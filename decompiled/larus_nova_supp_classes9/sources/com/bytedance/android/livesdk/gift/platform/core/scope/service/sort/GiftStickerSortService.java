package com.bytedance.android.livesdk.gift.platform.core.scope.service.sort;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.configmodel.p2;
import com.bytedance.android.livesdk.gift.model.a2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.i;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.kmp.util.e;
import cy0.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.m;
import mz0.n;
import vh6.c;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftStickerSortService implements o {
    public final CompositeDisposable a;
    public final p2 b;
    public final List<Long> c;
    public String d;
    public final Lazy e;
    public final f1 f;
    public final i g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftStickerSortService a;

        public a(GiftStickerSortService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            GiftStickerSortService r0 = this.a;
            r0.c((String) r2);
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
        Disposable r0 = ((gz0.a) this.e.getValue()).P4().observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
        this.a.add(r0);
    }

    public final void onStop() {
        this.a.clear();
    }

    public final void c(String r18) {
        if (this.b.a() == true) goto L7;
        this.d = r18;
        return;
    L7:
        if (r18.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        a(r18, new LinkedHashMap());
        return;
    L12:
        Map<String, Long> r3 = this.g.n3();
        LinkedHashSet r5 = new LinkedHashSet();
        LinkedHashSet r6 = new LinkedHashSet();
        Iterator<Map.Entry<String, Long>> r7 = r3.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L24;
        Map.Entry<String, Long> r8 = r7.next();
        String r11 = r8.getKey();
        long r13 = r8.getValue().longValue();
        if (r11.length() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L14;
        if (StringsKt.contains$default(r18, r11, false, 2, null) == false) goto L14;
        r5.add(Long.valueOf(r13));
        r6.add(r11);
        goto L14
    L18:
        r9 = false;
        goto L19
    L24:
        if (r5.isEmpty() == false) goto L36;
        Map<String, String> r10 = this.b.c();
        if (r10 == null) goto L36;
        Iterator<Map.Entry<String, String>> r14 = r10.entrySet().iterator();
        boolean r15 = false;
    L29:
        if (r14.hasNext() == false) goto L37;
        Map.Entry<String, String> r16 = r14.next();
        if (StringsKt.contains$default(r18, r16.getKey(), false, 2, null) == false) goto L29;
        Long r17 = r3.get(r16.getValue());
        if (r17 == null) goto L35;
        r5.add(Long.valueOf(r17.longValue()));
        r6.add(r16.getValue());
    L35:
        r15 = true;
    L37:
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("sticker_content", r18);
        if ((!r5.isEmpty()) == false) goto L43;
        a2 r110 = (a2) f.c(a2.class);
        String r111 = this.b.e();
        if (r111 != null) goto L42;
        r111 = BuildConfig.FLAVOR;
    L42:
        r110.setScene(r111);
        r110.setGiftIds(CollectionsKt.toList(r5));
        long r112 = e.b();
        LinkedHashSet r113 = r5;
        long r4 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        r110.setStartTime(r112 / r4);
        r110.setEndTime((e.b() / r4) + this.b.d());
        r110.setExtra(BuildConfig.FLAVOR);
        r110.setEventTrack(r19);
        this.f.g(CollectionsKt.arrayListOf(new a2[]{r110}));
    L46:
        ((ArrayList) this.c).clear();
        LinkedHashSet r20 = r113;
        ((ArrayList) this.c).addAll(r20);
        if ((!Intrinsics.areEqual(this.d, r18)) == false) goto L61;
        String r21 = h.a;
        boolean r23 = !r20.isEmpty();
        int r24 = r3.size();
        Intrinsics.checkNotNullParameter(r20, "giftId");
        Intrinsics.checkNotNullParameter(r18, "content");
        Intrinsics.checkNotNullParameter(r6, "giftName");
        Pair[] r25 = new Pair[7];
        r25[0] = TuplesKt.to("match_gift_id", TextUtils.join("_", r20));
        String r26 = "1";
        if (r23 == false) goto L51;
        Object r27 = "1";
    L52:
        r25[1] = TuplesKt.to("is_match", r27);
        r25[2] = TuplesKt.to("match_gift_name", TextUtils.join("_", r6));
        r25[3] = TuplesKt.to("sticker_content", r18);
        if (g02.a.e() == false) goto L55;
        Object r28 = "1";
    L56:
        r25[4] = TuplesKt.to("is_anchor", r28);
        if (r15 == true) goto L60;
        r26 = "0";
    L60:
        r25[5] = TuplesKt.to("is_fuzzy_match", r26);
        r25[6] = TuplesKt.to("gift_size", String.valueOf(r24));
        LinkedHashMap r29 = new LinkedHashMap();
        MapsKt.putAll(r29, r25);
        n r30 = new n();
        Map r31 = r30.a;
        Intrinsics.checkNotNullParameter(r31, "map");
        Intrinsics.checkNotNullParameter(r29, "map");
        r31.putAll(r29);
        m r33 = new m();
        com.bytedance.android.livesdk.revenue.log.i r34 = c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r34, "pageSourceLog");
        ((ArrayList) r33.a).add(r34.a);
        r33.b(LogCommon.ROOM);
        ((ArrayList) r30.b).addAll(r33.a);
        cy0.e.a.getClass();
        j r35 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r36 = com.bytedance.android.scope.m.b(r35).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r36);
        ((f80.a) r36).w3("live_sticker_match_gift", r30.a, r30.b);
        goto L61
    L55:
        r28 = "0";
        goto L56
    L51:
        r27 = "0";
    L61:
        this.d = r18;
        return;
    L43:
        r113 = r5;
        if ((!((ArrayList) this.c).isEmpty()) == false) goto L46;
        a(r18, r19);
    L36:
        r15 = false;
        goto L37
    L9:
        r2 = false;
        goto L10
    }

    public final void a(String r8, Map<String, String> r9) {
        this.d = r8;
        ArrayList r10 = new ArrayList();
        r10.addAll(this.c);
        a2 r0 = (a2) f.c(a2.class);
        String r1 = this.b.e();
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r0.setScene(r1);
        r0.setGiftIds(r10);
        long r3 = e.b();
        long r5 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        r0.setStartTime(r3 / r5);
        r0.setEndTime((e.b() / r5) + this.b.b());
        r0.setExtra(BuildConfig.FLAVOR);
        r0.setEventTrack(r9);
        ((ArrayList) this.c).clear();
        this.f.g(CollectionsKt.arrayListOf(new a2[]{r0}));
    }

    public GiftStickerSortService(f1 r2, i r3, e1 r4) {
        Intrinsics.checkNotNullParameter(r2, "giftListSortService");
        Intrinsics.checkNotNullParameter(r3, "giftListRepository");
        Intrinsics.checkNotNullParameter(r4, "giftListService");
        this.f = r2;
        this.g = r3;
        this.a = new CompositeDisposable();
        this.b = (p2) com.bytedance.android.livesdk.gift.platform.core.h.w0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[73]);
        this.c = new ArrayList();
        this.d = BuildConfig.FLAVOR;
        this.e = LazyKt.lazy(GiftStickerSortService$giftStickerInternalService$2.INSTANCE);
    }
}
