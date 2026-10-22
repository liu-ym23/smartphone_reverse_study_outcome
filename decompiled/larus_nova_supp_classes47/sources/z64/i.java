package z64;

import com.bytedance.badger.data.ReportStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class i {

    public static final class a extends i {
        public final Throwable a;
        public final boolean b;
        public final ReportStage c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L5;
        L17:
            return true;
        L5:
            if ((r5 instanceof a) == false) goto L16;
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == false) goto L16;
            if (this.b != r6.b) goto L11;
            boolean r1 = true;
        L12:
            if (r1 == false) goto L16;
            if (Intrinsics.areEqual(this.c, r6.c) == false) goto L16;
        L11:
            r1 = false;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            Throwable r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = r4;
            if (r4 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r3 + r5) * 31;
            ReportStage r7 = this.c;
            if (r7 == null) goto L13;
            r1 = r7.hashCode();
        L13:
            return r6 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Failure(error=" + this.a + ", isReportGenerated=" + this.b + ", reportStage=" + this.c + ")";
        }

        public /* synthetic */ a(Throwable r2, boolean r3) {
            this(r2, r3, ReportStage.FINAL);
        }

        public a(Throwable r1, boolean r2, ReportStage r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends i {
        public final String a;
        public final int b;
        public final boolean c;
        public final ReportStage d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L5;
        L22:
            return true;
        L5:
            if ((r5 instanceof b) == false) goto L21;
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == false) goto L21;
            if (this.b != r6.b) goto L11;
            boolean r1 = true;
        L12:
            if (r1 == false) goto L21;
            if (this.c != r6.c) goto L16;
            boolean r2 = true;
        L17:
            if (r2 == false) goto L21;
            if (Intrinsics.areEqual(this.d, r6.d) == false) goto L21;
        L16:
            r2 = false;
            goto L17
        L11:
            r1 = false;
        L21:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.b) * 31;
            boolean r4 = this.c;
            ?? r5 = r4;
            if (r4 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r3 + r5) * 31;
            ReportStage r7 = this.d;
            if (r7 == null) goto L13;
            r1 = r7.hashCode();
        L13:
            return r6 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(logId=" + this.a + ", sceneId=" + this.b + ", isFull=" + this.c + ", reportStage=" + this.d + ")";
        }

        public /* synthetic */ b(int r4) {
            this("", r4, true, ReportStage.FINAL);
        }

        public b(String r1, int r2, boolean r3, ReportStage r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public i() {
    }
}
