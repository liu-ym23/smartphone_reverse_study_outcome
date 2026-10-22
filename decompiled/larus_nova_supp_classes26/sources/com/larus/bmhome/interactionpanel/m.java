package com.larus.bmhome.interactionpanel;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public final o a;
    public final Set<InteractionPanelSource> b;
    public final t c;
    public final t d;
    public final long e;
    public final long f;
    public final Long g;
    public final long h;
    public final InteractionPanelQueueState i;
    public final String j;
    public final w k;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        t r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        t r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        long r7 = this.e;
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.f;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        Long r11 = this.g;
        if (r11 != null) goto L13;
        int r12 = 0;
    L14:
        int r13 = (r10 + r12) * 31;
        long r14 = this.h;
        int r15 = (((r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31) + this.i.hashCode()) * 31;
        String r16 = this.j;
        if (r16 != null) goto L17;
        int r17 = 0;
    L18:
        int r18 = (r15 + r17) * 31;
        w r19 = this.k;
        if (r19 == null) goto L23;
        r2 = r19.hashCode();
    L23:
        return r18 + r2;
    L17:
        r17 = r16.hashCode();
        goto L18
    L13:
        r12 = r11.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionPanelEntry(key=" + this.a + ", sources=" + this.b + ", mainHostPayload=" + this.c + ", threadHostPayload=" + this.d + ", firstEnqueueTimeMs=" + this.e + ", updateTimeMs=" + this.f + ", expireAtMs=" + this.g + ", order=" + this.h + ", queueState=" + this.i + ", submitOwnerHostId=" + this.j + ", trackContext=" + this.k + ')';
    }

    public static m a(m r18, Set r19, t r20, t r21, long r22, Long r24, InteractionPanelQueueState r25, String r26, w r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        o r2 = r18.a;
    L6:
        o r4 = r2;
        if ((r28 & 2) == 0) goto L9;
        Set r5 = r18.b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        t r6 = r18.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        t r7 = r18.d;
    L18:
        long r8 = 0;
        if ((r28 & 16) == 0) goto L21;
        long r10 = r18.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r12 = r18.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        Long r3 = r18.g;
    L31:
        if ((r28 & 128) == 0) goto L33;
        r8 = r18.h;
    L33:
        long r14 = r8;
        if ((r28 & 256) == 0) goto L36;
        InteractionPanelQueueState r9 = r18.i;
    L38:
        if ((r28 & 512) == 0) goto L40;
        String r16 = r18.j;
    L42:
        if ((r28 & 1024) == 0) goto L44;
        w r17 = r18.k;
    L45:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "sources");
        Intrinsics.checkNotNullParameter(r9, "queueState");
        return new m(r4, r5, r6, r7, r10, r12, r3, r14, r9, r16, r17);
    L44:
        r17 = r27;
        goto L45
    L40:
        r16 = r26;
        goto L42
    L36:
        r9 = r25;
        goto L38
    L29:
        r3 = r24;
        goto L31
    L25:
        r12 = r22;
        goto L27
    L21:
        r10 = 0;
        goto L23
    L17:
        r7 = r21;
        goto L18
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(o r2, Set<? extends InteractionPanelSource> r3, t r4, t r5, long r6, long r8, Long r10, long r11, InteractionPanelQueueState r13, String r14, w r15) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "sources");
        Intrinsics.checkNotNullParameter(r13, "queueState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r13;
        this.j = r14;
        this.k = r15;
    }
}
