package com.larus.suggest.impl.wcb.policy;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements b0 {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // com.larus.suggest.impl.wcb.policy.b0
    public final a0 a(com.larus.suggest.impl.wcb.request.f r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "snapshot");
        y r0 = r6.f.a.h();
        if (r0.l(r6) == false) goto L7;
        return new a0.d("wcb consumed in conversation");
    L7:
        if (r6.f.b == WcbRequestTrigger.REGENERATE) goto L9;
        v r1 = r0.k(r6);
        if (Intrinsics.areEqual(r1, v.b.a) == false) goto L13;
        if (r7 == true) goto L24;
        long r2 = r0.i(r6);
        long r8 = r0.c(r6) * 1000;
        if (r2 >= r8) goto L32;
        if (r8 <= 0) goto L32;
        FLogger.a.i("WcbLog", "intercept next pulse request, reqInterval=" + r2 + " minInterval=" + r8);
        return new a0.d("request within freqReqInterval");
    L32:
        return a0.c.a;
    L24:
        return a0.c.a;
    L13:
        if ((r1 instanceof v.a) == false) goto L17;
        return new a0.a(((v.a) r1).a);
    L17:
        if ((r1 instanceof v.c) == false) goto L21;
        ((v.c) r1).getClass();
        Intrinsics.checkNotNullParameter(null, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        throw null;
    L21:
        throw new NoWhenBranchMatchedException();
    L9:
        return a0.c.a;
    }
}
