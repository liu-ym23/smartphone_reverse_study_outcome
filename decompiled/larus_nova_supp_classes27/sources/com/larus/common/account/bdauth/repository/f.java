package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class f {

    public static final class a extends f {
        public final com.larus.common.account.bdauth.repository.d a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "BlockingError(error=" + this.a + ')';
        }

        public a(com.larus.common.account.bdauth.repository.d r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
        }
    }

    public static final class b extends f {
        public final fb7.d a;

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
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failure(response=" + this.a + ')';
        }

        public b(fb7.d r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    public static final class c extends f {
        public static final c a = null;

        static {
            a = new c();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return 1731732198;
        }

        public final String toString() {
            return "NeedLogin";
        }

        public c() {
        }
    }

    public static final class d extends f {
        public final e a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.a + ')';
        }

        public d(e r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public f() {
    }
}
