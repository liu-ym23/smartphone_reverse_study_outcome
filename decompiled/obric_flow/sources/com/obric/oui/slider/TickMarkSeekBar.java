package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.reflect.w;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.m;
import com.obric.oui.common.style.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import jp.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001:\u0002H+B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\f2\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\f2\b\b\u0001\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\f2\b\b\u0001\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0011J\u0017\u0010 \u001a\u00020\f2\b\b\u0001\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b \u0010\u0011J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u0011J\u0015\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u0011J\u0017\u0010&\u001a\u00020\f2\b\b\u0001\u0010%\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u0011J\u0017\u0010(\u001a\u00020\f2\b\b\u0001\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\u0011J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0011J\u0017\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0012H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0012H\u0002¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103R*\u00109\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00100\"\u0004\b8\u0010\u0015R\u001b\u0010=\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u00103R*\u0010C\u001a\u00020\n2\u0006\u00104\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010\u000eR\"\u0010G\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00106\u001a\u0004\bE\u00100\"\u0004\bF\u0010\u0015¨\u0006I"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "enabled", "", "setDebugLogEnabled", "(Z)V", "tickMarkCount", "setDefaultTickMarkCount", "(I)V", "", "backgroundHeight", "setBackgroundHeight", "(F)V", "backgroundColor", "setProcessBackgroundColorInt", "progressColor", "setProcessProgressColorInt", "backgroundColorResId", "setProcessBackgroundColor", "progressColorResId", "setProcessProgressColor", "color", "setTickColorInt", "setTickColor", "minVisibleProgress", "setMinVisibleProgress", "maxVisibleProgress", "setMaxVisibleProgress", "thumbColor", "setThumbColorInt", "thumbColorResId", "setThumbColor", NotificationCompat.CATEGORY_PROGRESS, "setProgress", "Lcom/obric/oui/slider/b;", "l", "setOnSeekBarChangeListenerExt", "(Lcom/obric/oui/slider/b;)V", "getTrackStartX", "()F", "getTrackEndX", "getCompatMinValue", "()I", "value", "j", "F", "getCurrentProgress", "setCurrentProgress", "currentProgress", "I", "Lkotlin/Lazy;", "getTouchSlop", "touchSlop", ExifInterface.GPS_DIRECTION_TRUE, "Z", "getEnableMoveThumbOnDownOutside", "()Z", "setEnableMoveThumbOnDownOutside", "enableMoveThumbOnDownOutside", "U", "getMTouchProgressOffset", "setMTouchProgressOffset", "mTouchProgressOffset", "ib/d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TickMarkSeekBar extends AppCompatSeekBar {
    public static final /* synthetic */ int W = 0;
    public final m A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final float H;
    public final Lazy I;
    public float J;
    public float K;
    public boolean L;
    public boolean M;
    public int N;
    public float O;
    public MotionEvent P;
    public final com.obric.oui.lisitem.a Q;
    public final boolean R;
    public boolean S;
    public boolean T;
    public float U;
    public b V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14533c;
    public final float d;
    public final float e;
    public final float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f14535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f14538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f14539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f14540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14542p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14543q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f14544r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f14545t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Path f14546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f14547v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f14548w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f14549x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14550y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final al.a f14551z;

    static {
    }

    @JvmOverloads
    public TickMarkSeekBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(TickMarkSeekBar r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.B == false) goto L22;
        if (r5.F == true) goto L22;
        if (r5.L == true) goto L22;
        if (r5.M == true) goto L22;
        if (r5.D == true) goto L22;
        MotionEvent r10 = r5.P;
        r5.P = null;
        r5.removeCallbacks(r5.Q);
        if (r10 != null) goto L17;
        return;
    L17:
        if (r5.S == false) goto L20;
        StringBuilder r11 = new StringBuilder("[delayed-track-run][");
        r11.append(Integer.toHexString(System.identityHashCode(r5)));
        r11.append("] ");
        r11.append("action=" + ib.d.e(r10.getAction()) + ", x=" + r10.getX() + ", progress=" + r5.getProgress() + ", currentProgress=" + r5.getCurrentProgress());
        ps.a.a("TickSeekBar", r11.toString());
    L20:
        r5.t(r10);
        r10.recycle();
        return;
    L22:
        if (r5.S == false) goto L25;
        StringBuilder r12 = new StringBuilder("[delayed-track-skip][");
        r12.append(Integer.toHexString(System.identityHashCode(r5)));
        r12.append("] ");
        r12.append("isPress=" + r5.B + ", isInternalUpdating=" + r5.F + ", hasDirectionLocked=" + r5.L + ", isDraggingHorizontally=" + r5.M + ", isThumbOnTouchDown=" + r5.D);
        ps.a.a("TickSeekBar", r12.toString());
    L25:
        r5.f();
    }

    public static final /* synthetic */ float b(TickMarkSeekBar r5) {
        return r5.getCurrentProgress();
    }

    public static final /* synthetic */ void c(TickMarkSeekBar r5, float r10) {
        r5.setCurrentProgress(r10);
    }

    private final int getCompatMinValue() {
        return getMin();
    }

    private final float getCurrentProgress() {
        return this.f14536j;
    }

    private final int getTouchSlop() {
        return ((Number) this.I.getValue()).intValue();
    }

    private final float getTrackEndX() {
        return (getWidth() - this.H) - (this.f / 2.0f);
    }

    private final float getTrackStartX() {
        return (this.f / 2.0f) + this.H;
    }

    public static float q(int r5) {
        return Float.parseFloat(String.format(Locale.CHINA, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r5 / 100)}, 1)));
    }

    private final void setCurrentProgress(float r5) {
        this.f14536j = r5;
    }

    public final void d() {
        if (this.f14550y == false) goto L35;
        int r5 = 0;
        IntRange r10 = RangesKt.until(0, this.f14531a);
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<Integer> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.add(Integer.valueOf(o(((IntIterator) r12).nextInt())));
        goto L6
    L8:
        Iterator<Integer> r13 = CollectionsKt.getIndices(r11).iterator();
        if (r13.hasNext() == true) goto L11;
        Integer r14 = null;
    L21:
        Integer r15 = r14;
        if (r15 == null) goto L25;
        r5 = r15.intValue();
    L25:
        int r16 = ((Number) r11.get(r5)).intValue();
        androidx.core.content.res.a r17 = new androidx.core.content.res.a(r5, 6, this);
        boolean r18 = r(r16, r17);
        if (this.S == false) goto L29;
        StringBuilder r19 = new StringBuilder("[anchor-point][");
        r19.append(Integer.toHexString(System.identityHashCode(this)));
        r19.append("] ");
        r19.append("closestTickIndex=" + r5 + ", closestProgress=" + r16 + ", currentProgress=" + getCurrentProgress() + ", result=" + r18);
        ps.a.a("TickSeekBar", r19.toString());
    L29:
        if (r18 == true) goto L36;
        r17.run();
        return;
    L36:
        return;
    L11:
        Integer r20 = r13.next();
        if (r13.hasNext() == true) goto L14;
    L13:
        r14 = r20;
        goto L21
    L14:
        int r21 = Math.abs(((Number) r11.get(r20.intValue())).intValue() - getProgress());
    L15:
        Integer r22 = r13.next();
        int r23 = Math.abs(((Number) r11.get(r22.intValue())).intValue() - getProgress());
        if (r21 <= r23) goto L19;
        r20 = r22;
        r21 = r23;
    L19:
        if (r13.hasNext() == true) goto L15;
    }

    public final float e(float r5) {
        float r10 = getTrackStartX();
        float r11 = getTrackEndX() - r10;
        if (r11 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn((p(r5) - r10) / r11, 0.0f, 1.0f);
    }

    public final void f() {
        MotionEvent r5 = this.P;
        if (r5 == null) goto L6;
        r5.recycle();
    L6:
        this.P = null;
        removeCallbacks(this.Q);
    }

    public final void g(MotionEvent r5) {
        if (this.S == false) goto L10;
        StringBuilder r10 = new StringBuilder("[internal-update-cancel][");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("] ");
        StringBuilder r11 = new StringBuilder("action=");
        if (r5 != null) goto L8;
        int r12 = -1;
    L9:
        r11.append(ib.d.e(r12));
        r11.append(", progress=");
        r11.append(getProgress());
        r11.append(", currentProgress=");
        r11.append(getCurrentProgress());
        r11.append(", touchOffset=");
        r11.append(getMTouchProgressOffset());
        r10.append(r11.toString());
        ps.a.a("TickSeekBar", r10.toString());
        goto L10
    L8:
        r12 = r5.getActionMasked();
    L10:
        this.B = false;
        n();
        if (r5 == null) goto L14;
        MotionEvent r13 = MotionEvent.obtain(r5);
        r13.setAction(3);
        super.onTouchEvent(r13);
        r13.recycle();
    L14:
        this.F = false;
    }

    public final boolean getEnableMoveThumbOnDownOutside() {
        return this.T;
    }

    public final float getMTouchProgressOffset() {
        return this.U;
    }

    public final float h() {
        float r5 = getWidth();
        float r10 = this.H;
        float r11 = this.f;
        float r12 = ((r5 - r10) - r10) - r11;
        return ((getCurrentProgress() / getMax()) * r12) + ((r11 / 2.0f) + r10);
    }

    public final void i(Canvas r10) {
        r10.save();
        float r5 = this.f14532b / 2;
        RectF r11 = this.f14547v;
        float r12 = this.f14533c;
        float r13 = getWidth();
        float r14 = this.H;
        r11.set(r14, r12 - r5, r13 - r14, r12 + r5);
        Path r15 = this.f14546u;
        r15.reset();
        r15.addRoundRect(r11, r5, r5, Path.Direction.CW);
        Paint r16 = this.f14545t;
        r16.setColor(this.f14541o);
        r10.drawPath(r15, r16);
        r10.restore();
        if (this.f14550y == false) goto L6;
        l(r10);
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "dr");
        super.invalidateDrawable(r5);
    }

    public final void j(Canvas r13) {
        int r5 = r13.save();
        if (getProgressDrawable() == null) goto L5;
        Drawable r10 = getProgressDrawable();
        r13.translate(0.0f, getPaddingTop());
        r10.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r10.getIntrinsicHeight() / 2), getMeasuredWidth(), (r10.getIntrinsicHeight() / 2) + (getMeasuredHeight() / 2)));
        r10.draw(r13);
    L6:
        r13.restoreToCount(r5);
        return;
    L5:
        float r11 = this.f14532b / 2;
        float r12 = h();
        float r14 = (this.f * this.g) / 2.0f;
        RectF r15 = this.f14547v;
        float r16 = this.f14533c;
        r15.set(this.H, r16 - r11, r12, r16 + r11);
        Path r17 = this.f14549x;
        r17.reset();
        Path.Direction r18 = Path.Direction.CW;
        r17.addRoundRect(r15, new float[]{r11, r11, 0.0f, 0.0f, 0.0f, 0.0f, r11, r11}, r18);
        Paint r19 = this.f14545t;
        r19.setColor(this.f14542p);
        Path r110 = this.f14546u;
        r110.reset();
        r110.addCircle(r12, r16, r14, r18);
        r13.clipOutPath(r110);
        r13.drawPath(r17, r19);
        goto L6
    }

    public final void k(Canvas r13) {
        if (this.f14543q != 0) goto L5;
        return;
    L5:
        r13.save();
        float r5 = this.f * this.g;
        float r10 = h();
        Paint r11 = this.f14545t;
        r11.setColor(this.f14543q);
        RectF r12 = this.f14547v;
        float r14 = r5 / 2.0f;
        float r15 = this.f14533c;
        r12.set(r10 - r14, r15 - r14, r10 + r14, r15 + r14);
        r13.drawRoundRect(r12, r14, r14, r11);
        r13.restore();
        r13.save();
        Intrinsics.checkNotNullParameter(r13, "canvas");
        m r16 = this.A;
        Intrinsics.checkNotNullParameter(r16, "shadow");
        Intrinsics.checkNotNullParameter(r12, SVGRenderEngine.RECT);
        float r17 = r16.g;
        if (r17 > 0.0f) goto L9;
        r17 = r14;
    L9:
        Path r18 = new Path();
        pp.b r19 = o.f12520a;
        Intrinsics.checkNotNullParameter(r18, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r12, SVGRenderEngine.RECT);
        r18.addPath(o.a(r12, r17));
        int r20 = r13.save();
        RectF r21 = new RectF(r12);
        r21.offset(r16.f12518c, r16.d);
        float r110 = -r16.e;
        r21.inset(r110, r110);
        r13.clipOutPath(r18);
        int r22 = r16.f12516a;
        Paint r111 = r16.f;
        r111.setColor(r22);
        if (r16.f12517b <= 0.0f) goto L12;
        r111.setMaskFilter(new BlurMaskFilter(r16.f12517b, BlurMaskFilter.Blur.NORMAL));
    L12:
        o.e(r13, r21, r17, r111);
        r13.restoreToCount(r20);
        r13.restore();
        float r23 = this.O / 2.0f;
        RectF r24 = this.f14548w;
        r24.set(r12);
        float r25 = -r23;
        r24.inset(r25, r25);
        Paint.Style r26 = r11.getStyle();
        float r27 = r11.getStrokeWidth();
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeWidth(this.O);
        r11.setColor(this.f14544r);
        float r28 = r14 + r23;
        r13.drawRoundRect(r24, r28, r28, r11);
        r11.setStrokeWidth(r27);
        r11.setStyle(r26);
    }

    public final void l(Canvas r11) {
        if (this.f14531a > 0) goto L5;
        return;
    L5:
        if (this.f14550y == false) goto L11;
        float r5 = getWidth();
        float r10 = this.H;
        float r12 = this.f;
        int r13 = this.f14531a;
        float r14 = (((r5 - r10) - r10) - r12) / (r13 - 1);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        int r16 = r15 + 1;
        float r17 = (r12 / 2.0f) + this.f14533c;
        float r18 = this.f14540n;
        Paint r19 = this.f14545t;
        r19.setColor(this.s);
        r11.drawCircle((r15 * r14) + ((r12 / 2.0f) + r10), r17 - r18, r18, r19);
        r15 = r16;
        goto L7
    L12:
        return;
    }

    public final boolean m(float r10) {
        float r5 = p(r10);
        boolean r11 = false;
        if (r5 > getTrackStartX()) goto L5;
        boolean r12 = true;
    L7:
        if (r5 < getTrackEndX()) goto L9;
        boolean r13 = true;
    L10:
        if (r12 == true) goto L12;
        if (r13 == true) goto L12;
    L13:
        if (r11 == true) goto L15;
    L18:
        return r11;
    L15:
        if (this.S == false) goto L18;
        StringBuilder r14 = new StringBuilder("[track-edge-hit][");
        r14.append(Integer.toHexString(System.identityHashCode(this)));
        r14.append("] ");
        r14.append("rawX=" + r10 + ", logicalX=" + r5 + ", hitStart=" + r12 + ", hitEnd=" + r13 + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX());
        ps.a.a("TickSeekBar", r14.toString());
    L12:
        r11 = true;
        goto L13
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L7
    }

    public final void n() {
        if (this.S == false) goto L6;
        StringBuilder r5 = new StringBuilder("[reset-touch-state][");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append("] ");
        r5.append("isThumbOnTouchDown=" + this.D + ", isThumbOnTouchEvent=" + this.E + ", hasDirectionLocked=" + this.L + ", isDraggingHorizontally=" + this.M);
        ps.a.a("TickSeekBar", r5.toString());
    L6:
        this.D = false;
        this.E = false;
        this.L = false;
        this.M = false;
        f();
        s(false);
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    public final int o(int r5) {
        int r10 = this.f14531a;
        if (r10 > 1) goto L6;
        return 0;
    L6:
        if (r5 > 0) goto L10;
        return getCompatMinValue();
    L10:
        if (r5 >= (r10 - 1)) goto L12;
        int r11 = getCompatMinValue();
        int r12 = getMax() - r11;
        return MathKt.roundToInt(((r5 / (this.f14531a - 1)) * r12) + r11);
    L12:
        return getMax();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.N = com.lynx.tasm.utils.a.B(32, this);
        this.O = com.lynx.tasm.utils.a.F(this, 0.5d);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "canvas");     // Catch: Throwable -> L6
        if (this.G == false) goto L8;
        this.G = false;     // Catch: Throwable -> L6
        setCurrentProgress(getProgress());     // Catch: Throwable -> L6
    L8:
        i(r5);     // Catch: Throwable -> L6
        l(r5);     // Catch: Throwable -> L6
        j(r5);     // Catch: Throwable -> L6
        k(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(this.N, BasicMeasure.EXACTLY));
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r26) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        String r10 = "action=";
        if (this.S == false) goto L22;
        StringBuilder r5 = new StringBuilder("[touch-enter][");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append("] ");
        StringBuilder r14 = new StringBuilder("action=");
        if (r26 != null) goto L11;
        int r15 = -1;
    L12:
        r14.append(ib.d.e(r15));
        r14.append(", x=");
        if (r26 != null) goto L15;
        Float r16 = null;
    L16:
        r14.append(r16);
        r14.append(", y=");
        if (r26 != null) goto L19;
        Float r17 = null;
    L20:
        r14.append(r17);
        r14.append(", progress=");
        r14.append(getProgress());
        r14.append(", currentProgress=");
        r14.append(getCurrentProgress());
        r14.append(", isPress=");
        r14.append(this.B);
        r14.append(", isInternalUpdating=");
        r14.append(this.F);
        r14.append(", touchOffset=");
        r14.append(getMTouchProgressOffset());
        r5.append(r14.toString());
        ps.a.a("TickSeekBar", r5.toString());
        goto L22
    L19:
        r17 = Float.valueOf(r26.getY());
        goto L20
    L15:
        r16 = Float.valueOf(r26.getX());
        goto L16
    L11:
        r15 = r26.getActionMasked();
    L22:
        if (this.F == true) goto L24;
        float r11 = this.H;
        float r12 = this.f;
        int r13 = (int) ((r12 / 2) + ((int) r11));
        setPadding(r13, 0, r13, 0);
        if (r26 != null) goto L36;
        Integer r18 = null;
    L37:
        if (r26 != null) goto L39;
        Integer r19 = null;
    L41:
        if (r19 != null) goto L44;
    L50:
        if (r18 != null) goto L53;
    L54:
        if (r18 != null) goto L57;
        String r20 = ", progress=";
    L60:
        this.B = false;
        this.D = false;
        this.E = false;
        f();
        invalidate();
        String r21 = ", offset=";
        r10 = "action=";
        String r22 = r20;
        boolean r110 = false;
        r26 = r26;
        r19 = r19;
    L154:
        if (r26 != null) goto L158;
    L155:
        String r111 = ", touchOffset=";
    L156:
        MotionEvent r23 = null;
    L191:
        if (r23 != null) goto L193;
        MotionEvent r24 = r26;
    L194:
        boolean r25 = super.onTouchEvent(r24);
        if (this.S == true) goto L197;
        String r27 = r10;
    L210:
        if (r23 == null) goto L214;
        r23.recycle();
        Unit r28 = Unit.INSTANCE;
    L214:
        if (this.F == false) goto L216;
        g(r26);
        boolean r29 = true;
    L217:
        if (r26 == null) goto L252;
        int r30 = r26.getAction();
        if (this.F == true) goto L251;
        if (r30 == 0) goto L231;
        if (r30 == 2) goto L226;
    L233:
        if (r30 == 1) goto L238;
        if (r30 != 3) goto L251;
    L238:
        if (this.S == false) goto L241;
        StringBuilder r31 = new StringBuilder("[touch-finish][");
        r31.append(Integer.toHexString(System.identityHashCode(this)));
        r31.append("] ");
        r31.append(r27 + ib.d.e(r30) + r22 + getProgress() + ", currentProgress=" + getCurrentProgress() + ", isStyleSegmented=" + this.f14550y + r111 + getMTouchProgressOffset());
        ps.a.a("TickSeekBar", r31.toString());
    L241:
        if (r30 == 1) goto L243;
    L250:
        n();
        goto L251
    L243:
        if (this.f14550y == false) goto L245;
        d();
    L246:
        b r32 = this.V;
        if (r32 == null) goto L250;
        ((we.a) r32).m(this, q(getProgress()));
        Unit r33 = Unit.INSTANCE;
        goto L250
    L245:
        r(getProgress(), null);
        goto L246
    L226:
        if (this.D == false) goto L228;
    L229:
        t(r26);
        goto L233
    L228:
        if (this.M == false) goto L233;
    L231:
        if (this.D == false) goto L233;
        t(r26);
    L251:
        Unit r34 = Unit.INSTANCE;
    L252:
        this.F = false;
        setPadding(0, 0, 0, 0);
        if (this.S == false) goto L260;
        StringBuilder r35 = new StringBuilder("[touch-exit][");
        r35.append(Integer.toHexString(System.identityHashCode(this)));
        r35.append("] ");
        StringBuilder r36 = new StringBuilder(r27);
        if (r19 != null) goto L258;
        int r37 = -1;
    L259:
        r36.append(ib.d.e(r37));
        r36.append(r22);
        r36.append(getProgress());
        r36.append(", currentProgress=");
        r36.append(getCurrentProgress());
        r36.append(", forceBreakTouch=");
        r36.append(r29);
        r35.append(r36.toString());
        ps.a.a("TickSeekBar", r35.toString());
        goto L260
    L258:
        r37 = r19.intValue();
    L260:
        if (r29 == false) goto L263;
        return false;
    L263:
        return r25;
    L216:
        r29 = r110;
        goto L217
    L197:
        StringBuilder r38 = new StringBuilder("[touch-super-result][");
        r38.append(Integer.toHexString(System.identityHashCode(this)));
        r38.append("] ");
        if (r23 != null) goto L200;
        MotionEvent r39 = r26;
    L201:
        r27 = r10;
        StringBuilder r40 = new StringBuilder(r27);
        if (r39 != null) goto L204;
        int r41 = -1;
    L205:
        r40.append(ib.d.e(r41));
        r40.append(", usedCorrectedEvent=");
        if (r23 == null) goto L208;
        boolean r42 = true;
    L209:
        r40.append(r42);
        r40.append(r22);
        r40.append(getProgress());
        r40.append(", currentProgress=");
        r40.append(getCurrentProgress());
        r40.append(", result=");
        r40.append(r25);
        r38.append(r40.toString());
        ps.a.a("TickSeekBar", r38.toString());
        goto L210
    L208:
        r42 = false;
        goto L209
    L204:
        r41 = r39.getActionMasked();
        goto L205
    L200:
        r39 = r23;
        goto L201
    L193:
        r24 = r23;
        goto L194
    L158:
        if (r26.getAction() == 0) goto L163;
        if (r26.getAction() != 2) goto L155;
    L163:
        if (this.D == true) goto L167;
        if (this.E == false) goto L155;
    L167:
        if (this.U == 0.0f) goto L155;
        if (m(r26.getX()) == true) goto L172;
        int r43 = getMax() - getCompatMinValue();
        if (r43 <= 0) goto L155;
        float r44 = e(r26.getX());
        float r45 = RangesKt.coerceIn((this.U / r43) + r44, 0.0f, 1.0f);
        float r112 = r12 / 2.0f;
        float r113 = r112 + r11;
        float r46 = (getWidth() - r11) - r112;
        r111 = ", touchOffset=";
        float r47 = (RangesKt.coerceIn(r45, 0.0f, 1.0f) * (r46 - r113)) + r113;
        if (getLayoutDirection() != 1) goto L184;
        if (this.R == false) goto L184;
        r47 = (r113 + r46) - r47;
    L184:
        if (r47 == r26.getX()) goto L156;
        if (this.S == false) goto L190;
        StringBuilder r48 = new StringBuilder("[native-event-correct][");
        r48.append(Integer.toHexString(System.identityHashCode(this)));
        r48.append("] ");
        r48.append("rawX=" + r26.getX() + ", scale=" + r44 + ", nativeScale=" + r45 + ", nativeX=" + r47 + r21 + getMTouchProgressOffset() + ", range=" + r43);
        ps.a.a("TickSeekBar", r48.toString());
    L190:
        r23 = MotionEvent.obtain(r26);
        r23.offsetLocation(r47 - r26.getX(), 0.0f);
        goto L191
    L172:
        if (this.S == false) goto L155;
        StringBuilder r49 = new StringBuilder("[native-event-skip-edge][");
        r49.append(Integer.toHexString(System.identityHashCode(this)));
        r49.append("] ");
        r49.append("x=" + r26.getX() + ", logicalX=" + p(r26.getX()) + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX() + r21 + getMTouchProgressOffset());
        ps.a.a("TickSeekBar", r49.toString());
        goto L155
    L57:
        r20 = ", progress=";
        if (r18.intValue() != 2) goto L60;
    L62:
        this.B = true;
        float r50 = h();
        float r114 = r12 / 2.0f;
        float r51 = (r50 - r114) - 30.0f;
        float r115 = (r114 + r50) + 30.0f;
        if (getEnableMoveThumbOnDownOutside() == false) goto L70;
        float r52 = r26.getX();
        if (r51 > r52) goto L70;
        if (r52 > r115) goto L70;
        this.E = true;
        if (this.S == false) goto L70;
        StringBuilder r53 = new StringBuilder("[thumb-hit-area][");
        r53.append(Integer.toHexString(System.identityHashCode(this)));
        r53.append("] ");
        StringBuilder r54 = new StringBuilder("action=");
        if (r19 != null) goto L74;
        int r210 = -1;
    L75:
        r54.append(ib.d.e(r210));
        r54.append(", x=");
        r54.append(r26.getX());
        r54.append(", thumbLeft=");
        r54.append(r51);
        r54.append(", thumbRight=");
        r54.append(r115);
        r53.append(r54.toString());
        ps.a.a("TickSeekBar", r53.toString());
    L76:
        if (r18 != null) goto L79;
    L77:
        r26 = r26;
        r22 = r20;
        r21 = ", offset=";
        r110 = false;
    L122:
        if (r19 != null) goto L125;
    L123:
        r110 = r110;
        r19 = r19;
    L147:
        if (this.D == false) goto L149;
    L152:
        boolean r55 = true;
    L153:
        s(r55);
        invalidate();
        goto L154
    L149:
        if (this.E == true) goto L152;
        r55 = false;
        goto L153
    L125:
        if (r19.intValue() != 2) goto L123;
        if (this.L == true) goto L123;
        float r56 = Math.abs(r26.getX() - this.J);
        float r57 = Math.abs(r26.getY() - this.K);
        if (r56 <= getTouchSlop()) goto L131;
    L132:
        this.L = true;
        if (r56 <= r57) goto L135;
        boolean r116 = true;
    L136:
        this.M = r116;
        f();
        if (this.S == false) goto L141;
        StringBuilder r117 = new StringBuilder("[direction-lock][");
        r117.append(Integer.toHexString(System.identityHashCode(this)));
        r117.append("] ");
        r117.append("dx=" + r56 + ", dy=" + r57 + ", touchSlop=" + getTouchSlop() + ", isDraggingHorizontally=" + this.M + ", isThumbOnTouchDown=" + this.D);
        ps.a.a("TickSeekBar", r117.toString());
    L141:
        if (this.M == false) goto L144;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L147
    L144:
        if (this.D == true) goto L147;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L147
    L135:
        r116 = false;
        goto L136
    L131:
        if (r57 <= getTouchSlop()) goto L123;
    L79:
        if (r18.intValue() != 0) goto L77;
        float r58 = r26.getX();
        if (r51 <= r58) goto L83;
    L100:
        r22 = r20;
        r21 = r1;
        if (getEnableMoveThumbOnDownOutside() == true) goto L107;
        this.B = false;
        this.D = false;
        this.E = false;
        r26 = r26;
        r26.setAction(1);
        if (this.S == false) goto L106;
        StringBuilder r59 = new StringBuilder("[touch-down-outside-break][");
        r59.append(Integer.toHexString(System.identityHashCode(this)));
        r59.append("] ");
        r59.append("x=" + r26.getX() + ", enableMoveThumbOnDownOutside=" + getEnableMoveThumbOnDownOutside());
        ps.a.a("TickSeekBar", r59.toString());
    L106:
        r110 = true;
    L108:
        if (r110 == true) goto L122;
        if (getEnableMoveThumbOnDownOutside() == false) goto L122;
        if (this.D == true) goto L122;
        this.U = 0.0f;
        b r60 = this.V;
        if (r60 == null) goto L117;
        ((we.a) r60).l(this);
        Unit r61 = Unit.INSTANCE;
    L117:
        this.P = MotionEvent.obtain(r26);
        postDelayed(this.Q, 150);
        if (this.S == false) goto L122;
        StringBuilder r62 = new StringBuilder("[delayed-track-schedule][");
        r62.append(Integer.toHexString(System.identityHashCode(this)));
        r62.append("] ");
        r62.append("x=" + r26.getX() + ", y=" + r26.getY() + ", delayMs=150");
        ps.a.a("TickSeekBar", r62.toString());
    L107:
        r110 = false;
        goto L108
    L83:
        if (r58 > r115) goto L100;
        this.D = true;
        float r63 = r26.getX();
        int r64 = getCompatMinValue();
        int r65 = getMax() - r64;
        if (r65 > 0) goto L87;
        this.U = 0.0f;
    L91:
        getParent().requestDisallowInterceptTouchEvent(true);
        b r66 = this.V;
        if (r66 == null) goto L96;
        ((we.a) r66).l(this);
        Unit r67 = Unit.INSTANCE;
    L96:
        if (this.S == true) goto L98;
        r22 = r20;
        r21 = r1;
        goto L107
    L98:
        StringBuilder r68 = new StringBuilder("[touch-down-thumb][");
        r68.append(Integer.toHexString(System.identityHashCode(this)));
        r68.append("] ");
        StringBuilder r69 = new StringBuilder("x=");
        r69.append(r26.getX());
        r21 = r1;
        r69.append(r21);
        r69.append(getMTouchProgressOffset());
        r22 = r20;
        r69.append(r22);
        r69.append(getProgress());
        r69.append(", currentProgress=");
        r69.append(getCurrentProgress());
        r68.append(r69.toString());
        ps.a.a("TickSeekBar", r68.toString());
        goto L107
    L87:
        float r70 = e(r63);
        this.U = getCurrentProgress() - ((r65 * r70) + r64);
        if (this.S == false) goto L91;
        StringBuilder r71 = new StringBuilder("[touch-offset-update][");
        r71.append(Integer.toHexString(System.identityHashCode(this)));
        r71.append("] ");
        r71.append("downX=" + r63 + ", scale=" + r70 + ", minValue=" + r64 + ", range=" + r65 + ", currentProgress=" + getCurrentProgress() + ", touchOffset=" + getMTouchProgressOffset());
        ps.a.a("TickSeekBar", r71.toString());
        goto L91
    L74:
        r210 = r19.intValue();
    L70:
        r10 = "action=";
        goto L76
    L53:
        if (r18.intValue() != 0) goto L54;
        r20 = ", progress=";
        goto L62
    L44:
        if (r19.intValue() != 0) goto L50;
        f();
        this.U = 0.0f;
        this.J = r26.getX();
        this.K = r26.getY();
        this.L = false;
        this.M = false;
        if (this.S == false) goto L50;
        StringBuilder r118 = new StringBuilder("[touch-down-init][");
        r118.append(Integer.toHexString(System.identityHashCode(this)));
        r118.append("] ");
        r118.append("x=" + r26.getX() + ", y=" + r26.getY() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", thumbCenter=" + h());
        ps.a.a("TickSeekBar", r118.toString());
        goto L50
    L39:
        r19 = Integer.valueOf(r26.getActionMasked());
        goto L41
    L36:
        r18 = Integer.valueOf(r26.getAction());
        goto L37
    L24:
        if (this.S == false) goto L31;
        StringBuilder r72 = new StringBuilder("[touch-break-internal-update][");
        r72.append(Integer.toHexString(System.identityHashCode(this)));
        r72.append("] ");
        StringBuilder r73 = new StringBuilder("action=");
        if (r26 != null) goto L29;
        int r74 = -1;
    L30:
        r73.append(ib.d.e(r74));
        r73.append(", progress=");
        r73.append(getProgress());
        r73.append(", currentProgress=");
        r73.append(getCurrentProgress());
        r72.append(r73.toString());
        ps.a.a("TickSeekBar", r72.toString());
        goto L31
    L29:
        r74 = r26.getActionMasked();
    L31:
        g(r26);
        return false;
    }

    public final float p(float r5) {
        float r10 = getTrackStartX();
        float r11 = getTrackEndX();
        if (getLayoutDirection() == 1) goto L5;
        return r5;
    L5:
        if (this.R == true) goto L7;
        return r5;
    L7:
        return (r10 + r11) - r5;
    }

    public final boolean r(float r12, final Runnable r13) {
        if (getCurrentProgress() != r12) goto L6;
        return false;
    L6:
        if (this.D == false) goto L8;
    L22:
        d r5 = this.f14539m;
        if (r5 == null) goto L26;
        int r10 = d.d;
        r5.a(false);
    L26:
        setCurrentProgress(r12);
        this.f14537k = getCurrentProgress();
        invalidate();
        if (r13 == null) goto L30;
        r13.run();
    L30:
        return true;
    L8:
        if (this.E == true) goto L22;
        if (this.f14537k != r12) goto L16;
        setCurrentProgress(r12);
        this.f14537k = r12;
        invalidate();
        if (r13 == null) goto L21;
        r13.run();
    L21:
        return true;
    L16:
        d r11 = this.f14539m;
        if (r11 == null) goto L20;
        int r14 = d.d;
        r11.a(false);
    L20:
        this.f14537k = r12;
        float r15 = getCurrentProgress();
        float r16 = this.f14537k;
        com.obric.common.oea.foundation.animation.spec.spring.b r17 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4);
        r17.f11323b = 0.1f;
        Unit r18 = Unit.INSTANCE;
        Float r19 = Float.valueOf(this.f14538l);
        Intrinsics.checkNotNullParameter(r17, "spec");
        hp.a r20 = new hp.a(r17, Float.valueOf(r15), Float.valueOf(r16), r19, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));
        Function3<String, Object, Object, Unit> r110 = new TickMarkSeekBar$toggleProgressChangedAnim$2(this);
        Intrinsics.checkNotNullParameter(r110, "callback");
        Function2<Boolean, Throwable, Unit> r21 = new TickMarkSeekBar$toggleProgressChangedAnim$3(r13);
        Intrinsics.checkNotNullParameter(r21, "callback");
        this.f14539m = new w(r20, r110, r21).x();
        invalidate();
        goto L21
    }

    public final void s(boolean r11) {
        if (this.C != r11) goto L5;
        return;
    L5:
        this.C = r11;
        d r5 = this.f14535i;
        if (r5 == null) goto L9;
        int r10 = d.d;
        r5.a(false);
    L9:
        float r12 = this.g;
        if (r11 == false) goto L12;
        float r13 = this.e;
    L13:
        com.obric.common.oea.foundation.animation.spec.spring.b r14 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4);
        Float r15 = Float.valueOf(this.f14534h);
        Intrinsics.checkNotNullParameter(r14, "spec");
        hp.a r16 = new hp.a(r14, Float.valueOf(r12), Float.valueOf(r13), r15, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));
        Function3<String, Object, Object, Unit> r17 = new TickMarkSeekBar$toggleThumbScaleAnim$1(this);
        Intrinsics.checkNotNullParameter(r17, "callback");
        this.f14535i = new w(r16, r17, null).x();
        return;
    L12:
        r13 = this.d;
        goto L13
    }

    public final void setBackgroundHeight(float r5) {
        this.f14532b = r5;
        invalidate();
    }

    public final void setDebugLogEnabled(boolean r5) {
        this.S = r5;
        if (r5 == false) goto L7;
        StringBuilder r10 = new StringBuilder("[config][");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("] ");
        r10.append("instanceDebug=" + r5 + ", globalDebug=false");
        ps.a.a("TickSeekBar", r10.toString());
        return;
    }

    public void setDefaultTickMarkCount(int r5) {
        this.f14531a = r5;
        invalidate();
    }

    public final void setEnableMoveThumbOnDownOutside(boolean r5) {
        this.T = r5;
    }

    public final void setMTouchProgressOffset(float r5) {
        this.U = r5;
    }

    public final void setMaxVisibleProgress(int r5) {
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setMinVisibleProgress(int r5) {
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(b r5) {
        this.V = r5;
        super.setOnSeekBarChangeListener(new a(this, 1));
    }

    public final void setProcessBackgroundColor(@ColorRes int r5) {
        this.f14541o = ContextCompat.getColor(getContext(), r5);
        invalidate();
    }

    public final void setProcessBackgroundColorInt(@ColorInt int r5) {
        this.f14541o = r5;
        invalidate();
    }

    public final void setProcessProgressColor(@ColorRes int r5) {
        this.f14542p = ContextCompat.getColor(getContext(), r5);
        invalidate();
    }

    public final void setProcessProgressColorInt(@ColorInt int r5) {
        this.f14542p = r5;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r5) {
        super.setProgress(r5);
        if (this.S == false) goto L6;
        StringBuilder r10 = new StringBuilder("[setProgress][");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("] ");
        r10.append("progress=" + r5 + ", isPress=" + this.B + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.f14537k);
        ps.a.a("TickSeekBar", r10.toString());
    L6:
        this.D = true;
        if (this.B == false) goto L9;
        this.F = true;
    L9:
        r(r5, null);
        this.D = false;
    }

    public final void setThumbColor(@ColorRes int r5) {
        this.f14543q = ContextCompat.getColor(getContext(), r5);
        invalidate();
    }

    public final void setThumbColorInt(@ColorInt int r5) {
        this.f14543q = r5;
        invalidate();
    }

    public final void setTickColor(@ColorRes int r5) {
        this.s = ContextCompat.getColor(getContext(), r5);
        invalidate();
    }

    public final void setTickColorInt(@ColorInt int r5) {
        this.s = r5;
        invalidate();
    }

    public final void t(MotionEvent r10) {
        int r5 = getCompatMinValue();
        int r11 = getMax() - r5;
        if (r11 > 0) goto L6;
        return;
    L6:
        if (m(r10.getX()) == false) goto L11;
        if (p(r10.getX()) > getTrackStartX()) goto L11;
        float r12 = r5;
    L17:
        if (this.S == false) goto L20;
        StringBuilder r13 = new StringBuilder("[track-touch][");
        r13.append(Integer.toHexString(System.identityHashCode(this)));
        r13.append("] ");
        r13.append("x=" + r10.getX() + ", logicalX=" + p(r10.getX()) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", newProgress=" + r12 + ", minValue=" + r5 + ", max=" + getMax() + ", touchOffset=" + getMTouchProgressOffset());
        ps.a.a("TickSeekBar", r13.toString());
    L20:
        r(r12, null);
        return;
    L11:
        if (m(r10.getX()) == true) goto L13;
    L15:
        float r14 = e(r10.getX()) * r11;
        float r15 = r5;
        r12 = RangesKt.coerceIn((r14 + this.U) + r15, r15, getMax());
        goto L17
    L13:
        if (p(r10.getX()) < getTrackEndX()) goto L15;
        r12 = getMax();
        goto L17
    }

    @JvmOverloads
    public TickMarkSeekBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ TickMarkSeekBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public TickMarkSeekBar(final Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        this.f14531a = -1;
        this.f14532b = com.lynx.tasm.utils.a.B(6, this);
        this.f14533c = com.lynx.tasm.utils.a.B(16, this);
        this.d = 1.0f;
        this.e = 1.22f;
        this.f = com.lynx.tasm.utils.a.B(18, this);
        this.g = 1.0f;
        this.f14540n = com.lynx.tasm.utils.a.B(2, this);
        Paint r5 = new Paint();
        this.f14545t = r5;
        this.f14546u = new Path();
        this.f14547v = new RectF();
        this.f14548w = new RectF();
        this.f14549x = new Path();
        al.a r10 = new al.a();
        r10.f313a = Integer.MAX_VALUE;
        this.f14551z = r10;
        m r11 = new m(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.A = r11;
        this.G = true;
        this.H = com.lynx.tasm.utils.a.B(12, this);
        this.I = LazyKt.lazy(new TickMarkSeekBar$touchSlop$2(r12));
        this.Q = new com.obric.oui.lisitem.a(this, 2);
        this.T = true;
        this.N = com.lynx.tasm.utils.a.B(32, this);
        this.O = com.lynx.tasm.utils.a.F(this, 0.5d);
        TypedArray r15 = r12.getTheme().obtainStyledAttributes(r13, R$styleable.TickMarkSeekBar, r14, 0);
        this.f14532b = r15.getDimensionPixelSize(R$styleable.TickMarkSeekBar_seekbarHeight, com.lynx.tasm.utils.a.B(6, this));
        this.f14541o = r15.getColor(R$styleable.TickMarkSeekBar_seekbarBackgroundColor, ContextCompat.getColor(r12, R$color.oui_basic_line_2));
        this.f14542p = r15.getColor(R$styleable.TickMarkSeekBar_seekbarProgressColor, ContextCompat.getColor(r12, R$color.oui_functional_blue_6));
        this.f14543q = r15.getColor(R$styleable.TickMarkSeekBar_seekbarThumbColor, ContextCompat.getColor(r12, R$color.oui_on_accent_default));
        this.f14544r = r15.getColor(R$styleable.TickMarkSeekBar_seekbarThumbStrokeColor, ContextCompat.getColor(r12, R$color.oui_basic_line_1));
        this.s = r15.getColor(R$styleable.TickMarkSeekBar_seekbarTickColor, ContextCompat.getColor(r12, R$color.oui_basic_line_2));
        setEnableMoveThumbOnDownOutside(r15.getBoolean(R$styleable.TickMarkSeekBar_seekbarEnableMoveThumbOnDownOutside, true));
        this.R = r15.getBoolean(R$styleable.TickMarkSeekBar_seekbarMirrorForRtl, false);
        r15.recycle();
        setOnSeekBarChangeListenerExt(null);
        r5.setStyle(Paint.Style.FILL);
        int r16 = R$style.OUIShadow_1;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "baseShadow");
        TypedArray r17 = r12.obtainStyledAttributes(r16, R$styleable.OUILayout);
        int r18 = R$styleable.OUILayout_oui_firstShadowColor;
        int r19 = R$styleable.OUILayout_oui_firstShadowBlur;
        int r20 = R$styleable.OUILayout_oui_firstOffsetX;
        int r21 = R$styleable.OUILayout_oui_firstOffsetY;
        int r22 = R$styleable.OUILayout_oui_firstShadowSpread;
        r11.f12516a = r17.getColor(r18, Color.parseColor("#00000000"));
        r11.f12517b = r17.getDimension(r19, 0.0f);
        r11.f12518c = r17.getDimension(r20, 0.0f);
        r11.d = r17.getDimension(r21, 0.0f);
        r11.e = r17.getDimension(r22, 0.0f);
        r17.recycle();
        setCurrentProgress(getProgress());
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r5, boolean r10) {
        super.setProgress(r5, r10);
        if (this.S == false) goto L7;
        StringBuilder r11 = new StringBuilder("[setProgressWithAnimate][");
        r11.append(Integer.toHexString(System.identityHashCode(this)));
        r11.append("] ");
        r11.append("progress=" + r5 + ", animate=" + r10 + ", isPress=" + this.B + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.f14537k);
        ps.a.a("TickSeekBar", r11.toString());
    L7:
        if (r10 == true) goto L10;
        this.D = true;
    L10:
        if (this.B == false) goto L12;
        this.F = true;
    L12:
        r(r5, null);
        this.D = false;
    }
}
