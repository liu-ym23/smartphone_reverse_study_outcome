package com.larus.canvas.feature.component.logic.provider;

import android.animation.Animator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.canvas.impl.databinding.LarusLayoutCanvasGenerateBottomProviderBinding;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements Animator.AnimatorListener {
    public final /* synthetic */ i a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        LarusLayoutCanvasGenerateBottomProviderBinding r5 = this.a.g;
        if (r5 == null) goto L7;
        ConstraintLayout r6 = r5.b;
        if (r6 == null) goto L7;
        r6.setAlpha(1.0f);
    L7:
        i r7 = this.a;
        LarusLayoutCanvasGenerateBottomProviderBinding r0 = r7.g;
        if (r0 == null) goto L16;
        CommonDownLoadLayout r1 = r0.d;
        if (r1 == null) goto L16;
        CoroutineScope r2 = r7.h;
        ky8.a r8 = (ky8.a) ((com.larus.gallery.api.t) r7).d;
        if (r8 == null) goto L14;
        String r9 = r8.f;
    L15:
        r1.S5(r2, new com.larus.bmhome.bigimg.download.d.a(String.valueOf(r9)));
        goto L16
    L14:
        r9 = null;
    L16:
        this.a.A();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LarusLayoutCanvasGenerateBottomProviderBinding r3 = this.a.g;
        if (r3 == null) goto L7;
        ConstraintLayout r4 = r3.b;
        if (r4 == null) goto L7;
        e1.x(r4);
    L7:
        LarusLayoutCanvasGenerateBottomProviderBinding r5 = this.a.g;
        if (r5 == null) goto L13;
        ConstraintLayout r6 = r5.b;
        if (r6 == null) goto L14;
        r6.setAlpha(0.0f);
        return;
    L14:
        return;
    }
}
