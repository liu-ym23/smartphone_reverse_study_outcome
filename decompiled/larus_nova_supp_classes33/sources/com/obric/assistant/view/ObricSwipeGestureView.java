package com.obric.assistant.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0004,-./B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0014J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0017J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/view/ObricSwipeGestureView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "minimumFlingVelocity", "distance", "", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "topMarginPx", "rectHeightPx", "rectWidthPx", "getRectWidthPx", "()I", "cornerRadiusPx", "listener", "Lcom/obric/assistant/view/ObricSwipeGestureView$OnSwipeGestureListener;", "setOnSwipeGestureListener", "", "swipeConfig", "Lcom/obric/assistant/view/ObricSwipeGestureView$SwipeConfig;", "setSwipeConfig", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "dpToPx", "dp", "Companion", "OnSwipeGestureListener", "SwipeConfig", "IconGestureListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSwipeGestureView extends View {
    public final GestureDetector a;
    public final int b;
    public float c;
    public final Paint d;
    public final RectF e;
    public final float f;
    public final int g;
    public final float h;
    public c i;
    public d j;

    public static final class a {
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ ObricSwipeGestureView a;

        public b(ObricSwipeGestureView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            c r0 = this.a.i;
            if (r0 == null) goto L7;
            r0.F4(new PointF(r4.getX(), r4.getY()));
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            Intrinsics.checkNotNullParameter(r5, "e2");
            ObricSwipeGestureView r8 = this.a;
            float r0 = r5.getRawY();
            if (r4 == null) goto L5;
            float r9 = r4.getRawY();
        L6:
            r8.c = r0 - r9;
            ObricSwipeGestureView r10 = this.a;
            int r11 = r10.b;
            if (r7 >= (-r11)) goto L16;
            float r12 = r10.c;
            if (r12 >= (-r10.j.a)) goto L16;
            c r13 = r10.i;
            if (r13 == null) goto L13;
            r13.s5(r12, r7);
        L13:
            this.a.c = 0.0f;
            return true;
        L16:
            if (r7 <= r11) goto L24;
            float r14 = r10.c;
            if (r14 <= r10.j.b) goto L26;
            c r15 = r10.i;
            if (r15 == null) goto L22;
            r15.s5(r14, r7);
        L22:
            this.a.c = 0.0f;
            return true;
        L26:
            return false;
        L24:
            return false;
        L5:
            r9 = r5.getRawY();
            goto L6
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            Intrinsics.checkNotNullParameter(r5, "e2");
            ObricSwipeGestureView r0 = this.a;
            float r1 = r5.getRawY();
            if (r4 == null) goto L5;
            float r2 = r4.getRawY();
        L6:
            r0.c = r1 - r2;
            ObricSwipeGestureView r3 = this.a;
            c r8 = r3.i;
            if (r8 == null) goto L10;
            r8.E(r3.c);
        L10:
            return super.onScroll(r4, r5, r6, r7);
        L5:
            r2 = r5.getRawY();
            goto L6
        }
    }

    public interface c {
        void E(float r1);

        void F4(PointF r1);

        void onDown(MotionEvent r1);

        void s5(float r1, float r2);
    }

    public static final class d {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "SwipeConfig(topDistance=" + this.a + ", downDistance=" + this.b + ')';
        }

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public ObricSwipeGestureView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricSwipeGestureView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getRectWidthPx() {
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L6;
        return i5.W();
    L6:
        return i5.h0();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        float r0 = (getWidth() - getRectWidthPx()) / 2.0f;
        this.e.set(r0, this.f, getRectWidthPx() + r0, this.f + this.g);
        RectF r1 = this.e;
        float r2 = this.h;
        r7.drawRoundRect(r1, r2, r2, this.d);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onTouchEvent action is ");
        r1.append(r6.getAction());
        r1.append(", isEnabled: ");
        r1.append(isEnabled());
        r1.append(", isVisible: ");
        boolean r3 = false;
        if (getVisibility() != 0) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("ObricSwipeGestureView", r1.toString());
        if (isEnabled() == true) goto L9;
    L31:
        return false;
    L9:
        if (getVisibility() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L31;
        this.a.onTouchEvent(r6);
        if (r6.getAction() != 0) goto L20;
        this.c = 0.0f;
        c r5 = this.i;
        if (r5 == null) goto L30;
        r5.onDown(r6);
    L30:
        return true;
    L20:
        if (r6.getAction() != 1) goto L22;
    L23:
        float r7 = this.c;
        if (r7 != 0.0f) goto L26;
        r3 = true;
    L26:
        if (r3 == true) goto L30;
        c r8 = this.i;
        if (r8 == null) goto L30;
        r8.s5(r7, 0.0f);
        goto L30
    L22:
        if (r6.getAction() != 3) goto L30;
    L11:
        r4 = false;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final void setOnSwipeGestureListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.i = r2;
    }

    public final void setSwipeConfig(d r2) {
        Intrinsics.checkNotNullParameter(r2, "swipeConfig");
        this.j = r2;
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        setMeasuredDimension(View.resolveSize(getRectWidthPx(), r4), View.resolveSize((int) (this.f + this.g), r5));
    }

    public ObricSwipeGestureView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new GestureDetector(r2, new b(this));
        this.b = ViewConfiguration.get(r2).getScaledMinimumFlingVelocity();
        Paint r5 = new Paint();
        r5.setColor(864059520);
        r5.setAntiAlias(true);
        r5.setStyle(Paint.Style.FILL);
        this.d = r5;
        this.e = new RectF();
        Resources r6 = getContext().getResources();
        this.f = TypedValue.applyDimension(1, 5.0f, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()));
        this.g = i5.Y();
        this.h = i5.z();
        this.j = new d(-60, 60);
    }

    public /* synthetic */ ObricSwipeGestureView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
