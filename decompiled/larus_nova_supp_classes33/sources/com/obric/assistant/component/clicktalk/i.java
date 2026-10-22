package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ long b;

    public /* synthetic */ i(ChatClickTalkComponent r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatClickTalkComponent r0 = this.a;
        long r1 = this.b;
        Long r3 = r0.Y;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.longValue() != r1) goto L19;
        r0.X = null;
        r0.Y = null;
        ChatClickTalkComponent$a r4 = r0.V;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L17;
        FLogger.a.i("ChatClickTalkComponent", "close pending wakeup request after pause delay, requestId=" + r1);
        maa.e.a.a(r0, null, null, false, 7);
        return;
    L17:
        return;
    L11:
        if (r4.a != r1) goto L13;
        r5 = true;
        goto L14
    }
}
