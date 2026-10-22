package com.larus.bmhome.instruction;

import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$loginShutdownStateListener$1$onLoginShutdownStateChanged$1", f = "InstructionInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InstructionInputComponent$loginShutdownStateListener$1$onLoginShutdownStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $shutdown;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$loginShutdownStateListener$1$onLoginShutdownStateChanged$1(boolean r1, InstructionInputComponent r2, Continuation<? super InstructionInputComponent$loginShutdownStateListener$1$onLoginShutdownStateChanged$1> r3) {
        this.$shutdown = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionInputComponent$loginShutdownStateListener$1$onLoginShutdownStateChanged$1(this.$shutdown, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r4);
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("onLoginShutdownStateChanged isLogin = ");
        AccountService r1 = AccountService.a;
        r0.append(r1.isLogin().booleanValue());
        r5.i("InstructionInputComponent", r0.toString());
        if (r1.isLogin().booleanValue() == true) goto L20;
        if (this.$shutdown == this.this$0.p2) goto L18;
        r5.i("InstructionInputComponent", "onLoginShutdownStateChanged shutdown state change, current = " + this.this$0.p2 + ", new = " + this.$shutdown);
        InstructionInputComponent r6 = this.this$0;
        boolean r2 = this.$shutdown;
        r6.p2 = r2;
        CustomActionBar r7 = r6.P0;
        if (r7 == null) goto L18;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        CustomActionBarViewModel r8 = r7.o;     // Catch: Throwable -> L16
        if (r8 == null) goto L13;
        r8.reRefreshActionHiddenStatus(r2);     // Catch: Throwable -> L16
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(r9);     // Catch: Throwable -> L16
        goto L18
    L13:
        r9 = null;
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        FLogger.a.i("InstructionInputComponent", "onLoginShutdownStateChanged current isLoginShutDown = " + this.this$0.p2);
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
