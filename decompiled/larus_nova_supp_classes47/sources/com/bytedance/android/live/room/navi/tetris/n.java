package com.bytedance.android.live.room.navi.tetris;

import android.widget.TextView;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ LandscapeRoomNavigatorTetris a;

    public n(LandscapeRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        LandscapeRoomNavigatorTetris r5 = this.a;
        String r0 = r5.V();
        MarqueeTextView r1 = r5.s;
        if (r1 == null) goto L5;
        String r2 = r1.getOriginText();
    L7:
        if (r0.equals(r2) == true) goto L17;
        MarqueeTextView r6 = r5.s;
        if (r6 == null) goto L12;
        r6.setTextWithEllipsisImmediately(r5.V());
    L12:
        TextView r7 = r5.q;
        if (r7 == null) goto L16;
        r7.setText(r5.V());
        return;
    L16:
        return;
    L17:
        return;
    L5:
        r2 = null;
        goto L7
    }
}
