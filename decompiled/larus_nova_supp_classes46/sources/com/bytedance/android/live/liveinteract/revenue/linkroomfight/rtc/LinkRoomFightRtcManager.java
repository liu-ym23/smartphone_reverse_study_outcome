package com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.core.k;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import hg6.g;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti6.d;
import uf2.m1;
import uf2.x;
import vm2.e;
import yf2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkRoomFightRtcManager implements xi0.b {
    public static final /* synthetic */ int i = 0;
    public long a;
    public boolean b;
    public MixStreamType c;
    public final CopyOnWriteArraySet<k> d;
    public x e;
    public Boolean f;
    public final g g;
    public final tc0.b h;

    public static final class a {
    }

    static {
    }

    @Override // xi0.b
    public final void N() {
        g r0 = this.g;
        if (r0 == null) goto L9;
        ei6.a r1 = r0.V0();
        if (r1 == null) goto L9;
        fi6.a r2 = r1.g();
        if (r2 == null) goto L9;
        MixStreamType r3 = r2.U;
    L10:
        MixStreamType r4 = MixStreamType.SERVER_MIX;
        zi0.a r5 = zi0.a.a;
        JSONObject r6 = new JSONObject();
        r6.put("from_type", r3);
        r6.put("to_type", r4);
        zi0.a.a(r6);
        zi0.a.e(r5, "switch_mix_type", r6);
        if (r3 == r4) goto L20;
        jy0.b.c(LinkRoomFightContext.TAG, "now is " + r3 + ", try switch to server mix，one way switch!!", null, 4);
        g r7 = this.g;
        if (r7 == null) goto L21;
        ei6.a r8 = r7.V0();
        if (r8 == null) goto L22;
        d r9 = r8.p();
        if (r9 == null) goto L23;
        r9.m(r4);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void a() {
        if (((Boolean) e.G.getValue(null, e.a[31])).booleanValue() == true) goto L5;
        return;
    L5:
        g r0 = this.g;
        if (r0 == null) goto L12;
        ei6.a r1 = r0.V0();
        if (r1 == null) goto L12;
        fi6.a r2 = r1.g();
        if (r2 == null) goto L12;
        MixStreamType r3 = r2.U;
    L13:
        MixStreamType r4 = this.c;
        zi0.a r5 = zi0.a.a;
        JSONObject r6 = new JSONObject();
        r6.put("from_type", r3);
        r6.put("to_type", r4);
        zi0.a.a(r6);
        zi0.a.e(r5, "switch_mix_type", r6);
        jy0.b.d(LinkRoomFightContext.TAG, "#PublicStreamMix# tryRecoverMixType current mix type is " + r3 + ", before link room fight is " + this.c);
        MixStreamType r7 = this.c;
        if (r3 == r7) goto L27;
        if (r7 == null) goto L28;
        jy0.b.c(LinkRoomFightContext.TAG, "current mix type is " + r3 + ", before link room fight is " + this.c + ", recover to it", null, 4);
        MixStreamType r8 = this.c;
        if (r8 == null) goto L29;
        g r9 = this.g;
        if (r9 == null) goto L25;
        ei6.a r10 = r9.V0();
        if (r10 == null) goto L25;
        d r11 = r10.p();
        if (r11 == null) goto L25;
        r11.m(r8);
    L25:
        this.c = null;
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L12:
        r3 = null;
        goto L13
    }

    @Override // xi0.b
    public final void h() {
        this.d.clear();
    }

    @Override // xi0.b
    public final void q() {
        yb6.e r1 = null;
        zi0.a.a.d(null);
        InteractLinkFullLinkMonitor.g0(null);
        g r0 = this.g;
        if (r0 == null) goto L5;
        r1 = r0.j();
    L5:
        if (r1 != null) goto L7;
        InteractLinkFullLinkMonitor.m0("stopForwardStreamToRooms");
    L7:
        g r2 = this.g;
        if (r2 == null) goto L12;
        yb6.e r3 = r2.j();
        if (r3 == null) goto L12;
        r3.q();
    L12:
        a();
    }

    @Override // xi0.b
    public final boolean Y() {
        return this.b;
    }

    @Override // xi0.b
    public final void C(String r4) {
        if (r4 != null) goto L5;
        zi0.a.a.d(r4);
        InteractLinkFullLinkMonitor.g0(r4);
    L6:
        if (r4 != null) goto L9;
        jy0.b.c(LinkRoomFightContext.TAG, "stopForward error, localRtcInfo " + r4, null, 4);
        return;
    L9:
        g r0 = this.g;
        if (r0 == null) goto L14;
        yb6.e r1 = r0.j();
        if (r1 == null) goto L14;
        r1.c(r4);
    L14:
        g r5 = this.g;
        if (r5 == null) goto L19;
        yb6.e r6 = r5.j();
        if (r6 == null) goto L19;
        r6.q();
    L19:
        a();
        return;
    L5:
        zi0.a.a.d(null);
        InteractLinkFullLinkMonitor.g0("");
        goto L6
    }

    @Override // xi0.b
    public final int k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "publicStreamId");
        n1(false);
        g r0 = this.g;
        if (r0 == null) goto L7;
        yb6.e r1 = r0.j();
        if (r1 == null) goto L7;
        return r1.k(r2);
    L7:
        return -1;
    }

    @Override // xi0.b
    public final int l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "publicStreamId");
        g r0 = this.g;
        if (r0 == null) goto L7;
        yb6.e r1 = r0.j();
        if (r1 == null) goto L7;
        return r1.l(r2);
    L7:
        return -1;
    }

    @Override // xi0.b
    public final void n1(boolean r5) {
        if (this.e == null) goto L19;
        jy0.b.f(LinkRoomFightContext.TAG, "#PublicStreamMix# recoverMixer lastLiveCoreMixStatus = " + this.f + ", invalidSei = " + r5 + ", stackTrace = " + ExceptionsKt.stackTraceToString(new Throwable()), null, 4);
        x r0 = this.e;
        if (r0 == null) goto L7;
        r0.release();
    L7:
        this.e = null;
        if (Intrinsics.areEqual(this.f, Boolean.FALSE) == false) goto L14;
        g r1 = this.g;
        if (r1 == null) goto L14;
        pf6.a r2 = r1.f0();
        if (r2 == null) goto L14;
        r2.t(false);
    L14:
        if (r5 == false) goto L20;
        N();
        g r6 = this.g;
        if (r6 == null) goto L21;
        r6.f();
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // xi0.b
    public final void p(k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.add(r2);
    }

    public LinkRoomFightRtcManager(g r2, tc0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcManager");
        Intrinsics.checkNotNullParameter(r3, "linkInRoomDataHolder");
        this.g = r2;
        this.h = r3;
        this.d = new CopyOnWriteArraySet();
        if (r2 == null) goto L5;
        r2.G(new com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc.a(this));
    L5:
        if (r2 == null) goto L8;
        r2.B(new b(this));
        return;
    }

    @Override // xi0.b
    public final int b0(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "publicStreamId");
        Intrinsics.checkNotNullParameter(r6, "view");
        Function0<g> r2 = new LinkRoomFightRtcManager$setPublicStreamVideoCanvas$1(this);
        Intrinsics.checkNotNullParameter(r2, "rtcManagerGetter");
        Intrinsics.checkNotNullParameter(r5, "publicStreamId");
        Intrinsics.checkNotNullParameter(r6, "view");
        g r0 = (g) r2.invoke();
        if (r0 != null) goto L5;
        return -2;
    L5:
        f r1 = new f();
        if ((r6 instanceof View) == true) goto L8;
        r6 = null;
    L8:
        r1.a = (View) r6;
        r1.c = 2;
        ei6.a r7 = r0.V0();
        if (r7 == null) goto L13;
        ui6.c r8 = r7.o();
        if (r8 == null) goto L13;
        r8.b(r5, r1);
        return 0;
    L13:
        return -1;
    }

    @Override // xi0.b
    public final void v4(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "publicStreamId");
        Boolean r1 = null;
        if (r7 == false) goto L17;
        g r2 = this.g;
        if (r2 == null) goto L9;
        pf6.a r3 = r2.f0();
        if (r3 == null) goto L9;
        x r4 = r3.b();
    L10:
        this.e = r4;
        g r5 = this.g;
        if (r5 == null) goto L15;
        pf6.a r8 = r5.f0();
        if (r8 == null) goto L15;
        Boolean r9 = Boolean.valueOf(r8.a());
    L16:
        this.f = r9;
    L15:
        r9 = null;
    L9:
        r4 = null;
    L17:
        Function0<g> r10 = new LinkRoomFightRtcManager$setPublicStreamVideoSink$1(this);
        Function0<x> r11 = new LinkRoomFightRtcManager$setPublicStreamVideoSink$2(this);
        Intrinsics.checkNotNullParameter(r10, "rtcManagerGetter");
        Intrinsics.checkNotNullParameter(r11, "mcuInputStreamGetter");
        Intrinsics.checkNotNullParameter(r6, "publicStreamId");
        g r0 = (g) r10.invoke();
        if (r0 == null) goto L50;
        x r12 = (x) r11.invoke();
        pf6.a r13 = r0.f0();
        if (r13 == null) goto L23;
        r13.B(r6);
    L23:
        if (r7 == false) goto L42;
        m1.b.a.getClass();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r14 = ILiveWrappedLivePusher.a.b();
        if (r14 == null) goto L27;
        m1.b r15 = r14.newVideoMixerDescription("RIGHT_HALF");
    L28:
        if (r15 == null) goto L30;
        r15.b();
        r15.h();
        r15.i();
        r15.a();
        r15.g();
    L30:
        if (r12 == null) goto L32;
        r12.o();
    L32:
        if (r12 == null) goto L34;
        r12.start();
    L34:
        pf6.a r16 = r0.f0();
        if (r16 == null) goto L37;
        r1 = Boolean.valueOf(r16.a());
    L37:
        ALogger.w(LinkRoomFightContext.TAG, "#PublicStreamMix# try enableMixer lastLiveCoreMixStatus = " + r1 + ", liveStreamWrapper = " + r0.f0());
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L42;
        pf6.a r17 = r0.f0();
        if (r17 == null) goto L42;
        r17.t(true);
        goto L42
    L27:
        r15 = null;
    L42:
        c r18 = new c(r7, r12);
        ei6.a r19 = r0.V0();
        if (r19 == null) goto L48;
        ui6.c r20 = r19.o();
        if (r20 == null) goto L49;
        fg2.b r21 = new fg2.b();
        r21.a(LiveWrappedVideoPixelFormat.I420);
        Unit r22 = Unit.INSTANCE;
        r20.c(r6, r18, r21);
        return;
    L49:
        return;
    L48:
        return;
    }

    @Override // xi0.b
    public final int V(String r9, String r10, String r11, boolean r12) {
        zi0.a r0 = zi0.a.a;
        r0.c(r9, r10, r11);
        InteractLinkFullLinkMonitor.Z(r9, r10, r11);
        InteractLinkFullLinkMonitor.Z(r9, r10, r11);
        i97.a r1 = i97.a.a;
        this.a = System.currentTimeMillis();
        if (r9 == null) goto L54;
        StringBuilder r5 = new StringBuilder("#PublicStreamMix# trySwitchMixType, now mixType is ");
        g r6 = this.g;
        if (r6 == null) goto L11;
        ei6.a r7 = r6.V0();
        if (r7 == null) goto L11;
        fi6.a r8 = r7.g();
        if (r8 == null) goto L11;
        MixStreamType r13 = r8.U;
    L12:
        r5.append(r13);
        r5.append(", purposeMcuClientMix = ");
        r5.append(r12);
        jy0.b.f(LinkRoomFightContext.TAG, r5.toString(), null, 4);
        if (r12 == false) goto L24;
        g r14 = this.g;
        if (r14 == null) goto L21;
        ei6.a r15 = r14.V0();
        if (r15 == null) goto L21;
        fi6.a r16 = r15.g();
        if (r16 == null) goto L21;
        MixStreamType r17 = r16.U;
    L22:
        this.c = r17;
        jy0.b.f(LinkRoomFightContext.TAG, "#PublicStreamMix# purpose to use mcu client mix, no need to switch to server mix.", null, 4);
    L43:
        List r18 = CollectionsKt.mutableListOf(new ui6.a[]{new ui6.a(r9, r11)});
        g r19 = this.g;
        if (r19 == null) goto L48;
        yb6.e r110 = r19.j();
        if (r110 == null) goto L48;
        r110.c(r10);
    L48:
        g r111 = this.g;
        if (r111 == null) goto L56;
        yb6.e r112 = r111.j();
        if (r112 != null) goto L53;
        return -1;
    L53:
        return r112.W(r18);
    L56:
        return -1;
    L21:
        r17 = null;
        goto L22
    L24:
        if (((Boolean) e.G.getValue(null, e.a[31])).booleanValue() == false) goto L43;
        g r113 = this.g;
        if (r113 == null) goto L33;
        ei6.a r114 = r113.V0();
        if (r114 == null) goto L33;
        fi6.a r115 = r114.g();
        if (r115 == null) goto L33;
        MixStreamType r116 = r115.U;
    L34:
        this.c = r116;
        MixStreamType r20 = MixStreamType.SERVER_MIX;
        JSONObject r21 = new JSONObject();
        r21.put("from_type", r116);
        r21.put("to_type", r20);
        zi0.a.a(r21);
        zi0.a.e(r0, "switch_mix_type", r21);
        if (this.c == r20) goto L43;
        jy0.b.c(LinkRoomFightContext.TAG, "now is " + this.c + ", try switch to server mix", null, 4);
        g r117 = this.g;
        if (r117 == null) goto L43;
        ei6.a r118 = r117.V0();
        if (r118 == null) goto L43;
        d r119 = r118.p();
        if (r119 == null) goto L43;
        r119.m(r20);
    L33:
        r116 = null;
    L11:
        r13 = null;
        goto L12
    L54:
        jy0.b.c(LinkRoomFightContext.TAG, "startForward error, roomId " + r9 + " localRtcInfo " + r10 + " remoteRtcInfo " + r11, null, 4);
        return -1;
    }
}
