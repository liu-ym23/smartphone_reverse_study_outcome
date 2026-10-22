package hia;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return 1100627058;
        }

        public final String toString() {
            return "PreInterrupted";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: hia.b$b, reason: collision with other inner class name */
    public static final class C0059b extends b {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0059b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0059b) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "QueryBegin(startListenTimestampMs=" + this.a + ')';
        }

        public C0059b(long r1) {
            this.a = r1;
        }
    }

    public static final class c extends b {
        public final boolean a;
        public final long b;
        public final Long c;
        public final String d;
        public final String e;
        public final String f;
        public final Long g;
        public final Long h;
        public final String i;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            long r1 = this.b;
            int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            Long r3 = this.c;
            int r4 = 0;
            if (r3 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r2 + r5) * 31;
            String r7 = this.d;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.e;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.f;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Long r16 = this.g;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            Long r19 = this.h;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.i;
            if (r22 == null) goto L35;
            r4 = r22.hashCode();
        L35:
            return r21 + r4;
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r3.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "QueryEnd(noContent=" + this.a + ", userDuration=" + this.b + ", lastRespCostTime=" + this.c + ", questionId=" + this.d + ", asrTaskId=" + this.e + ", localMessageId=" + this.f + ", queryStartTime=" + this.g + ", queryEndTime=" + this.h + ", callRound=" + this.i + ')';
        }

        public c(boolean r1, long r2, Long r4, String r5, String r6, String r7, Long r8, Long r9, String r10) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public static final class d extends b {
        public static final d a = null;

        static {
            a = new d();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof d) == true) goto L9;
            return false;
        L9:
            d r4 = (d) r3;
            return true;
        }

        public final int hashCode() {
            return 1363465779;
        }

        public final String toString() {
            return "QueryRejected";
        }

        public d() {
        }
    }

    public static final class e extends b {
        public static final e a = null;

        static {
            a = new e();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof e) == true) goto L9;
            return false;
        L9:
            e r4 = (e) r3;
            return true;
        }

        public final int hashCode() {
            return 1661526974;
        }

        public final String toString() {
            return "QueryUpdate";
        }

        public e() {
        }
    }

    public static final class f extends b {
        public static final f a = null;

        static {
            a = new f();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof f) == true) goto L9;
            return false;
        L9:
            f r4 = (f) r3;
            return true;
        }

        public final int hashCode() {
            return 1732912690;
        }

        public final String toString() {
            return "ReplyBegin";
        }

        public f() {
        }
    }

    public static final class g extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ReplyEnd(messageId=" + this.a + ')';
        }

        public g(String r1) {
            this.a = r1;
        }
    }

    public static final class h extends b {
        public static final h a = null;

        static {
            a = new h();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof h) == true) goto L9;
            return false;
        L9:
            h r4 = (h) r3;
            return true;
        }

        public final int hashCode() {
            return -355891246;
        }

        public final String toString() {
            return "VadVoiceActived";
        }

        public h() {
        }
    }

    public static final class i extends b {
        public static final i a = null;

        static {
            a = new i();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof i) == true) goto L9;
            return false;
        L9:
            i r4 = (i) r3;
            return true;
        }

        public final int hashCode() {
            return 137027679;
        }

        public final String toString() {
            return "VadVoiceFinish";
        }

        public i() {
        }
    }

    public static final class j extends b {
        public final String a;
        public final String b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof j) == true) goto L8;
            return false;
        L8:
            j r6 = (j) r5;
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
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "VoiceAuthResult(roomId=" + this.a + ", asrTaskId=" + this.b + ", voiceMatch=" + this.c + ')';
        }

        public j(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "roomId");
            Intrinsics.checkNotNullParameter(r3, "asrTaskId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public b() {
    }
}
