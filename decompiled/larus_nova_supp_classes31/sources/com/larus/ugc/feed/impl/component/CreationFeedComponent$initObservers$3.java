package com.larus.ugc.feed.impl.component;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import com.larus.ugc.feed.impl.adapter.CreationListAdapter;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$initObservers$3", f = "CreationFeedComponent.kt", i = {}, l = {825}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$initObservers$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationFeedComponent a;

        public a(CreationFeedComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            final n0a.d r4 = (n0a.d) r2;
            if ((r4 instanceof n0a.d.f) == false) goto L5;
        L6:
            SwipeRefreshLayout r5 = this.a.o.b();
            if (r5 == null) goto L9;
            r5.setEnabled(true);
        L9:
            CreationListAdapter r6 = this.a.s;
            if (r6 == null) goto L13;
            Intrinsics.checkNotNullParameter(r4, "state");
            r6.q = r4;
            w0a.a.a("CreationListAdapter", new p0a.a(r4));
            r6.notifyDataSetChanged();
        L13:
            return Unit.INSTANCE;
        L5:
            if ((r4 instanceof n0a.d.b) == false) goto L9;
            goto L6
        }
    }

    public CreationFeedComponent$initObservers$3(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$initObservers$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationFeedComponent$initObservers$3(this.this$0, r3);
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
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationFeedComponent r6 = this.this$0;
        int r2 = CreationFeedComponent.H;
        CreationFeedAbilityImpl r7 = r6.B3();
        if (r7 == null) goto L18;
        final StateFlowImpl r8 = r7.b.a;
        if (r8 == null) goto L18;
        Flow r9 = kotlinx.coroutines.flow.e.n(new CreationFeedComponent$initObservers$3$invokeSuspend$$inlined$map$1(r8));
        if (r9 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r9.collect(r3, this) != r0) goto L18;
        return r0;
    }
}
