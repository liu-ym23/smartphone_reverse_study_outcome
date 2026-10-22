package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view;

import a02.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/GiftListEdgeTransparentView;", "Landroid/widget/LinearLayout;", "La02/a;", "c", "La02/a;", "getTouchInterceptor", "()La02/a;", "setTouchInterceptor", "(La02/a;)V", "touchInterceptor", BuildConfig.FLAVOR, "h", "F", "getTopDrawSize", "()F", "setTopDrawSize", "(F)V", "topDrawSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftListEdgeTransparentView extends LinearLayout {
    public float a;
    public float b;
    public a c;
    public final Paint d;
    public int[] e;
    public float[] f;
    public float g;
    public float h;
    public final Paint i;
    public int[] j;
    public float[] k;
    public float l;

    public GiftListEdgeTransparentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftListEdgeTransparentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        Paint r0 = this.d;
        if (r0 == null) goto L6;
        float r3 = this.g;
        r0.setShader(new LinearGradient(0.0f, r3, 0.0f, r3 + this.h, this.e, this.f, Shader.TileMode.CLAMP));
        return;
    }

    public final float getTopDrawSize() {
        return this.h;
    }

    public final a getTouchInterceptor() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        a r0 = this.c;
        if (r0 == null) goto L9;
        if (r0.a(r3) != true) goto L9;
        return false;
    L9:
        return super.dispatchTouchEvent(r3);
    }

    public final void setTopDrawSize(float r1) {
        this.h = r1;
    }

    public final void setTouchInterceptor(a r1) {
        this.c = r1;
    }

    public GiftListEdgeTransparentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = new int[]{-1, 0};
        this.f = new float[]{0.0f, 1.0f};
        this.j = new int[]{-1, 0};
        this.k = new float[]{0.0f, 1.0f};
        Paint r5 = new Paint(1);
        this.d = r5;
        r5.setStyle(Paint.Style.FILL);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint r6 = new Paint(1);
        this.i = r6;
        r6.setStyle(Paint.Style.FILL);
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r10, View r11, long r13) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.h <= 0.0f) goto L5;
    L8:
        int r0 = r10.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean r14 = super.drawChild(r10, r11, r13);
        float r15 = this.h;
        if (r15 <= 0.0f) goto L14;
        Paint r7 = this.d;
        if (r7 == null) goto L14;
        float r4 = this.g;
        r10.drawRect(0.0f, r4, this.a, r4 + r15, r7);
    L14:
        if (this.l <= 0.0f) goto L18;
        Paint r6 = this.i;
        if (r6 == null) goto L18;
        int r16 = r10.save();
        r10.rotate(180.0f, this.a / 2.0f, this.b / 2.0f);
        r10.drawRect(0.0f, 0.0f, this.a, this.l, r6);
        r10.restoreToCount(r16);
    L18:
        r10.restoreToCount(r0);
        return r14;
    L5:
        if (this.l > 0.0f) goto L8;
        return super.drawChild(r10, r11, r13);
    }

    public /* synthetic */ GiftListEdgeTransparentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r13) {
        super.onSizeChanged(r9, r10, r11, r13);
        a();
        Paint r14 = this.i;
        if (r14 == null) goto L5;
        r14.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.l, this.j, this.k, Shader.TileMode.CLAMP));
    L5:
        this.a = getWidth();
        this.b = getHeight();
    }
}
