package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.config.am0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements com.bytedance.android.live.liveinteract.plantform.core.k {
    public final /* synthetic */ ConcertMultiLinkWindowManager a;

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r1, boolean[] r2, int[] r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, s0 r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r1, long r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r1, long r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h6(int r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void ip(Object r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void k1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public t(ConcertMultiLinkWindowManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r2, "s");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r1, z.a r2) {
        if (((Boolean) this.a.Y.getValue()).booleanValue() == false) goto L5;
        ConcertMultiLinkWindowManager.q1(this.a);
    L5:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] onFirstRemoteVideoFrameRender");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r2, dg2.e[] r3) {
        Intrinsics.checkNotNullParameter(r2, "localQuality");
        Intrinsics.checkNotNullParameter(r3, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r1, z.a r2, int r3, int r4) {
        if (((Boolean) this.a.Y.getValue()).booleanValue() == true) goto L6;
        ConcertMultiLinkWindowManager.q1(this.a);
    L8:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] onFirstRemoteVideoFrame");
        return;
    L6:
        if (((Boolean) am0.a.getValue()).booleanValue() == false) goto L8;
        ConcertMultiLinkWindowManager.q1(this.a);
        goto L8
    }
}
