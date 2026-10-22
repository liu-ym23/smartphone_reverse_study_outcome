package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface j extends dy0.c {

    public static final class a {
        public final boolean a;
        public final boolean b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            if (r4 == true) goto L10;
            r1 = r4;
        L10:
            return ((r3 + r1) * 31) + this.c;
        }

        public final String toString() {
            return "BannerState(isVisible=" + this.a + ", isInRegionB=" + this.b + ", width=" + this.c + ")";
        }

        public a(boolean r1, boolean r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    Observable<a> l5(long r1);
}
