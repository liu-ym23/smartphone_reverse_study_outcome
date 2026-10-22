package com.bytedance.android.live.profile.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;
import rs0.a0;
import rs0.q0;
import ss0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileMonitor {
    public static final a g = null;
    public final Lazy a;
    public final Map<String, String> b;
    public boolean c;
    public final Map<ComponentType, Map<LifecycleType, Long>> d;
    public final Lazy e;
    public final IRoom f;

    public static final class a {
        public a() {
        }

        public static void a(Map r3) {
            q0 r0 = q0.a;
            r3.put("delay_time", String.valueOf(((d) r0.getValue()).a()));
            r3.put("sampling", String.valueOf(((d) r0.getValue()).h()));
            r3.put("predict_pre_request", m2.b(((d) r0.getValue()).f()));
            r3.put("predict_delay_time", String.valueOf(((d) r0.getValue()).e()));
        }

        @JvmStatic
        public static void c(ProfileMonitor r4, ComponentType r5, LifecycleType r6, Function0 r7) {
            Intrinsics.checkNotNullParameter(r5, "componentType");
            Intrinsics.checkNotNullParameter(r6, "lifecycleType");
            Intrinsics.checkNotNullParameter(r7, "action");
            if (r4 == null) goto L8;
            Intrinsics.checkNotNullParameter(r5, "componentType");
            Intrinsics.checkNotNullParameter(r6, "lifecycleType");
            Intrinsics.checkNotNullParameter(r7, "action");
            long r0 = System.currentTimeMillis();
            r7.invoke();
            long r2 = System.currentTimeMillis();
            Map r8 = (Map) ((LinkedHashMap) r4.d).get(r5);
            if (r8 != null) goto L7;
            r4.d.put(r5, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r6, Long.valueOf(r2 - r0))}));
            return;
        L7:
            r8.put(r6, Long.valueOf(r2 - r0));
            return;
        L8:
            Unit r9 = (Unit) r7.invoke();
        }

        public static void b(String r2, String r3, String r4, long r5, String r7) {
            Intrinsics.checkNotNullParameter(r2, "preRequestUid");
            Intrinsics.checkNotNullParameter(r3, "currentId");
            Intrinsics.checkNotNullParameter(r4, "anchorId");
            Intrinsics.checkNotNullParameter(r7, "logId");
            Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pre_uid", String.valueOf(r2)), TuplesKt.to("current_id", r3), TuplesKt.to("anchor_id", r4), TuplesKt.to("room_id", String.valueOf(r5)), TuplesKt.to("log_id", r7)});
            a(r6);
            j0.l().sendLog("livesdk_profile_pre_request_success", r6, new Object[0]);
        }
    }

    public final IRoom c() {
        return (IRoom) this.a.getValue();
    }

    static {
        g = new a();
    }

    public ProfileMonitor(IRoom r1) {
        this.f = r1;
        this.a = LazyKt.lazy(new ProfileMonitor$room$2(this));
        this.b = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(new ProfileMonitor$processedComponentCost$2(this));
    }

    public final void g(EventType r2) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        h(r2.getKey(), "placeholder");
    }

    public final void i(TimeType r3) {
        Intrinsics.checkNotNullParameter(r3, "timeType");
        String r0 = String.valueOf(System.currentTimeMillis());
        h(r3.getKey(), r0);
    }

    public static /* synthetic */ void b(ProfileMonitor r1, EndType r2) {
        r1.a(r2, "");
    }

    public final void a(EndType r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "endType");
        Intrinsics.checkNotNullParameter(r9, Constants.OperatorKey.MSG);
        if (this.c == false) goto L5;
        return;
    L5:
        DataType r0 = DataType.SelfUid;
        IMiddlewareUserService r1 = k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L11;
        e r2 = r1.user();
        if (r2 == null) goto L11;
        String r3 = r2.n();
        if (r3 == null) goto L11;
    L12:
        d(r0, r3);
        DataType r4 = DataType.RoomId;
        IRoom r5 = c();
        String r6 = null;
        if (r5 == null) goto L15;
        String r7 = r5.getIdStr();
    L16:
        d(r4, r7);
        DataType r10 = DataType.AnchorId;
        IRoom r12 = c();
        if (r12 == null) goto L19;
        String r13 = r12.getOwnerUserIdString();
    L20:
        d(r10, r13);
        d(DataType.State, Integer.valueOf(r8.getStateCode()));
        d(DataType.StateMsg, r9);
        j0.l().sendLog("livesdk_profile_monitor_info", this.b, new Object[]{IRoom.class});
        if (Random.Default.nextInt(0, 10000) > ((Integer) a0.a.getValue()).intValue()) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == false) goto L26;
    L27:
        Iterator r15 = ((Map) this.e.getValue()).entrySet().iterator();
    L29:
        if (r15.hasNext() == false) goto L31;
        Map.Entry r16 = (Map.Entry) r15.next();
        Map r17 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_component_type", r16.getKey())});
        r17.putAll((Map) r16.getValue());
        j0.l().sendLog("livesdk_profile_component_cost_monitor_info", r17, new Object[0]);
    L31:
        int r18 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r19 = com.bytedance.android.live.core.monitor.trace.e.b.a("livesdk_profile_monitor_info", "live_profile");
        r19.c = "webcast_client_community";
        IRoom r20 = c();
        if (r20 == null) goto L34;
        String r22 = r20.getIdStr();
    L35:
        r19.e = r22;
        IRoom r23 = c();
        if (r23 == null) goto L38;
        String r24 = r23.getOwnerUserIdString();
    L39:
        r19.f = r24;
        IRoom r25 = c();
        if (r25 == null) goto L42;
        String r26 = r25.getEnterLogId();
    L43:
        r19.b = r26;
        IMiddlewareUserService r27 = k.f(IMiddlewareUserService.class);
        if (r27 == null) goto L50;
        e r28 = r27.user();
        if (r28 == null) goto L50;
        String r29 = r28.n();
        if (r29 == null) goto L50;
        r6 = r29;
    L50:
        r19.g = r6;
        r19.b("target_uid", ((LinkedHashMap) this.b).get(DataType.TargetUid.getKey()));
        r19.b("source", ((LinkedHashMap) this.b).get(DataType.Source.getKey()));
        r19.b("click_user_position", ((LinkedHashMap) this.b).get(DataType.ClickUserPosition.getKey()));
        r19.b("error_code", ((LinkedHashMap) this.b).get(DataType.ErrorCode.getKey()));
        r19.b("request_log_id", ((LinkedHashMap) this.b).get(DataType.RequestLogId.getKey()));
        com.bytedance.android.live.core.monitor.trace.e r30 = r19.a();
        JSONObject r32 = new JSONObject();     // Catch: Exception -> L53
        r32.put("message", this.b.toString());     // Catch: Exception -> L53
        r32.put("component_cost", ((Map) this.e.getValue()).toString());     // Catch: Exception -> L53
        c.b(r30, r32);     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        ALogger.e("livesdk_profile_monitor_info", "reportTrace error: " + e.getMessage());
        return;
    L42:
        r26 = null;
        goto L43
    L38:
        r24 = null;
        goto L39
    L34:
        r22 = null;
        goto L35
    L26:
        if (v.a() == false) goto L31;
    L23:
        r14 = false;
        goto L24
    L19:
        r13 = null;
        goto L20
    L15:
        r7 = null;
    L11:
        r3 = DataType.FALSE;
        goto L12
    }

    public final void d(DataType r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "dataType");
        if ((r3 instanceof Boolean) == false) goto L10;
        String r4 = r2.getKey();
        DataType.a r0 = DataType.Companion;
        boolean r5 = ((Boolean) r3).booleanValue();
        r0.getClass();
        if (r5 == false) goto L7;
        String r6 = DataType.TRUE;
    L8:
        h(r4, r6);
        return;
    L7:
        r6 = DataType.FALSE;
        goto L8
    L10:
        if ((r3 instanceof Number) == false) goto L13;
        h(r2.getKey(), r3.toString());
        return;
    L13:
        if ((r3 instanceof String) == false) goto L15;
        h(r2.getKey(), (String) r3);
        return;
    L15:
        if (r3 != null) goto L17;
        h(r2.getKey(), "");
        return;
    L17:
        h(r2.getKey(), r3.toString());
    }

    public final void h(String r2, String r3) {
        this.b.put(r2, r3);
    }

    public final void f(boolean r2, boolean r3, String r4, boolean r5, String r6) {
        d(DataType.IsForceSecret, Boolean.valueOf(r2));
        d(DataType.IsIntercomHideUserCard, Boolean.valueOf(r3));
        d(DataType.ClickUserPosition, r4);
        d(DataType.IsSkipPrivacyCheck, Boolean.valueOf(r5));
        d(DataType.Source, r6);
    }

    public final void e(String r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        d(DataType.TargetUid, r2);
        d(DataType.IsAdmin, Boolean.valueOf(r3));
        d(DataType.IsToSelf, Boolean.valueOf(r4));
        d(DataType.IsToAnchor, Boolean.valueOf(r5));
        d(DataType.IsToUnionAnchor, Boolean.valueOf(r6));
        d(DataType.SelfIsAnchor, Boolean.valueOf(r7));
        DataType r8 = DataType.IsRoomHideProfile;
        IRoom r9 = c();
        if (r9 == null) goto L7;
        IRoomAuthStatus r10 = r9.getRoomAuthStatus();
        if (r10 == null) goto L7;
        Boolean r12 = Boolean.valueOf(r10.getEnableUserCard());
    L8:
        d(r8, r12);
        return;
    L7:
        r12 = null;
        goto L8
    }
}
