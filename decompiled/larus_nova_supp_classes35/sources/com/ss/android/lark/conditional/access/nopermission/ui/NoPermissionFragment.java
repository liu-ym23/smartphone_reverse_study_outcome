package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentNoPermissionBinding;
import com.ss.android.lark.conditional.access.databinding.ScsWidgetLoadingViewBinding;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.handler.policy.center.PolicyCenterDisplayIdActionGate;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u001dH\u0014J\b\u0010,\u001a\u00020\u001dH\u0014J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u000200H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/PageUpdateFragment;", IPortraitService.TYPE, "Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", "<init>", "(Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;)V", "getType", "()Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", "viewModel", "Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentNoPermissionBinding;", "getViewBinding", "()Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentNoPermissionBinding;", "setViewBinding", "(Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentNoPermissionBinding;)V", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "getInternalSecurityAction", "()Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "setInternalSecurityAction", "(Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;)V", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "ping", "pingSource", BuildConfig.FLAVOR, "onPrimaryButtonClick", "onRetryButtonClick", "onPageUpdate", "onDestroyView", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NoPermissionFragment extends BaseFragment implements d0c.c, y {
    public final NoPermissionType d;
    public final Lazy e;
    public ScsFragmentNoPermissionBinding f;
    public InternalSecurityAction g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ NoPermissionFragment a;

        public b(NoPermissionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            int r3 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_NoPermissionFragment", this.a.getType().name() + ", btnRetry onClick");
            int r4 = p8b.a.a;
            p8b.a.b("retry", this.a.getType().getValue());
            this.a.V90();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NoPermissionFragment a;

        public c(NoPermissionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            int r3 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_NoPermissionFragment", this.a.getType().name() + ", btn_primary onClick");
            this.a.U90();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ NoPermissionFragment a;

        public d(NoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            Lazy r3 = PolicyCenterDisplayIdActionGate.a;
            InternalSecurityAction r4 = this.a.g;
            ((com.ss.android.lark.conditional.access.traffic.handler.policy.center.a) PolicyCenterDisplayIdActionGate.a.getValue()).i3(r4);
            this.a.finish();
            com.ss.android.lark.conditional.access.nopermission.interception.a.a.getClass();
            com.ss.android.lark.conditional.access.nopermission.interception.a.a();
            return;
        }
    }

    static {
    }

    public void U90() {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final ScsFragmentNoPermissionBinding S90() {
        ScsFragmentNoPermissionBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        return null;
    }

    public final NoPermissionViewModel T90() {
        return (NoPermissionViewModel) this.e.getValue();
    }

    public void V90() {
        W90("refresh_button");
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        FileAuthMonitor.d(this.g, "dismiss", this.d);
    }

    public void onPageUpdate() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        InternalSecurityAction r1 = (InternalSecurityAction) r0.getParcelable("param_action");
    L6:
        this.g = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m977provideComponent() {
        return provideComponent();
    }

    public final NoPermissionType getType() {
        return this.d;
    }

    public NoPermissionFragment(NoPermissionType r4) {
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        this.d = r4;
        final Function0<Fragment> r5 = new NoPermissionFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NoPermissionViewModel.class), new NoPermissionFragment$special$$inlined$viewModels$default$2(r5), new NoPermissionFragment$special$$inlined$viewModels$default$3(r5, this));
    }

    public final void W90(String r3) {
        Intrinsics.checkNotNullParameter(r3, "pingSource");
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionFragment", this.d.name() + ", ping()");
        T90().ping(r3, this.g);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        InternalSecurityAction r4 = (InternalSecurityAction) r3.getParcelable("param_action");
    L6:
        this.g = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_NoPermissionFragment", "onViewCreated");
        S90().d.setOnClickListener(new b(this));
        S90().c.setOnClickListener(new c(this));
        T90().getPingLiveData().observe(getViewLifecycleOwner(), new d(this));
        FileAuthMonitor.UpdateTrigger[] r4 = FileAuthMonitor.a;
        FileAuthMonitor.d(this.g, "show", this.d);
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131564436, r14, false);
        int r17 = 2131363229;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131363229);
        if (r2 == null) goto L29;
        r17 = 2131364797;
        UDButton r3 = ViewBindings.findChildViewById(r16, 2131364797);
        if (r3 == null) goto L29;
        r17 = 2131364816;
        UDButton r4 = ViewBindings.findChildViewById(r16, 2131364816);
        if (r4 == null) goto L29;
        r17 = 2131376433;
        if (ViewBindings.findChildViewById(r16, 2131376433) == null) goto L29;
        r17 = 2131379091;
        View r18 = ViewBindings.findChildViewById(r16, 2131379091);
        if (r18 == null) goto L29;
        ScsWidgetLoadingViewBinding r5 = ScsWidgetLoadingViewBinding.a(r18);
        r17 = 2131380912;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131380912);
        if (r6 == null) goto L29;
        r17 = 2131390479;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r16, 2131390479);
        if (r7 == null) goto L29;
        r17 = 2131390740;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r16, 2131390740);
        if (r8 == null) goto L29;
        r17 = 2131391245;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r16, 2131391245);
        if (r9 == null) goto L29;
        r17 = 2131391519;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131391519)) == null) goto L29;
        r17 = 2131391606;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131391606);
        if (r10 == null) goto L29;
        r17 = 2131393116;
        WebView r11 = (WebView) ViewBindings.findChildViewById(r16, 2131393116);
        if (r11 == null) goto L29;
        ScsFragmentNoPermissionBinding r19 = new ScsFragmentNoPermissionBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        this.f = r19;
        return S90().a;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
