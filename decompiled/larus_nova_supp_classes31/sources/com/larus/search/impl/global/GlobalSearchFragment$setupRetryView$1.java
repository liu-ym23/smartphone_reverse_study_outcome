package com.larus.search.impl.global;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.business.search.impl.databinding.LarusFragmentGlobalSearchBinding;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.network.http.AsyncThrowable;
import com.larus.paging.PagingDataAdapter;
import com.larus.paging.d1;
import com.larus.paging.f0;
import com.larus.paging.k0;
import com.larus.paging.n0;
import com.larus.settings.value.e10;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$setupRetryView$1", f = "GlobalSearchFragment.kt", i = {}, l = {699}, m = "invokeSuspend", n = {}, s = {})
final class GlobalSearchFragment$setupRetryView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentGlobalSearchBinding $this_setupRetryView;
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX INFO: renamed from: com.larus.search.impl.global.GlobalSearchFragment$setupRetryView$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/paging/CombinedLoadStates;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$setupRetryView$1$1", f = "GlobalSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.paging.i, Continuation<? super Unit>, Object> {
        final /* synthetic */ LarusFragmentGlobalSearchBinding $this_setupRetryView;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GlobalSearchFragment this$0;

        public AnonymousClass1(GlobalSearchFragment r1, LarusFragmentGlobalSearchBinding r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$this_setupRetryView = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$this_setupRetryView, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(com.larus.paging.i r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.paging.i) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L74;
            ResultKt.throwOnFailure(r11);
            com.larus.paging.i r12 = (com.larus.paging.i) this.L$0;
            if (this.this$0.h.length() != 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L10;
            GlobalSearchFragment r1 = this.this$0;
            com.larus.paging.u.a r2 = r12.a;
            r1.x = r2;
            String r3 = null;
            if ((r2 instanceof com.larus.paging.u.a) == false) goto L14;
            com.larus.paging.u.a r4 = r2;
        L15:
            if (r4 == null) goto L17;
            Throwable r5 = r4.b;
        L19:
            if ((r5 instanceof AsyncThrowable) == false) goto L21;
            AsyncThrowable r6 = (AsyncThrowable) r5;
        L22:
            if (r6 == null) goto L24;
            Long r7 = Boxing.boxLong(r6.getCode());
        L26:
            if ((r12.a instanceof com.larus.paging.u.a) == false) goto L36;
            if (r7 == null) goto L32;
            if (r7.longValue() == 710012005) goto L36;
        L32:
            if (NetworkUtils.isNetworkAvailable(this.this$0.getContext()) == true) goto L34;
            t19.s.j(t19.s.a, this.this$0.getContext(), this.this$0.getString(2131908080), null, false, 28);
        L34:
            this.$this_setupRetryView.b.c(Boxing.boxInt(2131906531));
            this.$this_setupRetryView.e.setVisibility(8);
            this.$this_setupRetryView.g.setVisibility(8);
        L72:
            return Unit.INSTANCE;
        L36:
            if ((r12.a instanceof com.larus.paging.u.c) == true) goto L45;
            if (r7 == null) goto L43;
            if (r7.longValue() == 710012005) goto L45;
        L43:
            if ((r12.a instanceof com.larus.paging.u.b) == false) goto L72;
            this.$this_setupRetryView.b.b();
            this.$this_setupRetryView.e.setVisibility(8);
            this.$this_setupRetryView.g.setVisibility(8);
            GlobalSearchFragment r13 = this.this$0;
            String r8 = r13.j;
            r13.X90(r8, iz8.c.d(r8));
        L45:
            if (r7 != null) goto L48;
        L50:
            f0 r14 = ((n0) ((PagingDataAdapter) this.this$0.g).a.f).c;
            int r9 = r14.c;
            int r10 = r14.d;
            List r15 = r14.a;
            ArrayList r16 = new ArrayList();
            Iterator r17 = r15.iterator();
        L52:
            if (r17.hasNext() == false) goto L55;
            CollectionsKt.addAll(r16, ((d1) r17.next()).b);
            goto L52
        L55:
            if (new com.larus.paging.s(r9, r10, r16).size() != 0) goto L70;
            this.$this_setupRetryView.b.d(Boxing.boxInt(2131906532));
            e10 r18 = e10.a;
            if (e10.i() == false) goto L69;
            if (r7 != null) goto L61;
        L62:
            LoadingWithRetryView r19 = this.$this_setupRetryView.b;
            Context r20 = this.this$0.getContext();
            if (r20 == null) goto L65;
            r3 = r20.getString(2131909109);
        L65:
            r19.a.b.setVisibility(0);
            if (r3 == null) goto L68;
            r19.a.b.setText(r3);
        L68:
            o3.b(this.this$0.k());
            goto L69
        L61:
            if (r7.longValue() != 710012005) goto L62;
        L69:
            this.$this_setupRetryView.g.setVisibility(8);
            this.$this_setupRetryView.e.setVisibility(8);
            goto L72
        L70:
            this.$this_setupRetryView.g.setVisibility(0);
            this.$this_setupRetryView.b.setVisibility(8);
            this.$this_setupRetryView.e.setVisibility(8);
            this.this$0.v = SystemClock.elapsedRealtime();
            goto L72
        L48:
            if (r7.longValue() != 710012005) goto L50;
            GlobalSearchFragment r110 = this.this$0;
            GlobalSearchResultAdapter r21 = r110.g;
            Lifecycle r111 = r110.getViewLifecycleOwner().getLifecycle();
            k0 r22 = k0.c;
            Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.larus.paging.PagingData<T of com.larus.paging.PagingData.Companion.empty>");
            r21.z2(r111, r22);
            goto L50
        L24:
            r7 = null;
            goto L26
        L21:
            r6 = null;
            goto L22
        L17:
            r5 = null;
            goto L19
        L14:
            r4 = null;
            goto L15
        L10:
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L8
        L74:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public GlobalSearchFragment$setupRetryView$1(GlobalSearchFragment r1, LarusFragmentGlobalSearchBinding r2, Continuation<? super GlobalSearchFragment$setupRetryView$1> r3) {
        this.this$0 = r1;
        this.$this_setupRetryView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GlobalSearchFragment$setupRetryView$1(this.this$0, this.$this_setupRetryView, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        GlobalSearchFragment r8 = this.this$0;
        FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1 r2 = ((PagingDataAdapter) r8.g).b;
        AnonymousClass1 r3 = new AnonymousClass1(r8, this.$this_setupRetryView, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
