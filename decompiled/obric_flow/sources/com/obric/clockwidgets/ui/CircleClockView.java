package com.obric.clockwidgets.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.keva.KevaImpl;
import com.obric.clockwidgets.R$dimen;
import com.obric.clockwidgets.R$drawable;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/obric/clockwidgets/ui/CircleClockView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Ljava/util/TimeZone;", "tz", "", "setTimeZone", "(Ljava/util/TimeZone;)V", "", "tzId", "setTimeZoneId", "(Ljava/lang/String;)V", "Lep/a;", "j", "Lkotlin/Lazy;", "getDrawableRefreshLogic", "()Lep/a;", "drawableRefreshLogic", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RemoteViews.RemoteView
@SourceDebugExtension({"SMAP\nCircleClockView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircleClockView.kt\ncom/obric/clockwidgets/ui/CircleClockView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
public final class CircleClockView extends View {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f11266p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f11267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeZone f11268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11269c;
    public final int d;
    public final int e;
    public final Drawable f;
    public final RotateDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RotateDrawable f11270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RotateDrawable f11271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f11272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f11273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f11274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f11276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f11277o;

    @JvmOverloads
    public CircleClockView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(CircleClockView r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        long r5 = 1000;
        if (r10.getDrawableRefreshLogic().a() == false) goto L6;
        long r11 = System.currentTimeMillis();
        r10.d(r11 - (r11 % 1000));
    L6:
        if (r10.f11275m == false) goto L13;
        long r12 = 1000 - (System.currentTimeMillis() % 1000);
        Handler r13 = r10.f11274l;
        if (r12 <= 0) goto L11;
        r5 = r12;
    L11:
        r13.postDelayed(r10.f11276n, r5);
        return;
    }

    public static void c(RotateDrawable r5, int r10) {
        r5.setPivotX(0.5f);
        r5.setPivotY(1.0f - (r10 / r5.getIntrinsicHeight()));
    }

    private final ep.a getDrawableRefreshLogic() {
        return (ep.a) this.f11272j.getValue();
    }

    public final void b(Drawable r10, int r11, int r12, int r13) {
        int r5 = r10.getIntrinsicWidth();
        int r14 = r10.getIntrinsicHeight();
        int r15 = Math.max(1, MathKt.roundToInt(r5 * this.f11273k));
        float r16 = r14;
        int r17 = Math.max(1, MathKt.roundToInt(this.f11273k * r16));
        int r18 = r11 - (r15 / 2);
        int r19 = MathKt.roundToInt(r12 - (RangesKt.coerceIn(1.0f - (r13 / r16), 0.0f, 1.0f) * r17));
        r10.setBounds(r18, r19, r18 + r15, r17 + r19);
        if ((r10 instanceof RotateDrawable) == false) goto L6;
        ((RotateDrawable) r10).setPivotX(RangesKt.coerceIn((r11 - r18) / r15, 0.0f, 1.0f));
        return;
    }

    public final void d(long r10) {
        TimeZone r5 = this.f11268b;
        Calendar r11 = this.f11267a;
        r11.setTimeZone(r5);
        r11.setTimeInMillis(r10);
        int r12 = r11.get(10);
        int r13 = r11.get(12);
        float r14 = r11.get(13);
        float r15 = r14 / 60.0f;
        float r16 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        RotateDrawable r17 = this.f11271i;
        r17.setLevel((int) (r15 * r16));
        float r18 = r13;
        RotateDrawable r19 = this.f11270h;
        r19.setLevel((int) (((r15 + r18) / 60.0f) * r16));
        float r20 = r14 / 3600.0f;
        int r21 = (int) (((r20 + ((r18 / 60.0f) + r12)) / 12.0f) * r16);
        RotateDrawable r22 = this.g;
        r22.setLevel(r21);
        r17.invalidateSelf();
        r19.invalidateSelf();
        r22.invalidateSelf();
        invalidate();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a r5 = this.f11277o;
        removeCallbacks(r5);
        postDelayed(r5, 300);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11275m = false;
        this.f11274l.removeCallbacks(this.f11276n);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        this.f.draw(r5);
        this.g.draw(r5);
        this.f11270h.draw(r5);
        this.f11271i.draw(r5);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = MathKt.roundToInt(getResources().getDisplayMetrics().density * 136.0f);
        int r12 = getPaddingLeft() + r11;
        int r13 = getPaddingRight() + r12;
        int r14 = View.MeasureSpec.getMode(r5);
        int r15 = View.MeasureSpec.getSize(r5);
        if (r14 != Integer.MIN_VALUE) goto L5;
        r13 = Math.min(r13, r15);
    L9:
        setMeasuredDimension(r13, r13);
        return;
    L5:
        if (r14 != 1073741824) goto L9;
        r13 = r15;
        goto L9
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        int r13 = Math.min(r5, r10);
        int r14 = (r5 - r13) / 2;
        int r15 = (r10 - r13) / 2;
        this.f.setBounds(r14, r15, r14 + r13, r15 + r13);
        float r16 = getResources().getDisplayMetrics().density * 136.0f;
        if (r16 <= 0.0f) goto L5;
        float r17 = r13 / r16;
    L6:
        this.f11273k = r17;
        int r18 = r5 / 2;
        int r19 = r10 / 2;
        b(this.g, r18, r19, this.f11269c);
        b(this.f11270h, r18, r19, this.d);
        b(this.f11271i, r18, r19, this.e);
        return;
    L5:
        r17 = 1.0f;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "changedView");
        super.onVisibilityChanged(r5, r10);
        a r11 = this.f11277o;
        removeCallbacks(r11);
        postDelayed(r11, 300);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r5) {
        super.onWindowFocusChanged(r5);
        a r10 = this.f11277o;
        removeCallbacks(r10);
        postDelayed(r10, 300);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        a r10 = this.f11277o;
        removeCallbacks(r10);
        postDelayed(r10, 300);
    }

    public final void setTimeZone(TimeZone r5) {
        Intrinsics.checkNotNullParameter(r5, "tz");
        this.f11268b = r5;
        long r10 = System.currentTimeMillis();
        d(r10 - (r10 % 1000));
    }

    public final void setTimeZoneId(String r5) {
        if (r5 != null) goto L4;
    L7:
        TimeZone r10 = TimeZone.getDefault();
    L8:
        Log.d("CircleClockView", "setTimeZoneId: " + r5 + ", tz: " + r10);
        setTimeZone(r10);
        return;
    L4:
        if (r5.length() == 0) goto L7;
        r10 = TimeZone.getTimeZone(r5);
        goto L8
    }

    @JvmOverloads
    public CircleClockView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ CircleClockView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [com.obric.clockwidgets.ui.a] */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.obric.clockwidgets.ui.a] */
    @JvmOverloads
    public CircleClockView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f11267a = Calendar.getInstance();
        this.f11268b = TimeZone.getDefault();
        int r13 = getResources().getDimensionPixelSize(R$dimen.clock_hour_pivot_offset_square);
        this.f11269c = r13;
        int r14 = getResources().getDimensionPixelSize(R$dimen.clock_minute_pivot_offset_square);
        this.d = r14;
        int r15 = getResources().getDimensionPixelSize(R$dimen.clock_second_pivot_offset_square);
        this.e = r15;
        Drawable r5 = AppCompatResources.getDrawable(getContext(), R$drawable.circle_dial);
        if (r5 == null) goto L7;
        Drawable r16 = r5.mutate();
        this.f = r16;
        Drawable r17 = AppCompatResources.getDrawable(getContext(), R$drawable.circle_hand_rotation_hour);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        RotateDrawable r18 = (RotateDrawable) r17;
        r18.mutate();
        this.g = r18;
        Drawable r19 = AppCompatResources.getDrawable(getContext(), R$drawable.circle_hand_rotation_minute);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        RotateDrawable r20 = (RotateDrawable) r19;
        r20.mutate();
        this.f11270h = r20;
        Drawable r21 = AppCompatResources.getDrawable(getContext(), R$drawable.circle_hand_rotation_second);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        RotateDrawable r22 = (RotateDrawable) r21;
        r22.mutate();
        this.f11271i = r22;
        this.f11272j = LazyKt.lazy(new CircleClockView$drawableRefreshLogic$2(this));
        r16.setCallback(this);
        r18.setCallback(this);
        r20.setCallback(this);
        r22.setCallback(this);
        c(r22, r15);
        c(r18, r13);
        c(r20, r14);
        this.f11273k = 1.0f;
        this.f11274l = new Handler(Looper.getMainLooper());
        final int r23 = 0;
        this.f11276n = new a(this, r23);
        final int r24 = 1;
        this.f11277o = new a(this, r24);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.");
    }
}
