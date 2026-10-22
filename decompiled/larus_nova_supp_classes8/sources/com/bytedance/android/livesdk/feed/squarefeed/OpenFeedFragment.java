package com.bytedance.android.livesdk.feed.squarefeed;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.squarefeed.adapter.OpenFeedAdapter;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenFeedViewModel;
import com.bytedance.android.livesdk.feed.ui.FeedTitleBar;
import com.bytedance.android.livesdk.feed.viewmodel.TimeOutRefreshViewModel;
import com.bytedance.android.livesdkapi.feed.constant.FeedChannel;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/OpenFeedFragment;", "Lcom/bytedance/android/livesdk/feed/squarefeed/BaseOpenFeedFragment;", "Lcom/bytedance/android/livesdk/feed/h;", "Lcom/bytedance/android/livesdk/feed/IFeedActionCallback;", "<init>", "()V", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenFeedFragment extends BaseOpenFeedFragment implements com.bytedance.android.livesdk.feed.h, IFeedActionCallback {
    public static final /* synthetic */ int C = 0;
    public final Lazy A;
    public final b B;
    public OpenFeedParams o;
    public final Lazy p;
    public com.bytedance.android.livesdk.feed.feed.e q;
    public OpenFeedViewModel r;
    public OpenFeedAdapter s;
    public FeedTitleBar t;
    public boolean u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OpenFeedFragment a;

        public b(OpenFeedFragment r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.isResumed() == true) goto L5;
            return;
        L5:
            if (this.a.getUserVisibleHint() == false) goto L23;
            RecyclerView r0 = this.a.getRecyclerView();
            if (r0 == null) goto L11;
            RecyclerView.Adapter r1 = r0.getAdapter();
            if (r1 == null) goto L11;
            Integer r2 = Integer.valueOf(r1.getItemCount());
        L12:
            if (r2 == null) goto L24;
            RecyclerView r3 = this.a.getRecyclerView();
            if (r3 == null) goto L20;
            RecyclerView.Adapter r4 = r3.getAdapter();
            if (r4 == null) goto L20;
            if (r4.getItemCount() != 0) goto L20;
            return;
        L20:
            this.a.getClass();
            return;
        L24:
            return;
        L11:
            r2 = null;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OpenFeedFragment a;

        public c(OpenFeedFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            FragmentActivity r2 = this.a.getActivity();
            if (r2 == null) goto L6;
            r2.finish();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.squarefeed.OpenFeedFragment$initView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/feed/squarefeed/OpenFeedFragment$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends RecyclerView.OnScrollListener {
        public AnonymousClass2() {
            throw null;
        }

        public final void onScrollStateChanged(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            super.onScrollStateChanged(r2, r3);
            if (r3 == 0) goto L5;
            return;
        L5:
            int r4 = OpenFeedFragment.C;
            throw null;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final /* synthetic */ Map DN() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void S90() {
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final InterceptTouchLayout T90() {
        return (InterceptTouchLayout) this.v.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final ViewGroup V90() {
        return (ViewGroup) this.w.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final TextView W90() {
        return (TextView) this.z.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedActionCallback
    public final void WS(IFeedActionCallback.FeedAction r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "param");
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final int Y90() {
        return 2131565996;
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final BannerSwipeRefreshLayout Z90() {
        return (BannerSwipeRefreshLayout) this.x.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String getEnterMethod() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final RecyclerView getRecyclerView() {
        return (RecyclerView) this.y.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final int wY() {
        return 2131566261;
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final boolean Ay() {
        OpenFeedParams r0 = this.o;
        if (r0 == null) goto L5;
        FeedStyle r1 = r0.getFeedStyle();
    L7:
        if (r1 != FeedStyle.DOUBLE_LIST_D) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String Sy() {
        OpenFeedParams r0 = this.o;
        if (r0 == null) goto L5;
        FeedType r1 = r0.getFeedType();
    L7:
        if (r1 != FeedType.FOLLOW_FEED) goto L10;
        return "homepage_follow";
    L10:
        OpenFeedParams r2 = this.o;
        if (r2 != null) goto L13;
        return "live_channel";
    L13:
        if (TextUtils.isEmpty(r2.getChannelName()) == false) goto L15;
        return "live_channel";
    L15:
        if (Intrinsics.areEqual(FeedChannel.DEFAULT.getChannelName(), r2.getChannelName()) == false) goto L18;
        return "live_channel";
    L18:
        return "live_channel_" + r2.getChannelName();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final HorFollowListParams X90() {
        return new HorFollowListParams.Builder(Sy()).backgroundColor(LiveResUtil.getColor(2131107460)).build();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final long aa0() {
        return ((Number) LiveFeedSettings.MAIN_REFRESH_TIME_OUT.getValue()).intValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final boolean ca0() {
        OpenFeedParams r0 = this.o;
        if (r0 == null) goto L5;
        Boolean r1 = r0.getSupportFollowListInFeed();
    L7:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L7
    }

    public final void ea0() {
        if (this.i == true) goto L5;
        return;
    L5:
        if (getRecyclerView() == null) goto L27;
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L26;
        r0.removeCallbacks(this.B);
        GridLayoutManager r1 = r0.getLayoutManager();
        if (r1 == null) goto L20;
        GridLayoutManager r2 = r1;
        int r3 = r2.findFirstVisibleItemPosition();
        int r4 = r2.findLastVisibleItemPosition() + 1;
    L12:
        if (r3 >= r4) goto L28;
        ww1.k r5 = r0.findViewHolderForAdapterPosition(r3);
        if (r5 == null) goto L18;
        if ((r5 instanceof ww1.k) == false) goto L18;
        r5.stopPreview();
    L18:
        r3 = r3 + 1;
        goto L12
    L28:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final FeedType getFeedType() {
        OpenFeedParams r0 = this.o;
        if (r0 == null) goto L7;
        FeedType r1 = r0.getFeedType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return FeedType.COMMON_FEED;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final LiveCoverConfig kG() {
        OpenFeedParams r0 = this.o;
        Integer r1 = null;
        if (r0 == null) goto L5;
        FeedStyle r2 = r0.getFeedStyle();
    L7:
        if (r2 != FeedStyle.SIMPLE_LIST) goto L27;
        OpenFeedParams r3 = this.o;
        Intrinsics.checkNotNull(r3);
        boolean r4 = r3.getEnableContentLabel();
        OpenFeedParams r5 = this.o;
        if (r5 == null) goto L11;
        FeedType r6 = r5.getFeedType();
    L12:
        boolean r7 = true;
        if (r6 != FeedType.HOT_FEED) goto L15;
        boolean r8 = true;
    L16:
        OpenFeedParams r9 = this.o;
        if (r9 != null) goto L19;
    L21:
        r7 = false;
    L22:
        mw1.b r10 = new mw1.b(r4, r8, r7, 29);
        OpenFeedParams r11 = this.o;
        if (r11 == null) goto L25;
        r1 = r11.getLiveTagColor();
    L25:
        r10.a = r1;
        return r10;
    L19:
        if (r9.getEnableFeedTitle() == true) goto L21;
    L15:
        r8 = false;
        goto L16
    L11:
        r6 = null;
        goto L12
    L27:
        return new LiveCoverConfig(false, false, false, 7, null);
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final com.bytedance.android.livesdk.feed.feed.e wg() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new com.bytedance.android.livesdk.feed.feed.e();
    }

    public OpenFeedFragment() {
        this.p = LazyKt.lazy(OpenFeedFragment$mFeedTabRepository$2.INSTANCE);
        this.v = LazyKt.lazy(new OpenFeedFragment$contentContainer$2(this));
        this.w = LazyKt.lazy(new OpenFeedFragment$followListViewContainer$2(this));
        this.x = LazyKt.lazy(new OpenFeedFragment$refreshLayout$2(this));
        this.y = LazyKt.lazy(new OpenFeedFragment$recyclerView$2(this));
        this.z = LazyKt.lazy(new OpenFeedFragment$followUserCount$2(this));
        this.A = LazyKt.lazy(new OpenFeedFragment$feedDataKey$2(this));
        this.B = new b(this);
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final String U90() {
        return Sy();
    }

    public final void da0() {
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.B);
    L5:
        RecyclerView r1 = getRecyclerView();
        if (r1 == null) goto L9;
        r1.postDelayed(this.B, 1000);
        return;
    }

    public final void onPause() {
        super.onPause();
        ea0();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void onResume() {
        super.onResume();
        da0();
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String d40() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void initView(View r8) {
        Intrinsics.checkNotNullParameter(r8, "rootView");
        this.t = (FeedTitleBar) r8.findViewById(2131372258);
        View r9 = r8.findViewById(2131387768);
        if (r9 == null) goto L5;
        r9.setVisibility(8);
    L5:
        RecyclerView r10 = getRecyclerView();
        if (r10 == null) goto L8;
        GridLayoutManager r1 = new GridLayoutManager(getContext(), 2);
        r1.setSpanSizeLookup(new OpenFeedFragment$getLayoutManager$1(this));
        r10.setLayoutManager(r1);
    L8:
        OpenFeedAdapter r11 = this.s;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        FeedDataKey r2 = (FeedDataKey) this.A.getValue();
        OpenFeedViewModel r3 = this.r;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
    L14:
        com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> r4 = r3.getFeedCache();
        r11.d = r2;
        r11.e = r4;
        ((SimplePagingAdapter) r11).b = new Object[]{r11.j, r11.k, r11.l, r11.m, r11.n};
        OpenFeedAdapter r12 = this.s;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        OpenFeedViewModel r0 = this.r;
        if (r0 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
    L20:
        r12.setViewModel(r0);
        RecyclerView r13 = getRecyclerView();
        if (r13 == null) goto L26;
        OpenFeedAdapter r5 = this.s;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L25:
        r13.setAdapter(r5);
    L26:
        RecyclerView r14 = getRecyclerView();
        if (r14 == null) goto L29;
        r14.addOnScrollListener(new AnonymousClass1(this));
    L29:
        OpenFeedParams r15 = this.o;
        if (r15 != null) goto L32;
    L36:
        ba0();
        return;
    L32:
        if (r15.getFeedStyle() != FeedStyle.SIMPLE_LIST) goto L36;
        RecyclerView r16 = getRecyclerView();
        if (r16 == null) goto L36;
        r16.setPadding(LiveResUtil.dp2Px(12.0f), 0, LiveResUtil.dp2Px(12.0f), 0);
        goto L36
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        OpenFeedAdapter r3 = this.s;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r3.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        this.r = ViewModelProviders.of(this, new BaseOpenFeedFragment$createFeedVMFactory$1(this)).get(OpenFeedViewModel.class);
        OpenFeedParams r0 = this.o;
        if (r0 == null) goto L6;
        FeedStyle r1 = r0.getFeedStyle();
        if (r1 == null) goto L6;
    L7:
        uw1.e r8 = new uw1.e(r1, this, (FeedDataKey) this.A.getValue(), this.d, this);
        this.s = new OpenFeedAdapter(r8.a(), r8.a);
        return;
    L6:
        r1 = FeedStyle.SIMPLE_LIST;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == false) goto L5;
        da0();
        return;
    L5:
        ea0();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        OpenFeedViewModel r12 = this.r;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
    L5:
        FeedDataKey r0 = (FeedDataKey) this.A.getValue();
        OpenFeedParams r1 = this.o;
        Drawable r2 = null;
        if (r1 == null) goto L8;
        FeedStyle r3 = r1.getFeedStyle();
    L9:
        FeedStyle r4 = FeedStyle.SIMPLE_LIST;
        if (r3 != r4) goto L12;
        String r5 = "main_tab";
    L13:
        String r6 = Sy() + '-' + r5;
        LinkedHashMap r7 = new LinkedHashMap();
        OpenFeedParams r8 = this.o;
        if (r8 == null) goto L16;
        FeedType r9 = r8.getFeedType();
    L18:
        if (r9 != FeedType.FOLLOW_FEED) goto L20;
        r7.put("content_type", 3);
    L21:
        OpenFeedParams r13 = this.o;
        if (r13 == null) goto L24;
        FeedStyle r14 = r13.getFeedStyle();
    L25:
        if (r14 != r4) goto L27;
        r7.put("style", Integer.valueOf(FeedApi.Style.RANK.getStyleValue()));
    L27:
        OpenFeedParams r15 = this.o;
        boolean r16 = true;
        if (r15 == null) goto L37;
        String r17 = r15.getChannelName();
        if (r17 == null) goto L37;
        if (r17.length() <= 0) goto L34;
        boolean r18 = true;
    L35:
        if (r18 != true) goto L37;
        OpenFeedParams r19 = this.o;
        Intrinsics.checkNotNull(r19);
        String r20 = r19.getChannelName();
        Intrinsics.checkNotNull(r20);
        r7.put("channel_name", r20);
        goto L37
    L34:
        r18 = false;
    L37:
        r12.fetch(r0, r6, r7, null);
        HorizontalLiveListView r110 = this.g;
        if (r110 == null) goto L40;
        r110.refresh();
    L40:
        OpenFeedViewModel r111 = this.r;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
    L43:
        if (r111 == null) goto L45;
        LiveData r112 = r111.refreshStat();
        OpenFeedFragment$bindData$1$1 r113 = new OpenFeedFragment$bindData$1$1(this);
        Intrinsics.checkNotNullParameter(this, "$this$observe");
        Intrinsics.checkNotNullParameter(r112, "liveData");
        Intrinsics.checkNotNullParameter(r113, "observer");
        r112.observe(this, new h(r113));
    L45:
        TimeOutRefreshViewModel r114 = this.l;
        if (r114 == null) goto L50;
        Observable<Object> r115 = r114.timeOutRefresh();
        if (r115 == null) goto L50;
        Disposable r116 = r115.subscribe(new f(this));
    L51:
        CompositeDisposable r117 = this.k;
        Intrinsics.checkNotNull(r116);
        r117.add(r116);
        BannerSwipeRefreshLayout r118 = Z90();
        if (r118 == null) goto L54;
        r118.setOnRefreshListener(new g(this));
    L54:
        OpenFeedParams r119 = this.o;
        if (r119 != null) goto L57;
    L79:
        ConstraintLayout r120 = this.t;
        if (r120 == null) goto L82;
        r120.setVisibility(8);
    L82:
        View r121 = this.e;
        if (r121 == null) goto L90;
        View r122 = r121.findViewById(2131372237);
        if (r122 == null) goto L91;
        r122.setVisibility(8);
        return;
    L91:
        return;
    L90:
        return;
    L57:
        if (r119.getEnableFeedTitle() != true) goto L79;
        ConstraintLayout r123 = this.t;
        if (r123 == null) goto L61;
        r123.setVisibility(0);
    L61:
        FeedTitleBar r124 = this.t;
        if (r124 == null) goto L76;
        OpenFeedParams r125 = this.o;
        if (r125 == null) goto L66;
        String r126 = r125.getFeedTitle();
    L67:
        OpenFeedParams r21 = this.o;
        if (r21 == null) goto L70;
        r2 = r21.getFeedBackIcon();
    L70:
        OpenFeedParams r22 = this.o;
        if (r22 == null) goto L75;
        Boolean r23 = r22.getEnableFeedBackIcon();
        if (r23 == null) goto L75;
        r16 = r23.booleanValue();
    L75:
        r124.R5(r126, r2, r16);
        goto L76
    L66:
        r126 = null;
    L76:
        FeedTitleBar r127 = this.t;
        if (r127 == null) goto L88;
        r127.setBackOnClickListener(new c(this));
        return;
    L88:
        return;
    L50:
        r116 = null;
        goto L51
    L24:
        r14 = null;
        goto L25
    L20:
        r7.put("content_type", 0);
        goto L21
    L16:
        r9 = null;
        goto L18
    L12:
        r5 = "";
        goto L13
    L8:
        r3 = null;
        goto L9
    }
}
