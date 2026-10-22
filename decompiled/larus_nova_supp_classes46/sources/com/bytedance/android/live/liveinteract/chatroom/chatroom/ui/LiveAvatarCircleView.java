package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LiveAvatarCircleView;", "Landroid/view/View;", "", "value", "", "setStrokeWidth", "", "fraction", "setFraction", "interval", "setInterval", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveAvatarCircleView extends View {
    public final Paint a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public int g;
    public final Paint h;

    public static final class a {
    }

    static {
    }

    public LiveAvatarCircleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveAvatarCircleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        float r0 = this.c;
        float r1 = this.d;
        float r2 = this.e;
        Paint r3 = this.a;
        Intrinsics.checkNotNull(r3);
        r5.drawCircle(r0, r1, r2, r3);
        float r4 = this.c;
        float r6 = this.d;
        float r7 = this.f;
        Paint r8 = this.h;
        Intrinsics.checkNotNull(r8);
        r5.drawCircle(r4, r6, r7, r8);
    }

    public final void setFraction(float r4) {
        float r0 = this.e + (this.g * r4);
        float r1 = this.b * (1 - r4);
        this.f = r0;
        Paint r5 = this.h;
        Intrinsics.checkNotNull(r5);
        r5.setStrokeWidth(r1);
        postInvalidate();
    }

    public final void setInterval(int r1) {
        this.g = r1;
    }

    public final void setStrokeWidth(int r1) {
        this.b = r1;
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.c = getMeasuredWidth() / 2;
        this.d = getMeasuredHeight() / 2;
        float r3 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.e = r3;
        this.f = r3;
        this.g = 9;
    }

    public LiveAvatarCircleView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        TypedArray r14 = r11.obtainStyledAttributes(r12, new int[]{2130972571, 2130972572});
        this.b = r14.getDimension(1, UIUtils.dip2Px(r11, 1.5f));
        r14.recycle();
        Paint r15 = new Paint();
        this.a = r15;
        LinearGradient r0 = new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR);
        Intrinsics.checkNotNull(r15);
        r15.setShader(r0);
        Intrinsics.checkNotNull(r15);
        r15.setAntiAlias(true);
        Intrinsics.checkNotNull(r15);
        r15.setDither(true);
        Intrinsics.checkNotNull(r15);
        r15.setStyle(Paint.Style.STROKE);
        Intrinsics.checkNotNull(r15);
        r15.setStrokeWidth(UIUtils.dip2Px(r11, 1.5f));
        this.h = new Paint(r15);
    }

    public /* synthetic */ LiveAvatarCircleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
