package com.larus.common_ui.venus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w19.k;
import w19.l;
import w19.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJN\u0010I\u001a\u00020J2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010(\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007H\u0007J\u0018\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014J\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020J2\u0006\u0010Q\u001a\u00020OJ\u0010\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u00020OH\u0002J\u0010\u0010T\u001a\u00020J2\u0006\u0010S\u001a\u00020OH\u0002J\u0012\u0010U\u001a\u00020J2\b\u0010V\u001a\u0004\u0018\u00010/H\u0002J\b\u0010W\u001a\u00020/H\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0002J\u0018\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bF\u0010G¨\u0006]"}, d2 = {"Lcom/larus/common_ui/venus/ShapeRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shapeMode", "fillColor", "getFillColor", "()I", "setFillColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "cornerRadius", "getCornerRadius", "setCornerRadius", "topLeftRadius", "getTopLeftRadius", "setTopLeftRadius", "topRightRadius", "getTopRightRadius", "setTopRightRadius", "bottomLeftRadius", "getBottomLeftRadius", "setBottomLeftRadius", "bottomRightRadius", "getBottomRightRadius", "setBottomRightRadius", "cornerPosition", "startColor", "midColor", "endColor", "shadowOrientation", "withElevation", "shadowDx", "shadowDy", "shadowBlurRadius", "shadowRadii", "", "shadowColor", "excludeDx", "", "excludeLeft", "excludeTop", "excludeRight", "excludeBottom", "shadowPaint", "Landroid/graphics/Paint;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable$delegate", "Lkotlin/Lazy;", "shadowRoundRectDrawable", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "getShadowRoundRectDrawable", "()Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "shadowRoundRectDrawable$delegate", "shadowLayerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "getShadowLayerDrawable", "()Landroid/graphics/drawable/LayerDrawable;", "shadowLayerDrawable$delegate", "modifyAttribute", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "getShadowParam", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable$Params;", "applyShadowParam", "newParams", "copyShadowParamsToLocal", "params", "copyLocalParamsToShadow", "applyLocalParamsToShadow", "radii", "getCornerRadiusByPosition", "getPositionRadius", "position", "containsFlag", "flagSet", "flag", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShapeRelativeLayout extends RelativeLayout {
    public static final /* synthetic */ int C = 0;
    public final Lazy A;
    public final Lazy B;
    public final int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public float[] r;
    public final int s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final Paint y;
    public final Lazy z;

    public ShapeRelativeLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShapeRelativeLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final float[] getCornerRadiusByPosition() {
        float[] r1 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        int r2 = this.j;
        boolean r3 = true;
        if ((1 | r2) != r2) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        float r5 = c(1);
        r1[0] = r5;
        r1[1] = r5;
    L8:
        int r6 = this.j;
        if ((2 | r6) != r6) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        float r8 = c(2);
        r1[2] = r8;
        r1[3] = r8;
    L14:
        int r9 = this.j;
        if ((4 | r9) != r9) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == false) goto L20;
        float r11 = c(4);
        r1[4] = r11;
        r1[5] = r11;
    L20:
        int r12 = this.j;
        if ((8 | r12) == r12) goto L24;
        r3 = false;
    L24:
        if (r3 == false) goto L26;
        float r0 = c(8);
        r1[6] = r0;
        r1[7] = r0;
    L26:
        return r1;
    L17:
        r10 = false;
        goto L18
    L11:
        r7 = false;
        goto L12
    L5:
        r4 = false;
        goto L6
    }

    private final GradientDrawable getGradientDrawable() {
        return (GradientDrawable) this.z.getValue();
    }

    private final LayerDrawable getShadowLayerDrawable() {
        return (LayerDrawable) this.B.getValue();
    }

    private final a getShadowRoundRectDrawable() {
        return (a) this.A.getValue();
    }

    public final a.C0014a getShadowParam() {
        return getShadowRoundRectDrawable().a;
    }

    public final int getBottomLeftRadius() {
        return this.h;
    }

    public final int getBottomRightRadius() {
        return this.i;
    }

    public final int getCornerRadius() {
        return this.e;
    }

    public final int getFillColor() {
        return this.b;
    }

    public final int getStrokeColor() {
        return this.c;
    }

    public final int getStrokeWidth() {
        return this.d;
    }

    public final int getTopLeftRadius() {
        return this.f;
    }

    public final int getTopRightRadius() {
        return this.g;
    }

    public static LayerDrawable a(ShapeRelativeLayout r4) {
        return new LayerDrawable(new Drawable[]{r4.getShadowRoundRectDrawable(), r4.getGradientDrawable()});
    }

    public final void b(a.C0014a r2) {
        r2.c = this.o;
        r2.d = this.p;
        r2.g = this.s;
        r2.b = this.b;
        r2.e = this.q;
        r2.f = this.t;
        r2.h = this.u;
        r2.i = this.v;
        r2.j = this.w;
        r2.k = this.x;
    }

    public final int c(int r2) {
        int r0 = this.e;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (r2 != 1) goto L9;
        return this.f;
    L9:
        if (r2 != 2) goto L12;
        return this.g;
    L12:
        if (r2 != 8) goto L15;
        return this.h;
    L15:
        if (r2 == 4) goto L22;
        return 0;
    L22:
        return this.i;
    }

    public final void setBottomLeftRadius(int r1) {
        this.h = r1;
    }

    public final void setBottomRightRadius(int r1) {
        this.i = r1;
    }

    public final void setCornerRadius(int r1) {
        this.e = r1;
    }

    public final void setFillColor(int r1) {
        this.b = r1;
    }

    public final void setStrokeColor(int r1) {
        this.c = r1;
    }

    public final void setStrokeWidth(int r1) {
        this.d = r1;
    }

    public final void setTopLeftRadius(int r1) {
        this.f = r1;
    }

    public final void setTopRightRadius(int r1) {
        this.g = r1;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        super.onMeasure(r9, r10);
        float[] r11 = getCornerRadiusByPosition();
        GradientDrawable r12 = getGradientDrawable();
        int r0 = this.k;
        if (r0 == (-1)) goto L5;
    L8:
        int r6 = this.l;
        if (r6 == (-1)) goto L11;
        int[] r7 = {r0, r6, this.m};
    L12:
        r12.setColors(r7);
        switch(this.n) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L23;
        };
    L15:
        r12.setOrientation(GradientDrawable.Orientation.TL_BR);
        goto L23
    L16:
        r12.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        goto L23
    L17:
        r12.setOrientation(GradientDrawable.Orientation.BL_TR);
        goto L23
    L18:
        r12.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        goto L23
    L19:
        r12.setOrientation(GradientDrawable.Orientation.BR_TL);
        goto L23
    L20:
        r12.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        goto L23
    L21:
        r12.setOrientation(GradientDrawable.Orientation.TR_BL);
        goto L23
    L22:
        r12.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
    L23:
        int r1 = this.a;
        if (r1 == 0) goto L32;
        if (r1 == 1) goto L31;
        if (r1 == 2) goto L30;
        if (r1 != 3) goto L34;
        r12.setShape(3);
    L34:
        if (this.j != (-1)) goto L36;
        r12.setCornerRadius(this.e);
    L37:
        int r2 = this.c;
        if (r2 == 0) goto L41;
        r12.setStroke(this.d, r2);
    L41:
        if (this.q <= 0) goto L63;
        float[] r13 = this.r;
        if (r13 != null) goto L45;
    L49:
        this.r = r11;
    L50:
        float[] r14 = this.r;
        if (r14 == null) goto L54;
        r11 = r14;
    L54:
        a.C0014a r15 = getShadowRoundRectDrawable().a;
        b(r15);
        if (r11 != null) goto L57;
        r11 = getCornerRadiusByPosition();
    L57:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r15.a = r11;
        getShadowRoundRectDrawable().b(r15);
        getShadowRoundRectDrawable().a(0, getShadowLayerDrawable());
        getShadowRoundRectDrawable().a(1, getShadowLayerDrawable());
        if (Build.VERSION.SDK_INT < 28) goto L60;
    L62:
        setBackground(getShadowLayerDrawable());
        return;
    L60:
        if (getShadowRoundRectDrawable().getPaint() == null) goto L62;
        setLayerType(1, this.y);
        goto L62
    L45:
        if (r13.length != 8) goto L47;
        boolean r16 = true;
    L48:
        if (r16 == true) goto L50;
    L47:
        r16 = false;
        goto L48
    L63:
        setBackground(getGradientDrawable());
        return;
    L36:
        r12.setCornerRadii(r11);
        goto L37
    L30:
        r12.setShape(2);
        goto L34
    L31:
        r12.setShape(1);
        goto L34
    L32:
        r12.setShape(0);
        goto L34
    L11:
        r7 = new int[]{r0, this.m};
        goto L12
    L5:
        if (this.m != (-1)) goto L8;
        r12.setColor(this.b);
        goto L23
    }

    public ShapeRelativeLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.j = -1;
        this.y = new Paint(1);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.z = LazyKt.lazy(r0, new k());
        this.A = LazyKt.lazy(r0, new l(this));
        this.B = LazyKt.lazy(r0, new m(this));
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130972199, 2130972200, 2130972201, 2130972202, 2130972203, 2130972204, 2130972205, 2130972206, 2130972207, 2130972208, 2130972209, 2130972210, 2130972211, 2130972212, 2130972213, 2130972214, 2130972215, 2130972216, 2130972217, 2130972218, 2130972219, 2130972220, 2130972221, 2130972222, 2130972223, 2130972224});
        this.a = r7.getInt(19, 0);
        this.b = r7.getColor(10, -1);
        this.c = r7.getColor(21, 0);
        this.d = r7.getDimensionPixelSize(22, 0);
        this.e = r7.getDimensionPixelSize(3, 0);
        this.f = r7.getDimensionPixelSize(23, 0);
        this.g = r7.getDimensionPixelSize(24, 0);
        this.i = r7.getDimensionPixelSize(1, 0);
        this.h = r7.getDimensionPixelSize(0, 0);
        this.j = r7.getInt(2, -1);
        this.k = r7.getColor(20, -1);
        this.l = r7.getColor(11, -1);
        this.m = r7.getColor(4, -1);
        this.n = r7.getColor(12, 0);
        r7.getDimensionPixelSize(25, 0);
        this.s = r7.getColor(15, 0);
        this.t = r7.getBoolean(6, false);
        this.u = r7.getBoolean(7, false);
        this.w = r7.getBoolean(8, false);
        this.v = r7.getBoolean(9, false);
        this.x = r7.getBoolean(5, false);
        this.o = r7.getDimensionPixelSize(16, 0);
        this.p = r7.getDimensionPixelSize(17, 0);
        this.q = r7.getDimensionPixelSize(14, 0);
        r7.recycle();
    }

    public /* synthetic */ ShapeRelativeLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
