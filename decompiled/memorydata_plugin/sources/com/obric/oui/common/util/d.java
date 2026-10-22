package com.obric.oui.common.util;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0001\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"covertToTinted", "Landroid/graphics/drawable/Drawable;", "tintColor", "", "createTintBlackColorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "drawableToBitmap", "Landroid/graphics/Bitmap;", "scaleDrawable", "w", com.loc.o.g, "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class d {
    public static final ColorMatrixColorFilter a(int r5) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r5), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r5), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r5), 0.0f, 0.0f, 0.0f, (Color.alpha(r5) * 1.0f) / 255, 0.0f});
    }
}
