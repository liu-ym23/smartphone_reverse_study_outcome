package com.ss.android.lark.conditional.access.device.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentDeviceDeclareOldBinding;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.ui.CommonTitleBar;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = UserScopeDeviceDeclareActivity.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001?B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000fH\u0002J\u001c\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u000f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&H\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u000fH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u000fH\u0002J\u0012\u00103\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010!H\u0016J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u001fH\u0002J\b\u0010;\u001a\u00020\u001fH\u0002J\b\u0010<\u001a\u00020\u001fH\u0002J\b\u0010=\u001a\u00020>H\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006@"}, d2 = {"Lcom/ss/android/lark/conditional/access/device/ui/UserScopeDeviceDeclareFragment;", "Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentDeviceDeclareOldBinding;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "kvStorage", "Lcom/ss/android/lark/storage/kv/storage/KVStorage;", "getKvStorage$annotations", "getKvStorage", "()Lcom/ss/android/lark/storage/kv/storage/KVStorage;", "setKvStorage", "(Lcom/ss/android/lark/storage/kv/storage/KVStorage;)V", "mApplyStatus", BuildConfig.FLAVOR, "Ljava/lang/Integer;", "mNeedProbe", BuildConfig.FLAVOR, "viewModel", "Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initData", "getOS", BuildConfig.FLAVOR, "getDeviceName", "getDeviceInfo", "getApplyStatusLocalData", "updateApplyStatusLocalData", "status", "refreshDeviceStateUI", "applyStatus", "rejectReasonInfo", "getApplySwitchStatus", "showApplyStatusDialog", "refreshDeviceOwnerUI", "ownership", "onClick", "v", "refreshApplyStatus", "showApplyActionPanel", "applyDeviceOwner", "deviceOwnership", "Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency$DeviceOwnership;", "showApplyProcessingDialog", "showApplySuccessDialog", "showApplyRejectDialog", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeDeviceDeclareFragment extends Hilt_UserScopeDeviceDeclareFragment<ScsFragmentDeviceDeclareOldBinding> implements View.OnClickListener, d0c.c {
    public static final /* synthetic */ int m = 0;

    @Inject
    public com.ss.android.lark.storage.kv.storage.a i;
    public Integer j;
    public boolean k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements UDListDialogController.OnItemClickListener {
        public final /* synthetic */ UserScopeDeviceDeclareFragment a;

        public b(UserScopeDeviceDeclareFragment r1) {
            this.a = r1;
        }

        public final void onItemClick(int r2) {
            if (r2 != 0) goto L4;
            UserScopeDeviceDeclareFragment.X90(this.a, ConditionalAccessNetDependency.DeviceOwnership.Company);
            return;
        L4:
            UserScopeDeviceDeclareFragment.X90(this.a, ConditionalAccessNetDependency.DeviceOwnership.Personal);
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

    public final void aa0() {
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "getDeviceInfo");
        if (this.j != null) goto L9;
        com.ss.android.lark.storage.kv.storage.a r0 = this.i;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r0 = null;
    L8:
        com.ss.android.lark.storage.a r1 = com.ss.android.lark.security.compliance.infra.storage.d.a;
        Intrinsics.checkNotNullParameter(r0, "user");
        this.j = Integer.valueOf(LarkKVStorage.d(LarkKVStorage.a, r0, com.ss.android.lark.security.compliance.infra.storage.d.a, "common").getInt("scs_sp_conditional_access_apply_status", ConditionalAccessNetDependency.DeviceApplyStatus.Unknown.getValue()));
    L9:
        ba0().getDeviceInfo();
    }

    public final DeviceDeclareViewModel ba0() {
        return (DeviceDeclareViewModel) this.l.getValue();
    }

    public UserScopeDeviceDeclareFragment() {
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DeviceDeclareViewModel.class), new UserScopeDeviceDeclareFragment$special$$inlined$activityViewModels$default$1(this), new UserScopeDeviceDeclareFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void da0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        new UDActionPanelBuilder(r0).title(r0.getString(2131890535)).items(CollectionsKt.listOf(new String[]{r0.getString(2131892679), r0.getString(2131892680)})).itemClickListener(new b(this)).addActionButton(2131391775, r0.getString(2131890466), null).show();
        return;
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m961provideComponent() {
        return provideComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (Intrinsics.areEqual(r3, ((ScsFragmentDeviceDeclareOldBinding) T90()).b) == false) goto L6;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "btnApply onclick");
        da0();
        return;
    L6:
        if (Intrinsics.areEqual(r3, ((ScsFragmentDeviceDeclareOldBinding) T90()).j) == false) goto L13;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "llRefreshContainer onclick");
        p8b.a.a("refresh");
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L10;
        UDToast.show(r4, r4.getString(2131890469));
    L10:
        aa0();
        return;
    }

    public static final void X90(UserScopeDeviceDeclareFragment r2, ConditionalAccessNetDependency.DeviceOwnership r3) {
        r2.getClass();
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "applyDeviceOwner, owner: " + r3);
        if (r2.ba0().deviceApplyReasonEnable() == false) goto L5;
        r2.ba0().launchReasonEditPage(r3.getValue());
        return;
    L5:
        DeviceDeclareViewModel.applyDevice$default(r2.ba0(), r3.getValue(), null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Y90(UserScopeDeviceDeclareFragment r2, int r3) {
        TextView r0 = ((ScsFragmentDeviceDeclareOldBinding) r2.T90()).g;
        if (r3 != ConditionalAccessNetDependency.DeviceOwnership.Company.getValue()) goto L8;
        FragmentActivity r4 = r2.getActivity();
        if (r4 == null) goto L15;
        String r5 = r4.getString(2131892679);
    L16:
        r0.setText(r5);
        return;
    L15:
        r5 = null;
        goto L16
    L8:
        if (r3 != ConditionalAccessNetDependency.DeviceOwnership.Personal.getValue()) goto L12;
        FragmentActivity r6 = r2.getActivity();
        if (r6 == null) goto L15;
        r5 = r6.getString(2131892680);
        goto L16
    L12:
        FragmentActivity r7 = r2.getActivity();
        if (r7 == null) goto L15;
        r5 = r7.getString(2131890548);
        goto L16
    }

    public static final void Z90(UserScopeDeviceDeclareFragment r7, int r8) {
        r7.getClass();
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "showApplyStatusDialog, applyStatus: " + r8);
        if (r8 != ConditionalAccessNetDependency.DeviceApplyStatus.Pass.getValue()) goto L11;
        FragmentActivity r9 = r7.getActivity();
        if (r9 == null) goto L21;
        UDDialogBuilder r1 = new UDDialogBuilder(r9);
        if (r7.k == false) goto L9;
        r1.title(r9.getString(2131890546)).message(r9.getString(2131890539)).addActionButton(2131391778, r9.getString(2131890503), l.a).addActionButton(2131391777, r9.getString(2131890551), new m(r7)).show();
        return;
    L9:
        r1.title(r9.getString(2131890546)).message(r9.getString(2131890539)).addActionButton(2131391777, r9.getString(2131890503), n.a).show();
        return;
    L21:
        return;
    L11:
        if (r8 != ConditionalAccessNetDependency.DeviceApplyStatus.Processing.getValue()) goto L16;
        FragmentActivity r10 = r7.getActivity();
        if (r10 == null) goto L24;
        new UDDialogBuilder(r10).title(r10.getString(2131890546)).message(r10.getString(2131890538)).addActionButton(2131391777, r10.getString(2131890503), i.a).show();
        return;
    L24:
        return;
    L16:
        if (r8 != ConditionalAccessNetDependency.DeviceApplyStatus.Reject.getValue()) goto L26;
        FragmentActivity r11 = r7.getActivity();
        if (r11 == null) goto L27;
        new UDDialogBuilder(r11).title(r11.getString(2131890546)).message(r11.getString(2131890544)).addActionButton(2131391778, r11.getString(2131890503), j.a).addActionButton(2131391777, r11.getString(2131890523), new k(r7)).show();
        return;
    L27:
        return;
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final ViewBinding U90(LayoutInflater r17, ViewGroup r18) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131564435, r18, false);
        int r1 = 2131363177;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131363177);
        if (r5 == null) goto L43;
        r1 = 2131363178;
        Group r6 = ViewBindings.findChildViewById(r0, 2131363178);
        if (r6 == null) goto L43;
        r1 = 2131368912;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131368912);
        if (r7 == null) goto L43;
        r1 = 2131368914;
        if (ViewBindings.findChildViewById(r0, 2131368914) == null) goto L43;
        r1 = 2131368915;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131368915);
        if (r8 == null) goto L43;
        r1 = 2131368916;
        if (ViewBindings.findChildViewById(r0, 2131368916) == null) goto L43;
        r1 = 2131368917;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r0, 2131368917);
        if (r9 == null) goto L43;
        r1 = 2131368918;
        if (ViewBindings.findChildViewById(r0, 2131368918) == null) goto L43;
        r1 = 2131368919;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131368919);
        if (r10 == null) goto L43;
        r1 = 2131368920;
        if (ViewBindings.findChildViewById(r0, 2131368920) == null) goto L43;
        r1 = 2131371563;
        if (((Space) ViewBindings.findChildViewById(r0, 2131371563)) == null) goto L43;
        r1 = 2131376175;
        if (ViewBindings.findChildViewById(r0, 2131376175) == null) goto L43;
        r1 = 2131377904;
        View r11 = ViewBindings.findChildViewById(r0, 2131377904);
        if (r11 == null) goto L43;
        r1 = 2131377907;
        View r12 = ViewBindings.findChildViewById(r0, 2131377907);
        if (r12 == null) goto L43;
        r1 = 2131384134;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r0, 2131384134);
        if (r13 == null) goto L43;
        r1 = 2131384135;
        Group r14 = ViewBindings.findChildViewById(r0, 2131384135);
        if (r14 == null) goto L43;
        r1 = 2131384191;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131384191);
        if (r15 == null) goto L43;
        r1 = 2131384192;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131384192)) == null) goto L43;
        r1 = 2131390740;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131390740)) == null) goto L43;
        return new ScsFragmentDeviceDeclareOldBinding(r0, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ca0(int r4, String r5) {
        ((ScsFragmentDeviceDeclareOldBinding) T90()).c.setVisibility(8);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).k.setVisibility(8);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).l.setVisibility(8);
        if (r4 != ConditionalAccessNetDependency.DeviceApplyStatus.Pass.getValue()) goto L5;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setText(getString(2131890526));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setTextColor(getResources().getColor(2131109127));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setBackground(getResources().getDrawable(2131247516));
        return;
    L5:
        boolean r1 = false;
        if (r4 != ConditionalAccessNetDependency.DeviceApplyStatus.Processing.getValue()) goto L9;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setText(getString(2131890521));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setTextColor(getResources().getColor(2131109131));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setBackground(getResources().getDrawable(2131247519));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).k.setVisibility(0);
        return;
    L9:
        if (r4 != ConditionalAccessNetDependency.DeviceApplyStatus.Reject.getValue()) goto L26;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setText(getString(2131890483));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setTextColor(getResources().getColor(2131109132));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setBackground(getResources().getDrawable(2131247520));
        if (ba0().deviceApplyReasonEnable() == false) goto L25;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).l.setVisibility(0);
        StringBuilder r6 = new StringBuilder(String.valueOf(getString(2131892683)));
        if (r5 == null) goto L22;
        String r0 = StringsKt.trim(r5).toString();
        if (r0 == null) goto L22;
        if (r0.length() <= 0) goto L19;
        boolean r2 = true;
    L20:
        if (r2 != true) goto L22;
        r1 = true;
        goto L22
    L19:
        r2 = false;
    L22:
        if (r1 == false) goto L24;
        TextView r3 = ((ScsFragmentDeviceDeclareOldBinding) T90()).l;
        r6.append(r5);
        r3.setText(r6.toString());
        goto L25
    L24:
        TextView r7 = ((ScsFragmentDeviceDeclareOldBinding) T90()).l;
        r6.append("-");
        r7.setText(r6.toString());
    L25:
        ba0().getDeviceApplySwitchData();
        return;
    L26:
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setText(getString(2131890537));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setTextColor(getResources().getColor(2131109115));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).d.setBackground(getResources().getDrawable(2131247518));
        ba0().getDeviceApplySwitchData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "onViewCreated");
        Bundle r4 = getArguments();
        boolean r5 = false;
        if (r4 == null) goto L5;
        r5 = r4.getBoolean("need_probe", false);
    L5:
        this.k = r5;
        String r6 = null;
        if (r5 == true) goto L8;
        p8b.a.d("scs_device_declare_view", null);
    L8:
        CommonTitleBar r7 = S90();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L11;
        r6 = r0.getString(2131890471);
    L11:
        r7.setTitle(r6);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).e.setText(RomUtils.c());
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f.setText(RomUtils.d());
        ((ScsFragmentDeviceDeclareOldBinding) T90()).b.setOnClickListener(this);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).j.setOnClickListener(this);
        ba0().getDeviceInfoLiveData().observe(getViewLifecycleOwner(), new e(this));
        ba0().getDeviceApplySwitchLiveData().observe(getViewLifecycleOwner(), new f(this));
        ba0().getApplyDeviceLiveData().observe(getViewLifecycleOwner(), new g(this));
        ba0().getPinLiveData().observe(getViewLifecycleOwner(), new h(this));
        aa0();
    }
}
