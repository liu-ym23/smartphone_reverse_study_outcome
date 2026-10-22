package com.bytedance.android.live.revenue.platform.network.dynamic;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements vlc.l {
    public final /* synthetic */ Function1 a;

    public a(Function1 r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r2) {
        if (r2 == null) goto L5;
        this.a.invoke(r2);
        return;
    }
}
