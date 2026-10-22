package com.bytedance.android.live.revlink.impl.multianchor.service;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.vm.RevLinkPreloadContext;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdkapi.util.RxP4SchedulerHelper;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kc0.t;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkPreloadService implements t, h {
    public static final List<Long> s = null;
    public Map<String, String> a;
    public ExtraResponse<r, Extra> b;
    public ExtraResponse<r, Extra> c;
    public long d;
    public long e;
    public Disposable f;
    public Disposable g;
    public final CompositeDisposable h;
    public h.b i;
    public h.c j;
    public boolean k;
    public boolean l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;

    public static final class a {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void g() {
        this.i = null;
        this.j = null;
    }

    static {
        s = CollectionsKt.listOf(new Long[]{Long.valueOf(6), Long.valueOf(2)});
    }

    public final void detach() {
        jy0.b.c("MultiLinkPreloadWidget", "PreloadWidget detach for channelID: " + this.m + " roomID: " + this.n, null, 4);
        this.b = null;
        this.c = null;
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.h.clear();
        RevLinkLayoutPreloadContext r1 = RevLinkLayoutPreloadContext.Companion.getContext(Long.valueOf(this.n));
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<f> r2 = r1.getService();
        if (r2 == null) goto L12;
        f r3 = (f) r2.getValue();
        if (r3 == null) goto L12;
        r3.d("detach");
    L12:
        Disposable r4 = this.g;
        if (r4 == null) goto L16;
        r4.dispose();
        return;
    }

    public RevLinkPreloadService() {
        this.h = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void d() {
        s1.getContext();
    }

    public final void c(long r5) {
        jy0.b.c("MultiLinkPreloadWidget", "PreloadWidget attach for channelID: " + this.m + " roomID: " + r5, null, 4);
        this.n = r5;
        Pair r0 = com.bytedance.live.datacontext.d.a(RevLinkPreloadService$attach$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r0.getFirst(), "MultiLinkPreloadWidget" + r5);
        ((RevLinkPreloadContext) r0.getFirst()).getService().d(this);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r0.getSecond(), this.h);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void e(PkDoubleAudienceDataContext.C03571 r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        this.j = r9;
        ExtraResponse<r, Extra> r6 = this.c;
        if (r6 == null) goto L6;
        r9.b(this.r, this.p, r6, true);
        this.c = null;
        this.p = 0;
        this.r = 0;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void f(h.b r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        this.i = r9;
        ExtraResponse<r, Extra> r6 = this.b;
        if (r6 == null) goto L6;
        r9.b(this.q, this.o, r6, true);
        this.b = null;
        this.o = 0;
        this.q = 0;
        return;
    }

    public static final void i(RevLinkPreloadService r4, long r5) {
        r4.getClass();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r6 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r6.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f.getValue(r6, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[4])).booleanValue() == false) goto L13;
        LiveFullLinkPKMonitor r7 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r7 == null) goto L13;
        q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L11;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r1 = r0.g();
        if (r1 == null) goto L11;
        int r2 = r1.isBattleStatsObtained();
    L12:
        LiveFullLinkPKMonitor.n(r7, r2, SystemClock.elapsedRealtime() - r5, 1);
    L11:
        r2 = 0;
    L13:
        jy0.b.d("RevLinkPreloadWidget", "load success time = " + (SystemClock.elapsedRealtime() - r5));
        jy0.b.d("RevLinkPreloadWidget", "lynx load success ");
    }

    public static final void h(RevLinkPreloadService r7, String r8, String r9) {
        r7.getClass();
        LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r0 != null) goto L5;
    L11:
        jy0.b.c("RevLinkPreloadWidget", "lynx load error errMsg = " + r9, null, 4);
        r7.getClass();
        return;
    L5:
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        if (r9 != null) goto L9;
        String r3 = "";
    L10:
        LiveFullLinkPKMonitor.o(r0, "link_dynamic_central_load_failed", r8, r3, 0, 0, 24);
        goto L11
    L9:
        r3 = r9;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final boolean a(long r5, long r7, long r9, boolean r12) {
        if (r5 == this.n) goto L5;
        return false;
    L5:
        if (r7 != this.m) goto L22;
        long r10 = r9 - this.d;
        u41.b r6 = u41.b.i;
        r6.getClass();
        if (r10 <= ((Number) u41.b.g.getValue(r6, u41.b.a[5])).longValue()) goto L10;
        return false;
    L10:
        if (r12 == false) goto L17;
        if (this.b == null) goto L14;
    L15:
        return true;
    L14:
        if (this.k == true) goto L15;
        return false;
    L17:
        if (this.c != null) goto L15;
        if (this.l == true) goto L15;
        return false;
    L22:
        return false;
    }

    public final void b(Context r25, long r26, long r28, String r30, long r32, String r33, Map<String, String> r34) {
        Intrinsics.checkNotNullParameter(r33, "rawSei");
        this.n = r28;
        this.a = r34;
        if (r25 != null) goto L5;
    L77:
        String r5 = "MultiLinkPreloadWidget";
    L79:
        if (u41.b.i.b() == true) goto L82;
        return;
    L82:
        if (r32 == 6) goto L84;
        long r6 = 2;
        if (r32 == r6) goto L108;
        return;
    L108:
        if (this.n != 0) goto L110;
        return;
    L110:
        if (this.l == false) goto L112;
        return;
    L112:
        if (vh6.c.b(wh6.a.class).n2() == false) goto L149;
        Disposable r1 = this.f;
        if (r1 == null) goto L117;
        r1.dispose();
    L117:
        this.m = r26;
        i97.a r2 = i97.a.a;
        this.d = System.currentTimeMillis();
        this.c = null;
        jy0.b.c(r5, "start preload battleStats for roomID: " + this.n, null, 4);
        long r3 = System.currentTimeMillis();
        this.p = com.bytedance.live.kmp.util.e.b();
        this.l = true;
        if (com.bytedance.android.live.revlink.impl.global.b.r() == null) goto L120;
        String r0 = d21.d.c(PkDoubleAudienceDataContext.BattleStatsFromType.PKingInRoom.ordinal());
    L121:
        Observable r4 = r31.b.a(r31.a.a).O(r26, r6, 1, true, r0, r28, r30);
        if (r4 == null) goto L145;
        Observable r7 = r4.compose(RxP4SchedulerHelper.rxP4SchedulerHelper());
        if (r7 == null) goto L146;
        Disposable r8 = r7.subscribe(new l(this, r3, r26, r0), new m(this, r26, r0));
        if (r8 == null) goto L147;
        com.bytedance.revenue.platform.api.core.rx.f.a(r8, this.h);
        return;
    L147:
        return;
    L146:
        return;
    L145:
        return;
    L120:
        r0 = "";
        goto L121
    L149:
        return;
    L84:
        if (r26 != 0) goto L86;
    L104:
        jy0.b.c(r5, "intercept preload linkmic/list !!! channelID: " + r26 + " roomID: " + r28 + ' ' + this.k, null, 4);
        return;
    L86:
        if (r28 == 0) goto L104;
        if (this.k == true) goto L104;
        if (vh6.c.b(wh6.a.class).n2() == false) goto L104;
        jy0.b.f(r5, "start preload linkmic/list channelID: " + r26 + " roomID: " + r28, null, 4);
        Disposable r9 = this.f;
        if (r9 == null) goto L95;
        r9.dispose();
    L95:
        this.m = r26;
        i97.a r10 = i97.a.a;
        this.d = System.currentTimeMillis();
        this.b = null;
        this.k = true;
        this.o = com.bytedance.live.kmp.util.e.b();
        long r12 = System.currentTimeMillis();
        Observable r13 = r31.b.a(r31.a.a).v(r26, 4, r28);
        if (r13 == null) goto L102;
        Observable r14 = r13.compose(RxP4SchedulerHelper.rxP4SchedulerHelper());
        if (r14 == null) goto L102;
        Disposable r15 = r14.subscribe(new j(this, r26, r28, r12), new k(this, r26, r12));
        if (r15 == null) goto L102;
        com.bytedance.revenue.platform.api.core.rx.f.a(r15, this.h);
        Disposable r16 = r15;
    L103:
        this.f = r16;
        return;
    L102:
        r16 = null;
        goto L103
    L5:
        if (r28 == 0) goto L77;
        if (s.contains(Long.valueOf(r32)) == false) goto L77;
        long r17 = 6;
        if (r32 != r17) goto L14;
        z41.e.d.getClass();
        if (z41.e.c.e9() == true) goto L14;
    L18:
        r5 = "MultiLinkPreloadWidget";
    L14:
        long r18 = 2;
        if (r32 != r18) goto L19;
        z41.e.d.getClass();
        if (z41.e.c.S7() == false) goto L18;
    L19:
        com.bytedance.android.live.revlink.impl.global.c r19 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r19 == null) goto L22;
        LinkRevInternalServiceContext r20 = r19.Cj();
    L23:
        if (r20 == null) goto L25;
        r5 = "MultiLinkPreloadWidget";
        jy0.b.c(r5, "intercept preInflateLayout, controlWidget already loaded", null, 4);
        goto L79
    L25:
        r5 = "MultiLinkPreloadWidget";
        if (this.e <= 0) goto L30;
        i97.a r110 = i97.a.a;
        if ((System.currentTimeMillis() - this.e) >= 2000) goto L30;
        jy0.b.c(r5, "intercept preInflateLayout, too frequently", null, 4);
    L30:
        i97.a r22 = i97.a.a;
        this.e = System.currentTimeMillis();
        RevLinkLayoutPreloadContext.a r23 = RevLinkLayoutPreloadContext.Companion;
        RevLinkLayoutPreloadContext r24 = r23.getContext(Long.valueOf(r28));
        jy0.b.f(r5, "preInflateLayout for " + r28 + ' ' + r32 + ' ' + r24 + ' ' + this, null, 4);
        if (r24 != null) goto L33;
        Pair r27 = com.bytedance.live.datacontext.d.a(RevLinkPreloadService$preInflateLayout$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r27.getFirst(), "RevLinkLayoutPreloadContext_" + r28);
        ((RevLinkLayoutPreloadContext) r27.getFirst()).getService().d(new p31.a(r25));
        this.g = (Disposable) r27.getSecond();
    L33:
        RevLinkLayoutPreloadContext r29 = r23.getContext(Long.valueOf(r28));
        if (r29 == null) goto L38;
        com.bytedance.live.datacontext.j<f> r35 = r29.getService();
        if (r35 == null) goto L38;
        f r36 = (f) r35.getValue();
    L39:
        if (r32 != r17) goto L71;
        int r37 = StringsKt.indexOf$default(r33, "grids", 0, false, 6, null);
        if (r37 >= 0) goto L43;
        jy0.b.c(r5, "can not find grids in sei", null, 4);
    L67:
        int r38 = 0;
    L69:
        if (r36 == null) goto L74;
        r36.b(r38);
    L74:
        Disposable r39 = Single.timer(6, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r28));
        if (r39 == null) goto L79;
        this.h.add(r39);
        goto L79
    L43:
        int r111 = r33.length();
    L44:
        if (r37 >= r111) goto L49;
        if (r33.charAt(r37) == '[') goto L49;
        r37 = r37 + 1;
    L49:
        if (r37 >= r111) goto L53;
        if (r33.charAt(r37) == '{') goto L53;
        r37 = r37 + 1;
    L53:
        int r40 = 0;
        int r112 = 0;
    L54:
        if (r37 >= r111) goto L66;
        if (r33.charAt(r37) == ']') goto L66;
        if (r33.charAt(r37) != '{') goto L61;
        r112 = r112 + 1;
    L65:
        r37 = r37 + 1;
        goto L54
    L61:
        if (r33.charAt(r37) != '}') goto L65;
        r112 = r112 - 1;
        if (r112 != 0) goto L65;
        r40 = r40 + 1;
    L66:
        if (r112 != 0) goto L67;
        r38 = RangesKt.coerceAtMost(r40, 4);
        goto L69
    L71:
        if (r32 != r18) goto L74;
        if (r36 == null) goto L74;
        r36.c();
    L38:
        r36 = null;
        goto L39
    L22:
        r20 = null;
        goto L23
    }
}
