package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements ScaleGestureDetector.OnScaleGestureListener {
    public float a;
    public float b;
    public boolean c;
    public final float d;
    public final float e;
    public boolean f;
    public boolean g;
    public final View h;
    public final ViewGroup i;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r6) {
        Intrinsics.checkNotNullParameter(r6, "detector");
        boolean r1 = true;
        if (this.f == false) goto L7;
        if (r6.getScaleFactor() <= 1) goto L7;
    L11:
        if (this.f == false) goto L14;
        r6.getScaleFactor();
    L14:
        if (this.g == false) goto L16;
        r6.getScaleFactor();
    L16:
        return true;
    L7:
        if (this.g == true) goto L9;
    L17:
        float r0 = this.b * r6.getScaleFactor();
        this.a = r0;
        float r7 = this.d * 1.0f;
        if (r0 <= r7) goto L20;
        this.a = r7;
        this.f = true;
        this.g = false;
    L24:
        Float r8 = Float.valueOf(this.a);
        Float r2 = Float.valueOf(this.a);
        if (r8 == null) goto L27;
        this.h.setScaleX(r8.floatValue());
    L27:
        if (r2 == null) goto L29;
        this.h.setScaleY(r2.floatValue());
    L29:
        return r1;
    L20:
        float r9 = this.e * 1.0f;
        if (r0 >= r9) goto L23;
        this.a = r9;
        this.f = false;
        this.g = true;
        goto L24
    L23:
        this.f = false;
        this.g = false;
        r1 = false;
        goto L24
    L9:
        if (r6.getScaleFactor() >= 1) goto L17;
        goto L17
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        this.b = this.a;
    }

    public c(View r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        this.h = r2;
        this.i = r3;
        this.a = 1.0f;
        this.b = 1.0f;
        this.d = 5.0f;
        this.e = 1.0f;
        this.g = true;
    }
}
