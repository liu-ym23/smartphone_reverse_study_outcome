package com.bytedance.android.livesdk.interactivity.comment.frequentchat.api;

import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH'J(\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\nH'J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'J2\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\nH'¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/api/FrequentChatApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/d;", "queryFrequentChatList", "Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/e;", "getRecommendChat", BuildConfig.FLAVOR, "sortedIdSeq", "sortFrequentChatList", "content", "Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/a;", "addFrequentChat", "chatId", "removeFrequentChat", "newContent", "updateFrequentChat", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FrequentChatApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static FrequentChatApi a() {
            return (FrequentChatApi) c.b().e(FrequentChatApi.class);
        }
    }

    static {
        a = a.a;
    }

    @FormUrlEncoded
    @POST("/webcast/interaction/add_frequently_chat_content/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.a>> addFrequentChat(@Field("room_id") long r1, @Field("content") String r3);

    @FormUrlEncoded
    @POST("/webcast/interaction/get_recommend_content/")
    Observable<Response<e>> getRecommendChat(@Field("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/interaction/get_frequently_chat_content/")
    Observable<Response<d>> queryFrequentChatList(@Field("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/interaction/del_frequently_chat_content/")
    Observable<Response<Object>> removeFrequentChat(@Field("room_id") long r1, @Field("content_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/interaction/sort_frequently_chat_content/")
    Observable<Response<Object>> sortFrequentChatList(@Field("room_id") long r1, @Field("sorted_id_list") String r3);

    @FormUrlEncoded
    @POST("/webcast/interaction/update_frequently_chat_content/")
    Observable<Response<Object>> updateFrequentChat(@Field("room_id") long r1, @Field("content_id") long r3, @Field("update_content") String r5);
}
