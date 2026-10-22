package com.ss.android.lark.imageocr.select;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ e a;

    public h(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        e r4 = this.a;
        r4.h = (int) r3.getX();
        e r5 = this.a;
        r5.i = (int) r3.getY();
        return false;
    }
}
