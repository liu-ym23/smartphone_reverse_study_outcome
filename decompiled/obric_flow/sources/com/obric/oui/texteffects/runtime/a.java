package com.obric.oui.texteffects.runtime;

import android.view.View;
import js.g;
import js.h;
import js.i;
import js.j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f14739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f14740c;
    public final int d;
    public final float e;

    public a(String r5, View r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r5, "bindingKey");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "textWidthProvider");
        this.f14738a = r5;
        this.f14739b = r10;
        this.f14740c = r11;
        this.d = 4;
        this.e = r10.getResources().getDisplayMetrics().density;
    }

    public final float a(f8.b r5, float r10) {
        if ((r5 instanceof h) == false) goto L6;
        return ((h) r5).f18466a;
    L6:
        if ((r5 instanceof g) == false) goto L9;
        float r11 = ((g) r5).f18465a;
        return this.e * r11;
    L9:
        if ((r5 instanceof j) == false) goto L12;
        return RangesKt.coerceAtLeast(((Number) this.f14740c.invoke()).floatValue(), 0.0f) * ((j) r5).f18470a;
    L12:
        if ((r5 instanceof i) == false) goto L16;
        i r12 = (i) r5;
        float r13 = a(r12.f18467a, r10);
        float r14 = a(r12.f18468b, r10) - r13;
        return (RangesKt.coerceIn(r12.f18469c, 0.0f, 1.0f) * r14) + r13;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
