package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ TuningButtonListView a;

    public b(TuningButtonListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ((Boolean) r2).booleanValue();
        TuningButtonListView r3 = this.a;
        int r0 = TuningButtonListView.h;
        r3.u();
    }
}
