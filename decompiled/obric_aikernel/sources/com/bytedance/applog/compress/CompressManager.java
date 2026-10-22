package com.bytedance.applog.compress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.bytedance.crypto.utils.CryptoConst;
import f1.g;
import f1.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;
import y0.a;
import y0.b;

/* JADX INFO: loaded from: classes.dex */
public class CompressManager implements Handler.Callback {
    public static final String DEFAULT_SP_NAME = "sp_tea_log_compress";
    private static final int DICTIONARY_SIZE = 49152;
    private static final int MAX_DATA_LEVEL = 12;
    private static final int MAX_ENCODE_TYPE = 3;
    private static final int MAX_WAIT_INIT_COUNT = 10;
    private static final int MSG_INIT = 3;
    private static final int MSG_RECORD = 0;
    private static final int MSG_REPORT = 2;
    private static final int MSG_SAVE = 1;
    private static final long REPORT_INTERVAL = 86400000;
    private static final long SAVE_INTERVAL = 60000;
    private static final String SP_EVENT_RECORD_KEY = "sp_tea_log_compress_record";
    private static final String SP_REPORT_TIME_KEY = "sp_tea_log_compress_report";
    private static final String TAG = "CompressManager";
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static final int WAIT_INIT_INTERVAL = 500;
    private static volatile boolean reportStatsEnabled = true;
    private volatile boolean dictionaryInitialized;
    private final Context mContext;
    private byte[] mDictionary;
    private a[][] mEventRecord;
    private Handler mHandler;
    private final g mLogger;
    private final b mReporter;
    private final SharedPreferences mSp;

    static {
    }

    public CompressManager(Context r10, String r11, b r12, g r13) {
        this.dictionaryInitialized = false;
        this.mContext = r10;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r11 = DEFAULT_SP_NAME;
    L5:
        this.mSp = r10.getSharedPreferences(r11, 0);
        this.mReporter = r12;
        if (r13 != null) goto L9;
        r13 = n.B();
    L9:
        this.mLogger = r13;
        r13.h(14, "Init compress manager...", new Object[0]);
        resetEventRecord();     // Catch: Throwable -> L12
        HandlerThread r14 = new HandlerThread("tea_log_compress");     // Catch: Throwable -> L12
        r14.start();     // Catch: Throwable -> L12
        Handler r15 = new Handler(r14.getLooper(), this);     // Catch: Throwable -> L12
        this.mHandler = r15;     // Catch: Throwable -> L12
        r15.sendEmptyMessage(3);     // Catch: Throwable -> L12
        this.mHandler.sendEmptyMessageDelayed(1, 60000);     // Catch: Throwable -> L12
        this.mHandler.sendEmptyMessageDelayed(2, REPORT_INTERVAL);     // Catch: Throwable -> L12
        r13.h(14, "Compress manager init end.", new Object[0]);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        this.mLogger.v(14, "Init compress manager failed", th, new Object[0]);
    }

    private void doSave() {
        if (reportStatsEnabled == false) goto L27;
        a[][] r10 = this.mEventRecord;
        if (r10 == null) goto L27;
        if (r10.length == 0) goto L27;
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L20
        int r12 = 0;
    L12:
        if (r12 >= 3) goto L18;
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L20
        int r14 = 0;
    L15:
        if (r14 >= 12) goto L17;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L20
        a r16 = this.mEventRecord[r12][r14];     // Catch: Throwable -> L20
        r15.put("compressSize", r16.f13627b);     // Catch: Throwable -> L20
        r15.put("dataSize", r16.f13626a);     // Catch: Throwable -> L20
        r15.put("encodeType", r16.f13628c);     // Catch: Throwable -> L20
        r15.put("result", r16.f13630e);     // Catch: Throwable -> L20
        r15.put("token", r16.f13631f);     // Catch: Throwable -> L20
        r15.put("compressTime", r16.f13629d);     // Catch: Throwable -> L20
        r13.put(r15);     // Catch: Throwable -> L20
        r14 = r14 + 1;     // Catch: Throwable -> L20
        goto L15
    L17:
        r11.put(r13);     // Catch: Throwable -> L20
        r12 = r12 + 1;     // Catch: Throwable -> L20
        goto L12
    L18:
        String r17 = r11.toString();     // Catch: Throwable -> L20
        this.mSp.edit().putString(SP_EVENT_RECORD_KEY, r17).apply();     // Catch: Throwable -> L20
        this.mLogger.h(14, "compress monitor data saved: {}", new Object[]{r17});     // Catch: Throwable -> L20
    L22:
        this.mHandler.sendEmptyMessageDelayed(1, 60000);
        return;
    L20:
        th = move-exception;
        this.mLogger.v(14, "Write data to json failed", th, new Object[0]);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.mHandler.sendEmptyMessageDelayed(1, 60000);
        throw th;
    L27:
        this.mHandler.sendEmptyMessageDelayed(1, 60000);
    }

