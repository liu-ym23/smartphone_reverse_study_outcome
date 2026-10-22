package com.larus.bmhome.double_post.conv;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.bmhome.chat.adapter.ConversationAdapter;
import com.larus.bmhome.double_post.adapter.AwemeRecommendAdapter;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostViewModel;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.bmhome.view.ChatConversationList;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AwemeConversationListDelegate {
    public final Fragment a;
    public final ConversationAdapter b;
    public ChatConversationList c;
    public final Lazy d;
    public final AwemeDividerAdapter e;
    public final AwemeRecommendAdapter f;
    public List<wh8.a> g;
    public boolean h;
    public final int i;
    public long j;
    public final Lazy k;
    public boolean l;
    public long m;

    public static final class a {
    }

    public static final class b implements AwemeDividerAdapter.a {
        public final /* synthetic */ AwemeConversationListDelegate a;

        @Override // com.larus.bmhome.double_post.conv.AwemeDividerAdapter.a
        public final void a() {
            AwemeConversationListDelegate r0 = this.a;
            r0.h = true;
            List<wh8.a> r1 = r0.g;
            if (r1 == null) goto L6;
            r0.d(r1);
            return;
        }

        public b(AwemeConversationListDelegate r1) {
            this.a = r1;
        }
    }

    public static final class c implements ip8.e {
        public final /* synthetic */ AwemeConversationListDelegate a;

        public c(AwemeConversationListDelegate r1) {
            this.a = r1;
        }

        @Override // ip8.e
        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            AwemeDoublePostViewModel.loadMoreData$default(this.a.a(), null, false, 3, null);
        }

        @Override // ip8.e
        public final void c(View r12, Content r13) {
            Intrinsics.checkNotNullParameter(r12, "view");
            Context r1 = this.a.a.getContext();
            if (r1 == null) goto L20;
            if (r13 == null) goto L22;
            int r0 = this.a.f.I2(r13);
            if (r0 >= 0) goto L9;
            return;
        L9:
            if (r0 >= this.a.f.getItemCount()) goto L23;
            com.larus.bmhome.double_post.utils.h.b(r1, r12, r13, r0, "chat_feed_tab", null, null, null, null, 992);
            StaggeredGridLayoutManager.LayoutParams r14 = r12.getLayoutParams();
            if ((r14 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L14;
            StaggeredGridLayoutManager.LayoutParams r15 = r14;
        L15:
            if (r15 == null) goto L17;
            int r16 = r15.getSpanIndex();
        L18:
            com.larus.bmhome.double_post.utils.e.c(r13, r0, r16);
            return;
        L17:
            r16 = 0;
            goto L18
        L14:
            r15 = null;
            goto L15
        L23:
            return;
        L22:
            return;
        }

        @Override // ip8.e
        public final void b(View r8, Content r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r8, "view");
            int r0 = com.larus.bmhome.double_post.utils.h.a;
            final AwemeConversationListDelegate r1 = this.a;
            com.larus.bmhome.double_post.utils.h.c(r1.a, r8, r9, r10, r11, new h(r1));
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final AwemeDoublePostViewModel a() {
        return (AwemeDoublePostViewModel) this.d.getValue();
    }

    public final void e() {
        if (((Number) this.k.getValue()).longValue() > 0) goto L5;
        return;
    L5:
        if (this.j <= 0) goto L30;
        ChatConversationList r0 = this.c;
        if (r0 == null) goto L21;
        StaggeredGridLayoutManager r3 = r0.getLayoutManager();
        if ((r3 instanceof StaggeredGridLayoutManager) == false) goto L12;
        StaggeredGridLayoutManager r4 = r3;
    L13:
        if (r4 == null) goto L21;
        int[] r5 = r4.findLastVisibleItemPositions(null);
        Intrinsics.checkNotNull(r5);
        int r6 = r5.length;
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L21;
        if ((r0.findViewHolderForAdapterPosition(r5[r7]) instanceof lp8.h) == true) goto L19;
        r7 = r7 + 1;
        goto L16
    L19:
        boolean r1 = true;
    L22:
        if (r1 == false) goto L31;
        long r8 = System.currentTimeMillis() - this.j;
        FLogger.a.i("AwemeConversationListDelegate", "tryAutoRefresh, leavePageGap = " + r8 + ", autoRefreshInterval = " + ((Number) this.k.getValue()).longValue());
        if (r8 < ((Number) this.k.getValue()).longValue()) goto L32;
        AwemeDoublePostViewModel.refreshData$default(a(), SortRequestType.AutoRefresh, false, 2, null);
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r4 = null;
    L21:
        r1 = false;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(ChatConversationList r8) {
        this.m = System.currentTimeMillis();
        this.c = r8;
        a().getAwemeContentList().observe(this.a, new d(new com.larus.bmhome.double_post.conv.c(this)));
        a().getAwemeLoadMoreList().observe(this.a, new d(new com.larus.bmhome.double_post.conv.d(this)));
        a().getAwemeRefreshList().observe(this.a, new d(new e(this)));
        a().setScene(SortScene.ConversationList);
        a().prefetchData(null);
        AwemeDividerAdapter r0 = this.e;
        b r2 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "callback");
        r0.b = r2;
        this.f.k = new c(this);
        if (r8 == 0) goto L5;
        StaggeredGridLayoutManager r4 = new StaggeredGridLayoutManager(2, 1);
        r4.setGapStrategy(0);
        r8.setLayoutManager(r4);
    L5:
        if (r8 == 0) goto L7;
        r8.setAdapter(new ConcatAdapter(new RecyclerView.Adapter[]{this.b, this.e, this.f}));
    L7:
        if (r8 == 0) goto L9;
        r8.addOnScrollListener(new AwemeConversationListDelegate$init$7(this));
    L9:
        Lazy r1 = com.larus.bmhome.video.b.a;
        int r3 = com.larus.bmhome.video.b.b(false);
        if (r8 == 0) goto L12;
        r8.setPadding(r3, r8.getPaddingTop(), r3, r8.getPaddingBottom());
    L12:
        if (r8 == 0) goto L14;
        y6.g(r8, new f(this), ((Number) i5.j0.getValue()).intValue(), new g(this));
    L14:
        LifecycleOwnerKt.getLifecycleScope(this.a).launchWhenResumed(new AwemeConversationListDelegate$init$10(null));
    }

    public final void c(boolean r5) {
        if (r5 == false) goto L4;
        this.m = System.currentTimeMillis();
        e();
        return;
    L4:
        long r0 = System.currentTimeMillis();
        this.j = r0;
        com.larus.bmhome.double_post.utils.e r6 = com.larus.bmhome.double_post.utils.e.a;
        long r1 = r0 - this.m;
        AwemeRecommendAdapter r2 = this.f;
        Content r3 = (Content) r2.A2(r2.getItemCount() - 1);
        if (r3 == null) goto L9;
        Integer r4 = r3.getImprIndex();
        if (r4 == null) goto L9;
        int r7 = r4.intValue();
    L10:
        r6.b("click_button_tab", r1, Integer.valueOf(r7));
        return;
    L9:
        r7 = 0;
        goto L10
    }

    public final void d(List<wh8.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.g = r5;
        int r0 = r5.size();
        boolean r2 = true;
        if (this.h == true) goto L7;
        int r1 = this.i;
        if (r0 <= r1) goto L7;
        r0 = r1 - 1;
    L7:
        this.b.E2(CollectionsKt.take(r5, r0));
        List<wh8.a> r6 = this.g;
        if (r6 == null) goto L10;
        int r7 = r6.size();
    L12:
        if (this.h == false) goto L14;
        final List<wh8.a> r8 = null;
    L22:
        final AwemeDividerAdapter r3 = this.e;
        if (r3.a == null) goto L26;
        if (r8 != null) goto L26;
    L27:
        if (r2 == false) goto L29;
        long r4 = 50;
    L30:
        t0.d(new k(r3, r8), r4);
        return;
    L29:
        r4 = 0;
    L26:
        r2 = false;
        goto L27
    L14:
        int r9 = this.i;
        if (r7 <= r9) goto L21;
        List<wh8.a> r10 = this.g;
        if (r10 == null) goto L20;
        r8 = r10.subList(r9 - 1, r9 + 1);
        if (r8 != null) goto L22;
    L20:
        r8 = CollectionsKt.emptyList();
        goto L22
    L21:
        r8 = CollectionsKt.emptyList();
        goto L22
    L10:
        r7 = 0;
        goto L12
    }

    public AwemeConversationListDelegate(final Fragment r7, ConversationAdapter r8) {
        Intrinsics.checkNotNullParameter(r7, "fg");
        Intrinsics.checkNotNullParameter(r8, "adapter");
        this.a = r7;
        this.b = r8;
        final Function0<Fragment> r9 = new AwemeConversationListDelegate$special$$inlined$viewModels$default$1(r7);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(r7, Reflection.getOrCreateKotlinClass(AwemeDoublePostViewModel.class), new AwemeConversationListDelegate$special$$inlined$viewModels$default$2(r9), new AwemeConversationListDelegate$special$$inlined$viewModels$default$3(r9, r7));
        this.e = new AwemeDividerAdapter();
        this.f = new AwemeRecommendAdapter(new FPagingAdapter.a(new com.larus.bmhome.double_post.conv.a(this)), com.larus.bmhome.video.b.d(0, 0, 7), false, null, 24);
        this.i = 4;
        this.k = LazyKt.lazy(new com.larus.bmhome.double_post.conv.b());
    }
}
