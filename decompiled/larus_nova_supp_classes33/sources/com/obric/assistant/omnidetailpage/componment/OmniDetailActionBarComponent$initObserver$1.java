package com.obric.assistant.omnidetailpage.componment;

import androidx.core.content.ContextCompat;
import com.larus.utils.e1;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailActionBarComponent$initObserver$1", f = "OmniDetailActionBarComponent.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailActionBarComponent$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OmniDetailActionBarComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ OmniDetailActionBarComponent a;

        public a(OmniDetailActionBarComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            int r6 = ((Number) r4).intValue();
            OmniDetailActionBarComponent r7 = this.a;
            int r0 = OmniDetailActionBarComponent.q;
            ObricFragmentOmniDetailBinding r1 = (ObricFragmentOmniDetailBinding) r7.m.getValue();
            if (r1 == null) goto L19;
            if (r6 != OmniDetailActionBarComponent.Companion.TaskStatus.Completed.ordinal()) goto L9;
            e1.o(r1.i);
            e1.x(r1.j);
            r1.f.setImageResource(2131245469);
            r1.l.setText(r7.getContext().getString(2131912291));
            r1.l.setTextColor(ContextCompat.getColor(r7.getContext(), v19.c.b(2130970958, r7.getContext(), 2131102629)));
            goto L19
        L9:
            if (r6 != OmniDetailActionBarComponent.Companion.TaskStatus.Terminated.ordinal()) goto L12;
            e1.o(r1.i);
            e1.x(r1.j);
            r1.f.setImageResource(2131244565);
            r1.l.setText(r7.getContext().getString(2131912292));
            r1.l.setTextColor(ContextCompat.getColor(r7.getContext(), v19.c.b(2130972081, r7.getContext(), 2131103143)));
            goto L19
        L12:
            if (r6 != OmniDetailActionBarComponent.Companion.TaskStatus.Fail.ordinal()) goto L15;
            e1.o(r1.i);
            e1.x(r1.j);
            r1.f.setImageResource(2131245470);
            r1.l.setText(r7.getContext().getString(2131912293));
            r1.l.setTextColor(ContextCompat.getColor(r7.getContext(), 2131102625));
            r1.l.setTextColor(ContextCompat.getColor(r7.getContext(), v19.c.b(2130970996, r7.getContext(), 2131102625)));
            goto L19
        L15:
            if (r6 != OmniDetailActionBarComponent.Companion.TaskStatus.NoTask.ordinal()) goto L17;
            e1.o(r1.i);
            e1.o(r1.j);
            goto L19
        L17:
            e1.x(r1.i);
            r1.i.setLoading(false);
            e1.o(r1.j);
        L19:
            return Unit.INSTANCE;
        }
    }

    public OmniDetailActionBarComponent$initObserver$1(OmniDetailActionBarComponent r1, Continuation<? super OmniDetailActionBarComponent$initObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OmniDetailActionBarComponent$initObserver$1(this.this$0, r3);
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
        OmniDetailActionBarComponent r6 = this.this$0;
        StateFlowImpl r2 = r6.o;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
