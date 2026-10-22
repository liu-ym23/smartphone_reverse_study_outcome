package com.bytedance.android.live.broadcastgame.opengame.cloudgame.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/cloudgame/api/LiveCloudGameApi;", "", "", "from_scene", "to_scene", "", "applet_app_id", "game_id", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "switchSceneRequest", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveCloudGameApi {
    @FormUrlEncoded
    @POST("/aweme/cloudgaming/switch_scene/")
    Observable<e<?>> switchSceneRequest(@Field("from_scene") long r1, @Field("to_scene") long r3, @Field("applet_app_id") String r5, @Field("game_id") String r6);
}
