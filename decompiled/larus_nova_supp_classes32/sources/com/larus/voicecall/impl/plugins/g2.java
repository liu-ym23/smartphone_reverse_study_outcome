package com.larus.voicecall.impl.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g2 extends com.larus.audio.call.arch.a<r> implements u {
    public final String f;

    public final String T2() {
        return this.f;
    }

    public g2(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeNotWorkInfoPlugin";
    }

    @Override // com.larus.voicecall.impl.plugins.u
    public final void L(int r5) {
        FLogger.a.i(this.f, "triggerNetInfoChange newQuality: " + r5);
        JSONObject r0 = new JSONObject();
        r0.put("ui_event", "network_quality");
        r0.put("network_level", String.valueOf(r5));
        id9.d r6 = ((r) getContext()).j();
        if (r6 == null) goto L6;
        TriggerMode r1 = TriggerMode.UPDATE_UI_CONTEXT;
        JSONObject r2 = new JSONObject();
        r2.put("applet_payload", r0);
        Unit r3 = Unit.INSTANCE;
        r6.p(r1, r2.toString());
        return;
    }
}
