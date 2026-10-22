package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.g0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.feed.adapter.FeedLiveAdapter;
import com.bytedance.android.livesdk.feed.openui.vm.FeedListViewModel;
import com.bytedance.android.livesdk.feed.ui.OpenItemDecoration;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.bytedance.android.livesdkapi.feed.ui.ILiveBlock;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mv1.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/LiveListBlock;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveBlock;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "a", "I", "getDefaultBg", "()I", "defaultBg", "Landroidx/lifecycle/LifecycleRegistry;", "b", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/bytedance/android/livesdk/feed/openui/vm/FeedListViewModel;", "c", "getFeedViewModel", "()Lcom/bytedance/android/livesdk/feed/openui/vm/FeedListViewModel;", "feedViewModel", "Lcom/bytedance/android/livesdk/feed/adapter/FeedLiveAdapter;", "f", "getAdapter", "()Lcom/bytedance/android/livesdk/feed/adapter/FeedLiveAdapter;", "adapter", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class LiveListBlock extends FrameLayout implements LifecycleOwnerCompat, ILiveBlock {
    public final int a;
    public final Lazy b;
    public final Lazy c;
    public final f d;
    public final MutableLiveData<Boolean> e;
    public final Lazy f;
    public final OpenFeedParams g;
    public HashMap h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ LiveListBlock a;

        public a(LiveListBlock r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            NetworkStat r3 = (NetworkStat) r2;
            if (r3 == null) goto L5;
            NetworkStat.Status r4 = r3.mStatus;
        L7:
            if (r4 != NetworkStat.Status.FAILED) goto L9;
            this.a.e.postValue(Boolean.TRUE);
            f2.b(2131916600, 0);
            return;
        L9:
            this.a.e.postValue(Boolean.FALSE);
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    private final FeedLiveAdapter getAdapter() {
        return (FeedLiveAdapter) this.f.getValue();
    }

    private final FeedListViewModel getFeedViewModel() {
        return (FeedListViewModel) this.c.getValue();
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.b.getValue();
    }

    public final View a(int r3) {
        if (this.h != null) goto L5;
        this.h = new HashMap();
    L5:
        View r0 = (View) this.h.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this.h.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final RecyclerView.ItemDecoration getItemDecoration() {
        FeedStyle r0 = this.g.getFeedStyle();
        if (r0 != null) goto L5;
        r0 = FeedStyle.DOUBLE_LIST_D;
    L5:
        int r1 = this.g.getFeedItemDecorationHorizontal();
        int r2 = this.g.getFeedItemDecorationVertical();
        int r3 = mw1.c.a;
        Intrinsics.checkNotNullParameter(r0, "feedStyle");
        int r4 = LiveResUtil.dp2Px(3.0f);
        int r5 = LiveResUtil.dp2Px(3.0f);
        if (r0 != FeedStyle.DOUBLE_LIST_D) goto L17;
        if (r1 != 0) goto L11;
        if (r2 != 0) goto L11;
        int r6 = r5;
    L15:
        int r7 = r4 / 2;
        return new OpenItemDecoration(r7, 0, r7, r6, 0);
    L11:
        if (r1 > 0) goto L14;
        r1 = r2;
    L14:
        r4 = r1;
        r6 = r4;
        goto L15
    L17:
        return new OpenItemDecoration(0, 0, 0, 0, 0);
    }

    private final RecyclerView.LayoutManager getLayoutManager() {
        GridLayoutManager r0 = new GridLayoutManager(getContext(), 2);
        r0.setSpanSizeLookup(new AnonymousClass1(this));
        return r0;
    }

    public final void refresh() {
        FeedType r0 = this.g.getFeedType();
        FeedType r1 = FeedType.FOLLOW_FEED;
        if (r0 != r1) goto L5;
        int r2 = g0.a;
        String r3 = g0.a.a(BubbleId.PadCastForVs);
    L6:
        LinkedHashMap r4 = new LinkedHashMap();
        if (this.g.getFeedType() != r1) goto L9;
        r4.put("content_type", 3);
    L10:
        final Ref.IntRef r5 = new Ref.IntRef();
        r5.element = 0;
        final int r6 = 4;
        getFeedViewModel().setDataFilter(new C04431(r6, r5));
        getFeedViewModel().fetch(r3, "homepage_follow-live_cover", r4);
        getFeedViewModel().networkStat().observe(this, new a(this));
        return;
    L9:
        r4.put("content_type", 0);
        goto L10
    L5:
        int r7 = g0.a;
        r3 = g0.a.a(BubbleId.LiveAdmin);
        goto L6
    }

    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    public final LiveData<Boolean> isEmpty() {
        return getFeedViewModel().listing().isEmpty();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().markState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        FeedLiveAdapter r0 = getAdapter();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.feed.f r1 = r0.e;
        if (r1 == null) goto L7;
        r1.b(this.d);
    L7:
        super.onDetachedFromWindow();
        getLifecycleRegistry().markState(Lifecycle.State.DESTROYED);
    }

    public final int getDefaultBg() {
        return this.a;
    }

    public final LiveData<Boolean> isError() {
        return this.e;
    }

    public static final /* synthetic */ FeedLiveAdapter b(LiveListBlock r0) {
        return r0.getAdapter();
    }

    public static final /* synthetic */ FeedListViewModel c(LiveListBlock r0) {
        return r0.getFeedViewModel();
    }

    public LiveListBlock(OpenFeedParams r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "feedParams");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.g = r4;
        this.a = -1;
        this.b = LazyKt.lazy(new LiveListBlock$lifecycleRegistry$2(this));
        new ArrayList();
        this.c = LazyKt.lazy(LiveListBlock$feedViewModel$2.INSTANCE);
        f r6 = new f(this);
        this.d = r6;
        this.e = new MutableLiveData();
        this.f = LazyKt.lazy(new LiveListBlock$adapter$2(this));
        getLifecycleRegistry().markState(Lifecycle.State.CREATED);
        FrameLayout.inflate(r5, 2131565963, this);
        a(2131384076).setAdapter(getAdapter());
        a(2131384076).setLayoutManager(getLayoutManager());
        a(2131384076).addItemDecoration(getItemDecoration());
        a(2131384076).setOnTouchListener(new d(this));
        ((LinearLayout) a(2131372260)).setOnClickListener(new e(this, r5));
        getAdapter().setViewModel(getFeedViewModel());
        getAdapter().H2(l.a);
        com.bytedance.android.livesdk.feed.f r7 = getAdapter().e;
        if (r7 == null) goto L6;
        r7.i(r6);
        return;
    }
}
