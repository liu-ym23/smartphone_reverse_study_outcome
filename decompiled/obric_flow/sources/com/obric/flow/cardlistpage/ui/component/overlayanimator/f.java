package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11660c;
    public final MviLogLevel d;

    public f(float r5, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "desc");
        this.f11658a = r5;
        this.f11659b = r10;
        this.f11660c = r11;
        this.d = MviLogLevel.VERBOSE;
    }

    @Override // com.obric.flow.cardlistpage.ui.component.overlayanimator.g, com.obric.flow.cardlistpage.mvi.e
    public final MviLogLevel b() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        float r11 = r10.f11658a;
        if (Float.compare(this.f11658a, r11) == 0) goto L12;
        return false;
    L12:
        if (this.f11659b == r10.f11659b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11660c, r10.f11660c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.d(Float.hashCode(this.f11658a) * 31, 31, this.f11659b);
        return this.f11660c.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("UpdateTranslation(progress=");
        r5.append(this.f11658a);
        r5.append(", rtl=");
        r5.append(this.f11659b);
        r5.append(", desc=");
        return ai.j0.q(r5, this.f11660c, ")");
    }
}
