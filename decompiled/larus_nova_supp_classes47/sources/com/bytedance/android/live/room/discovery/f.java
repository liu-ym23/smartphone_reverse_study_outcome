package com.bytedance.android.live.room.discovery;

import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements AdjustPercentBar.d {
    public final /* synthetic */ AnchorPerfMonitorDialogNew a;

    public final void b() {
    }

    public f(AnchorPerfMonitorDialogNew r1) {
        this.a = r1;
    }

    public final void a(int r5) {
        StringBuilder r0 = new StringBuilder("micbar-onFreeze：");
        float r1 = r5 / 100.0f;
        r0.append(r1);
        ALogger.d("AnchorVolumnOptiTAG", r0.toString());
        AnchorPerfMonitorDialogNew r2 = this.a;
        int r3 = AnchorPerfMonitorDialogNew.B;
        com.bytedance.android.live.pushstream.d r4 = r2.S0();
        if (r4 == null) goto L5;
        r4.p1(r1);
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        Room r7 = this.a.h;
        if (r7 == null) goto L8;
        r6.put("room_id", String.valueOf(r7.id));
        r6.put("anchor_id", r7.getOwnerUserIdString());
    L8:
        r6.put("status", String.valueOf(r5));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_sound_click", r6, new Object[0]);
    }

    public final void onChanged(int r3) {
        TextView r0 = (TextView) this.a.findViewById(2131380052);
        if (r0 == null) goto L6;
        r0.setText(String.valueOf(r3));
        return;
    }
}
