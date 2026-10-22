package com.bytedance.android.livesdk.dislike.preload.loader.watchlater;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/preload/loader/watchlater/LongPanelControlApi;", "", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/dislike/preload/loader/watchlater/c;", "requestLongPanelData", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LongPanelControlApi {
    @GET("/webcast/preview/more_panel/")
    Observable<c> requestLongPanelData(@Query("room_id") long r1);
}
