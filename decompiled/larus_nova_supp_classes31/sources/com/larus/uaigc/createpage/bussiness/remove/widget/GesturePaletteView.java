package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/GesturePaletteView;", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "midPntX", "", "midPntY", "touchingPointList", "", "Landroid/graphics/PointF;", "circlePaint", "Landroid/graphics/Paint;", "gestureDetector", "Landroid/view/GestureDetector;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "updateTouchingPoints", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GesturePaletteView extends PaletteView {
    public float V0;
    public float b1;
    public final List<PointF> g1;
    public final GestureDetector h1;
    public final ScaleGestureDetector k1;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ GesturePaletteView a;

        public a(GesturePaletteView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r3, "e2");
            if (r3.getPointerCount() <= 1) goto L6;
            this.a.setInDrawingPath(false);
            this.a.p(-r4, -r5);
            return true;
        L6:
            return false;
        }
    }

    public static final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public final /* synthetic */ GesturePaletteView a;

        public b(GesturePaletteView r1) {
            this.a = r1;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r4) {
            Intrinsics.checkNotNullParameter(r4, "detector");
            this.a.setInDrawingPath(false);
            GesturePaletteView r0 = this.a;
            float r5 = r4.getScaleFactor();
            GesturePaletteView r1 = this.a;
            r0.o(r5, r1.V0, r1.b1);
            return true;
        }
    }

    public GesturePaletteView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GesturePaletteView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView
    public final boolean onTouchEvent(MotionEvent r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
        return false;
    L5:
        ((ArrayList) this.g1).clear();
        if (r8.getActionMasked() != 0) goto L9;
        s();
    L9:
        if (r8.getPointerCount() <= 1) goto L11;
        float r4 = 2;
        this.V0 = (r8.getX(0) + r8.getX(1)) / r4;
        this.b1 = (r8.getY(0) + r8.getY(1)) / r4;
    L11:
        this.h1.onTouchEvent(r8);
        this.k1.onTouchEvent(r8);
        if (r8.getActionMasked() != 1) goto L14;
    L15:
        setImageToWrapCropBounds(true);
        invalidate();
    L17:
        if (this.k1.isInProgress() == false) goto L19;
    L23:
        setSingleTouchingPoint(null);
        ((ArrayList) this.g1).clear();
        if (r8.getPointerCount() != 2) goto L28;
        int r1 = r8.getPointerCount();
    L26:
        if (r0 >= r1) goto L28;
        ((ArrayList) this.g1).add(new PointF(r8.getX(r0), r8.getY(r0)));
        r0 = r0 + 1;
    L28:
        invalidate();
        return true;
    L19:
        if (r8.getPointerCount() > 1) goto L23;
        return super.onTouchEvent(r8);
    L14:
        if (r8.getActionMasked() != 3) goto L17;
        goto L15
    }

    public GesturePaletteView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g1 = new ArrayList();
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        r5.setColor(ColorProtector.parseColor("#BFCCCCCC"));
        r5.setAntiAlias(true);
        this.h1 = new GestureDetector(r2, new a(this));
        this.k1 = new ScaleGestureDetector(r2, new b(this));
    }

    public /* synthetic */ GesturePaletteView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
