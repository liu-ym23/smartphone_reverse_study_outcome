package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends SimpleTarget<Drawable> {
    public final /* synthetic */ String a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ Drawable c;

    public final void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        Log.e("MarkdownImageLoader", "movable image load failed, " + this.a);
        this.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.b.setImageDrawable(this.c);
    }

    public final void onResourceReady(Object r2) {
        Drawable r3 = (Drawable) r2;
        super.onResourceReady(r3);
        this.b.setImageDrawable(r3);
    }

    public c(String r1, LKUIRoundedImageView2 r2, Drawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
