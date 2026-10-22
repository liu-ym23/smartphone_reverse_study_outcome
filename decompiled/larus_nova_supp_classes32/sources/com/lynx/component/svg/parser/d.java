package com.lynx.component.svg.parser;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements com.lynx.component.svg.d.b {
    public final /* synthetic */ SVG.n a;
    public final /* synthetic */ PreserveAspectRatio b;
    public final /* synthetic */ e c;

    @Override // com.lynx.component.svg.d.b
    public final void onFailed() {
    }

    @Override // com.lynx.component.svg.d.b
    public final void onSuccess(Bitmap r4) {
        this.c.D(this.a, this.b, r4);
    }

    public d(e r1, SVG.n r2, PreserveAspectRatio r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
