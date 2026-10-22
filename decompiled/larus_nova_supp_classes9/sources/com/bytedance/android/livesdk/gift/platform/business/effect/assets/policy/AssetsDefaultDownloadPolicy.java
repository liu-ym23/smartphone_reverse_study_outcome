package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.p;
import i12.o;
import io.reactivex.Completable;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssetsDefaultDownloadPolicy implements e {
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public final Map<Long, Long> a;
    public final Map<Long, Integer> b;
    public boolean c;
    public final MutableLiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> d;
    public final Lazy e;
    public final List<String> f;
    public final ConcurrentHashMap<String, Long> g;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j h;

    public static final class a {
        public a() {
        }
    }

    public final boolean c() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void f(List r1, boolean r2) {
    }

    static {
        new a();
        i = LazyKt.lazy(AssetsDefaultDownloadPolicy$Companion$liveAssetsMangerReadSettingOptimize$2.INSTANCE);
        j = LazyKt.lazy(AssetsDefaultDownloadPolicy$Companion$liveAssetsUseMainThread$2.INSTANCE);
        k = LazyKt.lazy(AssetsDefaultDownloadPolicy$Companion$liveDownloadDynamic$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0() {
        return this.d;
    }

    public AssetsDefaultDownloadPolicy(com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r2) {
        Intrinsics.checkNotNullParameter(r2, "assetsManager");
        this.h = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.d = new MutableLiveData();
        this.e = LazyKt.lazy(new AssetsDefaultDownloadPolicy$mShowLog$2(this));
        this.f = new ArrayList();
        this.g = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void a(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, Long>> r0 = this.g.entrySet().iterator();
    L16:
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (r0.hasNext() == false) goto L24;
        Map.Entry<String, Long> r1 = r0.next();     // Catch: Exception -> L13
        if (r5.length() >= 500) goto L25;
        if (r1.getValue() == null) goto L16;
        r5.put(r1.getKey(), r1.getValue());     // Catch: Exception -> L13
        r0.remove();     // Catch: Exception -> L13
        goto L16
    L25:
        return;
    }

    public static void d(String r5, List r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.append(String.valueOf(((com.bytedance.android.live.core.resources.e) r7.next()).getId()) + ",");
        goto L4
    L6:
        jy0.b.a("AssetsDefaultDownloadPolicy", r5 + r0.toString());
    }

    public final void b(com.bytedance.android.live.core.resources.e r5, boolean r6) {
        if (r6 == false) goto L5;
        this.g.put(String.valueOf(r5.getId()), Long.valueOf(r5.getModifyVersion()));
    L5:
        if (c() == false) goto L8;
        Object r0 = this.d.getValue();
        Intrinsics.checkNotNull(r0);
        ((List) r0).add(new Pair(r5, Boolean.valueOf(r6)));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void g(List<com.bytedance.android.live.core.resources.e> r28, int r29, boolean r30) {
        if (r28 != null) goto L5;
        return;
    L5:
        int r11 = 1;
        int r13 = 0;
        if (this.c == false) goto L86;
        ((LinkedHashMap) this.b).clear();
        if (c() == false) goto L10;
        ((ArrayList) this.f).clear();
    L10:
        i12.e r0 = o.b();
        if (r0 == null) goto L13;
        m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) m.b(r0).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.effect.assets.h.class));
    L14:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.h r2 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.h) r1;
        if (r2 == null) goto L17;
        List<List<h1>> r3 = r2.X2();
    L19:
        if (com.bytedance.android.livesdk.gift.platform.business.i.o().I0() == false) goto L54;
        if (this.c == false) goto L52;
        if (r3 == null) goto L52;
        Iterator<List<h1>> r4 = r3.iterator();
        int r5 = 0;
    L26:
        if (r4.hasNext() == false) goto L50;
        List<h1> r6 = r4.next();
        if (r6 == null) goto L26;
        Iterator<h1> r7 = r6.iterator();
    L31:
        if (r7.hasNext() == false) goto L26;
        h1 r8 = r7.next();
        if (r8 == null) goto L31;
        int r14 = r5 + 1;
        this.b.put(Long.valueOf(r8.getPrimaryEffectId()), Integer.valueOf(r5));
        if (r8.getAssetIds() != null) goto L37;
    L48:
        r5 = r14;
        goto L31
    L37:
        if (r8.getAssetIds().size() <= 1) goto L48;
        Iterator<T> r9 = r8.getAssetIds().iterator();
        int r10 = 0;
    L40:
        if (r9.hasNext() == false) goto L48;
        Object r15 = r9.next();
        int r16 = r10 + 1;
        if (r10 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        long r17 = ((Number) r15).longValue();
        if (r17 == r8.getPrimaryEffectId()) goto L47;
        this.b.put(Long.valueOf(r17), Integer.valueOf(r10 + r14));
    L47:
        r10 = r16;
        goto L40
    L50:
        if (c() == false) goto L73;
        jy0.b.a("AssetsDefaultDownloadPolicy", "observeState update SortIndex " + this.b);
    L73:
        if (this.b.size() != 0) goto L76;
        jy0.b.a("AssetsDefaultDownloadPolicy", "[sortIfNeed]-mSortIndexMap size is 0,no need sort");
        goto L86
    L76:
        if (c() == false) goto L214;
        d("before sort:", r28);
    L214:
        ArrayList r18 = new ArrayList(r28);     // Catch: Exception -> L80
        CollectionsKt.sortWith(r18, new com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.a(this));     // Catch: Exception -> L80
        r28.clear();     // Catch: Exception -> L80
        r28.addAll(r18);     // Catch: Exception -> L80
    L83:
        if (c() == false) goto L86;
        d("after sort:", r28);
        jy0.b.a("AssetsDefaultDownloadPolicy", "sort target:" + this.f);
    L80:
        e = move-exception;
        e.printStackTrace();
    L52:
        jy0.b.a("AssetsDefaultDownloadPolicy", "setSortIndexOnlyPrimaryEffectId : needSort " + this.c + "panelListList " + r3);
        goto L73
    L54:
        if (this.c == false) goto L71;
        if (r3 == null) goto L71;
        Iterator<List<h1>> r19 = r3.iterator();
        int r20 = 0;
    L59:
        if (r19.hasNext() == false) goto L69;
        List<h1> r21 = r19.next();
        if (r21 == null) goto L59;
        Iterator<h1> r23 = r21.iterator();
    L64:
        if (r23.hasNext() == false) goto L59;
        h1 r24 = r23.next();
        if (r24 == null) goto L64;
        Map<Long, Integer> r25 = this.b;
        Long r26 = Long.valueOf(r24.getPrimaryEffectId());
        Integer r27 = Integer.valueOf(r20);
        r20 = r20 + 1;
        r25.put(r26, r27);
        goto L64
    L69:
        if (c() == false) goto L73;
        jy0.b.a("AssetsDefaultDownloadPolicy", "observeState update SortIndex " + this.b);
    L71:
        jy0.b.a("AssetsDefaultDownloadPolicy", "setSortIndexOnlyPrimaryEffectId : needSort " + this.c + "panelListList " + r3);
        goto L73
    L17:
        r3 = null;
        goto L19
    L13:
        r1 = null;
    L86:
        if (c() == false) goto L88;
        Object r31 = this.d.getValue();
        Intrinsics.checkNotNull(r31);
        ((List) r31).clear();
    L88:
        int r110 = 2;
        int r111 = 3;
        if (com.bytedance.android.livesdk.gift.platform.business.i.o().X1() == true) goto L123;
        i97.a r33 = i97.a.a;
        long r112 = System.currentTimeMillis();
        Iterator<com.bytedance.android.live.core.resources.e> r34 = r28.iterator();
    L92:
        if (r34.hasNext() == false) goto L123;
        com.bytedance.android.live.core.resources.e r35 = r34.next();
        Long r36 = (Long) ((LinkedHashMap) this.a).get(Long.valueOf(r35.getId()));
        if (r36 == null) goto L96;
        long r37 = r36.longValue();
    L98:
        if ((r112 - r37) <= 150000.0d) goto L100;
        boolean r38 = true;
    L102:
        if (r35.getResourceType() == r11) goto L110;
        if (r35.getResourceType() == 6) goto L110;
        if (r35.getResourceType() == 7) goto L110;
        if (r35.getResourceType() != 2) goto L92;
    L110:
        if (r38 == false) goto L92;
        if (((Boolean) k.getValue()).booleanValue() == false) goto L120;
        if (r35.getDownloadType() == 2) goto L92;
        if (r35.getDownloadType() == r111) goto L92;
    L120:
        if (((Boolean) j.getValue()).booleanValue() == true) goto L121;
        int r39 = com.bytedance.revenue.platform.api.core.rx.e.a;
        Completable r40 = Completable.complete();
        int r41 = p.a;
        r40.observeOn(Schedulers.single()).subscribe(new c(this, r35, r29, r112));
        r11 = 1;
        r111 = 3;
        goto L92
    L121:
        boolean r43 = this.h.Re(r35, r29);
        this.a.put(Long.valueOf(r35.getId()), Long.valueOf(r112));
        b(r35, r43);
        goto L92
    L100:
        r38 = false;
        goto L102
    L96:
        r37 = 0;
    L123:
        int r44 = 4;
        int r113 = IAssetsManager.DownloadAssetsSource.SOURCE_JSB_PLAY;
        int r114 = 5;
        String r45 = "$this$getLokiExtraModel";
        if (r30 == false) goto L166;
        i97.a r46 = i97.a.a;
        long r115 = System.currentTimeMillis();
        Iterator<com.bytedance.android.live.core.resources.e> r210 = r28.iterator();
    L127:
        if (r210.hasNext() == false) goto L166;
        com.bytedance.android.live.core.resources.e r47 = r210.next();
        Long r48 = (Long) ((LinkedHashMap) this.a).get(Long.valueOf(r47.getId()));
        if (r48 == null) goto L131;
        long r49 = r48.longValue();
    L133:
        if ((r115 - r49) <= 150000.0d) goto L135;
        boolean r50 = true;
    L136:
        if (r50 == false) goto L127;
        if (r47.getResourceType() != r114) goto L127;
        if (((Boolean) k.getValue()).booleanValue() == false) goto L154;
        if (r47.getDownloadType() != 2) goto L146;
    L147:
        if (r29 == r113) goto L150;
        if (r29 == r44) goto L150;
        boolean r51 = true;
    L151:
        if (r51 == false) goto L154;
    L150:
        r51 = false;
        goto L151
    L146:
        if (r47.getDownloadType() == 3) goto L147;
    L154:
        if (((Boolean) j.getValue()).booleanValue() == false) goto L156;
        boolean r53 = this.h.ib(r47, null, r29, AssetDownloadPriority.NORMAL);
        this.a.put(Long.valueOf(r47.getId()), Long.valueOf(r115));
        b(r47, r53);
    L158:
        if (r47.getModelRequirements() == null) goto L162;
        List r54 = r47.getModelRequirements();
        Intrinsics.checkNotNull(r54);
        if (r54.isEmpty() == true) goto L162;
        cy0.e.a.getClass();
        cy0.j r55 = cy0.e.a.a;
        m.e.getClass();
        Object r56 = m.b(r55).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r56);
        List r57 = r47.getModelRequirements();
        Intrinsics.checkNotNull(r57);
        ((com.bytedance.live.kmp.core.c) r56).downloadRequirements(r57);
    L162:
        Intrinsics.checkNotNullParameter(r47, r45);
        com.bytedance.android.live.core.resources.h r58 = r47.getLokiExtraModel();
        if (r58 == null) goto L165;
        cy0.e.a.getClass();
        cy0.j r59 = cy0.e.a.a;
        m.e.getClass();
        Object r60 = m.b(r59).b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        Intrinsics.checkNotNull(r60);
        ((com.bytedance.live.kmp.core.c) r60).Bj(r58.o8(), com.bytedance.android.live.core.resources.i.a(r58), null);
    L165:
        r45 = r45;
        r44 = 4;
        r113 = IAssetsManager.DownloadAssetsSource.SOURCE_JSB_PLAY;
        r114 = 5;
        goto L127
    L156:
        int r61 = com.bytedance.revenue.platform.api.core.rx.e.a;
        Completable r63 = Completable.complete();
        int r64 = p.a;
        r63.observeOn(Schedulers.single()).subscribe(new d(this, r47, r29, r115));
        goto L158
    L135:
        r50 = false;
        goto L136
    L131:
        r49 = 0;
    L166:
        String r116 = r45;
        i97.a r65 = i97.a.a;
        long r117 = System.currentTimeMillis();
        int r66 = r28.size();
        int r118 = 0;
    L167:
        if (r118 >= r66) goto L211;
        com.bytedance.android.live.core.resources.e r67 = (com.bytedance.android.live.core.resources.e) ListProtector.get(r28, r118);
        Long r68 = (Long) ((LinkedHashMap) this.a).get(Long.valueOf(r67.getId()));
        if (r68 == null) goto L171;
        long r69 = r68.longValue();
    L173:
        if ((r117 - r69) <= 150000.0d) goto L175;
        boolean r70 = true;
    L176:
        if (r70 == true) goto L179;
    L209:
        r118 = r118 + 1;
        r110 = 2;
        r13 = 0;
        goto L167
    L179:
        if (r67.getDownloadType() == r110) goto L185;
        if (r67.getDownloadType() == 3) goto L185;
    L200:
        if (r67.getResourceType() == 5) goto L209;
        Intrinsics.checkNotNullParameter(r67, r116);
        com.bytedance.android.live.core.resources.h r71 = r67.getLokiExtraModel();
        if (r71 == null) goto L206;
        cy0.e.a.getClass();
        cy0.j r73 = cy0.e.a.a;
        m.e.getClass();
        Object r74 = m.b(r73).b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        Intrinsics.checkNotNull(r74);
        ((com.bytedance.live.kmp.core.c) r74).Bj(r71.o8(), com.bytedance.android.live.core.resources.i.a(r71), null);
    L206:
        if (((Boolean) j.getValue()).booleanValue() == false) goto L208;
        boolean r75 = this.h.ib(r67, null, r29, AssetDownloadPriority.NORMAL);
        this.a.put(Long.valueOf(r67.getId()), Long.valueOf(r117));
        b(r67, r75);
        goto L209
    L208:
        int r76 = com.bytedance.revenue.platform.api.core.rx.e.a;
        Completable r77 = Completable.complete();
        int r78 = p.a;
        r77.observeOn(Schedulers.single()).subscribe(new b(this, r67, r29, r117));
    L185:
        if (((Boolean) k.getValue()).booleanValue() == true) goto L188;
        if (r30 == true) goto L200;
    L188:
        if (r29 == 1007) goto L191;
        if (r29 == 4) goto L191;
        boolean r79 = true;
    L192:
        if (r79 == false) goto L200;
        if (r29 != 3) goto L196;
    L197:
        jy0.b.a("AssetsDefaultDownloadPolicy", "打开礼物面板跳过下载，资源id：" + r67.getId() + "，type：" + r67.getDownloadType());
        goto L209
    L196:
        if (r29 != 1006) goto L209;
    L191:
        r79 = false;
        goto L192
    L175:
        r70 = false;
        goto L176
    L171:
        r69 = r13;
        goto L173
    L211:
        if (c() == false) goto L269;
        jy0.b.a("AssetsDefaultDownloadPolicy", "DownloadSort:" + ((List) this.d.getValue()));
        MutableLiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> r80 = this.d;
        r80.postValue(r80.getValue());
        return;
    }
}
