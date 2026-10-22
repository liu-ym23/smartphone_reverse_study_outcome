package com.larus.voicecall.impl.component.vlm;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.video.VideoPreviewState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l2 implements com.larus.platform.api.g1.c {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ RealtimeVideoComponent b;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public l2(boolean r1, RealtimeVideoComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        if (r2 == true) goto L5;
        FLogger.a.d("RealtimeVideoComponent", "camera permission not granted");
        Keva r6 = RealtimeCallDegradeManager.a;
        if (RealtimeCallDegradeManager.h("video_call", "video_button", true) == false) goto L39;
        FragmentActivity r7 = s1a.a.c(this.b).getActivity();
        if (r7 == null) goto L40;
        r7.finish();
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (this.a == false) goto L7;
        RealtimeVideoComponent r8 = this.b;
        ExitVideoModalReason r9 = ExitVideoModalReason.REJECT_CAMERA_PERMISSION_ON_CLICK;
        int r10 = RealtimeVideoComponent.g1;
        r8.p3(r9, true);
        return;
    L7:
        this.b.S = true;
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("click enter video call. isInSceneMode = ");
        com.larus.voicecall.impl.component.scene.a r0 = this.b.V3();
        if (r0 == null) goto L10;
        Boolean r1 = Boolean.valueOf(r0.oY());
    L11:
        r12.append(r1);
        r12.append(" useNewInteractionStyle = ");
        r12.append(((h88.a) this.b.B3()).k0);
        r12.append(" needEnterVideoCall = ");
        r12.append(this.b.V0);
        r11.i("RealtimeVideoComponent", r12.toString());
        if (((h88.a) this.b.B3()).k0 == false) goto L28;
        com.larus.voicecall.impl.component.scene.a r13 = this.b.V3();
        if (r13 != null) goto L16;
    L18:
        boolean r14 = false;
    L19:
        if (r14 == false) goto L28;
        RealtimeVideoComponent r15 = this.b;
        if (r15.V0 == true) goto L25;
        r15.V0 = true;
        com.larus.voicecall.impl.component.scene.a r16 = r15.V3();
        if (r16 == null) goto L25;
        r16.yM(new g2(r15));
    L25:
        com.larus.voicecall.impl.component.scene.a r17 = this.b.V3();
        if (r17 == null) goto L36;
        r17.Ii("enter_video_call");
        return;
    L36:
        return;
    L16:
        if (r13.oY() != true) goto L18;
        r14 = true;
    L28:
        com.larus.voicecall.impl.video.n r18 = this.b.N;
        r18.getClass();
        r18.a(VideoPreviewState.full, "openLLMVideo", new com.larus.voicecall.impl.video.k());
        return;
    L10:
        r1 = null;
        goto L11
    }
}
