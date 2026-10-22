package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends BaseMonitor {
    public static final String a = null;
    public static final String b = null;

    static {
        LiveSlardarConstants.suffixAll("ttlive_pk_open_api");
        LiveSlardarConstants.suffixError("ttlive_pk_open_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_finish_api");
        LiveSlardarConstants.suffixError("ttlive_pk_finish_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_stats_api");
        LiveSlardarConstants.suffixError("ttlive_pk_stats_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_sei_api");
        LiveSlardarConstants.suffixError("ttlive_pk_sei_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_permission_api");
        LiveSlardarConstants.suffixError("ttlive_pk_permission_api");
        a = LiveSlardarConstants.suffixAll("ttlive_interact_plugin_api");
        b = LiveSlardarConstants.suffixError("ttlive_interact_plugin_api");
    }

    public static boolean l(String r3) {
        List r0 = (List) vm2.d.q8.getValue(null, vm2.d.a[481(0x1e1, float:6.74E-43)]);
        if (Lists.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        if (r0.contains(r3) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void p(Map r3) {
        r3.put("event", "rtc_mix_sei");
        Room r0 = m.i().getCurrentRoom();
        if (r0 == null) goto L5;
        r3.put("room_id", r0.getIdStr());
        r3.put("anchor_id", r0.getOwnerUserIdString());
    L5:
        b0.o().j("ttlive_link", r3);
    }

    public static void q(long r3, int r5) {
        HashMap r0 = new HashMap();
        r0.put("pluginName", "live_resource");
        r0.put("duration", Long.valueOf(r3));
        r0.put("pre_load_strategy", Integer.valueOf(r5));
        LiveSlardarMonitor.monitorStatusAndDuration(b, 1, 0, r0);
    }

    public static void r(String r6, Throwable r7) {
        if (l(r6) == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put(MultiLinkOpenSource.MESSAGE, r7.getMessage());
        r0.put("event", r6);
        StringBuilder r8 = new StringBuilder();
        if (r7.getStackTrace() == null) goto L10;
        StackTraceElement[] r9 = r7.getStackTrace();
        int r1 = r9.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L10;
        r8.append("\t\t" + r9[r2].toString());
        r2 = r2 + 1;
    L10:
        r0.put("trace", r8.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", 1, r0);
    }

    public static void s(String r2, Map<String, Object> r3) {
        if (l(r2) == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("event", r2);
        r0.putAll(r3);
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", 1, r0);
    }

    public static void o(String r2, Map<String, Object> r3, tf0.i r4) {
        r3.put("event", r2);
        r3.put("channel_id", Long.valueOf(r4.getChannelId()));
        r3.put("interact_id", r4.getInteractId());
        Room r5 = m.i().getCurrentRoom();
        if (r5 == null) goto L5;
        r3.put("room_id", r5.getIdStr());
        r3.put("anchor_id", r5.getOwnerUserIdString());
    L5:
        b0.o().j("ttlive_link", r3);
    }

    public static void m(String r3, Map<String, Object> r4, tf0.i r5, long r6) {
        if (l(r3) == false) goto L5;
        return;
    L5:
        r4.put("event", r3);
        r4.put("channel_id", Long.valueOf(r5.getChannelId()));
        r4.put("interact_id", r5.getInteractId());
        com.bytedance.android.livesdk.user.e r7 = jc1.k.f(IMiddlewareUserService.class).user();
        Room r0 = m.i().getCurrentRoom();
        if (r0 == null) goto L9;
        if (r7 == null) goto L9;
        r4.put("room_id", r0.getIdStr());
        r4.put("anchor_id", r0.getOwnerUserIdString());
        boolean r8 = Objects.equals(r0.getOwnerUserIdString(), r7.n());
    L10:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_interact_event_api_all", d.a(r3, ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene(), r8), r6, r4);
        b0.o().j("ttlive_link", r4);
        return;
    L9:
        r8 = false;
        goto L10
    }

    public static void n(String r2, Map<String, Object> r3, tf0.i r4, boolean r5) {
        if (l(r2) == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = new HashMap();
    L7:
        r3.put("event", r2);
        r3.put("channel_id", Long.valueOf(r4.getChannelId()));
        r3.put("interact_id", r4.getInteractId());
        if (r5 == false) goto L10;
        r3.put("rtc_info", r4.getRtcInfo());
    L10:
        com.bytedance.android.livesdk.user.e r6 = jc1.k.f(IMiddlewareUserService.class).user();
        Room r7 = m.i().getCurrentRoom();
        if (r7 == null) goto L14;
        if (r6 == null) goto L14;
        r3.put("room_id", r7.getIdStr());
        r3.put("anchor_id", r7.getOwnerUserIdString());
        boolean r8 = Objects.equals(r7.getOwnerUserIdString(), r6.n());
    L15:
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", d.a(r2, ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene(), r8), r3);
        b0.o().j("ttlive_link", r3);
        return;
    L14:
        r8 = false;
        goto L15
    }
}
