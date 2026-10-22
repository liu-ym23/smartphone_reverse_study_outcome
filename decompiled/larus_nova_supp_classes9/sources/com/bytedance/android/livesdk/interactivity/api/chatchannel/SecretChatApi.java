package com.bytedance.android.livesdk.interactivity.api.chatchannel;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.i;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.l;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0013Ji\u0010\u000e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\t\u001a\u00020\u0005H'¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b`\r2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/SecretChatApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "toUid", BuildConfig.FLAVOR, "content", "type", "replyMsgId", "pasteEditMethod", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/l;", "Lcom/bytedance/revenue/platform/api/core/rx/Observable;", "sendSecretChat", "(JJLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/i;", "getHistorySecretChat", "(Ljava/lang/Long;Ljava/lang/Long;)Lio/reactivex/Observable;", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SecretChatApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @FormUrlEncoded
    @POST("/webcast/interaction/get_secret_chat_msg/")
    Observable<Response<i>> getHistorySecretChat(@Field("room_id") Long r1, @Field("to_uid") Long r2);

    @FormUrlEncoded
    @POST("/webcast/room/secret_chat/")
    Observable<Response<l>> sendSecretChat(@Field("room_id") long r1, @Field("to_uid") long r3, @Field("content") String r5, @Field("type") long r6, @Field("reply_msg_id") Long r8, @Field("paste_edit_method") String r9);
}
