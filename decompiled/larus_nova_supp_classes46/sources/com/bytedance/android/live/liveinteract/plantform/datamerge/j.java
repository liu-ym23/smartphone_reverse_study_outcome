package com.bytedance.android.live.liveinteract.plantform.datamerge;

import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.o;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.v;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.w;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.x;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.y;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSDataContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends com.bytedance.android.live.liveinteract.plantform.datamergev2.b {
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> A;
    public final c B;
    public eg6.b C;
    public final j1 D;
    public final DataCenter E;
    public final boolean F;
    public final BehaviorSubject<Boolean> r;
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> s;
    public final BehaviorSubject<ch0.k> t;
    public final BehaviorSubject<Boolean> u;
    public final BehaviorSubject<Boolean> v;
    public final BehaviorSubject<ch0.l> w;
    public final BehaviorSubject<ch0.i> x;
    public final BehaviorSubject<wg0.a> y;
    public v z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void O1() {
        if (this.a == false) goto L6;
        ALogger.i("LinkDataMerge", "LinkUserDataMergeCenter=" + hashCode() + ", isInitDefaultHandler=" + this.a);
        return;
    L6:
        this.a = true;
        if (((MultiLinkFrequencyOptConfig) v2.a.getValue()).getEnableSeiHandlerSampling() == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b r2 = new y(this.C, this.E);
    L10:
        this.n = r2;
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r3 = this.m;
        Intrinsics.checkNotNullParameter(this, "proxy");
        r2.a = this;
        r3.add(r2);
        v r4 = this.z;
        if (r4 == null) goto L19;
        eg6.b r5 = this.C;
        eg6.b r6 = r4.j;
        if (r6 == null) goto L15;
        r6.s(r4.i);
    L15:
        r4.j = r5;
        if (r4.h == false) goto L20;
        if (r5 == null) goto L20;
        r5.h0(r4.i);
    L20:
        String r7 = null;
        if (this.B.c() == false) goto L45;
        List<ch0.h> r8 = this.B.a();
        v r9 = this.z;
        if (r9 == null) goto L27;
        List<ch0.h> r10 = r9.b;
        if (r10 == null) goto L27;
        ((CopyOnWriteArrayList) r10).clear();
    L27:
        v r11 = this.z;
        if (r11 == null) goto L34;
        ch0.g r12 = this.B.d();
        if (r12 == null) goto L32;
        ch0.g r13 = ch0.g.a(r12);
    L33:
        r11.c = r13;
        goto L34
    L32:
        r13 = null;
    L34:
        Iterator<T> r14 = r8.iterator();
    L36:
        if (r14.hasNext() == false) goto L44;
        ch0.h r15 = (ch0.h) r14.next();
        if (r15 == null) goto L36;
        v r16 = this.z;
        if (r16 == null) goto L36;
        List<ch0.h> r17 = r16.b;
        if (r17 == null) goto L36;
        ((CopyOnWriteArrayList) r17).add(ch0.h.a(r15, null, false, false, false, 0, 127));
        goto L36
    L44:
        this.B.b();
    L45:
        DataCenter r18 = this.E;
        if (r18 == null) goto L48;
        String r19 = (String) r18.get("data_room_unique_id", "");
    L49:
        l6 r20 = tc0.c.i(r19).O;
        if (r20 == null) goto L112;
        List r21 = r20.getMLinkUsers();
        if (r21 == null) goto L112;
        IMiddlewareUserService r22 = jc1.k.f(IMiddlewareUserService.class);
        if (r22 == null) goto L58;
        com.bytedance.android.livesdk.user.e r23 = r22.user();
        if (r23 == null) goto L58;
        String r24 = r23.n();
    L59:
        v r25 = this.z;
        if (r25 == null) goto L64;
        List<ch0.h> r26 = r25.b;
        if (r26 == null) goto L64;
        ((CopyOnWriteArrayList) r26).clear();
    L64:
        Iterator r27 = r21.iterator();
    L66:
        if (r27.hasNext() == false) goto L112;
        com.bytedance.android.livesdk.link.model.bridge.k r28 = (com.bytedance.android.livesdk.link.model.bridge.k) r27.next();
        if (r28.getLinkType() != 1) goto L70;
    L72:
        boolean r110 = false;
    L74:
        if (r28.getSilenceStatus() == 0) goto L76;
        boolean r111 = true;
    L77:
        IBaseUser r29 = r28.getUser();
        if (r29 == null) goto L80;
        String r30 = r29.getIdString();
    L82:
        if (Intrinsics.areEqual(r30, r24) == true) goto L84;
    L103:
        String r31 = r28.getLinkMicIdStr();
        if (r31 != null) goto L106;
        String r112 = "";
    L107:
        ch0.h r32 = new ch0.h(r112, r110, r111, 1, 32);
        v r33 = this.z;
        if (r33 == null) goto L66;
        List<ch0.h> r34 = r33.b;
        if (r34 == null) goto L66;
        ((CopyOnWriteArrayList) r34).add(r32);
        goto L66
    L106:
        r112 = r31;
        goto L107
    L84:
        if (r110 == false) goto L86;
        int r113 = 4;
    L87:
        if (r111 == false) goto L89;
        int r114 = 3;
    L90:
        if (r110 == false) goto L92;
        int r210 = 2;
    L93:
        if (r111 == false) goto L95;
        int r211 = 2;
    L96:
        String r115 = r28.getLinkMicIdStr();
        if (r115 != null) goto L99;
        String r116 = "";
    L100:
        ch0.g r35 = new ch0.g(r116, r113, r114, r210, r211);
        v r117 = this.z;
        if (r117 == null) goto L103;
        r117.c = r35;
        goto L103
    L99:
        r116 = r115;
        goto L100
    L95:
        r211 = 1;
        goto L96
    L92:
        r210 = 1;
        goto L93
    L89:
        r114 = 2;
        goto L90
    L86:
        r113 = 2;
        goto L87
    L80:
        r30 = null;
        goto L82
    L76:
        r111 = false;
        goto L77
    L70:
        if (r28.getLinkType() == 3) goto L72;
        r110 = true;
    L58:
        r24 = null;
    L112:
        DataCenter r1 = this.E;
        if (r1 == null) goto L115;
        r7 = (String) r1.get("data_room_unique_id", "");
    L115:
        l6 r36 = tc0.c.i(r7).O;
        if (r36 == null) goto L118;
        i1(r36);
    L118:
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r37 = this.m;
        v r38 = this.z;
        Intrinsics.checkNotNull(r38);
        r38.getClass();
        Intrinsics.checkNotNullParameter(this, "proxy");
        r38.a = this;
        r37.add(r38);
        this.l.addAllAbsent(this.m);
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r39 = this.l;
        o r40 = new o(this.m, this.A, this.E);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r40.a = this;
        r39.add(r40);
        Iterator<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r41 = this.l.iterator();
    L120:
        if (r41.hasNext() == false) goto L122;
        r41.next().attach();
        goto L120
    L122:
        return;
    L48:
        r19 = null;
        goto L49
    L19:
        this.z = new v(this.C, this.E, !this.F);
        goto L20
    L9:
        r2 = new x(this.C, this.E);
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final SurfaceView R0() {
        v r0 = this.z;
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
        if (r10 != null) goto L48;
        cg6.a r11 = this.D.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r11 == null) goto L38;
        vb6.g r12 = r11.O5();
        if (r12 == null) goto L38;
        yb6.e r13 = r12.j();
        if (r13 == null) goto L38;
        String r14 = tc0.c.h().f();
        if (r14 == null) goto L35;
        r1 = r14;
    L35:
        yb6.j r15 = r13.U(r1);
        if (r15 == null) goto L38;
        Object r16 = r15.a;
    L40:
        if ((r16 instanceof SurfaceView) == false) goto L44;
        r2 = r16;
    L44:
        return (SurfaceView) r2;
    L38:
        r16 = null;
        goto L40
    L48:
        return r10;
    L15:
        r5 = null;
    L19:
        r9 = null;
        goto L21
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Boolean> F0() {
        return this.r;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Boolean> H0() {
        return this.u;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.i> I0() {
        return this.x;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<wg0.a> b() {
        return this.y;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.k> e1() {
        return this.t;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Boolean> f1() {
        return this.v;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final v s0() {
        return this.z;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> u0() {
        return this.s;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<ch0.l> w0() {
        return this.w;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void A0(boolean r2) {
        this.r.onNext(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void B0(boolean r2) {
        this.v.onNext(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void K0(String r10) {
        Iterable r0 = (List) this.b.getValue();
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        Iterable r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        ch0.e r4 = (ch0.e) r3.next();
        if (Intrinsics.areEqual(r4.a.getInteractId(), r10) == false) goto L11;
        HashMap r7 = new HashMap();
        r7.putAll(r4.d);
        r7.put("EXT_KEY_UPDATE_MEDIA_TYPE_TIME_STAMP", Long.valueOf(System.currentTimeMillis()));
        r4 = ch0.e.a(r4, null, null, null, r7, 7);
    L11:
        r2.add(r4);
        goto L7
    L12:
        this.b.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void N1(hg6.g r4) {
        this.C = r4;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.e(r4);
    L5:
        v r1 = this.z;
        if (r1 == null) goto L14;
        eg6.b r2 = r1.j;
        if (r2 == null) goto L10;
        r2.s(r1.i);
    L10:
        r1.j = r4;
        if (r1.h == false) goto L14;
        if (r4 == null) goto L14;
        r4.h0(r1.i);
    L14:
        v r5 = this.z;
        if (r5 == null) goto L26;
        RTSDataContext r3 = RTSDataContext.Companion.getContext();
        if (r3 == null) goto L27;
        com.bytedance.live.datacontext.n<ph0.b> r6 = r3.getLinkTypeEvent();
        if (r6 == null) goto L28;
        Observable r7 = r6.a();
        if (r7 == null) goto L29;
        Disposable r8 = r7.subscribe(new w(r5));
        if (r8 == null) goto L30;
        RxUtilKt.c(r8, r5.g);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void Y0(ch0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "endEvent");
        this.t.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void Z0(List<ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "leavedPaidUserList");
        this.s.onNext(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void c(wg0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "playModeStateItem");
        gh0.a.b(null, "notifyUpdatePlayModeState", 5);
        this.y.onNext(r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void c1(boolean r2) {
        this.u.onNext(Boolean.valueOf(r2));
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
        v r5 = this.z;
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
        ch0.h r15 = new ch0.h(r14, r11, r12, 1, 32);
        v r16 = this.z;
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
        v r23 = this.z;
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

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void k1(ch0.l r4) {
        Intrinsics.checkNotNullParameter(r4, "voiceAnchorGuideInfo");
        gh0.b.a("AudioAnchorGuide", "notifyVoiceAnchorGuideInfo", false);
        this.w.onNext(r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void n0(v r1) {
        this.z = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void y0(ch0.i r2) {
        Intrinsics.checkNotNullParameter(r2, "seatDynamicData");
        this.x.onNext(r2);
    }

    public /* synthetic */ j(LifecycleOwner r9, com.bytedance.android.live.liveinteract.plantform.base.i r10, we0.a r11, eg6.b r12, j1 r13, DataCenter r14) {
        this(r9, r10, r11, r12, r13, r14, false);
    }

    public j(LifecycleOwner r3, com.bytedance.android.live.liveinteract.plantform.base.i r4, we0.a r5, eg6.b r6, j1 r7, DataCenter r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r3, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r4, "linkUserCenter");
        Intrinsics.checkNotNullParameter(r5, "linkFloatWindowListener");
        Intrinsics.checkNotNullParameter(r7, "outerScopeProvider");
        super(r3, null, 0);
        this.A = r4;
        this.B = r5;
        this.C = r6;
        this.D = r7;
        this.E = r8;
        this.F = r9;
        Boolean r10 = Boolean.FALSE;
        this.r = BehaviorSubject.createDefault(r10);
        this.s = BehaviorSubject.createDefault(new ArrayList());
        this.t = BehaviorSubject.createDefault(new ch0.k(null, false));
        this.u = BehaviorSubject.createDefault(r10);
        this.v = BehaviorSubject.createDefault(r10);
        this.w = BehaviorSubject.createDefault(new ch0.l(0, null));
        this.x = BehaviorSubject.createDefault(new ch0.i("", new ArrayList(), new ArrayList(), new ArrayList()));
        this.y = BehaviorSubject.createDefault(new wg0.a(0));
    }
}
