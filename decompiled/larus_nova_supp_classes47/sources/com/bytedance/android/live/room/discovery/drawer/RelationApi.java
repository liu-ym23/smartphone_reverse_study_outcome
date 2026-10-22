package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.retrofit2.http.GET;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface RelationApi {
    @GET("/webcast/distribution/more_live_relation_show/")
    Observable<BaseResponse<Room, h>> getRelationShow();
}
