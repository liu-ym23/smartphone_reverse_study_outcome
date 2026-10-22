package com.larus.dora.obric.device_management.setting.earbuds.doubao_agent;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

    public /* synthetic */ n(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        DoraObricEarbudsDoubaoAgentSettingsFragment r4 = this.a;
        int r0 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
        r4.fa0().updateConvStartEndSoundEnable(r3);
    }
}
