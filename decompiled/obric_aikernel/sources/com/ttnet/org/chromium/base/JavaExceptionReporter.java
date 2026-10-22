package com.ttnet.org.chromium.base;

import androidx.annotation.UiThread;
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

    interface Natives {
        void reportJavaException(boolean r10, Throwable r11);

        void reportJavaStackTrace(String r10);
    }

    static {
    }

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler r10, boolean r11) {
        this.mParent = r10;
        this.mCrashAfterReport = r11;
    }

    @CalledByNative
    private static void installHandler(boolean r10) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), r10));
    }

    @UiThread
    public static void reportException(Throwable r10) {
        JavaExceptionReporterJni.get().reportJavaException(false, r10);
    }

    @UiThread
    public static void reportStackTrace(String r10) {
        JavaExceptionReporterJni.get().reportJavaStackTrace(PiiElider.sanitizeStacktrace(r10));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r10, Throwable r11) {
        if (this.mHandlingException == true) goto L5;
        this.mHandlingException = true;
        JavaExceptionReporterJni.get().reportJavaException(this.mCrashAfterReport, r11);
    L5:
        Thread.UncaughtExceptionHandler r12 = this.mParent;
        if (r12 == null) goto L9;
        r12.uncaughtException(r10, r11);
        return;
    }
}
