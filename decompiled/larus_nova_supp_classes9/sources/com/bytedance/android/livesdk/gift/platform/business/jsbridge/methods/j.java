package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetSelectGiftInfoResultModel;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends w2<JsonObject, LiveGetSelectGiftInfoResultModel> {
    public j() {
    }

    public final void invoke(Object r8, CallContext r9) {
        Intrinsics.checkNotNullParameter((JsonObject) r8, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        LiveGetSelectGiftInfoResultModel r10 = new LiveGetSelectGiftInfoResultModel();
        r10.a(LiveGetSelectGiftInfoResultModel.Code.Success);
        i12.m.a r11 = i12.m.e2;
        i12.d r0 = r11.a();
        ArrayList r1 = null;
        if (r0 == null) goto L5;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, GiftDialogStateDataStore.class);
    L6:
        GiftDialogStateDataStore r3 = (GiftDialogStateDataStore) r2;
        if (r3 == null) goto L61;
        h1 r4 = r3.q();
        if (r4 == null) goto L61;
        ArrayList r5 = new LiveGetSelectGiftInfoResultModel.b();
        r5.e(Long.valueOf(r4.getId()));
        r5.g(r4.getName());
        py.k r6 = r4.getImage();
        if (r6 == null) goto L15;
        List r7 = r6.getUrls();
        if (r7 == null) goto L15;
        String r13 = (String) CollectionsKt.firstOrNull(r7);
    L16:
        r5.f(r13);
        r5.c(Integer.valueOf(r4.getDiamondCount()));
        r5.h(Integer.valueOf(r4.getType()));
        r5.b(r4.getDescribe());
        i12.d r14 = r11.a();
        if (r14 == null) goto L19;
        Object r15 = com.bytedance.android.scope.m.e.d(r14, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c.class);
    L20:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r16 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c) r15;
        if (r16 == null) goto L31;
        l1 r17 = r16.q();
        if (r17 == null) goto L31;
        py.k r18 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).findGiftById(r17.getBuffGiftId()).getImage();
        if (r18 == null) goto L29;
        List r19 = r18.getUrls();
        if (r19 == null) goto L29;
        String r20 = (String) CollectionsKt.firstOrNull(r19);
    L30:
        LiveGetSelectGiftInfoResultModel.a r21 = new LiveGetSelectGiftInfoResultModel.a();
        r21.d(Integer.valueOf(r17.getBuffLevel()));
        r21.b(Long.valueOf(r17.getBuffGiftId()));
        r21.a(Long.valueOf(r17.getBuffDiamondCount()));
        r21.c(r20);
    L32:
        r5.a(r21);
        i12.d r23 = r11.a();
        if (r23 == null) goto L35;
        Object r24 = com.bytedance.android.scope.m.e.d(r23, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c.class);
    L36:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r25 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c) r24;
        if (r25 == null) goto L60;
        com.bytedance.android.livesdk.gift.model.n r26 = r25.k();
        if (r26 == null) goto L60;
        ArrayList r27 = new LiveGetSelectGiftInfoResultModel.c();
        r27.d(r26.getMainText());
        r27.f(r26.getSubText());
        py.k r28 = r26.getGiftCellIcon();
        if (r28 == null) goto L45;
        List r29 = r28.getUrls();
        if (r29 == null) goto L45;
        String r30 = (String) CollectionsKt.firstOrNull(r29);
    L46:
        r27.b(r30);
        if ((r26 instanceof sz1.a) == false) goto L49;
        String r31 = ((sz1.a) r26).getLocalIconBitmap();
    L50:
        r27.c(r31);
        r27.g(Long.valueOf(r26.getTotalDiamonds()));
        r27.a(r26.getCardName());
        ArrayList<e3> r33 = gz1.c.g(r26);
        if ((!r33.isEmpty()) == true) goto L54;
        r33 = null;
    L54:
        if (r33 == null) goto L59;
        r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator<T> r34 = r33.iterator();
    L57:
        if (r34.hasNext() == false) goto L59;
        e3 r35 = (e3) r34.next();
        LiveGetSelectGiftInfoResultModel.d r36 = new LiveGetSelectGiftInfoResultModel.d();
        r36.b(Long.valueOf(r35.getPluginId()));
        r36.a(GsonProtectorUtils.toJson(GsonHelper.getDefault(), r35.getItemPotentialValueHint()));
        r1.add(r36);
    L59:
        r27.e(r1);
        r1 = r27;
        goto L60
    L49:
        r31 = null;
    L45:
        r30 = null;
    L60:
        r5.d(r1);
        r1 = r5;
        goto L61
    L35:
        r24 = null;
    L29:
        r20 = null;
    L31:
        r21 = null;
        goto L32
    L19:
        r15 = null;
    L15:
        r13 = null;
    L61:
        r10.b(r1);
        finishWithResult(r10);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
