package com.larus.doc.impl.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class e {

    public static final class a extends e {
        public final com.larus.doc.impl.offline.a a;
        public final String b;
        public final String c;
        public final com.larus.doc.impl.offline.b d;

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
            return "CompensateCreate(snapshot=" + this.a + ", failReason=" + this.b + ", trigger=" + this.c + ", createDocByMessageState=" + this.d + ')';
        }

        public a(com.larus.doc.impl.offline.a r2, String r3, String r4, com.larus.doc.impl.offline.b r5) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            Intrinsics.checkNotNullParameter(r3, "failReason");
            Intrinsics.checkNotNullParameter(r4, "trigger");
            Intrinsics.checkNotNullParameter(r5, "createDocByMessageState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b extends e {
        public final com.larus.doc.impl.offline.a a;
        public final String b;
        public final com.larus.doc.impl.offline.b c;

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
            return "FormalCreate(snapshot=" + this.a + ", trigger=" + this.b + ", createDocByMessageState=" + this.c + ')';
        }

        public b(com.larus.doc.impl.offline.a r2, String r3, com.larus.doc.impl.offline.b r4) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            Intrinsics.checkNotNullParameter(r3, "trigger");
            Intrinsics.checkNotNullParameter(r4, "createDocByMessageState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends e {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Noop(reason=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class d extends e {
        public final String a;
        public final String b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "RetryOpen(docRealToken=" + this.a + ", reason=" + this.b + ')';
        }

        public d(String r3) {
            Intrinsics.checkNotNullParameter("offline_create_fail", "reason");
            this.a = r3;
            this.b = "offline_create_fail";
        }
    }

    public e() {
    }
}
