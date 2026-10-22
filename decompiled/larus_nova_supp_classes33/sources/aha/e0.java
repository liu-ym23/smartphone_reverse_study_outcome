package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class e0 implements jha.o, t {
    public final String a;
    public final String b;
    public final String c;
    public final jha.h d;
    public final Map<String, Object> e;
    public final u f;

    public static final class a extends e0 {
        public final String g;
        public final String h;
        public final String i;
        public final jha.h j;
        public final Map<String, Object> k;
        public final u l;

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
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.g;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.h;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.i;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + this.j.hashCode()) * 31;
            Map<String, Object> r10 = this.k;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return ((r9 + r1) * 31) + this.l.hashCode();
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "END(audioScene=" + this.g + ", conversationId=" + this.h + ", messageId=" + this.i + ", lifecycleStage=" + this.j + ", ext=" + this.k + ", taskMetadata=" + this.l + ')';
        }

        @Override // aha.e0, jha.a
        public final jha.h a() {
            return this.j;
        }

        @Override // aha.e0, aha.t
        public final u b() {
            return this.l;
        }

        @Override // aha.e0
        public final String d() {
            return this.g;
        }

        @Override // aha.e0
        public final String e() {
            return this.h;
        }

        @Override // aha.e0
        public final String f() {
            return this.i;
        }

        public a(String r9, String r10, String r11, Map r12, u r13) {
            jha.h.c r7 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r13, "taskMetadata");
            super(r9, r10, r11, r7, r12, r13);
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r7;
            this.k = r12;
            this.l = r13;
        }
    }

    public static final class b extends e0 {
        public final String g;
        public final String h;
        public final String i;
        public final jha.h j;
        public final Map<String, Object> k;
        public final u l;

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
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.g;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.h;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.i;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + this.j.hashCode()) * 31;
            Map<String, Object> r10 = this.k;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return ((r9 + r1) * 31) + this.l.hashCode();
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PLAYING(audioScene=" + this.g + ", conversationId=" + this.h + ", messageId=" + this.i + ", lifecycleStage=" + this.j + ", ext=" + this.k + ", taskMetadata=" + this.l + ')';
        }

        @Override // aha.e0, jha.a
        public final jha.h a() {
            return this.j;
        }

        @Override // aha.e0, aha.t
        public final u b() {
            return this.l;
        }

        @Override // aha.e0
        public final String d() {
            return this.g;
        }

        @Override // aha.e0
        public final String e() {
            return this.h;
        }

        @Override // aha.e0
        public final String f() {
            return this.i;
        }

        public b(String r9, String r10, String r11, Map r12, u r13) {
            jha.h.a r7 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r13, "taskMetadata");
            super(r9, r10, r11, r7, r12, r13);
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r7;
            this.k = r12;
            this.l = r13;
        }
    }

    public static final class c extends e0 {
        public final String g;
        public final String h;
        public final String i;
        public final jha.h j;
        public final Map<String, Object> k;
        public final u l;

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
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.g;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.h;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.i;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + this.j.hashCode()) * 31;
            Map<String, Object> r10 = this.k;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return ((r9 + r1) * 31) + this.l.hashCode();
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PREPARING(audioScene=" + this.g + ", conversationId=" + this.h + ", messageId=" + this.i + ", lifecycleStage=" + this.j + ", ext=" + this.k + ", taskMetadata=" + this.l + ')';
        }

        @Override // aha.e0, jha.a
        public final jha.h a() {
            return this.j;
        }

        @Override // aha.e0, aha.t
        public final u b() {
            return this.l;
        }

        @Override // aha.e0
        public final String d() {
            return this.g;
        }

        @Override // aha.e0
        public final String e() {
            return this.h;
        }

        @Override // aha.e0
        public final String f() {
            return this.i;
        }

        public c(String r9, String r10, String r11, Map r12, u r13) {
            jha.h.a r7 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r13, "taskMetadata");
            super(r9, r10, r11, r7, r12, r13);
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r7;
            this.k = r12;
            this.l = r13;
        }
    }

    public e0() {
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
        return this.d;
    }

    @Override // aha.t
    public u b() {
        return this.f;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public e0(String r1, String r2, String r3, jha.h r4, Map r5, u r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
