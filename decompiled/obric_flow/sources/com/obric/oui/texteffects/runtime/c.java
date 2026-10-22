package com.obric.oui.texteffects.runtime;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14753c;

    public c(long r5, long r10, ArrayList r11) {
        Intrinsics.checkNotNullParameter(r11, "layers");
        this.f14751a = r5;
        this.f14752b = r10;
        this.f14753c = r11;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        long r5 = r11.f14751a;
        if (this.f14751a == r5) goto L12;
        return false;
    L12:
        if (this.f14752b == r11.f14752b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f14753c, r11.f14753c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.e(Long.hashCode(this.f14751a) * 31, this.f14752b, 31);
        return this.f14753c.hashCode() + r5;
    }

    public final String toString() {
        return "TextEffectFrame(playTimeMs=" + this.f14751a + ", normalizedPlayTimeMs=" + this.f14752b + ", layers=" + this.f14753c + ')';
    }
}