    private int getEncodeType(int r10) {
        if (r10 == 2) goto L5;
    L8:
        return r10;
    L5:
        if (this.mDictionary != null) goto L8;
        return 1;
    }

    private String[] getKeyIv(Context r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L17
        InputStream r12 = r10.getAssets().open("log_tea_dict.kv");     // Catch: Throwable -> L15
        byte[] r13 = new byte[1024];     // Catch: Throwable -> L13
    L7:
        int r14 = r12.read(r13);     // Catch: Throwable -> L13
        if (r14 == (-1)) goto L10;
        r11.write(r13, 0, r14);     // Catch: Throwable -> L13
        goto L7
    L10:
        String[] r15 = r11.toString("UTF-8").split("\\|");     // Catch: Throwable -> L13
        safeClose(r11);
        safeClose(r12);
        return r15;
    L13:
        th = th;
    L31:
        this.mLogger.v(14, "get key iv failed", th, new Object[0]);     // Catch: Throwable -> L22
        safeClose(r11);
        safeClose(r12);
        return null;
    L22:
        th = move-exception;
        safeClose(r11);
        safeClose(r12);
        throw th;
    L15:
        th = th;
        r12 = null;
    L17:
        th = th;
        r12 = null;
        r11 = null;
        goto L31
    }

    private void initDictionary(Context r10) {
        if (this.dictionaryInitialized == false) goto L38;
        return;
    L38:
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L28
        InputStream r12 = r10.getAssets().open("log_tea_dict.txt");     // Catch: Throwable -> L26
        byte[] r13 = new byte[1024];     // Catch: Throwable -> L24
    L10:
        int r14 = r12.read(r13);     // Catch: Throwable -> L24
        if (r14 == (-1)) goto L13;
        r11.write(r13, 0, r14);     // Catch: Throwable -> L24
        goto L10
    L13:
        String[] r15 = getKeyIv(r10);     // Catch: Throwable -> L24
        if (r15 != null) goto L16;
    L18:
        byte[] r16 = this.mDictionary;     // Catch: Throwable -> L24
        if (r16 != null) goto L21;
    L31:
        this.dictionaryInitialized = true;
        safeClose(r11);
        safeClose(r12);
        return;
    L21:
        if (r16.length == DICTIONARY_SIZE) goto L31;
        this.mDictionary = null;     // Catch: Throwable -> L24
        goto L31
    L16:
        if (r15.length != 2) goto L18;
        this.mDictionary = gzipUncompress(decryptAesCbc(r11.toByteArray(), r15[0], r15[1]));     // Catch: Throwable -> L24
    L24:
        th = th;
    L40:
        this.mDictionary = null;     // Catch: Throwable -> L33
        this.mLogger.v(14, "load zstd dict failed", th, new Object[0]);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        this.dictionaryInitialized = true;
        safeClose(r11);
        safeClose(r12);
        throw th;
    L26:
        th = th;
        r12 = null;
    L28:
        th = th;
        r11 = null;
        r12 = null;
        goto L40
    }

