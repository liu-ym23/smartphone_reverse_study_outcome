package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LandscapeZDanmakuWidget a;
    public final /* synthetic */ boolean b;

    public g(LandscapeZDanmakuWidget r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L9;
        if (this.b == false) goto L7;
        float r3 = 0.7f;
    L12:
        this.a.Eq(r3);
        return;
    L7:
        r3 = 0.6f;
        goto L12
    L9:
        if (this.b == false) goto L11;
        r3 = 0.3f;
        goto L12
    L11:
        r3 = 1.0f;
        goto L12
    }
}
