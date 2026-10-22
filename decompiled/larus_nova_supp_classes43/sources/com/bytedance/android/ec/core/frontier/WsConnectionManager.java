package com.bytedance.android.ec.core.frontier;

import android.content.Context;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import com.bytedance.common.wschannel.MsgSendListener;
import com.bytedance.common.wschannel.WsChannel;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@GenProtoDecoders
public final class WsConnectionManager {
    public static volatile WsChannel a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final Map<c, Set<b>> d = null;
    public static final WsConnectionManager e = null;

    public static final class a implements MsgSendListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void onSendResult(WsChannelMsg r10, boolean r11) {
            if (r10 == null) goto L8;
            byte[] r12 = r10.getPayload();
            if (r12 == null) goto L9;
            new String(r12, Charsets.UTF_8);
            return;
        L9:
            return;
        }
    }

    public WsConnectionManager() {
    }

    static {
        e = new WsConnectionManager();
        d = new HashMap();
    }

    public static void b(c r12) {
        int r0 = t0.a;
        Gson r1 = t0.a.a;
        ECAppInfoService r10 = ECAppInfoService.e;
        String r13 = GsonProtectorUtils.toJson(r1, new yg.a(r10.getAppId(), r10.getAppVersion(), "android", null, "json", r12.a, r12.b, Integer.valueOf(SceneAction.SceneActionEnter.getNum()), null)).toString();
        Charset r11 = Charsets.UTF_8;
        if (r13 == null) goto L9;
        byte[] r14 = r13.getBytes(r11);
        WsChannel r15 = a;
        if (r15 == null) goto L10;
        r15.sendMsg(new WsChannelMsg.Builder(1060).setLogId(r14.hashCode()).setMethod(1).setService(20177).setPayloadType("json").setPayload(r14).build(), a.a);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static void a(final c r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, "sceneInfo");
        Intrinsics.checkNotNullParameter(r11, "receiver");
        HashMap r0 = (HashMap) d;
        Set r1 = (Set) r0.get(r10);
        if (r1 == null) goto L5;
        r1.add(r11);
    L7:
        if (c == false) goto L19;
        b(r10);
        return;
    L19:
        Context r12 = ECAppInfoService.e.getApplicationContext();     // Catch: Exception -> L15
        Function0<Unit> r13 = new WsConnectionManager$register$2(r10);     // Catch: Exception -> L15
        if (r12 != null) goto L11;
        return;
    L11:
        if (b == true) goto L22;
        b = true;     // Catch: Exception -> L15
        new WsConnectionManager$connect$action$1(r12, r13, r10).run();     // Catch: Exception -> L15
        return;
    L22:
        return;
    L15:
        e = move-exception;
        ye.a.b(e);
        return;
    L5:
        r0.put(r10, SetsKt.mutableSetOf(new b[]{r11}));
        goto L7
    }

    public static void c(c r12, b r13) {
        Intrinsics.checkNotNullParameter(r12, "sceneInfo");
        Intrinsics.checkNotNullParameter(r13, "receiver");
        HashMap r0 = (HashMap) d;
        Set r1 = (Set) r0.get(r12);
        if (r1 == null) goto L5;
        Boolean r14 = Boolean.valueOf(r1.remove(r13));
    L7:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L19;
        Set r15 = (Set) r0.get(r12);
        if (r15 != null) goto L11;
        return;
    L11:
        if (r15.isEmpty() != true) goto L21;
        int r16 = t0.a;
        Gson r17 = t0.a.a;
        ECAppInfoService r10 = ECAppInfoService.e;
        String r18 = GsonProtectorUtils.toJson(r17, new yg.a(r10.getAppId(), r10.getAppVersion(), "android", null, "json", r12.a, r12.b, Integer.valueOf(SceneAction.SceneActionLeave.getNum()), null)).toString();
        Charset r19 = Charsets.UTF_8;
        if (r18 == null) goto L18;
        byte[] r110 = r18.getBytes(r19);
        WsChannel r111 = a;
        if (r111 == null) goto L22;
        r111.sendMsg(new WsChannelMsg.Builder(1060).setLogId(r110.hashCode()).setMethod(1).setService(20177).setPayloadType("json").setPayload(r110).build(), e.a);
        return;
    L22:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        return;
    L19:
        return;
    L5:
        r14 = null;
        goto L7
    }
}
