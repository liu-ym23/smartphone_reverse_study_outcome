package com.bytedance.android.live.room.discovery;

import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.AdjustPercentBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements AdjustPercentBar.d {
    public final /* synthetic */ AnchorPerfMonitorDialogNew a;

    public final void b() {
    }

    public e(AnchorPerfMonitorDialogNew r1) {
        this.a = r1;
    }

    public final void a(int r3) {
        StringBuilder r0 = new StringBuilder("Internal-onFreeze：");
        float r4 = r3 / 100.0f;
        r0.append(r4);
        ALogger.d("AnchorVolumnOptiTAG", r0.toString());
        AnchorPerfMonitorDialogNew r1 = this.a;
        int r2 = AnchorPerfMonitorDialogNew.B;
        com.bytedance.android.live.pushstream.d r5 = r1.S0();
        if (r5 == null) goto L6;
        r5.a1(r4);
        return;
    }

    public final void onChanged(int r3) {
        TextView r0 = (TextView) this.a.findViewById(2131375561);
        if (r0 == null) goto L6;
        r0.setText(String.valueOf(r3));
        return;
    }
}
