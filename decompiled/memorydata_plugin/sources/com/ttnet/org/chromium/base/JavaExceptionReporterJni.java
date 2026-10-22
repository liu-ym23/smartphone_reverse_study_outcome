package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class JavaExceptionReporterJni implements JavaExceptionReporter.Natives {
    public static final JniStaticTestMocker<JavaExceptionReporter.Natives> TEST_HOOKS = null;
    private static JavaExceptionReporter.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    JavaExceptionReporterJni() {
    }

    static /* synthetic */ JavaExceptionReporter.Natives access$002(JavaExceptionReporter.Natives r2) {
        JavaExceptionReporter.Natives r3 = (JavaExceptionReporter.Natives) ZeusTransformUtils.wrapperContextForParams(r2, JavaExceptionReporter.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static JavaExceptionReporter.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JavaExceptionReporter.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaExceptionReporter.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaExceptionReporterJni();
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaException(boolean r1, Throwable r2) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaStackTrace(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(r1);
    }
}
