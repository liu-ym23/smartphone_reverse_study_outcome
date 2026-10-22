package com.larus.bmhome.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J(\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0014J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020#H\u0014J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\nJ\b\u00101\u001a\u00020#H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020#H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/bmhome/view/ShadowChatConstraintLayout;", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shadowPaint", "Landroid/graphics/Paint;", "shadowBitmapPaint", "shadowClearPaint", "shadowRect", "Landroid/graphics/RectF;", "clipPath", "Landroid/graphics/Path;", "topShadowRect", "topShadowPath", "cornerRadii", "", "shadowBitmap", "Landroid/graphics/Bitmap;", "cachedShadowColor", "shadowBitmapDirty", "", "outwardShadowAlpha", "topCornerRadiusPx", "shadowBlurRadiusPx", "shadowBitmapTopPaddingPx", "topShadowContentHeightPx", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "setOutwardShadowAlpha", "alpha", "updateShadowPath", "ensureShadowBitmap", "shadowColor", "resolveShadowFillColor", "recycleShadowBitmap", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowChatConstraintLayout extends ChatConstraintLayout {
    public static final /* synthetic */ int k0 = 0;
    public final Paint I;
    public final Paint J;
    public final Paint K;
    public final RectF L;
    public final Path M;
    public final RectF N;
    public final Path O;
    public final float[] P;
    public Bitmap Q;
    public int R;
    public boolean S;
    public int T;
    public final int U;
    public final int V;
    public final int W;

    public static final class a {
    }

    static {
    }

    public final void onDetachedFromWindow() {
        Bitmap r0 = this.Q;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.Q = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowChatConstraintLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.I = r9;
        Paint r10 = new Paint(1);
        r10.setFilterBitmap(true);
        this.J = r10;
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.K = r11;
        this.L = new RectF();
        this.M = new Path();
        this.N = new RectF();
        this.O = new Path();
        this.P = new float[]{c7.b(24), c7.b(24), c7.b(24), c7.b(24), 0.0f, 0.0f, 0.0f, 0.0f};
        this.S = true;
        this.T = 255;
        int r12 = c7.b(24);
        int r0 = c7.b(8);
        this.U = r0;
        this.V = Math.max(c7.b(8), r0 + c7.b(1));
        this.W = r12 + c7.b(1);
        setWillNotDraw(false);
        setBackgroundColor(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        int r0 = ContextCompat.getColor(getContext(), v19.c.b(2130970529, getContext(), 2131102529));
        if (getWidth() > 0) goto L5;
    L18:
        Bitmap r1 = this.Q;
        if (r1 == null) goto L21;
        this.J.setAlpha(this.T);
        r9.drawBitmap(r1, 0.0f, -this.V, this.J);
    L21:
        int r2 = r9.save();
        r9.clipPath(this.M);
        super/*android.view.ViewGroup*/.draw(r9);
        r9.restoreToCount(r2);
        return;
    L5:
        if (getHeight() <= 0) goto L18;
        if (this.S == false) goto L10;
    L14:
        Bitmap r3 = this.Q;
        if (r3 == null) goto L17;
        r3.recycle();
    L17:
        this.Q = null;
        Bitmap r4 = Bitmap.createBitmap(getWidth(), this.V + Math.min(getHeight(), this.W), Bitmap.Config.ARGB_8888);
        Canvas r5 = new Canvas(r4);
        r5.translate(0.0f, this.V);
        this.I.setColor(r0);
        this.I.setShadowLayer(this.U, 0.0f, 0.0f, Color.argb(26, 0, 0, 0));
        r5.drawPath(this.O, this.I);
        this.I.clearShadowLayer();
        r5.drawPath(this.O, this.K);
        this.Q = r4;
        this.R = r0;
        this.S = false;
        goto L18
    L10:
        if (this.Q == null) goto L14;
        if (this.R != r0) goto L14;
        goto L14
    }

    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.S = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOutwardShadowAlpha(int r3) {
        int r4 = RangesKt.coerceIn(r3, 0, 255);
        if (this.T != r4) goto L5;
        return;
    L5:
        this.T = r4;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowChatConstraintLayout(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.I = r9;
        Paint r10 = new Paint(1);
        r10.setFilterBitmap(true);
        this.J = r10;
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.K = r11;
        this.L = new RectF();
        this.M = new Path();
        this.N = new RectF();
        this.O = new Path();
        this.P = new float[]{c7.b(24), c7.b(24), c7.b(24), c7.b(24), 0.0f, 0.0f, 0.0f, 0.0f};
        this.S = true;
        this.T = 255;
        int r12 = c7.b(24);
        int r13 = c7.b(8);
        this.U = r13;
        this.V = Math.max(c7.b(8), r13 + c7.b(1));
        this.W = r12 + c7.b(1);
        setWillNotDraw(false);
        setBackgroundColor(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowChatConstraintLayout(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r8);
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.I = r9;
        Paint r10 = new Paint(1);
        r10.setFilterBitmap(true);
        this.J = r10;
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.K = r11;
        this.L = new RectF();
        this.M = new Path();
        this.N = new RectF();
        this.O = new Path();
        this.P = new float[]{c7.b(24), c7.b(24), c7.b(24), c7.b(24), 0.0f, 0.0f, 0.0f, 0.0f};
        this.S = true;
        this.T = 255;
        int r12 = c7.b(24);
        int r13 = c7.b(8);
        this.U = r13;
        this.V = Math.max(c7.b(8), r13 + c7.b(1));
        this.W = r12 + c7.b(1);
        setWillNotDraw(false);
        setBackgroundColor(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        super/*android.view.ViewGroup*/.onSizeChanged(r4, r5, r6, r7);
        this.L.set(c7.b(2), c7.b(1), getWidth() - c7.b(2), getHeight());
        this.M.reset();
        this.M.addRoundRect(this.L, this.P, Path.Direction.CW);
        RectF r8 = this.N;
        RectF r9 = this.L;
        float r10 = r9.left;
        float r0 = r9.top;
        r8.set(r10, r0, r9.right, Math.min(r9.bottom, this.W + r0));
        this.O.reset();
        this.O.addRoundRect(this.N, this.P, Path.Direction.CW);
        this.S = true;
    }
}
