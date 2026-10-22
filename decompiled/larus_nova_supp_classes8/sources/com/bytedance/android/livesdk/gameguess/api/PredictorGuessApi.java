package com.bytedance.android.livesdk.gameguess.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.gameguess.model.a;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface PredictorGuessApi {
    public static final Integer a = null;
    public static final Integer b = null;

    static {
        a = 0;
        b = 1;
    }

    @FormUrlEncoded
    @POST("/webcast/quiz/game_room/")
    Observable<e<a>> requestIsGameRoomByMergeTag(@Field("room_id") String r1, @Field("is_anchor") boolean r2, @Field("enter_from") Integer r3);
}
