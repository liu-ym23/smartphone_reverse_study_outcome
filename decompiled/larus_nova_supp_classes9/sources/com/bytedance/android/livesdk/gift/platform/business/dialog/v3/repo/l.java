package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements SingleOnSubscribe {
    public final /* synthetic */ GiftListCacheRepo a;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.i b;
    public final /* synthetic */ int c;

    public l(GiftListCacheRepo r1, com.bytedance.android.livesdk.gift.platform.core.model.i r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<Object> r18) {
        GiftListCacheRepo r1 = this.a;
        com.bytedance.android.livesdk.gift.platform.core.model.i r2 = this.b;
        int r3 = this.c;
        r1.getClass();
        Function1 r6 = null;
        boolean r7 = false;
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().d() != 2) goto L37;
        ArrayList r4 = new ArrayList();
        w1 r9 = (w1) vh7.f.c(w1.class);
        List<? extends w1> r5 = r2.giftPages;
        if (r5 == null) goto L15;
        Iterator<T> r8 = r5.iterator();
    L8:
        if (r8.hasNext() == false) goto L15;
        w1 r13 = (w1) r8.next();
        if (r13.getPageType() != 1) goto L8;
        if (r13.getDisplay() == false) goto L8;
        r4.addAll(r13.getGifts());
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r4);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r4, false, null);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r4);
        r9.setPageType(r13.getPageType());
        r9.setPageName(r13.getPageName());
        r9.setEventName(r13.getEventName());
        r9.setDisplay(r13.getDisplay());
        r9.setTopicList(r13.getTopicList());
        r9.setPageNameStyleInfo(r13.getPageNameStyleInfo());
        r9.setLynxConfig(r13.getLynxConfig());
    L15:
        if (r4.size() <= 12) goto L24;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r4.iterator();
        int r14 = 0;
    L18:
        if (r11.hasNext() == false) goto L22;
        h1 r15 = (h1) r11.next();
        if (r14 > 11) goto L18;
        r10.add(r15);
        r14 = r14 + 1;
        goto L18
    L22:
        if (r9 == null) goto L26;
        r9.setGifts(r10);
    L26:
        if (r9 == null) goto L93;
        new com.bytedance.android.livesdk.gift.platform.core.model.i().giftPages = CollectionsKt.listOf(r9);
        String r16 = GsonProtectorUtils.toJson(r1.a, r9);
        if (r16 != null) goto L31;
    L32:
        r7 = true;
    L33:
        if (r7 == true) goto L94;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("gift_list_response_v2_" + r3, BuildConfig.FLAVOR), r16);
        HashSet<String> r17 = ay1.b.k();
        r17.add(String.valueOf(r3));
        ay1.b.y(r17);
        r1.c.add(Integer.valueOf(r3));
        return;
    L94:
        return;
    L31:
        if (r16.length() != 0) goto L33;
    L93:
        return;
    L24:
        if (r9 == null) goto L26;
        r9.setGifts(r4);
        goto L26
    L37:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().d() != 3) goto L92;
        com.bytedance.android.livesdk.gift.platform.core.model.i r19 = new com.bytedance.android.livesdk.gift.platform.core.model.i();
        ArrayList r20 = new ArrayList();
        List<? extends w1> r110 = r2.giftPages;
        if (r110 == null) goto L58;
        Iterator<T> r111 = r110.iterator();
    L42:
        if (r111.hasNext() == false) goto L58;
        w1 r112 = (w1) r111.next();
        if (r112.getDisplay() == false) goto L42;
        ArrayList r113 = new ArrayList();
        r113.addAll(r112.getGifts());
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r113);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r113, r7, r6);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r113);
        w1 r114 = (w1) vh7.f.c(w1.class);
        r114.setPageType(r112.getPageType());
        r114.setPageName(r112.getPageName());
        r114.setEventName(r112.getEventName());
        r114.setDisplay(r112.getDisplay());
        r114.setTopicList(r112.getTopicList());
        r114.setPageNameStyleInfo(r112.getPageNameStyleInfo());
        r114.setLynxConfig(r112.getLynxConfig());
        if (r113.size() <= 12) goto L55;
        ArrayList r21 = new ArrayList();
        Iterator r115 = r113.iterator();
        int r116 = 0;
    L49:
        if (r115.hasNext() == false) goto L54;
        h1 r23 = (h1) r115.next();
        if (r116 > 11) goto L49;
        r21.add(r23);
        r116 = r116 + 1;
        goto L49
    L54:
        r114.setGifts(r21);
    L56:
        r20.add(r114);
        r6 = null;
        r7 = false;
        goto L42
    L55:
        r114.setGifts(r113);
    L58:
        if (r20.isEmpty() == true) goto L95;
        r19.giftPages = r20;
        r19.giftsInfo = r2.giftsInfo;
        String r24 = GsonProtectorUtils.toJson(r1.a, r19);
        if (r24 != null) goto L63;
    L66:
        boolean r25 = true;
    L67:
        if (r25 == true) goto L96;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("gift_list_response_v3_" + r3, BuildConfig.FLAVOR), r24);
        HashSet<String> r26 = ay1.b.k();
        r26.add(String.valueOf(r3));
        ay1.b.y(r26);
        r1.c.add(Integer.valueOf(r3));
        return;
    L96:
        return;
    L63:
        if (r24.length() == 0) goto L66;
        r25 = false;
        goto L67
    L95:
        return;
    }
}
