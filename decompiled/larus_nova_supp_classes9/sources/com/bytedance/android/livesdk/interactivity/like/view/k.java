package com.bytedance.android.livesdk.interactivity.like.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements n81.b {
    public final /* synthetic */ DiggCountFlipperLayout b;

    public final void onShow() {
        DiggCountFlipperLayout r0 = this.b;
        Function1<? super String, Unit> r1 = r0.w;
        if (r1 == null) goto L6;
        Unit r2 = (Unit) r1.invoke(r0.i);
        return;
    }

    public k(DiggCountFlipperLayout r1) {
        this.b = r1;
    }
}
