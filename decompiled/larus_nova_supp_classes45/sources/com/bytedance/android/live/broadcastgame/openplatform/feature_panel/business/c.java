package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r11, boolean r12) {
        if (r11 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        IBroadcastService r3 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        String r4 = null;
        if (r3 == null) goto L14;
        a00.a r5 = r3.getInteractToolsMobInfo(r11);
    L15:
        if (r5 == null) goto L17;
        Integer r6 = Integer.valueOf(r5.b);
    L18:
        if (r6 == null) goto L20;
        InteractID.a r7 = InteractID.Companion;
        int r8 = r6.intValue();
        r7.getClass();
        InteractID r9 = InteractID.a.b(r8);
    L22:
        if (r9 == null) goto L27;
        int r13 = b.a[r9.ordinal()];
        if (r13 == 1) goto L29;
        if (r13 != 2) goto L27;
        String r14 = "小程序";
    L30:
        String r15 = "";
        if (r5 == null) goto L34;
        String r16 = r5.c;
        if (r16 == null) goto L34;
    L35:
        if (r5 == null) goto L40;
        String r17 = r5.a;
        if (r17 == null) goto L40;
        r15 = r17;
    L40:
        if (r6 == null) goto L42;
        InteractID.a r18 = InteractID.Companion;
        int r19 = r6.intValue();
        r18.getClass();
        InteractID r21 = InteractID.a.b(r19);
    L44:
        if (r21 != InteractID.InteractLoki) goto L46;
        String r22 = "互动特效";
    L47:
        if (r5 == null) goto L49;
        r4 = r5.d;
    L49:
        Map r110 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, r11), TuplesKt.to("event_page", r16), TuplesKt.to("extension_name", r15), TuplesKt.to("extension_type", r22), TuplesKt.to("extension_type_level2", r14)});
        if (r4 != null) goto L59;
    L56:
        u.l().sendLog("livesdk_anchor_interactive_extension_select", r110, new Object[]{IRoom.class});
        return;
    L59:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L58
        JSONObject r23 = LiveSeiUtil.c(r4);     // Catch: Exception -> L58
        r110.put("plugin_type", r23.optString("plugin_type"));     // Catch: Exception -> L58
        r110.put("price", r23.optString("single_month_price"));     // Catch: Exception -> L58
        if (r12 == false) goto L54;
        String r111 = "quit";
    L55:
        r110.put("btn_type", r111);     // Catch: Exception -> L58
        r110.put("app_type", r23.optString("plugin_type"));     // Catch: Exception -> L58
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L58
        goto L56
    L54:
        r111 = "use";
        goto L55
    L46:
        r22 = "互动插件";
        goto L47
    L42:
        r21 = null;
    L34:
        r16 = "";
        goto L35
    L29:
        r14 = "lynx";
    L27:
        r14 = "null";
        goto L30
    L20:
        r9 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L14:
        r5 = null;
        goto L15
    L5:
        if (r11.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
