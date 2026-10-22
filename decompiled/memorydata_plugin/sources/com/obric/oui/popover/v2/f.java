package com.obric.oui.popover.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.crash.entity.EventBody;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0014J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0014R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLandscapeWrapper;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", EventBody.KEY_VALUE, "", "orientationAngle", "getOrientationAngle", "()F", "setOrientationAngle", "(F)V", "rotationLayer", "Landroid/widget/FrameLayout;", "getRotationLayer", "()Landroid/widget/FrameLayout;", "addView", "", "child", "Landroid/view/View;", "index", "", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f14368b;

    public f(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        FrameLayout r0 = new FrameLayout(r4);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        this.f14368b = r0;
        setClipChildren(false);
        setClipToPadding(false);
        super.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), -1, new ViewGroup.LayoutParams(-2, -2));
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        this.f14368b.addView(r2, r3, r4);
    }

    public final float getOrientationAngle() {
        return this.f14367a;
    }

    public final FrameLayout getRotationLayer() {
        return this.f14368b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = r6 - r4;
        int r9 = this.f14368b.getMeasuredWidth();
        int r10 = this.f14368b.getMeasuredHeight();
        int r11 = (r8 - r9) / 2;
        int r12 = ((r7 - r5) - r10) / 2;
        this.f14368b.layout(r11, r12, r11 + r9, r12 + r10);
        this.f14368b.setPivotX(r9 / 2.0f);
        this.f14368b.setPivotY(r10 / 2.0f);
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        if ((this.f14367a % SubsamplingScaleImageView.ORIENTATION_180) != 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        measureChild((View) ZeusTransformUtils.preCheckCast(this.f14368b, View.class, "com.obric.memorydata.plugin"), r5, r4);
        int r6 = this.f14368b.getMeasuredHeight();
        int r7 = this.f14368b.getMeasuredWidth();
    L10:
        setMeasuredDimension(r6, r7);
        return;
    L9:
        measureChild((View) ZeusTransformUtils.preCheckCast(this.f14368b, View.class, "com.obric.memorydata.plugin"), r4, r5);
        r6 = this.f14368b.getMeasuredWidth();
        r7 = this.f14368b.getMeasuredHeight();
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final void setOrientationAngle(float r2) {
        this.f14367a = r2;
        this.f14368b.setRotation(r2);
        requestLayout();
    }
}
