package com.larus.voicecall.impl.component.vlm;

import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.video.VideoPreviewState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g2 implements l3a.c {
    public final /* synthetic */ RealtimeVideoComponent a;

    public g2(RealtimeVideoComponent r1) {
        this.a = r1;
    }

    @Override // l3a.c
    public final void a(com.larus.voicecall.impl.scene.m r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onSceneSelected selected = ");
        if (r4 == null) goto L7;
        SceneModel r2 = r4.a;
        if (r2 == null) goto L7;
        String r3 = r2.getName();
    L8:
        r1.append(r3);
        r1.append("  needEnterVideoCall=");
        r1.append(this.a.V0);
        r0.i("RealtimeVideoComponent", r1.toString());
        com.larus.voicecall.impl.component.scene.a r5 = this.a.V3();
        if (r5 == null) goto L11;
        r5.Fk(this);
    L11:
        if (r4 != null) goto L15;
        RealtimeVideoComponent r6 = this.a;
        if (r6.V0 == false) goto L15;
        com.larus.voicecall.impl.video.n r7 = r6.N;
        r7.getClass();
        r7.a(VideoPreviewState.full, "openLLMVideo", new com.larus.voicecall.impl.video.k());
    L15:
        this.a.V0 = false;
        return;
    L7:
        r3 = null;
        goto L8
    }
}
