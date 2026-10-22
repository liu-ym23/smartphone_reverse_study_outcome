package com.larus.ugc.feed.impl.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.z;
import com.larus.bot.api.IBotDiscoverService;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.FlowRuntime;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.api.model.FabVisibilityStateKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.impl.ability.CommunityCreateEventFeature;
import com.larus.ugc.feed.impl.spi.CommunityCreateNavigatorAndroidImpl;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zp9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u000247\b\u0007\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001pB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010D\u001a\u00020:H\u0016J\b\u0010E\u001a\u00020:H\u0016J\b\u0010F\u001a\u00020:H\u0016J\b\u0010I\u001a\u00020!H\u0016J\b\u0010J\u001a\u00020HH\u0016J\b\u0010K\u001a\u000202H\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0012\u0010N\u001a\u00020:2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010O\u001a\u00020:H\u0016J \u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020!2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010SH\u0016J\u0018\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020H2\u0006\u0010V\u001a\u000202H\u0016J\u0018\u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020H2\u0006\u0010V\u001a\u000202H\u0016J\u0010\u0010Y\u001a\u00020:2\u0006\u0010V\u001a\u000202H\u0016J\u0012\u0010Z\u001a\u00020:2\b\u0010[\u001a\u0004\u0018\u00010<H\u0016J\b\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u0002022\u0006\u0010_\u001a\u00020]H\u0002J\u0010\u0010`\u001a\u00020:2\u0006\u0010_\u001a\u00020]H\u0002J\b\u0010a\u001a\u00020:H\u0002J\u0010\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020dH\u0002J\b\u0010e\u001a\u00020:H\u0002J\b\u0010f\u001a\u00020:H\u0002J\b\u0010g\u001a\u00020:H\u0002J\u0010\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020:2\u0006\u0010l\u001a\u00020mH\u0002J\n\u0010n\u001a\u0004\u0018\u00010oH\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b*\u0010(R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/larus/ugc/feed/impl/home/CommunityCreateFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "Lcom/larus/bmhome/chat/multi_tab/IChatMultiTabChildFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sharedPool$delegate", "Lkotlin/Lazy;", "bridgeVM", "Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "getBridgeVM", "()Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "bridgeVM$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "rootView", "Landroid/view/View;", "titleBarView", "tabContainerView", "iconLeftView", "profileImageContainerView", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "fabView", "tabListView", "Lcom/larus/platform/api/creation/ITabListLayout;", "adapter", "Lcom/larus/ugc/feed/impl/home/CommunityMainAdapter;", "hasResumedBefore", "", "isMultiTab", "isClickedTab", "disableReportEnterTab", "innerPushUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "isSideBar", "()Z", "isSideBar$delegate", "isChatMultiTab", "isChatMultiTab$delegate", "hostUiPolicy", "Lcom/larus/uaigc/applet/AICreationCommunityHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/uaigc/applet/AICreationCommunityHostUiPolicy;", "hostUiPolicy$delegate", "lastSelectedIndex", "", "appBackGroundListener", "com/larus/ugc/feed/impl/home/CommunityCreateFragment$appBackGroundListener$1", "Lcom/larus/ugc/feed/impl/home/CommunityCreateFragment$appBackGroundListener$1;", "pollingListener", "com/larus/ugc/feed/impl/home/CommunityCreateFragment$pollingListener$1", "Lcom/larus/ugc/feed/impl/home/CommunityCreateFragment$pollingListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onStop", "onDestroyView", "previousPage", "", "autoLogEnterPage", "getCurrentPageName", "tabIndex", "getCurrentChildFragment", "Landroidx/fragment/app/Fragment;", "onEnterTab", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "onChatTabSelected", "enterMethod", "position", "onChatTabUnselected", "leaveMethod", "onChatTabReselected", "onNewIntent", "bundle", "deriveLaunchMode", "Lcom/larus/ugc/feed/api/model/CommunityCreateLaunchModeKmp;", "deriveRecommendType", "launchMode", "applyLaunchModeUi", "setupViewPager", "setupFab", "ability", "Lcom/larus/ugc/feed/api/ability/IKMPCommunityCreateAbility;", "setupProfileAvatar", "loadProfileAvatar", "setupTabListView", "applyFabVisibility", "v", "Lcom/larus/ugc/feed/api/model/FabVisibilityStateKmp;", "handleInnerPushCreation", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "eventAbility", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateEventAbility;", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommunityCreateFragment extends BaseHomeTabFragment implements s19.a, z, ci8.c {
    public static final /* synthetic */ int G = 0;
    public final Lazy A;
    public final Lazy B;
    public int C;
    public final c D;
    public final d E;
    public String F;
    public final Lazy j;
    public final com.larus.ui.arch.vm.internal.l k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public ViewPager2 q;
    public View r;
    public u s;
    public CommunityMainAdapter t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public UserCreation y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[CommunityCreateLaunchModeKmp.values().length];
            r0[CommunityCreateLaunchModeKmp.STANDALONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[CommunityCreateLaunchModeKmp.SIDE_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[FabVisibilityStateKmp.values().length];
            r1[FabVisibilityStateKmp.VISIBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[FabVisibilityStateKmp.HIDDEN_DOWNGRADE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[FabVisibilityStateKmp.HIDDEN_LAUNCH_MODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final class c implements f09.a.b {
        public final /* synthetic */ CommunityCreateFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            CommunityCreateFragment r0 = this.a;
            int r1 = CommunityCreateFragment.G;
            g0a.b r2 = r0.Y90();
            if (r2 == null) goto L6;
            r2.da("leave_app");
            return;
        }

        public c(CommunityCreateFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements s09.b {
        public final /* synthetic */ CommunityCreateFragment a;

        public final String getUniqueId() {
            return "CommunityCreateFragment[Kmp]";
        }

        public final void onFailure() {
        }

        public d(CommunityCreateFragment r1) {
            this.a = r1;
        }

        public final void a(s09.a r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            Map r4 = r3.a;
            if (r4 == null) goto L5;
            String r5 = (String) r4.get("cre_tab_ent_dg");
        L6:
            boolean r6 = Intrinsics.areEqual(r5, "1");
            CommunityCreateFragment r0 = this.a;
            int r1 = CommunityCreateFragment.G;
            g0a.b r2 = r0.Y90();
            if (r2 == null) goto L10;
            r2.Sd(r6);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public e(Function1 r2) {
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

    public static final class f implements Function0<LifecycleOwner> {
        public final /* synthetic */ Fragment a;

        public f(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class g implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ Fragment a;

        public g(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class h implements Function0<ViewModelProvider.Factory> {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public CommunityCreateFragment() {
        super(false);
        this.j = LazyKt.lazy(new com.larus.ugc.feed.impl.home.g());
        this.k = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CommunityCreateLegacyBridgeViewModel.class), Reflection.getOrCreateKotlinClass(CommunityCreateBridgeEmptyState.class), new f(this), new g(this), h.a);
        this.z = LazyKt.lazy(new com.larus.ugc.feed.impl.home.h(this));
        this.A = LazyKt.lazy(new i(this));
        this.B = LazyKt.lazy(new j(this));
        this.C = -1;
        this.D = new c(this);
        this.E = new d(this);
        this.F = "";
    }

    public final void LY(String r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveMethod");
    }

    public final boolean S90() {
        return false;
    }

    public final void pp(String r1) {
    }

    public final boolean aa0() {
        return ((Boolean) this.z.getValue()).booleanValue();
    }

    public final String k() {
        if (((Boolean) this.A.getValue()).booleanValue() == false) goto L5;
        return "create_feed_top_tab";
    L5:
        return "ai_generate";
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.COMMUNITY_CREATE.getIndex();
    }

    public final void SL() {
        Fragment r0 = Z90();
        if ((r0 instanceof CommunityListFragment) == false) goto L5;
        CommunityListFragment r1 = (CommunityListFragment) r0;
    L6:
        if (r1 == null) goto L9;
        zp9.o.a.a(r1, false, 7);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final g0a.b Y90() {
        return s1a.a.g(this).o(Reflection.getOrCreateKotlinClass(g0a.b.class));
    }

    public final Fragment Z90() {
        if (isAdded() == true) goto L6;
        return null;
    L6:
        FragmentManager r0 = getChildFragmentManager();
        StringBuilder r1 = new StringBuilder("f");
        CommunityMainAdapter r2 = this.t;
        if (r2 == null) goto L13;
        ViewPager2 r3 = this.q;
        if (r3 == null) goto L11;
        int r4 = r3.getCurrentItem();
    L12:
        long r5 = r2.getItemId(r4);
    L14:
        r1.append(r5);
        return r0.findFragmentByTag(r1.toString());
    L11:
        r4 = 0;
        goto L12
    L13:
        r5 = 0;
        goto L14
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        AppHost.a.a().c(this.D);
        PollingConfigService.a.i(this.E);
        this.s = null;
    }

    public final void onResume() {
        super.onResume();
        g0a.b r0 = Y90();
        if (r0 == null) goto L9;
        Bundle r1 = getArguments();
        if (r1 == null) goto L7;
        String r2 = r1.getString("enter_method");
    L8:
        r0.nI(null, r2);
        goto L9
    L7:
        r2 = null;
    L9:
        this.u = true;
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        FragmentActivity r0 = getActivity();
        AppHost.Companion r1 = AppHost.a;
        List r2 = CollectionsKt.reversed(r1.a().g());
        boolean r4 = true;
        if (r2.size() > 1) goto L5;
    L7:
        r4 = false;
    L9:
        if (Intrinsics.areEqual(r1.a().getCurrentActivity(), r0) == false) goto L11;
        return;
    L11:
        if (r4 == false) goto L16;
        g0a.b r3 = Y90();
        if (r3 == null) goto L17;
        r3.da("enter_new_page");
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r2, 1), r0) == false) goto L7;
        goto L7
    }

    public final void t1() {
        g0a.b r0 = Y90();
        if (r0 == null) goto L5;
        r0.da("leave_page");
    L5:
        z r1 = null;
        if (aa0() == false) goto L12;
        z r2 = Z90();
        if ((r2 instanceof z) == false) goto L10;
        r1 = r2;
    L10:
        if (r1 == null) goto L18;
        r1.t1();
        return;
    L18:
        return;
    L12:
        z r3 = Z90();
        if ((r3 instanceof s19.a) == false) goto L15;
        r1 = (s19.a) r3;
    L15:
        if (r1 == null) goto L20;
        r1.t1();
        return;
    }

    public final void a2(Bundle r8) {
        if (r8 == null) goto L5;
        UserCreation r1 = (UserCreation) r8.getParcelable("creation");
    L6:
        if (r8 == null) goto L8;
        String r2 = r8.getString("related_recommendation");
    L9:
        if (r8 == null) goto L11;
        String r3 = r8.getString("related_creation_id");
    L12:
        g0a.b r4 = Y90();
        if (r4 == null) goto L23;
        if (r8 == null) goto L17;
        String r6 = r8.getString("enter_method");
    L18:
        if (r1 == null) goto L20;
        UserCreationKmp r5 = com.larus.ugc.feed.impl.mapper.c.b(r1);
    L21:
        r4.wK(new g0a.a(r2, r3, r6, r5));
        goto L23
    L20:
        r5 = null;
        goto L21
    L17:
        r6 = null;
    L23:
        if (r2 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == true) goto L39;
        ViewPager2 r9 = this.q;
        if (r9 == null) goto L33;
        int r10 = r9.getCurrentItem();
    L34:
        if (r10 == 0) goto L39;
        this.x = true;
        ViewPager2 r11 = this.q;
        if (r11 == null) goto L39;
        r11.setCurrentItem(0, false);
        goto L39
    L33:
        r10 = 0;
    L39:
        if (isAdded() == false) goto L57;
        Iterator r12 = getChildFragmentManager().getFragments().iterator();
    L42:
        if (r12.hasNext() == false) goto L68;
        s19.a r13 = (Fragment) r12.next();
        if (aa0() == true) goto L46;
        if ((r13 instanceof s19.a) == false) goto L54;
        s19.a r14 = r13;
    L55:
        if (r14 == null) goto L42;
        r14.a2(r8);
        goto L42
    L54:
        r14 = null;
        goto L55
    L46:
        if ((r13 instanceof z) == false) goto L48;
        z r15 = (z) r13;
    L49:
        if (r15 == null) goto L42;
        r15.a2(r8);
        goto L42
    L48:
        r15 = null;
        goto L49
    L68:
        return;
    L57:
        return;
    L25:
        if (r2.length() == 0) goto L28;
        r7 = false;
        goto L29
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void jv(String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        g0a.b r0 = Y90();
        if (r0 == null) goto L6;
        r0.nI(null, r3);
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        boolean r0 = false;
        if (r4 == null) goto L5;
        r0 = r4.getBoolean("key_is_multi_tab", false);
    L5:
        this.v = r0;
        Bundle r5 = getArguments();
        if (r5 == null) goto L8;
        UserCreation r6 = (UserCreation) r5.getParcelable("creation");
    L9:
        this.y = r6;
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void y2(String r5) {
        if (r5 != null) goto L4;
        String r0 = "";
    L5:
        this.F = r0;
        g0a.b r1 = Y90();
        z r2 = null;
        if (r1 == null) goto L13;
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        String r4 = r3.getString("enter_method");
    L11:
        r1.nI(r5, r4);
        goto L13
    L10:
        r4 = null;
    L13:
        if (aa0() == false) goto L19;
        z r6 = Z90();
        if ((r6 instanceof z) == false) goto L17;
        r2 = r6;
    L17:
        if (r2 == null) goto L25;
        r2.y2(r5);
        return;
    L25:
        return;
    L19:
        z r7 = Z90();
        if ((r7 instanceof s19.a) == false) goto L22;
        r2 = (s19.a) r7;
    L22:
        if (r2 == null) goto L27;
        r2.y2(r5);
        return;
    L27:
        return;
    L4:
        r0 = r5;
        goto L5
    }

    public final void KC(boolean r3, Function0<Unit> r4) {
        s19.a r0 = Z90();
        if ((r0 instanceof s19.a) == false) goto L5;
        s19.a r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.KC(r3, r4);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r21, r22);
        FLogger r1 = FLogger.a;
        r1.d("CommunityCreateFragment[Kmp]", "onViewCreated isMultiTab=" + this.v + " isChatMultiTab=" + ((Boolean) this.A.getValue()).booleanValue() + " isSideBar=" + aa0());
        FragmentAttachExtKt.b(this, ContainerFilter.COMMUNITY_CREATE_KMP);
        final g0a.f r2 = s1a.a.g(this).o(Reflection.getOrCreateKotlinClass(g0a.f.class));
        if (r2 != null) goto L7;
        r1.e("CommunityCreateFragment[Kmp]", "IKMPCommunityCreateAbility not bound, fallback to legacy behavior");
        return;
    L7:
        if (((Boolean) this.A.getValue()).booleanValue() == false) goto L10;
        CommunityCreateLaunchModeKmp r3 = CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB;
    L14:
        if (r3 != CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB) goto L16;
        int r5 = 6;
    L17:
        boolean r6 = this.v;
        Bundle r4 = getArguments();
        if (r4 == null) goto L20;
        String r7 = r4.getString("enter_method");
    L21:
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        m0a.e r14 = new m0a.e(r3, r5, r6, "", r7, null, null, null, null, 0, null, 32736);
        FragmentActivity r8 = getActivity();
        if (aa0() == false) goto L26;
        CommunityCreateFragment r13 = this;
    L27:
        r2.yG(r14, new m0a.d(new CommunityCreateNavigatorAndroidImpl(r8, r13), new com.larus.ugc.feed.impl.spi.b(), new com.larus.ugc.feed.impl.spi.a(), new y0a.e(FlowRuntime.b().c())));
        g0a.b r9 = Y90();
        if ((r9 instanceof CommunityCreateEventFeature) == false) goto L30;
        CommunityCreateEventFeature r15 = (CommunityCreateEventFeature) r9;
    L31:
        if (r15 == null) goto L33;
        Intrinsics.checkNotNullParameter(r2, "ability");
        c0.b.d("CommunityCreateEventFeature", "bindMainAbility");
        r15.h = r2;
    L33:
        ((CommunityCreateLegacyBridgeViewModel) this.k.getValue()).bind(r2);
        ((CommunityCreateLegacyBridgeViewModel) this.k.getValue()).getTabListLiveData().observe(getViewLifecycleOwner(), new e(new com.larus.ugc.feed.impl.home.a(this)));
        ((CommunityCreateLegacyBridgeViewModel) this.k.getValue()).getFabVisibilityLiveData().observe(getViewLifecycleOwner(), new e(new com.larus.ugc.feed.impl.home.e(this)));
        ((CommunityCreateLegacyBridgeViewModel) this.k.getValue()).getPendingPublishedCreationLiveData().observe(getViewLifecycleOwner(), new e(new com.larus.ugc.feed.impl.home.f(this, r2)));
        if (this.v == false) goto L65;
        Context r10 = getContext();
        if (r10 == null) goto L92;
        u r11 = IBotDiscoverService.a.d(r10);
        if (r11 == 0) goto L92;
        this.s = r11;
        if ((r11 instanceof View) == false) goto L44;
        View r16 = (View) r11;
    L45:
        if (r16 == null) goto L92;
        if (r16.getId() != (-1)) goto L50;
        r16.setId(View.generateViewId());
    L50:
        ConstraintLayout r12 = this.n;
        if ((r12 instanceof ConstraintLayout) == false) goto L53;
        ConstraintLayout r17 = r12;
    L54:
        if (r17 == null) goto L92;
        View r18 = this.p;
        if (r18 == null) goto L59;
        int r19 = r18.getId();
    L60:
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, -2);
        r20.startToStart = 0;
        if (r19 == 0) goto L63;
        r20.endToStart = r19;
        r20.goneEndMargin = 0;
    L64:
        r20.bottomToBottom = 0;
        Unit r23 = Unit.INSTANCE;
        r17.addView(r16, 0, r20);
        e1.x(r17);
        r11.a(new com.larus.ugc.feed.impl.home.c(this));
        r11.c(new com.larus.ugc.feed.impl.home.d());
        goto L92
    L63:
        r20.endToEnd = 0;
        goto L64
    L59:
        r19 = 0;
        goto L60
    L53:
        r17 = null;
        goto L54
    L44:
        r16 = null;
    L92:
        CommunityMainAdapter r24 = new CommunityMainAdapter(this, this.v, (RecyclerView.RecycledViewPool) this.j.getValue());
        this.t = r24;
        ViewPager2 r25 = this.q;
        if (r25 == null) goto L95;
        r25.setAdapter(r24);
    L95:
        ViewPager2 r26 = this.q;
        if (r26 == null) goto L98;
        r26.setOffscreenPageLimit(3);
    L98:
        ViewPager2 r27 = this.q;
        if (r27 == null) goto L101;
        r27.registerOnPageChangeCallback(new CommunityCreateFragment$setupViewPager$1(this));
    L101:
        u r28 = this.s;
        if (r28 == null) goto L104;
        r28.a(new l(this));
    L104:
        View r29 = this.r;
        if (r29 == null) goto L107;
        r29.setOnClickListener(new k(r2, this));
    L107:
        ((CommunityCreateLegacyBridgeViewModel) this.k.getValue()).getShowAvatarLiveData().observe(getViewLifecycleOwner(), new e(new m(this)));
        View r30 = this.p;
        if (r30 == null) goto L110;
        r30.setOnClickListener(new com.larus.ugc.feed.impl.home.b(this));
    L110:
        AppHost.a.a().j(this.D);
        PollingConfigService.a.j(this.E);
        UserCreation r31 = this.y;
        if (r31 == null) goto L117;
        g0a.b r32 = Y90();
        if (r32 == null) goto L115;
        r32.mk(com.larus.ugc.feed.impl.mapper.c.b(r31));
    L115:
        this.y = null;
        return;
    L117:
        return;
    L65:
        int r33 = b.a[r3.ordinal()];
        if (r33 == 1) goto L92;
        if (r33 == 2) goto L82;
        if (r33 != 3) goto L81;
        View r34 = this.m;
        if (r34 == null) goto L77;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (r35 == null) goto L76;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
        i0.a.getClass();
        r36.topMargin = i0.g();
        r34.setLayoutParams(r36);
        goto L77
    L76:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L77:
        View r37 = this.m;
        if (r37 == null) goto L92;
        e1.x(r37);
        goto L92
    L81:
        throw new NoWhenBranchMatchedException();
    L82:
        View r38 = this.m;
        if (r38 == null) goto L89;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if (r39 == null) goto L88;
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r39;
        i0.a.getClass();
        r40.topMargin = i0.g();
        r38.setLayoutParams(r40);
        goto L89
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L89:
        View r41 = this.m;
        if (r41 == null) goto L92;
        e1.x(r41);
        goto L92
    L30:
        r15 = null;
        goto L31
    L26:
        r13 = null;
        goto L27
    L20:
        r7 = null;
        goto L21
    L16:
        r5 = 1;
        goto L17
    L10:
        if (aa0() == false) goto L12;
        r3 = CommunityCreateLaunchModeKmp.SIDE_BAR;
        goto L14
    L12:
        r3 = CommunityCreateLaunchModeKmp.STANDALONE;
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561925, r3, false);
        this.l = r5;
        this.m = r5.findViewById(2131388816);
        this.n = r5.findViewById(2131388009);
        this.o = r5.findViewById(2131374774);
        this.p = r5.findViewById(2131383224);
        this.q = r5.findViewById(2131392569);
        this.r = r5.findViewById(2131367591);
        return r5;
    }
}
