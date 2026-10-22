package com.larus.search.impl.combine;

import com.larus.business.search.impl.databinding.LarusFragmentCombineSearchBinding;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$onViewCreated$3$1", f = "CombineSearchFragment.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
public final class CombineSearchFragment$onViewCreated$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentCombineSearchBinding $this_apply;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CombineSearchFragment a;

        public a(CombineSearchFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            String r5 = (String) r3;
            if (r5.length() != 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L8;
        L16:
            CombineSearchFragment r7 = this.a;
            r7.ia0(r7.j, r7.k);
            CombineSearchFragment r8 = this.a;
            r8.j = "";
            r8.k = iz8.c.d("");
            this.a.ca0().updateKeyWord(this.a.j);
            this.a.ga0();
            this.a.ia0(null, null);
        L18:
            return Unit.INSTANCE;
        L8:
            if (StringsKt.isBlank(r5) == true) goto L16;
            if (Intrinsics.areEqual(this.a.j, r5) == true) goto L18;
            CombineSearchFragment r9 = this.a;
            String r1 = r9.j;
            r9.j = r5;
            r9.k = iz8.c.d(r5);
            String r10 = "auto";
            CombineSearchFragment.Y90(this.a, "auto");
            CombineSearchFragment r11 = this.a;
            if (r11.y == false) goto L15;
            r11.y = false;
            r10 = "history";
        L15:
            tx9.c0.y(r10, r11);
            goto L18
        L5:
            r6 = false;
            goto L6
        }
    }

    public CombineSearchFragment$onViewCreated$3$1(LarusFragmentCombineSearchBinding r1, CombineSearchFragment r2, Continuation<? super CombineSearchFragment$onViewCreated$3$1> r3) {
        this.$this_apply = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CombineSearchFragment$onViewCreated$3$1(this.$this_apply, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Flow r7 = kotlinx.coroutines.flow.e.m(this.$this_apply.c.getInputTextFlow(), 100);
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
