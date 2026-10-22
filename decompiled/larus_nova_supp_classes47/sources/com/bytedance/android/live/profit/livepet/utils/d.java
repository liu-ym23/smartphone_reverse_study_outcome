package com.bytedance.android.live.profit.livepet.utils;

import android.animation.AnimatorSet;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements Action {
    public final /* synthetic */ AnimatorSet a;

    public d(AnimatorSet r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.cancel();
    }
}
