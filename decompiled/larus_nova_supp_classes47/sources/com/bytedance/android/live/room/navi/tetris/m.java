package com.bytedance.android.live.room.navi.tetris;

import android.graphics.Paint;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements Runnable {
    public final /* synthetic */ LandscapeRoomNavigatorTetris a;

    public m(LandscapeRoomNavigatorTetris r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MarqueeTextView r0 = this.a.s;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        Paint r1 = r0.getPaint();     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        float r2 = r1.measureText("正正正正正正正正...");     // Catch: Throwable -> L10
        MarqueeTextView r3 = this.a.s;     // Catch: Throwable -> L10
        if (r3 == null) goto L18;
        r3.setMaxWidth((int) r2);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
