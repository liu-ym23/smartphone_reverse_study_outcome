package com.bytedance.android.annie.param;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<T> implements Consumer {
    public static final h<T> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r10) {
        k r11 = (k) r10;
        com.bytedance.android.annie.a.f(r11);
        if (i.b != null) goto L7;
        i.b = r11;
        return;
    }
}
