package com.bytedance.android.livesdk.interactivity.comment.share.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.share.model.c;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J*\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/api/InteractivityShareApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a;", "getItemShareList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "shareItemRequest", "Lcom/bytedance/android/livesdk/interactivity/comment/share/model/c;", "shareItem", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface InteractivityShareApi {
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

    @GET("/webcast/interaction/item_share/list/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.comment.share.model.a>> getItemShareList(@Query("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/interaction/item_share/share/")
    Observable<Response<c>> shareItem(@FieldMap Map<String, String> r1);
}
