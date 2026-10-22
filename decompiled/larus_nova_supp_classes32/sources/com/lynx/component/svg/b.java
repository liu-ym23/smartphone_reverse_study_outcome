package com.lynx.component.svg;

import android.graphics.Bitmap;
import com.lynx.serval.svg.SVGRender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements d.b {
    public final /* synthetic */ SVGRender.b a;

    @Override // com.lynx.component.svg.d.b
    public final void onFailed() {
        this.a.getClass();
    }

    public b(SVGRender.a r1) {
        this.a = r1;
    }

    @Override // com.lynx.component.svg.d.b
    public final void onSuccess(Bitmap r2) {
        ((SVGRender.a) this.a).a(r2);
    }
}
