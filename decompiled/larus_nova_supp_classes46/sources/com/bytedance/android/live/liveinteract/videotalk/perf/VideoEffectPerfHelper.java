package com.bytedance.android.live.liveinteract.videotalk.perf;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import ec6.b;
import hd0.c;
import hg6.g;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VideoEffectPerfHelper {
    public boolean a;
    public String b;
    public final boolean c;
    public final j1 d;

    public static final class a {
    }

    static {
    }

    public final void c() {
        String r0 = this.b;
        if (r0 != null) goto L23;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.performance.a r2 = r1.getMultiLinkPerfAbilityManager(true);
        if (r2 == null) goto L22;
        j1 r3 = this.d;
        if (r3 == null) goto L21;
        cg6.a r4 = r3.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r4 == null) goto L21;
        g r5 = r4.getRtcManager();
        if (r5 == null) goto L21;
        ei6.a r6 = r5.V0();
        if (r6 == null) goto L21;
        fi6.a r7 = r6.g();
        if (r7 == null) goto L21;
        qi6.g r8 = r7.F;
        if (r8 == null) goto L21;
        ALogger.i("MultiLinkAtomicAbility-VideoEffect", "handleVideoEffectPerfInit width=" + r8.c + " height=" + r8.d);
        e(r8.c, r8.d);
    L21:
        r0 = r2.b("multilink_video_effect", new VideoEffectPerfHelper$handleVideoEffectPerfInit$$inlined$let$lambda$1(this));
    L22:
        r0 = null;
    L23:
        this.b = r0;
    }

    public final void d() {
        String r0 = this.b;
        if (r0 == null) goto L9;
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r3 = r2.getMultiLinkPerfAbilityManager(false);
        if (r3 == null) goto L9;
        r3.c("multilink_video_effect", r0);
    L9:
        this.b = null;
        if (this.a == false) goto L13;
        this.a = false;
        b(a("", ""));
        return;
    }

    public final void b(String r3) {
        j1 r0 = this.d;
        if (r0 == null) goto L14;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L15;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L16;
        b r4 = r2.R();
        if (r4 == null) goto L17;
        d r5 = gc6.b.a(r4);
        if (r5 == null) goto L18;
        r5.e0("GradedOptConfig", r3);
        ALogger.i("MultiLinkAtomicAbility-VideoEffect", "handleConfigChange configStr=" + r3 + ' ');
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public VideoEffectPerfHelper(boolean r1, j1 r2) {
        this.c = r1;
        this.d = r2;
    }

    public static String a(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("face_extra_model_name", r2);
        r0.put("matting_model_name", r3);
        return r0.toString();
    }

    public final void e(int r4, int r5) {
        ALogger.i("MultiLinkAtomicAbility-VideoEffect", "notifyCaptureVideoWHChanged width=" + r4 + " height=" + r5);
        if (r4 >= 360) goto L45;
        if (r5 >= 640) goto L45;
        IInteractService r6 = (IInteractService) k.f(IInteractService.class);
        if (r6 == null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.performance.a r7 = r6.getMultiLinkPerfAbilityManager(true);
        if (r7 == null) goto L12;
        boolean r8 = r7.a("multilink_video_effect");
    L13:
        if (r8 == false) goto L15;
        return;
    L15:
        if (this.a == false) goto L17;
        return;
    L17:
        if (this.c == false) goto L30;
        DigitAvatarContext.a r9 = DigitAvatarContext.Companion;
        DigitAvatarContext r0 = r9.getContext();
        VideoShowMode r1 = null;
        if (r0 == null) goto L21;
        VideoShowMode r2 = r0.getCurrentVideoShowMode();
    L23:
        if (r2 == VideoShowMode.VIDEO) goto L35;
        DigitAvatarContext r10 = r9.getContext();
        if (r10 == null) goto L28;
        r1 = r10.getCurrentVideoShowMode();
    L28:
        if (r1 != VideoShowMode.DIGIT_AVATAR) goto L30;
    L35:
        j1 r11 = this.d;
        if (r11 == null) goto L52;
        cg6.a r12 = r11.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r12 == null) goto L53;
        g r13 = r12.getRtcManager();
        if (r13 != null) goto L42;
        return;
    L42:
        if (r13.isEngineOn() != true) goto L55;
        this.a = true;
        b(a("tt_face_extra_multiguest", "tt_matting_multiguest"));
        return;
    L55:
        return;
    L53:
        return;
    L52:
        return;
    L21:
        r2 = null;
    L30:
        if (this.c == false) goto L32;
        return;
    L32:
        if (c.f().g == 3) goto L35;
        if (c.f().g == 1) goto L35;
        return;
    L12:
        r8 = true;
    L45:
        if (this.a == false) goto L57;
        this.a = false;
        b(a("", ""));
        return;
    }
}
