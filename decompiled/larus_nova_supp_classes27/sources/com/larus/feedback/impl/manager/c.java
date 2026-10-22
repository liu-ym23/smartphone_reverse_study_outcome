package com.larus.feedback.impl.manager;

import android.os.Handler;
import com.larus.utils.t0;
import q99.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements o99.c {
    public final /* synthetic */ a a;
    public final /* synthetic */ i b;

    @Override // o99.c
    public final void e(final q99.d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Handler r0 = t0.a;
        final a r1 = this.a;
        final i r2 = this.b;
        r0.post(new b(r1, r2, r5));
    }

    public c(a r1, i r2) {
        this.a = r1;
        this.b = r2;
    }
}
