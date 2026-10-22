package yvb;

import com.ss.android.lark.widget.span.PrefixSpan;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final d f = null;
    public final float a;
    public final Integer b;
    public final Integer c;
    public final Map<Integer, b> d;
    public final boolean e;

    public static final class a {
    }

    public static final class b {
        public final PrefixSpan.Type a;
        public final Float b;
        public final Integer c;

        public b() {
            this(null, null, 7);
        }

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            PrefixSpan.Type r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Float r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "LevelStyle(iconType=" + this.a + ", iconSizeDp=" + this.b + ", color=" + this.c + ')';
        }

        public b(PrefixSpan.Type r3, Float r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            this.a = r3;
            this.b = r4;
            this.c = null;
        }
    }

    public d() {
        this(0.0f, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = Float.floatToIntBits(this.a) * 31;
        Integer r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((r4 + r2) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L13;
        int r7 = 1231;
    L15:
        return r6 + r7;
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMarkDownStyle(textSizeSp=" + this.a + ", unorderedListColor=" + this.b + ", orderedListColor=" + this.c + ", levelStyles=" + this.d + ", needAnotherLine=" + this.e + ')';
    }

    static {
        PrefixSpan.Type r6 = PrefixSpan.Type.FILL_CIRCLE;
        Float r7 = Float.valueOf(5.0f);
        f = new d(17.0f, MapsKt.mapOf(new Pair[]{TuplesKt.to(1, new b(r6, r7, 4)), TuplesKt.to(2, new b(PrefixSpan.Type.HOLLOW_CIRCLE, r7, 4)), TuplesKt.to(3, new b(PrefixSpan.Type.FILL_RECT, r7, 4)), TuplesKt.to(4, new b(PrefixSpan.Type.HOLLOW_RECT, r7, 4))}), 22);
    }

    public d(float r2, Map r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 16.0f;
    L6:
        if ((r4 & 8) == 0) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        Intrinsics.checkNotNullParameter(r3, "levelStyles");
        this.a = r2;
        this.b = null;
        this.c = null;
        this.d = r3;
        this.e = false;
    }
}
