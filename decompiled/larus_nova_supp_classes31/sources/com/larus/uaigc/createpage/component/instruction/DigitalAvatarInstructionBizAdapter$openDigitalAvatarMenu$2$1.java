package com.larus.uaigc.createpage.component.instruction;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {0}, l = {314}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $digitalAvatarId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

    public DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1(DigitalAvatarInstructionBizAdapter r1, String r2, Continuation<? super DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1> r3) {
        this.this$0 = r1;
        this.$digitalAvatarId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1 r0 = new DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1(this.this$0, this.$digitalAvatarId, r5);
        r0.L$0 = r4;
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
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L16;
        DigitalAvatarInstructionBizAdapter r5 = this.this$0;
        DigitalAvatarInstructionBizAdapter.F(r5, this.$digitalAvatarId, r5.r);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        DigitalAvatarInstructionBizAdapter r3 = this.this$0;
        this.L$0 = r6;
        this.label = 1;
        if (DigitalAvatarInstructionBizAdapter.H(r3, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r6;
        goto L13
    }
}
