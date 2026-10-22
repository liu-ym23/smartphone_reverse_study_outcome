package uga;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final String f;
    public final Set<String> g;
    public final long h;
    public final Map<String, String> i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r3 = this.e;
        int r4 = (((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r5 = this.h;
        return ((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + this.i.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AssistantStartupAttemptSpec(attemptId=" + this.a + ", source=" + this.b + ", action=" + this.c + ", target=" + this.d + ", startElapsedRealtimeMs=" + this.e + ", startClock=" + this.f + ", requiredMilestones=" + this.g + ", timeoutMs=" + this.h + ", attributes=" + this.i + ')';
    }

    public static a a(a r12, String r13) {
        String r2 = r12.b;
        String r3 = r12.c;
        String r4 = r12.d;
        long r5 = r12.e;
        String r7 = r12.f;
        Set<String> r8 = r12.g;
        long r9 = r12.h;
        Map<String, String> r11 = r12.i;
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r7, "startClock");
        Intrinsics.checkNotNullParameter(r8, "requiredMilestones");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        return new a(r13, r2, r3, r4, r5, r7, r8, r9, r11);
    }

    public /* synthetic */ a(String r13, String r14, String r15, String r16, long r17, String r19, Set r20, Map r21) {
        this(r13, r14, r15, r16, r17, r19, r20, 15000, r21);
    }

    public a(String r2, String r3, String r4, String r5, long r6, String r8, Set<String> r9, long r10, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r8, "startClock");
        Intrinsics.checkNotNullParameter(r9, "requiredMilestones");
        Intrinsics.checkNotNullParameter(r12, "attributes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
    }
}
