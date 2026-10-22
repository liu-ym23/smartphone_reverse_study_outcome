package com.ss.android.lark.coremd.base.parse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    public static final C0177a a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.base.parse.a$a, reason: collision with other inner class name */
    public static final class C0177a implements a {
        public static final /* synthetic */ C0177a b = null;

        static {
            b = new C0177a();
        }

        public C0177a() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.a
        public final b a(com.ss.android.lark.coremd.impl.parse.i r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new b(r3, r4);
        }
    }

    public static final class b {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "ImageSize(width=" + this.a + ", height=" + this.b + ')';
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = C0177a.b;
    }

    b a(com.ss.android.lark.coremd.impl.parse.i r1, int r2, int r3);
}
