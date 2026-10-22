package com.bytedance.android.live.profit.scoreboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0003\u0012\u0013B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;", "a", "Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;", "getDragCallback", "()Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;", "setDragCallback", "(Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;)V", "dragCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScoreboardBannerView extends FrameLayout {
    public c a;
    public final b b;

    public static final class a {
    }

    public final class b {
        public final int a;
        public j80.d b;
        public j80.d c;
        public final /* synthetic */ ScoreboardBannerView d;

        public b(ScoreboardBannerView r2) {
            this.d = r2;
            this.a = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
            this.b = new j80.d(0.0f, 0.0f);
            this.c = new j80.d(0.0f, 0.0f);
        }
    }

    public interface c {
        void a();

        void b(j80.d r1);

        void onDragStart();
    }

    static {
    }

    public ScoreboardBannerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ScoreboardBannerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final c getDragCallback() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        b r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r1 = r5.getAction();
        if (r1 != 0) goto L5;
        r0.c = j80.b.c(r5);
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L21;
        return true;
    L21:
        return super.onInterceptTouchEvent(r5);
    L5:
        if (r1 != 2) goto L17;
        if (j80.c.a(j80.b.c(r5), r0.c) < r0.a) goto L17;
        r0.b = j80.b.c(r5);
        r0.d.requestDisallowInterceptTouchEvent(true);
        c r3 = r0.d.getDragCallback();
        if (r3 == null) goto L12;
        r3.onDragStart();
    L12:
        c r4 = r0.d.getDragCallback();
        if (r4 == null) goto L15;
        r4.b(j80.c.b(j80.b.c(r5), r0.c));
    L15:
        r2 = true;
        goto L18
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getAction();
        if (r0 == 0) goto L20;
        if (r0 != 1) goto L6;
        c r2 = r1.d.getDragCallback();
        if (r2 == null) goto L19;
        r2.a();
    L19:
        r1.d.performClick();
    L23:
        boolean r3 = true;
    L24:
        if (r3 == false) goto L27;
        return true;
    L27:
        return super.onTouchEvent(r5);
    L6:
        if (r0 != 2) goto L8;
        j80.d r4 = j80.c.b(j80.b.c(r5), r1.b);
        r1.b = j80.b.c(r5);
        c r6 = r1.d.getDragCallback();
        if (r6 == null) goto L23;
        r6.b(r4);
        goto L23
    L8:
        if (r0 == 3) goto L10;
        r3 = false;
        goto L24
    L10:
        c r7 = r1.d.getDragCallback();
        if (r7 == null) goto L23;
        r7.a();
        goto L23
    L20:
        r1.b = j80.b.c(r5);
        r1.d.requestDisallowInterceptTouchEvent(true);
        c r8 = r1.d.getDragCallback();
        if (r8 == null) goto L23;
        r8.onDragStart();
        goto L23
    }

    public final void setDragCallback(c r1) {
        this.a = r1;
    }

    public ScoreboardBannerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new b(this);
    }

    public /* synthetic */ ScoreboardBannerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
