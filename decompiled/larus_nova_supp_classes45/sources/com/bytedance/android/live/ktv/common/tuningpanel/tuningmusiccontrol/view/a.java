package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ TuningMusicControlContainer a;

    public a(TuningMusicControlContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        TuningMusicControlContainer r4 = this.a;
        int r0 = TuningMusicControlContainer.n;
        r4.S5();
    }
}
