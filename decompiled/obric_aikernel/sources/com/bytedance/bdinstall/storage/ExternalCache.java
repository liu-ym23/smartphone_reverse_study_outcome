package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExternalCache extends Cache {
    private static final int FILE_MAX_SIZE = 2048;
    private static final String TAG = "DirectoryCacheHelper";
    private static volatile Pair<byte[], String> sCipherTextCache;
    private static volatile Pair<String, byte[]> sClearTextCache;
    private String cacheDir;
    private String mAid;
    private volatile Map<String, String> mCachedParams;
    private final Context mContext;
    private final boolean mEnableWrite;
    private final String mFileName;
    private AtomicBoolean mIsDelayingToWrite;
    private final String mKey;
    private final String mState;

    private class WriteRunnable implements Runnable {
        final /* synthetic */ ExternalCache this$0;

        private WriteRunnable(ExternalCache r10) {
            this.this$0 = r10;
        }

        /* synthetic */ WriteRunnable(ExternalCache r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            ExternalCache.access$200(this.this$0).set(false);
            String r10 = "";
        L7:
            th = move-exception;
            th.printStackTrace();
        L9:
            ExternalCache.access$500(this.this$0, r10);
            return;
        L4:
            if (ExternalCache.access$300(this.this$0) == null) goto L9;
            ExternalCache r11 = this.this$0;     // Catch: Throwable -> L7
            r10 = ExternalCache.access$400(r11, ExternalCache.access$300(r11));     // Catch: Throwable -> L7
            goto L9
        }
    }

    ExternalCache(Context r10, boolean r11, String r12, String r13, String r14, String r15) {
        this.mIsDelayingToWrite = new AtomicBoolean(false);
        this.mState = Environment.getExternalStorageState();
        this.cacheDir = r12;
        this.mEnableWrite = r11;
        this.mContext = r10;
        this.mFileName = r13;
        this.mKey = r14;
        this.mAid = r15;
    }

    static /* synthetic */ String access$000(ExternalCache r10) {
        return r10.mAid;
    }

    static /* synthetic */ AtomicBoolean access$200(ExternalCache r10) {
        return r10.mIsDelayingToWrite;
    }

    static /* synthetic */ Map access$300(ExternalCache r10) {
        return r10.mCachedParams;
    }

    static /* synthetic */ String access$400(ExternalCache r10, Map r11) {
        return r10.map2Json(r11);
    }

    static /* synthetic */ void access$500(ExternalCache r10, String r11) {
        r10.write(r11);
    }

    private String decrypt(byte[] r10) {
        if (sCipherTextCache == null) goto L10;
        if (Arrays.equals(r10, (byte[]) sCipherTextCache.first) == false) goto L10;
        Object r11 = sCipherTextCache.second;
    L8:
        return (String) r11;
    L10:
        if (sClearTextCache != null) goto L12;
    L14:
        String r12 = null;
        r12 = StringEncryptUtils.decryptAES(r10, this.mKey);     // Catch: Throwable -> L17
    L19:
        if (r12 == null) goto L21;
        sCipherTextCache = new Pair(r10, r12);
    L21:
        return r12;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L12:
        if (Arrays.equals(r10, (byte[]) sClearTextCache.second) == false) goto L14;
        r11 = sClearTextCache.first;
        goto L8
    }

    private byte[] encrypt(String r10) {
        if (sClearTextCache == null) goto L10;
        if (Utils.equal(r10, (String) sClearTextCache.first) == false) goto L10;
        Object r11 = sClearTextCache.second;
    L8:
        return (byte[]) r11;
    L10:
        if (sCipherTextCache != null) goto L12;
    L14:
        byte[] r12 = null;
        r12 = StringEncryptUtils.encryptAES(r10, this.mKey);     // Catch: Throwable -> L17
    L19:
        if (r12 == null) goto L21;
        sClearTextCache = new Pair(r10, r12);
    L21:
        return r12;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L12:
        if (Utils.equal(r10, (String) sCipherTextCache.second) == false) goto L14;
        r11 = sCipherTextCache.first;
        goto L8
    }

    private String getCachePath() {
        return this.cacheDir + "/" + this.mFileName;
    }

    private String getStorageValue(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (this.mCachedParams == null) goto L11;
        String r11 = this.mCachedParams.get(r10);
        if (DrLog.debug() == false) goto L9;
        DrLog.v("get key = " + r10 + " value = " + r11 + " way = memory dir = " + getCachePath());
    L9:
        return r11;
    L11:
        if ("mounted".equals(this.mState) == true) goto L103;
        return null;
    L103:
    L56:
        th = th;
        RandomAccessFile r12 = null;
        FileLock r13 = null;
    L99:
    L69:
        th = move-exception;
        if (this.mCachedParams != null) goto L73;
        this.mCachedParams = new ConcurrentHashMap();
    L73:
        if (r13 != null) goto L105;
    L75:
        if (r12 == null) goto L113;
        r12.close();     // Catch: Exception -> L86
        throw th;
    L114:
        throw th;
    L113:
        throw th;
    L105:
        r13.release();     // Catch: Exception -> L85
        goto L75
    L59:
        if ((th instanceof IOException) == true) goto L62;
        th.printStackTrace();     // Catch: Throwable -> L69
    L62:
        if (this.mCachedParams != null) goto L64;
        this.mCachedParams = new ConcurrentHashMap();
    L64:
        if (r13 != null) goto L111;
    L66:
        if (r12 != null) goto L107;
    L68:
        return null;
    L107:
        r12.close();     // Catch: Exception -> L83
        goto L68
    L111:
        r13.release();     // Catch: Exception -> L84
        goto L66
    L14:
        if (new File(this.cacheDir).exists() == false) goto L16;
        File r14 = new File(getCachePath());     // Catch: Throwable -> L56
        r12 = new RandomAccessFile(r14, "rwd");     // Catch: Throwable -> L56
        r13 = r12.getChannel().lock();     // Catch: Throwable -> L54
    L52:
        th = th;
        goto L99
    L22:
        if (r14.isFile() == false) goto L46;
        byte[] r15 = new byte[2049];     // Catch: Throwable -> L52
        int r16 = r12.read(r15, 0, 2049);     // Catch: Throwable -> L52
        if (r16 <= 0) goto L46;
        if (r16 >= 2049) goto L46;
        this.mCachedParams = json2Map(decrypt(Arrays.copyOf(r15, r16)));     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r10) == true) goto L29;
        String r17 = this.mCachedParams.get(r10);     // Catch: Throwable -> L52
        if (DrLog.debug() == false) goto L39;
        DrLog.v("get key = " + r10 + " value = " + r17 + " way = file dir = " + getCachePath());     // Catch: Throwable -> L52
    L39:
        if (this.mCachedParams != null) goto L41;
        this.mCachedParams = new ConcurrentHashMap();
    L41:
        if (r13 != null) goto L95;
    L89:
        r12.close();     // Catch: Exception -> L81
    L44:
        return r17;
    L95:
        r13.release();     // Catch: Exception -> L80
        goto L89
    L29:
        if (this.mCachedParams != null) goto L31;
        this.mCachedParams = new ConcurrentHashMap();
    L31:
        if (r13 != null) goto L109;
    L101:
        r12.close();     // Catch: Exception -> L79
    L34:
        return null;
    L109:
        r13.release();     // Catch: Exception -> L78
    L46:
        if (this.mCachedParams != null) goto L48;
        this.mCachedParams = new ConcurrentHashMap();
    L48:
        if (r13 == null) goto L107;
        r13.release();     // Catch: Exception -> L82
    L54:
        th = th;
        r13 = null;
        goto L99
    L16:
        if (this.mCachedParams != null) goto L18;
        this.mCachedParams = new ConcurrentHashMap();
    L18:
        return null;
    }

    private Map<String, String> json2Map(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        JSONObject r11 = new JSONObject(r10);
        Iterator<String> r12 = r11.keys();
        ConcurrentHashMap r13 = new ConcurrentHashMap();
    L8:
        if (r12.hasNext() == false) goto L10;
        String r14 = r12.next();
        r13.put(r14, (String) r11.get(r14));
        goto L8
    L10:
        return r13;
    L5:
        return new ConcurrentHashMap();
    }

    private String map2Json(Map<String, String> r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        JSONObject r11 = new JSONObject();
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<String, String> r13 = r12.next();
        r11.put(r13.getKey(), r13.getValue());
        goto L7
    L10:
        return r11.toString();
    }

    private void storeValue(String r10, String r11) {
        if (this.mCachedParams != null) goto L8;
        getStorageValue(null);
        if (this.mCachedParams != null) goto L8;
        this.mCachedParams = new ConcurrentHashMap();
    L8:
        if (Utils.equal(this.mCachedParams.get(r10), r11) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r11) == false) goto L16;
        if (this.mCachedParams.containsKey(r10) == false) goto L16;
        this.mCachedParams.remove(r10);
    L19:
        if (this.mEnableWrite == true) goto L21;
        return;
    L21:
        if (this.mIsDelayingToWrite.compareAndSet(false, true) == false) goto L25;
        ExecutorUtil.getHandler(this.mAid).postDelayed(new AnonymousClass1(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        this.mCachedParams.put(r10, r11);
        goto L19
    }

    private void write(String r10) {
        if ("mounted".equals(this.mState) == true) goto L5;
        return;
    L5:
        FileLock r11 = null;
        File r12 = new File(this.cacheDir);     // Catch: Throwable -> L19
        if (r12.exists() == false) goto L9;
    L11:
        RandomAccessFile r13 = new RandomAccessFile(new File(getCachePath()), "rwd");     // Catch: Throwable -> L19
        r11 = r13.getChannel().lock();     // Catch: Throwable -> L17
        byte[] r14 = encrypt(r10);     // Catch: Throwable -> L17
        r13.setLength(0);     // Catch: Throwable -> L17
        r13.write(r14);     // Catch: Throwable -> L17
        if (r11 != null) goto L48;
    L40:
        r13.close();     // Catch: Exception -> L36
        return;
    L57:
        return;
    L48:
        r11.release();     // Catch: Exception -> L35
    L17:
        th = th;
    L42:
    L29:
        th = move-exception;
        if (r11 != null) goto L50;
    L32:
        if (r13 == null) goto L58;
        r13.close();     // Catch: Exception -> L39
        throw th;
    L59:
        throw th;
    L58:
        throw th;
    L50:
        r11.release();     // Catch: Exception -> L38
        goto L32
    L22:
        if ((th instanceof IOException) == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L29
    L24:
        if (r11 != null) goto L44;
    L26:
        if (r13 != null) goto L40;
        return;
    L44:
        r11.release();     // Catch: Exception -> L37
        goto L26
    L9:
        if (r12.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r13 = null;
        goto L42
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r10, String r11) {
        storeValue(r10, r11);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String r10, String[] r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        cacheString(r10, TextUtils.join("\n", r11));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<String> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L11;
        String r12 = r11.next();
        if (this.mCachedParams == null) goto L10;
        this.mCachedParams.remove(r12);
    L10:
        storeValue(r12, null);
        goto L6
    L11:
        super.clear(r10);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r10) {
        return getStorageValue(r10);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String r10) {
        String r11 = getStorageValue(r10);
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return null;
    L7:
        return r11.split("\n");
    }
}
