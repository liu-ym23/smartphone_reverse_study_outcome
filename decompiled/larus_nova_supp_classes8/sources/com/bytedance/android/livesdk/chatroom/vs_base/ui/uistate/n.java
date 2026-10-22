package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends ir1.c {
    public int c;
    public int d;

    public n() {
        this.c = -1;
        this.d = -1;
    }

    public final int o(Context r3) {
        ALogger.d("ReplayPlayFragmentUIState", "playFragmentLongSide context " + r3 + ", playFragmentLongSide " + this.c);
        int r0 = this.c;
        if (r0 > 0) goto L10;
        int r1 = t.a;
        Rect r2 = new Rect();
        if ((r3 instanceof Activity) == false) goto L9;
        t.b(((Activity) r3).getWindow()).getWindowVisibleDisplayFrame(r2);
    L9:
        return r2.height();
    L10:
        return r0;
    }

    public final int p(Context r3) {
        ALogger.d("ReplayPlayFragmentUIState", "playFragmentShortSide context " + r3 + ", playFragmentShortSide " + this.d);
        int r0 = this.d;
        if (r0 > 0) goto L10;
        int r1 = t.a;
        Rect r2 = new Rect();
        if ((r3 instanceof Activity) == false) goto L9;
        t.b(((Activity) r3).getWindow()).getWindowVisibleDisplayFrame(r2);
    L9:
        return r2.width();
    L10:
        return r0;
    }
}
