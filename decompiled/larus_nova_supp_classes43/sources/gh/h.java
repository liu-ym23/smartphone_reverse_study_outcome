package gh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements am3.c<c> {
    public h() {
    }

    public static c a(am3.g r10) throws Exception {
        c r0 = new c();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L12;
        if (r11 != 1) goto L8;
        r0.action = am3.h.c(r10);
        goto L3
    L8:
        if (r11 != 2) goto L9;
        r0.uri = am3.h.c(r10);
        goto L3
    L9:
        am3.h.e(r10);
        goto L3
    L12:
        r10.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
