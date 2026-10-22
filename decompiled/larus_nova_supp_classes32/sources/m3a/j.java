package m3a;

import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.utils.e1;
import com.larus.voicecall.impl.component.top.RealtimeTopComponent;
import com.larus.voicecall.impl.video.VideoPreviewState;
import kotlin.jvm.internal.Intrinsics;
import w3a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements w3a.i {
    public final /* synthetic */ RealtimeTopComponent a;

    public j(RealtimeTopComponent r1) {
        this.a = r1;
    }

    @Override // w3a.i
    public final void a(w3a.h r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof w3a.a) == false) goto L10;
        if (((w3a.a) r3).a != RealtimePageMode.HALF_SCREEN) goto L19;
        VoiceCallTopLayout r4 = this.a.z;
        if (r4 == null) goto L20;
        e1.o(r4);
        return;
    L20:
        return;
    L19:
        return;
    L10:
        if ((r3 instanceof o) == false) goto L22;
        RealtimeTopComponent r0 = this.a;
        int r1 = RealtimeTopComponent.C;
        if (((h88.a) r0.h3()).k0 == true) goto L14;
        return;
    L14:
        if (((o) r3).a == VideoPreviewState.full) goto L24;
        VoiceCallTopLayout r5 = this.a.z;
        if (r5 == null) goto L25;
        e1.o(r5);
        return;
    L25:
        return;
    L24:
        return;
    }
}
