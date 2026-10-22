package com.ss.android.lark.conditional.access.device.ui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentDeclareReasonEditBinding;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;
import com.ss.android.lark.conditional.access.network.model.response.ApplyDeviceData;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.widget.CustomApplyButton;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.suite.lark.emm.design.edittext.SCEditText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = UserScopeDeviceDeclareActivity.class)
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0011\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Lcom/ss/android/lark/conditional/access/device/ui/UserScopeDeclareReasonEditFragment;", "Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentDeclareReasonEditBinding;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "maxLength", BuildConfig.FLAVOR, "applyButton", "Lcom/ss/android/lark/security/compliance/infra/widget/CustomApplyButton;", "backCallback", "com/ss/android/lark/conditional/access/device/ui/UserScopeDeclareReasonEditFragment$backCallback$1", "Lcom/ss/android/lark/conditional/access/device/ui/UserScopeDeclareReasonEditFragment$backCallback$1;", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "updateInputTextCount", "length", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeDeclareReasonEditFragment extends Hilt_UserScopeDeclareReasonEditFragment<ScsFragmentDeclareReasonEditBinding> implements d0c.c {
    public static final /* synthetic */ int m = 0;
    public final Lazy i;
    public final int j;
    public CustomApplyButton k;
    public final UserScopeDeclareReasonEditFragment$backCallback$1 l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ UserScopeDeclareReasonEditFragment a;

        public c(UserScopeDeclareReasonEditFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onChanged(Object r3) {
            ApplyDeviceData r4 = (ApplyDeviceData) r3;
            CustomApplyButton r0 = this.a.k;
            if (r0 == null) goto L5;
            r0.b.c.clearAnimation();
        L5:
            setEnabled(false);
            if (r4 == null) goto L8;
            this.a.V90();
            ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "apply finished with success, close page");
            return;
        L8:
            ((ScsFragmentDeclareReasonEditBinding) this.a.T90()).d.setEnabled(true);
            ((ScsFragmentDeclareReasonEditBinding) this.a.T90()).b.setEnabled(true);
            this.a.S90().getLeftText().setEnabled(true);
            UserScopeDeclareReasonEditFragment r5 = this.a;
            r5.Y90(TextUtils.getTrimmedLength(((ScsFragmentDeclareReasonEditBinding) r5.T90()).d.getEditableText()));
            ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "apply finished with error, recovery ui");
        }
    }

    static {
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

    public final DeviceDeclareViewModel X90() {
        return (DeviceDeclareViewModel) this.i.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.conditional.access.device.ui.UserScopeDeclareReasonEditFragment$backCallback$1] */
    public UserScopeDeclareReasonEditFragment() {
        this.i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DeviceDeclareViewModel.class), new UserScopeDeclareReasonEditFragment$special$$inlined$activityViewModels$default$1(this), new UserScopeDeclareReasonEditFragment$special$$inlined$activityViewModels$default$2(this));
        this.j = ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        this.l = new UserScopeDeclareReasonEditFragment$backCallback$1();
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m953provideComponent() {
        return provideComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y90(int r6) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        String r1 = String.valueOf(r6);
        r0.append(r1).append("/").append(String.valueOf(this.j));
        if (r6 <= this.j) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L12;
        r0.setSpan(new ForegroundColorSpan(ContextCompat.getColor(((BaseFragment) this).mContext, 2131102093)), 0, r1.length(), 17);
        CustomApplyButton r8 = this.k;
        if (r8 == null) goto L11;
        r8.b(CustomApplyButton.ApplyButtonStatus.DISABLE);
    L11:
        ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "disable apply button");
    L16:
        ((ScsFragmentDeclareReasonEditBinding) T90()).c.setText(r0);
        return;
    L12:
        CustomApplyButton r9 = this.k;
        if (r9 == null) goto L15;
        r9.b(CustomApplyButton.ApplyButtonStatus.ENABLE);
    L15:
        ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "enable apply button");
        goto L16
    L5:
        r7 = false;
        goto L7
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final ViewBinding U90(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ConstraintLayout r6 = r4.inflate(2131564434, r5, false);
        int r7 = 2131371382;
        ConstraintLayout r0 = ViewBindings.findChildViewById(r6, 2131371382);
        if (r0 == null) goto L11;
        r7 = 2131371388;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r6, 2131371388);
        if (r1 == null) goto L11;
        r7 = 2131383837;
        SCEditText r2 = ViewBindings.findChildViewById(r6, 2131383837);
        if (r2 == null) goto L11;
        return new ScsFragmentDeclareReasonEditBinding(r6, r0, r1, r2);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        CustomApplyButton r4 = new CustomApplyButton(requireContext());
        r4.setText(r4.getResources().getString(2131892677));
        r4.setOnClickListener(new UserScopeDeclareReasonEditFragment$initView$1$1(this));
        this.k = r4;
        S90().addAction(new com.ss.android.lark.ui.d(this.k));
        S90().setLeftTextOnly(2131892678);
        S90().setTitle(2131892682);
        ((ScsFragmentDeclareReasonEditBinding) T90()).d.setText(X90().getReason());
        ((ScsFragmentDeclareReasonEditBinding) T90()).d.addTextChangedListener(new com.ss.android.lark.conditional.access.device.ui.b(this));
        Y90(TextUtils.getTrimmedLength(((ScsFragmentDeclareReasonEditBinding) T90()).d.getEditableText()));
        UIUtils.setTextStyle(S90().getLeftText(), 2131953908);
        S90().setLeftTextColor(getResources().getColorStateList(2131100762));
        getRootView().setOnClickListener(b.a);
        X90().getApplyDeviceLiveData().observe(getViewLifecycleOwner(), new c(this));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.l);
        ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "onViewCreated");
    }
}
