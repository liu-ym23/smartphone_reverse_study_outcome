package com.obric.audio.enroll.view;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$observe$4", f = "EnrollStageView.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollStageView$observe$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollStageView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ EnrollStageView a;

        public a(EnrollStageView r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            Pair r9 = (Pair) r7;
            FLogger.a.i("EnrollStageView", "enrollProgress: " + r9 + " detail: " + ((int[]) r9.getSecond())[0] + " ~ " + ((int[]) r9.getSecond())[1]);
            int r10 = ((Number) r9.getFirst()).intValue();
            int r0 = ((int[]) r9.getSecond())[0];
            int r11 = ((int[]) r9.getSecond())[1];
            Iterator r1 = ((ArrayList) this.a.b).iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            Object r4 = r1.next();
            if (((EnrollTeamView) r4).getIndex() != r10) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L4;
        L12:
            EnrollTeamView r6 = (EnrollTeamView) r4;
            if (r6 == null) goto L16;
            r6.setHoloVisible(true);
            r6.N6(r0, r11);
        L16:
            return Unit.INSTANCE;
        L8:
            r5 = false;
            goto L9
        L11:
            r4 = null;
            goto L12
        }
    }

    public EnrollStageView$observe$4(EnrollStageView r1, Continuation<? super EnrollStageView$observe$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollStageView$observe$4(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow<Pair<Integer, int[]>> r6 = this.this$0.getViewModel().getEnrollProgress();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
