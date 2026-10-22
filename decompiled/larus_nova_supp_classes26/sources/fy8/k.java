package fy8;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final boolean a;
    public final String b;
    public final String c;
    public final Pair<Integer, Integer> d;
    public final Function0<Boolean> e;
    public final Map<String, String> f;

    public k() {
        this(true, null, null, null, null, MapsKt.emptyMap());
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        Pair<Integer, Integer> r9 = this.d;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Function0<Boolean> r12 = this.e;
        if (r12 == null) goto L23;
        r3 = r12.hashCode();
    L23:
        return ((r11 + r3) * 31) + this.f.hashCode();
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputInitConfig(isNoImeWhenInit=" + this.a + ", customPrompt=" + this.b + ", hint=" + this.c + ", selection=" + this.d + ", onVoiceTouchBlockCallback=" + this.e + ", traceMap=" + this.f + ')';
    }

    public k(boolean r2, String r3, String r4, Pair<Integer, Integer> r5, Function0<Boolean> r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r7, "traceMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
