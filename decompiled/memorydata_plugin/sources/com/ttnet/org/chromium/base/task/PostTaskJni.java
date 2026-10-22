package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class PostTaskJni implements PostTask.Natives {
    public static final JniStaticTestMocker<PostTask.Natives> TEST_HOOKS = null;
    private static PostTask.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    PostTaskJni() {
    }

    static /* synthetic */ PostTask.Natives access$002(PostTask.Natives r2) {
        PostTask.Natives r3 = (PostTask.Natives) ZeusTransformUtils.wrapperContextForParams(r2, PostTask.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static PostTask.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        PostTask.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.PostTask.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PostTaskJni();
    }

    @Override // com.ttnet.org.chromium.base.task.PostTask.Natives
    public void postDelayedTask(int r11, boolean r12, boolean r13, byte r14, byte[] r15, Runnable r16, long r17, String r19) {
        GEN_JNI.com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(r11, r12, r13, r14, r15, (Runnable) ZeusTransformUtils.wrapperContextForParams(r16, Runnable.class, "com.obric.memorydata.plugin"), r17, r19);
    }
}
