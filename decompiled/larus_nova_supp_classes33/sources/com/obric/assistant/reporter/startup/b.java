package com.obric.assistant.reporter.startup;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final Set<String> a = null;

    public static final class a {
        public static final /* synthetic */ int b = 0;
        public final Set<String> a;

        /* JADX INFO: renamed from: com.obric.assistant.reporter.startup.b$a$a, reason: collision with other inner class name */
        public static final class C0014a {
        }

        static {
        }

        public a(Set r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.reporter.startup.b$b, reason: collision with other inner class name */
    public static final class C0015b {
        public final long a;
        public final String b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0015b) == true) goto L8;
            return false;
        L8:
            C0015b r9 = (C0015b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
            String r2 = this.c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r1 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "NormalizedStart(elapsedMs=" + this.a + ", clock=" + this.b + ", rejectionReason=" + this.c + ')';
        }

        public C0015b(long r2, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "clock");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ProcessState(type=" + this.a + ", inferred=" + this.b + ')';
        }

        public final String getType() {
            return this.a;
        }

        public c(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"elapsed_realtime", "uptime_converted_to_elapsed", "wall_converted_to_elapsed", "receiver_elapsed_fallback"});
    }

    public static C0015b a(long r6, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "requestedClock");
        if (a.contains(r8) == true) goto L6;
        String r0 = "unsupported_clock";
    L15:
        if (r0 != null) goto L18;
        return new C0015b(r6, r8, null);
    L18:
        return new C0015b(r9, "receiver_elapsed_fallback", r0);
    L6:
        if (r6 > 0) goto L9;
        r0 = "non_positive";
        goto L15
    L9:
        if (r6 <= r9) goto L12;
        r0 = "future";
        goto L15
    L12:
        if ((r9 - r6) <= 60000) goto L14;
        r0 = "too_old";
        goto L15
    L14:
        r0 = null;
        goto L15
    }
}
