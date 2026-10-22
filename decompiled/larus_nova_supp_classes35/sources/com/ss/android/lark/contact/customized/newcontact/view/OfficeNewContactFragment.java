package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeNewContactBinding;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.newcontact.viewmodel.OfficeNewContactViewModel;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u000f\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006 "}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficeNewContactBinding;", "newContactView", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactView;", "viewModel", "Lcom/ss/android/lark/contact/customized/newcontact/viewmodel/OfficeNewContactViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/newcontact/viewmodel/OfficeNewContactViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewDependency", "com/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactFragment$viewDependency$1", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactFragment$viewDependency$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initView", "initViewModel", "onDestroyView", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactFragment extends BaseFragment {
    public static final /* synthetic */ int h = 0;
    public ContactDbFragmentOfficeNewContactBinding d;
    public l e;
    public final Lazy f;
    public final b g;

    public static final class a {
    }

    public static final class b implements l.b {
        public final /* synthetic */ OfficeNewContactFragment a;

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void A() {
            OfficeNewContactFragment r0 = this.a;
            int r1 = OfficeNewContactFragment.h;
            r0.S90().loadInitial();
        }

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void y() {
            this.a.finish();
        }

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void z() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 != null) goto L5;
            return;
        L5:
            com.ss.android.lark.contact.customized.common.b.a("contact_application", "contact_application");
            Lazy r2 = OfficeContactPageUtils.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            int r3 = OfficeInviteExternalActivity.a;
            OfficeInviteExternalActivity.a.a(r0, "contact_application");
        }

        public b(OfficeNewContactFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void J(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "userId");
            Intrinsics.checkNotNullParameter(r4, "chatApplicationId");
            Context r0 = this.a.getActivity();
            if (r0 != null) goto L5;
            return;
        L5:
            ContactBaseModuleDependency.b.startNewContactProfilePage(r0, r3, r4);
        }
    }

    static {
    }

    public final OfficeNewContactViewModel S90() {
        return (OfficeNewContactViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        Log.i("Contact_NewContactFrag", "onDestroyView");
        l r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r0 = null;
    L5:
        r0.d = null;
        r0.e = null;
        r0.c = null;
        r0.f = null;
        super.onDestroyView();
    }

    public OfficeNewContactFragment() {
        final Function0<Fragment> r0 = new OfficeNewContactFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeNewContactViewModel.class), new OfficeNewContactFragment$special$$inlined$viewModels$default$2(r0), new OfficeNewContactFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        S90().onPageViewCreated(SystemClock.elapsedRealtime());
        ContactDbFragmentOfficeNewContactBinding r8 = this.d;
        String r0 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L5:
        l r9 = new l(r8, this.g);
        this.e = r9;
        r9.e = r9.a.d.getContext();
        r9.a.g.setRightIcon(2131255097);
        r9.a.g.setLeftIconClickListener(new o(r9));
        int r10 = com.ss.android.lark.contact.base.service.a.a;
        Intrinsics.checkNotNullParameter("invite.external.enable", "featureName");
        int r3 = 0;
        boolean r11 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.external.enable", false);
        Intrinsics.checkNotNullParameter("invite.union.enable", "featureName");
        boolean r2 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.union.enable", false);
        Intrinsics.checkNotNullParameter(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, "featureName");
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, false);
        if (r2 == false) goto L10;
        if (r11 == true) goto L9;
        if (r1 == false) goto L10;
    L9:
        boolean r12 = true;
    L11:
        View r4 = r9.a.g.findViewById(2131376563);
        if (r4 == null) goto L17;
        if (r12 == true) goto L16;
        r3 = 8;
    L16:
        r4.setVisibility(r3);
    L17:
        if (r12 == false) goto L19;
        r9.a.g.setRightIconClickListener(new p(r9));
    L20:
        Context r13 = r9.e;
        if (r13 == null) goto L24;
        ChatWindowPtrLoadingHeader r5 = new ChatWindowPtrLoadingHeader(r13);
        r9.a.c.setKeepHeaderWhenRefresh(true);
        r9.a.c.setFooterView(r5);
        r9.a.c.addPtrUIHandler(r5);
        r9.a.c.disableWhenHorizontalMove(true);
        r9.a.c.setPtrHandler(new m(r9));
    L24:
        zdc.h.a(r9.a.d);
        r9.a.d.setLayoutManager(new LinearLayoutManager(r9.e));
        if (r9.d != null) goto L27;
        r9.d = new OfficeNewContactAdapter();
    L27:
        OfficeNewContactAdapter r14 = r9.d;
        if (r14 == null) goto L30;
        n r15 = new n(r9);
        Intrinsics.checkNotNullParameter(r15, "listener");
        r14.b = r15;
    L30:
        r9.a.d.setAdapter(r9.d);
        LKUIPtrClassicFrameLayout r16 = r9.a.c;
        int r17 = DesktopUtil.a;
        l r18 = this.e;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r18 = null;
    L33:
        f r19 = new f(this);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "viewDelegate");
        r18.c = r19;
        S90().getFriendRequests().observe(getViewLifecycleOwner(), new g(this));
        S90().getUpdateFriendRequests().observe(getViewLifecycleOwner(), new h(this));
        S90().getLoadMoreFinished().observe(getViewLifecycleOwner(), new i(this));
        S90().getRemoveFriendRequest().observe(getViewLifecycleOwner(), new j(this));
        S90().getOpenProfile().observe(getViewLifecycleOwner(), new k(this));
        Lazy r20 = ContactHitPoint.a;
        JSONObject r21 = new JSONObject();
        r21.put("member_type", ContactHitPoint.a());
        Statistics.sendEvent("contact_new_view", r21);
        int r22 = com.ss.android.lark.contact.customized.common.b.a;
        Bundle r23 = getArguments();
        if (r23 == null) goto L36;
        r0 = r23.getString("from");
    L36:
        if (r0 != null) goto L38;
        r0 = BuildConfig.FLAVOR;
    L38:
        com.ss.android.lark.contact.customized.common.b.c("contact_application", r0);
        S90().loadInitial();
        Context r24 = getContext();
        if (r24 == null) goto L42;
        Lazy r25 = OfficeContactUtils.a;
        OfficeContactUtils.e(this, UIUtils.getColor(r24, 2131102022));
        return;
    L42:
        return;
    L19:
        r9.a.g.setRightIconClickListener(q.a);
    L10:
        r12 = false;
        goto L11
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131559910, r10, false);
        int r13 = 2131380711;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131380711);
        if (r2 == null) goto L17;
        r13 = 2131380712;
        LKUIPtrClassicFrameLayout r3 = ViewBindings.findChildViewById(r12, 2131380712);
        if (r3 == null) goto L17;
        r13 = 2131380713;
        CommonRecyclerView r4 = ViewBindings.findChildViewById(r12, 2131380713);
        if (r4 == null) goto L17;
        r13 = 2131380714;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131380714);
        if (r5 == null) goto L17;
        r13 = 2131380715;
        ContactOfficeEmptyStateView r6 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r12, 2131380715);
        if (r6 == null) goto L17;
        r13 = 2131388807;
        ContactOfficeTitleBar r7 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r12, 2131388807);
        if (r7 == null) goto L17;
        ContactDbFragmentOfficeNewContactBinding r14 = new ContactDbFragmentOfficeNewContactBinding((LinearLayout) r12, r2, r3, r4, r5, r6, r7);
        this.d = r14;
        return r14.a;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
