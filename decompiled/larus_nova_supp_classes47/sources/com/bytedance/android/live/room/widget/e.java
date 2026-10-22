package com.bytedance.android.live.room.widget;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ LiveRoomAudienceWidget a;

    public e(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - com.bytedance.android.live.room.util.f.a;
        com.bytedance.android.live.room.util.f.a = r0;
        if (r2 <= 500) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L9;
        LiveRoomAudienceWidget.wq(this.a);
        return;
    L9:
        return;
    L5:
        r6 = false;
        goto L6
    }
}
