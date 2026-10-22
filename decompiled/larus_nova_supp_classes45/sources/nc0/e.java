package nc0;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import hh1.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements gy.f {
    public final Map<gy.d, com.bytedance.android.live.revenuelink.rtc.g> a;
    public final com.bytedance.android.live.revenuelink.rtc.i b;

    @Override // gy.f
    public final boolean F() {
        return this.b.F();
    }

    @Override // gy.f
    public final boolean G() {
        return this.b.G();
    }

    @Override // gy.f
    public final void K() {
        this.b.K();
    }

    @Override // gy.f
    public final s L() {
        return new s(this.b.L());
    }

    @Override // gy.f
    public final List<ui6.a> L0() {
        List r0 = this.b.L0();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Object r3 = ((vc0.a) r2.next()).a;
        if (r3 == null) goto L9;
        r1.add((ui6.a) r3);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.livelink.kmp.api.core.rtc.ForwardRoomInfo");
    L10:
        return r1;
    }

    @Override // gy.f
    public final String O() {
        return this.b.O();
    }

    @Override // gy.f
    public final com.bytedance.android.live.revenuelink.e P() {
        return this.b.P();
    }

    @Override // gy.f
    public final String c0() {
        return this.b.c0();
    }

    @Override // gy.f
    public final void f() {
        this.b.f();
    }

    @Override // gy.f
    public final String f0() {
        return this.b.f0();
    }

    @Override // gy.f
    public final boolean g0() {
        return this.b.g0();
    }

    @Override // gy.f
    public final d0 getLiveCore() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        Object r1 = null;
        if (r0 == null) goto L9;
        vc0.a r2 = this.b.getLiveCore();
        if (r2 == null) goto L8;
        r1 = r2.a;
    L8:
        return r0.buildLiveCore(r1);
    L9:
        return null;
    }

    @Override // gy.f
    public final boolean isEngineOn() {
        return this.b.isEngineOn();
    }

    @Override // gy.f
    public final void n() {
        this.b.n();
    }

    @Override // gy.f
    public final void o() {
        this.b.o();
    }

    @Override // gy.f
    public final void onPause() {
        this.b.onPause();
    }

    @Override // gy.f
    public final void onResume() {
        this.b.onResume();
    }

    public e(com.bytedance.android.live.revenuelink.rtc.i r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.b = r2;
        this.a = new HashMap();
    }

    @Override // gy.f
    public final void J(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.b.J(r2);
    }

    @Override // gy.f
    public final void a(InteractMode r4) {
        Intrinsics.checkNotNullParameter(r4, "interactMode");
        this.b.v1(new vc0.a(r4), 17, 19);
    }

    @Override // gy.f
    public final Integer b(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "rtcInfoMap");
        Intrinsics.checkNotNullParameter("multiLinkRtcStartSuccess", "reqFrom");
        return this.b.c1(r4, "multiLinkRtcStartSuccess", "");
    }

    @Override // gy.f
    public final void d(f92.c r3) {
        Intrinsics.checkNotNullParameter(r3, "streamMixer");
        this.b.I1(new vc0.a(r3));
    }

    @Override // gy.f
    public final void e(gy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.live.revenuelink.rtc.g r3 = (com.bytedance.android.live.revenuelink.rtc.g) ((HashMap) this.a).remove(r2);
        if (r3 == null) goto L6;
        this.b.i1(r3);
        return;
    }

    @Override // gy.f
    public final void j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reqSrc");
        this.b.T1(r3, false);
    }

    @Override // gy.f
    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "waterMarkId");
        this.b.k(r2);
    }

    @Override // gy.f
    public final void l(long r3) {
        this.b.H1(r3, "");
    }

    @Override // gy.f
    public final void m(gy.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (((HashMap) this.a).containsKey(r3) == false) goto L5;
        return;
    L5:
        d r0 = new d(r3);
        this.b.g1(r0);
        ((HashMap) this.a).put(r3, r0);
    }

    @Override // gy.f
    public final void muteLocalVideo(boolean r2) {
        this.b.muteLocalVideo(r2);
    }

    @Override // gy.f
    public final void u1(boolean r3) {
        this.b.y1(r3, "");
    }

    @Override // gy.f
    public final void Q(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "src");
        this.b.Q(r2, r3);
    }

    @Override // gy.f
    public final void T(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "src");
        this.b.T(r2, r3);
    }

    @Override // gy.f
    public final Integer g(Map<Long, String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        return this.b.a1(r3, r4, "");
    }

    @Override // gy.f
    public final void h(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r4, "reason");
        this.b.h(r2, r3, r4);
    }

    @Override // gy.f
    public final void i(String r3, RTCWaterMarkRegion r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "waterMarkId");
        Intrinsics.checkNotNullParameter(r4, "region");
        this.b.S1(r3, new vc0.a(r4), r5);
    }

    @Override // gy.f
    public final void c(v0 r6, gy.g r7, String r8, gy.i r9) {
        Intrinsics.checkNotNullParameter(r7, "configInvocation");
        Intrinsics.checkNotNullParameter(r8, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r9, "params");
        com.bytedance.android.live.revenuelink.rtc.i r0 = this.b;
        if (r6 == null) goto L5;
        vc0.a r1 = new vc0.a(r6);
    L6:
        r0.U1(r1, new q(r7), r8, new com.bytedance.android.live.revenuelink.rtc.q(r9.a, r9.b, r9.c, r9.d));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // gy.f
    public final void d0(String r8, String r9, int r11, int r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r9, "src");
        this.b.d0(r8, r9, r11, r12, r13);
    }
}
