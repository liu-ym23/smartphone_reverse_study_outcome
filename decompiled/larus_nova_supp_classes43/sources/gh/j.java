package gh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements am3.c<e> {
    public j() {
    }

    public final Object decode(am3.g r10) throws Exception {
        e r0 = new e();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L15;
        if (r11 != 1) goto L8;
        r0.msgType = Integer.valueOf(r10.i());
        goto L3
    L8:
        if (r11 != 2) goto L10;
        r0.shopPopControl = h.a(r10);
        goto L3
    L10:
        if (r11 != 3) goto L11;
        r0.shopPopData = i.a(r10);
        goto L3
    L11:
        am3.h.e(r10);
        goto L3
    L15:
        r10.d(r1);
        return r0;
    }
}
