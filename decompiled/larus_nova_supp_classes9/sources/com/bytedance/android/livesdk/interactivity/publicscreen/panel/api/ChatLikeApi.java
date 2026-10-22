package com.bytedance.android.livesdk.interactivity.publicscreen.panel.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.b;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011JB\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'J7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0007j\b\u0012\u0004\u0012\u00020\u000e`\n2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/api/ChatLikeApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "msgId", BuildConfig.FLAVOR, "option", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/model/a;", "Lcom/bytedance/revenue/platform/api/core/rx/Observable;", "ChatOption", BuildConfig.FLAVOR, "msgIdList", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/model/b;", "getChatMsgStatus", "(Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ChatLikeApi {
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
    @POST("/webcast/room/chat_option/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a>> ChatOption(@Field("room_id") long r1, @Field("msg_id") long r3, @Field("option") int r5);

    @FormUrlEncoded
    @POST("/webcast/room/chat_option_status/")
    Observable<b> getChatMsgStatus(@Field("room_id") Long r1, @Field("msg_id_list") String r2);
}
