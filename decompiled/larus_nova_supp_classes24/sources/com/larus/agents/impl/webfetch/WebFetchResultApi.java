package com.larus.agents.impl.webfetch;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/agents/impl/webfetch/WebFetchResultApi;", "", "report", "Lcom/larus/agents/impl/webfetch/WebFetchResultAck;", "request", "Lcom/larus/agents/impl/webfetch/WebFetchResultRequest;", "(Lcom/larus/agents/impl/webfetch/WebFetchResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface WebFetchResultApi {
    @POST("/alice/dispatch/send_command_result")
    Object report(@Body s r1, Continuation<? super m> r2);
}
