package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final com.larus.suggest.impl.wcb.render.o a(com.larus.suggest.impl.wcb.request.f r3, NexPulseResponseData r4, com.larus.suggest.impl.wcb.render.h r5) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter(r5, "animation");
        com.larus.suggest.impl.wcb.request.c r6 = r3.f;
        com.larus.suggest.impl.wcb.render.p r0 = r6.e;
        if (r6.b != WcbRequestTrigger.REGENERATE) goto L8;
        if (r0 == null) goto L7;
        return new com.larus.suggest.impl.wcb.render.o.c(r0);
    L7:
        return new com.larus.suggest.impl.wcb.render.o.b();
    L8:
        boolean r7 = r5.a;
        if (r7 == false) goto L13;
        if (r0 == null) goto L13;
        return new com.larus.suggest.impl.wcb.render.o.c(r0);
    L13:
        if (r7 == false) goto L24;
        Integer r8 = r4.getNexPulseType();
        if (r8 == null) goto L24;
        if (r8.intValue() != 1) goto L24;
        com.larus.suggest.impl.wcb.render.p r9 = r5.b;
        if (r9 == null) goto L24;
        return new com.larus.suggest.impl.wcb.render.o.c(r9);
    L24:
        return com.larus.suggest.impl.wcb.render.o.a.a;
    }
}
