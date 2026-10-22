package com.obric.assistant.interaction.impl.permission;

import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionMediator;", "", "<init>", "()V", "TAG", "", "currentTask", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "activityRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/assistant/interaction/impl/permission/PermissionHelperActivity;", "value", "", "isProcessing", "()Z", "startNewTask", "", "newTask", "attachActivity", "activity", "consumeTask", "finishTask", "cancelCurrentTask", WindowEvent.Params.REASON, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionMediator {
    public static final PermissionMediator INSTANCE = null;
    private static final String TAG = "PermissionMediator";
    private static WeakReference<PermissionHelperActivity> activityRef;
    private static PermissionTask currentTask;
    private static boolean isProcessing;

    static {
        INSTANCE = new PermissionMediator();
    }

    private PermissionMediator() {
    }

    public final PermissionTask consumeTask() {
        FLogger.a.i(TAG, "consumeTask");
        return currentTask;
    }

    public final void finishTask() {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        FLogger.a.i(TAG, "finishTask, shouldRestoreWindow=" + r1);
        isProcessing = false;
        currentTask = null;
        activityRef = null;
        if (r1 == false) goto L14;
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L15;
        IAssistantChatWindow$DefaultImpls.pop$default(r2, null, 1, null);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r0.isStashed() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean isProcessing() {
        return isProcessing;
    }

    public final void attachActivity(PermissionHelperActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        activityRef = new WeakReference(r2);
    }

    public final void cancelCurrentTask(String r6) {
        Intrinsics.checkNotNullParameter(r6, WindowEvent.Params.REASON);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("cancelCurrentTask ");
        r1.append(r6);
        r1.append(", currentTask = ");
        PermissionTask r7 = currentTask;
        if (r7 == null) goto L5;
        String r8 = r7.getClass().getSimpleName();
    L6:
        r1.append(r8);
        r0.i(TAG, r1.toString());
        PermissionTask r9 = currentTask;
        if (r9 != null) goto L10;
        return;
    L10:
        if ((r9 instanceof PermissionTask.RequestBasic) == false) goto L13;
        ((PermissionTask.RequestBasic) r9).getCallback().invoke(Boolean.FALSE);
    L36:
        isProcessing = false;
        currentTask = null;
        return;
    L13:
        if ((r9 instanceof PermissionTask.RequestDetail) == false) goto L16;
        PermissionTask.RequestDetail r10 = (PermissionTask.RequestDetail) r9;
        r10.getCallback().invoke(Boolean.FALSE, CollectionsKt.emptyList(), r10.getManifest());
        goto L36
    L16:
        if ((r9 instanceof PermissionTask.RequestWithMap) == false) goto L19;
        ((PermissionTask.RequestWithMap) r9).getCallback().invoke(Boolean.FALSE);
        goto L36
    L19:
        if ((r9 instanceof PermissionTask.RequestFull) == false) goto L22;
        PermissionTask.RequestFull r11 = (PermissionTask.RequestFull) r9;
        r11.getCallback().onResult(false, CollectionsKt.emptyList(), r11.getManifest(), false);
        goto L36
    L22:
        if ((r9 instanceof PermissionTask.RequestAny) == false) goto L25;
        PermissionTask.RequestAny r12 = (PermissionTask.RequestAny) r9;
        r12.getCallback().onResult(false, CollectionsKt.emptyList(), r12.getManifest(), false);
        goto L36
    L25:
        if ((r9 instanceof PermissionTask.GoSettings) == false) goto L30;
        g1.c r13 = ((PermissionTask.GoSettings) r9).getCallback();
        if (r13 == null) goto L36;
        r13.onResult(false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
        goto L36
    L30:
        if ((r9 instanceof PermissionTask.ShowSettingDialog) == false) goto L35;
        g1.b r14 = ((PermissionTask.ShowSettingDialog) r9).getCallback();
        if (r14 == null) goto L36;
        r14.onGoSettingsDialogDismiss(false);
        goto L36
    L35:
        if ((r9 instanceof PermissionTask.RequestNotification) == true) goto L36;
        throw new NoWhenBranchMatchedException();
    L5:
        r8 = null;
        goto L6
    }

    public final void startNewTask(PermissionTask r4) {
        Intrinsics.checkNotNullParameter(r4, "newTask");
        FLogger.a.i(TAG, "startNewTask");
        if (isProcessing == true) goto L5;
    L11:
        currentTask = r4;
        isProcessing = true;
        return;
    L5:
        if (currentTask == null) goto L11;
        cancelCurrentTask("Preempted by new request");
        WeakReference<PermissionHelperActivity> r0 = activityRef;
        if (r0 == null) goto L11;
        PermissionHelperActivity r1 = r0.get();
        if (r1 == null) goto L11;
        r1.finishDirectly();
        goto L11
    }
}
