package com.larus.dora.obric.device_management.setting.earbuds.keep_alive;

import android.widget.CompoundButton;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.obric.oui.oswitch.OSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ DoraObricEarbudsKeepAliveFragment a;

    public /* synthetic */ j(DoraObricEarbudsKeepAliveFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r9, boolean r10) {
        DoraObricEarbudsKeepAliveFragment r0 = this.a;
        int r1 = DoraObricEarbudsKeepAliveFragment.F;
        String r2 = null;
        r9.setOnCheckedChangeListener(null);
        r9.setChecked(r0.t);
        OSwitch r3 = r0.r;
        if (r3 == null) goto L5;
        r3.setOnCheckedChangeListener(new j(r0));
    L5:
        Intrinsics.checkNotNull(r9);
        if (com.larus.dora.obric.device_management.setting.earbuds.k.a(r9) == false) goto L9;
        return;
    L9:
        if (r0.ba0() == null) goto L26;
        DoraKeepAliveViewModel r4 = r0.ca0();
        IFlowCompanionDeviceManager r5 = (IFlowCompanionDeviceManager) r0.i.getValue();
        oy8.e r6 = r0.j;
        DoraDevice r11 = r0.ba0();
        if (r11 == null) goto L13;
        String r12 = r11.mac;
    L15:
        if (r12 != null) goto L17;
        String r7 = "";
    L18:
        DoraDevice r13 = r0.ba0();
        if (r13 == null) goto L21;
        r2 = r13.sn;
    L21:
        if (r2 != null) goto L23;
        String r8 = "";
    L24:
        r4.enableCdm(r10, r5, r6, r7, r8);
        return;
    L23:
        r8 = r2;
        goto L24
    L17:
        r7 = r12;
        goto L18
    L13:
        r12 = null;
        goto L15
    }
}
