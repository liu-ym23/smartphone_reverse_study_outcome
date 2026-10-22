package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.widget.CompoundButton;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.obric.oui.oswitch.OSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment b;

    public /* synthetic */ d0(boolean r1, DoraObricEarbudsBroadcastSettingFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        boolean r0 = this.a;
        DoraObricEarbudsBroadcastSettingFragment r1 = this.b;
        int r2 = DoraObricEarbudsBroadcastSettingFragment.F;
        r5.setOnCheckedChangeListener(null);
        r5.setChecked(r0);
        OSwitch r3 = r1.C;
        if (r3 == null) goto L5;
        r3.setOnCheckedChangeListener(new d0(r0, r1));
    L5:
        Intrinsics.checkNotNull(r5);
        if (com.larus.dora.obric.device_management.setting.earbuds.k.a(r5) == true) goto L9;
        DoraUserSettingsManager r7 = DoraUserSettingsManager.a;
        DoraUserSettingsManager.o(r6);
        return;
    }
}
