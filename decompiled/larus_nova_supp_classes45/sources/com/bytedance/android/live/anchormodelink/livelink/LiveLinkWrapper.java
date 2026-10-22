package com.bytedance.android.live.anchormodelink.livelink;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import iy.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ny.t;
import ti6.j;
import vm2.i;
import yb6.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveLinkWrapper implements j {
    public final String a;
    public final int b;
    public ec6.a c;
    public ei6.a d;
    public final Lazy e;
    public final Lazy f;
    public final ConcurrentHashMap<String, yb6.j> g;
    public Disposable h;
    public Disposable i;
    public final CompositeDisposable j;
    public t k;
    public final boolean l;
    public volatile long m;
    public long n;
    public final Lazy o;
    public final Lazy p;
    public final Map<String, Boolean> q;
    public final long r;
    public long s;
    public boolean t;
    public final h u;
    public final my.a v;

    public final boolean b(aj6.d r2, aj6.b r3) {
        Intrinsics.checkNotNullParameter(r2, "audiencePos");
        Intrinsics.checkNotNullParameter(r3, "audienceOrientation");
        return false;
    }

    public final yb6.h f() {
        return (yb6.h) this.e.getValue();
    }

    public final n g() {
        return (n) this.f.getValue();
    }

    public final LiveLinkWrapper$mRtcListener$2.AnonymousClass1 h() {
        return (LiveLinkWrapper$mRtcListener$2.AnonymousClass1) this.o.getValue();
    }

    public final ec6.a d() {
        if (this.u.v4() == false) goto L9;
        Object r0 = this.u.q4();
        if ((r0 instanceof ec6.a) == true) goto L10;
        r0 = null;
    L10:
        return (ec6.a) r0;
    L9:
        return this.c;
    }

    public final ec6.b c() {
        ec6.a r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r();
    }

    public final void i() {
        if (d() != null) goto L5;
        return;
    L5:
        LinkMonitor.a(this.a, "stopLiveClient", null, null, null, false, 124);
        if (this.u.v4() == false) goto L14;
        sk0.c r0 = c();
        if (r0 == null) goto L12;
        sk0.a r1 = r0.b;
        if (r1 == null) goto L12;
        r1.d();
    L12:
        LinkMonitor.a(this.a, "resetAnchorLiveStream", "anchor reset live client params with livestream", null, null, false, 120);
    L14:
        if (this.u.v4() == true) goto L35;
        LinkMonitor.a(this.a, "releaseGuestLiveStream", null, null, null, false, 124);
        sk0.c r2 = c();
        if (r2 == null) goto L20;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r3 = r2.d;
        if (r3 == null) goto L20;
        r3.e("media manager release");
    L20:
        sk0.c r4 = c();
        if (r4 == null) goto L25;
        tk0.a r5 = r4.c;
        if (r5 == null) goto L25;
        r5.g("media manager release");
    L25:
        sk0.c r6 = c();
        if (r6 == null) goto L28;
        sk0.c r7 = r6;
        r7.h((LiveLinkWrapper$IMultiLinkBizAVClientLiveStreamListener$2.a) this.p.getValue());
    L28:
        sk0.c r8 = c();
        if (r8 == null) goto L31;
        r8.g();
    L31:
        ec6.a r9 = d();
        if (r9 == null) goto L34;
        r9.release();
    L34:
        this.c = null;
    L35:
        this.c = null;
        if (this.l == false) goto L38;
        j("onReleaseLiveClient", null);
    L38:
        yb6.h r11 = f();
        r11.b = false;
        r11.a = false;
    }

    public static long e(long r2) {
        i97.a r0 = i97.a.a;
        return System.currentTimeMillis() - r2;
    }

    public final void k(String r15) {
        Intrinsics.checkNotNullParameter(r15, "source");
        LinkMonitor.a(this.a, "stopRtcEngine", "[source] " + r15 + " RtcClientState " + g(), null, null, true, 56);
        if (g().b == false) goto L5;
    L16:
        LinkMonitor.a(this.a, "stopRtcEngine", null, null, null, false, 124);
        if (g().d == false) goto L19;
        LinkMonitor.a(this.a, "rtc engine is stopping skip!", null, null, null, false, 124);
        return;
    L19:
        InteractLinkFullLinkMonitor.h0();
        i97.a r16 = i97.a.a;
        this.n = System.currentTimeMillis();
        g().d = true;
        ei6.a r17 = this.d;
        if (r17 == null) goto L24;
        si6.b r18 = r17.b();
        if (r18 == null) goto L24;
        si6.a.b(r18, false, "LinkMediaManager", 3);
    L24:
        n r19 = g();
        r19.b = false;
        r19.a = false;
        this.g.clear();
        ei6.a r110 = this.d;
        if (r110 == null) goto L29;
        ri6.b r111 = r110.r();
        if (r111 == null) goto L29;
        r111.s1();
    L29:
        Disposable r112 = this.i;
        if (r112 == null) goto L32;
        r112.dispose();
    L32:
        Disposable r113 = this.h;
        if (r113 == null) goto L36;
        r113.dispose();
    L36:
        if (g().e == false) goto L40;
        ei6.a r114 = this.d;
        if (r114 == null) goto L41;
        l r0 = l.a;
        long r1 = i.l() * ((long) 1000);
        int r2 = p.a;
        Disposable r115 = Observable.timer(r1, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r114, this));
        f.a(r115, this.j);
        this.i = r115;
    L41:
        this.d = null;
        i();
        return;
    L40:
        LinkMonitor.a(this.a, "rtc engine is not on , reset state", null, null, null, false, 124);
        g().a("rtc engine is not on , reset state");
        InteractLinkFullLinkMonitor.j0(System.currentTimeMillis() - this.n);
        goto L41
    L5:
        if (g().a == true) goto L16;
        if (g().e == true) goto L16;
        if (g().c == true) goto L16;
        LinkMonitor.a(this.a, "stopRtcEngine", "rtc engine not init , check and stop live client", null, null, false, 120);
        LinkMonitor.a(this.a, "stopLiveClient", null, null, null, false, 124);
        if (f().b == false) goto L14;
    L15:
        i();
        return;
    L14:
        if (f().a == true) goto L15;
    }

    public LiveLinkWrapper(h r3, my.a r4) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.u = r3;
        this.v = r4;
        this.a = "LiveLinkWrapper";
        this.b = 6;
        this.e = LazyKt.lazy(LiveLinkWrapper$mLiveClientState$2.INSTANCE);
        this.f = LazyKt.lazy(LiveLinkWrapper$mRtcClientState$2.INSTANCE);
        this.g = new ConcurrentHashMap();
        this.j = new CompositeDisposable();
        this.l = r3.t4();
        this.m = 0;
        this.o = LazyKt.lazy(new LiveLinkWrapper$mRtcListener$2(this));
        this.p = LazyKt.lazy(new LiveLinkWrapper$IMultiLinkBizAVClientLiveStreamListener$2(this));
        this.q = new LinkedHashMap();
        this.r = r3.y4();
    }

    public final void j(String r3, JsonObject r4) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("method", r3);
        if (r4 == null) goto L5;
        r0.add("params", r4);
    L5:
        this.u.w4(r0);
    }

    public final String a(int r11, int r12, List<ti6.f> r13) {
        Intrinsics.checkNotNullParameter(r13, "mixRegions");
        t r14 = this.k;
        String r15 = null;
        if (r14 == null) goto L10;
        List<ny.n> r16 = r14.d;
        if (r16 == null) goto L10;
        List<ny.n> r17 = r16;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16));
        Iterator<T> r18 = r17.iterator();
    L8:
        if (r18.hasNext() == false) goto L11;
        Object r0 = r18.next();
        r1.put(((ny.n) r0).m, r0);
    L11:
        List<ti6.f> r19 = r13;
        Iterator<T> r110 = r19.iterator();
    L13:
        if (r110.hasNext() == false) goto L20;
        ti6.f r2 = (ti6.f) r110.next();
        if (r1 == null) goto L17;
        ny.n r3 = (ny.n) r1.get(r2.b);
    L18:
        if (r3 == null) goto L13;
        double r4 = r3.a;
        double r5 = r3.b;
        r2.d = r4;
        r2.e = r5;
        double r6 = r3.h;
        double r7 = r3.i;
        r2.f = r6;
        r2.g = r7;
        r2.a = r3.k;
        r2.l = true;
        r2.o = (int) r3.c;
        goto L13
    L17:
        r3 = null;
        goto L18
    L20:
        t r111 = this.k;
        if (r111 == null) goto L23;
        JsonObject r112 = r111.c;
    L24:
        if (r112 == null) goto L28;
        JsonElement r8 = r112.get("grids");
        if (r8 == null) goto L28;
        JsonArray r9 = r8.getAsJsonArray();
    L30:
        if (r9 == null) goto L57;
        int r21 = r9.size();
        int r22 = 0;
    L32:
        if (r22 >= r21) goto L57;
        JsonElement r23 = r9.get(r22);
        if (r23 == null) goto L56;
        JsonObject r24 = r23.getAsJsonObject();
        if (r24 == null) goto L56;
        JsonElement r25 = r24.get("uid_str");
        if (r25 == null) goto L41;
        String r26 = r25.getAsString();
    L42:
        Iterator<T> r27 = r19.iterator();
    L44:
        if (r27.hasNext() == false) goto L52;
        Object r28 = r27.next();
        String r29 = ((ti6.f) r28).b;
        if (r26 != null) goto L48;
        String r31 = "";
    L50:
        if (Intrinsics.areEqual(r29, r31) == false) goto L44;
    L53:
        ti6.f r32 = (ti6.f) r28;
        if (r32 == null) goto L56;
        r24.addProperty("talk", Integer.valueOf(r32.j ? 1 : 0));
        goto L56
    L48:
        r31 = r26;
        goto L50
    L52:
        r28 = null;
        goto L53
    L41:
        r26 = null;
    L56:
        r22 = r22 + 1;
    L57:
        if (r112 == null) goto L59;
        r15 = r112.toString();
    L59:
        int r113 = iy.a.a;
        Intrinsics.checkNotNullParameter("onMixStream region=" + r15, "msg");
        if (r15 != null) goto L63;
        return "";
    L63:
        return r15;
    L28:
        r9 = null;
        goto L30
    L23:
        r112 = null;
    L10:
        r1 = null;
        goto L11
    }
}
