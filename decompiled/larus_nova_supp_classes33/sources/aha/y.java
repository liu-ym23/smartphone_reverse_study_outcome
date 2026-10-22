package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class y implements jha.o, t {
    public final Map<String, Object> a;

    public static final class a extends y {
        public final String b;
        public final String c;
        public final int d;
        public final jha.h e;
        public final Map<String, Object> f;
        public final u g;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
            Map<String, Object> r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.g.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(callId=" + this.b + ", conversationId=" + this.c + ", instanceCallState=" + this.d + ", lifecycleStage=" + this.e + ", ext=" + this.f + ", taskMetadata=" + this.g + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.e;
        }

        @Override // aha.t
        public final u b() {
            return this.g;
        }

        public a(String r3, String r4, int r5, u r6) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r3, "callId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r6, "taskMetadata");
            super(r0, null);
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r0;
            this.f = null;
            this.g = r6;
        }
    }

    public static final class b extends y {
        public final String b;
        public final String c;
        public final int d;
        public final jha.h e;
        public final Map<String, Object> f;
        public final u g;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
            Map<String, Object> r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.g.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(callId=" + this.b + ", conversationId=" + this.c + ", instanceCallState=" + this.d + ", lifecycleStage=" + this.e + ", ext=" + this.f + ", taskMetadata=" + this.g + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.e;
        }

        @Override // aha.t
        public final u b() {
            return this.g;
        }

        public b(String r3, String r4, u r5) {
            jha.h.b r0 = jha.h.b.a;
            Intrinsics.checkNotNullParameter(r3, "callId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r5, "taskMetadata");
            super(r0, null);
            this.b = r3;
            this.c = r4;
            this.d = 0;
            this.e = r0;
            this.f = null;
            this.g = r5;
        }
    }

    public static final class c extends y {
        public final String b;
        public final String c;
        public final int d;
        public final jha.h e;
        public final Map<String, Object> f;
        public final u g;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
            Map<String, Object> r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.g.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Terminated(callId=" + this.b + ", conversationId=" + this.c + ", instanceCallState=" + this.d + ", lifecycleStage=" + this.e + ", ext=" + this.f + ", taskMetadata=" + this.g + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.e;
        }

        @Override // aha.t
        public final u b() {
            return this.g;
        }

        public c(String r3, String r4, u r5) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r3, "callId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r5, "taskMetadata");
            super(r0, null);
            this.b = r3;
            this.c = r4;
            this.d = -1;
            this.e = r0;
            this.f = null;
            this.g = r5;
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

    public y(jha.h r1, Map r2) {
        this.a = r2;
    }
}
