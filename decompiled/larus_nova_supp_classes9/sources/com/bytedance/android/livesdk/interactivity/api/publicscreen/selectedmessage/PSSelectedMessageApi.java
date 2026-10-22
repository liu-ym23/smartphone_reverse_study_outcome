package com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/selectedmessage/PSSelectedMessageApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "scene", "status", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "sendShowStatusChange", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PSSelectedMessageApi {
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
    @POST("/webcast/interaction/set_featured_public_screen_setting/")
    Observable<Response<Object>> sendShowStatusChange(@Field("room_id") long r1, @Field("scene") String r3, @Field("featured_public_screen_status") long r4);
}
