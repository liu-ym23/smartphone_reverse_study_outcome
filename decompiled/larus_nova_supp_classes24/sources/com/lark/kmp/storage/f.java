package com.lark.kmp.storage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class f {

    public static final class a extends f {
        public final String a;

        public a() {
            this(0);
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
            return this.a.hashCode();
        }

        public final String toString() {
            return "GlobalSpace(spaceName=" + this.a + ')';
        }

        public a(int r2) {
            Intrinsics.checkNotNullParameter("lark", "spaceName");
            SpaceScope r3 = SpaceScope.Global;
            super("lark");
            this.a = "lark";
        }
    }

    public static final class b extends f {
        public final String a;

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
            return "UserSpace(spaceName=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "spaceName");
            SpaceScope r0 = SpaceScope.Global;
            super(r2);
            this.a = r2;
        }
    }

    public f(String r1) {
    }
}
