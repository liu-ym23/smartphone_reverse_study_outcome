package aha;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatusLocal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class j implements jha.o, t {

    public static final class a extends j {
        public final String a;
        public final String b;

        @MessageStatusLocal
        public final int c;
        public final Message d;
        public final jha.h e;
        public final u f;

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
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c) * 31;
            Message r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(conversationId=" + this.a + ", messageId=" + this.b + ", messageStatusLocal=" + this.c + ", msg=" + this.d + ", lifecycleStage=" + this.e + ", taskMetadata=" + this.f + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.e;
        }

        @Override // aha.t
        public final u b() {
            return this.f;
        }

        public a(String r2, String r3, int r4, Message r5, jha.h.c r6, u r7) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r6, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r6);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class b extends j {
        public final String a;
        public final String b;

        @MessageStatusLocal
        public final int c;
        public final Message d;
        public final jha.h e;
        public final u f;

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
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c) * 31;
            Message r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Start(conversationId=" + this.a + ", messageId=" + this.b + ", messageStatusLocal=" + this.c + ", msg=" + this.d + ", lifecycleStage=" + this.e + ", taskMetadata=" + this.f + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.e;
        }

        @Override // aha.t
        public final u b() {
            return this.f;
        }

        public b(String r2, String r3, int r4, Message r5, jha.h.a r6, u r7) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r6, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r6);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
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

    public j(jha.h r1) {
    }
}
