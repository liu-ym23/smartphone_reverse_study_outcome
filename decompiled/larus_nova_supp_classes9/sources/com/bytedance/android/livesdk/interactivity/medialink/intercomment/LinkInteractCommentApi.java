package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.interact.model.c0;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface LinkInteractCommentApi {
    @GET("/webcast/interaction/intercom/close/")
    Single<Response<c0>> intercomClose(@Query("room_id") long r1, @Query("channel_id") long r3);

    @GET("/webcast/interaction/intercom/invite/")
    Single<Response<c0>> intercomInvite(@Query("room_id") long r1, @Query("channel_id") long r3);

    @GET("/webcast/interaction/intercom/reply/")
    Single<Response<c0>> intercomReply(@Query("room_id") long r1, @Query("channel_id") long r3, @Query("reply_status") int r5, @Query("always_reject") boolean r6);
}
