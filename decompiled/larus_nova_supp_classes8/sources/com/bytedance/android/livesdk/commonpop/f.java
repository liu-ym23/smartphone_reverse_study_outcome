package com.bytedance.android.livesdk.commonpop;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements View.OnTouchListener {
    public final /* synthetic */ Ref.FloatRef a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ View c;

    public f(Ref.FloatRef r1, Function0 r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        int r6 = r4.getHeight() / 3;
        float r0 = r5.getRawY() - this.a.element;
        int r1 = r5.getAction();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L9;
    L16:
        return true;
    L9:
        if (r0 >= 0) goto L16;
        this.c.setTranslationY(r0);
        goto L16
    L12:
        if (r0 >= (-r6)) goto L14;
        this.b.invoke();
        goto L16
    L14:
        this.c.animate().translationY(0.0f).start();
        goto L16
    L15:
        this.a.element = r5.getRawY();
        goto L16
    }
}
