package com.bytedance.android.live.room.widget;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements Action {
    public final /* synthetic */ LiveRoomAudienceWidget a;

    public f(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }

    public final void run() {
        RecyclerView r0 = this.a.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getAlpha() == 1.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        r0.setAlpha(1.0f);
        return;
    L15:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
