package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoTabPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends AnimatorListenerAdapter {
    public final /* synthetic */ UserInfoMiddleElement a;

    public n(UserInfoMiddleElement r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.p.setAlpha(1.0f);
        this.a.p.setVisibility(8);
        this.a.o.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.p.setAlpha(1.0f);
        this.a.p.setVisibility(8);
        UserInfoMiddleElement r4 = this.a;
        UserInfoTabPresenter r0 = r4.i;
        if (r0 != null) goto L5;
    L6:
        r4.o.setVisibility(0);
        return;
    L5:
        if (r0.B != 5) goto L6;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationStart(r4);
        UserInfoTabPresenter r5 = this.a.i;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.B != 5) goto L9;
        r5.t();
        r5.m("flip", false);
        r5.C.setVisibility(0);
        r5.C.setAlpha(0.0f);
        Disposable r0 = Observable.timer(r5.r, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.navi.userinfo_p.presenter.f(r5));
        Intrinsics.checkNotNullParameter(r0, "disposables");
        r5.a.add(r0);
        return;
    }
}
