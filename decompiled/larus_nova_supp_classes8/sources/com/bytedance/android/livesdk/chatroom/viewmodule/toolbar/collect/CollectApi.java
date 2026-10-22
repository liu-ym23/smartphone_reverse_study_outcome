package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.collect;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/collect/CollectApi;", "", "collect", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "episodeId", "", "seasonId", "actionType", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CollectApi {
    @FormUrlEncoded
    @POST("/webcast/show/collect/")
    Observable<Response<Object>> collect(@Field("episode_id") long r1, @Field("season_id") long r3, @Field("action_type") int r5);
}
