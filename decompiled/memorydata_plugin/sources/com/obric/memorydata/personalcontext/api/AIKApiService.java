package com.obric.memorydata.personalcontext.api;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0001H'¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/AIKApiService;", "", "modelService", "Lcom/bytedance/retrofit2/Call;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/personalcontext/api/AIKModelRequest;", "any", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AIKApiService {
    @Headers({"Content-Type:application/json"})
    @POST("/ocean/device_intelligence/chat")
    Call<Object> modelService(@Body AIKModelRequest r1, @ExtraInfo Object r2);
}
