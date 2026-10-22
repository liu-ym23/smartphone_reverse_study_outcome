package com.larus.voicecall.impl.autostop;

import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements t {
    public final String f;

    public final String T2() {
        return this.f;
    }

    public a(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "AutoStopAsrContextPlugin";
    }

    @Override // com.larus.voicecall.impl.autostop.t
    public final void updateScreenshotForAsr(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tosKey");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        JSONObject r1 = new JSONObject();
        r1.put("image_url", r4);
        r1.put("update_nonstream_context_finish", true);
        JSONObject r5 = new JSONObject();
        r5.put("context_data", r1);
        id9.d r2 = getContext().j();
        if (r2 == null) goto L11;
        jd9.c r3 = r2.state();
    L13:
        if ((r3 instanceof jd9.c.a) == false) goto L18;
        id9.d r6 = getContext().j();
        if (r6 == null) goto L19;
        r6.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r5.toString());
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r3 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
