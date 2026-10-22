package com.bytedance.android.live.broadcast.api.share;

import com.bytedance.android.live.broadcast.api.model.l1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/share/ShareListApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcast/api/model/l1;", "getAnchorShareList", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ShareListApi {
    @PbRequest
    @POST("/webcast/room/share/list/")
    Observable<Response<l1>> getAnchorShareList();
}
