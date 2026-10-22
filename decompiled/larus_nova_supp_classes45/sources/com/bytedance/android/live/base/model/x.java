package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements am3.c<ImageModel> {
    public x() {
    }

    public static ImageModel a(am3.g r5) throws Exception {
        ImageModel r0 = new ImageModel();
        r0.setThreadSafe(false);
        r0.mUrls = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L17;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r5);
        switch(r3) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        r0.isAnimated = am3.h.a(r5);
        goto L3
    L9:
        r0.content = (ImageModel.Content) vh7.f.a(r5, ImageModel.Content.class);
        goto L3
    L10:
        r0.schema = am3.h.c(r5);
        goto L3
    L11:
        r0.imageType = r5.i();
        goto L3
    L12:
        r0.avgColor = am3.h.c(r5);
        goto L3
    L13:
        r0.width = (int) r5.j();
        goto L3
    L14:
        r0.height = (int) r5.j();
        goto L3
    L15:
        r0.mUri = am3.h.c(r5);
        goto L3
    L16:
        r0.mUrls.add(am3.h.c(r5));
        goto L3
    L7:
        am3.h.d(r4, r5);
        goto L3
    L17:
        r5.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
