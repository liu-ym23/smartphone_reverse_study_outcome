package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends BaseMonitor {
    public static tc0.b a;
    public static final n b = null;

    static {
        b = new n();
    }

    public static boolean E() {
        return ((Boolean) vm2.e.v.getValue(null, vm2.e.a[20])).booleanValue();
    }

    public static boolean F() {
        ((Boolean) vm2.e.w.getValue(null, vm2.e.a[21])).booleanValue();
        return true;
    }

    @JvmStatic
    public static final MultiLinkEventModule p() {
        return q(Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
    }

    public static void I() {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        BaseMonitor.add(r1, "link_mode", hd0.c.f().g);
        B(r0, "start_rtc", r1);
    }

    public n() {
    }

    public static void o(long r3) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        BaseMonitor.add(r1, "msg_id", r3);
        A(r0, "admin_audience_join", r1);
    }

    @JvmStatic
    public static final MultiLinkEventModule q(Integer r3) {
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        boolean r2 = r1.isLiveTypeAudio();
    L8:
        if (r3 != null) goto L11;
    L13:
        if (r3 != null) goto L16;
    L18:
        if (r3 != null) goto L21;
    L23:
        if (r3 != null) goto L26;
    L28:
        if (r3 == null) goto L37;
        if (r3.intValue() != 16) goto L37;
        if (r2 != true) goto L42;
        return MultiLinkEventModule.MULTI_AUDIO;
    L42:
        return MultiLinkEventModule.BIG_PARTY;
    L37:
        return MultiLinkEventModule.common;
    L26:
        if (r3.intValue() != 9) goto L28;
        return MultiLinkEventModule.KTV;
    L21:
        if (r3.intValue() != 12) goto L23;
    L39:
        return MultiLinkEventModule.BIG_PARTY;
    L16:
        if (r3.intValue() != 8) goto L18;
    L11:
        if (r3.intValue() != 5) goto L13;
        return MultiLinkEventModule.MULTI_AUDIO;
    L7:
        r2 = false;
        goto L8
    }

    public static void r(long r3) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        y(r0, "prepare_apply", r3, r1);
    }

    public static boolean t(String r3) {
        return ((List) vm2.e.u.getValue(null, vm2.e.a[19])).contains(r3);
    }

    public final void l(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        Intrinsics.checkNotNullParameter(r5, "extra");
        BaseMonitor.add(r5, "room_id", rd0.b.b());
        BaseMonitor.add(r5, "anchor_id", rd0.b.a());
        com.bytedance.live.datacontext.m r1 = m.i().getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        LiveMode r3 = r2.getStreamType();
        if (r3 == null) goto L9;
    L10:
        BaseMonitor.add(r5, "room_scene", r3.ordinal());
        int r4 = 1;
        if (nd0.e.b() != true) goto L13;
        r4 = 2;
    L13:
        BaseMonitor.add(r5, "role_type", r4);
        Intrinsics.checkNotNullParameter(r5, "extra");
        tc0.b r0 = a;
        if (r0 == null) goto L27;
        BaseMonitor.add(r5, "channel_id", String.valueOf(r0.getChannelId()));
        BaseMonitor.add(r5, "rtc_owner_user_id", r0.u());
        BaseMonitor.add(r5, "rtc_current_user_id", nd0.e.a());
        if (r0.zi() == false) goto L19;
        long r6 = 1;
    L20:
        BaseMonitor.add(r5, "is_client_mixstream", r6);
        BaseMonitor.add(r5, "rtc_extra_info", r0.getRtcExtInfo());
        v1 r7 = r0.getMultiRtcInfo();
        if (r7 == null) goto L24;
        String r8 = r7.toString();
        if (r8 == null) goto L24;
    L25:
        BaseMonitor.add(r5, "rtc_multi_extra_info", r8);
        return;
    L24:
        r8 = "";
        goto L25
    L19:
        r6 = 0;
        goto L20
    L27:
        return;
    L9:
        r3 = LiveMode.UNDEFINED;
        goto L10
    }

    public static void G(long r3, String r5) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        int r4 = (int) r3;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        C(r0, "rtc_error", r4, r5, r1);
    }

    public static void H(String r4, long r5) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r4, "linkmicId");
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        BaseMonitor.add(r1, "guest_linkmic_id", r4);
        if (r5 <= 0) goto L5;
        i97.a r6 = i97.a.a;
        BaseMonitor.add(r1, "duration", System.currentTimeMillis() - r5);
    L5:
        D(r0, "first_remote_audio_of_uid", r1);
    }

    public static void J(long r3, String r5) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        int r4 = (int) r3;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        C(r0, "rtc_connect_failure", r4, r5, r1);
    }

    public static void m(String r3, long r4) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r3, "toUserIdString");
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        b.l(r1);
        BaseMonitor.add(r1, "to_user_id", r3);
        y(r0, "prepare_apply_permit", r4, r1);
    }

    public static void s(Throwable r6, long r7) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r5 = new JSONObject();
        b.l(r5);
        x(r0, "prepare_apply", r6, r7, r5);
    }

    public static void A(MultiLinkEventModule r9, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r10, "businessApiName");
        Intrinsics.checkNotNullParameter(r11, "extra");
        if (t(r10) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r11, "business_api_name", r10);
        F();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r7, "metric");
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
        Map r12 = JsonUtil.jsonObjectToMap(r11);
        Intrinsics.checkNotNullParameter(r12, "value");
        Iterator r13 = r12.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r8.put((String) r14.getKey(), r14.getValue());
        goto L7
    L9:
        String r4 = r9.getName();
        Intrinsics.checkNotNullParameter(r4, "eventModuleString");
        String r5 = MultiLinkEventType.SDK_CALLBACK.getName();
        Intrinsics.checkNotNullParameter(r5, "eventTypeString");
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g("ttlive_audience_interactive_bussiness", r4, r5, r6, r7, r8);
    }

    public static void B(MultiLinkEventModule r9, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r10, "sdkApiName");
        Intrinsics.checkNotNullParameter(r11, "extra");
        if (t(r10) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r11, "sdk_api_name", r10);
        F();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r7, "metric");
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
        Map r12 = JsonUtil.jsonObjectToMap(r11);
        Intrinsics.checkNotNullParameter(r12, "value");
        Iterator r13 = r12.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r8.put((String) r14.getKey(), r14.getValue());
        goto L7
    L9:
        String r4 = r9.getName();
        Intrinsics.checkNotNullParameter(r4, "eventModuleString");
        String r5 = MultiLinkEventType.SDK_INTERFACE_CALL.getName();
        Intrinsics.checkNotNullParameter(r5, "eventTypeString");
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g("ttlive_interact_sdk_api_call", r4, r5, r6, r7, r8);
    }

    public static void D(MultiLinkEventModule r9, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r10, "sdkCallbackName");
        Intrinsics.checkNotNullParameter(r11, "extra");
        if (t(r10) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r11, "sdk_callback_name", r10);
        F();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r7, "metric");
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
        Map r12 = JsonUtil.jsonObjectToMap(r11);
        Intrinsics.checkNotNullParameter(r12, "value");
        Iterator r13 = r12.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r8.put((String) r14.getKey(), r14.getValue());
        goto L7
    L9:
        String r4 = r9.getName();
        Intrinsics.checkNotNullParameter(r4, "eventModuleString");
        String r5 = MultiLinkEventType.SDK_CALLBACK.getName();
        Intrinsics.checkNotNullParameter(r5, "eventTypeString");
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g("ttlive_interact_sdk_callback", r4, r5, r6, r7, r8);
    }

    public static void n(String r6, Throwable r7, long r8) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r6, "toUserIdString");
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r5 = new JSONObject();
        b.l(r5);
        BaseMonitor.add(r5, "to_user_id", r6);
        x(r0, "prepare_apply_permit", r7, r8, r5);
    }

    public static void u(int r3, long r4, String r6) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "duration", r4);
        if (r6 != null) goto L5;
        String r5 = "";
    L6:
        BaseMonitor.add(r1, "join_channel_type", r5);
        int r7 = r3 + 10;
        if (vm2.g.a() == false) goto L9;
        r7 = r7 + 100;
    L9:
        if (r6 == null) goto L20;
        int r8 = 1;
        if (r6.length() <= 0) goto L13;
        boolean r9 = true;
    L14:
        if (r9 != true) goto L20;
        if (Intrinsics.areEqual(r6, "apply") == true) goto L19;
        r8 = 2;
    L19:
        r7 = r7 + (r8 * 1000);
        goto L20
    L13:
        r9 = false;
    L20:
        b.getClass();
        z(r0, "interaction_mode_anchor_connection_success", r7, r1);
        return;
    L5:
        r5 = r6;
        goto L6
    }

    public static void v(int r3, long r4, String r6) {
        MultiLinkEventModule r0 = p();
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "duration", r4);
        if (r6 != null) goto L5;
        String r5 = "";
    L6:
        BaseMonitor.add(r1, "join_channel_type", r5);
        if (r6 == null) goto L18;
        int r7 = 1;
        if (r6.length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 != true) goto L18;
        if (Intrinsics.areEqual(r6, "apply") == true) goto L17;
        r7 = 2;
    L17:
        r3 = r3 + (r7 * 1000);
        goto L18
    L11:
        r8 = false;
    L18:
        b.getClass();
        z(r0, "interaction_mode_audience_connection_success", r3, r1);
        return;
    L5:
        r5 = r6;
        goto L6
    }

    public static void K(String r7, int r8, Throwable r9, long r10) {
        MultiLinkEventModule r1 = q(Integer.valueOf(r8));
        Intrinsics.checkNotNullParameter(r7, "supportedScene");
        Intrinsics.checkNotNullParameter(r1, "eventModule");
        JSONObject r6 = new JSONObject();
        b.l(r6);
        BaseMonitor.add(r6, "supported_scene", r7);
        BaseMonitor.add(r6, "request_scene", r8);
        x(r1, "init/v2", r9, r10, r6);
    }

    public static void y(MultiLinkEventModule r8, String r9, long r10, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r8, "eventModule");
        Intrinsics.checkNotNullParameter(r9, "apiPath");
        Intrinsics.checkNotNullParameter(r12, "extra");
        w(r8, r9, 0, "", r10, r12);
    }

    public static void z(MultiLinkEventModule r10, String r11, int r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "eventModule");
        Intrinsics.checkNotNullParameter(r11, "businessApiName");
        Intrinsics.checkNotNullParameter("", "statusMsg");
        Intrinsics.checkNotNullParameter(r13, "extra");
        if (t(r11) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r13, "business_api_name", r11);
        F();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "extra");
        Intrinsics.checkNotNullParameter(r8, "metric");
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r13, "jsonObject");
        Map r14 = JsonUtil.jsonObjectToMap(r13);
        Intrinsics.checkNotNullParameter(r14, "value");
        Iterator r15 = r14.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        Map.Entry r16 = (Map.Entry) r15.next();
        r9.put((String) r16.getKey(), r16.getValue());
        goto L7
    L9:
        String r5 = r10.getName();
        Intrinsics.checkNotNullParameter(r5, "eventModuleString");
        String r6 = MultiLinkEventType.BUSSINESS_API_CALL.getName();
        Intrinsics.checkNotNullParameter(r6, "eventTypeString");
        r8.put("status_code", String.valueOf(r12));
        r9.put("status_code", String.valueOf(r12));
        Intrinsics.checkNotNullParameter("", "string");
        r9.put("status_message", "");
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).b(n97.a.class);
        Intrinsics.checkNotNull(r18);
        ((com.bytedance.live.kmp.core.c) r18).g("ttlive_audience_interactive_bussiness", r5, r6, r7, r8, r9);
    }

    public static void C(MultiLinkEventModule r8, String r9, int r10, String r11, JSONObject r12) {
        if (t(r9) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r12, "sdk_callback_name", r9);
        F();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r12, "jsonObject");
        Map r13 = JsonUtil.jsonObjectToMap(r12);
        Intrinsics.checkNotNullParameter(r13, "value");
        Iterator r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        r7.put((String) r15.getKey(), r15.getValue());
        goto L7
    L9:
        String r3 = r8.getName();
        Intrinsics.checkNotNullParameter(r3, "eventModuleString");
        String r4 = MultiLinkEventType.SDK_CALLBACK.getName();
        Intrinsics.checkNotNullParameter(r4, "eventTypeString");
        r6.put("status_code", String.valueOf(r10));
        r7.put("status_code", String.valueOf(r10));
        Intrinsics.checkNotNullParameter(r11, "string");
        r7.put("status_message", r11);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).b(n97.a.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).g("ttlive_interact_sdk_callback", r3, r4, r5, r6, r7);
    }

    public static void x(MultiLinkEventModule r8, String r9, Throwable r10, long r11, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r8, "eventModule");
        Intrinsics.checkNotNullParameter(r9, "apiPath");
        Intrinsics.checkNotNullParameter(r13, "extra");
        if (t(r9) == false) goto L6;
        return;
    L6:
        if ((r10 instanceof ApiServerException) == false) goto L12;
        ApiServerException r12 = (ApiServerException) r10;
        int r2 = r12.getErrorCode();
        String r14 = r12.getErrorMsg();
        if (r14 != null) goto L10;
        r14 = "";
    L10:
        w(r8, r9, r2, r14, r11, r13);
        return;
    L12:
        if (E() == true) goto L14;
        return;
    L14:
        w(r8, r9, 1, String.valueOf(r10), r11, r13);
    }

    public static void w(MultiLinkEventModule r7, String r8, int r9, String r10, long r11, JSONObject r13) {
        if (t(r8) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r13, "duration", r11);
        BaseMonitor.add(r13, "server_api_name", r8);
        F();
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r13, "jsonObject");
        Map r12 = JsonUtil.jsonObjectToMap(r13);
        Intrinsics.checkNotNullParameter(r12, "value");
        Iterator r14 = r12.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        r6.put((String) r15.getKey(), r15.getValue());
        goto L7
    L9:
        String r2 = r7.getName();
        Intrinsics.checkNotNullParameter(r2, "eventModuleString");
        String r3 = MultiLinkEventType.SERVER_API_CALL.getName();
        Intrinsics.checkNotNullParameter(r3, "eventTypeString");
        r5.put("status_code", String.valueOf(r9));
        r6.put("status_code", String.valueOf(r9));
        Intrinsics.checkNotNullParameter(r10, "string");
        r6.put("status_message", r10);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).b(n97.a.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).g("ttlive_audience_interactive_api_call", r2, r3, r4, r5, r6);
    }
}
