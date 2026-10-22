package com.obric.oui.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gr.e f12872b;

    public /* synthetic */ p(gr.e r5, int r10) {
        this.f12871a = r10;
        this.f12872b = r5;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        switch(this.f12871a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return (float) this.f12872b.a(r5);
    L7:
        return (float) this.f12872b.a(r5);
    L9:
        return (float) this.f12872b.a(r5);
    }
}
