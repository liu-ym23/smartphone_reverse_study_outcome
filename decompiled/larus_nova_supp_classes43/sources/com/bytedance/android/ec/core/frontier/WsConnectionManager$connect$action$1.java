package com.bytedance.android.ec.core.frontier;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.common.wschannel.ChannelInfo;
import com.bytedance.common.wschannel.WsChannel;
import com.bytedance.common.wschannel.WsChannelSdk2;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WsConnectionManager$connect$action$1 implements Action {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ c c;

    public final void run() {
        ArrayList r0 = new ArrayList();
        r0.add("wss://frontier.snssdk.com/ws/v2");
        HashMap r1 = new HashMap();
        r1.put("ttnet_ignore_offline", "1");
        ECAppInfoService r10 = ECAppInfoService.e;
        String r11 = r10.getSessionKey();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r1.put("sid", r11);
        if (we.a.a == false) goto L22;
        r r12 = r.a;
        String r13 = r12.getCurrentUserId();
        if ((!StringsKt.isBlank(r13)) == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L13;
        r1.put("OpenID", r13);
    L13:
        String r14 = r12.getAccessToken();
        if (r14 == null) goto L22;
        if ((!StringsKt.isBlank(r14)) == true) goto L19;
        r14 = null;
    L19:
        if (r14 == null) goto L22;
        r1.put("Authorization", "Bearer ".concat(r14));
    L22:
        if (we.a.a == false) goto L24;
        Integer r15 = 7386;
    L28:
        String r16 = r10.getAppVersion();
        if (r16 == null) goto L31;
        Integer r17 = StringsKt.toIntOrNull(r16);
    L32:
        if (r15 == null) goto L48;
        if (r17 == null) goto L51;
        ChannelInfo r18 = ChannelInfo.Builder.create(1060).setAppKey("a1ede44a8715fd38c64d52cbd6dc7f5b").setFPID(32).setAid(r15.intValue()).setAppVersion(r17.intValue()).setDeviceId(r10.getServerDeviceId()).setInstallId(r10.getInstallId()).urls(r0).extras(r1).builder();
        WsChannel r19 = WsConnectionManager.a;
        WsConnectionManager.a = WsChannelSdk2.registerChannel(this.a, r18, new WsConnectionManager$connect$action$1$run$5(this));
        f.c.getClass();
        if (f.a == true) goto L39;
        f.a = true;
        f.b = Long.valueOf(SystemClock.elapsedRealtime());
    L39:
        SparseBooleanArray r20 = g.a;
        c r21 = this.c;
        WsChannel r22 = WsConnectionManager.a;
        Intrinsics.checkNotNullParameter(r21, "sceneInfo");
        if (r22 == null) goto L42;
        Integer r23 = Integer.valueOf(r22.hashCode());
    L43:
        if (r23 == null) goto L49;
        int r24 = r23.intValue();
        SparseBooleanArray r25 = g.a;
        if (r25.get(r24) == true) goto L50;
        r25.put(r24, true);
        int r26 = ECMonitorService.b;
        JSONObject r27 = new JSONObject();
        r27.put("where_invoke", "begin");
        r27.put("scene_type", r21.a);
        Unit r28 = Unit.INSTANCE;
        JSONObject r29 = new JSONObject();
        r29.put("scene_item_id", r21.b);
        ECMonitorService.a.a("ec_ws_connection_usability", r27, null, r29);
        g.b.put(r24, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L50:
        return;
    L49:
        return;
    L42:
        r23 = null;
        goto L43
    L51:
        return;
    L48:
        return;
    L31:
        r17 = null;
        goto L32
    L24:
        String r30 = r10.getAppId();
        if (r30 == null) goto L27;
        r15 = StringsKt.toIntOrNull(r30);
        goto L28
    L27:
        r15 = null;
        goto L28
    }

    public WsConnectionManager$connect$action$1(Context r1, Function0 r10, c r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
