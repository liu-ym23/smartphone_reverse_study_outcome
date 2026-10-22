package eub;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadDeleteReason;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskEventOrigin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c {

    public static final class a extends c {
        public final String a;
        public final eub.f b;
        public final MmMinutesFileUploadTaskEventOrigin c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Added(taskId=" + this.a + ", param=" + this.b + ", origin=" + this.c + ')';
        }

        public a(String r2, eub.f r3, MmMinutesFileUploadTaskEventOrigin r4) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "origin");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends c {
        public final String a;
        public final MmMinutesFileUploadDeleteReason b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Deleted(taskId=" + this.a + ", reason=" + this.b + ')';
        }

        public b(String r2, MmMinutesFileUploadDeleteReason r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "reason");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: eub.c$c, reason: collision with other inner class name */
    public static final class C0137c extends c {
        public static final C0137c a = null;

        static {
            a = new C0137c();
        }

        public C0137c() {
        }
    }

    public static final class d extends c {
        public final String a;
        public final eub.f b;
        public final eub.g c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PrepareSucceeded(taskId=" + this.a + ", param=" + this.b + ", status=" + this.c + ')';
        }

        public d(String r2, eub.f r3, eub.g r4) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "status");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class e extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Prepared(userId=" + this.a + ')';
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }
    }

    public static final class f extends c {
        public final String a;
        public final eub.g b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ProgressUpdated(taskId=" + this.a + ", status=" + this.b + ')';
        }

        public f(String r2, eub.g r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "status");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class g extends c {
        public final String a;
        public final eub.f b;
        public final eub.b c;
        public final eub.g d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "UploadFailed(taskId=" + this.a + ", param=" + this.b + ", error=" + this.c + ", status=" + this.d + ')';
        }

        public g(String r2, eub.f r3, eub.b r4, eub.g r5) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r5, "status");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class h extends c {
        public final String a;
        public final eub.f b;
        public final MmMinutesFileUploadDeleteReason c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "UploadItemDeleted(taskId=" + this.a + ", param=" + this.b + ", reason=" + this.c + ')';
        }

        public h(String r2, eub.f r3, MmMinutesFileUploadDeleteReason r4) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "reason");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class i extends c {
        public final String a;
        public final eub.f b;
        public final eub.g c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "UploadSuccess(taskId=" + this.a + ", param=" + this.b + ", status=" + this.c + ')';
        }

        public i(String r2, eub.f r3, eub.g r4) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "status");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public c() {
    }
}
