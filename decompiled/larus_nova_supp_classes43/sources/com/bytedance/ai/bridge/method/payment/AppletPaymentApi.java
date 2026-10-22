package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.method.payment.bean.CreateSignOrderRequest;
import com.bytedance.ai.bridge.method.payment.bean.CreateSignOrderResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetPlatformSignInfoRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetPlatformSignInfoResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataResponse;
import com.bytedance.ai.bridge.method.payment.bean.RequestOrderRequest;
import com.bytedance.ai.bridge.method.payment.bean.RequestOrderResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0015H'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/AppletPaymentApi;", "", "requestOrder", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/ai/bridge/method/payment/bean/RequestOrderResponse;", "body", "Lcom/bytedance/ai/bridge/method/payment/bean/RequestOrderRequest;", "getOrderPayment", "Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentResponse;", "Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentRequest;", "getOrderPaymentWithSign", "Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentWithSignResponse;", "Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentWithSignRequest;", "createSignOrder", "Lcom/bytedance/ai/bridge/method/payment/bean/CreateSignOrderResponse;", "Lcom/bytedance/ai/bridge/method/payment/bean/CreateSignOrderRequest;", "getSignPageData", "Lcom/bytedance/ai/bridge/method/payment/bean/GetSignPageDataResponse;", "Lcom/bytedance/ai/bridge/method/payment/bean/GetSignPageDataRequest;", "getPlatformSignInfo", "Lcom/bytedance/ai/bridge/method/payment/bean/GetPlatformSignInfoResponse;", "Lcom/bytedance/ai/bridge/method/payment/bean/GetPlatformSignInfoRequest;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppletPaymentApi {
    @POST("/user/trade/create_sign_order")
    Call<CreateSignOrderResponse> createSignOrder(@Body CreateSignOrderRequest r1);

    @POST("/user/trade/get_order_payment")
    Call<GetOrderPaymentResponse> getOrderPayment(@Body GetOrderPaymentRequest r1);

    @POST("/user/trade/get_order_payment_with_sign")
    Call<GetOrderPaymentWithSignResponse> getOrderPaymentWithSign(@Body GetOrderPaymentWithSignRequest r1);

    @POST("/api/v1/trade/get_platform_sign_info")
    Call<GetPlatformSignInfoResponse> getPlatformSignInfo(@Body GetPlatformSignInfoRequest r1);

    @POST("/user/trade/get_sign_page_data")
    Call<GetSignPageDataResponse> getSignPageData(@Body GetSignPageDataRequest r1);

    @POST("/user/trade/request_order")
    Call<RequestOrderResponse> requestOrder(@Body RequestOrderRequest r1);
}
