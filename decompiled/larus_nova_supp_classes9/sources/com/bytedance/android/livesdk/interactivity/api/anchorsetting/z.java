package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ XiaoAnSettingDialog a;

    public z(XiaoAnSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r2, int r3) {
        XiaoAnSettingDialog r4 = this.a;
        r4.i = r4.g.get(Integer.valueOf(r3));
    }
}
