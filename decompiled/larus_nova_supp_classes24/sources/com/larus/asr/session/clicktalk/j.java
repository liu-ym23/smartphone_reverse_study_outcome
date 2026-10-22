package com.larus.asr.session.clicktalk;

import com.larus.audio.call.mgr.MajorState;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface j {

    public static final class a implements j {
        public final byte[] a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public final String toString() {
            return "AudioDataReceive(data=" + Arrays.toString(this.a) + ')';
        }

        public a(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public static final class b implements j {
        public final List<pf9.p> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CommandReply(commands=" + this.a + ')';
        }

        public b(List<pf9.p> r2) {
            Intrinsics.checkNotNullParameter(r2, "commands");
            this.a = r2;
        }
    }

    public static final class c implements j {
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
            return "ConversationIdUpdated(conversationId=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            this.a = r2;
        }
    }

    public static final class d implements j {
        public final Integer a;
        public final Integer b;
        public final String c;
        public final Integer d;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
            Integer r7 = this.d;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(errorCode=" + this.a + ", vuiErrorCode=" + this.b + ", message=" + this.c + ", subErrorCode=" + this.d + ')';
        }

        public d(Integer r2, Integer r3, String r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r4, "message");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class e implements j {
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
            return "FinishCall(callId=" + this.a + ')';
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "callId");
            this.a = r2;
        }
    }

    public static final class f implements j {
        public final MajorState a;
        public final MajorState b;

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
            return "MajorStateChanged(previous=" + this.a + ", current=" + this.b + ')';
        }

        public f(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "previous");
            Intrinsics.checkNotNullParameter(r3, "current");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class g implements j {
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
            return "QueryBegin(questionId=" + this.a + ')';
        }

        public g(String r1) {
            this.a = r1;
        }
    }

    public static final class h implements j {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }
    }

    public static final class i implements j {
        public final pf9.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            pf9.a r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "QueryUpdate(asrResult=" + this.a + ')';
        }

        public i(pf9.a r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.asr.session.clicktalk.j$j, reason: collision with other inner class name */
    public static final class C0068j implements j {
        public static final C0068j a = null;

        static {
            a = new C0068j();
        }

        public C0068j() {
        }
    }

    public static final class k implements j {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }
    }

    public static final class l implements j {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }
    }

    public static final class m implements j {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }
    }

    public static final class n implements j {
        public final int a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof n) == true) goto L8;
            return false;
        L8:
            n r6 = (n) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "StateChanged(state=" + this.a + ", firstConnect=" + this.b + ')';
        }

        public n(int r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }
}
