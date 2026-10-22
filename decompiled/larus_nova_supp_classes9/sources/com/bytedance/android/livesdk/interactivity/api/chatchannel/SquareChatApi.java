package com.bytedance.android.livesdk.interactivity.api.chatchannel;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.g;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011JB\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'JA\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b`\n2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/SquareChatApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "content", "pasteEditMethod", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/square/g;", "Lcom/bytedance/revenue/platform/api/core/rx/Observable;", "sendSquareChat", BuildConfig.FLAVOR, "scene", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/square/a;", "getSquareTabChat", "(Ljava/lang/Long;I)Lio/reactivex/Observable;", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SquareChatApi {
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
    @POST("/webcast/interaction/get_world_chat_msg/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.a>> getSquareTabChat(@Field("room_id") Long r1, @Field("scene") int r2);

    @FormUrlEncoded
    @POST("/webcast/room/world_chat/")
    Observable<Response<g>> sendSquareChat(@Field("room_id") long r1, @Field("content") String r3, @Field("paste_edit_method") String r4);
}
