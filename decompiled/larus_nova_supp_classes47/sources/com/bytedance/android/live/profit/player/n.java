package com.bytedance.android.live.profit.player;

import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public final PlayPriority a;
    public final List<MaskSrc> b;
    public final Function1<List<String>, Unit> c;
    public final l d;

    public n() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L14;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        PlayPriority r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<MaskSrc> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function1<List<String>, Unit> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        l r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "Mp4PlayConfig(priority=" + this.a + ", maskSrc=" + this.b + ", onElementClick=" + this.c + ", callback=" + this.d + ")";
    }

    public n(List r4, Function1 r5, l r6, int r7) {
        if ((r7 & 1) == 0) goto L5;
        PlayPriority r0 = PlayPriority.Normal;
    L7:
        if ((r7 & 2) == 0) goto L10;
        r4 = null;
    L10:
        if ((r7 & 4) == 0) goto L13;
        r5 = Mp4PlayConfig$1.INSTANCE;
    L13:
        if ((r7 & 8) == 0) goto L15;
        r6 = new m();
    L15:
        Intrinsics.checkNotNullParameter(r0, "priority");
        Intrinsics.checkNotNullParameter(r5, "onElementClick");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.a = r0;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
