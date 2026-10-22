package com.bytedance.byted_bach_sdk;

import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmOutput;
import com.bytedance.byted_bach_sdk.finder.BachResourceFinder;
import com.bytedance.byted_bach_sdk.input.BachAlgorithmInput;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BachAlgorithmSystem {
    private boolean isDestroyed;
    private BachResourceFinder m_finder;
    private long m_nativePtr;

    public static final enum BachErrorCode extends Enum<BachErrorCode> {
        private static final /* synthetic */ BachErrorCode[] $VALUES = null;
        public static final BachErrorCode INTERNAL_ERROR = null;
        public static final BachErrorCode INVALID_CONFIG = null;
        public static final BachErrorCode INVALID_FORMAT = null;
        public static final BachErrorCode INVALID_GRAPH = null;
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
            BachErrorCode r12 = new BachErrorCode("NONE_ERROR", 10);
            NONE_ERROR = r12;
            $VALUES = new BachErrorCode[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        public static BachErrorCode[] values() {
            return (BachErrorCode[]) $VALUES.clone();
        }

        public static BachErrorCode valueOf(String r1) {
            return (BachErrorCode) a.a(BachErrorCode.class, r1);
        }

        private BachErrorCode(String r1, int r2) {
            super(r1, r2);
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

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private native long nativeCreate(BachInitConfig r1);

    private native void nativeDestroy(long r1);

    private native int nativeExec(long r1, BachAlgorithmInput r3);

    private native BachAlgorithmOutput nativeGetResult(long r1, String r3, int r4);

    private native void nativeInitGraph(long r1, String r3);

    private native void nativeSetBachCacheEnable(long r1, boolean r3);

    private native int nativeSetEnable(long r1, String r3, boolean r4);

    private native int nativeSetFloatParams(long r1, String r3, HashMap<String, Float> r4);

    private native int nativeSetIntParams(long r1, String r3, HashMap<String, Integer> r4);

    private native int nativeSetStringParams(long r1, String r3, HashMap<String, String> r4);

    private native void nativeinitGraphWithRootPath(long r1, String r3, String r4);

    public synchronized void destroy() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isDestroyed = true;     // Catch: Throwable -> L11
        nativeDestroy(this.m_nativePtr);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    static {
        INVOKESTATIC_com_bytedance_byted_bach_sdk_BachAlgorithmSystem_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bach-sdk-jni");
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public BachAlgorithmSystem(BachInitConfig r3) {
        this.isDestroyed = false;
        this.m_nativePtr = nativeCreate(r3);
        this.m_finder = r3.finder;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_byted_bach_sdk_BachAlgorithmSystem_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public synchronized BachErrorCode execute(BachAlgorithmInput r3) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L9;
        BachErrorCode r4 = BachErrorCode.NOT_INIT;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r4;
    L9:
        if (this.m_finder.isDestroyed == false) goto L13;
        BachErrorCode r5 = BachErrorCode.INVALID_RES_FINDER;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r5;
    L13:
        int r6 = nativeExec(this.m_nativePtr, r3);     // Catch: Throwable -> L16
        BachErrorCode r7 = BachErrorCode.values()[r6];     // Catch: Throwable -> L16
        monitor-exit(this);
        return r7;
    }

    public synchronized BachAlgorithmOutput getResult(String r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        BachAlgorithmOutput r5 = nativeGetResult(this.m_nativePtr, r4, 0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    }

    public synchronized void initGraph(String r3) {
        monitor-enter(this);
        nativeInitGraph(this.m_nativePtr, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setBachCacheEnable(boolean r3) {
        nativeSetBachCacheEnable(this.m_nativePtr, r3);
    }

    public int enable(String r3, boolean r4) {
        return nativeSetEnable(this.m_nativePtr, r3, r4);
    }

    public synchronized BachAlgorithmOutput getResult(String r3, int r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        BachAlgorithmOutput r5 = nativeGetResult(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    }

    public synchronized void initGraphWithRootPath(String r3, String r4) {
        monitor-enter(this);
        nativeinitGraphWithRootPath(this.m_nativePtr, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int setFloatParams(String r3, HashMap<String, Float> r4) {
        return nativeSetFloatParams(this.m_nativePtr, r3, r4);
    }

    public int setIntParams(String r3, HashMap<String, Integer> r4) {
        return nativeSetIntParams(this.m_nativePtr, r3, r4);
    }

    public int setStringParams(String r3, HashMap<String, String> r4) {
        return nativeSetStringParams(this.m_nativePtr, r3, r4);
    }
}
