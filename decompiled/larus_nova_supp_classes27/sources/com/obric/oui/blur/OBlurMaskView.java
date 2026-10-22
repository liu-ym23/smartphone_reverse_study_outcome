package com.obric.oui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.g;
import com.obric.oui.material.h;
import com.obric.oui.material.p;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/b;", "Lcom/obric/oui/material/g;", "Landroid/view/View;", "getDefaultTargetView", "", "radius", "", "setMaskBlurRadius", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "", "height", "setMaskHeight", "view", "setBackdropTarget", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBlurMaskView extends FrameLayout implements com.obric.oui.material.b, g {
    public static final /* synthetic */ int i = 0;
    public final ViewGroup a;
    public boolean b;
    public boolean c;
    public final int d;
    public final int e;
    public final boolean f;
    public int g;
    public final com.obric.oui.material.c h;

    public static final class a {
    }

    static {
    }

    public OBlurMaskView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OBlurMaskView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Deprecated(message = "")
    public final void setMaskHeight(int r1) {
    }

    public final void c() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L22;
        int r3 = r2 + 1;
        com.obric.oui.material.b r4 = getChildAt(r2);
        if ((r4 instanceof g) == false) goto L11;
        com.obric.oui.material.b r5 = (g) r4;
        r5.a(this.g);
        if ((r5 instanceof com.obric.oui.material.b) == false) goto L9;
        r5.b(false);
    L9:
        r5.setBackdropTarget(getDefaultTargetView());
    L21:
        r2 = r3;
        goto L3
    L11:
        if ((r4 instanceof ViewGroup) == false) goto L21;
        ViewGroup r6 = (ViewGroup) r4;
        int r7 = r6.getChildCount();
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L21;
        int r9 = r8 + 1;
        com.obric.oui.material.b r10 = r6.getChildAt(r8);
        if ((r10 instanceof g) == false) goto L20;
        com.obric.oui.material.b r11 = (g) r10;
        r11.a(this.g);
        if ((r11 instanceof com.obric.oui.material.b) == false) goto L19;
        r11.b(false);
    L19:
        r11.setBackdropTarget(getDefaultTargetView());
    L20:
        r8 = r9;
        goto L13
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    private final View getDefaultTargetView() {
        Integer r0 = OMaterialHelper.a;
        return this;
    }

    public final void a(int r1) {
        this.g = r1;
        p.g(this, r1);
        c();
    }

    public final void b(boolean r3) {
        int r4 = this.g;
        if (r4 == (-1)) goto L6;
        h.a(this, false, r4);
        return;
    L6:
        h.b(this, false, this.f);
    }

    public void setBackdropTarget(View r2) {
        if (r2 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, this);
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, r2);
    }

    public final void setMaskBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        setBackground(r2);
    }

    public final void setMaskBlurRadius(float r3) {
        com.obric.oui.material.c r0 = this.h;
        com.obric.oui.blur.a r1 = r0.g;
        if (r1 == null) goto L6;
        r1.a = r3;
    L6:
        OMaterialHelper.p(this, r0, 2);
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, this);
    }

    public OBlurMaskView(Context r21, AttributeSet r22, int r23) {
        Intrinsics.checkNotNullParameter(r21, "context");
        super(r21, r22, r23);
        int r4 = d.n(this, 24);
        this.d = r4;
        int r2 = d.n(this, 24);
        this.e = r2;
        this.f = true;
        this.g = 2;
        com.obric.oui.color.a[] r10 = OMaterialHelper.d(getResources(), 2130903100, 2130903097);
        float r7 = BlurToken.Blur_Progress_Thin;
        com.obric.oui.material.c r15 = new com.obric.oui.material.c(null, null, r10, null, new com.obric.oui.blur.a(r7, 1, 6, 20), null, null, null, 955);
        this.h = r15;
        LayoutInflater.from(r21).inflate(2131563746, this, true);
        this.a = (ViewGroup) findViewById(2131379715);
        setClipChildren(false);
        setClipToPadding(false);
        if (r22 == null) goto L44;
        TypedArray r1 = getContext().obtainStyledAttributes(r22, new int[]{2130972846, 2130972847, 2130972848, 2130972849, 2130972850, 2130973368, 2130973369, 2130973371, 2130973377, 2130973378, 2130973379, 2130973380, 2130973389}, 0, 0);
        if (r1.hasValue(12) == false) goto L8;
        this.g = r1.getInt(12, 2);
    L8:
        if (r1.hasValue(7) == false) goto L14;
        int r8 = r1.getInt(7, 0);
        com.obric.oui.blur.a r9 = r15.g;
        if (r9 == null) goto L14;
        r9.b = r8;
    L14:
        if (r1.hasValue(6) == false) goto L21;
        if (r1.hasValue(5) == false) goto L21;
        int r11 = r1.getResourceId(6, 2130903100);
        int r12 = r1.getResourceId(5, 2130903097);
        com.obric.oui.color.a[] r13 = OMaterialHelper.d(r1.getResources(), r11, r12);
        r15.c = r13;
        if (r13 != null) goto L21;
        wma.b.b("OBlurMaskView", "init get widget blur colors or modes error");
    L21:
        if (r1.hasValue(0) == false) goto L28;
        float r14 = r1.getFloat(0, r7);
        com.obric.oui.blur.a r6 = r15.g;
        if (r6 == null) goto L26;
        r6.a = r14;
    L26:
        setMaskBlurRadius(r14);
    L28:
        if (r1.hasValue(3) == false) goto L32;
        int r16 = r1.getDimensionPixelSize(3, 0);
        if (r16 <= 0) goto L32;
        setMaskHeight(r16);
    L32:
        this.b = r1.getBoolean(11, r1.getBoolean(4, false));
        boolean r3 = r1.getBoolean(8, false);
        this.c = r3;
        if (this.b == true) goto L35;
        if (r3 == true) goto L35;
    L42:
        r1.recycle();
        return;
    L35:
        xma.b r5 = zma.a.f(this, null, true);
        if (this.b == false) goto L38;
        r4 = r5.b;
    L38:
        setPadding(getPaddingLeft(), r4, getPaddingRight(), getPaddingBottom());
        if (this.c == false) goto L41;
        r2 = r5.d;
    L41:
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r2);
        setOnApplyWindowInsetsListener(new c(this));
        goto L42
    }

    public /* synthetic */ OBlurMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
