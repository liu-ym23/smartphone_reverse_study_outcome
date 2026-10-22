package com.obric.oui.popover;

import android.view.animation.Interpolator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/popover/SpringInterpolator;", "Landroid/view/animation/Interpolator;", "factor", "", "(F)V", "getInterpolation", "ratio", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14331a;

    public g(float r2) {
        this.f14331a = 0.5f;
        this.f14331a = r2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        boolean r1 = false;
        if (r10 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r10;
    L8:
        if (r10 != 1.0f) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L15;
        double r2 = Math.pow(2.0d, (-10) * r10);
        float r9 = this.f14331a;
        return (float) ((r2 * Math.sin(((((double) r10) - (((double) r9) / 4.0d)) * 6.283185307179586d) / ((double) r9))) + ((double) 1));
    L15:
        return r10;
    L5:
        r0 = false;
        goto L6
    }
}
