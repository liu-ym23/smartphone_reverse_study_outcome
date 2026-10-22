package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a() {
            this(0, 0, 0, 0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "SeiBaseInfo(version=" + this.a + ", uiLayout=" + this.b + ", style=" + this.c + ", subUILayout=" + this.d + ")";
        }

        public a(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b$b, reason: collision with other inner class name */
    public static final class C0054b {
        public final SeiAppData a;
        public final SeiAppData b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0054b) == false) goto L14;
            C0054b r4 = (C0054b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public final int hashCode() {
            SeiAppData r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            SeiAppData r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            boolean r6 = this.c;
            ?? r7 = 1;
            ?? r8 = r6;
            if (r6 == false) goto L12;
            r8 = 1;
        L12:
            int r9 = (r5 + r8) * 31;
            boolean r10 = this.d;
            if (r10 == true) goto L17;
            r7 = r10;
        L17:
            return r9 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SeiDataCompareResult(oldData=" + this.a + ", newData=" + this.b + ", coreDataChanged=" + this.c + ", talkingDataChanged=" + this.d + ")";
        }

        public C0054b(SeiAppData r2, SeiAppData r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "newData");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public abstract void d(SeiAppData r1);

    public abstract void e(eg6.b r1);

    public b() {
    }
}
