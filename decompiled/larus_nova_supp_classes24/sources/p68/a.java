package p68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: p68.a$a, reason: collision with other inner class name */
    public static final class C0119a extends a {
        public final String a;
        public final String b;
        public final long c;
        public final Integer d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0119a) == true) goto L8;
            return false;
        L8:
            C0119a r9 = (C0119a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            Integer r3 = this.d;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "AsrFailure(taskId=" + this.a + ", recordPath=" + this.b + ", duration=" + this.c + ", errorCode=" + this.d + ')';
        }

        public C0119a(String r2, String r3, long r4, Integer r6) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "recordPath");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    public static final class b extends a {
        public final String a;
        public final String b;
        public final long c;
        public final String d;
        public final String e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31;
            String r3 = this.e;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "AsrSuccess(taskId=" + this.a + ", content=" + this.b + ", duration=" + this.c + ", vid=" + this.d + ", logId=" + this.e + ')';
        }

        public b(String r2, String r3, long r4, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "content");
            Intrinsics.checkNotNullParameter(r6, "vid");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }
    }

    public a() {
    }
}
