package com.larus.camera.impl.ui.component.result.general;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class n {

    public static final class a extends n {
        public final ix8.d a;

        public a() {
            this(null);
        }

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
            ix8.d r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        @Override // com.larus.camera.impl.ui.component.result.general.n
        public final String toString() {
            return "Completed(detectResult=" + this.a + ')';
        }

        public a(ix8.d r1) {
            this.a = r1;
        }
    }

    public static final class b extends n {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends n {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public n() {
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
