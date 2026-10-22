package fy8;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final boolean a;
    public final String b;
    public final String c;
    public final Pair<Integer, Integer> d;
    public final Function0<Boolean> e;
    public final int f;
    public final Map<String, String> g;

    public j() {
        this(null, null, 0, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
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
        return ((((r11 + r3) * 31) + this.f) * 31) + this.g.hashCode();
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
        return "EditorInitConfig(isNoImeWhenInit=" + this.a + ", customPrompt=" + this.b + ", hint=" + this.c + ", selection=" + this.d + ", onVoiceTouchBlockCallback=" + this.e + ", canvasType=" + this.f + ", traceMap=" + this.g + ')';
    }

    public j(String r4, String r5, int r6, Map r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r8 & 2) == 0) goto L10;
        r4 = null;
    L10:
        if ((r8 & 4) == 0) goto L13;
        r5 = null;
    L13:
        if ((r8 & 32) == 0) goto L16;
        r6 = -1;
    L16:
        if ((r8 & 64) == 0) goto L18;
        r7 = MapsKt.emptyMap();
    L18:
        Intrinsics.checkNotNullParameter(r7, "traceMap");
        this.a = r0;
        this.b = r4;
        this.c = r5;
        this.d = null;
        this.e = null;
        this.f = r6;
        this.g = r7;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
