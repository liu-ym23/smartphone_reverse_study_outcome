package com.ss.android.lark.conditional.access.nopermission.ui;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.security.v1.GetDeviceApplySwitchResponse;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ DeviceOwnerNoPermissionV2Fragment a;

    public l(DeviceOwnerNoPermissionV2Fragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        GetDeviceApplySwitchResponse r5 = (GetDeviceApplySwitchResponse) r4;
        if (r5 != null) goto L8;
        DeviceOwnerNoPermissionV2Fragment r6 = this.a;
        int r1 = DeviceOwnerNoPermissionV2Fragment.j;
        r6.S90().e.b.cancelAnimation();
        t4c.b.a(r6.S90().e.a);
        t4c.b.b(r6.S90().f);
        FragmentActivity r7 = r6.getActivity();
        if (r7 == null) goto L7;
        UDToast.show(r7, r7.getString(2131890507));
    L7:
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionV2Fragment", "show error toast by deviceApplySwitchLiveData");
        t4c.b.a(this.a.S90().c);
        t4c.b.b(this.a.S90().f);
    L12:
        this.a.S90().e.b.cancelAnimation();
        t4c.b.a(this.a.S90().e.a);
        return;
    L8:
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionV2Fragment", "switch : " + r5.is_enable);
        if (r5.is_enable.booleanValue() == false) goto L11;
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionV2Fragment", "show switch");
        t4c.b.b(this.a.S90().c);
        t4c.b.b(this.a.S90().f);
        goto L12
    L11:
        t4c.b.a(this.a.S90().c);
        t4c.b.b(this.a.S90().f);
        goto L12
    }
}
