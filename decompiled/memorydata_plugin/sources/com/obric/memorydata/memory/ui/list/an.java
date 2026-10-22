package com.obric.memorydata.memory.ui.list;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.memorydata.ui.BaseActivity;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"applyThreeButtonNavigationBottomInset", "", "Landroid/view/View;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class an {

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/ui/list/OperationContainerInsetsKt$applyThreeButtonNavigationBottomInset$2", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f11192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver.OnWindowFocusChangeListener f11193b;

        a(ViewTreeObserver r3, ViewTreeObserver.OnWindowFocusChangeListener r4) {
            ViewTreeObserver.OnWindowFocusChangeListener r5 = (ViewTreeObserver.OnWindowFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r4, ViewTreeObserver.OnWindowFocusChangeListener.class, "com.obric.memorydata.plugin");
            this.f11192a = r3;
            this.f11193b = r5;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
            if (this.f11192a.isAlive() == false) goto L5;
            this.f11192a.removeOnWindowFocusChangeListener(this.f11193b);
        L5:
            r3.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        }
    }

    private static final WindowInsetsCompat a(int r4, View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "insets");
        int r0 = r6.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r1 = r6.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom;
        if (r0 <= 0) goto L7;
        if (r1 > 0) goto L8;
        r0 = 0;
    L8:
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r4 + r0);
        return r6;
    L7:
        r0 = BaseActivity.Companion.b();
        goto L8
    }

    public static final void a(final View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final int r0 = r3.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(r3, new $$Lambda$an$tdICGMgbvSHwvurl4W37geW5eE(r0));
        ViewTreeObserver.OnWindowFocusChangeListener r1 = new $$Lambda$an$gt9Nlms3FTn2D5DJ4pTLAEdA(r3);
        ViewTreeObserver r2 = r3.getViewTreeObserver();
        r2.addOnWindowFocusChangeListener(r1);
        r3.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new a(r2, r1), View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        ViewCompat.requestApplyInsets(r3);
    }

    private static final void a(View r0, boolean r1) {
        if (r1 == false) goto L5;
        ViewCompat.requestApplyInsets(r0);
        return;
    }

    /* JADX INFO: renamed from: lambda$gt9Nlms-3FTn2D5DJ--4pTLAEdA, reason: not valid java name */
    public static /* synthetic */ void m931lambda$gt9Nlms3FTn2D5DJ4pTLAEdA(View r0, boolean r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tdICG-MgbvSHwvurl4W37geW5eE, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m932lambda$tdICGMgbvSHwvurl4W37geW5eE(int r0, View r1, WindowInsetsCompat r2) {
        return a(r0, r1, r2);
    }
}
