package com.bytedance.android.livesdk.interactivity.zdanmaku.cast;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import p22.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements h80.d {
    public final /* synthetic */ CastZDanmakuWidget a;

    public d(CastZDanmakuWidget r1) {
        this.a = r1;
    }

    public final Object get() {
        k r0 = this.a.h;
        if (r0 != null) goto L6;
        BarrageSetting r1 = (BarrageSetting) l42.a.d.getValue();
        return new k(r1.getBarrageArea(), r1.getFontSize(), r1.getAlpha());
    L6:
        return r0;
    }
}
