package com.bytedance.android.livesdk.gift.platform.core;

import android.os.Bundle;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.w3;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.model.UserType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.monitor.EventType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 {
    public static boolean a;
    public static final boolean b = false;

    public static final class a<T> implements SingleOnSubscribe {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<e> r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            int r0 = com.bytedance.android.livesdk.gift.platform.core.b.a;
            r3.onSuccess(new e(com.bytedance.android.livesdk.gift.platform.core.b.a(this.a)));
        }
    }

    public static final class b extends com.bytedance.android.livesdk.user.h<e> {
        public final /* synthetic */ Map a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Map c;

        public final void onSuccess(Object r18) {
            e r1 = (e) r18;
            Intrinsics.checkNotNullParameter(r1, "t");
            this.a.put("size", Float.valueOf(r1.a));
            this.a.put("collect_time", Long.valueOf(Long.valueOf(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).h).longValue()));
            this.a.put("collect_size", Integer.valueOf(Integer.valueOf(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).i).intValue()));
            this.a.put("cache_prepare", Long.valueOf(Long.valueOf(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).l).longValue()));
            wh6.a r2 = vh6.c.b(wh6.a.class);
            if (r2 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r2.isDeepCleanDowngrade());
        L6:
            boolean r4 = r3.booleanValue();
            this.a.put("deep_clean", Boolean.valueOf(r4));
            boolean r5 = d0.a;
            String r9 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_report_appasset_size_status");
            JSONObject r13 = new JSONObject();
            JSONObject r14 = new JSONObject();
            JSONObject r15 = new JSONObject();
            Intrinsics.checkNotNullParameter(r15, "extra");
            Intrinsics.checkNotNullParameter(r14, "metric");
            EventModule r6 = EventModule.LIVE_GIFT;
            Intrinsics.checkNotNullParameter(r6, "eventModule");
            String r10 = r6.getValue();
            Intrinsics.checkNotNullParameter(r13, "map");
            Map r7 = this.b;
            Intrinsics.checkNotNullParameter(r7, "value");
            Iterator r8 = r7.entrySet().iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            Map.Entry r16 = (Map.Entry) r8.next();
            Iterator r19 = r8;
            r13.put((String) r16.getKey(), r16.getValue());
            r8 = r19;
            goto L8
        L10:
            Intrinsics.checkNotNullParameter(r14, "map");
            Map r11 = this.a;
            Intrinsics.checkNotNullParameter(r11, "value");
            Iterator r17 = r11.entrySet().iterator();
        L12:
            if (r17.hasNext() == false) goto L14;
            Map.Entry r20 = (Map.Entry) r17.next();
            r14.put((String) r20.getKey(), r20.getValue());
            goto L12
        L14:
            cy0.e.a.getClass();
            cy0.j r110 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r21 = com.bytedance.android.scope.m.b(r110).b(n97.a.class);
            Intrinsics.checkNotNull(r21);
            ((com.bytedance.live.kmp.core.c) r21).g(r9, r10, "bussiness_api_call", r13, r14, r15);
            this.c.put("appasset_size", String.valueOf(r1.a));
            this.c.put("collect_alltime", String.valueOf(Long.valueOf(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).h).longValue()));
            this.c.put("collect_size", String.valueOf(Integer.valueOf(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).i).intValue()));
            this.c.put("cache_prepare", String.valueOf(Long.valueOf(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).l).longValue()));
            if (r4 == false) goto L17;
            this.c.put("deep_clean", "1");
        L18:
            mz0.n r23 = new mz0.n();
            Map r24 = r23.a;
            Intrinsics.checkNotNullParameter(r24, "map");
            Map r25 = this.c;
            Intrinsics.checkNotNullParameter(r25, "map");
            r24.putAll(r25);
            Object r26 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r26);
            ((f80.a) r26).w3("livesdk_report_appasset_size_status", r23.a, r23.b);
            return;
        L17:
            this.c.put("deep_clean", "0");
            goto L18
        L5:
            r3 = null;
            goto L6
        }

        public b(Map r1, Map r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        b = ((Boolean) h.b.getValue(null, h.a[0])).booleanValue();
    }

    public static yz0.k b() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
    }

    public static void h() {
        if (a == false) goto L6;
        return;
    L6:
        if (((Boolean) h.i.getValue(null, h.a[7])).booleanValue() == true) goto L8;
        return;
    L8:
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.b.S;
        KProperty[] r1 = ay1.b.a;
        if ((System.currentTimeMillis() - ((Number) r0.getValue(null, r1[56])).longValue()) >= 86400000) goto L12;
        a = true;
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();
        HashMap r5 = new HashMap();
        long r6 = ((Number) ay1.b.Q.getValue(null, r1[54])).longValue();
        if (r6 != 0) goto L15;
        r4.put("first_time", -1);
    L16:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r7 = GiftResourceManagerFactory.a();
        if (r7 == null) goto L21;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r8 = r7.a();
        if (r8 == null) goto L21;
        String r9 = r8.a();
    L22:
        if (r9 != null) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        return;
    L30:
        r0.setValue(null, r1[56], Long.valueOf(System.currentTimeMillis()));
        a = true;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("consume_level", Integer.valueOf(ay1.b.u()));
        r2.put("is_anchor", Boolean.valueOf(g02.a.e()));
        r5.put("consume_level", String.valueOf(ay1.b.u()));
        if (g02.a.e() == false) goto L33;
        r5.put("is_anchor", "1");
    L34:
        Single.create(new a(r9)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r4, r2, r5));
        return;
    L33:
        r5.put("is_anchor", "0");
        goto L34
    L24:
        if (r9.length() == 0) goto L27;
        r10 = false;
    L21:
        r9 = null;
        goto L22
    L15:
        Calendar r11 = Calendar.getInstance();
        r11.setTimeInMillis(r6);
        r4.put("first_time", Integer.valueOf(r11.get(11)));
        goto L16
    }

    public static int a(List r3) {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        yz0.k r1 = b();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isAnchor());
    L7:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L10;
        return UserType.Anchor.getValue();
    L10:
        if (((ArrayList) r3).contains(r0) == false) goto L13;
        return UserType.Guest.getValue();
    L13:
        return UserType.Audience.getValue();
    L5:
        r2 = null;
        goto L7
    }

    public static void c(int r10) {
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_toolbar_gift_show_status");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r3 = r0.getValue();
        Intrinsics.checkNotNullParameter(r5, "map");
        Integer r1 = Integer.valueOf(r10);
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        r5.put("status_code", r1);
        Integer r11 = Integer.valueOf(r10);
        Intrinsics.checkNotNullParameter("status", "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        r5.put("status", r11);
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r4).b(n97.a.class);
        Intrinsics.checkNotNull(r13);
        ((com.bytedance.live.kmp.core.c) r13).g(r2, r3, "bussiness_api_call", r5, r6, r7);
    }

    @JvmStatic
    public static final void e(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "extras");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r3 = r0.getValue();
        r6.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r7, "map");
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        Object r8 = r10.get(r2);
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.put(r2, r8);
        goto L4
    L6:
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r11 = com.bytedance.android.scope.m.b(r4).b(n97.a.class);
        Intrinsics.checkNotNull(r11);
        ((com.bytedance.live.kmp.core.c) r11).g("ttlive_video_gift_show_link_all", r3, "bussiness_api_call", r5, r6, r7);
    }

    public static void g(Map r14) {
        Intrinsics.checkNotNullParameter(r14, "stampMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r0, "$this$addDurationToMetrics");
        Intrinsics.checkNotNullParameter(r14, "map");
        if (r14.keySet().containsAll(CollectionsKt.listOf(new Integer[]{0, 1, 2, 4, 9, 10})) == false) goto L57;
        Long r2 = (Long) r14.get(1);
        long r10 = 0;
        if (r2 == null) goto L7;
        long r3 = r2.longValue();
    L8:
        Long r13 = (Long) r14.get(0);
        if (r13 == null) goto L11;
        long r15 = r13.longValue();
    L12:
        r0.put("intercept_to_receive_duration", Long.valueOf(r3 - r15));
        Long r4 = (Long) r14.get(2);
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        Long r6 = (Long) r14.get(1);
        if (r6 == null) goto L19;
        long r16 = r6.longValue();
    L20:
        r0.put("receive_to_msg_queue_duration", Long.valueOf(r5 - r16));
        Long r7 = (Long) r14.get(4);
        if (r7 == null) goto L23;
        long r8 = r7.longValue();
    L24:
        Long r9 = (Long) r14.get(2);
        if (r9 == null) goto L27;
        long r11 = r9.longValue();
    L28:
        r0.put("msg_queue_to_effect_queue_duration", Long.valueOf(r8 - r11));
        Long r17 = (Long) r14.get(9);
        if (r17 == null) goto L31;
        long r18 = r17.longValue();
    L32:
        Long r19 = (Long) r14.get(4);
        if (r19 == null) goto L35;
        long r20 = r19.longValue();
    L36:
        r0.put("effect_queue_to_consume_duration", Long.valueOf(r18 - r20));
        Long r21 = (Long) r14.get(10);
        if (r21 == null) goto L39;
        long r23 = r21.longValue();
    L40:
        Long r24 = (Long) r14.get(9);
        if (r24 == null) goto L43;
        long r25 = r24.longValue();
    L44:
        r0.put("consume_to_display_duration", Long.valueOf(r23 - r25));
        Long r26 = (Long) r14.get(10);
        if (r26 == null) goto L47;
        long r27 = r26.longValue();
    L48:
        Long r28 = (Long) r14.get(0);
        if (r28 == null) goto L51;
        long r29 = r28.longValue();
    L52:
        r0.put("durations", Long.valueOf(r27 - r29));
        long r30 = com.bytedance.live.kmp.util.e.b();
        Long r110 = (Long) r14.get(10);
        if (r110 == null) goto L55;
        r10 = r110.longValue();
    L55:
        r0.put("log_to_display_duration", Long.valueOf(r30 - r10));
        goto L57
    L51:
        r29 = 0;
        goto L52
    L47:
        r27 = 0;
        goto L48
    L43:
        r25 = 0;
        goto L44
    L39:
        r23 = 0;
        goto L40
    L35:
        r20 = 0;
        goto L36
    L31:
        r18 = 0;
        goto L32
    L27:
        r11 = 0;
        goto L28
    L23:
        r8 = 0;
        goto L24
    L19:
        r16 = 0;
        goto L20
    L15:
        r5 = 0;
        goto L16
    L11:
        r15 = 0;
        goto L12
    L7:
        r3 = 0;
    L57:
        if (g02.a.e() == false) goto L65;
        JSONObject r31 = new JSONObject();
        JSONObject r33 = new JSONObject();
        JSONObject r34 = new JSONObject();
        Intrinsics.checkNotNullParameter(r34, "extra");
        Intrinsics.checkNotNullParameter(r33, "metric");
        EventModule r111 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r111, "eventModule");
        String r35 = r111.getValue();
        Intrinsics.checkNotNullParameter(r33, "map");
        Intrinsics.checkNotNullParameter(r0, "value");
        Iterator r112 = r0.entrySet().iterator();
    L60:
        if (r112.hasNext() == false) goto L62;
        Map.Entry r1 = (Map.Entry) r112.next();
        r33.put((String) r1.getKey(), r1.getValue());
        goto L60
    L62:
        cy0.e.a.getClass();
        cy0.j r36 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r36).b(n97.a.class);
        Intrinsics.checkNotNull(r113);
        ((com.bytedance.live.kmp.core.c) r113).g("ttlive_gift_message_anchor_receive_to_show_time", r35, "bussiness_api_call", r31, r33, r34);
        return;
    }

    public static void m(NormalGiftMessage r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        o7 r0 = r6.r();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getGift() == null) goto L98;
        LinkedHashMap r1 = new LinkedHashMap();
        o7 r2 = r6.r();
        if (r2 == null) goto L18;
        o0 r3 = r2.getTrayInfo();
        if (r3 == null) goto L18;
        w3 r4 = r3.getTrayPreEffect();
        if (r4 == null) goto L18;
        py.k r5 = r4.getPreEffectImg();
        if (r5 == null) goto L18;
        String r7 = r5.getUri();
        if (r7 == null) goto L18;
        r1.put("pre_effect_uri", r7);
    L18:
        o7 r8 = r6.r();
        if (r8 == null) goto L29;
        o0 r9 = r8.getTrayInfo();
        if (r9 == null) goto L29;
        u3 r10 = r9.getTrayPostEffect();
        if (r10 == null) goto L29;
        py.k r11 = r10.getPostEffectImg();
        if (r11 == null) goto L29;
        String r13 = r11.getUri();
        if (r13 == null) goto L29;
        r1.put("post_effect_uri", r13);
    L29:
        o7 r14 = r6.r();
        if (r14 == null) goto L36;
        IBaseUser r15 = r14.getFromUser();
        if (r15 == null) goto L36;
        String r16 = r15.getNickName();
        if (r16 == null) goto L36;
        r1.put("user_name", r16);
    L36:
        o7 r17 = r6.r();
        if (r17 == null) goto L47;
        IBaseUser r18 = r17.getFromUser();
        if (r18 == null) goto L47;
        py.k r19 = r18.getAvatarThumbKt();
        if (r19 == null) goto L47;
        List r20 = r19.getUrls();
        if (r20 == null) goto L47;
        String r21 = (String) CollectionsKt.getOrNull(r20, 0);
        if (r21 == null) goto L47;
        r1.put("user_avatar_url", r21);
    L47:
        o7 r23 = r6.r();
        if (r23 == null) goto L56;
        o0 r24 = r23.getTrayInfo();
        if (r24 == null) goto L56;
        py.k r25 = r24.getTrayRightImgV2();
        if (r25 == null) goto L56;
        String r26 = r25.getUri();
        if (r26 == null) goto L56;
        r1.put("tray_right_img_v2_uri", r26);
    L56:
        o7 r27 = r6.r();
        if (r27 == null) goto L59;
        r1.put("gift_id", Long.valueOf(r27.getGiftId()));
    L59:
        ur2.a r28 = vh6.c.b(ur2.a.class);
        a5 r29 = r6.getTrayDisplayText();
        String r30 = r6.c;
        if (r30 != null) goto L62;
        r30 = BuildConfig.FLAVOR;
    L62:
        r1.put("gift_script", r28.Lf(r29, r30).toString());
        o7 r31 = r6.r();
        if (r31 == null) goto L73;
        h1 r33 = r31.getGift();
        if (r33 == null) goto L73;
        py.k r34 = r33.getImage();
        if (r34 == null) goto L73;
        List r35 = r34.getUrls();
        if (r35 == null) goto L73;
        String r36 = (String) CollectionsKt.getOrNull(r35, 0);
        if (r36 == null) goto L73;
        r1.put("gift_icon_url", r36);
    L73:
        o7 r37 = r6.r();
        String r38 = null;
        if (r37 == null) goto L87;
        List r39 = r37.getSeriesGiftData();
        if (r39 == null) goto L87;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r39.iterator();
    L79:
        if (r41.hasNext() == false) goto L86;
        h1 r43 = ((n3) r41.next()).getGift();
        if (r43 == null) goto L83;
        Long r44 = Long.valueOf(r43.getId());
    L84:
        if (r44 == null) goto L79;
        r40.add(r44);
        goto L79
    L83:
        r44 = null;
        goto L84
    L86:
        r1.put("series_gift_ids", r40);
    L87:
        r1.put("group_count", Long.valueOf(r6.m));
        r1.put("group_size", Long.valueOf(r6.k));
        boolean r45 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.profit.privilege.c r46 = com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class);
        ProfitCheckType r47 = ProfitCheckType.GIFT_TRAY;
        o7 r48 = r6.r();
        if (r48 == null) goto L90;
        r38 = r48.getTraceId();
    L90:
        r46.B1(r47, r1, r38);
        return;
    }

    public static void i(int r10, int r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("delete_source", Integer.valueOf(r11));
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("delete_count", Integer.valueOf(r10));
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_report_asset_delete_status");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r14 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r14, "eventModule");
        String r3 = r14.getValue();
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "value");
        Iterator r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r8 = (Map.Entry) r1.next();
        r5.put((String) r8.getKey(), r8.getValue());
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r13, "value");
        Iterator r15 = r13.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Map.Entry r16 = (Map.Entry) r15.next();
        r6.put((String) r16.getKey(), r16.getValue());
        goto L8
    L10:
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).b(n97.a.class);
        Intrinsics.checkNotNull(r18);
        ((com.bytedance.live.kmp.core.c) r18).g(r2, r3, "bussiness_api_call", r5, r6, r7);
    }

    public static void f(String r25, int r26, int r27) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("status_code", 1);
        r0.put("status", 1);
        r0.put("source_type", Integer.valueOf(r27));
        String r1 = BuildConfig.FLAVOR;
        if (r25 != null) goto L5;
        String r2 = BuildConfig.FLAVOR;
    L6:
        r0.put("error_msg", r2);
        r0.put("error_code", Integer.valueOf(r26));
        LinkedHashMap r3 = new LinkedHashMap();
        yz0.k r4 = b();
        String r5 = null;
        if (r4 == null) goto L9;
        IRoom r6 = r4.getRoom();
    L10:
        if (r6 == null) goto L15;
        r3.put("room_id", Long.valueOf(r6.getId()));
        String r7 = r6.getAnchorId();
        if (r7 != null) goto L14;
        r7 = BuildConfig.FLAVOR;
    L14:
        r3.put("anchor_id", r7);
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r8 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r8 == null) goto L23;
        IBaseUser r9 = r8.a;
        if (r9 == null) goto L23;
        String r10 = r9.getIdString();
        if (r10 == null) goto L23;
        r5 = r10;
    L25:
        if (r5 == null) goto L28;
        r1 = r5;
    L28:
        r3.put("to_anchor_id", r1);
        String r11 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_asset_list_status");
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        JSONObject r15 = new JSONObject();
        Intrinsics.checkNotNullParameter(r15, "extra");
        Intrinsics.checkNotNullParameter(r14, "metric");
        EventModule r16 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r16, "eventModule");
        String r17 = r16.getValue();
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "value");
        Iterator r18 = r0.entrySet().iterator();
    L30:
        if (r18.hasNext() == false) goto L32;
        Map.Entry r19 = (Map.Entry) r18.next();
        Iterator r28 = r18;
        r13.put((String) r19.getKey(), r19.getValue());
        r18 = r28;
        r0 = r0;
        goto L30
    L32:
        LinkedHashMap r110 = r0;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r20 = r3.entrySet().iterator();
    L34:
        if (r20.hasNext() == false) goto L36;
        Map.Entry r21 = (Map.Entry) r20.next();
        r15.put((String) r21.getKey(), r21.getValue());
        r20 = r20;
        goto L34
    L36:
        cy0.e.a.getClass();
        cy0.j r111 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r111).b(n97.a.class);
        Intrinsics.checkNotNull(r23);
        ((com.bytedance.live.kmp.core.c) r23).g(r11, r17, "bussiness_api_call", r13, r14, r15);
        String r112 = com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_asset_list_status");
        JSONObject r24 = new JSONObject();
        JSONObject r29 = new JSONObject();
        JSONObject r30 = new JSONObject();
        Intrinsics.checkNotNullParameter(r30, "extra");
        Intrinsics.checkNotNullParameter(r29, "metric");
        Intrinsics.checkNotNullParameter(r16, "eventModule");
        String r210 = r16.getValue();
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r110, "value");
        Iterator r31 = r110.entrySet().iterator();
    L38:
        if (r31.hasNext() == false) goto L40;
        Map.Entry r33 = (Map.Entry) r31.next();
        r24.put((String) r33.getKey(), r33.getValue());
        goto L38
    L40:
        Intrinsics.checkNotNullParameter(r30, "map");
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r34 = r3.entrySet().iterator();
    L42:
        if (r34.hasNext() == false) goto L44;
        Map.Entry r35 = (Map.Entry) r34.next();
        r30.put((String) r35.getKey(), r35.getValue());
        goto L42
    L44:
        Object r36 = com.bytedance.android.scope.m.b(r111).b(n97.a.class);
        Intrinsics.checkNotNull(r36);
        ((com.bytedance.live.kmp.core.c) r36).g(r112, r210, "bussiness_api_call", r24, r29, r30);
        return;
    L23:
        if (r6 == null) goto L25;
        r5 = r6.getAnchorId();
        goto L25
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = r25;
        goto L6
    }

    public static void j(long r9, List r11, List r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", Long.valueOf(r9));
        if (r11 == null) goto L15;
        r0.put("option_type", "1");
        ArrayList r3 = new ArrayList();
        Iterator r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L14;
        l1 r4 = (l1) r14.next();
        JSONObject r5 = new JSONObject();
        r5.put("buff_level", r4.getBuffLevel());
        r5.put("buff_gift_id", r4.getBuffGiftId());
        com.bytedance.android.livesdk.gift.model.i r6 = r4.getLockInfo();
        if (r6 == null) goto L12;
        int r7 = 1;
        if (r6.getLocked() != true) goto L12;
    L13:
        r5.put("is_lock", r7);
        r3.add(r5);
    L12:
        r7 = 0;
        goto L13
    L14:
        r0.put("right_infos", r3);
    L15:
        if (r13 == null) goto L28;
        r0.put("option_type", "2");
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L18:
        if (r16.hasNext() == false) goto L27;
        com.bytedance.android.livesdk.gift.model.n r2 = (com.bytedance.android.livesdk.gift.model.n) r16.next();
        JSONObject r8 = new JSONObject();
        r8.put("main_text", r2.getMainText());
        String r10 = r2.getCardName();
        if (r10 == null) goto L22;
        r8.put("card_name", r10);
    L22:
        CardLockInfo r17 = r2.getLockInfo();
        if (r17 == null) goto L25;
        int r18 = r17.getLockStatus();
    L26:
        r8.put("is_lock", r18);
        r15.add(r8);
        goto L18
    L25:
        r18 = 0;
        goto L26
    L27:
        r0.put("right_infos", r15);
    L28:
        boolean r19 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).B1(ProfitCheckType.GIFT_OPTION_RIGHT, r0, null);
    }

    public static void n(JSONObject r13, JSONObject r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r13, "category");
        Intrinsics.checkNotNullParameter(r14, "metrics");
        Intrinsics.checkNotNullParameter(r15, "extras");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r3 = r0.getValue();
        Intrinsics.checkNotNullParameter(r5, "map");
        Iterator<String> r1 = r13.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r8 = r1.next();
        Object r11 = r13.get(r8);
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        r5.put(r8, r11);
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r6, "map");
        Iterator<String> r16 = r14.keys();
    L8:
        if (r16.hasNext() == false) goto L10;
        String r2 = r16.next();
        Object r9 = r14.get(r2);
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r6.put(r2, r9);
        goto L8
    L10:
        Intrinsics.checkNotNullParameter(r7, "map");
        Iterator<String> r17 = r15.keys();
    L12:
        if (r17.hasNext() == false) goto L14;
        String r18 = r17.next();
        Object r4 = r15.get(r18);
        Intrinsics.checkNotNullParameter(r18, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(r18, r4);
        goto L12
    L14:
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r19).b(n97.a.class);
        Intrinsics.checkNotNull(r110);
        ((com.bytedance.live.kmp.core.c) r110).g("ttlive_video_gift_msg_consume_all", r3, "bussiness_api_call", r5, r6, r7);
    }

    @JvmStatic
    public static final void o(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$safePut");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.put(r2, r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if (r4 != null) goto L9;
        r4 = BuildConfig.FLAVOR;
    L9:
        jy0.b.c("LiveGiftMonitor", r4, null, 4);
    }

    @JvmStatic
    public static final void l(Integer r10, long r11, JSONObject r13, int r14) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r2 = r0.getValue();
        EventType r1 = EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r1, "eventType");
        String r3 = r1.getValue();
        Intrinsics.checkNotNullParameter(r4, "map");
        if (r10 == null) goto L5;
        int r15 = r10.intValue();
    L6:
        Integer r16 = Integer.valueOf(r15);
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(r16, "value");
        r4.put("status_code", r16);
        Long r17 = Long.valueOf(r11);
        Intrinsics.checkNotNullParameter("source", "key");
        Intrinsics.checkNotNullParameter(r17, "value");
        r4.put("source", r17);
        Integer r18 = Integer.valueOf(r14);
        Intrinsics.checkNotNullParameter("ttnet_from", "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r4.put("ttnet_from", r18);
        Intrinsics.checkNotNullParameter(r6, "map");
        Iterator<String> r19 = r13.keys();
        if (r19 != null) goto L9;
    L11:
        cy0.e.a.getClass();
        cy0.j r110 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).b(n97.a.class);
        Intrinsics.checkNotNull(r111);
        ((com.bytedance.live.kmp.core.c) r111).g("ttlive_gift_tt_download_result", r2, r3, r4, r5, r6);
        return;
    L9:
        if (r19.hasNext() == false) goto L11;
        String r112 = r19.next();
        Object r113 = r13.get(r112);
        Intrinsics.checkNotNullParameter(r112, "key");
        Intrinsics.checkNotNullParameter(r113, "value");
        r6.put(r112, r113);
        goto L9
    L5:
        r15 = 0;
        goto L6
    }

    public static void d(boolean r5, long r6, int r8, IBaseUser r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "toUser");
        JSONObject r0 = new JSONObject();
        r0.put("send_scene", r10);
        r0.put("is_send_all_mic", com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() ? 1 : 0);
        r0.put("gift_id", r6);
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L10;
        com.bytedance.live.datacontext.n<Bundle> r11 = r7.getGiftLogExtra();
        if (r11 == null) goto L10;
        Bundle r13 = (Bundle) r11.getValue();
        if (r13 == null) goto L10;
        Object r14 = r13.get("gift_show_from");
        if (r14 == null) goto L10;
    L11:
        r0.put("source", r14);
        r0.put("tab_index", r8);
        r0.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r8));
        List<IBaseUser> r15 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.e();
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        r16.add(((IBaseUser) r17.next()).getIdString());
        goto L13
    L15:
        r0.put("user_identifier", a(r16));
        r0.put("to_user_identifier", com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.d().getValue());
        JSONObject r18 = new JSONObject();
        Object r19 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        yz0.k r20 = b();
        if (r20 == null) goto L20;
        IRoom r21 = r20.getRoom();
        if (r21 == null) goto L20;
        long r3 = r21.getRoomId();
    L21:
        r18.put("room_id", r3);
        if (r19 != null) goto L24;
        r19 = 0L;
    L24:
        r18.put("user_id", r19);
        r18.put("to_user_id", r9.getIdString());
        yz0.k r23 = b();
        if (r23 == null) goto L27;
        long r24 = r23.Hl();
    L29:
        if (r24 <= 0) goto L31;
        r18.put("stay_room_duration", System.currentTimeMillis() - r24);
    L32:
        JSONObject r25 = new JSONObject();
        if (r5 == false) goto L35;
        r0.put("status_code", 1);
        LiveTracingMonitor.f(com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_locate_status"), LiveTracingMonitor.EventModule.LIVE_GIFT, r0, r18, r25);
        return;
    L35:
        r0.put("status_code", 0);
        String r26 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_locate_status");
        LiveTracingMonitor.EventModule r27 = LiveTracingMonitor.EventModule.LIVE_GIFT;
        LiveTracingMonitor.f(r26, r27, r0, r18, r25);
        LiveTracingMonitor.f(com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_locate_status"), r27, r0, r18, r25);
        return;
    L31:
        r18.put("stay_room_duration", 0);
        goto L32
    L27:
        r24 = 0;
    L20:
        r3 = 0;
    L10:
        r14 = BuildConfig.FLAVOR;
        goto L11
    }

    @JvmStatic
    public static final void k(Integer r13, String r14, Integer r15, long r16, int r17, long r18) {
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r2, "metric");
        EventModule r4 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        String r5 = r4.getValue();
        EventType r6 = EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r6, "eventType");
        String r7 = r6.getValue();
        Intrinsics.checkNotNullParameter(r1, "map");
        int r8 = 0;
        if (r15 == null) goto L5;
        int r9 = r15.intValue();
    L6:
        Integer r10 = Integer.valueOf(r9);
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r1.put("status_code", r10);
        Long r11 = Long.valueOf(r16);
        Intrinsics.checkNotNullParameter("source", "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        r1.put("source", r11);
        Integer r19 = Integer.valueOf(r17);
        Intrinsics.checkNotNullParameter("ttnet_from", "key");
        Intrinsics.checkNotNullParameter(r19, "value");
        r1.put("ttnet_from", r19);
        Long r20 = Long.valueOf(r18);
        Intrinsics.checkNotNullParameter("asset_id", "key");
        Intrinsics.checkNotNullParameter(r20, "value");
        r1.put("asset_id", r20);
        Intrinsics.checkNotNullParameter(r3, "map");
        if (r13 == null) goto L9;
        r8 = r13.intValue();
    L9:
        Integer r21 = Integer.valueOf(r8);
        Intrinsics.checkNotNullParameter("errorCode", "key");
        Intrinsics.checkNotNullParameter(r21, "value");
        r3.put("errorCode", r21);
        if (r14 != null) goto L12;
        String r23 = BuildConfig.FLAVOR;
    L13:
        Intrinsics.checkNotNullParameter("errorMsg", "key");
        Intrinsics.checkNotNullParameter(r23, "value");
        r3.put("errorMsg", r23);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).b(n97.a.class);
        Intrinsics.checkNotNull(r25);
        ((com.bytedance.live.kmp.core.c) r25).g("ttlive_gift_tt_download_result", r5, r7, r1, r2, r3);
        return;
    L12:
        r23 = r14;
        goto L13
    L5:
        r9 = 0;
        goto L6
    }

    public static void p(long r21, long r23, boolean r25, long r26, int r28, String r29, String r30, String r31, String r33, long r34, int r35) {
        Intrinsics.checkNotNullParameter(r29, "errorMessage");
        Intrinsics.checkNotNullParameter(r30, "userId");
        Intrinsics.checkNotNullParameter(r31, "anchorId");
        Intrinsics.checkNotNullParameter(r33, "toUserId");
        if (r25 == false) goto L5;
        String r17 = com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_prop_transaction_finish_status");
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r9, "metric");
        EventModule r6 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r6, "eventModule");
        String r4 = r6.getValue();
        Intrinsics.checkNotNullParameter(r8, "map");
        Long r7 = Long.valueOf(r23);
        Intrinsics.checkNotNullParameter("prop_id", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r8.put("prop_id", r7);
        Integer r5 = Integer.valueOf(r28);
        Intrinsics.checkNotNullParameter("error_code", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put("error_code", r5);
        rz0.b r10 = new rz0.b(r9);
        r10.a("room_id", Long.valueOf(r26));
        r10.a("user_id", r30);
        r10.a("anchor_id", r31);
        r10.a("to_user_id", r33);
        r10.a("to_room_id", Long.valueOf(r34));
        r10.a("send_scene", Integer.valueOf(r35));
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter("error_message", "key");
        Intrinsics.checkNotNullParameter(r29, "value");
        r3.put("error_message", r29);
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r2).b(n97.a.class);
        Intrinsics.checkNotNull(r0);
        ((com.bytedance.live.kmp.core.c) r0).g(r17, r4, "bussiness_api_call", r8, r9, r3);
        return;
    L5:
        String r18 = com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_transaction_finish_status");
        JSONObject r11 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r13 = new JSONObject();
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r1, "metric");
        EventModule r14 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r14, "eventModule");
        String r15 = r14.getValue();
        Intrinsics.checkNotNullParameter(r11, "map");
        Long r16 = Long.valueOf(r21);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r16, "value");
        r11.put("gift_id", r16);
        Integer r19 = Integer.valueOf(r28);
        Intrinsics.checkNotNullParameter("error_code", "key");
        Intrinsics.checkNotNullParameter(r19, "value");
        r11.put("error_code", r19);
        rz0.b r20 = new rz0.b(r1);
        r20.a("room_id", Long.valueOf(r26));
        r20.a("user_id", r30);
        r20.a("anchor_id", r31);
        r20.a("to_user_id", r33);
        r20.a("to_room_id", Long.valueOf(r34));
        r20.a("send_scene", Integer.valueOf(r35));
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter("error_message", "key");
        Intrinsics.checkNotNullParameter(r29, "value");
        r13.put("error_message", r29);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r24).b(n97.a.class);
        Intrinsics.checkNotNull(r27);
        ((com.bytedance.live.kmp.core.c) r27).g(r18, r15, "bussiness_api_call", r11, r1, r13);
    }

    public static void q(long r21, long r23, boolean r25, long r26, int r28, String r29, String r30, String r31, String r33, long r34, int r35) {
        Intrinsics.checkNotNullParameter(r29, "errorMessage");
        Intrinsics.checkNotNullParameter(r30, "userId");
        Intrinsics.checkNotNullParameter(r31, "anchorId");
        Intrinsics.checkNotNullParameter(r33, "toUserId");
        if (r25 == false) goto L5;
        String r17 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_prop_transaction_finish_status");
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r9, "metric");
        EventModule r6 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r6, "eventModule");
        String r4 = r6.getValue();
        Intrinsics.checkNotNullParameter(r8, "map");
        Long r7 = Long.valueOf(r23);
        Intrinsics.checkNotNullParameter("prop_id", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r8.put("prop_id", r7);
        Integer r5 = Integer.valueOf(r28);
        Intrinsics.checkNotNullParameter("error_code", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put("error_code", r5);
        rz0.b r10 = new rz0.b(r9);
        r10.a("room_id", Long.valueOf(r26));
        r10.a("user_id", r30);
        r10.a("anchor_id", r31);
        r10.a("to_user_id", r33);
        r10.a("to_room_id", Long.valueOf(r34));
        r10.a("send_scene", Integer.valueOf(r35));
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter("error_message", "key");
        Intrinsics.checkNotNullParameter(r29, "value");
        r3.put("error_message", r29);
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r2).b(n97.a.class);
        Intrinsics.checkNotNull(r0);
        ((com.bytedance.live.kmp.core.c) r0).g(r17, r4, "bussiness_api_call", r8, r9, r3);
        return;
    L5:
        String r18 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_transaction_finish_status");
        JSONObject r11 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r13 = new JSONObject();
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r1, "metric");
        EventModule r14 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r14, "eventModule");
        String r15 = r14.getValue();
        Intrinsics.checkNotNullParameter(r11, "map");
        Long r16 = Long.valueOf(r21);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r16, "value");
        r11.put("gift_id", r16);
        Integer r19 = Integer.valueOf(r28);
        Intrinsics.checkNotNullParameter("error_code", "key");
        Intrinsics.checkNotNullParameter(r19, "value");
        r11.put("error_code", r19);
        rz0.b r20 = new rz0.b(r1);
        r20.a("room_id", Long.valueOf(r26));
        r20.a("user_id", r30);
        r20.a("anchor_id", r31);
        r20.a("to_user_id", r33);
        r20.a("to_room_id", Long.valueOf(r34));
        r20.a("send_scene", Integer.valueOf(r35));
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter("error_message", "key");
        Intrinsics.checkNotNullParameter(r29, "value");
        r13.put("error_message", r29);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r24).b(n97.a.class);
        Intrinsics.checkNotNull(r27);
        ((com.bytedance.live.kmp.core.c) r27).g(r18, r15, "bussiness_api_call", r11, r1, r13);
    }
}
