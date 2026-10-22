package com.obric.audio.enroll.view;

import android.os.CountDownTimer;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.model.TeamEnrollState;
import com.obric.audio.enroll.model.TipsCode;
import java.util.List;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollTeamView$restartAsrTimer$1", f = "EnrollTeamView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EnrollTeamView$restartAsrTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollTeamView this$0;

    public static final class a extends CountDownTimer {
        public final /* synthetic */ EnrollTeamView a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            EnrollTeamView r0 = this.a;
            Lazy<List<Integer>> r1 = EnrollTeamView.G;
            r0.getClass();
            FLogger.a.i("EnrollTeamView", "onSentenceAsrTimeout");
            r0.e = 0;
            r0.C6();
            EnrollTeamView.l7(r0, TeamEnrollState.ENROLLING);
            r0.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_TIMEOUT_RETRY));
        }

        public a(EnrollTeamView r5) {
            this.a = r5;
            super(5000, 1000);
        }
    }

    public EnrollTeamView$restartAsrTimer$1(EnrollTeamView r1, Continuation<? super EnrollTeamView$restartAsrTimer$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollTeamView$restartAsrTimer$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        CountDownTimer r4 = this.this$0.getSentenceAsrTimer();
        if (r4 == null) goto L7;
        r4.cancel();
    L7:
        this.this$0.setSentenceAsrTimer(new a(this.this$0).start());
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
