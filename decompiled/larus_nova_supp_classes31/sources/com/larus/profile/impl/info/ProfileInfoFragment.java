package com.larus.profile.impl.info;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.NestedScrollableHost;
import com.larus.home.api.block.BlockUserViewModel;
import com.larus.home.api.block.BottomConfirmDialog;
import com.larus.platform.api.b3;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.profile.impl.ProfileBotListFragment;
import com.larus.profile.impl.ProfileRequestSource;
import com.larus.profile.impl.creation.k2;
import com.larus.profile.impl.databinding.LarusPageProfileInfoErrorBinding;
import com.larus.profile.impl.databinding.LarusPageProfileTabInfoLoadingBinding;
import com.larus.profile.impl.databinding.LarusPageProfileUserInfoSkeletonBinding;
import com.larus.profile.impl.databinding.LarusPageTabProfileInfoBinding;
import com.larus.profile.impl.databinding.LarusProfileBlockCoverBinding;
import com.larus.profile.impl.e2;
import com.larus.profile.impl.view.ProfileHeaderUserInfoView;
import com.larus.profile.impl.viewmodel.ProfileInfoViewModel;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.base.MainTabFragmentAction;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tx9.a1;
import tx9.s2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020$H\u0016J\b\u00104\u001a\u00020$H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u000207H\u0016J\u000f\u00108\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020;H\u0002J\f\u0010<\u001a\u00020$*\u00020\u0006H\u0002J\u0012\u0010=\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0012\u0010@\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0012\u0010A\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\n\u0010B\u001a\u0004\u0018\u00010?H\u0002J\u000f\u0010D\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u00109J\b\u0010E\u001a\u00020\bH\u0002J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0002J\u000f\u0010H\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u00109J\u0018\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u00102\b\b\u0002\u0010K\u001a\u00020\u0010J\b\u0010L\u001a\u00020$H\u0016J\b\u0010M\u001a\u00020$H\u0016J\b\u0010N\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020$H\u0002J\u000f\u0010P\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u00109J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010R\u001a\u00020$H\u0016J\n\u0010S\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010T\u001a\u00020$H\u0002J\b\u0010U\u001a\u00020$H\u0002J\b\u0010V\u001a\u00020\u0010H\u0016J\b\u0010W\u001a\u00020$H\u0016J\u0018\u0010X\u001a\u00020$2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u0010H\u0016J\b\u0010Z\u001a\u00020\u0010H\u0016J\b\u0010[\u001a\u00020\u0010H\u0016J\u0010\u0010\\\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010]H\u0016J\b\u0010_\u001a\u00020$H\u0016J\b\u0010`\u001a\u00020$H\u0016J\b\u0010a\u001a\u00020\u0010H\u0016J\u0018\u0010b\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010c\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/larus/profile/impl/info/ProfileInfoFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/voice_setting/voice/base/IMultiTabProfile;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusPageTabProfileInfoBinding;", "userId", "", "viewModel", "Lcom/larus/profile/impl/viewmodel/ProfileInfoViewModel;", "getViewModel", "()Lcom/larus/profile/impl/viewmodel/ProfileInfoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadDataSuccess", "", "blockUserViewModel", "Lcom/larus/home/api/block/BlockUserViewModel;", "getBlockUserViewModel", "()Lcom/larus/home/api/block/BlockUserViewModel;", "blockUserViewModel$delegate", "appBarLayoutState", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "scroll", "scrollStatusChangedWhenReset", "tag", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "enterFrom", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "selectTab", "defaultTabSelector", "Lcom/larus/profile/impl/ProfileDefaultTabSelector;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "previousPage", "fromNoticeType", "enterMethod", "initArgs", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "initView", "()Lkotlin/Unit;", "hostUiPolicy", "Lcom/larus/profile/impl/info/ProfileHostUiPolicy;", "applyAICreationAppletUiIfNeeded", "mobEnterPager", "currentFragment", "Landroidx/fragment/app/Fragment;", "mobEnterCreationList", "mobEnterBotList", "getCurrentFragment", "isReportCreation", "startMoreMenu", "getBlockConfirmContent", "tipOff", "initViewModel", "registerObservations", "enableAppBarLayoutScroll", "enable", "isReset", "onDestroyView", "onDestroy", "getCurrentPageName", "updateAICreationAppletMenuActions", "handleBlockActionFromAICreationAppletMenu", "autoLogEnterPage", "logEnterPage", "getPageName", "resetLoadDataState", "forceRefreshUserInfo", "scrollStatusChanged", "resetScrollStatusChanged", "enableScroll", "reset", "getScrollStatus", "needRefreshBotList", "getTabActionData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "scrollToTop", "scrollToNormal", "isAppBarExpand", "updateChildTabListState", "isEmpty", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileInfoFragment extends TraceFragment implements com.larus.voice_setting.voice.base.a {
    public static final /* synthetic */ int v = 0;
    public LarusPageTabProfileInfoBinding e;
    public String f;
    public final Lazy g;
    public boolean h;
    public final Lazy i;
    public AppBarLayoutStateListener.State j;
    public boolean k;
    public boolean l;
    public final String m;
    public r38.b n;
    public String o;
    public RecommendFrom p;
    public String q;
    public final com.larus.profile.impl.w r;
    public String s;
    public String t;
    public String u;

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

    public final boolean S90() {
        return true;
    }

    public final void UM() {
        this.l = false;
    }

    public final MutableLiveData<MainTabFragmentAction> kI() {
        return null;
    }

    public final int l() {
        return 0;
    }

    public final void n40(boolean r1) {
    }

    public final boolean qv() {
        return true;
    }

    public final BlockUserViewModel W90() {
        return (BlockUserViewModel) this.i.getValue();
    }

    public final ProfileInfoViewModel X90() {
        return (ProfileInfoViewModel) this.g.getValue();
    }

    public final com.larus.profile.impl.info.a Y90() {
        int r0 = com.larus.profile.impl.info.a.c;
        return com.larus.profile.impl.info.a.C0014a.a(getArguments(), getActivity());
    }

    public final void aa0() {
        if (AppHost.a.isOversea() == false) goto L7;
        View r2 = getView();
        if (r2 == null) goto L20;
        z1 r1 = z1.a;
        b3.a.a(r2, 6, null, null, this.f, 12);
        return;
    L20:
        return;
    L7:
        IAIChatService.Companion r3 = IAIChatService.a;
        String r4 = this.f;
        Intrinsics.checkNotNullParameter(r4, "entityId");
        TipOffDialogParams r15 = new TipOffDialogParams(6, r4, null, null, "", "", 0, null, null, null, null, null, null, null, null);
        r15.d = k();
        Fragment r5 = r3.g8(r15);
        FragmentManager r6 = getChildFragmentManager();
        if ((r5 instanceof Fragment) == false) goto L10;
        Fragment r7 = r5;
    L11:
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, null, r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r7, r8) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r5.show(r6, null);
        return;
    L22:
        return;
    L10:
        r7 = null;
        goto L11
    }

    public final Fragment getCurrentFragment() {
        LarusPageTabProfileInfoBinding r2 = this.e;     // Catch: Exception -> L19
        if (r2 == null) goto L24;
        ViewPager2 r3 = r2.p;     // Catch: Exception -> L19
        if (r3 == null) goto L25;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L19
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L19
        if (r5 == null) goto L26;
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L19
        LarusPageTabProfileInfoBinding r0 = this.e;     // Catch: Exception -> L19
        if (r0 == null) goto L16;
        ViewPager2 r1 = r0.p;     // Catch: Exception -> L19
        if (r1 == null) goto L16;
        RecyclerView.Adapter r7 = r1.getAdapter();     // Catch: Exception -> L19
        if (r7 == null) goto L16;
        Long r8 = Long.valueOf(r7.getItemId(r4));     // Catch: Exception -> L19
    L17:
        r6.append(r8);     // Catch: Exception -> L19
        return r5.findFragmentByTag(r6.toString());
    L16:
        r8 = null;
        goto L17
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L19:
        e = move-exception;
        FLogger.a.e(this.m, "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final String getPageName() {
        if (Intrinsics.areEqual(this.f, ILoginService.a.getAccountInfo().c) == false) goto L5;
        return "self_created_bot_list";
    L5:
        return "chat";
    }

    public final String k() {
        if (Intrinsics.areEqual(this.f, ILoginService.a.getAccountInfo().c) == false) goto L5;
        return "bot_list_profile";
    L5:
        return "bot_list_others";
    }

    public ProfileInfoFragment() {
        this.f = "";
        final Function0<Fragment> r1 = new ProfileInfoFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileInfoViewModel.class), new ProfileInfoFragment$special$$inlined$viewModels$default$2(r1), new ProfileInfoFragment$special$$inlined$viewModels$default$3(r1, this));
        final Function0<Fragment> r2 = new ProfileInfoFragment$special$$inlined$viewModels$default$4(this);
        this.i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BlockUserViewModel.class), new ProfileInfoFragment$special$$inlined$viewModels$default$5(r2), new ProfileInfoFragment$special$$inlined$viewModels$default$6(r2, this));
        this.j = AppBarLayoutStateListener.State.EXPANDED;
        this.m = "PageProfileInfoFragment" + hashCode();
        this.o = "";
        this.r = new com.larus.profile.impl.w();
        this.s = "";
    }

    public final void T90() {
        super.T90();
        Z90(getCurrentFragment());
    }

    public final void ba0() {
        com.larus.profile.impl.info.a r0 = Y90();
        boolean r1 = isResumed();
        boolean r2 = Intrinsics.areEqual(this.f, ILoginService.a.getAccountInfo().c);
        boolean r4 = false;
        if (X90().getBlockListType() == 3) goto L5;
        boolean r3 = true;
    L7:
        if (r0.a == false) goto L12;
        if (r1 == false) goto L12;
        if (r2 == true) goto L12;
        if (r3 == false) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L14;
        WeakReference<Object> r5 = cy9.d.a;
        cy9.d.b r6 = new cy9.d.b(new ProfileInfoFragment$updateAICreationAppletMenuActions$1(this), new ProfileInfoFragment$updateAICreationAppletMenuActions$2(this));
        Intrinsics.checkNotNullParameter(this, "owner");
        Intrinsics.checkNotNullParameter(r6, "actions");
        cy9.d.a(this);
        cy9.d.c = null;
        cy9.d.d = r6;
        return;
    L14:
        cy9.d.e(this);
        return;
    L5:
        r3 = false;
        goto L7
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        cy9.d.e(this);
        this.e = null;
    }

    public final void onPause() {
        cy9.d.e(this);
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onResume() {
        super.onResume();
        ba0();
    }

    public final boolean kt() {
        return this.l;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final boolean tz() {
        return this.k;
    }

    public final void X3(String r2) {
        Intrinsics.checkNotNullParameter("click_placeholder", "enterMethod");
    }

    public final void Z90(final Fragment r61) {
        boolean r2 = r61 instanceof k2;
        String r7 = "";
        String r8 = null;
        if (r2 == false) goto L31;
        com.larus.profile.impl.w r9 = this.r;
        if (r61 == null) goto L7;
        String r10 = r61.getClass().getName();
    L9:
        if (r9.c(r10) == false) goto L11;
        SafeExtKt.c(this, new i(this, r61), 2000);
        return;
    L11:
        String r3 = this.s;
        com.larus.profile.impl.w r4 = this.r;
        if (r2 == false) goto L14;
        k2 r5 = (k2) r61;
    L15:
        if (r5 == null) goto L20;
        String r6 = r5.yq(null);
        if (r6 == null) goto L20;
        r7 = r6;
    L26:
        if (r4.b(r7) == false) goto L28;
        String r31 = "0";
    L29:
        a1.c(null, null, null, null, null, "creation_others", null, null, this.u, null, null, null, null, null, null, null, r3, null, null, null, null, null, null, null, null, null, r31, this.t, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -97, 7);
        return;
    L28:
        r31 = "1";
    L20:
        if (r61 == null) goto L22;
        r8 = r61.getClass().getName();
    L22:
        if (r8 == null) goto L26;
        r7 = r8;
        goto L26
    L14:
        r5 = null;
        goto L15
    L7:
        r10 = "";
        goto L9
    L31:
        if ((r61 instanceof ProfileBotListFragment) == false) goto L58;
        com.larus.profile.impl.w r11 = this.r;
        if (r61 == null) goto L35;
        String r12 = r61.getClass().getName();
    L37:
        if (r11.c(r12) == false) goto L39;
        SafeExtKt.c(this, new h(this, r61), 2000);
        return;
    L39:
        String r13 = this.s;
        com.larus.profile.impl.w r14 = this.r;
        if (r2 == false) goto L42;
        k2 r15 = (k2) r61;
    L43:
        if (r15 == null) goto L48;
        String r16 = r15.yq(null);
        if (r16 == null) goto L48;
        r7 = r16;
    L54:
        if (r14.b(r7) == false) goto L56;
        String r32 = "0";
    L57:
        a1.c(null, null, null, null, null, "self_bot_list", null, null, this.u, null, null, null, null, null, null, null, r13, null, null, null, null, null, null, null, null, null, r32, this.t, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -97, 7);
        return;
    L56:
        r32 = "1";
    L48:
        if (r61 == null) goto L50;
        r8 = r61.getClass().getName();
    L50:
        if (r8 == null) goto L54;
        r7 = r8;
        goto L54
    L42:
        r15 = null;
        goto L43
    L35:
        r12 = "";
        goto L37
    L58:
        com.larus.profile.impl.w r17 = this.r;
        if (r61 == null) goto L61;
        String r18 = r61.getClass().getName();
    L63:
        if (r17.c(r18) == false) goto L65;
        SafeExtKt.c(this, new u(this, r61), 2000);
        return;
    L65:
        String r19 = this.s;
        com.larus.profile.impl.w r20 = this.r;
        if (r2 == false) goto L68;
        k2 r21 = (k2) r61;
    L69:
        if (r21 == null) goto L74;
        String r22 = r21.yq(null);
        if (r22 == null) goto L74;
        r7 = r22;
    L80:
        if (r20.b(r7) == false) goto L82;
        String r33 = "0";
    L83:
        a1.c(null, null, null, null, null, "self_bot_list", null, null, this.u, null, null, null, null, null, null, null, r19, null, null, null, null, null, null, null, null, null, r33, this.t, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -97, 7);
        return;
    L82:
        r33 = "1";
    L74:
        if (r61 == null) goto L76;
        r8 = r61.getClass().getName();
    L76:
        if (r8 == null) goto L80;
        r7 = r8;
        goto L80
    L68:
        r21 = null;
        goto L69
    L61:
        r18 = "";
        goto L63
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a$a.a(this, r3);
        r3.put("from_notice_type", this.t);
        r3.put("enter_method", this.u);
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        String r0 = "";
        if (r8 == null) goto L6;
        String r9 = r8.getString("key_user_id", "");
        if (r9 == null) goto L6;
    L7:
        this.f = r9;
        boolean r1 = true;
        if (r9.length() != 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L18;
        Bundle r11 = getArguments();
        if (r11 == null) goto L16;
        String r12 = r11.getString("user_id", "");
        if (r12 == null) goto L16;
    L17:
        this.f = r12;
    L16:
        r12 = "";
    L18:
        Bundle r13 = getArguments();
        if (r13 == null) goto L22;
        String r14 = r13.getString("landing_tab", "");
        if (r14 == null) goto L22;
    L23:
        this.q = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L27;
        String r16 = r15.getString("previous_page", "");
        if (r16 == null) goto L27;
    L28:
        this.s = r16;
        Bundle r17 = getArguments();
        if (r17 == null) goto L31;
        String r18 = r17.getString("from_notice_type", null);
    L32:
        this.t = r18;
        Bundle r19 = getArguments();
        if (r19 == null) goto L35;
        String r20 = r19.getString("enter_method", null);
    L36:
        this.u = r20;
        if (TextUtils.isEmpty(this.t) == true) goto L40;
        this.s = "notify";
    L40:
        if (this.s.length() == 0) goto L43;
        r1 = false;
    L43:
        if (r1 == false) goto L49;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        String r21 = TrackParams.optString$default(by7.h.a(this), "previous_page", null, 2, null);
        if (r21 == null) goto L48;
        r0 = r21;
    L48:
        this.s = r0;
    L49:
        X90().setUserId(this.f);
        Bundle r22 = getArguments();
        if (r22 == null) goto L52;
        String r23 = r22.getString("recommend_scene");
    L53:
        Bundle r2 = getArguments();
        if (r2 == null) goto L56;
        String r3 = r2.getString("recommend_request_id");
    L58:
        if (o0.d(r23) == true) goto L60;
        return;
    L60:
        if (o0.d(r3) == false) goto L64;
        this.p = new RecommendFrom(r23, r3, null, 4);
        return;
    L64:
        return;
    L56:
        r3 = null;
        goto L58
    L52:
        r23 = null;
        goto L53
    L35:
        r20 = null;
        goto L36
    L31:
        r18 = null;
    L27:
        r16 = "";
    L22:
        r14 = "";
        goto L23
    L10:
        r10 = false;
    L6:
        r9 = "";
        goto L7
    }

    public static void U90(BottomConfirmDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "BottomConfirmDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "BottomConfirmDialog");
    }

    public final void Ol(boolean r1, boolean r2) {
        V90(r1, r2);
    }

    public final void V90(boolean r5, boolean r6) {
        if (this.j == AppBarLayoutStateListener.State.EXPANDED) goto L6;
        return;
    L6:
        if (r6 == false) goto L14;
        if (r5 == false) goto L9;
    L11:
        boolean r7 = false;
    L12:
        this.l = r7;
        goto L14
    L9:
        if (this.k == false) goto L11;
        r7 = true;
    L14:
        if (this.k != r5) goto L16;
        return;
    L16:
        FLogger.a.i(this.m, "[enableAppBarLayoutScroll] enable: " + r5 + ", current: " + this.k);
        this.k = r5;
        LarusPageTabProfileInfoBinding r8 = this.e;
        if (r8 == null) goto L34;
        AppBarLayout r9 = r8.b;
        if (r9 == null) goto L35;
        View r10 = r9.getChildAt(0);
        if (r10 == null) goto L36;
        AppBarLayout.LayoutParams r1 = r10.getLayoutParams();
        if ((r1 instanceof AppBarLayout.LayoutParams) == false) goto L26;
        AppBarLayout.LayoutParams r2 = r1;
    L27:
        if (r2 != null) goto L29;
        return;
    L29:
        if (r5 == false) goto L31;
        r2.setScrollFlags(3);
    L32:
        r10.setLayoutParams(r2);
        return;
    L31:
        r2.setScrollFlags(0);
        goto L32
    L26:
        r2 = null;
        goto L27
    L36:
        return;
    L35:
        return;
    }

    public final void Ym(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        this.r.f(r3, r4);
        LarusPageTabProfileInfoBinding r5 = this.e;
        if (r5 == null) goto L16;
        TabLayout r6 = r5.o;
        if (r6 != null) goto L7;
        return;
    L7:
        if (this.r.d(r6, false, false, 1) == false) goto L18;
        LarusPageTabProfileInfoBinding r7 = this.e;
        if (r7 == null) goto L19;
        LarusPageProfileTabInfoLoadingBinding r8 = r7.k;
        if (r8 == null) goto L20;
        ConstraintLayout r9 = r8.a;
        if (r9 == null) goto L21;
        r9.setVisibility(8);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.larus.profile.impl.info.q] */
    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        final LarusPageTabProfileInfoBinding r8 = this.e;
        if (r8 == null) goto L116;
        ConstraintLayout.LayoutParams r0 = r8.i.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r1 = r0;
    L8:
        r8.i.setLayoutParams(r1);
        com.larus.profile.impl.info.a r2 = Y90();
        boolean r3 = r2.a;
        if (r3 == false) goto L28;
        if (r3 == true) goto L13;
    L15:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L23;
        r8.g.setImageResource(2131243187);
        r8.g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r8.g.setContentDescription(getString(2131898805));
        AppCompatImageView r5 = r8.g;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L22;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        ((ViewGroup.MarginLayoutParams) r7).width = getResources().getDimensionPixelSize(v19.c.b(2130971435, null, 2131167240));
        ((ViewGroup.MarginLayoutParams) r7).height = getResources().getDimensionPixelSize(v19.c.b(2130971435, null, 2131167240));
        r7.setMarginStart(getResources().getDimensionPixelSize(v19.c.b(2130971255, null, 2131166880)));
        r7.bottomToBottom = -1;
        r7.topToTop = 2131383247;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = getResources().getDimensionPixelSize(v19.c.b(2130971480, null, 2131167331));
        r5.setLayoutParams(r7);
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L23:
        r8.j.setVisibility(8);
        AppCompatImageView r9 = r8.j;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L114;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) r10;
        r11.setMarginEnd(getResources().getDimensionPixelSize(v19.c.b(2130971155, null, 2131166679)));
        r9.setLayoutParams(r11);
        AppCompatTextView r12 = r8.h;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L112;
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;
        r14.endToEnd = -1;
        r14.endToStart = 2131383256;
        r14.setMarginEnd(getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786)));
        r12.setLayoutParams(r14);
        goto L28
    L112:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L114:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L13:
        if (r2.b == false) goto L15;
        r4 = true;
    L28:
        ba0();
        e1.d(r8.g, new com.larus.profile.impl.info.b(this));
        e1.d(r8.f.b, new m(this));
        r8.e.setAvatarClick(new n(this));
        String r15 = this.f;
        ILoginService.Companion r16 = ILoginService.a;
        if (Intrinsics.areEqual(r15, r16.getAccountInfo().c) == false) goto L31;
        this.o = "bot_list_profile";
        r8.e.setEditClick(new o(this));
    L32:
        r8.b.addOnOffsetChangedListener(new v(this, r8));
        e1.d(r8.j, new p(this));
        ViewParent r19 = r8.p.getParent();
        if ((r19 instanceof ViewGroup) == false) goto L35;
        ViewGroup r20 = (ViewGroup) r19;
    L36:
        ViewGroup.LayoutParams r21 = r8.p.getLayoutParams();
        if (r20 == null) goto L39;
        int r22 = r20.indexOfChild(r8.p);
    L40:
        if (r20 == null) goto L42;
        r20.removeView(r8.p);
    L42:
        NestedScrollableHost r23 = new NestedScrollableHost(requireContext());
        r23.setLayoutParams(r21);
        r23.addView(r8.p, new ViewGroup.LayoutParams(-1, -1));
        if (r20 == null) goto L45;
        r20.addView(r23, r22);
    L45:
        r8.p.setAdapter(new OtherProfileInfoAdapter(this, this.o, this.f, this.p, this.r, Y90().a));
        r8.p.setUserInputEnabled(true);
        z2 r24 = z2.a;
        if (r24.I2() == false) goto L50;
        if (r24.D2() == false) goto L50;
    L54:
        if (com.larus.bmhome.utils.u.g() == true) goto L56;
    L60:
        boolean r25 = Intrinsics.areEqual(this.f, r16.getAccountInfo().c);
        if (r24.x3().shouldHideProfileBotTab(r25) == true) goto L67;
        e10 r26 = e10.a;
        if (e10.B0() == false) goto L65;
        if (r25 == false) goto L67;
    L65:
        TabLayout r27 = r8.o;
        r27.addTab(r27.newTab().setText(getString(2131898418)));
    L67:
        if (com.larus.bmhome.utils.u.g() == false) goto L74;
        if (AccountService.a.isLogin().booleanValue() == false) goto L74;
        e10 r28 = e10.a;
        if (e10.u0().a() == true) goto L74;
        TabLayout r29 = r8.o;
        r29.addTab(r29.newTab().setText(getString(2131901250)));
    L74:
        if (r24.I2() == true) goto L76;
    L78:
        r8.p.setOffscreenPageLimit(r8.o.getTabCount());
        r8.o.addOnTabSelectedListener(new w(r8));
        r8.p.registerOnPageChangeCallback(new ProfileInfoFragment$initView$1$8(r8, this));
        if (com.larus.bmhome.utils.u.g() == false) goto L89;
        if (AccountService.a.isLogin().booleanValue() == false) goto L89;
        if (Intrinsics.areEqual(this.q, "creation") == false) goto L89;
        e10 r30 = e10.a;
        if (e10.u0().a() == false) goto L87;
        this.r.e(0);
    L101:
        LarusPageTabProfileInfoBinding r31 = this.e;
        if (r31 == null) goto L106;
        ConstraintLayout r32 = r31.m;
        if (r32 == null) goto L106;
        i0.a.getClass();
        int r33 = i0.g();
        int r34 = r32.getPaddingStart();
        int r35 = r32.getPaddingEnd();
        int r36 = r32.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r32.getClass().getSimpleName() + ",source:,start:" + r34 + ",top:" + r33 + ",end:" + r35 + ",bottom:" + r36);
        r32.setPaddingRelative(r34, r33, r35, r36);
    L106:
        i0 r37 = i0.a;
        FragmentActivity r38 = getActivity();
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        r37.getClass();
        final int r39 = Math.min(i0.c(r38), i0.e());
        LarusPageTabProfileInfoBinding r40 = this.e;
        if (r40 == null) goto L116;
        final ConstraintLayout r41 = r40.m;
        if (r41 == null) goto L116;
        final ?? r42 = new q(this, r39, r41);
        r41.post(new r(r42));
        ViewCompat.setOnApplyWindowInsetsListener(r41, new s(r41, r42));
        Unit r43 = Unit.INSTANCE;
        goto L116
    L87:
        this.r.e(1);
    L89:
        if (o0.d(this.q) == false) goto L101;
        Iterator<e2> r44 = this.r.c.iterator();
        int r45 = 0;
    L92:
        if (r44.hasNext() == false) goto L97;
        if (Intrinsics.areEqual(r44.next().b.name(), this.q) == true) goto L95;
        r45 = r45 + 1;
        goto L92
    L95:
        int r110 = r45;
    L98:
        if (r110 <= 0) goto L101;
        this.r.e(r110);
        goto L101
    L97:
        r110 = -1;
        goto L98
    L76:
        if (r24.D2() == false) goto L78;
        TabLayout r46 = r8.o;
        r46.addTab(r46.newTab().setText(getString(2131900243)));
        goto L78
    L56:
        if (AccountService.a.isLogin().booleanValue() == false) goto L60;
        e10 r47 = e10.a;
        if (e10.u0().a() == false) goto L60;
        TabLayout r48 = r8.o;
        r48.addTab(r48.newTab().setText(getString(2131901250)));
    L50:
        if (com.larus.bmhome.utils.u.g() == true) goto L52;
    L100:
        r8.o.setVisibility(8);
        r8.n.setVisibility(8);
        r8.k.a.setVisibility(8);
        goto L101
    L52:
        if (AccountService.a.isLogin().booleanValue() == false) goto L100;
    L39:
        r22 = 0;
        goto L40
    L35:
        r20 = null;
        goto L36
    L31:
        this.o = "bot_list_others";
        goto L32
    L7:
        r1 = null;
    L116:
        if (getViewLifecycleOwner() == null) goto L118;
        X90().getUserInfoState().observeForever(new b(new c(this)));
        X90().getProfileBotsLive().observe(getViewLifecycleOwner(), new b(new d(this)));
        W90().getBlockLiveData().observe(getViewLifecycleOwner(), new b(new e(this)));
        W90().getUnblockLiveData().observe(getViewLifecycleOwner(), new b(new f(this)));
        Unit r49 = Unit.INSTANCE;
    L118:
        ProfileInfoViewModel.queryUserInfo$default(X90(), false, ProfileRequestSource.OTHERS_INIT, 1, null);
        s2.a(null, this, 3);
    }

    public final View onCreateView(LayoutInflater r22, ViewGroup r23, Bundle r24) {
        Intrinsics.checkNotNullParameter(r22, "inflater");
        ConstraintLayout r1 = r22.inflate(2131563076, r23, false);
        int r2 = 2131363083;
        AppBarLayout r6 = ViewBindings.findChildViewById(r1, 2131363083);
        if (r6 == null) goto L45;
        r2 = 2131364283;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r1, 2131364283);
        if (r4 == null) goto L45;
        int r3 = 2131375131;
        if (ViewBindings.findChildViewById(r4, 2131375131) == null) goto L43;
        r3 = 2131390331;
        if (ViewBindings.findChildViewById(r4, 2131390331) == null) goto L43;
        LarusProfileBlockCoverBinding r7 = new LarusProfileBlockCoverBinding(r4);
        r2 = 2131367812;
        CoordinatorLayout r8 = ViewBindings.findChildViewById(r1, 2131367812);
        if (r8 == null) goto L45;
        r2 = 2131374317;
        ProfileHeaderUserInfoView r9 = (ProfileHeaderUserInfoView) ViewBindings.findChildViewById(r1, 2131374317);
        if (r9 == null) goto L45;
        r2 = 2131383231;
        View r5 = ViewBindings.findChildViewById(r1, 2131383231);
        if (r5 == null) goto L45;
        LarusPageProfileInfoErrorBinding r10 = LarusPageProfileInfoErrorBinding.a(r5);
        r2 = 2131383239;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r1, 2131383239);
        if (r11 == null) goto L45;
        r2 = 2131383240;
        AppCompatTextView r12 = ViewBindings.findChildViewById(r1, 2131383240);
        if (r12 == null) goto L45;
        r2 = 2131383247;
        View r13 = ViewBindings.findChildViewById(r1, 2131383247);
        if (r13 == null) goto L45;
        r2 = 2131383256;
        AppCompatImageView r14 = ViewBindings.findChildViewById(r1, 2131383256);
        if (r14 == null) goto L45;
        r2 = 2131383263;
        View r15 = ViewBindings.findChildViewById(r1, 2131383263);
        if (r15 == null) goto L45;
        LarusPageProfileTabInfoLoadingBinding r16 = LarusPageProfileTabInfoLoadingBinding.a(r15);
        r2 = 2131383276;
        View r17 = ViewBindings.findChildViewById(r1, 2131383276);
        if (r17 == null) goto L45;
        LarusPageProfileUserInfoSkeletonBinding r18 = LarusPageProfileUserInfoSkeletonBinding.a(r17);
        ConstraintLayout r19 = r1;
        View r110 = ViewBindings.findChildViewById(r1, 2131388013);
        if (r110 == null) goto L41;
        TabLayout r111 = ViewBindings.findChildViewById(r1, 2131388072);
        if (r111 == null) goto L40;
        ViewPager2 r20 = ViewBindings.findChildViewById(r1, 2131392623);
        if (r20 == null) goto L39;
        this.e = new LarusPageTabProfileInfoBinding(r19, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r19, r110, r111, r20);
        if (r19 == null) goto L37;
        r19.setTag(2131377847, this);
        return r19;
    L37:
        return null;
    L39:
        r2 = 2131392623;
        goto L45
    L40:
        r2 = 2131388072;
        goto L45
    L41:
        r2 = 2131388013;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r3)));
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
