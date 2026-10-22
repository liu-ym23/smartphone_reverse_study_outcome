package com.bytedance.android.live.liveinteract.videotalk.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/ui/TeamFightPartBackground;", "Landroid/view/View;", "Landroid/graphics/Shader;", "getShader", "Landroid/graphics/RectF;", "getRoundRect", "Landroid/graphics/Path;", "getRoundRectPath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightPartBackground extends View {
    public final Paint a;
    public final float b;
    public final int c;
    public final int d;
    public final float e;
    public final boolean f;
    public Shader g;
    public RectF h;
    public Path i;

    private final RectF getRoundRect() {
        if (this.h != null) goto L8;
        float r0 = 2;
        float r1 = (this.b * r0) + this.e;
        if (this.f == false) goto L7;
        this.h = new RectF((-1) * r1, 0.0f, (getWidth() * 1.0f) - (this.e / r0), (getHeight() * 1.0f) - this.e);
        goto L8
    L7:
        this.h = new RectF(this.e / r0, 0.0f, (getWidth() * 1.0f) + r1, (getHeight() * 1.0f) - this.e);
    L8:
        RectF r2 = this.h;
        if (r2 == null) goto L12;
        return r2;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.RectF");
    }

    private final Path getRoundRectPath() {
        float r0 = s1.e(this.b);
        if (this.i != null) goto L8;
        Path r1 = new Path();
        this.i = r1;
        if (this.f == false) goto L7;
        r1.addRoundRect(getRoundRect(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, r0, r0, 0.0f, 0.0f}, Path.Direction.CW);
        goto L8
    L7:
        r1.addRoundRect(getRoundRect(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r0, r0}, Path.Direction.CW);
    L8:
        Path r2 = this.i;
        if (r2 == null) goto L12;
        return r2;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Path");
    }

    private final Shader getShader() {
        if (this.g != null) goto L5;
        this.g = new LinearGradient(0.0f, 0.0f, 1.0f * getWidth(), 0.0f, this.c, this.d, Shader.TileMode.CLAMP);
    L5:
        Shader r0 = this.g;
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Shader");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Paint r0 = this.a;
        if (r0 == null) goto L5;
        r3.drawPath(getRoundRectPath(), r0);
    L5:
        super.onDraw(r3);
    }

    public TeamFightPartBackground(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        this.f = true;
        Paint r1 = new Paint();
        this.a = r1;
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{2130968999, 2130969963, 2130972506, 2130974241, 2130974311});
        int r2 = r9.getColor(3, ColorProtector.parseColor("#000000"));
        this.c = r2;
        int r10 = r9.getColor(1, ColorProtector.parseColor("#000000"));
        this.d = r10;
        this.b = r9.getDimension(0, 0.0f);
        boolean r3 = r9.getBoolean(2, true);
        this.f = r3;
        float r11 = r9.getDimension(4, 0.0f);
        this.e = r11;
        if (r3 == false) goto L5;
        r1.setColor(r10);
    L6:
        r1.setStrokeWidth(r11);
        r1.setAntiAlias(true);
        r1.setStyle(Paint.Style.STROKE);
        return;
    L5:
        r1.setColor(r2);
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(r1, r2);
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L8;
        Paint r6 = this.a;
        if (r6 == null) goto L9;
        r6.setShader(getShader());
        return;
    L9:
        return;
    }
}
