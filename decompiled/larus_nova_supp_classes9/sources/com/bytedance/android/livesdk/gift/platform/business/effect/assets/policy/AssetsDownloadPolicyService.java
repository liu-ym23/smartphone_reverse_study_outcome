package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssetsDownloadPolicyService implements o, dy0.c, e {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Map<Long, Long> e;
    public final ConcurrentHashMap<String, Long> f;
    public final MutableLiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> g;
    public final Map<Long, Integer> h;

    public static final class a implements Action {
        public final /* synthetic */ com.bytedance.android.live.core.resources.e a;
        public final /* synthetic */ AssetsDownloadPolicyService b;
        public final /* synthetic */ int c;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.j d;

        public a(com.bytedance.android.live.core.resources.e r1, AssetsDownloadPolicyService r2, int r3, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void run() {
            boolean r0 = this.d.ib(this.a, null, this.c, AssetDownloadPriority.NORMAL);
            this.b.h(this.a, r0);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public AssetsDownloadPolicyService() {
        this.a = LazyKt.lazy(AssetsDownloadPolicyService$liveDownloadDynamic$2.INSTANCE);
        this.b = LazyKt.lazy(AssetsDownloadPolicyService$liveAssetsUseMainThread$2.INSTANCE);
        this.c = LazyKt.lazy(AssetsDownloadPolicyService$liveAssetsMangerReadSettingOptimize$2.INSTANCE);
        this.d = LazyKt.lazy(AssetsDownloadPolicyService$showLog$2.INSTANCE);
        this.e = new LinkedHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new MutableLiveData();
        this.h = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void a(JSONObject r5) {
        if (r5 != null) goto L16;
        return;
    L16:
        Iterator<String> r0 = this.f.keySet().iterator();     // Catch: JSONException -> L13
    L6:
        if (r0.hasNext() == false) goto L24;
        String r1 = r0.next();     // Catch: JSONException -> L13
        if (r5.length() >= 500) goto L25;
        Long r2 = this.f.get(r1);     // Catch: JSONException -> L13
        if (r2 == null) goto L6;
        r5.put(r1, r2.longValue());     // Catch: JSONException -> L13
        goto L6
    L25:
        return;
    L24:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void f(List r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        x(r2, r3, 3);
    }

    public final void h(com.bytedance.android.live.core.resources.e r5, boolean r6) {
        if (r6 == false) goto L5;
        this.f.put(String.valueOf(r5.getId()), Long.valueOf(r5.getModifyVersion()));
    L5:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L10;
        List r0 = (List) this.g.getValue();
        if (r0 == null) goto L11;
        r0.add(new Pair(r5, Boolean.valueOf(r6)));
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void g(List<com.bytedance.android.live.core.resources.e> r21, int r23, boolean r24) {
        if (r21 != null) goto L5;
        return;
    L5:
        int r4 = 0;
        List<List<h1>> r7 = null;
        if (r23 != 3) goto L8;
    L62:
        ArrayList r6 = new ArrayList();
        r6.addAll(r21);
        ArrayList r1 = new ArrayList();
        i12.e r8 = i12.o.b();
        if (r8 == null) goto L65;
        m.e.getClass();
        r7 = (o) m.b(r8).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.effect.assets.i.class));
    L65:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.i r9 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.i) r7;
        if (r9 == null) goto L70;
        List<Long> r10 = r9.k7();
        if (r10 == null) goto L70;
        r1.addAll(r10);
    L70:
        ArrayList r11 = new ArrayList();
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator r14 = r6.iterator();
    L72:
        if (r14.hasNext() == false) goto L74;
        Object r15 = r14.next();
        r13.put(Long.valueOf(((com.bytedance.android.live.core.resources.e) r15).getId()), r15);
        goto L72
    L74:
        Map r16 = MapsKt.toMutableMap(r13);
        Iterator r2 = r1.iterator();
    L76:
        if (r2.hasNext() == false) goto L81;
        long r17 = ((Number) r2.next()).longValue();
        com.bytedance.android.live.core.resources.e r18 = (com.bytedance.android.live.core.resources.e) r16.get(Long.valueOf(r17));
        if (r18 == null) goto L80;
        r11.add(r18);
    L80:
        r16.remove(Long.valueOf(r17));
        goto L76
    L81:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r19 = r16.entrySet().iterator();
    L83:
        if (r19.hasNext() == false) goto L90;
        Map.Entry r20 = (Map.Entry) r19.next();
        if (((com.bytedance.android.live.core.resources.e) r20.getValue()).getDownloadType() != 1) goto L87;
        boolean r25 = true;
    L88:
        if (r25 == false) goto L83;
        r3.put(r20.getKey(), r20.getValue());
        goto L83
    L87:
        r25 = false;
        goto L88
    L90:
        r11.addAll(r3.values());
        x(r11, r24, r23);
        return;
    L8:
        if (r23 == 5) goto L62;
        if (r23 == 1006) goto L62;
        ((LinkedHashMap) this.h).clear();
        i12.e r26 = i12.o.b();
        if (r26 == null) goto L15;
        m.e.getClass();
        o r27 = (o) m.b(r26).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.effect.assets.h.class));
    L16:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.h r28 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.h) r27;
        if (r28 == null) goto L19;
        r7 = r28.X2();
    L19:
        if (r7 == null) goto L57;
        if (com.bytedance.android.livesdk.gift.platform.business.i.o().I0() == false) goto L47;
        Iterator<T> r29 = r7.iterator();
        int r30 = 0;
    L25:
        if (r29.hasNext() == false) goto L57;
        Iterator r110 = ((List) r29.next()).iterator();
    L28:
        if (r110.hasNext() == false) goto L25;
        h1 r111 = (h1) r110.next();
        if (r111.getPrimaryEffectId() <= 0) goto L32;
        this.h.put(Long.valueOf(r111.getPrimaryEffectId()), Integer.valueOf(r30));
        r30 = r30 + 1;
    L32:
        List<Long> r112 = r111.getAssetIds();
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L34:
        if (r114.hasNext() == false) goto L43;
        Object r115 = r114.next();
        long r116 = ((Number) r115).longValue();
        if (r116 != r111.getPrimaryEffectId()) goto L38;
    L40:
        boolean r117 = false;
    L41:
        if (r117 == false) goto L34;
        r113.add(r115);
        goto L34
    L38:
        if (r116 <= 0) goto L40;
        r117 = true;
        goto L41
    L43:
        Iterator r118 = r113.iterator();
    L45:
        if (r118.hasNext() == false) goto L28;
        this.h.put(Long.valueOf(((Number) r118.next()).longValue()), Integer.valueOf(r30));
        r30 = r30 + 1;
        goto L45
    L47:
        Iterator<T> r5 = r7.iterator();
    L49:
        if (r5.hasNext() == false) goto L57;
        Iterator r31 = ((List) r5.next()).iterator();
    L52:
        if (r31.hasNext() == false) goto L49;
        h1 r33 = (h1) r31.next();
        if (r33.getPrimaryEffectId() <= 0) goto L52;
        this.h.put(Long.valueOf(r33.getPrimaryEffectId()), Integer.valueOf(r4));
        r4 = r4 + 1;
    L57:
        if (this.h.isEmpty() == true) goto L60;
        CollectionsKt.sortWith(r21, new g(this));
    L60:
        x(r21, r24, r23);
        return;
    L15:
        r27 = null;
        goto L16
    }

    public final void x(List<com.bytedance.android.live.core.resources.e> r13, boolean r14, int r15) {
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r2 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.j) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.j.class);
        Iterator<T> r16 = r13.iterator();
    L4:
        if (r16.hasNext() == false) goto L37;
        com.bytedance.android.live.core.resources.e r3 = (com.bytedance.android.live.core.resources.e) r16.next();
        Long r4 = (Long) ((LinkedHashMap) this.e).get(Long.valueOf(r3.getId()));
        boolean r5 = false;
        if (r4 == null) goto L8;
        long r6 = r4.longValue();
    L10:
        if ((r1 - r6) <= 150000.0d) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L4;
        if (r3.getResourceType() != 5) goto L20;
        if (r14 == false) goto L4;
    L20:
        if (r3.getDownloadType() != 2) goto L22;
    L23:
        if (r14 == false) goto L27;
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L27;
    L34:
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L35;
        int r8 = com.bytedance.revenue.platform.api.core.rx.e.a;
        Completable r9 = Completable.complete();
        int r10 = p.a;
        r9.observeOn(Schedulers.single()).subscribe(new a(r3, this, r15, r2), b.a);
        this.e.put(Long.valueOf(r3.getId()), Long.valueOf(r1));
        goto L4
    L35:
        boolean r11 = r2.ib(r3, null, r15, AssetDownloadPriority.NORMAL);
        this.e.put(Long.valueOf(r3.getId()), Long.valueOf(r1));
        h(r3, r11);
    L27:
        if (r15 != 1007) goto L29;
    L31:
        if (r5 == false) goto L34;
    L29:
        if (r15 == 4) goto L31;
        r5 = true;
        goto L31
    L22:
        if (r3.getDownloadType() != 3) goto L34;
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = 0;
        goto L10
    }
}
