package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.GameSuggestionResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.a;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface BroadcastFloatWindowSuggestionApi {
    @FormUrlEncoded
    @POST("/webcast/game/creator_ai/float_window_setting/")
    Observable<Response<GameSuggestionResponse>> gameSuggestionSetting(@Field("room_id") Long r1);

    @FormUrlEncoded
    @POST("/webcast/game/creator_ai/upsert_float_window_setting/")
    Observable<a> gameSuggestionUpsert(@Field("room_id") Long r1, @Field("is_open_suggestion") Boolean r2);
}
