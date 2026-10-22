package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.mgr.MajorState;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b3 extends com.larus.audio.call.play.e {
    public final /* synthetic */ RealtimeSwitchMicroPlugin<com.larus.audio.call.arch.c> a;

    public final void onPlayComplete() {
        MajorState.d r0 = this.a.getContext().a().s1();
        if ((r0 instanceof MajorState.d) == false) goto L15;
        MajorState.d r1 = r0;
        if (r1.c != MajorState.From.PLAY_COMPLETE) goto L16;
        boolean r2 = CollectionsKt.listOf(new MajorState.InterruptType[]{MajorState.InterruptType.AUTO, MajorState.InterruptType.USER}).contains(r1.d);
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.v == false) goto L10;
        if (r2 == false) goto L10;
        FLogger.a.i(this.a.f, "[onPlayCompleteForNow] triggerPlayMicroVoice ignore, curStatus:" + r0);
        return;
    L10:
        if (r2 == true) goto L18;
        RealtimeSwitchMicroPlugin<com.larus.audio.call.arch.c> r3 = this.a;
        if (r3.h == false) goto L19;
        FLogger.a.i(r3.f, "[onPlayCompleteForNow] triggerPlayMicroVoice start, curStatus:" + r0);
        this.a.h = false;
        return;
    L19:
        return;
    L18:
        return;
    L16:
        return;
    }

    public b3(RealtimeSwitchMicroPlugin<com.larus.audio.call.arch.c> r1) {
        this.a = r1;
    }
}
