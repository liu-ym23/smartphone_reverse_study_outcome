package com.obric.miniapp.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o0 extends BitmapDrawable {
    public final int a;
    public final int b;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.b;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.a;
    }

    public o0(Resources r2, Bitmap r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "resources");
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        super(r2, r3);
        this.a = r4;
        this.b = r5;
    }
}
