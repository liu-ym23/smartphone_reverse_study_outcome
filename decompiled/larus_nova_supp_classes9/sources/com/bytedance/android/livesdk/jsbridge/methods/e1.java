package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1<T> implements Consumer {
    public final /* synthetic */ d1 a;

    public e1(d1 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        int r6 = ((Number) r5).intValue();
        d1 r0 = this.a;
        Context r1 = r0.a.get();
        if (r1 == null) goto L13;
        String r2 = r1.getString(2131922150);
        if (r0.e != null) goto L8;
        km3.g r3 = km3.g.c(r1, r2);
        r3.e = new h1(r0);
        r3.b();
        Unit r4 = Unit.INSTANCE;
        r0.e = r3;
    L8:
        km3.g r7 = r0.e;
        if (r7 == null) goto L12;
        r7.setProgress(r6);
        return;
    L12:
        return;
    }
}
