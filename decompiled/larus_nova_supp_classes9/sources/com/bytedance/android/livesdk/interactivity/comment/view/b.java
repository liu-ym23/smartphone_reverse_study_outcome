package com.bytedance.android.livesdk.interactivity.comment.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends NinePatchDrawable implements c {
    public final Rect a;
    public int b;
    public int c;

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void a() {
        this.c = -1;
        invalidateSelf();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final Drawable getDrawable() {
        return this;
    }

    @Override // android.graphics.drawable.NinePatchDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void b(int r1) {
        this.c = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.NinePatchDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        r4.save();
        this.a.set(getBounds());
        int r0 = this.c;
        if (r0 < 0) goto L5;
        Rect r1 = this.a;
        this.b = r1.right;
        r1.right = r1.left + r0;
        setBounds(r1);
    L5:
        super.draw(r4);
        r4.restore();
        Rect r5 = getBounds();
        r5.right = this.b;
    }

    @Override // android.graphics.drawable.NinePatchDrawable, android.graphics.drawable.Drawable, com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void setAlpha(int r2) {
        getPaint().setAlpha(r2);
        invalidateSelf();
    }

    public b(Bitmap r8, byte[] r9, Rect r10) {
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        Intrinsics.checkNotNullParameter(r9, "chunk");
        Intrinsics.checkNotNullParameter(r10, "padding");
        super(s1.getResources(), r8, r9, r10, null);
        this.a = new Rect();
        this.c = -1;
    }
}
