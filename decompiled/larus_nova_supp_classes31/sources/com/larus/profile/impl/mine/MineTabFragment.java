package com.larus.profile.impl.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.list.ListAdapter;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.api.AiChatTraceDelegate;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.bot.api.IBotCreateService;
import com.larus.home.api.main.IHomeApi;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.larus.profile.impl.ProfileRequestSource;
import com.larus.profile.impl.databinding.LarusFragmentMineTabBinding;
import com.larus.profile.impl.databinding.LarusProfileInfoViewBinding;
import com.larus.profile.impl.view.MineTabTitleBar;
import com.larus.profile.impl.view.ProfileInfoView;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00015\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\u000f\u0010/\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002J\b\u00107\u001a\u00020\u0018H\u0016J\b\u00108\u001a\u00020\u0018H\u0016J\b\u00109\u001a\u00020\u0018H\u0016J\b\u0010:\u001a\u000203H\u0016J\b\u0010;\u001a\u00020\u000eH\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u000203H\u0016J\b\u0010?\u001a\u00020@H\u0016J\u0012\u0010A\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u000103H\u0016J\b\u0010C\u001a\u00020\u0018H\u0016J \u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u000e2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001d\u0010\u001eR\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106¨\u0006J"}, d2 = {"Lcom/larus/profile/impl/mine/MineTabFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusFragmentMineTabBinding;", "viewModel", "Lcom/larus/profile/impl/mine/MineTabViewModel;", "getViewModel", "()Lcom/larus/profile/impl/mine/MineTabViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "firstLoadUserInfo", "", "refreshUserInfoWhenFailed", "needLoading", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "profileOverviewObserver", "Landroidx/lifecycle/Observer;", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "onNewIntent", "", "bundle", "Landroid/os/Bundle;", "outerInputController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "getOuterInputController", "()Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "outerInputController$delegate", "onCreate", "savedInstanceState", "initLoadMoreManager", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "initViewModel", "initFragmentResultListener", "registerObservations", "setupBotCreateButton", "()Lkotlin/Unit;", "startCreateBot", "enterMethod", "", "viewUpdateCallback", "com/larus/profile/impl/mine/MineTabFragment$viewUpdateCallback$1", "Lcom/larus/profile/impl/mine/MineTabFragment$viewUpdateCallback$1;", "onResume", "onDestroyView", "onDestroy", "getCurrentPageName", "autoLogEnterPage", "parentTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPageName", "tabIndex", "", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "mergeAllReferrerParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MineTabFragment extends BaseHomeTabFragment implements s19.a {
    public static final String s = null;
    public LarusFragmentMineTabBinding j;
    public final Lazy k;
    public boolean l;
    public boolean m;
    public boolean n;
    public LoadMoreManager o;
    public final k p;
    public final Lazy q;
    public final c r;

    public static final class a {
        public a() {
        }
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

    public static final class c implements ProfileInfoView.b {
        public final /* synthetic */ MineTabFragment a;

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final void c() {
            MineTabFragment r0 = this.a;
            String r1 = MineTabFragment.s;
            r0.Y90().queryUserInfo(ProfileRequestSource.RETRY);
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final void h() {
            if (z2.a.botCreateEnable() == false) goto L6;
            MineTabFragment r0 = this.a;
            String r1 = MineTabFragment.s;
            r0.X3("click_placeholder");
            return;
        }

        public c(MineTabFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final Unit a(fs9.n r3) {
            MineTabFragment r0 = this.a;
            String r1 = MineTabFragment.s;
            r0.Y90().updateCreateScene(r3);
            return Unit.INSTANCE;
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final void b(boolean r2) {
            LarusFragmentMineTabBinding r0 = this.a.j;
            if (r0 == null) goto L10;
            MineTabTitleBar r1 = r0.e;
            if (r2 == false) goto L7;
            int r3 = 0;
        L8:
            r1.V5(r3);
            return;
        L7:
            r3 = 8;
            goto L8
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final void e(r38.b r3) {
            Intrinsics.checkNotNullParameter(r3, "userInfo");
            LarusFragmentMineTabBinding r0 = this.a.j;
            if (r0 == null) goto L19;
            MineTabTitleBar r1 = r0.e;
            String r4 = r3.d();
            if (r4 != null) goto L7;
            r4 = "";
        L7:
            MineTabTitleBar.S5(r1, r4);
            LinearLayoutManager r5 = r0.d.e;
            int r2 = 0;
            if (r5 == null) goto L10;
            int r6 = r5.findFirstVisibleItemPosition();
        L11:
            if (r6 == 0) goto L13;
            boolean r7 = true;
        L14:
            if (r7 == true) goto L17;
            r2 = 8;
        L17:
            r0.e.V5(r2);
            return;
        L13:
            r7 = false;
            goto L14
        L10:
            r6 = 0;
            goto L11
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final Unit g(fs9.n r3) {
            MineTabFragment r0 = this.a;
            String r1 = MineTabFragment.s;
            r0.Y90().createConversationByBot(r3);
            return Unit.INSTANCE;
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final Object d(fs9.n r3, Continuation<? super String> r4) {
            MineTabFragment r0 = this.a;
            String r1 = MineTabFragment.s;
            return r0.Y90().createLocalConversation(r3, r4);
        }

        @Override // com.larus.profile.impl.view.ProfileInfoView.b
        public final Unit f(String r3, String r4) {
            MineTabFragment r0 = this.a;
            String r1 = MineTabFragment.s;
            r0.Y90().removeConversationByBot(r3, r4);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.profile.impl.mine.k] */
    public MineTabFragment() {
        super(false);
        final Function0<Fragment> r0 = new MineTabFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MineTabViewModel.class), new MineTabFragment$special$$inlined$viewModels$default$2(r0), new MineTabFragment$special$$inlined$viewModels$default$3(r0, this));
        this.l = true;
        this.n = true;
        this.p = new k(this);
        this.q = LazyKt.lazy(new l(this));
        this.r = new c(this);
    }

    public final void KC(boolean r1, Function0<Unit> r2) {
    }

    public final boolean S90() {
        return false;
    }

    public final void a2(Bundle r1) {
    }

    public final boolean et() {
        return true;
    }

    public final String getPageName() {
        return "personal_homepage";
    }

    public final String k() {
        return "bot_list_profile";
    }

    static {
        s = "MineTabFragment" + new a().hashCode();
    }

    public final MineTabViewModel Y90() {
        return (MineTabViewModel) this.k.getValue();
    }

    public final void onDestroy() {
        FLogger.a.i(s, "[onDestroy]");
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.MINE.getIndex();
    }

    public final void t1() {
        LarusFragmentMineTabBinding r0 = this.j;
        if (r0 == null) goto L10;
        ProfileInfoView r1 = r0.d;
        if (r1 == null) goto L11;
        RecyclerView r2 = r1.getRecyclerView();
        if (r2 == null) goto L12;
        y6.i(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Y90().getUserInfoState().removeObserver(this.p);
    }

    public final void onResume() {
        super.onResume();
        if (this.l == true) goto L5;
        Y90().queryUserInfo(ProfileRequestSource.REFRESH);
        return;
    L5:
        this.m = true;
    }

    public final by7.e parentTrackNode() {
        by7.e r0 = getParentFragment();
        if ((r0 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void X3(String r8) {
        IAuthModelService r0 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r0 == null) goto L18;
        LiveData r1 = r0.e();
        if (r1 == null) goto L19;
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) r1.getValue();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.a == null) goto L21;
        IBotCreateService.Companion r3 = IBotCreateService.a;
        nq9.c r4 = r3.i("bot_list_profile", r8);
        String r5 = null;
        if (r4 == null) goto L13;
        String r6 = r4.b;
    L14:
        if (r4 == null) goto L16;
        r5 = r4.a;
    L16:
        com.bytedance.router.i r7 = SmartRouter.buildRoute(getContext(), r3.k());
        Bundle r9 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "personal_homepage"), TuplesKt.to("enter_method", r8), TuplesKt.to("create_way", r6), TuplesKt.to("creation_id", r5), TuplesKt.to("previous_page", "bot_list_profile")});
        by7.h.k(r9, this);
        r7.c.putExtras(r9);
        r7.d = 2130772401;
        r7.e = 2130772399;
        r7.d();
        AiChatTraceDelegate.b.a(r8, r6, r5);
        return;
    L13:
        r6 = null;
        goto L14
    L21:
        return;
    L19:
        return;
    }

    public final void onCreate(Bundle r4) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r4);
        FLogger.a.i(s, "[onCreate]");
        Y90().setUserId(ILoginService.a.getAccountInfo().c);
        Y90().queryUserInfo(ProfileRequestSource.MINE_INIT);
        Context r5 = getContext();
        if (r5 == null) goto L6;
        this.o = new LoadMoreManager(r5, new h(this), null);
    L6:
        requireParentFragment().getParentFragmentManager().setFragmentResultListener("back_from_setting", this, new com.larus.profile.impl.mine.a());
    }

    public final void y2(final String r5) {
        FLogger.a.i(s, "onEnterTab, previousPage:" + r5);
        getViewLifecycleOwnerLiveData().observeForever(new b(new g(this, r5)));
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        final LarusFragmentMineTabBinding r8 = this.j;
        boolean r9 = false;
        if (r8 == null) goto L28;
        r8.e.bringToFront();
        r8.e.U5(getString(2131898833), new m(this));
        IHomeApi r1 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r1 == null) goto L11;
        hb9.a r2 = r1.d0();
        if (r2 == null) goto L11;
        if (true != r2.a()) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
    L17:
        ProfileInfoView r4 = r8.d;
        LoadMoreManager r5 = this.o;
        r4.f = r5;
        LarusProfileInfoViewBinding r10 = r4.c;
        if (r10 == null) goto L27;
        RecyclerView r11 = r10.c;
        if (r11 == null) goto L27;
        ListAdapter r12 = r4.d;
        if (r12 == null) goto L27;
        if (r5 == null) goto L27;
        r5.d(r11, r12);
    L27:
        r8.d.setViewUpdateCallback(this.r);
        r8.d.setTracePageName("personal_homepage");
        r8.d.setEnterFrom("bot_list_profile");
        r8.d.setMobPageName("bot_list_profile");
        ProfileInfoView r13 = r8.d;
        Function0<Unit> r14 = new com.larus.profile.impl.mine.c(this);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "action");
        r13.j = r14;
        r8.d.setQrCodeAction(new d(this));
        goto L28
    L14:
        if (com.larus.bmhome.b0.b(this) == true) goto L16;
        INotifyRedDotLifecycleObserver r15 = INotifyService.a.g(LifecycleOwnerKt.getLifecycleScope(this));
        getLifecycle().addObserver(r15);
    L16:
        r8.e.T5(2131243459, new n(this));
        INotifyService.a.e().a().observe(getViewLifecycleOwner(), new b(new com.larus.profile.impl.mine.b(r8)));
    L11:
        r3 = false;
    L28:
        final LarusFragmentMineTabBinding r16 = this.j;
        if (r16 == null) goto L53;
        com.larus.bmhome.chat.outerinput.c r17 = (com.larus.bmhome.chat.outerinput.c) this.q.getValue();
        if (r17 != null) goto L33;
    L35:
        boolean r18 = false;
    L36:
        if (r18 == false) goto L38;
    L51:
        r16.b.setVisibility(8);
    L52:
        Unit r19 = Unit.INSTANCE;
        goto L53
    L38:
        if (z2.a.botCreateEnable() == false) goto L51;
        IHomeApi r20 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r20 == null) goto L46;
        hb9.a r21 = r20.d0();
        if (r21 == null) goto L46;
        if (true != r21.b()) goto L46;
        r9 = true;
    L46:
        if (r9 == true) goto L51;
        IFlowCreationThemeConfigProvider r22 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        if (r22 == null) goto L52;
        r22.b(r16.b, new f(r16, this), AdaptThemeFeatureKey.CREATION_MINE_TAB_BOT_CREATE);
        goto L52
    L33:
        if (r17.a() != true) goto L35;
        r18 = true;
    L53:
        LifecycleOwner r23 = getViewLifecycleOwner();
        Y90().getUserInfoState().observeForever(this.p);
        Y90().getLoadMoreState().observe(r23, new b(new i(this)));
        Y90().getProfileBotsLive().observe(r23, new b(new j(this)));
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        FLogger.a.i(s, "[onCreateView]");
        ConstraintLayout r10 = getLayoutInflater().inflate(2131562407, r8, false);
        int r11 = 2131364358;
        CreateBotButton r2 = ViewBindings.findChildViewById(r10, 2131364358);
        if (r2 == null) goto L19;
        ConstraintLayout r12 = r10;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131381753);
        if (r3 == null) goto L17;
        ProfileInfoView r4 = (ProfileInfoView) ViewBindings.findChildViewById(r10, 2131383249);
        if (r4 == null) goto L16;
        MineTabTitleBar r5 = (MineTabTitleBar) ViewBindings.findChildViewById(r10, 2131388807);
        if (r5 == null) goto L15;
        this.j = new LarusFragmentMineTabBinding(r12, r2, r3, r4, r5);
        if (r12 == null) goto L13;
        r12.setTag(2131377847, this);
        return r12;
    L13:
        return null;
    L15:
        r11 = 2131388807;
        goto L19
    L16:
        r11 = 2131383249;
        goto L19
    L17:
        r11 = 2131381753;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
