package com.larus.suggest.impl.wcb.policy;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p implements b0 {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // com.larus.suggest.impl.wcb.policy.b0
    public final a0 a(com.larus.suggest.impl.wcb.request.f r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        com.larus.suggest.impl.wcb.request.c r5 = r3.f;
        WcbRequestTrigger r0 = r5.b;
        if (r0 != WcbRequestTrigger.REGENERATE) goto L7;
        return a0.c.a;
    L7:
        if (r0 == WcbRequestTrigger.INITIAL) goto L9;
    L12:
        v r6 = r3.f.a.h().k(r3);
        if ((r6 instanceof v.a) == false) goto L16;
        return new a0.b(((v.a) r6).a);
    L16:
        if (Intrinsics.areEqual(r6, v.b.a) == false) goto L20;
        return a0.c.a;
    L20:
        if ((r6 instanceof v.c) == false) goto L24;
        ((v.c) r6).getClass();
        Intrinsics.checkNotNullParameter(null, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        throw null;
    L24:
        throw new NoWhenBranchMatchedException();
    L9:
        if (r5.a.getKey().b != WcbMode.QUICK_EXPERT) goto L12;
        return a0.c.a;
    }
}
