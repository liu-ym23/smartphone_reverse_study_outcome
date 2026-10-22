package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface i5 {

    public static final class a implements i5 {
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
            return -428676707;
        }

        public final String toString() {
            return "Buffer";
        }
    }

    public static final class b implements i5 {
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
            return -362399860;
        }

        public final String toString() {
            return "Drop";
        }
    }

    public static final class c implements i5 {
        private final t4 owner;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.owner, ((c) r4).owner) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.owner.hashCode();
        }

        public final String toString() {
            return "Route(owner=" + this.owner + ')';
        }

        public final t4 a() {
            return this.owner;
        }

        public c(t4 r2) {
            Intrinsics.checkNotNullParameter(r2, "owner");
            this.owner = r2;
        }
    }
}
