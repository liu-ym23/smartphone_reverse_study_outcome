package com.bytedance.android.live.profile.seeselftransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ NewProfileTransitionDialogManager a;
    public final /* synthetic */ b b;
    public final /* synthetic */ b c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationEnd(r4);
        NewProfileTransitionDialogManager r5 = this.a;
        int r0 = NewProfileTransitionDialogManager.l;
        r5.getClass();
        ALogger.i("TransitionDialogManager", "onAnimEnd");
        Disposable r1 = r5.i;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r5.i = Observable.timer(700, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r5));
    }

    public j(NewProfileTransitionDialogManager r1, b r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
