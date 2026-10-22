package com.bytedance.android.live.base.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w implements am3.c<ImageModel.Content> {
    public w() {
    }

    public final Object decode(am3.g r7) throws Exception {
        ImageModel.Content r0 = new ImageModel.Content();
        r0.setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L18;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        r0.name = am3.h.c(r7);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.fontColor = am3.h.c(r7);
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.level = r7.j();
        goto L3
    L12:
        if (r3 != 4) goto L13;
        r0.accessibilityText = am3.h.c(r7);
        goto L3
    L13:
        am3.h.d(r4, r7);
        goto L3
    L18:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
