package com.bytedance.android.live.room.navi.tetris;

import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends com.bytedance.android.live.core.tetris.task.a {
    public final /* synthetic */ AudienceRoomNavigatorTetris c;

    public final void run() {
        AudienceRoomNavigatorTetris r0 = this.c;
        ImageView r1 = r0.r;
        if (r1 == null) goto L6;
        if (r1 == null) goto L6;
        int r2 = k.a;
        r1.setOnClickListener(new j(r0.s));
    L6:
        b(true);
    }

    public h(AudienceRoomNavigatorTetris r1) {
        this.c = r1;
        super("live_close_view");
    }
}
