package com.bytedance.android.live.room.discovery;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.schema.api.WebcastRedirectException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends CountDownTimer {
    public final /* synthetic */ AnchorPerfMonitorDialog a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r3) {
        long r4 = r3 / ((long) WebcastRedirectException.UNKNOWN);
        TextView r0 = (TextView) this.a.findViewById(2131390950);
        if (r0 == null) goto L6;
        r0.setText(s1.C(2131911543, new Object[]{Integer.valueOf((int) r4)}));
        return;
    }

    public c(AnchorPerfMonitorDialog r3, long r4) {
        this.a = r3;
        super(r4, 1000);
    }
}
