package com.bytedance.android.annie.container.fragment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ AnnieFragment a;

    public e(AnnieFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Long r11 = (Long) r10;
        w8.d r12 = this.a.k0;
        if (r12 == null) goto L6;
        r12.a(true);
        return;
    }
}
