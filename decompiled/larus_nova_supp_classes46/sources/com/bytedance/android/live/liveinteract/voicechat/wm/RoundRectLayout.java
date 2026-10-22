package com.bytedance.android.live.liveinteract.voicechat.wm;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/wm/RoundRectLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoundRectLayout extends FrameLayout {
    public final Path a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public RoundRectLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        float r1 = this.b;
        float r2 = this.c;
        float r3 = this.e;
        float r4 = this.d;
        this.a.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), new float[]{r1, r1, r2, r2, r3, r3, r4, r4}, Path.Direction.CW);
        r7.clipPath(this.a);
        super.dispatchDraw(r7);
    }

    public RoundRectLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attributeSet");
        this(r3);
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130972492, 2130972512, 2130973766, 2130973793, 2130973831});
        float r6 = r5.getDimension(4, this.f);
        this.f = r6;
        this.b = r5.getDimension(1, this.b);
        this.c = r5.getDimension(3, this.c);
        this.e = r5.getDimension(2, this.e);
        this.d = r5.getDimension(0, this.d);
        if (r6 == 0.0f) goto L5;
        this.b = r6;
        this.c = r6;
        this.e = r6;
        this.d = r6;
    L5:
        r5.recycle();
    }
}
