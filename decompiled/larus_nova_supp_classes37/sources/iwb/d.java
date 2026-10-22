package iwb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final iwb.a a;
    public final e b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Integer g;
    public Integer h;
    public ValueAnimator i;
    public hwb.d j;
    public int k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FrameLayout.LayoutParams a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FrameLayout f;

        public a(FrameLayout.LayoutParams r1, int r2, int r3, int r4, int r5, FrameLayout r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            float r6 = r5.getAnimatedFraction();
            FrameLayout.LayoutParams r0 = this.a;
            r0.gravity = 0;
            int r1 = this.b;
            r0.leftMargin = (int) (r1 + ((this.c - r1) * r6));
            int r2 = this.d;
            r0.topMargin = (int) (r2 + ((this.e - r2) * r6));
            this.f.setLayoutParams(r0);
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ d a;
        public final /* synthetic */ FrameLayout.LayoutParams b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            d r4 = this.a;
            r4.c = false;
            boolean r0 = r4.d;
            r4.e = r0;
            r4.a.c(r0, r4.f);
            d r5 = this.a;
            r5.a.b(r5.c());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            d r4 = this.a;
            r4.c = false;
            boolean r0 = r4.d;
            r4.e = r0;
            if (r0 == true) goto L5;
            FrameLayout.LayoutParams r1 = this.b;
            r4.f(r1.leftMargin, r1.topMargin);
        L5:
            d r5 = this.a;
            r5.a.c(r5.e, r5.f);
            d r6 = this.a;
            r6.a.b(r6.c());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            d r3 = this.a;
            r3.c = true;
            r3.e = false;
            r3.a.c(false, false);
        }

        public b(d r1, FrameLayout.LayoutParams r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void b() {
        ValueAnimator r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.i = null;
        this.c = false;
    }

    public final hwb.d c() {
        ViewGroup.LayoutParams r0 = this.a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        boolean r2 = !this.d;
        if (this.f == false) goto L5;
        MmRecordingFloatSide r3 = MmRecordingFloatSide.RIGHT;
    L7:
        return new hwb.d(r2, r3, Integer.valueOf(r1.leftMargin), Integer.valueOf(r1.topMargin), this.a.l, this.g, this.h);
    L5:
        r3 = MmRecordingFloatSide.LEFT;
        goto L7
    }

    public final void d(boolean r9) {
        boolean r0 = this.d;
        int r1 = 0;
        this.d = false;
        this.e = false;
        ViewGroup.LayoutParams r2 = this.a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        int r4 = this.a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        if (r0 == true) goto L7;
        int r5 = this.a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        if (r5 <= this.k) goto L7;
        this.k = r5;
    L7:
        Integer r6 = Integer.valueOf(this.k);
        if (r6.intValue() <= 0) goto L10;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
        int r8 = r6.intValue();
    L19:
        if ((r3.leftMargin + (r4 / 2)) >= (this.a.getWidth() / 2)) goto L21;
        this.f = false;
    L22:
        int r10 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "sideAnim", "currentLeft=" + r3.leftMargin + ", currentWidth=" + r4 + ", containerWidth=" + this.a.getWidth() + ", expandedWidth=" + r8 + ", targetLeft=" + r1 + ", right=" + this.f + ", needAnim=" + r9, null, 8);
        a(r1, r3.topMargin, r9);
        return;
    L21:
        this.f = true;
        r1 = RangesKt.coerceAtLeast(this.a.getWidth() - r8, 0);
        goto L22
    L17:
        r8 = r4;
        goto L19
    L10:
        r7 = false;
        goto L12
    }

    public final void e(boolean r7) {
        boolean r0 = this.d;
        this.d = true;
        int r2 = this.a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        if (r2 <= this.k) goto L5;
        this.k = r2;
    L5:
        ViewGroup.LayoutParams r3 = this.a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        int r5 = 0;
        if ((r4.leftMargin + (this.a.getFloatView$officesdk_minutes_base_ui_release().getWidth() / 2)) >= (this.a.getWidth() / 2)) goto L8;
        this.f = false;
        int r1 = this.b.d();
    L9:
        if (r0 == true) goto L12;
        f(r4.leftMargin, r4.topMargin);
    L15:
        a(r1, r4.topMargin, r7);
        return;
    L12:
        if (this.f == false) goto L14;
        r5 = this.b.a();
    L14:
        f(r5, r4.topMargin);
        goto L15
    L8:
        this.f = true;
        r1 = this.b.e();
        goto L9
    }

    public d(iwb.a r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "restrictHelper");
        this.a = r2;
        this.b = r3;
        this.f = true;
    }

    public final void f(int r3, int r4) {
        e r0 = this.b;
        r0.getClass();
        this.g = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r3, 0), r0.a()));
        this.h = Integer.valueOf(this.b.c(r4));
    }

    public final void a(int r10, int r11, boolean r12) {
        b();
        FrameLayout r7 = this.a.getFloatView$officesdk_minutes_base_ui_release();
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        int r3 = r1.leftMargin;
        int r5 = r1.topMargin;
        int r6 = this.b.c(r11);
        int r13 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "animateTo", "left=" + r10 + ", top=" + r6 + ", hidden=" + this.d + ", right=" + this.f, null, 8);
        if (r12 == true) goto L9;
        r1.gravity = 0;
        r1.leftMargin = r10;
        r1.topMargin = r6;
        r7.setLayoutParams(r1);
        boolean r14 = this.d;
        this.e = r14;
        if (r14 == true) goto L7;
        f(r1.leftMargin, r1.topMargin);
    L7:
        this.a.c(this.e, this.f);
        this.a.b(c());
        return;
    L9:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setDuration(300);
        r15.addUpdateListener(new a(r1, r3, r10, r5, r6, r7));
        r15.addListener(new b(this, r1));
        this.i = r15;
        r15.start();
    }
}
