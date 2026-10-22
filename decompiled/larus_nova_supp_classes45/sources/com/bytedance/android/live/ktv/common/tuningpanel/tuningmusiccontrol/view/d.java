package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ TuningMusicControlContainer a;

    public d(TuningMusicControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        fd2.a r3 = (fd2.a) r2;
        if ((r3 instanceof fd2.a.b) == false) goto L5;
    L8:
        TuningMusicControlContainer r4 = this.a;
        int r0 = TuningMusicControlContainer.n;
        r4.R5();
        return;
    L5:
        if ((r3 instanceof fd2.a.c) == true) goto L8;
        if ((r3 instanceof fd2.a.d) == true) goto L8;
    }
}
