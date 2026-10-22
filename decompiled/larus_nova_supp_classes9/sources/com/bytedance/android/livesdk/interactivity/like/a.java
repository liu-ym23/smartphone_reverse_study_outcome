package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements h80.a<Long>, Consumer<Long> {
    public final /* synthetic */ DigAccessibilityWidget a;

    public a(DigAccessibilityWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.xq();
    }
}
