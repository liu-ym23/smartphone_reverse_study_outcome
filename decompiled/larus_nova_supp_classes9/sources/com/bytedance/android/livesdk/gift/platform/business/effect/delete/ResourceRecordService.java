package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.livesdk.config.v31;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.b0;
import com.bytedance.android.livesdk.gift.platform.core.keva_store.AssetKevaKey;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ResourceRecordService implements com.bytedance.android.scope.o, dy0.c {
    public final ConcurrentHashMap<String, Long> a;
    public final LinkedHashMap<String, Long> b;
    public final ConcurrentHashMap<String, v> c;
    public final BehaviorSubject<Boolean> d;
    public final BehaviorSubject<Boolean> e;
    public final BehaviorSubject<Boolean> f;
    public final PublishSubject<v> g;
    public Disposable h;
    public volatile boolean i;
    public boolean j;
    public boolean k;
    public final Lazy l;
    public final CompositeDisposable m;
    public final Lazy n;
    public final GiftResourceFileCacheService o;
    public final uy0.b p;

    public static final class a implements ObservableOnSubscribe<u> {
        public final /* synthetic */ ResourceRecordService a;

        public a(ResourceRecordService r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<u> r18) {
            Intrinsics.checkNotNullParameter(r18, "emitter");
            LinkedHashMap r4 = new LinkedHashMap();
            LinkedHashMap r5 = new LinkedHashMap();
            if (this.a.g().G6().getEnable() == false) goto L25;
            iz0.a r6 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;     // Catch: Exception -> L22
            String r7 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a(AssetKevaKey.RESOURCE_DOWNLOAD_BLACK_LIST);     // Catch: Exception -> L22
            if (r7.length() <= 0) goto L7;
            boolean r13 = true;
        L8:
            if (r13 == false) goto L10;
            String r14 = r7;
        L11:
            if (r14 == null) goto L13;
            Gson r15 = l97.a.a;     // Catch: Exception -> L22
            KTypeProjection.Companion r16 = KTypeProjection.Companion;     // Catch: Exception -> L22
            LinkedHashMap r8 = (LinkedHashMap) r15.fromJson(r7, TypesJVMKt.getJavaType(Reflection.typeOf(LinkedHashMap.class, r16.invariant(Reflection.typeOf(String.class)), r16.invariant(Reflection.typeOf(Long.TYPE)))));     // Catch: Exception -> L22
        L14:
            if (r8 == null) goto L16;
            r4.putAll(r8);     // Catch: Exception -> L22
        L16:
            StringBuilder r9 = new StringBuilder("ResourceRecordService onStart, init black download list, listStr = ");     // Catch: Exception -> L22
            r9.append(r7);     // Catch: Exception -> L22
            r9.append(", list.size = ");     // Catch: Exception -> L22
            if (r8 == null) goto L19;
            Integer r0 = Integer.valueOf(r8.size());     // Catch: Exception -> L22
        L20:
            r9.append(r0);     // Catch: Exception -> L22
            jy0.b.a("GiftAssetClean", r9.toString());     // Catch: Exception -> L22
            goto L25
        L19:
            r0 = null;
            goto L20
        L13:
            r8 = null;
            goto L14
        L10:
            r14 = null;
            goto L11
        L7:
            r13 = false;
        L22:
            e = move-exception;
            jy0.b.c("GiftAssetClean", "black download list parse error, error is " + e.getMessage(), null, 4);
        L25:
            if (this.a.g().E7().getEnable() == true) goto L50;
        L46:
            r18.onNext(new u(r4, r5));
            r18.onComplete();
            return;
        L50:
            iz0.a r1 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;     // Catch: Exception -> L44
            String r2 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a(AssetKevaKey.RESOURCE_DELETE_WHITE_LIST);     // Catch: Exception -> L44
            if (r2.length() <= 0) goto L29;
            boolean r10 = true;
        L30:
            if (r10 == false) goto L32;
            String r11 = r2;
        L33:
            if (r11 == null) goto L35;
            Gson r17 = l97.a.a;     // Catch: Exception -> L44
            KTypeProjection.Companion r19 = KTypeProjection.Companion;     // Catch: Exception -> L44
            LinkedHashMap r20 = (LinkedHashMap) r17.fromJson(r2, TypesJVMKt.getJavaType(Reflection.typeOf(LinkedHashMap.class, r19.invariant(Reflection.typeOf(String.class)), r19.invariant(Reflection.typeOf(Long.TYPE)))));     // Catch: Exception -> L44
        L36:
            if (r20 == null) goto L38;
            r5.putAll(r20);     // Catch: Exception -> L44
        L38:
            StringBuilder r21 = new StringBuilder("ResourceRecordService onStart, init white delete list, listStr = ");     // Catch: Exception -> L44
            r21.append(r2);     // Catch: Exception -> L44
            r21.append(", list.size = ");     // Catch: Exception -> L44
            if (r20 == null) goto L41;
            Integer r3 = Integer.valueOf(r20.size());     // Catch: Exception -> L44
        L42:
            r21.append(r3);     // Catch: Exception -> L44
            jy0.b.a("GiftAssetClean", r21.toString());     // Catch: Exception -> L44
            goto L46
        L41:
            r3 = null;
            goto L42
        L35:
            r20 = null;
            goto L36
        L32:
            r11 = null;
            goto L33
        L29:
            r10 = false;
        L44:
            e = move-exception;
            jy0.b.c("GiftAssetClean", "white list parse error, error is " + e.getMessage(), null, 4);
            goto L46
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ResourceRecordService a;

        public b(ResourceRecordService r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            u r10 = (u) r9;
            jy0.b.a("GiftAssetClean", "ResourceRecordService resourceInformation: black:" + r10.a.size() + ", white:" + r10.b.size());
            if ((!this.a.b.isEmpty()) == false) goto L5;
            this.a.j = true;
        L5:
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<Map.Entry<String, Long>> r3 = r10.b.entrySet().iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            Map.Entry<String, Long> r4 = r3.next();
            String r5 = r4.getKey();
            long r6 = r4.getValue().longValue();
            if (this.a.b.containsKey(r5) == true) goto L7;
            r0.put(r5, Long.valueOf(r6));
            goto L7
        L11:
            r0.putAll(this.a.b);
            this.a.b.clear();
            this.a.b.putAll(r0);
            if ((!this.a.a.isEmpty()) == false) goto L14;
            this.a.i = true;
        L14:
            this.a.a.putAll(r10.a);
            BehaviorSubject<Boolean> r11 = this.a.d;
            Boolean r2 = Boolean.TRUE;
            r11.onNext(r2);
            this.a.e.onNext(r2);
            jy0.b.a("GiftAssetClean", "ResourceRecordService resultMap: " + r0.size());
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ ResourceRecordService a;

        public d(ResourceRecordService r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Boolean r4 = (Boolean) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            ResourceRecordService r0 = this.a;
            return ResourceRecordService.a(r0, r0.o, r4.booleanValue());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ResourceRecordService a;

        public e(ResourceRecordService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            if (((Boolean) r6.getFirst()).booleanValue() == true) goto L5;
            return;
        L5:
            if (this.a.c.isEmpty() == false) goto L7;
            this.a.c.putAll((Map) r6.getSecond());
        L16:
            this.a.f.onNext(Boolean.TRUE);
            return;
        L7:
            Iterator r7 = ((Map) r6.getSecond()).entrySet().iterator();
        L9:
            if (r7.hasNext() == false) goto L16;
            Map.Entry r0 = (Map.Entry) r7.next();
            String r1 = (String) r0.getKey();
            v r2 = (v) r0.getValue();
            if (this.a.c.get(r1) != null) goto L12;
            this.a.c.put(r1, r2);
            goto L9
        L12:
            v r3 = this.a.c.get(r1);
            if (r3 == null) goto L9;
            r3.setSize(r2.getSize());
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class g implements ObservableOnSubscribe<Pair<? extends Boolean, ? extends Map<String, ? extends v>>> {
        public final /* synthetic */ ResourceRecordService a;

        public g(ResourceRecordService r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Pair<Boolean, Map<String, v>>> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            ResourceRecordService r0 = this.a;
            r4.onNext(ResourceRecordService.a(r0, r0.o, true));
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ ResourceRecordService a;

        public h(ResourceRecordService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            if (((Boolean) r6.getFirst()).booleanValue() == true) goto L5;
            return;
        L5:
            if (this.a.c.isEmpty() == false) goto L7;
            this.a.c.putAll((Map) r6.getSecond());
        L16:
            this.a.f.onNext(Boolean.TRUE);
            return;
        L7:
            Iterator r7 = ((Map) r6.getSecond()).entrySet().iterator();
        L9:
            if (r7.hasNext() == false) goto L16;
            Map.Entry r0 = (Map.Entry) r7.next();
            String r1 = (String) r0.getKey();
            v r2 = (v) r0.getValue();
            if (this.a.c.get(r1) != null) goto L12;
            this.a.c.put(r1, r2);
            goto L9
        L12:
            v r3 = this.a.c.get(r1);
            if (r3 == null) goto L9;
            r3.setSize(r2.getSize());
            goto L9
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class j implements SingleOnSubscribe<Unit> {
        public final /* synthetic */ Map a;
        public final /* synthetic */ LinkedHashMap b;
        public final /* synthetic */ Map c;

        public final void subscribe(SingleEmitter<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            Map r0 = this.a;
            if (r0 == null) goto L5;
            String r1 = GsonProtectorUtils.toJson(l97.a.a, r0);
            iz0.a r2 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.b(AssetKevaKey.RESOURCE_DELETE_WHITE_LIST, r1);
        L5:
            LinkedHashMap r3 = this.b;
            if (r3 == null) goto L8;
            String r4 = GsonProtectorUtils.toJson(l97.a.a, r3);
            iz0.a r6 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.b(AssetKevaKey.RESOURCE_DOWNLOAD_BLACK_LIST, r4);
        L8:
            Map r7 = this.c;
            if (r7 == null) goto L11;
            String r8 = GsonProtectorUtils.toJson(l97.a.a, r7);
            iz0.a r9 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.b(AssetKevaKey.RESOURCE_USED_INFORMATION_RECORD, r8);
        L11:
            jy0.b.c("GiftAssetClean", "写回黑名单内容: " + this.b, null, 4);
            r5.onSuccess(Unit.INSTANCE);
        }

        public j(Map r1, LinkedHashMap r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class k<T> implements Consumer {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final com.bytedance.android.livesdk.gift.configmodel.m g() {
        return (com.bytedance.android.livesdk.gift.configmodel.m) this.l.getValue();
    }

    public final void E() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        LinkedHashMap r1 = null;
        if (this.j == true) goto L10;
    L12:
        LinkedHashMap r2 = null;
    L14:
        if (this.i == true) goto L16;
    L18:
        LinkedHashMap r3 = null;
    L20:
        if (g().getEnable() == true) goto L22;
    L24:
        if (r3 != null) goto L28;
        if (r2 != null) goto L28;
        if (r1 != null) goto L28;
        return;
    L28:
        this.j = false;
        this.i = false;
        this.k = false;
        int r4 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r5 = Single.create(new j(r2, r3, r1));
        int r6 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.h = r5.subscribeOn(Schedulers.io()).subscribe(k.a, l.a);
        return;
    L22:
        if (this.k == false) goto L24;
        r1 = new LinkedHashMap();
        r1.putAll(this.c);
        goto L24
    L16:
        if (g().G6().getEnable() == false) goto L18;
        r3 = new LinkedHashMap();
        r3.putAll(this.a);
        goto L20
    L10:
        if (g().E7().getEnable() == false) goto L12;
        r2 = new LinkedHashMap();
        r2.putAll(this.b);
        goto L14
    L5:
        if (r0.isDisposed() == true) goto L7;
    }

    public final List<String> h() {
        ArrayList r0 = new ArrayList();
        if (g().E7().getEnable() == true) goto L5;
        return r0;
    L5:
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        long r2 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator<Map.Entry<String, Long>> r3 = this.b.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Map.Entry<String, Long> r4 = r3.next();
        String r5 = r4.getKey();
        if ((r2 - r4.getValue().longValue()) >= g().E7().getExpireTime()) goto L7;
        r0.add(r5);
        goto L7
    L11:
        jy0.b.c("GiftAssetClean", "白名单内容: " + r0, null, 4);
        return r0;
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r1 = Observable.create(new a(this));
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r3 = r1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
        if (g().getEnable() == true) goto L5;
        return;
    L5:
        jy0.b.a("GiftAssetClean", "ResourceRecordService assetsFileArrayInitStatus.value = " + ((Boolean) this.o.m.getValue()));
        if (Intrinsics.areEqual((Boolean) this.o.m.getValue(), Boolean.TRUE) == false) goto L8;
        this.m.add(Observable.create(new g(this)).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new h(this), i.a));
    L9:
        this.m.add(r3);
        return;
    L8:
        this.m.add(this.o.m.observeOn(Schedulers.io()).map(new d(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.a));
        goto L9
    }

    public final void f() {
        if (g().G6().getEnable() == true) goto L5;
        return;
    L5:
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator<Map.Entry<String, Long>> r2 = this.a.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if ((r1 - r2.next().getValue().longValue()) <= g().G6().getExpireTime()) goto L7;
        r2.remove();
        goto L7
    L11:
        int r3 = this.a.size() - g().G6().getLength();
        if (r3 <= 0) goto L36;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Map.Entry<String, Long>> r5 = this.a.entrySet().iterator();
    L14:
        int r6 = 0;
        if (r5.hasNext() == false) goto L20;
        Map.Entry<String, Long> r7 = r5.next();
        String r8 = r7.getKey();
        long r9 = r7.getValue().longValue();
        Integer r10 = (Integer) r4.get(Long.valueOf(r9));
        if (r10 != null) goto L19;
        r10 = 0;
    L19:
        r4.put(Long.valueOf(r9), Integer.valueOf(r10.intValue() + 1));
        goto L14
    L20:
        long r11 = -1;
        if (r4.size() > 0) goto L23;
        return;
    L23:
        Iterator r13 = r4.entrySet().iterator();
        int r14 = 0;
    L25:
        if (r13.hasNext() == false) goto L29;
        Map.Entry r15 = (Map.Entry) r13.next();
        r14 = r14 + ((Number) r15.getValue()).intValue();
        if (r14 <= r3) goto L25;
        r11 = ((Number) r15.getKey()).longValue();
    L29:
        Iterator<Map.Entry<String, Long>> r16 = this.a.entrySet().iterator();
    L31:
        if (r16.hasNext() == false) goto L36;
        if (r6 > r3) goto L36;
        if (r16.next().getValue().longValue() > r11) goto L31;
        r16.remove();
        r6 = r6 + 1;
    L36:
        this.i = true;
    }

    public final void onStop() {
        E();
    }

    public final void A(String r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (g().getEnable() == true) goto L7;
        return;
    L7:
        this.c.remove(r2);
        this.k = true;
    }

    public final void I(String r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (g().G6().getEnable() == true) goto L7;
        return;
    L7:
        this.a.remove(r6);
        ConcurrentHashMap<String, Long> r0 = this.a;
        i97.a r1 = i97.a.a;
        r0.put(r6, Long.valueOf(System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        this.i = true;
    }

    public ResourceRecordService(GiftResourceFileCacheService r2, uy0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "fileCacheService");
        Intrinsics.checkNotNullParameter(r3, "hostFileService");
        this.o = r2;
        this.p = r3;
        this.a = new ConcurrentHashMap();
        this.b = new LinkedHashMap();
        this.c = new ConcurrentHashMap();
        int r4 = com.bytedance.revenue.platform.api.core.rx.c.a;
        Boolean r5 = Boolean.FALSE;
        this.d = BehaviorSubject.createDefault(r5);
        this.e = BehaviorSubject.createDefault(r5);
        this.f = BehaviorSubject.createDefault(r5);
        int r6 = com.bytedance.revenue.platform.api.core.rx.o.a;
        this.g = PublishSubject.create();
        this.l = LazyKt.lazy(ResourceRecordService$cleanConfig$2.INSTANCE);
        this.m = new CompositeDisposable();
        this.n = LazyKt.lazy(ResourceRecordService$giftDeleteOpt$2.INSTANCE);
    }

    public final void f0(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "md5");
        if (g().E7().getEnable() == true) goto L5;
        return;
    L5:
        this.b.remove(r7);
        this.b.put(r7, Long.valueOf(r8));
        int r9 = this.b.size();
        com.bytedance.live.kmp.util.c r10 = com.bytedance.live.kmp.util.c.a;
        long r11 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator<Map.Entry<String, Long>> r0 = this.b.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<String, Long> r1 = r0.next();
        if (r9 <= g().E7().getLength()) goto L12;
        r0.remove();
    L15:
        r9 = r9 - 1;
        goto L7
    L12:
        if ((r11 - r1.getValue().longValue()) <= g().E7().getExpireTime()) goto L16;
        r0.remove();
    L16:
        this.j = true;
    }

    public static final Pair a(ResourceRecordService r13, GiftResourceFileCacheService r14, boolean r15) {
        r13.getClass();
        jy0.b.a("GiftAssetClean", "ResourceRecordService initResourceModelSp, isInit = " + r15);
        LinkedHashMap r1 = new LinkedHashMap();
        if (r15 == false) goto L84;
        ConcurrentHashMap<String, String> r16 = r14.c;
        if (r13.g().getEnable() == false) goto L63;
        iz0.a r3 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;     // Catch: Throwable -> L60
        String r4 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a(AssetKevaKey.RESOURCE_USED_INFORMATION_RECORD);     // Catch: Throwable -> L60
        if (r4.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        String r6 = r4;
    L15:
        if (r6 == null) goto L17;
        Gson r7 = l97.a.a;     // Catch: Throwable -> L60
        KTypeProjection.Companion r9 = KTypeProjection.Companion;     // Catch: Throwable -> L60
        Map r8 = (Map) r7.fromJson(r6, TypesJVMKt.getJavaType(Reflection.typeOf(Map.class, r9.invariant(Reflection.typeOf(String.class)), r9.invariant(Reflection.typeOf(v.class)))));     // Catch: Throwable -> L60
    L18:
        if (r8 == null) goto L20;
        r1.putAll(r8);     // Catch: Throwable -> L60
    L20:
        StringBuilder r10 = new StringBuilder("ResourceRecordService initResourceModelSp, recordListString = ");     // Catch: Throwable -> L60
        r10.append(r4);     // Catch: Throwable -> L60
        r10.append(", list.size = ");     // Catch: Throwable -> L60
        if (r8 == null) goto L23;
        Integer r0 = Integer.valueOf(r8.size());     // Catch: Throwable -> L60
    L24:
        r10.append(r0);     // Catch: Throwable -> L60
        jy0.b.a("GiftAssetClean", r10.toString());     // Catch: Throwable -> L60
        Iterator r2 = r1.entrySet().iterator();     // Catch: Throwable -> L60
    L26:
        if (r2.hasNext() == false) goto L33;
        Map.Entry r11 = (Map.Entry) r2.next();     // Catch: Throwable -> L60
        if (((v) r11.getValue()).getSize() > 0) goto L26;
        String r17 = (String) r11.getKey();     // Catch: Throwable -> L60
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L60
        r18.append(r13.o.f());     // Catch: Throwable -> L60
        int r19 = uy0.a.a;     // Catch: Throwable -> L60
        r18.append("/");     // Catch: Throwable -> L60
        r18.append(r17);     // Catch: Throwable -> L60
        r18.append("/");     // Catch: Throwable -> L60
        String r20 = r18.toString();     // Catch: Throwable -> L60
        if (r13.p.Y4(r20) == true) goto L31;
        r2.remove();     // Catch: Throwable -> L60
        goto L26
    L31:
        ((v) r11.getValue()).setSize(r13.p.l4(r20) / ((long) 1024));     // Catch: Throwable -> L60
        goto L26
    L33:
        Iterator<Map.Entry<String, String>> r110 = r16.entrySet().iterator();     // Catch: Throwable -> L60
    L35:
        if (r110.hasNext() == false) goto L63;
        Map.Entry<String, String> r21 = r110.next();     // Catch: Throwable -> L60
        String r23 = r21.getKey();     // Catch: Throwable -> L60
        String r24 = r21.getValue();     // Catch: Throwable -> L60
        if (r1.containsKey(r23) == true) goto L35;
        if ((!Intrinsics.areEqual(r23, "zip")) == false) goto L35;
        if (r13.p.Y4(r24) == false) goto L35;
        Class r25 = v.class.getAnnotation(JsonAdapter.class).value();     // Catch: Throwable -> L60
        ConcurrentHashMap r26 = vh7.b.a;     // Catch: Throwable -> L60
        Object r27 = r26.get(r25);     // Catch: Throwable -> L60
        if (r27 != null) goto L52;
        r27 = r25.getConstructor(new Class[0]);     // Catch: Throwable -> L60
        if (r27 == null) goto L51;
        Object r28 = r26.putIfAbsent(r25, r27);     // Catch: Throwable -> L60
        if (r28 == null) goto L52;
        r27 = r28;
        goto L52
    L51:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");     // Catch: Throwable -> L60
    L52:
        Object r29 = ((SerializableObjectJsonAdapterBase) ((Constructor) r27).newInstance(new Object[0])).createInstance();     // Catch: Throwable -> L60
        if (r29 == null) goto L59;
        v r30 = (v) r29;     // Catch: Throwable -> L60
        r30.R4(r23);     // Catch: Throwable -> L60
        r30.setSize(r13.p.l4(r24) / ((long) 1024));     // Catch: Throwable -> L60
        if (((v31) r13.n.getValue()).q1() == false) goto L57;
        r30.U4(0);     // Catch: Throwable -> L60
    L57:
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L60
        r1.put(r23, r30);     // Catch: Throwable -> L60
        StringBuilder r33 = new StringBuilder();     // Catch: Throwable -> L60
        r33.append("ResourceRecordService initResourceModelSp, fileCache foreach, recordItem = ");     // Catch: Throwable -> L60
        r33.append(l97.a.a.toJson(r1.get(r23)));     // Catch: Throwable -> L60
        jy0.b.a("GiftAssetClean", r33.toString());     // Catch: Throwable -> L60
        goto L35
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordModel");     // Catch: Throwable -> L60
    L23:
        r0 = null;
        goto L24
    L17:
        r8 = null;
        goto L18
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = false;
    L60:
        th = move-exception;
        jy0.b.c("GiftAssetClean", "record list parse error, error is " + th.getMessage(), null, 4);
    L63:
        return new Pair(Boolean.TRUE, r1);
    L84:
        return new Pair(Boolean.FALSE, r1);
    }

    public final void x(String r8, boolean r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "md5");
        if (g().G6().getEnable() == true) goto L6;
        return;
    L6:
        if (this.a.contains(r8) == false) goto L13;
        this.a.remove(r8);
        this.i = true;
        if (r9 == true) goto L10;
        return;
    L10:
        if (r10 <= 0) goto L15;
        b0 r11 = b0.a;
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r13 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r13, "eventModule");
        String r2 = r13.getValue();
        Intrinsics.checkNotNullParameter(r5, "map");
        Long r14 = Long.valueOf(r10);
        Intrinsics.checkNotNullParameter("assets_need_download", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r5.put("assets_need_download", r14);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g("ttlive_assets_need_download", r2, "bussiness_api_call", r4, r5, r6);
        return;
    L15:
        return;
    }

    public static /* synthetic */ void b0(ResourceRecordService r11, String r13, long r14, long r15, long r17) {
        r11.K(r13, r14, 0, r15, r17);
    }

    public final void K(String r5, long r6, long r8, long r10, long r13) {
        Intrinsics.checkNotNullParameter(r5, "md5");
        if (g().getEnable() == true) goto L5;
        return;
    L5:
        v r0 = this.c.get(r5);
        if (r0 == null) goto L14;
        r0.U4(r6);
        if (r8 <= 0) goto L11;
        r0.setSize(r8);
    L11:
        if (r10 <= 0) goto L13;
        r0.setAssetId(r10);
    L13:
        r0.R4(r5);
        r0.x7(r13);
    L27:
        jy0.b.a("GiftAssetClean", "ResourceRecordService updateRecordList, md5=" + r5 + ", usedTime=" + r6 + ", size=" + r8 + ", assetId=" + r10 + ", keepAliveTime=" + r13);
        this.g.onNext(r0);
        this.k = true;
        return;
    L14:
        Class r1 = v.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r2 = vh7.b.a;
        Object r3 = r2.get(r1);
        if (r3 != null) goto L24;
        r3 = r1.getConstructor(new Class[0]);
        if (r3 == null) goto L23;
        Object r4 = r2.putIfAbsent(r1, r3);
        if (r4 == null) goto L24;
        r3 = r4;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r3).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L30;
        r0 = (v) r7;
        r0.U4(r6);
        r0.R4(r5);
        r0.setSize(r8);
        r0.setAssetId(r10);
        r0.x7(r13);
        this.c.put(r5, r0);
        goto L27
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordModel");
    }
}
