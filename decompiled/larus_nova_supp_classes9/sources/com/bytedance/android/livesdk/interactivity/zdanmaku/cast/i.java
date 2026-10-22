package com.bytedance.android.livesdk.interactivity.zdanmaku.cast;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements h80.d {
    public final /* synthetic */ CastZDanmakuWidget a;

    public i(CastZDanmakuWidget r1) {
        this.a = r1;
    }

    public final Object get() {
        p22.i r0 = this.a.j;
        if (r0 != null) goto L6;
        BarrageSetting r1 = (BarrageSetting) l42.a.d.getValue();
        return new p22.i(r1.getBarrageArea(), r1.getFontSize(), r1.getAlpha());
    L6:
        return r0;
    }
}
