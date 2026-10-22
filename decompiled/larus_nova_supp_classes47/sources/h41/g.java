package h41;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final IRoom a;

    public g(IRoom r1) {
        this.a = r1;
    }

    public static void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        HashMap r0 = new HashMap();
        r0.put("request_page", r6);
        w31.c r7 = com.bytedance.android.live.revlink.impl.global.b.T();
        h0 r1 = null;
        if (r7 == null) goto L5;
        String r8 = r7.c();
    L6:
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r2 == null) goto L9;
        long r3 = r2.f();
    L10:
        r0.put("pk_description", "routine");
        r0.put("pk_activity_type", "");
        r0.put("match_type", "single");
        r0.put("anchor_connect_status", DataType.FALSE);
        r0.put("source", "restart");
        r0.put("room_status", "live");
        r0.put("is_reinvite", DataType.TRUE);
        if (com.bytedance.android.live.revlink.impl.global.b.M() == null) goto L21;
        com.bytedance.android.live.revlink.impl.pk.service.a r4 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r4 == null) goto L15;
        h0 r5 = r4.d();
    L16:
        if (r5 == null) goto L21;
        com.bytedance.android.live.revlink.impl.pk.service.a r9 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r9 == null) goto L20;
        r1 = r9.d();
    L20:
        Intrinsics.checkNotNull(r1);
        r1.a(r0);
        goto L21
    L15:
        r5 = null;
    L21:
        n r10 = new n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r12.putAll(r0);
        m r13 = new m();
        com.bytedance.android.livesdk.revenue.log.h r14 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r14, "linkInfoLog");
        r14.f(r8);
        r14.c(r3);
        ((ArrayList) r13.a).add(r14.a);
        r13.b(LogCommon.ROOM);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r16);
        ((i) ((f80.a) r16)).w3("match_cancel_click", r10.a, r10.b);
        return;
    L9:
        r3 = 0;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public static void b(String r5) {
        Intrinsics.checkNotNullParameter("window", "type");
        Intrinsics.checkNotNullParameter(r5, "choice");
        HashMap r0 = new HashMap();
        r0.put("pop_type", "window");
        r0.put("pop_choice", r5);
        q r6 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r6 != null) goto L5;
    L7:
        String r7 = DataType.FALSE;
    L8:
        r0.put("is_oncemore", r7);
        w31.c r8 = com.bytedance.android.live.revlink.impl.global.b.T();
        Integer r1 = null;
        if (r8 == null) goto L11;
        String r9 = r8.c();
    L12:
        r0.put("right_user_id", String.valueOf(r9));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r10 == null) goto L17;
        PkBaseStateMachine.c r2 = r10.getCurPKBaseState();
        r2.getClass();
        if ((r2 instanceof PkBaseStateMachine.c.d) == false) goto L17;
        String r12 = "time_out";
    L22:
        r0.put("end_type", r12);
        w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r13 == null) goto L25;
        r1 = Integer.valueOf(r13.a());
    L25:
        r0.put("pk_time", String.valueOf(r1));
        long r3 = System.currentTimeMillis();
        q r14 = com.bytedance.android.live.revlink.impl.global.b.W();
        long r4 = 0;
        if (r14 == null) goto L30;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r15 = r14.d();
        if (r15 == null) goto L30;
        r4 = r15.startTimeMs();
    L30:
        r0.put("connection_time", String.valueOf((r3 - r4) / ((long) WebcastRedirectException.UNKNOWN)));
        n r16 = new n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r17.putAll(r0);
        m r18 = new m();
        r18.b(LogCommon.PAGE_SOURCE_LOG);
        LinkCrossRoomDataHolder.a r19 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r18);
        r18.b(LogCommon.ROOM);
        ((ArrayList) r16.b).addAll(r18.a);
        cy0.e.a.getClass();
        j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r22);
        ((i) ((f80.a) r22)).w3("livesdk_pk_end_choice", r16.a, r16.b);
        return;
    L17:
        if (r10 == null) goto L21;
        PkBaseStateMachine.c r23 = r10.getCurPKBaseState();
        r23.getClass();
        if ((r23 instanceof PkBaseStateMachine.c.b) == false) goto L21;
        r12 = "disconnect";
    L21:
        r12 = "in_advance";
        goto L22
    L11:
        r9 = null;
        goto L12
    L5:
        if (r6.e() != true) goto L7;
        r7 = DataType.TRUE;
        goto L8
    }

    public static void c(String r3) {
        Intrinsics.checkNotNullParameter("pk_room", "type");
        Intrinsics.checkNotNullParameter(r3, "choice");
        HashMap r0 = new HashMap();
        r0.put("pop_type", "pk_room");
        r0.put("pop_choice", r3);
        q r4 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r4 != null) goto L5;
    L7:
        String r5 = DataType.FALSE;
    L8:
        r0.put("is_oncemore", r5);
        n r6 = new n();
        Map<String, String> r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        m r2 = new m();
        r2.b(LogCommon.PAGE_SOURCE_LOG);
        r2.b(LogCommon.ROOM);
        List<Object> r7 = r6.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r2.a);
        cy0.e.a.getClass();
        j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r10);
        ((i) ((f80.a) r10)).w3("livesdk_pk_end_choice", r6.a, r6.b);
        return;
    L5:
        if (r4.e() != true) goto L7;
        r5 = DataType.TRUE;
        goto L8
    }
}
