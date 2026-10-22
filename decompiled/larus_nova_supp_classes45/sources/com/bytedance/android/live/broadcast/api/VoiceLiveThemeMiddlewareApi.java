package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.GetLatestBGResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/VoiceLiveThemeMiddlewareApi;", "", "getLatestOfficeBg", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/GetLatestBGResponse;", "bgType", "", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface VoiceLiveThemeMiddlewareApi {
    @GET("/webcast/room/latest_bg/")
    Observable<Response<GetLatestBGResponse>> getLatestOfficeBg(@Query("bg_type") int r1);
}
