package com.larus.uaigc.lynx;

import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.utils.logger.FLogger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LotteryPollingConfigProvider {
    public static final Lazy a = null;
    public static final MutableSharedFlow<s09.a> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((hy9.g) r1).d(), ((hy9.g) r2).d());
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((hy9.g) r1).d(), ((hy9.g) r2).d());
        }
    }

    static {
        Lazy r0 = LazyKt.lazy(new c());
        a = r0;
        b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        c = LazyKt.lazy(new d());
        d = LazyKt.lazy(new e());
        e = LazyKt.lazy(new f());
        f = LazyKt.lazy(new g());
        g = LazyKt.lazy(new h());
        FLogger.a.i("LotteryPollingConfigProvider", "initZLotteryGuideManager");
        PollingConfigService.a.j((s09.b) r0.getValue());
    }

    public static hy9.b a(boolean r12) {
        List r0 = b(r12);
        if (r12 == false) goto L9;
        Long r13 = PollingConfigService.a.c();
        if (r13 == null) goto L7;
        long r1 = r13.longValue();
    L8:
        Long r14 = Long.valueOf(r1);
    L10:
        Long r6 = r14;
        if (r6 != null) goto L14;
        FLogger.a.e("LotteryPollingConfigProvider", "getCurHostReadState failed, curTimeMs is null");
        return new hy9.b(null, 31);
    L14:
        Iterator r2 = r0.iterator();
        int r3 = 0;
    L16:
        if (r2.hasNext() == false) goto L28;
        hy9.g r4 = (hy9.g) r2.next();
        if (r4.a() != null) goto L20;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == true) goto L29;
        r3 = r3 + 1;
    L29:
        hy9.g r7 = (hy9.g) CollectionsKt.getOrNull(r0, r3);
        FLogger.a.i("LotteryPollingConfigProvider", "[getCurHostReadState] roundList = " + r0.size() + ", curTimeMs = " + r6 + ", index = " + r3);
        if (r7 == null) goto L48;
        Integer r8 = r7.d();
        if (r8 == null) goto L35;
        int r9 = r8.intValue();
    L36:
        long r10 = r6.longValue();
        Long r11 = r7.c();
        if (r11 == null) goto L39;
        long r15 = r11.longValue();
    L41:
        if (r10 < r15) goto L43;
        boolean r16 = true;
    L45:
        return new hy9.b(true, r9, r16, r7, r6);
    L43:
        r16 = false;
        goto L45
    L39:
        r15 = 0;
        goto L41
    L35:
        r9 = r3 + 1;
        goto L36
    L48:
        return new hy9.b(r6, 15);
    L20:
        if (r4.b() == null) goto L24;
        Long r17 = r4.a();
        Intrinsics.checkNotNull(r17);
        long r18 = r17.longValue();
        Long r19 = r4.b();
        Intrinsics.checkNotNull(r19);
        if (RangesKt.until(r18, r19.longValue()).contains(r6.longValue()) == false) goto L24;
        r5 = true;
        goto L25
    L28:
        r3 = -1;
        goto L29
    L7:
        r1 = AppHost.a.getAppClock().currentTimeMillis();
        goto L8
    L9:
        r14 = PollingConfigService.a.c();
        goto L10
    }

    public static List b(boolean r1) {
        List r0 = null;
        if (r1 == false) goto L12;
        hy9.a r2 = (hy9.a) ((i1) e.getValue()).getValue();
        if (r2 == null) goto L9;
        List<hy9.g> r3 = r2.a();
        if (r3 == null) goto L9;
        r0 = CollectionsKt.filterNotNull(r3);
    L9:
        if (r0 != null) goto L21;
        r0 = CollectionsKt.emptyList();
    L21:
        return CollectionsKt.sortedWith(r0, new a());
    L12:
        hy9.a r4 = (hy9.a) ((i1) d.getValue()).getValue();
        if (r4 == null) goto L17;
        List<hy9.g> r5 = r4.a();
        if (r5 == null) goto L17;
        r0 = CollectionsKt.filterNotNull(r5);
    L17:
        if (r0 != null) goto L20;
        r0 = CollectionsKt.emptyList();
    L20:
        return CollectionsKt.sortedWith(r0, new b());
    }
}
