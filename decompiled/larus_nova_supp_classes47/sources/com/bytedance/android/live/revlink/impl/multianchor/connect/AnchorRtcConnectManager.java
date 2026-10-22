package com.bytedance.android.live.revlink.impl.multianchor.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenuelink.rtc.q;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.bridge.a2;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import dq2.t;
import dq2.w;
import fr2.h0;
import fr2.m1;
import fr2.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorRtcConnectManager {
    public static final /* synthetic */ int o = 0;
    public final IRoom a;
    public final CompositeDisposable b;
    public boolean c;
    public boolean d;
    public final com.bytedance.android.live.revlink.impl.multianchor.connect.d e;
    public boolean f;
    public String g;
    public final AnchorRtcConnectManager$configInvocation$1 h;
    public v i;
    public final AnchorRtcConnectModel j;
    public final yz0.g k;
    public final yz0.f l;
    public final com.bytedance.android.live.revlink.impl.global.c m;
    public final ld.a n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public b(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Unit) sh6.c.b((sh6.b) r3)) == null) goto L9;
            AnchorRtcConnectManager r4 = this.a;
            r4.j.onMultiLinkFinished();
            com.bytedance.android.live.revlink.impl.multianchor.connect.d r0 = r4.e;
            com.bytedance.android.live.revenuelink.rtc.i r1 = r0.a;
            if (r1 == null) goto L7;
            r1.i1(r0.d());
        L7:
            r4.c = false;
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public c(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            AnchorRtcConnectManager r7 = this.a;
            r7.getClass();
            jy0.b.d("ttlive_anchor_connect_mgr", "onEnterMultiLink, forward: " + r7.j.forwardInfoString());
            jy0.b.d("ttlive_anchor_connect_mgr", "onEnterMultiLink, frame: " + r7.j.frameInfoString());
            Map<Long, ? extends z1> r0 = (Map) r7.j.getPreRtcInfoMap().getValue();
            if (r0 == null) goto L5;
            r7.f(r0);
            r7.e();
        L5:
            o r1 = (o) r7.j.getRtcForwardData().getValue();
            if (r1 == null) goto L8;
            Map<Long, String> r2 = r1.a;
        L10:
            if (r2 != null) goto L12;
        L15:
            boolean r3 = true;
        L16:
            if (r3 == false) goto L23;
            com.bytedance.android.live.revlink.impl.global.c r4 = r7.m;
            if (r4 == null) goto L22;
            g0 r8 = r4.Rn();
            if (r8 == null) goto L22;
            r8.n("enterMultiLink");
        L22:
            r7.j.refreshForwardData();
        L23:
            com.bytedance.android.live.revenuelink.rtc.i r9 = r7.g();
            if (r9 != null) goto L26;
        L28:
            r7.c = false;
            return;
        L26:
            if (r9.isEngineOn() != true) goto L28;
            r7.e.a();
            goto L28
        L12:
            if (r2.isEmpty() == true) goto L15;
            r3 = false;
            goto L16
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public d(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            this.a.e.a();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public e(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Map<Long, ? extends z1> r7 = (Map) sh6.c.b((sh6.b) r6);
            if (r7 == null) goto L28;
            this.a.f(r7);
            this.a.e();
            AnchorRtcConnectManager r0 = this.a;
            r0.getClass();
            Iterator<Map.Entry<Long, ? extends z1>> r8 = r7.entrySet().iterator();
        L5:
            boolean r2 = false;
        L7:
            if (r8.hasNext() == false) goto L18;
            z1 r3 = r8.next().getValue();
            if (AnchorRtcConnectUtilsKt.d(r3) == false) goto L7;
            Boolean r4 = r0.j.getAnchorWithAudienceMap().remove(r3.getLinkmicIdStr());
            if (r4 == null) goto L14;
            boolean r5 = r4.booleanValue();
        L15:
            if (r2 == true) goto L17;
            if (r5 == false) goto L5;
        L17:
            r2 = true;
            goto L7
        L14:
            r5 = false;
            goto L15
        L18:
            if (r2 == false) goto L29;
            r0.j.refreshForwardData();
            return;
        L29:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public f(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r14) {
            String r15 = (String) r14;
            AnchorRtcConnectManager r0 = this.a;
            Map r1 = (Map) r0.j.getPreRtcInfoMap().getValue();
            if (r1 == null) goto L14;
            Collection r2 = r1.values();
            if (r2 == null) goto L14;
            Iterator<T> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L12;
            T r4 = r3.next();
            if (Intrinsics.areEqual(((z1) r4).getLinkmicIdStr(), r15) == false) goto L8;
        L13:
            z1 r5 = (z1) r4;
        L15:
            Pair<Boolean, Boolean> r6 = r0.b(r15);
            boolean r7 = ((Boolean) r6.component1()).booleanValue();
            boolean r8 = ((Boolean) r6.component2()).booleanValue();
            boolean r9 = false;
            if (r7 == false) goto L19;
            if (r8 == false) goto L19;
            boolean r10 = true;
        L21:
            if (r5 != null) goto L26;
            jy0.b.c("ttlive_anchor_connect_mgr", "onRtcUserJoin " + r15 + " not in preRtcInfo can audience render: " + r10, null, 4);
            y41.f r12 = y41.f.N;
            r12.getClass();
            if (((Boolean) y41.f.g.getValue(r12, y41.f.a[5])).booleanValue() == true) goto L26;
            if (r10 == true) goto L26;
            return;
        L26:
            com.bytedance.android.live.revlink.impl.global.c r13 = r0.m;
            if (r13 == null) goto L34;
            g0 r16 = r13.Rn();
            if (r16 == null) goto L34;
            if (r16.p(r15) != true) goto L34;
            jy0.b.c("ttlive_anchor_connect_mgr", "onRtcUserJoin main backup stream ".concat(r15), null, 4);
            return;
        L34:
            if (StringsKt.startsWith$default(r15, "output_view_stream_x", false, 2, null) == false) goto L37;
            Pair r17 = TuplesKt.to(Boolean.TRUE, Boolean.valueOf(r0.i()));
        L43:
            boolean r18 = ((Boolean) r17.component1()).booleanValue();
            boolean r19 = ((Boolean) r17.component2()).booleanValue();
            if (r18 == false) goto L47;
            if (r19 == false) goto L47;
            boolean r110 = true;
        L48:
            StringBuilder r111 = new StringBuilder("onRtcUserJoin isStreamXView ");
            r111.append(r18);
            r111.append(" canStreamXRender: ");
            r111.append(r19);
            r111.append(" canAudienceFrameRender: ");
            r111.append(r10);
            r111.append(", isLinked = ");
            if (r5 == null) goto L51;
            Boolean r20 = Boolean.valueOf(AnchorRtcConnectUtilsKt.d(r5));
        L52:
            r111.append(r20);
            jy0.b.c("ttlive_anchor_connect_mgr", r111.toString(), null, 4);
            if (r0.i() == false) goto L57;
            if (r5 == null) goto L57;
            if (AnchorRtcConnectUtilsKt.d(r5) != true) goto L57;
        L61:
            boolean r22 = true;
        L62:
            com.bytedance.android.live.revenuelink.rtc.i r23 = r0.g();
            if (r23 == null) goto L65;
            r23.b1(r15, r22);
        L65:
            com.bytedance.android.live.revenuelink.rtc.i r24 = r0.g();
            if (r24 == null) goto L76;
            if (r22 == false) goto L69;
            if (r18 == true) goto L69;
        L70:
            r24.G1(r15, r9, "onRtcUserJoin");
            return;
        L69:
            r9 = true;
            goto L70
        L76:
            return;
        L57:
            if (r10 == true) goto L61;
            if (r110 == true) goto L61;
            r22 = false;
            goto L62
        L51:
            r20 = null;
        L47:
            r110 = false;
            goto L48
        L37:
            if (StringsKt.startsWith$default(r15, "director_view_stream_x", false, 2, null) == false) goto L39;
        L42:
            r17 = TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
            goto L43
        L39:
            if (StringsKt.startsWith$default(r15, "group_view_stream_x", false, 2, null) == true) goto L42;
            Boolean r25 = Boolean.FALSE;
            r17 = TuplesKt.to(r25, r25);
        L19:
            r10 = false;
            goto L21
        L12:
            r4 = null;
        L14:
            r5 = null;
            goto L15
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public g(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            String r7 = (String) r6;
            AnchorRtcConnectManager r0 = this.a;
            com.bytedance.android.live.revenuelink.rtc.i r1 = r0.g();
            String r2 = null;
            if (r1 == null) goto L7;
            com.bytedance.android.live.revenuelink.rtc.p r3 = r1.L();
            if (r3 == null) goto L7;
            com.bytedance.android.live.revenuelink.rtc.o r4 = r3.k(r7);
        L8:
            if (r4 == null) goto L15;
            com.bytedance.android.live.revenuelink.rtc.i r5 = r0.g();
            if (r5 == null) goto L12;
            r5.b1(r7, false);
        L12:
            com.bytedance.android.live.revenuelink.rtc.i r8 = r0.g();
            if (r8 == null) goto L15;
            r8.G1(r7, true, "onRenderedFrameInvalid");
        L15:
            StringBuilder r9 = new StringBuilder("onRenderedFrameInvalid ");
            r9.append(r7);
            r9.append(", frame: ");
            r9.append(r0.j.frameInfoString());
            r9.append(' ');
            com.bytedance.android.live.revenuelink.rtc.i r10 = r0.g();
            if (r10 == null) goto L20;
            com.bytedance.android.live.revenuelink.rtc.p r12 = r10.L();
            if (r12 == null) goto L20;
            r2 = r12.toString();
        L20:
            r9.append(r2);
            jy0.b.d("ttlive_anchor_connect_mgr", r9.toString());
            return;
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AnchorRtcConnectManager a;

        public h(AnchorRtcConnectManager r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            o r6 = (o) sh6.c.b((sh6.b) r5);
            if (r6 == null) goto L26;
            com.bytedance.android.live.revenuelink.rtc.i r0 = this.a.g();
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.isEngineOn() != true) goto L28;
            com.bytedance.android.live.revlink.impl.global.c r1 = this.a.m;
            if (r1 == null) goto L14;
            com.bytedance.android.live.revenuelink.connect.g r2 = r1.getAnchorConnectUtils();
            if (r2 == null) goto L14;
            String r3 = String.valueOf(r2.getChannelId());
            if (r3 == null) goto L14;
        L15:
            com.bytedance.android.live.revenuelink.rtc.i r4 = this.a.g();
            if (r4 != null) goto L18;
        L22:
            com.bytedance.android.live.revenuelink.rtc.i r7 = this.a.g();
            if (r7 == null) goto L31;
            r7.c1(r6.a, r6.b, r3);
            return;
        L31:
            return;
        L18:
            if (r4.g0() != true) goto L22;
            com.bytedance.android.live.revenuelink.rtc.i r8 = this.a.g();
            if (r8 == null) goto L29;
            r8.a1(r6.a, r6.b, r3);
            return;
        L29:
            return;
        L14:
            r3 = "";
            goto L15
        L28:
            return;
        }
    }

    static {
    }

    public static boolean h() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        w r2 = ((com.bytedance.live.kmp.core.c) r0).M1();
        if (r2 == null) goto L5;
        int r3 = r2.w();
    L6:
        if (r3 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = 0;
        goto L6
    }

    public static boolean j() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        w r2 = ((com.bytedance.live.kmp.core.c) r0).M1();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.s() != true) goto L7;
        return true;
    }

    public final void a() {
        yz0.f r0 = this.l;
        if (r0 == null) goto L9;
        Observable r1 = yz0.h.a.a(r0, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r1 == null) goto L9;
        final AnchorRtcConnectManager$attach$1 r2 = new AnchorRtcConnectManager$attach$1(this);
        Disposable r3 = r1.subscribe(new i(r2));
        if (r3 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.b);
    L9:
        ld.a r4 = this.n;
        if (r4 == null) goto L18;
        NextLiveData r5 = r4.N5();
        if (r5 == null) goto L18;
        Observable r6 = ld.c.a(r5);
        if (r6 == null) goto L18;
        Disposable r7 = r6.subscribe(new b(this));
        if (r7 == null) goto L18;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7, this.b);
    L18:
        com.bytedance.revenue.platform.api.core.rx.f.a(this.j.getMultiLinkLoadEvent().onEvent().subscribe(new c(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.j.getOnStartRtcEvent().onEvent().subscribe(new d(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.j.getPreRtcInfoMap().a().subscribe(new e(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.j.getOnRtcUserJoinEvent().onEvent().subscribe(new f(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.j.getOnRenderedFrameInvalidEvent().onEvent().subscribe(new g(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.j.getRtcForwardData().a().subscribe(new h(this)), this.b);
        Function1<List<? extends ILinkPlayerInfoBridge>, Unit> r8 = new AnchorRtcConnectManager$attach$9(this);
        Intrinsics.checkNotNullParameter(r8, "onChange");
        com.bytedance.revenue.platform.api.core.rx.f.a(vh6.c.b(qr2.c.class).registerOnlineListChange(r8), this.b);
    }

    public final com.bytedance.android.live.revenuelink.rtc.i g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.m;
        if (r0 == null) goto L7;
        com.bytedance.android.live.revenuelink.rtc.f r1 = r0.m0();
        if (r1 == null) goto L7;
        return r1.getRtcManager();
    L7:
        return null;
    }

    public final boolean i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.m;
        if (r0 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r1 = r0.getMultiLinkUtil();
        if (r1 == null) goto L9;
        if (r1.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void e() {
        com.bytedance.android.live.revenuelink.rtc.i r0 = g();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEngineOn() != true) goto L42;
        com.bytedance.android.live.revenuelink.rtc.i r1 = g();
        if (r1 == null) goto L39;
        com.bytedance.android.live.revenuelink.rtc.p r2 = r1.L();
        if (r2 == null) goto L40;
        List<com.bytedance.android.live.revenuelink.rtc.o> r3 = r2.l();
        if (r3 == null) goto L41;
        Iterator<T> r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L43;
        com.bytedance.android.live.revenuelink.rtc.o r5 = (com.bytedance.android.live.revenuelink.rtc.o) r4.next();
        Pair<Boolean, Boolean> r6 = b(r5.b);
        boolean r7 = ((Boolean) r6.component1()).booleanValue();
        boolean r8 = ((Boolean) r6.component2()).booleanValue();
        if (r7 == false) goto L15;
        if ((!Intrinsics.areEqual(r5.l, Boolean.valueOf(r8))) == true) goto L21;
        jy0.b.c("ttlive_anchor_connect_mgr", "rtc user render status same " + r5, null, 4);
        goto L15
    L21:
        com.bytedance.android.live.revenuelink.rtc.i r9 = g();
        if (r9 == null) goto L24;
        r9.b1(r5.b, r8);
    L24:
        com.bytedance.android.live.revenuelink.rtc.i r10 = g();
        if (r10 == null) goto L15;
        r10.G1(r5.b, !r8, "ensureRemoteRenderStatus");
        goto L15
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    }

    public final Pair<Boolean, Boolean> b(String r5) {
        qr2.a r0 = n41.a.a(r5);
        if (r0 != null) goto L7;
        Boolean r6 = Boolean.FALSE;
        return TuplesKt.to(r6, r6);
    L7:
        if (r0.a == true) goto L9;
        jy0.b.c("ttlive_anchor_connect_mgr", "checkAudienceFrameCanRender linkerID: " + r5 + ", linkRoomID: " + r0.h, null, 4);
        Map r7 = (Map) this.j.getPreRtcInfoMap().getValue();
        if (r7 == null) goto L24;
        z1 r8 = (z1) r7.get(Long.valueOf(r0.h));
        if (r8 == null) goto L24;
        Boolean r1 = Boolean.TRUE;
        if (i() == false) goto L20;
        boolean r2 = true;
        if (AnchorRtcConnectUtilsKt.d(r8) != true) goto L20;
    L22:
        return TuplesKt.to(r1, Boolean.valueOf(r2));
    L20:
        r2 = false;
    L24:
        return TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
    L9:
        return TuplesKt.to(Boolean.TRUE, Boolean.valueOf(i()));
    }

    public final void c(String r8) {
        if (this.f == true) goto L5;
        return;
    L5:
        jy0.b.f("ttlive_anchor_connect_mgr", "do checkRtcOnForHasAudience", null, 4);
        if (j() == false) goto L54;
        jy0.b.f("ttlive_anchor_connect_mgr", "set rtc client from multi link", null, 4);
        com.bytedance.android.live.revlink.impl.global.c r1 = this.m;
        if (r1 == null) goto L14;
        com.bytedance.android.live.revenuelink.rtc.f r2 = r1.m0();
        if (r2 == null) goto L14;
        com.bytedance.android.live.revenuelink.rtc.i r3 = r2.getRtcManager();
        if (r3 == null) goto L14;
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r4 = com.bytedance.android.scope.m.b(r5).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r4);
        r3.k1(((com.bytedance.live.kmp.core.c) r4).getData(), r8);
    L14:
        o r6 = (o) this.j.getRtcForwardData().getValue();
        if (r6 != null) goto L17;
    L29:
        com.bytedance.android.live.revlink.impl.multianchor.connect.d r9 = this.e;
        com.bytedance.android.live.revenuelink.rtc.i r0 = r9.a;
        if (r0 == null) goto L44;
        com.bytedance.android.live.revenuelink.rtc.p r7 = r0.L();
        if (r7 == null) goto L44;
        Iterator r10 = h0.a(r7.d()).entrySet().iterator();
    L35:
        if (r10.hasNext() == false) goto L44;
        Map.Entry r12 = (Map.Entry) r10.next();
        String r13 = (String) r12.getKey();
        Object r14 = r12.getValue();
        if ((r14 instanceof fr2.l) == true) goto L39;
        r14 = null;
    L39:
        fr2.l r15 = (fr2.l) r14;
        if (r15 == null) goto L35;
        r9.g.onUserJoined(r13);
        r9.b.onFirstFrame(r13, new g21.b(r15, r9.b(r13)));
    L44:
        if (v41.a.m.a() == false) goto L55;
        com.bytedance.android.live.revenuelink.rtc.i r16 = g();
        if (r16 == null) goto L56;
        r16.R0(this.g);
        return;
    L56:
        return;
    L55:
        return;
    L17:
        if ((!r6.a.isEmpty()) == false) goto L28;
        jy0.b.f("ttlive_anchor_connect_mgr", "checkRtcOnForHasAudience startForwardStreamsToRooms " + r6, null, 4);
        com.bytedance.android.live.revenuelink.rtc.i r17 = g();
        if (r17 == null) goto L29;
        Map<Long, String> r18 = r6.a;
        String r19 = "pushInAdvance_".concat(r8);
        com.bytedance.android.live.revlink.impl.global.c r20 = this.m;
        if (r20 == null) goto L26;
        com.bytedance.android.live.revenuelink.connect.g r22 = r20.getAnchorConnectUtils();
        if (r22 == null) goto L26;
        String r23 = String.valueOf(r22.getChannelId());
        if (r23 == null) goto L26;
    L27:
        r17.c1(r18, r19, r23);
    L26:
        r23 = "";
        goto L27
    L28:
        jy0.b.a("ttlive_anchor_connect_mgr", "not start forward in advance since room is empty " + r6);
        goto L29
    }

    public final void f(Map<Long, ? extends z1> r18) {
        StringBuilder r1 = new StringBuilder("ensureRemoteRenderStatus ");
        r1.append(i());
        r1.append(" state=");
        com.bytedance.android.live.revlink.impl.global.c r2 = this.m;
        if (r2 == null) goto L9;
        com.bytedance.android.live.revenuelink.connect.g r3 = r2.getAnchorConnectUtils();
        if (r3 == null) goto L9;
        LiveData<ey.f> r4 = r3.connectState();
        if (r4 == null) goto L9;
        ey.f r5 = (ey.f) r4.getValue();
    L10:
        r1.append(r5);
        r1.append(' ');
        r1.append(r18.keySet());
        r1.append('}');
        jy0.b.d("ttlive_anchor_connect_mgr", r1.toString());
        com.bytedance.android.live.revenuelink.rtc.i r6 = g();
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.isEngineOn() != true) goto L146;
        IRoomBase r7 = this.a;
        if (r7 == null) goto L77;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.m;
        if (r8 == null) goto L77;
        g0 r9 = r8.Rn();
        if (r9 == null) goto L77;
        com.bytedance.android.live.revenuelink.rtc.i r10 = g();
        Intrinsics.checkNotNullParameter(r18, "preRtcInfoMap");
        Intrinsics.checkNotNullParameter(r7, "room");
        com.bytedance.android.live.revlink.impl.global.c r12 = r9.d;
        if (r12 == null) goto L24;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r13 = r12.getMultiLinkUtil();
    L25:
        if (r13 != null) goto L27;
    L28:
        com.bytedance.android.live.revlink.impl.global.c r14 = r9.d;
        if (r14 == null) goto L31;
        com.bytedance.android.live.revenuelink.connect.g r15 = r14.getAnchorConnectUtils();
    L32:
        if (r15 != null) goto L34;
    L36:
        StringBuilder r16 = new StringBuilder();
        Iterator<Map.Entry<Long, ? extends z1>> r17 = r18.entrySet().iterator();
    L38:
        if (r17.hasNext() == false) goto L65;
        Map.Entry<Long, ? extends z1> r19 = r17.next();
        long r110 = r19.getKey().longValue();
        z1 r111 = r19.getValue();
        if (r110 == IRoomKtKt.getId(r7)) goto L38;
        String r112 = r111.getLinkmicIdStr();
        com.bytedance.android.live.revlink.impl.global.c r113 = r9.d;
        if (r113 == null) goto L44;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r114 = r113.getMultiLinkUtil();
    L45:
        if (r114 != null) goto L47;
    L51:
        boolean r115 = false;
    L52:
        if (r10 == null) goto L56;
        com.bytedance.android.live.revenuelink.rtc.p r116 = r10.L();
        if (r116 == null) goto L56;
        com.bytedance.android.live.revenuelink.rtc.o r117 = r116.k(r112);
    L57:
        if (r117 == null) goto L59;
        Boolean r118 = r117.l;
    L61:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L38;
        if (r115 == true) goto L38;
        r16.append(r112 + " rendered frame become disable");
        goto L38
    L59:
        r118 = null;
    L56:
        r117 = null;
        goto L57
    L47:
        if (r114.c() != true) goto L51;
        if (AnchorRtcConnectUtilsKt.d(r111) == false) goto L51;
        r115 = true;
        goto L52
    L44:
        r114 = null;
        goto L45
    L65:
        if (r16.length() <= 0) goto L67;
        boolean r20 = true;
    L68:
        if (r20 == false) goto L77;
        JSONObject r22 = new JSONObject();
        int r23 = y50.b.a;
        y50.b.a.d(r22, "errorInfo", r16.toString());
        Collection<? extends z1> r24 = r18.values();
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator<T> r26 = r24.iterator();
    L71:
        if (r26.hasNext() == false) goto L73;
        r25.add(a2.a((z1) r26.next()));
        goto L71
    L73:
        y50.b.a.d(r22, "update_pre_rtc_info", r25.toString());
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r27 = r9.o();
        if (r27 == null) goto L77;
        r27.I("unexpected_render_status_update", r22, true);
        goto L77
    L67:
        r20 = false;
        goto L68
    L34:
        if (r15.t1() != true) goto L36;
    L31:
        r15 = null;
        goto L32
    L27:
        if (r13.c() == true) goto L36;
    L24:
        r13 = null;
    L77:
        Iterator<Map.Entry<Long, ? extends z1>> r28 = r18.entrySet().iterator();
    L79:
        if (r28.hasNext() == false) goto L147;
        Map.Entry<Long, ? extends z1> r29 = r28.next();
        long r30 = r29.getKey().longValue();
        z1 r32 = r29.getValue();
        IRoomBase r33 = this.a;
        if (r33 == null) goto L85;
        if (r30 == IRoomKtKt.getId(r33)) goto L79;
    L85:
        String r34 = r32.getLinkmicIdStr();
        if (i() == true) goto L88;
    L90:
        boolean r35 = false;
    L91:
        com.bytedance.android.live.revenuelink.rtc.i r36 = g();
        if (r36 == null) goto L96;
        com.bytedance.android.live.revenuelink.rtc.p r37 = r36.L();
        if (r37 == null) goto L96;
        com.bytedance.android.live.revenuelink.rtc.o r38 = r37.k(r34);
    L98:
        if (r38 == null) goto L99;
        com.bytedance.android.live.revlink.impl.global.c r119 = this.m;
        if (r119 == null) goto L108;
        g0 r120 = r119.Rn();
        if (r120 == null) goto L108;
        if (r120.p(r34) != true) goto L108;
        jy0.b.f("ttlive_anchor_connect_mgr", "skip main backup stream ".concat(r34), null, 4);
    L108:
        if ((!Intrinsics.areEqual(r38.l, Boolean.valueOf(r35))) == false) goto L112;
        com.bytedance.android.live.revenuelink.rtc.i r121 = g();
        if (r121 == null) goto L114;
        r121.b1(r34, r35);
    L114:
        if (r38.j == false) goto L117;
        if (r35 == false) goto L117;
        jy0.b.c("ttlive_anchor_connect_mgr", "rtc user in chorus mute, intercept un-mute " + r38, null, 4);
    L120:
        this.j.updateFrameCanRender(r32, r35);
    L117:
        com.bytedance.android.live.revenuelink.rtc.i r39 = g();
        if (r39 == null) goto L120;
        r39.G1(r34, !r35, "ensureRemoteRenderStatus");
        goto L120
    L112:
        jy0.b.c("ttlive_anchor_connect_mgr", "rtc user render status same " + r38, null, 4);
        goto L114
    L99:
        jy0.b.f("ttlive_anchor_connect_mgr", "rtc user " + r34 + " not joined when ensure render status", null, 4);
    L96:
        r38 = null;
        goto L98
    L88:
        if (AnchorRtcConnectUtilsKt.d(r32) == false) goto L90;
        r35 = true;
        goto L91
    L147:
        return;
    L146:
        return;
    L9:
        r5 = null;
        goto L10
    }

    public final void d(String r10, String r12) {
        jy0.b.f("ttlive_anchor_connect_mgr", "startRtcInAdvance source=" + r12 + " initRtcInfo=" + r10, null, 4);
        v r0 = this.i;
        if (r0 == null) goto L7;
        m1 r1 = r0.getLiveStream();
        if (r1 == null) goto L7;
        r1.b();
    L7:
        com.bytedance.android.live.revenuelink.rtc.i r2 = g();
        if (r2 == null) goto L32;
        v r4 = this.i;
        if (r4 == null) goto L12;
        vc0.a r5 = vc0.b.a(r4);
    L13:
        if (r5 == null) goto L26;
        Object r6 = r5.b;
        if ((r6 instanceof xh6.c) == true) goto L17;
        xh6.c r7 = vh6.c.b(fr2.g0.class).o6().e(Reflection.getOrCreateKotlinClass(v.class), r5.a);
        if ((r7 instanceof v) == true) goto L23;
        r7 = null;
    L23:
        v r8 = (v) r7;
    L24:
        if (r8 == null) goto L26;
        vc0.a r9 = vc0.b.a(r8);
    L27:
        AnchorRtcConnectManager$configInvocation$1 r13 = this.h;
        if (r10 != null) goto L30;
        String r14 = "";
    L31:
        r2.U1(r9, r13, r14, new q(null, 10));
        goto L32
    L30:
        r14 = r10;
        goto L31
    L17:
        if ((r6 instanceof v) == true) goto L19;
        r6 = null;
    L19:
        r8 = (v) r6;
    L26:
        r9 = null;
        goto L27
    L12:
        r5 = null;
    L32:
        o r3 = (o) this.j.getRtcForwardData().getValue();
        if (r3 == null) goto L48;
        if ((!r3.a.isEmpty()) == false) goto L46;
        com.bytedance.android.live.revlink.impl.global.c r15 = this.m;
        if (r15 == null) goto L42;
        com.bytedance.android.live.revenuelink.connect.g r16 = r15.getAnchorConnectUtils();
        if (r16 == null) goto L42;
        String r17 = String.valueOf(r16.getChannelId());
        if (r17 == null) goto L42;
    L43:
        com.bytedance.android.live.revenuelink.rtc.i r18 = g();
        if (r18 == null) goto L48;
        r18.c1(r3.a, "pushInAdvance_" + r12, r17);
    L42:
        r17 = "";
        goto L43
    L46:
        jy0.b.a("ttlive_anchor_connect_mgr", "not start forward in advance since room is empty " + r3);
    L48:
        if (v41.a.m.a() == false) goto L55;
        com.bytedance.android.live.revenuelink.rtc.i r19 = g();
        if (r19 == null) goto L56;
        if (r10 != null) goto L53;
        r10 = "";
    L53:
        r19.R0(r10);
        return;
    L56:
        return;
    }

    public final void l(String r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        com.bytedance.android.live.revenuelink.rtc.i r1 = g();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isEngineOn());
    L6:
        jy0.b.f("ttlive_anchor_connect_mgr", "stopRtc " + r10 + " rtcEngineOn=" + r2, null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.connect.d r3 = this.e;
        com.bytedance.android.live.revenuelink.rtc.i r4 = r3.a;
        if (r4 == null) goto L9;
        r4.i1(r3.d());
    L9:
        com.bytedance.android.live.revenuelink.rtc.i r5 = g();
        if (r5 != null) goto L12;
    L27:
        this.j.onRtcClosed();
        com.bytedance.android.live.revlink.impl.global.c r6 = this.m;
        if (r6 == null) goto L34;
        MultiLinkAnchorControlContext r7 = r6.ua();
        if (r7 == null) goto L34;
        UnexpectedFrameMonitor r8 = r7.getUnexpectedFrameMonitor();
        if (r8 == null) goto L34;
        r8.m = null;
    L34:
        this.f = false;
        if (r12 == true) goto L37;
        return;
    L37:
        if (this.c == false) goto L47;
        com.bytedance.android.live.revlink.impl.global.c r13 = this.m;
        if (r13 == null) goto L45;
        g0 r14 = r13.Rn();
        if (r14 == null) goto L45;
        Intrinsics.checkNotNullParameter(r10, "source");
        jy0.b.c("ttlive_anchor_link", "reopen video talk by multi anchor ".concat(r10), null, 4);
        JSONObject r9 = new JSONObject();
        int r15 = y50.b.a;
        y50.b.a.d(r9, "source", r10);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r16 = r14.o();
        if (r16 == null) goto L45;
        r16.I("reopen_video_talk_by_multi_anchor", r9, true);
    L45:
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r18);
        ((com.bytedance.live.kmp.core.c) r18).multiAnchorLoadVideoTalk();
        this.c = false;
    L47:
        if (this.d == false) goto L54;
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r19).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r110);
        t r111 = ((com.bytedance.live.kmp.core.c) r110).getRadioLinkService();
        if (r111 == null) goto L51;
        r111.n();
    L51:
        this.d = false;
        return;
    L54:
        return;
    L12:
        if (r5.isEngineOn() != true) goto L27;
        if (h() == true) goto L19;
        com.bytedance.android.live.revenuelink.rtc.i r20 = g();
        if (r20 == null) goto L27;
        r20.T1("connect_".concat(r10), false);
        goto L27
    L19:
        com.bytedance.android.live.revenuelink.rtc.i r22 = g();
        if (r22 == null) goto L22;
        r22.o1();
    L22:
        com.bytedance.android.live.revlink.impl.settings.live.b r23 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r23.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.b.i.getValue(r23, com.bytedance.android.live.revlink.impl.settings.live.b.a[7])).booleanValue() == false) goto L27;
        com.bytedance.android.live.revenuelink.rtc.i r24 = g();
        if (r24 == null) goto L27;
        r24.P1(false, null, null);
        goto L27
    L5:
        r2 = null;
        goto L6
    }

    public final void k(final String r7, final String r8, final int r9) {
        com.bytedance.android.live.revenuelink.rtc.i r0 = g();
        boolean r3 = true;
        if (r0 != null) goto L5;
    L8:
        this.g = r7;
        this.e.a();
        boolean r5 = false;
        if (j() == false) goto L22;
        jy0.b.f("ttlive_anchor_connect_mgr", "startRtcInAdvance but video talk rtc engine on source=".concat(r8), null, 4);
        if (r9 == BizType.PK.ordinal()) goto L15;
        if (r9 == BizType.OpenGame.ordinal()) goto L15;
    L16:
        r5 = true;
    L17:
        if (r5 == false) goto L21;
        jy0.b.f("ttlive_anchor_connect_mgr", "stop video talk rtc", null, 4);
        Function0<Unit> r1 = new AnchorRtcConnectManager$startRtcInAdvance$1(this, r7, r8, r9);
        AnchorRtcConnectManager$startRtcInAdvance$2 r10 = AnchorRtcConnectManager$startRtcInAdvance$2.INSTANCE;
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r13);
        w r14 = ((com.bytedance.live.kmp.core.c) r13).M1();
        if (r14 == null) goto L34;
        r14.y(new com.bytedance.android.live.revlink.impl.multianchor.connect.b(r1, r10));
        return;
    L34:
        return;
    L21:
        jy0.b.f("ttlive_anchor_connect_mgr", "skip stop video talk rtc", null, 4);
        this.f = true;
        return;
    L15:
        if (h() == true) goto L17;
    L22:
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r2).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r15);
        t r16 = ((com.bytedance.live.kmp.core.c) r15).getRadioLinkService();
        if (r16 != null) goto L25;
    L27:
        r3 = false;
    L28:
        if (r3 == false) goto L32;
        Function0<Unit> r17 = new AnchorRtcConnectManager$startRtcInAdvance$3(this, r7, r8);
        AnchorRtcConnectManager$startRtcInAdvance$4 r18 = AnchorRtcConnectManager$startRtcInAdvance$4.INSTANCE;
        Object r19 = com.bytedance.android.scope.m.b(r2).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r19);
        t r20 = ((com.bytedance.live.kmp.core.c) r19).getRadioLinkService();
        if (r20 == null) goto L37;
        r20.q(new com.bytedance.android.live.revlink.impl.multianchor.connect.a(r17, r18));
        return;
    L37:
        return;
    L32:
        d(r7, r8);
        return;
    L25:
        if (r16.o() != true) goto L27;
    L5:
        if (r0.isEngineOn() != true) goto L8;
        jy0.b.c("ttlive_anchor_connect_mgr", "startRtcInAdvance but rtc already on ".concat(r8), null, 4);
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager$configInvocation$1] */
    public AnchorRtcConnectManager(v r10, AnchorRtcConnectModel r12, yz0.g r13, yz0.f r14, com.bytedance.android.live.revlink.impl.global.c r15, ld.a r16) {
        Intrinsics.checkNotNullParameter(r12, "rtcConnectModel");
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        g0 r17 = null;
        if (r13 == null) goto L5;
        IRoomBase r18 = r13.mo444getRoom();
    L7:
        if ((r18 instanceof IRoom) == true) goto L9;
        r18 = null;
    L9:
        this.a = (IRoom) r18;
        this.b = new CompositeDisposable();
        com.bytedance.android.live.revenuelink.rtc.i r2 = g();
        if (r15 == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r5 = r15.rb();
    L13:
        if (r15 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r7 = r15.getMultiLinkUtil();
    L16:
        if (r15 == null) goto L18;
        r17 = r15.Rn();
    L18:
        Intrinsics.checkNotNullParameter(this, "rtcConnectionManager");
        Intrinsics.checkNotNullParameter(r12, "rtcConnectModel");
        this.e = new com.bytedance.android.live.revlink.impl.multianchor.connect.d(r2, this, r12, r5, r13, r7, r17);
        this.g = "";
        this.h = new AnchorRtcConnectManager$configInvocation$1(this);
        return;
    L15:
        r7 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L5:
        r18 = null;
        goto L7
    }
}
