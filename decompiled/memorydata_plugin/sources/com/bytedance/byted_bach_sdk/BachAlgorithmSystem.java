package com.bytedance.byted_bach_sdk;

import android.graphics.Bitmap;
import android.util.Log;
import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmOutput;
import com.bytedance.byted_bach_sdk.input.BachAlgorithmInput;
import com.bytedance.byted_bach_sdk.input.BachBitmapInput;
import com.bytedance.byted_bach_sdk.listener.BachAlgorithmMessage;
import com.bytedance.byted_bach_sdk.listener.BachCallbackListener;
import com.bytedance.byted_bach_sdk.log.BachAppLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BachAlgorithmSystem {
    private static final String TAG = "byted_bach_sdk";
    private boolean isDestroyed;
    private BachResourceFinder m_finder;
    private long m_nativePtr;

    public static final enum BachErrorCode extends Enum<BachErrorCode> {
        private static final /* synthetic */ BachErrorCode[] $VALUES = null;
        public static final BachErrorCode INTERNAL_ERROR = null;
        public static final BachErrorCode INVALID_CONFIG = null;
        public static final BachErrorCode INVALID_FORMAT = null;
        public static final BachErrorCode INVALID_GRAPH = null;
        public static final BachErrorCode INVALID_INPUT = null;
        public static final BachErrorCode INVALID_MODEL = null;
        public static final BachErrorCode INVALID_NODE = null;
        public static final BachErrorCode INVALID_RES_FINDER = null;
        public static final BachErrorCode INVALID_TYPE = null;
        public static final BachErrorCode NONE_ERROR = null;
        public static final BachErrorCode NOT_INIT = null;
        public static final BachErrorCode NO_ERROR = null;

        static {
            BachErrorCode r0 = new BachErrorCode("NO_ERROR", 0);
            NO_ERROR = r0;
            BachErrorCode r1 = new BachErrorCode("INVALID_RES_FINDER", 1);
            INVALID_RES_FINDER = r1;
            BachErrorCode r3 = new BachErrorCode("NOT_INIT", 2);
            NOT_INIT = r3;
            BachErrorCode r5 = new BachErrorCode("INVALID_CONFIG", 3);
            INVALID_CONFIG = r5;
            BachErrorCode r7 = new BachErrorCode("INVALID_GRAPH", 4);
            INVALID_GRAPH = r7;
            BachErrorCode r9 = new BachErrorCode("INVALID_MODEL", 5);
            INVALID_MODEL = r9;
            BachErrorCode r11 = new BachErrorCode("INVALID_TYPE", 6);
            INVALID_TYPE = r11;
            BachErrorCode r13 = new BachErrorCode("INVALID_NODE", 7);
            INVALID_NODE = r13;
            BachErrorCode r15 = new BachErrorCode("INVALID_FORMAT", 8);
            INVALID_FORMAT = r15;
            BachErrorCode r14 = new BachErrorCode("INTERNAL_ERROR", 9);
            INTERNAL_ERROR = r14;
            BachErrorCode r12 = new BachErrorCode("INVALID_INPUT", 10);
            INVALID_INPUT = r12;
            BachErrorCode r10 = new BachErrorCode("NONE_ERROR", 11);
            NONE_ERROR = r10;
            $VALUES = new BachErrorCode[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private BachErrorCode(String r1, int r2) {
            super(r1, r2);
        }

        public static BachErrorCode valueOf(String r2) {
            return (BachErrorCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(BachErrorCode.class, r2), BachErrorCode.class, "com.obric.memorydata.plugin");
        }

        public static BachErrorCode[] values() {
            return (BachErrorCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BachErrorCode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class BachInitConfig {
        public String applicationName;
        public String cacheFolder;
        public String deviceName;
        public BachResourceFinder finder;

        public BachInitConfig() {
            this.cacheFolder = "";
        }
    }

    static {
        System.loadLibrary("bach-sdk-jni");
    }

    public BachAlgorithmSystem(BachInitConfig r3) {
        this.isDestroyed = false;
        this.m_nativePtr = 0;
        this.m_finder = null;
        this.m_nativePtr = nativeCreate(r3);
        BachResourceFinder r4 = r3.finder;
        this.m_finder = r4;
        r4.bindAlgorithmSystem(this);
    }

    private BachErrorCode checkAlive() {
        if (this.isDestroyed == false) goto L6;
        Log.e(TAG, "BachAlgorithmSystem already destroyed");
        return BachErrorCode.NOT_INIT;
    L6:
        BachResourceFinder r2 = this.m_finder;
        if (r2 != null) goto L9;
    L13:
        Log.e(TAG, "BachResourceFinder already destroyed");
        return BachErrorCode.INVALID_RES_FINDER;
    L9:
        if (r2.isDestroyed == true) goto L13;
        return BachErrorCode.NO_ERROR;
    }

    public static String getSDKVersion() {
        return nativeGetSDKVersion();
    }

    private native long nativeCreate(BachInitConfig r1);

    private native void nativeDestroy(long r1);

    private native int nativeExec(long r1, BachAlgorithmInput r3);

    private native BachAlgorithmOutput nativeGetResult(long r1, String r3, int r4);

    private static native String nativeGetSDKVersion();

    private native void nativeInitGraph(long r1, String r3);

    private native void nativeInitGraphWithRootPath(long r1, String r3, String r4);

    private native int nativeLoadModel(long r1);

    private native void nativeRegisterListener(long r1, BachCallbackListener r3);

    private native void nativeSendMessage(long r1, String r3, BachAlgorithmMessage r4);

    private static native void nativeSetAppLogger(BachAppLogger r0, int r1);

    private native void nativeSetBachCacheEnable(long r1, boolean r3);

    private native int nativeSetEnable(long r1, String r3, boolean r4);

    private native int nativeSetFloatParams(long r1, String r3, HashMap<String, Float> r4);

    private native int nativeSetIntParams(long r1, String r3, HashMap<String, Integer> r4);

    private native int nativeSetStringParams(long r1, String r3, HashMap<String, String> r4);

    private native void nativeUnRegisterListener(long r1, BachCallbackListener r3);

    public static void setAppLogger(BachAppLogger r0, int r1) {
        nativeSetAppLogger(r0, r1);
    }

    public synchronized void destroy() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isDestroyed = true;     // Catch: Throwable -> L13
        nativeDestroy(this.m_nativePtr);     // Catch: Throwable -> L13
        this.m_nativePtr = 0;     // Catch: Throwable -> L13
        BachResourceFinder r0 = this.m_finder;     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        r0.bindAlgorithmSystem(null);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    public synchronized int enable(String r3, boolean r4) {
        monitor-enter(this);
        int r5 = nativeSetEnable(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized BachErrorCode execute(BachAlgorithmInput r3) {
        monitor-enter(this);
        BachAlgorithmInput r4 = (BachAlgorithmInput) ZeusTransformUtils.wrapperContextForParams(r3, BachAlgorithmInput.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        BachErrorCode r0 = checkAlive();     // Catch: Throwable -> L27
        if (r0 == BachErrorCode.NO_ERROR) goto L8;
        Log.e(TAG, "execute with destroyed instance");     // Catch: Throwable -> L27
        monitor-exit(this);
        return r0;
    L8:
        if (r4 != null) goto L13;
        Log.e(TAG, "BachAlgorithmInput is null");     // Catch: Throwable -> L27
        BachErrorCode r5 = BachErrorCode.INVALID_INPUT;     // Catch: Throwable -> L27
        monitor-exit(this);
        return r5;
    L13:
        if (ZeusTransformUtils.instanceOf(r4, BachBitmapInput.class) == false) goto L24;
        Bitmap r1 = ((BachBitmapInput) ZeusTransformUtils.preCheckCast(r4, BachBitmapInput.class, "com.obric.memorydata.plugin")).getInput();     // Catch: Throwable -> L27
        if (r1 != null) goto L20;
        Log.e(TAG, "BachBitmapInput bitmap is null");     // Catch: Throwable -> L27
        BachErrorCode r6 = BachErrorCode.INVALID_INPUT;     // Catch: Throwable -> L27
        monitor-exit(this);
        return r6;
    L20:
        if (r1.isRecycled() == false) goto L24;
        Log.e(TAG, "BachBitmapInput bitmap is recycled");     // Catch: Throwable -> L27
        BachErrorCode r7 = BachErrorCode.INVALID_INPUT;     // Catch: Throwable -> L27
        monitor-exit(this);
        return r7;
    L24:
        int r8 = nativeExec(this.m_nativePtr, r4);     // Catch: Throwable -> L27
        BachErrorCode r9 = BachErrorCode.values()[r8];     // Catch: Throwable -> L27
        monitor-exit(this);
        return r9;
    L27:
        th = move-exception;
        throw th;
    }

    public void finalize() {
        super.finalize();
        destroy();
    }

    public synchronized BachAlgorithmOutput getResult(String r2) {
        monitor-enter(this);
        BachAlgorithmOutput r3 = getResult(r2, 0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized BachAlgorithmOutput getResult(String r3, int r4) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (checkAlive() == BachErrorCode.NO_ERROR) goto L9;
        Log.e(TAG, "getResult with destroyed instance");     // Catch: Throwable -> L12
        monitor-exit(this);
        return null;
    L9:
        BachAlgorithmOutput r5 = nativeGetResult(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r5;
    }

    public synchronized void initGraph(String r3) {
        monitor-enter(this);
        nativeInitGraph(this.m_nativePtr, r3);     // Catch: Throwable -> L6
        parseExtraInfo(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void initGraphWithRootPath(String r3, String r4) {
        monitor-enter(this);
        nativeInitGraphWithRootPath(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L6
        parseExtraInfo(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized BachErrorCode loadModel() {
        monitor-enter(this);
        BachErrorCode r0 = checkAlive();     // Catch: Throwable -> L11
        if (r0 == BachErrorCode.NO_ERROR) goto L8;
        Log.e(TAG, "loadModel with destroyed instance");     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        int r1 = nativeLoadModel(this.m_nativePtr);     // Catch: Throwable -> L11
        BachErrorCode r2 = BachErrorCode.values()[r1];     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public void parseExtraInfo(String r1) {
    }

    public synchronized void registerListener(BachCallbackListener r3) {
        monitor-enter(this);
        nativeRegisterListener(this.m_nativePtr, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void resetResourceFinder(BachResourceFinder r2) {
        monitor-enter(this);
        BachResourceFinder r0 = this.m_finder;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        if (r0 != r2) goto L7;
        this.m_finder = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        Log.i(TAG, "reset finder not match and skip");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void sendMessage(String r3, BachAlgorithmMessage r4) {
        nativeSendMessage(this.m_nativePtr, r3, r4);
    }

    public synchronized void setBachCacheEnable(boolean r3) {
        monitor-enter(this);
        nativeSetBachCacheEnable(this.m_nativePtr, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int setFloatParam(String r2, String r3, float r4) {
        monitor-enter(this);
        HashMap<String, Float> r0 = new HashMap();     // Catch: Throwable -> L6
        r0.put(r3, Float.valueOf(r4));     // Catch: Throwable -> L6
        int r5 = setFloatParams(r2, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int setFloatParams(String r3, HashMap<String, Float> r4) {
        monitor-enter(this);
        int r5 = nativeSetFloatParams(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int setIntParam(String r2, String r3, int r4) {
        monitor-enter(this);
        HashMap<String, Integer> r0 = new HashMap();     // Catch: Throwable -> L6
        r0.put(r3, Integer.valueOf(r4));     // Catch: Throwable -> L6
        int r5 = setIntParams(r2, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int setIntParams(String r3, HashMap<String, Integer> r4) {
        monitor-enter(this);
        int r5 = nativeSetIntParams(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int setStringParam(String r2, String r3, String r4) {
        monitor-enter(this);
        HashMap<String, String> r0 = new HashMap();     // Catch: Throwable -> L6
        r0.put(r3, r4);     // Catch: Throwable -> L6
        int r5 = setStringParams(r2, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int setStringParams(String r3, HashMap<String, String> r4) {
        monitor-enter(this);
        int r5 = nativeSetStringParams(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterListener(BachCallbackListener r3) {
        monitor-enter(this);
        nativeUnRegisterListener(this.m_nativePtr, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
