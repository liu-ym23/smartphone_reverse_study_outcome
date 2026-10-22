package com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        int r0 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r0 != 4) goto L5;
        r5.put("function_type", "audience");
        return;
    L5:
        if (r0 != 5) goto L7;
        r5.put("function_type", "radio");
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L27;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 != null) goto L19;
        return;
    L19:
        if (d0.h(r2) == false) goto L29;
        r5.put("function_type", "party");
        return;
    L29:
        return;
    L27:
        return;
    L7:
        if (r0 == 12) goto L13;
        switch(r0) {
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L31;
        };
    L10:
        r5.put("function_type", "watch");
        return;
    L11:
        r5.put("function_type", "ktv");
        return;
    L12:
        r5.put("function_type", "radio");
        return;
    L31:
        return;
    L13:
        r5.put("function_type", "party");
    }

    @JvmStatic
    public static final void a(boolean r1, IVoiceLiveTheme r2) {
        if (r1 == false) goto L10;
        Map r3 = null;
        if (r2 != null) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        r3 = MapsKt.mapOf(TuplesKt.to("theme_id", String.valueOf(r2.getId())));
    L9:
        k.n(IPerformanceManager.class).onModuleStart("audio_animated_bg", r3);
        return;
    L10:
        k.n(IPerformanceManager.class).onModuleStop("audio_animated_bg");
    }

    public static void d(Map r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r5 != 1) goto L5;
        r4.put("live_type", "voice_live");
        r4.put("function_type", "ktv");
    L21:
        r4.put("function_type2", ((IInteractService) k.n(IInteractService.class)).getFunctionType2());
        return;
    L5:
        if (r5 != 2) goto L7;
        r4.put("live_type", "voice_live");
        r4.put("function_type", "radio");
        m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r6 == null) goto L16;
        IRoom r7 = (IRoom) r6.getValue();
    L18:
        if (d0.h(r7) == false) goto L21;
        r4.put("function_type", "party");
        goto L21
    L16:
        r7 = null;
        goto L18
    L7:
        if (r5 != 5) goto L9;
        r4.put("live_type", "voice_live");
        r4.put("function_type", "live");
        goto L21
    L9:
        if (r5 != 100) goto L21;
        r4.put("live_type", "voice_live");
        r4.put("function_type", "chorus");
        goto L21
    }

    @JvmStatic
    public static final void b(IVoiceLiveTheme r7, boolean r8, int r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r0 == null) goto L7;
        Long r1 = Long.valueOf(r0.getId());
    L8:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("anchor_id", k.n(IMiddlewareUserService.class).user().n());
        String r3 = r7.getImageUri();
        String r4 = "";
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r2.put("pic_uri", r3);
        r2.put("template_id", String.valueOf(r7.getId()));
        if (r8 == false) goto L14;
        String r10 = "0";
    L15:
        r2.put("is_default", r10);
        if (r1 != null) goto L18;
        r2.put("event_page", "live_take_page");
    L19:
        r2.put("play_mode", w.a());
        int r11 = r7.getFormatType();
        if (r11 != 1) goto L22;
        r4 = "static";
    L26:
        r2.put("pic_type", r4);
        r2.put("template_id", String.valueOf(r7.getId()));
        int r12 = r7.getBgType();
        if (r12 != 3) goto L29;
    L31:
        String r13 = "video_live";
    L32:
        r2.put("live_type", r13);
        d(r2, r9);
        if (r1 != null) goto L35;
        j0.l().sendLog("livesdk_anchor_theme_select", r2, new Object[0]);
        return;
    L35:
        r2.put("room_id", String.valueOf(r1.longValue()));
        j0.l().sendLog("livesdk_anchor_theme_select", r2, new Object[]{IRoom.class});
        return;
    L29:
        if (r12 == 4) goto L31;
        r13 = "voice_live";
        goto L32
    L22:
        if (r11 != 2) goto L26;
        r4 = "dynamic";
        goto L26
    L18:
        r2.put("event_page", "live_take_detail");
        goto L19
    L14:
        r10 = "1";
        goto L15
    L7:
        r1 = null;
        goto L8
    }
}
