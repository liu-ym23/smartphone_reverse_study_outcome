package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class k {

    public static final class a extends k {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends k {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends k {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends k {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends k {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L8;
            return false;
        L8:
            ((e) r4).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "SuspendForCallInterruption(interruptedPlaybackState=null)";
        }
    }

    public static final class f extends k {
        public f() {
            throw null;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof f) == true) goto L9;
            return false;
        L9:
            ((f) r3).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "SuspendForInputUnavailable(reason=null)";
        }
    }

    public k() {
    }
}
