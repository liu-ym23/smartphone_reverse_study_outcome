package com.larus.camera.impl.ui.component.capture;

import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g0 implements Function1 {
    public /* synthetic */ g0() {
    }

    public final Object invoke(Object r5) {
        ImageView r6 = (ImageView) r5;
        int r0 = CaptureControlComponent.u;
        Intrinsics.checkNotNullParameter(r6, "$this$configMainButton");
        ViewPropertyAnimator r7 = r6.animate();
        r7.scaleX(1.0f);
        r7.scaleY(1.0f);
        r7.setDuration(300);
        r7.setInterpolator(new PathInterpolator(0.25f, 0.0f, 0.25f, 1.0f));
        r7.start();
        return Unit.INSTANCE;
    }
}
