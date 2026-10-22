package com.bytedance.android.livesdk.gift.platform.core.interceptor;

import android.util.LongSparseArray;
import android.util.Pair;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.config.xn;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.common.utility.Lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tlc.d;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssetsInterceptorNew implements vlc.b, o {
    public a a;
    public final LongSparseArray<List<yh6.c>> b;
    public final List<Long> c;
    public final Lazy d;
    public final Lazy e;
    public final c f;
    public final l g;
    public final k h;
    public final AssetsService i;
    public final com.bytedance.android.livesdk.revenue.service.user.a j;
    public final j k;

    public final class a {
        public final List<Pair<List<Long>, yh6.c>> a;

        public a() {
            this.a = new ArrayList();
        }
    }

    public static final class b {
    }

    public static final class c implements IAssetsManager.b {
        public final /* synthetic */ AssetsInterceptorNew a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public c(AssetsInterceptorNew r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends e> r18) {
            Intrinsics.checkNotNullParameter(r18, "assetsModels");
            Iterator r0 = ((ArrayList) this.a.c).iterator();
        L4:
            if (r0.hasNext() == false) goto L21;
            long r8 = ((Number) r0.next()).longValue();
            if (this.a.i.G1(r8) == null) goto L16;
            List<yh6.c> r2 = this.a.b.get(r8);
            if (r2 != null) goto L11;
            r2 = CollectionsKt.emptyList();
        L11:
            if (Lists.isEmpty(r2) == true) goto L17;
            Iterator<yh6.c> r3 = r2.iterator();
        L14:
            if (r3.hasNext() == false) goto L17;
            this.a.g.insert(r3.next(), true);
        L17:
            List<yh6.c> r4 = this.a.b.get(r8);
            if (r4 == null) goto L20;
            r4.clear();
        L20:
            r0.remove();
            goto L4
        L16:
            jy0.b.c("AssetsInterceptor", "拉不到该特效资源  assetId = " + r8, null, 4);
            boolean r5 = d0.a;
            boolean r6 = this.a.d();
            String r11 = z.a("ttlive_gift_find_more_error");
            JSONObject r14 = new JSONObject();
            JSONObject r15 = new JSONObject();
            JSONObject r7 = new JSONObject();
            Intrinsics.checkNotNullParameter(r7, "extra");
            Intrinsics.checkNotNullParameter(r15, "metric");
            EventModule r9 = EventModule.LIVE_GIFT;
            Intrinsics.checkNotNullParameter(r9, "eventModule");
            String r13 = r9.getValue();
            Intrinsics.checkNotNullParameter(r14, "map");
            Boolean r10 = Boolean.valueOf(r6);
            Intrinsics.checkNotNullParameter("is_anchor", "key");
            Intrinsics.checkNotNullParameter(r10, "value");
            r14.put("is_anchor", r10);
            Intrinsics.checkNotNullParameter(r15, "map");
            Long r16 = Long.valueOf(r8);
            Intrinsics.checkNotNullParameter("asset_id", "key");
            Intrinsics.checkNotNullParameter(r16, "value");
            r15.put("asset_id", r16);
            cy0.e.a.getClass();
            cy0.j r17 = cy0.e.a.a;
            m.e.getClass();
            Object r19 = m.b(r17).b(n97.a.class);
            Intrinsics.checkNotNull(r19);
            ((com.bytedance.live.kmp.core.c) r19).g(r11, r13, "bussiness_api_call", r14, r15, r7);
            goto L17
        L21:
            a r1 = this.a.a;
            if (r1 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("mAssetChecker");
        L24:
            AssetsInterceptorNew r20 = this.a;
            AssetsService r21 = r20.i;
            l r23 = r20.g;
            r1.getClass();
            Iterator r24 = ((ArrayList) r1.a).iterator();     // Catch: Error -> L49
            HashSet r25 = new HashSet();     // Catch: Error -> L49
        L26:
            if (r24.hasNext() == false) goto L75;
            Pair r110 = (Pair) r24.next();     // Catch: Error -> L49
            Object r111 = r110.first;     // Catch: Error -> L49
            if (r111 == null) goto L47;
            if (r110.second == null) goto L47;
            Iterator r112 = ((List) r111).iterator();     // Catch: Error -> L49
        L34:
            if (r112.hasNext() == false) goto L43;
            long r113 = ((Number) r112.next()).longValue();     // Catch: Error -> L49
            if (r25.contains(Long.valueOf(r113)) == true) goto L34;
            if (r21 == null) goto L39;
            e r114 = r21.G1(r113);     // Catch: Error -> L49
        L40:
            if (r114 == null) goto L42;
            r25.add(Long.valueOf(r113));     // Catch: Error -> L49
            goto L34
        L42:
            jy0.b.c("AssetsInterceptor", "拉不到该特效资源  assetId = " + r113, null, 4);     // Catch: Error -> L49
            boolean r115 = false;
        L44:
            if (r115 == false) goto L26;
            if (r23 == null) goto L26;
            r23.insert((yh6.c) r110.second, true);     // Catch: Error -> L49
            r24.remove();     // Catch: Error -> L49
            goto L26
        L39:
            r114 = null;
            goto L40
        L43:
            r115 = true;
        L47:
            r24.remove();     // Catch: Error -> L49
            goto L26
        L75:
            return;
        L49:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }

    public final boolean d() {
        return this.h.isAnchor();
    }

    public final void onStart() {
        if ((this.k instanceof ur.a) == false) goto L5;
    L6:
        this.g.h(this);
    L7:
        this.a = new a();
        this.i.T(this.f);
        return;
    L5:
        if (h.i() == true) goto L7;
        goto L6
    }

    public final void onStop() {
        this.i.l0(this.f);
        this.b.clear();
        ((ArrayList) this.c).clear();
    }

    public final boolean c(long r11) {
        if (h.e() == false) goto L10;
        AssetsService r0 = this.i;
        if (r0 == null) goto L7;
        e r1 = r0.G1(r11);
    L8:
        if (r1 != null) goto L10;
        return true;
    L7:
        r1 = null;
    L10:
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L22;
        com.bytedance.android.livesdk.gift.platform.core.a r3 = (com.bytedance.android.livesdk.gift.platform.core.a) ((Map) r2.getAssetFetchSaver().getValue()).get(Long.valueOf(r11));
        if (r3 == null) goto L21;
        int r4 = r3.a;
        ReadOnlyProperty r5 = h.r;
        KProperty[] r6 = h.a;
        if (r4 < ((Number) r5.getValue(null, r6[16])).intValue()) goto L18;
        return false;
    L18:
        if ((System.currentTimeMillis() - r3.b) >= (((Number) h.s.getValue(null, r6[17])).intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) goto L20;
        return false;
    L20:
        ((Map) r2.getAssetFetchSaver().getValue()).put(Long.valueOf(r11), new com.bytedance.android.livesdk.gift.platform.core.a(r3.a + 1, System.currentTimeMillis()));
        goto L22
    L21:
        ((Map) r2.getAssetFetchSaver().getValue()).put(Long.valueOf(r11), new com.bytedance.android.livesdk.gift.platform.core.a(1, System.currentTimeMillis()));
    L22:
        return true;
    }

    public final boolean f(k6 r13) {
        Intrinsics.checkNotNullParameter(r13, "assetMessage");
        r13.setTimeStampMap(1, com.bytedance.live.kmp.util.e.b());
        List r0 = r13.getRequiredAssets();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        boolean r2 = false;
    L62:
        if (r2 == false) goto L65;
        return true;
    L65:
        if (this.i.G1(r13.getAssetId()) == null) goto L67;
        return false;
    L67:
        a(r13, r13.getAssetId());
        ((ArrayList) this.c).add(Long.valueOf(r13.getAssetId()));
        if (h.b() == true) goto L70;
        this.i.L0(4, d(), "AssetsInterceptorNew4");
        return true;
    L70:
        if (c(r13.getAssetId()) == false) goto L81;
        this.i.d4(4, d(), r13.getAssetId(), "AssetsInterceptorNew3");
        return true;
    L81:
        return true;
    L13:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.a() == false) goto L61;
        IBaseUser r3 = this.j.b();
        ArrayList r4 = null;
        if (r3 == null) goto L18;
        String r5 = r3.getIdString();
    L19:
        IBaseUser r6 = r13.getToUser();
        if (r6 == null) goto L22;
        String r7 = r6.getIdString();
    L24:
        if (Intrinsics.areEqual(r5, r7) == true) goto L33;
        IBaseUser r8 = r13.getFromUser();
        if (r8 == null) goto L28;
        String r9 = r8.getIdString();
    L30:
        if (Intrinsics.areEqual(r5, r9) == true) goto L33;
        boolean r10 = false;
    L34:
        if (r10 == false) goto L36;
        int r11 = 12;
    L37:
        List r14 = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(r13.getAssetId())});
        List r15 = r13.getRequiredAssets();
        if (r15 == null) goto L44;
        List r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L41:
        if (r18.hasNext() == false) goto L43;
        r17.add(Long.valueOf(((Number) r18.next()).intValue()));
        goto L41
    L43:
        r14.addAll(r17);
    L44:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r14.iterator();
    L46:
        if (r20.hasNext() == false) goto L53;
        Object r21 = r20.next();
        if (this.i.G1(((Number) r21).longValue()) != null) goto L50;
        boolean r23 = true;
    L51:
        if (r23 == false) goto L46;
        r19.add(r21);
        goto L46
    L50:
        r23 = false;
        goto L51
    L53:
        a r24 = this.a;
        if (r24 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetChecker");
    L56:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r13, "giftMessage");
        Intrinsics.checkNotNullParameter(r19, "currentNeedAssetIds");
        ((ArrayList) r24.a).add(new Pair(r19, r13));
        if ((!r19.isEmpty()) == false) goto L59;
        r4 = r19;
    L59:
        if (r4 == null) goto L61;
        this.i.ji(r11, d(), r4, "AssetsInterceptorNew3");
        goto L61
    L36:
        r11 = 4;
        goto L37
    L28:
        r9 = null;
    L33:
        r10 = true;
        goto L34
    L22:
        r7 = null;
        goto L24
    L18:
        r5 = null;
    L61:
        r2 = true;
        goto L62
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final boolean onMessage(d r19) {
        IBaseUser r2 = this.j.b();
        if (r2 == null) goto L5;
        String r3 = r2.getIdString();
    L7:
        if (r3 == null) goto L11;
        Long r6 = StringsKt.toLongOrNull(r3);
        if (r6 == null) goto L11;
        long r7 = r6.longValue();
    L13:
        if (r7 > 0) goto L15;
    L29:
        int r8 = 4;
        if ((r19 instanceof o7) == false) goto L137;
        o7 r4 = (o7) r19;
        h2 r9 = u.f(r4);
        if (r9 != null) goto L36;
        this.g.insert((yh6.c) r19, false);
        return true;
    L36:
        if (r9.getType() == 2) goto L62;
        if (r9.getType() == 8) goto L62;
        if (r9.getType() == 4) goto L43;
    L54:
        boolean r10 = false;
    L55:
        if (r10 == true) goto L62;
        if (r9.getType() == 13) goto L62;
        if (r9.getType() == 15) goto L62;
        return false;
    L43:
        if (d() == false) goto L46;
    L53:
        r10 = true;
        goto L55
    L46:
        if (((Boolean) xn.a.getValue()).booleanValue() == true) goto L54;
        String r11 = f.a(l01.d.class).getCurrentUserId();
        IBaseUser r13 = r4.getToUser();
        if (r13 == null) goto L54;
        String r14 = r13.getIdString();
        if (r14 == null) goto L54;
        if (r14.equals(r11) != true) goto L54;
    L62:
        if (r9.getId() != 998) goto L65;
        return false;
    L65:
        if (13 != r9.getType()) goto L124;
        if (r4 == null) goto L120;
        ArrayList r1 = new ArrayList();
        if (ArraysKt.contains((long[]) com.bytedance.android.livesdk.gift.platform.business.effect.a.O.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[39]), r9.getId()) == true) goto L79;
        List r5 = l0.c(r9);
        if (r5 != null) goto L72;
    L78:
        r1.addAll(r9.getAssetIds());
    L81:
        if (r9.getPrimaryEffectId() > 0) goto L83;
    L85:
        Iterator r15 = r1.iterator();
    L87:
        if (r15.hasNext() == false) goto L92;
        if (this.i.G1(((Number) r15.next()).longValue()) == null) goto L87;
        r15.remove();
        goto L87
    L92:
        if (r1.size() == 0) goto L94;
        a r16 = this.a;
        if (r16 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetChecker");
    L99:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r4, "giftMessage");
        Intrinsics.checkNotNullParameter(r1, "currentNeedAssetIds");
        ((ArrayList) r16.a).add(new Pair(r1, r4));
        Iterator r17 = r1.iterator();
        boolean r18 = false;
    L101:
        if (r17.hasNext() == false) goto L105;
        long r110 = ((Number) r17.next()).longValue();
        c0.a.a(r4.getGiftId(), r110);
        if (c(r110) == false) goto L101;
        r18 = true;
        goto L101
    L105:
        if (r18 == false) goto L117;
        if (v.a() == false) goto L110;
        jy0.b.a("AssetsInterceptor", "needAssetIds " + r4.getGiftId() + " " + r1);
    L110:
        if (h.e() == true) goto L112;
        this.i.ji(4, d(), r1, "AssetsInterceptorNew8");
    L119:
        boolean r20 = true;
    L121:
        if (r20 == false) goto L159;
        return true;
    L159:
        return false;
    L112:
        if (r4.isLocal() == false) goto L114;
        r8 = 12;
    L114:
        this.i.ji(r8, d(), r1, "AssetsInterceptorNew7");
        goto L119
    L117:
        if (v.a() == false) goto L119;
        jy0.b.a("AssetsInterceptor", "no needFetchAsset " + r4.getGiftId());
        goto L119
    L94:
        if (v.a() == false) goto L120;
        jy0.b.a("AssetsInterceptor", "no needFetchAsset " + r4.getGiftId());
        goto L120
    L83:
        if (r1.contains(Long.valueOf(r9.getPrimaryEffectId())) == true) goto L85;
        r1.add(Long.valueOf(r9.getPrimaryEffectId()));
        goto L85
    L72:
        if ((!r5.isEmpty()) != true) goto L78;
        List r21 = l0.c(r9);
        if (r21 == null) goto L76;
        List r23 = r21;
    L77:
        r1.addAll(r23);
        goto L81
    L76:
        r23 = new ArrayList();
        goto L77
    L79:
        r1.addAll(r9.getAssetIds());
    L120:
        r20 = false;
        goto L121
    L124:
        if (this.i.G1(r9.getPrimaryEffectId()) != null) goto L135;
        c0.a.a(r4.getGiftId(), r9.getPrimaryEffectId());
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L129;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.u(r9.getPrimaryEffectId(), -3, "-3", -3, -3, -3);
    L129:
        a((yh6.c) r19, r9.getPrimaryEffectId());
        ((ArrayList) this.c).add(Long.valueOf(r9.getPrimaryEffectId()));
        if (h.b() == true) goto L132;
        this.i.L0(4, d(), "AssetsInterceptorNew2");
        goto L135
    L132:
        if (c(r9.getPrimaryEffectId()) == false) goto L135;
        this.i.d4(4, d(), r9.getPrimaryEffectId(), "AssetsInterceptorNew1");
    L135:
        return false;
    L137:
        if ((r19 instanceof k6) == false) goto L141;
        return f((k6) r19);
    L141:
        if ((r19 instanceof o6) == false) goto L159;
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L159;
        o6 r24 = (o6) r19;
        Intrinsics.checkNotNullParameter(r24, "bindingMessage");
        h2 r25 = u.f(r24.getGiftMessage());
        if (r25 == null) goto L157;
        long r111 = r25.getPrimaryEffectId();
        if (this.i.G1(r111) != null) goto L157;
        if (r111 <= 0) goto L157;
        a(r24, r111);
        ((ArrayList) this.c).add(Long.valueOf(r111));
        if (h.b() == true) goto L154;
        this.i.L0(4, d(), "AssetsInterceptorNew6");
        return true;
    L154:
        if (c(r111) == false) goto L170;
        this.i.d4(4, d(), r111, "AssetsInterceptorNew5");
        return true;
    L170:
        return true;
    L157:
        return false;
    L15:
        if ((r19 instanceof o7) == false) goto L29;
        o7 r26 = (o7) r19;
        if (r26.isLocal() == true) goto L29;
        IBaseUser r27 = r26.getFromUser();
        if (r27 == null) goto L21;
        String r28 = r27.getIdString();
    L23:
        if (Intrinsics.areEqual(r3, r28) == false) goto L29;
        if (r26.getDisplayForSelf() == true) goto L29;
        if (r26.getRepeatEnd() == 1) goto L29;
        return true;
    L21:
        r28 = null;
    L11:
        r7 = 0;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    public final void a(yh6.c r3, long r4) {
        List<yh6.c> r0 = this.b.get(r4);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.b.put(r4, r0);
    L5:
        r0.add(r3);
    }

    public AssetsInterceptorNew(l r2, k r3, AssetsService r4, com.bytedance.android.livesdk.revenue.service.user.a r5, j r6) {
        Intrinsics.checkNotNullParameter(r2, "messageService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "assetsService");
        Intrinsics.checkNotNullParameter(r5, "userService");
        Intrinsics.checkNotNullParameter(r6, "scope");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.b = new LongSparseArray();
        this.c = new ArrayList();
        this.d = LazyKt.lazy(AssetsInterceptorNew$bindingMsgCheckAssetEnable$2.INSTANCE);
        this.e = LazyKt.lazy(AssetsInterceptorNew$assetFindFailReport$2.INSTANCE);
        this.f = new c(this);
    }
}