    private void initEventRecord() {
        if (reportStatsEnabled == true) goto L5;
        return;
    L5:
        String r10 = this.mSp.getString(SP_EVENT_RECORD_KEY, "");
        if (TextUtils.isEmpty(r10) == true) goto L11;
        readDataFromJson(r10);
        long r11 = this.mSp.getLong(SP_REPORT_TIME_KEY, 0);
        if ((System.currentTimeMillis() - r11) <= REPORT_INTERVAL) goto L12;
        report();
        return;
    L12:
        return;
    }

    private void readDataFromJson(String r10) {
        JSONArray r11 = new JSONArray(r10);     // Catch: Throwable -> L12
        int r12 = 0;
    L5:
        if (r12 >= 3) goto L19;
        JSONArray r13 = r11.getJSONArray(r12);     // Catch: Throwable -> L12
        int r14 = 0;
    L8:
        if (r14 >= 12) goto L11;
        JSONObject r15 = r13.getJSONObject(r14);     // Catch: Throwable -> L12
        a r16 = this.mEventRecord[r12][r14];     // Catch: Throwable -> L12
        r16.f13627b = r15.optInt("compressSize", 0);     // Catch: Throwable -> L12
        r16.f13626a = r15.optInt("dataSize", 0);     // Catch: Throwable -> L12
        r16.f13628c = r15.optInt("encodeType", 0);     // Catch: Throwable -> L12
        r16.f13630e = r15.optInt("result", 0);     // Catch: Throwable -> L12
        r16.f13631f = r15.optInt("token", 0);     // Catch: Throwable -> L12
        r16.f13629d = r15.optLong("compressTime", 0);     // Catch: Throwable -> L12
        r14 = r14 + 1;
        goto L8
    L11:
        r12 = r12 + 1;
        goto L5
    L19:
        return;
    L12:
        th = move-exception;
        this.mLogger.v(14, "Read data from json failed", th, new Object[0]);
    }

    private void record(a r10) {
        int r11 = r10.f13626a / 1024;     // Catch: Throwable -> L13
        if (r11 <= 0) goto L6;
        r11 = ((int) Math.floor(Math.log(r11) / Math.log(2.0d))) + 1;     // Catch: Throwable -> L13
    L6:
        if (r11 < 12) goto L8;
        r11 = 11;
    L8:
        a r12 = this.mEventRecord[r10.f13628c][r11];     // Catch: Throwable -> L13
        int r13 = r10.f13630e;     // Catch: Throwable -> L13
        if (r13 != 0) goto L11;
        r12.f13626a += r10.f13626a;     // Catch: Throwable -> L13
        r12.f13629d += r10.f13629d;     // Catch: Throwable -> L13
        r12.f13627b += r10.f13627b;     // Catch: Throwable -> L13
    L11:
        r12.f13630e += r13;     // Catch: Throwable -> L13
        r12.f13631f++;     // Catch: Throwable -> L13
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L13
        this.mHandler.sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        this.mLogger.v(14, "record data failed", th, new Object[0]);
    }

    private void recordEvent(a r10) {
        if (reportStatsEnabled == true) goto L5;
        return;
    L5:
        Handler r11 = this.mHandler;
        if (r11 == null) goto L10;
        if (r10 == null) goto L11;
        r11.obtainMessage(0, r10).sendToTarget();
        return;
    L11:
        return;
    }

