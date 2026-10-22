package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        private WriteRunnable(ExternalCache r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WriteRunnable(ExternalCache r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            ExternalCache.access$200(this.this$0).set(false);
            String r0 = "";
        L7:
            th = move-exception;
            th.printStackTrace();
        L9:
            ExternalCache.access$500(this.this$0, r0);
            return;
        L4:
            if (ExternalCache.access$300(this.this$0) == null) goto L9;
            ExternalCache r1 = this.this$0;     // Catch: Throwable -> L7
            r0 = ExternalCache.access$400(r1, ExternalCache.access$300(r1));     // Catch: Throwable -> L7
            goto L9
        }
    }

    ExternalCache(Context r4, boolean r5, String r6, String r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mIsDelayingToWrite = new AtomicBoolean(false);
        this.mState = Environment.getExternalStorageState();
        this.cacheDir = r6;
        this.mEnableWrite = r5;
        this.mContext = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.mFileName = r7;
        this.mKey = r8;
        this.mAid = r9;
    }

    static /* synthetic */ String access$000(ExternalCache r0) {
        return r0.mAid;
    }

    static /* synthetic */ AtomicBoolean access$200(ExternalCache r0) {
        return r0.mIsDelayingToWrite;
    }

    static /* synthetic */ Map access$300(ExternalCache r0) {
        return r0.mCachedParams;
    }

    static /* synthetic */ String access$400(ExternalCache r2, Map r3) {
        return r2.map2Json((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$500(ExternalCache r0, String r1) {
        r0.write(r1);
    }

    private String decrypt(byte[] r4) {
        if (sCipherTextCache == null) goto L10;
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(sCipherTextCache.first, byte[].class, "com.obric.memorydata.plugin")) == false) goto L10;
        Object r3 = sCipherTextCache.second;
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L10:
        if (sClearTextCache != null) goto L12;
    L14:
        String r0 = null;
        r0 = StringEncryptUtils.decryptAES(r4, this.mKey);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        sCipherTextCache = new Pair(r4, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L12:
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(sClearTextCache.second, byte[].class, "com.obric.memorydata.plugin")) == false) goto L14;
        r3 = sClearTextCache.first;
        goto L8
    }

    private byte[] encrypt(String r5) {
        if (sClearTextCache == null) goto L10;
        if (Utils.equal(r5, (String) ZeusTransformUtils.preCheckCast(sClearTextCache.first, String.class, "com.obric.memorydata.plugin")) == false) goto L10;
        Object r4 = sClearTextCache.second;
    L8:
        return (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin");
    L10:
        if (sCipherTextCache != null) goto L12;
    L14:
        byte[] r0 = null;
        r0 = StringEncryptUtils.encryptAES(r5, this.mKey);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        sClearTextCache = new Pair(r5, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L12:
        if (Utils.equal(r5, (String) ZeusTransformUtils.preCheckCast(sCipherTextCache.second, String.class, "com.obric.memorydata.plugin")) == false) goto L14;
        r4 = sCipherTextCache.first;
        goto L8
    }

    private String getCachePath() {
        return this.cacheDir + "/" + this.mFileName;
    }

    private String getStorageValue(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (this.mCachedParams == null) goto L11;
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.mCachedParams.get(r10), String.class, "com.obric.memorydata.plugin");
        if (DrLog.debug() == false) goto L9;
        DrLog.v("get key = " + r10 + " value = " + r0 + " way = memory dir = " + getCachePath());
    L9:
        return r0;
    L11:
        if ("mounted".equals(this.mState) == true) goto L89;
        return null;
    L89:
    L56:
        th = th;
        RandomAccessFile r5 = null;
        FileLock r6 = null;
    L91:
    L69:
        th = move-exception;
        if (this.mCachedParams != null) goto L73;
        this.mCachedParams = new ConcurrentHashMap();
    L73:
        if (r6 != null) goto L101;
    L75:
        if (r5 == null) goto L113;
        r5.close();     // Catch: Exception -> L86
        throw th;
    L114:
        throw th;
    L113:
        throw th;
    L101:
        r6.release();     // Catch: Exception -> L85
        goto L75
    L59:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L62;
        th.printStackTrace();     // Catch: Throwable -> L69
    L62:
        if (this.mCachedParams != null) goto L64;
        this.mCachedParams = new ConcurrentHashMap();
    L64:
        if (r6 != null) goto L87;
    L66:
        if (r5 != null) goto L105;
    L68:
        return null;
    L105:
        r5.close();     // Catch: Exception -> L83
        goto L68
    L87:
        r6.release();     // Catch: Exception -> L84
        goto L66
    L14:
        if (new File(this.cacheDir).exists() == false) goto L16;
        File r1 = new File(getCachePath());     // Catch: Throwable -> L56
        r5 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L56
        r6 = r5.getChannel().lock();     // Catch: Throwable -> L54
    L52:
        th = th;
        goto L91
    L22:
        if (r1.isFile() == false) goto L46;
        byte[] r7 = new byte[2049];     // Catch: Throwable -> L52
        int r8 = r5.read(r7, 0, 2049);     // Catch: Throwable -> L52
        if (r8 <= 0) goto L46;
        if (r8 >= 2049) goto L46;
        this.mCachedParams = json2Map(decrypt(Arrays.copyOf(r7, r8)));     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r10) == true) goto L29;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.mCachedParams.get(r10), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        if (DrLog.debug() == false) goto L39;
        DrLog.v("get key = " + r10 + " value = " + r2 + " way = file dir = " + getCachePath());     // Catch: Throwable -> L52
    L39:
        if (this.mCachedParams != null) goto L41;
        this.mCachedParams = new ConcurrentHashMap();
    L41:
        if (r6 != null) goto L103;
    L97:
        r5.close();     // Catch: Exception -> L81
    L44:
        return r2;
    L103:
        r6.release();     // Catch: Exception -> L80
        goto L97
    L29:
        if (this.mCachedParams != null) goto L31;
        this.mCachedParams = new ConcurrentHashMap();
    L31:
        if (r6 != null) goto L107;
    L99:
        r5.close();     // Catch: Exception -> L79
    L34:
        return null;
    L107:
        r6.release();     // Catch: Exception -> L78
    L46:
        if (this.mCachedParams != null) goto L48;
        this.mCachedParams = new ConcurrentHashMap();
    L48:
        if (r6 == null) goto L105;
        r6.release();     // Catch: Exception -> L82
    L54:
        th = th;
        r6 = null;
        goto L91
    L16:
        if (this.mCachedParams != null) goto L18;
        this.mCachedParams = new ConcurrentHashMap();
    L18:
        return null;
    }

    private Map<String, String> json2Map(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L5;
        JSONObject r5 = new JSONObject(r6);
        Iterator<String> r7 = r5.keys();
        ConcurrentHashMap r0 = new ConcurrentHashMap();
    L8:
        if (r7.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r1, (String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        return r0;
    L5:
        return new ConcurrentHashMap();
    }

    private String map2Json(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return "";
    L6:
        JSONObject r6 = new JSONObject();
        Iterator r7 = r4.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());
        goto L8
    L11:
        return r6.toString();
    }

    private void storeValue(String r4, String r5) {
        if (this.mCachedParams != null) goto L8;
        getStorageValue(null);
        if (this.mCachedParams != null) goto L8;
        this.mCachedParams = new ConcurrentHashMap();
    L8:
        if (Utils.equal((String) ZeusTransformUtils.preCheckCast(this.mCachedParams.get(r4), String.class, "com.obric.memorydata.plugin"), r5) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        if (this.mCachedParams.containsKey(r4) == false) goto L16;
        this.mCachedParams.remove(r4);
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
        if (TextUtils.isEmpty(r5) == true) goto L19;
        this.mCachedParams.put(r4, r5);
        goto L19
    }

    private void write(String r6) {
        if ("mounted".equals(this.mState) == true) goto L5;
        return;
    L5:
        FileLock r0 = null;
        File r1 = new File(this.cacheDir);     // Catch: Throwable -> L19
        if (r1.exists() == false) goto L9;
    L11:
        RandomAccessFile r2 = new RandomAccessFile(new File(getCachePath()), "rwd");     // Catch: Throwable -> L19
        r0 = r2.getChannel().lock();     // Catch: Throwable -> L17
        byte[] r5 = encrypt(r6);     // Catch: Throwable -> L17
        r2.setLength(0);     // Catch: Throwable -> L17
        r2.write(r5);     // Catch: Throwable -> L17
        if (r0 == null) goto L48;
        r0.release();     // Catch: Exception -> L35
    L48:
        r2.close();     // Catch: Exception -> L36
        return;
    L57:
        return;
    L17:
        th = th;
    L44:
    L29:
        th = move-exception;
        if (r0 != null) goto L42;
    L32:
        if (r2 == null) goto L58;
        r2.close();     // Catch: Exception -> L39
        throw th;
    L59:
        throw th;
    L58:
        throw th;
    L42:
        r0.release();     // Catch: Exception -> L38
        goto L32
    L22:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L29
    L24:
        if (r0 != null) goto L52;
    L26:
        if (r2 != null) goto L48;
        return;
    L52:
        r0.release();     // Catch: Exception -> L37
        goto L26
    L9:
        if (r1.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r2 = null;
        goto L44
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r1, String r2) {
        storeValue(r1, r2);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    public void cacheStringArray(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        cacheString(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r6.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mCachedParams == null) goto L11;
        this.mCachedParams.remove(r2);
    L11:
        storeValue(r2, null);
        goto L7
    L12:
        super.clear(r6);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r1) {
        return getStorageValue(r1);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    public String[] getCachedStringArray(String r1) {
        String r0 = getStorageValue(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }
}
