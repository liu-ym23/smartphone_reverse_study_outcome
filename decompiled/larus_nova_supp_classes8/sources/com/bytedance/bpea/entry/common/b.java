package com.bytedance.bpea.entry.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {

    public static final class a {
        public final int a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "ApiControlResult(resultCode=" + this.a + ", msg=" + this.b + ")";
        }

        public final boolean a() {
            if (this.a == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public a(String r2) {
            this.a = 0;
            this.b = r2;
        }
    }

    a a();

    a b();

    void c();
}
