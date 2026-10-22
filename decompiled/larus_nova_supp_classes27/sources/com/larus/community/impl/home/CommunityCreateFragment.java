package com.larus.community.impl.home;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.databinding.LarusCommunityMainFragmentLayoutBinding;
import com.larus.community.impl.fragment.CommunityListFragment;
import com.larus.community.impl.view.CommunityCreateButton;
import com.larus.community.impl.viewmodel.CommunityCreateViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import tx9.x2;
import v19.i5;
import zp9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n*\u0002-?\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001gB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00109\u001a\u000200H\u0016J\u001a\u0010<\u001a\u0002002\u0006\u0010=\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010A\u001a\u000200H\u0016J\b\u0010B\u001a\u000200H\u0002J\u0014\u0010D\u001a\u0004\u0018\u00010\u000e2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u0010E\u001a\u000200H\u0002J\u000e\u0010F\u001a\u000200H\u0082@¢\u0006\u0002\u0010GJ\u000f\u0010H\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u0010IJ\f\u0010J\u001a\u000200*\u00020KH\u0002J\u0018\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020\u0012H\u0002J\b\u0010O\u001a\u000200H\u0002J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020\u001dH\u0016J\b\u0010S\u001a\u00020;H\u0016J\b\u0010T\u001a\u00020\u0012H\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0012\u0010W\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010X\u001a\u0002002\b\u0010Y\u001a\u0004\u0018\u000102H\u0016J\b\u0010Z\u001a\u000200H\u0016J \u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020\u001d2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010^H\u0016J\b\u0010_\u001a\u000200H\u0016J\b\u0010`\u001a\u000200H\u0002J\u0018\u0010a\u001a\u0002002\u0006\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020\u0012H\u0016J\u0018\u0010b\u001a\u0002002\u0006\u0010c\u001a\u00020;2\u0006\u0010N\u001a\u00020\u0012H\u0016J\u0010\u0010d\u001a\u0002002\u0006\u0010c\u001a\u00020;H\u0002J\b\u0010e\u001a\u000200H\u0016J\u0010\u0010f\u001a\u0002002\u0006\u0010N\u001a\u00020\u0012H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010!R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b*\u0010!R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u000e\u0010C\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/larus/community/impl/home/CommunityCreateFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "Lcom/larus/bmhome/chat/multi_tab/IChatMultiTabChildFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sharedPool$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityMainFragmentLayoutBinding;", "tabListView", "Lcom/larus/platform/api/creation/ITabListLayout;", "lastSelectedIndex", "", "lastTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "viewModel", "Lcom/larus/community/impl/viewmodel/CommunityCreateViewModel;", "getViewModel", "()Lcom/larus/community/impl/viewmodel/CommunityCreateViewModel;", "viewModel$delegate", "adapter", "Lcom/larus/community/impl/home/CommunityMainAdapter;", "hasResumedBefore", "", "isMultiTab", "isClickedTab", "isSideBar", "()Z", "isSideBar$delegate", "isChatMultiTab", "isChatMultiTab$delegate", "leaveStartTime", "", "innerPushUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "disableReportEnterTab", "isShowAvatar", "isShowAvatar$delegate", "appBackGroundListener", "com/larus/community/impl/home/CommunityCreateFragment$appBackGroundListener$1", "Lcom/larus/community/impl/home/CommunityCreateFragment$appBackGroundListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "previousPage", "", "onViewCreated", "view", "listener", "com/larus/community/impl/home/CommunityCreateFragment$listener$1", "Lcom/larus/community/impl/home/CommunityCreateFragment$listener$1;", "onDestroy", "handleProfileOverview", "isShowCreationTab", "initView", "setUpBottomFloatButton", "openMixCreationPage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCommunityCreateButton", "()Lkotlin/Unit;", "debounceSlip", "Landroidx/viewpager2/widget/ViewPager2;", "reportEnterAIGenerateTab", "enterMethod", "position", "setupTabListView", "hostUiPolicy", "Lcom/larus/community/api/spi/CommunityHostUiPolicy;", "autoLogEnterPage", "getCurrentPageName", "tabIndex", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "onEnterTab", "onNewIntent", "bundle", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "onDestroyView", "handleInnerPushCreation", "onChatTabSelected", "onChatTabUnselected", "leaveMethod", "reportLeaveAIGeneratePage", "onStop", "onChatTabReselected", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommunityCreateFragment extends BaseHomeTabFragment implements s19.a, z, ci8.c {
    public static final /* synthetic */ int C = 0;
    public final CommunityCreateFragment$listener$1 A;
    public volatile boolean B;
    public final Lazy j;
    public LarusCommunityMainFragmentLayoutBinding k;
    public u l;
    public int m;
    public TabItemInfo n;
    public final Lazy o;
    public CommunityMainAdapter p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final Lazy t;
    public final Lazy u;
    public long v;
    public UserCreation w;
    public boolean x;
    public final Lazy y;
    public final b z;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ CommunityCreateFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            CommunityCreateFragment r0 = this.a;
            int r1 = CommunityCreateFragment.C;
            r0.da0("leave_app");
        }

        public b(CommunityCreateFragment r1) {
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

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.community.impl.home.CommunityCreateFragment$listener$1] */
    public CommunityCreateFragment() {
        super(false);
        this.j = LazyKt.lazy(new e());
        this.m = -1;
        final Function0<Fragment> r0 = new CommunityCreateFragment$special$$inlined$viewModels$default$1(this);
        this.o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CommunityCreateViewModel.class), new CommunityCreateFragment$special$$inlined$viewModels$default$2(r0), new CommunityCreateFragment$special$$inlined$viewModels$default$3(r0, this));
        this.t = LazyKt.lazy(new f(this));
        this.u = LazyKt.lazy(new g(this));
        this.y = LazyKt.lazy(new h());
        this.z = new b(this);
        this.A = new CommunityCreateFragment$listener$1(this);
    }

    public final void LY(String r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveMethod");
    }

    public final boolean S90() {
        return false;
    }

    public final void ea0() {
        this.B = true;
        LarusCommunityMainFragmentLayoutBinding r0 = this.k;
        if (r0 == null) goto L7;
        CommunityCreateButton r1 = r0.b;
        if (r1 == null) goto L7;
        e1.x(r1);
    L7:
        LarusCommunityMainFragmentLayoutBinding r2 = this.k;
        if (r2 == null) goto L12;
        CommunityCreateButton r3 = r2.b;
        if (r3 == null) goto L12;
        e1.d(r3, new com.larus.community.impl.home.a(this));
    L12:
        LarusCommunityMainFragmentLayoutBinding r4 = this.k;
        if (r4 == null) goto L24;
        CommunityCreateButton r5 = r4.b;
        if (r5 == null) goto L17;
        r5.b();
    L17:
        LarusCommunityMainFragmentLayoutBinding r6 = this.k;
        if (r6 == null) goto L22;
        CommunityCreateButton r7 = r6.b;
        if (r7 == null) goto L22;
        r7.setAlpha(1.0f);
    L22:
        Unit r8 = Unit.INSTANCE;
        return;
    }

    public final void pp(String r1) {
    }

    public final boolean aa0() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    public final boolean ba0() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    @Override // s19.a
    public final int sb() {
        return BaseHomeTabFragment.MainTab.COMMUNITY_CREATE.getIndex();
    }

    public final void SL() {
        Fragment r0 = getCurrentFragment();
        if ((r0 instanceof CommunityListFragment) == false) goto L5;
        CommunityListFragment r1 = (CommunityListFragment) r0;
    L6:
        if (r1 == null) goto L11;
        zp9.l r2 = r1.S90();
        if (r2 == null) goto L12;
        zp9.l.a.a(r2, false, false, null, false, false, 31);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void Z90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L19;
        UserCreation r1 = this.w;
        if (r1 == null) goto L20;
        LarusCommunityMainFragmentLayoutBinding r2 = this.k;
        if (r2 == null) goto L11;
        ConstraintLayout r3 = r2.a;
        if (r3 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r1, "creation");
        Intrinsics.checkNotNullParameter(r0, "activity");
        Intrinsics.checkNotNullParameter(r3, "shareContainer");
        IUgcAIGCService.a.a(IUgcAIGCService.a, r1, r0, r3);
        LarusCommunityMainFragmentLayoutBinding r4 = this.k;
        if (r4 == null) goto L17;
        ViewPager2 r5 = r4.h;
        if (r5 == null) goto L17;
        r5.setCurrentItem(0, false);
    L17:
        this.w = null;
        return;
    L11:
        r3 = new View(getContext());
        goto L12
    L20:
        return;
    }

    public final Fragment getCurrentFragment() {
        Long r1 = null;
        if (isAdded() == false) goto L15;
        FragmentManager r0 = getChildFragmentManager();
        StringBuilder r2 = new StringBuilder("f");
        CommunityMainAdapter r3 = this.p;
        if (r3 == null) goto L13;
        LarusCommunityMainFragmentLayoutBinding r4 = this.k;
        if (r4 == null) goto L11;
        ViewPager2 r5 = r4.h;
        if (r5 == null) goto L11;
        int r6 = r5.getCurrentItem();
    L12:
        r1 = Long.valueOf(r3.getItemId(r6));
    L11:
        r6 = 0;
    L13:
        r2.append(r1);
        return r0.findFragmentByTag(r2.toString());
    L15:
        return null;
    }

    public final String k() {
        if (aa0() == false) goto L5;
        return "create_feed_top_tab";
    L5:
        return "ai_generate";
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        PollingConfigService.a.i(this.A);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.l = null;
        AppHost.a.a().c(this.z);
    }

    public final void onResume() {
        super.onResume();
        Z90();
        if (this.q == false) goto L5;
    L12:
        this.q = true;
        this.v = SystemClock.elapsedRealtime();
        return;
    L5:
        if (aa0() == true) goto L12;
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        String r1 = r0.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        if (r1 == null) goto L10;
    L11:
        ca0(r1, this.m);
    L10:
        r1 = "";
        goto L11
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
        if (r4 == false) goto L14;
        da0("enter_new_page");
        return;
    L14:
        return;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r2, 1), r0) == false) goto L7;
        goto L7
    }

    @Override // s19.a
    public final void t1() {
        z r1 = null;
        if (ba0() == false) goto L9;
        z r0 = getCurrentFragment();
        if ((r0 instanceof z) == false) goto L7;
        r1 = r0;
    L7:
        if (r1 == null) goto L14;
        r1.t1();
    L14:
        da0("leave_page");
        return;
    L9:
        z r2 = getCurrentFragment();
        if ((r2 instanceof s19.a) == false) goto L12;
        r1 = (s19.a) r2;
    L12:
        if (r1 == null) goto L14;
        r1.t1();
        goto L14
    }

    @Override // s19.a
    public final void a2(Bundle r5) {
        if (r5 == null) goto L9;
        String r2 = r5.getString("related_recommendation");
        if (r2 == null) goto L9;
        if (o0.d(r2) != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L27;
        LarusCommunityMainFragmentLayoutBinding r4 = this.k;
        if (r4 == null) goto L16;
        ViewPager2 r6 = r4.h;
        if (r6 == null) goto L16;
        int r7 = r6.getCurrentItem();
    L17:
        String r8 = r5.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        ca0(r8, 0);
        if (r7 == 0) goto L32;
        this.x = true;
        LarusCommunityMainFragmentLayoutBinding r0 = this.k;
        if (r0 == null) goto L32;
        ViewPager2 r1 = r0.h;
        if (r1 == null) goto L32;
        r1.setCurrentItem(0, false);
    L32:
        if (isAdded() == false) goto L50;
        List r9 = getChildFragmentManager().getFragments();
        if (r9 == null) goto L61;
        Iterator r10 = r9.iterator();
    L37:
        if (r10.hasNext() == false) goto L62;
        s19.a r11 = (Fragment) r10.next();
        s19.a r12 = null;
        if (ba0() == true) goto L41;
        if ((r11 instanceof s19.a) == false) goto L48;
        r12 = r11;
    L48:
        if (r12 == null) goto L37;
        r12.a2(r5);
        goto L37
    L41:
        if ((r11 instanceof z) == false) goto L43;
        r12 = (z) r11;
    L43:
        if (r12 == null) goto L37;
        r12.a2(r5);
        goto L37
    L62:
        return;
    L61:
        return;
    L50:
        return;
    L16:
        r7 = 0;
        goto L17
    L27:
        if (r5 == null) goto L32;
        UserCreation r13 = r5.getParcelable("creation");
        if (r13 == null) goto L32;
        this.w = r13;
        Z90();
    L9:
        r3 = false;
        goto L10
    }

    public final void da0(String r13) {
        if (aa0() == false) goto L6;
        return;
    L6:
        if (this.v > 0) goto L8;
        return;
    L8:
        long r0 = SystemClock.elapsedRealtime() - this.v;
        this.v = 0;
        u r2 = this.l;
        if (r2 == null) goto L34;
        int r3 = r2.getCurrent();
        CommunityMainAdapter r4 = this.p;
        if (r4 == null) goto L35;
        List<TabItemInfo> r5 = r4.d;
        if (r5 == null) goto L36;
        int r6 = r5.size();
        if (r3 < 0) goto L18;
        if (r3 >= r6) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L37;
        CommunityMainAdapter r8 = this.p;
        if (r8 == null) goto L38;
        List<TabItemInfo> r9 = r8.d;
        if (r9 == null) goto L39;
        TabItemInfo r10 = (TabItemInfo) CollectionsKt.getOrNull(r9, r3);
        if (r10 == null) goto L40;
        Bundle r11 = getArguments();
        if (r11 == null) goto L31;
        String r12 = r11.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        if (r12 == null) goto L31;
    L32:
        x2.f(r12, r13, "creation_feed", "1", r10.getName(), r10.getId(), k(), Long.valueOf(r0));
        return;
    L31:
        r12 = "";
        goto L32
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L18:
        r7 = false;
        goto L19
    L36:
        return;
    L35:
        return;
    }

    public final void jv(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterMethod");
        ca0(r2, 0);
    }

    public final void onCreate(Bundle r3) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        boolean r0 = false;
        if (r4 == null) goto L5;
        r0 = r4.getBoolean("key_is_multi_tab", false);
    L5:
        this.r = r0;
        Bundle r5 = getArguments();
        if (r5 == null) goto L8;
        UserCreation r6 = (UserCreation) r5.getParcelable("creation");
    L9:
        this.w = r6;
        boolean r7 = z2.a.o();
        CommunityCreateViewModel r1 = (CommunityCreateViewModel) this.o.getValue();
        boolean r2 = this.r;
        if (r7 == false) goto L12;
        String r8 = DowngradeSource.ENTER_PAGE.getValue();
    L13:
        r1.fetchTabList(r2, r8);
        if (e29.d.a(this).a(((Boolean) this.y.getValue()).booleanValue()) == false) goto L17;
        ((CommunityCreateViewModel) this.o.getValue()).fetchAvatarInfo(AccountService.a.getUserId());
        return;
    L17:
        return;
    L12:
        r8 = DowngradeSource.ENTER_CONVERSATION_LIST.getValue();
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    @Override // s19.a
    public final void y2(String r4) {
        ((CommunityCreateViewModel) this.o.getValue()).fetchTabList(this.r, DowngradeSource.ENTER_PAGE.getValue());
        z r1 = null;
        if (ba0() == false) goto L9;
        z r0 = getCurrentFragment();
        if ((r0 instanceof z) == false) goto L7;
        r1 = r0;
    L7:
        if (r1 == null) goto L15;
        r1.y2(r4);
        return;
    L15:
        return;
    L9:
        z r2 = getCurrentFragment();
        if ((r2 instanceof s19.a) == false) goto L12;
        r1 = (s19.a) r2;
    L12:
        if (r1 == null) goto L17;
        r1.y2(r4);
        return;
    }

    public static final Object Y90(CommunityCreateFragment r62, Continuation r63) {
        r62.getClass();
        if ((r63 instanceof CommunityCreateFragment$openMixCreationPage$1) == false) goto L7;
        CommunityCreateFragment$openMixCreationPage$1 r2 = (CommunityCreateFragment$openMixCreationPage$1) r63;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Bundle r8 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        IUgcAIGCService.Companion r6 = (IUgcAIGCService.Companion) r2.L$2;
        FragmentActivity r7 = (FragmentActivity) r2.L$1;
        z0 r9 = (z0) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L79:
        wc9.e r10 = (wc9.e) r1;
        z0 r12 = r9;
        IUgcAIGCService.Companion r11 = r6;
        FragmentActivity r13 = r7;
    L80:
        if (r10 == null) goto L82;
        String r14 = r10.a;
    L83:
        e0 r15 = (e0) AuthModelDelegate.b.e().getValue();
        if (r15 == null) goto L88;
        LaunchInfo r16 = r15.a;
        if (r16 == null) goto L88;
        String r17 = r16.W();
    L89:
        Bundle r18 = r62.getArguments();
        if (r18 == null) goto L95;
        String r20 = r18.getString("current_page");
        if (r20 == null) goto L95;
        String r110 = r20;
    L96:
        Bundle r21 = r62.getArguments();
        if (r21 == null) goto L102;
        String r22 = r21.getString("current_page");
        if (r22 == null) goto L102;
        String r111 = r22;
    L103:
        ChatParam r23 = new ChatParam(r14, r17, r110, r111, "default", 224);
        boolean r38 = !z2.a.f1().f();
        int r24 = e29.d.a;
        Intrinsics.checkNotNullParameter(r62, "fragment");
        ICommunityHostBehaviorProvider r25 = e29.d.c();
        if (r25 == null) goto L106;
        r8 = r25.a(r62);
    L106:
        n r26 = new n(r62);
        r11.W(new ny9.b(true, r13, r12, r23, true, false, null, null, null, null, null, null, null, Boxing.boxInt(4), null, null, null, null, null, false, false, r26, null, r8, false, null, null, null, r38, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -278929440, 262143));
    L108:
        return Unit.INSTANCE;
    L102:
        r111 = "";
    L95:
        r110 = "";
    L88:
        r17 = null;
        goto L89
    L82:
        r14 = null;
        goto L83
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        e0 r27 = (e0) AuthModelDelegate.b.e().getValue();
        if (r27 == null) goto L20;
        LaunchInfo r28 = r27.a;
        if (r28 == null) goto L20;
        String r30 = r28.W();
        if (r30 == null) goto L20;
    L21:
        List r31 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r30);
        if (r31 == null) goto L39;
        Iterator r32 = r31.iterator();
    L25:
        if (r32.hasNext() == false) goto L37;
        Object r112 = r32.next();
        r r113 = ((z0) r112).q;
        if (r113 == null) goto L34;
        Integer r114 = r113.a;
        if (r114 == null) goto L34;
        if (r114.intValue() != 28) goto L34;
        boolean r115 = true;
    L35:
        if (r115 == false) goto L25;
    L38:
        z0 r116 = (z0) r112;
    L40:
        if (r116 != null) goto L61;
        if (r31 == null) goto L58;
        Iterator r33 = r31.iterator();
    L44:
        if (r33.hasNext() == false) goto L56;
        Object r34 = r33.next();
        r r117 = ((z0) r34).q;
        if (r117 == null) goto L53;
        Integer r118 = r117.a;
        if (r118 == null) goto L53;
        if (r118.intValue() != 4) goto L53;
        boolean r119 = true;
    L54:
        if (r119 == false) goto L44;
    L57:
        z0 r35 = (z0) r34;
    L59:
        if (r35 == null) goto L119;
    L62:
        FragmentActivity r36 = r62.getActivity();
        if (r36 == null) goto L108;
        if ((!r36.isFinishing()) == false) goto L67;
        r7 = r36;
    L68:
        if (r7 == null) goto L108;
        r11 = IUgcAIGCService.a;
        ILaunchCacheService r120 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r120 == null) goto L75;
        r10 = r120.b();
        if (r10 == null) goto L75;
        r13 = r7;
        r12 = r35;
    L75:
        Flow r121 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        CommunityCreateFragment$openMixCreationPage$3$1 r122 = new CommunityCreateFragment$openMixCreationPage$3$1(null);
        r2.L$0 = r35;
        r2.L$1 = r7;
        r2.L$2 = r11;
        r2.label = 1;
        Object r37 = kotlinx.coroutines.flow.e.t(r121, r122, r2);
        if (r37 == r4) goto L120;
        r6 = r11;
        r1 = r37;
        r9 = r35;
        goto L79
    L120:
        return r4;
    L67:
        r7 = null;
        goto L68
    L119:
        return Unit.INSTANCE;
    L53:
        r119 = false;
        goto L54
    L56:
        r34 = null;
        goto L57
    L58:
        r35 = null;
        goto L59
    L61:
        r35 = r116;
    L34:
        r115 = false;
        goto L35
    L37:
        r112 = null;
        goto L38
    L39:
        r116 = null;
    L20:
        r30 = "";
    L7:
        r2 = new CommunityCreateFragment$openMixCreationPage$1(r62, r63);
        goto L8
    }

    @Override // s19.a
    public final void KC(boolean r3, Function0<Unit> r4) {
        s19.a r0 = getCurrentFragment();
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

    public final void ca0(String r9, int r10) {
        if (r10 >= 0) goto L6;
        boolean r11 = m29.a.a;
        m29.a.b("CommunityCreateFragment", "reportEnterAIGenerateTab position is not valid: " + r10);
        return;
    L6:
        boolean r1 = m29.a.a;
        m29.a.c("CommunityCreateFragment", "reportEnterAIGenerateTab position:" + r10);
        CommunityMainAdapter r0 = this.p;
        if (r0 == null) goto L26;
        List<TabItemInfo> r2 = r0.d;
        if (r2 == null) goto L27;
        TabItemInfo r12 = (TabItemInfo) CollectionsKt.getOrNull(r2, r10);
        if (r12 == null) goto L28;
        String r3 = k();
        String r4 = r12.getId();
        String r5 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        String r6 = r12.b();
        if (r6 == null) goto L20;
        r5 = r6;
    L20:
        TabItemInfo r7 = this.n;
        if (r7 == null) goto L23;
        String r8 = r7.getId();
    L24:
        p29.a.b(r3, null, r4, r5, r8, r9, null, 898);
        this.n = r12;
        return;
    L23:
        r8 = null;
        goto L24
    L28:
        return;
    L27:
        return;
    }

    public final void onViewCreated(View r110, Bundle r20) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r110, r20);
        LarusCommunityMainFragmentLayoutBinding r1 = this.k;
        String r2 = "CommunityCreateFragment";
        if (r1 == null) goto L202;
        CommunityMainAdapter r3 = new CommunityMainAdapter(this, this.r, (RecyclerView.RecycledViewPool) this.j.getValue());
        this.p = r3;
        LarusCommunityMainFragmentLayoutBinding r4 = this.k;
        if (r4 == null) goto L9;
        ViewPager2 r5 = r4.h;
        if (r5 == null) goto L9;
        r5.setAdapter(r3);
    L9:
        LarusCommunityMainFragmentLayoutBinding r6 = this.k;
        if (r6 == null) goto L15;
        ViewPager2 r7 = r6.h;
        if (r7 == null) goto L15;
        r7.setOffscreenPageLimit(3);
    L15:
        if (this.r == false) goto L151;
        Context r8 = getContext();
        if (r8 != null) goto L19;
    L18:
        r2 = "CommunityCreateFragment";
    L136:
        if (Intrinsics.areEqual(PollingConfigService.a.f("cre_tab_ent_dg"), "1") == false) goto L143;
        LarusCommunityMainFragmentLayoutBinding r9 = this.k;
        if (r9 == null) goto L142;
        CommunityCreateButton r10 = r9.b;
        if (r10 == null) goto L142;
        e1.o(r10);
    L142:
        this.B = false;
    L145:
        if (e29.d.a(this).a(((Boolean) this.y.getValue()).booleanValue()) == false) goto L183;
        ((CommunityCreateViewModel) this.o.getValue()).getUserInfoState().observe(getViewLifecycleOwner(), new c(new m(this)));
        LarusCommunityMainFragmentLayoutBinding r11 = this.k;
        if (r11 == null) goto L183;
        FrameLayout r12 = r11.e;
        if (r12 == null) goto L183;
        e1.d(r12, new com.larus.community.impl.home.b(this));
    L183:
        LarusCommunityMainFragmentLayoutBinding r13 = this.k;
        if (r13 == null) goto L189;
        ViewPager2 r14 = r13.h;
        if (r14 == null) goto L189;
        r14.registerOnPageChangeCallback(new CommunityCreateFragment$initView$1$3(this));
    L189:
        if (this.r == false) goto L195;
        LarusCommunityMainFragmentLayoutBinding r15 = this.k;
        if (r15 == null) goto L195;
        ViewPager2 r16 = r15.h;
        if (r16 == null) goto L195;
        Field r17 = ViewPager2.class.getDeclaredField("mRecyclerView");
        r17.setAccessible(true);
        Object r18 = r17.get(r16);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r21 = (RecyclerView) r18;
        Field r22 = RecyclerView.class.getDeclaredField("mTouchSlop");
        r22.setAccessible(true);
        Object r23 = r22.get(r21);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Int");
        r22.set(r21, Integer.valueOf(((Integer) r23).intValue() * 2));
    L195:
        u r24 = this.l;
        if (r24 == null) goto L198;
        r24.a(new j(this));
    L198:
        u r25 = this.l;
        if (r25 == null) goto L201;
        r25.c(new k());
    L201:
        ((CommunityCreateViewModel) this.o.getValue()).getTabListLiveData().observe(getViewLifecycleOwner(), new c(new l(this)));
    L203:
        FLogger.a.d(r2, "initView");
        AppHost.a.a().j(this.z);
        PollingConfigService.a.j(this.A);
        return;
    L143:
        ea0();
        goto L145
    L19:
        View r111 = m3.a.p(r8);
        if (r111 != null) goto L22;
        r111 = new r29.j(r8);
    L22:
        this.l = r111;
        boolean r26 = r111 instanceof View;
        if (r26 == false) goto L25;
        View r112 = r111;
    L26:
        if (r112 != null) goto L28;
        boolean r27 = m29.a.a;
        m29.a.b("CommunityCreateFragment", "tab list view is not view: " + this.l);
        goto L18
    L28:
        if (r26 == false) goto L30;
        View r113 = r111;
    L31:
        if (r113 == null) goto L18;
        LarusCommunityMainFragmentLayoutBinding r28 = this.k;
        if (r28 == null) goto L38;
        ConstraintLayout r30 = r28.f;
        if (r30 == null) goto L38;
        e1.x(r30);
    L38:
        if (ba0() == false) goto L48;
        LarusCommunityMainFragmentLayoutBinding r31 = this.k;
        if (r31 == null) goto L48;
        ConstraintLayout r32 = r31.f;
        if (r32 == null) goto L48;
        ViewGroup.LayoutParams r114 = r32.getLayoutParams();
        if (r114 == null) goto L47;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        i0.a.getClass();
        int r116 = i0.g() + i5.r0();
        ((ViewGroup.MarginLayoutParams) r115).topMargin = r116;
        r115.goneTopMargin = r116;
        r32.setLayoutParams(r115);
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L48:
        e29.e r33 = e29.d.a(this);
        if (r33.a(((Boolean) this.y.getValue()).booleanValue()) == false) goto L92;
        LarusCommunityMainFragmentLayoutBinding r34 = this.k;
        if (r34 == null) goto L56;
        FrameLayout r35 = r34.e;
        if (r35 == null) goto L56;
        e1.x(r35);
    L56:
        if (ba0() == false) goto L81;
        LarusCommunityMainFragmentLayoutBinding r36 = this.k;
        if (r36 == null) goto L62;
        ImageView r37 = r36.c;
        if (r37 == null) goto L62;
        e1.x(r37);
    L62:
        LarusCommunityMainFragmentLayoutBinding r38 = this.k;
        if (r38 == null) goto L67;
        ImageView r40 = r38.c;
        if (r40 == null) goto L67;
        e1.d(r40, new com.larus.community.impl.home.c(this));
    L67:
        LarusCommunityMainFragmentLayoutBinding r41 = this.k;
        if (r41 == null) goto L76;
        ConstraintLayout r42 = r41.a;
        if (r42 == null) goto L76;
        FragmentActivity r117 = getContext();
        if ((r117 instanceof FragmentActivity) == false) goto L74;
        FragmentActivity r43 = r117;
    L75:
        int r44 = com.larus.utils.u.b(r43);
        int r118 = r42.getPaddingStart();
        int r119 = r42.getPaddingTop();
        int r120 = r42.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r42.getClass().getSimpleName() + ",source:,start:" + r118 + ",top:" + r119 + ",end:" + r120 + ",bottom:" + r44);
        r42.setPaddingRelative(r118, r119, r120, r44);
        goto L76
    L74:
        r43 = null;
    L76:
        LarusCommunityMainFragmentLayoutBinding r45 = this.k;
        if (r45 == null) goto L91;
        ConstraintLayout r46 = r45.f;
        if (r46 == null) goto L91;
        ConstraintLayout.LayoutParams r47 = new ConstraintLayout.LayoutParams(0, -2);
        r47.startToEnd = 2131374773;
        r47.endToStart = 2131383223;
        r47.bottomToBottom = 0;
        Unit r48 = Unit.INSTANCE;
        r46.addView(r113, 0, r47);
    L91:
        r2 = "CommunityCreateFragment";
    L134:
        r113.setId(2131377235);
        goto L136
    L81:
        LarusCommunityMainFragmentLayoutBinding r50 = this.k;
        if (r50 == null) goto L86;
        ImageView r51 = r50.c;
        if (r51 == null) goto L86;
        e1.o(r51);
    L86:
        LarusCommunityMainFragmentLayoutBinding r52 = this.k;
        if (r52 == null) goto L91;
        ConstraintLayout r53 = r52.f;
        if (r53 == null) goto L91;
        ConstraintLayout.LayoutParams r54 = new ConstraintLayout.LayoutParams(0, -2);
        r54.startToStart = 0;
        r54.endToStart = 2131383223;
        r54.bottomToBottom = 0;
        Unit r55 = Unit.INSTANCE;
        r53.addView(r113, 0, r54);
        goto L91
    L92:
        LarusCommunityMainFragmentLayoutBinding r56 = this.k;
        if (r56 == null) goto L98;
        FrameLayout r57 = r56.e;
        if (r57 == null) goto L98;
        e1.o(r57);
    L98:
        if (ba0() == false) goto L124;
        LarusCommunityMainFragmentLayoutBinding r58 = this.k;
        if (r58 == null) goto L104;
        ImageView r60 = r58.c;
        if (r60 == null) goto L104;
        e1.x(r60);
    L104:
        LarusCommunityMainFragmentLayoutBinding r61 = this.k;
        if (r61 == null) goto L109;
        ImageView r62 = r61.c;
        if (r62 == null) goto L109;
        e1.d(r62, new d(this));
    L109:
        LarusCommunityMainFragmentLayoutBinding r63 = this.k;
        if (r63 == null) goto L119;
        ConstraintLayout r64 = r63.a;
        if (r64 == null) goto L119;
        FragmentActivity r65 = getContext();
        if ((r65 instanceof FragmentActivity) == false) goto L116;
        FragmentActivity r66 = r65;
    L117:
        int r67 = com.larus.utils.u.b(r66);
        int r121 = r64.getPaddingStart();
        int r122 = r64.getPaddingTop();
        int r123 = r64.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r64.getClass().getSimpleName() + ",source:,start:" + r121 + ",top:" + r122 + ",end:" + r123 + ",bottom:" + r67);
        r64.setPaddingRelative(r121, r122, r123, r67);
        goto L119
    L116:
        r66 = null;
    L119:
        LarusCommunityMainFragmentLayoutBinding r68 = this.k;
        if (r68 == null) goto L134;
        ConstraintLayout r70 = r68.f;
        if (r70 == null) goto L134;
        ConstraintLayout.LayoutParams r71 = new ConstraintLayout.LayoutParams(0, -2);
        r71.startToEnd = 2131374773;
        r71.endToEnd = 0;
        r71.setMarginEnd(r33.b);
        r71.bottomToBottom = 0;
        Unit r72 = Unit.INSTANCE;
        r70.addView(r113, 0, r71);
        goto L134
    L124:
        r2 = "CommunityCreateFragment";
        LarusCommunityMainFragmentLayoutBinding r73 = this.k;
        if (r73 == null) goto L129;
        ImageView r74 = r73.c;
        if (r74 == null) goto L129;
        e1.o(r74);
    L129:
        LarusCommunityMainFragmentLayoutBinding r75 = this.k;
        if (r75 == null) goto L134;
        ConstraintLayout r76 = r75.f;
        if (r76 == null) goto L134;
        ConstraintLayout.LayoutParams r77 = new ConstraintLayout.LayoutParams(0, -2);
        r77.startToStart = 0;
        r77.endToEnd = 0;
        r77.setMarginEnd(r33.b);
        r77.bottomToBottom = 0;
        Unit r78 = Unit.INSTANCE;
        r76.addView(r113, 0, r77);
        goto L134
    L30:
        r113 = null;
        goto L31
    L25:
        r112 = null;
        goto L26
    L151:
        r2 = "CommunityCreateFragment";
        if (aa0() == false) goto L168;
        LarusCommunityMainFragmentLayoutBinding r80 = this.k;
        if (r80 == null) goto L162;
        NovaTitleBarEx r81 = r80.g;
        if (r81 == null) goto L162;
        ViewGroup.LayoutParams r82 = r81.getLayoutParams();
        if (r82 == null) goto L161;
        ViewGroup.MarginLayoutParams r83 = (ViewGroup.MarginLayoutParams) r82;
        i0.a.getClass();
        r83.topMargin = i0.g();
        r81.setLayoutParams(r83);
        e1.x(r81);
        goto L162
    L161:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L162:
        ConstraintLayout r84 = r1.a;
        FragmentActivity r85 = getContext();
        if ((r85 instanceof FragmentActivity) == false) goto L165;
        FragmentActivity r86 = r85;
    L166:
        int r87 = com.larus.utils.u.b(r86);
        int r88 = r84.getPaddingStart();
        int r90 = r84.getPaddingTop();
        int r124 = r84.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r84.getClass().getSimpleName() + ",source:,start:" + r88 + ",top:" + r90 + ",end:" + r124 + ",bottom:" + r87);
        r84.setPaddingRelative(r88, r90, r124, r87);
        goto L183
    L165:
        r86 = null;
        goto L166
    L168:
        if (ba0() == false) goto L183;
        LarusCommunityMainFragmentLayoutBinding r91 = this.k;
        if (r91 == null) goto L178;
        NovaTitleBarEx r125 = r91.g;
        if (r125 == null) goto L178;
        ViewGroup.LayoutParams r92 = r125.getLayoutParams();
        if (r92 == null) goto L177;
        ViewGroup.MarginLayoutParams r93 = (ViewGroup.MarginLayoutParams) r92;
        i0.a.getClass();
        r93.topMargin = i0.g();
        r125.setLayoutParams(r93);
        e1.x(r125);
        FragmentActivity r94 = null;
        NovaTitleBarEx.Y5(r125, getString(2131897499), null, null, 6);
        NovaTitleBarEx.b6(r125, 2131242079, false, null, null, new i(this), 14);
    L179:
        ConstraintLayout r95 = r1.a;
        Context r96 = getContext();
        if ((r96 instanceof FragmentActivity) == false) goto L182;
        r94 = (FragmentActivity) r96;
    L182:
        int r97 = com.larus.utils.u.b(r94);
        int r98 = r95.getPaddingStart();
        int r100 = r95.getPaddingTop();
        int r126 = r95.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r95.getClass().getSimpleName() + ",source:,start:" + r98 + ",top:" + r100 + ",end:" + r126 + ",bottom:" + r97);
        r95.setPaddingRelative(r98, r100, r126, r97);
        goto L183
    L177:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L178:
        r94 = null;
        goto L179
    L202:
        r2 = "CommunityCreateFragment";
        goto L203
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = getLayoutInflater().inflate(2131561974, r11, false);
        int r14 = 2131367590;
        CommunityCreateButton r2 = (CommunityCreateButton) ViewBindings.findChildViewById(r13, 2131367590);
        if (r2 == null) goto L25;
        ConstraintLayout r15 = r13;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r13, 2131374773);
        if (r3 == null) goto L23;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r13, 2131383222);
        if (r4 == null) goto L22;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131383223);
        if (r5 == null) goto L21;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r13, 2131388008);
        if (r6 == null) goto L20;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r13, 2131388807);
        if (r7 == null) goto L19;
        ViewPager2 r8 = ViewBindings.findChildViewById(r13, 2131392568);
        if (r8 == null) goto L18;
        this.k = new LarusCommunityMainFragmentLayoutBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L18:
        r14 = 2131392568;
        goto L25
    L19:
        r14 = 2131388807;
        goto L25
    L20:
        r14 = 2131388008;
        goto L25
    L21:
        r14 = 2131383223;
        goto L25
    L22:
        r14 = 2131383222;
        goto L25
    L23:
        r14 = 2131374773;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
