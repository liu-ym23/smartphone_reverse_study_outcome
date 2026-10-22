package com.larus.voicecall.impl;

import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public h() {
    }

    public final void a(String r3, ouc.d0 r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r0.reportEvent(r3, com.larus.voicecall.impl.util.d.d(r4));
    }
}
