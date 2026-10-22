package com.obric.oui.dialog.alert.view;

import a.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.o;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pp.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0011R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "suppress", "", "setSuppressChildMeasureAndLayout", "(Z)V", "color", "setBackgroundColor", "(I)V", "", "r", "setRadius", "(F)V", "h", "I", "getMaxHeight", "()I", "setMaxHeight", "maxHeight", "i", "Z", "getMeasureHeightUnspecified", "()Z", "setMeasureHeightUnspecified", "measureHeightUnspecified", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f13081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13082c;
    public float[] d;
    public final RectF e;
    public final Path f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f13086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f13087l;

    @JvmOverloads
    public RadiusLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a(float r5, float r10, float r11, float r12) {
        this.d = new float[]{r5, r5, r10, r10, r12, r12, r11, r11};
        c();
        invalidate();
    }

    public final void b(int r5, int r10) {
        Paint r11 = new Paint();
        boolean r12 = true;
        r11.setAntiAlias(true);
        r11.setColor(r5);
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeWidth(r10);
        this.f13081b = r11;
        if ((r5 & ViewCompat.MEASURED_STATE_MASK) == 0) goto L6;
        if (r10 == 0) goto L6;
    L7:
        this.f13082c = r12;
        invalidate();
        return;
    L6:
        r12 = false;
        goto L7
    }

    public final void c() {
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        float[] r10 = this.d;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r10 = null;
    L5:
        r5.setCornerRadii(r10);
        r5.setColor(ColorStateList.valueOf(this.g));
        setBackground(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        boolean r5 = this.f13086k;
        Path r11 = this.f;
        RectF r12 = this.e;
        float[] r13 = null;
        if (r5 == false) goto L8;
        r12.set(0.0f, 0.0f, getWidth(), getHeight());
        r12.inset(0.0f, this.f13087l);
        r11.reset();
        float[] r14 = this.d;
        if (r14 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r14 = null;
    L7:
        r11.addRoundRect(r12, r14, Path.Direction.CW);
        r10.clipPath(r11);
    L8:
        super.dispatchDraw(r10);
        if (this.f13082c == true) goto L11;
        return;
    L11:
        if (this.f13080a == false) goto L34;
        Paint r15 = this.f13081b;
        if (r15 == null) goto L35;
        r12.set(0.0f, 0.0f, getWidth(), getHeight());
        r11.reset();
        b r16 = o.f12520a;
        float[] r17 = this.d;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
    L19:
        Path.Direction r18 = Path.Direction.CW;
        Intrinsics.checkNotNullParameter(r11, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r12, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r13, "radii");
        Intrinsics.checkNotNullParameter(r18, "dir");
        if (r13.length == 0) goto L28;
        float r19 = r13[0];
        int r20 = r13.length;
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L28;
        if (r13[r21] != r19) goto L27;
        r21 = r21 + 1;
        goto L23
    L27:
        r11.addRoundRect(r12, r13, r18);
    L29:
        r10.drawPath(r11, r15);
        return;
    L28:
        r11.addPath(o.a(r12, r13[0]));
        goto L29
    L18:
        r13 = r17;
        goto L19
    L35:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.draw(r5);
    }

    public final int getMaxHeight() {
        return this.f13083h;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.f13084i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (this.f13085j == false) goto L5;
        return;
    L5:
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.f13085j == false) goto L14;
        int r11 = View.MeasureSpec.getMode(r5);
        int r12 = View.MeasureSpec.getSize(r5);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r10);
        if (r11 == Integer.MIN_VALUE) goto L8;
        if (r11 == 1073741824) goto L8;
        r12 = RangesKt.coerceAtLeast(getMeasuredWidth(), getSuggestedMinimumWidth());
    L8:
        if (r13 == Integer.MIN_VALUE) goto L11;
        if (r13 == 1073741824) goto L11;
        r14 = RangesKt.coerceAtLeast(getMeasuredHeight(), getSuggestedMinimumHeight());
    L11:
        setMeasuredDimension(r12, r14);
        return;
    L14:
        if (this.f13084i == false) goto L19;
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r15 = getMeasuredHeight();
        int r16 = this.f13083h;
        if (1 > r16) goto L21;
        if (r16 >= r15) goto L22;
        setMeasuredDimension(getMeasuredWidth(), this.f13083h);
        return;
    L22:
        return;
    L21:
        return;
    L19:
        super.onMeasure(r5, r10);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        super.setBackgroundColor(r5);
        this.g = r5;
        c();
    }

    public final void setMaxHeight(int r5) {
        this.f13083h = r5;
    }

    public final void setMeasureHeightUnspecified(boolean r5) {
        this.f13084i = r5;
    }

    public final void setRadius(float r5) {
        a(r5, r5, r5, r5);
    }

    public final void setSuppressChildMeasureAndLayout(boolean r5) {
        if (this.f13085j != r5) goto L5;
        return;
    L5:
        this.f13085j = r5;
        if (r5 == true) goto L9;
        requestLayout();
        invalidate();
        return;
    }

    @JvmOverloads
    public RadiusLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ RadiusLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public RadiusLayout(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        this.f13080a = true;
        this.e = new RectF();
        this.f = new Path();
        this.f13086k = a.w(this);
        this.f13087l = 3.0f;
        boolean r5 = false;
        if ((getBackground() instanceof ColorDrawable) == false) goto L9;
        Drawable r10 = getBackground();
        if (r10 == null) goto L8;
        int r11 = ((ColorDrawable) r10).getColor();
    L10:
        this.g = r11;
        TypedArray r16 = r13.obtainStyledAttributes(r14, R$styleable.ORadiusLayout, r15, 0);
        float r17 = r16.getDimension(R$styleable.ORadiusLayout_oui_cornerRadius, 0.0f);
        float r12 = r16.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusLeftTop, r17);
        float r18 = r16.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusRightTop, r17);
        float r19 = r16.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusLeftBottom, r17);
        float r20 = r16.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusRightBottom, r17);
        int r21 = r16.getColor(R$styleable.ORadiusLayout_oui_radiusStrokeColor, ViewCompat.MEASURED_STATE_MASK);
        int r22 = r16.getDimensionPixelOffset(R$styleable.ORadiusLayout_oui_radiusStrokeWidth, 0);
        int r23 = r16.getDimensionPixelOffset(R$styleable.ORadiusLayout_oui_radiusStrokeDashWidth, 0);
        int r110 = r16.getDimensionPixelOffset(R$styleable.ORadiusLayout_oui_radiusStrokeDashGapWidth, 0);
        if (r17 != 0.0f) goto L13;
        a(r12, r18, r19, r20);
    L14:
        Paint r111 = new Paint();
        r111.setAntiAlias(true);
        r111.setColor(r21);
        r111.setStyle(Paint.Style.STROKE);
        if (r23 == 0) goto L18;
        if (r110 == 0) goto L18;
        r111.setPathEffect(new DashPathEffect(new float[]{r23, r110}, 0.0f));
    L18:
        r111.setStrokeWidth(r22);
        this.f13081b = r111;
        if ((r21 & ViewCompat.MEASURED_STATE_MASK) == 0) goto L22;
        if (r22 == 0) goto L22;
        r5 = true;
    L22:
        this.f13082c = r5;
        invalidate();
        r16.recycle();
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
        return;
    L13:
        setRadius(r17);
        goto L14
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L9:
        r11 = 0;
        goto L10
    }
}
