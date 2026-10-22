package com.ss.android.lark.custom.repeat.widget.wheelview;

import android.os.Handler;
import android.os.Message;
import tab.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends Handler {
    public final WheelView a;

    public a(WheelView r1) {
        this.a = r1;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r4) {
        int r5 = r4.what;
        if (r5 != 1000) goto L5;
        this.a.invalidate();
        return;
    L5:
        if (r5 != 2000) goto L7;
        this.a.d(WheelView.ACTION.FLING);
        return;
    L7:
        if (r5 != 3000) goto L18;
        WheelView r6 = this.a;
        if (r6.c == null) goto L15;
        r6.postDelayed(new c(r6), 0);
        return;
    L15:
        return;
    }
}
