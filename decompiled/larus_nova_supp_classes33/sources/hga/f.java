package hga;

import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import com.obric.capabilitykit.common.UiType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public final long a;
    public final WakeupAudioCaptureTriggerType b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final int o;
    public final float p;
    public final float q;
    public final int r;
    public final boolean s;
    public final boolean t;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
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
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (Float.compare(this.p, r9.p) == 0) goto L57;
        return false;
    L57:
        if (Float.compare(this.q, r9.q) == 0) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31;
        long r3 = this.e;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.f;
        int r5 = (((((((((((((((((((((((((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o) * 31) + Float.floatToIntBits(this.p)) * 31) + Float.floatToIntBits(this.q)) * 31) + this.r) * 31;
        int r6 = 1231;
        if (this.s == false) goto L5;
        int r7 = 1231;
    L6:
        int r8 = (r5 + r7) * 31;
        if (this.t == true) goto L11;
        r6 = 1237;
    L11:
        return r8 + r6;
    L5:
        r7 = 1237;
        goto L6
    }

    public final String toString() {
        return "WakeupAudioCaptureTrigger(triggerTimeMs=" + this.a + ", triggerType=" + this.b + ", sessionId=" + this.c + ", wakeupId=" + this.d + ", interactionAudioStartTimeMs=" + this.e + ", mainProcessReceivedTimeMs=" + this.f + ", rawUid=" + d.a(this.g) + ", uid=" + d.a(this.h) + ", did=" + d.a(this.i) + ", osDid=" + d.a(this.j) + ", confidence=" + this.q + ", ohrHand=" + this.r + ", firstWakeupAfterBoot=" + this.s + ", firstWakeupAfterVoiceprintRecord=" + this.t + ')';
    }

    public f(long r24, WakeupAudioCaptureTriggerType r26, int r27, long r28, long r30, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, int r40, float r41, float r42, int r43, boolean r44, boolean r45, int r46) {
        if ((r46 & 4) == 0) goto L5;
        int r3 = -1;
    L7:
        if ((r46 & 8) == 0) goto L9;
        int r5 = 0;
    L10:
        long r7 = 0;
        if ((r46 & 16) == 0) goto L13;
        long r9 = 0;
    L15:
        if ((r46 & 32) != 0) goto L19;
        r7 = r30;
    L19:
        if ((r46 & 64) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r46 & 128) == 0) goto L25;
        String r12 = "";
    L27:
        if ((r46 & 256) == 0) goto L29;
        String r13 = "";
    L31:
        if ((r46 & 512) == 0) goto L33;
        String r14 = "";
    L35:
        if ((r46 & 1024) == 0) goto L37;
        String r15 = "";
    L39:
        if ((r46 & 2048) == 0) goto L41;
        String r4 = "";
    L43:
        if ((r46 & 4096) == 0) goto L45;
        String r11 = "";
    L46:
        long r29 = r7;
        if ((r46 & 8192) == 0) goto L49;
        String r8 = "";
    L51:
        if ((r46 & 16384) == 0) goto L53;
        int r10 = 0;
    L55:
        if ((r46 & 32768) == 0) goto L57;
        float r19 = 0.0f;
    L59:
        if ((r46 & UiType.FLAG_ALARM_CLOCK_CARD) == 0) goto L61;
        float r20 = 0.0f;
    L63:
        if ((r46 & UiType.FLAG_PHONE_CARD) == 0) goto L65;
        int r21 = 0;
    L67:
        if ((r46 & UiType.FLAG_TIMER_CARD) == 0) goto L69;
        boolean r22 = false;
    L71:
        if ((r46 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L73;
        boolean r16 = false;
    L74:
        Intrinsics.checkNotNullParameter(r26, "triggerType");
        Intrinsics.checkNotNullParameter(r6, "rawUid");
        Intrinsics.checkNotNullParameter(r12, "uid");
        Intrinsics.checkNotNullParameter(r13, "did");
        Intrinsics.checkNotNullParameter(r14, "osDid");
        Intrinsics.checkNotNullParameter(r15, "firstEngineVersion");
        Intrinsics.checkNotNullParameter(r4, "kwsModelMd5");
        Intrinsics.checkNotNullParameter(r11, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r8, "groupId");
        this.a = r24;
        this.b = r26;
        this.c = r3;
        this.d = r5;
        this.e = r9;
        this.f = r29;
        this.g = r6;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r4;
        this.m = r11;
        this.n = r8;
        this.o = r10;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r16;
        return;
    L73:
        r16 = r45;
        goto L74
    L69:
        r22 = r44;
        goto L71
    L65:
        r21 = r43;
        goto L67
    L61:
        r20 = r42;
        goto L63
    L57:
        r19 = r41;
        goto L59
    L53:
        r10 = r40;
        goto L55
    L49:
        r8 = r39;
        goto L51
    L45:
        r11 = r38;
        goto L46
    L41:
        r4 = r37;
        goto L43
    L37:
        r15 = r36;
        goto L39
    L33:
        r14 = r35;
        goto L35
    L29:
        r13 = r34;
        goto L31
    L25:
        r12 = r33;
        goto L27
    L21:
        r6 = r32;
        goto L23
    L13:
        r9 = r28;
        goto L15
    L9:
        r5 = r27;
        goto L10
    L5:
        r3 = 0;
        goto L7
    }
}
