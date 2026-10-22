package com.obric.assistant.spi.audio;

import com.obric.assistant.session.singleton.r;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricRealtimeCallExtService$a {
    public static /* synthetic */ Object a(IObricRealtimeCallExtService r7, CallType r8, String r9, long r10, r r12, Continuation r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r9 = "obric_ai_key";
    L5:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        r10 = 0;
    L8:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L12;
        r12 = null;
    L12:
        return r7.launchRealtimeCall(r8, r2, r3, r12, r13);
    }
}
