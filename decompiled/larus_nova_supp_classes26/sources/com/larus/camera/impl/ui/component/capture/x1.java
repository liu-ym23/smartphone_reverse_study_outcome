package com.larus.camera.impl.ui.component.capture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x1 extends GestureDetector.SimpleOnGestureListener {
    public boolean a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Function0<Unit> c;

    public x1(m1 r1) {
        this.b = r1;
        this.c = null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a = false;
        return super.onDown(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "e2");
        if (Math.abs(r4) > Math.abs(r3)) goto L5;
        return false;
    L5:
        if (this.a == false) goto L7;
    L16:
        return true;
    L7:
        if (r4 <= 20.0f) goto L12;
        this.a = true;
        Function0<Unit> r5 = this.b;
        if (r5 == null) goto L16;
        r5.invoke();
        goto L16
    L12:
        if (r4 >= (-20.0f)) goto L16;
        this.a = true;
        Function0<Unit> r6 = this.c;
        if (r6 == null) goto L16;
        r6.invoke();
        goto L16
    }
}
