package com.bytedance.android.live.revenuelink.rtc;

import fr2.n0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s extends n0 {
    public final WeakReference<n0> b;

    public s(n0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = new WeakReference(r2);
    }

    public final void b(gr2.b r8, int r9, long r10, Exception r12) {
        n0 r1 = this.b.get();
        if (r1 == null) goto L6;
        r1.b(r8, r9, r10, r12);
        return;
    }

    public final void l(gr2.b r8, int r9, long r10, Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        n0 r1 = this.b.get();
        if (r1 == null) goto L6;
        r1.l(r8, r9, r10, Arrays.copyOf(r12, r12.length));
        return;
    }
}
