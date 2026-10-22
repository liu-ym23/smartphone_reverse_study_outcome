package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b#\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001_B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\\\u00101\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u000b2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bJ\u0018\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u000207H\u0014J\u0010\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:H\u0016J0\u0010;\u001a\u00020\f2\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020=H\u0002J\u0010\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020=H\u0002J\b\u0010C\u001a\u00020\fH\u0002J&\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020=J\u0017\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010KJ \u0010L\u001a\u00020=2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0002J\b\u0010M\u001a\u00020=H\u0002J\b\u0010N\u001a\u00020=H\u0002J\b\u0010O\u001a\u00020=H\u0002J\b\u0010P\u001a\u00020=H\u0002J\b\u0010Q\u001a\u00020=H\u0002J\b\u0010R\u001a\u00020=H\u0002J\b\u0010S\u001a\u00020=H\u0002J\b\u0010T\u001a\u00020=H\u0002J\b\u0010U\u001a\u00020=H\u0002J\b\u0010V\u001a\u00020=H\u0002J\b\u0010W\u001a\u00020=H\u0002J\b\u0010X\u001a\u00020=H\u0002J\u0018\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007H\u0002J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0010\u0010^\u001a\u00020=2\u0006\u0010]\u001a\u00020\u0007H\u0002R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/CollaboratedDurationSliderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDurationChanged", "Lkotlin/Function1;", "", "getOnDurationChanged", "()Lkotlin/jvm/functions/Function1;", "setOnDurationChanged", "(Lkotlin/jvm/functions/Function1;)V", "onDurationTrackingStarted", "getOnDurationTrackingStarted", "setOnDurationTrackingStarted", "onDurationTrackingFinished", "getOnDurationTrackingFinished", "setOnDurationTrackingFinished", "lower", "upper", "step", "selected", "shouldShowDots", "", "valueFormatter", "", "upgradeBadgeWidthProvider", "trackRect", "Landroid/graphics/RectF;", "progressRect", "primaryColor", "textColor", "tertiaryTextColor", "trackColor", "dotColor", "thumbStrokeColor", "trackPaint", "Landroid/graphics/Paint;", "progressPaint", "dotPaint", "thumbPaint", "thumbStrokePaint", "valuePaint", "boundPaint", "bind", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "drawDots", "startX", "", "endX", "centerY", "progressX", "updateFromTouch", "x", "updateContentDescription", "upgradeBadgeLeftFor", "duration", "label", "badgeWidth", "badgeGap", "upgradeBadgeTop", "upgradeBadgeWidth", "(I)Ljava/lang/Integer;", "positionForDuration", "trackStartX", "trackEndX", "thumbCenterStartX", "thumbCenterEndX", "sliderHorizontalInset", "thumbCenterOffsetFromTrackEdge", "activeValueBadgeGap", "boundLabelHorizontalInset", "boundLabelBaselineY", "valueBaselineY", "trackCenterY", "thumbRadius", "resolveColor", "attr", "fallback", "dp", "value", "sp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollaboratedDurationSliderView extends View {
    public Function1<? super Integer, Unit> a;
    public Function1<? super Integer, Unit> b;
    public Function1<? super Integer, Unit> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public Function1<? super Integer, String> i;
    public Function1<? super Integer, Integer> j;
    public final RectF k;
    public final RectF l;
    public final int m;
    public final Paint n;
    public final Paint o;
    public final Paint p;
    public final Paint q;
    public final Paint r;
    public final Paint s;
    public final Paint t;

    public static final class a {
    }

    static {
    }

    public CollaboratedDurationSliderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CollaboratedDurationSliderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final float c() {
        return a(16);
    }

    public final void f() {
        Function1<? super Integer, String> r0 = this.i;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.invoke(Integer.valueOf(this.g));
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String[] r3 = new String[4];
        boolean r4 = false;
        r3[0] = r2;
        String r5 = j0.c(getContext(), null);
        if (h(this.g) == null) goto L11;
        r4 = true;
    L11:
        if (r4 == false) goto L13;
        r1 = r5;
    L13:
        r3[1] = r1;
        r3[2] = String.valueOf(this.d);
        r3[3] = String.valueOf(this.e);
        List r6 = CollectionsKt.filterNotNull(CollectionsKt.listOf(r3));
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        if ((!StringsKt.isBlank((String) r9)) == false) goto L15;
        r7.add(r9);
        goto L15
    L19:
        setContentDescription(CollectionsKt.joinToString$default(r7, " ", null, null, 0, null, null, 62, null));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final float d() {
        return RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(getWidth() - c(), c()) - a(15), getWidth() - a(18)), e());
    }

    public final float e() {
        return RangesKt.coerceAtLeast(c() + a(15), a(18));
    }

    public final Function1<Integer, Unit> getOnDurationChanged() {
        return this.a;
    }

    public final Function1<Integer, Unit> getOnDurationTrackingFinished() {
        return this.c;
    }

    public final Function1<Integer, Unit> getOnDurationTrackingStarted() {
        return this.b;
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void g(float r3) {
        float r0 = e();
        int r1 = this.d + (MathKt.roundToInt(RangesKt.coerceIn((r3 - r0) / RangesKt.coerceAtLeast(d() - r0, 1.0f), 0.0f, 1.0f) * RangesKt.coerceAtLeast((this.e - this.d) / this.f, 0)) * this.f);
        if (Math.abs(r1 - this.g) <= 0) goto L9;
        int r4 = RangesKt.coerceIn(r1, this.d, this.e);
        this.g = r4;
        Function1<? super Integer, Unit> r2 = this.a;
        if (r2 == null) goto L7;
        r2.invoke(Integer.valueOf(r4));
    L7:
        f();
        invalidate();
        return;
    }

    public final Integer h(int r3) {
        Function1<? super Integer, Integer> r0 = this.j;
        if (r0 == null) goto L13;
        Integer r4 = (Integer) r0.invoke(Integer.valueOf(r3));
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.intValue() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r1 = false;
        goto L10
    L13:
        return null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r21) {
        Intrinsics.checkNotNullParameter(r21, "canvas");
        super.onDraw(r21);
        float r2 = c();
        float r3 = RangesKt.coerceAtLeast(getWidth() - c(), c());
        float r4 = a(12);
        float r6 = (a(16) + a(18)) + a(8);
        int r9 = this.g;
        float r10 = e();
        float r11 = d();
        int r12 = this.e;
        int r13 = this.d;
        if (r12 <= r13) goto L6;
        r10 = r10 + (((r11 - r10) * (r9 - r13)) / (r12 - r13));
    L6:
        float r5 = r4 / 2.0f;
        this.k.set(r2, r6 - r5, r3, r5 + r6);
        RectF r7 = this.l;
        RectF r8 = this.k;
        r7.set(r2, r8.top, r10, r8.bottom);
        r21.drawRoundRect(this.k, a(10), a(10), this.n);
        Paint r14 = this.o;
        RectF r15 = this.l;
        float r16 = r15.left;
        int r17 = 0;
        r14.setShader(new LinearGradient(r16, 0.0f, RangesKt.coerceAtLeast(r15.right, 1.0f + r16), 0.0f, new int[]{this.m, Color.rgb(78, 148, 253)}, null, Shader.TileMode.CLAMP));
        r21.drawRoundRect(this.l, a(10), a(10), this.o);
        String r18 = null;
        this.o.setShader(null);
        if (this.h == false) goto L17;
        int r19 = RangesKt.coerceAtLeast((this.e - this.d) / this.f, 0) + 1;
        if (r19 <= 1) goto L17;
        float r20 = e();
        float r22 = d();
        float r110 = a(3);
    L12:
        if (r17 >= r19) goto L17;
        float r111 = ((r22 - r20) * (r17 / (r19 - 1))) + r20;
        if (r111 <= (r10 + r110)) goto L16;
        r21.drawCircle(r111, r6, r110, this.p);
    L16:
        r17 = r17 + 1;
    L17:
        Function1<? super Integer, String> r23 = this.i;
        if (r23 == null) goto L20;
        r18 = (String) r23.invoke(Integer.valueOf(this.g));
    L20:
        if (r18 != null) goto L23;
        r18 = "";
    L23:
        if ((!StringsKt.isBlank(r18)) == false) goto L36;
        Integer r24 = h(this.g);
        float r25 = 0.0f;
        if (r24 == null) goto L27;
        float r26 = r24.intValue();
    L28:
        float r27 = this.s.measureText(r18);
        if (r26 <= 0.0f) goto L31;
        r25 = a(2);
    L31:
        float r28 = ((r25 + r27) + r26) / 2.0f;
        float r29 = c();
        float r30 = r28 + r29;
        float r31 = (getWidth() - r28) - r29;
        if (r31 < r30) goto L34;
        float r32 = RangesKt.coerceIn(r10, r30, r31);
        float r33 = 2.0f;
    L35:
        r21.drawText(r18, (r32 - r28) + (r27 / r33), a(16), this.s);
        goto L36
    L34:
        r33 = 2.0f;
        r32 = getWidth() / 2.0f;
        goto L35
    L27:
        r26 = 0.0f;
    L36:
        float r34 = a(18);
        r21.drawCircle(r10, r6, r34, this.q);
        r21.drawCircle(r10, r6, r34, this.r);
        float r35 = a(20);
        float r36 = (((a(16) + a(18)) + a(8)) + a(18)) - this.t.getFontMetrics().ascent;
        r21.drawText(String.valueOf(this.d), r35, r36, this.t);
        this.t.setTextAlign(Paint.Align.RIGHT);
        r21.drawText(String.valueOf(this.e), getWidth() - r35, r36, this.t);
        this.t.setTextAlign(Paint.Align.LEFT);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = r4.getActionMasked();
        if (r0 == 0) goto L22;
        if (r0 != 1) goto L6;
    L13:
        ViewParent r1 = getParent();
        if (r1 == null) goto L17;
        r1.requestDisallowInterceptTouchEvent(false);
    L17:
        if (r4.getActionMasked() != 1) goto L21;
        Function1<? super Integer, Unit> r5 = this.c;
        if (r5 == null) goto L21;
        r5.invoke(Integer.valueOf(this.g));
    L21:
        return true;
    L6:
        if (r0 != 2) goto L8;
        g(r4.getX());
        return true;
    L8:
        if (r0 == 3) goto L13;
        return super.onTouchEvent(r4);
    L22:
        ViewParent r2 = getParent();
        if (r2 == null) goto L25;
        r2.requestDisallowInterceptTouchEvent(true);
    L25:
        Function1<? super Integer, Unit> r3 = this.b;
        if (r3 == null) goto L28;
        r3.invoke(Integer.valueOf(this.g));
    L28:
        g(r4.getX());
        return true;
    }

    public final void setOnDurationChanged(Function1<? super Integer, Unit> r1) {
        this.a = r1;
    }

    public final void setOnDurationTrackingFinished(Function1<? super Integer, Unit> r1) {
        this.c = r1;
    }

    public final void setOnDurationTrackingStarted(Function1<? super Integer, Unit> r1) {
        this.b = r1;
    }

    public final int b(int r3, int r4) {
        return ContextCompat.getColor(getContext(), v19.c.b(r3, getContext(), r4));
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        int r4 = View.resolveSize(a(80), r3);
        setMeasuredDimension(View.MeasureSpec.getSize(r2), r4);
    }

    public CollaboratedDurationSliderView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.f = 1;
        this.h = true;
        this.k = new RectF();
        this.l = new RectF();
        this.m = b(2130972123, 2131103203);
        int r11 = b(2130972079, 2131103136);
        int r12 = b(2130972081, 2131103143);
        int r0 = b(2130972086, 2131103159);
        int r1 = b(2130972087, 2131103162);
        int r2 = Color.argb(26, 0, 0, 0);
        Paint r4 = new Paint(1);
        r4.setStyle(Paint.Style.FILL);
        r4.setColor(r0);
        this.n = r4;
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.FILL);
        this.o = r3;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        r5.setColor(r1);
        this.p = r5;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.FILL);
        r6.setColor(-1);
        r6.setShadowLayer(a(6), 0.0f, a(3), Color.argb(20, 0, 0, 0));
        this.q = r6;
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.STROKE);
        r7.setStrokeWidth(a(1));
        r7.setColor(r2);
        this.r = r7;
        Paint r13 = new Paint(1);
        r13.setColor(r11);
        r13.setTextAlign(Paint.Align.CENTER);
        float r14 = 16;
        Resources r15 = getResources();
        r13.setTextSize(TypedValue.applyDimension(2, r14, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics())));
        r13.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.s = r13;
        Paint r16 = new Paint(1);
        r16.setColor(r12);
        r16.setTextAlign(Paint.Align.LEFT);
        Resources r17 = getResources();
        r16.setTextSize(TypedValue.applyDimension(2, r14, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics())));
        r16.setTypeface(Typeface.create("sans-serif", 0));
        this.t = r16;
        setLayerType(1, null);
        setImportantForAccessibility(1);
    }

    public /* synthetic */ CollaboratedDurationSliderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
