package com.lynx.component.svg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SvgImageView extends AppCompatImageView {
    public SvgImageView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageDrawable(Drawable r3) {
        ViewCompat.setLayerType(this, 1, null);
        super.setImageDrawable(r3);
    }
}
