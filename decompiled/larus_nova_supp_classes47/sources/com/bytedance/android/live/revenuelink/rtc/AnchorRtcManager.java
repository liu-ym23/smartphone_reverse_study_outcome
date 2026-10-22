package com.bytedance.android.live.revenuelink.rtc;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.anchorlink.linksecurity.LinkSecurityApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.setting.c7;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.m0;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revenue.model.extension.main.IMainRoomLinkExt;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fr2.e0;
import fr2.g0;
import fr2.h0;
import fr2.h1;
import fr2.i0;
import fr2.i1;
import fr2.j0;
import fr2.k1;
import fr2.m1;
import fr2.n0;
import fr2.p0;
import fr2.s0;
import fr2.t0;
import fr2.u1;
import fr2.v;
import fr2.x;
import fr2.y;
import fr2.z;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorRtcManager extends n0 implements i {
    public static final /* synthetic */ int E = 0;
    public final IRoom A;
    public final com.bytedance.android.live.revenuelink.withroom.a B;
    public final p11.c C;
    public final yz0.g D;
    public fr2.e b;
    public fr2.m c;
    public fr2.p d;
    public final CopyOnWriteArrayList<g> e;
    public Disposable f;
    public final d g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public final s o;
    public z p;
    public fr2.n q;
    public final HashSet<String> r;
    public final p s;
    public final ArrayList<fr2.g> t;
    public Integer u;
    public String v;
    public String w;
    public final l x;
    public String y;
    public final Lazy z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void logout() {
        this.m = false;
        fr2.e r0 = this.b;
        if (r0 == null) goto L8;
        u1 r1 = r0.X();
        if (r1 == null) goto L9;
        r1.b();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void o1() {
        this.l = false;
        fr2.e r0 = this.b;
        if (r0 == null) goto L5;
        r0.q();
    L5:
        d r1 = this.g;
        if (r1 == null) goto L8;
        m.d(r1.f, r1.d(), "stop_forward_stream", r1.c(), 8);
    L8:
        jy0.b.c("AnchorRtcManager", "stopForwardStream", null, 4);
    }

    public final void t() {
        this.l = false;
        this.j = false;
        fr2.e r1 = this.b;
        if (r1 == null) goto L5;
        r1.q();
    L5:
        fr2.e r2 = this.b;
        if (r2 == null) goto L8;
        r2.stop(false);
    L8:
        fr2.e r0 = this.b;
        if (r0 == null) goto L12;
        r0.dispose();
    L12:
        if (((Boolean) xa1.f.g.getValue(null, xa1.f.a[5])).booleanValue() == false) goto L18;
        fr2.m r3 = this.c;
        if (r3 == null) goto L18;
        m1 r4 = r3.F4();
        if (r4 == null) goto L21;
        r4.I();
    L21:
        Disposable r5 = this.f;
        if (r5 == null) goto L24;
        r5.dispose();
    L24:
        this.s.b("onDestroy");
        HashSet<String> r6 = this.r;
        if (r6 == null) goto L27;
        r6.clear();
    L27:
        pr2.a r7 = (pr2.a) this.z.getValue();
        if (r7 == null) goto L30;
        r7.release();
    L30:
        l r8 = this.x;
        r8.getClass();
        LinkSecurityApi.VideoCaptureType r9 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
        r8.a.clear();
        return;
    L18:
        fr2.p r10 = m();
        if (r10 == null) goto L21;
        r10.I();
        goto L21
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final boolean F() {
        fr2.n r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.F() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final boolean G() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L9;
        IConfig r1 = r0.getConfig();
        if (r1 == null) goto L9;
        if (r1.G() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void K() {
        Integer r0 = this.u;
        if (r0 == null) goto L16;
        int r1 = r0.intValue();
        j0 r3 = null;
        j0 r2 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(j0.class), null);
        if ((r2 instanceof j0) == false) goto L8;
        r3 = r2;
    L8:
        j0 r4 = r3;
        KmpEnv r5 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r4 != null) goto L11;
        return;
    L11:
        r4.P3(r1);
        fr2.p r6 = m();
        if (r6 == null) goto L14;
        r6.m3(r4);
    L14:
        r4.release();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final p L() {
        p r0 = this.s;
        r0.getClass();
        p r1 = new p();
        r1.a.addAll(r0.a);
        return r1;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final List<vc0.a> L0() {
        ArrayList r0 = new ArrayList();
        ArrayList<fr2.g> r1 = this.t;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(vc0.b.a((fr2.g) r3.next()));
        goto L4
    L6:
        r0.addAll(r2);
        return r0;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void M1() {
        if (this.i == true) goto L5;
        return;
    L5:
        hr2.e.d2.getClass();
        hr2.e r0 = hr2.e.a.a;
        if (r0 != null) goto L8;
        return;
    L8:
        hr2.a r1 = this.b;
        if (r1 != null) goto L11;
        return;
    L11:
        if (hr2.a.class.isAssignableFrom(r1.getClass()) == false) goto L13;
        hr2.a r2 = r1;
    L14:
        if (r2 == null) goto L18;
        r2.p4(r0);
        return;
    L18:
        return;
    L13:
        r2 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String O() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.getRtcRoomId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void O1() {
        if (this.i == true) goto L5;
        return;
    L5:
        String r0 = this.A.getIdStr();
        Iterator<T> r1 = L().l().iterator();
    L7:
        if (r1.hasNext() == false) goto L30;
        o r2 = (o) r1.next();
        if (r2.a() == 2) goto L7;
        Integer r3 = r2.n;
        hr2.a r4 = null;
        if (r3 == null) goto L13;
        Integer r5 = Integer.valueOf(r3.intValue() & (-2));
    L14:
        r2.n = r5;
        hr2.e.d2.getClass();
        hr2.e r6 = hr2.e.a.a;
        if (r6 == null) goto L16;
        xh6.b r7 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(hr2.d.class), new hr2.g(r0, r2.b, r6));
        if ((r7 instanceof hr2.d) == true) goto L20;
        r7 = null;
    L20:
        hr2.d r8 = (hr2.d) r7;
        KmpEnv r9 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r8 == null) goto L22;
        fr2.e r10 = this.b;
        if (r10 == null) goto L7;
        if (hr2.a.class.isAssignableFrom(r10.getClass()) == false) goto L28;
        r4 = (hr2.a) r10;
    L28:
        if (r4 == null) goto L7;
        r4.L4(r8, false);
        goto L7
    L22:
        return;
    L16:
        return;
    L13:
        r5 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final com.bytedance.android.live.revenuelink.b P() {
        return new com.bytedance.android.live.revenuelink.b(this.B, this.D);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final vc0.a P0() {
        fr2.n r0 = this.q;
        gr2.g r1 = null;
        if (r0 != null) goto L5;
    L12:
        return null;
    L5:
        if (r0.k3() == null) goto L12;
        fr2.n r2 = this.q;
        if (r2 == null) goto L10;
        r1 = r2.k3();
    L10:
        Intrinsics.checkNotNull(r1);
        return vc0.b.a(r1);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void U() {
        this.g.f(false, 0);
        fr2.m r0 = this.c;
        if (r0 == null) goto L6;
        r0.U();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String U0() {
        fr2.n r4 = this.q;
        String r5 = null;
        if (r4 == null) goto L5;
        gr2.j r6 = r4.getMixStreamType();
    L6:
        IConfig.c.d1.getClass();
        if (Intrinsics.areEqual(r6, IConfig.c.a.a) == false) goto L10;
        String r7 = "SERVER_MIX";
    L25:
        StringBuilder r8 = new StringBuilder("合流方式：");     // Catch: Exception -> L24
        r8.append(r7);     // Catch: Exception -> L24
        r8.append(" \n \nRTC推流参数：");     // Catch: Exception -> L24
        String r3 = this.v;     // Catch: Exception -> L24
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        JSONObject r2 = new JSONObject(r3).optJSONObject("live_rtc_video_param");     // Catch: Exception -> L24
        if (r2 == null) goto L22;
        r5 = r2.toString();     // Catch: Exception -> L24
    L22:
        r8.append(r5);     // Catch: Exception -> L24
        r8.append(" \n \nLiveCore推流参数：");     // Catch: Exception -> L24
        r8.append(this.w);     // Catch: Exception -> L24
        r8.append('\n');     // Catch: Exception -> L24
        return r8.toString();
    L27:
        return "";
    L10:
        if (Intrinsics.areEqual(r6, IConfig.c.a.b) == false) goto L13;
        r7 = "CLIENT_MIX";
        goto L25
    L13:
        if (Intrinsics.areEqual(r6, IConfig.c.a.c) == false) goto L15;
        r7 = "RTC_CLIENT_MIX";
        goto L25
    L15:
        r7 = "error";
        goto L25
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String c0() {
        fr2.e r0 = this.b;
        if (r0 != null) goto L8;
        String r1 = this.y;
        if (r1 != null) goto L20;
        return "";
    L20:
        return r1;
    L8:
        IConfig r2 = null;
        if (r0 == null) goto L11;
        IConfig r3 = r0.getConfig();
    L13:
        if ((r3 instanceof fr2.n) == false) goto L16;
        r2 = r3;
    L16:
        fr2.n r4 = (fr2.n) r2;
        if (r4 == null) goto L21;
        r1 = r4.getLinkerSessionId();
        if (r1 != null) goto L20;
        return "";
    L21:
        return "";
    L11:
        r3 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final pc0.e createRtcData() {
        m0 r6 = new m0(this.b, this.i, h0.a(this.s.d()), m(), false);
        this.i = false;
        this.p = null;
        pc0.e.a r0 = pc0.e.f;
        return com.bytedance.android.live.revenue.common.n0.a(r6);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final pc0.e e() {
        m0 r6 = new m0(this.b, this.i, h0.a(this.s.d()), m(), this.k);
        pc0.e.a r0 = pc0.e.f;
        return com.bytedance.android.live.revenue.common.n0.a(r6);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void f() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String f0() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L7;
        gr2.h r1 = r0.getRtcExtInfo();
        if (r1 == null) goto L7;
        String r2 = r1.getInteractId();
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String getBusinessId() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.getBusinessId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final vc0.a getLiveCore() {
        fr2.m r0 = this.c;
        if (r0 == null) goto L6;
        fr2.p r1 = r0.getLiveCore();
        if (r1 == null) goto L6;
    L7:
        if (r1 != null) goto L11;
        return null;
    L11:
        return vc0.b.a(r1);
    L6:
        r1 = this.d;
        goto L7
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String getLiveCoreExtInfo() {
        String r0 = this.w;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final int getMixType() {
        fr2.n r0 = this.q;
        if (r0 == null) goto L5;
        gr2.j r1 = r0.getMixStreamType();
    L6:
        IConfig.c.d1.getClass();
        if (Intrinsics.areEqual(r1, IConfig.c.a.a) == false) goto L10;
        return 1;
    L10:
        if (Intrinsics.areEqual(r1, IConfig.c.a.b) == false) goto L13;
        return 2;
    L13:
        if (Intrinsics.areEqual(r1, IConfig.c.a.c) == false) goto L15;
        return 3;
    L15:
        return 0;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final String getRtcExtInfo() {
        String r0 = this.v;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void j() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        d r1 = this.g;
        if (r1 == null) goto L9;
        jy0.b.f(r1.a, "startPushData", null, 4);
        m.d(r1.f, r1.d(), "push_data_in_advance", r1.c(), 8);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void n() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void n1() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L5;
        r0.x1();
    L5:
        fr2.e r1 = this.b;
        if (r1 == null) goto L9;
        r1.f();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void o() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.o();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void onPause() {
        if (this.i == false) goto L6;
        y1(false, "AnchorRtcManager onPause");
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void onResume() {
        if (this.i == false) goto L6;
        y1(true, "AnchorRtcManager onResume");
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void q0() {
        fr2.e r0 = this.b;
        if (r0 == null) goto L8;
        IConfig r1 = r0.getConfig();
        if (r1 == null) goto L9;
        r1.q0();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void L1() {
        fr2.p r0 = m();
        if (r0 == null) goto L5;
        List r1 = r0.getUrls();
    L6:
        d r2 = this.g;
        boolean r3 = false;
        if (r1 == null) goto L9;
        int r4 = r1.size();
    L10:
        r2.f(true, r4);
        List r5 = r1;
        if (r5 != null) goto L13;
    L14:
        r3 = true;
    L15:
        if (r3 == true) goto L20;
        fr2.m r6 = this.c;
        if (r6 == null) goto L21;
        r6.h1(r1);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        if (r5.isEmpty() == false) goto L15;
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final fr2.p m() {
        vc0.a r0 = getLiveCore();
        if (r0 != null) goto L7;
        return null;
    L7:
        return i0.a(r0);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final boolean Q0() {
        return this.h;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final boolean g0() {
        return this.l;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final boolean hasLogin() {
        return this.m;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final boolean isEngineOn() {
        return this.i;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void B(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        fr2.e r0 = this.b;
        if (r0 == null) goto L8;
        u1 r1 = r0.X();
        if (r1 == null) goto L9;
        r1.e(r2);
        return;
    L9:
        return;
    }

    public final void D4(boolean r7) {
        fr2.e r0 = this.b;
        if (r0 == null) goto L5;
        r0.D4(r7);
    L5:
        d r1 = this.g;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.i.getRevenueLinkTraceMonitor().X("enable_remote_session_render") == true) goto L20;
        HashMap<String, Object> r2 = r1.c();
        if (r7 == false) goto L13;
        String r3 = DataType.TRUE;
    L14:
        r2.put("enable", r3);
        m.d(r1.f, r1.d(), "enable_remote_session_render", r2, 8);
        if (r7 == false) goto L19;
        m.d(r1.f, LiveTracingMonitorKt.EventModule.PK, "mix_stream_in_advance", null, 12);
        return;
    L19:
        return;
    L13:
        r3 = DataType.FALSE;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void I1(vc0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "streamMixer");
        Object r0 = r4.b;
        p0 r2 = null;
        if ((r0 instanceof xh6.c) == true) goto L5;
        p0 r5 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(p0.class), r4.a);
        if ((r5 instanceof p0) == false) goto L12;
        r2 = r5;
    L12:
        p0 r1 = r2;
    L13:
        if (r1 != null) goto L15;
        return;
    L15:
        fr2.n r6 = this.q;
        if (r6 == null) goto L18;
        r6.V3(r1);
    L18:
        fr2.e r7 = this.b;
        if (r7 == null) goto L22;
        r7.f();
        return;
    L22:
        return;
    L5:
        if ((r0 instanceof p0) == true) goto L7;
        r0 = null;
    L7:
        r1 = (p0) r0;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void J(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.J(r2);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void N0(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.N0(r2);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void N1(boolean r4) {
        if (((Boolean) xa1.f.h.getValue(null, xa1.f.a[6])).booleanValue() == false) goto L7;
        boolean r0 = !r4;
        fr2.e r1 = this.b;
        if (r1 == null) goto L10;
        r1.t3(r4, r0);
    L10:
        fr2.e r5 = this.b;
        if (r5 == null) goto L14;
        r5.f();
        return;
    L14:
        return;
    L7:
        fr2.e r2 = this.b;
        if (r2 == null) goto L10;
        r2.t3(r4, false);
        goto L10
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void O0(String r6) {
        Intrinsics.checkNotNullParameter(r6, "interactId");
        d r0 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "linkmicId");
        HashMap<String, Object> r1 = r0.c();
        r1.put("subscribe", String.valueOf(false));
        r1.put("linkmic_id", r6);
        m.d(r0.f, r0.d(), "subscribe_stream_audio", r1, 8);
        fr2.e r2 = this.b;
        if (r2 == null) goto L6;
        r2.w1(r6);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void Q1(String r6) {
        Intrinsics.checkNotNullParameter(r6, "interactId");
        d r0 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "linkmicId");
        HashMap<String, Object> r1 = r0.c();
        r1.put("subscribe", String.valueOf(false));
        r1.put("linkmic_id", r6);
        m.d(r0.f, r0.d(), "subscribe_stream_video", r1, 8);
        fr2.e r2 = this.b;
        if (r2 == null) goto L6;
        r2.c4(r6);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void R0(String r9) {
        Intrinsics.checkNotNullParameter(r9, "rtcExtInfo");
        JSONObject r10 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r9), "live_rtc_engine_config");     // Catch: JSONException -> L11
        String r4 = JSONObjectProtectorUtils.getString(r10, "rtc_token");     // Catch: JSONException -> L11
        String r12 = JSONObjectProtectorUtils.getString(r10, "rtc_user_id");     // Catch: JSONException -> L11
        this.m = true;     // Catch: JSONException -> L11
        fr2.e r5 = this.b;     // Catch: JSONException -> L11
        if (r5 == null) goto L8;
        u1 r6 = r5.X();     // Catch: JSONException -> L11
        if (r6 == null) goto L8;
        long r7 = r6.a(r4, r12);     // Catch: JSONException -> L11
    L9:
        jy0.b.c("AnchorRtcManager", "login token:" + r4 + " userId:" + r12 + " code:" + r7, null, 4);     // Catch: JSONException -> L11
        this.g.q(r7);     // Catch: JSONException -> L11
        return;
    L8:
        r7 = -1005;
    L11:
        e = move-exception;
        jy0.b.c("AnchorRtcManager", "login json exception " + e.getMessage(), null, 4);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void V0(List<String> r6) {
        z r0 = new z();
        String r1 = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r0.a = "";
        if (r6 != null) goto L5;
    L10:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        fr2.e r7 = this.b;
        if (r7 == null) goto L13;
        r7.E3(r0);
    L13:
        this.p = r0;
        d r8 = this.g;
        if (r8 == null) goto L17;
        String r2 = r0.b;
        String r3 = r0.a;
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "url");
        HashMap<String, Object> r4 = r8.c();
        r4.put("path", r2);
        r4.put("url", r3);
        m.d(r8.f, r8.d(), "update_effect", r4, 8);
        return;
    L17:
        return;
    L5:
        if ((!r6.isEmpty()) != true) goto L10;
        String r9 = (String) ListProtector.get(r6, 0);
        if (r9 == null) goto L10;
        r1 = r9;
        goto L10
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void Z0(String r5) {
        if (this.i == true) goto L5;
        return;
    L5:
        String r0 = this.A.getIdStr();
        o r6 = L().k(r5);
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.a() == 2) goto L31;
        Integer r1 = r6.n;
        hr2.a r2 = null;
        if (r1 == null) goto L12;
        Integer r3 = Integer.valueOf(r1.intValue() & (-2));
    L13:
        r6.n = r3;
        hr2.e.d2.getClass();
        hr2.e r4 = hr2.e.a.a;
        if (r4 != null) goto L16;
        return;
    L16:
        xh6.b r7 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(hr2.d.class), new hr2.g(r0, r6.b, r4));
        if ((r7 instanceof hr2.d) == true) goto L19;
        r7 = null;
    L19:
        hr2.d r8 = (hr2.d) r7;
        KmpEnv r9 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r8 != null) goto L22;
        return;
    L22:
        fr2.e r10 = this.b;
        if (r10 != null) goto L25;
        return;
    L25:
        if (hr2.a.class.isAssignableFrom(r10.getClass()) == false) goto L27;
        r2 = (hr2.a) r10;
    L27:
        if (r2 == null) goto L33;
        r2.L4(r8, false);
        return;
    L33:
        return;
    L12:
        r3 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "businessId");
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void g1(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.e.contains(r2) == false) goto L5;
        return;
    L5:
        this.e.add(r2);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void i(boolean r4) {
        hr2.a r5 = this.b;
        hr2.a r0 = null;
        if (r5 != null) goto L5;
    L10:
        fr2.e r6 = this.b;
        if (r6 != null) goto L13;
        return;
    L13:
        if (hr2.a.class.isAssignableFrom(r6.getClass()) == false) goto L15;
        r0 = (hr2.a) r6;
    L15:
        if (r0 == null) goto L19;
        r0.disableRemoteOrientation();
        return;
    L19:
        return;
    L5:
        if (hr2.a.class.isAssignableFrom(r5.getClass()) == false) goto L7;
        hr2.a r7 = r5;
    L8:
        if (r7 == null) goto L10;
        r7.i(false);
        goto L10
    L7:
        r7 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void i1(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.remove(r2);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void j1(vc0.a r5) {
        fr2.e r0 = this.b;
        if (r0 == null) goto L19;
        IConfig.c r1 = null;
        Object r2 = null;
        xh6.c r3 = null;
        if (r5 == null) goto L18;
        Object r4 = r5.b;
        if ((r4 instanceof xh6.c) == true) goto L9;
        xh6.c r6 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(IConfig.c.class), r5.a);
        if ((r6 instanceof IConfig.c) == false) goto L17;
        r3 = r6;
    L17:
        r1 = (IConfig.c) r3;
        goto L18
    L9:
        if ((r4 instanceof IConfig.c) == false) goto L12;
        r2 = r4;
    L12:
        r1 = (IConfig.c) r2;
    L18:
        r0.B1(r1);
    L19:
        d r7 = this.g;
        HashMap<String, Object> r8 = r7.c();
        r8.put("mixOnClient", DataType.FALSE);
        m.d(r7.f, r7.d(), "switch_mix_type", r8, 8);
        this.x.a("switch_mix_type");
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "waterMarkId");
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void muteLocalVideo(boolean r5) {
        fr2.e r0 = this.b;
        if (r0 == null) goto L5;
        r0.muteLocalVideo(r5);
    L5:
        d r1 = this.g;
        if (r1 == null) goto L9;
        HashMap<String, Object> r2 = r1.c();
        r2.put("mute", String.valueOf(r5));
        m.d(r1.f, r1.d(), "mute_local_video", r2, 8);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void q1(String r6) {
        Intrinsics.checkNotNullParameter(r6, "src");
        this.h = true;
        fr2.e r1 = this.b;
        if (r1 == null) goto L5;
        r1.z1();
    L5:
        d r2 = this.g;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r6, "src");
        jy0.b.f(r2.a, "startInteract src=".concat(r6), null, 4);
        m r0 = r2.f;
        LiveTracingMonitorKt.EventModule r3 = r2.d();
        HashMap<String, Object> r4 = r2.c();
        r4.put("source", r6);
        Unit r7 = Unit.INSTANCE;
        m.d(r0, r3, "start_interact", r4, 8);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void x(boolean r2) {
        fr2.p r0 = m();
        if (r0 == null) goto L6;
        r0.x(r2);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void A(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "linkmicId");
        Intrinsics.checkNotNullParameter(r8, Constants.OperatorKey.MSG);
        if (StringsKt.contains$default(r8, "rtmp_set_custom_sei", false, 2, null) == true) goto L5;
        d r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r7, "linkmicId");
        jy0.b.f(r2.a, "monitorSendUserMessage msg=" + r8, null, 4);
        m r0 = r2.f;
        LiveTracingMonitorKt.EventModule r3 = r2.d();
        HashMap<String, Object> r4 = r2.c();
        r4.put(Constants.OperatorKey.MSG, r8);
        r4.put("linkmic_id", r7);
        Unit r1 = Unit.INSTANCE;
        m.d(r0, r3, "send_user_message", r4, 8);
    L5:
        fr2.e r5 = this.b;
        if (r5 == null) goto L9;
        r5.A(r7, r8);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void F1(LiveTracingMonitorKt.EventModule r4, com.bytedance.android.live.revlink.impl.multianchor.connect.m r5) {
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        Intrinsics.checkNotNullParameter(r5, FileUtils.FILTER);
        d r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        Intrinsics.checkNotNullParameter(r5, FileUtils.FILTER);
        m r3 = r2.f;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        Intrinsics.checkNotNullParameter(r5, FileUtils.FILTER);
        r3.b.put(r4, r5);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void H1(long r9, String r12) {
        Intrinsics.checkNotNullParameter(r12, "reqFrom");
        Iterator<fr2.g> r1 = this.t.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        fr2.g r2 = r1.next();
        if (Intrinsics.areEqual(r2.getRoomId(), String.valueOf(r9)) == false) goto L4;
        jy0.b.c("multi_rtc stop", String.valueOf(r9) + r2.getRtcExtInfo(), null, 4);
        r1.remove();
        goto L4
    L8:
        d r3 = this.g;
        ArrayList<fr2.g> r4 = this.t;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "forwardRoomList");
        Intrinsics.checkNotNullParameter(r12, "reqFrom");
        HashMap<String, Object> r0 = r3.c();
        r0.put("remove_roomid", String.valueOf(r9));
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<fr2.g> r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.add(r6.next().getRoomId());
        goto L10
    L12:
        r0.put("forward_rooms", r5.toString());
        r0.put("req_from", r12);
        m.d(r3.f, r3.d(), "update_stop_forward_stream", r0, 8);
        fr2.e r7 = this.b;
        if (r7 == null) goto L15;
        r7.D2(this.t);
    L15:
        StringBuilder r8 = new StringBuilder("stopForwardStreamTo ");
        r8.append(r9);
        r8.append(", reqFrom=");
        r8.append(r12);
        r8.append(" forwardRoomInfoList=");
        ArrayList<fr2.g> r10 = this.t;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<fr2.g> r14 = r10.iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        r13.add(r14.next().getRoomId());
        goto L17
    L19:
        r8.append(r13);
        jy0.b.c("AnchorRtcManager", r8.toString(), null, 4);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final long M(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "uid");
        Intrinsics.checkNotNullParameter(r13, "message");
        x r1 = s0.a;
        if (r1 != null) goto L6;
        return 0;
    L6:
        fr2.e r2 = this.b;
        if (r2 == null) goto L11;
        u1 r3 = r2.X();
        if (r3 == null) goto L11;
        long r4 = r3.c(r12, r13, r1);
    L12:
        d r14 = this.g;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r12, "uid");
        HashMap<String, Object> r7 = r14.c();
        r14.f.f(r14.d(), "send_msg_outside", r12, r7, (int) r4, "");
        return r4;
    L11:
        r4 = -3;
        goto L12
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void Q(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "src");
        String r2 = null;
        jy0.b.f("AnchorRtcManager", "updateRtcExtInfo " + r6, null, 4);
        fr2.p r0 = m();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.a());
    L6:
        boolean r3 = true;
        if ((!Intrinsics.areEqual(r1, Boolean.TRUE)) == false) goto L11;
        fr2.p r4 = m();
        if (r4 == null) goto L11;
        r4.N();
    L11:
        this.v = r6;
        if (r6 != null) goto L14;
    L19:
        if (r6 != null) goto L21;
        return;
    L21:
        if (r6.length() > 0) goto L24;
        r3 = false;
    L24:
        if (r3 == false) goto L26;
        r2 = r6;
    L26:
        if (r2 == null) goto L36;
        fr2.e r5 = this.b;
        if (r5 == null) goto L30;
        r5.c(r6);
    L30:
        d r8 = this.g;
        if (r8 == null) goto L33;
        HashMap<String, Object> r9 = r8.c();
        r9.put("rtc_params", r6);
        m.d(r8.f, r8.d(), "update_rtc_params", r9, 8);
    L33:
        this.x.a("switch_resolution");
        i.a.a(this, r6, r7);
        return;
    L36:
        return;
    L14:
        if (r6.length() != 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 != true) goto L19;
        this.g.g(r7);
        goto L19
    L16:
        r10 = false;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void R1(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        p r1 = this.s;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "interactId");
        o r5 = r1.k(r3);
        if (r5 == null) goto L6;
        r5.k = r4;
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void T(String r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "src");
        jy0.b.c("AnchorRtcManager", r10 + "---" + r12, null, 4);
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L12;
        return;
    L12:
        if (this.b != null) goto L14;
        return;
    L14:
        if (this.i == false) goto L63;
        this.w = r10;
        k r6 = k.j;
        r6.getClass();
        if (((Boolean) k.d.getValue(r6, k.a[2])).booleanValue() == true) goto L19;
    L21:
        if (r10 != null) goto L23;
        return;
    L23:
        if (r10.length() > 0) goto L26;
        r0 = false;
    L26:
        if (r0 == false) goto L28;
        String r1 = r10;
    L29:
        if (r1 == null) goto L59;
        fr2.p r2 = m();
        if (r2 == null) goto L35;
        k1 r3 = r2.getBuilder();
        if (r3 == null) goto L35;
        Integer r4 = Integer.valueOf(r3.b());
    L36:
        jy0.b.f("AnchorRtcManager", "updateLiveCoreExtInfo ".concat(r10), null, 4);
        d r7 = this.g;
        HashMap<String, Object> r8 = r7.c();
        r8.put("liveCore", r10);
        if (r12 != null) goto L39;
        String r9 = "";
    L40:
        r8.put("update_src", r9);
        m.d(r7.f, r7.d(), "update_live_core", r8, 8);
        fr2.e r13 = this.b;
        if (r13 == null) goto L43;
        r13.y(r10);
    L43:
        fr2.p r14 = m();
        if (r14 == null) goto L46;
        r14.y(r10);
    L46:
        r(r10, r12, null);
        if (r4 == null) goto L64;
        fr2.p r15 = m();
        if (r15 == null) goto L60;
        k1 r16 = r15.getBuilder();
        if (r16 != null) goto L54;
        return;
    L54:
        if (r4.intValue() == r16.b()) goto L62;
        this.u = r4;
        return;
    L62:
        return;
    L60:
        return;
    L64:
        return;
    L39:
        r9 = r12;
    L35:
        r4 = null;
        goto L36
    L59:
        return;
    L28:
        r1 = null;
        goto L29
    L19:
        if (this.j == true) goto L21;
        return;
    L63:
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void T1(String r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "reqSrc");
        long r4 = this.C.A();
        StringBuilder r6 = new StringBuilder("stopEngine reqSrc = ");
        r6.append(r18);
        r6.append(", videoXplayRunning: ");
        r6.append(r19);
        r6.append(", punishRemainTime = ");
        r6.append(r4);
        r6.append(",realAudioMute = ");
        fr2.m r7 = this.c;
        if (r7 == null) goto L5;
        Boolean r8 = Boolean.valueOf(r7.w0());
    L6:
        r6.append(r8);
        jy0.b.f("AnchorRtcManager", r6.toString(), null, 4);
        this.i = false;
        this.l = false;
        this.j = false;
        this.k = false;
        d r9 = this.g;
        fr2.m r10 = this.c;
        if (r10 == null) goto L9;
        boolean r12 = r10.w0();
    L10:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r18, "reqSrc");
        HashMap<String, Object> r13 = r9.c();
        r13.put("req_src", r18);
        r13.put("punish_remain_time", Long.valueOf(r4));
        r13.put("real_audio_mute", Boolean.valueOf(r12));
        m.d(r9.f, r9.d(), "stop_interact_streaming", r13, 8);
        if (this.b != null) goto L13;
        d r14 = this.g;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r18, "reqSrc");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("req_src", r18);
        m.d(r14.f, r14.d(), "trace_null_client", r3, 8);
    L13:
        fr2.e r5 = this.b;
        if (r5 == null) goto L16;
        r5.q();
    L16:
        fr2.e r15 = this.b;
        if (r15 == null) goto L19;
        r15.stop(r19);
    L19:
        fr2.e r16 = this.b;
        if (r16 == null) goto L22;
        r16.dispose();
    L22:
        fr2.e r17 = this.b;
        if (r17 == null) goto L25;
        r17.n3(null);
    L25:
        k r20 = k.j;
        r20.getClass();
        if (((Boolean) k.c.getValue(r20, k.a[1])).booleanValue() == false) goto L30;
        fr2.e r22 = this.b;
        if (r22 == null) goto L30;
        r22.A1(false);
    L30:
        this.b = null;
        if (r4 <= 0) goto L41;
        fr2.m r23 = this.c;
        if (r23 != null) goto L35;
    L36:
        fr2.m r24 = this.c;
        if (r24 == null) goto L41;
        fr2.p r25 = r24.getLiveCore();
        if (r25 == null) goto L41;
        r25.setAudioMute(false);
        goto L41
    L35:
        if (r23.w0() != true) goto L36;
    L41:
        if (r19 == false) goto L43;
    L52:
        fr2.p r2 = m();
        if (r2 == null) goto L55;
        r2.I();
    L55:
        i97.a r26 = i97.a.a;
        long r27 = System.currentTimeMillis();
        d r28 = this.g;
        HashMap<String, Object> r110 = r28.c();
        r110.put(Constants.Keys.duration, Long.valueOf(System.currentTimeMillis() - r27));
        m.g(r28.f, r28.d(), "did_leave_channel", "", r110, 0, 48);
        jy0.b.f(r28.a, "onRtcEndSuccess cost " + (System.currentTimeMillis() - r27) + "ms", null, 4);
        fr2.e r29 = this.b;
        if (r29 == null) goto L58;
        r29.s1();
    L58:
        Disposable r30 = this.f;
        if (r30 == null) goto L61;
        r30.dispose();
    L61:
        Disposable r32 = this.f;
        if (r32 == null) goto L64;
        r32.dispose();
    L64:
        this.e.clear();
        HashSet<String> r33 = this.r;
        if (r33 == null) goto L67;
        r33.clear();
    L67:
        this.s.b("stopEngine_".concat(r18));
        return;
    L43:
        if (((Boolean) xa1.f.g.getValue(null, xa1.f.a[5])).booleanValue() == false) goto L49;
        fr2.m r34 = this.c;
        if (r34 == null) goto L49;
        m1 r35 = r34.F4();
        if (r35 == null) goto L52;
        r35.I();
    L49:
        fr2.p r36 = m();
        if (r36 == null) goto L52;
        r36.I();
        goto L52
    L9:
        r12 = false;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void b1(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "interactId");
        StringBuilder r1 = new StringBuilder("enableRemoteVideoRender ");
        r1.append(r6);
        r1.append(' ');
        r1.append(r7);
        r1.append(' ');
        if (this.i == true) goto L5;
        String r2 = "rtcOff";
    L6:
        r1.append(r2);
        jy0.b.f("AnchorRtcManager", r1.toString(), null, 4);
        fr2.e r3 = this.b;
        if (r3 == null) goto L9;
        r3.s2(r6, !r7);
    L9:
        p r4 = this.s;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "interactId");
        o r8 = r4.k(r6);
        if (r8 == null) goto L13;
        r8.l = Boolean.valueOf(r7);
        return;
    L13:
        return;
    L5:
        r2 = "";
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void k1(pc0.e r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "source");
        jy0.b.c("AnchorRtcManager", "setClient source=" + r13 + ", " + r12, null, 4);
        if (r12 == null) goto L35;
        Intrinsics.checkNotNullParameter(r12, "$this$toRtcData");
        vc0.a r14 = r12.a;
        if (r14 == null) goto L16;
        Object r0 = r14.b;
        if ((r0 instanceof xh6.c) == true) goto L9;
        xh6.c r15 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.e.class), r14.a);
        if ((r15 instanceof fr2.e) == true) goto L15;
        r15 = null;
    L15:
        fr2.e r1 = (fr2.e) r15;
    L17:
        HashMap r16 = h0.a(r12.c);
        vc0.a r2 = r12.d;
        if (r2 == null) goto L20;
        fr2.p r3 = i0.a(r2);
    L21:
        boolean r4 = r12.b;
        boolean r5 = r12.e;
        Intrinsics.checkNotNullParameter(r16, "remoteMap");
        this.b = r1;
        this.d = r3;
        this.i = r4;
        p r6 = this.s;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r16, "remoteViewMap");
        int r7 = w51.a.a;
        String r8 = "onSetAnchorClient remoteViewMap=" + r16 + " current=" + r6.a;
        Intrinsics.checkNotNullParameter("ttlive_anchor_link_rtc_user", "tag");
        Intrinsics.checkNotNullParameter(r8, Constants.OperatorKey.MSG);
        ALogger.w("ttlive_anchor_link_rtc_user", r8);
        r6.a.clear();
        Iterator r17 = r16.entrySet().iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        Map.Entry r9 = (Map.Entry) r17.next();
        r6.a.add(new o((String) r9.getKey(), r9.getValue(), true, 8184));
        goto L23
    L25:
        fr2.e r18 = this.b;
        if (r18 == null) goto L28;
        r18.n3(this.o);
    L28:
        if (r1 == null) goto L30;
        IConfig r19 = r1.getConfig();
    L31:
        fr2.n r110 = (fr2.n) r19;
        this.q = r110;
        if (r110 == null) goto L34;
        r110.R4(((Boolean) xa1.f.m.getValue(null, xa1.f.a[11])).booleanValue());
    L34:
        this.k = r5;
        goto L35
    L30:
        r19 = null;
        goto L31
    L20:
        r3 = null;
        goto L21
    L9:
        if ((r0 instanceof fr2.e) == true) goto L11;
        r0 = null;
    L11:
        r1 = (fr2.e) r0;
        goto L17
    L16:
        r1 = null;
    L35:
        if (r12 == null) goto L37;
        vc0.a r111 = r12.a;
    L38:
        if (r111 == null) goto L40;
        return;
    L40:
        if (((Boolean) xa1.f.b.getValue(null, xa1.f.a[0])).booleanValue() == false) goto L45;
        jy0.b.e("ttlive_pk", "AnchorRtcManager.setClient", new IllegalStateException());
        return;
    L45:
        return;
    L37:
        r111 = null;
        goto L38
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void p0(boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        fr2.e r1 = this.b;
        if (r1 == null) goto L5;
        r1.p0(r5, r6);
    L5:
        fr2.m r2 = this.c;
        if (r2 == null) goto L10;
        fr2.p r3 = r2.getLiveCore();
        if (r3 == null) goto L10;
        r3.setAudioMute(r5);
    L10:
        d r4 = this.g;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "reason");
        HashMap<String, Object> r7 = r4.c();
        r7.put("mute", String.valueOf(r5));
        r7.put("reason", r6);
        m.d(r4.f, r4.d(), "muteLocalAudio", r7, 8);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void y1(boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        long r1 = this.C.A();
        if (r1 > 0) goto L7;
        fr2.e r3 = this.b;
        if (r3 == null) goto L7;
        r3.u1(r7);
    L7:
        d r4 = this.g;
        String r9 = r8 + ", punishRemainTime = " + r1;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r9, "reason");
        HashMap<String, Object> r2 = r4.c();
        r2.put("enable", String.valueOf(r7));
        r2.put("reason", r9);
        m.d(r4.f, r4.d(), "switch_audio", r2, 8);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void D1(String r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "interactId");
        Intrinsics.checkNotNullParameter(r7, "reason");
        jy0.b.f("AnchorRtcManager", "muteRemoteVideo " + r5 + ' ' + r6 + ", reason=" + r7 + " rtcOn=" + this.i, null, 4);
        fr2.e r8 = this.b;
        if (r8 == null) goto L5;
        r8.r1(r5, r6);
    L5:
        p r9 = this.s;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r5, "interactId");
        o r10 = r9.k(r5);
        if (r10 == null) goto L9;
        r10.h = r6;
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void G1(String r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "interactId");
        Intrinsics.checkNotNullParameter(r10, "reason");
        fr2.e r2 = this.b;
        if (r2 != null) goto L5;
        return;
    L5:
        d r3 = this.g;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "interactId");
        Intrinsics.checkNotNullParameter(r10, "reason");
        HashMap<String, Object> r4 = r3.c();
        r4.put("mute", String.valueOf(r9));
        r4.put("interactId", r8);
        r4.put("reason", r10);
        m.d(r3.f, r3.d(), "muteRemoteAudioPlayVolume", r4, 8);
        jy0.b.f("AnchorRtcManager", "muteRemoteAudioPlayVolume " + r8 + ' ' + r9, null, 4);
        k r1 = k.j;
        r1.getClass();
        int r5 = 100;
        if (((Boolean) k.i.getValue(r1, k.a[7])).booleanValue() == false) goto L12;
        fr2.e r6 = this.b;
        if (r6 == null) goto L20;
        if (r9 == false) goto L11;
        r5 = 0;
    L11:
        r6.b0(r8, r5, r10);
    L20:
        p r12 = this.s;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r8, "interactId");
        o r13 = r12.k(r8);
        if (r13 == null) goto L24;
        r13.m = r9;
        return;
    L24:
        return;
    L12:
        fr2.e r14 = this.b;
        if (r14 == null) goto L20;
        u1 r15 = r14.X();
        if (r15 == null) goto L20;
        String r7 = r2.getRtcRoomId();
        if (r9 == false) goto L19;
        r5 = 0;
    L19:
        r15.d(r7, r8, r5);
        goto L20
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void P1(boolean r7, String r8, List<String> r9) {
        boolean r0 = false;
        if (r7 == false) goto L25;
        if (r8 == null) goto L25;
        o r10 = this.s.k(r8);
        if (r10 == null) goto L8;
        this.s.j(r8);
    L8:
        List<String> r12 = r9;
        if (r12 != null) goto L11;
    L12:
        r0 = true;
    L14:
        if ((!r0) == false) goto L16;
        List<String> r13 = r9;
    L18:
        if (r13 == null) goto L23;
        Iterator<T> r14 = r13.iterator();
    L21:
        if (r14.hasNext() == false) goto L23;
        String r3 = (String) r14.next();
        jy0.b.c("AnchorRtcManager", "remove invalidLinkIds: " + r3, null, 4);
        this.s.j(r3);
    L23:
        jy0.b.c("AnchorRtcManager", "doClear4StopWithLinkAudience remove " + r10 + ", invalid:" + r9 + ", " + this.s, null, 4);
        return;
    L16:
        r13 = null;
        goto L18
    L11:
        if (r12.isEmpty() == false) goto L14;
    L25:
        this.p = null;
        this.i = false;
        this.k = true;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void S1(String r4, vc0.a r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "waterMarkId");
        Intrinsics.checkNotNullParameter(r5, "regionArg");
        Object r0 = r5.b;
        e0 r2 = null;
        if ((r0 instanceof xh6.c) == true) goto L5;
        e0 r7 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(e0.class), r5.a);
        if ((r7 instanceof e0) == false) goto L12;
        r2 = r7;
    L12:
        e0 r1 = r2;
    L13:
        if (r1 != null) goto L15;
        return;
    L15:
        fr2.e r8 = this.b;
        if (r8 == null) goto L19;
        r8.o4(r4, r1, r6);
        return;
    L19:
        return;
    L5:
        if ((r0 instanceof e0) == true) goto L7;
        r0 = null;
    L7:
        r1 = (e0) r0;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final Integer a1(Map<Long, String> r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r14, "reqFrom");
        Intrinsics.checkNotNullParameter(r15, "channelId");
        ArrayList r2 = new ArrayList();
        Iterator<Map.Entry<Long, String>> r3 = r13.entrySet().iterator();
    L3:
        fr2.g r6 = null;
        if (r3.hasNext() == false) goto L14;
        Map.Entry<Long, String> r4 = r3.next();
        if (r4.getKey().longValue() == IRoomKtKt.getId(this.A)) goto L3;
        jy0.b.c("multi_rtc_update", String.valueOf(r4.getKey().longValue()) + r4.getValue(), null, 4);
        fr2.g r5 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(fr2.g.class), new fr2.h(String.valueOf(r4.getKey().longValue()), r4.getValue()));
        if ((r5 instanceof fr2.g) == false) goto L11;
        r6 = r5;
    L11:
        fr2.g r7 = r6;
        KmpEnv r8 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r7 == null) goto L3;
        r2.add(r7);
        goto L3
    L14:
        this.t.clear();
        this.t.addAll(r2);
        StringBuilder r9 = new StringBuilder("updateForwardStreamToRooms channelId = ");
        r9.append(r15);
        r9.append(" keys:");
        r9.append(r13.keySet());
        r9.append(" forwardRooms=");
        ArrayList<fr2.g> r10 = this.t;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<fr2.g> r16 = r10.iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        r12.add(r16.next().getRoomId());
        goto L16
    L18:
        r9.append(r12);
        r9.append(" from:");
        r9.append(r14);
        jy0.b.c("AnchorRtcManager", r9.toString(), null, 4);
        d r17 = this.g;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r13, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r2, "forwardRoomList");
        Intrinsics.checkNotNullParameter(r14, "reqFrom");
        m r0 = r17.f;
        LiveTracingMonitorKt.EventModule r1 = r17.d();
        String r18 = Arrays.toString(d.z(r13.keySet()));
        HashMap<String, Object> r19 = r17.c();
        r19.put("rtc_map_keys", r18);
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r20 = r2.iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        r110.add(((fr2.g) r20.next()).getRoomId());
        goto L20
    L22:
        r19.put("forward_rooms", r110.toString());
        r19.put("req_from", r14);
        m.d(r0, r1, "update_forward_stream", r19, 8);
        r17.b(r2, "updateForward_" + r14);
        fr2.e r111 = this.b;
        if (r111 != null) goto L25;
        return null;
    L25:
        return Integer.valueOf(r111.K3(this.t, r15));
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void b0(String r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        Intrinsics.checkNotNullParameter(r10, "reason");
        fr2.e r2 = this.b;
        if (r2 != null) goto L5;
        return;
    L5:
        jy0.b.f("AnchorRtcManager", "setRemoteAudioPlaybackVolume " + r8 + ' ' + r9 + ' ' + r10, null, 4);
        d r3 = this.g;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "uid");
        Intrinsics.checkNotNullParameter(r10, "reason");
        HashMap<String, Object> r4 = r3.c();
        r4.put("uid", r8);
        r4.put("volume", String.valueOf(r9));
        r4.put("reason", r10);
        m.d(r3.f, r3.d(), "setRemoteAudioPlaybackVolume", r4, 8);
        k r0 = k.j;
        r0.getClass();
        if (((Boolean) k.i.getValue(r0, k.a[7])).booleanValue() == false) goto L10;
        fr2.e r1 = this.b;
        if (r1 == null) goto L15;
        r1.b0(r8, r9, r10);
    L15:
        p r12 = this.s;
        if (r9 != 0) goto L18;
        boolean r13 = true;
    L19:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r8, "interactId");
        o r14 = r12.k(r8);
        if (r14 == null) goto L23;
        r14.j = r13;
        return;
    L23:
        return;
    L18:
        r13 = false;
        goto L19
    L10:
        fr2.e r15 = this.b;
        if (r15 == null) goto L15;
        u1 r16 = r15.X();
        if (r16 == null) goto L15;
        r16.d(r2.getRtcRoomId(), r8, r9);
        goto L15
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final Integer c1(Map<Long, String> r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r14, "reqFrom");
        Intrinsics.checkNotNullParameter(r15, "channelId");
        ArrayList r2 = new ArrayList();
        Iterator<Map.Entry<Long, String>> r3 = r13.entrySet().iterator();
    L3:
        fr2.g r6 = null;
        if (r3.hasNext() == false) goto L14;
        Map.Entry<Long, String> r4 = r3.next();
        if (r4.getKey().longValue() == IRoomKtKt.getId(this.A)) goto L3;
        jy0.b.c("multi_rtc forward", "AnchorRtcManager mClient = " + this.b + ", key = " + String.valueOf(r4.getKey().longValue()) + ", value = " + r4.getValue(), null, 4);
        fr2.g r5 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(fr2.g.class), new fr2.h(String.valueOf(r4.getKey().longValue()), r4.getValue()));
        if ((r5 instanceof fr2.g) == false) goto L11;
        r6 = r5;
    L11:
        fr2.g r7 = r6;
        KmpEnv r8 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r7 == null) goto L3;
        r2.add(r7);
        goto L3
    L14:
        this.t.clear();
        this.t.addAll(r2);
        this.l = true;
        StringBuilder r9 = new StringBuilder("startForwardStreamToRooms channelId = ");
        r9.append(r15);
        r9.append(' ');
        r9.append(r13.keySet());
        r9.append(" forwardRooms=");
        ArrayList<fr2.g> r10 = this.t;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<fr2.g> r16 = r10.iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        r12.add(r16.next().getRoomId());
        goto L16
    L18:
        r9.append(r12);
        r9.append(" from:");
        r9.append(r14);
        jy0.b.c("AnchorRtcManager", r9.toString(), null, 4);
        d r17 = this.g;
        Map r18 = MapsKt.toMap(r13);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r2, "forwardRoomList");
        Intrinsics.checkNotNullParameter(r14, "reqFrom");
        Set r19 = r18.keySet();
        if (r19 == null) goto L21;
        String r110 = Arrays.toString(d.z(r19));
    L22:
        HashMap<String, Object> r0 = r17.c();
        Intrinsics.checkNotNull(r110);
        r0.put("rtc_map_keys", r110);
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r1 = r2.iterator();
    L24:
        if (r1.hasNext() == false) goto L26;
        r111.add(((fr2.g) r1.next()).getRoomId());
        goto L24
    L26:
        r0.put("forward_rooms", r111.toString());
        r0.put("req_from", r14);
        m.d(r17.f, r17.d(), "start_forward_stream", r0, 8);
        r17.b(r2, "startForward_" + r14);
        fr2.e r112 = this.b;
        if (r112 != null) goto L29;
        return null;
    L29:
        return Integer.valueOf(r112.T3(r2, r15));
    L21:
        r110 = null;
        goto L22
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void h(String r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "interactId");
        Intrinsics.checkNotNullParameter(r9, "reason");
        jy0.b.f("AnchorRtcManager", "muteRemoteAudio " + r7 + ' ' + r8 + ", reason=" + r9 + " rtcOn=" + this.i, null, 4);
        fr2.e r2 = this.b;
        if (r2 == null) goto L5;
        r2.h(r7, r8, r9);
    L5:
        fr2.e r3 = this.b;
        if (r3 == null) goto L8;
        r3.f();
    L8:
        p r4 = this.s;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "interactId");
        Intrinsics.checkNotNullParameter(r9, "reason");
        o r1 = r4.k(r7);
        if (r1 == null) goto L11;
        r1.g = r8;
    L11:
        o r5 = r4.k(r7);
        if (r5 == null) goto L17;
        if (r8 == true) goto L16;
        r9 = "";
    L16:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r5.a = r9;
    L17:
        d r10 = this.g;
        if (r10 == null) goto L20;
        Intrinsics.checkNotNullParameter(r7, "interactId");
        HashMap r0 = new HashMap();
        r0.put("operation_biz_uid", r7);
        r0.put("res", 0);
        r0.put("mute", Integer.valueOf(r8 ? 1 : 0));
        m.d(r10.f, LiveTracingMonitorKt.EventModule.PK, "mute_remote_audio_stream_with_struid", r0, 8);
    L20:
        if (r8 == false) goto L22;
        this.r.add(r7);
        return;
    L22:
        this.r.remove(r7);
    }

    public final fr2.e p(v r17, j r18, String r19) {
        jy0.b.c("multi_rtc ext", "AnchorRtcManager rtcInfo = ".concat(r19), null, 4);
        xh6.b r0 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(fr2.n.class), null);
        if ((r0 instanceof fr2.n) == true) goto L5;
        r0 = null;
    L5:
        hr2.b r4 = (fr2.n) r0;
        KmpEnv r1 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r4 != null) goto L8;
        return null;
    L8:
        r4.setContext(vh6.c.b(wh6.a.class).getHostContext());
        r4.setRtcExtInfo(r19);
        r4.N3();
        r4.setProjectKey(vh6.c.b(vr2.d.class).J9());
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r2 = com.bytedance.android.scope.m.b(r7).b(wh6.a.class);
        Intrinsics.checkNotNull(r2);
        r4.E1(((com.bytedance.live.kmp.core.c) r2).getChannel());
        Object r3 = com.bytedance.android.scope.m.b(r7).b(wh6.a.class);
        Intrinsics.checkNotNull(r3);
        r4.setAppId(String.valueOf(((com.bytedance.live.kmp.core.c) r3).getAppId()));
        Object r5 = com.bytedance.android.scope.m.b(r7).b(wh6.a.class);
        Intrinsics.checkNotNull(r5);
        r4.setAppVersion(((com.bytedance.live.kmp.core.c) r5).getVersionCode());
        Object r6 = com.bytedance.android.scope.m.b(r7).b(wh6.a.class);
        Intrinsics.checkNotNull(r6);
        r4.P2(String.valueOf(((com.bytedance.live.kmp.core.c) r6).getUpdateVersionCode()));
        k r8 = k.j;
        r8.getClass();
        r4.e4(((Boolean) k.g.getValue(r8, k.a[5])).booleanValue());
        IConfig.a.a1.getClass();
        r4.l4(IConfig.a.a.a);
        Object r9 = com.bytedance.android.scope.m.b(r7).b(wh6.a.class);
        Intrinsics.checkNotNull(r9);
        if (((com.bytedance.live.kmp.core.c) r9).isBoe() == false) goto L12;
        r4.V1(t0.a);
    L12:
        if (((Boolean) xa1.f.k.getValue(null, xa1.f.a[9])).booleanValue() == false) goto L14;
        r4.S2();
    L14:
        boolean r10 = false;
        if (((Boolean) c.b.getValue(null, c.a[0])).booleanValue() == true) goto L17;
    L19:
        int r12 = n.a;
        IRoom r13 = this.A;
        Intrinsics.checkNotNullParameter(r13, "room");
        JSONObject r14 = new JSONObject();
        int r15 = c7.a;
        JSONObject r16 = new JSONObject(v60.a.c());     // Catch: Exception -> L22
    L25:
        if (r16 == null) goto L35;
        Iterator<String> r20 = r16.keys();
        if (r20 == null) goto L35;
    L29:
        if (r20.hasNext() == false) goto L35;
        String r110 = r20.next();
        if (r110 == null) goto L29;
        if (StringsKt.startsWith$default(r110, "rtc_ab", false, 2, null) != true) goto L29;
        r14.put(r110, c7.d(r110));
    L35:
        IMainRoomLinkExt r22 = (IMainRoomLinkExt) ((IRoomLinkExt) r13.castTo(IRoomLinkExt.class)).castToOrNull(IMainRoomLinkExt.class);
        if (r22 == null) goto L48;
        Map<String, String> r23 = r22.getAnchorAbMap();
        if (r23 == null) goto L48;
        Iterator<String> r111 = r23.keySet().iterator();
    L41:
        if (r111.hasNext() == false) goto L48;
        String r24 = r111.next();
        if (StringsKt.startsWith$default(r24, "rtc_anchor_ab", false, 2, null) == false) goto L41;
        r14.put(r24, new JSONObject(r23.get(r24)));     // Catch: JSONException -> L46
    L46:
        e = move-exception;
        ALogger.e("rtc_ab", e);
    L48:
        r4.W3(r14.toString());
        IConfig.c.d1.getClass();
        IConfig.c r25 = IConfig.c.a.a;
        r4.G4(r25);
        if (IRoomKt_androidKt.isVirtualLiveKt(this.A) == false) goto L51;
        r4.e1();
    L60:
        if (hr2.b.class.isAssignableFrom(r4.getClass()) == false) goto L62;
        hr2.b r26 = r4;
    L63:
        if (r26 == null) goto L73;
        com.bytedance.android.live.revenuelink.connect.f r27 = this.B.Z0();
        if (r27 == null) goto L71;
        LiveData<ey.f> r28 = r27.connectState();
        if (r28 == null) goto L71;
        ey.f r29 = (ey.f) r28.getValue();
        if (r29 == null) goto L71;
        String r30 = String.valueOf(r29.a);
    L72:
        r26.m1(r30);
    L71:
        r30 = null;
    L73:
        r18.i(vc0.b.a(r4));
        this.q = r4;
        r4.R4(((Boolean) xa1.f.m.getValue(null, xa1.f.a[11])).booleanValue());
        if (r19.length() != 0) goto L76;
        r10 = true;
    L76:
        if (r10 == false) goto L78;
        jy0.b.c("AnchorRtcManager", "dataHolder.rtcInfo is empty", null, 4);
    L78:
        if (r17 != null) goto L80;
        return null;
    L80:
        return r17.W2(r4);
    L62:
        r26 = null;
        goto L63
    L51:
        k r32 = k.j;
        r32.getClass();
        ReadOnlyProperty r33 = k.b;
        KProperty[] r112 = k.a;
        if (((Number) r33.getValue(r32, r112[0])).intValue() < 0) goto L60;
        int r34 = ((Number) r33.getValue(r32, r112[0])).intValue();
        r4.e1();
        if (r34 == 0) goto L58;
        if (r34 == 1) goto L57;
        r25 = IConfig.c.a.c;
        goto L58
    L57:
        r25 = IConfig.c.a.b;
    L58:
        r4.G4(r25);
    L22:
        e = move-exception;
        d6.a("SettingCache#getABTest", e);
        r16 = null;
        goto L25
    L17:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L19;
        r4.V1(t0.c);
        goto L19
    }

    public final void r(String r10, String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r12, "src");
        if (((Boolean) xa1.f.e.getValue(null, xa1.f.a[3])).booleanValue() == true) goto L5;
        return;
    L5:
        d r0 = this.g;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r10 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L38;
        HashMap<String, Object> r6 = r0.c();
        if (r10 != null) goto L19;
        String r7 = "";
    L20:
        r6.put("livecore_params", r7);
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r6.put("update_src", r12);
        JSONObject r14 = new JSONObject(r10).optJSONObject("PushBase");     // Catch: JSONException -> L31
        if (r14 == null) goto L37;
        int r15 = r14.optInt("cap_adapted_width");     // Catch: JSONException -> L31
        int r8 = r14.optInt("cap_adapted_height");     // Catch: JSONException -> L31
        int r9 = r14.optInt("videoCaptureWidth");     // Catch: JSONException -> L31
        int r16 = r14.optInt("videoCaptureHeight");     // Catch: JSONException -> L31
        r6.put("cap_adapted_width", Integer.valueOf(r15));     // Catch: JSONException -> L31
        r6.put("cap_adapted_height", Integer.valueOf(r8));     // Catch: JSONException -> L31
        r6.put("video_capture_width", Integer.valueOf(r9));     // Catch: JSONException -> L31
        r6.put("video_capture_height", Integer.valueOf(r16));     // Catch: JSONException -> L31
        StringBuilder r3 = new StringBuilder();     // Catch: JSONException -> L31
        r3.append(r15);     // Catch: JSONException -> L31
        r3.append('*');     // Catch: JSONException -> L31
        r3.append(r8);     // Catch: JSONException -> L31
        r6.put("ext_livecore_resolution", r3.toString());     // Catch: JSONException -> L31
        StringBuilder r4 = new StringBuilder();     // Catch: JSONException -> L31
        r4.append(r9);     // Catch: JSONException -> L31
        r4.append('*');     // Catch: JSONException -> L31
        r4.append(r16);     // Catch: JSONException -> L31
        r6.put("ext_capture_resolution", r4.toString());     // Catch: JSONException -> L31
        if (r13 == null) goto L29;
        r6.putAll(r13);     // Catch: JSONException -> L31
    L29:
        r0.f.c(r0.d(), "switch_rtc_and_livecore_ext_info", r6, true);     // Catch: JSONException -> L31
        return;
    L37:
        return;
    L31:
        e = move-exception;
        jy0.b.c("monitorLiveCoreCaptResolution", "e = " + e, null, 4);
        return;
    L19:
        r7 = r10;
        goto L20
    L38:
        return;
    L10:
        if (r10.length() == 0) goto L13;
        r5 = false;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void v1(vc0.a r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "interactMode");
        Object r0 = r4.b;
        IConfig.b r2 = null;
        if ((r0 instanceof xh6.c) == true) goto L5;
        IConfig.b r7 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(IConfig.b.class), r4.a);
        if ((r7 instanceof IConfig.b) == false) goto L12;
        r2 = r7;
    L12:
        IConfig.b r1 = r2;
    L13:
        if (r1 != null) goto L15;
        return;
    L15:
        fr2.e r8 = this.b;
        if (r8 == null) goto L18;
        r8.G3(r1);
    L18:
        fr2.e r9 = this.b;
        if (r9 == null) goto L25;
        int r3 = com.bytedance.android.live.revenuelink.rtc.a.a;
        IConfig.b.c1.getClass();
        if (Intrinsics.areEqual(r1, IConfig.b.a.b) == false) goto L23;
        RtcAudioScene r10 = RtcAudioScene.PK;
    L24:
        r9.w(r10.getValue());
        goto L25
    L23:
        r10 = RtcAudioScene.NORMAL;
    L25:
        fr2.n r12 = this.q;
        if (r12 == null) goto L28;
        r12.X0(r6);
    L28:
        d r13 = this.g;
        if (r13 == null) goto L32;
        r13.g = r5;
        return;
    L32:
        return;
    L5:
        if ((r0 instanceof IConfig.b) == true) goto L7;
        r0 = null;
    L7:
        r1 = (IConfig.b) r0;
        goto L13
    }

    public AnchorRtcManager(IRoom r2, com.bytedance.android.live.revenuelink.withroom.a r3, p11.c r4, yz0.g r5) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "storeService");
        Intrinsics.checkNotNullParameter(r4, "pkService");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        this.A = r2;
        this.B = r3;
        this.C = r4;
        this.D = r5;
        this.e = new CopyOnWriteArrayList();
        this.g = new d(r2, r3);
        Intrinsics.checkNotNullParameter(this, "$this$createLinkListeners");
        this.o = new s(this);
        this.r = new HashSet();
        this.s = new p();
        this.t = new ArrayList();
        this.x = new l(r2, r3);
        this.z = LazyKt.lazy(new AnchorRtcManager$streamSignHelper$2(this));
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void U1(vc0.a r9, j r10, String r12, q r13) {
        Intrinsics.checkNotNullParameter(r10, "configInvocation");
        Intrinsics.checkNotNullParameter(r12, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r9 == null) goto L14;
        Object r1 = r9.b;
        if ((r1 instanceof xh6.c) == true) goto L7;
        xh6.c r14 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(v.class), r9.a);
        if ((r14 instanceof v) == true) goto L13;
        r14 = null;
    L13:
        v r2 = (v) r14;
    L16:
        if (this.i == false) goto L23;
        d r15 = this.g;
        if (r15 == null) goto L20;
        r15.i.getRevenueLinkTraceMonitor().b0("double_start", r15.d(), new JSONObject());
    L20:
        jy0.b.c("AnchorRtcManager", "rtc already start.", null, 4);
        return;
    L23:
        if (r12.length() != 0) goto L25;
        boolean r16 = true;
    L26:
        if (r16 == false) goto L37;
        d r17 = this.g;
        if (r17 == null) goto L30;
        r17.g("startEngine");
    L30:
        Iterator<g> r18 = this.e.iterator();
    L32:
        if (r18.hasNext() == false) goto L36;
        g r19 = r18.next();
        if (r19 == null) goto L32;
        r19.R(-1, new IllegalStateException("rtc_ext_info is empty"));
        goto L32
    L36:
        return;
    L37:
        this.v = r12;
        this.h = false;
        this.j = false;
        this.s.b("startRtc");
        Disposable r20 = this.f;
        if (r20 == null) goto L40;
        r20.dispose();
    L40:
        ReadOnlyProperty r22 = xa1.f.c;
        KProperty[] r3 = xa1.f.a;
        if (((Boolean) r22.getValue(null, r3[1])).booleanValue() == false) goto L43;
        com.bytedance.revenue.platform.api.core.rx.l r23 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r24 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.f = Observable.timer(15000, TimeUnit.MILLISECONDS, Schedulers.computation()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    L43:
        i97.a r25 = i97.a.a;
        this.n = System.currentTimeMillis();
        StringBuilder r26 = new StringBuilder();
        r26.append(IRoomKtKt.getId(this.A));
        r26.append('_');
        com.bytedance.android.live.revenuelink.connect.f r6 = this.B.Z0();
        if (r6 == null) goto L50;
        LiveData<ey.f> r7 = r6.connectState();
        if (r7 == null) goto L50;
        ey.f r8 = (ey.f) r7.getValue();
        if (r8 == null) goto L50;
        Long r27 = Long.valueOf(r8.a);
    L51:
        r26.append(r27);
        r26.append('_');
        r26.append(this.n);
        this.y = r26.toString();
        if (r2 != null) goto L142;
        fr2.m r28 = null;
    L55:
        this.c = r28;     // Catch: Exception -> L64
        k r29 = k.j;     // Catch: Exception -> L64
        r29.getClass();     // Catch: Exception -> L64
        ReadOnlyProperty r5 = k.f;     // Catch: Exception -> L64
        KProperty[] r30 = k.a;     // Catch: Exception -> L64
        if (((Boolean) r5.getValue(r29, r30[4])).booleanValue() == false) goto L61;
        if (r2 == null) goto L61;
        fr2.p r4 = r2.getLiveCore();     // Catch: Exception -> L64
        if (r4 == null) goto L61;
        this.d = r4;     // Catch: Exception -> L64
    L61:
        gr2.b r110 = p(r2, r10, r12);     // Catch: Exception -> L64
        this.b = r110;     // Catch: Exception -> L64
        if (r110 == null) goto L66;
        r110.n3(this.o);     // Catch: Exception -> L64
    L66:
        boolean r111 = r13.b;     // Catch: Exception -> L64
        if (r111 == true) goto L69;
        D4(r111);     // Catch: Exception -> L64
    L69:
        fr2.e r112 = this.b;     // Catch: Exception -> L64
        if (r112 == null) goto L80;
        int r32 = com.bytedance.android.live.revenuelink.rtc.a.a;     // Catch: Exception -> L64
        fr2.n r33 = this.q;     // Catch: Exception -> L64
        if (r33 == null) goto L74;
        gr2.g r34 = r33.k3();     // Catch: Exception -> L64
    L75:
        IConfig.b.c1.getClass();     // Catch: Exception -> L64
        if (Intrinsics.areEqual(r34, IConfig.b.a.b) == false) goto L78;
        RtcAudioScene r35 = RtcAudioScene.PK;     // Catch: Exception -> L64
    L79:
        r112.w(r35.getValue());     // Catch: Exception -> L64
        goto L80
    L78:
        r35 = RtcAudioScene.NORMAL;     // Catch: Exception -> L64
        goto L79
    L74:
        r34 = null;
    L80:
        pr2.a r113 = (pr2.a) this.z.getValue();     // Catch: Exception -> L64
        if (r113 == null) goto L86;
        if (r2 == null) goto L84;
        fr2.p r36 = r2.getLiveCore();     // Catch: Exception -> L64
    L85:
        r113.a(r36);     // Catch: Exception -> L64
        goto L86
    L84:
        r36 = null;
    L86:
        fr2.n r114 = this.q;     // Catch: Exception -> L64
        if (r114 == null) goto L90;
        r114.setLinkerSessionId(this.y);     // Catch: Exception -> L64
    L90:
        if (r13.a == false) goto L95;
        fr2.e r115 = this.b;     // Catch: Exception -> L64
        if (r115 == null) goto L94;
        r115.start();     // Catch: Exception -> L64
    L94:
        this.h = true;     // Catch: Exception -> L64
    L99:
        if (((Boolean) xa1.f.d.getValue(null, r3[2])).booleanValue() == true) goto L101;
    L120:
        this.g.y(r13, r12);     // Catch: Exception -> L64
        fr2.e r116 = this.b;     // Catch: Exception -> L64
        if (r116 == null) goto L123;
        r116.t1();     // Catch: Exception -> L64
    L123:
        this.i = true;     // Catch: Exception -> L64
        if (((Boolean) k.c.getValue(r29, r30[1])).booleanValue() == false) goto L141;
        fr2.e r37 = this.b;     // Catch: Exception -> L64
        if (r37 == null) goto L154;
        r37.A1(true);     // Catch: Exception -> L64
        return;
    L64:
        e = move-exception;
        Disposable r117 = this.f;
        if (r117 == null) goto L132;
        r117.dispose();
    L132:
        d r118 = this.g;
        if (r118 == null) goto L135;
        Intrinsics.checkNotNullParameter(e, "e");
        JSONObject r119 = new JSONObject();
        r119.put("message", e.getMessage());
        e.printStackTrace();
        r119.put("trace", e.toString());
        r118.i.getRevenueLinkTraceMonitor().b0("start_error", r118.d(), r119);
    L135:
        Iterator<g> r120 = this.e.iterator();
    L137:
        if (r120.hasNext() == false) goto L156;
        g r121 = r120.next();
        if (r121 == null) goto L137;
        r121.R(10002, e);
        goto L137
    L156:
        return;
    L154:
        return;
    L141:
        return;
    L101:
        if (r13.c == false) goto L120;
        s1 r122 = r13.d;     // Catch: Exception -> L64
        if (r122 == null) goto L120;
        b7 r123 = r122.castToOrNull(b7.class);     // Catch: Exception -> L64
        if (r123 == null) goto L120;
        if (r123.getUseMultiChannel() == false) goto L120;
        Map<Long, String> r124 = r123.getChannelMap();     // Catch: Exception -> L64
        if (r124 == null) goto L120;
        com.bytedance.android.live.revenuelink.connect.f r38 = this.B.Z0();     // Catch: Exception -> L64
        if (r38 == null) goto L118;
        LiveData<ey.f> r39 = r38.connectState();     // Catch: Exception -> L64
        if (r39 == null) goto L118;
        ey.f r40 = (ey.f) r39.getValue();     // Catch: Exception -> L64
        if (r40 == null) goto L118;
        String r42 = String.valueOf(r40.a);     // Catch: Exception -> L64
        if (r42 == null) goto L118;
    L119:
        c1(r124, "start", r42);     // Catch: Exception -> L64
    L118:
        r42 = "";
        goto L119
    L95:
        fr2.e r125 = this.b;     // Catch: Exception -> L64
        if (r125 == null) goto L99;
        r125.H3();     // Catch: Exception -> L64
        goto L99
    L142:
        r28 = r2.getLiveStream();     // Catch: Exception -> L64
    L50:
        r27 = null;
        goto L51
    L25:
        r16 = false;
        goto L26
    L7:
        if ((r1 instanceof v) == true) goto L9;
        r1 = null;
    L9:
        r2 = (v) r1;
        goto L16
    L14:
        r2 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void W0(int r10, long r12, long r13, String r15) {
        Intrinsics.checkNotNullParameter(r15, "arg3");
        z r0 = this.p;
        if (r0 == null) goto L8;
        r0.c = new y(r10, r12, r13, r15);
        fr2.e r14 = this.b;
        if (r14 == null) goto L9;
        r14.E3(r0);
        return;
    L9:
        return;
    }

    public final void b(gr2.b r8, final int r9, final long r10, final Exception r12) {
        jy0.b.d("AnchorRtcManager", "onError: type " + r9 + ", code " + r10 + " exception " + r12);
        com.bytedance.live.kmp.util.d.b(0, false, new AnchorRtcManager$onError$1(this, r9, r10, r12), 7);
    }

    public final void l(gr2.b r7, final int r8, final long r9, final Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        com.bytedance.live.kmp.util.d.b(0, false, new AnchorRtcManager$onInfo$1(this, r8, r9, r12), 7);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void J0(boolean r7, boolean r8, boolean r9, boolean r10, boolean r12) {
        fr2.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.J0(r7, r8, r9, r10, r12);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.i
    public final void d0(String r9, String r10, int r12, int r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r10, "src");
        IConfig r2 = null;
        if (((Boolean) xa1.f.f.getValue(null, xa1.f.a[4])).booleanValue() == true) goto L5;
        return;
    L5:
        fr2.e r0 = this.b;
        if (r0 == null) goto L8;
        r2 = r0.getConfig();
    L8:
        if (r2 != null) goto L10;
    L14:
        d r1 = this.g;
        if (r1 == null) goto L36;
        fr2.p r3 = m();
        if (r3 == null) goto L23;
        i1 r4 = r3.f3();
        if (r4 == null) goto L23;
        h1 r5 = r4.K0();
        if (r5 == null) goto L23;
        int r6 = r5.getWidth();
    L24:
        fr2.p r7 = m();
        if (r7 == null) goto L31;
        i1 r8 = r7.f3();
        if (r8 == null) goto L31;
        h1 r15 = r8.K0();
        if (r15 == null) goto L31;
        int r16 = r15.getHeight();
    L32:
        r1.e(r9, r10, r6, r16, r14, this.s);
        return;
    L31:
        r16 = 0;
    L23:
        r6 = 0;
        goto L24
    L36:
        return;
    L10:
        if (r2.G() == true) goto L14;
        d r17 = this.g;
        if (r17 == null) goto L34;
        r17.e(r9, r10, r12, r13, r14, this.s);
        return;
    }
}
