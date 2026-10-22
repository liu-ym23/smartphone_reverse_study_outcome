package h68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: h68.a$a, reason: collision with other inner class name */
    public static final class C0110a extends a {
        public final int a;
        public final String b;
        public final Throwable c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0110a) == true) goto L8;
            return false;
        L8:
            C0110a r6 = (C0110a) r5;
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
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Throwable r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(errorCode=" + this.a + ", errorMsg=" + this.b + ", throwable=" + this.c + ')';
        }

        public C0110a(int r1, String r2, Throwable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends a {
        public final Integer a;

        public b() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(readSize=" + this.a + ')';
        }

        public b(Integer r1) {
            this.a = r1;
        }
    }

    public a() {
    }
}
