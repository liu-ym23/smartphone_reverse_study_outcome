package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface k4$c {

    public static final class a implements k4$c {
        public static final a INSTANCE = null;

        static {
            INSTANCE = new a();
        }

        public a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return -1618202342;
        }

        public final String toString() {
            return "DirectoryUnavailable";
        }
    }

    public static final class b implements k4$c {
        public static final b INSTANCE = null;

        static {
            INSTANCE = new b();
        }

        public b() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
            return true;
        }

        public final int hashCode() {
            return -1926672212;
        }

        public final String toString() {
            return "InsufficientSpace";
        }
    }

    public static final class c implements k4$c {
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
            return 400707846;
        }

        public final String toString() {
            return "InvalidPackage";
        }
    }

    public static final class d implements k4$c {
        private final k4$b target;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.target, ((d) r4).target) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.target.hashCode();
        }

        public final String toString() {
            return "Ready(target=" + this.target + ')';
        }

        public final k4$b a() {
            return this.target;
        }

        public d(k4$b r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.target = r2;
        }
    }
}
