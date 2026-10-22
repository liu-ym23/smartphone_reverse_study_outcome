package com.larus.search.impl.global;

import android.view.View;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.business.search.impl.databinding.LarusFragmentGlobalSearchBinding;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$onViewCreated$1$1", f = "GlobalSearchFragment.kt", i = {}, l = {531}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalSearchFragment$onViewCreated$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isFromEmpty;
    final /* synthetic */ LarusFragmentGlobalSearchBinding $this_apply;
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GlobalSearchFragment a;
        public final /* synthetic */ Ref.BooleanRef b;

        public a(GlobalSearchFragment r1, Ref.BooleanRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r4, Continuation r5) {
            String r6 = (String) r4;
            if (r6.length() != 0) goto L5;
            boolean r7 = true;
        L7:
            if (r7 == false) goto L14;
            GlobalSearchFragment r8 = this.a;
            r8.X90(r8.h, r8.i);
            GlobalSearchFragment r9 = this.a;
            r9.h = "";
            this.b.element = true;
            r9.i = iz8.c.d("");
            this.a.W90();
            this.a.X90(null, null);
            LarusFragmentGlobalSearchBinding r10 = this.a.e;
            if (r10 == null) goto L51;
            View r11 = r10.d;
            if (r11 == null) goto L51;
            r11.setVisibility(8);
        L51:
            return Unit.INSTANCE;
        L14:
            if (StringsKt.isBlank(r6) == false) goto L43;
            LarusFragmentGlobalSearchBinding r12 = this.a.e;
            if (r12 == null) goto L21;
            ScrollView r13 = r12.e;
            if (r13 == null) goto L21;
            r13.setVisibility(8);
        L21:
            if (this.b.element == true) goto L32;
            LarusFragmentGlobalSearchBinding r14 = this.a.e;
            if (r14 == null) goto L27;
            RecyclerView r15 = r14.g;
            if (r15 == null) goto L27;
            r15.setVisibility(0);
        L27:
            LarusFragmentGlobalSearchBinding r16 = this.a.e;
            if (r16 == null) goto L51;
            View r17 = r16.d;
            if (r17 == null) goto L51;
            r17.setVisibility(8);
            goto L51
        L32:
            LarusFragmentGlobalSearchBinding r18 = this.a.e;
            if (r18 == null) goto L37;
            RecyclerView r19 = r18.g;
            if (r19 == null) goto L37;
            r19.setVisibility(8);
        L37:
            LarusFragmentGlobalSearchBinding r20 = this.a.e;
            if (r20 == null) goto L51;
            View r21 = r20.d;
            if (r21 == null) goto L51;
            r21.setVisibility(0);
            goto L51
        L43:
            if (Intrinsics.areEqual(this.a.h, r6) == true) goto L51;
            GlobalSearchFragment r22 = this.a;
            r22.j = r22.h;
            this.b.element = false;
            r22.h = r6;
            r22.i = iz8.c.d(r6);
            this.a.Y90("auto");
            LarusFragmentGlobalSearchBinding r23 = this.a.e;
            if (r23 == null) goto L49;
            View r24 = r23.d;
            if (r24 == null) goto L49;
            r24.setVisibility(8);
        L49:
            c0.y("auto", this.a);
            goto L51
        L5:
            r7 = false;
            goto L7
        }
    }

    public GlobalSearchFragment$onViewCreated$1$1(LarusFragmentGlobalSearchBinding r1, GlobalSearchFragment r2, Ref.BooleanRef r3, Continuation<? super GlobalSearchFragment$onViewCreated$1$1> r4) {
        this.$this_apply = r1;
        this.this$0 = r2;
        this.$isFromEmpty = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GlobalSearchFragment$onViewCreated$1$1(this.$this_apply, this.this$0, this.$isFromEmpty, r5);
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
        a r2 = new a(this.this$0, this.$isFromEmpty);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
