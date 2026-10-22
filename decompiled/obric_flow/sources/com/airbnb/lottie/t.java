package com.airbnb.lottie;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.tab.OTabLayoutBase;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class t implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1336b;

    public /* synthetic */ t(Object r5, int r10) {
        this.f1335a = r10;
        this.f1336b = r5;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Object r10 = this.f1336b;
        switch(this.f1335a) {
            case 0: goto L36;
            case 1: goto L30;
            case 2: goto L24;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            default: goto L4;
        };
    L4:
        Object r11 = r5.getAnimatedValue();
        if (r11 == null) goto L44;
        int r12 = ((Integer) r11).intValue();
        LynxBaseUI r13 = (LynxBaseUI) r10;
        com.lynx.tasm.behavior.ui.utils.g r14 = r13.getLynxBackground();
        r14.e = r12;
        if (r12 == 0) goto L9;
    L11:
        ((BackgroundDrawable) r14.d()).setColor(r12);
    L12:
        r13.invalidate();
        return;
    L9:
        if (r14.f10750b != null) goto L11;
    L44:
        return;
    L14:
        OTabLayoutBase r15 = (OTabLayoutBase) r10;
        r15.scrollTo(((Integer) r5.getAnimatedValue()).intValue(), 0);
        return;
    L16:
        ((ODownloadProgressView) ((com.obric.oui.progress.a) r10).f14222b).invalidate();
        return;
    L18:
        LynxUI r16 = (LynxUI) ((com.lynx.tasm.animation.keyframe.g) r10).f10101b.get();
        if (r16 != null) goto L21;
        return;
    L21:
        if ((r16.getParent() instanceof UIShadowProxy) == false) goto L46;
        UIShadowProxy r17 = (UIShadowProxy) r16.getParent();
        r17.invalidate();
        r17.e = true;
        return;
    L46:
        return;
    L24:
        Intrinsics.checkNotNullParameter(r5, "animation");
        ?? r18 = (Lambda) r10;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L27
        Result.m124constructorimpl((Unit) r18.invoke(Float.valueOf(r5.getAnimatedFraction())));     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L30:
        Intrinsics.checkNotNullParameter(r5, "animation");
        Function1 r21 = (Function1) r10;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L33
        r21.invoke(Float.valueOf(r5.getAnimatedFraction()));     // Catch: Throwable -> L33
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L36:
        w r24 = (w) r10;
        r.e r25 = r24.f1347m;
        if (r25 == null) goto L49;
        r25.n(r24.f1341c.a());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(Function1 r5) {
        this.f1335a = 2;
        this.f1336b = (Lambda) r5;
    }
}
