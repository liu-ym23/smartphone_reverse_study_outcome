package com.larksuite.component.card.component.text;

import com.lynx.tasm.behavior.shadow.MeasureMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final a a;
    public final MeasureMode b;
    public final MeasureMode c;
    public final float d;
    public final float e;

    public static final class a {
        public final CharSequence a;
        public final d b;

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof a) == true) goto L5;
            return false;
        L5:
            a r5 = (a) r4;
            if (Intrinsics.areEqual(this.a, r5.a) == true) goto L9;
            return false;
        L9:
            return Intrinsics.areEqual(this.b, r5.b);
        }

        public a(CharSequence r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r3, "attributes");
            this.a = r2;
            this.b = r3;
        }
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.a.a);
        r0.append(' ');
        r0.append(this.d);
        r0.append(' ');
        r0.append(this.e);
        return r0.toString();
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof b) == true) goto L5;
        return false;
    L5:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.d != r6.d) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == true) goto L17;
        return false;
    L17:
        if (this.e != r6.e) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L27;
        return true;
    L27:
        return false;
    L19:
        r7 = false;
        goto L20
    L14:
        r0 = false;
        goto L15
    }

    public b(CharSequence r2, d r3, MeasureMode r4, MeasureMode r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Intrinsics.checkNotNullParameter(r4, "widthMode");
        Intrinsics.checkNotNullParameter(r5, "heightMode");
        this.a = new a(r2, r3);
        this.d = r6;
        this.e = r7;
        this.b = r4;
        this.c = r5;
    }
}
