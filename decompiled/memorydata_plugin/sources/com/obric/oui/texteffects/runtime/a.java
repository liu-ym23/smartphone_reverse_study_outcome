package com.obric.oui.texteffects.runtime;

import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\rB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/texteffects/runtime/AeShapeInterpolator;", "Landroid/view/animation/Interpolator;", "mode", "", "easeLow", "", "easeHigh", "(IFF)V", "highPower", "", "lowPower", "getInterpolation", "input", "Mode", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f14687b;
    private final float c;
    private final double d;
    private final double e;

    public a() {
        this(0, 0.0f, 0.0f, 7, null);
    }

    public a(int r10, float r11, float r12) {
        this.f14686a = r10;
        this.f14687b = r11;
        this.c = r12;
        double r7 = r11;
        if (r11 < 0.0f) goto L5;
        double r8 = r7 * 1.5d;
    L6:
        this.d = r8 + 1.0d;
        if (r12 < 0.0f) goto L9;
        double r13 = ((double) r12) * 1.5d;
    L10:
        this.e = r13 + 1.0d;
        return;
    L9:
        r13 = ((double) r12) * 0.6d;
        goto L10
    L5:
        r8 = r7 * 0.6d;
        goto L6
    }

    public /* synthetic */ a(int r2, float r3, float r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0.0f;
    L11:
        this(r2, r3, r4);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r13) {
        double r3 = r13;
        if (this.f14686a == 0) goto L6;
        r3 = 1.0d - r3;
    L6:
        double r4 = RangesKt.coerceIn(r3, 0.0d, 1.0d);
        float r14 = this.f14687b;
        boolean r6 = true;
        if (r14 != 0.0f) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L19;
        if (this.c != 0.0f) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L19;
        return (float) r4;
    L14:
        r7 = false;
    L19:
        if (r14 != 0.0f) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == true) goto L24;
        double r8 = ((Math.pow(r4, this.d) - r4) * (1.0d - r4)) + r4;
    L26:
        if (this.c == 0.0f) goto L29;
        r6 = false;
    L29:
        if (r6 == true) goto L32;
        r8 = r8 + (((1.0d - Math.pow(1.0d - r4, this.e)) - r8) * r4);
    L32:
        return (float) r8;
    L24:
        r8 = r4;
        goto L26
    L21:
        r15 = false;
        goto L22
    L9:
        r5 = false;
        goto L10
    }
}
