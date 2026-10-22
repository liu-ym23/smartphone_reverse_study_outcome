package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a {
    public final e49.a a;
    public final boolean b;

    /* JADX INFO: renamed from: d49.a$a, reason: collision with other inner class name */
    public static final class C0124a extends a {
        public static final C0124a c = null;

        static {
            c = new C0124a();
        }

        public C0124a() {
            super(null, true);
        }
    }

    public static final class b extends a {
        public final d49.b c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((b) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessAlreadyLatest(device=" + this.c + ')';
        }

        public b(d49.b r3) {
            Intrinsics.checkNotNullParameter(r3, "device");
            super(null, true);
            this.c = r3;
        }
    }

    public static final class c extends a {
        public final e49.a c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((c) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessWithNewVersion(responseWrapper=" + this.c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public c(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, true);
            this.c = r2;
        }
    }

    public static final class d extends a {
        public static final d c = null;

        static {
            c = new d();
        }

        public d() {
            super(null, true);
        }
    }

    public static final class e extends a {
        public final e49.a c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((e) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "CheckingBeforeDataTransfer(responseWrapper=" + this.c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public e(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
        }
    }

    public static final class f extends a {
        public final e49.a c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((f) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "CheckingBeforeDownload(responseWrapper=" + this.c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public f(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
        }
    }

    public static final class g extends a {
        public final e49.a c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof g) == true) goto L8;
            return false;
        L8:
            g r9 = (g) r8;
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r9.d) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.c.hashCode() * 31;
            long r1 = this.d;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "DataTransferSuccess(responseWrapper=" + this.c + ", dataTransferId=" + this.d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public g(e49.a r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class h extends a {
        public final e49.a c;
        public final long d;
        public final int e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof h) == true) goto L8;
            return false;
        L8:
            h r9 = (h) r8;
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r9.d) goto L15;
            return false;
        L15:
            if (this.e == r9.e) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.c.hashCode() * 31;
            long r1 = this.d;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e;
        }

        public final String toString() {
            return "DataTransferring(responseWrapper=" + this.c + ", dataTransferId=" + this.d + ", dataTransferProgress=" + this.e + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public h(e49.a r2, long r3, int r5) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
            this.d = r3;
            this.e = r5;
        }
    }

    public static final class i extends a {
        public final e49.a c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.c.hashCode() * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "DownloadFailed(responseWrapper=" + this.c + ", downloadFailedReason=" + this.d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public i(e49.a r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            Intrinsics.checkNotNullParameter(r3, "downloadFailedReason");
            super(r2, true);
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class j extends a {
        public final e49.a c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((j) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "DownloadSuccess(responseWrapper=" + this.c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public j(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, true);
            this.c = r2;
        }
    }

    public static final class k extends a {
        public final e49.a c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof k) == true) goto L8;
            return false;
        L8:
            k r6 = (k) r5;
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r6.d) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.c.hashCode() * 31) + this.d;
        }

        public final String toString() {
            return "Downloading(responseWrapper=" + this.c + ", downloadProgress=" + this.d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public k(e49.a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class l extends a {
        public static final l c = null;

        static {
            c = new l();
        }

        public l() {
            super(null, true);
        }
    }

    public static final class m extends a {
        public final e49.a c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof m) == true) goto L8;
            return false;
        L8:
            m r6 = (m) r5;
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.c.hashCode() * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "OTAFailed(responseWrapper=" + this.c + ", failReason=" + this.d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public m(e49.a r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            Intrinsics.checkNotNullParameter(r3, "failReason");
            super(r2, true);
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class n extends a {
        public final d49.b c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof n) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((n) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "OTASuccess(device=" + this.c + ')';
        }

        public n(d49.b r3) {
            Intrinsics.checkNotNullParameter(r3, "device");
            super(null, true);
            this.c = r3;
        }
    }

    public static final class o extends a {
        public final e49.a c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof o) == true) goto L8;
            return false;
        L8:
            o r6 = (o) r5;
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r6.d) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.c.hashCode() * 31) + this.d;
        }

        public final String toString() {
            return "PeripheralInstalling(responseWrapper=" + this.c + ", peripheralInstallProgress=" + this.d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public o(e49.a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class p extends a {
        public final e49.a c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof p) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((p) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "PeripheralRestarting(responseWrapper=" + this.c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.c;
        }

        public p(e49.a r2) {
            Intrinsics.checkNotNullParameter(r2, "responseWrapper");
            super(r2, false);
            this.c = r2;
        }
    }

    public e49.a a() {
        return this.a;
    }

    public a(e49.a r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
