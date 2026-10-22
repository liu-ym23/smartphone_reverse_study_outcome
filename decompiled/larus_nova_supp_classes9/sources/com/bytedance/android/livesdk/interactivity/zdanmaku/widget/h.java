package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LandscapeZDanmakuWidget a;
    public final /* synthetic */ boolean b;

    public h(LandscapeZDanmakuWidget r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L19;
        r3.booleanValue();
        if (com.bytedance.android.livesdk.f.d().d == false) goto L8;
        return;
    L8:
        if (r3.booleanValue() == false) goto L14;
        if (this.b == false) goto L12;
        float r4 = 0.3f;
    L17:
        this.a.Eq(r4);
        return;
    L12:
        r4 = 0.6f;
        goto L17
    L14:
        if (this.b == false) goto L16;
        r4 = 0.7f;
        goto L17
    L16:
        r4 = 1.0f;
        goto L17
    }
}
