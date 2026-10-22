package com.larus.bmhome.notification;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.notification.adapter.NotificationListAdapter;
import com.larus.bmhome.notification.viewmodel.BannerViewModel;
import com.larus.bmhome.notification.viewmodel.NotificationListViewModel;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.home.api.main.HomeService;
import com.larus.notify.impl.databinding.LarusPageNotificationBinding;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001,\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\"H\u0016J\b\u00100\u001a\u00020 H\u0002J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0016J\b\u00109\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0016J\b\u0010A\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020\u0019H\u0002J.\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\b\b\u0002\u0010F\u001a\u00020\u00142\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\u0019H\u0016J\b\u0010J\u001a\u00020\u0014H\u0016J\n\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u0019H\u0016J\b\u0010N\u001a\u00020OH\u0016J\u0012\u0010P\u001a\u00020 2\b\u0010Q\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010R\u001a\u00020 H\u0016J \u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020\u00142\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0014H\u0002J,\u0010X\u001a\u00020 2\b\u0010Y\u001a\u0004\u0018\u0001022\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006`"}, d2 = {"Lcom/larus/bmhome/notification/NotifyTabFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/notify/impl/databinding/LarusPageNotificationBinding;", "viewModel", "Lcom/larus/bmhome/notification/viewmodel/NotificationListViewModel;", "getViewModel", "()Lcom/larus/bmhome/notification/viewmodel/NotificationListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bannerViewModel", "Lcom/larus/bmhome/notification/viewmodel/BannerViewModel;", "getBannerViewModel", "()Lcom/larus/bmhome/notification/viewmodel/BannerViewModel;", "bannerViewModel$delegate", "clickItem", "", "isFirstCreate", "listAdapter", "Lcom/larus/bmhome/notification/adapter/NotificationListAdapter;", "enterMethod", "", "outerInputController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "getOuterInputController", "()Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "outerInputController$delegate", "onNewIntent", "", "bundle", "Landroid/os/Bundle;", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "isSideBar", "()Z", "isSideBar$delegate", "appJustForeground", "wentBackgroundFromThisFragment", "isInTabForeground", "appBackgroundListener", "com/larus/bmhome/notification/NotifyTabFragment$appBackgroundListener$1", "Lcom/larus/bmhome/notification/NotifyTabFragment$appBackgroundListener$1;", "onCreate", "savedInstanceState", "refreshNotificationList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "startCreateBot", "initViewModel", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "onResume", "onPause", "onDestroyView", "getEnterMethod", "refresh", "withLoading", "showRetryPage", "fromResume", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "getCurrentPageName", "autoLogEnterPage", "parentTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPageName", "tabIndex", "", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "isNotifyActivity", "openLongClickMenu", "anchor", "notice", "Lcom/larus/bmhome/chat/resp/Notice;", "clickX", "", "clickY", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyTabFragment extends BaseHomeTabFragment implements s19.a, z {
    public static final /* synthetic */ int w = 0;
    public LarusPageNotificationBinding j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;
    public boolean n;
    public final NotificationListAdapter o;
    public final Lazy p;
    public final et3.c q;
    public final Lazy r;
    public boolean s;
    public boolean t;
    public boolean u;
    public final b v;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ NotifyTabFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            NotifyTabFragment r0 = this.a;
            r0.t = r0.u;
        }

        public final void onAppForeground() {
            if (Intrinsics.areEqual(AppHost.a.a().getCurrentActivity(), this.a.getActivity()) == false) goto L6;
            this.a.s = true;
            return;
        }

        public b(NotifyTabFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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

    public NotifyTabFragment() {
        super(false);
        final Function0<Fragment> r1 = new NotifyTabFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationListViewModel.class), new NotifyTabFragment$special$$inlined$viewModels$default$2(r1), new NotifyTabFragment$special$$inlined$viewModels$default$3(r1, this));
        final Function0<Fragment> r2 = new NotifyTabFragment$special$$inlined$viewModels$default$4(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BannerViewModel.class), new NotifyTabFragment$special$$inlined$viewModels$default$5(r2), new NotifyTabFragment$special$$inlined$viewModels$default$6(r2, this));
        this.n = true;
        this.o = new NotificationListAdapter(new FPagingAdapter.a(new e(this)), getLifecycle(), this);
        this.p = LazyKt.lazy(new p(this));
        this.q = new et3.c("List_NotifyTab", false, null);
        this.r = LazyKt.lazy(new r(this));
        this.v = new b(this);
    }

    public final void KC(boolean r1, Function0<Unit> r2) {
    }

    public final void a2(Bundle r1) {
    }

    public final void pp(String r1) {
    }

    public final void t1() {
        this.u = false;
    }

    public final NotificationListViewModel Y90() {
        return (NotificationListViewModel) this.k.getValue();
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.NOTIFY.getIndex();
    }

    public final boolean S90() {
        return Z90();
    }

    public final boolean Z90() {
        if ((getActivity() instanceof NotifyActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getActivity() instanceof AggregatedNotifyActivity) == true) goto L8;
        return false;
    }

    public final String getEnterMethod() {
        Bundle r0 = getArguments();
        String r1 = "other";
        if (r0 == null) goto L8;
        String r2 = r0.getString("enter_method", "other");
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        Bundle r3 = getArguments();
        if (r3 == null) goto L11;
        String r4 = r3.getString("is_from_push", "false");
    L13:
        if (Intrinsics.areEqual(r4, "true") == false) goto L15;
        r1 = "outer_push";
    L15:
        FLogger.a.i("NotifyTabFragment", "getEnterFrom = ".concat(r1));
        return r1;
    L11:
        r4 = null;
        goto L13
    }

    public final String getPageName() {
        if (Y90().isAggNotificationPage() == false) goto L5;
        return "multi_add_notify";
    L5:
        return "notify";
    }

    public final String k() {
        if (Y90().isAggNotificationPage() == false) goto L5;
        return "multi_add_notify";
    L5:
        return "notify";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.j = null;
        AppHost.a.a().c(this.v);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (this.m == true) goto L22;
        Iterator r0 = ((ArrayList) ((FPagingAdapter) this.o).b).iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L10;
        if (((Notice) r0.next()).getHasRead() == true) goto L6;
        r1 = r1 + 1;
        goto L6
    L10:
        NotificationListAdapter r2 = this.o;
        Iterator r3 = ((ArrayList) ((FPagingAdapter) r2).b).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        ((Notice) r3.next()).setHasRead(true);
        goto L12
    L14:
        r2.notifyDataSetChanged();
        Y90().markTotalRead(Integer.valueOf(r1));
        Y90().setLeaveNotifyTimestamp(System.currentTimeMillis());
        return;
    }

    public final void onResume() {
        super.onResume();
        String r0 = getEnterMethod();
        if (this.m == true) goto L11;
        boolean r1 = o3.a;
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.put("enter_method", r0);     // Catch: JSONException -> L7
    L9:
        TrackParams r3 = new TrackParams().merge(r2);
        by7.a r4 = new by7.a("show_notification_page");
        r4.b = this;
        r4.a.merge(r3);
        r4.b();
    L7:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper showNotificationPage " + e.getLocalizedMessage());
    L11:
        if (this.s == true) goto L13;
    L15:
        DowngradeSource r5 = DowngradeSource.ENTER_PAGE;
    L16:
        this.m = false;
        ((BannerViewModel) this.l.getValue()).refreshNotificationBanner(r5);
        this.s = false;
        this.t = false;
        return;
    L13:
        if (this.t == false) goto L15;
        r5 = DowngradeSource.HOT_LAUNCH;
        goto L16
    }

    public final by7.e parentTrackNode() {
        by7.e r0 = getParentFragment();
        if ((r0 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        r3.putIfNull("enter_method", getEnterMethod());
    }

    public final void onCreate(Bundle r7) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r7);
        Y90().init(getArguments());
        ((BannerViewModel) this.l.getValue()).init(getArguments());
        if (((Boolean) this.r.getValue()).booleanValue() == true) goto L5;
        NotifyRedDotLifecycleObserver r8 = new NotifyRedDotLifecycleObserver(LifecycleOwnerKt.getLifecycleScope(this));
        getLifecycle().addObserver(r8);
    L5:
        boolean r9 = HomeService.a.o();
        NotificationListViewModel r0 = Y90();
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L8;
        DowngradeSource r1 = DowngradeSource.ENTER_PAGE;
    L9:
        NotificationListViewModel.refreshNotificationList$default(r0, r1, false, false, 6, null);
        BannerViewModel r2 = (BannerViewModel) this.l.getValue();
        if (r9 == false) goto L12;
        DowngradeSource r10 = DowngradeSource.ENTER_PAGE;
    L13:
        r2.refreshNotificationBanner(r10);
        AppHost.a.a().j(this.v);
        return;
    L12:
        r10 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L13
    L8:
        r1 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L9
    }

    public final void y2(final String r7) {
        FLogger.a.i("NotifyTabFragment", "onEnterTab, previousPage:" + r7);
        this.u = true;
        getViewLifecycleOwnerLiveData().observeForever(new c(new w(this, r7)));
        if (Y90().getUnreadNotificationCount() > 0) goto L5;
    L11:
        Y90().clearUnreadNotificationCount();
        return;
    L5:
        if (this.n == true) goto L11;
        NotificationListViewModel r0 = Y90();
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L9;
        DowngradeSource r8 = DowngradeSource.ENTER_PAGE;
    L10:
        NotificationListViewModel.refreshNotificationList$default(r0, r8, false, false, 6, null);
        goto L11
    L9:
        r8 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L10
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        final LarusPageNotificationBinding r13 = this.j;
        if (r13 == null) goto L35;
        Bundle r14 = getArguments();
        FragmentActivity r0 = null;
        if (r14 == null) goto L7;
        String r15 = r14.getString("title");
    L9:
        if (TextUtils.isEmpty(r15) == true) goto L14;
        NovaTitleBarEx r1 = r13.e;
        if (r15 != null) goto L13;
        r15 = "";
    L13:
        NovaTitleBarEx.Y5(r1, r15, null, null, 6);
    L20:
        if (Z90() == false) goto L23;
        NovaTitleBarEx.b6(r13.e, 2131241477, false, null, null, new x(this), 14);
    L32:
        NotificationListAdapter r16 = this.o;
        Function0<Unit> r2 = new f(this);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "callback");
        r16.q = r2;
        final RecyclerView r17 = r13.c;
        r17.setLayoutManager(new LinearLayoutManager(r17.getContext()));
        r17.setHasFixedSize(true);
        NotificationListAdapter r3 = this.o;
        r3.n = new g(this);
        r3.m = new h(this);
        r3.o = new i(this);
        r3.p = new j(this);
        r17.addOnScrollListener(new NotifyTabFragment$initView$1$5$5(this, r13));
        Intrinsics.checkNotNull(r17);
        y6.d(r17, null, new k(this), null, new l(this), 11);
        r17.addItemDecoration(new NotifyTabFragment$initView$1$5$8(r17));
        r17.setAdapter(this.o);
        IFlowCreationThemeConfigProvider r18 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        if (r18 == null) goto L35;
        r18.b(r13.b, new m(this, r13), AdaptThemeFeatureKey.CREATION_NOTIFY_BOT_CREATE);
        goto L35
    L23:
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L32;
        ConstraintLayout r19 = r13.e;
        ViewGroup.LayoutParams r4 = r19.getLayoutParams();
        if (r4 == null) goto L31;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        i0.a.getClass();
        r5.topMargin = i0.g();
        r19.setLayoutParams(r5);
        NovaTitleBarEx.b6(r13.e, 2131242079, false, null, null, new y(this), 14);
        ConstraintLayout r110 = r13.a;
        Context r6 = getContext();
        if ((r6 instanceof FragmentActivity) == false) goto L29;
        r0 = (FragmentActivity) r6;
    L29:
        int r7 = com.larus.utils.u.b(r0);
        int r8 = r110.getPaddingStart();
        int r9 = r110.getPaddingTop();
        int r10 = r110.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r110.getClass().getSimpleName() + ",source:,start:" + r8 + ",top:" + r9 + ",end:" + r10 + ",bottom:" + r7);
        r110.setPaddingRelative(r8, r9, r10, r7);
        Y90().clearUnreadNotificationCount();
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L14:
        NovaTitleBarEx r111 = r13.e;
        if (Y90().isAggNotificationPage() == false) goto L17;
        String r20 = getString(2131899215);
    L18:
        Intrinsics.checkNotNull(r20);
        NovaTitleBarEx.Y5(r111, r20, null, null, 6);
        goto L20
    L17:
        r20 = getString(2131908220);
        goto L18
    L7:
        r15 = null;
    L35:
        Y90().getRefreshNotificationListData().observe(getViewLifecycleOwner(), new c(new s(this)));
        Y90().getLoadMoreNotificationListData().observe(getViewLifecycleOwner(), new c(new t(this)));
        Y90().getDeleteNoticeLiveData().observe(getViewLifecycleOwner(), new c(new u(this)));
        ((BannerViewModel) this.l.getValue()).getRefreshBannerEvent().observe(getViewLifecycleOwner(), new c(new v(this)));
        this.n = false;
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = getLayoutInflater().inflate(2131563053, r8, false);
        int r11 = 2131364358;
        CreateBotButton r2 = (CreateBotButton) ViewBindings.findChildViewById(r10, 2131364358);
        if (r2 == null) goto L19;
        ConstraintLayout r12 = r10;
        RecyclerView r3 = ViewBindings.findChildViewById(r10, 2131381051);
        if (r3 == null) goto L17;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131381753);
        if (r4 == null) goto L16;
        NovaTitleBarEx r5 = (NovaTitleBarEx) ViewBindings.findChildViewById(r10, 2131388807);
        if (r5 == null) goto L15;
        this.j = new LarusPageNotificationBinding(r12, r2, r3, r4, r5);
        if (r12 == null) goto L13;
        r12.setTag(2131377847, this);
        return r12;
    L13:
        return null;
    L15:
        r11 = 2131388807;
        goto L19
    L16:
        r11 = 2131381753;
        goto L19
    L17:
        r11 = 2131381051;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static void aa0(NotifyTabFragment r3, boolean r4, boolean r5, DowngradeSource r6) {
        r3.getClass();
        FLogger.a.i("NotifyTabFragment", "refreshing notification tab");
        if (r4 == false) goto L11;
        NotificationListAdapter r7 = r3.o;
        if (r7.H2() == false) goto L10;
        ArrayList r1 = new ArrayList();
        Notice r2 = (Notice) r7.A2(0);
        if (r2 == null) goto L9;
        r1.add(r2);
    L9:
        r1.addAll(r7.k);
        r7.E2(r1);
        goto L11
    L10:
        r7.E2(r7.k);
    L11:
        r3.Y90().refreshNotificationList(r6, r5, false);
    }
}
