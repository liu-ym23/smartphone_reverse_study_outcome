package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.g2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j1;
import com.bytedance.android.livesdk.gift.model.q1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.ModelUtilsKt;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ int a;

    public t(int r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        ExtraResponse r15 = (ExtraResponse) r14;
        if (r15 == null) goto L119;
        com.bytedance.android.livesdk.gift.platform.core.model.i r16 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r15.data;
        if (r16 == null) goto L125;
        GiftListRepo r0 = GiftListRepo.k;
        int r1 = this.a;
        r0.getClass();
        if (((com.bytedance.android.livesdk.gift.configmodel.n0) nz1.a.b0.getValue(null, nz1.a.a[52])).a() == false) goto L128;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.g r2 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.g) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.g.class);
        j1 r3 = r16.giftBaseData;
        if (r3 == null) goto L13;
        r2.L5(r3);
    L13:
        if (r1 != 13) goto L126;
        List<? extends w1> r17 = r16.giftPages;
        if (r17 == null) goto L127;
        Iterator<T> r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L129;
        w1 r4 = (w1) r18.next();
        List<h1> r5 = r4.getGifts();
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator<T> r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        T r8 = r7.next();
        r6.put(Long.valueOf(((h1) r8).getId()), r8);
        goto L21
    L23:
        List<g2> r9 = r4.getLiteGifts();
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L25:
        if (r11.hasNext() == false) goto L118;
        g2 r13 = (g2) r11.next();
        h1 r19 = (h1) r6.get(Long.valueOf(r13.getId()));
        boolean r20 = false;
        if (r19 != null) goto L77;
        r19 = GiftManagerKt.j(r13.getId(), Integer.valueOf(r4.getPageType()));
        if (r19 == null) goto L76;
        c1 r110 = r2.D2().get(Long.valueOf(r13.getId()));
        Intrinsics.checkNotNullParameter(r19, "$this$updateFromLiteGift");
        Intrinsics.checkNotNullParameter(r13, "liteGift");
        r19.setId(r13.getId());
        r19.setType(r13.getType());
        r19.setName(r13.getName());
        r19.setDiamondCount(r13.getDiamondCount());
        r19.setBizType(r13.getBizType());
        q1 r111 = r13.getGiftImage();
        if (r111 != null) goto L33;
    L42:
        py.k r112 = ModelUtilsKt.a(r110, r13.getGiftImage());
    L43:
        if (r112 == null) goto L45;
        r19.setImage(r112);
    L45:
        q1 r113 = r13.getWebpGiftImage();
        if (r113 != null) goto L48;
    L57:
        py.k r114 = ModelUtilsKt.a(r110, r13.getWebpGiftImage());
    L58:
        if (r114 == null) goto L60;
        r19.setWebpImage(r114);
    L60:
        q1 r115 = r13.getLeftLogoGiftImage();
        if (r115 != null) goto L63;
    L72:
        py.k r116 = ModelUtilsKt.a(r110, r13.getLeftLogoGiftImage());
    L73:
        if (r116 == null) goto L75;
        r19.setLeftLogo(r116);
    L75:
        r19.setPrimaryEffectId(r13.getPrimaryEffectId());
        r19.setDuration(r13.getDuration());
        r19.setDescribe(r13.getDescribe());
        r19.setGiftMsgBoard(r13.getGiftMsgBoard());
        r19.setGiftPreviewInfo(r13.getGiftPreviewInfo());
        r19.setAssetIds(r13.getAssetIds());
        r19.setOptionalAssetIds(r13.getOptionalAssetIds());
        r19.setForFansClub(r13.isForFansClub());
        r19.setSelectedDynamicEffect(r13.getSelectedDynamicEffect());
        r19.setAfterSendAction(r13.getAfterSendAction());
        r19.setGiftGroupList(r13.getGiftGroupList());
        r19.setGiftEndingTime(r13.getGiftEndingTime());
        r19.setReqExtraType(r13.getReqExtraType());
        r19.setBannerScheme(r13.getBannerScheme());
        r19.setSpecialEffects(r13.getSpecialEffects());
        r19.setDisplayedOnPanel(r13.isDisplayedOnPanel());
        r19.setTriggerWords(r13.getTriggerWords());
        r19.setGiftSource(r13.getGiftSource());
        r19.setRepeat(r13.getCombo());
        r19.setForFirstRecharge(r13.getForFirstRecharge());
        r19.setSortExtra(r13.getSortExtra());
        goto L77
    L63:
        if (r115.getFetchFrom() != 1) goto L65;
        boolean r117 = true;
    L66:
        if (r117 == true) goto L69;
        r115 = null;
    L69:
        if (r115 == null) goto L72;
        r116 = r115.getImage();
        if (r116 != null) goto L73;
    L65:
        r117 = false;
        goto L66
    L48:
        if (r113.getFetchFrom() != 1) goto L50;
        boolean r118 = true;
    L51:
        if (r118 == true) goto L54;
        r113 = null;
    L54:
        if (r113 == null) goto L57;
        r114 = r113.getImage();
        if (r114 != null) goto L58;
    L50:
        r118 = false;
        goto L51
    L33:
        if (r111.getFetchFrom() != 1) goto L35;
        boolean r119 = true;
    L36:
        if (r119 == true) goto L39;
        r111 = null;
    L39:
        if (r111 == null) goto L42;
        r112 = r111.getImage();
        if (r112 != null) goto L43;
    L35:
        r119 = false;
        goto L36
    L76:
        r19 = null;
    L77:
        if (r19 != null) goto L117;
        c1 r21 = r2.D2().get(Long.valueOf(r13.getId()));
        Intrinsics.checkNotNullParameter(r13, "$this$toGift");
        h1 r120 = (h1) vh7.f.c(h1.class);
        r120.setId(r13.getId());
        r120.setType(r13.getType());
        r120.setName(r13.getName());
        r120.setDiamondCount(r13.getDiamondCount());
        r120.setBizType(r13.getBizType());
        q1 r121 = r13.getGiftImage();
        if (r121 != null) goto L81;
    L90:
        py.k r122 = ModelUtilsKt.a(r21, r13.getGiftImage());
    L91:
        r120.setImage(r122);
        q1 r123 = r13.getWebpGiftImage();
        if (r123 != null) goto L94;
    L103:
        py.k r124 = ModelUtilsKt.a(r21, r13.getWebpGiftImage());
    L104:
        r120.setWebpImage(r124);
        q1 r125 = r13.getLeftLogoGiftImage();
        if (r125 != null) goto L107;
    L115:
        py.k r23 = ModelUtilsKt.a(r21, r13.getLeftLogoGiftImage());
    L116:
        r120.setLeftLogo(r23);
        r120.setPrimaryEffectId(r13.getPrimaryEffectId());
        r120.setDuration(r13.getDuration());
        r120.setDescribe(r13.getDescribe());
        r120.setGiftMsgBoard(r13.getGiftMsgBoard());
        r120.setGiftPreviewInfo(r13.getGiftPreviewInfo());
        r120.setAssetIds(r13.getAssetIds());
        r120.setOptionalAssetIds(r13.getOptionalAssetIds());
        r120.setForFansClub(r13.isForFansClub());
        r120.setSelectedDynamicEffect(r13.getSelectedDynamicEffect());
        r120.setAfterSendAction(r13.getAfterSendAction());
        r120.setGiftGroupList(r13.getGiftGroupList());
        r120.setGiftEndingTime(r13.getGiftEndingTime());
        r120.setReqExtraType(r13.getReqExtraType());
        r120.setBannerScheme(r13.getBannerScheme());
        r120.setSpecialEffects(r13.getSpecialEffects());
        r120.setDisplayedOnPanel(r13.isDisplayedOnPanel());
        r120.setTriggerWords(r13.getTriggerWords());
        r120.setForFirstRecharge(r13.getForFirstRecharge());
        r120.setRepeat(r13.getCombo());
        r120.setGiftSource(r13.getGiftSource());
        r120.setTransformFromLiteGift(true);
        r120.setSortExtra(r13.getSortExtra());
        r19 = r120;
        goto L117
    L107:
        if (r125.getFetchFrom() != 1) goto L109;
        r20 = true;
    L109:
        if (r20 == true) goto L112;
        r125 = null;
    L112:
        if (r125 == null) goto L115;
        r23 = r125.getImage();
        if (r23 != null) goto L116;
    L94:
        if (r123.getFetchFrom() != 1) goto L96;
        boolean r126 = true;
    L97:
        if (r126 == true) goto L100;
        r123 = null;
    L100:
        if (r123 == null) goto L103;
        r124 = r123.getImage();
        if (r124 != null) goto L104;
    L96:
        r126 = false;
        goto L97
    L81:
        if (r121.getFetchFrom() != 1) goto L83;
        boolean r127 = true;
    L84:
        if (r127 == true) goto L87;
        r121 = null;
    L87:
        if (r121 == null) goto L90;
        r122 = r121.getImage();
        if (r122 != null) goto L91;
    L83:
        r127 = false;
    L117:
        r10.add(r19);
        goto L25
    L118:
        r4.setGifts(CollectionsKt.toMutableList(r10));
        goto L18
    L129:
        return;
    L127:
        return;
    L126:
        return;
    L128:
        return;
    L125:
        return;
    }
}
