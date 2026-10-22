package com.bytedance.android.livesdk.interactivity.api.base;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0004H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/base/InteractionInfoApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "scene", "shortcutEmojiGroup", "requestTag", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/q;", "getInteractionInfo", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface InteractionInfoApi {
    @GET("/webcast/room/interaction/info/")
    Observable<Response<q>> getInteractionInfo(@Query("room_id") long r1, @Query("scene") String r3, @Query("emoji_group") String r4, @Header("x-tt-request-tag") String r5);
}
