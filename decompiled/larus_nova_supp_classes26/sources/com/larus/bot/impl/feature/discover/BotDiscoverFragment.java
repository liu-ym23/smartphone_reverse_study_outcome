package com.larus.bot.impl.feature.discover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.legacy.widget.Space;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.LaunchLandingConfigHelperDelegate;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.common.view.CommonTagListView;
import com.larus.bot.impl.common.view.NewCommonTagListView;
import com.larus.bot.impl.databinding.LarusPageBotDiscoverBinding;
import com.larus.bot.impl.databinding.LarusPageBotDiscoverListBinding;
import com.larus.bot.impl.feature.discover.adapter.BotDiscoverAdapter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.search.SearchBar;
import com.larus.community.api.ICommunityService;
import com.larus.home.api.main.HomeService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.settings.value.rh;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tx9.a1;
import tx9.i3;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001/\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00101\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020-H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00102\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u0002082\b\u00102\u001a\u0004\u0018\u00010-H\u0016J\u000f\u0010?\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010@J\u000f\u0010A\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010@J\b\u0010B\u001a\u00020+H\u0016J\u0014\u0010C\u001a\u00020+2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u000f\u0010F\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u00020+H\u0002J\b\u0010J\u001a\u00020+H\u0016J\b\u0010K\u001a\u00020+H\u0016J\u000f\u0010L\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010@J%\u0010M\u001a\u00020+2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010Q\u001a\u00020+H\u0002J\n\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0017\u0010T\u001a\u0004\u0018\u00010+2\u0006\u0010U\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010VJ\f\u0010W\u001a\u00020+*\u00020XH\u0002J\b\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020+H\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\n\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010_\u001a\u00020ZH\u0016J\b\u0010`\u001a\u00020\u0010H\u0016J\u0012\u0010a\u001a\u00020+2\b\u0010b\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010c\u001a\u00020+H\u0016J \u0010d\u001a\u00020+2\u0006\u0010e\u001a\u00020\u001b2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010gH\u0016J\u0010\u0010h\u001a\u00020+2\u0006\u0010N\u001a\u00020GH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b#\u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b'\u0010(R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006j"}, d2 = {"Lcom/larus/bot/impl/feature/discover/BotDiscoverFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/bot/api/model/discover/IBotDiscoverFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotDiscoverBinding;", "model", "Lcom/larus/bot/impl/feature/discover/BotDiscoverModel;", "getModel", "()Lcom/larus/bot/impl/feature/discover/BotDiscoverModel;", "model$delegate", "Lkotlin/Lazy;", "fragments", "Ljava/util/HashMap;", "", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/HashMap;", "lastIndex", "adapter", "Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverAdapter;", "tagList", "", "Lcom/larus/platform/api/creation/TabTag;", "status", "isFirst", "", "isDisplayPlaceHolder", "lastSelectedIndex", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "isNewStyle", "()Z", "isNewStyle$delegate", "isSideBar", "isSideBar$delegate", "outerInputController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "getOuterInputController", "()Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "outerInputController$delegate", "onNewIntent", "", "bundle", "Landroid/os/Bundle;", "callBack", "com/larus/bot/impl/feature/discover/BotDiscoverFragment$callBack$1", "Lcom/larus/bot/impl/feature/discover/BotDiscoverFragment$callBack$1;", "onCreate", "savedInstanceState", "onHiddenChanged", "hidden", "onSaveInstanceState", "outState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "()Lkotlin/Unit;", "updateBackIconWhenSearchLayShow", "onResume", "requestBotListWhenInit", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "getArgumentTagId", "", "()Ljava/lang/Long;", "initViewModel", "onDestroyView", "onDestroy", "setupBotCreateButton", "refresh", "tagId", "(Ljava/lang/Long;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;)V", "updateStatus", "startCreateBot", "initSearchView", "Lcom/larus/common_ui/search/SearchBar;", "reportClickTab", "position", "(I)Lkotlin/Unit;", "debounceSlip", "Landroidx/viewpager2/widget/ViewPager2;", "getCurrentPageName", "", "logEnterPage", "autoLogEnterPage", "parentTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPageName", "tabIndex", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "selectTag", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverFragment extends BaseHomeTabFragment implements ou8.a, com.larus.bmhome.z {
    public static final /* synthetic */ int y = 0;
    public LarusPageBotDiscoverBinding j;
    public final Lazy k;
    public final HashMap<Integer, Fragment> l;
    public int m;
    public BotDiscoverAdapter n;
    public List<zp9.w> o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public final et3.c t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final BotDiscoverFragment$callBack$1 x;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bot.impl.feature.discover.BotDiscoverFragment$callBack$1] */
    public BotDiscoverFragment() {
        super(false);
        final Function0<Fragment> r1 = new BotDiscoverFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotDiscoverModel.class), new BotDiscoverFragment$special$$inlined$viewModels$default$2(r1), new BotDiscoverFragment$special$$inlined$viewModels$default$3(r1, this));
        this.l = new HashMap();
        this.m = -1;
        this.o = CollectionsKt.emptyList();
        this.q = true;
        this.s = -1;
        this.t = new et3.c("bot_discover", false, null);
        this.u = LazyKt.lazy(new com.larus.bot.impl.feature.discover.a());
        this.v = LazyKt.lazy(new l(this));
        this.w = LazyKt.lazy(new n(this));
        this.x = new BotDiscoverFragment$callBack$1(this);
    }

    public final boolean S90() {
        return false;
    }

    public final void a2(Bundle r1) {
    }

    public final String getPageName() {
        return "bot_discover";
    }

    public final String k() {
        return "bot_list_discover";
    }

    public final void pp(String r1) {
    }

    public final void t1() {
        setUserVisibleHint(false);
        LarusPageBotDiscoverBinding r1 = this.j;
        if (r1 == null) goto L25;
        ViewPager2 r2 = r1.o;
        if (r2 == null) goto L31;
        Fragment r3 = this.l.get(Integer.valueOf(r2.getCurrentItem()));
        if (r3 == null) goto L10;
        r3.setUserVisibleHint(false);
    L10:
        LarusPageBotDiscoverBinding r0 = this.j;
        if (r0 == null) goto L26;
        ViewPager2 r4 = r0.o;
        if (r4 == null) goto L27;
        int r5 = r4.getCurrentItem();
        Fragment r6 = this.l.get(Integer.valueOf(r5));
        if ((r6 instanceof BotDiscoverListFragment) == false) goto L17;
        BotDiscoverListFragment r7 = (BotDiscoverListFragment) r6;
    L18:
        if (r7 == null) goto L28;
        LarusPageBotDiscoverListBinding r8 = r7.e;
        if (r8 == null) goto L29;
        RecyclerView r9 = r8.b;
        if (r9 == null) goto L30;
        y6.i(r9);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L17:
        r7 = null;
        goto L18
    L27:
        return;
    L26:
        return;
    L31:
        return;
    }

    public final void T90() {
        if (LaunchLandingConfigHelperDelegate.b.c(getArguments()) == false) goto L5;
        String r0 = "1";
    L6:
        a1.c(null, null, null, null, null, null, null, null, null, null, r0, null, null, null, null, "bot_discover", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -540673, -16777217, 7);
        return;
    L5:
        r0 = TriggerSendLoading.NO_LOADING;
        goto L6
    }

    public final BotDiscoverModel Z90() {
        return (BotDiscoverModel) this.k.getValue();
    }

    public final Unit ca0() {
        final LarusPageBotDiscoverBinding r0 = this.j;
        com.larus.home.impl.sdk.i r1 = null;
        if (r0 == null) goto L37;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L7;
        r2.f0();
        r1 = com.larus.home.impl.sdk.i.a;
    L7:
        com.larus.bmhome.chat.outerinput.c r3 = (com.larus.bmhome.chat.outerinput.c) this.w.getValue();
        boolean r4 = false;
        if (r3 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L15;
    L34:
        r0.d.setVisibility(8);
    L36:
        return Unit.INSTANCE;
    L15:
        if (z2.a.botCreateEnable() == false) goto L34;
        if (r1 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L31;
        e10 r7 = e10.a;
        int r8 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new rh())).booleanValue() == true) goto L25;
    L27:
        if (r4 == true) goto L31;
        if (ICommunityService.a.f1().l() == true) goto L31;
    L25:
        if (e10.h() == false) goto L27;
        r4 = true;
    L31:
        IFlowCreationThemeConfigProvider r9 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        if (r9 == null) goto L36;
        r9.b(r0.d, new q(r0, this), AdaptThemeFeatureKey.CREATION_BOT_DISCOVER_BOT_CREATE);
        goto L36
    L18:
        if (r1.b() != true) goto L20;
        r6 = true;
        goto L21
    L10:
        if (r3.a() != true) goto L12;
        r5 = true;
        goto L13
    L37:
        return null;
    }

    public final void da0() {
        LarusPageBotDiscoverBinding r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L7;
        r0.b.setVisibility(0);
        r0.b.setImageResource(2131242079);
        e1.d(r0.b, new m(this));
    L7:
        Unit r1 = Unit.INSTANCE;
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.DISCOVERY.getIndex();
    }

    public final Long Y90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L7;
        String r1 = r0.getString("tag");
        if (r1 == null) goto L7;
        Long r2 = StringsKt.toLongOrNull(r1);
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        Bundle r3 = getArguments();
        if (r3 == null) goto L16;
        String r4 = r3.getString("tag_id");
        if (r4 != null) goto L15;
        return null;
    L15:
        return StringsKt.toLongOrNull(r4);
    L16:
        return null;
    L7:
        r2 = null;
        goto L8
    }

    public final SearchBar aa0() {
        Context r0 = getContext();
        if (r0 == null) goto L10;
        final SearchBar r2 = new SearchBar(r0, null);
        if ((getActivity() instanceof BotDiscoverActivity) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-1, -2);
        r1.setMarginStart(i5.Y());
        r1.setMarginEnd(i5.h());
        r1.topMargin = i5.z();
        r1.bottomMargin = i5.j0();
        r2.setLayoutParams(r1);
    L8:
        e1.d(r2, new j(this, r2));
        return r2;
    L7:
        ViewGroup.MarginLayoutParams r3 = new ViewGroup.MarginLayoutParams(-1, -2);
        r3.setMarginStart(i5.q());
        r3.setMarginEnd(i5.q());
        r3.bottomMargin = i5.r0();
        r2.setLayoutParams(r3);
        goto L8
    L10:
        return null;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        BotStatusCacheDelegate.b.clear();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.n = null;
        LarusPageBotDiscoverBinding r1 = this.j;
        if (r1 == null) goto L5;
        r1.o.unregisterOnPageChangeCallback(this.x);
        this.m = r1.m.getCurrent();
    L5:
        this.j = null;
    }

    public final void onResume() {
        super.onResume();
        boolean r1 = false;
        if (Z90().getNeedPreloadBotList() == true) goto L8;
        DowngradeSource r0 = DowngradeSource.ENTER_PAGE;
        if (this.q == false) goto L19;
        ba0(Y90(), r0);
        this.q = false;
        return;
    L19:
        return;
    L8:
        if (Z90().getRefreshData().getValue() == null) goto L17;
        ic8.o0 r2 = (ic8.o0) Z90().getRefreshData().getValue();
        if (r2 == null) goto L16;
        List r3 = r2.b();
        if (r3 == null) goto L16;
        if (r3.isEmpty() != true) goto L16;
        r1 = true;
    L16:
        if (r1 == true) goto L17;
        return;
    L17:
        ba0(Y90(), DowngradeSource.ENTER_PAGE);
    }

    public final by7.e parentTrackNode() {
        by7.e r0 = getParentFragment();
        if ((r0 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void ea0(int r12) {
        this.p = r12;
        LarusPageBotDiscoverBinding r0 = this.j;
        if (r0 == null) goto L30;
        LinearLayout r1 = r0.j;
        if (r1 == null) goto L34;
        CommonTagListView r2 = r0.m;
        if (r2 == null) goto L35;
        int r3 = 0;
        if (r12 != 0) goto L13;
        this.r = false;
        r1.setVisibility(8);
        return;
    L13:
        if (r12 == 1) goto L21;
        if (r12 == 2) goto L18;
        return;
    L18:
        if (this.r == false) goto L31;
        r1.setVisibility(0);
        return;
    L31:
        return;
    L21:
        if (FeatureKitDelegate.b.g0().b() == false) goto L26;
        zp9.w[] r5 = new zp9.w[10];
    L23:
        if (r3 >= 10) goto L25;
        r5[r3] = new zp9.w(-1, null, 62);
        r3 = r3 + 1;
        goto L23
    L25:
        r2.d(ArraysKt.toList(r5));
    L26:
        this.r = true;
        r1.setVisibility(8);
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // ou8.a
    public final void fT(long r2) {
        ic8.o0 r0 = (ic8.o0) Z90().getRefreshData().getValue();
        if (r0 == null) goto L10;
        int r3 = r0.g(r2);
        LarusPageBotDiscoverBinding r4 = this.j;
        if (r4 == null) goto L11;
        ViewPager2 r5 = r4.o;
        if (r5 == null) goto L12;
        r5.setCurrentItem(r3, true);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onCreate(Bundle r56) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r56);
        setUserVisibleHint(false);
        if ((getActivity() instanceof BotDiscoverActivity) == false) goto L6;
        a1.c(null, null, null, null, null, "bot_discover", "bot_list_discover", null, "click_immersive_to_discover", null, null, null, null, null, null, "bot_discover", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -525697, -16777217, 7);
    L6:
        if (r56 == null) goto L8;
        BotDiscoverFragment r2 = this;
        int r0 = r56.getInt("last_index", r2.m);
    L9:
        r2.m = r0;
        return;
    L8:
        r2 = this;
        r0 = r2.m;
        goto L9
    }

    public final void onHiddenChanged(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(r3);
        LarusPageBotDiscoverBinding r0 = this.j;
        if (r0 == null) goto L10;
        ViewPager2 r1 = r0.o;
        if (r1 == null) goto L11;
        Fragment r2 = this.l.get(Integer.valueOf(r1.getCurrentItem()));
        if (r2 == null) goto L12;
        r2.setUserVisibleHint(!r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        LarusPageBotDiscoverBinding r0 = this.j;
        if (r0 == null) goto L7;
        CommonTagListView r1 = r0.m;
        if (r1 == null) goto L7;
        int r2 = r1.getCurrent();
    L8:
        r3.putInt("last_index", r2);
        super.onSaveInstanceState(r3);
        return;
    L7:
        r2 = this.m;
        goto L8
    }

    public final void y2(final String r10) {
        FLogger.a.i("BotDiscoverFragment", "onEnterTab, previousPage:" + r10);
        getViewLifecycleOwnerLiveData().observeForever(new b(new o(this, r10)));
        setUserVisibleHint(true);
        if (getActivity() != null) goto L5;
    L7:
        LarusPageBotDiscoverBinding r0 = this.j;
        if (r0 == null) goto L19;
        ViewPager2 r1 = r0.o;
        if (r1 == null) goto L21;
        Fragment r2 = this.l.get(Integer.valueOf(r1.getCurrentItem()));
        if (r2 == null) goto L16;
        r2.setUserVisibleHint(true);
    L16:
        if (FeatureKitDelegate.b.V().b() == false) goto L20;
        i3.b(null, null, null, null, null, "bot", null, this, 95);
        return;
    L20:
        return;
    L21:
        return;
    L19:
        return;
    L5:
        if (Z90().getNeedShowNetErrorToast() == false) goto L7;
        Z90().setNeedShowNetErrorToast(false);
        t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        goto L7
    }

    public final void KC(boolean r1, Function0<Unit> r2) {
        LarusPageBotDiscoverBinding r3 = this.j;
        if (r3 == null) goto L13;
        ViewPager2 r4 = r3.o;
        if (r4 == null) goto L14;
        int r5 = r4.getCurrentItem();
        Fragment r6 = this.l.get(Integer.valueOf(r5));
        if ((r6 instanceof BotDiscoverListFragment) == false) goto L9;
        BotDiscoverListFragment r7 = (BotDiscoverListFragment) r6;
    L10:
        if (r7 == null) goto L15;
        r7.ba0();
        return;
    L15:
        return;
    L9:
        r7 = null;
        goto L10
    L14:
        return;
    }

    public final void ba0(Long r10, DowngradeSource r11) {
        Iterator<T> r0 = this.o.iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        long r4 = ((zp9.w) r1).a;
        if (r10 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L3;
    L15:
        zp9.w r2 = (zp9.w) r1;
        if (r2 == null) goto L18;
        r3 = r2.b;
    L18:
        ea0(1);
        Z90().refreshData(r10, r3, r11);
        return;
    L9:
        if (r4 != r10.longValue()) goto L11;
        r5 = true;
        goto L12
    L14:
        r1 = null;
        goto L15
    }

    public final void onViewCreated(View r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r24, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r24, r25);
        if (z2.a.x3().getHideBottomTabDiscovery() == false) goto L6;
        r24.setVisibility(8);
        return;
    L6:
        final LarusPageBotDiscoverBinding r10 = this.j;
        if (r10 == null) goto L70;
        ca0();
        NovaTitleBarEx.Y5(r10.n, getString(2131900769), null, null, 6);
        if (((Boolean) this.u.getValue()).booleanValue() == false) goto L28;
        r10.n.setVisibility(8);
        e1.o(r10.k);
        e1.x(r10.e);
        NewCommonTagListView r0 = r10.f;
        Function2<? super Integer, ? super String, Unit> r2 = new r(r10);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "click");
        r0.c = r2;
        NewCommonTagListView r1 = r10.f;
        Function0<Boolean> r3 = new u(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "scroll");
        r1.d = r3;
        e1.d(r10.h, new com.larus.bot.impl.feature.discover.b(this));
        ConstraintLayout.LayoutParams r4 = r10.o.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r4.topToBottom = 2131380702;
        if (FeatureKitDelegate.b.V().b() == true) goto L14;
        e1.o(r10.h);
        e1.o(r10.g);
    L14:
        if ((getActivity() instanceof BotDiscoverActivity) == false) goto L17;
        e1.x(r10.c);
        e1.d(r10.c, new c(this));
        final BotDiscoverFragment r5 = this;
    L53:
        HashMap<Integer, Fragment> r6 = r5.l;
        if (r10.d.getVisibility() != 0) goto L56;
        boolean r7 = true;
    L57:
        r5.n = new BotDiscoverAdapter(r5, r6, r7);
        e10 r8 = e10.a;
        if (Intrinsics.areEqual(e10.s0().d(), Boolean.TRUE) == false) goto L60;
        r10.o.setOffscreenPageLimit(3);
    L60:
        r10.o.setAdapter(r5.n);
        r10.o.registerOnPageChangeCallback(r5.x);
        ViewPager2 r9 = r10.o;
        Field r11 = ViewPager2.class.getDeclaredField("mRecyclerView");
        r11.setAccessible(true);
        Object r12 = r11.get(r9);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r13 = (RecyclerView) r12;
        Field r14 = RecyclerView.class.getDeclaredField("mTouchSlop");
        r14.setAccessible(true);
        Object r15 = r14.get(r13);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Int");
        r14.set(r13, Integer.valueOf(((Integer) r15).intValue() * 4));
        e1.d(r10.j, new t(r5));
        if (Z90().getNeedPreloadBotList() == true) goto L63;
    L69:
        Unit r16 = Unit.INSTANCE;
    L71:
        Z90().getRefreshData().observe(getViewLifecycleOwner(), new b(new p(r5)));
        ca0();
        return;
    L63:
        if (HomeService.a.o() == false) goto L65;
        DowngradeSource r17 = DowngradeSource.ENTER_PAGE;
    L67:
        if (r5.q == false) goto L69;
        r5.ba0(Y90(), r17);
        r5.q = false;
        goto L69
    L65:
        r17 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L67
    L56:
        r7 = false;
        goto L57
    L17:
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L27;
        Space r18 = r10.l;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L26;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        com.larus.utils.i0.a.getClass();
        r20.topMargin = com.larus.utils.i0.g();
        r18.setLayoutParams(r20);
        e1.x(r10.c);
        r10.c.setImageResource(2131242079);
        e1.d(r10.c, new d(this));
        NovaTitleBarEx.b6(r10.n, 2131242079, false, null, null, new e(this), 14);
        i3.b(null, null, null, null, null, "bot", null, this, 95);
        ConstraintLayout r21 = r10.a;
        FragmentActivity r22 = getContext();
        if ((r22 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r23 = r22;
    L24:
        int r26 = com.larus.utils.u.b(r23);
        int r27 = r21.getPaddingStart();
        int r28 = r21.getPaddingTop();
        int r29 = r21.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r21.getClass().getSimpleName() + ",source:,start:" + r27 + ",top:" + r28 + ",end:" + r29 + ",bottom:" + r26);
        r21.setPaddingRelative(r27, r28, r29, r26);
        goto L27
    L23:
        r23 = null;
        goto L24
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L27:
        r5 = this;
        goto L53
    L28:
        e1.o(r10.e);
        ConstraintLayout.LayoutParams r30 = r10.o.getLayoutParams();
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r30.topToBottom = 2131388112;
        if ((getActivity() instanceof BotDiscoverActivity) == false) goto L33;
        r5 = this;
        NovaTitleBarEx.b6(r10.n, 2131241477, false, null, null, new f(r5), 14);
        LarusPageBotDiscoverBinding r31 = r5.j;
        if (r31 == null) goto L46;
        r31.b.setVisibility(0);
        e1.d(r31.b, new g(r5));
    L46:
        if (FeatureKitDelegate.b.V().b() == false) goto L52;
        View r32 = aa0();
        if (r32 != null) goto L51;
        r32 = new View(getContext());
    L51:
        r10.k.addView(r32);
        da0();
        r10.n.setVisibility(8);
    L52:
        CommonTagListView r33 = r10.m;
        Function2<? super Integer, ? super String, Unit> r34 = new i(r10);
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "click");
        r33.c = r34;
        CommonTagListView r35 = r10.m;
        Function0<Boolean> r36 = new s(r5);
        r35.getClass();
        Intrinsics.checkNotNullParameter(r36, "scroll");
        r35.d = r36;
        goto L53
    L33:
        r5 = this;
        if (((Boolean) r5.v.getValue()).booleanValue() == false) goto L46;
        Space r37 = r10.l;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        if (r38 == null) goto L43;
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r38;
        com.larus.utils.i0.a.getClass();
        r39.topMargin = com.larus.utils.i0.g();
        r37.setLayoutParams(r39);
        NovaTitleBarEx.b6(r10.n, 2131242079, false, null, null, new h(r5), 14);
        ConstraintLayout r40 = r10.a;
        FragmentActivity r41 = getContext();
        if ((r41 instanceof FragmentActivity) == false) goto L40;
        FragmentActivity r42 = r41;
    L41:
        int r43 = com.larus.utils.u.b(r42);
        int r44 = r40.getPaddingStart();
        int r45 = r40.getPaddingTop();
        int r46 = r40.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r40.getClass().getSimpleName() + ",source:,start:" + r44 + ",top:" + r45 + ",end:" + r46 + ",bottom:" + r43);
        r40.setPaddingRelative(r44, r45, r46, r43);
        goto L46
    L40:
        r42 = null;
        goto L41
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L70:
        r5 = this;
        goto L71
    }

    public final View onCreateView(LayoutInflater r21, ViewGroup r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r21, "inflater");
        ConstraintLayout r1 = getLayoutInflater().inflate(2131563000, r22, false);
        int r2 = 2131363779;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r1, 2131363779);
        if (r6 == null) goto L53;
        r2 = 2131363780;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r1, 2131363780);
        if (r7 == null) goto L53;
        r2 = 2131364358;
        CreateBotButton r8 = (CreateBotButton) ViewBindings.findChildViewById(r1, 2131364358);
        if (r8 == null) goto L53;
        ConstraintLayout r3 = r1;
        ConstraintLayout r9 = ViewBindings.findChildViewById(r1, 2131380702);
        if (r9 == null) goto L51;
        NewCommonTagListView r10 = (NewCommonTagListView) ViewBindings.findChildViewById(r1, 2131380703);
        if (r10 != null) goto L13;
        r2 = 2131380703;
        goto L53
    L13:
        if (ViewBindings.findChildViewById(r1, 2131380704) == null) goto L49;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r1, 2131380705);
        if (r11 == null) goto L48;
        AppCompatImageView r12 = ViewBindings.findChildViewById(r1, 2131380706);
        if (r12 == null) goto L47;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131381753);
        if (r13 == null) goto L46;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131384140);
        if (r14 != null) goto L23;
        r2 = 2131384140;
        goto L53
    L23:
        if (((TextView) ViewBindings.findChildViewById(r1, 2131384145)) == null) goto L44;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131385526);
        if (r15 == null) goto L43;
        Space r16 = ViewBindings.findChildViewById(r1, 2131386408);
        if (r16 == null) goto L42;
        CommonTagListView r17 = (CommonTagListView) ViewBindings.findChildViewById(r1, 2131388112);
        if (r17 == null) goto L41;
        NovaTitleBarEx r18 = (NovaTitleBarEx) ViewBindings.findChildViewById(r1, 2131388807);
        if (r18 == null) goto L40;
        ViewPager2 r19 = ViewBindings.findChildViewById(r1, 2131392567);
        if (r19 == null) goto L39;
        this.j = new LarusPageBotDiscoverBinding(r3, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        if (r3 == null) goto L37;
        r3.setTag(2131377847, this);
        return r3;
    L37:
        return null;
    L39:
        r2 = 2131392567;
        goto L53
    L40:
        r2 = 2131388807;
        goto L53
    L41:
        r2 = 2131388112;
        goto L53
    L42:
        r2 = 2131386408;
        goto L53
    L43:
        r2 = 2131385526;
        goto L53
    L44:
        r2 = 2131384145;
        goto L53
    L46:
        r2 = 2131381753;
        goto L53
    L47:
        r2 = 2131380706;
        goto L53
    L48:
        r2 = 2131380705;
        goto L53
    L49:
        r2 = 2131380704;
        goto L53
    L51:
        r2 = 2131380702;
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
