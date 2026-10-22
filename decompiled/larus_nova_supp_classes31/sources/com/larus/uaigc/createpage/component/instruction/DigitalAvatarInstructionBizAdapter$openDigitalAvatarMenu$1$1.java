package com.larus.uaigc.createpage.component.instruction;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {0}, l = {263}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

    public DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1(DigitalAvatarInstructionBizAdapter r1, Continuation<? super DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1 r0 = new DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r4);
    L12:
        Triple<Integer, Integer, Integer> r5 = this.this$0.r;
        if (r5 == null) goto L15;
        int r6 = ((Number) r5.getSecond()).intValue();
    L17:
        if (CoroutineScopeKt.isActive(r2) == false) goto L21;
        if (r6 < 0) goto L21;
        DigitalAvatarInstructionBizAdapter r7 = this.this$0;
        DigitalAvatarInstructionBizAdapter.G(r7, r7.r);
    L21:
        return Unit.INSTANCE;
    L15:
        r6 = 0;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        DigitalAvatarInstructionBizAdapter r3 = this.this$0;
        this.L$0 = r8;
        this.label = 1;
        if (DigitalAvatarInstructionBizAdapter.H(r3, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        goto L12
    }
}
