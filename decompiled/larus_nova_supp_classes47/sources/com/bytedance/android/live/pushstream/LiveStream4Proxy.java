package com.bytedance.android.live.pushstream;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.broadcast.api.framework.common.LiveAVResourceIntent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveAVResourceRole;
import com.bytedance.android.live.broadcast.api.framework.common.LiveAVResourceType;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.broadcast.api.framework.service.ILiveAVResourceService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.chatroom.utils.b4;
import fr2.q0;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.b1;
import uf2.d0;
import uf2.h0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveStream4Proxy implements d {
    public final LiveStream4 a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final d0 A() {
        return this.a.h;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final z C() {
        return this.a.C();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void D() {
        this.a.D();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void E0() {
        this.a.E0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void G0() {
        this.a.G0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void I() {
        this.a.I();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void J() {
        this.a.J();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void L() {
        this.a.L();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void M() {
        this.a.M();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean N() {
        return this.a.z;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void N0() {
        this.a.N0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final int T0() {
        return this.a.r;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final ei6.a V0() {
        return this.a.i;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final int W0() {
        return this.a.q;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final uf2.x b() {
        return this.a.b();
    }

    @Override // com.bytedance.android.live.pushstream.f
    public final nv0.c c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.live.pushstream.f
    public final void d() {
        this.a.d();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void d1() {
        this.a.d1();
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final nc1.a e() {
        return this.a.e();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final JSONObject getClientInfo() {
        this.a.getClass();
        return new JSONObject();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final Map<String, String> getFpsInfo() {
        return this.a.getFpsInfo();
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final Map<String, String> getLastAudioCaptureLogMap() {
        return this.a.C;
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final Map<String, String> getLastVideoCaptureLogMap() {
        return this.a.D;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final d0 getLiveCore() {
        return this.a.h;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final b.C0058b getStatus() {
        return this.a.a;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final View getSurfaceView() {
        return this.a.y;
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void j0() {
        this.a.j0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final String j1() {
        return this.a.t;
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void l0() {
        this.a.l0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void r1() {
        this.a.r1();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void release() {
        this.a.release();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void s() {
        this.a.s();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final b.a s1() {
        return this.a.b;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean t0() {
        return this.a.m;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void u() {
        this.a.u();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean u1() {
        return this.a.u1();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean w0() {
        return this.a.w0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void x0() {
        this.a.x0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final d0.a y0() {
        return this.a.y0();
    }

    public LiveStream4Proxy(LiveStream4 r2) {
        Intrinsics.checkNotNullParameter(r2, "realLiveStream4");
        this.a = r2;
    }

    public static LiveAVResourceRole g(LiveRequestSourceRole r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toLiveAVResourceRole");
        int r2 = t.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return LiveAVResourceRole.RoomState;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return LiveAVResourceRole.Business;
    L13:
        return LiveAVResourceRole.User;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void A0(String r2) {
        this.a.A0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void B(String r2) {
        this.a.B(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void C0(uv0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "stop(request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.ALL, LiveAVResourceIntent.CloseAllCapture, g(r10.a), r10.b, r10.c)) != true) goto L12;
        this.a.o();
        return;
    L12:
        return;
    L10:
        StringBuilder r12 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$stop$1.INSTANCE);
        r12.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r12.toString());
        this.a.o();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void D0(h0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.D0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void I0(h0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.I0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void K0(View r2) {
        this.a.K0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void L0(h0.b r2) {
        this.a.c = r2;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void O(boolean r2) {
        this.a.O(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void S0(h0.e r2) {
        this.a.S0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void U0(uv0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "startVideoCapture(request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.VIDEO, LiveAVResourceIntent.StartCapture, g(r10.a), r10.b, r10.c)) != true) goto L12;
        this.a.n();
        return;
    L12:
        return;
    L10:
        StringBuilder r12 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$startVideoCapture$1.INSTANCE);
        r12.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r12.toString());
        this.a.n();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void Y0(int r2) {
        this.a.Y0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void a1(float r2) {
        this.a.a1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void b1(String r2) {
        this.a.b1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void e1(h0.b r2) {
        this.a.e1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final void f(RadioWidget.e r2) {
        this.a.f(r2);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void f0(boolean r3) {
        this.a.k0(r3, null, null);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void g0(boolean r2) {
        this.a.g0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final ei6.a g1(fi6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return this.a.g1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void h0(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.a.b r2) {
        this.a.h0(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void h1(h0.c r2) {
        this.a.h1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void i1(uv0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "switchVideoCapture(request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L13;
        if (r2 == null) goto L13;
        Map<String, Object> r0 = MapsKt.emptyMap();
        Map<String, Object> r3 = r10.c;
        if (r3 == null) goto L9;
        r0 = r3;
    L9:
        LiveAVResourceType r4 = LiveAVResourceType.VIDEO;
        LiveAVResourceIntent r5 = LiveAVResourceIntent.SwitchAVPushSource;
        LiveAVResourceRole r6 = g(r10.a);
        String r7 = r10.b;
        Map r8 = MapsKt.toMutableMap(r0);
        r8.put("video_capture_mode", 1);
        Unit r9 = Unit.INSTANCE;
        if (r2.requestAVResourceChange(new zz.a(r4, r5, r6, r7, r8)) != true) goto L15;
        this.a.r();
        return;
    L15:
        return;
    L13:
        StringBuilder r12 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$switchVideoCapture$1.INSTANCE);
        r12.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r12.toString());
        this.a.r();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void k1(uv0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "stopVideoCapture(request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.VIDEO, LiveAVResourceIntent.StopCapture, g(r10.a), r10.b, r10.c)) != true) goto L12;
        this.a.q();
        return;
    L12:
        return;
    L10:
        StringBuilder r12 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$stopVideoCapture$1.INSTANCE);
        r12.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r12.toString());
        this.a.q();
    }

    @Override // com.bytedance.android.live.pushstream.b
    @Deprecated(message = "视频相关的设置一定不要走这个方法")
    public final void l1(b1 r2) {
        this.a.l1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void m1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "streamControlMessage");
        this.a.m1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void n1(int r2) {
        this.a.n1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void o1(q0 r2) {
        this.a.o1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void p1(float r3) {
        Intrinsics.checkNotNullParameter("perf on freeze", "reason");
        this.a.p1(r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void startZoom(float r2) {
        this.a.startZoom(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void t(boolean r2) {
        this.a.t(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void t1(boolean r2) {
        this.a.t1(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void v1(RtcManager.g r2) {
        this.a.e = r2;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void y(String r2) {
        this.a.y(r2);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void B0(String r12, uv0.a r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "start(url, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        boolean r3 = true;
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.ALL, LiveAVResourceIntent.StartPush, g(r13.a), r13.b, r13.c)) != true) goto L16;
        this.a.k(r12);
        return;
    L16:
        return;
    L10:
        StringBuilder r14 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        if (r2 == null) goto L14;
        r3 = false;
    L14:
        r14.append(r3);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r14.toString());
        this.a.k(r12);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void F0(Bundle r2, com.bytedance.android.live.broadcastgame.opengame.service.g r3) {
        this.a.F0(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void H0(String r2, sk0.a.a r3) {
        this.a.H0(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void J0(String r10, uv0.a r12) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r12, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "pause(reason, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.ALL, LiveAVResourceIntent.StopCapture, g(r12.a), r12.b, r12.c)) != true) goto L12;
        this.a.g(r10);
        return;
    L12:
        return;
    L10:
        StringBuilder r13 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$pause$1.INSTANCE);
        r13.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r13.toString());
        this.a.g(r10);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void M0(String r10, uv0.a r12) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r12, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "startAudioCapture(reason, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.AUDIO, LiveAVResourceIntent.StartCapture, g(r12.a), r12.b, r12.c)) != true) goto L12;
        this.a.m(r10);
        return;
    L12:
        return;
    L10:
        StringBuilder r13 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$startAudioCapture$1.INSTANCE);
        r13.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r13.toString());
        this.a.m(r10);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void O0(com.bytedance.android.live.broadcast.api.camera.b r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "dirtyDetectCallBack");
        Intrinsics.checkNotNullParameter(r3, "modlPath");
        this.a.O0(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void P0(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a.P0(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void X0(List<String> r12, uv0.a r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "start(urlList, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        List<String> r3 = null;
        if (r1 == false) goto L13;
        if (r2 == null) goto L13;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.ALL, LiveAVResourceIntent.StartPush, g(r13.a), r13.b, r13.c)) != true) goto L18;
        LiveStream4 r14 = this.a;
        if (r12 == null) goto L11;
        r3 = CollectionsKt.toMutableList(r12);
    L11:
        r14.l(r3);
        return;
    L18:
        return;
    L13:
        StringBuilder r15 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$start$1.INSTANCE);
        r15.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r15.toString());
        LiveStream4 r16 = this.a;
        if (r12 == null) goto L16;
        r3 = CollectionsKt.toMutableList(r12);
    L16:
        r16.l(r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void Z0(int r10, uv0.a r12) {
        Intrinsics.checkNotNullParameter(r12, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "switchVideoCapture(videoCaptureDevice, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L13;
        if (r2 == null) goto L13;
        Map<String, Object> r0 = MapsKt.emptyMap();
        Map<String, Object> r3 = r12.c;
        if (r3 == null) goto L9;
        r0 = r3;
    L9:
        LiveAVResourceType r4 = LiveAVResourceType.VIDEO;
        LiveAVResourceIntent r5 = LiveAVResourceIntent.SwitchAVPushSource;
        LiveAVResourceRole r6 = g(r12.a);
        String r7 = r12.b;
        Map r8 = MapsKt.toMutableMap(r0);
        r8.put("video_capture_mode", Integer.valueOf(r10));
        Unit r13 = Unit.INSTANCE;
        if (r2.requestAVResourceChange(new zz.a(r4, r5, r6, r7, r8)) != true) goto L15;
        this.a.v(r10);
        return;
    L15:
        return;
    L13:
        StringBuilder r14 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$switchVideoCapture$3.INSTANCE);
        r14.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r14.toString());
        this.a.v(r10);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void e0(String r2, String r3) {
        this.a.e0(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void f1(String r10, uv0.a r12) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r12, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "stopAudioCapture(reason, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.AUDIO, LiveAVResourceIntent.StopCapture, g(r12.a), r12.b, r12.c)) != true) goto L12;
        this.a.p(r10);
        return;
    L12:
        return;
    L10:
        StringBuilder r13 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$stopAudioCapture$1.INSTANCE);
        r13.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r13.toString());
        this.a.p(r10);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void q1(String r10, uv0.a r12) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r12, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "resume(reason, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L10;
        if (r2 == null) goto L10;
        if (r2.requestAVResourceChange(new zz.a(LiveAVResourceType.ALL, LiveAVResourceIntent.StartCapture, g(r12.a), r12.b, r12.c)) != true) goto L12;
        this.a.h(r10);
        return;
    L12:
        return;
    L10:
        StringBuilder r13 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$resume$1.INSTANCE);
        r13.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r13.toString());
        this.a.h(r10);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void z0(int r2, int r3) {
        this.a.z0(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void Q0(boolean r10, String r12, uv0.a r13) {
        Intrinsics.checkNotNullParameter(r12, "reason");
        Intrinsics.checkNotNullParameter(r13, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "setAudioMute(mute, reason, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L13;
        if (r2 == null) goto L13;
        if (r10 == false) goto L8;
        LiveAVResourceIntent r0 = LiveAVResourceIntent.SetAudioMute;
    L9:
        LiveAVResourceType r4 = LiveAVResourceType.AUDIO;
        if (r2.requestAVResourceChange(new zz.a(r4, r0, g(r13.a), r13.b, r13.c)) != true) goto L15;
        this.a.i(r10, r12);
        return;
    L15:
        return;
    L8:
        r0 = LiveAVResourceIntent.ResumeAudioMute;
    L13:
        StringBuilder r14 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$setAudioMute$1.INSTANCE);
        r14.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r14.toString());
        this.a.i(r10, r12);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void R0(boolean r10, String r12, uv0.a r13) {
        Intrinsics.checkNotNullParameter(r12, "reason");
        Intrinsics.checkNotNullParameter(r13, "request");
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", "setAudioMuteRaw(mute, reason, request)");
        boolean r1 = LiveRoomStatesAndAVResourceUtils.b();
        ILiveAVResourceService r2 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r1 == false) goto L13;
        if (r2 == null) goto L13;
        if (r10 == false) goto L8;
        LiveAVResourceIntent r0 = LiveAVResourceIntent.SetAudioMute;
    L9:
        LiveAVResourceType r4 = LiveAVResourceType.AUDIO;
        if (r2.requestAVResourceChange(new zz.a(r4, r0, g(r13.a), r13.b, r13.c)) != true) goto L15;
        this.a.j(r10, r12);
        return;
    L15:
        return;
    L8:
        r0 = LiveAVResourceIntent.ResumeAudioMute;
    L13:
        StringBuilder r14 = new StringBuilder("API proxy disabled, enter rollback, liveAVResourceService ");
        b4.a(r2, LiveStream4Proxy$setAudioMuteRaw$1.INSTANCE);
        r14.append(r2);
        ALogger.i("ttlive_anchor_live_stream_LiveStream4Proxy", r14.toString());
        this.a.j(r10, r12);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void i0(int r2, int r3, String r4) {
        this.a.i0(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void k0(boolean r2, Pair<Integer, Integer> r3, Boolean r4) {
        this.a.k0(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void m0(uf2.p.c r2, uf2.p.b r3, uf2.p.a r4) {
        this.a.m0(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final int c1(String r8, Object r9, int r10, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "key");
        return this.a.c1(r8, r9, r10, r12, r13);
    }
}
