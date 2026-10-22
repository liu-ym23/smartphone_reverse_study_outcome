package com.obric.aiagent.messenger.stub;

import android.os.Bundle;
import com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowUIIDLStub$suspendDismissKeyguard$1", f = "FlowUIIDLStub.kt", i = {0}, l = {183}, m = "invokeSuspend", n = {"isWindowShowing"}, s = {"I$0"})
public final class FlowUIIDLStub$suspendDismissKeyguard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowBiometricUnlock;
    final /* synthetic */ IDismissKeyguardCallbackIDL $callback;
    final /* synthetic */ String $intent;
    final /* synthetic */ String[] $noTTSIntents;
    final /* synthetic */ Bundle $reportParams;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ FlowUIIDLStub this$0;

    public FlowUIIDLStub$suspendDismissKeyguard$1(IDismissKeyguardCallbackIDL r1, FlowUIIDLStub r2, String r3, String[] r4, boolean r5, Bundle r6, Continuation<? super FlowUIIDLStub$suspendDismissKeyguard$1> r7) {
        this.$callback = r1;
        this.this$0 = r2;
        this.$intent = r3;
        this.$noTTSIntents = r4;
        this.$allowBiometricUnlock = r5;
        this.$reportParams = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new FlowUIIDLStub$suspendDismissKeyguard$1(this.$callback, this.this$0, this.$intent, this.$noTTSIntents, this.$allowBiometricUnlock, this.$reportParams, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [int] */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r3 = this.I$0;
        IDismissKeyguardCallbackIDL r4 = (IDismissKeyguardCallbackIDL) this.L$0;
        ResultKt.throwOnFailure(r11);
        ?? r5 = r3;
    L18:
        boolean r12 = ((Boolean) r11).booleanValue();
        if (r5 == 0) goto L21;
        r2 = true;
    L21:
        r4.onResult(r12, r2);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IAssistantChatWindow r13 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r13 == null) goto L11;
        ?? r14 = r13.isShowing();
    L12:
        r4 = this.$callback;
        if (r4 == null) goto L23;
        FlowUIIDLStub r6 = this.this$0;
        String r7 = this.$intent;
        String[] r8 = this.$noTTSIntents;
        boolean r9 = this.$allowBiometricUnlock;
        Bundle r10 = this.$reportParams;
        this.L$0 = r4;
        this.I$0 = r14;
        this.label = 1;
        Object r15 = FlowUIIDLStub.access$suspendDismissKeyguard(r6, r7, r8, r9, r10, this);
        if (r15 != r0) goto L17;
        return r0;
    L17:
        r5 = r14;
        r11 = r15;
        goto L18
    L11:
        r14 = 0;
        goto L12
    }
}
