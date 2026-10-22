package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiLinkEnterCheck {
    public static final /* synthetic */ int k = 0;
    public final CompositeDisposable a;
    public boolean b;
    public boolean c;
    public int d;
    public long e;
    public long f;
    public long g;
    public long h;
    public final com.bytedance.android.live.revlink.impl.global.c i;
    public final i11.b j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.i;
        if (r0 == null) goto L5;
        ProfitInteractionDataContext r1 = r0.vj();
    L6:
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.m<Long> r2 = r1.getLinkStartTimeStamp();
        if (r2 == null) goto L14;
        Disposable r3 = com.bytedance.android.live.core.utils.b0.a(r2, new MultiLinkEnterCheck$attach$1(this));
        if (r3 == null) goto L15;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean c() {
        if (this.h != 0) goto L5;
    L12:
        return false;
    L5:
        if (this.g == 0) goto L12;
        u41.b r0 = u41.b.i;
        r0.getClass();
        long r1 = ((Number) u41.b.d.getValue(r0, u41.b.a[2])).longValue();
        if (Math.abs(this.g - this.e) > r1) goto L10;
    L11:
        return true;
    L10:
        if (Math.abs(this.h - this.e) > r1) goto L12;
        goto L11
    }

    public final void e() {
        if (this.b == true) goto L5;
        return;
    L5:
        if (this.c == true) goto L8;
        return;
    L8:
        if (this.d > 0) goto L10;
    L12:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("error_code", String.valueOf(this.d));
        r0.put("battle_start_diff", String.valueOf(this.f - this.e));
        r0.put("near_mode_change", String.valueOf(c()));
        r0.put("server_time_diff", String.valueOf(Math.abs(com.bytedance.live.kmp.util.e.b() - this.e)));
        if (this.d <= 0) goto L22;
        u41.d r1 = u41.d.n;
        r1.getClass();
        if (((Boolean) u41.d.l.getValue(r1, u41.d.a[10])).booleanValue() == false) goto L22;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.i;
        if (r2 == null) goto L19;
        v r3 = r2.getMultiLinkMonitor();
    L20:
        if (r3 == null) goto L22;
        Intrinsics.checkNotNullParameter(r0, "map");
        JSONObject r4 = new JSONObject(r0);
        r3.c(r4);
        r3.I("multi_audience_enter_diff_check", r4, false);
        goto L22
    L19:
        r3 = null;
    L22:
        jy0.b.c("link_preload", r0.toString(), null, 4);
        return;
    L10:
        if (c() == false) goto L12;
        this.d |= 1;
        goto L12
    }

    public final void f() {
        u41.b r0 = u41.b.i;
        r0.getClass();
        if (((Boolean) u41.b.c.getValue(r0, u41.b.a[1])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.g != 0) goto L8;
        return;
    L8:
        if (this.h != 0) goto L10;
        return;
    L10:
        if (this.e != 0) goto L13;
        return;
    L13:
        if (c() == false) goto L18;
        jy0.b.c("link_preload", "start tryWRDSBackup for multi", null, 4);
        this.j.o(new MultiLinkEnterCheck$tryWRDSBackup$1(this));
        return;
    }

    public final boolean b(ExtraResponse<com.bytedance.android.livesdk.link.model.r, Extra> r9) {
        Intrinsics.checkNotNullParameter(r9, "resp");
        com.bytedance.android.livesdk.link.model.r r0 = (com.bytedance.android.livesdk.link.model.r) r9.data;
        long r1 = 0;
        if (r0 == null) goto L9;
        c3 r2 = r0.getBattleStatsMeta();
        if (r2 == null) goto L9;
        c1 r3 = r2.getBattleSetting();
        if (r3 == null) goto L9;
        long r4 = r3.getBattleId();
    L10:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.i;
        Integer r6 = null;
        if (r5 == null) goto L13;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = r5.Ig();
    L14:
        if (r7 != null) goto L16;
    L17:
        this.d |= 2;
    L18:
        com.bytedance.android.livesdk.link.model.r r8 = (com.bytedance.android.livesdk.link.model.r) r9.data;
        if (r8 == null) goto L25;
        c3 r10 = r8.getBattleStatsMeta();
        if (r10 == null) goto L25;
        c1 r12 = r10.getBattleSetting();
        if (r12 == null) goto L25;
        long r13 = r12.getFinished();
    L27:
        if (r13 <= 0) goto L29;
        boolean r14 = true;
    L30:
        com.bytedance.android.live.revlink.impl.global.c r15 = this.i;
        if (r15 == null) goto L33;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r16 = r15.Ig();
    L34:
        if (r16 == null) goto L40;
        PkBaseStateMachine.c r17 = r16.getCurPKBaseState();
        if (r17 == null) goto L40;
        if ((r17 instanceof PkBaseStateMachine.c.d) != true) goto L40;
        boolean r18 = true;
    L41:
        if (r14 == r18) goto L43;
        this.d |= 4;
    L43:
        com.bytedance.android.livesdk.link.model.r r19 = (com.bytedance.android.livesdk.link.model.r) r9.data;
        if (r19 == null) goto L48;
        List r20 = r19.getLinkUsers();
        if (r20 == null) goto L48;
        r6 = Integer.valueOf(r20.size());
    L48:
        int r22 = this.j.c();
        if (r6 != null) goto L52;
    L53:
        this.d |= 8;
    L54:
        this.c = true;
        com.bytedance.android.livesdk.link.model.r r23 = (com.bytedance.android.livesdk.link.model.r) r9.data;
        if (r23 == null) goto L61;
        c3 r24 = r23.getBattleStatsMeta();
        if (r24 == null) goto L61;
        c1 r25 = r24.getBattleSetting();
        if (r25 == null) goto L61;
        r1 = r25.getStartTimeMs();
    L61:
        this.f = r1;
        e();
        if (this.d == 0) goto L65;
        return true;
    L65:
        return false;
    L52:
        if (r6.intValue() == r22) goto L54;
    L40:
        r18 = false;
        goto L41
    L33:
        r16 = null;
        goto L34
    L29:
        r14 = false;
    L25:
        r13 = 0;
        goto L27
    L16:
        if (r4 == r7.getPkId()) goto L18;
    L13:
        r7 = null;
    L9:
        r4 = 0;
        goto L10
    }

    public final void d(long r3) {
        this.g = r3;
        this.h = com.bytedance.live.kmp.util.e.b();
        u41.b r4 = u41.b.i;
        r4.getClass();
        if (((Boolean) u41.b.f.getValue(r4, u41.b.a[4])).booleanValue() == false) goto L6;
        jy0.b.c("link_preload", "start tryGeneralBackUp for multi", null, 4);
        this.j.o(new MultiLinkEnterCheck$tryGeneralBackUp$1(this));
    L6:
        f();
    }

    public MultiLinkEnterCheck(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, AnchorLinkUserCenterV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "userCenter");
        this.i = r2;
        this.j = r3;
        this.a = new CompositeDisposable();
    }
}
