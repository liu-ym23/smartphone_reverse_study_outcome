package com.larus.common_ui.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q19.b;
import q19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/common_ui/refresh/RefreshHeaderLayout;", "Lcom/larus/common_ui/refresh/AbsRefreshHeaderLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressBar", "Landroid/widget/ProgressBar;", "fakeRefreshingAnimator", "Landroid/animation/ValueAnimator;", "fakeFinishAnimator", "init", "", "resetState", "dispatchTopAndBottomOffset", "refreshLayout", "Lcom/larus/common_ui/refresh/SuperSwipeRefreshLayout;", "offset", "dispatchRefreshing", "listener", "Landroid/animation/Animator$AnimatorListener;", "dispatchRefreshCancel", "setHeaderViewScale", "scale", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RefreshHeaderLayout extends AbsRefreshHeaderLayout {
    public ProgressBar a;
    public ValueAnimator b;
    public ValueAnimator c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void d() {
        setHeaderViewScale(0.0f);
    }

    public RefreshHeaderLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        e(r2);
    }

    private final void setHeaderViewScale(float r3) {
        if (r3 > 0.0f) goto L6;
        r3 = 0.0f;
    L8:
        ProgressBar r0 = this.a;
        if (r0 == null) goto L11;
        r0.setScaleX(r3);
    L11:
        ProgressBar r1 = this.a;
        if (r1 == null) goto L15;
        r1.setScaleY(r3);
        return;
    L15:
        return;
    L6:
        if (r3 < 1.0f) goto L8;
        r3 = 1.0f;
        goto L8
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void b(SuperSwipeRefreshLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "refreshLayout");
        FLogger.a.d("RefreshHeaderLayout", "dispatchRefreshing...");
        ProgressBar r4 = this.a;
        if (r4 == null) goto L5;
        e1.x(r4);
    L5:
        ValueAnimator r5 = this.b;
        if (r5 == null) goto L8;
        r5.cancel();
    L8:
        ValueAnimator r6 = this.c;
        if (r6 == null) goto L11;
        r6.cancel();
    L11:
        setHeaderViewScale(1.0f);
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r7.addListener(new b());
        r7.setInterpolator(new LinearInterpolator());
        r7.setDuration(200);
        r7.start();
        this.b = r7;
    }

    public final void e(Context r2) {
        FrameLayout.inflate(r2, 2131563101, this);
        this.a = (ProgressBar) findViewById(2131383333);
    }

    public RefreshHeaderLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        e(r2);
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void a(SuperSwipeRefreshLayout r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "refreshLayout");
        FLogger.a.d("RefreshHeaderLayout", "dispatchRefreshCancel...");
        ProgressBar r5 = this.a;
        if (r5 == null) goto L5;
        e1.o(r5);
    L5:
        ValueAnimator r6 = this.b;
        if (r6 == null) goto L8;
        r6.cancel();
    L8:
        ValueAnimator r7 = this.c;
        if (r7 == null) goto L11;
        r7.cancel();
    L11:
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.addListener(new q19.a());
        r8.setInterpolator(new LinearInterpolator());
        r8.addListener(r4);
        r8.setDuration(200);
        r8.start();
        this.c = r8;
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void c(SuperSwipeRefreshLayout r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "refreshLayout");
        FLogger.a.d("RefreshHeaderLayout", "dispatchTopAndBottomOffset...");
        ViewCompat.offsetTopAndBottom(this, r6);
        int r7 = getBottom();
        int r0 = getMeasuredHeight();
        ValueAnimator r1 = this.b;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L33;
        ValueAnimator r4 = r5.v;
        if (r4 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == true) goto L28;
        ValueAnimator r9 = r5.w;
        if (r9 != null) goto L22;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == true) goto L28;
        boolean r11 = false;
    L29:
        if (r11 == true) goto L33;
        setHeaderViewScale(1.0f);
        return;
    L22:
        if (r9.isRunning() == false) goto L24;
        r10 = true;
    L28:
        r11 = true;
        goto L29
    L15:
        if (r4.isRunning() == false) goto L17;
        r8 = true;
    L33:
        ValueAnimator r12 = r5.w;
        if (r12 != null) goto L36;
    L38:
        r2 = false;
    L39:
        if (r2 == false) goto L46;
        float r13 = r0 * 0.5f;
        float r14 = (r7 - r13) / r13;
        if (r14 >= 0.0f) goto L44;
        r14 = 0.0f;
    L44:
        setHeaderViewScale(r14);
        return;
    L46:
        return;
    L36:
        if (r12.isRunning() == false) goto L38;
    L5:
        if (r1.isRunning() != true) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L10;
        r3 = true;
        goto L11
    L7:
        r15 = false;
        goto L8
    }

    public RefreshHeaderLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        e(r2);
    }
}
