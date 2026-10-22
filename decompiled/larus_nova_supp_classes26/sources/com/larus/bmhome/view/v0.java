package com.larus.bmhome.view;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class v0 implements Runnable {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public /* synthetic */ v0(ChatMessageList r1, int r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatMessageList r0 = this.a;
        int r1 = this.b;
        long r2 = this.c;
        String r4 = this.d;
        if (r0.p == r1) goto L5;
        return;
    L5:
        if (r0.q <= r2) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r0.r, r4) == false) goto L12;
        FLogger.a.d("search_landing", "clear precision guard position=" + r1 + ", targetMessageId=" + r4 + ", expireAt=" + r2);
        r0.p = -1;
        r0.q = 0;
        r0.r = null;
        r0.s = null;
        r0.u = null;
        r0.v = -1;
        return;
    }
}
