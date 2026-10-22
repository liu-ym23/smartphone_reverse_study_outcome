package com.bytedance.android.ec.common.impl.sku.repository;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.common.impl.sku.repository.api.NewSkuApi;
import com.bytedance.android.ec.common.impl.sku.repository.api.SkuApi;
import com.bytedance.android.ec.common.impl.sku.repository.dto.AddCartResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.CommonSkusUpdateRequest;
import com.bytedance.android.ec.common.impl.sku.repository.dto.CommonSkusUpdateResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAppointmentResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuCheckPayNotificationResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInstallmentItemResponse;
import com.bytedance.android.ec.core.abtest.d;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SkuRepository implements a {
    public final eg.a a;

    public SkuRepository() {
        this.a = new eg.a();
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<CommonSkusUpdateResponse> a(CommonSkusUpdateRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "request");
        SkuApi.a.getClass();
        SkuApi r0 = SkuApi.a.a;
        if (r0 == null) goto L7;
        Observable<CommonSkusUpdateResponse> r11 = r0.commonSkuUpdate(r10.getSelectedNum(), r10.getParam());
        if (r11 == null) goto L7;
        return r11;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<SkuInfoResponseDTO> d(final SkuParams r37) {
        Intrinsics.checkNotNullParameter(r37, "params");
        int r1 = ECSdk.a;
        IVisitUnit r10 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r10 == null) goto L5;
        r10.hookToDirectCall(VisitActions.SKU_REQ_COMMON_SKU.getKey(), new SkuRepository$getSkuInfo$1(r37));
    L5:
        eg.a r11 = this.a;
        String r12 = r37.getPromotionId();
        String r13 = r37.getProductId();
        String r14 = r37.getAuthorId();
        String r15 = r37.getAuthorOpenId();
        String r16 = r37.getSecAuthorId();
        String r17 = r37.getRoomId();
        if (r37.isGroupingBuy() == false) goto L8;
        long r18 = 1;
    L9:
        int r19 = r37.getSceneType();
        int r110 = r37.getActionType();
        String r111 = r37.getReceiveAddressId();
        SkuExtraData r112 = r37.getSkuExtraData();
        String r113 = null;
        if (r112 == null) goto L12;
        String r114 = r112.getMarketChannel();
    L13:
        String r115 = r37.getEntranceInfo();
        String r116 = r37.getCombinationId();
        String r20 = u0.d(r37.getDefaultSelect());
        String r21 = r37.getSelectCarId();
        String r34 = r37.getItemId();
        String r35 = r37.getEnterFrom();
        JSONObject r117 = new JSONObject();
        r117.put("is_multi", true);
        ECAdLogExtra r0 = r37.getAdLogExtra();
        if (r0 == null) goto L16;
        r113 = r0.getCreativeId();
    L16:
        r117.putOpt(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r113);
        r117.putOpt("cps_track", r37.getCpsTrack());
        String r22 = r117.toString();
        String r23 = r37.getExtraParams();
        String r24 = r37.getChannelId();
        Integer r25 = r37.getChannelType();
        Integer r26 = r37.getHeightPercent();
        Integer r27 = Integer.valueOf(d.F());
        Integer r28 = r37.getSpecMode();
        Long r29 = r37.getSpecModeTime();
        String r30 = r37.getAddressDetail();
        String r31 = r37.getBizCampaignType();
        Integer r32 = r37.getTouTiaoAppId();
        String r33 = r37.getNGroupBuyToken();
        r11.getClass();
        return eg.a.c(r12, r13, r14, r15, r16, r17, r18, r19, r110, 1, r111, r114, r115, r116, r20, r21, r34, r35, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
    L12:
        r114 = null;
        goto L13
    L8:
        r18 = 0;
        goto L9
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<SkuCheckPayNotificationResponse> checkPayNotification(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "promotionIds");
        Intrinsics.checkNotNullParameter(r11, "authorId");
        Intrinsics.checkNotNullParameter(r12, "secAuthorId");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "promotionIds");
        Intrinsics.checkNotNullParameter(r11, "authorId");
        Intrinsics.checkNotNullParameter(r12, "secAuthorId");
        SkuApi.a.getClass();
        SkuApi r0 = SkuApi.a.a;
        if (r0 == null) goto L7;
        Observable<SkuCheckPayNotificationResponse> r13 = r0.checkPayNotification(r10, r11, r12);
        if (r13 == null) goto L7;
        return r13;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable c(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "productId");
        Intrinsics.checkNotNullParameter(r11, "awemeId");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "productId");
        Intrinsics.checkNotNullParameter(r11, "awemeId");
        NewSkuApi.a.getClass();
        NewSkuApi r0 = NewSkuApi.a.a;
        if (r0 == null) goto L7;
        Observable<SkuAppointmentResponse> r14 = r0.appointNoStock(r10, r11, r12, r13, 3);
        if (r14 == null) goto L7;
        return r14;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<SkuCheckPayNotificationResponse> checkSkuPayNotification(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "promotionId");
        Intrinsics.checkNotNullParameter(r11, "skuId");
        Intrinsics.checkNotNullParameter(r12, "authorId");
        Intrinsics.checkNotNullParameter(r13, "secAuthorId");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "promotionId");
        Intrinsics.checkNotNullParameter(r11, "skuId");
        Intrinsics.checkNotNullParameter(r12, "authorId");
        Intrinsics.checkNotNullParameter(r13, "secAuthorId");
        SkuApi.a.getClass();
        SkuApi r0 = SkuApi.a.a;
        if (r0 == null) goto L7;
        Observable<SkuCheckPayNotificationResponse> r14 = r0.checkSkuPayNotification(r10, r11, r12, r13);
        if (r14 == null) goto L7;
        return r14;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<String> b(final String r17, final String r18, final String r19, final String r20, final String r21, final int r22, final String r23) {
        Intrinsics.checkNotNullParameter(r17, "productId");
        Intrinsics.checkNotNullParameter(r18, "comboId");
        Intrinsics.checkNotNullParameter(r19, "comboNum");
        Intrinsics.checkNotNullParameter(r20, "extra");
        Intrinsics.checkNotNullParameter(r21, "channelId");
        int r0 = ECSdk.a;
        IVisitUnit r1 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r1 == null) goto L5;
        r1.hookToDirectCall(VisitActions.SKU_REQ_ADD_CART.getKey(), new SkuRepository$addShopCartNewString$1(r17, r18, r19, r20, r21, r22, r23));
    L5:
        eg.a r10 = this.a;
        int r11 = eg.a.a;
        r10.getClass();
        return eg.a.b(r17, r18, r19, r20, r21, r22, r23, null, null);
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<PromotionAutoApplyCouponResponse> applyCouponAuto(String r12, String r13, long r14, String r16, String r17, String r18, String r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r12, "productId");
        Intrinsics.checkNotNullParameter(r13, "shopId");
        Intrinsics.checkNotNullParameter(r17, "authorId");
        Intrinsics.checkNotNullParameter(r18, "secAuthorId");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "productId");
        Intrinsics.checkNotNullParameter(r13, "shopId");
        Intrinsics.checkNotNullParameter(r17, "authorId");
        Intrinsics.checkNotNullParameter(r18, "secAuthorId");
        NewSkuApi.a.getClass();
        NewSkuApi r0 = NewSkuApi.a.a;
        if (r0 == null) goto L7;
        Observable<PromotionAutoApplyCouponResponse> r1 = r0.applyCouponAuto(r12, r13, r14, r16, r17, r18, r19, r20);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable e(String r19, String r20, String r21, long r22, long r24, String r26, String r27, String r28, String r29, String r30) {
        Intrinsics.checkNotNullParameter(r19, "promotionId");
        Intrinsics.checkNotNullParameter(r20, "productId");
        Intrinsics.checkNotNullParameter(r21, "skuId");
        Intrinsics.checkNotNullParameter(r26, "authorId");
        Intrinsics.checkNotNullParameter(r27, "secAuthorId");
        Intrinsics.checkNotNullParameter(r28, "marketChannel");
        Intrinsics.checkNotNullParameter(r29, "sceneId");
        Intrinsics.checkNotNullParameter(r30, BdpAwemeConstant.KEY_ROOM_ID);
        eg.a r15 = this.a;
        Integer r17 = Integer.valueOf(d.F());
        r15.getClass();
        Intrinsics.checkNotNullParameter(r19, "promotionId");
        Intrinsics.checkNotNullParameter(r20, "productId");
        Intrinsics.checkNotNullParameter(r21, "skuId");
        Intrinsics.checkNotNullParameter(r26, "authorId");
        Intrinsics.checkNotNullParameter(r27, "secAuthorId");
        Intrinsics.checkNotNullParameter(r28, "marketChannel");
        Intrinsics.checkNotNullParameter(r29, "sceneId");
        Intrinsics.checkNotNullParameter(r30, BdpAwemeConstant.KEY_ROOM_ID);
        SkuApi.a.getClass();
        SkuApi r0 = SkuApi.a.a;
        if (r0 == null) goto L7;
        Observable<SkuInstallmentItemResponse> r1 = r0.getSkuInstallmentInfo(r19, r20, r21, r22, r24, r26, r27, r28, r29, r30, r17);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    @Override // com.bytedance.android.ec.common.impl.sku.repository.a
    public final Observable<AddCartResponse> f(final String r20, final String r21, final String r22, final String r23, final String r24, final String r25, final String r26, final String r27, final String r28, final String r29, final String r30, final String r31, final int r32, final String r33) {
        Intrinsics.checkNotNullParameter(r20, "promotionId");
        Intrinsics.checkNotNullParameter(r21, "productId");
        Intrinsics.checkNotNullParameter(r22, "originType");
        Intrinsics.checkNotNullParameter(r23, "originId");
        Intrinsics.checkNotNullParameter(r24, "comboId");
        Intrinsics.checkNotNullParameter(r25, "comboNum");
        Intrinsics.checkNotNullParameter(r26, "specDesc");
        Intrinsics.checkNotNullParameter(r27, "deviceId");
        Intrinsics.checkNotNullParameter(r28, "extra");
        Intrinsics.checkNotNullParameter(r29, "authorId");
        Intrinsics.checkNotNullParameter(r30, "secAuthorId");
        Intrinsics.checkNotNullParameter(r31, "channelId");
        int r0 = ECSdk.a;
        IVisitUnit r1 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r1 == null) goto L5;
        r1.hookToDirectCall(VisitActions.SKU_REQ_ADD_CART.getKey(), new SkuRepository$addShopCart$1(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33));
    L5:
        eg.a r10 = this.a;
        int r11 = eg.a.a;
        r10.getClass();
        return eg.a.a(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, null, null);
    }
}
