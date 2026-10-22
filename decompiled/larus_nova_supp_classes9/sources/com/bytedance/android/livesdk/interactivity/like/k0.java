package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ DiggWidget a;

    public k0(DiggWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r r5 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r) r4;
        List<? extends py.k> r0 = r5.iconList;
        if (r0 == null) goto L5;
        DiggWidget r1 = this.a;
        int r2 = DiggWidget.M1;
        r1.Nq(r0);
    L5:
        DiggWidget r3 = this.a;
        int r6 = DiggWidget.M1;
        r3.ar(r5);
    }
}
