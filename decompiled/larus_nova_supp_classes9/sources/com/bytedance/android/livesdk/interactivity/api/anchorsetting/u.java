package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ PrivilegeSettingDetailDialog a;

    public u(PrivilegeSettingDetailDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r2, int r3) {
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.h1;
        Integer r5 = this.a.g.get(Integer.valueOf(r3));
        Intrinsics.checkNotNull(r5);
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
        PrivilegeSettingDetailDialog.T90(this.a);
    }
}
