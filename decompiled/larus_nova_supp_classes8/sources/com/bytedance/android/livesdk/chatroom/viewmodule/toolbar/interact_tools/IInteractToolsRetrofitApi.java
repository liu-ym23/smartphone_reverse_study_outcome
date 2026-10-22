package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.interact_tools;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import dp1.f;
import dp1.g;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/interact_tools/IInteractToolsRetrofitApi;", "", "", "appId", "", "roomId", "", "appType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Ldp1/f;", "reportHistory", "(Ljava/lang/String;JLjava/lang/Integer;)Lio/reactivex/Observable;", "startId", "", "stopAll", "Ldp1/g;", "stopTask", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractToolsRetrofitApi {
    @FormUrlEncoded
    @POST("/webcast/anchor/interaction_plugin/report_history")
    Observable<e<f>> reportHistory(@Field("app_id") String r1, @Field("room_id") long r2, @Field("plugin_type") Integer r4);

    @FormUrlEncoded
    @POST("/webcast/anchor/interaction_plugin/stop_task")
    Observable<e<g>> stopTask(@Field("app_id") String r1, @Field("room_id") long r2, @Field("start_id") String r4, @Field("plugin_type") Integer r5, @Field("stop_all") Boolean r6);
}
