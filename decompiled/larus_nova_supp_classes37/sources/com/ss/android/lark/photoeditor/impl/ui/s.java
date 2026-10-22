package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.ss.android.lark.image.api.SimpleTarget;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s extends SimpleTarget<Bitmap> {
    public final /* synthetic */ File a;
    public final /* synthetic */ r b;

    public final void onResourceReady(Object r6) {
        Bitmap r7 = (Bitmap) r6;
        r r0 = this.b;
        r0.getClass();
        File r1 = this.a;
        if (p0c.a.a().isFeatureGatingEnable("lark.im.autoblur") == false) goto L5;
        List<RectF> r2 = r0.e;
    L6:
        ofc.b.a r3 = new ofc.b.a();
        r3.a = r0.a;
        r3.e = r0.i;
        r3.b = r7;
        r3.f = new x();
        r3.l = new w();
        r3.j = r2;
        r3.k = p0c.a.a().isFeatureGatingEnable("lark.im.message-to-image");
        r3.g = new v(r0);
        ofc.b r4 = r3.a();
        r4.b(new u(r0, r7, r1));
        r0.j = r4;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public s(r r1, File r2) {
        this.b = r1;
        this.a = r2;
    }
}
