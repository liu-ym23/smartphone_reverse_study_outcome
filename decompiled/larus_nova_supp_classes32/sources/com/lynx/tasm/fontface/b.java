package com.lynx.tasm.fontface;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements e8a.a<byte[]> {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ String b;
    public final /* synthetic */ LynxContext c;
    public final /* synthetic */ CountDownLatch d;
    public final /* synthetic */ FontFaceManager e;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r5) {
        if (r5.a != LynxResourceResponse.ResponseState.SUCCESS) goto L7;
        byte[] r0 = r5.b;
        if (r0 == null) goto L7;
        this.a.set(r0);
    L8:
        this.d.countDown();
        return;
    L7:
        FontFaceManager r1 = this.e;
        String r6 = "Load font with genericResourceFetcher failed:" + r5.c.getMessage();
        String r2 = this.b;
        LynxContext r3 = this.c;
        r1.getClass();
        FontFaceManager.n(30202, r6, r2, null, r3);
        goto L8
    }

    public b(FontFaceManager r1, AtomicReference r2, String r3, LynxContext r4, CountDownLatch r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
