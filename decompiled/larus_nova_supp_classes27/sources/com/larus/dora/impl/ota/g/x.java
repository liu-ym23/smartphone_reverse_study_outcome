package com.larus.dora.impl.ota.g;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface x {

    public static final class a implements x {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements x {
        public final d49.b a;

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
            return "CheckUpdateSuccessAlreadyLatest(device=" + this.a + ')';
        }

        public b(d49.b r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class c implements x {
        public final e49.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessWithNewVersion(responseWrapper=" + this.a + ')';
        }

        public c(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
        }
    }

    public static final class d implements x {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e implements x {
        public final e49.a a;

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
            return "CheckingEnvironment(responseWrapper=" + this.a + ')';
        }

        public e(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
        }
    }

    public static final class f implements x {
        public final e49.a a;

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
            return "DataTransferFailed(responseWrapper=" + this.a + ')';
        }

        public f(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
        }
    }

    public static final class g implements x {
        public final e49.a a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
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
            return "DataTransferring(responseWrapper=" + this.a + ", progress=" + this.b + ')';
        }

        public g(e49.a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class h implements x {
        public final e49.a a;

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
            return "DeviceRestarting(responseWrapper=" + this.a + ')';
        }

        public h(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
        }
    }

    public static final class i implements x {
        public final e49.a a;

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
            return "DownloadFailed(responseWrapper=" + this.a + ')';
        }

        public i(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
        }
    }

    public static final class j implements x {
        public final e49.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((j) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "DownloadSuccess(responseWrapper=" + this.a + ')';
        }

        public j(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
        }
    }

    public static final class k implements x {
        public final e49.a a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof k) == true) goto L8;
            return false;
        L8:
            k r6 = (k) r5;
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
            return "Downloading(responseWrapper=" + this.a + ", progress=" + this.b + ')';
        }

        public k(e49.a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class l implements x {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }
    }

    public static final class m implements x {
        public final d49.b a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((m) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OTASuccess(device=" + this.a + ')';
        }

        public m(d49.b r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }
}
