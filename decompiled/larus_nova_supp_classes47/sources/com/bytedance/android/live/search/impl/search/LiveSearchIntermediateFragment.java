package com.bytedance.android.live.search.impl.search;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchHistoryAdapter;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchSugAdapter;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lqa1/c;", "Lcom/bytedance/android/live/search/impl/search/t$a;", "<init>", "()V", "SimpleItemDecoration", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchIntermediateFragment extends BaseFragment implements qa1.c, t.a {
    public static final /* synthetic */ int k = 0;
    public RecyclerView d;
    public LiveSearchSugAdapter e;
    public LiveSearchHistoryAdapter f;
    public LiveSearchIntermediateViewModel g;
    public String h;
    public final Lazy i;
    public t j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateFragment$SimpleItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SimpleItemDecoration extends RecyclerView.ItemDecoration {
        public final Drawable a;

        public static final class a {
        }

        static {
        }

        public SimpleItemDecoration(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            this.a = r2;
        }

        public final void onDraw(Canvas r2, RecyclerView r3, RecyclerView.State r4) {
            Intrinsics.checkNotNullParameter(r2, "c");
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r4, "state");
            if (r3.getChildCount() >= 2) goto L5;
            return;
        L5:
            LinearLayoutManager r5 = r3.getLayoutManager();
            if (r5 == null) goto L13;
            LinearLayoutManager r6 = r5;
            if (((r6.findLastVisibleItemPosition() - r6.findFirstVisibleItemPosition()) - 1) >= 0) goto L10;
            return;
        L10:
            this.a.draw(r2);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.set(0, 0, 0, this.a.getIntrinsicHeight());
        }
    }

    public static final class a<T> implements Observer {
        public final /* synthetic */ LiveSearchIntermediateFragment a;

        public a(LiveSearchIntermediateFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            LiveSearchIntermediateFragment r0 = this.a;
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            r0.h = r3;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ LiveSearchIntermediateFragment a;

        public b(LiveSearchIntermediateFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Integer r9 = (Integer) r8;
            LiveSearchIntermediateFragment r10 = this.a;
            int r0 = LiveSearchIntermediateFragment.k;
            if (r10.isViewValid() == true) goto L5;
            return;
        L5:
            if (r10.getUserVisibleHint() == false) goto L70;
            LiveSearchIntermediateViewModel r1 = r10.g;
            if (r1 == null) goto L12;
            NextLiveData<Integer> r2 = r1.getIntermediateState();
            if (r2 == null) goto L12;
            Integer r3 = (Integer) r2.getValue();
        L14:
            if (r3 != null) goto L17;
        L37:
            if (r3 != null) goto L40;
        L56:
            if (r3 == null) goto L71;
            r3.intValue();
            return;
        L71:
            return;
        L40:
            if (r3.intValue() != 2) goto L56;
            LiveSearchSugAdapter r4 = r10.e;
            if (r4 == null) goto L44;
            r4.y2(new ArrayList(), "", "");
        L44:
            LiveSearchSugAdapter r5 = r10.e;
            if (r5 == null) goto L47;
            r5.notifyDataSetChanged();
        L47:
            RecyclerView r6 = r10.d;
            if (r6 == null) goto L50;
            r6.setAdapter(r10.e);
        L50:
            t r7 = r10.j;
            if (r7 == null) goto L68;
            String r12 = r10.h;
            Intrinsics.checkNotNullParameter(r12, "keyword");
            Disposable r13 = r7.a;
            if (r13 == null) goto L55;
            r13.dispose();
        L55:
            int r14 = r7.b + 1;
            r7.b = r14;
            r7.a = ((ObservableSubscribeProxy) ((ILiveSearchApi) com.bytedance.android.live.network.c.b().e(ILiveSearchApi.class)).getSugList("https://search.amemv.com/aweme/v1/search/sug/", r12, "live").compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r7.c))).subscribe(new u(r7, r12, r14), new v(r7));
            return;
        L68:
            return;
        L17:
            if (r3.intValue() != 1) goto L37;
            ((CopyOnWriteArrayList) r10.i.getValue()).clear();
            CopyOnWriteArrayList r15 = (CopyOnWriteArrayList) r10.i.getValue();
            f r16 = f.d;
            int r17 = ra1.c.a;
            r16.getClass();
            List r18 = f.a();
            ArrayList r19 = new ArrayList();
            Iterator<T> r20 = r18.iterator();
        L19:
            boolean r22 = false;
            if (r20.hasNext() == false) goto L26;
            T r23 = r20.next();
            if (((ra1.c) r23).getType() != 1) goto L24;
            r22 = true;
        L24:
            if (r22 == false) goto L19;
            r19.add(r23);
            goto L19
        L26:
            r15.addAll(CollectionsKt.toMutableList(r19));
            LiveSearchHistoryAdapter r24 = r10.f;
            if (r24 == null) goto L33;
            CopyOnWriteArrayList r25 = (CopyOnWriteArrayList) r10.i.getValue();
            ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
            Iterator<T> r27 = r25.iterator();
        L30:
            if (r27.hasNext() == false) goto L32;
            ra1.c r28 = (ra1.c) r27.next();
            int r29 = ra1.g.b;
            Intrinsics.checkNotNullParameter(r28, "history");
            ra1.g r30 = new ra1.g();
            r30.f();
            r30.e(r28.a());
            r26.add(r30);
            goto L30
        L32:
            List r32 = CollectionsKt.toMutableList(r26);
            Intrinsics.checkNotNullParameter(r32, "list");
            ((ArrayList) r24.a).clear();
            ArrayList r33 = (ArrayList) r24.a;
            r33.addAll(r32);
        L33:
            RecyclerView r34 = r10.d;
            if (r34 == null) goto L36;
            r34.setAdapter(r10.f);
        L36:
            int r35 = g.a;
            HashMap r36 = new HashMap();
            r36.put("action_type", "show");
            com.bytedance.android.livesdk.log.u.l().e("search_history", r36, new Object[0]);
            return;
        L12:
            r3 = null;
            goto L14
        }
    }

    @Override // com.bytedance.android.live.search.impl.search.t.a
    public final void H6() {
    }

    public final String getSpm() {
        return "a100.a217";
    }

    public LiveSearchIntermediateFragment() {
        this.h = "";
        this.i = LazyKt.lazy(LiveSearchIntermediateFragment$searchHistory$2.INSTANCE);
    }

    @Override // qa1.c
    public final void Dw(ra1.g r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        LiveSearchIntermediateViewModel r0 = this.g;
        if (r0 == null) goto L8;
        NextLiveData<String> r1 = r0.getInputValue();
        if (r1 == null) goto L9;
        r1.setValue(r2.a());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.search.impl.search.t.a
    public final void Xp(ra1.h r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        LiveSearchSugAdapter r0 = this.e;
        if (r0 == null) goto L8;
        List<ra1.g> r1 = r6.b();
        if (r1 != null) goto L7;
        r1 = new ArrayList();
    L7:
        r0.y2(r1, r6.a(), r6.a);
    L8:
        LiveSearchSugAdapter r2 = this.e;
        if (r2 == null) goto L11;
        r2.notifyDataSetChanged();
    L11:
        int r3 = g.a;
        String r4 = r6.a;
        String r5 = r6.a();
        List<ra1.g> r7 = r6.b();
        if (r7 == null) goto L14;
        int r8 = r7.size();
    L15:
        Intrinsics.checkNotNullParameter(r4, "keyword");
        Intrinsics.checkNotNullParameter(r5, "rid");
        HashMap r9 = new HashMap();
        r9.put("raw_query", r4);
        r9.put("query_id", r5);
        r9.put("words_num", String.valueOf(r8));
        r9.put("search_position", "live_square");
        r9.put("word_source", "sug");
        r9.put("rank", "-1");
        com.bytedance.android.livesdk.log.u.l().e("trending_show", r9, new Object[0]);
        return;
    L14:
        r8 = 0;
        goto L15
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L5;
        this.g = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r4).get(LiveSearchIntermediateViewModel.class);
        this.e = new LiveSearchSugAdapter(r4);
        this.j = new t(r4, this);
        this.f = new LiveSearchHistoryAdapter(r4);
    L5:
        LiveSearchIntermediateViewModel r5 = this.g;
        if (r5 == null) goto L10;
        NextLiveData<String> r6 = r5.getSearchKeyword();
        if (r6 == null) goto L10;
        r6.observe(this, new a(this));
    L10:
        LiveSearchIntermediateViewModel r7 = this.g;
        if (r7 == null) goto L16;
        NextLiveData<Integer> r8 = r7.getIntermediateState();
        if (r8 == null) goto L17;
        r8.observe(this, new b(this), true);
        return;
    L17:
        return;
    }

    @Override // qa1.c
    public final void BO(ra1.g r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        LiveSearchResultParam r5 = new LiveSearchResultParam();
        r5.setKeyword(r2.a());
        if (r2.d() == false) goto L5;
        String r6 = "search_history";
    L6:
        r5.setEnterMethod(r6);
        r5.setRankInList(r4);
        LiveSearchIntermediateViewModel r7 = this.g;
        if (r7 == null) goto L10;
        r7.openSearch(r5);
        return;
    L10:
        return;
    L5:
        r6 = "search_sug";
        goto L6
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = r4.inflate(2131567417, r5, false);
        View r8 = r7.findViewById(2131378459);
        ViewGroup r1 = (ViewGroup) r7.findViewById(2131384076);
        r8.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L5;
        boolean r2 = false;
    L6:
        if (r2 == false) goto L8;
        r8.setBackgroundColor(0);
    L8:
        RecyclerView r9 = r7.findViewById(2131384076);
        this.d = r9;
        if (r9 == null) goto L11;
        r9.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    L11:
        RecyclerView r10 = this.d;
        if (r10 == null) goto L14;
        r10.addItemDecoration(new SimpleItemDecoration(getResources().getDrawable(2131247573)));
    L14:
        RecyclerView r12 = this.d;
        if (r12 == null) goto L17;
        r12.addOnScrollListener(new LiveSearchIntermediateFragment$initView$1());
    L17:
        LiveSearchSugAdapter r13 = this.e;
        if (r13 == null) goto L20;
        Intrinsics.checkNotNullParameter(this, "handler");
        r13.d = this;
    L20:
        LiveSearchHistoryAdapter r14 = this.f;
        if (r14 == null) goto L23;
        Intrinsics.checkNotNullParameter(this, "handler");
        r14.c = this;
    L23:
        return r7;
    L5:
        r2 = e5.n();
        goto L6
    }
}
