package com.lynx.tasm.ui.image;

import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.io.Closeable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements e8a.a<Closeable> {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ h d;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<Closeable> r12) {
        if (r12.a != LynxResourceResponse.ResponseState.SUCCESS) goto L7;
        CloseableReference<?> r13 = r12.b;
        if ((r13 instanceof CloseableReference) == false) goto L7;
        this.d.A.f(r13);
        long r7 = System.currentTimeMillis();
        int r10 = this.d.c(this.a, this.b);
        h r1 = this.d;
        r1.l(r1.v, true, true, this.c, r7, 0, r10);
        return;
    L7:
        this.d.A.d();
    }

    public j(h r1, int r2, int r3, long r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
