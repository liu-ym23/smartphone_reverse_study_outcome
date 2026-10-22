package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface x4 {

    public static final class a implements x4 {
        private final e5 pkg;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.pkg, ((a) r4).pkg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.pkg.hashCode();
        }

        public final String toString() {
            return "Available(pkg=" + this.pkg + ')';
        }

        public final e5 a() {
            return this.pkg;
        }

        public a(e5 r2) {
            Intrinsics.checkNotNullParameter(r2, "pkg");
            this.pkg = r2;
        }
    }

    public static final class b implements x4 {
        private final FailureReason reason;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.reason == ((b) r4).reason) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.reason.hashCode();
        }

        public final String toString() {
            return "Failed(reason=" + this.reason + ')';
        }

        public final FailureReason a() {
            return this.reason;
        }

        public b(FailureReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.reason = r2;
        }
    }

    public static final class c implements x4 {
        public static final c INSTANCE = null;

        static {
            INSTANCE = new c();
        }

        public c() {
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
            return 637286237;
        }

        public final String toString() {
            return "NoUpdate";
        }
    }
}
