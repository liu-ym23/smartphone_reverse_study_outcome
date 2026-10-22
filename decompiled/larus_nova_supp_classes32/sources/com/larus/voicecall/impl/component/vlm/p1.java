package com.larus.voicecall.impl.component.vlm;

import com.larus.voicecall.impl.video.VideoPreviewState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p1 implements Function0 {
    public final /* synthetic */ RealtimeVideoComponent a;

    public /* synthetic */ p1(RealtimeVideoComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final RealtimeVideoComponent r0 = this.a;
        if (r0.G == true) goto L14;
        if (((h88.a) r0.B3()).m == false) goto L7;
        r0.q4("onVideoServiceAvailable", new s1(r0), r0.k0);
    L7:
        com.larus.voicecall.impl.plugins.o1 r1 = r0.E3().z();
        if (r1 == null) goto L11;
        r1.l();
    L11:
        if (r0.N.c.getValue() != VideoPreviewState.full) goto L14;
        r0.v4(Intrinsics.areEqual(r0.N.b.getValue(), Boolean.TRUE), "video_service_available", 0);
    L14:
        return Unit.INSTANCE;
    }
}
