package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.k;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4012b;
    public int[] c;
    public int d;
    public int e;
    public int f;

    public c(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        this.c = new int[0];
        int r0 = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_progress_track_thickness, "dimen", "mtrl_progress_track_thickness"));
        TypedArray r14 = k.a(r13, r3, R.styleable.BaseProgressIndicator, r11, r12, new int[0]);
        this.f4011a = com.google.android.material.resources.c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackThickness, "styleable", "BaseProgressIndicator_trackThickness"), r0);
        this.f4012b = Math.min(com.google.android.material.resources.c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackCornerRadius, "styleable", "BaseProgressIndicator_trackCornerRadius"), 0), this.f4011a / 2);
        this.e = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_showAnimationBehavior, "styleable", "BaseProgressIndicator_showAnimationBehavior"), 0);
        this.f = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_hideAnimationBehavior, "styleable", "BaseProgressIndicator_hideAnimationBehavior"), 0);
        a(r13, r14);
        b(r13, r14);
        r14.recycle();
    }

    private void a(Context r8, TypedArray r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor")) == true) goto L7;
        this.c = new int[]{com.google.android.material.c.a.a(r10, ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"), -1)};
        return;
    L7:
        if (r9.peekValue(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor")).type == 1) goto L10;
        this.c = new int[]{r9.getColor(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor"), -1)};
        return;
    L10:
        int[] r11 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getIntArray(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor"), -1));
        this.c = r11;
        if (r11.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void b(Context r4, TypedArray r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackColor, "styleable", "BaseProgressIndicator_trackColor")) == false) goto L7;
        int r7 = r5.getColor(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackColor, "styleable", "BaseProgressIndicator_trackColor"), -1);
    L5:
        this.d = r7;
        return;
    L7:
        this.d = this.c[0];
        TypedArray r8 = r6.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r9 = r8.getFloat(0, 0.2f);
        r8.recycle();
        r7 = com.google.android.material.c.a.b(this.d, (int) (r9 * 255.0f));
        goto L5
    }

    public boolean a() {
        if (this.e == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.f == 0) goto L5;
        return true;
    L5:
        return false;
    }

    abstract void c();
}
