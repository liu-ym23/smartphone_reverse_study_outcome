package com.larus.dispatcher.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/dispatcher/api/GetAllDevicesApi;", "", "requestDispatchAllDevices", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authorizeDevice", "request", "Lcom/larus/dispatcher/api/AuthorizeDeviceRequest;", "(Lcom/larus/dispatcher/api/AuthorizeDeviceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GetAllDevicesApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/dispatch/authorize/device")
    Object authorizeDevice(@Body AuthorizeDeviceRequest r1, Continuation<? super BizResponse<BizResponse<AllDeviceResponse>>> r2);

    @GET("/alice/dispatch/all_devices")
    Object requestDispatchAllDevices(Continuation<? super BizResponse<AllDeviceResponse>> r1);
}
