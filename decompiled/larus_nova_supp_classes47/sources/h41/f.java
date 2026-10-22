package h41;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final LinkCrossRoomDataHolder d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public f(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void c(int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("is_success", String.valueOf(r4));
        n r5 = new n();
        Map<String, String> r1 = r5.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        m r2 = new m();
        r2.b(LogCommon.PAGE_SOURCE_LOG);
        r2.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r3 = d();
        if (r3 == null) goto L5;
        r3.m(r2);
    L5:
        List<Object> r6 = r5.b;
        ArrayList r7 = (ArrayList) r6;
        r7.addAll(r2.a);
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((i) ((f80.a) r9)).w3("livesdk_pk_game_panel_npk_click", r5.a, r5.b);
    }

    public final void e(String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("pop_choice", "cancel");
        if (r4 == null) goto L5;
        r0.put("npk_invite_page_source", r4);
    L5:
        r0.put("battle_mode", "individual_pk");
        n r5 = new n();
        Map<String, String> r1 = r5.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        m r2 = new m();
        r2.b(LogCommon.PAGE_SOURCE_LOG);
        r2.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r3 = d();
        if (r3 == null) goto L8;
        r3.m(r2);
    L8:
        List<Object> r6 = r5.b;
        ArrayList r7 = (ArrayList) r6;
        r7.addAll(r2.a);
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((i) ((f80.a) r9)).w3("livesdk_npk_invite_page_cancel_click", r5.a, r5.b);
    }

    public final void f(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "choice");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L5;
        r0.put("npk_invite_page_source", r4);
    L5:
        r0.put("battle_mode", "individual_pk");
        r0.put("pop_choice", r3);
        n r5 = new n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        m r7 = new m();
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        r7.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r1 = d();
        if (r1 == null) goto L8;
        r1.m(r7);
    L8:
        List<Object> r2 = r5.b;
        ArrayList r8 = (ArrayList) r2;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r10);
        ((i) ((f80.a) r10)).w3("livesdk_npk_invite_page_choice", r5.a, r5.b);
    }

    public final void g(String r3, String r4, Integer r5, int r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("is_success", String.valueOf(r6));
        if (r3 == null) goto L5;
        r0.put("npk_invite_page_source", r3);
    L5:
        r0.put("battle_mode", r4);
        if (r5 == null) goto L8;
        r0.put("pk_anchor_cnt", String.valueOf(r5.intValue()));
    L8:
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r8.putAll(r0);
        m r9 = new m();
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        r9.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r10 = d();
        if (r10 == null) goto L11;
        r10.m(r9);
    L11:
        List<Object> r12 = r7.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r9.a);
        cy0.e.a.getClass();
        j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r15);
        ((i) ((f80.a) r15)).w3("livesdk_npk_invite_page_npk_start", r7.a, r7.b);
    }

    public final void h(boolean r6, int r7, int r8, PlayMode r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkCrossRoomDataHolder r1 = d();
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.c());
    L6:
        r0.put("channel_id", String.valueOf(r3));
        com.bytedance.android.live.revlink.impl.global.c r4 = this.a;
        if (r4 == null) goto L9;
        w31.c r5 = r4.getPkLinkUtils();
    L10:
        if (r5 == null) goto L12;
        Long r10 = Long.valueOf(r5.i());
    L13:
        r0.put("pk_id", String.valueOf(r10));
        if (r6 == false) goto L16;
        String r12 = DataType.TRUE;
    L17:
        r0.put("is_success", r12);
        r0.put("connection_anchor_cnt", String.valueOf(r7));
        if (r6 == false) goto L20;
        r0.put("pk_anchor_cnt", String.valueOf(r8));
    L20:
        com.bytedance.android.live.revlink.impl.global.c r13 = this.a;
        if (r13 == null) goto L23;
        r2 = r13.getLinkOptLogContext();
    L23:
        if (r2 == null) goto L26;
        String r14 = r2.a;
        if (r14 == null) goto L26;
    L27:
        r0.put("source", r14);
        r0.put("is_oncemore", DataType.FALSE);
        if (r9 != PlayMode.PERSONAL_PK) goto L30;
        String r15 = "individual_pk";
    L31:
        r0.put("battle_mode", r15);
        n r16 = new n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r17.putAll(r0);
        m r18 = new m();
        r18.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r19 = d();
        if (r19 == null) goto L34;
        r19.m(r18);
    L34:
        ((ArrayList) r16.b).addAll(r18.a);
        cy0.e.a.getClass();
        j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r22);
        ((i) ((f80.a) r22)).w3("livesdk_npk_gameplay_banner_npk_start", r16.a, r16.b);
        return;
    L30:
        r15 = "team_pk";
    L26:
        r14 = "";
        goto L27
    L16:
        r12 = DataType.FALSE;
        goto L17
    L12:
        r10 = null;
        goto L13
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void b(int r3, int r4, String r5, Integer r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r5, "battleMode");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("pk_anchor_cnt", String.valueOf(r4));
        r0.put("connection_anchor_cnt", String.valueOf(r3));
        r0.put("battle_mode", r5);
        if (r6 == null) goto L5;
        r0.put("team_pk_a_anchor_cnt", String.valueOf(r6.intValue()));
    L5:
        if (r7 == null) goto L7;
        r0.put("team_pk_b_anchor_cnt", String.valueOf(r7.intValue()));
    L7:
        n r8 = new n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r9.putAll(r0);
        m r10 = new m();
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        r10.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r12 = d();
        if (r12 == null) goto L10;
        r12.m(r10);
    L10:
        List<Object> r13 = r8.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r10.a);
        cy0.e.a.getClass();
        j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r16);
        ((i) ((f80.a) r16)).w3("livesdk_oncemore_invited_page_show", r8.a, r8.b);
    }

    public final void a(String r3, int r4, int r5, String r6, Integer r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r6, "battleMode");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("action", r3);
        r1.put("pk_anchor_cnt", String.valueOf(r5));
        r1.put("connection_anchor_cnt", String.valueOf(r4));
        r1.put("battle_mode", r6);
        if (r7 == null) goto L5;
        r1.put("team_pk_a_anchor_cnt", String.valueOf(r7.intValue()));
    L5:
        if (r8 == null) goto L7;
        r1.put("team_pk_b_anchor_cnt", String.valueOf(r8.intValue()));
    L7:
        n r9 = new n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r10.putAll(r1);
        m r12 = new m();
        r12.b(LogCommon.PAGE_SOURCE_LOG);
        r12.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r13 = d();
        if (r13 == null) goto L10;
        r13.m(r12);
    L10:
        List<Object> r14 = r9.b;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r12.a);
        cy0.e.a.getClass();
        j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r17);
        ((i) ((f80.a) r17)).w3("livesdk_oncemore_invited_page_choice", r9.a, r9.b);
    }
}
