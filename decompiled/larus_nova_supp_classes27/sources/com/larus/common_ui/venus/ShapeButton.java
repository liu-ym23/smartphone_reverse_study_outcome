package com.larus.common_ui.venus;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w19.c;
import w19.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010E\u001a\u00020FH\u0002JN\u0010G\u001a\u00020F2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\u00072\b\b\u0003\u0010\u0018\u001a\u00020\u00072\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0003\u0010H\u001a\u00020\u0007H\u0007J\u0018\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0015J\b\u0010L\u001a\u00020FH\u0003J0\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0014J\u000e\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020UJ\u0016\u0010W\u001a\u00020F2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020ZH\u0014J\b\u0010[\u001a\u00020FH\u0003J\n\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\b\u0010^\u001a\u00020_H\u0002J\u0018\u0010`\u001a\u00020\u00162\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010)\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/common_ui/venus/ShapeButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shapeMode", "fillColor", "pressedColor", "strokeColor", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeWidth", "cornerRadius", "cornerPosition", "activeEnable", "", "startColor", "endColor", "shadowDx", "shadowDy", "shadowBlurRadius", "shapeShadowColor", "excludeDx", "excludeLeft", "excludeTop", "excludeRight", "excludeBottom", "orientation", "drawablePosition", "normalGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getNormalGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "normalGradientDrawable$delegate", "Lkotlin/Lazy;", "shadowRoundRectDrawable", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "getShadowRoundRectDrawable", "()Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "shadowRoundRectDrawable$delegate", "shadowGradientLayer", "Landroid/graphics/drawable/LayerDrawable;", "getShadowGradientLayer", "()Landroid/graphics/drawable/LayerDrawable;", "shadowGradientLayer$delegate", "contentWidth", "", "contentHeight", "hasChangeContext", "touchAdd", "touchAddBottom", "touchAddLeft", "touchAddRight", "touchAddTop", "touchRect", "Landroid/graphics/Rect;", "touchDelegateCustom", "Landroid/view/TouchDelegate;", "getTouchDelegateCustom", "()Landroid/view/TouchDelegate;", "touchDelegateCustom$delegate", "centerText", "initShadowParam", "", "modifyAttribute", "textColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateBackground", "onLayout", "changed", "left", "top", "right", "bottom", "updateShadowParam", "shadowParam", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable$Params;", "getShadowParam", "updateBgColor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "changeTintContextWrapperToActivity", "getActivity", "Landroid/app/Activity;", "getCornerRadiusByPosition", "", "containsFlag", "flagSet", "flag", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShapeButton extends AppCompatButton {
    public static final /* synthetic */ int z = 0;
    public final int a;
    public final int b;
    public final int c;
    public int d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public float q;
    public float r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final Rect w;
    public final Lazy x;
    public final boolean y;

    public ShapeButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShapeButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final float[] getCornerRadiusByPosition() {
        float[] r1 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float r2 = this.f;
        int r3 = this.g;
        boolean r4 = true;
        if ((1 | r3) != r3) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        r1[0] = r2;
        r1[1] = r2;
    L9:
        if ((2 | r3) != r3) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L15;
        r1[2] = r2;
        r1[3] = r2;
    L15:
        if ((4 | r3) != r3) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L21;
        r1[4] = r2;
        r1[5] = r2;
    L21:
        if ((8 | r3) == r3) goto L24;
        r4 = false;
    L24:
        if (r4 == false) goto L26;
        r1[6] = r2;
        r1[7] = r2;
    L26:
        return r1;
    L17:
        r8 = false;
        goto L18
    L11:
        r7 = false;
        goto L12
    L5:
        r5 = false;
        goto L6
    }

    private final GradientDrawable getNormalGradientDrawable() {
        return (GradientDrawable) this.n.getValue();
    }

    private final LayerDrawable getShadowGradientLayer() {
        return (LayerDrawable) this.p.getValue();
    }

    private final a getShadowRoundRectDrawable() {
        return (a) this.o.getValue();
    }

    private final TouchDelegate getTouchDelegateCustom() {
        return (TouchDelegate) this.x.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Activity getActivity() {
        Context r0 = getContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L10;
        if ((r0 instanceof Activity) == true) goto L8;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L8:
        return (Activity) r0;
    L10:
        return null;
    }

    public final a.C0014a getShadowParam() {
        return getShadowRoundRectDrawable().a;
    }

    public final int getStrokeColor() {
        return this.d;
    }

    public static LayerDrawable a(ShapeButton r4) {
        return new LayerDrawable(new Drawable[]{r4.getShadowRoundRectDrawable(), r4.getNormalGradientDrawable()});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        boolean r2 = true;
        if (this.q <= 0.0f) goto L9;
        int r0 = this.m;
        if (r0 == 0) goto L7;
        if (r0 != 2) goto L9;
    L7:
        r7.save();
        r7.translate((getWidth() - this.q) / 2, 0.0f);
    L21:
        super/*android.widget.Button*/.onDraw(r7);
        if (r2 == false) goto L25;
        r7.restore();
        return;
    L25:
        return;
    L9:
        if (this.r <= 0.0f) goto L16;
        int r1 = this.m;
        if (r1 != 1) goto L13;
    L14:
        r7.save();
        r7.translate(0.0f, (getHeight() - this.r) / 2);
        goto L21
    L13:
        if (r1 == 3) goto L14;
    L16:
        if (this.k > 0) goto L18;
    L20:
        r2 = false;
        goto L21
    L18:
        if (this.h == true) goto L20;
        r7.save();
        float r3 = 2;
        r7.translate(((-(getPaddingLeft() - getShadowRoundRectDrawable().b)) + (getPaddingRight() - getShadowRoundRectDrawable().c)) / r3, (((-(getPaddingTop() - getShadowRoundRectDrawable().d)) + getPaddingBottom()) - getShadowRoundRectDrawable().e) / r3);
        goto L21
    }

    public final void setStrokeColor(int r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        super/*android.widget.Button*/.onMeasure(r7, r8);
        float[] r9 = getCornerRadiusByPosition();
        GradientDrawable r10 = getNormalGradientDrawable();
        int r0 = this.i;
        if (r0 == (-1)) goto L5;
    L8:
        r10.setColors(new int[]{r0, this.j});
        switch(this.l) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L19;
        };
    L11:
        r10.setOrientation(GradientDrawable.Orientation.TL_BR);
        goto L19
    L12:
        r10.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        goto L19
    L13:
        r10.setOrientation(GradientDrawable.Orientation.BL_TR);
        goto L19
    L14:
        r10.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        goto L19
    L15:
        r10.setOrientation(GradientDrawable.Orientation.BR_TL);
        goto L19
    L16:
        r10.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        goto L19
    L17:
        r10.setOrientation(GradientDrawable.Orientation.TR_BL);
        goto L19
    L18:
        r10.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
    L19:
        int r1 = this.a;
        if (r1 == 0) goto L29;
        if (r1 == 1) goto L28;
        if (r1 != 2) goto L24;
        r10.setShape(2);
    L31:
        if (this.g != (-1)) goto L33;
        r10.setCornerRadius(this.f);
    L34:
        int r2 = this.d;
        if (r2 == 0) goto L38;
        r10.setStroke(this.e, r2);
    L38:
        if (this.h == false) goto L41;
        Drawable r11 = new RippleDrawable(ColorStateList.valueOf(this.c), getNormalGradientDrawable(), null);
    L49:
        setBackground(r11);
        return;
    L41:
        if (this.k <= 0) goto L48;
        a.C0014a r12 = getShadowRoundRectDrawable().a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r12.a = r9;
        getShadowRoundRectDrawable().b(r12);
        getShadowRoundRectDrawable().a(0, getShadowGradientLayer());
        getShadowRoundRectDrawable().a(1, getShadowGradientLayer());
        if (Build.VERSION.SDK_INT < 28) goto L45;
    L47:
        r11 = getShadowGradientLayer();
        goto L49
    L45:
        if (getShadowRoundRectDrawable().getPaint() == null) goto L47;
        setLayerType(1, getPaint());
        goto L47
    L48:
        r11 = getNormalGradientDrawable();
        goto L49
    L33:
        r10.setCornerRadii(r9);
        goto L34
    L24:
        if (r1 != 3) goto L31;
        r10.setShape(3);
        goto L31
    L28:
        r10.setShape(1);
        goto L31
    L29:
        r10.setShape(0);
        goto L31
    L5:
        if (this.j != (-1)) goto L8;
        int r5 = this.b;
        r10.setColors(new int[]{r5, r5});
        goto L19
    }

    public ShapeButton(Context r17, AttributeSet r18, int r110) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r110);
        this.m = -1;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.n = LazyKt.lazy(r3, new w19.a());
        this.o = LazyKt.lazy(r3, new w19.b());
        this.p = LazyKt.lazy(r3, new c(this));
        this.x = LazyKt.lazy(r3, new d(this));
        this.y = true;
        TypedArray r1 = r17.obtainStyledAttributes(r18, new int[]{2130972172, 2130972173, 2130972174, 2130972175, 2130972176, 2130972177, 2130972178, 2130972179, 2130972180, 2130972181, 2130972182, 2130972183, 2130972184, 2130972185, 2130972186, 2130972187, 2130972188, 2130972189, 2130972190, 2130972191, 2130972192, 2130972193, 2130972194, 2130972195, 2130972196, 2130972197, 2130972198});
        this.a = r1.getInt(18, 0);
        int r4 = r1.getColor(11, -1);
        this.b = r4;
        this.c = r1.getColor(13, -10066330);
        this.d = r1.getColor(20, 0);
        this.e = r1.getDimensionPixelOffset(21, 0);
        this.f = r1.getDimensionPixelSize(3, 0);
        this.g = r1.getInt(2, -1);
        this.h = r1.getBoolean(0, false);
        this.m = r1.getInt(4, -1);
        this.i = r1.getColor(19, -1);
        this.j = r1.getColor(5, -1);
        this.l = r1.getColor(12, 0);
        int r2 = r1.getDimensionPixelSize(22, 0);
        int r6 = r1.getDimensionPixelSize(23, r2);
        this.s = r6;
        int r7 = r1.getDimensionPixelSize(24, r2);
        this.t = r7;
        int r8 = r1.getDimensionPixelSize(25, r2);
        this.u = r8;
        int r5 = r1.getDimensionPixelSize(26, r2);
        this.v = r5;
        this.y = r1.getBoolean(1, true);
        int r9 = r1.getColor(15, 0);
        boolean r10 = r1.getBoolean(7, false);
        boolean r11 = r1.getBoolean(8, false);
        boolean r12 = r1.getBoolean(10, false);
        boolean r13 = r1.getBoolean(9, false);
        boolean r14 = r1.getBoolean(6, false);
        int r15 = r1.getDimensionPixelSize(16, 0);
        int r16 = r1.getDimensionPixelSize(17, 0);
        int r20 = r1.getDimensionPixelSize(14, 0);
        this.k = r20;
        if (r6 <= 0) goto L8;
        if (r7 <= 0) goto L8;
        if (r8 <= 0) goto L8;
        if (r5 <= 0) goto L8;
        this.w = new Rect();
    L8:
        a.C0014a r21 = getShadowRoundRectDrawable().a;
        r21.c = r15;
        r21.d = r16;
        r21.g = r9;
        r21.b = r4;
        r21.e = r20;
        r21.f = r10;
        r21.h = r11;
        r21.i = r12;
        r21.j = r13;
        r21.k = r14;
        r1.recycle();
    }

    public /* synthetic */ ShapeButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (this.m <= (-1)) goto L17;
        getCompoundDrawables();
        Drawable r0 = getCompoundDrawables()[this.m];
        if (r0 == null) goto L17;
        int r1 = getCompoundDrawablePadding();
        int r3 = this.m;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L10;
    L14:
        int r2 = r0.getIntrinsicHeight();
        Paint.FontMetrics r4 = getPaint().getFontMetrics();
        float r5 = (float) Math.ceil(((double) r4.descent) - ((double) r4.ascent));
        this.r = (((r5 * getLineCount()) + ((getLineCount() - 1) * getLineSpacingExtra())) + r2) + r1;
        setPadding(0, 0, 0, (int) (getHeight() - this.r));
        goto L17
    L10:
        if (r3 == 2) goto L15;
        if (r3 == 3) goto L14;
    L15:
        this.q = (getPaint().measureText(getText().toString()) + r0.getIntrinsicWidth()) + r1;
        setPadding(0, 0, (int) (getWidth() - this.q), 0);
    L17:
        if (this.y == false) goto L20;
        setGravity(17);
    L20:
        if (this.h == false) goto L22;
        setClickable(true);
    L22:
        if (r10 == false) goto L27;
        Rect r15 = this.w;
        if (r15 == null) goto L28;
        r15.left = r11 - this.t;
        r15.top = r12 - this.v;
        r15.right = r13 + this.u;
        r15.bottom = r14 + this.s;
        Object r16 = getParent();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.View");
        ((View) r16).setTouchDelegate(getTouchDelegateCustom());
        return;
    L28:
        return;
    }
}
