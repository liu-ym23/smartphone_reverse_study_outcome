package w38;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class b<T> {

    public static final class a<T> extends b<T> {
        public final C0134b a;
        public final T b;

        public a() {
            throw null;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            T r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.a + ", body=" + this.b + ')';
        }

        @Override // w38.b
        public final c a() {
            return this.a;
        }

        public a(C0134b r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
            this.b = null;
        }

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    /* JADX INFO: renamed from: w38.b$b, reason: collision with other inner class name */
    public static final class C0134b implements c {
        public final int a;
        public final String b;
        public final Throwable c;
        public final Map<String, String> d;

        public C0134b() {
            throw null;
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
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Map<String, String> r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "FlowError(code=" + this.a + ", tips=" + this.b + ", exception=" + this.c + ", ext=" + this.d + ')';
        }

        @Override // w38.b.c
        public final int getCode() {
            return this.a;
        }

        @Override // w38.b.c
        public final Throwable getException() {
            return this.c;
        }

        @Override // w38.b.c
        public final String getTips() {
            return this.b;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0134b) == true) goto L8;
            return false;
        L8:
            C0134b r6 = (C0134b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public C0134b(int r3, String r4, Throwable r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = null;
        L8:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = null;
        }
    }

    public interface c {
        int getCode();

        Throwable getException();

        String getTips();
    }

    public static final class d<T> extends b<T> {
        public final T a;
        public final c b;

        public d() {
            throw null;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(body=" + this.a + ", error=" + this.b + ')';
        }

        @Override // w38.b
        public final c a() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object r6) {
            C0134b r0 = new C0134b(0, "OK", null, 12);
            Intrinsics.checkNotNullParameter(r0, "error");
            this.a = r6;
            this.b = r0;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public b() {
    }

    public abstract c a();
}
