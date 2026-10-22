package com.bytedance.android.live.room.api.draggablecomponent;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/api/draggablecomponent/DraggableComponentApi;", "", "closeEcomAnchorTeleprompter", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Ljava/lang/Object;", "operate", "", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DraggableComponentApi {
    @POST("https://lianmengapi.snssdk.com/live/seller/prompt/switch/")
    Observable<Response<Object>> closeEcomAnchorTeleprompter(@Query("operate") int r1);
}
