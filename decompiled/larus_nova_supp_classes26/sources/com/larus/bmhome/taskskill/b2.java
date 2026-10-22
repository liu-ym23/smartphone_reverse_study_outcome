package com.larus.bmhome.taskskill;

import android.graphics.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b2 {
    public static final b a = null;
    public static final b b = null;
    public static final List<a> c = null;

    public static final class a {
        public final String a;
        public final b b;
        public final b c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ColorGroup(characters=" + this.a + ", light=" + this.b + ", dark=" + this.c + ')';
        }

        public a(String r2, b r3, b r4) {
            Intrinsics.checkNotNullParameter(r2, "characters");
            Intrinsics.checkNotNullParameter(r3, "light");
            Intrinsics.checkNotNullParameter(r4, "dark");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

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
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "Colors(icon=" + this.a + ", backgroundCenter=" + this.b + ", backgroundEdge=" + this.c + ", border=" + this.d + ')';
        }

        public b(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public b2() {
    }

    static {
        b2 r7 = new b2();
        a = a(r7, Color.rgb(77, 124, 255), Color.rgb(0, 68, 255), 0, 0.05f, 0.1f, 4);
        b = a(r7, Color.rgb(57, 115, 229), Color.rgb(51, 119, 255), 0, 0.11f, 0.1f, 4);
        c = CollectionsKt.listOf(new a[]{new a("024GOT", a(r7, Color.rgb(59, 178, 196), Color.rgb(92, 211, 229), 0, 0.1f, 0.0f, 20), a(r7, Color.rgb(59, 178, 196), Color.rgb(40, 226, 255), 0, 0.07f, 0.0f, 20)), new a("8EIJUY", a(r7, Color.rgb(77, 121, 255), Color.rgb(0, 64, 255), 0, 0.05f, 0.0f, 20), a(r7, Color.rgb(77, 121, 255), Color.rgb(51, 119, 255), Color.rgb(51, 102, 255), 0.11f, 0.0f, 16)), new a("1DFHMW", a(r7, Color.rgb(146, 104, 242), Color.rgb(145, 104, 242), 0, 0.08f, 0.0f, 20), a(r7, Color.rgb(146, 104, 242), Color.rgb(145, 104, 242), 0, 0.1f, 0.0f, 20)), new a("3BCLSV", a(r7, Color.rgb(64, 161, 40), Color.rgb(66, 166, 41), 0, 0.08f, 0.0f, 20), a(r7, Color.rgb(64, 161, 40), Color.rgb(41, 166, 124), 0, 0.07f, 0.0f, 20)), new a("67AKPQ", a(r7, Color.rgb(229, 160, 23), Color.rgb(229, 160, 23), 0, 0.09f, 0.12f, 4), a(r7, Color.rgb(229, 160, 23), Color.rgb(229, 160, 23), 0, 0.09f, 0.12f, 4)), new a("59NRXZ", a(r7, Color.rgb(247, 100, 86), Color.rgb(247, 100, 86), 0, 0.07f, 0.09f, 4), a(r7, Color.rgb(247, 100, 86), Color.rgb(247, 100, 86), 0, 0.07f, 0.09f, 4))});
    }

    public static b b(String r6, boolean r7) {
        b r0 = null;
        if (r6 == null) goto L20;
        Character r8 = StringsKt.lastOrNull(r6);
        if (r8 == null) goto L20;
        char r9 = Character.toUpperCase(r8.charValue());
        Iterator<T> r1 = c.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (StringsKt.contains$default(((a) r2).a, r9, false, 2, null) == false) goto L8;
    L13:
        a r3 = (a) r2;
        if (r3 == null) goto L20;
        if (r7 == false) goto L18;
        b r10 = r3.c;
    L19:
        r0 = r10;
        goto L20
    L18:
        r10 = r3.b;
        goto L19
    L12:
        r2 = null;
    L20:
        if (r0 != null) goto L28;
        if (r7 == false) goto L24;
        return b;
    L24:
        return a;
    L28:
        return r0;
    }

    public static int c(int r2, float r3) {
        return Color.argb(MathKt.roundToInt(r3 * 255), Color.red(r2), Color.green(r2), Color.blue(r2));
    }

    public static b a(b2 r0, int r1, int r2, int r3, float r4, float r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r3 = r2;
    L6:
        if ((r6 & 16) == 0) goto L9;
        r5 = 0.08f;
    L9:
        return new b(r1, c(r2, 0.0f), c(r3, r4), c(r1, r5));
    }
}
