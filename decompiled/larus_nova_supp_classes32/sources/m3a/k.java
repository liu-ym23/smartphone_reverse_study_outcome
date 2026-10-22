package m3a;

import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.e1;
import com.larus.voicecall.impl.component.top.RealtimeTopComponent;
import com.larus.voicecall.impl.scene.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements l3a.c {
    public final /* synthetic */ RealtimeTopComponent a;

    public k(RealtimeTopComponent r1) {
        this.a = r1;
    }

    @Override // l3a.c
    public final void a(m r2) {
        com.larus.voicecall.impl.component.scene.a.C0016a r0 = com.larus.voicecall.impl.component.scene.a.C1;
        if (r2 == null) goto L5;
        SceneModel r3 = r2.a;
    L6:
        r0.getClass();
        if (com.larus.voicecall.impl.component.scene.a.C0016a.a(r3) == false) goto L15;
        VoiceCallTopLayout r4 = this.a.z;
        if (r4 == null) goto L11;
        e1.o(r4.a.d);
    L11:
        VoiceCallTopLayout r5 = this.a.z;
        if (r5 == null) goto L16;
        e1.x(r5);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
