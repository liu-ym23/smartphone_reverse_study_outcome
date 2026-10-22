package com.bytedance.android.ec.common.impl.sku.repository.api;

import com.bytedance.android.ec.common.api.domainselect.IDomainSelect;
import com.bytedance.android.ec.common.impl.sku.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAppointmentResponse;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import jg.c;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0018Jk\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u000bH'¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/api/NewSkuApi;", "", "", "productId", "shopId", "", "price", "marketChannel", "authorId", "secAuthorId", "channelId", "", "channelType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/PromotionAutoApplyCouponResponse;", "applyCouponAuto", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "promotionId", "awemeId", "productExtra", "skuExtra", "type", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAppointmentResponse;", "appointNoStock", "a", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface NewSkuApi {
    public static final a a = null;

    public static final class a {
        public static final NewSkuApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            n r0 = n.a;
            int r1 = c.a;
            int r10 = ECSdk.a;
            IDomainSelect r11 = (IDomainSelect) ECSdk.a(IDomainSelect.class);
            if (r11 == null) goto L12;
            String r12 = r11.selectedHost();
            if (r12 == null) goto L12;
            if (StringsKt.trim(r12).toString().length() <= 0) goto L9;
            boolean r13 = true;
        L10:
            if (r13 == false) goto L12;
        L13:
            a = (NewSkuApi) r0.create(r12, NewSkuApi.class);
            return;
        L9:
            r13 = false;
        L12:
            r12 = "https://aweme.snssdk.com";
            goto L13
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("/aweme/v2/shop/coupon/apply/auto/")
    Observable<PromotionAutoApplyCouponResponse> applyCouponAuto(@Field(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID) String r1, @Field(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID) String r10, @Field("price") long r11, @Field(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL) String r12, @Field(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID) String r13, @Field(com.bytedance.android.ec.core.event.a.KEY_SEC_AUTHOR_ID) String r14, @Field("channel_id") String r15, @Field("channel_type") Integer r16);

    @GET("https://ecom.snssdk.com/aweme/v1/promotion/appoint/")
    Observable<SkuAppointmentResponse> appointNoStock(@Query(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID) String r1, @Query("aweme_id") String r10, @Query("product_extra") String r11, @Query("sku_extra") String r12, @Query("op_type") int r13);
}
