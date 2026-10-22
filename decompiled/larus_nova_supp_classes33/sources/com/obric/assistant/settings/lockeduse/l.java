package com.obric.assistant.settings.lockeduse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class l {

    public static final class a extends l {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "Hint(textRes=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b extends l {
        public final String a;
        public final int b;
        public final Integer c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            Integer r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            if (this.d == false) goto L9;
            int r4 = 1231;
        L11:
            return r3 + r4;
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Item(id=" + this.a + ", titleRes=" + this.b + ", subtitleRes=" + this.c + ", enabled=" + this.d + ')';
        }

        public b(String r2, int r3, Integer r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c extends l {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "SectionTitle(titleRes=" + this.a + ')';
        }

        public c() {
            this.a = 2131912536;
        }
    }

    public static final class d extends l {
        public final int a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final Integer e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L10;
            r2 = 1237;
        L10:
            int r4 = (r3 + r2) * 31;
            Integer r5 = this.e;
            if (r5 != null) goto L13;
            int r6 = 0;
        L15:
            return r4 + r6;
        L13:
            r6 = r5.hashCode();
            goto L15
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Switch(titleRes=" + this.a + ", subtitleRes=" + this.b + ", enabled=" + this.c + ", switchEnabled=" + this.d + ", disabledToastTextRes=" + this.e + ')';
        }

        public d(int r1, int r2, boolean r3, boolean r4, Integer r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public l() {
    }
}
