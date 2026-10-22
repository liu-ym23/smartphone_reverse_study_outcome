package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.AdjustPercentBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements AdjustPercentBar.d {
    public final /* synthetic */ AnchorPerfMonitorDialogNew a;

    public final void b() {
    }

    public i(AnchorPerfMonitorDialogNew r1) {
        this.a = r1;
    }

    public final void a(int r4) {
        StringBuilder r0 = new StringBuilder("micbar-onFreeze(max:100)：");
        float r5 = r4 / 100.0f;
        r0.append(r5);
        ALogger.d("AnchorVolumnOptiTAG", r0.toString());
        Context r1 = this.a.getContext();
        int r6 = (int) (r5 * t81.a.a(r1));
        if (t81.a.b(r1) == true) goto L12;
        t81.a.a.setStreamVolume(3, r6, 8);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void onChanged(int r3) {
        TextView r0 = (TextView) this.a.findViewById(2131387062);
        if (r0 == null) goto L6;
        r0.setText(String.valueOf(r3));
        return;
    }
}
