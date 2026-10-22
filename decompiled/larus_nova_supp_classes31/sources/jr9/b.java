package jr9;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final Map<String, Integer> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r2 = 1231;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.h == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareItemUIConfig(iconId=" + this.a + ", rectangleIconId=" + this.b + ", textId=" + this.c + ", textStr=" + this.d + ", shareTypeTextMap=" + this.e + ", enableStatus=" + this.f + ", autoDismissDialog=" + this.g + ", isLoadingState=" + this.h + ')';
    }

    public static b a(b r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        int r3 = r11.a;
    L7:
        if ((r14 & 2) == 0) goto L9;
        int r4 = r11.b;
    L11:
        if ((r14 & 4) == 0) goto L13;
        int r5 = r11.c;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r6 = r11.d;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Map<String, Integer> r7 = r11.e;
    L23:
        if ((r14 & 32) == 0) goto L25;
        r12 = r11.f;
    L25:
        boolean r8 = r12;
        if ((r14 & 64) == 0) goto L28;
        boolean r9 = r11.g;
    L30:
        if ((r14 & 128) == 0) goto L32;
        r13 = r11.h;
    L32:
        Intrinsics.checkNotNullParameter(r6, "textStr");
        Intrinsics.checkNotNullParameter(r7, "shareTypeTextMap");
        return new b(r3, r4, r5, r6, r7, r8, r9, r13);
    L28:
        r9 = false;
        goto L30
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = 0;
        goto L15
    L9:
        r4 = 0;
        goto L11
    L5:
        r3 = 0;
        goto L7
    }

    public /* synthetic */ b(int r12, int r13, int r14, Map r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r16 & 4) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r16 & 8) == 0) goto L13;
        String r0 = "";
    L14:
        String r6 = r0;
        if ((r16 & 16) == 0) goto L17;
        Map r7 = new HashMap();
    L19:
        if ((r16 & 32) == 0) goto L21;
        boolean r8 = true;
    L23:
        if ((r16 & 64) == 0) goto L25;
        boolean r9 = true;
    L26:
        this(r12, r4, r5, r6, r7, r8, r9, false);
        return;
    L25:
        r9 = false;
        goto L26
    L21:
        r8 = false;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r0 = null;
        goto L14
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public b(int r2, int r3, int r4, String r5, Map<String, Integer> r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "textStr");
        Intrinsics.checkNotNullParameter(r6, "shareTypeTextMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
