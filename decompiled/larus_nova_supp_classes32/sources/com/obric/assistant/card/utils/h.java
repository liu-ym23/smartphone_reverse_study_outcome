package com.obric.assistant.card.utils;

import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final void a(SimpleDraweeView r2, String r3, String r4) {
        if (r2 == null) goto L4;
        final DraweeController r0 = r2.getController();
    L5:
        ImageLoaderKt.y(r2, r3, r4, new g(r0), 4);
        return;
    L4:
        r0 = null;
        goto L5
    }
}
