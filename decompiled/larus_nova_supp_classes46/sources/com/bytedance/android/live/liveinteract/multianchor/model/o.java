package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements am3.c<MicDress.a> {
    public o() {
    }

    public static MicDress.a a(am3.g r5) throws Exception {
        MicDress.a r0 = new MicDress.a();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L14;
        switch(r3) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r0.triggerReason = am3.h.c(r5);
        goto L3
    L8:
        r0.type = (int) r5.j();
        goto L3
    L9:
        r0.randomNum = r5.j();
        goto L3
    L10:
        r0.dynamicImage = (py.k) vh7.f.a(r5, py.k.class);
        goto L3
    L11:
        r0.statusImage = (py.k) vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        r0.ts = r5.j();
        goto L3
    L13:
        r0.status = r5.i();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
