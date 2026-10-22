package com.larus.setting.impl.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u0001:\u0002XYB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u000207H\u0002J(\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fH\u0014J\u000e\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020\u000fJ\b\u0010?\u001a\u000207H\u0002J\u0010\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020BH\u0014J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\rH\u0002J\u0010\u0010H\u001a\u0002072\u0006\u0010G\u001a\u00020\rH\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\rH\u0002J\u000e\u0010O\u001a\u0002072\u0006\u0010P\u001a\u00020QJ\u000e\u0010S\u001a\u0002072\u0006\u0010T\u001a\u00020\u000fJ\u0010\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0002J\b\u0010W\u001a\u000207H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larus/setting/impl/view/FontSizeSettingView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "mMargin", "", "mAxisColor", "", "mPointColor", "mCircleShadowColor", "mCircleStrokeColor", "mCircleColor", "mPointCount", "mCircleRadius", "mCurrentProgress", "mInitialPosition", "mItemWidth", "mHeight", "mWidth", "mAxisPaint", "Landroid/graphics/Paint;", "mPointPaint", "mCircleShadowPaintLarge", "mCircleShadowPaintSmall", "mCircleStrokePaint", "mCirclePaint", "mCircleX", "mCircleY", "lastTouchX", "isTrackingTouch", "", "mPoints", "", "Landroid/graphics/Point;", "standardDrawValue", "mAxisRect", "Landroid/graphics/RectF;", "mAxisHeight", "mAxisCornerRadius", "mPointRadius", "mPointEndMargin", "mAxisStartX", "mAxisEndX", "mPointStartX", "mPointEndX", "mAxisCenterY", "initAttrs", "", "onSizeChanged", "w", "h", "oldw", "oldh", "setPointCount", "count", "rebuildGeometry", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "stepProgressByTouchX", "x", "snapProgressByTouchX", "setProgressIfChanged", "newIndex", "getMidX", "leftIndex", "rightIndex", "getNearestIndex", "setChangeCallbackListener", "listener", "Lcom/larus/setting/impl/view/FontSizeSettingView$OnProgressChangeListener;", "onChangeListener", "setDefaultPosition", "position", "dp2px", "dp", "onAttachedToWindow", "Companion", "OnProgressChangeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FontSizeSettingView extends AppCompatTextView {
    public final RectF A;
    public final float B;
    public final float C;
    public final float D;
    public final float E;
    public float F;
    public float G;
    public float H;
    public b I;
    public AttributeSet a;
    public final float b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public Paint o;
    public Paint p;
    public Paint q;
    public Paint r;
    public Paint s;
    public Paint t;
    public float u;
    public float v;
    public float w;
    public boolean x;
    public final List<Point> y;
    public final float z;

    public static final class a {
    }

    public interface b {
        void a(int r1);

        void b(int r1);
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        int r0 = this.n;
        if (r0 > 0) goto L5;
        return;
    L5:
        if (this.h < 2) goto L23;
        float r1 = getHeight() * this.z;
        this.H = r1;
        this.v = r1;
        ((ArrayList) this.y).clear();
        float r2 = this.b;
        float r3 = r0;
        RectF r5 = this.A;
        float r6 = this.H;
        float r4 = 2;
        float r7 = this.B / r4;
        r5.set(r2, r6 - r7, r3 - r2, r6 + r7);
        float r8 = this.A.left;
        float r9 = this.E;
        this.F = r8 + r9;
        float r10 = (r3 - (this.b * r4)) - (r4 * r9);
        if (r10 > 0.0f) goto L11;
        FLogger.a.e("FontSizeSettingView", "rebuildGeometry, insufficient width: width=" + r0 + ", availableWidth=" + r10);
        return;
    L11:
        int r11 = this.h;
        this.l = (int) (r10 / (r11 - 1));
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        ((ArrayList) this.y).add(new Point(((int) this.F) + (this.l * r12), (int) this.H));
        r12 = r12 + 1;
        goto L12
    L14:
        this.G = ((Point) ListProtector.get(this.y, this.h - 1)).x;
        int r13 = this.k;
        if (r13 >= 0) goto L17;
    L19:
        FLogger.a.i("FontSizeSettingView", "onSizeChanged, default circleX = " + this.u + ", mInitialPosition = " + this.k + ", points = " + this.y);
        return;
    L17:
        if (r13 >= ((ArrayList) this.y).size()) goto L19;
        this.u = ((Point) ListProtector.get(this.y, this.k)).x;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L6;
        setScaleX(-1.0f);
        return;
    }

    public final AttributeSet getAttrs() {
        return this.a;
    }

    public FontSizeSettingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setProgressIfChanged(int r3) {
        int r4 = RangesKt.coerceIn(r3, 0, CollectionsKt.getLastIndex(this.y));
        int r0 = this.j;
        if (r4 != r0) goto L6;
        this.u = ((Point) ListProtector.get(this.y, r0)).x;
        invalidate();
        return;
    L6:
        this.j = r4;
        this.u = ((Point) ListProtector.get(this.y, r4)).x;
        a4.a.getClass();
        a4.a(5);
        b r5 = this.I;
        if (r5 == null) goto L9;
        r5.b(this.j);
    L9:
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super/*android.widget.TextView*/.onDraw(r7);
        if (CollectionUtils.isEmpty(this.y) == false) goto L6;
        FLogger.a.e("FontSizeSettingView", "mPoints is empty");
        return;
    L6:
        RectF r0 = this.A;
        float r1 = this.C;
        Paint r2 = this.o;
        Paint r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAxisPaint");
        r2 = null;
    L9:
        r7.drawRoundRect(r0, r1, r1, r2);
        Iterator r4 = ((ArrayList) this.y).iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        float r5 = ((Point) r4.next()).x;
        float r6 = this.H;
        float r8 = this.D;
        Paint r9 = this.p;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mPointPaint");
        r9 = null;
    L15:
        r7.drawCircle(r5, r6, r8, r9);
        goto L11
    L16:
        float r10 = this.u;
        float r11 = this.F;
        if (r10 >= r11) goto L19;
        this.u = r11;
    L19:
        float r12 = this.u;
        float r13 = this.G;
        if (r12 <= r13) goto L22;
        this.u = r13;
    L22:
        float r14 = this.u;
        float r15 = this.v;
        float r16 = this.i;
        Paint r17 = this.q;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCircleShadowPaintLarge");
        r17 = null;
    L25:
        r7.drawCircle(r14, r15, r16, r17);
        float r18 = this.u;
        float r19 = this.v;
        float r20 = this.i;
        Paint r21 = this.r;
        if (r21 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mCircleShadowPaintSmall");
        r21 = null;
    L28:
        r7.drawCircle(r18, r19, r20, r21);
        float r22 = this.u;
        float r23 = this.v;
        float r24 = this.i;
        Paint r25 = this.t;
        if (r25 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mCirclePaint");
        r25 = null;
    L31:
        r7.drawCircle(r22, r23, r24, r25);
        float r26 = this.u;
        float r27 = this.v;
        float r28 = this.i;
        Paint r29 = this.s;
        if (r29 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mCircleStrokePaint");
    L35:
        r7.drawCircle(r26, r27, r28, r3);
        return;
    L34:
        r3 = r29;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (((ArrayList) this.y).isEmpty() == true) goto L5;
        float r0 = RangesKt.coerceIn(r8.getX(), this.F, this.G);
        int r9 = r8.getAction();
        if (r9 != 0) goto L9;
        this.w = r0;
        this.x = true;
        ViewParent r10 = getParent();
        if (r10 == null) goto L63;
        r10.requestDisallowInterceptTouchEvent(true);
    L63:
        invalidate();
    L64:
        return true;
    L9:
        if (r9 != 1) goto L11;
        ViewParent r11 = getParent();
        if (r11 == null) goto L51;
        r11.requestDisallowInterceptTouchEvent(false);
    L51:
        if (this.l > 0) goto L53;
        int r12 = RangesKt.coerceIn(this.j, 0, CollectionsKt.getLastIndex(this.y));
    L54:
        setProgressIfChanged(r12);
        if (this.x == false) goto L59;
        b r13 = this.I;
        if (r13 == null) goto L59;
        r13.a(this.j);
    L59:
        this.x = false;
        goto L64
    L53:
        float r14 = RangesKt.coerceIn(r0, ((Point) CollectionsKt.first(this.y)).x, ((Point) CollectionsKt.last(this.y)).x);
        float r4 = r14 - ((Point) CollectionsKt.first(this.y)).x;
        float r5 = this.l;
        int r3 = RangesKt.coerceIn((int) ((r4 + (r5 / 2.0f)) / r5), 0, CollectionsKt.getLastIndex(this.y));
        FLogger.a.i("FontSizeSettingView", "getNearestIndex x=" + r0 + " clamped=" + r14 + " index=" + r3);
        r12 = r3;
        goto L54
    L11:
        if (r9 != 2) goto L13;
        ViewParent r15 = getParent();
        if (r15 == null) goto L27;
        r15.requestDisallowInterceptTouchEvent(true);
    L27:
        float r16 = r0 - this.w;
        if (r16 != 0.0f) goto L30;
        boolean r6 = true;
    L31:
        if (r6 == true) goto L46;
        int r7 = RangesKt.coerceIn(this.j, 0, CollectionsKt.getLastIndex(this.y));
        if (r16 <= 0.0f) goto L40;
        int r17 = RangesKt.coerceAtMost(r7 + 1, CollectionsKt.getLastIndex(this.y));
        if (r17 != r7) goto L38;
    L45:
        setProgressIfChanged(r7);
        goto L46
    L38:
        if (r0 < ((((Point) ListProtector.get(this.y, r7)).x + ((Point) ListProtector.get(this.y, r17)).x) / 2.0f)) goto L45;
    L44:
        r7 = r17;
        goto L45
    L40:
        r17 = RangesKt.coerceAtLeast(r7 - 1, 0);
        if (r17 == r7) goto L45;
        if (r0 > ((((Point) ListProtector.get(this.y, r17)).x + ((Point) ListProtector.get(this.y, r7)).x) / 2.0f)) goto L45;
    L46:
        this.w = r0;
        goto L64
    L30:
        r6 = false;
        goto L31
    L13:
        if (r9 != 3) goto L64;
        ViewParent r18 = getParent();
        if (r18 == null) goto L19;
        r18.requestDisallowInterceptTouchEvent(false);
    L19:
        if (this.x == false) goto L23;
        b r19 = this.I;
        if (r19 == null) goto L23;
        r19.a(this.j);
    L23:
        this.x = false;
        goto L64
    L5:
        return super/*android.widget.TextView*/.onTouchEvent(r8);
    }

    public final void setAttrs(AttributeSet r1) {
        this.a = r1;
    }

    public final void setChangeCallbackListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.I = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDefaultPosition(int r2) {
        this.k = r2;
        this.j = r2;
        if (r2 >= 0) goto L5;
    L7:
        b r3 = this.I;
        if (r3 == null) goto L10;
        r3.b(this.k);
    L10:
        invalidate();
        return;
    L5:
        if (r2 >= ((ArrayList) this.y).size()) goto L7;
        this.u = ((Point) ListProtector.get(this.y, r2)).x;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPointCount(int r3) {
        int r4 = RangesKt.coerceAtLeast(r3, 2);
        if (r4 != this.h) goto L5;
        return;
    L5:
        this.h = r4;
        if (this.n > 0) goto L8;
    L12:
        invalidate();
        return;
    L8:
        if (this.m <= 0) goto L12;
        y();
        int r5 = CollectionsKt.getLastIndex(this.y);
        if (r5 < 0) goto L12;
        this.k = RangesKt.coerceIn(this.k, 0, r5);
        int r6 = RangesKt.coerceIn(this.j, 0, r5);
        this.j = r6;
        this.u = ((Point) ListProtector.get(this.y, r6)).x;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float x(float r3) {
        Resources r0 = getContext().getResources();
        return TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FontSizeSettingView(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        this.a = r8;
        this.b = x(20.0f);
        AppHost.Companion r9 = AppHost.a;
        this.c = ContextCompat.getColor(r9.getApplication(), c.b(2130972086, r9.getApplication(), 2131103159));
        this.d = ContextCompat.getColor(r9.getApplication(), c.b(2130972088, r9.getApplication(), 2131103165));
        this.e = ColorProtector.parseColor("#1F000000");
        this.f = ContextCompat.getColor(r9.getApplication(), c.b(2130972086, r9.getApplication(), 2131103159));
        this.g = ContextCompat.getColor(r7, 2131103298);
        this.h = 6;
        this.i = x(16.0f);
        this.k = 2;
        this.y = new ArrayList();
        this.z = 0.5f;
        this.A = new RectF();
        this.B = x(16.0f);
        this.C = x(14.0f);
        this.D = x(4.0f);
        this.E = x(8.0f);
        TypedArray r10 = getContext().obtainStyledAttributes(this.a, new int[]{2130970517, 2130970934, 2130970935, 2130970936, 2130972115, 2130972116});
        this.h = r10.getInt(5, this.h);
        this.c = r10.getColor(0, this.c);
        this.d = r10.getColor(4, this.d);
        this.g = r10.getColor(1, this.g);
        this.f = r10.getColor(3, this.f);
        this.e = r10.getColor(2, this.e);
        r10.recycle();
        if (this.h >= 2) goto L5;
        this.h = 2;
    L5:
        Paint r11 = new Paint(1);
        r11.setColor(this.c);
        r11.setStyle(Paint.Style.FILL);
        this.o = r11;
        Paint r12 = new Paint(1);
        r12.setColor(this.d);
        r12.setStyle(Paint.Style.FILL);
        this.p = r12;
        setLayerType(1, null);
        Paint r13 = new Paint(1);
        r13.setColor(this.g);
        r13.setStyle(Paint.Style.FILL);
        this.t = r13;
        Paint r14 = new Paint(1);
        r14.setColor(this.f);
        r14.setStyle(Paint.Style.STROKE);
        r14.setStrokeWidth(x(0.5f));
        this.s = r14;
        Paint r15 = new Paint(1);
        r15.setColor(this.g);
        r15.setStyle(Paint.Style.FILL);
        r15.setShadowLayer(x(14.0f), 0.0f, x(4.0f), this.e);
        this.q = r15;
        Paint r16 = new Paint(1);
        r16.setColor(this.g);
        r16.setStyle(Paint.Style.FILL);
        r16.setShadowLayer(x(4.0f), 0.0f, 0.0f, this.e);
        this.r = r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        this.m = r2;
        this.n = r1;
        y();
    }
}
