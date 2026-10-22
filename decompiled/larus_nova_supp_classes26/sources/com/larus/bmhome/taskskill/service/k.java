package com.larus.bmhome.taskskill.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface k {

    public static final class a implements k {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
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
            return -1436327194;
        }

        public final String toString() {
            return "BrowserTakeoverOpened";
        }
    }

    public static final class b implements h {
        public final String a;

        public b() {
            this(null);
        }

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
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Failure(reason=" + this.a + ')';
        }

        public b(String r1) {
            this.a = r1;
        }
    }

    public static final class c implements h {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return 632741084;
        }

        public final String toString() {
            return "PcGuideConfirmed";
        }
    }

    public static final class d implements h {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
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
            return 1596317222;
        }

        public final String toString() {
            return "PcGuideDismissed";
        }
    }

    public static final class e implements k {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
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
            return 1455711502;
        }

        public final String toString() {
            return "PcGuideShown";
        }
    }

    public static final class f implements k {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
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
            return -1545128776;
        }

        public final String toString() {
            return "RequestStarted";
        }
    }

    public static final class g implements h {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof g) == true) goto L9;
            return false;
        L9:
            g r4 = (g) r3;
            return true;
        }

        public final int hashCode() {
            return 1968037034;
        }

        public final String toString() {
            return "ResultAccepted";
        }
    }

    public interface h extends k {
    }

    public static final class i implements h {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
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
            return 1838148143;
        }

        public final String toString() {
            return "Unsupported";
        }
    }
}
