package com.bytedance.android.anniex.lite.container;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.lottie.LottieAnimationView;
import com.bytedance.lottie.LottieDrawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q extends FrameLayout implements cqa.e {
    public final LottieAnimationView a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            r0[RefreshState.PullDownToRefresh.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RefreshState.ReleaseToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RefreshState.Refreshing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r10, int r11) {
    }

    public final void f(cqa.h r1, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
    }

    public final void g(SmartRefreshLayout.j r1, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
    }

    public View getView() {
        return this;
    }

    public final void i(cqa.h r1, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
    }

    public void setPrimaryColors(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "colors");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimationView r0 = this.a;
        LottieDrawable r1 = r0.c;
        r1.e.clear();
        r1.c.cancel();
        r0.enableOrDisableHardwareLayer();
    }

    public dqa.b getSpinnerStyle() {
        return dqa.b.d;
    }

    public q(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        LottieAnimationView r0 = new LottieAnimationView(r10);
        Resources r1 = getResources();
        int r11 = (int) TypedValue.applyDimension(1, 32.0f, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
        Resources r12 = getResources();
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r11, (int) TypedValue.applyDimension(1, 32.0f, WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics())));
        r13.gravity = 17;
        r0.setLayoutParams(r13);
        r0.setAnimation("redblueballs-32x32-60fps-const.json");
        r0.setRepeatCount(-1);
        r0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LottieDrawable r14 = r0.c;
        if (r14.i == true) goto L8;
        r14.i = true;
        if (r14.b == null) goto L8;
        r14.b();
    L8:
        this.a = r0;
        addView(r0);
    }

    public final int j(SmartRefreshLayout r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        this.a.setProgress(0.0f);
        return 200;
    }

    public final void e(cqa.h r10, RefreshState r11, RefreshState r12) {
        Intrinsics.checkNotNullParameter(r10, "refreshLayout");
        Intrinsics.checkNotNullParameter(r11, "oldState");
        Intrinsics.checkNotNullParameter(r12, "newState");
        int r13 = b.a[r12.ordinal()];
        if (r13 != 1) goto L5;
        this.a.setSpeed(1.0f);
        return;
    L5:
        if (r13 != 2) goto L7;
        this.a.setSpeed(2.0f);
        return;
    L7:
        if (r13 == 3) goto L9;
        LottieAnimationView r14 = this.a;
        LottieDrawable r15 = r14.c;
        r15.e.clear();
        r15.c.cancel();
        r14.enableOrDisableHardwareLayer();
        return;
    L9:
        LottieAnimationView r16 = this.a;
        r16.c.e();
        r16.n = true;
        r16.enableOrDisableHardwareLayer();
        this.a.setSpeed(1.0f);
    }

    public final void b(boolean r1, float r10, int r11, int r12, int r13) {
        this.a.setProgress(RangesKt.coerceIn(r11 / r13, 0.0f, 1.0f));
    }
}
