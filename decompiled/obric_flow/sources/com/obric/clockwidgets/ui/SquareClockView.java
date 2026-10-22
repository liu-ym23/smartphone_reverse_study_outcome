package com.obric.clockwidgets.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RemoteViews;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.keva.KevaImpl;
import com.obric.clockwidgets.R$dimen;
import com.obric.clockwidgets.R$drawable;
import com.obric.clockwidgets.R$styleable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/obric/clockwidgets/ui/SquareClockView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Ljava/util/TimeZone;", "tz", "", "setTimeZone", "(Ljava/util/TimeZone;)V", "", "tzId", "setTimeZoneId", "(Ljava/lang/String;)V", "Lep/a;", "k", "Lkotlin/Lazy;", "getDrawableRefreshLogic", "()Lep/a;", "drawableRefreshLogic", "com/obric/clockwidgets/ui/f", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RemoteViews.RemoteView
@SourceDebugExtension({"SMAP\nSquareClockView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SquareClockView.kt\ncom/obric/clockwidgets/ui/SquareClockView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,268:1\n1#2:269\n1855#3,2:270\n*S KotlinDebug\n*F\n+ 1 SquareClockView.kt\ncom/obric/clockwidgets/ui/SquareClockView\n*L\n97#1:270,2\n*E\n"})
public final class SquareClockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f11279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeZone f11280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11281c;
    public final int d;
    public final int e;
    public final Drawable f;
    public final RotateDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RotateDrawable f11282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RotateDrawable f11283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f11284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f11285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f11286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.fragment.app.d f11288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f11289o;

    @JvmOverloads
    public SquareClockView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(SquareClockView r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        long r5 = System.currentTimeMillis();
        long r11 = 1000;
        long r12 = r5 - (r5 % 1000);
        if (r10.getDrawableRefreshLogic().a() == false) goto L9;
        r10.e(r12);
        Iterator r13 = r10.f11289o.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        f r14 = (f) r13.next();
        r14.f11306a.g(r14.f11307b);
    L9:
        if (r10.f11287m == false) goto L17;
        long r15 = 1000 - (System.currentTimeMillis() % 1000);
        Handler r16 = r10.f11286l;
        if (r15 <= 0) goto L14;
        r11 = r15;
    L14:
        r16.postDelayed(r10.f11288n, r11);
        return;
    }

    public static void b(Drawable r10, int r11, int r12, int r13) {
        int r5 = r10.getIntrinsicWidth();
        int r14 = r10.getIntrinsicHeight();
        float r15 = r14;
        int r16 = r11 - (r5 / 2);
        int r17 = (int) (r12 - (RangesKt.coerceIn(1.0f - (r13 / r15), 0.0f, 1.0f) * r15));
        r10.setBounds(r16, r17, r16 + r5, r14 + r17);
        if ((r10 instanceof RotateDrawable) == false) goto L6;
        ((RotateDrawable) r10).setPivotX(RangesKt.coerceIn((r11 - r16) / r5, 0.0f, 1.0f));
        return;
    }

    public static void c(RotateDrawable r5, int r10) {
        r5.setPivotX(0.5f);
        r5.setPivotY(1.0f - (r10 / r5.getIntrinsicHeight()));
    }

    private final ep.a getDrawableRefreshLogic() {
        return (ep.a) this.f11285k.getValue();
    }

    public final void d() {
        boolean r5 = isAttachedToWindow();
        androidx.fragment.app.d r10 = this.f11288n;
        Handler r11 = this.f11286l;
        if (r5 == false) goto L18;
        if (getVisibility() != 0) goto L18;
        if (getWindowVisibility() != 0) goto L18;
        long r12 = System.currentTimeMillis();
        long r13 = 1000;
        e(r12 - (r12 % 1000));
        boolean r14 = this.f11287m;
        if (r14 == true) goto L21;
        if (r14 == true) goto L24;
        this.f11287m = true;
        long r15 = 1000 - (System.currentTimeMillis() % 1000);
        if (r15 <= 0) goto L16;
        r13 = r15;
    L16:
        r11.postDelayed(r10, r13);
        return;
    L24:
        return;
    L21:
        return;
    L18:
        if (this.f11287m == false) goto L23;
        this.f11287m = false;
        r11.removeCallbacks(r10);
        return;
    }

    public final void e(long r10) {
        TimeZone r5 = this.f11280b;
        Calendar r11 = this.f11279a;
        r11.setTimeZone(r5);
        r11.setTimeInMillis(r10);
        int r12 = r11.get(10);
        int r13 = r11.get(12);
        float r14 = r11.get(13);
        float r15 = r14 / 60.0f;
        float r16 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        RotateDrawable r17 = this.f11283i;
        r17.setLevel((int) (r15 * r16));
        float r18 = r13;
        RotateDrawable r19 = this.f11282h;
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
        long r5 = System.currentTimeMillis();
        e(r5 - (r5 % 1000));
        d();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11287m = false;
        this.f11286l.removeCallbacks(this.f11288n);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        if (this.f11284j == false) goto L5;
        this.f.draw(r5);
    L5:
        this.g.draw(r5);
        this.f11282h.draw(r5);
        this.f11283i.draw(r5);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        int r13 = Math.min(r5, r10);
        int r14 = (r5 - r13) / 2;
        int r15 = (r10 - r13) / 2;
        Drawable r16 = this.f;
        r16.setBounds(r14, r15, r14 + r13, r13 + r15);
        int r17 = r5 / 2;
        int r18 = r10 / 2;
        int r19 = this.f11281c;
        b(this.g, r17, r18, r19);
        b(this.f11282h, r17, r18, this.d);
        b(this.f11283i, r17, r18, this.e);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "changedView");
        super.onVisibilityChanged(r5, r10);
        d();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r5) {
        super.onWindowFocusChanged(r5);
        d();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        d();
    }

    public final void setTimeZone(TimeZone r5) {
        Intrinsics.checkNotNullParameter(r5, "tz");
        this.f11280b = r5;
        long r10 = System.currentTimeMillis();
        e(r10 - (r10 % 1000));
    }

    public final void setTimeZoneId(String r5) {
        if (r5 != null) goto L4;
    L7:
        TimeZone r10 = TimeZone.getDefault();
    L8:
        setTimeZone(r10);
        return;
    L4:
        if (r5.length() == 0) goto L7;
        r10 = TimeZone.getTimeZone(r5);
        goto L8
    }

    @JvmOverloads
    public SquareClockView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ SquareClockView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public SquareClockView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f11279a = Calendar.getInstance();
        this.f11280b = TimeZone.getDefault();
        int r5 = getResources().getDimensionPixelSize(R$dimen.clock_hour_pivot_offset_square);
        this.f11281c = r5;
        int r13 = getResources().getDimensionPixelSize(R$dimen.clock_minute_pivot_offset_square);
        this.d = r13;
        int r14 = getResources().getDimensionPixelSize(R$dimen.clock_second_pivot_offset_square);
        this.e = r14;
        Drawable r15 = AppCompatResources.getDrawable(getContext(), R$drawable.square_dial);
        if (r15 == null) goto L10;
        Drawable r16 = r15.mutate();
        this.f = r16;
        Drawable r17 = AppCompatResources.getDrawable(getContext(), R$drawable.square_hand_rotation_hour);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        RotateDrawable r18 = (RotateDrawable) r17;
        r18.mutate();
        this.g = r18;
        Drawable r19 = AppCompatResources.getDrawable(getContext(), R$drawable.square_hand_rotation_minute);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        RotateDrawable r20 = (RotateDrawable) r19;
        r20.mutate();
        this.f11282h = r20;
        Drawable r21 = AppCompatResources.getDrawable(getContext(), R$drawable.square_hand_rotation_second);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        RotateDrawable r22 = (RotateDrawable) r21;
        r22.mutate();
        this.f11283i = r22;
        this.f11284j = true;
        this.f11285k = LazyKt.lazy(new SquareClockView$drawableRefreshLogic$2(this));
        r16.setCallback(this);
        r18.setCallback(this);
        r20.setCallback(this);
        r22.setCallback(this);
        c(r22, r14);
        c(r18, r5);
        c(r20, r13);
        if (r11 == null) goto L7;
        TypedArray r110 = r10.obtainStyledAttributes(r11, R$styleable.SquareClockView, r12, 0);
        this.f11284j = r110.getBoolean(R$styleable.SquareClockView_drawDial, true);
        r110.recycle();
    L7:
        this.f11286l = new Handler(Looper.getMainLooper());
        this.f11288n = new androidx.fragment.app.d(this, 20);
        this.f11289o = new ArrayList();
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.");
    }
}
