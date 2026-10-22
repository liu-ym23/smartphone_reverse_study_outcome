package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/LiveWatchLaterApi;", "", "", "roomId", "", "reqFrom", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/b;", "addWatchLater", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/d;", "cancelWatchLater", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveWatchLaterApi {
    @GET("/webcast/distribution/add_watch_later/")
    Observable<b> addWatchLater(@Query("room_id") long r1, @Query("req_from") String r3);

    @GET("/webcast/distribution/cancel_watch_later/")
    Observable<d> cancelWatchLater(@Query("room_id") long r1, @Query("req_from") String r3);
}
