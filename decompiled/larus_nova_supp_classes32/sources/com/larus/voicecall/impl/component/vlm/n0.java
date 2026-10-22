package com.larus.voicecall.impl.component.vlm;

import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.video.VideoPreviewState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class n0 implements Function0 {
    public final /* synthetic */ RealtimeVideoComponent a;

    public /* synthetic */ n0(RealtimeVideoComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        RealtimeVideoComponent r0 = this.a;
        int r1 = RealtimeVideoComponent.g1;
        AppHost.Companion r2 = AppHost.a;
        boolean r3 = false;
        if ((r2.a().getCurrentActivity() instanceof d4) == false) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (((h88.a) r0.B3()).k0 == false) goto L12;
        if (r4 == false) goto L12;
        FLogger.a.w("RealtimeVideoComponent", "pinchClicker exec. but not in chat activity");
    L39:
        return Unit.INSTANCE;
    L12:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("pinchClicker before switch, subtitleOpen=");
        RealtimeCallUtil.a.getClass();
        r6.append(RealtimeCallUtil.z);
        r6.append(", subtitleAbilityNull=");
        if (r0.W3() != null) goto L15;
        boolean r7 = true;
    L16:
        r6.append(r7);
        r6.append(", isFloatSubtitle=");
        com.larus.voicecall.impl.component.subtitle.a r8 = r0.W3();
        Boolean r9 = null;
        if (r8 == null) goto L19;
        Boolean r10 = Boolean.valueOf(r8.NT());
    L20:
        r6.append(r10);
        r6.append(", lastPreviewState=");
        r6.append(r0.U);
        r6.append(", isFullVideo=");
        r6.append(((h88.b) r0.Q3()).r);
        r6.append(", isPipVideo=");
        r6.append(((h88.b) r0.Q3()).s);
        r5.i("RealtimeVideoComponent", r6.toString());
        if (RealtimeCallUtil.z == false) goto L36;
        boolean r11 = r0.R4();
        StringBuilder r12 = new StringBuilder("switchSubtitleWhenPopToFullVideo, useFloatSubtitle=");
        r12.append(r11);
        r12.append(", subtitleAbilityNull=");
        if (r0.W3() != null) goto L25;
        r3 = true;
    L25:
        r12.append(r3);
        r12.append(", currentFloatSubtitle=");
        com.larus.voicecall.impl.component.subtitle.a r13 = r0.W3();
        if (r13 == null) goto L28;
        r9 = Boolean.valueOf(r13.NT());
    L28:
        r12.append(r9);
        r12.append(", lastPreviewState=");
        r12.append(r0.U);
        r12.append(", isFullVideo=");
        r12.append(((h88.b) r0.Q3()).r);
        r12.append(", isPipVideo=");
        r12.append(((h88.b) r0.Q3()).s);
        r5.i("RealtimeVideoComponent", r12.toString());
        if (r11 == false) goto L33;
        com.larus.voicecall.impl.component.subtitle.a r14 = r0.W3();
        if (r14 == null) goto L37;
        r14.Cf(true, "pop_to_full_video");
    L37:
        com.larus.voicecall.impl.video.n r15 = r0.N;
        r15.getClass();
        r15.a(VideoPreviewState.full, "onVideoViewPortClick", new com.larus.voicecall.impl.video.l());
        int r16 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.c(r0.Q3().a(), r0.B3(), ((h88.b) r0.Q3()).m, false, Boolean.valueOf(Intrinsics.areEqual(r0.N.b.getValue(), Boolean.TRUE)), "small_window", null, null, 200);
        goto L39
    L33:
        com.larus.voicecall.impl.component.subtitle.a r17 = r0.W3();
        if (r17 == null) goto L37;
        r17.Zk("pop_to_full_video");
        goto L37
    L36:
        r5.i("RealtimeVideoComponent", "pinchClicker skip switchSubtitleWhenPopToFullVideo, subtitleOpen=false");
        goto L37
    L19:
        r10 = null;
        goto L20
    L15:
        r7 = false;
        goto L16
    L5:
        if ((r2.a().getCurrentActivity() instanceof j4) == true) goto L7;
        r4 = true;
        goto L9
    }
}
