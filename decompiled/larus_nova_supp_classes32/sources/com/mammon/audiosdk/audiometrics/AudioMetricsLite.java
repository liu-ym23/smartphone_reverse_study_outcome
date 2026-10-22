package com.mammon.audiosdk.audiometrics;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AudioMetricsLite {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public synchronized void delete() {
        monitor-enter(this);
        long r0 = this.swigCPtr;     // Catch: Throwable -> L11
        if (r0 != 0) goto L6;
    L9:
        monitor-exit(this);
        return;
    L6:
        if (this.swigCMemOwn == false) goto L8;
        this.swigCMemOwn = false;     // Catch: Throwable -> L11
        AduioMetricLiteModuleJNI.delete_AudioMetricsLite(r0);     // Catch: Throwable -> L11
    L8:
        this.swigCPtr = 0;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    static {
        INVOKESTATIC_com_mammon_audiosdk_audiometrics_AudioMetricsLite_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(BuildConfig.LIBNAME);
    }

    public String get_result() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_get_result__SWIG_1(this.swigCPtr, this);
    }

    public int init() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_init(this.swigCPtr, this);
    }

    public int process_tail() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_process_tail(this.swigCPtr, this);
    }

    public void release() {
        AduioMetricLiteModuleJNI.AudioMetricsLite_release(this.swigCPtr, this);
    }

    public int reset() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_reset(this.swigCPtr, this);
    }

    public String version() {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_version(this.swigCPtr, this);
    }

    public AudioMetricsLite() {
        this(AduioMetricLiteModuleJNI.new_AudioMetricsLite(), true);
    }

    public void finalize() {
        delete();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_mammon_audiosdk_audiometrics_AudioMetricsLite_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static long getCPtr(AudioMetricsLite r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.swigCPtr;
    }

    public static long swigRelease(AudioMetricsLite r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        if (r3.swigCMemOwn == false) goto L7;
        long r0 = r3.swigCPtr;
        r3.swigCMemOwn = false;
        r3.delete();
        return r0;
    L7:
        throw new RuntimeException("Cannot release ownership as memory is not owned");
    }

    public String get_result(int r3) {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_get_result__SWIG_0(this.swigCPtr, this, r3);
    }

    public int prepare(String r3) {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_prepare(this.swigCPtr, this, r3);
    }

    public AudioMetricsLite(long r1, boolean r3) {
        this.swigCMemOwn = r3;
        this.swigCPtr = r1;
    }

    public int process(float[] r7, int r8, int r9) {
        return AduioMetricLiteModuleJNI.AudioMetricsLite_process__SWIG_1(this.swigCPtr, this, r7, r8, r9);
    }
}
