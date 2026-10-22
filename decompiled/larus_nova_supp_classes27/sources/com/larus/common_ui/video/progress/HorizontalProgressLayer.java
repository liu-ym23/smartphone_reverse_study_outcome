package com.larus.common_ui.video.progress;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020'H\u0002J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020'R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/common_ui/video/progress/HorizontalProgressLayer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingBar1", "Landroid/view/View;", "getLoadingBar1", "()Landroid/view/View;", "loadingBar1$delegate", "Lkotlin/Lazy;", "loadingBar2", "getLoadingBar2", "loadingBar2$delegate", "loadingBar3", "getLoadingBar3", "loadingBar3$delegate", "loadingBars", "", "getLoadingBars", "()[Landroid/view/View;", "loadingBars$delegate", "animators", "Landroid/animation/ObjectAnimator;", "getAnimators", "()[Landroid/animation/ObjectAnimator;", "animators$delegate", "animationJob", "Lkotlinx/coroutines/Job;", "isAnimating", "", "buildFadeInOutAnimator", "view", "stopAllAnimators", "", "setLoadingLength", "length", "startLoadingAnimation", "stopLoadingAnimation", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalProgressLayer extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public Job f;

    public static final class a {
    }

    static {
    }

    public HorizontalProgressLayer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HorizontalProgressLayer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final ObjectAnimator[] getAnimators() {
        return (ObjectAnimator[]) this.e.getValue();
    }

    private final View getLoadingBar1() {
        return (View) this.a.getValue();
    }

    private final View getLoadingBar2() {
        return (View) this.b.getValue();
    }

    private final View getLoadingBar3() {
        return (View) this.c.getValue();
    }

    private final View[] getLoadingBars() {
        return (View[]) this.d.getValue();
    }

    public final void e() {
        e1.q(this);
        ObjectAnimator[] r0 = getAnimators();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].cancel();
        r2 = r2 + 1;
        goto L3
    L5:
        Job r3 = this.f;
        if (r3 == null) goto L8;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L8:
        this.f = null;
    }

    public static ObjectAnimator[] a(HorizontalProgressLayer r3) {
        return new ObjectAnimator[]{d(r3.getLoadingBar1()), d(r3.getLoadingBar2()), d(r3.getLoadingBar3())};
    }

    public static View[] b(HorizontalProgressLayer r3) {
        return new View[]{r3.getLoadingBar1(), r3.getLoadingBar2(), r3.getLoadingBar3()};
    }

    public static final /* synthetic */ ObjectAnimator[] c(HorizontalProgressLayer r0) {
        return r0.getAnimators();
    }

    public static ObjectAnimator d(View r2) {
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.0f, 1.0f, 0.0f});
        r3.setDuration(1400);
        return r3;
    }

    public final void setLoadingLength(int r6) {
        View[] r0 = getLoadingBars();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        View r3 = r0[r2];
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = r6;
        r3.setLayoutParams(r4);
        r2 = r2 + 1;
        goto L3
    L5:
        invalidate();
    }

    public HorizontalProgressLayer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new com.larus.common_ui.video.progress.a(this));
        this.b = LazyKt.lazy(new b(this));
        this.c = LazyKt.lazy(new c(this));
        this.d = LazyKt.lazy(new d(this));
        this.e = LazyKt.lazy(new e(this));
    }

    public /* synthetic */ HorizontalProgressLayer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
