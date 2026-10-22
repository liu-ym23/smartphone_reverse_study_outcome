package com.bytedance.android.live.browser.service;

import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.g1;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostUser;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.he;
import com.bytedance.android.livesdk.v5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements com.bytedance.android.annie.param.m {
    public p() {
    }

    public final void W0(Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        IMiddlewareHostBusiness r0 = jc1.k.n(IMiddlewareHostBusiness.class);
        IRoom r1 = null;
        r0.appendBcmInfo(r7, null, null);
        r0.appendExtGlobalProps(r7, null);
        IMiddleWareHostContext r2 = jc1.k.f(IMiddleWareHostContext.class);
        Object r3 = Boolean.TRUE;
        r7.put("is_live_saas", r3);
        int r4 = com.bytedance.android.livesdk.paas.d.a;
        r7.put("is_live_saas_full_fuse", r3);
        r7.put("webcast_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        IMiddleHostService r5 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r5 == null) goto L8;
        IMiddlewareHostUser r6 = r5.user();
        if (r6 == null) goto L8;
        Object r8 = String.valueOf(r6.hostUserId());
        if (r8 == null) goto L8;
    L9:
        r7.put("host_uid", r8);
        if (((Boolean) v5.a.getValue()).booleanValue() == false) goto L23;
        com.bytedance.live.datacontext.m r9 = o3.f().getRoom();
        if (r9 == null) goto L15;
        r1 = (IRoom) r9.getValue();
    L15:
        if (r1 == null) goto L17;
        long r11 = r1.getRoomId();
    L18:
        int r12 = g1.a;
        if (r11 == 0) goto L21;
        String r13 = "during_live";
    L22:
        r7.put("hybrid_live_scene", r13);
        ALogger.i("Hybrid_Params", "cur room scene :: ".concat(r13));
        goto L23
    L21:
        r13 = "unknown";
        goto L22
    L17:
        r11 = 0;
    L23:
        if (r2 == null) goto L28;
        r7.put("saas_webcast_app_id", Integer.valueOf(jc1.k.n(IMiddleWareHostContext.class).appId()));
        r7.put("ecom_host_appid", r2.ecHostAppId());
        r7.put("fe_param_extra", r2.getFEParamExtra());
        if (((Boolean) he.a.getValue()).booleanValue() == false) goto L29;
        r7.put("effect_sdk_version", r2.getEffectSDKVersion());
        return;
    L29:
        return;
    L28:
        return;
    L8:
        r8 = "";
        goto L9
    }

    public final void y(Map<String, Object> r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        IMiddlewareHostBusiness r0 = jc1.k.n(IMiddlewareHostBusiness.class);
        IRoom r1 = null;
        r0.appendBcmInfo(r7, null, null);
        if (r8 == null) goto L5;
        String r9 = r8.toString();
    L6:
        r0.appendExtGlobalProps(r7, r9);
        IMiddleWareHostContext r11 = jc1.k.f(IMiddleWareHostContext.class);
        Object r2 = Boolean.TRUE;
        r7.put("is_live_saas", r2);
        int r3 = com.bytedance.android.livesdk.paas.d.a;
        r7.put("is_live_saas_full_fuse", r2);
        r7.put("webcast_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        IMiddleHostService r4 = TTMiddlewareLiveSDK.hostMiddlewareService();
        Object r5 = "";
        if (r4 == null) goto L12;
        IMiddlewareHostUser r6 = r4.user();
        if (r6 == null) goto L12;
        Object r12 = String.valueOf(r6.hostUserId());
        if (r12 == null) goto L12;
    L13:
        r7.put("host_uid", r12);
        if (((Boolean) v5.a.getValue()).booleanValue() == false) goto L27;
        com.bytedance.live.datacontext.m r13 = o3.f().getRoom();
        if (r13 == null) goto L19;
        r1 = (IRoom) r13.getValue();
    L19:
        if (r1 == null) goto L21;
        long r14 = r1.getRoomId();
    L22:
        int r15 = g1.a;
        if (r14 == 0) goto L25;
        String r16 = "during_live";
    L26:
        r7.put("hybrid_live_scene", r16);
        ALogger.i("Hybrid_Params", "cur room scene :: ".concat(r16));
        goto L27
    L25:
        r16 = "unknown";
        goto L26
    L21:
        r14 = 0;
    L27:
        if (r11 == null) goto L36;
        r7.put("saas_webcast_app_id", Integer.valueOf(jc1.k.n(IMiddleWareHostContext.class).appId()));
        Object r17 = r11.ecHostAppId();
        if (r17 == null) goto L32;
        r5 = r17;
    L32:
        r7.put("ecom_host_appid", r5);
        r7.put("fe_param_extra", r11.getFEParamExtra());
        if (((Boolean) he.a.getValue()).booleanValue() == false) goto L37;
        r7.put("effect_sdk_version", r11.getEffectSDKVersion());
        return;
    L37:
        return;
    L36:
        return;
    L12:
        r12 = "";
        goto L13
    L5:
        r9 = null;
        goto L6
    }
}
