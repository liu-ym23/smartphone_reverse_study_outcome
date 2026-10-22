package com.bytedance.android.live.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionResponseData;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionResponseDataSingle;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J2\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/api/MatchShareApi;", "", "getCollectionDataByCollectionId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionResponseDataSingle;", "collectionId", "", "episodeId", "getCollectionList", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionResponseData;", "roomId", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MatchShareApi {
    @FormUrlEncoded
    @POST("/webcast/show/episode/match/collection/get/")
    Observable<Response<CollectionResponseDataSingle>> getCollectionDataByCollectionId(@Field("collection_id") String r1, @Field("episode_id") String r2);

    @FormUrlEncoded
    @POST("/webcast/show/episode/match/collection/list/")
    Observable<Response<CollectionResponseData>> getCollectionList(@Field("room_id") String r1, @Field("episode_id") String r2);
}
