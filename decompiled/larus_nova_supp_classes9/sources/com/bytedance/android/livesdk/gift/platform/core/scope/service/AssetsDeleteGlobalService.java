package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.CleanDataSource;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.revenue.service.feature.IRevFeatureService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssetsDeleteGlobalService implements com.bytedance.android.scope.o, dy0.c {
    public final com.bytedance.android.livesdk.gift.configmodel.i a;
    public final com.bytedance.android.livesdk.gift.configmodel.c b;
    public final Lazy c;
    public final CompositeDisposable d;
    public final AssetsService e;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            long r0 = ((l) r5).f - ((l) r4).f;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 != 0) goto L7;
            return 0;
        L7:
            return -1;
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.d.clear();
    }

    public AssetsDeleteGlobalService(AssetsService r4) {
        Intrinsics.checkNotNullParameter(r4, "globalAssetsService");
        this.e = r4;
        this.a = (com.bytedance.android.livesdk.gift.configmodel.i) com.bytedance.android.livesdk.gift.platform.business.b.t.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[18]);
        this.b = (com.bytedance.android.livesdk.gift.configmodel.c) com.bytedance.android.livesdk.gift.platform.business.i.m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.i.a[11]);
        this.c = LazyKt.lazy(AssetsDeleteGlobalService$portraitCleanEnable$2.INSTANCE);
        this.d = new CompositeDisposable();
    }

    public final void a(Map<Long, com.bytedance.android.livesdk.gift.platform.business.effect.assets.a> r21, CleanDataSource r23) {
        PolarisFileWrapper r2 = new PolarisFileWrapper(new AssetsFileCacheFactory().c());
        if (r2.exists() == true) goto L5;
        return;
    L5:
        File[] r1 = r2.listFiles();
        if (r1 != null) goto L8;
        return;
    L8:
        ArrayList r3 = new ArrayList();
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L13;
        String r4 = vh6.c.b(IRevFeatureService.class).getPortrait("live_not_clean_assets");
        if (r4 == null) goto L13;
        r3.addAll(GsonHelper.fromJsonArray(r4, Long.TYPE));
    L13:
        PriorityQueue r5 = new PriorityQueue(20, b.a);
        long r6 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator r7 = ((LinkedHashMap) r21).entrySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L43;
        Map.Entry r8 = (Map.Entry) r7.next();
        long r10 = ((Number) r8.getKey()).longValue();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r13 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.a) r8.getValue();
        if (r3.contains(Long.valueOf(r10)) == true) goto L40;
        Intrinsics.checkNotNullParameter(r13, "$this$getLastUseTime");
        String r9 = r13.a;
        if (r9 == null) goto L21;
        long r14 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r9);
    L22:
        String r11 = r13.b;
        if (r11 == null) goto L25;
        long r15 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r11);
    L26:
        String r16 = r13.c;
        if (r16 == null) goto L29;
        long r17 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r16);
    L30:
        long r18 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r14, r15), r17);
        long r19 = r6 - r18;
        if (r18 != 0) goto L33;
        long r110 = Long.MAX_VALUE;
    L35:
        if (r110 < this.a.a()) goto L41;
        String r20 = r13.a;
        if (r20 != null) goto L39;
        r20 = BuildConfig.FLAVOR;
    L39:
        r5.add(new l(r10, r20, r13, null, r110, 17));
    L41:
        r7 = r7;
        goto L15
    L33:
        r110 = r19;
        goto L35
    L29:
        r17 = 0;
        goto L30
    L25:
        r15 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L40:
        r7 = r7;
        goto L41
    L43:
        if (r5.isEmpty() == false) goto L45;
        return;
    L45:
        Iterator r24 = r5.iterator();
        int r25 = 0;
    L47:
        if (r24.hasNext() == false) goto L111;
        l r26 = (l) r24.next();
        if (r25 >= this.a.b()) goto L111;
        int r27 = r1.length;
        int r28 = 0;
        boolean r29 = false;
    L52:
        if (r28 >= r27) goto L109;
        File r30 = r1[r28];
        String r111 = r30.getName();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r112 = r26.d;
        if (r112 == null) goto L108;
        Intrinsics.checkNotNullParameter(r112, "$this$isMd5Matched");
        Intrinsics.checkNotNullParameter(r111, "targetMd5");
        if (r111.length() != 0) goto L58;
        boolean r113 = true;
    L59:
        if (r113 == true) goto L91;
        String r114 = r112.a;
        if (r114 != null) goto L64;
    L71:
        String r115 = r112.b;
        if (r115 != null) goto L74;
    L81:
        String r116 = r112.c;
        if (r116 == null) goto L91;
        if (r116.length() <= 0) goto L86;
        boolean r117 = true;
    L87:
        if (r117 == false) goto L91;
        if (r116.equals(r111) == false) goto L91;
    L90:
        boolean r118 = true;
    L92:
        if (r118 != true) goto L108;
        int r31 = com.bytedance.android.livesdk.gift.platform.core.b.a;
        String r33 = r30.getName();
        Intrinsics.checkNotNullParameter(r33, "assetMd5");
        GiftResourceFileCacheService r119 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r33 != null) goto L96;
    L99:
        boolean r120 = true;
    L100:
        if (r120 == true) goto L104;
        r119.c.remove(r33);
    L104:
        if (com.bytedance.android.live.revenue.common.c0.b(r30) == false) goto L107;
        iz0.a r34 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
        Intrinsics.checkNotNullParameter(r111, "md5");
        com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a.i("last_use_time_".concat(r111));
        int r35 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(r26.b, r26.f, r111, "strategy_clean", r23, null, null, 96);
    L107:
        r29 = true;
        goto L108
    L96:
        if (r33.length() == 0) goto L99;
        r120 = false;
        goto L100
    L86:
        r117 = false;
        goto L87
    L74:
        if (r115.length() <= 0) goto L76;
        boolean r121 = true;
    L77:
        if (r121 == false) goto L81;
        if (r115.equals(r111) == false) goto L81;
    L76:
        r121 = false;
        goto L77
    L64:
        if (r114.length() <= 0) goto L66;
        boolean r122 = true;
    L67:
        if (r122 == false) goto L71;
        if (r114.equals(r111) == false) goto L71;
    L66:
        r122 = false;
    L91:
        r118 = false;
        goto L92
    L58:
        r113 = false;
    L108:
        r28 = r28 + 1;
        goto L52
    L109:
        if (r29 == false) goto L47;
        r25 = r25 + 1;
    L111:
        if (r25 <= 0) goto L128;
        com.bytedance.android.livesdk.gift.platform.core.d0.i(r25, 4);
        return;
    }
}
