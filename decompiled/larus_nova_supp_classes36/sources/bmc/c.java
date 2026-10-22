package bmc;

import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class c<T extends d> implements a {
    public c() {
    }

    public abstract void b(T r1);

    @Override // vlc.l
    public final void onMessage(d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getIntType() != dB()) goto L8;
        b(r3);
        return;
    }
}
