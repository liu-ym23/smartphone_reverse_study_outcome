package com.ss.android.lark.conditional.access.web.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentBindDeviceWebBinding;
import com.ss.android.lark.conditional.access.network.model.response.BindDeviceWebData;
import com.ss.android.lark.conditional.access.utils.PrivacyPolicyUtils;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = UserScopeBindDeviceWebActivity.class)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001)B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010!H\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020(H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/conditional/access/web/ui/UserScopeBindDeviceWebFragment;", "Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentBindDeviceWebBinding;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/conditional/access/web/viewmodel/BindDeviceWebViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/web/viewmodel/BindDeviceWebViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mWebDid", BuildConfig.FLAVOR, "mBundleId", "mTvPolicy", "Landroid/widget/TextView;", "mBtnAuthorize", "Lcom/larksuite/component/universe_design/button/UDButton;", "mBtnCancel", "mCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "mTvDesc", "mTvSubDesc", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "popPolicyNotice", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeBindDeviceWebFragment extends Hilt_UserScopeBindDeviceWebFragment<ScsFragmentBindDeviceWebBinding> implements View.OnClickListener, d0c.c {
    public final Lazy i;
    public String j;
    public String k;
    public TextView l;
    public UDButton m;
    public UDButton n;
    public UDCheckBox o;
    public TextView p;
    public TextView q;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ UserScopeBindDeviceWebFragment a;

        public b(UserScopeBindDeviceWebFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            BindDeviceWebData r4 = (BindDeviceWebData) r3;
            if (r4 != null) goto L8;
            ScsLogger.c("SecurityPolicy_UserScopeBindDeviceWebFragment", "bindDeviceWeb error");
            FragmentActivity r5 = this.a.getActivity();
            if (r5 == null) goto L22;
            UDToast.show(r5, r5.getString(2131890507));
            return;
        L22:
            return;
        L8:
            if (r4.getSuccess() == false) goto L18;
            ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bindDeviceWeb success");
            FragmentActivity r6 = this.a.getActivity();
            if (r6 != null) goto L12;
            return;
        L12:
            if (this.a.k.length() != 0) goto L14;
            boolean r0 = true;
        L15:
            if (r0 == false) goto L17;
            r6.finish();
            return;
        L17:
            r6.moveTaskToBack(true);
            r6.finish();
            return;
        L14:
            r0 = false;
            goto L15
        L18:
            ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bindDeviceWeb failed");
            FragmentActivity r7 = this.a.getActivity();
            if (r7 == null) goto L27;
            UDToast.show(r7, r7.getString(2131890507));
            return;
        }
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public UserScopeBindDeviceWebFragment() {
        this.i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindDeviceWebViewModel.class), new UserScopeBindDeviceWebFragment$special$$inlined$activityViewModels$default$1(this), new UserScopeBindDeviceWebFragment$special$$inlined$activityViewModels$default$2(this));
        this.j = BuildConfig.FLAVOR;
        this.k = BuildConfig.FLAVOR;
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m1002provideComponent() {
        return provideComponent();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (Intrinsics.areEqual(r7, this.m) == false) goto L19;
        UDCheckBox r8 = this.o;
        if (r8 == null) goto L9;
        boolean r0 = true;
        if (r8.isChecked() != true) goto L9;
    L10:
        if (r0 == false) goto L12;
        int r9 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bind device web, mPolicyAgree: true, web id: " + this.j + ", bundleID: " + this.k);
        ((BindDeviceWebViewModel) this.i.getValue()).bindDeviceWeb(this.j);
        return;
    L12:
        int r10 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bind device web, mPolicyAgree: false, web id: " + this.j + ", bundleID: " + this.k);
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "popPolicyNotice");
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L25;
        UDDialogBuilder r1 = new UDDialogBuilder(r11);
        View r2 = LayoutInflater.from(r11).inflate(2131564439, null);
        TextView r3 = (TextView) r2.findViewById(2131390396);
        if (r3 == null) goto L17;
        new PrivacyPolicyUtils.c(r3, 2131890528).a();
    L17:
        r1.title(r11.getString(2131890546)).contentLayout(r2).addActionButton(2131391777, r11.getString(2131890522), new d(this)).addActionButton(2131391778, r11.getString(2131890466), new e(this)).show();
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "did show pop policy notice, web did: " + this.j);
        return;
    L25:
        return;
    L9:
        r0 = false;
        goto L10
    L19:
        if (Intrinsics.areEqual(r7, this.n) == false) goto L27;
        int r12 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "cancel bind device web id: " + this.j + ", bundleID: " + this.k);
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L28;
        r13.finish();
        return;
    L28:
        return;
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final ViewBinding U90(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r5 = r3.inflate(2131564432, r4, false);
        int r6 = 2131364649;
        if (ViewBindings.findChildViewById(r5, 2131364649) == null) goto L25;
        r6 = 2131364673;
        if (ViewBindings.findChildViewById(r5, 2131364673) == null) goto L25;
        r6 = 2131365631;
        if (ViewBindings.findChildViewById(r5, 2131365631) == null) goto L25;
        r6 = 2131378895;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131378895)) == null) goto L25;
        r6 = 2131378896;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131378896)) == null) goto L25;
        r6 = 2131390479;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131390479)) == null) goto L25;
        r6 = 2131390480;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131390480)) == null) goto L25;
        r6 = 2131391128;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131391128)) == null) goto L25;
        r6 = 2131391517;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131391517)) == null) goto L25;
        r6 = 2131391606;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131391606)) == null) goto L25;
        return new ScsFragmentBindDeviceWebBinding(r5);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Bundle r6 = getArguments();
        String r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.getString("web_did");
    L6:
        this.j = String.valueOf(r8);
        Bundle r9 = getArguments();
        if (r9 == null) goto L9;
        String r10 = r9.getString("bundle_id");
    L10:
        this.k = String.valueOf(r10);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L13;
        UDButton r12 = (UDButton) r11.findViewById(2131364649);
    L14:
        this.m = r12;
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L17;
        UDButton r14 = (UDButton) r13.findViewById(2131364673);
    L18:
        this.n = r14;
        UDButton r15 = this.m;
        if (r15 == null) goto L21;
        r15.setOnClickListener(this);
    L21:
        UDButton r16 = this.n;
        if (r16 == null) goto L24;
        r16.setOnClickListener(this);
    L24:
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L27;
        TextView r18 = (TextView) r17.findViewById(2131391128);
    L28:
        this.l = r18;
        FragmentActivity r19 = getActivity();
        if (r19 == null) goto L31;
        UDCheckBox r20 = (UDCheckBox) r19.findViewById(2131365631);
    L32:
        this.o = r20;
        FragmentActivity r21 = getActivity();
        if (r21 == null) goto L35;
        TextView r22 = (TextView) r21.findViewById(2131390479);
    L36:
        this.p = r22;
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L39;
        TextView r24 = (TextView) r23.findViewById(2131390480);
    L40:
        this.q = r24;
        TextView r25 = this.l;
        if (r25 == null) goto L43;
        new PrivacyPolicyUtils.c(r25, 2131890505).a();
    L43:
        TextView r26 = this.p;
        if (r26 == null) goto L50;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L48;
        String r2 = com.ss.android.lark.security.compliance.infra.util.a.a.a(r1);
    L49:
        r26.setText(UIHelper.mustacheFormat(2131890461, "brand", r2));
        goto L50
    L48:
        r2 = null;
    L50:
        TextView r27 = this.q;
        if (r27 == null) goto L56;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L55;
        r7 = com.ss.android.lark.security.compliance.infra.util.a.a.a(r3);
    L55:
        r27.setText(UIHelper.mustacheFormat(2131890463, "brand", r7));
    L56:
        ((BindDeviceWebViewModel) this.i.getValue()).getBindDeviceWebLiveData().observe(getViewLifecycleOwner(), new b(this));
        return;
    L39:
        r24 = null;
        goto L40
    L35:
        r22 = null;
        goto L36
    L31:
        r20 = null;
        goto L32
    L27:
        r18 = null;
        goto L28
    L17:
        r14 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
