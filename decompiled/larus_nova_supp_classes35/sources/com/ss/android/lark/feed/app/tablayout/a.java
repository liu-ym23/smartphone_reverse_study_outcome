package com.ss.android.lark.feed.app.tablayout;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a extends Drawable {
    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (getAlpha() >= 255) goto L5;
        return -3;
    L5:
        return -1;
    }

    public a() {
    }
}
