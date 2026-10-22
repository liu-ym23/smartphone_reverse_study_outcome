package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.browser.jsbridge.base.LiveOperateInteractPluginResultModel;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.operateInteractPlugin")
public final class p9 extends w20.e3<w20.ya, LiveOperateInteractPluginResultModel> {

    public static final class a {
    }

    static {
    }

    public p9() {
    }

    public final void invoke(Object r9, CallContext r11) {
        w20.ya r12 = (w20.ya) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.b();
        if (r13 == null) goto L43;
        int r0 = r13.hashCode();
        if (r0 == 3417674) goto L25;
        if (r0 != 94756344) goto L43;
        if (r13.equals("close") == false) goto L43;
        JsonObject r14 = r12.c();
        if (r14 == null) goto L47;
        JsonElement r15 = r14.get("interact_app_id");
        if (r15 == null) goto L48;
        IBroadcastService r16 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r16 == null) goto L19;
        boolean r17 = r16.closeInteractPluginCard(r15.getAsString(), true);
    L20:
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(r15.getAsString(), ReloadPanelType.FROM_CAHCE, false, false, 4));
        if (r17 == false) goto L23;
        finishWithSuccess();
        return;
    L23:
        finishWithFailure();
        return;
    L19:
        r17 = false;
        goto L20
    L48:
        return;
    L47:
        return;
    L25:
        if (r13.equals("open") == false) goto L43;
        JsonObject r18 = r12.c();
        if (r18 == null) goto L51;
        JsonElement r19 = r18.get("schema_url");
        if (r19 == null) goto L52;
        String r5 = null;
        if (RoomContext.a.c(RoomContext.Companion, null, 0, 3) != null) goto L45;
        j(r19, r12, null);
        return;
    L45:
        JsonObject r1 = r12.c();     // Catch: Exception -> L39
        if (r1 == null) goto L40;
        JsonElement r2 = r1.get("interact_app_id");     // Catch: Exception -> L39
        if (r2 == null) goto L40;
        r5 = r2.getAsString();     // Catch: Exception -> L39
    L40:
        if (r5 != null) goto L42;
        finishWithFailure();
        Unit r3 = Unit.INSTANCE;
    L42:
        j(r19, r12, r5);
        return;
    L52:
        return;
    L51:
        return;
    L43:
        finishWithFailure(new Throwable("Unsupported operation type"));
    }

    public final void j(JsonElement r9, w20.ya r11, String r12) {
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        LinkedHashMap r1 = new LinkedHashMap();
        if (r11 == null) goto L11;
        JsonObject r2 = r11.c();
        if (r2 == null) goto L11;
        JsonElement r3 = r2.get("relate_effect_id");
        if (r3 == null) goto L11;
        String r4 = r3.getAsString();
        if (r4 == null) goto L11;
        String r5 = r1.put("relate_effect_id", r4);
    L11:
        String r6 = "";
        if (r11 == null) goto L27;
        String r13 = r11.a();
        if (r13 == null) goto L27;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L26
        JSONObject r14 = LiveSeiUtil.c(r13);     // Catch: Exception -> L26
        String r7 = r14.optString("upload_score_id");     // Catch: Exception -> L26
        String r8 = r14.optString("event_page");     // Catch: Exception -> L24
        String r15 = r14.optString("interact_tool_name");     // Catch: Exception -> L22
        r6 = r14.optString("interact_tool_info");     // Catch: Exception -> L20
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L20
    L21:
        String r17 = r6;
    L23:
        r6 = r8;
    L25:
        String r18 = r17;
        String r19 = r6;
        r6 = r7;
    L28:
        if (r0 == null) goto L30;
        boolean r21 = r0.openPluginMiniApp(r9.getAsString(), r12, r6, r1);
    L31:
        if (r21 == false) goto L40;
        if (r12 == null) goto L39;
        if (r0 == null) goto L39;
        int r22 = InteractID.InteractMiniApp.getValue();
        if (com.bytedance.android.livesdk.utils.r2.a(r19) == true) goto L38;
        r19 = "interactive_extension_detailpage";
    L38:
        r0.putInteractToolsMobInfo(r12, new a00.a(r15, r22, r19, r18));
    L39:
        finishWithSuccess();
        return;
    L40:
        finishWithFailure();
        return;
    L30:
        r21 = false;
    L22:
        r17 = "";
        r15 = r17;
    L24:
        r17 = "";
        r15 = r17;
    L27:
        r19 = "";
        r18 = r19;
        r15 = r18;
        goto L28
    }
}
