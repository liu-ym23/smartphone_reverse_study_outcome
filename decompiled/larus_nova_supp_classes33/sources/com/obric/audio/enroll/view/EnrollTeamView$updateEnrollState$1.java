package com.obric.audio.enroll.view;

import com.obric.audio.enroll.model.TeamEnrollState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollTeamView$updateEnrollState$1", f = "EnrollTeamView.kt", i = {}, l = {686}, m = "invokeSuspend", n = {}, s = {})
final class EnrollTeamView$updateEnrollState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TeamEnrollState $oldState;
    final /* synthetic */ TeamEnrollState $state;
    int label;
    final /* synthetic */ EnrollTeamView this$0;

    public EnrollTeamView$updateEnrollState$1(EnrollTeamView r1, TeamEnrollState r2, TeamEnrollState r3, Continuation<? super EnrollTeamView$updateEnrollState$1> r4) {
        this.this$0 = r1;
        this.$oldState = r2;
        this.$state = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new EnrollTeamView$updateEnrollState$1(this.this$0, this.$oldState, this.$state, r5);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        EnrollTeamView r6 = this.this$0;
        TeamEnrollState r2 = this.$oldState;
        TeamEnrollState r3 = this.$state;
        this.label = 1;
        if (EnrollTeamView.S5(r6, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
