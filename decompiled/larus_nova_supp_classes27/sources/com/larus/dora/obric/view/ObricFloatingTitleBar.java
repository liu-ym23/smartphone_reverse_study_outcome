package com.larus.dora.obric.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.titlebar.OFloatingTitleBar;
import d79.a;
import d79.b;
import d79.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J$\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J$\u0010%\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0013J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/obric/view/ObricFloatingTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "blurMask", "Lcom/larus/dora/obric/view/TopRoundedMaskView;", "maskSpacer", "Landroid/view/View;", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "maskBlurRadius", "", "fitInsetTop", "", "maskHeight", "onAttachedToWindow", "", "onDetachedFromWindow", "setMaskBlurRadius", "radius", "setTopCornerRadii", "topLeftRadius", "topRightRadius", "attachBlurMask", "updateMaskHeight", "insetTop", "addStartAction", "iconRes", "index", "onClick", "Landroid/view/View$OnClickListener;", "addEndAction", "showStartAction", "show", "showEndAction", "createMaskMaterial", "Lcom/obric/oui/material/MaterialConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFloatingTitleBar extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final c a;
    public final View b;
    public final OFloatingTitleBar c;
    public float d;
    public final boolean e;
    public int f;

    public ObricFloatingTitleBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricFloatingTitleBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewParent r0 = this.a.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(this.a);
    L8:
        OMaterialHelper.q(this.a, 0);
        OMaterialHelper.t(this.a, null);
        super.onDetachedFromWindow();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
        ViewCompat.requestApplyInsets(this);
    }

    public final void setMaskBlurRadius(float r18) {
        this.d = r18;
        c r2 = this.a;
        boolean r4 = false;
        if (r18 <= 0.0f) goto L5;
        int r5 = 0;
    L6:
        r2.setVisibility(r5);
        if (r18 <= 0.0f) goto L18;
        c r3 = this.a;
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L11;
        r4 = true;
    L11:
        if (r4 == false) goto L13;
        int r6 = 2130903102;
    L14:
        if (r4 == false) goto L16;
        int r7 = 2130903099;
    L17:
        OMaterialHelper.p(r3, new com.obric.oui.material.c(null, null, OMaterialHelper.d(getResources(), r6, r7), null, new com.obric.oui.blur.a(r18, 1, 6, 20), null, null, null, 955), 2);
        OMaterialHelper.t(this.a, this.a);
        return;
    L16:
        r7 = 2130903098;
        goto L17
    L13:
        r6 = 2130903101;
        goto L14
    L18:
        OMaterialHelper.q(this.a, 0);
        OMaterialHelper.t(this.a, null);
        return;
    L5:
        r5 = 8;
        goto L6
    }

    public ObricFloatingTitleBar(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new c(r5);
        View r8 = new View(r5);
        r8.setVisibility(4);
        this.b = r8;
        OFloatingTitleBar r0 = new OFloatingTitleBar(r5, null, 6, 0);
        this.c = r0;
        this.f = getResources().getDimensionPixelSize(2131168037);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130972851, 2130972852, 2130972853, 2130972854, 2130972855, 2130972856, 2130972857, 2130972858, 2130972859, 2130972860, 2130972861, 2130972862, 2130972863, 2130972864, 2130972865, 2130972866, 2130972867, 2130972868, 2130973368, 2130973369, 2130973377, 2130973378, 2130973379, 2130973380, 2130973383, 2130973389});
        this.d = r9.getFloat(10, 0.0f);
        this.e = r9.getBoolean(23, r9.getBoolean(16, false));
        r9.recycle();
        addView(r8, new FrameLayout.LayoutParams(-1, this.f));
        addView(r0, new FrameLayout.LayoutParams(-1, -2));
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this));
        setMaskBlurRadius(this.d);
    }

    public /* synthetic */ ObricFloatingTitleBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