    @SuppressLint({"DefaultLocale"})
    private void report() {
        if (reportStatsEnabled == true) goto L5;
        return;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= 3) goto L17;
        int r11 = 0;
    L10:
        if (r11 >= 12) goto L16;
        a r12 = this.mEventRecord[r10][r11];     // Catch: Throwable -> L19
        if (r12.f13631f <= 0) goto L15;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L19
        r13.put("encode_type", r10);     // Catch: Throwable -> L19
        int r14 = r12.f13631f - r12.f13630e;     // Catch: Throwable -> L19
        r13.put("compress_time", r12.f13629d);     // Catch: Throwable -> L19
        r13.put("compress_ratio", String.format("%.2f", new Object[]{Double.valueOf((((double) r12.f13626a) * 1.0d) / ((double) r12.f13627b))}));     // Catch: Throwable -> L19
        r13.put("data_size", r12.f13626a);     // Catch: Throwable -> L19
        r13.put("compress_size", r12.f13627b);     // Catch: Throwable -> L19
        r13.put("success_count", r14);     // Catch: Throwable -> L19
        r13.put(CommonConsts.COUNT_TYPE, r12.f13631f);     // Catch: Throwable -> L19
        r13.put("data_level", r11 + 1);     // Catch: Throwable -> L19
        this.mReporter.a("log_encode_result", r13);     // Catch: Throwable -> L19
        this.mSp.edit().remove(SP_EVENT_RECORD_KEY).putLong(SP_REPORT_TIME_KEY, System.currentTimeMillis()).apply();     // Catch: Throwable -> L19
    L15:
        r11 = r11 + 1;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mLogger.v(14, "report data failed", th, new Object[0]);
    L21:
        resetEventRecord();
        return;
    L16:
        r10 = r10 + 1;     // Catch: Throwable -> L19
        goto L7
    L17:
        this.mLogger.h(14, "report data completed", new Object[0]);     // Catch: Throwable -> L19
        goto L21
    }

    private void resetEventRecord() {
        this.mEventRecord = (a[][]) Array.newInstance(a.class, new int[]{3, 12});
        int r10 = 0;
    L4:
        if (r10 >= 3) goto L10;
        int r11 = 0;
    L7:
        if (r11 >= 12) goto L9;
        this.mEventRecord[r10][r11] = new a();
        r11 = r11 + 1;
        goto L7
    L9:
        r10 = r10 + 1;
        goto L4
    }

    private static void safeClose(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void setReportStatsEnabled(boolean r10) {
        reportStatsEnabled = r10;
    }

    private static byte[] transStrCharToByte(String r10) {
        int r11 = r10.length();
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = (byte) r10.charAt(r13);
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    private void waitDictionaryLoad(int r10) {
        if (this.dictionaryInitialized == false) goto L5;
        return;
    L5:
        if (r10 == 2) goto L7;
        if (r10 == 1) goto L7;
        return;
    L7:
        int r11 = 0;
    L9:
        if (this.dictionaryInitialized == true) goto L16;
        int r12 = r11 + 1;
        if (r11 >= 10) goto L16;
        this.mLogger.h(14, "Wait dictionary initializing for 500ms... Try:{}", new Object[]{Integer.valueOf(r12)});
        Thread.sleep(500);     // Catch: Throwable -> L19
    L14:
        r11 = r12;
    L16:
        if (this.dictionaryInitialized == true) goto L27;
        this.mLogger.q(14, "Zstd dictionary init timeout.", new Object[0]);
        return;
    }

    public byte[] compress(byte[] r10, int r11, a r12) {
        waitDictionaryLoad(r11);
        int r13 = getEncodeType(r11);
        if (r13 != 0) goto L5;
        r10 = compressUsingGzip(r10, r12);
    L11:
        if (r10 != null) goto L13;
    L14:
        recordEvent(r12);
        r10 = compressUsingGzip(r10, r12);
    L15:
        recordEvent(r12);
        return r10;
    L13:
        if (r10.length != 0) goto L15;
    L5:
        if (r13 != 1) goto L7;
    L9:
        r10 = compressUsingZstd(r10, r12, r11);
        goto L11
    L7:
        if (r13 == 2) goto L9;
        goto L9
    }

    public byte[] compressUsingGzip(byte[] r10, a r11) {
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        r11.f13626a = r12;
        r11.f13628c = 0;
        long r13 = System.currentTimeMillis();
        ByteArrayOutputStream r14 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L18
        GZIPOutputStream r15 = new GZIPOutputStream(r14);     // Catch: Throwable -> L16
        if (r10 != null) goto L26;
    L14:
        safeClose(r15);
        safeClose(r14);
        byte[] r16 = r14.toByteArray();
        long r17 = System.currentTimeMillis();
        r11.f13630e = 0;
        r11.f13629d = r17 - r13;
        r11.f13627b = r16.length;
        return r16;
    L26:
        r15.write(r10);     // Catch: Throwable -> L12
    L12:
        th = th;
    L28:
        this.mLogger.v(14, "compress with gzip failed", th, new Object[0]);     // Catch: Throwable -> L23
        r11.f13630e = 1;     // Catch: Throwable -> L23
        safeClose(r15);
        safeClose(r14);
        return null;
    L23:
        th = move-exception;
        safeClose(r15);
        safeClose(r14);
        throw th;
    L16:
        th = th;
        r15 = null;
    L18:
        th = th;
        r14 = null;
        r15 = null;
        goto L28
    L5:
        r12 = r10.length;
        goto L6
    }

    public byte[] compressUsingZstd(byte[] r10, a r11, int r12) {
        r11.f13626a = r10.length;
        r11.f13628c = r12;
        r11.f13631f = 0;
        byte[] r13 = null;
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r12 == 2) goto L6;
    L8:
        byte[] r15 = ZstdCompress.compress(r10, 15);     // Catch: Throwable -> L11
    L9:
        r13 = r15;
        r11.f13629d = System.currentTimeMillis() - r14;     // Catch: Throwable -> L11
        r11.f13627b = r13.length;     // Catch: Throwable -> L11
        r11.f13630e = 0;     // Catch: Throwable -> L11
        return r13;
    L6:
        if (this.mDictionary == null) goto L8;
        r15 = ZstdCompress.compress(r10, new ZstdDictCompress(this.mDictionary, 15));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLogger.v(14, "compress with zstd failed", th, new Object[0]);
        r11.f13630e = 1;
        return r13;
    }

    public byte[] decryptAesCbc(byte[] r10, String r11, String r12) {
        Cipher r13 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L4
        r13.init(2, new SecretKeySpec(transStrCharToByte(r11), CryptoConst.ALGORITHM_AES), new IvParameterSpec(transStrCharToByte(r12)));     // Catch: Throwable -> L4
        return r13.doFinal(r10);
    L4:
        th = move-exception;
        this.mLogger.v(14, "decryptAesCbc failed", th, new Object[0]);
        return null;
    }

    public byte[] gzipUncompress(byte[] r10) {
        if (r10 != null) goto L5;
    L28:
        return null;
    L5:
        if (r10.length <= 0) goto L28;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ByteArrayInputStream r12 = new ByteArrayInputStream(r10);     // Catch: Throwable -> L20
        GZIPInputStream r13 = new GZIPInputStream(r12);     // Catch: Throwable -> L18
        byte[] r14 = new byte[1024];     // Catch: Throwable -> L16
    L12:
        int r15 = r13.read(r14);     // Catch: Throwable -> L16
        if (r15 < 0) goto L23;
        r11.write(r14, 0, r15);     // Catch: Throwable -> L16
    L23:
        safeClose(r13);
        safeClose(r12);
        return r11.toByteArray();
    L16:
        Throwable th = th;
    L31:
        this.mLogger.v(14, "uncompress gzip failed", th, new Object[0]);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        safeClose(r13);
        safeClose(r12);
        throw th;
    L18:
        th = move-exception;
        th = th;
        r13 = null;
    L20:
        th = move-exception;
        r12 = null;
        th = th;
        r13 = null;
        goto L31
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        int r11 = r10.what;
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L6;
        doSave();
    L14:
        return true;
    L6:
        if (r11 != 2) goto L8;
        report();
        this.mHandler.sendEmptyMessageDelayed(2, REPORT_INTERVAL);
        goto L14
    L8:
        if (r11 != 3) goto L14;
        initDictionary(this.mContext);
        initEventRecord();
        goto L14
    L13:
        record((a) r10.obj);
        goto L14
    }
}
