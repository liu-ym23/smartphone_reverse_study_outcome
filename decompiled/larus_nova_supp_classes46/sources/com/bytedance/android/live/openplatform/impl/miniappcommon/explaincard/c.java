package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.vc1;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final int b() {
        d90 r0 = d90.a;
        if (((vc1) r0.getValue()).a() == 1) goto L5;
        return 2131566957;
    L5:
        if (((vc1) r0.getValue()).c() != 1) goto L7;
        return 2131566958;
    L7:
        return 2131566959;
    }

    public static final b a(ShelfInfo r18) {
        String r1 = null;
        if (r18 != null) goto L5;
        return null;
    L5:
        List<ShelfCardInfo> r2 = r18.cardInfoList;
        if (r2 == null) goto L51;
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();
        if (((ShelfCardInfo) r4).getStatus() != 1) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
    L17:
        ShelfCardInfo r5 = (ShelfCardInfo) r4;
        if (r5 == null) goto L52;
        Pair<Integer, String> r7 = r5.a(null);
        long r8 = r5.getCardId();
        int r9 = ((Number) r7.getFirst()).intValue();
        String r10 = (String) r7.getSecond();
        String r11 = r5.j(false);
        ShelfMicroAppInfo r12 = r18.appInfo;
        if (r12 == null) goto L22;
        ImageModel r13 = r12.icon;
    L23:
        if (r12 == null) goto L25;
        String r14 = r12.name;
    L26:
        ProductInfo r15 = r5.getProductInfo();
        if (r15 == null) goto L29;
        String r16 = r15.actionText;
    L31:
        if (g.c(r18) == false) goto L35;
        uc1 r0 = (uc1) ee0.a.getValue();
        if (r0 == null) goto L38;
        r1 = r0.m();
    L38:
        String r17 = r1;
        uc1 r19 = (uc1) ee0.a.getValue();
        if (r19 != null) goto L41;
    L43:
        int r110 = 0;
    L45:
        return new b(r8, r9, r10, r11, r13, r14, r16, r17, r110);
    L41:
        if (r19.i() != true) goto L43;
        r110 = r5.f0();
        goto L45
    L35:
        uc1 r20 = (uc1) ee0.a.getValue();
        if (r20 == null) goto L38;
        r1 = r20.n();
        goto L38
    L29:
        r16 = null;
        goto L31
    L25:
        r14 = null;
        goto L26
    L22:
        r13 = null;
        goto L23
    L52:
        return null;
    L13:
        r6 = false;
        goto L14
    L16:
        r4 = null;
        goto L17
    L51:
        return null;
    }
}
