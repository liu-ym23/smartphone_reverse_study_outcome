package com.larus.profile.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ#\u0010\u0018\u001a\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0000¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0014J0\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0014J!\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010*R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/profile/impl/view/ProfileEditPerfRootLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onFirstDispatchDrawEnd", "Lkotlin/Function1;", "Lcom/larus/profile/impl/view/ProfileEditFirstFrameTiming;", "", "firstMeasureStartNs", "", "Ljava/lang/Long;", "lastMeasureEndNs", "firstLayoutStartNs", "lastLayoutEndNs", "hasFinishedFirstFrame", "", "setOnFirstDispatchDrawEndListener", "listener", "setOnFirstDispatchDrawEndListener$impl_mainlandRelease", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "durationNs", "startNs", "endNs", "(Ljava/lang/Long;Ljava/lang/Long;)J", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileEditPerfRootLayout extends ConstraintLayout {
    public Function1<? super i, Unit> a;
    public Long b;
    public Long c;
    public Long d;
    public Long e;
    public boolean f;

    public ProfileEditPerfRootLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void dispatchDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.dispatchDraw(r9);
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        Function1<? super i, Unit> r10 = this.a;
        if (r10 != null) goto L8;
        return;
    L8:
        this.a = null;
        r10.invoke(new i(System.currentTimeMillis(), R5(this.b, this.c), R5(this.d, this.e)));
    }

    public final void setOnFirstDispatchDrawEndListener$impl_mainlandRelease(Function1<? super i, Unit> r1) {
        this.a = r1;
    }

    public ProfileEditPerfRootLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public static long R5(Long r5, Long r6) {
        if (r5 == null) goto L7;
        if (r6 == null) goto L7;
        if (r6.longValue() < r5.longValue()) goto L7;
        return r6.longValue() - r5.longValue();
    L7:
        return 0;
    }

    public final void onMeasure(int r4, int r5) {
        if (this.f == false) goto L6;
        super.onMeasure(r4, r5);
        return;
    L6:
        long r0 = SystemClock.elapsedRealtimeNanos();
        if (this.b != null) goto L9;
        this.b = Long.valueOf(r0);
    L9:
        super.onMeasure(r4, r5);
        this.c = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    }

    public ProfileEditPerfRootLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        if (this.f == false) goto L6;
        super.onLayout(r4, r5, r6, r7, r8);
        return;
    L6:
        long r0 = SystemClock.elapsedRealtimeNanos();
        if (this.d != null) goto L9;
        this.d = Long.valueOf(r0);
    L9:
        super.onLayout(r4, r5, r6, r7, r8);
        this.e = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    }
}
