package com.lynx.clay.relax.adaptor;

import com.lynx.clay.embedding.android.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RelaxAdaptor {
    public final d a;
    public long b;

    private native long createNativeRelaxAdaptor();

    private native void nativeBindRelaxEngine(long r1, long r3, long r5);

    private native void nativeDestroy(long r1);

    public final void b() {
        long r0 = this.b;
        if (r0 == 0) goto L6;
        nativeDestroy(r0);
        this.b = 0;
        return;
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }

    public RelaxAdaptor(d r3) {
        this.b = 0;
        this.a = r3;
    }

    public final void a(long r12) {
        if (this.b != 0) goto L5;
        this.b = createNativeRelaxAdaptor();
    L5:
        d r0 = this.a;
        if (r0 == null) goto L8;
        long r9 = r0.b.a.getNativeClayViewContext();
    L10:
        if (r9 == 0) goto L13;
        nativeBindRelaxEngine(this.b, r12, r9);
        return;
    L13:
        return;
    L8:
        r9 = 0;
        goto L10
    }
}
