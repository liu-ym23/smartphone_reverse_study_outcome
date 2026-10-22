package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedNinePatchDrawable extends RoundedDrawable {
    public RoundedNinePatchDrawable(NinePatchDrawable r5) {
        super(r5);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        FrescoSystrace.a().getClass();
        if (this.f7874b == false) goto L5;
    L11:
        e();
        c();
        r5.clipPath(this.e);
        super.draw(r5);
        FrescoSystrace.a().getClass();
        return;
    L5:
        if (this.f7875c == true) goto L11;
        if (this.d > 0.0f) goto L11;
        super.draw(r5);
        FrescoSystrace.a().getClass();
    }
}
