package hga;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public final int a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final byte[] f;
    public final long g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final int p;
    public final float q;
    public final float r;
    public final int s;
    public final boolean t;
    public final boolean u;
    public final boolean v;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Float.compare(this.q, r9.q) == 0) goto L60;
        return false;
    L60:
        if (Float.compare(this.r, r9.r) == 0) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L69;
        return false;
    L69:
        if (this.u == r9.u) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.e;
        int r8 = (((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + Arrays.hashCode(this.f)) * 31;
        long r9 = this.g;
        int r10 = (((((((((((((((((((((((((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p) * 31) + Float.floatToIntBits(this.q)) * 31) + Float.floatToIntBits(this.r)) * 31) + this.s) * 31;
        int r11 = 1231;
        if (this.t == false) goto L5;
        int r12 = 1231;
    L6:
        int r13 = (r10 + r12) * 31;
        if (this.u == false) goto L9;
        int r14 = 1231;
    L10:
        int r15 = (r13 + r14) * 31;
        if (this.v == true) goto L15;
        r11 = 1237;
    L15:
        return r15 + r11;
    L9:
        r14 = 1237;
        goto L10
    L5:
        r12 = 1237;
        goto L6
    }

    public final String toString() {
        return "WakeupTruthUploadData(wakeupId=" + this.a + ", triggerTimeMs=" + this.b + ", captureAnchorTimeMs=" + this.c + ", uploadStartTimeMs=" + this.d + ", uploadEndTimeMs=" + this.e + ", audioBytes=" + this.f.length + ", audioDurationMs=" + this.g + ", rawUid=" + d.a(this.l) + ", uid=" + d.a(this.m) + ", did=" + d.a(this.n) + ", osDid=" + d.a(this.o) + ", confidence=" + this.r + ", ohrHand=" + this.s + ", pocketMode=" + this.t + ", firstWakeupAfterBoot=" + this.u + ", firstWakeupAfterVoiceprintRecord=" + this.v + ')';
    }

    public g(int r13, long r14, long r16, long r18, long r20, byte[] r22, long r23, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, int r33, float r34, float r35, int r36, boolean r37, boolean r38, boolean r39) {
        Intrinsics.checkNotNullParameter(r22, "audioData");
        Intrinsics.checkNotNullParameter(r25, "firstEngineVersion");
        Intrinsics.checkNotNullParameter(r26, "kwsModelMd5");
        Intrinsics.checkNotNullParameter(r27, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r28, "groupId");
        Intrinsics.checkNotNullParameter(r29, "rawUid");
        Intrinsics.checkNotNullParameter(r30, "uid");
        Intrinsics.checkNotNullParameter(r31, "did");
        Intrinsics.checkNotNullParameter(r32, "osDid");
        this.a = r13;
        this.b = r14;
        this.c = r16;
        this.d = r18;
        this.e = r20;
        this.f = r22;
        this.g = r23;
        this.h = r25;
        this.i = r26;
        this.j = r27;
        this.k = r28;
        this.l = r29;
        this.m = r30;
        this.n = r31;
        this.o = r32;
        this.p = r33;
        this.q = r34;
        this.r = r35;
        this.s = r36;
        this.t = r37;
        this.u = r38;
        this.v = r39;
    }
}
