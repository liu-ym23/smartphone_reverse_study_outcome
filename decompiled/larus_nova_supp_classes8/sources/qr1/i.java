package qr1;

import am2.a0;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.episode.BaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements jm1.b {
    public JSONObject a;
    public JSONObject b;
    public JSONObject c;
    public List<APMEvent> d;
    public final LiveRoomAPMConfig e;
    public b f;
    public final Bundle g;
    public String h;
    public String i;
    public String j;
    public String k;
    public final wr1.a l;
    public final DataCenter m;
    public long n;
    public final a o;
    public final WeakHandler p;

    public class a implements WeakHandler.IHandler {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void handleMsg(Message r3) {
            if (r3.what != 2) goto L13;
            this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, "enter room timeout"));
            if (this.a.c.opt("network_status") != null) goto L9;
            this.a.a("network_status", "time_out");
        L9:
            if (this.a.c.opt("player_status") != null) goto L11;
            this.a.a("player_status", "time_out");
        L11:
            i r4 = this.a;
            r4.f.c = true;
            r4.h(1, "");
            return;
        }
    }

    public static class b {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;

        public b() {
        }
    }

    public final long f() {
        Bundle r0 = this.g;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Long r1 = Long.valueOf(r0.getLong("live.intent.extra.EXTRA_BEGIN_START_ACTIVITY_TIME", 0));
        if (r1.longValue() > 0) goto L8;
        Long r2 = Long.valueOf(this.g.getLong("live.intent.extra.EXTRA_ACTIVITY_ON_CREATE_TIME", 0));
        if (r2.longValue() <= 0) goto L14;
        return r2.longValue();
    L14:
        return this.g.getLong("live.intent.extra.EXTRA_ENTER_ROOM_STAR_TIME", 0);
    L8:
        return r1.longValue();
    }

    public final void b(Map<String, String> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.containsKey("enter_from_merge") == false) goto L8;
        a("enter_from_merge", r3.get("enter_from_merge"));
    L8:
        if (r3.containsKey("enter_method") == false) goto L11;
        a("enter_method", r3.get("enter_method"));
    L11:
        if (r3.containsKey("action_type") == false) goto L14;
        a("action_type", r3.get("action_type"));
        return;
    }

    public final void c(APMEvent r10) {
        List r0 = this.e.blackEventName;
        if (r0 == null) goto L7;
        if (r0.contains(r10.a()) == false) goto L7;
        return;
    L7:
        if (((ArrayList) this.d).size() <= this.e.maxEventSize) goto L9;
        ListProtector.remove(this.d, 0);
    L9:
        ((ArrayList) this.d).add(r10);
        if (r10.b() != APMEvent.Level.E) goto L19;
        if (this.e.enableWriteALogE == false) goto L27;
        Spm r1 = Spm.obtain().businessId(String.valueOf(this.h)).addArg("user_id", String.valueOf(this.j)).result(500).addArg("tag", "VSEpisodeAPMMonitor").addArg("key", r10.a());
        if (r10.c() != null) goto L16;
        String r11 = "";
    L17:
        Spm r12 = r1.addArg("message", r11);
        ArrayList r2 = sw2.a.a;
        Intrinsics.checkNotNullParameter(r12, "spm");
        sw2.a.b(r12, "");
        return;
    L16:
        r11 = r10.c();
        goto L17
    L27:
        return;
    L19:
        if (this.e.enableWriteALogI == false) goto L29;
        Spm r3 = Spm.obtain().businessId(String.valueOf(this.h)).addArg("user_id", String.valueOf(this.j)).result(200).addArg("tag", "VSEpisodeAPMMonitor").addArg("key", r10.a());
        if (r10.c() != null) goto L23;
        String r13 = "";
    L24:
        Spm r14 = r3.addArg("message", r13);
        ArrayList r4 = sw2.a.a;
        Intrinsics.checkNotNullParameter(r14, "spm");
        sw2.a.b(r14, "");
        return;
    L23:
        r13 = r10.c();
        goto L24
    }

    public final void m00(Episode r5) {
        this.i = r5.attachRoomIdStr;
        this.k = EpisodeExtKt.getOwnerIdString(r5);
        c(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "room/enter request success", "log_id=" + r5.getRequestLogID()));
        d("room_auth", String.valueOf(r5.getRoomAuthStatus()));
        d("log_id", r5.getRequestLogID());
        long r0 = this.b.optLong("point_start_request_time", -1);
        d("point_finish_request_time", String.valueOf(System.currentTimeMillis()));
        if (r0 <= 0) goto L5;
        e("enter_request_start_to_end_cost", System.currentTimeMillis() - r0);
    L5:
        a("network_status", "success");
        this.f.b = true;
        h(0, "");
    }

    public static void g(Map r2, JSONObject r3) {
        if (r2 == null) goto L15;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L23;
        Iterator r4 = r2.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L24;
        Map.Entry r0 = (Map.Entry) r4.next();
        r3.put((String) r0.getKey(), r0.getValue());     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L24:
        return;
    L23:
        return;
    }

    public final void a(String r2, String r3) {
        JSONObject r0 = this.c;
        if (r0 == null) goto L9;
        r0.put(r2, r3);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void d(String r2, String r3) {
        JSONObject r0 = this.b;
        if (r0 == null) goto L9;
        r0.put(r2, r3);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void e(String r2, long r3) {
        JSONObject r0 = this.a;
        if (r0 == null) goto L9;
        r0.put(r2, r3);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void h(int r10, String r11) {
        b r0 = this.f;
        if (r0.c == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        return;
    L11:
        if (r0.e == false) goto L13;
        return;
    L13:
        r0.e = true;
        this.p.removeMessages(2);
        DataCenter r2 = this.m;
        if (r2 != null) goto L16;
    L22:
        DataCenter r3 = this.m;
        if (r3 != null) goto L25;
        Map<String, String> r4 = Collections.emptyMap();
    L29:
        b(r4);
        long r5 = f();
        long r6 = System.currentTimeMillis() - r5;
        if (r5 <= 0) goto L38;
        if (r6 >= this.e.enterRoomTimeout) goto L38;
        d("duration", String.valueOf(r6));
        if (r10 == 1) goto L36;
        e("start_to_total_ready_cost", r6);
    L36:
        c(com.bytedance.android.live.livepullstream.api.apm.a.b(APMEvent.Level.I, "enter_start", r5));
    L38:
        if (r10 == 1) goto L40;
        a("status_code", String.valueOf(r10));
    L48:
        if (TextUtils.isEmpty(r11) == false) goto L50;
        d("status_msg", r11);
    L50:
        d("metric", this.a.toString());
        d("category", this.c.toString());
        c(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "enter_finish", "enter_code=" + r10 + ", desc=" + r11 + ", total cost=" + r6));
        i(this.d, this.b);
        g(r4, this.b);
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L53;
        String r7 = LiveTracingMonitor.EventModule.vs.getName();
        int r8 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r9 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_vs_apm_enter", r7);
        r9.c = "webcast_client_room_apm";
        r9.h = Integer.valueOf(r10);
        r9.i = r11;
        r9.e = this.i;
        r9.f = this.k;
        r9.g = String.valueOf(k.f(IUserService.class).user().n());
        com.bytedance.android.live.core.monitor.trace.e r12 = r9.a();
        JSONObject r13 = this.c;
        JSONObject r14 = this.a;
        JSONObject r15 = this.b;
        Intrinsics.checkNotNullParameter(r12, "traceMeta");
        TraceMonitor.i(r12, r13, r14, r15);
    L54:
        ((ArrayList) this.d).clear();
        this.b = new JSONObject();
        this.c = new JSONObject();
        this.a = new JSONObject();
        this.n = System.currentTimeMillis();
        return;
    L53:
        LiveTracingMonitor.e("ttlive_vs_apm_enter", LiveTracingMonitor.EventModule.vs, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.c, this.a, this.b);
        goto L54
    L40:
        b r16 = this.f;
        if (r16.b == true) goto L44;
        a("status_code", String.valueOf(5));
        goto L48
    L44:
        if (r16.c == true) goto L46;
        a("status_code", String.valueOf(6));
        goto L48
    L46:
        a("status_code", String.valueOf(r10));
        goto L48
    L25:
        HashMap r17 = new HashMap();
        if (pm1.f.f() == null) goto L28;
        pm1.f.f().c(r3, a0.class, r17);
    L28:
        r4 = r17;
        goto L29
    L16:
        if (r2.get("data_vs_episode_data", null) == null) goto L22;
        Episode r18 = (Episode) this.m.get("data_vs_episode_data", null);
        if (r18 == null) goto L22;
        d("business_id", String.valueOf(r18.getIdExt()));
        d("episode", r18.toString());
        EpisodeMod r19 = r18.episodeMod;
        if (r19 == null) goto L22;
        a("state_type", String.valueOf(((BaseEpisodeMod) r19).episodeStage));
        a("record_type", String.valueOf(((BaseEpisodeMod) r19).episodeRecordType));
        goto L22
    L5:
        if (r0.b == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void i(List<APMEvent> r3, JSONObject r4) {
        if (r3 == null) goto L21;
        if (r4 == null) goto L22;
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L11
        Iterator r5 = ((ArrayList) r3).iterator();     // Catch: Exception -> L11
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.put(((APMEvent) r5.next()).h());     // Catch: Exception -> L11
        goto L7
    L9:
        r4.put("event_list", r0.toString());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        r4.put("event_list_error", e.getMessage());     // Catch: JSONException -> L15
        return;
    L24:
        return;
    L22:
        return;
    }

    public final void fX(long r7, String r9, boolean r10, Episode r11, ls2.e r12) {
        b r8 = this.f;
        if (r8.a == true) goto L5;
        return;
    L5:
        if (r8.d == false) goto L7;
        return;
    L7:
        if (k.f(IRoomModuleService.class) != null) goto L9;
        return;
    L9:
        if (k.f(IRoomModuleService.class).getLiveRoomMonitorHelper() == null) goto L60;
        this.f.d = true;
        this.p.removeMessages(2);
        EndReason r13 = r12.getReasonV2Ext();
        if (r13 == null) goto L14;
        a("exit_code", k.f(IRoomModuleService.class).getLiveRoomMonitorHelper().b(r13));
    L16:
        if (this.l.a().getValue() != null) goto L18;
    L20:
        boolean r14 = k.f(IRoomModuleService.class).getLiveRoomMonitorHelper().a(r13);
        if (r14 == false) goto L23;
        APMEvent.Level r15 = APMEvent.Level.I;
    L24:
        c(com.bytedance.android.live.livepullstream.api.apm.a.c(r15, "exit room", "error=" + r12 + ", exit_error_ms=" + r12.getErrMsgV2() + ", reason=" + r12.getReasonV2Ext()));
        if (r14 == true) goto L28;
        d("status_code", r12.getErrorCode() + "");
        d("status_msg", r12.getErrMsgV2() + " " + k.f(IRoomModuleService.class).getLiveRoomMonitorHelper().b(r13));
    L28:
        if (this.n <= 0) goto L32;
        long r16 = System.currentTimeMillis();
        long r0 = this.n;
        if (r16 <= r0) goto L32;
        e("watch_live_duration", r16 - r0);
        d("duration", String.valueOf(r16 - this.n));
    L32:
        LiveRoomAPMConfig r17 = this.e;
        int r18 = r17.uploadExitRoomLevel;
        if (r18 == 2) goto L37;
        if (r18 != 1) goto L58;
        if (r14 == false) goto L37;
        return;
    L58:
        return;
    L37:
        if (r17.exitUploadAll() == false) goto L39;
    L41:
        d("trace", Log.getStackTraceString(new Exception()));
    L42:
        c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "upload events by exit room=" + hashCode()));
        DataCenter r19 = this.m;
        if (r19 != null) goto L45;
        Map<String, String> r20 = Collections.emptyMap();
    L49:
        b(r20);
        g(r20, this.b);
        i(this.d, this.b);
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L52;
        String r21 = LiveTracingMonitor.EventModule.vs.getName();
        int r22 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r23 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_vs_apm_exit", r21);
        r23.c = "webcast_client_room_apm";
        r23.e = this.i;
        r23.f = this.k;
        r23.g = String.valueOf(k.f(IUserService.class).user().n());
        com.bytedance.android.live.core.monitor.trace.e r24 = r23.a();
        JSONObject r25 = this.c;
        JSONObject r26 = this.a;
        JSONObject r110 = this.b;
        Intrinsics.checkNotNullParameter(r24, "traceMeta");
        TraceMonitor.i(r24, r25, r26, r110);
    L53:
        this.b = new JSONObject();
        this.a = new JSONObject();
        ((ArrayList) this.d).clear();
        b r27 = this.f;
        r27.c = false;
        r27.b = false;
        r27.d = false;
        r27.a = false;
        r27.e = false;
        return;
    L52:
        LiveTracingMonitor.e("ttlive_vs_apm_exit", LiveTracingMonitor.EventModule.vs, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.c, this.a, this.b);
        goto L53
    L45:
        HashMap r28 = new HashMap();
        if (pm1.f.f() == null) goto L48;
        pm1.f.f().c(r19, a0.class, r28);
    L48:
        r20 = r28;
        goto L49
    L39:
        if (this.e.exitUploadOnlyAbnormal() == false) goto L42;
        if (r14 == true) goto L42;
    L23:
        r15 = APMEvent.Level.E;
        goto L24
    L18:
        if (TextUtils.isEmpty((CharSequence) ((Map) this.l.a().getValue()).get("log_id")) == true) goto L20;
        d("log_id", (String) ((Map) this.l.a().getValue()).get("log_id"));
        goto L20
    L14:
        a("exit_code", "unknown");
        goto L16
    }

    public i(Bundle r4, Fragment r5, String r6, String r7, ReplayEventHub r8, DataCenter r9, LiveRoomAPMConfig r10) {
        this.o = new a(this);
        this.p = new WeakHandler(Looper.getMainLooper(), this.o);
        this.a = new JSONObject();
        this.b = new JSONObject();
        this.c = new JSONObject();
        this.d = new ArrayList();
        this.f = new b();
        if (r4 != null) goto L5;
        r4 = Bundle.EMPTY;
    L5:
        this.g = r4;
        this.l = r8;
        this.m = r9;
        this.e = r10;
        if (r10.enableRoomAPM == false) goto L13;
        this.h = r6;
        this.j = r7;
        c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "monitor start"));
        if (r5 == null) goto L14;
        r8.e.observe(r5, new qr1.a(this));
        r8.b.observe(r5, new qr1.b(this), true);
        r8.f.observe(r5, new c(this));
        r8.x.observe(r5, new d(this));
        r8.l.observe(r5, new e(this));
        r8.y.observe(r5, new f(this));
        r8.h.observe(r5, new g(this));
        r8.m.observe(r5, new h(this));
        return;
    L14:
        return;
    }
}
