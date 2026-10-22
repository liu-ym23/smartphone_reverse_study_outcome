package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.q;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "", "r", "", "setRadius", "", "m", "Z", "getMeasureHeightUnspecified", "()Z", "setMeasureHeightUnspecified", "(Z)V", "measureHeightUnspecified", "", "l", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6470c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f6471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f6473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f6474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f6475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6477m;

    @JvmOverloads
    public RadiusLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public RadiusLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public RadiusLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6470c = true;
        this.f6474j = new RectF();
        this.f6475k = new Path();
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.ORadiusLayout, r12, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r14 = r13.getDimension(l.ORadiusLayout_oui_cornerRadius, 0.0f);
        float r15 = r13.getDimension(l.ORadiusLayout_oui_cornerRadiusLeftTop, r14);
        float r16 = r13.getDimension(l.ORadiusLayout_oui_cornerRadiusRightTop, r14);
        float r17 = r13.getDimension(l.ORadiusLayout_oui_cornerRadiusLeftBottom, r14);
        float r18 = r13.getDimension(l.ORadiusLayout_oui_cornerRadiusRightBottom, r14);
        int r19 = r13.getColor(l.ORadiusLayout_oui_radiusStrokeColor, ViewCompat.MEASURED_STATE_MASK);
        int r20 = r13.getDimensionPixelOffset(l.ORadiusLayout_oui_radiusStrokeWidth, 0);
        int r21 = r13.getDimensionPixelOffset(l.ORadiusLayout_oui_radiusStrokeDashWidth, 0);
        int r22 = r13.getDimensionPixelOffset(l.ORadiusLayout_oui_radiusStrokeDashGapWidth, 0);
        d(r15, r16, r17, r18);
        e(r19, r20, r21, r22);
        r13.recycle();
    }

    public /* synthetic */ RadiusLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void b(Canvas r10) {
        this.f6474j.set(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L11;
        this.f6475k.reset();
        q r12 = q.f11614e;
        Path r13 = this.f6475k;
        RectF r14 = this.f6474j;
        float[] r15 = this.f6473i;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
    L10:
        r12.b(r13, r14, r15, Path.Direction.CW);
        r10.clipPath(this.f6475k);
        return;
    L11:
        r10.clipRect(this.f6474j);
        return;
    L5:
        r11 = false;
        goto L6
    }

    private final void c(Canvas r10) {
        Paint r11 = this.f6471g;
        if (r11 == null) goto L15;
        this.f6474j.set(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L13;
        this.f6475k.reset();
        q r13 = q.f11614e;
        Path r14 = this.f6475k;
        RectF r15 = this.f6474j;
        float[] r16 = this.f6473i;
        if (r16 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
    L12:
        r13.b(r14, r15, r16, Path.Direction.CW);
        r10.drawPath(this.f6475k, r11);
        return;
    L13:
        r10.drawRect(this.f6474j, r11);
        return;
    L7:
        r12 = false;
        goto L8
    }

    public final void d(float r10, float r11, float r12, float r13) {
        this.f6473i = new float[]{r10, r10, r11, r11, r13, r13, r12, r12};
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        if (this.f6472h == true) goto L5;
        return;
    L5:
        if (this.f6470c == false) goto L9;
        c(r10);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        b(r10);
        super.draw(r10);
    }

    public final void e(int r10, int r11, int r12, int r13) {
        Paint r14 = new Paint();
        boolean r15 = true;
        r14.setAntiAlias(true);
        r14.setColor(r10);
        r14.setStyle(Paint.Style.STROKE);
        if (r12 == 0) goto L6;
        if (r13 == 0) goto L6;
        r14.setPathEffect(new DashPathEffect(new float[]{r12, r13}, 0.0f));
    L6:
        r14.setStrokeWidth(r11);
        this.f6471g = r14;
        if ((r10 & ViewCompat.MEASURED_STATE_MASK) == 0) goto L10;
        if (r11 == 0) goto L10;
    L11:
        this.f6472h = r15;
        invalidate();
        return;
    L10:
        r15 = false;
        goto L11
    }

    public final int getMaxHeight() {
        return this.f6476l;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.f6477m;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.f6477m == false) goto L9;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r12 = getMeasuredHeight();
        int r13 = this.f6476l;
        if (1 > r13) goto L13;
        if (r12 <= r13) goto L11;
        setMeasuredDimension(getMeasuredWidth(), this.f6476l);
        return;
    L11:
        return;
    L13:
        return;
    L9:
        super.onMeasure(r10, r11);
    }

    public final void setMaxHeight(int r10) {
        this.f6476l = r10;
    }

    public final void setMeasureHeightUnspecified(boolean r10) {
        this.f6477m = r10;
    }

    public final void setRadius(float r10) {
        this.f6473i = new float[]{r10, r10, r10, r10, r10, r10, r10, r10};
        invalidate();
    }
}
