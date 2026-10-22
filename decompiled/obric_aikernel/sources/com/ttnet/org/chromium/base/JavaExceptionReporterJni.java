package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class JavaExceptionReporterJni implements JavaExceptionReporter.Natives {
    public static final JniStaticTestMocker<JavaExceptionReporter.Natives> TEST_HOOKS = null;
    private static JavaExceptionReporter.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    JavaExceptionReporterJni() {
    }

    static /* synthetic */ JavaExceptionReporter.Natives access$002(JavaExceptionReporter.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static JavaExceptionReporter.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JavaExceptionReporter.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaExceptionReporter.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaExceptionReporterJni();
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaException(boolean r10, Throwable r11) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaStackTrace(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(r10);
    }
}
