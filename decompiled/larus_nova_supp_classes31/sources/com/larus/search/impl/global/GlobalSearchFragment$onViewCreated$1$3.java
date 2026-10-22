package com.larus.search.impl.global;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.business.search.impl.databinding.LarusFragmentGlobalSearchBinding;
import com.larus.paging.PagingDataAdapter;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$onViewCreated$1$3", f = "GlobalSearchFragment.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalSearchFragment$onViewCreated$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GlobalSearchFragment a;

        public a(GlobalSearchFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            com.larus.paging.i r3 = (com.larus.paging.i) r1;
            LarusFragmentGlobalSearchBinding r4 = this.a.e;
            if (r4 == null) goto L8;
            RecyclerView r5 = r4.g;
            if (r5 == null) goto L8;
            r5.scrollToPosition(0);
        L8:
            return Unit.INSTANCE;
        }
    }

    public GlobalSearchFragment$onViewCreated$1$3(GlobalSearchFragment r1, Continuation<? super GlobalSearchFragment$onViewCreated$1$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GlobalSearchFragment$onViewCreated$1$3(this.this$0, r3);
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
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Flow r6 = kotlinx.coroutines.flow.e.o(((PagingDataAdapter) this.this$0.g).b, new r());
        a r2 = new a(this.this$0);
        this.label = 1;
        Object r7 = r6.collect(new GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2(r2), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r7 = Unit.INSTANCE;
    L12:
        if (r7 != r0) goto L15;
        return r0;
    }
}
