package com.larus.audio.call.play;

import com.larus.voicecall.impl.plugins.i0;
import com.larus.voicecall.impl.plugins.j0;
import com.larus.voicecall.impl.plugins.k0;
import com.larus.voicecall.impl.plugins.s0;
import com.larus.voicecall.impl.plugins.t0;
import com.larus.voicecall.impl.plugins.u0;
import com.larus.voicecall.impl.plugins.v0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public final Function1<byte[], Unit> a;
    public final Function1<byte[], Unit> b;
    public final Function1<byte[], Unit> c;
    public final Function1<byte[], Unit> d;
    public final Function1<byte[], Unit> e;
    public final Function1<byte[], Unit> f;
    public final Function3<byte[], String, String, Unit> g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "DumpConfig(rawTTSPerRound=" + this.a + ", rawTTSAll=" + this.b + ", processedTTSAll=" + this.c + ", processedTTSPerRound=" + this.d + ", rawTTSPerRoundWithSilent=" + this.e + ", processedTTSPerRoundWithSilent=" + this.f + ", firstFrame=" + this.g + ')';
    }

    public g(s0 r2, t0 r3, u0 r4, v0 r5, i0 r6, j0 r7, k0 r8) {
        Intrinsics.checkNotNullParameter(r2, "rawTTSPerRound");
        Intrinsics.checkNotNullParameter(r3, "rawTTSAll");
        Intrinsics.checkNotNullParameter(r4, "processedTTSAll");
        Intrinsics.checkNotNullParameter(r5, "processedTTSPerRound");
        Intrinsics.checkNotNullParameter(r6, "rawTTSPerRoundWithSilent");
        Intrinsics.checkNotNullParameter(r7, "processedTTSPerRoundWithSilent");
        Intrinsics.checkNotNullParameter(r8, "firstFrame");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
