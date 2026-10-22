package com.bytedance.android.live.revenuelink.rtc;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import fr2.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final String a;
    public long b;
    public long c;
    public long d;
    public long e;
    public final m f;
    public int g;
    public final IRoom h;
    public final com.bytedance.android.live.revenuelink.withroom.a i;

    public final HashMap<String, Object> c() {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("interact_first_video_time_interval", Long.valueOf(this.d));
        r0.put("interact_first_frame_render_interval", Long.valueOf(this.e));
        r0.put("interact_start_join_channel_time_interval", Long.valueOf(this.c));
        r0.put("interact_join_channel_success_time_interval", Long.valueOf(this.b));
        r0.put("scene", Integer.valueOf(this.g));
        IStreamUrlExtra r1 = IRoomKtKt.getStreamUrlExtraSafely(this.h);
        StringBuilder r2 = new StringBuilder();
        r2.append(IStreamUrlExtraKt.getWidthFlex(r1));
        r2.append('-');
        r2.append(IStreamUrlExtraKt.getWidthFlex(r1));
        r0.put("push_stream_info", r2.toString());
        return r0;
    }

    public final LiveTracingMonitorKt.EventModule d() {
        com.bytedance.android.live.revenuelink.connect.f r0 = this.i.Z0();
        Object r1 = null;
        if (r0 == null) goto L7;
        LiveData<ey.f> r2 = r0.connectState();
        if (r2 == null) goto L7;
        ey.f r3 = (ey.f) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        int r4 = r3.c;
    L11:
        int r5 = 7;
        if (r4 != 1) goto L14;
    L17:
        int r6 = 1;
    L18:
        if (r6 != 0) goto L43;
        f r7 = this.i.m0();
        if (r7 == null) goto L37;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L37;
        vc0.a r9 = r8.P0();
        if (r9 == null) goto L37;
        Object r10 = r9.b;
        if ((r10 instanceof xh6.c) == true) goto L28;
        xh6.c r12 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(IConfig.b.class), r9.a);
        if ((r12 instanceof IConfig.b) == false) goto L36;
        r1 = r12;
    L36:
        r1 = (IConfig.b) r1;
        goto L37
    L28:
        if ((r10 instanceof IConfig.b) == false) goto L31;
        r1 = r10;
    L31:
        r1 = (IConfig.b) r1;
    L37:
        IConfig.b.c1.getClass();
        if (Intrinsics.areEqual(r1, IConfig.b.a.b) == false) goto L41;
        r5 = 1;
    L44:
        LiveTracingMonitorKt r13 = LiveTracingMonitorKt.a;
        return LiveTracingMonitorKt.a(r5);
    L41:
        if (Intrinsics.areEqual(r1, IConfig.b.a.a) == true) goto L44;
    L43:
        r5 = r6;
        goto L44
    L14:
        if (r4 == 2) goto L17;
        r6 = 7;
        goto L18
    L10:
        r4 = 0;
    L7:
        r3 = null;
        goto L8
    }

    public static long[] z(Set r5) {
        long[] r0 = new long[r5.size()];
        Iterator r6 = r5.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        r0[r1] = ((Number) r6.next()).longValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public final void g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        HashMap<String, Object> r0 = c();
        r0.put("req_src", r5);
        m.d(this.f, d(), "rtc_ext_info_empty", r0, 8);
    }

    public final void h(int r8) {
        HashMap<String, Object> r4 = c();
        if (r8 != 0) goto L5;
        String r9 = DataType.TRUE;
    L6:
        r4.put("switch_success", r9);
        m.g(this.f, d(), "switch_mix_type", "", r4, 0, 48);
        return;
    L5:
        r9 = DataType.FALSE;
        goto L6
    }

    public final void k(String r9) {
        Intrinsics.checkNotNullParameter(r9, "linkId");
        m.g(this.f, d(), "first_remote_audio_of_uid", r9, c(), 0, 48);
    }

    public final void l(String r10) {
        Intrinsics.checkNotNullParameter(r10, "linkId");
        i97.a r0 = i97.a.a;
        this.d = System.currentTimeMillis();
        m.g(this.f, d(), "first_remote_video_decoded_of_uid", r10, c(), 0, 48);
        jy0.b.f(this.a, "onFirstVideoFrame " + r10, null, 4);
    }

    public final void q(long r12) {
        if (r12 < 0) goto L5;
        return;
    L5:
        if (r12 == (-5)) goto L10;
        HashMap<String, Object> r7 = c();
        this.f.f(d(), "login_error", "", r7, (int) r12, "");
        return;
    }

    public final void u(long r9) {
        i97.a r0 = i97.a.a;
        this.b = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.f r1 = this.i.Z0();
        if (r1 == null) goto L9;
        LiveData<ey.f> r2 = r1.connectState();
        if (r2 == null) goto L9;
        ey.f r3 = (ey.f) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.b;
    L10:
        HashMap<String, Object> r5 = c();
        r5.put(Constants.Keys.duration, Long.valueOf(this.b - r9));
        r5.put("curScene", Integer.valueOf(r4));
        r5.put("scene", Integer.valueOf(this.g));
        m.g(this.f, d(), "did_join_channel", "", r5, 0, 48);
        jy0.b.f(this.a, "onRtcStartSuccess cost " + (System.currentTimeMillis() - r9) + "ms, curScene = " + r4, null, 4);
        return;
    L9:
        r4 = this.g;
        goto L10
    }

    public final void v(String r9) {
        Intrinsics.checkNotNullParameter(r9, "linkId");
        m.g(this.f, d(), "did_user_join", r9, c(), 0, 48);
        jy0.b.f(this.a, "onUserJoin " + r9, null, 4);
    }

    public final void w(String r9) {
        Intrinsics.checkNotNullParameter(r9, "linkId");
        m.g(this.f, d(), "did_offline_of_uid", r9, c(), 0, 48);
        jy0.b.f(this.a, "onUserLeave " + r9, null, 4);
    }

    public d(IRoom r2, com.bytedance.android.live.revenuelink.withroom.a r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "storeService");
        this.h = r2;
        this.i = r3;
        this.a = "ttlive_anchor_link_rtc";
        this.f = new m((IRoomBase) r2, r3);
        this.g = 1;
    }

    public final void a(Object r4, Object r5) {
        if (r4 == null) goto L5;
        if (r5 == null) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        f r1 = this.i.m0();
        if (r1 == null) goto L11;
        i r2 = r1.getRtcManager();
        if (r2 == null) goto L11;
        Object r3 = r2.O();
        if (r3 == null) goto L11;
    L12:
        r0.put("channel_id", r3);
        if (r4 != null) goto L15;
        this.i.getRevenueLinkTraceMonitor().b0("empty_linkid_on_first_frame_render", d(), r0);
    L15:
        if (r5 != null) goto L18;
        this.i.getRevenueLinkTraceMonitor().b0("empty_frame_on_first_frame_render", d(), r0);
        return;
    L18:
        return;
    L11:
        r3 = 0L;
        goto L12
    }

    public final void b(List<? extends fr2.g> r5, String r6) {
        HashMap r0 = new HashMap();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r2 = r5.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((fr2.g) r2.next()).getRoomId());
        goto L4
    L6:
        r0.put("forward_rooms", r1.toString());
        r0.put("req_from", r6);
        ArrayList r7 = (ArrayList) r5;
        if (r7.size() <= 3) goto L10;
        m.i(this.f, d(), "forward_too_many_rooms", r0, r6);
    L10:
        if (r7.isEmpty() == false) goto L14;
        m.i(this.f, d(), "empty_forward_room_list", r0, r6);
        return;
    }

    public final void f(boolean r5, int r6) {
        jy0.b.f(this.a, "monitorPushStream isStart=" + r5 + ", urlCount=" + r6, null, 4);
        m r0 = this.f;
        LiveTracingMonitorKt.EventModule r1 = d();
        HashMap<String, Object> r2 = c();
        r2.put("is_start", Boolean.valueOf(r5));
        r2.put("url_count", Integer.valueOf(r6));
        Unit r7 = Unit.INSTANCE;
        m.d(r0, r1, "streamx_push_stream", r2, 8);
    }

    public final void i(long r8, String r10) {
        HashMap r3 = new HashMap();
        r3.put("source", "rtc_connection_lost");
        r3.put("error_code", String.valueOf(r8));
        HashMap r6 = new HashMap();
        r6.put("business_api_name", "abnormal_finish");
        r6.put("android_event_key", "abnormal_finish");
        m r0 = this.f;
        LiveTracingMonitorKt.EventModule r1 = d();
        int r4 = (int) r8;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r0.h(r1, "ttlive_pk_business_api_call", r3, r4, r10, r6);
    }

    public final void j(long r8, String r10) {
        m r0 = this.f;
        LiveTracingMonitorKt.EventModule r1 = d();
        int r5 = (int) r8;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        HashMap<String, Object> r4 = c();
        r0.f(r1, "did_occur_error", "", r4, r5, r10);
    }

    public final void m(String r10, int r12) {
        Intrinsics.checkNotNullParameter(r10, "linkId");
        i97.a r0 = i97.a.a;
        this.e = System.currentTimeMillis();
        HashMap<String, Object> r6 = c();
        r6.put("frame_index", Integer.valueOf(r12));
        m.g(this.f, d(), "first_remote_video_frame_render", r10, r6, 0, 48);
        jy0.b.d(this.a, "onFirstVideoFrameRender " + r10);
    }

    public final void n(int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "roomId");
        HashMap<String, Object> r5 = c();
        r5.put("target_room_id", r10);
        jy0.b.c(this.a, "onForwardStreamFailed " + r9 + ' ' + r10, null, 4);
        m.g(this.f, d(), "start_forward_stream_failed", "", r5, r9, 32);
    }

    public final void o(int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "roomId");
        HashMap<String, Object> r5 = c();
        r5.put("target_room_id", r10);
        jy0.b.c(this.a, "onForwardStreamStop " + r9 + ' ' + r10, null, 4);
        m.g(this.f, d(), "stop_forward_stream", "", r5, r9, 32);
    }

    public final void p(int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "roomId");
        HashMap<String, Object> r5 = c();
        r5.put("target_room_id", r10);
        jy0.b.c(this.a, "onForwardStreamSuccess " + r9 + ' ' + r10, null, 4);
        m.g(this.f, d(), "start_forward_stream_success", "", r5, r9, 32);
    }

    public final void r(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "linkId");
        HashMap<String, Object> r5 = c();
        r5.put("mute_state", Boolean.valueOf(r10));
        m.g(this.f, d(), "remote_audio_state", r9, r5, 0, 48);
    }

    public final void s(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "linkId");
        HashMap<String, Object> r5 = c();
        r5.put("mute_state", Boolean.valueOf(r10));
        m.g(this.f, d(), "remote_video_state", r9, r5, 0, 48);
        jy0.b.d(this.a, "onRemoteMuteVideo " + r9 + ' ' + r10);
    }

    public final void t(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r6, Constants.OperatorKey.MSG);
        m r1 = this.f;
        LiveTracingMonitorKt.EventModule r2 = d();
        HashMap<String, Object> r3 = c();
        r3.put(Constants.OperatorKey.MSG, r6);
        r3.put("linkmic_id", r5);
        Unit r7 = Unit.INSTANCE;
        m.d(r1, r2, "room_message_received", r3, 8);
    }

    public final void x(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        Intrinsics.checkNotNullParameter(r6, Constants.OperatorKey.MSG);
        m r1 = this.f;
        LiveTracingMonitorKt.EventModule r2 = d();
        HashMap<String, Object> r3 = c();
        r3.put(Constants.OperatorKey.MSG, r6);
        r3.put("linkmic_id", r5);
        Unit r7 = Unit.INSTANCE;
        m.d(r1, r2, "user_message_received", r3, 8);
    }

    public final void y(q r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        i97.a r0 = i97.a.a;
        this.c = System.currentTimeMillis();
        this.e = 0;
        this.b = 0;
        this.d = 0;
        HashMap<String, Object> r1 = c();
        r1.put("rtc_ext_info", r8);
        if (r7.a == false) goto L9;
        if (xa1.f.a() == false) goto L7;
        jy0.b.c("rev_kibana_log", "call monitor start_interact_streaming with extra map: " + r1, null, 4);
        this.f.e("start_interact_streaming_test");
    L7:
        m.d(this.f, d(), "start_interact_streaming", r1, 8);
    L12:
        jy0.b.f(this.a, "startEngine params=" + r7, null, 4);
        return;
    L9:
        if (xa1.f.a() == false) goto L11;
        jy0.b.c("rev_kibana_log", "call monitor join_channel_in_advance with extra map: " + r1, null, 4);
        this.f.e("join_channel_in_advance_test");
    L11:
        m.d(this.f, d(), "join_channel_in_advance", r1, 8);
        goto L12
    }

    public final void e(String r17, String r18, int r19, int r20, Map<String, ? extends Object> r22, p r23) {
        if (r20 == 0) goto L74;
        if (r19 == 0) goto L75;
        int r6 = 0;
        if (r17 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == true) goto L77;
        HashMap<String, Object> r8 = c();
        String r9 = "";
        if (r17 != null) goto L17;
        String r10 = "";
    L18:
        r8.put("rtc_params", r10);
        if (r18 == null) goto L22;
        r9 = r18;
    L22:
        r8.put("update_src", r9);
        r8.put("self_layer_width", Integer.valueOf(r19));
        r8.put("self_layer_height", Integer.valueOf(r20));
        JSONObject r12 = new JSONObject(r17);     // Catch: JSONException -> L69
        JSONObject r0 = r12.optJSONObject("live_rtc_video_param");     // Catch: JSONException -> L69
        String r13 = r12.optString("rtc_business_id");     // Catch: JSONException -> L69
        if (r0 == null) goto L76;
        int r14 = r0.optInt("rtc_video_param_mode");     // Catch: JSONException -> L69
        int r15 = -1;
        if (r14 == 1) goto L45;
        if (r14 == 3) goto L30;
        int r16 = 0;
    L52:
        r8.put("update_rtc_width", Integer.valueOf(r16));     // Catch: JSONException -> L69
        r8.put("update_rtc_height", Integer.valueOf(r15));     // Catch: JSONException -> L69
        if (r23 == null) goto L57;
        List<o> r24 = r23.l();     // Catch: JSONException -> L69
        if (r24 == null) goto L57;
        r6 = r24.size();     // Catch: JSONException -> L69
    L57:
        r8.put("rtc_user_size", Integer.valueOf(r6 + 1));     // Catch: JSONException -> L69
        r8.put("ext_rtc_business_id", r13);     // Catch: JSONException -> L69
        StringBuilder r25 = new StringBuilder();     // Catch: JSONException -> L69
        r25.append(r16);     // Catch: JSONException -> L69
        r25.append('*');     // Catch: JSONException -> L69
        r25.append(r15);     // Catch: JSONException -> L69
        r8.put("ext_rtc_resolution", r25.toString());     // Catch: JSONException -> L69
        if (r22 == null) goto L60;
        r8.putAll(r22);     // Catch: JSONException -> L69
    L60:
        if (r16 == 0) goto L63;
        if (r19 == 0) goto L63;
        float r1 = ((r15 * 1.0f) / r16) - ((r20 * 1.0f) / r19);     // Catch: JSONException -> L69
    L64:
        k r2 = k.j;     // Catch: JSONException -> L69
        r2.getClass();     // Catch: JSONException -> L69
        if (r1 <= ((Number) k.e.getValue(r2, k.a[3])).floatValue()) goto L67;
        m.d(this.f, d(), "pushstream_resolution_redundancy", r8, 8);     // Catch: JSONException -> L69
    L67:
        this.f.c(d(), "switch_rtc_and_livecore_ext_info", r8, true);     // Catch: JSONException -> L69
        return;
    L63:
        r1 = 0.0f;
        goto L64
    L30:
        JSONObject r26 = r0.optJSONObject("rtc_video_param_1v1_client");     // Catch: JSONException -> L69
        if (r26 == null) goto L33;
        r16 = r26.optInt("width");     // Catch: JSONException -> L69
    L34:
        if (r26 == null) goto L36;
        int r110 = r26.optInt("height");     // Catch: JSONException -> L69
    L37:
        if (r26 != null) goto L44;
        JSONObject r3 = r0.optJSONObject("rtc_video_param_1v1_server");     // Catch: JSONException -> L69
        if (r3 == null) goto L41;
        r16 = r3.optInt("width");     // Catch: JSONException -> L69
    L42:
        if (r3 == null) goto L52;
        int r4 = r3.optInt("height");     // Catch: JSONException -> L69
    L51:
        r15 = r4;
        goto L52
    L41:
        r16 = 0;
        goto L42
    L44:
        r15 = r110;
        goto L52
    L36:
        r110 = -1;
        goto L37
    L33:
        r16 = 0;
        goto L34
    L45:
        JSONObject r5 = r0.optJSONObject("rtc_video_param_server_define");     // Catch: JSONException -> L69
        if (r5 == null) goto L48;
        r16 = r5.optInt("width");     // Catch: JSONException -> L69
    L49:
        if (r5 == null) goto L52;
        r4 = r5.optInt("height");     // Catch: JSONException -> L69
        goto L51
    L48:
        r16 = 0;
        goto L49
    L76:
        return;
    L69:
        e = move-exception;
        jy0.b.c("monitorPushResolution", "e = " + e, null, 4);
        return;
    L17:
        r10 = r17;
        goto L18
    L77:
        return;
    L8:
        if (r17.length() == 0) goto L11;
        r7 = false;
        goto L12
    L75:
        return;
    }
}
