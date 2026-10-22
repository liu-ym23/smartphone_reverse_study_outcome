package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import androidx.collection.LongSparseArray;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.b;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.util.d;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends n {
    public static final int c = 0;
    public static final a d = null;
    public boolean a;
    public final j b;

    public static final class a {
        public a() {
        }
    }

    static {
        d = new a();
        c = e.b(2131168749);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.GIFT_ICON;
    }

    public c(j r2) {
        Intrinsics.checkNotNullParameter(r2, "preloadContext");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void b(h r14) {
        Intrinsics.checkNotNullParameter(r14, "trigger");
        this.a = true;
        Object r2 = null;
        LongSparseArray<Integer> r3 = null;
        if ((r14 instanceof h.f) == false) goto L70;
        List<w1> r15 = ((h.f) r14).a;
        boolean r1 = this.b.a();
        LinkedHashMap r4 = new LinkedHashMap();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r5 = f.a(mz0.c.class).W2(LogCommon.PAGE_SOURCE_LOG);
        if (r5 == null) goto L7;
        r5.h(r4);
    L7:
        String r6 = (String) r4.get("room_rank");
        if (r6 == null) goto L12;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L12;
        int r8 = r7.intValue();
    L13:
        if (r8 <= 1) goto L16;
        if (r1 == true) goto L16;
    L234:
        this.a = false;
        return;
    L16:
        int r9 = ((Number) b.p.getValue(null, b.a[14])).intValue();
        Iterator<T> r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L25;
        Object r10 = r16.next();
        if (((w1) r10).getPageType() != 1) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L18;
    L26:
        w1 r13 = (w1) r10;
        if (r13 == null) goto L234;
        List<h1> r17 = r13.getGifts();
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L31:
        if (r19.hasNext() == false) goto L35;
        Object r20 = r19.next();
        if (((h1) r20).isDisplayedOnPanel() == false) goto L31;
        r18.add(r20);
        goto L31
    L35:
        i12.e r110 = o.b();
        if (r110 == null) goto L38;
        Object r111 = m.e.d(r110, f1.class);
    L39:
        f1 r112 = (f1) r111;
        if (r112 == null) goto L42;
        LongSparseArray<Integer> r113 = r112.d;
    L43:
        if (r113 != null) goto L45;
    L47:
        boolean r21 = false;
    L48:
        if (r21 == false) goto L50;
        r3 = r113;
    L50:
        Iterator r114 = r18.iterator();
        int r23 = 0;
    L52:
        if (r114.hasNext() == false) goto L234;
        h1 r24 = (h1) r114.next();
        if (r23 < r9) goto L60;
        if (r3 == null) goto L59;
        if (r3.containsKey(r24.getId()) == true) goto L60;
    L59:
        if (r24.getId() == 463) goto L60;
    L67:
        r23 = r23 + 1;
    L60:
        ImageRequest r25 = d.a(r24.getImage(), c);
        if (r25 == null) goto L67;
        if (r1 == false) goto L66;
        Fresco.getImagePipeline().prefetchToBitmapCache(r25, "live_gift_panel_icon_prefetch");
        goto L67
    L66:
        Fresco.getImagePipeline().prefetchToDiskCache(r25, "live_gift_panel_icon_prefetch");
        goto L67
    L45:
        if (r113.isEmpty() == true) goto L47;
        r21 = true;
        goto L48
    L42:
        r113 = null;
        goto L43
    L38:
        r111 = null;
        goto L39
    L22:
        r11 = false;
        goto L23
    L25:
        r10 = null;
    L12:
        r8 = 0;
        goto L13
    L70:
        if ((r14 instanceof h.b) == false) goto L78;
        h.b r115 = (h.b) r14;
        k r0 = r115.c;
        if (r0 == null) goto L234;
        if (e(r0, "gift_panel_icon_click_prefetch") == true) goto L234;
        String r26 = h.a;
        h.y();
        r115.toString();
        goto L234
    L78:
        if ((r14 instanceof h.a) == false) goto L96;
        int r116 = ((h.a) r14).a;
        List<w1> r27 = this.b.d().c;
        ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r27.iterator();
    L81:
        if (r29.hasNext() == false) goto L86;
        Object r30 = r29.next();
        if (((w1) r30).getDisplay() == false) goto L81;
        r28.add(r30);
        goto L81
    L86:
        if (r116 >= r28.size()) goto L234;
        Iterator<T> r117 = ((w1) ListProtector.get(r28, r116)).getGifts().iterator();
        int r31 = 0;
    L90:
        if (r117.hasNext() == false) goto L234;
        h1 r33 = (h1) r117.next();
        if (r31 >= 12) goto L94;
        e(r33.getImage(), "change_gift_tab_prefetch");
    L94:
        r31 = r31 + 1;
        goto L90
    L96:
        if ((r14 instanceof h.C0045h) == false) goto L118;
        h.C0045h r118 = (h.C0045h) r14;
        int r34 = r118.b;
        IntRange r119 = r118.c;
        List<w1> r35 = this.b.d().c;
        ArrayList r36 = new ArrayList();
        Iterator<T> r37 = r35.iterator();
    L99:
        if (r37.hasNext() == false) goto L104;
        Object r38 = r37.next();
        if (((w1) r38).getDisplay() == false) goto L99;
        r36.add(r38);
        goto L99
    L104:
        if (r34 >= r36.size()) goto L234;
        if (r119.getLast() < 12) goto L234;
        List<h1> r39 = ((w1) ListProtector.get(r36, r34)).getGifts();
        if ((r119.getLast() + 12) < r39.size()) goto L111;
        r119.toString();
        goto L234
    L111:
        IntRange r40 = new IntRange(r119.getLast() + 1, r119.getLast() + 12);
        r40.toString();
        int r120 = r40.getFirst();
        int r41 = r40.getLast();
        if (r120 > r41) goto L234;
    L114:
        if (r120 >= r39.size()) goto L234;
        e(((h1) ListProtector.get(r39, r120)).getImage(), "scroll_gift_list_prefetch");
        if (r120 == r41) goto L234;
        r120 = r120 + 1;
        goto L114
    L118:
        List<w1> r121 = this.b.d().c;
        List<w1> r43 = r121;
        Iterator<T> r44 = r43.iterator();
    L120:
        if (r44.hasNext() == false) goto L124;
        Object r45 = r44.next();
        if (((w1) r45).getDisplay() == false) goto L120;
    L125:
        w1 r46 = (w1) r45;
        Iterator<T> r47 = r43.iterator();
    L127:
        if (r47.hasNext() == false) goto L134;
        Object r48 = r47.next();
        if (((w1) r48).getPageType() != 1) goto L131;
        boolean r49 = true;
    L132:
        if (r49 == false) goto L127;
    L135:
        w1 r50 = (w1) r48;
        if (r50 == null) goto L138;
        List<h1> r51 = r50.getGifts();
    L139:
        List<h1> r53 = r51;
        if (r53 != null) goto L142;
    L145:
        boolean r54 = true;
    L146:
        int r55 = -1;
        if (r54 == false) goto L153;
        String r56 = h.a;
        int r122 = r121.size();
        if (r51 == null) goto L151;
        int r57 = r51.size();
    L152:
        h.A(r122, r57, -1, "touch_down");
        goto L234
    L151:
        r57 = -1;
        goto L152
    L153:
        LinkedHashSet r123 = new LinkedHashSet();
        Iterator<T> r58 = r51.iterator();
        int r59 = 0;
        int r60 = 0;
    L155:
        if (r58.hasNext() == false) goto L162;
        h1 r124 = (h1) r58.next();
        if (r59 >= 12) goto L162;
        if (e(r124.getImage(), "gift_panel_icon_touch_down_prefetch") == true) goto L161;
        r60 = r60 + 1;
    L161:
        r123.add(Long.valueOf(r124.getId()));
        r59 = r59 + 1;
    L162:
        if (r60 > 0) goto L164;
    L164:
        if (r46 != null) goto L166;
    L187:
        GiftContext r61 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r61 == null) goto L234;
        com.bytedance.live.datacontext.m<GiftContext.a> r63 = r61.getLastSendGiftId();
        if (r63 == null) goto L234;
        GiftContext.a r64 = (GiftContext.a) r63.getValue();
        if (r64 == null) goto L234;
        if (r64.a == 0) goto L234;
        Iterator<T> r65 = r43.iterator();
    L198:
        if (r65.hasNext() == false) goto L205;
        Object r66 = r65.next();
        if (((w1) r66).getPageType() != r64.c) goto L202;
        boolean r67 = true;
    L203:
        if (r67 == false) goto L198;
        r2 = r66;
        goto L205
    L202:
        r67 = false;
    L205:
        w1 r68 = (w1) r2;
        if (r68 == null) goto L209;
        List<h1> r69 = r68.getGifts();
        if (r69 == null) goto L209;
    L210:
        Iterator<h1> r70 = r69.iterator();
        int r71 = 0;
    L212:
        if (r70.hasNext() == false) goto L220;
        if (r70.next().getId() != r64.a) goto L216;
        boolean r73 = true;
    L217:
        if (r73 == true) goto L218;
        r71 = r71 + 1;
        goto L212
    L218:
        r55 = r71;
        goto L220
    L216:
        r73 = false;
    L220:
        if (r55 < 0) goto L234;
        int r74 = (r55 / 4) * 4;
        int r75 = Math.min(r74 + 11, r69.size());
        int r76 = r74;
        int r77 = 0;
    L223:
        if (r76 >= r75) goto L233;
        h1 r78 = (h1) ListProtector.get(r69, r76);
        if (r123.contains(Long.valueOf(r78.getId())) == true) goto L232;
        if (r78.isDisplayedOnPanel() == false) goto L232;
        if (e(r78.getImage(), "gift_panel_icon_touch_down_prefetch") == true) goto L232;
        r77 = r77 + 1;
    L232:
        r76 = r76 + 1;
        goto L223
    L233:
        jy0.b.a("ttlive_gift_icon", "last send gift " + r64 + " range=" + r74 + '-' + r75 + ", cache miss count = " + r77);
    L209:
        r69 = CollectionsKt.emptyList();
        goto L210
    L166:
        if (r46.getPageType() == 1) goto L168;
        boolean r79 = true;
    L169:
        if (r79 == true) goto L172;
        r46 = null;
    L172:
        if (r46 == null) goto L187;
        List<h1> r80 = r46.getGifts();
        if (r80 == null) goto L187;
        List r81 = CollectionsKt.take(r80, 12);
        if (r81 == null) goto L187;
        ArrayList r83 = new ArrayList();
        Iterator r84 = r81.iterator();
    L179:
        if (r84.hasNext() == false) goto L183;
        Object r85 = r84.next();
        if ((!r123.contains(Long.valueOf(((h1) r85).getId()))) == false) goto L179;
        r83.add(r85);
        goto L179
    L183:
        Iterator r86 = r83.iterator();
    L185:
        if (r86.hasNext() == false) goto L187;
        h1 r87 = (h1) r86.next();
        r87.getId();
        e(r87.getImage(), "gift_panel_icon_touch_down_prefetch");
        r123.add(Long.valueOf(r87.getId()));
        goto L185
    L168:
        r79 = false;
        goto L169
    L142:
        if (r53.isEmpty() == true) goto L145;
        r54 = false;
        goto L146
    L138:
        r51 = null;
        goto L139
    L131:
        r49 = false;
        goto L132
    L134:
        r48 = null;
        goto L135
    L124:
        r45 = null;
        goto L125
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final boolean c(h r5) {
        Intrinsics.checkNotNullParameter(r5, "trigger");
        if (this.a == false) goto L7;
        jy0.b.c("ttlive_gift_preload_new", "image preloading is in progress, skip", null, 4);
        return false;
    L7:
        if ((r5 instanceof h.f) == false) goto L11;
        if (GiftPreloadSettingsKt.b().d() == false) goto L11;
    L28:
        return true;
    L11:
        if ((r5 instanceof h.i) == true) goto L28;
        if ((r5 instanceof h.d) == true) goto L28;
        if ((r5 instanceof h.b) == true) goto L28;
        if ((r5 instanceof h.a) == false) goto L23;
        h.a r0 = (h.a) r5;
        if (r0.b == true) goto L23;
        if (r0.a <= 3) goto L28;
    L23:
        if ((r5 instanceof h.C0045h) == true) goto L25;
        return false;
    L25:
        if (((h.C0045h) r5).a == false) goto L27;
        return false;
    L27:
        if (GiftPreloadSettingsKt.b().c() == true) goto L28;
        return false;
    }

    public static boolean e(k r4, String r5) {
        ImagePipeline r0 = Fresco.getImagePipeline();
        ImageRequest r6 = d.a(r4, c);
        boolean r1 = true;
        if (r6 != null) goto L5;
        return true;
    L5:
        boolean r2 = r0.isInBitmapMemoryCache(r6);
        if (r2 == false) goto L8;
    L27:
        return r2;
    L8:
        if (Intrinsics.areEqual(r5, "gift_panel_icon_touch_down_prefetch") == false) goto L12;
        if (GiftPreloadSettingsKt.b().d() == false) goto L12;
    L25:
        if (r1 == false) goto L27;
        r0.prefetchToBitmapCache(r6, r5);
    L12:
        if (Intrinsics.areEqual(r5, "gift_panel_icon_click_prefetch") == false) goto L16;
        if (GiftPreloadSettingsKt.b().b() == true) goto L25;
    L16:
        if (Intrinsics.areEqual(r5, "change_gift_tab_prefetch") == false) goto L20;
        if (GiftPreloadSettingsKt.b().a() == true) goto L25;
    L20:
        if (Intrinsics.areEqual(r5, "scroll_gift_list_prefetch") == true) goto L22;
    L24:
        r1 = false;
        goto L25
    L22:
        if (GiftPreloadSettingsKt.b().c() == false) goto L24;
        goto L24
    }
}
