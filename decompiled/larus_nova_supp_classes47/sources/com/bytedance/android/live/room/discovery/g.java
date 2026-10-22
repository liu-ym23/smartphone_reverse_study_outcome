package com.bytedance.android.live.room.discovery;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.dux.duxswitch.DuxSwitch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ AnchorPerfMonitorDialogNew a;

    public g(AnchorPerfMonitorDialogNew r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        View r0 = this.a.findViewById(2131386999);
        if ((r0 instanceof DuxSwitch) == true) goto L5;
        r0 = null;
    L5:
        DuxSwitch r1 = (DuxSwitch) r0;
        if (r1 == null) goto L9;
        r1.setChecked(r4.booleanValue());
        return;
    }
}
