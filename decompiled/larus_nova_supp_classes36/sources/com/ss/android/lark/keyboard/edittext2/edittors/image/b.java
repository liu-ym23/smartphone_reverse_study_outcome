package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends BitmapDrawable {
    public final /* synthetic */ UrlImageSpanView a;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        r8.drawRect(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.a.c);
        super.draw(r8);
    }

    public b(Bitmap r1, UrlImageSpanView r2, Resources r3) {
        this.a = r2;
        super(r3, r1);
    }
}
