package gh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements am3.c<a> {
    public f() {
    }

    public final Object decode(am3.g r10) throws Exception {
        a r0 = new a();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L21;
        switch(r11) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            default: goto L6;
        };
    L7:
        r0.depositInfo = am3.h.c(r10);
        goto L3
    L8:
        r0.bizId = r10.i();
        goto L3
    L9:
        r0.leftPaymentTime = r10.j();
        goto L3
    L10:
        r0.freightCollect = am3.h.c(r10);
        goto L3
    L11:
        r0.jumpUrl = am3.h.c(r10);
        goto L3
    L12:
        r0.buttonLabel = am3.h.c(r10);
        goto L3
    L13:
        r0.total = r10.j();
        goto L3
    L14:
        r0.freight = r10.j();
        goto L3
    L15:
        r0.charge = r10.j();
        goto L3
    L16:
        r0.price = r10.j();
        goto L3
    L17:
        r0.productPic = am3.h.c(r10);
        goto L3
    L18:
        r0.productName = am3.h.c(r10);
        goto L3
    L19:
        r0.productId = r10.j();
        goto L3
    L20:
        r0.title = am3.h.c(r10);
        goto L3
    L6:
        am3.h.e(r10);
        goto L3
    L21:
        r10.d(r1);
        return r0;
    }
}
