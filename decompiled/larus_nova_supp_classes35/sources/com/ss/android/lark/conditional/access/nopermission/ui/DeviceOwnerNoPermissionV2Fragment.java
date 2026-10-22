package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.conditional.access.utils.OfficeSDKExternalDeviceFactorHelper;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/DeviceOwnerNoPermissionV2Fragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onPrimaryButtonClick", "onPageUpdate", "showErrorToast", "gotoDeviceDeclareActivity", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceOwnerNoPermissionV2Fragment extends Hilt_DeviceOwnerNoPermissionV2Fragment {
    public static final /* synthetic */ int j = 0;

    public static final class a {
    }

    static {
    }

    public DeviceOwnerNoPermissionV2Fragment() {
        super(NoPermissionType.DEVICE_OWNER_V2);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionV2Fragment", "btnDeviceDeclare onClick");
        List<String> r0 = OfficeSDKExternalDeviceFactorHelper.a;
        if (OfficeSDKExternalDeviceFactorHelper.c(requireActivity(), "DeviceApply", this.g, "page", DeviceOwnerNoPermissionV2Fragment$onPrimaryButtonClick$handledByOfficeSDK$1.INSTANCE) == false) goto L5;
        return;
    L5:
        int r1 = g8b.b.a;
        g8b.b.a.a().getDependency().m(requireActivity(), PassportcConvention.b(this));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        super.onPageUpdate();
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionV2Fragment", "onPageUpdate");
        S90().h.setText(requireContext().getText(2131890482));
        S90().i.setText(requireContext().getText(2131890473));
        S90().g.setText(requireContext().getText(2131890527));
        t4c.b.b(S90().e.a);
        t4c.b.a(S90().f);
        S90().e.b.playAnimation();
        T90().getDeviceApplySwitchDataV2();
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionV2Fragment", "onViewCreated");
        S90().h.setText(requireContext().getText(2131890482));
        S90().i.setText(requireContext().getText(2131890473));
        S90().g.setText(requireContext().getText(2131890527));
        t4c.b.b(S90().e.a);
        t4c.b.a(S90().f);
        S90().e.b.playAnimation();
        T90().getDeviceApplySwitchLiveDataV2().observe(getViewLifecycleOwner(), new l(this));
        T90().getDeviceApplySwitchDataV2();
    }
}
