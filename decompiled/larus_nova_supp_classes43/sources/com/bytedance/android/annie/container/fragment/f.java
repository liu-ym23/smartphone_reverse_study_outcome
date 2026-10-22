package com.bytedance.android.annie.container.fragment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ AnnieFragment a;

    public f(AnnieFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        com.bytedance.android.annie.param.a r0 = this.a.f;
        if (r0 == null) goto L8;
        x8.b r1 = r0.d;
        if (r1 == null) goto L9;
        x8.b.c(r1, r11);
        return;
    L9:
        return;
    }
}
