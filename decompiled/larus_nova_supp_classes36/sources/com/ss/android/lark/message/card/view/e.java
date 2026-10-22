package com.ss.android.lark.message.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.EncryptImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements rkb.g<EncryptImage, Drawable> {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ Context b;

    public e(ImageView r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // rkb.g
    public final boolean onLoadFailed(Exception r1, EncryptImage r2, Target<Drawable> r3, boolean r4) {
        this.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.a.setBackgroundColor(UIUtils.getColor(this.b, 2131103351));
        return false;
    }

    @Override // rkb.g
    public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r1, EncryptImage r2, Target<Drawable> r3, DataSource r4, boolean r5) {
        return false;
    }
}
