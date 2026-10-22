package a3a;

import com.larus.audio.call.mgr.MajorState;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pf9.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a {

    /* JADX INFO: renamed from: a3a.a$a, reason: collision with other inner class name */
    public static final class C0000a implements a {
        public final byte[] a;
        public final int b;
        public final Long c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0000a) == true) goto L8;
            return false;
        L8:
            C0000a r6 = (C0000a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((Arrays.hashCode(this.a) * 31) + this.b) * 31;
            Long r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "AudioDataReceive(data=" + Arrays.toString(this.a) + ", readSize=" + this.b + ", audioTimeNs=" + this.c + ')';
        }

        public C0000a(byte[] r2, int r3, Long r4) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements a {
        public final List<p> a;

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

        public b(List<p> r2) {
            Intrinsics.checkNotNullParameter(r2, "commands");
            this.a = r2;
        }
    }

    public static final class c implements a {
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

    public static final class d implements a {
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

    public static final class e implements a {
        public final MajorState a;
        public final MajorState b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
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

        public e(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "previous");
            Intrinsics.checkNotNullParameter(r3, "current");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class f implements a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
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
            return "QueryBegin(asrTaskId=" + this.a + ')';
        }

        public f(String r1) {
            this.a = r1;
        }
    }

    public static final class g implements a {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.a == ((g) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryEnd(noContent=" + this.a + ')';
        }

        public g(boolean r1) {
            this.a = r1;
        }
    }

    public static final class h implements a {
        public final pf9.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
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

        public h(pf9.a r1) {
            this.a = r1;
        }
    }

    public static final class i implements a {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }
    }

    public static final class j implements a {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }
    }

    public static final class k implements a {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }
    }

    public static final class l implements a {
        public final int a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof l) == true) goto L8;
            return false;
        L8:
            l r6 = (l) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "StateChanged(previous=" + this.a + ", current=" + this.b + ", firstConnect=" + this.c + ')';
        }

        public l(int r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }
}
