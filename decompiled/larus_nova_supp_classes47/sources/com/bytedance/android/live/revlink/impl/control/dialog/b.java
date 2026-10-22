package com.bytedance.android.live.revlink.impl.control.dialog;

import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.utils.x;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ int r = 0;
    public long a;
    public int b;
    public long c;
    public Disposable d;
    public Disposable e;
    public Disposable f;
    public Disposable g;
    public Disposable h;
    public final SparseArray<e> i;
    public final SparseArray<f> j;
    public final SparseArray<Long> k;
    public final ArraySet<String> l;
    public final ArrayMap<String, e> m;
    public final ArrayMap<String, f> n;
    public final ArrayMap<String, Long> o;
    public boolean p;
    public final Lazy q;

    public static final class a {
        public static boolean a() {
            return b51.b.c0.i().getEnable();
        }

        public static b b() {
            LinkRevPanelDataContext r0 = LinkRevPanelDataContext.Companion.getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<b> r1 = r0.getLoader();
            if (r1 == null) goto L7;
            return (b) r1.getValue();
        L7:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.control.dialog.b$b, reason: collision with other inner class name */
    public static final class C0123b<T, R> implements Function {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public C0123b(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r7) {
            ExtraResponse r8 = (ExtraResponse) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            b r0 = this.a;
            List r1 = ((IRivalRankRecommendResponse) r8.data).getSubTabs();
            Map r2 = null;
            if (r1 == null) goto L19;
            Iterator<T> r3 = r1.iterator();
        L6:
            if (r3.hasNext() == false) goto L14;
            T r4 = r3.next();
            IPkSubTabKey r5 = ((y7) r4).getKey();
            if (r5 == null) goto L10;
            String r6 = r5.getActivityId();
        L12:
            if (Intrinsics.areEqual(r6, this.b) == false) goto L6;
        L15:
            y7 r9 = (y7) r4;
            if (r9 == null) goto L19;
            String r10 = r9.getTrackingInfo();
            if (r10 == null) goto L19;
        L20:
            r0.getClass();
            r2 = JsonUtil.jsonObjectToMap(new JSONObject(r10));     // Catch: Exception -> L24
        L23:
            return new Pair(r8, r2);
        L10:
            r6 = null;
            goto L12
        L14:
            r4 = null;
        L19:
            r10 = "";
            goto L20
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public c(b r1, String r2, long r3, int r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r19) {
            Pair r1 = (Pair) r19;
            b r2 = this.a;
            String r3 = this.b;
            r2.getClass();
            boolean r5 = true;
            if (Intrinsics.areEqual(r3, "timer") == false) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == true) goto L13;
            LiveFullLinkPKMonitor r7 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r7 == null) goto L13;
            LiveFullLinkPKMonitor.s(r7, "battle/rivals/recommend", System.currentTimeMillis() - this.c, this.d, 0, null, 24);
        L13:
            this.a.l.remove(b.k(this.d, this.e));
            if (r1 == null) goto L122;
            ExtraResponse r6 = (ExtraResponse) r1.getFirst();
            if (r6 == null) goto L123;
            IRivalRankRecommendResponse r10 = (IRivalRankRecommendResponse) r6.data;
            if (r10 == null) goto L124;
            int r8 = x.a;
            if (x.a(this.e, this.d) == false) goto L26;
            e r9 = new e(this.d, this.e, r10, this.c, System.currentTimeMillis(), (Map) r1.getSecond());
            this.a.m.put(this.e, r9);
            LinkRevPanelDataContext r12 = b.b(this.a);
            if (r12 == null) goto L125;
            com.bytedance.live.datacontext.k<Pair<String, e>> r13 = r12.getLoadCompleteEvent();
            if (r13 == null) goto L126;
            r13.post(new Pair(b.c(this.a, this.b), r9));
            return;
        L126:
            return;
        L125:
            return;
        L26:
            int r14 = (int) r10.getLoadType();
            IRivalRankRecommendResponse.LoadType r15 = IRivalRankRecommendResponse.LoadType.All;
            if (r14 != r15.ordinal()) goto L96;
            if (Intrinsics.areEqual(this.b, "init") == false) goto L31;
        L32:
            LinkRevPanelDataContext r16 = b.b(this.a);
            if (r16 == null) goto L35;
            r16.setAbValueMap(r10.getListAbValueMap());
        L35:
            this.a.getClass();
            s2 r17 = r10.getTabRivals();
            HashMap r18 = null;
            if (r17 == null) goto L38;
            Map r20 = r17.getGroupRivals();
        L39:
            if (r20 != null) goto L41;
        L44:
            boolean r22 = true;
        L45:
            if (r22 == true) goto L60;
            IRivalRankRecommendResponse r23 = vh7.f.c(IRivalRankRecommendResponse.class);
            IRivalRankRecommendResponse r24 = r23;
            r24.setLoadType(IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal());
            r24.setTabRivals(vh7.f.c(s2.class));
            s2 r25 = r24.getTabRivals();
            if (r25 == null) goto L53;
            IGroupRivals.GroupType r110 = IGroupRivals.GroupType.GroupFeedRecommend;
            IGroupRivals r111 = (IGroupRivals) r20.get(Long.valueOf(r110.ordinal()));
            if (r111 == null) goto L51;
            HashMap r112 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Long.valueOf(r110.ordinal()), r111)});
        L52:
            r25.setGroupRivals(r112);
            goto L53
        L51:
            r112 = null;
        L53:
            Unit r26 = Unit.INSTANCE;
            IRivalRankRecommendResponse r27 = vh7.f.c(IRivalRankRecommendResponse.class);
            IRivalRankRecommendResponse r113 = r27;
            r113.setLoadType(IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
            r113.setTabRivals(vh7.f.c(s2.class));
            s2 r114 = r113.getTabRivals();
            if (r114 == null) goto L59;
            IGroupRivals.GroupType r115 = IGroupRivals.GroupType.GroupFeedFollowed;
            IGroupRivals r28 = (IGroupRivals) r20.get(Long.valueOf(r115.ordinal()));
            if (r28 == null) goto L58;
            r18 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Long.valueOf(r115.ordinal()), r28)});
        L58:
            r114.setGroupRivals(r18);
        L59:
            r18 = new Triple(r10, r23, r27);
        L60:
            if (r18 == null) goto L94;
            e r29 = b.d(this.a, this.e, IRivalRankRecommendResponse.LoadType.Other.ordinal(), (IRivalRankRecommendResponse) r18.getFirst(), this.c);
            if (r29 == null) goto L68;
            LinkRevPanelDataContext r30 = b.b(this.a);
            if (r30 == null) goto L68;
            com.bytedance.live.datacontext.k<Pair<String, e>> r32 = r30.getLoadCompleteEvent();
            if (r32 == null) goto L68;
            r32.post(new Pair(b.c(this.a, this.b), r29));
        L68:
            e r33 = b.d(this.a, this.e, IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal(), (IRivalRankRecommendResponse) r18.getSecond(), this.c);
            if (r33 == null) goto L75;
            LinkRevPanelDataContext r34 = b.b(this.a);
            if (r34 == null) goto L75;
            com.bytedance.live.datacontext.k<Pair<String, e>> r35 = r34.getLoadCompleteEvent();
            if (r35 == null) goto L75;
            r35.post(new Pair(b.c(this.a, this.b), r33));
        L75:
            if (r4 == true) goto L77;
        L79:
            r5 = false;
        L80:
            e r36 = b.d(this.a, this.e, IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal(), (IRivalRankRecommendResponse) r18.getThird(), this.c);
            if (r36 == null) goto L94;
            if (r5 == false) goto L88;
            LinkRevPanelDataContext r37 = b.b(this.a);
            if (r37 == null) goto L94;
            com.bytedance.live.datacontext.k<Pair<String, e>> r38 = r37.getLoadCompleteEvent();
            if (r38 == null) goto L94;
            r38.post(new Pair("timer", r36));
            goto L94
        L88:
            if (r4 == true) goto L94;
            LinkRevPanelDataContext r39 = b.b(this.a);
            if (r39 == null) goto L94;
            com.bytedance.live.datacontext.k<Pair<String, e>> r40 = r39.getLoadCompleteEvent();
            if (r40 == null) goto L94;
            r40.post(new Pair(b.c(this.a, this.b), r36));
            goto L94
        L77:
            if (b.a(this.a, (IRivalRankRecommendResponse) r18.getThird()) == false) goto L79;
        L94:
            this.a.i.put(r15.ordinal(), new e(r15.ordinal(), DataType.FALSE, r10, this.c, System.currentTimeMillis()));
            return;
        L41:
            if (r20.isEmpty() == true) goto L44;
            r22 = false;
            goto L45
        L38:
            r20 = null;
            goto L39
        L31:
            if (Intrinsics.areEqual(this.b, "timer") == false) goto L35;
        L96:
            if (Intrinsics.areEqual(this.b, "init") == false) goto L100;
            LinkRevPanelDataContext r42 = b.b(this.a);
            if (r42 == null) goto L100;
            r42.setAbValueMap(r10.getListAbValueMap());
        L100:
            if (r4 == true) goto L102;
        L106:
            r5 = false;
        L107:
            e r43 = b.d(this.a, this.e, r14, r10, this.c);
            if (r43 == null) goto L129;
            if (r5 == false) goto L115;
            LinkRevPanelDataContext r44 = b.b(this.a);
            if (r44 == null) goto L130;
            com.bytedance.live.datacontext.k<Pair<String, e>> r45 = r44.getLoadCompleteEvent();
            if (r45 == null) goto L131;
            r45.post(new Pair("timer", r43));
            return;
        L131:
            return;
        L130:
            return;
        L115:
            if (r4 == true) goto L133;
            LinkRevPanelDataContext r46 = b.b(this.a);
            if (r46 == null) goto L134;
            com.bytedance.live.datacontext.k<Pair<String, e>> r47 = r46.getLoadCompleteEvent();
            if (r47 == null) goto L135;
            r47.post(new Pair(b.c(this.a, this.b), r43));
            return;
        L135:
            return;
        L134:
            return;
        L133:
            return;
        L129:
            return;
        L102:
            if (b.a(this.a, r10) == false) goto L106;
            if (r14 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L106;
        L124:
            return;
        L123:
            return;
        L122:
            return;
        L5:
            if (Intrinsics.areEqual(r3, "ai") == true) goto L8;
            r4 = false;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public d(b r1, String r2, long r3, int r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            b r0 = this.a;
            String r1 = this.b;
            r0.getClass();
            if (Intrinsics.areEqual(r1, "timer") == false) goto L5;
        L8:
            boolean r9 = true;
        L9:
            if (r9 == true) goto L13;
            LiveFullLinkPKMonitor r2 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r2 == null) goto L13;
            LiveFullLinkPKMonitor.r(r2, "battle/rivals/recommend", r13, System.currentTimeMillis() - this.c, this.d, 0, null, 48);
        L13:
            if (r9 == true) goto L27;
            int r3 = x.a;
            if (x.a(this.e, this.d) == false) goto L18;
            f r8 = new f(this.d, this.e, r13, this.c, System.currentTimeMillis());
            this.a.n.put(this.e, r8);
            return;
        L18:
            f r10 = new f(this.d, this.e, r13, this.c, System.currentTimeMillis());
            this.a.j.put(this.d, r10);
            LinkRevPanelDataContext r14 = b.b(this.a);
            if (r14 == null) goto L25;
            com.bytedance.live.datacontext.k<Pair<String, f>> r15 = r14.getLoadFailEvent();
            if (r15 == null) goto L26;
            r15.post(new Pair(b.c(this.a, this.b), r10));
            return;
        L26:
            return;
        L25:
            return;
        L27:
            return;
        L5:
            if (Intrinsics.areEqual(r1, "ai") == true) goto L8;
            r9 = false;
            goto L9
        }
    }

    static {
    }

    public final void o() {
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.f;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.p = true;
    }

    public b() {
        this.a = -1;
        this.i = new SparseArray();
        this.j = new SparseArray();
        this.k = new SparseArray();
        this.l = new ArraySet();
        this.m = new ArrayMap();
        this.n = new ArrayMap();
        this.o = new ArrayMap();
        this.p = true;
        this.q = LazyKt.lazy(LinkRevPanelLoader$exposeSet$2.INSTANCE);
    }

    public final void m() {
        this.c = System.currentTimeMillis();
        d31.e r0 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r0 == null) goto L5;
        r0.d = this.c;
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.j.clear();
        this.n.clear();
        if (a.a() == true) goto L11;
        this.i.clear();
        this.m.clear();
        this.j.clear();
        this.n.clear();
        this.l.clear();
        this.m.clear();
    L11:
        b51.b r2 = b51.b.c0;
        r2.getClass();
        if (((Boolean) b51.b.l.getValue(r2, b51.b.a[10])).booleanValue() == false) goto L20;
        Disposable r3 = this.g;
        if (r3 == null) goto L16;
        r3.dispose();
    L16:
        Disposable r4 = this.h;
        if (r4 == null) goto L19;
        r4.dispose();
    L19:
        this.d = g(this, IRivalRankRecommendResponse.LoadType.Other.ordinal());
        this.g = g(this, IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
        this.h = g(this, IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal());
        return;
    L20:
        this.d = g(this, IRivalRankRecommendResponse.LoadType.All.ordinal());
    }

    public static final LinkRevPanelDataContext b(b r0) {
        r0.getClass();
        return LinkRevPanelDataContext.Companion.getContext();
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        o();
        if (a.a() == true) goto L5;
    L6:
        this.i.clear();
        this.m.clear();
        this.j.clear();
        this.n.clear();
        this.l.clear();
    L7:
        Disposable r3 = this.g;
        if (r3 == null) goto L10;
        r3.dispose();
    L10:
        Disposable r4 = this.d;
        if (r4 == null) goto L13;
        r4.dispose();
    L13:
        Disposable r5 = this.h;
        if (r5 == null) goto L17;
        r5.dispose();
        return;
    L17:
        return;
    L5:
        if (Intrinsics.areEqual(r2, "clear") == false) goto L7;
        goto L6
    }

    public final void n(String r24) {
        Intrinsics.checkNotNullParameter(r24, "source");
        if (this.a < 0) goto L5;
    L7:
        boolean r7 = true;
        if (Intrinsics.areEqual(r24, "open") == false) goto L10;
        this.b++;
    L10:
        b51.b r3 = b51.b.c0;
        if (r3.i().getOpenPanelCount() < 0) goto L16;
        if (this.b >= r3.i().getOpenPanelCount()) goto L16;
        return;
    L16:
        if (r3.i().h5() < 0) goto L25;
        if (this.b >= r3.i().h5()) goto L25;
        if (this.a <= 0) goto L25;
        i97.a r8 = i97.a.a;
        if ((System.currentTimeMillis() - this.a) < 1200000) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r24, "live") == true) goto L29;
        if (Intrinsics.areEqual(r24, "link_end") == true) goto L29;
    L37:
        if (r3.i().R5() == false) goto L42;
        if (((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager().a() == false) goto L42;
        return;
    L42:
        if (a.a() == false) goto L77;
        boolean r4 = Intrinsics.areEqual(r24, "open");
        r11.o r9 = r3.h();
        if (r4 == false) goto L47;
        long r12 = r9.q();
    L49:
        if (r12 <= 0) goto L77;
        r11.o r10 = r3.h();
        if (r4 == false) goto L54;
        int r13 = r10.C();
    L55:
        Disposable r14 = this.e;
        if (r14 == null) goto L58;
        r14.dispose();
    L58:
        this.p = false;
        if (r4 == true) goto L61;
    L63:
        long r15 = r3.h().getDelay();
    L64:
        if (r13 < 0) goto L66;
        long r16 = r13;
        if (r15 < 0) goto L73;
        long r18 = r15;
    L74:
        Observable r5 = Observable.intervalRange(0, r16, r18, r12, TimeUnit.MILLISECONDS);
    L75:
        this.e = r5.observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.control.dialog.d(this, r24));
        goto L77
    L73:
        r18 = 5000;
        goto L74
    L66:
        if (r15 >= 0) goto L69;
        r15 = 5000;
    L69:
        r5 = Observable.interval(r15, r12, TimeUnit.MILLISECONDS);
        goto L75
    L61:
        if (r3.i().R5() == false) goto L63;
        r15 = 8000;
        goto L64
    L54:
        r13 = r10.getCount();
        goto L55
    L47:
        r12 = r9.getInterval();
    L77:
        if (a.a() == false) goto L126;
        boolean r6 = Intrinsics.areEqual(r24, "open");
        r11.r r17 = r3.i();
        if (r6 == false) goto L82;
        long r19 = r17.q();
    L84:
        if (r19 <= 0) goto L127;
        if (r6 == false) goto L88;
        int r20 = r3.i().C();
    L89:
        int r22 = r24.hashCode();
        if (r22 == 3112) goto L106;
        if (r22 == 3417674) goto L100;
        if (r22 == 1194515222) goto L97;
    L108:
        long r2 = r3.i().getDelay();
    L109:
        Disposable r23 = this.f;
        if (r23 == null) goto L112;
        r23.dispose();
    L112:
        this.p = false;
        if (r20 < 0) goto L115;
        long r110 = r20;
        if (r2 < 0) goto L122;
        long r111 = r2;
    L123:
        Observable r25 = Observable.intervalRange(0, r110, r111, r19, TimeUnit.MILLISECONDS);
    L124:
        this.f = r25.observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.control.dialog.c(this, r24));
        return;
    L122:
        r111 = 5000;
        goto L123
    L115:
        if (r2 >= 0) goto L118;
        r2 = 5000;
    L118:
        r25 = Observable.interval(r2, r19, TimeUnit.MILLISECONDS);
        goto L124
    L97:
        if (r24.equals("link_end") == false) goto L108;
    L107:
        r2 = 3000;
        goto L109
    L100:
        if (r24.equals("open") == false) goto L108;
        if (r3.i().R5() == false) goto L104;
        r2 = 15000;
        goto L109
    L104:
        r2 = r3.i().getDelay();
        goto L109
    L106:
        if (r24.equals("ai") == false) goto L108;
    L88:
        r20 = r3.i().getCount();
        goto L89
    L127:
        return;
    L82:
        r19 = r17.getInterval();
        goto L84
    L126:
        return;
    L29:
        if (r3.g().getEnable() == true) goto L31;
    L33:
        r7 = false;
    L34:
        if (r7 == false) goto L37;
        return;
    L31:
        if (r3.g().K3() == false) goto L33;
    L5:
        if (Intrinsics.areEqual(r24, "live") == false) goto L7;
        i97.a r26 = i97.a.a;
        this.a = System.currentTimeMillis();
        goto L7
    }

    public static final boolean a(b r3, IRivalRankRecommendResponse r4) {
        if (r4 == null) goto L13;
        r3.getClass();
        s2 r5 = r4.getTabRivals();
        if (r5 == null) goto L13;
        Map r6 = r5.getGroupRivals();
        if (r6 == null) goto L13;
        IGroupRivals r7 = (IGroupRivals) r6.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r7 == null) goto L13;
        List r8 = r7.getRivals();
        if (r8 == null) goto L13;
        int r9 = r8.size();
    L14:
        SparseArray<e> r10 = r3.i;
        if (r10 == null) goto L29;
        e r12 = r10.get(IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
        if (r12 == null) goto L29;
        IRivalRankRecommendResponse r13 = r12.c;
        if (r13 == null) goto L29;
        s2 r14 = r13.getTabRivals();
        if (r14 == null) goto L29;
        Map r15 = r14.getGroupRivals();
        if (r15 == null) goto L29;
        IGroupRivals r16 = (IGroupRivals) r15.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r16 == null) goto L29;
        List r17 = r16.getRivals();
        if (r17 == null) goto L29;
        int r18 = r17.size();
    L30:
        if (r18 == r9) goto L33;
        return true;
    L33:
        return false;
    L29:
        r18 = 0;
    L13:
        r9 = 0;
        goto L14
    }

    public static final String c(b r0, String r1) {
        r0.getClass();
        if (Intrinsics.areEqual(r1, "ai") == false) goto L6;
        return "timer";
    L6:
        return r1;
    }

    public static Disposable g(b r6, int r7) {
        return r6.h(0, DataType.FALSE, "init", r7, "");
    }

    public static String k(int r1, String r2) {
        return r1 + '-' + r2;
    }

    public final Pair<String, e> e(int r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "activityId");
        Intrinsics.checkNotNullParameter(r13, "activityId");
        if (x.a(r13, r12) == false) goto L5;
        e r0 = (e) this.m.get(r13);
    L15:
        if (r0 != null) goto L17;
        return null;
    L17:
        if (a.a() == true) goto L21;
        return TuplesKt.to("cache", r0);
    L21:
        if (x.a(r13, r12) == false) goto L24;
        long r4 = b51.b.c0.i().m3();
    L31:
        if (r4 <= (-1)) goto L36;
        if ((System.currentTimeMillis() - r0.d) <= r4) goto L36;
        return null;
    L36:
        if (r12 != IRivalRankRecommendResponse.LoadType.Other.ordinal()) goto L41;
        d31.e r14 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r14 == null) goto L88;
        r14.e |= 1;
    L88:
        return TuplesKt.to("cache", r0);
    L41:
        if (r12 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L46;
        d31.e r15 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r15 == null) goto L88;
        r15.e |= 2;
        goto L88
    L46:
        if (r12 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L88;
        IRivalRankRecommendResponse r16 = r0.c;
        if (r16 == null) goto L54;
        s2 r17 = r16.getTabRivals();
        if (r17 == null) goto L54;
        Map r18 = r17.getGroupRivals();
        if (r18 == null) goto L54;
        IGroupRivals r19 = (IGroupRivals) r18.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()));
    L55:
        if (r19 == null) goto L57;
        List r110 = r19.getRivals();
    L58:
        List r5 = r110;
        if (r5 != null) goto L61;
    L64:
        boolean r6 = true;
    L65:
        if (r6 == false) goto L67;
    L84:
        d31.e r111 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r111 == null) goto L88;
        r111.e |= 4;
        goto L88
    L67:
        if ((true ^ ((HashSet) this.q.getValue()).isEmpty()) == false) goto L84;
        ArrayList r2 = new ArrayList();
        Iterator r112 = r110.iterator();
    L70:
        if (r112.hasNext() == false) goto L81;
        m2 r7 = (m2) r112.next();
        if (r7 == null) goto L70;
        HashSet r8 = (HashSet) this.q.getValue();
        IRoom r9 = r7.getRoom();
        if (r9 == null) goto L76;
        String r10 = r9.getIdStr();
    L78:
        if (r8.contains(r10) == true) goto L70;
        r2.add(r7);
        goto L70
    L76:
        r10 = null;
        goto L78
    L81:
        if (r2.size() < b51.b.c0.i().t()) goto L84;
        if (r19 == null) goto L84;
        r19.setRivals(r2);
        goto L84
    L61:
        if (r5.isEmpty() == true) goto L64;
        r6 = false;
        goto L65
    L57:
        r110 = null;
    L54:
        r19 = null;
        goto L55
    L24:
        if (r12 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L27;
        r4 = b51.b.c0.h().z();
        goto L31
    L27:
        if (r12 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L29;
        r4 = b51.b.c0.i().V7();
        goto L31
    L29:
        r4 = b51.b.c0.i().C2();
        goto L31
    L5:
        r0 = this.i.get(r12);
        if (r12 != IRivalRankRecommendResponse.LoadType.All.ordinal()) goto L15;
        if (r0 != null) goto L15;
        r0 = this.i.get(IRivalRankRecommendResponse.LoadType.Other.ordinal());
        SparseArray<e> r1 = this.i;
        IRivalRankRecommendResponse.LoadType r3 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals;
        e r20 = r1.get(r3.ordinal());
        SparseArray<e> r22 = this.i;
        IRivalRankRecommendResponse.LoadType r23 = IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals;
        e r24 = r22.get(r23.ordinal());
        if (r0 == null) goto L15;
        if (r20 == null) goto L12;
        j(r3.ordinal(), r0.c, r20.c);
    L12:
        if (r24 == null) goto L15;
        j(r23.ordinal(), r0.c, r24.c);
        goto L15
    }

    public final boolean i(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "activityId");
        if (this.l.contains(k(r2, r3)) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.l.contains(k(IRivalRankRecommendResponse.LoadType.All.ordinal(), r3)) == true) goto L8;
        return false;
    }

    public static void j(int r3, IRivalRankRecommendResponse r4, IRivalRankRecommendResponse r5) {
        if (r4.getTabRivals() != null) goto L5;
        r4.setTabRivals(r5.getTabRivals());
        return;
    L5:
        s2 r0 = r4.getTabRivals();
        Map r1 = null;
        if (r0 == null) goto L8;
        Map r2 = r0.getGroupRivals();
    L9:
        if (r2 == null) goto L11;
    L18:
        s2 r6 = r4.getTabRivals();
        if (r6 == null) goto L21;
        Map r7 = r6.getGroupRivals();
    L22:
        if (r7 == null) goto L63;
        s2 r8 = r5.getTabRivals();
        if (r8 == null) goto L26;
        r1 = r8.getGroupRivals();
    L26:
        if (r1 != null) goto L28;
        return;
    L28:
        if (r3 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L44;
        s2 r9 = r5.getTabRivals();
        if (r9 == null) goto L65;
        Map r10 = r9.getGroupRivals();
        if (r10 == null) goto L66;
        IGroupRivals.GroupType r12 = IGroupRivals.GroupType.GroupFeedRecommend;
        IGroupRivals r13 = (IGroupRivals) r10.get(Long.valueOf(r12.ordinal()));
        if (r13 == null) goto L67;
        s2 r14 = r4.getTabRivals();
        if (r14 == null) goto L68;
        LinkedHashMap r15 = new LinkedHashMap();
        s2 r16 = r4.getTabRivals();
        if (r16 == null) goto L41;
        Map r17 = r16.getGroupRivals();
        if (r17 == null) goto L41;
    L42:
        r15.putAll(r17);
        r15.put(Long.valueOf(r12.ordinal()), r13);
        Unit r18 = Unit.INSTANCE;
        r14.setGroupRivals(r15);
        return;
    L41:
        r17 = MapsKt.emptyMap();
        goto L42
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L44:
        if (r3 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L70;
        s2 r19 = r5.getTabRivals();
        if (r19 == null) goto L71;
        Map r20 = r19.getGroupRivals();
        if (r20 == null) goto L72;
        IGroupRivals r22 = (IGroupRivals) r20.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r22 == null) goto L73;
        s2 r23 = r4.getTabRivals();
        if (r23 == null) goto L74;
        LinkedHashMap r24 = new LinkedHashMap();
        s2 r25 = r4.getTabRivals();
        if (r25 == null) goto L57;
        Map r26 = r25.getGroupRivals();
        if (r26 == null) goto L57;
    L58:
        r24.putAll(r26);
        r24.put(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()), r22);
        Unit r27 = Unit.INSTANCE;
        r23.setGroupRivals(r24);
        return;
    L57:
        r26 = MapsKt.emptyMap();
        goto L58
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L63:
        return;
    L21:
        r7 = null;
        goto L22
    L11:
        if (r5.getTabRivals() == null) goto L18;
        s2 r28 = r4.getTabRivals();
        if (r28 == null) goto L61;
        s2 r29 = r5.getTabRivals();
        if (r29 == null) goto L17;
        r1 = r29.getGroupRivals();
    L17:
        r28.setGroupRivals(r1);
        return;
    L61:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static void l(b r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(DataType.FALSE, "activityId");
        b51.b r0 = b51.b.c0;
        if (r0.g().getEnable() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        return;
    L11:
        if ((!Intrinsics.areEqual(r5, "init")) == false) goto L16;
        if ((!Intrinsics.areEqual(r5, "cache")) == false) goto L16;
        return;
    L16:
        if (r6 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L22;
        r4.i.remove(r6);
        r4.j.remove(r6);
        r4.l.remove(k(r6, DataType.FALSE));
        return;
    L22:
        return;
    L5:
        if (r0.g().K3() == false) goto L7;
        r1 = true;
        goto L8
    }

    public static final e d(b r10, String r12, int r13, IRivalRankRecommendResponse r14, long r15) {
        r10.getClass();
        if (x.a(r12, r13) == false) goto L6;
        e r0 = new e(r13, r12, r14, r15, System.currentTimeMillis());
        r10.m.put(r12, r0);
        return r0;
    L6:
        if (r13 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L10;
        ((HashSet) r10.q.getValue()).clear();
        e r16 = new e(r13, DataType.FALSE, r14, r15, System.currentTimeMillis());
        r10.i.put(r13, r16);
        ALogger.i("LinkRevPanelLoader", "updateCache piece loadType=" + r13);
    L17:
        return r16;
    L10:
        if (r13 != IRivalRankRecommendResponse.LoadType.Other.ordinal()) goto L12;
    L15:
        r16 = new e(r13, DataType.FALSE, r14, r15, System.currentTimeMillis());
        r10.i.put(r13, r16);
        ALogger.i("LinkRevPanelLoader", "updateCache piece loadType=" + r13);
        goto L17
    L12:
        if (r13 == IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L15;
        return null;
    }

    public final Disposable h(int r22, String r23, String r24, int r25, String r26) {
        Intrinsics.checkNotNullParameter(r23, "activityId");
        Intrinsics.checkNotNullParameter(r24, "source");
        Intrinsics.checkNotNullParameter(r26, "posStr");
        this.l.add(k(r25, r23));
        long r18 = System.currentTimeMillis();
        if (x.a(r23, r25) == false) goto L5;
        this.o.put(r23, Long.valueOf(r18));
    L6:
        boolean r15 = Intrinsics.areEqual(r24, "init");
        if (Intrinsics.areEqual(r24, "init") == false) goto L9;
        String r10 = "";
    L10:
        r31.a r8 = r31.b.a(r31.a.a);
        int r0 = com.bytedance.android.live.revlink.impl.pk.flexactivity.b.a;
        int r12 = e51.a.c.a();
        int r1 = r24.hashCode();
        if (r1 != 3112) goto L13;
        String r2 = "ai";
        if (r24.equals("ai") == false) goto L21;
    L20:
        String r17 = r2;
    L22:
        Observable r3 = r8.D(1, r10, r23, r12, r22, r25, r15 ? 1 : 0, r26, r17);
        if (r3 == null) goto L29;
        Observable r4 = r3.map(new C0123b(this, r23));
        if (r4 == null) goto L29;
        Observable r9 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r9 == null) goto L29;
        return r9.subscribe(new c(this, r24, r18, r25, r23), new d(this, r24, r18, r25, r23));
    L29:
        return null;
    L21:
        r17 = "";
        goto L22
    L13:
        if (r1 != 110364485) goto L21;
        if (r24.equals("timer") == false) goto L21;
        r2 = "cache";
        goto L20
    L9:
        r10 = "common_pk";
        goto L10
    L5:
        this.k.put(r25, Long.valueOf(r18));
        goto L6
    }
}
