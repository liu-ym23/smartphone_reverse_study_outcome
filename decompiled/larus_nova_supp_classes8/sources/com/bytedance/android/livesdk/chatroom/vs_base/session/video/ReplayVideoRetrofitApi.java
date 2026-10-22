package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EnterVideoResult;
import com.bytedance.android.livesdkapi.depend.model.live.episode.LivePingExtra;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J~\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\bH'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoRetrofitApi;", "", "enterEpisode", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EnterVideoResult;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/LivePingExtra;", "episodeId", "", "isLogin", "enterSource", "", "enterType", "liveReason", "enterSourceExtra", "isSeek", "videoId", "notNeedMore", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReplayVideoRetrofitApi {
    @FormUrlEncoded
    @POST("/webcast/show/episode/enter/")
    Observable<ExtraResponse<EnterVideoResult, LivePingExtra>> enterEpisode(@Field("episode_id") long r1, @Field("is_login") long r3, @Field("enter_source") String r5, @Field("enter_type") String r6, @Field("live_reason") String r7, @Field("enter_source_extra") String r8, @Field("is_preview") long r9, @Field("video_id") String r11, @Field("ignore_more") long r12);
}
