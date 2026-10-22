package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J4\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\nH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/MentionChatApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/b;", "getHistoryMentionChat", BuildConfig.FLAVOR, "needSearch", BuildConfig.FLAVOR, "keyword", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/d;", "getMentionUsers", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MentionChatApi {
    @FormUrlEncoded
    @PbRequest("comment")
    @POST("/webcast/interaction/get_chat_mention_msg/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b>> getHistoryMentionChat(@Field("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/interaction/get_chat_mention_list/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d>> getMentionUsers(@Field("room_id") long r1, @Field("is_nickname_search") boolean r3, @Field("nickname_keyword") String r4);
}
