package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11647c;
    public final MviLogLevel d;

    public a0(float r5, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "desc");
        this.f11645a = r5;
        this.f11646b = r10;
        this.f11647c = r11;
        this.d = MviLogLevel.VERBOSE;
    }

    @Override // com.obric.flow.cardlistpage.ui.component.overlayanimator.c0, com.obric.flow.cardlistpage.mvi.j
    public final MviLogLevel b() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r10 = (a0) r5;
        float r11 = r10.f11645a;
        if (Float.compare(this.f11645a, r11) == 0) goto L12;
        return false;
    L12:
        if (this.f11646b == r10.f11646b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11647c, r10.f11647c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.d(Float.hashCode(this.f11645a) * 31, 31, this.f11646b);
        return this.f11647c.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("UpdateTranslation(progress=");
        r5.append(this.f11645a);
        r5.append(", rtl=");
        r5.append(this.f11646b);
        r5.append(", desc=");
        return ai.j0.q(r5, this.f11647c, ")");
    }
}
