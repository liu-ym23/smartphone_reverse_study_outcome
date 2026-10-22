package com.ss.android.lark.forseti.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ForsetiNormalChainDraggingView a;

    public c(ForsetiNormalChainDraggingView r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNullParameter(r6, "insets");
        boolean r7 = r6.isVisible(WindowInsetsCompat.Type.ime());
        if (this.a.e == r7) goto L9;
        Log.i("ForsetiNormalChainDraggingView", "setKeyboardStateListener: isKeyboardVisible = " + r7);
        ForsetiNormalChainDraggingView r0 = this.a;
        r0.e = r7;
        r0.getDraggingHelper().d = r7;
        this.a.invalidate();
        if (r7 == false) goto L7;
        float r8 = ((this.a.getMeasuredHeight() - this.a.getDraggingHelper().l) / 2.0f) - (this.a.getMeasuredHeight() - this.a.getDraggingHelper().v);
    L8:
        ForsetiNormalChainDraggingView r1 = this.a;
        float r2 = r1.f;
        r1.getClass();
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{r2, r8});
        r9.setDuration(300);
        r9.setInterpolator(new AccelerateDecelerateInterpolator());
        r9.addUpdateListener(new b(r1));
        r9.start();
        goto L9
    L7:
        r8 = 0.0f;
    L9:
        return r6;
    }
}
