package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ NewProfileEnterExitUseCase a;
    public final /* synthetic */ Function0 b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationEnd(r3);
        Function0 r4 = this.b;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke();
    L5:
        ProfileMonitor r6 = this.a.f();
        if (r6 == null) goto L8;
        r6.i(TimeType.EnterAnimEnd);
    L8:
        this.a.i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.ENTER_END));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: ENTER_END");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3);
        View r4 = this.a.a;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        ProfileMonitor r5 = this.a.f();
        if (r5 == null) goto L8;
        r5.i(TimeType.EnterAnimStart);
    L8:
        this.a.i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.ENTER_START));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: ENTER_START");
    }

    public c(NewProfileEnterExitUseCase r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
