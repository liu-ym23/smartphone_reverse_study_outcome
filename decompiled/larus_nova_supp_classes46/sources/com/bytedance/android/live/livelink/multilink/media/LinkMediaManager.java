package com.bytedance.android.live.livelink.multilink.media;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager$mRtcInfoListener$1;
import com.bytedance.android.live.livelink.platformapi.avclient.video.AndroidVideoStreamApi;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.rtc.PublicStreamType;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import fr2.u;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sk0.c;
import ti6.d;
import uf2.b1;
import yb6.e;
import yb6.g;
import yb6.h;
import yb6.i;
import yb6.j;
import yb6.n;
import yb6.o;
import zf2.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkMediaManager extends vb6.b implements e {
    public static final /* synthetic */ int x = 0;
    public final tc0.b b;
    public volatile ec6.a c;
    public volatile ei6.a d;
    public final hc6.a e;
    public Disposable f;
    public Disposable g;
    public final CopyOnWriteArraySet<o> h;
    public final CopyOnWriteArraySet<u> i;
    public final CopyOnWriteArraySet<i> j;
    public final ConcurrentHashMap<String, j> k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public volatile long o;
    public long p;
    public long q;
    public final Lazy r;
    public final Lazy s;
    public final Context t;
    public final boolean u;
    public final fc6.a v;
    public final bn0.b w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkMediaManager a;

        public b(LinkMediaManager r1) {
            this.a = r1;
        }

        public final void accept(Object r19) {
            Long r1 = (Long) r19;
            this.a.v0().a("stop_time_out");
            long r9 = -12302;
            this.a.w0().H(this.a.d, -2, r9, new Exception("stop_time_out"));
            LinkMonitor.a("LinkMediaM", "stop rtc time out", null, null, LinkMonitor.LogLevel.ERROR, false, 108);
            InteractLinkFullLinkMonitor.i0(r9, "stop rtc time out");
        }
    }

    static {
    }

    public final h u0() {
        return (h) this.l.getValue();
    }

    public final n v0() {
        return (n) this.m.getValue();
    }

    public final LinkMediaManager$mRtcListener$2.AnonymousClass1 w0() {
        return (LinkMediaManager$mRtcListener$2.AnonymousClass1) this.s.getValue();
    }

    public final void A0() {
        if (this.u == false) goto L16;
        Iterator<i> r0 = this.j.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().s1();
        goto L6
    L8:
        ec6.b r1 = t0();
        if (r1 == null) goto L13;
        sk0.a r2 = ((c) r1).b;
        if (r2 == null) goto L13;
        r2.d();
    L13:
        LinkMonitor.a("LinkMediaM", "resetAnchorLiveStream", "anchor reset live client params with livestream", null, null, false, 120);
        return;
    }

    public final void G() {
        ei6.a r0 = this.d;
        if (r0 == null) goto L8;
        vi6.a r1 = r0.v();
        if (r1 == null) goto L9;
        r1.f();
        return;
    L9:
        return;
    }

    public final void d() {
        LinkMonitor.a("LinkMediaM", "stopVideoCapture", null, null, null, true, 60);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r1 = ((c) r0).d;
        if (r1 == null) goto L9;
        r1.e("");
        return;
    L9:
        return;
    }

    public final void disableRemoteOrientation() {
        ei6.a r0 = this.d;
        if (r0 == null) goto L8;
        SpatialAudioManager r1 = r0.m();
        if (r1 == null) goto L9;
        r1.a(x0());
        return;
    L9:
        return;
    }

    public final void e() {
        LinkMonitor.a("LinkMediaM", "startVideoCapture", null, null, null, true, 60);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r1 = ((c) r0).d;
        if (r1 == null) goto L9;
        r1.d("");
        return;
    L9:
        return;
    }

    public final void j() {
        LinkMonitor.a("LinkMediaM", "startPushData", null, null, null, true, 60);
        ei6.a r0 = this.d;
        if (r0 == null) goto L8;
        si6.b r1 = r0.b();
        if (r1 == null) goto L9;
        r1.j();
        return;
    L9:
        return;
    }

    public final void l0() {
        if (this.c != null) goto L5;
        return;
    L5:
        LinkMonitor.a("LinkMediaM", "stopLiveClient", null, null, null, false, 124);
        A0();
        y0();
        this.c = null;
        Iterator<i> r0 = this.j.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().t1();
        goto L7
    L9:
        h r1 = u0();
        r1.b = false;
        r1.a = false;
    }

    public final void n() {
        LinkMonitor.a("LinkMediaM", "stopRtcEngine", null, null, null, false, 124);
        if (v0().d == false) goto L6;
        LinkMonitor.a("LinkMediaM", "rtc engine is stopping skip!", null, null, null, false, 124);
        return;
    L6:
        InteractLinkFullLinkMonitor.h0();
        i97.a r0 = i97.a.a;
        Intrinsics.checkNotNullParameter(r0, "$this$elapsedRealtime");
        this.p = SystemClock.elapsedRealtime();
        v0().d = true;
        ei6.a r2 = this.d;
        if (r2 == null) goto L11;
        si6.b r3 = r2.b();
        if (r3 == null) goto L11;
        si6.a.b(r3, false, "LinkMediaManager", 3);
    L11:
        n r4 = v0();
        r4.b = false;
        r4.a = false;
        this.k.clear();
        ei6.a r5 = this.e.a;
        if (r5 == null) goto L16;
        ri6.b r6 = r5.r();
        if (r6 == null) goto L16;
        r6.s1();
    L16:
        Disposable r7 = this.g;
        if (r7 == null) goto L19;
        r7.dispose();
    L19:
        Disposable r8 = this.f;
        if (r8 == null) goto L23;
        r8.dispose();
    L23:
        if (v0().e == true) goto L25;
        LinkMonitor.a("LinkMediaM", "rtc engine is not on , reset state", null, null, null, false, 124);
        v0().a("rtc engine is not on , reset state");
        Intrinsics.checkNotNullParameter(r0, "$this$elapsedRealtime");
        InteractLinkFullLinkMonitor.j0(SystemClock.elapsedRealtime() - this.p);
    L28:
        this.d = null;
        l0();
        return;
    L25:
        if (this.d == null) goto L28;
        l r1 = l.a;
        long r9 = vm2.i.l() * ((long) 1000);
        int r10 = p.a;
        Scheduler r11 = Schedulers.computation();
        Disposable r12 = Observable.timer(r9, TimeUnit.MILLISECONDS, r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        f.a(r12, ((vb6.b) this).a);
        this.g = r12;
        goto L28
    }

    public final void o() {
        LinkMonitor.a("LinkMediaM", "switchVideoCapture", "force switch front and back", null, null, true, 56);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r1 = ((c) r0).d;
        if (r1 == null) goto L9;
        r1.f();
        return;
    L9:
        return;
    }

    public final void q() {
        ei6.a r0 = this.d;
        if (r0 == null) goto L8;
        ui6.b r1 = r0.h();
        if (r1 == null) goto L9;
        r1.a(x0());
        return;
    L9:
        return;
    }

    public final ec6.b t0() {
        ec6.a r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r();
    }

    public final void v() {
        Intrinsics.checkNotNullParameter("handleKickOutMsg switchToSilence", "source");
        LinkMonitor.a("LinkMediaM", "setUserExRoomVisibility", "[source] handleKickOutMsg switchToSilence isVisible false rtcClient " + this.d, null, null, true, 56);
        ei6.a r0 = this.d;
        if (r0 == null) goto L25;
        si6.b r1 = r0.b();
        if (r1 == null) goto L26;
        ei6.a r2 = this.d;
        String r3 = "";
        if (r2 == null) goto L18;
        ui6.e r4 = r2.n();
        if (r4 == null) goto L18;
        Map r5 = r4.b();
        if (r5 == null) goto L18;
        Iterator r6 = r5.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        String r7 = ((mi6.b) ((Map.Entry) r6.next()).getValue()).getRoomId();
        if ((!Intrinsics.areEqual(r7, x0())) == false) goto L14;
        r3 = r7;
    L18:
        r1.o(r3, false);
        return;
    L26:
        return;
    }

    public final MixStreamType x() {
        ei6.a r0 = this.d;
        if (r0 == null) goto L9;
        fi6.a r1 = r0.g();
        if (r1 == null) goto L9;
        MixStreamType r2 = r1.U;
        if (r2 == null) goto L9;
        return r2;
    L9:
        return MixStreamType.NONE;
    }

    public final String x0() {
        ei6.a r0 = this.d;
        if (r0 == null) goto L7;
        si6.b r1 = r0.b();
        if (r1 == null) goto L7;
        String r2 = r1.m();
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }

    public final void y0() {
        if (this.u == true) goto L30;
        Iterator<i> r0 = this.j.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().s1();
        goto L6
    L8:
        ec6.b r1 = t0();
        if (r1 == null) goto L13;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r2 = ((c) r1).d;
        if (r2 == null) goto L13;
        r2.e("");
    L13:
        ec6.b r3 = t0();
        if (r3 == null) goto L18;
        tk0.a r4 = ((c) r3).c;
        if (r4 == null) goto L18;
        r4.g("media manager release");
    L18:
        ec6.b r5 = t0();
        if (r5 == null) goto L21;
        c r6 = (c) r5;
        r6.h((LinkMediaManager$IMultiLinkBizAVClientLiveStreamListener$2.a) this.r.getValue());
    L21:
        ec6.b r7 = t0();
        if (r7 == null) goto L24;
        ((c) r7).g();
    L24:
        ec6.a r8 = this.c;
        if (r8 == null) goto L27;
        r8.release();
    L27:
        this.c = null;
        return;
    }

    public final int J() {
        ec6.b r0 = t0();
        if (r0 == null) goto L7;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r1 = ((c) r0).d;
        if (r1 == null) goto L7;
        return r1.h();
    L7:
        return 0;
    }

    public final n K() {
        return v0();
    }

    public final boolean N() {
        ec6.b r0 = t0();
        if (r0 == null) goto L7;
        tk0.a r1 = ((c) r0).c;
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return false;
    }

    public final h O() {
        return u0();
    }

    public final boolean m0() {
        ec6.b r0 = t0();
        if (r0 == null) goto L7;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r1 = ((c) r0).d;
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return false;
    }

    public final boolean p() {
        ec6.b r0 = t0();
        if (r0 == null) goto L7;
        tk0.a r1 = ((c) r0).c;
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return false;
    }

    public final ei6.a Z0() {
        return this.d;
    }

    public final Context getContext() {
        return this.t;
    }

    public final Map<String, j> m() {
        return this.k;
    }

    public final ec6.a r0() {
        return this.c;
    }

    public final void A(LinkPipelineManager.e r8) {
        LinkMonitor.a("LinkMediaM", "addMediaInfoListener " + r8, null, null, null, false, 92);
        if (r8 != null) goto L5;
        return;
    L5:
        this.j.add(r8);
    }

    public final void D(LinkPipelineManager$mRtcInfoListener$1 r8) {
        LinkMonitor.a("LinkMediaM", "addRtcInfoListener " + r8, null, null, null, false, 92);
        if (r8 != null) goto L5;
        return;
    L5:
        this.h.add(r8);
    }

    public final void I(String r8) {
        LinkMonitor.a("LinkMediaM", "changeAnchorParams", String.valueOf(r8), null, null, false, 120);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        ei6.a r1 = this.d;
        if (r1 == null) goto L17;
        d r2 = r1.p();
        if (r2 == null) goto L18;
        r2.e(r8);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void L(String r18) {
        Intrinsics.checkNotNullParameter(r18, "reason");
        if ((!StringsKt.isBlank(r18)) == false) goto L5;
        String r1 = r18;
    L7:
        if (r1 == null) goto L9;
        LinkMonitor.a("LinkMediaM", "unMuteAudio", "by ".concat(r1), null, null, true, 56);
    L10:
        ec6.b r2 = t0();
        if (r2 == null) goto L16;
        tk0.a r3 = ((c) r2).c;
        if (r3 == null) goto L17;
        r3.c(false, r18);
        return;
    L17:
        return;
    L16:
        return;
    L9:
        LinkMonitor.a("LinkMediaM", "unMuteAudio", "by " + ExceptionsKt.stackTraceToString(new Throwable()), null, null, true, 56);
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void S(String r8) {
        LinkMonitor.a("LinkMediaM", "updateRtcSdkParams", String.valueOf(r8), null, null, false, 120);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        ei6.a r1 = this.d;
        if (r1 == null) goto L17;
        si6.b r2 = r1.b();
        if (r2 == null) goto L18;
        r2.f(r8);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void T(LinkPipelineManager.d r8) {
        LinkMonitor.a("LinkMediaM", "removeLiveStreamInfoListener " + r8, null, null, null, false, 92);
        if (r8 != null) goto L5;
        return;
    L5:
        this.i.remove(r8);
    }

    public final j U(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        return this.k.get(r2);
    }

    public final void V(LinkPipelineManager$mRtcInfoListener$1 r8) {
        LinkMonitor.a("LinkMediaM", "removeRtcInfoListener " + r8, null, null, null, false, 92);
        if (r8 != null) goto L5;
        return;
    L5:
        this.h.remove(r8);
    }

    public final int W(List<ui6.a> r8) {
        LinkMonitor.a("LinkMediaM", "startForwardStreamToRooms", String.valueOf(r8), null, null, false, 120);
        if (r8 != null) goto L5;
        return -1;
    L5:
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        this.q = SystemClock.elapsedRealtime();
        ei6.a r1 = this.d;
        if (r1 == null) goto L11;
        ui6.b r2 = r1.h();
        if (r2 == null) goto L12;
        r2.d(x0(), r8, "");
        return 0;
    L12:
        return -1;
    L11:
        return -1;
    }

    public final void X(String r10) {
        LinkMonitor.a("LinkMediaM", "updateLiveSdkParams", String.valueOf(r10), null, null, false, 120);
        if (r10 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        ec6.b r1 = t0();
        if (r1 == null) goto L21;
        ((LiveSdkParamsAdjuster) this.n.getValue()).a(r10);     // Catch: Exception -> L15
    L17:
        ((c) r1).b.h(r10);
        this.v.k();
        return;
    L15:
        e = move-exception;
        LinkMonitor.a("LinkMediaM", "SdkParamsAdjustError", "error msg " + e.getMessage(), e, LinkMonitor.LogLevel.ERROR, false, 96);
        goto L17
    L21:
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void Y(String r18) {
        Intrinsics.checkNotNullParameter(r18, "reason");
        if ((!StringsKt.isBlank(r18)) == false) goto L5;
        String r1 = r18;
    L6:
        if (r1 == null) goto L8;
        LinkMonitor.a("LinkMediaM", "muteAudio", " by ".concat(r1), null, null, true, 56);
    L9:
        ec6.b r2 = t0();
        if (r2 == null) goto L15;
        tk0.a r3 = ((c) r2).c;
        if (r3 == null) goto L16;
        r3.c(true, r18);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        LinkMonitor.a("LinkMediaM", "muteAudio", "by " + ExceptionsKt.stackTraceToString(new Throwable()), null, null, true, 56);
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void a(InteractMode r9) {
        Intrinsics.checkNotNullParameter(r9, "interactMode");
        LinkMonitor.a("LinkMediaM", "switchInteractMode", String.valueOf(r9), null, null, false, 88);
        ei6.a r0 = this.d;
        if (r0 == null) goto L8;
        si6.b r1 = r0.b();
        if (r1 == null) goto L9;
        r1.a(r9);
        return;
    L9:
        return;
    }

    public final boolean a0(StreamType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        int r5 = com.bytedance.android.live.livelink.multilink.media.a.c[r4.ordinal()];
        if (r5 == 1) goto L34;
        boolean r2 = false;
        if (r5 != 2) goto L7;
        ei6.a r6 = this.d;
        if (r6 == null) goto L41;
        xi6.c r7 = r6.t();
        if (r7 == null) goto L41;
        com.bytedance.live.livelink.kmp.impl.core.video.b r8 = r7.f();
        if (r8 == null) goto L41;
        r2 = ((com.bytedance.live.livelink.kmp.impl.core.video.f) r8).g;
    L41:
        return !r2;
    L7:
        if (r5 != 3) goto L26;
        ei6.a r9 = this.d;
        if (r9 == null) goto L13;
        ri6.b r10 = r9.r();
        if (r10 == null) goto L13;
        boolean r11 = r10.C();
    L14:
        if (r11 == false) goto L41;
        ei6.a r12 = this.d;
        if (r12 == null) goto L22;
        xi6.c r13 = r12.t();
        if (r13 == null) goto L22;
        com.bytedance.live.livelink.kmp.impl.core.video.b r14 = r13.f();
        if (r14 == null) goto L22;
        boolean r15 = ((com.bytedance.live.livelink.kmp.impl.core.video.f) r14).g;
    L23:
        if (r15 == false) goto L41;
    L39:
        r2 = true;
    L22:
        r15 = false;
    L13:
        r11 = true;
        goto L14
    L26:
        throw new NoWhenBranchMatchedException();
    L34:
        ei6.a r16 = this.d;
        if (r16 == null) goto L39;
        ri6.b r17 = r16.r();
        if (r17 == null) goto L39;
        r2 = r17.C();
        goto L41
    }

    public final void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        LinkMonitor.a("LinkMediaM", "stopAudioCapture reason " + r9, null, null, null, true, 60);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        tk0.a r1 = ((c) r0).c;
        if (r1 == null) goto L9;
        r1.g(r9);
        return;
    L9:
        return;
    }

    public final void c(String r8) {
        LinkMonitor.a("LinkMediaM", "updateRtcExtInfo", String.valueOf(r8), null, null, false, 120);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        InteractLinkFullLinkMonitor.u0(r8);
        ei6.a r1 = this.d;
        if (r1 == null) goto L17;
        si6.b r2 = r1.b();
        if (r2 == null) goto L18;
        r2.c(r8);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void e0(LinkPipelineManager.e r8) {
        LinkMonitor.a("LinkMediaM", "removeMediaInfoListener " + r8, null, null, null, false, 92);
        if (r8 != null) goto L5;
        return;
    L5:
        this.j.remove(r8);
    }

    public final void f(String r9) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        LinkMonitor.a("LinkMediaM", "startAudioCapture reason " + r9, null, null, null, true, 60);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        tk0.a r1 = ((c) r0).c;
        if (r1 == null) goto L9;
        r1.f(r9);
        return;
    L9:
        return;
    }

    public final void h(xb6.b r10) {
        super.h(r10);
        LinkMonitor.a("LinkMediaM", "detach", null, null, null, false, 92);
        if (r10 == null) goto L10;
        Pair r0 = r10.h();
        if (r0 == null) goto L10;
        if (((Boolean) r0.getFirst()).booleanValue() != true) goto L10;
        LinkMonitor.a("LinkMediaM", "DetachIntercepted", "detach intercepted by " + ((String) r10.h().getSecond()), null, null, false, 120);
        return;
    L10:
        ((LiveSdkParamsAdjuster) this.n.getValue()).a = 0;
        n r11 = v0();
        r11.getClass();
        Intrinsics.checkNotNullParameter("detach", "source");
        r11.b = false;
        r11.a = false;
        r11.a("detach");
        h r12 = u0();
        r12.b = false;
        r12.a = false;
        this.h.clear();
        this.i.clear();
        this.k.clear();
        ei6.a r13 = this.d;
        if (r13 == null) goto L15;
        gi6.e r14 = r13.getEventManager();
        if (r14 == null) goto L15;
        r14.b(null);
    L15:
        ei6.a r15 = this.d;
        if (r15 == null) goto L20;
        si6.b r16 = r15.b();
        if (r16 == null) goto L20;
        si6.a.b(r16, false, "link media manager detach", 3);
    L20:
        ec6.b r17 = t0();
        if (r17 == null) goto L27;
        AndroidVideoStreamApi r18 = ((c) r17).e;
        if (r18 == null) goto L27;
        AndroidVideoStreamApi.a r19 = r18.b;
        if (r19 == null) goto L27;
        r19.b();
    L27:
        A0();
        y0();
        this.c = null;
        this.d = null;
    }

    public final void i(boolean r3) {
        ei6.a r0 = this.d;
        if (r0 == null) goto L8;
        SpatialAudioManager r1 = r0.m();
        if (r1 == null) goto L9;
        r1.b(x0(), r3);
        return;
    L9:
        return;
    }

    public final int k(String r9) {
        Intrinsics.checkNotNullParameter(r9, "publicStreamId");
        LinkMonitor.a("LinkMediaM", "stopPlayPublicStream", r9, null, null, false, 120);
        ei6.a r0 = this.d;
        if (r0 == null) goto L7;
        ui6.c r1 = r0.o();
        if (r1 == null) goto L7;
        r1.d(r9, PublicStreamType.VIDEO_AUDIO);
        return 0;
    L7:
        return -1;
    }

    public final void k0(LinkPipelineManager.d r8) {
        LinkMonitor.a("LinkMediaM", "addLiveStreamInfoListener " + r8, null, null, null, false, 92);
        if (r8 != null) goto L5;
        return;
    L5:
        this.i.add(r8);
    }

    public final int l(String r9) {
        Intrinsics.checkNotNullParameter(r9, "publicStreamId");
        LinkMonitor.a("LinkMediaM", "startPlayPublicStream", " " + r9, null, null, false, 120);
        ei6.a r0 = this.d;
        if (r0 == null) goto L7;
        ui6.c r1 = r0.o();
        if (r1 == null) goto L7;
        r1.a(r9, PublicStreamType.VIDEO_AUDIO);
        return 0;
    L7:
        return -1;
    }

    public final void n0(int r8) {
        LinkMonitor.a("LinkMediaM", "switchVideoCapture", String.valueOf(r8), null, null, true, 56);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r1 = ((c) r0).d;
        if (r1 == null) goto L9;
        r1.g(r8);
        return;
    L9:
        return;
    }

    public final void o0(Map<String, j> r2) {
        Intrinsics.checkNotNullParameter(r2, "remoteViewMap");
        this.k.putAll(r2);
    }

    public final void r(b1 r9) {
        LinkMonitor.a("LinkMediaM", "updateLiveSdkParams", String.valueOf(r9), null, null, false, 120);
        if (r9 != null) goto L5;
        return;
    L5:
        ec6.b r0 = t0();
        if (r0 == null) goto L10;
        sk0.a r1 = ((c) r0).b;
        if (r1 == null) goto L10;
        r1.j(r9);
    L10:
        LinkMonitor.a("LinkMediaM", "updated live sdk params", null, null, null, false, 124);
    }

    public final void w(String r8) {
        LinkMonitor.a("LinkMediaM", "updateAudioScene", String.valueOf(r8), null, null, false, 120);
        if (r8 != null) goto L5;
        return;
    L5:
        ei6.a r0 = this.d;
        if (r0 == null) goto L11;
        ri6.b r1 = r0.r();
        if (r1 == null) goto L12;
        r1.w(r8);
        return;
    L12:
        return;
    }

    public final void B(StreamType r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "reason");
        if (this.d != null) goto L5;
        return;
    L5:
        LinkMonitor.a("LinkMediaM", "unSubscribeAllRemoteStreams", r9.ordinal() + " reason " + r10, null, null, true, 56);
        int r11 = com.bytedance.android.live.livelink.multilink.media.a.g[r9.ordinal()];
        if (r11 != 1) goto L8;
        ei6.a r12 = this.d;
        if (r12 == null) goto L44;
        xi6.c r13 = r12.t();
        if (r13 == null) goto L45;
        com.bytedance.live.livelink.kmp.impl.core.video.c r14 = r13.d();
        if (r14 == null) goto L46;
        r14.k(true, r10);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L8:
        if (r11 != 2) goto L10;
        ei6.a r15 = this.d;
        if (r15 == null) goto L41;
        ri6.b r16 = r15.r();
        if (r16 == null) goto L42;
        r16.p(x0(), true, r10);
        return;
    L42:
        return;
    L41:
        return;
    L10:
        if (r11 != 3) goto L47;
        ei6.a r17 = this.d;
        if (r17 == null) goto L17;
        ri6.b r18 = r17.r();
        if (r18 == null) goto L17;
        r18.p(x0(), true, r10);
    L17:
        ei6.a r19 = this.d;
        if (r19 == null) goto L37;
        xi6.c r20 = r19.t();
        if (r20 == null) goto L38;
        com.bytedance.live.livelink.kmp.impl.core.video.c r21 = r20.d();
        if (r21 == null) goto L39;
        r21.k(true, r10);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    public final void H(g r14, LinkPipelineManager.h r15) {
        Intrinsics.checkNotNullParameter(r14, "params");
        KmpEnv r2 = KmpEnv.a;
        if (v.a() == true) goto L5;
    L8:
        ec6.a r3 = this.c;
        if (r3 != null) goto L11;
    L17:
        u0().b = true;
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r4 = SystemClock.elapsedRealtime();
    L29:
        th = move-exception;
        LinkMonitor.a("LinkMediaM", "live client init failed", String.valueOf(th), null, null, false, 120);     // Catch: Throwable -> L38
        r15.lf(dc6.a.a(r4), th);     // Catch: Throwable -> L38
    L36:
        u0().b = false;
        return;
    L38:
        th = move-exception;
        u0().b = false;
        throw th;
    L19:
        if ((!StringsKt.isBlank(r14.a)) == false) goto L21;
        this.c = r15.O2(r14.a);     // Catch: Throwable -> L29
    L22:
        ec6.a r16 = this.c;     // Catch: Throwable -> L29
        if (r16 == null) goto L33;
        u0().a = true;     // Catch: Throwable -> L29
        if (this.u == true) goto L31;
        ec6.b r1 = t0();     // Catch: Throwable -> L29
        if (r1 == null) goto L31;
        ((c) r1).a((LinkMediaManager$IMultiLinkBizAVClientLiveStreamListener$2.a) this.r.getValue());     // Catch: Throwable -> L29
    L31:
        LinkMonitor.a("LinkMediaM", "live client init success duration " + dc6.a.a(r4), null, null, null, false, 92);     // Catch: Throwable -> L29
        r15.u4(dc6.a.a(r4), r16);     // Catch: Throwable -> L29
        if (Unit.INSTANCE != null) goto L36;
    L33:
        r15.lf(dc6.a.a(r4), new Exception("live client create fail"));     // Catch: Throwable -> L29
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L29
        goto L36
    L21:
        LinkMonitor.a("LinkMediaM", "illegal init params", String.valueOf(r14), null, null, false, 120);     // Catch: Throwable -> L29
        r15.lf(dc6.a.a(r4), new Exception("illegal live client init params " + r14));     // Catch: Throwable -> L29
        goto L22
    L11:
        if (u0().a == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L17;
        LinkMonitor.a("LinkMediaM", "live client already init !", null, null, null, false, 124);
        r15.u4(0, r3);
        return;
    L5:
        if (vm2.i.h().e4() == false) goto L8;
        LinkMonitor.a("LinkMediaM", "mock live client init failed in local test", null, null, null, false, 124);
        r15.lf(0, new Exception("mock live client init failed"));
    }

    public final void P(StreamType r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "reason");
        if (this.d != null) goto L5;
        return;
    L5:
        LinkMonitor.a("LinkMediaM", "subscribeAllRemoteStreams", r9.ordinal() + " reason " + r10, null, null, true, 56);
        int r11 = com.bytedance.android.live.livelink.multilink.media.a.f[r9.ordinal()];
        if (r11 != 1) goto L8;
        ei6.a r12 = this.d;
        if (r12 == null) goto L44;
        xi6.c r13 = r12.t();
        if (r13 == null) goto L45;
        com.bytedance.live.livelink.kmp.impl.core.video.c r14 = r13.d();
        if (r14 == null) goto L46;
        r14.k(false, r10);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L8:
        if (r11 != 2) goto L10;
        ei6.a r15 = this.d;
        if (r15 == null) goto L41;
        ri6.b r16 = r15.r();
        if (r16 == null) goto L42;
        r16.p(x0(), false, r10);
        return;
    L42:
        return;
    L41:
        return;
    L10:
        if (r11 != 3) goto L47;
        ei6.a r17 = this.d;
        if (r17 == null) goto L17;
        ri6.b r18 = r17.r();
        if (r18 == null) goto L17;
        r18.p(x0(), false, r10);
    L17:
        ei6.a r19 = this.d;
        if (r19 == null) goto L37;
        xi6.c r20 = r19.t();
        if (r20 == null) goto L38;
        com.bytedance.live.livelink.kmp.impl.core.video.c r21 = r20.d();
        if (r21 == null) goto L39;
        r21.k(false, r10);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    public final void Q(ei6.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "rtcClient");
        Intrinsics.checkNotNullParameter(r11, "source");
        this.d = r10;
        ei6.a r0 = this.d;
        if (r0 == null) goto L7;
        gi6.e r1 = r0.getEventManager();
        if (r1 == null) goto L7;
        r1.b(w0());
    L7:
        v0().b(true, "setRtcClient " + r11 + ' ');
        v0().a = true;
        v0().b = false;
        LinkMonitor.a("LinkMediaM", "setRtcClient", "source " + r11, null, null, false, 120);
        Iterator<i> r2 = this.j.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().I2(r10, r11);
        goto L9
    }

    public final void c0(fi6.a r18, LinkPipelineManager.i r19) {
        Intrinsics.checkNotNullParameter(r18, "config");
        KmpEnv r4 = KmpEnv.a;
        if (v.a() == true) goto L5;
    L8:
        ei6.a r5 = this.d;
        ei6.a r7 = null;
        if (r5 == null) goto L18;
        if (v0().a == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L18;
        LinkMonitor.a("LinkMediaM", "rtc client already init!", null, null, null, false, 124);
        r19.Zk(0, r5);
        return;
    L18:
        if (this.c != null) goto L22;
        h r0 = u0();
        r0.b = false;
        r0.a = false;
        LinkMonitor.a("LinkMediaM", "live client is null when init rtc client", null, null, null, false, 124);
        r19.uf(0, new Exception("live client is null"));
        return;
    L22:
        if (r18.getContext() == null) goto L32;
        String r6 = r18.v;
        if (r6 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == true) goto L36;
        LinkMonitor.a("LinkMediaM", "rtc init failed config is invalid", null, null, null, false, 124);
        r19.uf(0, new Exception("config is invalid"));
        return;
    L36:
        v0().b = true;
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r10 = SystemClock.elapsedRealtime();
    L60:
        th = move-exception;
        LinkMonitor.a("LinkMediaM", "rtc client init failed", th + " stackTrace=" + ExceptionsKt.stackTraceToString(th), null, LinkMonitor.LogLevel.ERROR, false, 104);     // Catch: Throwable -> L72
        r19.uf(dc6.a.a(r10), th);     // Catch: Throwable -> L72
    L70:
        v0().b = false;
        return;
    L72:
        th = move-exception;
        v0().b = false;
        throw th;
    L38:
        if (vh6.c.b(wh6.a.class).isBoe() == false) goto L41;
        r18.l(Env.ENV_BOE);     // Catch: Throwable -> L60
    L41:
        if (vm2.i.d() == false) goto L43;
        r18.l(Env.ENV_TEST);     // Catch: Throwable -> L60
    L43:
        String r11 = vh6.c.b(wh6.a.class).getChannel();     // Catch: Throwable -> L60
        if (r11 != null) goto L46;
        r11 = "";
    L46:
        Intrinsics.checkNotNullParameter(r11, "channel");     // Catch: Throwable -> L60
        r18.y = r11;     // Catch: Throwable -> L60
        r18.c(String.valueOf(vh6.c.b(wh6.a.class).getAppId()));     // Catch: Throwable -> L60
        r18.e(vh6.c.b(wh6.a.class).getVersionCode());     // Catch: Throwable -> L60
        r18.d(String.valueOf(vh6.c.b(wh6.a.class).getUpdateVersionCode()));     // Catch: Throwable -> L60
        r18.k(this.v.d());     // Catch: Throwable -> L60
        ec6.a r12 = this.c;     // Catch: Throwable -> L60
        if (r12 == null) goto L49;
        r7 = r12.q(r18);     // Catch: Throwable -> L60
    L49:
        this.d = r7;     // Catch: Throwable -> L60
        ei6.a r1 = this.d;     // Catch: Throwable -> L60
        if (r1 == null) goto L70;
        v0().a = true;     // Catch: Throwable -> L60
        LinkMonitor.a("LinkMediaM", "enableRtcMetaDataSign", null, null, null, false, 124);     // Catch: Throwable -> L60
        ec6.a r13 = this.c;     // Catch: Throwable -> L60
        if (r13 == null) goto L62;
        c r14 = r13.r();     // Catch: Throwable -> L60
        if (r14 == null) goto L62;
        AndroidVideoStreamApi r15 = r14.e;     // Catch: Throwable -> L60
        if (r15 == null) goto L62;
        AndroidVideoStreamApi.a r16 = r15.b;     // Catch: Throwable -> L60
        if (r16 == null) goto L62;
        r16.a();     // Catch: Throwable -> L60
    L62:
        ei6.a r17 = this.d;     // Catch: Throwable -> L60
        if (r17 == null) goto L67;
        gi6.e r20 = r17.getEventManager();     // Catch: Throwable -> L60
        if (r20 == null) goto L67;
        r20.b(w0());     // Catch: Throwable -> L60
    L67:
        LinkMonitor.a("LinkMediaM", "rtc client init success", "duration " + dc6.a.a(r10), null, null, false, 88);     // Catch: Throwable -> L60
        r19.Zk(dc6.a.a(r10), r1);     // Catch: Throwable -> L60
        goto L70
    L26:
        if (StringsKt.isBlank(r6) == true) goto L29;
        r8 = false;
    L32:
        r9 = false;
        goto L33
    L5:
        if (vm2.i.h().U() == false) goto L8;
        LinkMonitor.a("LinkMediaM", "mock init rtc client failed", null, null, null, false, 124);
        r19.uf(0, new Exception("mock rtc init failed"));
    }

    public final void d0(StreamType r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "reason");
        LinkMonitor.a("LinkMediaM", "unPublishStream", r9 + ", reason=" + r10 + ", rtcClient=" + this.d, null, null, true, 56);
        int r11 = com.bytedance.android.live.livelink.multilink.media.a.b[r9.ordinal()];
        if (r11 != 1) goto L5;
        ei6.a r12 = this.d;
        if (r12 == null) goto L42;
        ri6.b r13 = r12.r();
        if (r13 == null) goto L43;
        r13.s(x0(), true);
        return;
    L43:
        return;
    L42:
        return;
    L5:
        if (r11 != 2) goto L7;
        ei6.a r14 = this.d;
        if (r14 == null) goto L38;
        xi6.c r15 = r14.t();
        if (r15 == null) goto L39;
        com.bytedance.live.livelink.kmp.impl.core.video.b r16 = r15.f();
        if (r16 == null) goto L40;
        r16.e(true);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L7:
        if (r11 != 3) goto L44;
        ei6.a r17 = this.d;
        if (r17 == null) goto L14;
        ri6.b r18 = r17.r();
        if (r18 == null) goto L14;
        r18.s(x0(), true);
    L14:
        ei6.a r19 = this.d;
        if (r19 == null) goto L34;
        xi6.c r20 = r19.t();
        if (r20 == null) goto L35;
        com.bytedance.live.livelink.kmp.impl.core.video.b r21 = r20.f();
        if (r21 == null) goto L36;
        r21.e(true);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void g0(boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        LinkMonitor.a("LinkMediaM", "setUserVisibility", "[source] " + r10 + " isVisible " + r9 + " rtcClient " + this.d, null, null, true, 56);
        ei6.a r11 = this.d;
        if (r11 == null) goto L8;
        si6.b r12 = r11.b();
        if (r12 == null) goto L9;
        r12.o(x0(), r9);
        return;
    L9:
        return;
    }

    public final void s0(ec6.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "source");
        this.c = r10;
        u0().a = true;
        u0().b = false;
        if (this.u == true) goto L7;
        ec6.b r0 = t0();
        if (r0 == null) goto L7;
        ((c) r0).a((LinkMediaManager$IMultiLinkBizAVClientLiveStreamListener$2.a) this.r.getValue());
    L7:
        LinkMonitor.a("LinkMediaM", "setLiveClient", "source " + r11, null, null, false, 120);
        Iterator<i> r1 = this.j.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        r1.next().t5(r10, r11);
        goto L9
    }

    public final void u(k0 r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "streamInfo");
        ei6.a r1 = this.d;
        if (r1 == null) goto L48;
        LinkMonitor.a("LinkMediaM", "setRemoteVideoSuperResolution", "streamInfo" + r10 + " mode" + r11, null, null, false, 120);
        switch(r11) {
            case 0: goto L42;
            case 1: goto L37;
            case 2: goto L32;
            case 3: goto L27;
            case 4: goto L22;
            case 5: goto L17;
            case 6: goto L12;
            case 7: goto L7;
            default: goto L72;
        };
    L7:
        xi6.c r12 = r1.t();
        if (r12 == null) goto L49;
        com.bytedance.live.livelink.kmp.impl.core.video.c r13 = r12.d();
        if (r13 == null) goto L50;
        r13.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_14X);
        return;
    L50:
        return;
    L49:
        return;
    L12:
        xi6.c r14 = r1.t();
        if (r14 == null) goto L52;
        com.bytedance.live.livelink.kmp.impl.core.video.c r15 = r14.d();
        if (r15 == null) goto L53;
        r15.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_13X);
        return;
    L53:
        return;
    L52:
        return;
    L17:
        xi6.c r16 = r1.t();
        if (r16 == null) goto L55;
        com.bytedance.live.livelink.kmp.impl.core.video.c r17 = r16.d();
        if (r17 == null) goto L56;
        r17.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_12X);
        return;
    L56:
        return;
    L55:
        return;
    L22:
        xi6.c r18 = r1.t();
        if (r18 == null) goto L58;
        com.bytedance.live.livelink.kmp.impl.core.video.c r19 = r18.d();
        if (r19 == null) goto L59;
        r19.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_11X);
        return;
    L59:
        return;
    L58:
        return;
    L27:
        xi6.c r110 = r1.t();
        if (r110 == null) goto L61;
        com.bytedance.live.livelink.kmp.impl.core.video.c r111 = r110.d();
        if (r111 == null) goto L62;
        r111.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_20X);
        return;
    L62:
        return;
    L61:
        return;
    L32:
        xi6.c r112 = r1.t();
        if (r112 == null) goto L64;
        com.bytedance.live.livelink.kmp.impl.core.video.c r113 = r112.d();
        if (r113 == null) goto L65;
        r113.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_15X);
        return;
    L65:
        return;
    L64:
        return;
    L37:
        xi6.c r114 = r1.t();
        if (r114 == null) goto L67;
        com.bytedance.live.livelink.kmp.impl.core.video.c r115 = r114.d();
        if (r115 == null) goto L68;
        r115.q(r10, LiveWrappedVideoSuperResolutionMode.SCALE_AUTO);
        return;
    L68:
        return;
    L67:
        return;
    L42:
        xi6.c r116 = r1.t();
        if (r116 == null) goto L70;
        com.bytedance.live.livelink.kmp.impl.core.video.c r117 = r116.d();
        if (r117 == null) goto L71;
        r117.q(r10, LiveWrappedVideoSuperResolutionMode.OFF);
        return;
    L71:
        return;
    L70:
        return;
    L72:
        return;
    }

    public final void z(StreamType r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "reason");
        LinkMonitor.a("LinkMediaM", "publishStream", r9 + ", reason=" + r10 + ", rtcClient=" + this.d, null, null, true, 56);
        int r11 = com.bytedance.android.live.livelink.multilink.media.a.a[r9.ordinal()];
        if (r11 != 1) goto L5;
        ei6.a r12 = this.d;
        if (r12 == null) goto L42;
        ri6.b r13 = r12.r();
        if (r13 == null) goto L43;
        r13.s(x0(), false);
        return;
    L43:
        return;
    L42:
        return;
    L5:
        if (r11 != 2) goto L7;
        ei6.a r14 = this.d;
        if (r14 == null) goto L38;
        xi6.c r15 = r14.t();
        if (r15 == null) goto L39;
        com.bytedance.live.livelink.kmp.impl.core.video.b r16 = r15.f();
        if (r16 == null) goto L40;
        r16.e(false);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L7:
        if (r11 != 3) goto L44;
        ei6.a r17 = this.d;
        if (r17 == null) goto L14;
        ri6.b r18 = r17.r();
        if (r18 == null) goto L14;
        r18.s(x0(), false);
    L14:
        ei6.a r19 = this.d;
        if (r19 == null) goto L34;
        xi6.c r20 = r19.t();
        if (r20 == null) goto L35;
        com.bytedance.live.livelink.kmp.impl.core.video.b r21 = r20.f();
        if (r21 == null) goto L36;
        r21.e(false);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void z0(int r8, int r9) {
        LinkMonitor.a("LinkMediaM", "changeVideoResolution", " width: " + r8 + ", height " + r9, null, null, false, 120);
        ec6.b r0 = t0();
        if (r0 == null) goto L8;
        AndroidVideoStreamApi r1 = ((c) r0).e;
        if (r1 == null) goto L9;
        r1.a(r8, r9);
        return;
    L9:
        return;
    }

    public final void Z(StreamType r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r11, "reason");
        if (this.d != null) goto L5;
        return;
    L5:
        LinkMonitor.a("LinkMediaM", "subscribeRemoteStream", r9.ordinal() + " interactId " + r10 + " reason " + r11, null, null, true, 24);
        if (r10 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        int r12 = com.bytedance.android.live.livelink.multilink.media.a.d[r9.ordinal()];
        if (r12 != 1) goto L17;
        ei6.a r13 = this.d;
        if (r13 == null) goto L54;
        ri6.b r0 = r13.r();
        if (r0 == null) goto L55;
        r0.l(x0(), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r10, false, r11);
        return;
    L55:
        return;
    L54:
        return;
    L17:
        if (r12 != 2) goto L19;
        ei6.a r14 = this.d;
        if (r14 == null) goto L50;
        xi6.c r15 = r14.t();
        if (r15 == null) goto L51;
        com.bytedance.live.livelink.kmp.impl.core.video.c r16 = r15.d();
        if (r16 == null) goto L52;
        r16.l(r10, false, r11);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L19:
        if (r12 != 3) goto L56;
        ei6.a r17 = this.d;
        if (r17 == null) goto L26;
        ri6.b r1 = r17.r();
        if (r1 == null) goto L26;
        r1.l(x0(), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r10, false, r11);
    L26:
        ei6.a r18 = this.d;
        if (r18 == null) goto L46;
        xi6.c r19 = r18.t();
        if (r19 == null) goto L47;
        com.bytedance.live.livelink.kmp.impl.core.video.c r20 = r19.d();
        if (r20 == null) goto L48;
        r20.l(r10, false, r11);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L56:
        return;
    L8:
        if (StringsKt.isBlank(r10) == true) goto L11;
        r2 = false;
        goto L12
    }

    public final void t(StreamType r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r11, "reason");
        if (this.d != null) goto L5;
        return;
    L5:
        LinkMonitor.a("LinkMediaM", "unSubscribeRemoteStream", r9.ordinal() + " interactId " + r10, null, null, true, 56);
        if (r10 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        int r12 = com.bytedance.android.live.livelink.multilink.media.a.e[r9.ordinal()];
        if (r12 != 1) goto L17;
        ei6.a r13 = this.d;
        if (r13 == null) goto L54;
        ri6.b r0 = r13.r();
        if (r0 == null) goto L55;
        r0.l(x0(), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r10, true, r11);
        return;
    L55:
        return;
    L54:
        return;
    L17:
        if (r12 != 2) goto L19;
        ei6.a r14 = this.d;
        if (r14 == null) goto L50;
        xi6.c r15 = r14.t();
        if (r15 == null) goto L51;
        com.bytedance.live.livelink.kmp.impl.core.video.c r16 = r15.d();
        if (r16 == null) goto L52;
        r16.l(r10, true, r11);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L19:
        if (r12 != 3) goto L56;
        ei6.a r17 = this.d;
        if (r17 == null) goto L26;
        ri6.b r2 = r17.r();
        if (r2 == null) goto L26;
        r2.l(x0(), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r10, true, r11);
    L26:
        ei6.a r18 = this.d;
        if (r18 == null) goto L46;
        xi6.c r19 = r18.t();
        if (r19 == null) goto L47;
        com.bytedance.live.livelink.kmp.impl.core.video.c r20 = r19.d();
        if (r20 == null) goto L48;
        r20.l(r10, true, r11);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L56:
        return;
    L8:
        if (StringsKt.isBlank(r10) == true) goto L11;
        r1 = false;
        goto L12
    }

    public LinkMediaManager(Context r2, boolean r3, fc6.a r4, bn0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "hostService");
        Intrinsics.checkNotNullParameter(r5, "multiLinkRoomScope");
        this.t = r2;
        this.u = r3;
        this.v = r4;
        this.w = r5;
        this.b = hc6.b.a(r5, Reflection.getOrCreateKotlinClass(tc0.b.class));
        this.e = new hc6.a();
        this.h = new CopyOnWriteArraySet();
        this.i = new CopyOnWriteArraySet();
        this.j = new CopyOnWriteArraySet();
        this.k = new ConcurrentHashMap();
        this.l = LazyKt.lazy(LinkMediaManager$mLiveClientState$2.INSTANCE);
        this.m = LazyKt.lazy(LinkMediaManager$mRtcClientState$2.INSTANCE);
        this.n = LazyKt.lazy(new LinkMediaManager$mLiveSdkParamsAdjuster$2(this));
        this.r = LazyKt.lazy(new LinkMediaManager$IMultiLinkBizAVClientLiveStreamListener$2(this));
        this.s = LazyKt.lazy(new LinkMediaManager$mRtcListener$2(this));
    }

    public final void b0(boolean r18, int r19, ArrayList<String> r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "highPriorityRemoteUsers");
        Intrinsics.checkNotNullParameter(r21, "source");
        ei6.a r6 = this.d;     // Catch: JSONException -> L9
        if (r6 == null) goto L14;
        si6.b r7 = r6.b();     // Catch: JSONException -> L9
        if (r7 == null) goto L15;
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L9
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L9
        r9.put("enable", r18);     // Catch: JSONException -> L9
        r9.put("select_count", r19);     // Catch: JSONException -> L9
        r9.put("high_priority_remote_users", new JSONArray(r20));     // Catch: JSONException -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: JSONException -> L9
        r8.put("rtc.downlink_audio_selection_config", r9);     // Catch: JSONException -> L9
        LinkMonitor.a("LinkMediaM", "setAudioSelect", "enable " + r18 + " selectCount " + r19 + " source " + r21, null, null, false, 120);     // Catch: JSONException -> L9
        r7.d(r8);     // Catch: JSONException -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LinkMonitor.a("LinkMediaM", "setAudioSelect json exception error ", e.getMessage(), null, null, false, 120);
    }

    public final void q0(boolean r18, boolean r19, boolean r20, boolean r21, String r22, LinkPipelineManager.l r23) {
        Intrinsics.checkNotNullParameter(r22, "source");
        LinkMonitor.a("LinkMediaM", "startRtcEngine", "needPushStream " + r18 + " isUserVisible " + r19 + " needSubscribeRemoteAudio " + r20 + " needSubscribeRemoteVideo " + r21 + "[source] " + r22, null, null, false, 120);
        ei6.a r6 = this.d;
        if (r6 == null) goto L74;
        KmpEnv r7 = KmpEnv.a;
        if (v.a() == false) goto L11;
        if (vm2.i.h().c4() == false) goto L11;
        LinkMonitor.a("LinkMediaM", "mock rtc start failed", null, null, null, false, 124);
        w0().H(r6, -1, -12303, new Exception("mock rtc start failed"));
        return;
    L11:
        if (v0().e == false) goto L15;
        LinkMonitor.a("LinkMediaM", "rtc engine is on skip!", null, null, null, false, 124);
        return;
    L15:
        if (v0().c == false) goto L18;
        LinkMonitor.a("LinkMediaM", "rtc engine is starting skip", null, null, null, false, 124);
        return;
    L18:
        fi6.a r8 = r6.g();
        if (r8 == null) goto L26;
        String r9 = r8.v;
        if (r9 == null) goto L26;
        if (StringsKt.isBlank(r9) != true) goto L26;
        LinkMonitor.a("LinkMediaM", "rtc ext info is null or blank", null, null, LinkMonitor.LogLevel.ERROR, false, 108);
        w0().H(r6, -1, -12303, new Exception("rtc ext info is null or blank"));
        return;
    L26:
        v0().c = true;
        v0().b(false, "startRtcEngine");
        r23.E2();
        this.k.clear();
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        this.o = SystemClock.elapsedRealtime();
        InteractLinkFullLinkMonitor.c0();
        String r10 = this.b.x9();     // Catch: Throwable -> L64
        if (r10 == null) goto L32;
        fi6.a r11 = r6.g();     // Catch: Throwable -> L64
        if (r11 == null) goto L32;
        r11.k0 = r10;     // Catch: Throwable -> L64
    L32:
        if (r20 == true) goto L34;
        B(StreamType.AUDIO, r22);     // Catch: Throwable -> L64
    L34:
        if (r21 == true) goto L36;
        B(StreamType.VIDEO, r22);     // Catch: Throwable -> L64
    L36:
        if (r18 == true) goto L46;
        fi6.a r5 = r6.g();     // Catch: Throwable -> L64
        if (r5 == null) goto L40;
        r5.e0 = r19;     // Catch: Throwable -> L64
    L40:
        fi6.a r2 = r6.g();     // Catch: Throwable -> L64
        if (r2 == null) goto L43;
        r2.f0 = r20;     // Catch: Throwable -> L64
    L43:
        fi6.a r3 = r6.g();     // Catch: Throwable -> L64
        if (r3 == null) goto L46;
        r3.g0 = r21;     // Catch: Throwable -> L64
    L46:
        si6.b r4 = r6.b();     // Catch: Throwable -> L64
        if (r4 == null) goto L53;
        si6.b r12 = r6.b();     // Catch: Throwable -> L64
        if (r12 == null) goto L51;
        String r13 = r12.m();     // Catch: Throwable -> L64
    L52:
        si6.a.a(r4, String.valueOf(r13), r18, 12);     // Catch: Throwable -> L64
        goto L53
    L51:
        r13 = null;
    L53:
        Disposable r0 = this.g;     // Catch: Throwable -> L64
        if (r0 == null) goto L56;
        r0.dispose();     // Catch: Throwable -> L64
    L56:
        Disposable r1 = this.f;     // Catch: Throwable -> L64
        if (r1 == null) goto L59;
        r1.dispose();     // Catch: Throwable -> L64
    L59:
        l r14 = l.a;     // Catch: Throwable -> L64
        long r15 = vm2.i.l() * ((long) 1000);     // Catch: Throwable -> L64
        int r16 = p.a;     // Catch: Throwable -> L64
        Disposable r17 = Observable.timer(r15, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.livelink.multilink.media.b(this, r23));     // Catch: Throwable -> L64
        f.a(r17, ((vb6.b) this).a);     // Catch: Throwable -> L64
        this.f = r17;     // Catch: Throwable -> L64
        this.e.a = r6;     // Catch: Throwable -> L64
        ri6.b r24 = r6.r();     // Catch: Throwable -> L64 Exception -> L70
        if (r24 == null) goto L75;
        r24.t1();     // Catch: Throwable -> L64 Exception -> L70
        goto L77
    L76:
        return;
    L75:
        return;
    L77:
        return;
    L64:
        th = move-exception;
        LinkMonitor.a("LinkMediaM", "start rtc crash " + th + " stackTrace=" + ExceptionsKt.stackTraceToString(th), null, null, LinkMonitor.LogLevel.ERROR, false, 108);
        Disposable r25 = this.f;
        if (r25 == null) goto L68;
        r25.dispose();
    L68:
        v0().c = false;
        w0().H(this.d, -1, -12304, new Exception(th));
        return;
    }
}
