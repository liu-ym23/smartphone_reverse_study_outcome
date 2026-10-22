package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FastGiftRecommendService implements com.bytedance.android.scope.o {
    public final yz0.k a;

    public static final class a implements wp2.l {
        public a() {
        }
    }

    public static boolean a() {
        wh6.a r0 = vh6.c.b(wh6.a.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        wh6.a r3 = vh6.c.b(wh6.a.class);
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().e() == false) goto L20;
        if (r4 == false) goto L21;
        if (r1 == true) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L11:
        if (r3.isPersonalRecommendOn() != true) goto L13;
        r4 = true;
        goto L15
    L5:
        if (r0.isAppInGuestMode() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void onStart() {
        if (a() == true) goto L5;
        return;
    L5:
        vh6.c.b(rq2.a.class).nf(new a());
    }

    public final void onStop() {
        if (a() == true) goto L5;
        return;
    L5:
        vh6.c.b(rq2.a.class).removeFastGiftRecommendCallback();
    }

    public final void c(List<? extends com.bytedance.android.livesdk.gift.model.a2> r11) {
        Intrinsics.checkNotNullParameter(r11, "giftSortStrategyList");
        if (a() == true) goto L5;
        return;
    L5:
        List<? extends com.bytedance.android.livesdk.gift.model.a2> r0 = r11;
        jy0.b.a("Darwin Debug giftSortMessageModel ", CollectionsKt.joinToString$default(r0, null, null, null, 0, null, FastGiftRecommendService$triggerFastGiftAsyncSort$1.INSTANCE, 31, null));
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.gift.model.a2 r2 = (com.bytedance.android.livesdk.gift.model.a2) r1.next();
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().g().contains(r2.getScene()) == false) goto L12;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        return;
    L19:
        JSONObject r4 = new JSONObject();
        r4.putOpt("version", 2);
        r4.putOpt("room_id", Long.valueOf(this.a.getRoom().getRoomId()));
        r4.putOpt("gift_sort_strategy", new JSONArray(GsonProtectorUtils.toJson(GsonHelper.get(), r11)));
        jy0.b.a("Darwin Debug triggerFastGiftAsyncSort ", r4.toString());
        vh6.c.b(rq2.a.class).triggerFastGiftAsyncSort(r4);
        return;
    L16:
        r3 = false;
        goto L17
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }

    public FastGiftRecommendService(f1 r2, yz0.k r3) {
        Intrinsics.checkNotNullParameter(r2, "giftListSortService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.a = r3;
        new ArrayList();
    }
}
