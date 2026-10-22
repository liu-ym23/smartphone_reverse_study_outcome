package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface z2 {

    public static final class a implements z2 {
        public final DoraObricGlassesMode a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ExternalModeChanged(mode=" + this.a + ')';
        }

        public a(DoraObricGlassesMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            this.a = r2;
        }
    }

    public static final class b implements z2 {
        public final DoraObricGlassesMode a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SelectMode(mode=" + this.a + ')';
        }

        public b(DoraObricGlassesMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            this.a = r2;
        }
    }

    public static final class c implements z2 {
        public static final c a = null;

        static {
            a = new c();
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
            return 1586022282;
        }

        public final String toString() {
            return "Shutdown";
        }
    }
}
