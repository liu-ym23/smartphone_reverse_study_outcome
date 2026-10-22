package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements gc0.c {
    public final /* synthetic */ TuningVolumeContentArea a;

    public static final class a implements SeekBarWithProgress.b {
        public final /* synthetic */ g a;

        public final boolean a() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a.a;
            if (r0 != null) goto L5;
            return true;
        L5:
            if (r0.d(TuningVolumeType.ACCOMPANIMENT_VOLUME) != true) goto L10;
            return false;
        L10:
            return true;
        }

        public a(g r1) {
            this.a = r1;
        }
    }

    @Override // gc0.c
    public final int c() {
        return 100;
    }

    @Override // gc0.c
    public final SeekBarWithProgress.b b() {
        return new a(this);
    }

    @Override // gc0.c
    public final int d() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 != null) goto L7;
        return 50;
    L7:
        return (int) r0.A();
    }

    @Override // gc0.c
    public final String a() {
        return s1.B(2131918450);
    }

    public g(TuningVolumeContentArea r1) {
        this.a = r1;
    }

    @Override // gc0.c
    public final void onProgressChanged(int r2) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.G(r2);
        return;
    }
}
