package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ TuningEffectListView a;

    public d(TuningEffectListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.b.b0();
    }
}
