package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class TaskRunnerImplJni implements TaskRunnerImpl.Natives {
    public static final JniStaticTestMocker<TaskRunnerImpl.Natives> TEST_HOOKS = null;
    private static TaskRunnerImpl.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    TaskRunnerImplJni() {
    }

    static /* synthetic */ TaskRunnerImpl.Natives access$002(TaskRunnerImpl.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static TaskRunnerImpl.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TaskRunnerImpl.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TaskRunnerImplJni();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public boolean belongsToCurrentThread(long r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public void destroy(long r10) {
        GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public long init(int r10, int r11, boolean r12, boolean r13, byte r14, byte[] r15) {
        return GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public void postDelayedTask(long r10, Runnable r11, long r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(r10, r11, r12, r13);
    }
}
