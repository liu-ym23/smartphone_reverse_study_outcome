package com.larus.voicecall.impl.plugins;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h1 extends com.larus.audio.call.arch.a<r> implements i1 {
    public final String f;

    @Override // com.larus.voicecall.impl.plugins.i1
    public final void h1() {
        LinkedHashMap r0 = new LinkedHashMap();
        o1 r1 = s.e((r) getContext());
        boolean r3 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        r0.put("current_modal_type", 2);
        r0.put("video_source_type", 1);
    L20:
        FLogger.a.i(this.f, "syncClientInfo was called, info=" + r0);
        id9.d r4 = ((r) getContext()).j();
        if (r4 == null) goto L24;
        r4.r(r0);
        return;
    L24:
        return;
    L11:
        u2 r5 = s.d((r) getContext());
        if (r5 != null) goto L14;
    L16:
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r0.put("current_modal_type", 2);
        r0.put("video_source_type", 2);
        goto L20
    L19:
        r0.put("current_modal_type", 1);
        r0.put("video_source_type", 0);
        goto L20
    L14:
        if (r5.J() != true) goto L16;
    L5:
        if (r1.D5() != true) goto L7;
        r2 = true;
        goto L9
    }

    public final String T2() {
        return this.f;
    }

    public h1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeCallTracePlugin";
    }
}
