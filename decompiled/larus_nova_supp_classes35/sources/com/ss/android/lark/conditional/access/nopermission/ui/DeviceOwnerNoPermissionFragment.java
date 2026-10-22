package com.ss.android.lark.conditional.access.nopermission.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.conditional.access.device.ui.UserScopeDeviceDeclareActivity;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/DeviceOwnerNoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "passportService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "getPassportService", "()Lcom/ss/android/lark/passportc/api/IPassportUserService;", "setPassportService", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;)V", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onPrimaryButtonClick", "onPageUpdate", "setupDeclareUI", "showErrorToast", "gotoDeviceDeclareActivity", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceOwnerNoPermissionFragment extends Hilt_DeviceOwnerNoPermissionFragment {
    public static final /* synthetic */ int k = 0;

    @Inject
    public com.ss.android.lark.passportc.api.m j;

    public static final class a {
    }

    static {
    }

    public DeviceOwnerNoPermissionFragment() {
        super(NoPermissionType.DEVICE_OWNER);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "btnDeviceDeclare onClick");
        int r0 = UserScopeDeviceDeclareActivity.c;
        FragmentActivity r1 = requireActivity();
        com.ss.android.lark.passportc.api.m r2 = this.j;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("passportService");
        r2 = null;
    L6:
        UserSession r3 = r2.getSession();
        Intrinsics.checkNotNullParameter(r1, "context");
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareActivity", "startUi, needRetry: true");
        Intent r4 = new Intent(r1, UserScopeDeviceDeclareActivity.class);
        boolean r5 = r1 instanceof Activity;
        if (r5 == true) goto L9;
        r4.addFlags(268435456);
    L9:
        if (r3 == null) goto L11;
        PassportcConvention.g(r4, r3);
    L12:
        r4.putExtra("can_be_covered", false);
        r4.putExtra("need_probe", true);
        if (r5 == false) goto L15;
        r1.startActivityForResult(r4, 9999);
        return;
    L15:
        r1.startActivity(r4);
        return;
    L11:
        PassportcConvention.e(r4, LarkContext.getApplication());
        goto L12
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "onPageUpdate");
        S90().h.setText(requireContext().getText(2131890482));
        S90().i.setText(requireContext().getText(2131890473));
        S90().g.setText(requireContext().getText(2131890527));
        t4c.b.b(S90().e.a);
        t4c.b.a(S90().f);
        S90().e.b.playAnimation();
        T90().getDeviceInfo();
    }

    public static final void Y90(DeviceOwnerNoPermissionFragment r1) {
        r1.S90().e.b.cancelAnimation();
        t4c.b.a(r1.S90().e.a);
        t4c.b.b(r1.S90().f);
        FragmentActivity r2 = r1.getActivity();
        if (r2 == null) goto L6;
        UDToast.show(r2, r2.getString(2131890507));
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "onViewCreated");
        S90().h.setText(requireContext().getText(2131890482));
        S90().i.setText(requireContext().getText(2131890473));
        S90().g.setText(requireContext().getText(2131890527));
        t4c.b.b(S90().e.a);
        t4c.b.a(S90().f);
        S90().e.b.playAnimation();
        T90().getDeviceInfoLiveData().observe(getViewLifecycleOwner(), new h(this));
        T90().getBindDeviceLiveData().observe(getViewLifecycleOwner(), new i(this));
        T90().getDeviceApplySwitchLiveData().observe(getViewLifecycleOwner(), new j(this));
        T90().getDeviceInfo();
    }
}
