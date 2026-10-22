package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a0 {

    public static final class a extends a0 {
        public final int a;
        public final Bitmap b;
        public final long c;

        public a() {
            this(0, null, 7);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            Bitmap r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            long r4 = this.c;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "QueryAnswering(type=" + this.a + ", data=" + this.b + ", ts=" + this.c + ')';
        }

        public final int getType() {
            return this.a;
        }

        public a(int r3, Bitmap r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            long r0 = System.currentTimeMillis();
        L12:
            this.a = r3;
            this.b = r4;
            this.c = r0;
            return;
        L11:
            r0 = 0;
            goto L12
        }
    }

    public static final class b extends a0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a0 {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a0 {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a0 {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public a0() {
    }
}
