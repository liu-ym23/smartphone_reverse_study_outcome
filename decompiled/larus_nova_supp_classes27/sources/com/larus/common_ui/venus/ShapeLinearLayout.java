package com.larus.common_ui.venus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w19.h;
import w19.i;
import w19.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 x2\u00020\u0001:\u0002xyB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJN\u0010S\u001a\u00020T2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010(\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007H\u0007J\u0018\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0014J\u0010\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020/H\u0002J\u0018\u0010Z\u001a\u00020T2\u0006\u0010Y\u001a\u00020/2\u0006\u0010[\u001a\u000202H\u0002J\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020]J(\u0010`\u001a\u00020T2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0016J(\u0010e\u001a\u00020T2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0016J\u0010\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020\u0007H\u0016J\u0010\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020]H\u0002J\u0010\u0010l\u001a\u00020T2\u0006\u0010k\u001a\u00020]H\u0002J\u0012\u0010m\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010/H\u0002J\b\u0010n\u001a\u000202H\u0002J\b\u0010o\u001a\u00020TH\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020\u0007H\u0002J\b\u0010r\u001a\u00020/H\u0002J\u0010\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0007H\u0002J\u0018\u0010u\u001a\u0002022\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010H\u001a\u0004\bP\u0010Q¨\u0006z"}, d2 = {"Lcom/larus/common_ui/venus/ShapeLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shapeMode", "fillColor", "getFillColor", "()I", "setFillColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "cornerRadius", "getCornerRadius", "setCornerRadius", "topLeftRadius", "getTopLeftRadius", "setTopLeftRadius", "topRightRadius", "getTopRightRadius", "setTopRightRadius", "bottomLeftRadius", "getBottomLeftRadius", "setBottomLeftRadius", "bottomRightRadius", "getBottomRightRadius", "setBottomRightRadius", "cornerPosition", "startColor", "midColor", "endColor", "shadowOrientation", "withElevation", "shadowDx", "shadowDy", "shadowBlurRadius", "shadowRadii", "", "shadowLayoutMode", "applyingShadowPadding", "", "applyingShadowBackground", "contentPaddingLeft", "contentPaddingTop", "contentPaddingRight", "contentPaddingBottom", "contentPaddingStart", "contentPaddingEnd", "contentPaddingIsRelative", "shadowColor", "excludeDx", "excludeLeft", "excludeTop", "excludeRight", "excludeBottom", "shadowPaint", "Landroid/graphics/Paint;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable$delegate", "Lkotlin/Lazy;", "shadowRoundRectDrawable", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "getShadowRoundRectDrawable", "()Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "shadowRoundRectDrawable$delegate", "shadowLayerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "getShadowLayerDrawable", "()Landroid/graphics/drawable/LayerDrawable;", "shadowLayerDrawable$delegate", "modifyAttribute", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "configureShapeDrawable", "radii", "applyShadowOrShapeBackground", "updateContentBoxPadding", "getShadowParam", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable$Params;", "applyShadowParam", "newParams", "setPadding", "left", "top", "right", "bottom", "setPaddingRelative", "start", "end", "onRtlPropertiesChanged", "layoutDirection", "copyShadowParamsToLocal", "params", "copyLocalParamsToShadow", "applyLocalParamsToShadow", "applyContentBoxPaddingIfNeed", "updateAbsoluteContentHorizontalPadding", "resolvedContentPaddingLeft", "resolvedContentPaddingRight", "getCornerRadiusByPosition", "getPositionRadius", "position", "containsFlag", "flagSet", "flag", "Companion", "NoPaddingLayerDrawable", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShapeLinearLayout extends LinearLayout {
    public static final /* synthetic */ int M = 0;
    public int A;
    public boolean B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final Paint I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final int l;
    public int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public float[] r;
    public final int s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b extends LayerDrawable {
        public b(Drawable[] r2) {
            Intrinsics.checkNotNullParameter(r2, "layers");
            super(r2);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public final boolean getPadding(Rect r2) {
            Intrinsics.checkNotNullParameter(r2, "padding");
            r2.setEmpty();
            return false;
        }
    }

    static {
    }

    public ShapeLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShapeLinearLayout(Context r3, AttributeSet r4) {
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
        float r5 = g(1);
        r1[0] = r5;
        r1[1] = r5;
    L8:
        int r6 = this.j;
        if ((2 | r6) != r6) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        float r8 = g(2);
        r1[2] = r8;
        r1[3] = r8;
    L14:
        int r9 = this.j;
        if ((4 | r9) != r9) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == false) goto L20;
        float r11 = g(4);
        r1[4] = r11;
        r1[5] = r11;
    L20:
        int r12 = this.j;
        if ((8 | r12) == r12) goto L24;
        r3 = false;
    L24:
        if (r3 == false) goto L26;
        float r0 = g(8);
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
        return (GradientDrawable) this.J.getValue();
    }

    private final LayerDrawable getShadowLayerDrawable() {
        return (LayerDrawable) this.L.getValue();
    }

    private final com.larus.common_ui.venus.a getShadowRoundRectDrawable() {
        return (com.larus.common_ui.venus.a) this.K.getValue();
    }

    public final boolean b() {
        if (this.s == 1) goto L5;
    L26:
        return false;
    L5:
        if (this.q <= 0) goto L26;
        this.t = true;
    L23:
        th = move-exception;
        this.t = false;
        throw th;
    L9:
        if (this.B == true) goto L11;
    L13:
        int r0 = this.v;     // Catch: Throwable -> L23
    L14:
        int r1 = r0 + ((int) getShadowRoundRectDrawable().b);     // Catch: Throwable -> L23
        int r3 = this.w + ((int) getShadowRoundRectDrawable().d);     // Catch: Throwable -> L23
        if (this.B == true) goto L17;
    L19:
        int r4 = this.x;     // Catch: Throwable -> L23
    L20:
        super.setPadding(r1, r3, r4 + ((int) getShadowRoundRectDrawable().c), this.y + ((int) getShadowRoundRectDrawable().e));     // Catch: Throwable -> L23
        this.t = false;
        return true;
    L17:
        if (getLayoutDirection() != 1) goto L19;
        r4 = this.z;     // Catch: Throwable -> L23
        goto L20
    L11:
        if (getLayoutDirection() != 1) goto L13;
        r0 = this.A;     // Catch: Throwable -> L23
        goto L14
    }

    public final com.larus.common_ui.venus.a.C0014a getShadowParam() {
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

    public static LayerDrawable a(ShapeLinearLayout r5) {
        if (r5.s != 1) goto L6;
        return new b(new Drawable[]{r5.getShadowRoundRectDrawable(), r5.getGradientDrawable()});
    L6:
        return new LayerDrawable(new Drawable[]{r5.getShadowRoundRectDrawable(), r5.getGradientDrawable()});
    }

    public final void c(float[] r4) {
        com.larus.common_ui.venus.a.C0014a r0 = getShadowRoundRectDrawable().a;
        f(r0);
        if (r4 != null) goto L5;
        r4 = getCornerRadiusByPosition();
    L5:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
        getShadowRoundRectDrawable().b(r0);
        getShadowRoundRectDrawable().a(0, getShadowLayerDrawable());
        getShadowRoundRectDrawable().a(1, getShadowLayerDrawable());
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        if (getShadowRoundRectDrawable().getPaint() == null) goto L11;
        setLayerType(1, this.I);
    L11:
        if (this.s == 1) goto L19;
        setBackground(getShadowLayerDrawable());
        return;
    L19:
        this.u = true;     // Catch: Throwable -> L14
        setBackground(getShadowLayerDrawable());     // Catch: Throwable -> L14
        this.u = false;
        b();
        return;
    L14:
        th = move-exception;
        this.u = false;
        throw th;
    }

    public final void e(float[] r10) {
        GradientDrawable r0 = getGradientDrawable();
        int r1 = this.k;
        if (r1 == (-1)) goto L5;
    L8:
        int r7 = this.l;
        if (r7 == (-1)) goto L11;
        int[] r8 = {r1, r7, this.m};
    L12:
        r0.setColors(r8);
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
        r0.setOrientation(GradientDrawable.Orientation.TL_BR);
        goto L23
    L16:
        r0.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        goto L23
    L17:
        r0.setOrientation(GradientDrawable.Orientation.BL_TR);
        goto L23
    L18:
        r0.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        goto L23
    L19:
        r0.setOrientation(GradientDrawable.Orientation.BR_TL);
        goto L23
    L20:
        r0.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        goto L23
    L21:
        r0.setOrientation(GradientDrawable.Orientation.TR_BL);
        goto L23
    L22:
        r0.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
    L23:
        int r2 = this.a;
        if (r2 == 0) goto L32;
        if (r2 == 1) goto L31;
        if (r2 == 2) goto L30;
        if (r2 != 3) goto L34;
        r0.setShape(3);
    L34:
        if (this.j != (-1)) goto L36;
        r0.setCornerRadius(this.e);
    L37:
        int r11 = this.c;
        if (r11 == 0) goto L41;
        r0.setStroke(this.d, r11);
        return;
    L41:
        return;
    L36:
        r0.setCornerRadii(r10);
        goto L37
    L30:
        r0.setShape(2);
        goto L34
    L31:
        r0.setShape(1);
        goto L34
    L32:
        r0.setShape(0);
        goto L34
    L11:
        r8 = new int[]{r1, this.m};
        goto L12
    L5:
        if (this.m != (-1)) goto L8;
        r0.setColor(this.b);
        goto L23
    }

    public final void f(com.larus.common_ui.venus.a.C0014a r2) {
        r2.c = this.o;
        r2.d = this.p;
        r2.g = this.C;
        r2.b = this.b;
        r2.e = this.q;
        r2.f = this.D;
        r2.h = this.E;
        r2.i = this.F;
        r2.j = this.G;
        r2.k = this.H;
    }

    public final int g(int r2) {
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

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (this.B == true) goto L5;
    L8:
        b();
        return;
    L5:
        if (getLayoutDirection() != 1) goto L7;
        this.v = this.A;
        this.x = this.z;
        goto L8
    L7:
        this.v = this.z;
        this.x = this.A;
        goto L8
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

    public final void d(float[] r4, boolean r5) {
        if (this.q <= 0) goto L21;
        float[] r0 = this.r;
        if (r0 == null) goto L12;
        boolean r1 = false;
        if (r0 != null) goto L9;
    L11:
        if (r1 == false) goto L12;
    L13:
        if (r5 == false) goto L15;
        b();
        return;
    L15:
        float[] r6 = this.r;
        if (r6 == null) goto L19;
        r4 = r6;
    L19:
        c(r4);
        return;
    L9:
        if (r0.length != 8) goto L11;
        r1 = true;
    L12:
        this.r = r4;
        goto L13
    L21:
        setBackground(getGradientDrawable());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        boolean r1 = false;
        if (this.s == 1) goto L6;
        super.onMeasure(r6, r7);
        float[] r8 = getCornerRadiusByPosition();
        e(r8);
        d(r8, false);
        return;
    L6:
        float[] r0 = getCornerRadiusByPosition();
        e(r0);
        if (this.q <= 0) goto L20;
        float[] r3 = this.r;
        if (r3 == null) goto L15;
        if (r3 != null) goto L12;
    L14:
        if (r1 == false) goto L15;
    L16:
        float[] r2 = this.r;
        if (r2 != null) goto L19;
        r2 = r0;
    L19:
        c(r2);
        goto L20
    L12:
        if (r3.length != 8) goto L14;
        r1 = true;
    L15:
        this.r = r0;
    L20:
        super.onMeasure(r6, r7);
        d(r0, true);
    }

    public ShapeLinearLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.j = -1;
        this.I = new Paint(1);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.J = LazyKt.lazy(r0, new h());
        this.K = LazyKt.lazy(r0, new i(this));
        this.L = LazyKt.lazy(r0, new j(this));
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
        this.C = r7.getColor(15, 0);
        this.D = r7.getBoolean(6, false);
        this.E = r7.getBoolean(7, false);
        this.G = r7.getBoolean(8, false);
        this.F = r7.getBoolean(9, false);
        this.H = r7.getBoolean(5, false);
        this.o = r7.getDimensionPixelSize(16, 0);
        this.p = r7.getDimensionPixelSize(17, 0);
        this.q = r7.getDimensionPixelSize(14, 0);
        this.s = r7.getInt(18, 0);
        r7.recycle();
        this.v = getPaddingLeft();
        this.w = getPaddingTop();
        this.x = getPaddingRight();
        this.y = getPaddingBottom();
        this.z = getPaddingStart();
        this.A = getPaddingEnd();
        this.B = isPaddingRelative();
    }

    public /* synthetic */ ShapeLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void setPadding(int r3, int r4, int r5, int r6) {
        if (this.t == false) goto L5;
    L19:
        super.setPadding(r3, r4, r5, r6);
        return;
    L5:
        if (this.u == true) goto L19;
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.y = r6;
        if (getLayoutDirection() != 1) goto L10;
        int r0 = r5;
    L11:
        this.z = r0;
        if (getLayoutDirection() != 1) goto L14;
        int r1 = r3;
    L15:
        this.A = r1;
        this.B = false;
        if (b() == true) goto L21;
        super.setPadding(r3, r4, r5, r6);
        return;
    L21:
        return;
    L14:
        r1 = r5;
        goto L15
    L10:
        r0 = r3;
        goto L11
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r3, int r4, int r5, int r6) {
        if (this.t == false) goto L5;
    L15:
        super.setPaddingRelative(r3, r4, r5, r6);
        return;
    L5:
        if (this.u == true) goto L15;
        this.z = r3;
        this.w = r4;
        this.A = r5;
        this.y = r6;
        this.B = true;
        if (getLayoutDirection() != 1) goto L10;
        this.v = this.A;
        this.x = this.z;
    L12:
        if (b() == true) goto L17;
        super.setPaddingRelative(r3, r4, r5, r6);
        return;
    L17:
        return;
    L10:
        this.v = this.z;
        this.x = this.A;
        goto L12
    }
}
