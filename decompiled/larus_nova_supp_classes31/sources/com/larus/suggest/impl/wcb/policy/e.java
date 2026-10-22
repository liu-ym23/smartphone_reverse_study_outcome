package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final com.larus.suggest.impl.wcb.render.i b(com.larus.suggest.impl.wcb.request.f r4, NexPulseResponseData r5) {
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        Intrinsics.checkNotNullParameter(r5, "response");
        com.larus.suggest.impl.wcb.request.c r6 = r4.f;
        int r1 = r6.f;
        if (r6.a.getKey().b != WcbMode.OFFICE_TASK) goto L5;
        boolean r7 = true;
    L7:
        return new com.larus.suggest.impl.wcb.render.i(r1, r5, "DEPRECATED", r7);
    L5:
        r7 = false;
        goto L7
    }

    public final com.larus.suggest.impl.wcb.render.i a(com.larus.suggest.impl.wcb.request.f r5, NexPulseResponseData r6, com.larus.suggest.impl.wcb.render.h r7) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        Intrinsics.checkNotNullParameter(r6, "response");
        Intrinsics.checkNotNullParameter(r7, "animation");
        Integer r0 = r6.getNexPulseType();
        String r1 = null;
        boolean r2 = true;
        if (r0 != null) goto L6;
    L7:
        Integer r3 = r6.getNexPulseType();
        if (r3 != null) goto L11;
    L12:
        Integer r4 = r6.getNexPulseType();
        if (r4 != null) goto L16;
    L17:
        return null;
    L16:
        if (r4.intValue() != 4) goto L17;
    L19:
        if (r7.a == true) goto L22;
    L25:
        com.larus.suggest.impl.wcb.request.c r8 = r5.f;
        int r9 = r8.f;
        if (r8.a.getKey().b == WcbMode.OFFICE_TASK) goto L30;
        r2 = false;
    L30:
        return new com.larus.suggest.impl.wcb.render.i(r9, r6, r1, r2);
    L22:
        if (r7.b == null) goto L24;
        r1 = "UPDATED";
        goto L25
    L24:
        r1 = "DEFAULT";
        goto L25
    L11:
        if (r3.intValue() == 2) goto L19;
    L6:
        if (r0.intValue() == 1) goto L19;
        goto L7
    }
}
