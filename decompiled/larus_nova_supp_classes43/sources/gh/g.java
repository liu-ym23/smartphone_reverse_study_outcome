package gh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements am3.c<b> {
    public g() {
    }

    public static b a(am3.g r10) throws Exception {
        b r0 = new b();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L9;
        if (r11 != 1) goto L7;
        r0.promotionId = am3.h.c(r10);
        goto L3
    L7:
        am3.h.e(r10);
        goto L3
    L9:
        r10.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
