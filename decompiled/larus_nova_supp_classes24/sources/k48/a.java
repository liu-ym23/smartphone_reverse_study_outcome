package k48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: k48.a$a, reason: collision with other inner class name */
    public static final class C0113a extends a {
        public final String a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0113a) == true) goto L8;
            return false;
        L8:
            C0113a r6 = (C0113a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "Fail(reason=" + this.a + ", httpCode=" + this.b + ')';
        }

        public C0113a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends a {
        public final String a;
        public final int b;
        public final String c;
        public final boolean d;
        public final int e;

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
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.e;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Html(finalUrl=" + this.a + ", redirectCount=" + this.b + ", html=" + this.c + ", limitReached=" + this.d + ", httpCode=" + this.e + ')';
        }

        public b(String r2, int r3, String r4, boolean r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "finalUrl");
            Intrinsics.checkNotNullParameter(r4, "html");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public a() {
    }
}
