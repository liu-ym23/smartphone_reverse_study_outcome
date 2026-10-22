package com.larus.profile.impl.creation;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.community.api.ICommunityService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.z3;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2;
import com.larus.profile.impl.databinding.LarusItemProfileUserBannedBinding;
import com.larus.profile.impl.databinding.LarusProfileCreationList2Binding;
import com.larus.settings.value.e10;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020#H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\u000f\u00102\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u00103J\u0017\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u00020\u001dH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u00020\rH\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010;\u001a\u00020#H\u0016J\b\u0010<\u001a\u00020#H\u0016J\b\u0010=\u001a\u00020#H\u0002J\b\u0010@\u001a\u00020#H\u0002J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\rH\u0016J\u0012\u0010D\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010E\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020HH\u0017J\u0010\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0002J\u001a\u0010M\u001a\u0004\u0018\u00010\r2\u0006\u0010N\u001a\u00020O2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010Q\u001a\u00020#2\u0006\u0010R\u001a\u00020\rH\u0016J\u0010\u0010S\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010>\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/profile/impl/creation/ProfileCreationListFragmentV2;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Lcom/larus/profile/impl/creation/IProfileCreationListFragment;", "Lcom/larus/platform/api/creation/ICreationListener;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusProfileCreationList2Binding;", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "userId", "", "viewModel", "Lcom/larus/profile/impl/creation/viewmodel/ProfileCreationViewModelV2;", "getViewModel", "()Lcom/larus/profile/impl/creation/viewmodel/ProfileCreationViewModelV2;", "viewModel$delegate", "Lkotlin/Lazy;", "openMenusDialogHelper", "Lcom/larus/profile/impl/creation/OpenMenusHelper;", "isFirstEnterPage", "", "isEnterCreationPage", "hasReportEnterPage", "hasReportFunctionShow", "shouldReportFunctionShow", "creationMode", "", "getCreationMode", "()I", "setCreationMode", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initObservers", "initOpenPrivacyDialogHelper", "initBannedView", "getQueryPrivateStatus", "()Ljava/lang/Integer;", "getFragmentTag", "forceMode", "(Ljava/lang/Integer;)Ljava/lang/String;", "getCurrentCreationMode", "isPrivateTab", "getProfileCreationCurrentPage", "initCreationFeedComponent", "onResume", "onPause", "showUserBannedView", "previousPage", "recommendFrom", "initArgs", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tag", "updatePreviousPage", "onEnterMineTab", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "reportItemShow", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "openCreationDetailInHostIfNeeded", "sourceProfileUserIdForDetail", "hostUiPolicy", "Lcom/larus/profile/impl/info/ProfileHostUiPolicy;", "reportClickItem", "onRemoveUserCreation", "creationId", "onSetReferenceImagePublic", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileCreationListFragmentV2 extends ProfileInfoBaseFragment implements k2, zp9.r {
    public static final /* synthetic */ int r = 0;
    public LarusProfileCreationList2Binding j;
    public String k;
    public final Lazy l;
    public n3 m;
    public boolean n;
    public int o;
    public String p;
    public String q;

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

    public final String ba0() {
        if (this.k.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L14;
        int r1 = this.o;
        if (r1 == 4) goto L14;
        if (r1 != 2) goto L13;
        return "creation_private";
    L13:
        return "creation_list";
    L14:
        return "creation_others";
    L5:
        r0 = false;
        goto L6
    }

    public final ProfileCreationViewModelV2 ca0() {
        return (ProfileCreationViewModelV2) this.l.getValue();
    }

    public final boolean da0() {
        if (this.o != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onDestroy() {
        ICommunityService.a.c1(this);
        super.onDestroy();
    }

    public final String tag() {
        return "ProfileCreationListFragmentV2" + this.o;
    }

    public ProfileCreationListFragmentV2() {
        this.k = "";
        final Function0<Fragment> r0 = new ProfileCreationListFragmentV2$special$$inlined$viewModels$default$1(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileCreationViewModelV2.class), new ProfileCreationListFragmentV2$special$$inlined$viewModels$default$2(r0), new ProfileCreationListFragmentV2$special$$inlined$viewModels$default$3(r0, this));
        this.n = true;
    }

    public final zp9.l aa0() {
        return (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
    }

    public final RecyclerView getRecyclerView() {
        zp9.l r0 = aa0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRecyclerView();
    }

    public final void onPause() {
        super.onPause();
        Lazy r0 = com.larus.platform.service.q3.a;
        z3 r1 = com.larus.platform.service.q3.a();
        if (r1 == null) goto L6;
        r1.k(null);
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.n == true) goto L7;
        zp9.l r1 = aa0();
        if (r1 == null) goto L7;
        zp9.l.a.a(r1, true, false, null, true, ((ProfileInfoBaseFragment) this).i, 6);
    L7:
        ((ProfileInfoBaseFragment) this).i = false;
        this.n = false;
    }

    @Override // com.larus.profile.impl.creation.k2
    public final int to() {
        return this.o;
    }

    public static final Integer Z90(ProfileCreationListFragmentV2 r1) {
        int r2 = r1.o;
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return null;
    L11:
        return 2;
    L9:
        return 1;
    }

    public final void S90(String r56) {
        if (r56 != null) goto L5;
        String r0 = "";
    L6:
        this.p = r0;
        if (com.larus.utils.o0.d(r56) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r56, "unknown") == true) goto L13;
        tx9.a1.c(null, null, null, null, null, ba0(), null, null, null, null, null, null, null, null, null, null, r56, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048705, -1, 7);
        return;
    L13:
        return;
    L5:
        r0 = r56;
        goto L6
    }

    @Override // zp9.r
    public final void X0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "creationId");
        zp9.l r0 = aa0();
        if (r0 == null) goto L6;
        r0.deleteUserCreation(r3, false);
        return;
    }

    public final void Y90(String r1) {
        this.p = r1;
    }

    @Override // zp9.r
    public final void bZ(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (isResumed() == false) goto L10;
        zp9.l r3 = aa0();
        if (r3 == null) goto L11;
        RecyclerView r4 = r3.getRecyclerView();
        if (r4 == null) goto L12;
        r4.post(new s3(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r4);
        ICommunityService.a.e1(this);
        Bundle r5 = getArguments();
        String r0 = "";
        if (r5 == null) goto L6;
        String r6 = r5.getString("user_id", "");
        if (r6 == null) goto L6;
    L7:
        this.k = r6;
        Bundle r7 = getArguments();
        boolean r1 = false;
        if (r7 == null) goto L10;
        int r8 = r7.getInt("creation_mode", 0);
    L11:
        this.o = r8;
        String r9 = this.p;
        if (r9 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == false) goto L22;
        Bundle r10 = getArguments();
        if (r10 == null) goto L21;
        String r11 = r10.getString("previous_page", "");
        if (r11 == null) goto L21;
    L23:
        this.p = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L29;
        String r13 = r12.getString("recommend_from", "");
        if (r13 == null) goto L29;
        r0 = r13;
    L29:
        this.q = r0;
        ca0().setUserId(this.k);
        return;
    L21:
        r11 = "";
        goto L23
    L22:
        r11 = this.p;
        goto L23
    L14:
        if (r9.length() != 0) goto L16;
    L10:
        r8 = 0;
    L6:
        r6 = "";
        goto L7
    }

    @Override // zp9.r
    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        zp9.l r0 = aa0();
        if (r0 == null) goto L6;
        r0.CO(r2);
        return;
    }

    @Override // com.larus.profile.impl.creation.k2
    public final String yq(Integer r2) {
        int r0 = x3.a;
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L7:
        return x3.a(Integer.valueOf(r3));
    L5:
        r3 = this.o;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.profile.impl.creation.ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1] */
    public final void onViewCreated(View r46, Bundle r47) {
        Intrinsics.checkNotNullParameter(r46, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r46, r47);
        if (this.j == null) goto L60;
        final BaseContentWidget r1 = ICommunityService.a.w1();
        if (r1 == null) goto L7;
        k1a.b.a(this, new p3(this, r1));
    L7:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L14;
        r2.H();
        VideoPortraitConfig r3 = com.larus.home.impl.sdk.l1.a.a();
        if (r3 == null) goto L14;
        if (r3.getEnableAvatarCreation() != true) goto L14;
        boolean r4 = true;
    L15:
        zp9.l r5 = aa0();
        if (r5 == null) goto L56;
        String r10 = "List_ProfileCreationList_" + this.o;
        int r6 = 4;
        Integer r7 = null;
        if (this.o != 4) goto L20;
        String r18 = "creation_others";
    L21:
        zp9.g r8 = new zp9.g(ba0(), "personal_homepage_portfolio", null, null, null, null, r18, this.p, "personal_homepage_portfolio", "personal_homepage_portfolio", null, "creation_others", null, null, null, null, null, null, null, null, null, null, 4191292);
        if (da0() == false) goto L24;
        Integer r21 = Integer.valueOf(i5.a());
    L26:
        if (da0() == false) goto L28;
        Integer r22 = Integer.valueOf(i5.a());
    L29:
        boolean r19 = da0();
        if (da0() == false) goto L32;
        Integer r110 = 3;
    L34:
        if (da0() == false) goto L36;
        r7 = Integer.valueOf(i5.b());
    L36:
        Integer r20 = r7;
        int r9 = this.o;
        if (r9 == 1) goto L43;
        if (r9 == 2) goto L42;
        if (r9 != 4) goto L44;
        r6 = 3;
    L44:
        if (r9 != 2) goto L46;
        boolean r23 = false;
    L48:
        if (this.o == 2) goto L51;
        r4 = false;
    L51:
        zp9.f r12 = new zp9.f(false, false, r10, true, r8, Integer.valueOf(r6), null, 0, true, null, r110, r19, r20, r21, r22, r23, null, false, null, null, false, true, 10, Boolean.valueOf(r4), null, null, "ugc_video", "message_card", "ugc_video", "immersive_preview", 52363843);
        if (da0() == false) goto L54;
        zp9.n r11 = ca0().getProfileCreationFeedPrivateTabRepository();
    L55:
        r5.nh(r12, new zp9.e(r11, new v3(this), new w3(this), null, 8));
        goto L56
    L54:
        r11 = ca0().getProfileCreationFeedRepository();
        goto L55
    L46:
        e10 r13 = e10.a;
        r23 = e10.J().b();
        goto L48
    L42:
        r6 = 2;
        goto L44
    L43:
        r6 = 1;
        goto L44
    L32:
        r110 = null;
        goto L34
    L28:
        r22 = null;
        goto L29
    L24:
        r21 = null;
        goto L26
    L20:
        r18 = null;
    L56:
        zp9.l r14 = aa0();
        if (r14 == null) goto L59;
        r14.X20(new q3(this));
    L59:
        X90();
    L14:
        r4 = false;
    L60:
        LiveData<Integer> r15 = ca0().getProfileStatusLiveData();
        if (r15 == null) goto L63;
        r15.observe(getViewLifecycleOwner(), new b(new t3(this)));
    L63:
        LarusProfileCreationList2Binding r16 = this.j;
        if (r16 == null) goto L70;
        Context r17 = getContext();
        FrameLayout r111 = r16.d;
        if (this.k.length() != 0) goto L68;
        boolean r24 = true;
    L69:
        this.m = new n3(r17, r24, this.o, LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), new ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1(this), r111);
        goto L70
    L68:
        r24 = false;
    L70:
        zp9.l r25 = aa0();
        if (r25 == null) goto L76;
        LiveData<Boolean> r26 = r25.og();
        if (r26 == null) goto L77;
        r26.observe(getViewLifecycleOwner(), new b(new r3(this)));
        return;
    L77:
        return;
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131563092, r8, false);
        int r11 = 2131368243;
        NestedScrollView r2 = ViewBindings.findChildViewById(r10, 2131368243);
        if (r2 == null) goto L13;
        r11 = 2131368261;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131368261);
        if (r3 == null) goto L13;
        r11 = 2131386121;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131386121);
        if (r4 == null) goto L13;
        r11 = 2131392005;
        View r12 = ViewBindings.findChildViewById(r10, 2131392005);
        if (r12 == null) goto L13;
        ConstraintLayout r13 = r10;
        this.j = new LarusProfileCreationList2Binding(r13, r2, r3, r4, LarusItemProfileUserBannedBinding.a(r12));
        return r13;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    @Override // zp9.r
    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        zp9.r.a.a(r1, r6);
    }
}
