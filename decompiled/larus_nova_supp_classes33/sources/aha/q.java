package aha;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatusLocal;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class q implements jha.o, t {
    public final Message a;
    public final jha.h b;
    public final u c;

    public static final class a extends q {
        public final String d;
        public final String e;

        @MessageStatusLocal
        public final int f;
        public final Message g;
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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L15;
            return false;
        L15:
            if (this.f == r6.f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.d.hashCode() * 31;
            String r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.f) * 31;
            Message r5 = this.g;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(conversationId=" + this.d + ", messageId=" + this.e + ", messageStatusLocal=" + this.f + ", msg=" + this.g + ", lifecycleStage=" + this.h + ", taskMetadata=" + this.i + ')';
        }

        @Override // aha.q, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.q, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.q
        public final Message d() {
            return this.g;
        }

        public a(String r3, String r4, int r5, Message r6, u r7) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r6, r0, r7);
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r0;
            this.i = r7;
        }
    }

    public static final class b extends q {
        public final String d;
        public final String e;

        @MessageStatusLocal
        public final int f;
        public final Message g;
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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L15;
            return false;
        L15:
            if (this.f == r6.f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.d.hashCode() * 31;
            String r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.f) * 31;
            Message r5 = this.g;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + this.h.hashCode()) * 31;
            Map<String, Object> r8 = this.i;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((r7 + r2) * 31) + this.j.hashCode();
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Inactive(conversationId=" + this.d + ", messageId=" + this.e + ", messageStatusLocal=" + this.f + ", msg=" + this.g + ", lifecycleStage=" + this.h + ", ext=" + this.i + ", taskMetadata=" + this.j + ')';
        }

        @Override // aha.q, jha.a
        public final jha.h a() {
            return this.h;
        }

        @Override // aha.q, aha.t
        public final u b() {
            return this.j;
        }

        @Override // aha.q
        public final Message d() {
            return this.g;
        }

        public b(String r3, String r4, int r5, Message r6, Map r7, u r8) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r8, "taskMetadata");
            super(r6, r0, r8);
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r0;
            this.i = r7;
            this.j = r8;
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
        return this.b;
    }

    @Override // aha.t
    public u b() {
        return this.c;
    }

    public Message d() {
        return this.a;
    }

    public q(Message r1, jha.h r2, u r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
