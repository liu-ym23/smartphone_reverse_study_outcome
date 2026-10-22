package com.larus.bmhome.view.actionbar.gaokao.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoApi;", "", "getGaokaoProvinceConf", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceConfResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGaokaoZhiyuan", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceZhiyuanResponse;", "request", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoZhiyuanRequest;", "(Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoZhiyuanRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GaokaoApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r10, Continuation r11) {
            FlowHttpConnection r0 = FlowHttpConnection.a;
            return FlowHttpConnection.g("Basic", GaokaoApi.class, r10, false, null, null, null, r11, 248);
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/gaokao/province_conf")
    Object getGaokaoProvinceConf(Continuation<? super BizResponse<GaokaoProvinceConfResponse>> r1);

    @POST("/alice/gaokao/zhiyuan")
    Object getGaokaoZhiyuan(@Body GaokaoZhiyuanRequest r1, Continuation<? super BizResponse<GaokaoProvinceZhiyuanResponse>> r2);
}
