package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ8\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'J2\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0004H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/MarkUserApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "userId", BuildConfig.FLAVOR, "userOpenId", "actionType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/d;", "markUser", "scene", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/c;", "getUserMarked", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MarkUserApi {
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
    @POST("/webcast/interaction/relation/")
    Observable<Response<c>> getUserMarked(@Field("to_user_id") long r1, @Field("to_user_open_id") String r3, @Field("scene") String r4);

    @FormUrlEncoded
    @POST("/webcast/interaction/mark_user/")
    Observable<BaseResponse<Object, d>> markUser(@Field("to_user_id") long r1, @Field("to_user_open_id") String r3, @Field("action_type") long r4);
}
