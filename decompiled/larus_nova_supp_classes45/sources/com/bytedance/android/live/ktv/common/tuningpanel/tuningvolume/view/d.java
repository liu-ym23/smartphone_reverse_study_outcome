package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ TuningVolumeContentArea a;

    public d(TuningVolumeContentArea r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        View r4 = this.a.b(TuningVolumeType.EAR_BACK_VOLUME);
        if (r4 == null) goto L6;
        this.a.a.i();
        r4.setVisibility(8);
        return;
    }
}
