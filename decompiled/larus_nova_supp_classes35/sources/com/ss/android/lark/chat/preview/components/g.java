package com.ss.android.lark.chat.preview.components;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends SimpleTarget<Drawable> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ ImageView c;

    public final void onLoadFailed(Drawable r3) {
        super.onLoadFailed(r3);
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.c.setImageDrawable(r3);
    }

    public final void onLoadStarted(Drawable r3) {
        if (this.a == false) goto L5;
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.c.setImageDrawable(r3);
        return;
    L5:
        if (this.b == true) goto L7;
    L8:
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.c.setImageDrawable(r3);
        return;
    L7:
        if (this.c.getDrawable() == null) goto L8;
    }

    public final void onResourceReady(Object r3) {
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView r0 = this.c;
        r0.setImageDrawable((Drawable) r3);
    }

    public g(boolean r1, boolean r2, ImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
