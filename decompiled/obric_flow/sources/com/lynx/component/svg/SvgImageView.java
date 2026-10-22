package com.lynx.component.svg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class SvgImageView extends AppCompatImageView {
    public SvgImageView(Context r5) {
        super(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r5) {
        ViewCompat.setLayerType(this, 1, null);
        super.setImageDrawable(r5);
    }
}
