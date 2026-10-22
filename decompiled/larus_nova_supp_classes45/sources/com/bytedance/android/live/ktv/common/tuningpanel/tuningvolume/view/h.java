package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements gc0.a {
    public final /* synthetic */ TuningVolumeContentArea a;

    @Override // gc0.a
    public final int a() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.u();
    }

    @Override // gc0.a
    public final void b() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.c0(1.0d);
        return;
    }

    @Override // gc0.a
    public final void c() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.g0(1.0d);
        return;
    }

    public h(TuningVolumeContentArea r1) {
        this.a = r1;
    }

    @Override // gc0.a
    public final boolean d(TuningVolumeType r2) {
        Intrinsics.checkNotNullParameter(r2, "toneVolume");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d(r2) != true) goto L7;
        return true;
    }
}
