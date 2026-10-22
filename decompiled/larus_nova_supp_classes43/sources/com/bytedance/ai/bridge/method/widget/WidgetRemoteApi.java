package com.bytedance.ai.bridge.method.widget;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/widget/WidgetRemoteApi;", "", "updateCardInstance", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "request", "Lcom/bytedance/ai/bridge/method/widget/UpdateCardInstanceRequest;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface WidgetRemoteApi {
    @POST("/alice/mini_program/update_card_instance")
    Call<p4.a> updateCardInstance(@Body a r1);
}
