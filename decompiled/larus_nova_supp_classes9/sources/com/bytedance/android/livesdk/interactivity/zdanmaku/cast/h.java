package com.bytedance.android.livesdk.interactivity.zdanmaku.cast;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements h80.d {
    public final /* synthetic */ CastZDanmakuWidget a;

    public h(CastZDanmakuWidget r1) {
        this.a = r1;
    }

    public final Object get() {
        CastZDanmakuWidget r0 = this.a;
        p22.g r1 = r0.e;
        if (r1 == null) goto L5;
        return r1;
    L5:
        return r0.wq((BarrageSetting) l42.a.d.getValue());
    }
}
