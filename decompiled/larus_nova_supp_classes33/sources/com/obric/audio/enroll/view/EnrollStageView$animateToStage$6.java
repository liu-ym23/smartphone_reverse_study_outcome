package com.obric.audio.enroll.view;

import androidx.dynamicanimation.animation.SpringAnimation;
import com.obric.audio.enroll.animation.AnimationType;
import com.obric.audio.enroll.model.TeamState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$animateToStage$6", f = "EnrollStageView.kt", i = {0}, l = {441}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class EnrollStageView$animateToStage$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $args;
    final /* synthetic */ EnrollTeamView $candidate;
    final /* synthetic */ int $lines;
    final /* synthetic */ Map<Integer, List<SpringAnimation>> $springSet;
    int I$0;
    int label;

    public EnrollStageView$animateToStage$6(EnrollTeamView r1, Map<String, ? extends Object> r2, int r3, Map<Integer, List<SpringAnimation>> r4, Continuation<? super EnrollStageView$animateToStage$6> r5) {
        this.$candidate = r1;
        this.$args = r2;
        this.$lines = r3;
        this.$springSet = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new EnrollStageView$animateToStage$6(this.$candidate, this.$args, this.$lines, this.$springSet, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.ViewGroup, com.obric.audio.enroll.view.EnrollTeamView, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0090 -> B:31:0x0093). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r6);
        EnrollStageView$animateToStage$6 r7 = this;
    L31:
        r2 = r2 + 1;
    L21:
        if (r2 >= r7.$lines) goto L33;
        List<SpringAnimation> r3 = r7.$springSet.get(Boxing.boxInt(r2));
        if (r3 == null) goto L28;
        Iterator<T> r4 = r3.iterator();
    L26:
        if (r4.hasNext() == false) goto L28;
        ((SpringAnimation) r4.next()).start();
    L28:
        r7.I$0 = r2;
        r7.label = 1;
        if (DelayKt.delay(100, r7) != r0) goto L31;
        return r0;
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ?? r8 = this.$candidate;
        AnimationType r5 = AnimationType.FROM_CANDIDATE_TO_STAGE;
        Map<String, Object> r9 = this.$args;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "animatorType");
        Intrinsics.checkNotNullParameter(r9, "args");
        int r10 = EnrollTeamView.b.a[r5.ordinal()];
        if (r10 != 1) goto L11;
        r8.w = TeamState.CANDIDATE;
        r8.setVisibility(0);
    L19:
        r7 = this;
        r2 = 0;
        goto L21
    L11:
        if (r10 != 2) goto L13;
        r8.w = TeamState.ONSTAGE;
        r8.setVisibility(0);
        goto L19
    L13:
        if (r10 != 3) goto L16;
        r8.w = TeamState.DONE;
        goto L19
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
