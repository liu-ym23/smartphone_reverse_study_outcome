package com.larus.dora.impl;

import com.google.gson.Gson;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.impl.network.DoraMessage;
import com.larus.dora.impl.network.f0;
import com.larus.dora.impl.network.r;
import com.larus.dora.impl.util.b0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1$onReceive$1", f = "DoraPreWakeUpTask.kt", i = {}, l = {864}, m = "invokeSuspend", n = {}, s = {})
public final class DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraMessage $message;
    private /* synthetic */ Object L$0;
    int label;

    public DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1$onReceive$1(DoraMessage r1, Continuation<? super DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1$onReceive$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1$onReceive$1 r0 = new DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1$onReceive$1(this.$message, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L38:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        DoraMessage r7 = this.$message;
        if (r7 == null) goto L38;
        if (r7.cmd != 200000) goto L38;
        String r8 = r7.cmdContent;
        if (r8 == null) goto L38;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object r9 = Result.constructor-impl((f0) new Gson().fromJson(r8, f0.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = null;
    L21:
        f0 r10 = (f0) r9;
        String r3 = ILoginService.a.getAccountInfo().c;
        if (r10 == null) goto L31;
        r r11 = r10.b();
        if (r11 == null) goto L31;
        Integer r12 = r11.a();
        if (r12 == null) goto L31;
        if (r12.intValue() != 1) goto L31;
        boolean r13 = true;
    L32:
        b0.a.getClass();
        if (b0.t(r3) == r13) goto L38;
        b0.E(r3, r13);
        MutableSharedFlow r4 = DoraPreWakeUpTask.m;
        Boolean r14 = Boxing.boxBoolean(r13);
        this.label = 1;
        if (r4.emit(r14, this) != r0) goto L38;
        return r0;
    L31:
        r13 = false;
    L16:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
