package com.larus.reach.impl;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/reach/impl/ReachInappPushApi;", "", "getPushBanner", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/reach/impl/GetInappPushData;", "request", "Lcom/larus/reach/impl/GetInappPushRequest;", "(Lcom/larus/reach/impl/GetInappPushRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
interface ReachInappPushApi {
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

    @POST("/alice/notify/get_inapp_push")
    Object getPushBanner(@Body GetInappPushRequest r1, Continuation<? super BizResponse<GetInappPushData>> r2);
}
