package com.larus.voicecall.impl.plugins;

import com.larus.call_plugins_doubao_common.CommonFeedbackVoicePluginV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b1 extends CommonFeedbackVoicePluginV2<r> {
    public final void k3() {
        com.larus.voicecall.impl.tracer.o r0 = d3a.a.b(getContext());
        if (r0 == null) goto L6;
        r0.v();
        return;
    }

    public b1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
