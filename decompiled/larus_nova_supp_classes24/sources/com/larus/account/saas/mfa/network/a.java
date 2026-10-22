package com.larus.account.saas.mfa.network;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.larus.account.saas.mfa.network.a$a, reason: collision with other inner class name */
    public static final class C0065a<T> extends a<T> {
        public final b a;
        public final T b;

        public C0065a() {
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

        public C0065a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
            this.b = null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0065a) == true) goto L8;
            return false;
        L8:
            C0065a r6 = (C0065a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public static final class b implements c {
        public final int a;
        public final String b;
        public final Throwable c;
        public final Map<String, String> d;

        public b() {
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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public b(int r1, String r2) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = null;
        }
    }

    public interface c {
    }

    public static final class d<T> extends a<T> {
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

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object r4) {
            b r0 = new b(0, "OK");
            Intrinsics.checkNotNullParameter(r0, "error");
            this.a = r4;
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

    public a() {
    }
}
