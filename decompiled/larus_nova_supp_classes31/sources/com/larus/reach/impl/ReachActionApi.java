package com.larus.reach.impl;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/reach/impl/ReachActionApi;", "", "sendCommonRequest", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/reach/impl/ReachActionResponse;", "request", "Lcom/larus/reach/impl/ReachActionRequest;", "(Lcom/larus/reach/impl/ReachActionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
interface ReachActionApi {
    @POST("/biz/experience/common_request")
    Object sendCommonRequest(@Body ReachActionRequest r1, Continuation<? super BizResponse<ReachActionResponse>> r2);
}
