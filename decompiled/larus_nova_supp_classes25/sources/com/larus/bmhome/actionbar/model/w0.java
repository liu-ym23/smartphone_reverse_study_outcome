package com.larus.bmhome.actionbar.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class w0 {

    public static final class a extends w0 {
        public final wa8.d1 a;

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
            return "Available(capability=" + this.a + ')';
        }

        public a(wa8.d1 r2) {
            Intrinsics.checkNotNullParameter(r2, "capability");
            this.a = r2;
        }
    }

    public static final class b extends w0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public w0() {
    }
}
