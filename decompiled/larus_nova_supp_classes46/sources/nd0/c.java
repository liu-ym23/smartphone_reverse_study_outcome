package nd0;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import cy0.j;
import java.util.Iterator;
import jc1.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends BaseMonitor {
    public static final c a = null;

    static {
        a = new c();
    }

    public static MultiLinkEventModule l() {
        Integer r0 = Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene());
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        boolean r3 = r2.isLiveTypeAudio();
    L9:
        return m(r0, Boolean.valueOf(r3));
    L7:
        r3 = false;
        goto L9
    }

    public c() {
    }

    public static MultiLinkEventType n(String r3) {
        MultiLinkEventType r0 = MultiLinkEventType.SERVER_API_CALL;
        if (Intrinsics.areEqual(r3, r0.name()) == false) goto L5;
        return r0;
    L5:
        if (Intrinsics.areEqual(r3, r0.getName()) == true) goto L32;
        MultiLinkEventType r1 = MultiLinkEventType.SDK_CALLBACK;
        if (Intrinsics.areEqual(r3, r1.name()) == false) goto L10;
        return r1;
    L10:
        if (Intrinsics.areEqual(r3, r1.getName()) == true) goto L33;
        MultiLinkEventType r2 = MultiLinkEventType.BUSSINESS_API_CALL;
        if (Intrinsics.areEqual(r3, r2.name()) == false) goto L15;
        return r2;
    L15:
        if (Intrinsics.areEqual(r3, r2.getName()) == true) goto L34;
        MultiLinkEventType r4 = MultiLinkEventType.MESSAGE_RECEIVED;
        if (Intrinsics.areEqual(r3, r4.name()) == true) goto L27;
        if (Intrinsics.areEqual(r3, r4.getName()) == true) goto L27;
        r4 = MultiLinkEventType.SDK_INTERFACE_CALL;
        if (Intrinsics.areEqual(r3, r4.name()) == true) goto L27;
        if (Intrinsics.areEqual(r3, r4.getName()) == true) goto L27;
        return r2;
    L27:
        return r4;
    L34:
        return r2;
    L33:
        return r1;
    L32:
        return r0;
    }

    public static String u(MultiLinkEventType r1) {
        Intrinsics.checkNotNullParameter(r1, "eventType");
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "server_api_name";
    L5:
        if (r2 != 2) goto L7;
        return "server_message_name";
    L7:
        if (r2 != 3) goto L9;
        return "sdk_api_name";
    L9:
        if (r2 != 4) goto L11;
        return "sdk_callback_name";
    L11:
        if (r2 != 5) goto L14;
        return "business_api_name";
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public static MultiLinkEventModule m(Integer r2, Boolean r3) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        if (r2 != null) goto L20;
    L22:
        if (r2 == null) goto L31;
        if (r2.intValue() != 16) goto L31;
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L36;
        return MultiLinkEventModule.MULTI_AUDIO;
    L36:
        return MultiLinkEventModule.BIG_PARTY;
    L31:
        return MultiLinkEventModule.common;
    L20:
        if (r2.intValue() != 9) goto L22;
        return MultiLinkEventModule.KTV;
    L15:
        if (r2.intValue() != 12) goto L17;
    L33:
        return MultiLinkEventModule.BIG_PARTY;
    L10:
        if (r2.intValue() != 8) goto L12;
    L5:
        if (r2.intValue() != 5) goto L7;
        return MultiLinkEventModule.MULTI_AUDIO;
    }

    public static Pair t(Throwable r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "extra");
        int r0 = -1;
        String r1 = "";
        if (r5 != null) goto L5;
    L41:
        BaseMonitor.add(r6, "error_code", r0);
        BaseMonitor.add(r6, "error_msg", r1);
        return new Pair(Integer.valueOf(r0), r1);
    L5:
        if ((r5 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r2 = (CustomApiServerException) r5;
        BaseMonitor.add(r6, "detail_url", r2.getUrl());
        BaseMonitor.add(r6, "log_id", r2.getXTtLogId());
    L8:
        if ((r5 instanceof ApiServerException) == false) goto L26;
        ApiServerException r3 = (ApiServerException) r5;
        String r4 = r3.getErrorMsg();
        if (r4 == null) goto L26;
        if (r4.length() <= 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 != true) goto L26;
        r0 = r3.getErrorCode();
        String r8 = r3.getErrorMsg();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        String r9 = r3.getPrompt();
        if (r9 == null) goto L23;
        r1 = r9;
    L23:
        BaseMonitor.add(r6, "prompt", r1);
    L24:
        r1 = r8;
        goto L41
    L14:
        r7 = false;
    L26:
        if ((r5 instanceof ApiException) == false) goto L31;
        r0 = ((ApiException) r5).getErrorCode();
        r8 = r5.getMessage();
        if (r8 != null) goto L24;
    L31:
        if ((r5 instanceof NetworkErrorException) == false) goto L36;
        r0 = ((NetworkErrorException) r5).statusCode;
        r8 = r5.getMessage();
        if (r8 != null) goto L24;
    L36:
        if ((r5 instanceof Exception) == false) goto L40;
        r8 = r5.getMessage();
        if (r8 != null) goto L24;
    L40:
        r8 = r5.toString();
        goto L24
    }

    public final void q(LinkMonitorData r10, MultiLinkEventModule r11, long r12, Throwable r14, JSONObject r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r11, "eventModule");
        Intrinsics.checkNotNullParameter(r15, "extra");
        BaseMonitor.add(r15, "duration", r12);
        Pair r0 = t(r14, r15);
        p(this, r10, r15, r11, ((Number) r0.getFirst()).intValue(), (String) r0.getSecond(), r16, null, 64);
    }

    public static void o(c r11, LinkMonitorData r12, JSONObject r13, int r14, String r15, boolean r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r17 & 8) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r17 & 16) == 0) goto L13;
        boolean r8 = false;
    L14:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r7, "statusMsg");
        p(r11, r12, r13, l(), r6, r7, r8, null, 64);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public static /* synthetic */ void r(c r8, LinkMonitorData r9, MultiLinkEventModule r10, long r11, Throwable r13, JSONObject r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r8.getClass();
        r10 = l();
    L5:
        r8.q(r9, r10, r11, r13, r14, false);
    }

    public static void s(c r10, LinkMonitorData r11, MultiLinkEventModule r12, long r13, String r15, JSONObject r16, int r17) {
        if ((r17 & 2) == 0) goto L5;
        r10.getClass();
        MultiLinkEventModule r3 = l();
    L7:
        if ((r17 & 32) == 0) goto L9;
        JSONObject r1 = new JSONObject();
    L10:
        JSONObject r7 = r1;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r3, "eventModule");
        Intrinsics.checkNotNullParameter(r15, "logId");
        Intrinsics.checkNotNullParameter(r16, "extra");
        Intrinsics.checkNotNullParameter(r7, "metrics");
        BaseMonitor.add(r16, "duration", r13);
        BaseMonitor.add(r16, "log_id", r15);
        p(r10, r11, r16, r3, 0, null, false, r7, 24);
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r3 = r12;
        goto L7
    }

    public static void p(c r22, LinkMonitorData r23, JSONObject r24, MultiLinkEventModule r25, int r26, String r27, boolean r28, JSONObject r29, int r30) {
        if ((r30 & 4) == 0) goto L5;
        r22.getClass();
        MultiLinkEventModule r9 = l();
    L7:
        if ((r30 & 8) == 0) goto L9;
        int r11 = 0;
    L11:
        if ((r30 & 16) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r30 & 32) == 0) goto L17;
        boolean r0 = false;
    L19:
        if ((r30 & 64) == 0) goto L21;
        JSONObject r1 = new JSONObject();
    L22:
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r24, "extra");
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r12, "statusMsg");
        Intrinsics.checkNotNullParameter(r1, "metrics");
        Intrinsics.checkNotNullParameter(r23, "linkMonitorData");
        BaseMonitor.add(r24, u(r23.getEventType()), r23.getEventTypeValue());
        if (r23.getNeedRoomCommonParams() == false) goto L26;
        od0.c.a(r24);
    L26:
        if (r23.getNeedLinkCommonParams() == false) goto L29;
        od0.a.a(r24);
    L29:
        if (r23.getNeedTalkRoomCommonParams() == false) goto L31;
        od0.d.a(r24);
    L31:
        BaseMonitor.add(r1, "phone_score", String.valueOf(((Number) vm2.g.d.getValue(null, vm2.g.a[2])).floatValue()));
        int r2 = rd0.b.a;
        String r16 = r23.getServiceName();
        JSONObject r19 = new JSONObject();
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "extra");
        Intrinsics.checkNotNullParameter(r3, "metric");
        String r5 = r9.getName();
        Intrinsics.checkNotNullParameter(r5, "eventModuleString");
        String r6 = r23.getEventType().getName();
        Intrinsics.checkNotNullParameter(r6, "eventTypeString");
        r3.put("status_code", String.valueOf(r11));
        r4.put("status_code", String.valueOf(r11));
        Intrinsics.checkNotNullParameter(r12, "string");
        r4.put("status_message", r12);
        Intrinsics.checkNotNullParameter(r4, "map");
        Iterator<String> r7 = r24.keys();
    L33:
        if (r7.hasNext() == false) goto L35;
        String r15 = r7.next();
        Object r8 = r24.get(r15);
        Intrinsics.checkNotNullParameter(r15, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r4.put(r15, r8);
        goto L33
    L35:
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r10).b(n97.a.class);
        Intrinsics.checkNotNull(r13);
        ((com.bytedance.live.kmp.core.c) r13).g(r16, r5, r6, r19, r3, r4);
        if (r0 == true) goto L43;
        pd0.b r14 = pd0.b.a;
        String r17 = r23.getServiceName();
        Intrinsics.checkNotNullParameter(r17, "serviceName");
        boolean r18 = false;
        if (StringsKt.contains$default(r17, "ttlive_multi_revenue_", false, 2, null) == false) goto L40;
        boolean r20 = ((Boolean) vm2.e.y.getValue(null, vm2.e.a[23])).booleanValue();
    L41:
        if (r20 == true) goto L44;
    L45:
        pd0.b r21 = pd0.b.a;
        Intrinsics.checkNotNullParameter(r23, "linkMonitorData");
        if (((Boolean) vm2.e.x.getValue(null, vm2.e.a[22])).booleanValue() == true) goto L49;
    L59:
        if (r18 == false) goto L63;
        jy0.b.d("LinkService", "event: " + r23.getEventTypeValue() + ", status_code: " + r11 + ", status_msg: " + r12);
        jy0.b.d("LinkService", r24.toString());
        int r31 = rd0.a.a;
        rd0.a.c(r23, ProductId.CHAT_CHANNEL, "chat_channel_link", r24, r9, r11, r12);
        return;
    L63:
        return;
    L49:
        if (Intrinsics.areEqual(r23.getServiceName(), "ttlive_channel_link_business_logic") == false) goto L51;
    L58:
        r18 = true;
        goto L59
    L51:
        if (Intrinsics.areEqual(r23.getServiceName(), "ttlive_channel_link_server_api_call") == true) goto L58;
        if (Intrinsics.areEqual(r23.getServiceName(), "ttlive_channel_link_im_message_received") == true) goto L58;
        if (Intrinsics.areEqual(r23.getServiceName(), "ttlive_channel_link_sdk_api_call") == true) goto L58;
        if (Intrinsics.areEqual(r23.getServiceName(), "ttlive_channel_link_sdk_callback") == false) goto L59;
    L44:
        int r32 = rd0.a.a;
        rd0.a.c(r23, ProductId.MULTI_SCENE, "client_multi_scene", r24, r9, r11, r12);
        goto L45
    L40:
        r20 = false;
        goto L41
    L43:
        r18 = false;
        goto L44
    L21:
        r1 = r29;
        goto L22
    L17:
        r0 = r28;
        goto L19
    L13:
        r12 = r27;
        goto L15
    L9:
        r11 = r26;
        goto L11
    L5:
        r9 = r25;
        goto L7
    }
}
