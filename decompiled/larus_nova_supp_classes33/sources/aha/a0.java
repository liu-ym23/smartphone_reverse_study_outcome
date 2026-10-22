package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a0 implements jha.o, t {
    public final int a;
    public final jha.h b;
    public final Map<String, Object> c;
    public final u d;

    public static final class a extends a0 {
        public final String e;
        public final String f;
        public final int g;
        public final jha.h h;
        public final Map<String, Object> i;
        public final u j;

        public a() {
            throw null;
        }

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
            if (this.g == r6.g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.e.hashCode() * 31;
            String r1 = this.f;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.g) * 31) + this.h.hashCode()) * 31;
            Map<String, Object> r5 = this.i;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.j.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(callId=" + this.e + ", conversationId=" + this.f + ", instanceCallState=" + this.g + ", lifecycleStage=" + this.h + ", ext=" + this.i + ", taskMetadata=" + this.j + ')';
        }

        @Override // aha.a0, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.a0, aha.t
        public final u b() {
            return this.j;
        }

        @Override // aha.a0
        public final int d() {
            return this.g;
        }

        public a(String r3, String r4, int r5, Map r6, u r7, int r8) {
            if ((r8 & 8) == 0) goto L5;
            jha.h.a r0 = jha.h.a.a;
        L7:
            if ((r8 & 16) == 0) goto L9;
            r6 = null;
        L9:
            Intrinsics.checkNotNullParameter(r3, "callId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r5, r0, r6, r7);
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r0;
            this.i = r6;
            this.j = r7;
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    public static final class b extends a0 {
        public final String e;
        public final String f;
        public final int g;
        public final jha.h h;
        public final Map<String, Object> i;
        public final u j;

        public b() {
            throw null;
        }

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
            if (this.g == r6.g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.e.hashCode() * 31;
            String r1 = this.f;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.g) * 31) + this.h.hashCode()) * 31;
            Map<String, Object> r5 = this.i;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.j.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(callId=" + this.e + ", conversationId=" + this.f + ", instanceCallState=" + this.g + ", lifecycleStage=" + this.h + ", ext=" + this.i + ", taskMetadata=" + this.j + ')';
        }

        @Override // aha.a0, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.a0, aha.t
        public final u b() {
            return this.j;
        }

        @Override // aha.a0
        public final int d() {
            return this.g;
        }

        public b(String r4, String r5, u r6) {
            jha.h.b r0 = jha.h.b.a;
            Intrinsics.checkNotNullParameter(r4, "callId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r6, "taskMetadata");
            super(0, r0, null, r6);
            this.e = r4;
            this.f = r5;
            this.g = 0;
            this.h = r0;
            this.i = null;
            this.j = r6;
        }
    }

    public static final class c extends a0 {
        public final String e;
        public final String f;
        public final int g;
        public final jha.h h;
        public final Map<String, Object> i;
        public final u j;

        public c() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L15;
            return false;
        L15:
            if (this.g == r6.g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.e.hashCode() * 31;
            String r1 = this.f;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.g) * 31) + this.h.hashCode()) * 31;
            Map<String, Object> r5 = this.i;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.j.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Terminated(callId=" + this.e + ", conversationId=" + this.f + ", instanceCallState=" + this.g + ", lifecycleStage=" + this.h + ", ext=" + this.i + ", taskMetadata=" + this.j + ')';
        }

        @Override // aha.a0, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.a0, aha.t
        public final u b() {
            return this.j;
        }

        @Override // aha.a0
        public final int d() {
            return this.g;
        }

        public c(String r4, String r5, u r6) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r4, "callId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r6, "taskMetadata");
            super(-1, r0, null, r6);
            this.e = r4;
            this.f = r5;
            this.g = -1;
            this.h = r0;
            this.i = null;
            this.j = r6;
        }
    }

    public a0() {
        throw null;
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
        return this.b;
    }

    @Override // aha.t
    public u b() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public a0(int r1, jha.h r2, Map r3, u r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
