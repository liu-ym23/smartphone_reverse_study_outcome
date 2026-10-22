package com.bytedance.android.livesdk.interactivity.roomnotice.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomnotice/api/RoomNoticeApi;", BuildConfig.FLAVOR, "notice", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "roomId", BuildConfig.FLAVOR, "content", BuildConfig.FLAVOR, "preContent", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RoomNoticeApi {
    @GET("/webcast/room/announcement/?action=1")
    Observable<Response<Object>> notice(@Query("room_id") long r1, @Query("content") String r3, @Query("pre_content") String r4);
}
