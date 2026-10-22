package com.obric.flow.cardlistpage.ui.popup;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.oui.material.MaterialToken;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u000fJ\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u000fJ\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u001eR\"\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0013R\"\u0010(\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0013R\"\u0010-\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010\u000f¨\u0006."}, d2 = {"Lcom/obric/flow/cardlistpage/ui/popup/OPopoverLayout;", "Landroid/widget/LinearLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setBgColor", "(I)V", "", "cornerRadius", "setCornerRadius", "(F)V", "getCornerRadius", "()F", "setBorderColor", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "(Z)V", "getPadding", "()I", "getArrowHeight", "e", "F", "getMWidth", "setMWidth", "mWidth", "f", "getMHeight", "setMHeight", "mHeight", "g", "I", "getMBgColor", "setMBgColor", "mBgColor", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOPopoverLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OPopoverLayout.kt\ncom/obric/flow/cardlistpage/ui/popup/OPopoverLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,407:1\n1#2:408\n181#3,3:409\n180#3,5:412\n189#3,3:417\n188#3,5:420\n189#3,3:425\n188#3,5:428\n181#3,3:433\n180#3,5:436\n*S KotlinDebug\n*F\n+ 1 OPopoverLayout.kt\ncom/obric/flow/cardlistpage/ui/popup/OPopoverLayout\n*L\n51#1:409,3\n51#1:412,5\n52#1:417,3\n52#1:420,5\n53#1:425,3\n53#1:428,5\n54#1:433,3\n54#1:436,5\n*E\n"})
public final class OPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f11787n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f11788o = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f11790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f11791c;
    public RectF d;
    public float e;
    public float f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f11794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11796l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1 f11797m;

    static {
        float r5 = 0;
        f11787n = androidx.room.jarjarred.org.antlr.runtime.a.a(r5, 1);
        f11788o = TypedValue.applyDimension(1, 28, Resources.getSystem().getDisplayMetrics());
        TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics());
        MathKt.roundToInt(TypedValue.applyDimension(1, 36, Resources.getSystem().getDisplayMetrics()));
    }

    public OPopoverLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f11789a = f11788o;
        Color.parseColor("#20000000");
        new ArgbEvaluator();
        this.f11795k = true;
        this.f11797m = MaterialToken.OUI_Bg_Popup;
        a(r5);
    }

    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f11790b = new Paint();
        new Path();
        Paint r10 = this.f11790b;
        Paint r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L5:
        r10.setStyle(Paint.Style.FILL);
        Paint r12 = this.f11790b;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L8:
        r12.setStrokeCap(Paint.Cap.BUTT);
        Paint r13 = this.f11790b;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r13 = null;
    L11:
        r13.setAntiAlias(true);
        Paint r14 = this.f11790b;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r14 = null;
    L14:
        r14.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.g = ContextCompat.getColor(r5, R$color.oui_bg_base_3);
    L17:
        Paint r15 = this.f11790b;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r11.setColor(getMBgColor());
        setBackgroundColor(0);
        this.f11796l = a.a.w(this);
        b();
        setClipChildren(false);
        setOutlineProvider(new br.c(this, 3));
        return;
    L20:
        r11 = r15;
        goto L21
    }

    public final void b() {
        if (this.f11795k == true) goto L6;
        return;
    L6:
        if (this.f11796l == true) goto L9;
        return;
    L9:
        if (getMBgColor() != 0) goto L11;
        boolean r5 = a.a.v(this);
    L12:
        com.obric.oui.material.c[] r10 = (com.obric.oui.material.c[]) this.f11797m.invoke(Boolean.valueOf(!r5));
        if (r10 == null) goto L16;
        a.a.y(this, r10, false, 0, 14);
        return;
    L16:
        return;
    L11:
        r5 = h.j(getMBgColor());
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.dispatchDraw(r5);
    }

    public final int getArrowHeight() {
        return f11787n;
    }

    public final float getCornerRadius() {
        return this.f11789a;
    }

    public final int getMBgColor() {
        return this.g;
    }

    public final float getMHeight() {
        return this.f;
    }

    public final float getMWidth() {
        return this.e;
    }

    public final int getPadding() {
        return f11787n / 2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        RectF r5 = null;
        if (this.f11796l == true) goto L14;
        Paint r11 = this.f11790b;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r11 = null;
    L7:
        r11.setColor(getMBgColor());
        RectF r12 = this.d;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRectF");
        r12 = null;
    L10:
        float r13 = this.f11789a;
        Paint r14 = this.f11790b;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r14 = null;
    L13:
        r10.drawRoundRect(r12, r13, r13, r14);
    L18:
        Paint r15 = this.f11794j;
        if (r15 != null) goto L21;
        return;
    L21:
        if (this.f11792h <= 0) goto L29;
        RectF r16 = this.d;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRectF");
    L26:
        float r17 = f11788o;
        r10.drawRoundRect(r5, r17, r17, r15);
        return;
    L25:
        r5 = r16;
        goto L26
    L29:
        return;
    L14:
        Paint r18 = this.f11790b;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r18 = null;
    L17:
        r18.getAlpha();
        goto L18
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        this.e = getMeasuredWidth();
        this.f = getMeasuredHeight();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
    }

    public final void setBgColor(@ColorInt int r5) {
        if (getMBgColor() != r5) goto L5;
        return;
    L5:
        this.g = r5;
        Paint r10 = this.f11790b;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L8:
        r10.setColor(getMBgColor());
        b();
    }

    public final void setBorderColor(int r5) {
        this.f11793i = r5;
        if (this.f11794j != null) goto L5;
        this.f11794j = new Paint(1);
    L5:
        Paint r10 = this.f11794j;
        if (r10 == null) goto L10;
        r10.setColor(this.f11793i);
        return;
    }

    public final void setBorderWidth(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.f11792h = r5;
        if (this.f11794j != null) goto L7;
        this.f11794j = new Paint(1);
    L7:
        Paint r10 = this.f11794j;
        if (r10 == null) goto L11;
        r10.setStyle(Paint.Style.STROKE);
        r10.setStrokeWidth(this.f11792h);
        r10.setStrokeCap(Paint.Cap.BUTT);
        r10.setStrokeJoin(Paint.Join.MITER);
        r10.setAntiAlias(true);
        r10.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        r10.setColor(this.f11793i);
        return;
    }

    public final void setCornerRadius(@Px float r5) {
        this.f11789a = r5;
    }

    public final void setMBgColor(int r5) {
        this.g = r5;
    }

    public final void setMHeight(float r5) {
        this.f = r5;
    }

    public final void setMWidth(float r5) {
        this.e = r5;
    }

    public final void setTransparentBg(boolean r5) {
        if (r5 == false) goto L5;
        this.g = 0;
        return;
    }

    public OPopoverLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, true, MaterialToken.OUI_Bg_Popup);
    }

    public OPopoverLayout(Context r5, AttributeSet r10, boolean r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r12, "materials");
        super(r5, r10, 0);
        this.f11789a = f11788o;
        Color.parseColor("#20000000");
        new ArgbEvaluator();
        this.f11795k = true;
        MaterialToken r13 = MaterialToken.INSTANCE;
        this.f11795k = r11;
        this.f11797m = r12;
        a(r5);
    }
}
