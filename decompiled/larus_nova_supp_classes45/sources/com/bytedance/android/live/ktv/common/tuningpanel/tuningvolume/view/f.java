package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements gc0.c {
    public final /* synthetic */ TuningVolumeContentArea a;

    @Override // gc0.c
    public final SeekBarWithProgress.b b() {
        return new gc0.b();
    }

    @Override // gc0.c
    public final int d() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 != null) goto L7;
        return 50;
    L7:
        return (int) r0.e();
    }

    @Override // gc0.c
    public final String a() {
        return s1.B(2131918643);
    }

    @Override // gc0.c
    public final int c() {
        return vm2.h.M().g();
    }

    public f(TuningVolumeContentArea r1) {
        this.a = r1;
    }

    @Override // gc0.c
    public final void onProgressChanged(int r3) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 == null) goto L6;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.C0218a.b(r0, r3, 6);
        return;
    }
}
