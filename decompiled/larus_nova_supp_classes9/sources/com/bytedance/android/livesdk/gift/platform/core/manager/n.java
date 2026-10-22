package com.bytedance.android.livesdk.gift.platform.core.manager;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements SingleOnSubscribe {
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.i a;
    public final /* synthetic */ int b;

    public n(com.bytedance.android.livesdk.gift.platform.core.model.i r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r13) {
        GiftManagerKt r14 = GiftManagerKt.z;
        com.bytedance.android.livesdk.gift.platform.core.model.i r0 = this.a;
        int r1 = this.b;
        r14.getClass();
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().f() == true) goto L5;
        com.bytedance.android.livesdk.sharedpref.f.d(GiftManagerKt.w(r1), GsonProtectorUtils.toJson(GiftManagerKt.m, r0));
        HashSet<String> r15 = ay1.b.k();
        r15.add(String.valueOf(r1));
        ay1.b.y(r15);
        return;
    L5:
        if (GiftManagerKt.i.contains(Integer.valueOf(r1)) == true) goto L49;
        if (r1 < 0) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.model.i r16 = new com.bytedance.android.livesdk.gift.platform.core.model.i();
        ArrayList r2 = new ArrayList();
        List<? extends w1> r3 = r0.giftPages;
        boolean r4 = false;
        if (r3 == null) goto L27;
        Iterator<T> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L27;
        w1 r6 = (w1) r5.next();
        if (r6.getDisplay() == false) goto L12;
        ArrayList r7 = new ArrayList();
        r7.addAll(r6.getGifts());
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r7);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r7, false, null);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r7);
        w1 r8 = (w1) vh7.f.c(w1.class);
        r8.setPageType(r6.getPageType());
        r8.setPageName(r6.getPageName());
        r8.setEventName(r6.getEventName());
        r8.setDisplay(r6.getDisplay());
        r8.setPageNameStyleInfo(r6.getPageNameStyleInfo());
        r8.setLynxConfig(r6.getLynxConfig());
        if (r7.size() <= 12) goto L24;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
        int r11 = 0;
    L19:
        if (r10.hasNext() == false) goto L23;
        h1 r17 = (h1) r10.next();
        if (r11 > 11) goto L19;
        r9.add(r17);
        r11 = r11 + 1;
        goto L19
    L23:
        r8.setGifts(r9);
    L25:
        r2.add(r8);
        goto L12
    L24:
        r8.setGifts(r7);
    L27:
        if (r2.isEmpty() == true) goto L52;
        r16.giftPages = r2;
        String r18 = GsonProtectorUtils.toJson(GiftManagerKt.m, r16);
        if (r18 != null) goto L32;
    L33:
        r4 = true;
    L34:
        if (r4 == true) goto L53;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("gift_list_response_v2_" + r1, BuildConfig.FLAVOR), r18);
        com.bytedance.tools.kcp.spongepreference.runtime.a r19 = ay1.b.x;
        KProperty[] r20 = ay1.b.a;
        HashSet r21 = (HashSet) r19.getValue(null, r20[26]);
        r21.add(String.valueOf(r1));
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r19.setValue(null, r20[26], r21);
        GiftManagerKt.i.add(Integer.valueOf(r1));
        return;
    L53:
        return;
    L32:
        if (r18.length() != 0) goto L34;
    L52:
        return;
    L51:
        return;
    }
}
