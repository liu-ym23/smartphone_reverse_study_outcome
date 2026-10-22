package com.bytedance.android.livesdk.interactivity.like.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ DiggCountFlipperLayout a;

    public m(DiggCountFlipperLayout r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        n81.a.b("user digg");
        this.a.h();
    }
}
