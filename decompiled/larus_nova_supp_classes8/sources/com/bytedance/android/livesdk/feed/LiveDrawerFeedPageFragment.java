package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.config.a41;
import com.bytedance.android.livesdk.config.d00;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.config.lp;
import com.bytedance.android.livesdk.feed.drawer.preload.PreloadHelper;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.tab.viewmodel.FeedTabViewModelFactory;
import com.bytedance.android.livesdk.feed.viewmodel.FeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.MultiFeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.ILiveDrawerMultiTabView;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.LiveDrawerUrlHelper;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerFeedPageFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lqv1/a;", "Lcom/bytedance/android/livesdkapi/ILiveDrawerMultiTabView;", "<init>", "()V", "a", "b", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerFeedPageFragment extends BaseFragment implements qv1.a, ILiveDrawerMultiTabView {
    public static boolean G;
    public static final a H = null;
    public final Keva A;
    public ImageView B;
    public ImageView C;
    public ImageView D;
    public yo2.e E;
    public final String F;
    public SSViewPager d;
    public LiveDrawerPagerSlidingTabStrip e;
    public LiveDrawerTabScrollShadow f;
    public LiveDrawerPageAdapter g;
    public DouyinLoadingLayout h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public ViewGroup n;
    public TextView o;
    public ImageView p;
    public long q;
    public FeedTabViewModel r;
    public final CompositeDisposable s;
    public boolean t;
    public LiveDrawerTabViewModel u;
    public int v;
    public int w;
    public IDrawerFeedAction x;
    public boolean y;
    public final String z;

    public static final class a {
        public a() {
        }

        public static void a(long r3) {
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.b2;
            ((Map) r0.getValue()).put("show_times", Long.valueOf(r3));
            ((Map) r0.getValue()).put("last_show_time", Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static final class b implements ILiveDrawerLayoutInterceptor {
        public float a;
        public float b;
        public final int c;
        public final View d;
        public final ViewPager e;

        public final boolean onInterceptTouchEvent(MotionEvent r10) {
            if (r10 != null) goto L41;
            return false;
        L41:
            float r2 = r10.getRawX();     // Catch: IllegalArgumentException -> L38
            float r3 = r10.getRawY();     // Catch: IllegalArgumentException -> L38
            int r11 = r10.getAction();     // Catch: IllegalArgumentException -> L38
            if (r11 != 0) goto L9;
            this.a = r2;     // Catch: IllegalArgumentException -> L38
            this.b = r3;     // Catch: IllegalArgumentException -> L38
        L40:
            return true;
        L9:
            if (r11 != 2) goto L40;
            View r12 = this.d;     // Catch: IllegalArgumentException -> L38
            int r5 = (int) r2;     // Catch: IllegalArgumentException -> L38
            int r6 = (int) r3;     // Catch: IllegalArgumentException -> L38
            if (r12 == null) goto L21;
            int[] r4 = new int[2];     // Catch: IllegalArgumentException -> L38
            r12.getLocationOnScreen(r4);     // Catch: IllegalArgumentException -> L38
            int r7 = r4[0];     // Catch: IllegalArgumentException -> L38
            int r8 = r4[1];     // Catch: IllegalArgumentException -> L38
            int r9 = r12.getMeasuredWidth() + r7;     // Catch: IllegalArgumentException -> L38
            int r13 = r12.getMeasuredHeight() + r8;     // Catch: IllegalArgumentException -> L38
            if (r8 > r6) goto L21;
            if (r13 < r6) goto L21;
            if (r5 < r7) goto L21;
            if (r5 > r9) goto L21;
            boolean r14 = true;
        L22:
            if (r14 == true) goto L24;
            return false;
        L24:
            float r15 = this.a;     // Catch: IllegalArgumentException -> L38
            if (r2 >= r15) goto L27;
            return true;
        L27:
            float r16 = Math.abs(r2 - r15);     // Catch: IllegalArgumentException -> L38
            float r17 = Math.abs(r3 - this.b);     // Catch: IllegalArgumentException -> L38
            float r18 = (r16 * r16) + (r17 * r17);     // Catch: IllegalArgumentException -> L38
            int r19 = this.c;     // Catch: IllegalArgumentException -> L38
            if (r18 <= (r19 * r19)) goto L30;
            boolean r110 = true;
        L31:
            if (r110 == true) goto L33;
        L34:
            return true;
        L33:
            if (this.e.getCurrentItem() != 0) goto L34;
            return false;
        L30:
            r110 = false;
        L21:
            r14 = false;
        L38:
            e = move-exception;
            e.printStackTrace();
            goto L40
        }

        public b(View r2, SSViewPager r3, LiveDrawerFeedPageFragment r4) {
            Intrinsics.checkNotNullParameter(r3, "viewPage");
            Intrinsics.checkNotNullParameter(r4, "baseFragment");
            this.d = r2;
            this.e = r3;
            this.c = ViewConfiguration.get(jc1.a.b()).getScaledTouchSlop();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveDrawerFeedPageFragment a;

        public c(LiveDrawerFeedPageFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            uv1.e r3 = (uv1.e) r2;
            Intrinsics.checkNotNullParameter(r3, "liveDrawerActionEvent");
            int r4 = r3.a;
            if (r4 != 0) goto L5;
            IDrawerFeedAction r5 = this.a.x;
            if (r5 == null) goto L16;
            r5.closeDrawerDialog();
            return;
        L16:
            return;
        L5:
            if (r4 != 1) goto L17;
            IDrawerFeedAction r6 = this.a.x;
            if (r6 == null) goto L14;
            r6.disableDrawerSlide();
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveDrawerFeedPageFragment a;

        public d(LiveDrawerFeedPageFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            yv1.a r6 = (yv1.a) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            if (r6.a == 0) goto L6;
            this.a.t = true;
            return;
        }
    }

    public final String getSpm() {
        return "a100.a207";
    }

    static {
        H = new a();
    }

    @Override // qv1.a
    public final void DP() {
        if (G == false) goto L10;
        ImageView r0 = this.p;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        TextView r1 = this.o;
        if (r1 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r1);
        return;
    L17:
        return;
    L10:
        ImageView r2 = this.p;
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r2);
    L13:
        TextView r3 = this.o;
        if (r3 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    }

    @Override // qv1.a
    public final void P20() {
        ImageView r0 = this.p;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r0);
        return;
    }

    public final void dismissPopView() {
        yo2.d r0 = this.E;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.d();
        return;
    }

    public final void onLeave() {
        LiveDrawerTabViewModel r0 = this.u;
        if (r0 == null) goto L52;
        LiveDrawerTabViewModel.a r1 = new LiveDrawerTabViewModel.a();
        FeedTabViewModel r2 = this.r;
        long r3 = -1;
        int r5 = 0;
        Fragment r6 = null;
        if (r2 == null) goto L17;
        List<com.bytedance.android.livesdk.feed.feed.e> r4 = r2.getAllTabs();
        if (r4 == null) goto L17;
        int r7 = r4.size();
        int r8 = this.v;
        if (r7 <= r8) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        long r10 = ((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r4, r8)).f();
    L18:
        r1.a = r10;
        LiveDrawerPageAdapter r11 = this.g;
        if (r11 == null) goto L21;
        Fragment r12 = r11.getItem(this.v);
    L23:
        if ((r12 instanceof LiveDrawerFeedCategoryFragment) == true) goto L25;
        r12 = null;
    L25:
        LiveDrawerFeedCategoryFragment r13 = (LiveDrawerFeedCategoryFragment) r12;
        if (r13 == null) goto L28;
        int r14 = r13.C;
    L29:
        r1.b = r14;
        LiveDrawerPageAdapter r15 = this.g;
        if (r15 == null) goto L32;
        Fragment r16 = r15.getItem(this.v);
    L34:
        if ((r16 instanceof LiveDrawerFeedCategoryFragment) == true) goto L36;
        r16 = null;
    L36:
        LiveDrawerFeedCategoryFragment r17 = (LiveDrawerFeedCategoryFragment) r16;
        if (r17 == null) goto L39;
        r5 = r17.B;
    L39:
        r1.c = r5;
        LiveDrawerPageAdapter r18 = this.g;
        if (r18 == null) goto L42;
        Fragment r19 = r18.getItem(this.v);
    L44:
        if ((r19 instanceof LiveDrawerFeedCategoryFragment) == false) goto L47;
        r6 = r19;
    L47:
        LiveDrawerFeedCategoryFragment r20 = (LiveDrawerFeedCategoryFragment) r6;
        if (r20 == null) goto L50;
        r3 = r20.D;
    L50:
        r1.d = r3;
        Unit r21 = Unit.INSTANCE;
        r0.setTabStatus(r1);
        return;
    L42:
        r19 = null;
        goto L44
    L32:
        r16 = null;
        goto L34
    L28:
        r14 = 0;
        goto L29
    L21:
        r12 = null;
        goto L23
    L11:
        r9 = false;
    L17:
        r10 = -1;
        goto L18
    }

    public final void showPopView() {
        View r1 = this.l;
        if (r1 != null) goto L5;
        return;
    L5:
        Context r0 = getContext();
        if (r0 != null) goto L9;
        return;
    L9:
        if (gp.a.getValue().c() == false) goto L11;
        return;
    L11:
        d00 r2 = d00.a;
        if (r2 == null) goto L36;
        a41 r3 = r2.getValue();
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.a() != true) goto L38;
        Keva r4 = this.A;
        if (r4 != null) goto L21;
    L23:
        this.A.storeBoolean(this.F, true);
        String r7 = null;
        View r5 = LayoutInflater.from(r0).inflate(2131566857, null);
        if (r5 == null) goto L26;
        TextView r6 = (TextView) r5.findViewById(2131388367);
    L27:
        if (r6 == null) goto L34;
        a41 r8 = r2.getValue();
        if (r8 == null) goto L32;
        r7 = r8.b();
    L32:
        if (TextUtils.isEmpty(r7) == true) goto L34;
        r6.setText(r2.getValue().b());
    L34:
        yo2.e r9 = new yo2.e(r0);
        int r10 = (int) UIUtils.dip2Px(r0, 141.0f);
        int r11 = (int) UIUtils.dip2Px(r0, 49.0f);
        ((yo2.d) r9).d = r5;
        ((yo2.d) r9).e = 0;
        ((yo2.d) r9).h = r10;
        ((yo2.d) r9).i = r11;
        ((yo2.d) r9).m = 50;
        ((yo2.d) r9).l = true;
        ((yo2.d) r9).g = false;
        r9.a();
        this.E = r9;
        r9.i(r1, 2, 4, 0, 0);
        return;
    L26:
        r6 = null;
        goto L27
    L21:
        if (r4.getBoolean(this.F, false) == false) goto L23;
        return;
    L38:
        return;
    }

    public LiveDrawerFeedPageFragment() {
        this.s = new CompositeDisposable();
        this.z = "yellow_keva";
        this.A = Keva.getRepo("draw_history", 0);
        this.F = "pop_guide";
        boolean r0 = x0.d;
        x0.a.a();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.s.clear();
        IDrawerFeedAction r0 = this.x;
        if (r0 == null) goto L6;
        r0.setInterceptor(null);
        return;
    }

    public final void onResume() {
        super.onResume();
        ILiveService r0 = jc1.k.f(ILiveService.class);
        Intrinsics.checkNotNull(r0);
        r0.unMuteLivePlayer();
        SSViewPager r1 = this.d;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getCurrentItem();
    L6:
        FeedTabViewModel r4 = this.r;
        if (r4 == null) goto L11;
        List<com.bytedance.android.livesdk.feed.feed.e> r5 = r4.getAllTabs();
        if (r5 == null) goto L11;
        int r6 = r5.size();
    L12:
        if (r3 >= r6) goto L24;
        FeedTabViewModel r7 = this.r;
        if (r7 == null) goto L18;
        List<com.bytedance.android.livesdk.feed.feed.e> r8 = r7.getAllTabs();
        if (r8 == null) goto L18;
        com.bytedance.android.livesdk.feed.feed.e r9 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r8, r3);
    L19:
        IDrawerFeedAction r10 = this.x;
        if (r10 == null) goto L24;
        if (r9 == null) goto L23;
        r2 = r9.getType();
    L23:
        r10.setBackgroundByTabType(r2);
    L18:
        r9 = null;
    L24:
        DP();
        return;
    L11:
        r6 = 0;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        onLeave();
    }

    public static final void S90(LiveDrawerFeedPageFragment r10) {
        r10.getClass();
        if ((System.currentTimeMillis() - r10.q) <= 3000) goto L22;
        com.bytedance.android.livesdk.log.u.l().a(1);
        r10.q = System.currentTimeMillis();
        if (TTLiveSDK.hostService().user().isLogin() == true) goto L17;
        TTLiveSDK.hostService().user().login(r10.getActivity(), new m0(r10), "", "", 0, "", "", "");
        return;
    L17:
    L14:
        e = move-exception;
        ILiveService r0 = jc1.k.f(ILiveService.class);
        Intrinsics.checkNotNull(r0);
        r0.unMuteLivePlayer();
        e.printStackTrace();
        return;
    L9:
        if (r10.getContext() == null) goto L20;
        ILiveService r1 = jc1.k.f(ILiveService.class);     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L14
        r1.muteLivePlayer();     // Catch: Exception -> L14
        ILiveActionHandler r2 = jc1.k.f(ILiveActionHandler.class);     // Catch: Exception -> L14
        if (r2 == null) goto L21;
        r2.handle(r10.getContext(), "sslocal://webcast_open_live");     // Catch: Exception -> L14
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Disposable r4 = ((ObservableSubscribeProxy) xs2.b.a().b(uv1.e.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new c(this));
        Disposable r0 = ((ObservableSubscribeProxy) xs2.b.a().b(yv1.a.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new d(this));
        this.s.add(r4);
        this.s.add(r0);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L11;
        TabFeedViewModel r1 = PreloadHelper.a;
        if (r5.hashCode() != PreloadHelper.e) goto L7;
        LiveDrawerTabViewModel r2 = PreloadHelper.b;
    L8:
        this.u = r2;
        if (r2 != null) goto L11;
        this.u = (LiveDrawerTabViewModel) ViewModelProviders.of(r5).get(LiveDrawerTabViewModel.class);
        goto L11
    L7:
        r2 = null;
    L11:
        Bundle r6 = getArguments();
        if (r6 == null) goto L18;
        h0.m = r6.getLong("drawer_enter_time");
        String r7 = r6.getString("pull_type");
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        h0.a.a(r7);
        this.y = r6.getBoolean("live_drawer_support_search", false);
        return;
    }

    @Override // qv1.a
    public final void scrollToTop(boolean r2) {
        IDrawerFeedAction r0 = this.x;
        if (r0 == null) goto L6;
        r0.scrollToTop(r2);
        return;
    }

    public final void setUserVisibleHint(boolean r1) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r1);
        if (r1 == true) goto L6;
        onLeave();
        return;
    }

    public final void showLoading(boolean r2) {
        if (r2 == false) goto L9;
        DouyinLoadingLayout r3 = this.h;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
    L6:
        DouyinLoadingLayout r4 = this.h;
        if (r4 == null) goto L16;
        r4.b();
        return;
    L16:
        return;
    L9:
        DouyinLoadingLayout r5 = this.h;
        if (r5 == null) goto L12;
        r5.setVisibility(8);
    L12:
        DouyinLoadingLayout r6 = this.h;
        if (r6 == null) goto L18;
        r6.c();
        return;
    }

    @Override // qv1.a
    public final void C(RecyclerView r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        if (this.t == false) goto L6;
        xs2.b.a().post(new yv1.a(0));
        this.t = false;
    L6:
        if (G == false) goto L12;
        if (r6 != 0) goto L13;
        ImageView r7 = this.p;
        if (r7 == null) goto L14;
        r7.setVisibility(0);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void T90(View r3, int r4, int r5) {
        if (r3 == null) goto L11;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r4 != (-1)) goto L6;
        r4 = r0.width;
    L6:
        r0.width = r4;
        if (r5 != (-1)) goto L9;
        r5 = r0.height;
    L9:
        r0.height = r5;
        r3.setLayoutParams(r0);
        return;
    }

    public final View onCreateView(LayoutInflater r21, ViewGroup r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r21, "inflater");
        View r8 = r21.inflate(2131565969, r22, false);
        this.i = r8;
        this.d = r8.findViewById(2131392567);
        this.f = (LiveDrawerTabScrollShadow) r8.findViewById(2131381818);
        this.n = (ViewGroup) r8.findViewById(2131389093);
        this.e = (LiveDrawerPagerSlidingTabStrip) r8.findViewById(2131381819);
        View r0 = r8.findViewById(2131363779);
        this.j = r0;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.l = r8.findViewById(2131374393);
        this.m = r8.findViewById(2131393414);
        View r1 = r8.findViewById(2131385505);
        this.k = r1;
        if (r1 != null) goto L8;
    L12:
        SSViewPager r2 = this.d;
        if (r2 == null) goto L17;
        IDrawerFeedAction r3 = this.x;
        if (r3 == null) goto L17;
        r3.setInterceptor(new b(this.i, r2, this));
    L17:
        this.B = (ImageView) r8.findViewById(2131375189);
        this.C = (ImageView) r8.findViewById(2131375191);
        this.D = (ImageView) r8.findViewById(2131374403);
        this.h = (DouyinLoadingLayout) r8.findViewById(2131379091);
        if (Intrinsics.areEqual(lp.a.getValue(), Boolean.TRUE) == true) goto L20;
    L38:
        View r4 = this.l;
        if (r4 == null) goto L41;
        r4.setVisibility(8);
    L41:
        View r5 = this.m;
        if (r5 == null) goto L44;
        r5.setVisibility(8);
    L44:
        this.g = new LiveDrawerPageAdapter(getChildFragmentManager(), this.x, this.u, this, this);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L47;
        boolean r7 = x0.d;
        this.r = ViewModelProviders.of(r6, new FeedTabViewModelFactory(x0.a.a(), new n(), com.bytedance.android.livesdk.feed.services.d.b())).get(MultiFeedTabViewModel.class);
        ViewModelProviders.of(r6).get(MergeDrawerViewModel.class).getCloseDrawer().observe(this, t0.a);
    L47:
        com.bytedance.android.livesdk.log.filter.o r9 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r10 = "";
        if (r9.getMap().containsKey("enter_from_merge") == false) goto L50;
        String r11 = (String) r9.getMap().get("enter_from_merge");
    L51:
        if (r11 != null) goto L54;
        r11 = "";
    L54:
        if (r9.getMap().containsKey("enter_method") == false) goto L56;
        String r12 = (String) r9.getMap().get("enter_method");
    L57:
        if (r12 != null) goto L59;
        r12 = "";
    L59:
        FeedTabViewModel r13 = this.r;
        if (r13 == null) goto L91;
        List<com.bytedance.android.livesdk.feed.feed.e> r14 = r13.getAllTabs();
        if (r14 == null) goto L91;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L65:
        if (r16.hasNext() == false) goto L92;
        Object r17 = r16.next();
        com.bytedance.android.livesdk.feed.feed.e r18 = (com.bytedance.android.livesdk.feed.feed.e) r17;
        List<String> r19 = r18.b();
        if (r19 != null) goto L69;
    L72:
        boolean r110 = true;
    L73:
        if (r110 == false) goto L75;
    L76:
        List<String> r111 = r18.d();
        if (r111 != null) goto L79;
    L82:
        boolean r112 = true;
    L83:
        if (r112 == false) goto L85;
    L88:
        boolean r113 = true;
    L89:
        if (r113 == false) goto L65;
        r15.add(r17);
        goto L65
    L85:
        if (LiveDrawerUrlHelper.isParamInList(r11, r12, r18.d()) == true) goto L88;
    L87:
        r113 = false;
        goto L89
    L79:
        if (r111.isEmpty() == true) goto L82;
        r112 = false;
        goto L83
    L75:
        if (LiveDrawerUrlHelper.isParamInList(r11, r12, r18.b()) == true) goto L87;
    L69:
        if (r19.isEmpty() == true) goto L72;
        r110 = false;
    L92:
        if (r15 == null) goto L96;
        LiveDrawerPageAdapter r20 = this.g;
        if (r20 == null) goto L96;
        Intrinsics.checkNotNullParameter(r15, "data");
        ((ArrayList) r20.a).clear();
        ((ArrayList) r20.a).addAll(r15);
    L96:
        SSViewPager r24 = this.d;
        if (r24 == null) goto L99;
        r24.setAdapter(this.g);
    L99:
        LiveDrawerPagerSlidingTabStrip r25 = this.e;
        if (r25 == null) goto L102;
        r25.setShadeView(this.f);
    L102:
        LiveDrawerPagerSlidingTabStrip r26 = this.e;
        if (r26 == null) goto L105;
        r26.setViewPager(this.d);
    L105:
        Bundle r27 = getArguments();
        long r114 = -1;
        if (r27 == null) goto L108;
        boolean r115 = r27.getBoolean("switch_follow", false);
        long r116 = r27.getLong("default_tab_type", -1);
        long r28 = r27.getLong("tag_id", -1);
    L110:
        if (bx1.a.b(r11) == true) goto L125;
        if (r115 == true) goto L125;
        if (bx1.a.a(r11) == false) goto L117;
        int r29 = 3;
    L126:
        if (r15 == null) goto L137;
        Iterator r30 = r15.iterator();
        int r117 = 0;
        int r118 = 0;
    L129:
        if (r30.hasNext() == false) goto L138;
        Object r119 = r30.next();
        int r120 = r117 + 1;
        if (r117 >= 0) goto L134;
        CollectionsKt.throwIndexOverflow();
    L134:
        if (((com.bytedance.android.livesdk.feed.feed.e) r119).getType() != r29) goto L136;
        r118 = r117;
    L136:
        r117 = r120;
    L138:
        if (r15 == null) goto L154;
        Iterator r31 = r15.iterator();
        int r32 = 0;
    L141:
        if (r31.hasNext() == false) goto L154;
        Object r33 = r31.next();
        int r121 = r32 + 1;
        if (r32 >= 0) goto L145;
        CollectionsKt.throwIndexOverflow();
    L145:
        long r122 = ((com.bytedance.android.livesdk.feed.feed.e) r33).f();
        LiveDrawerTabViewModel r34 = this.u;
        if (r34 == null) goto L152;
        LiveDrawerTabViewModel.a r35 = r34.getTabStatus();
        if (r35 == null) goto L152;
        if (r122 != r35.a) goto L152;
        r118 = r32;
    L152:
        r32 = r121;
        r114 = -1;
    L154:
        if (r116 == r114) goto L167;
        if (r115 == true) goto L167;
        if (r15 == null) goto L167;
        Iterator r36 = r15.iterator();
        int r37 = 0;
    L159:
        if (r36.hasNext() == false) goto L167;
        Object r38 = r36.next();
        int r39 = r37 + 1;
        if (r37 >= 0) goto L164;
        CollectionsKt.throwIndexOverflow();
    L164:
        if (((com.bytedance.android.livesdk.feed.feed.e) r38).getType() != ((int) r116)) goto L166;
        r118 = r37;
    L166:
        r37 = r39;
    L167:
        int r40 = r118;
        if (r40 < 0) goto L192;
        if (r15 == null) goto L171;
        int r41 = r15.size();
    L172:
        if (r40 >= r41) goto L192;
        if (r15 == null) goto L175;
        com.bytedance.android.livesdk.feed.feed.e r42 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r15, r40);
    L176:
        int r43 = v0.a;
        ILiveService r44 = TTLiveService.getLiveService();
        if (r44 == null) goto L182;
        ILiveOntologyInfoManager r45 = r44.getLiveOntologyRecord();
        if (r45 == null) goto L182;
        String r46 = r45.getEnterFromMerge();
        if (r46 == null) goto L182;
    L183:
        if (r42 == null) goto L188;
        String r47 = r42.j();
        if (r47 == null) goto L188;
        r10 = r47;
    L188:
        if (r42 == null) goto L190;
        int r48 = r42.getType();
    L191:
        v0.a(r46, r10, "default", r48);
        goto L192
    L190:
        r48 = 0;
    L182:
        r46 = "drawer_null";
        goto L183
    L175:
        r42 = null;
        goto L176
    L171:
        r41 = 0;
    L192:
        Bundle r49 = getArguments();
        if (r49 == null) goto L195;
        r49.putLong("tag_type", r116);
    L195:
        Bundle r50 = getArguments();
        if (r50 == null) goto L198;
        r50.putLong("tag_id", r28);
    L198:
        SSViewPager r51 = this.d;
        if (r51 == null) goto L201;
        r51.setCurrentItem(r40);
    L201:
        this.v = r40;
        this.w = r40;
        LiveDrawerPagerSlidingTabStrip r52 = this.e;
        if (r52 == null) goto L204;
        r52.setOnTabClickListener(new u0(this));
    L204:
        LiveDrawerPagerSlidingTabStrip r53 = this.e;
        if (r53 == null) goto L207;
        r53.setOnPageChangeListener(new LiveDrawerFeedPageFragment$initView$9(this));
    L207:
        View r54 = this.j;
        if (r54 == null) goto L210;
        r54.setOnClickListener(new n0(this));
    L210:
        View r55 = this.k;
        if (r55 == null) goto L213;
        r55.setOnClickListener(new o0(this));
    L213:
        View r56 = this.l;
        if (r56 == null) goto L217;
        r56.setOnClickListener(new p0(this));
    L217:
        if (TTLiveSDK.hostService().user().isLogin() == true) goto L219;
        com.bytedance.android.livesdk.sharedpref.e r57 = com.bytedance.android.livesdk.sharedpref.b.a2;
        Boolean r58 = Boolean.TRUE;
        r57.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r57, r58);
        com.bytedance.android.livesdk.log.u.l().a(0);
    L227:
        TextView r59 = (TextView) r8.findViewById(2131364606);
        this.o = r59;
        if (r59 == null) goto L230;
        r59.setOnClickListener(new r0(this));
    L230:
        ImageView r60 = (ImageView) r8.findViewById(2131364607);
        this.p = r60;
        if (r60 == null) goto L233;
        UtilityKotlinExtentionsKt.t(r60);
    L233:
        ImageView r61 = this.p;
        if (r61 == null) goto L236;
        r61.setOnClickListener(new s0(this));
    L236:
        H.getClass();
        Integer r62 = (Integer) LiveFeedSettings.LIVE_DRAWER_OPEN_LIVE.getValue();
        if (r62 != null) goto L240;
    L241:
        boolean r63 = true;
    L243:
        if (r63 == false) goto L258;
        Map r64 = (Map) com.bytedance.android.livesdk.sharedpref.b.b2.getValue();
        if (r64.get("show_times") != null) goto L248;
        a.a(1);
    L257:
        boolean r65 = true;
    L259:
        G = r65;
        if (r65 == false) goto L262;
        ViewGroup.LayoutParams r66 = null;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_page_inspire_live_button_show", null, new Object[]{Room.class, am2.x.class});
    L263:
        DP();
        IDrawerFeedAction r67 = this.x;
        if (r67 == null) goto L266;
        r67.feedEnd();
    L266:
        r3.c(this.k, s1.B(2131919654), true);
        r3.c(this.l, s1.B(2131919189), true);
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L269;
        boolean r68 = false;
    L270:
        if (r68 == false) goto L304;
        int r69 = s1.f(40.0f);
        int r70 = s1.f(40.0f);
        int r71 = s1.f(20.0f);
        int r72 = s1.f(20.0f);
        T90(this.n, -1, r70);
        T90(this.j, r69, r70);
        T90(this.B, r71, r72);
        T90(this.k, -2, r70);
        T90(this.C, r71, r72);
        T90(this.l, -1, r70);
        T90(this.D, r71, r72);
        LiveDrawerPagerSlidingTabStrip r73 = this.e;
        if (r73 == null) goto L274;
        r73.setTextSize(s1.f(14.0f));
    L274:
        LiveDrawerPagerSlidingTabStrip r75 = this.e;
        if (r75 == null) goto L277;
        r75.setTabTextSelectSize(s1.f(14.0f));
    L277:
        View r76 = this.l;
        if (r76 == null) goto L280;
        ViewGroup.LayoutParams r77 = r76.getLayoutParams();
    L282:
        if (r77 == null) goto L303;
        LinearLayout.LayoutParams r78 = (LinearLayout.LayoutParams) r77;
        r78.leftMargin = s1.f(8.0f);
        r78.rightMargin = s1.f(4.0f);
        View r79 = this.l;
        if (r79 == null) goto L286;
        r79.setLayoutParams(r78);
    L286:
        View r80 = this.k;
        if (r80 == null) goto L289;
        ViewGroup.LayoutParams r81 = r80.getLayoutParams();
    L290:
        if (r81 == null) goto L301;
        LinearLayout.LayoutParams r82 = (LinearLayout.LayoutParams) r81;
        r82.leftMargin = s1.f(8.0f);
        View r83 = this.k;
        if (r83 == null) goto L294;
        r83.setLayoutParams(r82);
    L294:
        ImageView r84 = this.D;
        if (r84 == null) goto L297;
        r84.setImageResource(2131251461);
    L297:
        ImageView r85 = this.C;
        if (r85 == null) goto L304;
        r85.setImageResource(2131250598);
        goto L304
    L301:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L289:
        r81 = r66;
        goto L290
    L303:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L280:
        r77 = r66;
    L304:
        return r8;
    L269:
        r68 = e5.n();
        goto L270
    L262:
        r66 = null;
        goto L263
    L248:
        Long r86 = (Long) r64.get("show_times");
        Intrinsics.checkNotNull(r86);
        if (r86.longValue() >= 3) goto L251;
        a.a(r86.longValue() + 1);
        goto L257
    L251:
        Long r87 = (Long) r64.get("last_show_time");
        if (r87 != null) goto L255;
        r87 = 0L;
    L255:
        if ((System.currentTimeMillis() - r87.longValue()) <= 604800000) goto L258;
        a.a(1);
    L258:
        r65 = false;
        goto L259
    L240:
        if (r62.intValue() != 0) goto L241;
        r63 = false;
        goto L243
    L219:
        Integer r88 = (Integer) LiveFeedSettings.LIVE_DRAWER_START_LIVE_BTN.getValue();
        if (r88 == null) goto L225;
        if (r88.intValue() == 0) goto L227;
    L225:
        if (TTLiveSDK.hostService().user().isLogin() == false) goto L227;
        TTLiveSDK.hostService().user().requestLivePermission(new q0(this));
        goto L227
    L137:
        r118 = 0;
        goto L138
    L117:
        if (TextUtils.isEmpty(r11) == false) goto L119;
    L121:
        boolean r89 = false;
    L122:
        if (r89 == false) goto L124;
        r29 = 4;
        goto L126
    L124:
        r29 = 1;
        goto L126
    L119:
        if (CollectionsKt.contains(bx1.a.c, r11) == false) goto L121;
        r89 = true;
    L125:
        r29 = 2;
        goto L126
    L108:
        r28 = -1;
        r116 = -1;
        r115 = false;
    L91:
        r15 = null;
        goto L92
    L56:
        r12 = "";
        goto L57
    L50:
        r11 = "";
        goto L51
    L20:
        if (gp.a.getValue().c() == true) goto L38;
        View r90 = this.l;
        if (r90 == null) goto L25;
        r90.setVisibility(0);
    L25:
        if (this.A.getBoolean(this.z, false) == false) goto L32;
        View r91 = this.m;
        if (r91 == null) goto L29;
        r91.setVisibility(8);
    L29:
        IDrawerFeedAction r92 = this.x;
        if (r92 == null) goto L44;
        r92.historyShow(0);
        goto L44
    L32:
        View r93 = this.m;
        if (r93 == null) goto L35;
        r93.setVisibility(0);
    L35:
        IDrawerFeedAction r94 = this.x;
        if (r94 == null) goto L44;
        r94.historyShow(1);
        goto L44
    L8:
        if (this.y == false) goto L10;
        int r95 = 0;
    L11:
        r1.setVisibility(r95);
        goto L12
    L10:
        r95 = 8;
        goto L11
    }
}
