package com.bytedance.android.live.liveinteract.voicechat.subtitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0<T> {
    public T a;
    public long b;
    public final int c;

    public h0(int r1) {
        this.c = r1;
    }

    public final T a(T r6) {
        if (this.b != 0) goto L7;
        return this.a;
    L7:
        if (this.c > 0) goto L10;
    L12:
        boolean r0 = false;
    L13:
        if (r0 == false) goto L16;
        return r6;
    L16:
        return this.a;
    L10:
        if ((System.currentTimeMillis() - this.b) <= this.c) goto L12;
        r0 = true;
        goto L13
    }

    public final void b(T r3) {
        this.a = r3;
        this.b = System.currentTimeMillis();
    }
}
