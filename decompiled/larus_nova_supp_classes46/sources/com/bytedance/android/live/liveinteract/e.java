package com.bytedance.android.live.liveinteract;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.bc0;
import com.bytedance.android.livesdk.config.g1;
import com.bytedance.android.livesdk.config.m7;
import com.bytedance.android.livesdk.config.r91;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.RoomBattleMatchRefactorLynx;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import gd0.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public e() {
    }

    static {
    }

    public static void c(Context r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Map r0 = ((rj1) bc0.a.getValue()).b();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = (String) r0.get("schema");
    L9:
        if (r0 == null) goto L11;
        r1 = (String) r0.get("url");
    L11:
        ALogger.i("LynxUtil", "showLinkModeSelectDialog configSchema=" + r2 + ", configUrl=" + r1);
        if (r2 != null) goto L14;
        r2 = "sslocal://webcast_lynxview?type=popup&gravity=bottom&radius=12&height=484&web_bg_color=#FFFFFF";
    L14:
        u6 r3 = new u6(r2);
        if (r1 != null) goto L17;
        r1 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/linkmic_recommend_room_douyin/pages/multi_link_mode_select_video/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L17:
        r3.b("url", r1);
        k.n(IBaseLiveActionHandler.class).handle(r5, r3.c());
        return;
    L7:
        r2 = null;
        goto L9
    }

    public static void e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("match_bubble", "requestPage");
        u6 r0 = a(0, null);
        k.n(IBaseLiveActionHandler.class).handle(r3, r0.c());
    }

    public static u6 a(Integer r10, String r11) {
        Intrinsics.checkNotNullParameter("match_bubble", "requestPage");
        ReadOnlyProperty r0 = h.A5;
        KProperty[] r2 = h.a;
        Long r5 = null;
        u6 r6 = new u6(((RoomBattleMatchRefactorLynx) r0.getValue(null, r2[337(0x151, float:4.72E-43)])).roomBattleMainPanelSchema);
        r6.b("url", ((RoomBattleMatchRefactorLynx) r0.getValue(null, r2[337(0x151, float:4.72E-43)])).roomBattleMainPanelUrl);
        u6 r1 = r6.d("url");
        LocalTestManager.a(new Class[]{wy.a.class});
        String r4 = "0";
        r1.b("enable_debug", "0");
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L5;
        IRoom r7 = (IRoom) r3.getValue();
    L6:
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7 == null) goto L9;
        r5 = Long.valueOf(r7.getId());
    L9:
        r8.put("room_id", String.valueOf(r5));
        if (r7 == null) goto L13;
        String r9 = r7.getOwnerUserIdString();
        if (r9 == null) goto L13;
    L14:
        r8.put("anchor_id", r9);
        i<ILinkPlayerInfoBridge> r12 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r12 == null) goto L20;
        String r13 = String.valueOf(r12.b());
        if (r13 == null) goto L20;
        r4 = r13;
    L20:
        r8.put("user_cnt", r4);
        r8.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r7 != null) goto L23;
    L25:
        String r14 = "video_live";
    L26:
        r8.put("live_type", r14);
        r8.put("request_page", "match_bubble");
        if (r10 == null) goto L29;
        r8.put("match_type", String.valueOf(r10.intValue()));
    L29:
        if (r11 == null) goto L31;
        r8.put("request_source", r11);
    L31:
        Iterator r15 = r8.entrySet().iterator();
    L33:
        if (r15.hasNext() == false) goto L35;
        Map.Entry r16 = (Map.Entry) r15.next();
        r1.b((String) r16.getKey(), (String) r16.getValue());
        goto L33
    L35:
        return r6;
    L23:
        if (r7.isLiveTypeAudio() != true) goto L25;
        r14 = "voice_live";
    L13:
        r9 = "";
        goto L14
    L5:
        r7 = null;
        goto L6
    }

    public static void b(Context r4, Map r5) {
        r91 r0 = h.h().b();
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        u6 r2 = new u6(r1);
        r91 r3 = h.h().b();
        if (r3 == null) goto L11;
        String r6 = r3.b();
        if (r6 == null) goto L11;
    L12:
        String r7 = vm2.d.d0().a();
        if (r2.a(r7) == false) goto L15;
        r6 = "https://" + r7 + ":60006/pages/announce_panel/template.js&enable_latch=1&business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L15:
        r2.b("url", r6);
        u6 r8 = r2.d("url");
        if (r5 == null) goto L21;
        Iterator r9 = r5.entrySet().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        Map.Entry r10 = (Map.Entry) r9.next();
        r8.b((String) r10.getKey(), (String) r10.getValue());
    L21:
        k.n(IBaseLiveActionHandler.class).handle(r4, r2.c());
        return;
    L11:
        r6 = g1.b.b();
        Intrinsics.checkNotNull(r6);
    L6:
        r1 = g1.b.a();
        Intrinsics.checkNotNull(r1);
        goto L7
    }

    public static void d(Context r6, int r7, Map r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ReadOnlyProperty r0 = h.X4;
        KProperty[] r1 = h.a;
        Long r4 = null;
        String r3 = ((m7) r0.getValue(null, r1[308(0x134, float:4.32E-43)])).a();
        if (r3 != null) goto L5;
        r3 = "sslocal://webcast_lynxview?mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=12";
    L5:
        u6 r5 = new u6(r3);
        String r2 = ((m7) r0.getValue(null, r1[308(0x134, float:4.32E-43)])).b();
        if (r2 != null) goto L8;
        r2 = "https://tosv.byted.org/obj/gecko-internal/webcast/mono/lynx/social_help_page_common_douyin/pages/index/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L8:
        r5.b("url", r2);
        u6 r9 = r5.d("url");
        r9.b("intro_type", String.valueOf(r7));
        if (r8 == null) goto L14;
        Iterator r10 = r8.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r11 = (Map.Entry) r10.next();
        r9.b((String) r11.getKey(), (String) r11.getValue());
    L14:
        m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L17;
        IRoom r13 = (IRoom) r12.getValue();
    L18:
        LinkedHashMap r14 = new LinkedHashMap();
        if (r13 == null) goto L21;
        r4 = Long.valueOf(r13.getId());
    L21:
        r14.put("room_id", String.valueOf(r4));
        if (r13 == null) goto L25;
        String r15 = r13.getOwnerUserIdString();
        if (r15 == null) goto L25;
    L26:
        r14.put("anchor_id", r15);
        i<? extends ILinkPlayerInfoBridge> r16 = ((n) k.n(n.class)).getLinkUserInfoCenter();
        if (r16 == null) goto L30;
        String r17 = String.valueOf(r16.b());
        if (r17 == null) goto L30;
    L31:
        r14.put("user_cnt", r17);
        r14.put("action_from", "start");
        r14.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r13 != null) goto L34;
    L36:
        String r18 = "video_live";
    L37:
        r14.put("live_type", r18);
        Iterator r19 = r14.entrySet().iterator();
    L39:
        if (r19.hasNext() == false) goto L41;
        Map.Entry r20 = (Map.Entry) r19.next();
        r9.b((String) r20.getKey(), (String) r20.getValue());
        goto L39
    L41:
        k.n(IBaseLiveActionHandler.class).handle(r6, r5.c());
        return;
    L34:
        if (r13.isLiveTypeAudio() != true) goto L36;
        r18 = "voice_live";
    L30:
        r17 = "0";
    L25:
        r15 = "";
        goto L26
    L17:
        r13 = null;
        goto L18
    }
}
