package com.obric.oui.blur;

import a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import com.lynx.tasm.utils.j;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.material.b;
import com.obric.oui.material.c;
import com.obric.oui.material.d;
import com.obric.oui.material.n;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/b;", "Lcom/obric/oui/material/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "", "radius", "", "setMaskBlurRadius", "(F)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "(Landroid/graphics/drawable/Drawable;)V", "height", "setMaskHeight", "(I)V", "view", "setBackdropTarget", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBlurMaskView extends FrameLayout implements b, d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f12023i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f12024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12026c;
    public final int d;
    public final int e;
    public final boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f12027h;

    @JvmOverloads
    public OBlurMaskView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final View getDefaultTargetView() {
        Integer r5 = n.f13677a;
        return this;
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.g = r5;
        a.F(this, r5);
        b();
    }

    public final void b() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L22;
        int r11 = r10 + 1;
        KeyEvent.Callback r12 = getChildAt(r10);
        if ((r12 instanceof d) == false) goto L11;
        d r13 = (d) r12;
        r13.a(this.g);
        if ((r13 instanceof b) == false) goto L9;
        ((b) r13).e();
    L9:
        r13.setBackdropTarget(getDefaultTargetView());
    L21:
        r10 = r11;
        goto L3
    L11:
        if ((r12 instanceof ViewGroup) == false) goto L21;
        ViewGroup r14 = (ViewGroup) r12;
        int r15 = r14.getChildCount();
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L21;
        int r17 = r16 + 1;
        KeyEvent.Callback r18 = r14.getChildAt(r16);
        if ((r18 instanceof d) == false) goto L20;
        d r19 = (d) r18;
        r19.a(this.g);
        if ((r19 instanceof b) == false) goto L19;
        ((b) r19).e();
    L19:
        r19.setBackdropTarget(getDefaultTargetView());
    L20:
        r16 = r17;
        goto L13
    }

    @Override // com.obric.oui.material.b
    public final void e() {
        int r5 = this.g;
        if (r5 == (-1)) goto L6;
        p.l(this, r5);
        return;
    L6:
        p.m(this, this.f);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        if (r5 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(this, this);
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(r5, this);
    }

    public final void setMaskBackground(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        setBackground(r5);
    }

    public final void setMaskBlurRadius(float r5) {
        c r10 = this.f12027h;
        xq.a r11 = r10.g;
        if (r11 == null) goto L6;
        r11.f23207a = r5;
    L6:
        n.o(this, r10, 2);
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(this, this);
    }

    @Deprecated(message = "")
    public final void setMaskHeight(int r5) {
    }

    @JvmOverloads
    public OBlurMaskView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBlurMaskView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBlurMaskView(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21);
        int r5 = com.lynx.tasm.utils.a.B(24, this);
        this.d = r5;
        int r10 = com.lynx.tasm.utils.a.B(24, this);
        this.e = r10;
        this.f = true;
        this.g = 2;
        com.obric.oui.color.a[] r11 = n.c(getResources(), R$array.oui_titlebar_blur_colors, R$array.oui_titlebar_blur_blend_modes);
        float r14 = BlurToken.Blur_Progress_Thin;
        c r15 = new c(null, null, r11, new xq.a(r14, 1, 6), null, null, 955);
        this.f12027h = r15;
        LayoutInflater.from(r19).inflate(R$layout.o_blur_mask_view, this, true);
        this.f12024a = (ViewGroup) findViewById(R$id.material_mask);
        setClipChildren(false);
        setClipToPadding(false);
        if (r20 == null) goto L44;
        TypedArray r12 = getContext().obtainStyledAttributes(r20, R$styleable.OBlurMaskView, 0, 0);
        if (r12.hasValue(R$styleable.OBlurMaskView_oui_widgetMaterialSrcType) == false) goto L8;
        this.g = r12.getInt(R$styleable.OBlurMaskView_oui_widgetMaterialSrcType, 2);
    L8:
        if (r12.hasValue(R$styleable.OBlurMaskView_oui_widgetBlurType) == false) goto L14;
        int r13 = r12.getInt(R$styleable.OBlurMaskView_oui_widgetBlurType, 0);
        xq.a r16 = r15.g;
        if (r16 == null) goto L14;
        r16.f23208b = r13;
    L14:
        if (r12.hasValue(R$styleable.OBlurMaskView_oui_widgetBlurColors) == false) goto L21;
        if (r12.hasValue(R$styleable.OBlurMaskView_oui_widgetBlurBlendModes) == false) goto L21;
        int r17 = r12.getResourceId(R$styleable.OBlurMaskView_oui_widgetBlurColors, R$array.oui_titlebar_blur_colors);
        int r18 = r12.getResourceId(R$styleable.OBlurMaskView_oui_widgetBlurBlendModes, R$array.oui_titlebar_blur_blend_modes);
        com.obric.oui.color.a[] r22 = n.c(r12.getResources(), r17, r18);
        r15.f13611c = r22;
        if (r22 != null) goto L21;
        ps.a.c("OBlurMaskView", "init get widget blur colors or modes error");
    L21:
        if (r12.hasValue(R$styleable.OBlurMaskView_oBlurMask_blurRadius) == false) goto L28;
        float r23 = r12.getFloat(R$styleable.OBlurMaskView_oBlurMask_blurRadius, r14);
        xq.a r24 = r15.g;
        if (r24 == null) goto L26;
        r24.f23207a = r23;
    L26:
        setMaskBlurRadius(r23);
    L28:
        if (r12.hasValue(R$styleable.OBlurMaskView_oBlurMask_maskHeight) == false) goto L32;
        int r25 = r12.getDimensionPixelSize(R$styleable.OBlurMaskView_oBlurMask_maskHeight, 0);
        if (r25 <= 0) goto L32;
        setMaskHeight(r25);
    L32:
        boolean r26 = r12.getBoolean(R$styleable.OBlurMaskView_oBlurMask_statusBarImmersion, false);
        this.f12025b = r12.getBoolean(R$styleable.OBlurMaskView_oui_widgetFitInsetTop, r26);
        boolean r27 = r12.getBoolean(R$styleable.OBlurMaskView_oui_widgetFitInsetBottom, false);
        this.f12026c = r27;
        if (this.f12025b == true) goto L35;
        if (r27 == true) goto L35;
    L42:
        r12.recycle();
        return;
    L35:
        Insets r28 = j.r(this, null);
        if (this.f12025b == false) goto L38;
        r5 = r28.top;
    L38:
        setPadding(getPaddingLeft(), r5, getPaddingRight(), getPaddingBottom());
        if (this.f12026c == false) goto L41;
        r10 = r28.bottom;
    L41:
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r10);
        setOnApplyWindowInsetsListener(new com.obric.oui.actionbar.v2.b(this, 4));
        goto L42
    }
}
