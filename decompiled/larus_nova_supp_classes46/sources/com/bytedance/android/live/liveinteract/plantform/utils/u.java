package com.bytedance.android.live.liveinteract.plantform.utils;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.a80;
import com.bytedance.android.livesdk.config.cc0;
import com.bytedance.android.livesdk.config.ec0;
import com.bytedance.android.livesdk.config.fc0;
import com.bytedance.android.livesdk.config.op0;
import com.bytedance.android.livesdk.config.ta0;
import com.bytedance.android.livesdk.config.tn0;
import com.bytedance.android.livesdk.config.un0;
import com.bytedance.android.livesdk.config.y70;
import com.bytedance.android.livesdk.config.z70;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u {
    public final String a;
    public String b;
    public final BehaviorSubject<PublicStreamPlayState> c;
    public final BehaviorSubject<PublicStreamClientMixStrategy> d;
    public final SurfaceView e;
    public final SurfaceView f;
    public final boolean g;
    public final boolean h;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m i;
    public final CompositeDisposable j;
    public int k;
    public final DataCenter l;
    public final IRoom m;
    public final tf0.o.a n;
    public final eh0.b o;
    public final j1 p;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ u a;

        public a(u r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            u.a(this.a, ((com.bytedance.android.livesdk.chatroom.viewmodel.i) r2).a);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            u.a(this.a, ((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2).a);
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            PublicStreamPlayState r3 = (PublicStreamPlayState) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3 != PublicStreamPlayState.Playing) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ u a;

        public d(u r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.i();
        }
    }

    public final kg6.e c() {
        cg6.a r0 = this.p.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        jg6.a r1 = r0.e5();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return null;
    }

    public final Integer d() {
        PublicStreamClientMixStrategy r0 = (PublicStreamClientMixStrategy) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.ordinal());
    }

    public final Integer e() {
        PublicStreamPlayState r0 = (PublicStreamPlayState) this.c.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.ordinal());
    }

    public final boolean h() {
        boolean r0 = this.h;
        if (r0 == true) goto L9;
        hg6.g r1 = g(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.A() == true) goto L9;
        return false;
    L9:
        if (((Boolean) tn0.a.getValue()).booleanValue() == false) goto L21;
        String r2 = this.b;
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.length() <= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 != true) goto L23;
        return true;
    L23:
        return false;
    L15:
        r3 = false;
        goto L16
    L21:
        return false;
    }

    public final void i() {
        PublicStreamPlayState r0 = (PublicStreamPlayState) this.c.getValue();
        PublicStreamPlayState r1 = PublicStreamPlayState.Fallback;
        if (r0 != r1) goto L6;
        ALogger.i(LinkRoomFightContext.TAG, "already not use mcu, no need to fallback");
        return;
    L6:
        StringBuilder r2 = new StringBuilder("handleFallbackToCrossRoomStream: peer size ");
        List r3 = (List) this.o.h().getValue();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.size());
    L10:
        r2.append(r4);
        r2.append(", publicStreamClientMixStrategy = ");
        r2.append((PublicStreamClientMixStrategy) this.d.getValue());
        ALogger.i(LinkRoomFightContext.TAG, r2.toString());
        if (((PublicStreamClientMixStrategy) this.d.getValue()) == PublicStreamClientMixStrategy.Using) goto L13;
    L15:
        SurfaceView r5 = f();
        if (r5 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r5);
    L19:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L21;
        f2.f("公共流播放失败，使用RTC流");
    L21:
        this.n.kd(this.b, "fallback");
        this.c.onNext(r1);
        return;
    L13:
        if (this.h == false) goto L15;
        this.d.onNext(PublicStreamClientMixStrategy.Fallback);
        this.n.n1(true);
        goto L19
    L9:
        r4 = null;
        goto L10
    }

    public final void j() {
        if (this.g == false) goto L13;
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r0 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L24;
        BehaviorSubject r2 = r1.a();
        if (r2 == null) goto L25;
        Disposable r3 = r2.subscribe(new a(this));
        if (r3 == null) goto L26;
        this.j.add(r3);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r4 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L29;
        BehaviorSubject r6 = r5.a();
        if (r6 == null) goto L30;
        Disposable r7 = r6.subscribe(new b(this));
        if (r7 == null) goto L31;
        this.j.add(r7);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final boolean q() {
        if (((PublicStreamClientMixStrategy) this.d.getValue()) != PublicStreamClientMixStrategy.Purpose) goto L5;
    L8:
        return true;
    L5:
        if (((PublicStreamClientMixStrategy) this.d.getValue()) == PublicStreamClientMixStrategy.Using) goto L8;
        return false;
    }

    public final void r() {
        hg6.g r0 = g(this.h);
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = tc0.c.h().k;
        ALogger.d(this.a, "livecore version " + jc1.k.n(IMiddlewareBroadcastService.class).getLiveCoreVersion());
        String r2 = this.a;
        StringBuilder r3 = new StringBuilder("stopForwardStreamCrossRoom isEngineOn: ");
        r3.append(r0.isEngineOn());
        r3.append(" isForwardCrossRoom: ");
        xi0.b r4 = r0.O();
        if (r4 == null) goto L8;
        Boolean r5 = Boolean.valueOf(r4.Y());
    L9:
        r3.append(r5);
        r3.append(" localInfo: ");
        r3.append(r1);
        ALogger.d(r2, r3.toString());
        if (r0.isEngineOn() == false) goto L20;
        xi0.b r6 = r0.O();
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.Y() != true) goto L22;
        zi0.a r7 = zi0.a.a;
        JSONObject r8 = new JSONObject();
        r8.put("rtc_ext_info", r1);
        zi0.a.a(r8);
        MultiLinkEventModule r9 = com.bytedance.android.live.liveinteract.api.utils.n.p();
        com.bytedance.android.live.liveinteract.api.utils.n.b.getClass();
        com.bytedance.android.live.liveinteract.api.utils.n.A(r9, "stop_forward_stream", r8);
        xi0.b r10 = r0.O();
        if (r10 == null) goto L18;
        r10.C(r1);
    L18:
        ALogger.d(this.a, "stopForwardStreamCrossRoom localInfo " + r1);
        return;
    L22:
        return;
    L20:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void t() {
        ALogger.w(this.a, "#PublicStreamMix# tryStartPlayPublicStream，shouldUseMcu = " + h() + ", publicStreamClientMixStrategy = " + ((PublicStreamClientMixStrategy) this.d.getValue()));
        if (h() == false) goto L53;
        int r4 = 0;
        if (((PublicStreamClientMixStrategy) this.d.getValue()) != PublicStreamClientMixStrategy.Purpose) goto L13;
        if (this.h == false) goto L13;
        this.n.v4(this.b, true);
        MultiLinkEventModule r0 = zi0.b.a;
        String r1 = this.b;
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        zi0.b.c(r1, 0, true);
        this.d.onNext(PublicStreamClientMixStrategy.Using);
    L24:
        this.c.onNext(PublicStreamPlayState.Pulling);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L27;
        f2.f("订阅公共流\n " + this.b);
    L27:
        int r2 = -1;
    L29:
        if (r4 > ((Integer) z70.a.getValue()).intValue()) goto L42;
        if (r2 == 0) goto L42;
        r2 = this.n.Po(this.b);
        MultiLinkEventModule r3 = zi0.b.a;
        String r5 = this.b;
        if (r5 != null) goto L34;
        r5 = "";
    L34:
        Intrinsics.checkNotNullParameter(r5, "streamId");
        if (zi0.b.b() == false) goto L41;
        JSONObject r8 = new JSONObject();
        zi0.c.a(r8, "stream_id", r5);
        zi0.c.a(r8, "result", Integer.valueOf(r2));
        zi0.c.a(r8, "retry_count", Integer.valueOf(r4));
        zi0.b.a(r8);
        if (r2 != 0) goto L40;
        zi0.b.e = System.currentTimeMillis();
    L40:
        nd0.c.p(nd0.c.a, LinkMonitorData.PlayPublicStream, r8, zi0.b.a, 0, null, false, null, 120);
    L41:
        r4 = r4 + 1;
    L42:
        if (r2 == 0) goto L44;
        i();
        return;
    L44:
        if (((PublicStreamClientMixStrategy) this.d.getValue()) == PublicStreamClientMixStrategy.Using) goto L51;
        SurfaceView r6 = f();
        if (r6 == null) goto L48;
        UtilityKotlinExtentionsKt.w(r6);
    L48:
        SurfaceView r7 = f();
        if (r7 == null) goto L51;
        r7.setZOrderMediaOverlay(true);
    L51:
        this.j.add(Observable.timer(((Number) y70.a.getValue()).intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).takeUntil(this.c.filter(c.a)).subscribe(new d(this)));
        return;
    L13:
        if (((Boolean) op0.a.getValue()).booleanValue() == false) goto L18;
        this.n.mk(this.b);
        MultiLinkEventModule r9 = zi0.b.a;
        String r10 = this.b;
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        zi0.b.c(r10, 0, false);
        goto L24
    L18:
        SurfaceView r11 = f();
        if (r11 == null) goto L24;
        int r12 = this.n.Aa(r11);
        MultiLinkEventModule r13 = zi0.b.a;
        String r14 = this.b;
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        zi0.b.c(r14, r12, false);
        goto L24
    L53:
        this.d.onNext(PublicStreamClientMixStrategy.None);
    }

    public final SurfaceView f() {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        return this.e;
    L7:
        if (this.g == false) goto L10;
        return this.f;
    L10:
        return this.e;
    }

    public final void k() {
        SurfaceView r0 = f();
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L10;
        com.bytedance.android.live.ui.c r2 = r1.y4();
        if (r2 == null) goto L10;
        r2.f();
    L10:
        this.j.dispose();
    }

    public final void o() {
        if (aj0.a.d() == true) goto L5;
        return;
    L5:
        s(q());
        com.bytedance.android.live.liveinteract.plantform.model.e0 r0 = tc0.c.h().s;
        if (r0 == null) goto L8;
        String r1 = r0.getRivalsStreamId();
    L9:
        this.b = r1;
        t();
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void p() {
        if (aj0.a.d() == true) goto L5;
        return;
    L5:
        r();
        this.n.kd(this.b, "stop_rtc");
        this.c.onNext(PublicStreamPlayState.End);
        ALogger.w(LinkRoomFightContext.TAG, "#PublicStreamMix# onStopRtcSuccess, publicStreamPlayStateSubject = " + ((PublicStreamPlayState) this.c.getValue()));
        SurfaceView r0 = f();
        if (r0 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r0);
        return;
    }

    public static hg6.g g(boolean r0) {
        if (r0 == false) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r1 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r1 != null) goto L11;
    L9:
        return null;
    L11:
        return r1.R1();
    L6:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r2 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r2 == null) goto L9;
        return r2.P2();
    }

    public final void l(String r14) {
        if (((Boolean) a80.a.getValue()).booleanValue() == false) goto L6;
        ALogger.d(LinkRoomFightContext.TAG, "for test, force fall back to cross room stream, no need to send public stream first frame event.");
        return;
    L6:
        MultiLinkEventModule r0 = zi0.b.a;
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        PublicStreamPlayState r2 = (PublicStreamPlayState) this.c.getValue();
        if (r2 == null) goto L12;
        String r3 = r2.name();
    L13:
        Intrinsics.checkNotNullParameter(r14, "streamId");
        if (zi0.b.b() == false) goto L21;
        JSONObject r6 = new JSONObject();
        zi0.c.a(r6, "stream_id", r14);
        zi0.c.a(r6, "duration", Long.valueOf(System.currentTimeMillis() - zi0.b.e));
        if (r3 == null) goto L19;
        zi0.c.a(r6, "public_stream_state", r3);
    L19:
        zi0.b.a(r6);
        nd0.c.p(nd0.c.a, LinkMonitorData.FirstPublicStreamAudioFrameDecoded, r6, zi0.b.a, 0, null, false, null, 120);
    L21:
        if (((Boolean) ta0.a.getValue()).booleanValue() == false) goto L28;
        if (((PublicStreamPlayState) this.c.getValue()) != PublicStreamPlayState.Fallback) goto L28;
        ALogger.e(LinkRoomFightContext.TAG, "public stream onFirstPublicStreamAudioFrame, is already fallback, won't use public stream!!");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L39;
        f2.f("公共流跳过播放");
        return;
    L39:
        return;
    L28:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L30;
        f2.f("公共流开始播放");
    L30:
        this.c.onNext(PublicStreamPlayState.Playing);
        ALogger.w(LinkRoomFightContext.TAG, "public stream onFirstPublicStreamAudioFrame, try mute remote video stream");
        List r15 = (List) this.o.h().getValue();
        if (r15 == null) goto L44;
        List r16 = r15;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L45;
        String r4 = ((ch0.e) r17.next()).a.getInteractId();
        if (r4 != null) goto L38;
        r4 = "";
    L38:
        b(r4, "room battle mcu");
        r1.add(Unit.INSTANCE);
        goto L34
    L45:
        return;
    L44:
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final void m(String r14) {
        if (((Boolean) a80.a.getValue()).booleanValue() == false) goto L6;
        ALogger.d(LinkRoomFightContext.TAG, "for test, force fall back to cross room stream, no need to send public stream first frame event.");
        return;
    L6:
        MultiLinkEventModule r0 = zi0.b.a;
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        PublicStreamPlayState r2 = (PublicStreamPlayState) this.c.getValue();
        if (r2 == null) goto L12;
        String r3 = r2.name();
    L13:
        Intrinsics.checkNotNullParameter(r14, "streamId");
        if (zi0.b.b() == false) goto L21;
        JSONObject r6 = new JSONObject();
        zi0.c.a(r6, "stream_id", r14);
        zi0.c.a(r6, "width", 0);
        zi0.c.a(r6, "height", 0);
        if (r3 == null) goto L19;
        zi0.c.a(r6, "public_stream_state", r3);
    L19:
        zi0.c.a(r6, "duration", Long.valueOf(System.currentTimeMillis() - zi0.b.e));
        zi0.b.a(r6);
        nd0.c.p(nd0.c.a, LinkMonitorData.FirstPublicStreamVideoFrameDecoded, r6, zi0.b.a, 0, null, false, null, 120);
    L21:
        if (((Boolean) ec0.a.getValue()).booleanValue() == false) goto L28;
        if (((PublicStreamPlayState) this.c.getValue()) != PublicStreamPlayState.Fallback) goto L28;
        ALogger.e(LinkRoomFightContext.TAG, "public stream onFirstPublicStreamVideoFrameDecoded, is already fallback, won't use public stream!!");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L39;
        f2.f("公共流跳过播放");
        return;
    L39:
        return;
    L28:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L30;
        f2.f("公共流开始播放");
    L30:
        this.c.onNext(PublicStreamPlayState.Playing);
        ALogger.w(LinkRoomFightContext.TAG, "public stream onFirstPublicStreamVideoFrameDecoded, try mute remote video stream");
        List r15 = (List) this.o.h().getValue();
        if (r15 == null) goto L44;
        List r16 = r15;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L45;
        String r4 = ((ch0.e) r17.next()).a.getInteractId();
        if (r4 != null) goto L38;
        r4 = "";
    L38:
        b(r4, "room battle mcu");
        r1.add(Unit.INSTANCE);
        goto L34
    L45:
        return;
    L44:
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final void s(boolean r11) {
        ALogger.d(this.a, "livecore version " + jc1.k.n(IMiddlewareBroadcastService.class).getLiveCoreVersion());
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("startForwardStreamToRooms rtcinfo ");
        v1 r2 = tc0.c.h().n;
        Integer r3 = null;
        if (r2 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.model.interact.s r4 = r2.getCrossRoomLinkmicRtcInfo();
    L6:
        r1.append(r4);
        ALogger.d(r0, r1.toString());
        hg6.g r5 = g(this.h);
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.isEngineOn() == false) goto L48;
        xi0.b r6 = r5.O();
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.Y() == true) goto L50;
        String r7 = tc0.c.h().k;
        v1 r8 = tc0.c.h().n;
        if (r8 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.model.interact.s r9 = r8.getCrossRoomLinkmicRtcInfo();
        if (r9 == null) goto L20;
        Map r10 = r9.getRtcInfoMap();
    L21:
        Map.Entry r12 = tc0.c.h().p;
        if (r12 == null) goto L24;
        Long r13 = (Long) r12.getKey();
    L25:
        if (r10 == null) goto L29;
        Map.Entry r14 = z0.a(r10);
        if (r14 == null) goto L29;
        String r15 = (String) r14.getValue();
    L30:
        ALogger.d(this.a, "startForwardStreamToRooms roomId " + r13 + " localRtc " + r7 + " remoteInfo " + r15);
        zi0.a r16 = zi0.a.a;
        if (r13 == null) goto L33;
        String r17 = String.valueOf(r13.longValue());
    L34:
        JSONObject r18 = new JSONObject();
        r18.put("to_room_id", r17);
        r18.put("rtc_ext_info", r7);
        r18.put("remote_rtc_ext_info", r15);
        zi0.a.a(r18);
        MultiLinkEventModule r19 = com.bytedance.android.live.liveinteract.api.utils.n.p();
        com.bytedance.android.live.liveinteract.api.utils.n.b.getClass();
        com.bytedance.android.live.liveinteract.api.utils.n.A(r19, "start_forward_stream", r18);
        if (r13 != null) goto L37;
        return;
    L37:
        if (r13.longValue() <= 0) goto L52;
        if (r7 == null) goto L53;
        if (r15 == null) goto L54;
        xi0.b r20 = r5.O();
        if (r20 == null) goto L43;
        r20.q();
    L43:
        xi0.b r21 = r5.O();
        if (r21 == null) goto L46;
        r3 = Integer.valueOf(r21.V(String.valueOf(r13.longValue()), r7, r15, r11));
    L46:
        ALogger.d(this.a, "startForwardStreamToRooms result " + r3);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L33:
        r17 = null;
    L29:
        r15 = null;
        goto L30
    L24:
        r13 = null;
    L20:
        r10 = null;
        goto L21
    L50:
        return;
    L48:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void u(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6) {
        Intrinsics.checkNotNullParameter(r6, "layoutConfig");
        this.i = r6;
        boolean r0 = MultiLinkLoadWidgetUtils.g();
        if (aj0.b.c(r6.getUiLayout()) == true) goto L5;
        return;
    L5:
        if (this.g == false) goto L38;
        if (r0 == true) goto L39;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7 = this.i;
        View r1 = null;
        if (r7 == null) goto L10;
        pn0.f r8 = r7.d;
    L11:
        if (r8 == null) goto L41;
        pn0.f.b r2 = r8.c;
        int r3 = r2.c;
        int r4 = r2.d;
        ViewGroup r5 = UtilityKotlinExtentionsKt.p(this.f);
        if (r5 == null) goto L16;
        r5.removeView(this.f);
    L16:
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r3 / 2, r4, 53);
        pn0.f.b r10 = r8.c;
        r9.leftMargin = r10.a;
        r9.topMargin = r10.b;
        this.f.setLayoutParams(r9);
        if (gh0.a.d() == true) goto L25;
        cg6.a r11 = this.p.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r11 == null) goto L25;
        hg6.g r12 = r11.getRtcManager();
        if (r12 == null) goto L25;
        if (r12.A() == true) goto L25;
        UtilityKotlinExtentionsKt.t(this.f);
    L25:
        com.bytedance.android.live.liveinteract.plantform.base.g r13 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r13 == null) goto L28;
        View r14 = r13.j();
    L30:
        if ((r14 instanceof ViewGroup) == false) goto L33;
        r1 = r14;
    L33:
        ViewGroup r15 = (ViewGroup) r1;
        if (r15 == null) goto L40;
        r15.addView(this.f);
        UtilityKotlinExtentionsKt.w(r15);
        return;
    L40:
        return;
    L28:
        r14 = null;
        goto L30
    L41:
        return;
    L10:
        r8 = null;
        goto L11
    L39:
        return;
    }

    public static final void a(u r6, int r7) {
        if (r7 == 16) goto L5;
    L24:
        if (r7 != 16) goto L26;
    L30:
        r6.k = r7;
        return;
    L26:
        if (r6.k != 16) goto L30;
        r6.r();
        r6.n.kd(r6.b, "layout_end");
        r6.c.onNext(PublicStreamPlayState.End);
        ALogger.w(LinkRoomFightContext.TAG, "#PublicStreamMix# wm end, publicStreamPlayStateSubject = " + ((PublicStreamPlayState) r6.c.getValue()));
        SurfaceView r0 = r6.f();
        if (r0 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r0);
        goto L30
    L5:
        if (r6.k == 16) goto L24;
        com.bytedance.android.live.liveinteract.plantform.model.e0 r1 = tc0.c.h().s;
        Boolean r2 = null;
        if (r1 == null) goto L9;
        String r3 = r1.getRivalsStreamId();
    L10:
        r6.b = r3;
        r6.j.add(RxUtilKt.h(r6.o.h()).subscribe(new v(r6)));
        com.bytedance.android.live.liveinteract.plantform.model.e0 r4 = tc0.c.h().s;
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 == null) goto L13;
        MixStreamType r8 = r5.getMixStreamType();
    L14:
        StringBuilder r9 = new StringBuilder("window manager start，should use mcu ");
        r9.append(r6.h());
        r9.append(", mcu content ");
        r9.append(r4);
        r9.append(" isAnchor ");
        r9.append(r6.h);
        r9.append(" isEngineOn ");
        hg6.g r10 = g(r6.h);
        if (r10 == null) goto L17;
        r2 = Boolean.valueOf(r10.isEngineOn());
    L17:
        r9.append(r2);
        r9.append(" currentStreamMixType ");
        r9.append(r8);
        ALogger.w(LinkRoomFightContext.TAG, r9.toString());
        MixStreamType r11 = MixStreamType.NONE;
        r6.s(r6.q());
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r12 = ILiveWrappedLivePusher.a.b();
        if (r12 == null) goto L20;
        r12.newVideoMixerDescription("INVISIABLE");
    L20:
        SurfaceView r13 = r6.f();
        if (r13 == null) goto L23;
        UtilityKotlinExtentionsKt.t(r13);
    L23:
        r6.t();
        r6.j.add(r6.c.subscribe(new w(r6)));
        goto L30
    L13:
        r8 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    }

    public final void b(String r6, String r7) {
        if (((PublicStreamPlayState) this.c.getValue()) != PublicStreamPlayState.Playing) goto L6;
        this.n.r1(r6, true);
        this.n.h(r6, true, "room battle mcu");
        return;
    L6:
        if (((Boolean) un0.a.getValue()).booleanValue() == false) goto L8;
        this.n.r1(r6, false);
    L8:
        Map.Entry r0 = tc0.c.h().p;
        if (r0 == null) goto L15;
        g2 r1 = (g2) r0.getValue();
        if (r1 == null) goto L15;
        if (r1.getRoomLinkSilenceStatus() != 1) goto L15;
        boolean r2 = true;
    L16:
        StringBuilder r3 = new StringBuilder("remoteSilence ");
        r3.append(r2);
        r3.append(" user ");
        r3.append(r6);
        r3.append(" silence state ");
        kg6.e r4 = c();
        if (r4 == null) goto L19;
        Boolean r5 = Boolean.valueOf(r4.x(r6));
    L20:
        r3.append(r5);
        r3.append(" reason ");
        r3.append(r7);
        ALogger.w(LinkRoomFightContext.TAG, r3.toString());
        if (r2 == false) goto L29;
        kg6.e r8 = c();
        if (r8 == null) goto L29;
        if (r8.x(r6) == true) goto L29;
        kg6.e r9 = c();
        if (r9 == null) goto L29;
        r9.h(r6, true, "room battle cross silence");
    L29:
        if (r2 == true) goto L39;
        kg6.e r10 = c();
        if (r10 != null) goto L33;
        return;
    L33:
        if (r10.x(r6) != true) goto L41;
        kg6.e r11 = c();
        if (r11 == null) goto L42;
        r11.h(r6, false, "room battle cross silence");
        return;
    L42:
        return;
    L41:
        return;
    L39:
        return;
    L19:
        r5 = null;
    L15:
        r2 = false;
        goto L16
    }

    public final void n(String r11, int r12) {
        MultiLinkEventModule r0 = zi0.b.a;
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        Intrinsics.checkNotNullParameter(r11, "streamId");
        if (zi0.b.b() == false) goto L9;
        JSONObject r3 = new JSONObject();
        zi0.c.a(r3, "stream_id", r11);
        zi0.c.a(r3, "duration", Long.valueOf(System.currentTimeMillis() - zi0.b.e));
        zi0.b.a(r3);
        nd0.c.p(nd0.c.a, LinkMonitorData.PlayPublicStreamResult, r3, zi0.b.a, r12, null, false, null, 112);
    L9:
        fc0 r13 = fc0.a;
        if (((List) r13.getValue()).contains(String.valueOf(r12)) == false) goto L12;
        ALogger.i(LinkRoomFightContext.TAG, "on play public stream success.");
        return;
    L12:
        ALogger.e(LinkRoomFightContext.TAG, "on play public stream failed. errorCode: " + r12 + ", code: " + ((List) r13.getValue()));
        i();
    }

    public u(Context r2, DataCenter r3, ConstraintLayout r4, IRoom r5, tf0.o.a r6, eh0.b r7, j1 r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r6, "callBack");
        Intrinsics.checkNotNullParameter(r7, "linkRoomFightDataMergeCenter");
        Intrinsics.checkNotNullParameter(r8, "scopeProvider");
        this.l = r3;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        this.p = r8;
        this.a = LinkRoomFightContext.TAG;
        com.bytedance.android.live.liveinteract.plantform.model.e0 r9 = tc0.c.h().s;
        if (r9 == null) goto L5;
        String r10 = r9.getRivalsStreamId();
    L6:
        this.b = r10;
        this.c = BehaviorSubject.createDefault(PublicStreamPlayState.None);
        this.d = BehaviorSubject.createDefault(PublicStreamClientMixStrategy.None);
        this.e = (SurfaceView) r4.findViewById(2131383418);
        this.f = new SurfaceView(r2);
        this.g = r5.isLiveTypeAudio();
        this.h = gh0.a.d();
        this.j = new CompositeDisposable();
        if (((Boolean) cc0.a.getValue()).booleanValue() == false) goto L9;
        int r11 = 0;
    L10:
        this.k = r11;
        return;
    L9:
        r11 = je0.d.f();
        goto L10
    L5:
        r10 = null;
        goto L6
    }
}
