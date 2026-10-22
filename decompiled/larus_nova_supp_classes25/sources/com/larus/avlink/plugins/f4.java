package com.larus.avlink.plugins;

import com.larus.audio.call.plugins.CommonUIStatePlugin;
import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f4 extends CommonUIStatePlugin<n4> {
    public final String p;

    public final void o3() {
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L6;
        r0.p(TriggerMode.TTS_PLAYBACK_END, null);
        return;
    }

    public final String T2() {
        return this.p;
    }

    public f4(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.p = "DoraUIStatePlugin";
    }

    public final void n3(String r4, Function0<Unit> r5, Function0<Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "onIdle");
        Intrinsics.checkNotNullParameter(r6, "onAllEnd");
        Intrinsics.checkNotNullParameter(r7, "onOccupied");
        Intrinsics.checkNotNullParameter(r5, "onIdle");
        Intrinsics.checkNotNullParameter(r6, "onAllEnd");
        Intrinsics.checkNotNullParameter(r7, "onOccupied");
        com.larus.call_plugins_doubao_common.manager.m.a(r4, r5, r6, r7);
    }
}
