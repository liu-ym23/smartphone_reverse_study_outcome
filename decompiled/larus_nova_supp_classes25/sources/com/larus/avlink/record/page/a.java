package com.larus.avlink.record.page;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.larus.avlink.record.page.a$a, reason: collision with other inner class name */
    public static final class C0022a extends a {
        public final String a;
        public final Exception b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0022a) == true) goto L8;
            return false;
        L8:
            C0022a r6 = (C0022a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Exception r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(message=" + this.a + ", error=" + this.b + ')';
        }

        public C0022a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
            this.b = null;
        }
    }

    public static final class b<T> extends a<T> {
        public final T a;

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
            T r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.a + ')';
        }

        public b(T r1) {
            this.a = r1;
        }
    }

    public a() {
    }
}
