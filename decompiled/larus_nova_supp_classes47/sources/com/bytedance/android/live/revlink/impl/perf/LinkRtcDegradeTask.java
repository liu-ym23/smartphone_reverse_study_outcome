package com.bytedance.android.live.revlink.impl.perf;

import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.api.service.IDegradeTask;
import com.bytedance.android.live.revlink.impl.utils.y;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import cy0.j;
import fr2.j1;
import fr2.w1;
import fr2.y1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkRtcDegradeTask extends com.bytedance.android.live.revenuelink.rtc.e implements IDegradeTask {
    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public final Lazy e;
    public final ld.a f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;
    public final com.bytedance.android.live.revlink.impl.global.c h;
    public final x11.a i;

    @Override // com.bytedance.android.live.revlink.api.service.IDegradeTask
    public final void onRecover() {
    }

    public final com.bytedance.android.live.revenuelink.rtc.f j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m0();
    }

    @Override // com.bytedance.android.live.revlink.api.service.IDegradeTask
    public final void onDegrade() {
        vc0.a r1 = null;
        if (this.a == true) goto L11;
        com.bytedance.android.live.revenuelink.rtc.f r0 = j();
        if (r0 == null) goto L8;
        i r2 = r0.getRtcManager();
    L9:
        if (r2 == null) goto L11;
        this.a = true;
        r2.g1(this);
        goto L11
    L8:
        r2 = null;
    L11:
        r11.e r3 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b();
        Intrinsics.checkNotNullParameter(r3, "$this$isMixDegradeEnable");
        Intrinsics.checkNotNullParameter(r3, "$this$isDegradeEnable");
        boolean r4 = false;
        if (r3.getEnable() == true) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == true) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L31;
        com.bytedance.android.live.revenuelink.rtc.f r7 = j();
        if (r7 == null) goto L28;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L28;
        boolean r9 = r8.F();
    L29:
        if (r9 == false) goto L31;
        r4 = true;
    L28:
        r9 = false;
    L31:
        if (r4 == false) goto L53;
        com.bytedance.android.live.revenuelink.rtc.f r10 = j();
        if (r10 == null) goto L36;
        i r12 = r10.getRtcManager();
    L37:
        if (r12 == null) goto L53;
        IConfig.c.d1.getClass();
        IConfig.c r13 = IConfig.c.a.a;
        if (r13 == null) goto L41;
        r1 = vc0.b.a(r13);
    L41:
        r12.j1(r1);
        cy0.e.a.getClass();
        j r14 = cy0.e.a.a;
        m.e.getClass();
        Object r15 = m.b(r14).b(er2.b.class);
        Intrinsics.checkNotNull(r15);
        iq2.b r16 = ((com.bytedance.live.kmp.core.c) r15).getChorusService();
        if (r16 == null) goto L53;
        if (r16.e() != true) goto L53;
        x11.a r17 = this.i;
        if (r17 == null) goto L51;
        y11.f r18 = r17.G9();
        if (r18 == null) goto L51;
        String r19 = String.valueOf(r18.a());
        if (r19 == null) goto L51;
    L52:
        r16.b(r19);
    L51:
        r19 = "";
        goto L52
    L36:
        r12 = null;
    L53:
        q();
        k(true);
        n(true);
        return;
    L19:
        if (r3.a6() == false) goto L21;
        r6 = true;
        goto L22
    L14:
        if (r3.V6() == false) goto L16;
        r5 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.revlink.api.service.IDegradeTask
    public final void onClear() {
        com.bytedance.android.live.revenuelink.rtc.f r0 = j();
        if (r0 == null) goto L7;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        r1.i1(this);
    L7:
        this.a = false;
    }

    public final void q() {
        com.bytedance.android.live.revenuelink.rtc.f r0 = j();
        if (r0 == null) goto L25;
        i r1 = r0.getRtcManager();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isEngineOn() == false) goto L27;
        r1.M1();
        r1.O1();
        String r2 = r1.getRtcExtInfo();
        boolean r3 = false;
        if (r2.length() <= 0) goto L11;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L17;
        ((y) this.e.getValue()).getClass();
        String r5 = y.e(r2);
        if ((!Intrinsics.areEqual(r5, r2)) == false) goto L17;
        r1.Q(r5, "degrade");
    L17:
        String r6 = r1.getLiveCoreExtInfo();
        if (r6.length() <= 0) goto L20;
        r3 = true;
    L20:
        if (r3 == false) goto L28;
        String r7 = ((y) this.e.getValue()).d(r6);
        if ((!Intrinsics.areEqual(r7, r6)) == false) goto L29;
        r1.T(r7, "degrade");
        return;
    L29:
        return;
    L28:
        return;
    L11:
        r4 = false;
        goto L13
    L27:
        return;
    }

    public final void k(boolean r5) {
        if (com.bytedance.android.live.revlink.impl.settings.live.b.p.b().L0() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.g;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L12;
        if (r1.getCommonIsAnchor() == true) goto L12;
        return;
    L12:
        ld.a r2 = this.f;
        if (r2 == null) goto L17;
        NextLiveData r3 = r2.Un();
        if (r3 == null) goto L17;
        Boolean r4 = (Boolean) r3.getValue();
    L19:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L22;
        return;
    L22:
        if (r5 == true) goto L24;
    L48:
        if (r5 == false) goto L50;
        return;
    L50:
        if (this.b == false) goto L77;
        JSONObject r6 = new JSONObject();
        r6.put("face_extra_model_name", "");
        r6.put("matting_model_name", "");
        String r7 = r6.toString();
        com.bytedance.android.livesdk.revenue.service.room.c r8 = this.g;
        if (r8 == null) goto L60;
        com.bytedance.android.livesdk.revenue.room.a r9 = r8.getRoomContext();
        if (r9 == null) goto L60;
        com.bytedance.android.livesdk.revenue.pushstream.a r10 = r9.getCommonLiveStream();
        if (r10 == null) goto L60;
        j1 r12 = r10.j();
        if (r12 == null) goto L60;
        r12.j0();
    L60:
        com.bytedance.android.livesdk.revenue.service.room.c r13 = this.g;
        if (r13 == null) goto L73;
        com.bytedance.android.livesdk.revenue.room.a r14 = r13.getRoomContext();
        if (r14 == null) goto L73;
        com.bytedance.android.livesdk.revenue.pushstream.a r15 = r14.getCommonLiveStream();
        if (r15 == null) goto L73;
        j1 r16 = r15.j();
        if (r16 == null) goto L73;
        w1 r17 = r16.E();
        if (r17 == null) goto L73;
        y1 r18 = r17.j0();
        if (r18 == null) goto L73;
        r18.e0("GradedOptConfig", r7);
    L73:
        this.b = false;
        return;
    L77:
        return;
    L24:
        if (this.b == true) goto L48;
        JSONObject r19 = new JSONObject();
        r19.put("face_extra_model_name", "tt_face_extra_multiguest");
        r19.put("matting_model_name", "tt_matting_multiguest");
        String r20 = r19.toString();
        com.bytedance.android.livesdk.revenue.service.room.c r22 = this.g;
        if (r22 == null) goto L34;
        com.bytedance.android.livesdk.revenue.room.a r23 = r22.getRoomContext();
        if (r23 == null) goto L34;
        com.bytedance.android.livesdk.revenue.pushstream.a r24 = r23.getCommonLiveStream();
        if (r24 == null) goto L34;
        j1 r25 = r24.j();
        if (r25 == null) goto L34;
        r25.j0();
    L34:
        com.bytedance.android.livesdk.revenue.service.room.c r26 = this.g;
        if (r26 == null) goto L47;
        com.bytedance.android.livesdk.revenue.room.a r27 = r26.getRoomContext();
        if (r27 == null) goto L47;
        com.bytedance.android.livesdk.revenue.pushstream.a r28 = r27.getCommonLiveStream();
        if (r28 == null) goto L47;
        j1 r29 = r28.j();
        if (r29 == null) goto L47;
        w1 r30 = r29.E();
        if (r30 == null) goto L47;
        y1 r32 = r30.j0();
        if (r32 == null) goto L47;
        r32.e0("GradedOptConfig", r20);
    L47:
        this.b = true;
        return;
    L17:
        r4 = null;
        goto L19
    }

    public final void n(boolean r5) {
        if (com.bytedance.android.live.revlink.impl.settings.live.b.p.b().J7() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.g;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L12;
        if (r1.getCommonIsAnchor() == true) goto L12;
        return;
    L12:
        ld.a r2 = this.f;
        if (r2 == null) goto L17;
        NextLiveData r3 = r2.Un();
        if (r3 == null) goto L17;
        Boolean r4 = (Boolean) r3.getValue();
    L19:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L22;
        return;
    L22:
        if (r5 == true) goto L24;
    L26:
        if (r5 == false) goto L28;
        return;
    L28:
        if (this.c == false) goto L33;
        cy0.e.a.getClass();
        j r6 = cy0.e.a.a;
        m.e.getClass();
        Object r7 = m.b(r6).b(wh6.a.class);
        Intrinsics.checkNotNull(r7);
        ((com.bytedance.live.kmp.core.c) r7).broadcastPerfDowngrade(true);
        this.c = false;
        return;
    L33:
        return;
    L24:
        if (this.c == true) goto L26;
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).b(wh6.a.class);
        Intrinsics.checkNotNull(r9);
        ((com.bytedance.live.kmp.core.c) r9).broadcastPerfDowngrade(false);
        this.c = true;
        return;
    L17:
        r4 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.revlink.api.service.IDegradeTask
    public final void onSceneEnter(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (Intrinsics.areEqual(this.d, r6) == false) goto L5;
        return;
    L5:
        int r0 = r6.hashCode();
        if (r0 != (-1942410259)) goto L8;
        r6.equals("multi_linker");
    L28:
        this.d = r6;
        return;
    L8:
        if (r0 != 3579) goto L10;
        r6.equals("pk");
        goto L28
    L10:
        if (r0 == 3165170) goto L24;
        if (r0 != 1544803905) goto L28;
        if (r6.equals("default") == false) goto L28;
        if (Intrinsics.areEqual(this.d, "game") == false) goto L19;
    L22:
        k(false);
        n(false);
        goto L28
    L19:
        if (Intrinsics.areEqual(this.d, "pk") == true) goto L22;
        if (Intrinsics.areEqual(this.d, "multi_linker") == false) goto L28;
    L24:
        if (r6.equals("game") == false) goto L28;
        q();
        k(true);
        n(true);
        goto L28
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r2, "interactId");
        if (f.a() == false) goto L10;
        com.bytedance.android.live.revenuelink.rtc.f r0 = j();
        if (r0 == null) goto L11;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L12;
        r1.Z0(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public LinkRtcDegradeTask(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, com.bytedance.android.live.revlink.impl.global.c r3, x11.a r4) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.d = "";
        this.e = LazyKt.lazy(new LinkRtcDegradeTask$adjuster$2(this));
        if (this.a == true) goto L13;
        com.bytedance.android.live.revenuelink.rtc.f r5 = j();
        if (r5 == null) goto L8;
        i r6 = r5.getRtcManager();
    L9:
        if (r6 == null) goto L12;
        this.a = true;
        r6.g1(this);
        return;
    L12:
        return;
    L8:
        r6 = null;
        goto L9
    }
}
