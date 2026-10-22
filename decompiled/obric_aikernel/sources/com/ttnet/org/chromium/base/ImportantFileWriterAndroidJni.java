package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class ImportantFileWriterAndroidJni implements ImportantFileWriterAndroid.Natives {
    public static final JniStaticTestMocker<ImportantFileWriterAndroid.Natives> TEST_HOOKS = null;
    private static ImportantFileWriterAndroid.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    ImportantFileWriterAndroidJni() {
    }

    static /* synthetic */ ImportantFileWriterAndroid.Natives access$002(ImportantFileWriterAndroid.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static ImportantFileWriterAndroid.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ImportantFileWriterAndroid.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ImportantFileWriterAndroid.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ImportantFileWriterAndroidJni();
    }

    @Override // com.ttnet.org.chromium.base.ImportantFileWriterAndroid.Natives
    public boolean writeFileAtomically(String r10, byte[] r11) {
        return GEN_JNI.com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(r10, r11);
    }
}
