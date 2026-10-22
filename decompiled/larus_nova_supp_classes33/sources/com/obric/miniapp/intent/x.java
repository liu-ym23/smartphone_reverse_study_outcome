package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x {
    public static final x a = null;

    public static final class a {
        public static final /* synthetic */ int d = 0;
        public final boolean a;
        public final String b;
        public final String c;

        /* JADX INFO: renamed from: com.obric.miniapp.intent.x$a$a, reason: collision with other inner class name */
        public static final class C0047a {
            public static a a(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "errorCode");
                Intrinsics.checkNotNullParameter(r3, "errorMessage");
                return new a(false, r2, r3);
            }
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "Result(success=" + this.a + ", errorCode=" + this.b + ", errorMessage=" + this.c + ')';
        }

        public final String a() {
            return this.c;
        }

        public a(boolean r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "errorCode");
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = new x();
    }

    public x() {
    }
}
