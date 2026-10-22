package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.live.core.resources.CleanStrategyType;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.keva_store.AssetKevaKey;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LRUCleanStrategy implements com.bytedance.android.livesdk.gift.platform.business.effect.delete.a {
    public final CompositeDisposable a;
    public final Map<String, Map<String, v>> b;
    public final Map<String, Long> c;
    public final Map<String, com.bytedance.android.live.core.resources.c> d;
    public final Lazy e;
    public volatile boolean f;
    public volatile boolean g;
    public Disposable h;
    public boolean i;
    public long j;
    public t k;
    public final ResourceRecordService l;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j m;
    public final GiftResourceFileCacheService n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/LRUCleanStrategy$CleanResourceResult;", BuildConfig.FLAVOR, "FILE_REMOVE_SUCCESS", "FILE_REMOVE_FAILED", "FILE_NOT_EXIST", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CleanResourceResult extends Enum<CleanResourceResult> {
        public static final CleanResourceResult FILE_NOT_EXIST = null;
        public static final CleanResourceResult FILE_REMOVE_FAILED = null;
        public static final CleanResourceResult FILE_REMOVE_SUCCESS = null;
        public static final /* synthetic */ CleanResourceResult[] a = null;

        static {
            CleanResourceResult r1 = new CleanResourceResult("FILE_REMOVE_SUCCESS", 0);
            FILE_REMOVE_SUCCESS = r1;
            CleanResourceResult r2 = new CleanResourceResult("FILE_REMOVE_FAILED", 1);
            FILE_REMOVE_FAILED = r2;
            CleanResourceResult r3 = new CleanResourceResult("FILE_NOT_EXIST", 2);
            FILE_NOT_EXIST = r3;
            a = new CleanResourceResult[]{r1, r2, r3};
        }

        public static CleanResourceResult valueOf(String r1) {
            return (CleanResourceResult) r27.a.a(CleanResourceResult.class, r1);
        }

        public static CleanResourceResult[] values() {
            return (CleanResourceResult[]) a.clone();
        }

        public CleanResourceResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((v) r3).i3()), Long.valueOf(((v) r4).i3()));
        }
    }

    public static final class c implements SingleOnSubscribe<Map<String, ? extends List<? extends String>>> {
        public c() {
        }

        public final void subscribe(SingleEmitter<Map<String, List<String>>> r9) {
            Intrinsics.checkNotNullParameter(r9, "emitter");
            LinkedHashMap r0 = new LinkedHashMap();
            iz0.a r1 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;     // Catch: Exception -> L14
            String r2 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a(AssetKevaKey.RESOURCE_LRU_MD5_CACHE);     // Catch: Exception -> L14
            if (r2 != null) goto L6;
        L9:
            boolean r3 = true;
        L10:
            if (r3 == true) goto L12;
            Gson r4 = l97.a.a;     // Catch: Exception -> L14
            KTypeProjection.Companion r5 = KTypeProjection.Companion;     // Catch: Exception -> L14
            r0.putAll((Map) r4.fromJson(r2, TypesJVMKt.getJavaType(Reflection.typeOf(Map.class, r5.invariant(Reflection.typeOf(String.class)), r5.invariant(Reflection.typeOf(List.class, r5.invariant(Reflection.typeOf(String.class))))))));     // Catch: Exception -> L14
        L12:
            r9.onSuccess(r0);     // Catch: Exception -> L14
            return;
        L6:
            if (r2.length() == 0) goto L9;
            r3 = false;
        L14:
            e = move-exception;
            r9.onError(e);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LRUCleanStrategy a;

        public d(LRUCleanStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Map r5 = (Map) r4;
            Boolean r0 = (Boolean) this.a.l.f.getValue();
            if (r0 == null) goto L5;
            boolean r1 = r0.booleanValue();
        L6:
            if (r1 == false) goto L8;
            LRUCleanStrategy.g(this.a, r5);
            jy0.b.c("GiftAssetClean", "record初始化完成", null, 4);
            return;
        L8:
            BehaviorSubject<Boolean> r2 = this.a.l.f;
            int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
            Disposable r6 = r2.observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this, r5), s.a);
            this.a.a.add(r6);
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            jy0.b.c("GiftAssetClean", "初始化错误, " + ((Throwable) r4).getMessage(), null, 4);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LRUCleanStrategy a;

        public f(LRUCleanStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r21) {
            v r1 = (v) r21;
            com.bytedance.android.live.core.resources.e r2 = this.a.m.G1(r1.getAssetId());
            if (r2 == null) goto L84;
            com.bytedance.android.live.core.resources.b r3 = r2.getCleanStrategy();
            if (r3 == null) goto L85;
            long r4 = 0;
            Map<String, v> r5 = this.a.b.get(r3.getAssetType());
            if (r5 != null) goto L9;
        L29:
            Map<String, v> r6 = this.a.b.get(r3.getAssetType());
            if (r6 != null) goto L32;
            r6 = new LinkedHashMap();
        L32:
            r6.put(r1.getMd5(), r1);
            this.a.b.put(r3.getAssetType(), r6);
            Long r7 = (Long) ((LinkedHashMap) this.a.c).get(r3.getAssetType());
            if (r7 == null) goto L35;
            long r8 = r7.longValue();
        L36:
            long r9 = r8 + r1.getSize();
            this.a.c.put(r3.getAssetType(), Long.valueOf(r9));
        L37:
            Map<String, v> r10 = this.a.b.get("not_belong_poll_resource_tag");
            if (r10 == null) goto L41;
            v r11 = r10.remove(r1.getMd5());
        L41:
            if (this.a.h().g0() == false) goto L81;
            com.bytedance.android.live.core.resources.c r13 = (com.bytedance.android.live.core.resources.c) ((LinkedHashMap) this.a.d).get(r3.getAssetType());
            if (r13 == null) goto L45;
            int r14 = r13.getMaxSize();
        L47:
            if (r14 >= r9) goto L81;
            com.bytedance.live.kmp.util.c r15 = com.bytedance.live.kmp.util.c.a;
            long r16 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            LRUCleanStrategy r17 = this.a;
            if ((r16 - r17.j) <= r17.h().u1()) goto L81;
            LRUCleanStrategy r18 = this.a;
            CleanOpportunity r19 = CleanOpportunity.IN_THE_LIVE_ROOM;
            String r20 = r3.getAssetType();
            if (r18.h().getEnable() == true) goto L54;
        L80:
            this.a.j = r16;
            goto L81
        L54:
            if (r18.b.isEmpty() == true) goto L80;
            Disposable r23 = r18.h;
            if (r23 != null) goto L59;
        L61:
            i12.e r24 = i12.o.b();
            if (r24 == null) goto L64;
            com.bytedance.android.scope.m.e.getClass();
            com.bytedance.android.scope.o r25 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(w.class));
        L65:
            w r26 = (w) r25;
            if (r26 == null) goto L68;
            ConcurrentHashMap<String, Integer> r110 = r26.a;
        L69:
            ArrayList r111 = new ArrayList();
            Map<String, v> r27 = r18.b.get(r20);
            if (r27 == null) goto L72;
            r111.addAll(r27.values());
        L72:
            Long r28 = (Long) ((LinkedHashMap) r18.c).get(r20);
            if (r28 == null) goto L75;
            r4 = r28.longValue();
        L75:
            long r112 = r4;
            com.bytedance.android.live.core.resources.c r29 = (com.bytedance.android.live.core.resources.c) ((LinkedHashMap) r18.d).get(r20);
            if (r29 == null) goto L78;
            long r30 = r29.getPoolSize();
        L79:
            long r113 = r30;
            ArrayList r31 = new ArrayList();
            r31.addAll(r18.l.h());
            int r33 = com.bytedance.revenue.platform.api.core.rx.q.a;
            Single r34 = Single.create(new l(r18, r111, r20, r112, r113, r31, r110, r19));
            int r35 = com.bytedance.revenue.platform.api.core.rx.p.a;
            r18.h = r34.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r18, r20), n.a);
            goto L80
        L78:
            r30 = Long.MAX_VALUE;
            goto L79
        L68:
            r110 = null;
            goto L69
        L64:
            r25 = null;
            goto L65
        L59:
            if (r23.isDisposed() == true) goto L61;
        L45:
            r14 = Integer.MAX_VALUE;
        L81:
            this.a.i = true;
            return;
        L35:
            r8 = r4;
            goto L36
        L9:
            if (r5.containsKey(r1.getMd5()) != true) goto L29;
            Map<String, v> r36 = this.a.b.get(r3.getAssetType());
            if (r36 == null) goto L13;
            v r37 = r36.remove(r1.getMd5());
        L13:
            Map<String, v> r38 = this.a.b.get(r3.getAssetType());
            if (r38 == null) goto L16;
            v r39 = r38.put(r1.getMd5(), r1);
        L16:
            Long r40 = (Long) ((LinkedHashMap) this.a.c).get(r3.getAssetType());
            if (r40 == null) goto L19;
            r9 = r40.longValue();
        L21:
            if (r9 != r4) goto L37;
            Map<String, v> r41 = this.a.b.get(r3.getAssetType());
            if (r41 == null) goto L28;
            Iterator<Map.Entry<String, v>> r43 = r41.entrySet().iterator();
        L26:
            if (r43.hasNext() == false) goto L28;
            Map.Entry<String, v> r44 = r43.next();
            String r114 = r44.getKey();
            r9 = r9 + r44.getValue().getSize();
        L28:
            this.a.c.put(r3.getAssetType(), Long.valueOf(r9));
            goto L37
        L19:
            r9 = r4;
            goto L21
        L85:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class h implements SingleOnSubscribe<Unit> {
        public final /* synthetic */ Map a;

        public h(Map r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "emitter");
            Map r3 = this.a;
            String r4 = GsonProtectorUtils.toJson(l97.a.a, r3);
            iz0.a r0 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.b(AssetKevaKey.RESOURCE_LRU_MD5_CACHE, r4);
        }
    }

    static {
    }

    public final com.bytedance.android.livesdk.gift.configmodel.m h() {
        return (com.bytedance.android.livesdk.gift.configmodel.m) this.e.getValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final long c() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r1 = this.b.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next().getKey();
        Map<String, v> r3 = this.b.get(r2);
        if (r3 == null) goto L11;
        Collection<v> r4 = r3.values();
        if (r4 == null) goto L11;
        List r5 = CollectionsKt.toMutableList(r4);
        if (r5 == null) goto L11;
    L12:
        r0.put(r2, r5);
    L11:
        r5 = new ArrayList();
        goto L12
    L13:
        ArrayList r6 = new ArrayList();
        r6.addAll(this.l.h());
        Iterator r7 = r0.entrySet().iterator();
        long r8 = 0;
    L15:
        if (r7.hasNext() == false) goto L29;
        List r9 = (List) ((Map.Entry) r7.next()).getValue();
        if (r9.size() <= 1) goto L19;
        CollectionsKt.sortWith(r9, new b());
    L19:
        long r10 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator r11 = r9.iterator();
    L21:
        if (r11.hasNext() == false) goto L15;
        v r13 = (v) r11.next();
        if (i(r13, r6, r10, null) == true) goto L21;
        if ((r10 - r13.i3()) <= com.bytedance.android.livesdk.gift.platform.business.i.d().C0()) goto L21;
        jy0.b.a("GiftAssetClean", "getDeletableCacheSizeMB, 可清理礼物资源, 资源ID是：" + r13.getAssetId() + "， 资源大小是： " + r13.getSize());
        r8 = r8 + r13.getSize();
        goto L21
    L29:
        return r8 / ((long) 1024);
    }

    public final void k() {
        if (this.i == false) goto L17;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r1 = this.b.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Map<String, v>> r2 = r1.next();
        String r3 = r2.getKey();
        Map<String, v> r4 = r2.getValue();
        if ((!Intrinsics.areEqual(r3, "not_belong_poll_resource_tag")) == false) goto L6;
        r0.put(r3, r4.keySet());
        goto L6
    L10:
        int r5 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r6 = Single.create(new h(r0));
        int r7 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r6.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
        this.i = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void destroy() {
        k();
        this.a.clear();
        Disposable r0 = this.h;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void init() {
        if (h().getEnable() == true) goto L5;
        return;
    L5:
        int r0 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r1 = Single.create(new c());
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r3 = r1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.a);
        Observable r4 = this.l.g.observeOn(AndroidSchedulers.mainThread());
        if (r4 == null) goto L8;
        Disposable r5 = r4.subscribe(new f(this), g.a);
    L9:
        if (r5 == null) goto L11;
        this.a.add(r5);
    L11:
        this.a.add(r3);
        return;
    L8:
        r5 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void leaveRoom() {
        k();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void b(Map<String, ? extends com.bytedance.android.live.core.resources.c> r8) {
        Intrinsics.checkNotNullParameter(r8, "strategyMap");
        if (h().getEnable() == false) goto L27;
        Map<String, com.bytedance.android.livesdk.gift.configmodel.g> r0 = h().K8();
        Iterator<Map.Entry<String, ? extends com.bytedance.android.live.core.resources.c>> r9 = r8.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L35;
        Map.Entry<String, ? extends com.bytedance.android.live.core.resources.c> r1 = r9.next();
        String r2 = r1.getKey();
        com.bytedance.android.live.core.resources.c r3 = r1.getValue();
        com.bytedance.android.livesdk.gift.configmodel.g r4 = r0.get(r2);
        if (r4 == null) goto L7;
        if (r3.getCleanStrategy() != CleanStrategyType.LRU.getValue()) goto L7;
        if (r3.getPoolSize() >= r4.getPoolSize()) goto L17;
    L19:
        int r5 = r4.getPoolSize();
    L21:
        if (r3.getMaxSize() >= r4.getPoolSize()) goto L23;
    L25:
        int r6 = r4.U7();
    L26:
        com.bytedance.android.live.core.resources.c r7 = vh7.f.c(com.bytedance.android.live.core.resources.c.class);
        r7.setPoolSize(r5);
        r7.setCleanStrategy(r3.getCleanStrategy());
        r7.setMaxSize(r6);
        this.d.put(r2, r7);
        goto L7
    L23:
        if (r3.getPoolSize() > r4.U7()) goto L25;
        r6 = r3.getMaxSize();
        goto L26
    L17:
        if (r3.getPoolSize() > r4.U7()) goto L19;
        r5 = r3.getPoolSize();
        goto L21
    L35:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void d(List<? extends com.bytedance.android.live.core.resources.e> r8) {
        Intrinsics.checkNotNullParameter(r8, "assetList");
        ConcurrentHashMap<String, v> r0 = this.l.c;
        if (r0.isEmpty() == false) goto L6;
        jy0.b.c("GiftAssetClean", "resourceRecord is empty", null, 4);
        return;
    L6:
        Iterator<? extends com.bytedance.android.live.core.resources.e> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L48;
        com.bytedance.android.live.core.resources.e r1 = r9.next();
        com.bytedance.android.live.core.resources.b r3 = r1.getCleanStrategy();
        if (r3 == null) goto L8;
        if (r3.getCleanType() != CleanStrategyType.LRU.getValue()) goto L8;
        Set r4 = ((LinkedHashMap) this.d).keySet();
        com.bytedance.android.live.core.resources.b r5 = r1.getCleanStrategy();
        if (r5 == null) goto L17;
        String r6 = r5.getAssetType();
    L19:
        if (CollectionsKt.contains(r4, r6) == false) goto L8;
        String r7 = this.m.D1(r1.getId());
        if (r7 == null) goto L8;
        v r10 = r0.get(r7);
        if (r10 == null) goto L8;
        com.bytedance.android.live.core.resources.b r11 = r1.getCleanStrategy();
        if (r11 == null) goto L29;
        long r13 = r11.getKeepAliveTime();
    L30:
        r10.x7(r13);
        Map<String, Map<String, v>> r14 = this.b;
        com.bytedance.android.live.core.resources.b r15 = r1.getCleanStrategy();
        if (r15 == null) goto L33;
        String r16 = r15.getAssetType();
    L34:
        Map<String, v> r17 = r14.get(r16);
        if (r17 != null) goto L38;
        r17 = new LinkedHashMap();
    L38:
        if (r17.containsKey(r7) == true) goto L40;
        r17.put(r7, r10);
        this.i = true;
    L40:
        com.bytedance.android.live.core.resources.b r2 = r1.getCleanStrategy();
        if (r2 == null) goto L45;
        String r18 = r2.getAssetType();
        if (r18 == null) goto L45;
        this.b.put(r18, r17);
    L45:
        Map<String, v> r19 = this.b.get("not_belong_poll_resource_tag");
        if (r19 == null) goto L8;
        v r20 = r19.remove(r7);
        goto L8
    L33:
        r16 = null;
        goto L34
    L29:
        r13 = 0;
        goto L30
    L17:
        r6 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void e(CleanOpportunity r3) {
        Intrinsics.checkNotNullParameter(r3, "cleanOpportunity");
        if (com.bytedance.android.livesdk.gift.platform.business.effect.delete.h.b[r3.ordinal()] == 1) goto L5;
        this.f = false;
        return;
    L5:
        this.g = false;
        this.k = null;
    }

    public static final void g(LRUCleanStrategy r11, Map r13) {
        ConcurrentHashMap<String, v> r0 = r11.l.c;
        jy0.b.c("GiftAssetClean", "recordMap size is " + r0.size(), null, 4);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r14 = r13.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L20;
        Map.Entry r2 = (Map.Entry) r14.next();
        String r4 = (String) r2.getKey();
        List r3 = (List) r2.getValue();
        Map<String, v> r5 = r11.b.get(r4);
        if (r5 != null) goto L8;
        r5 = new LinkedHashMap();
    L8:
        LinkedHashMap r6 = new LinkedHashMap();
        long r7 = 0;
        Iterator r8 = r3.iterator();
    L10:
        if (r8.hasNext() == false) goto L18;
        String r9 = (String) r8.next();
        v r10 = r0.get(r9);
        if (r10 == null) goto L10;
        if (r5.containsKey(r9) == true) goto L17;
        r6.put(r9, r10);
        r1.put(r9, r10);
    L17:
        r7 = r7 + r10.getSize();
        goto L10
    L18:
        r6.putAll(r5);
        r11.b.put(r4, r6);
        r11.c.put(r4, Long.valueOf(r7));
        goto L4
    L20:
        if (com.bytedance.android.livesdk.gift.platform.business.i.b().getEnable() == false) goto L45;
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<Map.Entry<String, v>> r16 = r0.entrySet().iterator();
    L23:
        if (r16.hasNext() == false) goto L32;
        Map.Entry<String, v> r17 = r16.next();
        String r18 = r17.getKey();
        v r19 = r17.getValue();
        if (r1.containsKey(r18) == true) goto L29;
        boolean r20 = true;
        if ((!Intrinsics.areEqual(r18, "zip")) == false) goto L29;
    L30:
        if (r20 == false) goto L23;
        r15.put(r17.getKey(), r17.getValue());
    L29:
        r20 = false;
        goto L30
    L32:
        r11.b.put("not_belong_poll_resource_tag", MapsKt.toMutableMap(r15));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void a(CleanOpportunity r6, t r7) {
        Intrinsics.checkNotNullParameter(r6, "cleanOpportunity");
        if (com.bytedance.android.livesdk.gift.platform.business.effect.delete.h.a[r6.ordinal()] != 1) goto L5;
        this.g = true;
        this.k = r7;
        Disposable r8 = this.h;
        if (r8 == null) goto L36;
        if (r8.isDisposed() == true) goto L36;
        t r9 = this.k;
        if (r9 == null) goto L66;
        r9.a();
        return;
    L66:
        return;
    L36:
        if (h().getEnable() == true) goto L38;
    L55:
        t r10 = this.k;
        if (r10 == null) goto L69;
        r10.b();
        return;
    L69:
        return;
    L38:
        if (this.b.isEmpty() == true) goto L55;
        t r11 = this.k;
        if (r11 == null) goto L43;
        r11.c();
    L43:
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r14 = this.b.entrySet().iterator();
    L45:
        if (r14.hasNext() == false) goto L54;
        Map.Entry<String, Map<String, v>> r0 = r14.next();
        String r1 = r0.getKey();
        Map<String, v> r2 = r0.getValue();
        Map<String, v> r3 = this.b.get(r1);
        if (r3 == null) goto L52;
        Collection<v> r4 = r3.values();
        if (r4 == null) goto L52;
        List r5 = CollectionsKt.toMutableList(r4);
        if (r5 == null) goto L52;
    L53:
        r13.put(r1, r5);
    L52:
        r5 = new ArrayList();
        goto L53
    L54:
        ArrayList r15 = new ArrayList();
        r15.addAll(this.l.h());
        int r16 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r17 = Single.create(new o(this, r13, r15));
        int r18 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.h = r17.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this), new q(this));
        return;
    L5:
        if (h().getEnable() == true) goto L8;
    L27:
        this.f = true;
        return;
    L8:
        if (this.b.isEmpty() == false) goto L10;
        jy0.b.c("GiftAssetClean", "池子为空，跳过清理", null, 4);
        goto L27
    L10:
        Disposable r19 = this.h;
        if (r19 != null) goto L13;
    L15:
        LinkedHashMap r20 = new LinkedHashMap();
        r20.putAll(this.c);
        LinkedHashMap r21 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r23 = this.b.entrySet().iterator();
    L17:
        if (r23.hasNext() == false) goto L26;
        Map.Entry<String, Map<String, v>> r24 = r23.next();
        String r25 = r24.getKey();
        Map<String, v> r26 = r24.getValue();
        Map<String, v> r27 = this.b.get(r25);
        if (r27 == null) goto L24;
        Collection<v> r28 = r27.values();
        if (r28 == null) goto L24;
        List r29 = CollectionsKt.toMutableList(r28);
        if (r29 == null) goto L24;
    L25:
        r21.put(r25, r29);
    L24:
        r29 = new ArrayList();
        goto L25
    L26:
        ArrayList r30 = new ArrayList();
        r30.addAll(this.l.h());
        int r31 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r33 = Single.create(new i(this, r21, r30, r6));
        int r34 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.h = r33.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r20), k.a);
        goto L27
    L13:
        if (r19.isDisposed() == true) goto L15;
        jy0.b.c("GiftAssetClean", "上一次清理任务没有执行完成,跳过清理", null, 4);
        goto L27
    }

    public LRUCleanStrategy(ResourceRecordService r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r3, GiftResourceFileCacheService r4) {
        Intrinsics.checkNotNullParameter(r2, "recordService");
        Intrinsics.checkNotNullParameter(r3, "assetsService");
        Intrinsics.checkNotNullParameter(r4, "fileCacheService");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.a = new CompositeDisposable();
        if (com.bytedance.android.livesdk.gift.platform.business.i.e().v3() == false) goto L5;
        Map<String, Map<String, v>> r5 = new ConcurrentHashMap();
    L6:
        this.b = r5;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(LRUCleanStrategy$cleanConfig$2.INSTANCE);
        return;
    L5:
        r5 = new LinkedHashMap();
        goto L6
    }

    public static boolean i(v r7, List r8, long r9, ConcurrentHashMap r11) {
        if (r8.contains(r7.getMd5()) == false) goto L7;
        jy0.b.c("GiftAssetClean", r7.getMd5() + "跳过删除, 资源ID是：" + r7.getAssetId() + ", 白名单更新时间 " + r7.i3(), null, 4);
        return true;
    L7:
        if (r9 > r7.J0()) goto L10;
        jy0.b.c("GiftAssetClean", r7.getMd5() + "跳过删除, 资源ID是:" + r7.getAssetId() + ", server保活时间为 " + r7.J0(), null, 4);
        return true;
    L10:
        if (r11 == null) goto L17;
        Integer r10 = (Integer) r11.get(r7.getMd5());
        if (r10 != null) goto L14;
        return false;
    L14:
        if (r10.intValue() <= 0) goto L20;
        jy0.b.c("GiftAssetClean", r7.getMd5() + "跳过删除, 资源ID是:" + r7.getAssetId() + ", 跳过原因：正在播放", null, 4);
        return true;
    L20:
        return false;
    L17:
        return false;
    }

    public static /* synthetic */ boolean j(LRUCleanStrategy r0, v r1, List r2, long r3) {
        r0.getClass();
        return i(r1, r2, r3, null);
    }

    public static final CleanResourceResult f(LRUCleanStrategy r13, v r14, long r15, CleanOpportunity r16, String r17) {
        r13.getClass();
        String r0 = r14.getMd5();
        StringBuilder r1 = new StringBuilder();
        r1.append(r13.n.f());
        int r3 = uy0.a.a;
        r1.append("/");
        r1.append(r0);
        r1.append("/");
        String r2 = r1.toString();
        com.bytedance.android.livesdk.gift.configmodel.g r4 = r13.h().K8().get(r17);
        if (r4 == null) goto L5;
        long r5 = r4.d5();
    L7:
        if (r5 > 0) goto L10;
        r5 = r13.h().d3();
    L10:
        uy0.b r6 = com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class);
        if (r6.Y4(r2) == false) goto L27;
        boolean r7 = r6.J(r2);
        if (r7 == true) goto L15;
    L23:
        if (r7 == false) goto L29;
        return CleanResourceResult.FILE_REMOVE_SUCCESS;
    L29:
        return CleanResourceResult.FILE_REMOVE_FAILED;
    L15:
        if (r16 != CleanOpportunity.MANUAL_CLEAN_IN_ROOM) goto L19;
        String r8 = "pop_up";
    L17:
        String r9 = r8;
        jy0.b.c("GiftAssetClean", r14.getMd5() + "执行删除, 资源ID是：" + r14.getAssetId(), null, 4);
        int r10 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(r14.getAssetId(), r15 - r14.i3(), r14.getMd5(), r9, null, r16, r17, 16);
        goto L23
    L19:
        if ((r15 - r14.i3()) <= r5) goto L21;
        r8 = "expire_clean";
        goto L17
    L21:
        r8 = "lru_clean";
        goto L17
    L27:
        return CleanResourceResult.FILE_NOT_EXIST;
    L5:
        r5 = 0;
        goto L7
    }
}
