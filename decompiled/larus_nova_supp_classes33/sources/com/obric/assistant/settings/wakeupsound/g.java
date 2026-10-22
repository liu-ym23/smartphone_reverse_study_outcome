package com.obric.assistant.settings.wakeupsound;

import com.obric.assistant.WakeupSoundEffectSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final int e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == true) goto L11;
        r2 = 1237;
    L11:
        return ((r3 + r2) * 31) + this.e;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "WakeupSoundEffectItemUiModel(value=" + this.a + ", title=" + this.b + ", selected=" + this.c + ", playing=" + this.d + ", cardPosition=" + this.e + ')';
    }

    public g(@WakeupSoundEffectSettings String r2, String r3, boolean r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
