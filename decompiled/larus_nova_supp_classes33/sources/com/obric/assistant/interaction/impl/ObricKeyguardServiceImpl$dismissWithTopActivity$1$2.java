package com.obric.assistant.interaction.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl$dismissWithTopActivity$1$2", f = "ObricKeyguardServiceImpl.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
public final class ObricKeyguardServiceImpl$dismissWithTopActivity$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KeyguardDismissTerminalGate $terminalGate;
    int label;
    final /* synthetic */ ObricKeyguardServiceImpl this$0;

    public ObricKeyguardServiceImpl$dismissWithTopActivity$1$2(ObricKeyguardServiceImpl r1, KeyguardDismissTerminalGate r2, Continuation<? super ObricKeyguardServiceImpl$dismissWithTopActivity$1$2> r3) {
        this.this$0 = r1;
        this.$terminalGate = r2;
        super(2, r3);
    }

    public static /* synthetic */ Unit a() {
        return invokeSuspend$lambda$1();
    }

    public static /* synthetic */ boolean c(ObricKeyguardServiceImpl r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricKeyguardServiceImpl$dismissWithTopActivity$1$2(this.this$0, this.$terminalGate, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final Unit invokeSuspend$lambda$1() {
        ObricKeyguardServiceImpl.Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
        return Unit.INSTANCE;
    }

    private static final boolean invokeSuspend$lambda$0(ObricKeyguardServiceImpl r0) {
        return ObricKeyguardServiceImpl.access$getKeyguardManager(r0).isKeyguardLocked();
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) r5).booleanValue() == false) goto L15;
        ObricKeyguardServiceImpl.access$completeTopActivityDismiss(this.this$0, this.$terminalGate, "keyguard_state_unlocked", new w());
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final ObricKeyguardServiceImpl r6 = this.this$0;
        Function0 r2 = new v(r6);
        ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2 r7 = new ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2(null);
        this.label = 1;
        r5 = ObricKeyguardServiceImplKt.waitForTopActivityKeyguardUnlocked(r2, r7, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
