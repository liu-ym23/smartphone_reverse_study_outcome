package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class o0 {

    public static final class a extends o0 {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Completed(roundToken=" + this.a + ", text=" + this.b + ')';
        }

        public a(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "text");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class b extends o0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends o0 {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Loading(roundToken=" + this.a + ", placeholderText=" + this.b + ')';
        }

        public c(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "placeholderText");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class d extends o0 {
        public final long a;
        public final String b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L8;
            return false;
        L8:
            d r9 = (d) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Typing(roundToken=" + this.a + ", fullText=" + this.b + ", displayedText=" + this.c + ')';
        }

        public d(long r2, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "fullText");
            Intrinsics.checkNotNullParameter(r5, "displayedText");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public o0() {
    }
}
