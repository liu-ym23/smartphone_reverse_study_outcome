package com.bytedance.android.livesdk.interactivity.api.comment;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdk.interactivity.api.comment.data.a;
import com.bytedance.android.livesdk.interactivity.api.comment.data.c;
import com.bytedance.android.livesdk.interactivity.api.comment.data.g;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JL\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\b2(\b\u0001\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'J:\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H'J@\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t0\b2(\b\u0001\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H'JJ\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t0\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00102(\b\u0001\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H'JB\u0010\u0018\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\t\u0018\u00010\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u00102\b\b\u0001\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\u0016\u001a\u00020\u0015H'¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/CommentApi;", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "map", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/a;", "sendAudioMessage", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/c;", "sendBarrage", "Lcom/bytedance/android/livesdk/chatroom/model/v0;", "sendTextMessage", BuildConfig.FLAVOR, "roomId", "sendSpecialTextMessage", "itemId", "itemType", BuildConfig.FLAVOR, "type", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/g;", "videoPinShare", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CommentApi {
    @POST("/webcast/room/audio_chat/")
    Observable<Response<a>> sendAudioMessage(@QueryMap HashMap<String, String> r1, @Body TypedOutput r2);

    @FormUrlEncoded
    @POST("/webcast/screen_chat/")
    Observable<Response<c>> sendBarrage(@FieldMap HashMap<String, String> r1);

    @FormUrlEncoded
    @POST("/webcast/room/special_chat/{room_id}")
    Observable<Response<v0>> sendSpecialTextMessage(@Path("room_id") long r1, @FieldMap HashMap<String, String> r3);

    @FormUrlEncoded
    @PbRequest("comment")
    @POST("/webcast/room/chat/")
    Observable<Response<v0>> sendTextMessage(@FieldMap HashMap<String, String> r1);

    @FormUrlEncoded
    @POST("/webcast/room/video_share/")
    Observable<Response<g>> videoPinShare(@Field("room_id") long r1, @Field("item_id") long r3, @Field("item_type") long r5, @Field("type") int r7);
}
