package com.bytedance.android.live.revlink.impl.multianchor.pk.logger;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final a a;
    public boolean b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public final Map<String, String> a() {
        Map<String, String> r0 = this.a.a();
        r0.put("battle_mode", "individual_pk");
        return r0;
    }

    public b(com.bytedance.android.livesdk.revenue.service.room.c r2, d r3) {
        this.c = r2;
        this.d = r3;
        this.a = new a(r2, r3);
    }

    public final void b(boolean r4, Function1<? super n, Unit> r5) {
        if (r4 == true) goto L4;
        return;
    L4:
        if (this.b == true) goto L18;
        this.b = true;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(this.a.c());
        r6.putAll(a());
        n r0 = new n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r1.putAll(r6);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        com.bytedance.android.live.revlink.impl.global.c r2 = this.d;
        if (r2 == null) goto L9;
        LinkCrossRoomDataHolder r3 = r2.getLinkCrossRoomDataHolder();
    L10:
        if (r3 == null) goto L12;
        r3.m(r7);
    L12:
        List<Object> r8 = r0.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        if (r5 == null) goto L15;
        Unit r10 = (Unit) r5.invoke(r0);
    L15:
        e.a.getClass();
        j r12 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r13);
        ((i) ((f80.a) r13)).w3("livesdk_pk_end", r0.a, r0.b);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void c(boolean r6, Function1<? super n, Unit> r7) {
        if (r6 == true) goto L4;
        return;
    L4:
        LinkedHashMap r8 = new LinkedHashMap();
        r8.putAll(a());
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 == null) goto L15;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.Ig();
        if (r1 == null) goto L15;
        IBattleConfigSetting r2 = r1.getConfigSetting();
        if (r2 == null) goto L15;
        m3 r3 = r2.getBreakthroughConfig();
        if (r3 == null) goto L15;
        List r4 = r3.getStages();
        if (r4 == null) goto L15;
        int r5 = r4.size();
    L16:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r9 = null;
        if (r5 <= 0) goto L35;
        com.bytedance.android.live.revlink.impl.global.c r10 = this.d;
        if (r10 == null) goto L21;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r12 = r10.Ig();
    L22:
        if (r12 == null) goto L33;
        IBattleConfigSetting r13 = r12.getConfigSetting();
        if (r13 == null) goto L33;
        m3 r14 = r13.getBreakthroughConfig();
        if (r14 == null) goto L33;
        List r15 = r14.getStages();
        if (r15 == null) goto L33;
        m3.b r16 = (m3.b) ListProtector.get(r15, r5 - 1);
        if (r16 == null) goto L33;
        String r17 = String.valueOf(r16.getTargetScore());
        if (r17 == null) goto L33;
    L34:
        r8.put("pve_target_value", r17);
    L33:
        r17 = DataType.FALSE;
        goto L34
    L21:
        r12 = null;
    L35:
        com.bytedance.android.live.revlink.impl.global.c r18 = this.d;
        if (r18 == null) goto L38;
        r9 = r18.Q1();
    L38:
        if (r9 != null) goto L40;
    L44:
        n r19 = new n();
        Map<String, String> r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r20.putAll(r8);
        m r22 = new m();
        r22.b(LogCommon.ROOM);
        ((ArrayList) r19.b).addAll(r22.a);
        if (r7 == null) goto L47;
        Unit r23 = (Unit) r7.invoke(r19);
    L47:
        e.a.getClass();
        j r24 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r25);
        ((i) ((f80.a) r25)).w3("livesdk_pk_start", r19.a, r19.b);
        return;
    L40:
        if (r9.isPkLauncher() == false) goto L42;
        String r26 = "inviter";
    L43:
        r8.put("anchor_type", r26);
        r9.setPkLauncher(false);
        goto L44
    L42:
        r26 = "invitee";
    L15:
        r5 = 0;
        goto L16
    }
}
