package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface h {

    public static final class a {
        public boolean a;
        public final List<ch0.e> b;
        public final ch0.e c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            List<ch0.e> r3 = this.b;
            int r4 = 0;
            if (r3 == null) goto L8;
            int r5 = r3.hashCode();
        L9:
            int r6 = (r2 + r5) * 31;
            ch0.e r7 = this.c;
            if (r7 == null) goto L13;
            r4 = r7.hashCode();
        L13:
            return r6 + r4;
        L8:
            r5 = 0;
            goto L9
        }

        public final String toString() {
            return "UpdateResult(hasModified=" + this.a + ", newMergeDataList=" + this.b + ", newSelfMergeData=" + this.c + ")";
        }

        public a(boolean r2, List<ch0.e> r3, ch0.e r4) {
            Intrinsics.checkNotNullParameter(r3, "newMergeDataList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    void attach();

    a b(List<ch0.e> r1);

    void detach();
}
