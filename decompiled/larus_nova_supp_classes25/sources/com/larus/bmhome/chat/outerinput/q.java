package com.larus.bmhome.chat.outerinput;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function1<Integer, Unit> b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.getHeight() <= 0) goto L9;
        Function1<Integer, Unit> r0 = this.b;
        if (r0 == null) goto L7;
        r0.invoke(Integer.valueOf(this.a.getHeight() - c7.b(Float.valueOf(12.0f))));
    L7:
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(View r1, Function1<? super Integer, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
