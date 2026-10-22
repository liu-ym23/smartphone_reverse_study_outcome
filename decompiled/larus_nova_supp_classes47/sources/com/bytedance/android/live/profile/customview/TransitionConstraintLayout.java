package com.bytedance.android.live.profile.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0006¢\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010&\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010.\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020'8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u00106\u001a\u0004\u0018\u00010/2\b\u0010\u0007\u001a\u0004\u0018\u00010/8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/profile/customview/TransitionConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/PorterDuff$Mode;", "newMode", "", "setXfermode", "", "value", "a", "I", "getTransitionType", "()I", "setTransitionType", "(I)V", "transitionType", "Landroid/graphics/RectF;", "b", "Landroid/graphics/RectF;", "getDstRectF", "()Landroid/graphics/RectF;", "setDstRectF", "(Landroid/graphics/RectF;)V", "dstRectF", "Landroid/graphics/PointF;", "c", "Landroid/graphics/PointF;", "getStartPoint", "()Landroid/graphics/PointF;", "setStartPoint", "(Landroid/graphics/PointF;)V", "startPoint", "", "d", "F", "getOffset", "()F", "setOffset", "(F)V", "offset", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "paint", "Landroid/graphics/Bitmap;", "f", "Landroid/graphics/Bitmap;", "getSrcBitmap", "()Landroid/graphics/Bitmap;", "setSrcBitmap", "(Landroid/graphics/Bitmap;)V", "srcBitmap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionConstraintLayout extends ConstraintLayout {
    public int a;
    public RectF b;
    public PointF c;
    public float d;
    public Paint e;
    public Bitmap f;
    public PorterDuffXfermode g;

    public static final class a {
    }

    static {
    }

    public TransitionConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TransitionConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final RectF getDstRectF() {
        return this.b;
    }

    public final float getOffset() {
        return this.d;
    }

    public final Paint getPaint() {
        return this.e;
    }

    public final Bitmap getSrcBitmap() {
        return this.f;
    }

    public final PointF getStartPoint() {
        return this.c;
    }

    public final int getTransitionType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
    L4:
        e = move-exception;
        ALogger.e("TransitionConstraintLayout", "dispatchTouchEvent error", e);
        SafetyGuard.a(null, e, null);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super/*android.view.ViewGroup*/.draw(r12);
        if (this.a != 0) goto L5;
        return;
    L5:
        ALogger.i("TransitionConstraintLayout", "draw type: " + this.a);
        int r0 = this.a;
        if (r0 != 1) goto L8;
        Bitmap r1 = this.f;
        if (r1 == null) goto L22;
        this.e.setXfermode(this.g);
        r12.drawBitmap(r1, null, this.b, this.e);
        this.e.setXfermode(null);
        return;
    L22:
        return;
    L8:
        if (r0 != 2) goto L20;
        Bitmap r2 = this.f;
        if (r2 == null) goto L21;
        RectF r3 = new RectF(0.0f, 0.0f, this.b.left, getHeight());
        RectF r4 = this.b;
        RectF r5 = new RectF(r4.left, 0.0f, r4.right, r4.top);
        RectF r6 = new RectF(this.b.right, 0.0f, getWidth(), getHeight());
        RectF r7 = this.b;
        RectF r8 = new RectF(r7.left, r7.bottom, r7.right, getHeight());
        this.e.setXfermode(this.g);
        this.e.setColor(0);
        r12.drawRect(r3, this.e);
        r12.drawRect(r5, this.e);
        r12.drawRect(r6, this.e);
        r12.drawRect(r8, this.e);
        this.e.setColor(-1);
        r12.drawBitmap(r2, null, this.b, this.e);
        this.e.setXfermode(null);
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDstRectF(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ALogger.i("TransitionConstraintLayout", "set dstRectF: " + r3);
        this.b = r3;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOffset(float r6) {
        ALogger.i("TransitionConstraintLayout", "set offset: " + r6);
        this.d = r6;
        PointF r1 = this.c;
        float r2 = r1.x;
        float r3 = r1.y;
        setDstRectF(new RectF(r2 - r6, r3 - r6, r2 + r6, r3 + r6));
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPaint(Paint r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ALogger.i("TransitionConstraintLayout", "set paint, some info: " + r3.getStyle());
        this.e = r3;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSrcBitmap(Bitmap r3) {
        ALogger.i("TransitionConstraintLayout", "set srcBitmap");
        this.f = r3;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setStartPoint(PointF r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ALogger.i("TransitionConstraintLayout", "set startPoint: " + r3);
        this.c = r3;
        setOffset(this.d);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTransitionType(int r3) {
        ALogger.i("TransitionConstraintLayout", "set transitionType: " + r3);
        if (r3 == 0) goto L5;
        setWillNotDraw(false);
    L5:
        this.a = r3;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setXfermode(PorterDuff.Mode r3) {
        Intrinsics.checkNotNullParameter(r3, "newMode");
        ALogger.i("TransitionConstraintLayout", "set xfermode: " + r3);
        this.g = new PorterDuffXfermode(r3);
        invalidate();
    }

    public TransitionConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new RectF();
        this.c = new PointF(0.0f, 0.0f);
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        Unit r6 = Unit.INSTANCE;
        this.e = r5;
        this.g = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public /* synthetic */ TransitionConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
