package com.bytedance.android.livesdk.feed.squarefeed;

import am2.x;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.live.DislikeResult;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.squarefeed.adapter.OpenRankAdapter;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenRankViewModel;
import com.bytedance.android.livesdk.feed.ui.FeedTitleBar;
import com.bytedance.android.livesdk.feed.viewmodel.TimeOutRefreshViewModel;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/OpenRankFragment;", "Lcom/bytedance/android/livesdk/feed/squarefeed/BaseOpenFeedFragment;", "Lcom/bytedance/android/livesdk/feed/h;", "Lcom/bytedance/android/livesdk/feed/IFeedActionCallback;", "<init>", "()V", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenRankFragment extends BaseOpenFeedFragment implements com.bytedance.android.livesdk.feed.h, IFeedActionCallback {
    public static final /* synthetic */ int C = 0;
    public final Lazy A;
    public final Lazy B;
    public OpenFeedParams o;
    public final Lazy p;
    public com.bytedance.android.livesdk.feed.feed.e q;
    public OpenRankViewModel r;
    public final Lazy s;
    public OpenRankAdapter t;
    public FeedTitleBar u;
    public boolean v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ OpenRankFragment a;
        public final /* synthetic */ Room b;

        public b(OpenRankFragment r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            DislikeResult r8 = (DislikeResult) r7;
            OpenRankViewModel r9 = this.a.r;
            if (r9 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
        L5:
            r9.deleteItem((FeedDataKey) this.a.B.getValue(), String.valueOf(this.b.id));
            IESUIUtils.displayToast(this.a.getContext(), 2131916578);
            OpenRankFragment r10 = this.a;
            Room r0 = this.b;
            String r11 = r10.Sy();
            HashMap r1 = new HashMap();
            r1.put("enter_from_merge", r11);
            String r2 = "";
            r1.put("enter_method", "");
            r1.put("action_type", "click");
            String r4 = r0.getOwnerUserIdString();
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.put("anchor_id", r4);
            String r5 = String.valueOf(r0.getRoomId());
            if (r5 != null) goto L11;
            r5 = "";
        L11:
            r1.put("room_id", r5);
            r1.put("action_type", "click");
            String r12 = r0.getRequestId();
            if (r12 != null) goto L14;
            r12 = "";
        L14:
            r1.put("request_id", r12);
            String r13 = r0.getLog_pb();
            if (r13 != null) goto L17;
            r13 = "";
        L17:
            r1.put("log_pb", r13);
            String r14 = r0.getOwnerUserIdString();
            if (r14 == null) goto L21;
            r2 = r14;
        L21:
            r1.put("to_user_id", r2);
            r1.put("room_in_or_out", "out");
            r1.put("is_ad", "no_ad");
            u.l().sendLog("livesdk_dislike", r1, new Object[]{x.class, Room.class, am2.n.f()});
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ OpenRankFragment a;

        public c(OpenRankFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = this.a.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ OpenRankFragment a;

        public d(OpenRankFragment r1) {
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
        return (InterceptTouchLayout) this.w.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final ViewGroup V90() {
        return (ViewGroup) this.x.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final TextView W90() {
        return (TextView) this.A.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final int Y90() {
        return 2131565996;
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final BannerSwipeRefreshLayout Z90() {
        return (BannerSwipeRefreshLayout) this.y.getValue();
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String getEnterMethod() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final RecyclerView getRecyclerView() {
        return (RecyclerView) this.z.getValue();
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
    L6:
        if (r1 != null) goto L9;
    L10:
        return "homepage_hot";
    L9:
        if (i.a[r1.ordinal()] != 1) goto L10;
        return "homepage_follow";
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final HorFollowListParams X90() {
        return new HorFollowListParams.Builder().backgroundColor(LiveResUtil.getColor(2131107460)).build();
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
        if (r2 != FeedStyle.SIMPLE_LIST) goto L28;
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
    L28:
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

    public OpenRankFragment() {
        this.p = LazyKt.lazy(OpenRankFragment$mFeedTabRepository$2.INSTANCE);
        this.s = LazyKt.lazy(OpenRankFragment$dislikeRepository$2.INSTANCE);
        this.w = LazyKt.lazy(new OpenRankFragment$contentContainer$2(this));
        this.x = LazyKt.lazy(new OpenRankFragment$followListViewContainer$2(this));
        this.y = LazyKt.lazy(new OpenRankFragment$refreshLayout$2(this));
        this.z = LazyKt.lazy(new OpenRankFragment$recyclerView$2(this));
        this.A = LazyKt.lazy(new OpenRankFragment$followUserCount$2(this));
        this.B = LazyKt.lazy(new OpenRankFragment$feedDataKey$2(this));
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final String U90() {
        return Sy();
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String d40() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void initView(View r7) {
        Intrinsics.checkNotNullParameter(r7, "rootView");
        this.u = (FeedTitleBar) r7.findViewById(2131372258);
        View r8 = r7.findViewById(2131387768);
        if (r8 == null) goto L5;
        r8.setVisibility(8);
    L5:
        RecyclerView r9 = getRecyclerView();
        if (r9 == null) goto L8;
        GridLayoutManager r1 = new GridLayoutManager(getContext(), 2);
        r1.setSpanSizeLookup(new OpenRankFragment$getLayoutManager$1(this));
        r9.setLayoutManager(r1);
    L8:
        OpenRankAdapter r10 = this.t;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        Object[] r0 = new Object[2];
        r0[0] = (FeedDataKey) this.B.getValue();
        OpenRankViewModel r2 = this.r;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L14:
        r0[1] = r2.getFeedCache();
        ((SimplePagingAdapter) r10).b = r0;
        OpenRankAdapter r11 = this.t;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        OpenRankViewModel r3 = this.r;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L20:
        r11.setViewModel(r3);
        RecyclerView r12 = getRecyclerView();
        if (r12 == null) goto L26;
        OpenRankAdapter r4 = this.t;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L25:
        r12.setAdapter(r4);
    L26:
        RecyclerView r13 = getRecyclerView();
        if (r13 == null) goto L29;
        r13.addOnScrollListener(new AnonymousClass1());
    L29:
        RecyclerView r14 = getRecyclerView();
        if (r14 == null) goto L32;
        r14.addOnScrollListener(new AnonymousClass2(this));
    L32:
        OpenFeedParams r15 = this.o;
        if (r15 != null) goto L35;
    L39:
        ba0();
        return;
    L35:
        if (r15.getFeedStyle() != FeedStyle.SIMPLE_LIST) goto L39;
        RecyclerView r16 = getRecyclerView();
        if (r16 == null) goto L39;
        r16.setPadding(LiveResUtil.dp2Px(12.0f), 0, LiveResUtil.dp2Px(12.0f), 0);
        goto L39
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        OpenRankAdapter r3 = this.t;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r3.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        this.r = ViewModelProviders.of(this, new BaseOpenFeedFragment$createFeedVMFactory$1(this)).get(OpenRankViewModel.class);
        OpenFeedParams r0 = this.o;
        if (r0 == null) goto L6;
        FeedStyle r1 = r0.getFeedStyle();
        if (r1 == null) goto L6;
    L7:
        uw1.e r8 = new uw1.e(r1, this, (FeedDataKey) this.B.getValue(), this.d, this);
        OpenRankAdapter r2 = new OpenRankAdapter(r8.a(), r8.a);
        this.t = r2;
        r2.setSupportFooter(false);
        return;
    L6:
        r1 = FeedStyle.SIMPLE_LIST;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedActionCallback
    public final void WS(IFeedActionCallback.FeedAction r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "action");
        Intrinsics.checkNotNullParameter(r9, "param");
        if (r8 == IFeedActionCallback.FeedAction.DISLIKE_ROOM) goto L5;
        return;
    L5:
        if ((r9 instanceof Room) == false) goto L9;
        Room r10 = (Room) r9;
        Disposable r11 = ((tv1.c) this.s.getValue()).a(r10.id, r10.getOwnerUserIdString(), r10.getRequestId(), Sy(), "").observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r10), new c(this));
        CompositeDisposable r12 = this.k;
        Intrinsics.checkNotNull(r11);
        r12.add(r11);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.BaseOpenFeedFragment
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        OpenRankViewModel r12 = this.r;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L5:
        FeedDataKey r0 = (FeedDataKey) this.B.getValue();
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
        r12.fetch(r0, r6, r7, null);
        HorizontalLiveListView r15 = this.g;
        if (r15 == null) goto L30;
        r15.refresh();
    L30:
        OpenRankViewModel r16 = this.r;
        if (r16 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L33:
        if (r16 == null) goto L35;
        LiveData r17 = r16.refreshStat();
        OpenRankFragment$bindData$1$1 r18 = new OpenRankFragment$bindData$1$1(this);
        Intrinsics.checkNotNullParameter(this, "$this$observe");
        Intrinsics.checkNotNullParameter(r17, "liveData");
        Intrinsics.checkNotNullParameter(r18, "observer");
        r17.observe(this, new h(r18));
    L35:
        TimeOutRefreshViewModel r19 = this.l;
        if (r19 == null) goto L40;
        Observable<Object> r110 = r19.timeOutRefresh();
        if (r110 == null) goto L40;
        Disposable r111 = r110.subscribe(new j(this));
    L41:
        CompositeDisposable r20 = this.k;
        Intrinsics.checkNotNull(r111);
        r20.add(r111);
        BannerSwipeRefreshLayout r112 = Z90();
        if (r112 == null) goto L44;
        r112.setOnRefreshListener(new k(this));
    L44:
        OpenRankViewModel r113 = this.r;
        if (r113 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L47:
        if (r113 == null) goto L49;
        MutableLiveData<Integer> r114 = r113.getPos();
    L50:
        r114.observeForever(new l(this));
        OpenFeedParams r115 = this.o;
        if (r115 == null) goto L75;
        boolean r116 = true;
        if (r115.getEnableFeedTitle() != true) goto L75;
        ConstraintLayout r117 = this.u;
        if (r117 == null) goto L57;
        r117.setVisibility(0);
    L57:
        FeedTitleBar r118 = this.u;
        if (r118 == null) goto L72;
        OpenFeedParams r21 = this.o;
        if (r21 == null) goto L62;
        String r22 = r21.getFeedTitle();
    L63:
        OpenFeedParams r23 = this.o;
        if (r23 == null) goto L66;
        r2 = r23.getFeedBackIcon();
    L66:
        OpenFeedParams r24 = this.o;
        if (r24 == null) goto L71;
        Boolean r25 = r24.getEnableFeedBackIcon();
        if (r25 == null) goto L71;
        r116 = r25.booleanValue();
    L71:
        r118.R5(r22, r2, r116);
        goto L72
    L62:
        r22 = null;
    L72:
        FeedTitleBar r119 = this.u;
        if (r119 == null) goto L84;
        r119.setBackOnClickListener(new d(this));
        return;
    L84:
        return;
    L75:
        ConstraintLayout r120 = this.u;
        if (r120 == null) goto L78;
        r120.setVisibility(8);
    L78:
        View r121 = this.e;
        if (r121 == null) goto L86;
        View r122 = r121.findViewById(2131372237);
        if (r122 == null) goto L87;
        r122.setVisibility(8);
        return;
    L87:
        return;
    L86:
        return;
    L49:
        r114 = null;
    L40:
        r111 = null;
        goto L41
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
