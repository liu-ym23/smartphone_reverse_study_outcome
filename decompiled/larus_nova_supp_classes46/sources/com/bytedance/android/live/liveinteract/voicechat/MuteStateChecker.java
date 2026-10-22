package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MuteStateChecker implements rj0.g {
    public final boolean a;
    public final boolean b;
    public long c;
    public long d;
    public final boolean e;
    public final DataCenter f;
    public final y g;
    public final VoiceChatMuteManager h;

    public static final class a {
    }

    static {
    }

    public final void b() {
        UtilityKotlinExtentionsKt.s(2000, false, false, new MuteStateChecker$checkSelfOnSeat$1(this), 6);
    }

    public final com.bytedance.android.live.pushstream.d c() {
        if (this.a == false) goto L7;
        d.s0.getClass();
        d r0 = d.a.a();
        if (r0 != null) goto L18;
    L16:
        return null;
    L18:
        return r0.Ri();
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L11;
        com.bytedance.android.live.pushstream.d r2 = r1.guestLiveStream();
        if (r2 == null) goto L11;
        return r2;
    L11:
        rj0.l.n2.getClass();
        rj0.l r3 = rj0.l.a.a();
        if (r3 == null) goto L16;
        m00.g r4 = r3.hh();
        if (r4 == null) goto L16;
        return r4.getLiveStream();
    }

    @Override // rj0.g
    public final void a(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "timing");
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r1 = IVoiceChatAdminService.a.a();
        boolean r2 = true;
        if (r1 != null) goto L5;
    L6:
        rj0.l.n2.getClass();
        rj0.l r3 = rj0.l.a.a();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.isEngineOn() != true) goto L63;
    L11:
        com.bytedance.android.live.pushstream.d r4 = c();
        if (r4 != null) goto L15;
        return;
    L15:
        if (this.a == false) goto L17;
    L19:
        d0 r5 = r4.getLiveCore();
        if (r5 == null) goto L62;
        boolean r6 = r5.t0();
    L22:
        ILinkPlayerInfoBridge r7 = this.g.p(je0.d.b0(), null);
        if (r7 != null) goto L25;
        return;
    L25:
        Boolean r10 = (Boolean) this.f.get("data_self_is_silenced", Boolean.FALSE);
        if (r7.getSilenceStatus() != 0) goto L30;
        if (r6 == false) goto L30;
        String r11 = "list unSilence but liveCoreMute;";
    L34:
        if (r9 == false) goto L54;
        if (r10.booleanValue() == false) goto L40;
        if (r6 == true) goto L40;
        r11 = r11.concat("local silence but liveCoreUnMute;");
    L40:
        if (r10.booleanValue() == true) goto L44;
        if (r6 == false) goto L44;
        r11 = r11.concat("local unSilence but liveCoreMute;");
    L44:
        if (r10.booleanValue() == false) goto L49;
        if (r7.getSilenceStatus() != 0) goto L49;
        r11 = r11.concat("local silence but list unSilence;");
    L49:
        if (r10.booleanValue() == true) goto L54;
        if (r7.getSilenceStatus() == 0) goto L54;
        r11 = r11.concat("local unSilence but list silence;");
    L54:
        if (r11.length() > 0) goto L57;
        r2 = false;
    L57:
        if (r2 == false) goto L59;
        int r12 = x.a;
        int r13 = r7.getSilenceStatus();
        boolean r14 = r10.booleanValue();
        Intrinsics.checkNotNullParameter(r8, "timing");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("timing", r8);
        r15.put("error_msg", r11);
        r15.put("list_status", Integer.valueOf(r13));
        r15.put("audio_mute", Boolean.valueOf(r6));
        r15.put("local_state", Boolean.valueOf(r14));
        x.t0("self_mute_state_error", r15);
    L59:
        ALogger.i("ttlive_link", "checkSelfMuteState " + r8 + " errorMsg=" + r11);
        return;
    L30:
        if (r7.getSilenceStatus() == 0) goto L33;
        if (r6 == true) goto L33;
        r11 = "list silence but liveCoreUnMute;";
    L33:
        r11 = "";
        goto L34
    L62:
        return;
    L17:
        if (this.b == false) goto L19;
        r6 = r4.t0();
        goto L22
    L63:
        return;
    L5:
        if (r1.isEngineOn() == true) goto L11;
        goto L6
    }

    public MuteStateChecker(DataCenter r2, y r3, VoiceChatMuteManager r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "userInfoCenter");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        boolean r5 = false;
        this.a = a0.d(r2, false);
        this.b = a0.n(r2).isLiveTypeAudio();
        if (vm2.d.m().enable == true) goto L5;
    L7:
        this.e = r5;
        return;
    L5:
        if (vm2.d.P() == false) goto L7;
        r5 = true;
        goto L7
    }
}
