package com.larksuite.component.card.component.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.tasm.base.TraceEvent;
import idb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UniversalCardRoundedImageView extends LKUIRoundedImageView2 {
    public final Rect a;
    public Paint b;
    public Paint c;
    public Rect d;
    public String e;
    public float f;
    public int g;
    public a h;

    public interface a {
        void I(int r1, int r2);
    }

    public UniversalCardRoundedImageView(Context r1) {
        super(r1);
        this.a = new Rect();
        this.g = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.ui.imageview.LKUIRoundedImageView2
    public final void onDraw(Canvas r7) {
        TraceEvent.beginSection("UniversalCardRoundedImageView.onDraw");
        super.onDraw(r7);
        if (this.d == null) goto L5;
        r7.drawRect(this.a, this.c);
        String r1 = this.e;
        float r2 = (getWidth() - this.d.width()) / 2.0f;
        Rect r4 = this.a;
        r7.drawText(r1, r2, (r4.bottom - (r4.height() / 2.0f)) + this.f, this.b);
    L5:
        TraceEvent.endSection("UniversalCardRoundedImageView.onDraw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageDrawable(Drawable r4) {
        super.setImageDrawable(r4);
        if ((!f.a().isCurrentEnable("universal_card.gif_scale_fix_disable")) == false) goto L13;
        Matrix r0 = new Matrix();
        if ((r4 instanceof GifDrawable) == true) goto L7;
    L11:
        setImageMatrix(r0);
        return;
    L7:
        if (this.g == 0) goto L11;
        int r1 = r4.getIntrinsicWidth();
        int r2 = this.g;
        if (r1 == r2) goto L11;
        float r3 = r2 / r4.getIntrinsicWidth();
        r0.setScale(r3, r3);
        goto L11
    }

    public void setOnSizeChangedListener(a r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(int r4, int r5) {
        if (this.d == null) goto L6;
        Rect r0 = this.a;
        r0.left = 0;
        r0.top = r5 - UIUtils.dp2px(getContext(), 16.0f);
        Rect r1 = this.a;
        r1.right = r4;
        r1.bottom = r5;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        j(r1, r2);
        a r5 = this.h;
        if (r5 == null) goto L6;
        r5.I(r1, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        TraceEvent.beginSection("UniversalCardRoundedImageView.onLayout");
        super/*android.widget.ImageView*/.onLayout(r2, r3, r4, r5, r6);
        TraceEvent.endSection("UniversalCardRoundedImageView.onLayout");
    }
}
