package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.o;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.p;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends b {
    public final j1 A;
    public final BehaviorSubject<Map<String, Boolean>> r;
    public final BehaviorSubject<Map<String, Boolean>> s;
    public final BehaviorSubject<Map<String, Long>> t;
    public final BehaviorSubject<Map<String, Boolean>> u;
    public final BehaviorSubject<IRoomLinkMicSyncData> v;
    public o w;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.c x;
    public eg6.b y;
    public final DataCenter z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void K0(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void O1() {
        if (this.a == false) goto L6;
        ALogger.i("LinkUserDataMergeCenterV2", "LinkUserDataMergeCenterV2=" + hashCode() + ", isInitDefaultHandler=" + this.a);
        return;
    L6:
        this.a = true;
        p r2 = new p(this.y, this.p, this.z);
        this.n = r2;
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r3 = this.m;
        Intrinsics.checkNotNullParameter(this, "proxy");
        r2.a = this;
        r3.add(r2);
        d r4 = this.p;
        if (r4 != null) goto L9;
    L121:
        this.l.addAllAbsent(this.m);
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r1 = this.l;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.a r5 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.a(this.m, this.p, this.z);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r5.a = this;
        r1.add(r5);
        Iterator<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r6 = this.l.iterator();
    L123:
        if (r6.hasNext() == false) goto L127;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h r7 = r6.next();
        r7.attach();
        d r8 = this.p;
        if (r8 == null) goto L123;
        d.a.a(r8, "hjl-test", hashCode(), "initDefaultHandler, handler=" + r7, true, 16);
        goto L123
    L127:
        return;
    L9:
        if (r4.getShowFrom() != 0) goto L121;
        o r9 = this.w;
        if (r9 == null) goto L19;
        eg6.b r10 = this.y;
        eg6.b r11 = r9.l;
        if (r11 == null) goto L15;
        r11.s(r9.k);
    L15:
        r9.l = r10;
        if (r9.j == false) goto L20;
        if (r10 == null) goto L20;
        r10.h0(r9.k);
    L20:
        com.bytedance.android.live.liveinteract.plantform.datamerge.c r12 = this.x;
        String r13 = null;
        if (r12 != null) goto L23;
    L47:
        DataCenter r14 = this.z;
        if (r14 == null) goto L50;
        String r15 = (String) r14.get("data_room_unique_id", "");
    L51:
        l6 r16 = tc0.c.i(r15).O;
        if (r16 == null) goto L114;
        List r17 = r16.getMLinkUsers();
        if (r17 == null) goto L114;
        IMiddlewareUserService r18 = jc1.k.f(IMiddlewareUserService.class);
        if (r18 == null) goto L60;
        com.bytedance.android.livesdk.user.e r19 = r18.user();
        if (r19 == null) goto L60;
        String r20 = r19.n();
    L61:
        o r21 = this.w;
        if (r21 == null) goto L66;
        List<ch0.h> r22 = r21.b;
        if (r22 == null) goto L66;
        ((CopyOnWriteArrayList) r22).clear();
    L66:
        Iterator r23 = r17.iterator();
    L68:
        if (r23.hasNext() == false) goto L114;
        com.bytedance.android.livesdk.link.model.bridge.k r24 = (com.bytedance.android.livesdk.link.model.bridge.k) r23.next();
        if (r24.getLinkType() != 1) goto L72;
    L74:
        boolean r110 = false;
    L76:
        if (r24.getSilenceStatus() == 0) goto L78;
        boolean r111 = true;
    L79:
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L82;
        String r26 = r25.getIdString();
    L84:
        if (Intrinsics.areEqual(r26, r20) == true) goto L86;
    L105:
        String r27 = r24.getLinkMicIdStr();
        if (r27 != null) goto L108;
        String r112 = "";
    L109:
        ch0.h r28 = new ch0.h(r112, r110, r111, 0, 96);
        o r29 = this.w;
        if (r29 == null) goto L68;
        List<ch0.h> r30 = r29.b;
        if (r30 == null) goto L68;
        ((CopyOnWriteArrayList) r30).add(r28);
        goto L68
    L108:
        r112 = r27;
        goto L109
    L86:
        if (r110 == false) goto L88;
        int r113 = 4;
    L89:
        if (r111 == false) goto L91;
        int r114 = 3;
    L92:
        if (r110 == false) goto L94;
        int r210 = 2;
    L95:
        if (r111 == false) goto L97;
        int r211 = 2;
    L98:
        String r115 = r24.getLinkMicIdStr();
        if (r115 != null) goto L101;
        String r116 = "";
    L102:
        ch0.g r31 = new ch0.g(r116, r113, r114, r210, r211);
        o r117 = this.w;
        if (r117 == null) goto L105;
        r117.c = r31;
        goto L105
    L101:
        r116 = r115;
        goto L102
    L97:
        r211 = 1;
        goto L98
    L94:
        r210 = 1;
        goto L95
    L91:
        r114 = 2;
        goto L92
    L88:
        r113 = 2;
        goto L89
    L82:
        r26 = null;
        goto L84
    L78:
        r111 = false;
        goto L79
    L72:
        if (r24.getLinkType() == 3) goto L74;
        r110 = true;
    L60:
        r20 = null;
    L114:
        DataCenter r32 = this.z;
        if (r32 == null) goto L117;
        r13 = (String) r32.get("data_room_unique_id", "");
    L117:
        l6 r33 = tc0.c.i(r13).O;
        if (r33 == null) goto L120;
        i1(r33);
    L120:
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r34 = this.m;
        o r35 = this.w;
        Intrinsics.checkNotNull(r35);
        r35.getClass();
        Intrinsics.checkNotNullParameter(this, "proxy");
        r35.a = this;
        r34.add(r35);
        goto L121
    L50:
        r15 = null;
        goto L51
    L23:
        if (r12.c() != true) goto L47;
        List<ch0.h> r36 = this.x.a();
        o r37 = this.w;
        if (r37 == null) goto L29;
        List<ch0.h> r38 = r37.b;
        if (r38 == null) goto L29;
        ((CopyOnWriteArrayList) r38).clear();
    L29:
        o r39 = this.w;
        if (r39 == null) goto L36;
        ch0.g r40 = this.x.d();
        if (r40 == null) goto L34;
        ch0.g r41 = ch0.g.a(r40);
    L35:
        r39.c = r41;
        goto L36
    L34:
        r41 = null;
    L36:
        Iterator<T> r42 = r36.iterator();
    L38:
        if (r42.hasNext() == false) goto L46;
        ch0.h r43 = (ch0.h) r42.next();
        if (r43 == null) goto L38;
        o r44 = this.w;
        if (r44 == null) goto L38;
        List<ch0.h> r45 = r44.b;
        if (r45 == null) goto L38;
        ((CopyOnWriteArrayList) r45).add(ch0.h.a(r43, null, false, false, false, 0, 127));
        goto L38
    L46:
        this.x.b();
        goto L47
    L19:
        this.w = new o(this.y, this.p);
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final SurfaceView R0() {
        o r0 = this.w;
        String r1 = "";
        Object r2 = null;
        if (r0 == null) goto L19;
        List<ch0.h> r3 = r0.b;
        if (r3 == null) goto L19;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        String r6 = ((ch0.h) r5).a;
        String r7 = tc0.c.h().f();
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        if (Intrinsics.areEqual(r6, r7) == false) goto L8;
    L16:
        ch0.h r8 = (ch0.h) r5;
        if (r8 == null) goto L19;
        View r9 = r8.b;
    L21:
        if ((r9 instanceof SurfaceView) == true) goto L23;
        r9 = null;
    L23:
        SurfaceView r10 = (SurfaceView) r9;
        if (r10 != null) goto L50;
        j1 r11 = this.A;
        if (r11 == null) goto L40;
        cg6.a r12 = r11.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r12 == null) goto L40;
        vb6.g r13 = r12.O5();
        if (r13 == null) goto L40;
        yb6.e r14 = r13.j();
        if (r14 == null) goto L40;
        String r15 = tc0.c.h().f();
        if (r15 == null) goto L37;
        r1 = r15;
    L37:
        yb6.j r16 = r14.U(r1);
        if (r16 == null) goto L40;
        Object r17 = r16.a;
    L42:
        if ((r17 instanceof SurfaceView) == false) goto L46;
        r2 = r17;
    L46:
        return (SurfaceView) r2;
    L40:
        r17 = null;
        goto L42
    L50:
        return r10;
    L15:
        r5 = null;
    L19:
        r9 = null;
        goto L21
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b
    public final void r() {
        super.r();
        this.r.onNext(MapsKt.emptyMap());
        this.s.onNext(MapsKt.emptyMap());
        this.t.onNext(MapsKt.emptyMap());
        this.u.onNext(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Boolean>> Q0() {
        return this.s;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Boolean>> S0() {
        return this.r;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Boolean>> j1() {
        return this.u;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Long>> m1() {
        return this.t;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void J0(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcTalkingData");
        this.s.onNext(r2);
        this.u.onNext(r2);
        Objects.toString(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void N1(hg6.g r4) {
        this.y = r4;
        o r0 = this.w;
        if (r0 == null) goto L11;
        eg6.b r1 = r0.l;
        if (r1 == null) goto L7;
        r1.s(r0.k);
    L7:
        r0.l = r4;
        if (r0.j == false) goto L11;
        if (r4 == null) goto L11;
        r4.h0(r0.k);
    L11:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b r2 = this.n;
        if (r2 == null) goto L15;
        r2.e(r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void U0(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcLastTalkingTimeData");
        this.t.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void h1(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "seiTalkingData");
        this.r.onNext(r2);
        this.u.onNext(r2);
        Objects.toString(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void i1(l6 r20) {
        Intrinsics.checkNotNullParameter(r20, "resumeAudienceContent");
        List r1 = r20.getMLinkUsers();
        if (r1 == null) goto L63;
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L9;
        String r4 = r3.n();
    L10:
        o r5 = this.w;
        if (r5 == null) goto L15;
        List<ch0.h> r6 = r5.b;
        if (r6 == null) goto L15;
        ((CopyOnWriteArrayList) r6).clear();
    L15:
        Iterator r7 = r1.iterator();
    L17:
        if (r7.hasNext() == false) goto L71;
        com.bytedance.android.livesdk.link.model.bridge.k r8 = (com.bytedance.android.livesdk.link.model.bridge.k) r7.next();
        if (r8.getLinkType() != 1) goto L21;
    L23:
        boolean r11 = false;
    L25:
        if (r8.getSilenceStatus() == 0) goto L27;
        boolean r12 = true;
    L28:
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L31;
        String r10 = r9.getIdString();
    L33:
        if (Intrinsics.areEqual(r10, r4) == true) goto L35;
    L54:
        String r13 = r8.getLinkMicIdStr();
        if (r13 != null) goto L57;
        String r14 = "";
    L58:
        ch0.h r15 = new ch0.h(r14, r11, r12, 0, 96);
        o r16 = this.w;
        if (r16 == null) goto L17;
        List<ch0.h> r17 = r16.b;
        if (r17 == null) goto L17;
        ((CopyOnWriteArrayList) r17).add(r15);
        goto L17
    L57:
        r14 = r13;
        goto L58
    L35:
        if (r11 == false) goto L37;
        int r18 = 4;
    L38:
        if (r12 == false) goto L40;
        int r19 = 3;
    L41:
        if (r11 == false) goto L43;
        int r110 = 2;
    L44:
        if (r12 == false) goto L46;
        int r111 = 2;
    L47:
        String r21 = r8.getLinkMicIdStr();
        if (r21 != null) goto L50;
        String r112 = "";
    L51:
        ch0.g r22 = new ch0.g(r112, r18, r19, r110, r111);
        o r23 = this.w;
        if (r23 == null) goto L54;
        r23.c = r22;
        goto L54
    L50:
        r112 = r21;
        goto L51
    L46:
        r111 = 1;
        goto L47
    L43:
        r110 = 1;
        goto L44
    L40:
        r19 = 2;
        goto L41
    L37:
        r18 = 2;
        goto L38
    L31:
        r10 = null;
        goto L33
    L27:
        r12 = false;
        goto L28
    L21:
        if (r8.getLinkType() == 3) goto L23;
        r11 = true;
        goto L25
    L71:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public h(LifecycleOwner r1, d r2, we0.a r3, eg6.b r4, int r5, DataCenter r6, j1 r7) {
        super(r1, r2, r5);
        this.x = r3;
        this.y = r4;
        this.z = r6;
        this.A = r7;
        this.r = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.s = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.t = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.u = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.v = BehaviorSubject.create();
    }
}
