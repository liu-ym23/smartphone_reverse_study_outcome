package com.ss.android.lark.chat.preview.components.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.BorderProperty;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends BitmapDrawable {
    public final BitmapDrawable a;
    public final BorderProperty b;
    public final int c;
    public final int d;
    public final RectF e;
    public final RectF f;
    public final RectF g;
    public final Path h;
    public final Paint i;
    public final int j;
    public final int k;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        if (getBitmap().isRecycled() == true) goto L36;
        this.e.set(0.0f, 0.0f, this.c, this.d);
        float r0 = (this.j * 1.0f) / 2;
        this.g.set(this.e);
        this.g.inset(r0, r0);
        this.f.set(this.e);
        RectF r1 = this.f;
        float r2 = this.j;
        r1.inset(r2, r2);
        BitmapDrawable r3 = this.a;
        if ((r3 instanceof BitmapDrawable) == false) goto L34;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r4 = r3.getBitmap();
        if (r4 != null) goto L10;
    L33:
        Log.i("ImageBorderUtils", "bitmap recycled");
        goto L34
    L10:
        if (r4.isRecycled() == true) goto L33;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Object r5 = com.ss.android.lark.image.utils.e.a(this.a, "mBlendModeFilter");
        if (r5 != null) goto L17;
    L29:
        boolean r6 = false;
    L30:
        this.i.setAntiAlias(true);
        int r7 = r9.getSaveCount();
        r9.save();
        this.h.reset();
        Path r8 = this.h;
        RectF r10 = this.f;
        float r11 = this.k;
        r8.addRoundRect(r10, r11, r11, Path.Direction.CW);
        r9.clipPath(this.h);
        r9.drawBitmap(r4, null, this.e, this.a.getPaint());
        r9.restoreToCount(r7);
        if (r6 == false) goto L34;
        getPaint().setColorFilter(null);
        goto L34
    L17:
        if ((r5 instanceof BlendModeColorFilter) == false) goto L29;
        if (this.a.getPaint().getColorFilter() != null) goto L29;
        this.a.getPaint().setColorFilter((ColorFilter) r5);
    L28:
        r6 = true;
        goto L30
    L21:
        Object r12 = com.ss.android.lark.image.utils.e.a(this.a, "mTintFilter");
        if (r12 == null) goto L29;
        if ((r12 instanceof PorterDuffColorFilter) == false) goto L29;
        if (this.a.getPaint().getColorFilter() != null) goto L29;
        this.a.getPaint().setColorFilter((ColorFilter) r12);
    L34:
        this.i.setAntiAlias(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setColor(this.b.getBorderColor());
        this.i.setStrokeWidth(this.b.getBorderWidthPx());
        this.h.reset();
        Path r13 = this.h;
        RectF r14 = this.g;
        float r15 = this.k;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        r9.drawPath(this.h, this.i);
        return;
    }

    public e(Resources r2, BitmapDrawable r3, BorderProperty r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, SRStrategy.MEDIAINFO_KEY_RESOLUTION);
        Intrinsics.checkNotNullParameter(r3, "srcDrawable");
        Intrinsics.checkNotNullParameter(r4, "borderProperty");
        super(r2, r3.getBitmap());
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new Path();
        this.i = new Paint();
        this.j = r4.getBorderWidthPx();
        this.k = r4.getBorderRadiusPx();
    }
}
