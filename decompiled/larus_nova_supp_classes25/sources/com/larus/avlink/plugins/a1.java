package com.larus.avlink.plugins;

import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.l;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a1 extends DoraAudioFrameReceiver {
    public String o;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.avlink.plugins.DoraAudioFrameReceiver
    public final void R1(String r4) {
        Intrinsics.checkNotNullParameter(r4, "caller");
        FLogger.a.i(((com.larus.audio.call.plugins.e) this).g, "skip DoraG SI prepareToPlay and warmup, caller=".concat(r4));
    }

    @Override // com.larus.avlink.plugins.DoraAudioFrameReceiver
    public final void j3(Object r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        if ((r8 instanceof com.larus.audio.call.play.h.c) == false) goto L7;
        FLogger.a.i(((com.larus.audio.call.plugins.e) this).g, "skip early TtsStart in DoraG SI, wait for first inner play frame");
        return;
    L7:
        if ((r8 instanceof com.larus.audio.call.play.h.b) == false) goto L9;
        l3("tts end event");
    L9:
        boolean r1 = false;
        if ((r8 instanceof l) == false) goto L27;
        e10 r0 = e10.a;
        if (e10.p() == true) goto L14;
    L15:
        l r2 = (l) r8;
        if (r2.d == false) goto L18;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L27;
        r1 = true;
        goto L27
    L18:
        if (Intrinsics.areEqual(sf9.a.d(r2.b(), "src_channel"), "1") == false) goto L24;
        String r4 = r2.c() + '_' + ((String) r2.i.getValue()) + '_' + sf9.a.d(r2.b(), "task_id");
        if (Intrinsics.areEqual(r4, this.o) == true) goto L24;
        this.o = r4;
        FLogger.a.i(((com.larus.audio.call.plugins.e) this).g, "prepare DoraG SI on first inner play frame, audioId: " + r4);
        r3 = true;
        goto L25
    L14:
        if (getContext().params().s == AudioSessionType.SAMI) goto L15;
    L27:
        if (r1 == false) goto L29;
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.c(null));
    L29:
        super.j3(r8);
    }

    public final void l3(String r5) {
        FLogger.a.i(((com.larus.audio.call.plugins.e) this).g, "reset DoraG SI audio state, reason=" + r5 + ", lastAudioId=" + this.n + ", lastPreparedSiInnerAudioId=" + this.o);
        this.n = null;
        this.o = null;
    }

    public a1(n4 r2, com.larus.audio.call.arch.n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "postProcessor");
        super(r2, r3, false);
    }

    @Override // com.larus.avlink.plugins.DoraAudioFrameReceiver
    public final void k3(l r5, l r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "handledFrame");
        String r0 = r6.c() + '_' + ((String) r6.i.getValue()) + '_' + sf9.a.d(r6.b(), "task_id");
        int r1 = sf9.a.b(r6.b(), "status", 0);
        if (r5.d == false) goto L10;
        if (r1 == 1) goto L6;
    L8:
        FLogger.a.i(((com.larus.audio.call.plugins.e) this).g, "skip silent DoraG SI frame before inner play, audioId: " + r0);
        return;
    L6:
        if (Intrinsics.areEqual(r0, this.n) == false) goto L8;
        com.larus.audio.call.arch.b.a(getContext()).p0(com.larus.audio.call.play.h.b.a);
        l3("silent end frame");
        return;
    L10:
        super.k3(r5, r6);
        if (r1 != 1) goto L15;
        l3("end frame");
        return;
    }
}
