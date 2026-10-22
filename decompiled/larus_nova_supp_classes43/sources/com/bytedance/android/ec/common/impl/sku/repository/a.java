package com.bytedance.android.ec.common.impl.sku.repository;

import com.bytedance.android.ec.common.impl.sku.repository.dto.AddCartResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.CommonSkusUpdateRequest;
import com.bytedance.android.ec.common.impl.sku.repository.dto.CommonSkusUpdateResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuCheckPayNotificationResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.model.sku.SkuParams;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    Observable<CommonSkusUpdateResponse> a(CommonSkusUpdateRequest r1);

    Observable<PromotionAutoApplyCouponResponse> applyCouponAuto(String r1, String r10, long r11, String r12, String r13, String r14, String r15, Integer r16);

    Observable<String> b(String r1, String r10, String r11, String r12, String r13, int r14, String r15);

    Observable c(String r1, String r10, String r11, String r12);

    Observable<SkuCheckPayNotificationResponse> checkPayNotification(String r1, String r10, String r11);

    Observable<SkuCheckPayNotificationResponse> checkSkuPayNotification(String r1, String r10, String r11, String r12);

    Observable<SkuInfoResponseDTO> d(SkuParams r1);

    Observable e(String r1, String r10, String r11, long r12, long r13, String r14, String r15, String r16, String r17, String r18);

    Observable<AddCartResponse> f(String r1, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, int r111, String r112);
}
