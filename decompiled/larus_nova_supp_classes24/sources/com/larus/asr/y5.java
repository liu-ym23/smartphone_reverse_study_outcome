package com.larus.asr;

import com.larus.audio.report.h;
import kotlin.jvm.internal.Intrinsics;
import qw5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y5 {
    public final lw5.e a;
    public final a b;
    public final KmpAsrSessionAdapter.a c;
    public final long d;
    public final h e;
    public final z2 f;
    public final f2 g;
    public final n4 h;
    public long i;
    public volatile boolean j;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof y5) == true) goto L8;
        return false;
    L8:
        y5 r9 = (y5) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        a r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        long r5 = this.d;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        h r7 = this.e;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (((((r6 + r8) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        n4 r10 = this.h;
        if (r10 == null) goto L15;
        r2 = r10.hashCode();
    L15:
        return r9 + r2;
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceInputContext(voiceInput=" + this.a + ", config=" + this.b + ", callback=" + this.c + ", startTimeStamp=" + this.d + ", tracer=" + this.e + ", stateListenerAdapter=" + this.f + ", listenerAdapter=" + this.g + ", samiNotReadyRetryCoordinator=" + this.h + ')';
    }

    public y5(lw5.e r2, a r3, KmpAsrSessionAdapter.a r4, long r5, h r7, z2 r8, f2 r9, n4 r10) {
        Intrinsics.checkNotNullParameter(r2, "voiceInput");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r8, "stateListenerAdapter");
        Intrinsics.checkNotNullParameter(r9, "listenerAdapter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
