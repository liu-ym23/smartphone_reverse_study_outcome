package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler r8, boolean r10) {
        this.mParent = r8;
        this.mCrashAfterReport = r10;
    }

    @CalledByNative
    private static void installHandler(boolean r8) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), r8));
    }

    private static native void nativeReportJavaException(boolean r8, Throwable r10);

    private static native void nativeReportJavaStackTrace(String r8);

    public static void reportStackTrace(String r8) {
        nativeReportJavaStackTrace(PiiElider.sanitizeStacktrace(r8));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r8, Throwable r10) {
        if (this.mHandlingException == true) goto L5;
        this.mHandlingException = true;
        nativeReportJavaException(this.mCrashAfterReport, r10);
    L5:
        Thread.UncaughtExceptionHandler r11 = this.mParent;
        if (r11 == null) goto L9;
        r11.uncaughtException(r8, r10);
        return;
    }
}
