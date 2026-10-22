package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ NewProfileEnterExitUseCase a;
    public final /* synthetic */ Function0 b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationEnd(r4);
        ProfileMonitor r5 = this.a.f();
        if (r5 == null) goto L5;
        r5.i(TimeType.ExitAnimEnd);
    L5:
        this.a.i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.EXIT_END));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: EXIT_END");
        Function0 r0 = this.b;
        if (r0 == null) goto L8;
        Unit r1 = (Unit) r0.invoke();
    L8:
        this.a.i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.COMPLETE));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: COMPLETE");
        this.a.i.onComplete();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3);
        ProfileMonitor r4 = this.a.f();
        if (r4 == null) goto L5;
        r4.i(TimeType.ExitAnimStart);
    L5:
        this.a.i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.EXIT_START));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: EXIT_START");
    }

    public d(NewProfileEnterExitUseCase r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
