package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import com.bytedance.android.livesdk.utils.q4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends Animator {
    public final /* synthetic */ b a;

    @Override // android.animation.Animator
    public final long getDuration() {
        return 0;
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return 0;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return false;
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long r1) {
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator r1) {
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long r1) {
    }

    @Override // android.animation.Animator
    public final void cancel() {
        super.cancel();
        ((q4.b) this.a.c.getValue()).a();
        ((q4.b) this.a.f.getValue()).a();
        ((q4.b) this.a.g.getValue()).a();
    }

    public c(b r1) {
        this.a = r1;
    }
}
