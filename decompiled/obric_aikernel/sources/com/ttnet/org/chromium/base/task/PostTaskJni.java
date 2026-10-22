package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class PostTaskJni implements PostTask.Natives {
    public static final JniStaticTestMocker<PostTask.Natives> TEST_HOOKS = null;
    private static PostTask.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    PostTaskJni() {
    }

    static /* synthetic */ PostTask.Natives access$002(PostTask.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static PostTask.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        PostTask.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.PostTask.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PostTaskJni();
    }

    @Override // com.ttnet.org.chromium.base.task.PostTask.Natives
    public void postDelayedTask(int r10, boolean r11, boolean r12, byte r13, byte[] r14, Runnable r15, long r16, String r17) {
        GEN_JNI.com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
