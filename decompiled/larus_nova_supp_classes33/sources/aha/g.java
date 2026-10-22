package aha;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class g implements jha.o, t {
    public final String a;
    public final Object b;
    public final jha.h c;
    public final u d;

    public static final class a extends g {
        public final String e;
        public final Object f;
        public final String g;
        public final jha.h h;
        public final u i;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.e.hashCode() * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        }

        public final String toString() {
            return "Active(type=" + getType() + ", conversationId=" + this.g + ')';
        }

        @Override // aha.g, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.g, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.g
        public String getType() {
            return this.e;
        }

        public a(String r3, Object r4, String r5, u r6) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "taskInfo");
            Intrinsics.checkNotNullParameter(r5, "conversationId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r6, "taskMetadata");
            super(r3, r4, r0, r6);
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r0;
            this.i = r6;
        }
    }

    public static final class b extends g {
        public final String e;
        public final Object f;
        public final String g;
        public final jha.h h;
        public final u i;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.e.hashCode() * 31;
            Object r1 = this.f;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((r0 + r2) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Inactive(type=" + getType() + ", conversationId=" + this.g + ')';
        }

        @Override // aha.g, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.g, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.g
        public String getType() {
            return this.e;
        }

        public b(String r3, Object r4, String r5, u r6) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r5, "conversationId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r6, "taskMetadata");
            super(r3, r4, r0, r6);
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r0;
            this.i = r6;
        }
    }

    @Override // aha.t
    public final String c() {
        return b().d;
    }

    @Override // aha.t
    public final String getBotId() {
        return b().a;
    }

    @Override // jha.a
    public jha.h a() {
        return this.c;
    }

    @Override // aha.t
    public u b() {
        return this.d;
    }

    public String getType() {
        return this.a;
    }

    public g(String r1, Object r2, jha.h r3, u r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
