package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/common_ui/view/DoraVolumeSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tickTexts", "", "", "[Ljava/lang/String;", "tickCount", "", "textPaint", "Landroid/graphics/Paint;", "tickPaint", "height", "tickRadius", "", "tickTextMarginTop", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraVolumeSeekBar extends AppCompatSeekBar {
    public final String[] a;
    public final int b;
    public final Paint c;
    public final Paint d;
    public final int e;
    public final float f;
    public final float g;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r0 = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int r1 = this.b;
        float r2 = r0 / r1;
        if (r1 < 0) goto L10;
        int r3 = 0;
    L5:
        float r4 = r3 * r2;
        r10.drawCircle(getPaddingStart() + r4, this.e / 2, this.f, this.d);
        String r5 = (String) ArraysKt.getOrNull(this.a, r3);
        if (r5 == null) goto L8;
        r10.drawText(r5, (r4 - (this.c.measureText(r5) / 2)) + getPaddingStart(), (this.e - this.c.getTextSize()) + this.g, this.c);
    L8:
        if (r3 == r1) goto L10;
        r3 = r3 + 1;
    L10:
        super.onDraw(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraVolumeSeekBar(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6);
        this.a = new String[]{"0", "5", "10"};
        this.b = 2;
        Paint r7 = new Paint();
        int r0 = j0.a;
        r7.setColor(j0.a(v19.c.b(2130972081, null, 2131103143)));
        r7.setTextSize(r5.getResources().getDimension(v19.c.b(2130972270, r5, 2131167610)));
        r7.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.c = r7;
        Paint r8 = new Paint();
        r8.setColor(j0.a(v19.c.b(2130972086, null, 2131103159)));
        this.d = r8;
        this.e = r5.getResources().getDimensionPixelSize(v19.c.b(2130971491, r5, 2131167352));
        this.f = r5.getResources().getDimension(v19.c.b(2130971254, r5, 2131166879));
        this.g = r5.getResources().getDimension(v19.c.b(2130971546, r5, 2131167462));
        Drawable r9 = ContextCompat.getDrawable(r5, v19.c.b(2130971129, r5, 2131240655));
        if (r9 == null) goto L5;
        setProgressDrawable(r9);
    L5:
        Drawable r10 = ContextCompat.getDrawable(r5, v19.c.b(2130971130, r5, 2131240658));
        if (r10 == null) goto L9;
        setThumb(r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super/*android.widget.SeekBar*/.onMeasure(r1, r2);
        setMeasuredDimension(r1, this.e);
    }
}
