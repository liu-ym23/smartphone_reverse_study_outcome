package com.larus.dora.impl.onboarding.othersmart;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class r0 {
    public final String a;

    public static final class a extends r0 {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("gesture_end_guidance");
        }
    }

    public static final class b extends r0 {
        public final z98.f b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((b) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "QueryMusic(data=" + this.b + ')';
        }

        public b(z98.f r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super("");
            this.b = r2;
        }
    }

    public static final class c extends r0 {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("gesture_end_guidance");
        }
    }

    public static final class d extends r0 {
        public final boolean b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.b == ((d) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryTopic(isTTSPlayed=" + this.b + ')';
        }

        public d(boolean r2) {
            super("first_conversation_guidance");
            this.b = r2;
        }
    }

    public static final class e extends r0 {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("");
        }
    }

    public static final class f extends r0 {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
            super("subsequent_conversation_guidance");
        }
    }

    public static final class g extends r0 {
        public final boolean b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.b == ((g) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Wakeup(isTTSPlayed=" + this.b + ')';
        }

        public g(boolean r2) {
            super("voice_wakeup_guidance");
            this.b = r2;
        }
    }

    public r0(String r1) {
        this.a = r1;
    }
}
