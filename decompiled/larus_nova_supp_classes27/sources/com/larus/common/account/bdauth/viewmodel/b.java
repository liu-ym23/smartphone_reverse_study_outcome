package com.larus.common.account.bdauth.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class b {

    public static final class a extends b {
        public final com.larus.common.account.bdauth.repository.a a;

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
            return "AccountClicked(account=" + this.a + ')';
        }

        public a(com.larus.common.account.bdauth.repository.a r2) {
            Intrinsics.checkNotNullParameter(r2, "account");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.b$b, reason: collision with other inner class name */
    public static final class C0007b extends b {
        public static final C0007b a = null;

        static {
            a = new C0007b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0007b) == true) goto L9;
            return false;
        L9:
            C0007b r4 = (C0007b) r3;
            return true;
        }

        public final int hashCode() {
            return 1917944179;
        }

        public final String toString() {
            return "NeedLogin";
        }

        public C0007b() {
        }
    }

    public static final class c extends b {
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
            return -917564618;
        }

        public final String toString() {
            return "OpenAddAccount";
        }

        public c() {
        }
    }

    public static final class d extends b {
        public final fb7.d a;

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
            return "SendCancel(response=" + this.a + ')';
        }

        public d(fb7.d r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    public static final class e extends b {
        public final fb7.d a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SendError(response=" + this.a + ')';
        }

        public e(fb7.d r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    public static final class f extends b {
        public final fb7.d a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SendSuccess(response=" + this.a + ')';
        }

        public f(fb7.d r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    public static final class g extends b {
        public final com.larus.common.account.bdauth.repository.b a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowAccountIssue(issue=" + this.a + ')';
        }

        public g(com.larus.common.account.bdauth.repository.b r2) {
            Intrinsics.checkNotNullParameter(r2, "issue");
            this.a = r2;
        }
    }

    public static final class h extends b {
        public final com.larus.common.account.bdauth.repository.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowAccountSuccess(account=" + this.a + ')';
        }

        public h(com.larus.common.account.bdauth.repository.a r2) {
            Intrinsics.checkNotNullParameter(r2, "account");
            this.a = r2;
        }
    }

    public static final class i extends b {
        public final com.larus.common.account.bdauth.repository.d a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowBlockingError(error=" + this.a + ')';
        }

        public i(com.larus.common.account.bdauth.repository.d r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
        }
    }

    public b() {
    }
}
