package com.obric.assistant.special_input.util;

import android.os.IBinder;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/special_input/util/AssistantInteractionListenerIDLWrapper;", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;", "iAssistantInteractionListenerIDL", "taskChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "<init>", "(Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;Lkotlinx/coroutines/channels/Channel;)V", "asBinder", "Landroid/os/IBinder;", "onAssistantTakeOver", "onReply", "content", "", "onPanelCancel", "onPanelShow", "height", "", "onPanelHeightChanged", "requestToShowInputPanel", "requestToShowInputPanelWithMeta", "meta", "onAssistantDied", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantInteractionListenerIDLWrapper implements IAssistantInteractionListenerIDL {
    public static final a Companion = null;
    private static final String TAG = "SpecialInputAssistantInteractionListenerIDLWrapper";
    private final IAssistantInteractionListenerIDL iAssistantInteractionListenerIDL;
    private final Channel<Function0<Unit>> taskChannel;

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit a(String r0, AssistantInteractionListenerIDLWrapper r1) {
        return requestToShowInputPanelWithMeta$lambda$27(r0, r1);
    }

    public static /* synthetic */ Unit b(AssistantInteractionListenerIDLWrapper r0) {
        return onAssistantTakeOver$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(AssistantInteractionListenerIDLWrapper r0, int r1) {
        return onPanelShow$lambda$15(r0, r1);
    }

    public static /* synthetic */ Unit d(String r0, AssistantInteractionListenerIDLWrapper r1) {
        return onReply$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit e(AssistantInteractionListenerIDLWrapper r0) {
        return onPanelCancel$lambda$11(r0);
    }

    public static /* synthetic */ Unit f(AssistantInteractionListenerIDLWrapper r0, int r1) {
        return onPanelHeightChanged$lambda$19(r0, r1);
    }

    public static /* synthetic */ Unit g(AssistantInteractionListenerIDLWrapper r0) {
        return onAssistantDied$lambda$31(r0);
    }

    public static /* synthetic */ Unit h(AssistantInteractionListenerIDLWrapper r0) {
        return requestToShowInputPanel$lambda$23(r0);
    }

    public IBinder asBinder() {
        return this.iAssistantInteractionListenerIDL.asBinder();
    }

    public void onAssistantDied() {
        this.taskChannel.mo530trySendJP2dKIU(new c(this));
    }

    public void onAssistantTakeOver() {
        this.taskChannel.mo530trySendJP2dKIU(new d(this));
    }

    public void onPanelCancel() {
        this.taskChannel.mo530trySendJP2dKIU(new h(this));
    }

    public void requestToShowInputPanel() {
        this.taskChannel.mo530trySendJP2dKIU(new a(this));
    }

    private static final Unit onAssistantDied$lambda$31(AssistantInteractionListenerIDLWrapper r5) {
        FLogger.a.i(TAG, "onAssistantDied");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r5.iAssistantInteractionListenerIDL.onAssistantDied();     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.exceptionOrNull-impl(r6);
        if (r1 == null) goto L11;
        FLogger.a.w(TAG, "onAssistantDied failed: " + r1.getMessage(), r1);
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L14;
        Unit r7 = (Unit) r6;
        FLogger.a.i(TAG, "onAssistantDied succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit onAssistantTakeOver$lambda$3(AssistantInteractionListenerIDLWrapper r5) {
        FLogger.a.i(TAG, "onAssistantTakeOver");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r5.iAssistantInteractionListenerIDL.onAssistantTakeOver();     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.exceptionOrNull-impl(r6);
        if (r1 == null) goto L11;
        FLogger.a.w(TAG, "onAssistantTakeOver failed: " + r1.getMessage(), r1);
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L14;
        Unit r7 = (Unit) r6;
        FLogger.a.i(TAG, "onAssistantTakeOver succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit onPanelCancel$lambda$11(AssistantInteractionListenerIDLWrapper r5) {
        FLogger.a.i(TAG, "onPanelCancel");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r5.iAssistantInteractionListenerIDL.onPanelCancel();     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.exceptionOrNull-impl(r6);
        if (r1 == null) goto L11;
        FLogger.a.w(TAG, "onPanelCancel failed: " + r1.getMessage(), r1);
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L14;
        Unit r7 = (Unit) r6;
        FLogger.a.i(TAG, "onPanelCancel succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit requestToShowInputPanel$lambda$23(AssistantInteractionListenerIDLWrapper r5) {
        FLogger.a.i(TAG, "requestToShowInputPanel");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r5.iAssistantInteractionListenerIDL.requestToShowInputPanel();     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.exceptionOrNull-impl(r6);
        if (r1 == null) goto L11;
        FLogger.a.w(TAG, "requestToShowInputPanel failed: " + r1.getMessage(), r1);
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L14;
        Unit r7 = (Unit) r6;
        FLogger.a.i(TAG, "requestToShowInputPanel succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public void onPanelHeightChanged(int r3) {
        this.taskChannel.mo530trySendJP2dKIU(new g(this, r3));
    }

    public void onPanelShow(int r4) {
        FLogger.a.i(TAG, "onPanelShow: height = " + r4);
        this.taskChannel.mo530trySendJP2dKIU(new b(this, r4));
    }

    public void onReply(String r3) {
        this.taskChannel.mo530trySendJP2dKIU(new e(r3, this));
    }

    public void requestToShowInputPanelWithMeta(String r3) {
        this.taskChannel.mo530trySendJP2dKIU(new f(r3, this));
    }

    public AssistantInteractionListenerIDLWrapper(IAssistantInteractionListenerIDL r2, Channel<Function0<Unit>> r3) {
        Intrinsics.checkNotNullParameter(r2, "iAssistantInteractionListenerIDL");
        Intrinsics.checkNotNullParameter(r3, "taskChannel");
        this.iAssistantInteractionListenerIDL = r2;
        this.taskChannel = r3;
    }

    private static final Unit onPanelHeightChanged$lambda$19(AssistantInteractionListenerIDLWrapper r4, int r5) {
        FLogger.a.i(TAG, "onPanelHeightChanged");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r4.iAssistantInteractionListenerIDL.onPanelHeightChanged(r5);     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L11;
        FLogger.a.w(TAG, "onPanelHeightChanged failed: " + r7.getMessage(), r7);
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L14;
        Unit r8 = (Unit) r6;
        FLogger.a.i(TAG, "onPanelHeightChanged succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit onPanelShow$lambda$15(AssistantInteractionListenerIDLWrapper r4, int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r4.iAssistantInteractionListenerIDL.onPanelShow(r5);     // Catch: Throwable -> L4
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L10;
        FLogger.a.w(TAG, "onPanelShow failed: " + r7.getMessage(), r7);
    L10:
        if (Result.isSuccess-impl(r6) == false) goto L13;
        Unit r8 = (Unit) r6;
        FLogger.a.i(TAG, "onPanelShow succeed");
    L13:
        return Unit.INSTANCE;
    L4:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private static final Unit onReply$lambda$7(String r4, AssistantInteractionListenerIDLWrapper r5) {
        if (AppHost.a.isDebugChannel() == false) goto L5;
        FLogger.a.i(TAG, "onReply: content = " + r4);
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        r5.iAssistantInteractionListenerIDL.onReply(r4);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L14;
        FLogger.a.w(TAG, "onReply failed: " + r7.getMessage(), r7);
    L14:
        if (Result.isSuccess-impl(r6) == false) goto L17;
        Unit r8 = (Unit) r6;
        FLogger.a.i(TAG, "onReply succeed");
    L17:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L5:
        FLogger.a.i(TAG, "onReply");
        goto L18
    }

    private static final Unit requestToShowInputPanelWithMeta$lambda$27(String r4, AssistantInteractionListenerIDLWrapper r5) {
        FLogger.a.i(TAG, "requestToShowInputPanelWithMeta: meta = " + r4);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r5.iAssistantInteractionListenerIDL.requestToShowInputPanelWithMeta(r4);     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L11;
        FLogger.a.w(TAG, "requestToShowInputPanel failed: " + r7.getMessage(), r7);
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L14;
        Unit r8 = (Unit) r6;
        FLogger.a.i(TAG, "requestToShowInputPanel succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
