package com.larus.common_ui.widget.roundlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "cornerRadius", "", "usedWidth", "usedHeight", "rectF", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setCornerRadius", "radius", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomRoundImageView extends AppCompatImageView {
    public final Path a;
    public float b;
    public int c;
    public int d;
    public RectF e;

    public static final class a {
    }

    static {
    }

    public CustomRoundImageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomRoundImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        if (this.c == getWidth()) goto L6;
    L7:
        this.c = getWidth();     // Catch: Throwable -> L13
        this.d = getHeight();     // Catch: Throwable -> L13
        this.e = new RectF(0.0f, 0.0f, getWidth(), getHeight());     // Catch: Throwable -> L13
    L8:
        RectF r1 = this.e;     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        Path r2 = this.a;     // Catch: Throwable -> L13
        float r3 = this.b;     // Catch: Throwable -> L13
        r2.addRoundRect(r1, r3, r3, Path.Direction.CW);     // Catch: Throwable -> L13
        r5.clipPath(this.a);     // Catch: Throwable -> L13
    L11:
        super/*android.widget.ImageView*/.onDraw(r5);     // Catch: Throwable -> L13
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L22;
        FLogger.a.e("CustomRoundImageView", "on err = " + r7);
        return;
    L22:
        return;
    L6:
        if (this.d == getHeight()) goto L8;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCornerRadius(float r1) {
        this.b = r1;
        invalidate();
    }

    public CustomRoundImageView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new Path();
        if (r4 == null) goto L6;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130969698});
        this.b = r6.getDimensionPixelSize(0, 0);
        r6.recycle();
        return;
    }

    public /* synthetic */ CustomRoundImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
