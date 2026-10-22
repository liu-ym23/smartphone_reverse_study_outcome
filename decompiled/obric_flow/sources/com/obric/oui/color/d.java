package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlendMode f12425c;

    public d(float r5, int r10, BlendMode r11) {
        Intrinsics.checkNotNullParameter(r11, "blendMode");
        this.f12423a = r5;
        this.f12424b = r10;
        this.f12425c = r11;
    }

    public final d a() {
        return new d(this.f12423a, this.f12424b, this.f12425c);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f12423a), Float.valueOf(r10.f12423a)) == true) goto L12;
        return false;
    L12:
        if (this.f12424b == r10.f12424b) goto L15;
        return false;
    L15:
        if (this.f12425c == r10.f12425c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f12423a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f12424b, r5, 31);
        return this.f12425c.hashCode() + r10;
    }

    public final String toString() {
        return "StrokeConfig(width=" + this.f12423a + ", color=" + this.f12424b + ", blendMode=" + this.f12425c + ')';
    }
}
