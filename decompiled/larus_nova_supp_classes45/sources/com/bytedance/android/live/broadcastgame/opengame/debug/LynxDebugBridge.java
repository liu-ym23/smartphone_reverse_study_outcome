package com.bytedance.android.live.broadcastgame.opengame.debug;

import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsClient;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsListener;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LynxDebugBridge implements ILiveWsListener {
    public ILiveWsClient a;
    public Function3<? super String, ? super String, ? super String, Unit> b;
    public boolean c;
    public String d;
    public final boolean e;

    public final void onClosed(boolean r1) {
    }

    public final void onConnect() {
        this.c = true;
        int r0 = q.a;
        ALogger.d("OpenPlatformLog", "成功连接IDE");
    }

    public final void onFailure() {
    }

    public LynxDebugBridge(boolean r1) {
        this.e = r1;
        this.d = "";
    }

    public final void onMessage(String r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L39
        JSONObject r8 = LiveSeiUtil.c(r7);     // Catch: Exception -> L39
        String r0 = JSONObjectProtectorUtils.getString(r8, "event");     // Catch: Exception -> L39
        if (r0 != null) goto L8;
    L37:
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L39
    L40:
        return;
    L8:
        switch(r0.hashCode()) {
            case -1636810716: goto L35;
            case -1430411344: goto L32;
            case 123533986: goto L29;
            case 412407969: goto L11;
            default: goto L37;
        };
    L11:
        if (r0.equals("Customized") == false) goto L37;
        JSONObject r11 = r8.optJSONObject("data");     // Catch: Exception -> L39
        if (r11 == null) goto L40;
        if (Intrinsics.areEqual(JSONObjectProtectorUtils.getString(r11, "type"), "OpenCard") == false) goto L40;
        JSONObject r12 = r11.optJSONObject("data");     // Catch: Exception -> L39
        if (r12 == null) goto L40;
        JSONObject r13 = r12.optJSONObject(LiveSlardarConstants.EXTRA_KEY_URL);     // Catch: Exception -> L39
        if (r13 == null) goto L40;
        if (this.e == false) goto L25;
        final JSONObject r14 = r13.optJSONObject("anchor");     // Catch: Exception -> L39
        if (r14 == null) goto L40;
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxDebugBridge$onMessage$$inlined$json$lambda$1(r14, this), 7);     // Catch: Exception -> L39
        goto L40
    L25:
        final JSONObject r15 = r13.optJSONObject("audience");     // Catch: Exception -> L39
        if (r15 == null) goto L40;
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxDebugBridge$onMessage$$inlined$json$lambda$2(r15, this), 7);     // Catch: Exception -> L39
        goto L40
    L29:
        if (r0.equals("Registered") == false) goto L37;
        a("JoinRoom", this.d, null);     // Catch: Exception -> L39
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L39
        goto L40
    L32:
        if (r0.equals("Initialize") == false) goto L37;
        a("Register", null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("id", Long.valueOf(JSONObjectProtectorUtils.getLong(r8, "data"))), TuplesKt.to("info", new JSONObject()), TuplesKt.to("type", "runtime")}));     // Catch: Exception -> L39
        Unit r17 = Unit.INSTANCE;     // Catch: Exception -> L39
        goto L40
    L35:
        if (r0.equals("RoomJoined") == false) goto L37;
        int r18 = q.a;     // Catch: Exception -> L39
        ALogger.d("OpenPlatformLog", "成功初始化调试环境");     // Catch: Exception -> L39
        Unit r19 = Unit.INSTANCE;     // Catch: Exception -> L39
    }

    public final void a(String r4, String r5, Map<String, ? extends Object> r6) {
        JSONObject r0 = new JSONObject();
        r0.put("event", r4);
        if (r5 == null) goto L5;
        r0.put("data", r5);
    L5:
        if (r6 == null) goto L11;
        JSONObject r7 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r8 = r6.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry<String, ? extends Object> r1 = r8.next();
        r7.put(r1.getKey(), r1.getValue());
        goto L8
    L10:
        Unit r9 = Unit.INSTANCE;
        r0.put("data", r7);
    L11:
        ILiveWsClient r11 = this.a;
        if (r11 == null) goto L16;
        r11.send(r0.toString());
        return;
    }
}
