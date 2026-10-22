package com.bytedance.android.live.liveinteract.channel.api;

import ce0.a;
import ce0.b;
import ce0.c;
import ce0.d;
import com.bytedance.android.live.liveinteract.linksecurity.CheckAudienceLinkersResponse;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.link.model.u3;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H'J<\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H'J(\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'J(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'J<\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'J2\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0005H'J2\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0005H'J2\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'J(\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'J(\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'J2\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0005H'J<\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00052\b\b\u0001\u0010\u001f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'JP\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\"2\b\b\u0001\u0010$\u001a\u00020\"2\b\b\u0001\u0010%\u001a\u00020\"2\b\b\u0001\u0010&\u001a\u00020\"2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/liveinteract/channel/api/IChannelLinkApi;", "", "", "roomId", "roomChannelId", "", "roomChannelOwnerSecId", "toUserSecId", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/Response;", "Lce0/c;", "linkMicSilence", "Lce0/d;", "linkMicUnSilence", "channelId", "Lce0/a;", "linkMicApply", "Ljava/lang/Void;", "linkMicApplyCancel", "toSecUserId", "", "isPermit", "linkMicApplyReply", "linkMicInvite", "linkMicInviteCancel", "linkMicInviteReply", "Lce0/b;", "linkMicJoinChannel", "linkMicExitChannel", "linkMicKickOut", "linkmicIdList", "requestSource", "Lcom/bytedance/android/livesdk/link/model/u3;", "checkChannelLinkers", "", "linkType", "silenceStatus", "audioCaptureType", "audioPublishType", "Lcom/bytedance/android/live/liveinteract/linksecurity/CheckAudienceLinkersResponse;", "checkChannelAudienceLinkers", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IChannelLinkApi {
    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_channel/check_audience_linkers/")
    Single<Response<CheckAudienceLinkersResponse>> checkChannelAudienceLinkers(@Field("room_id") long r1, @Field("link_type") int r3, @Field("silence_status") int r4, @Field("audio_capture_type") int r5, @Field("audio_publish_status") int r6, @Field("room_channel_id") long r7);

    @FormUrlEncoded
    @POST("/webcast/linkmic_channel/check_linkers/")
    Single<Response<u3>> checkChannelLinkers(@Field("room_id") long r1, @Field("linkmic_id_list") String r3, @Field("request_source") String r4, @Field("room_channel_id") long r5);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_apply/")
    Single<Response<a>> linkMicApply(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_apply_cancel/")
    Single<Response<Void>> linkMicApplyCancel(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_apply_reply/")
    Single<Response<Void>> linkMicApplyReply(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("sec_user_id") String r5, @Field("is_permit") boolean r6);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_exit_channel/")
    Single<Response<Void>> linkMicExitChannel(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_invite/")
    Single<Response<Void>> linkMicInvite(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("sec_user_id") String r5);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_invite_cancel/")
    Single<Response<Void>> linkMicInviteCancel(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("sec_user_id") String r5);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_invite_reply/")
    Single<Response<Void>> linkMicInviteReply(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("is_permit") boolean r5);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_join_channel/")
    Single<Response<b>> linkMicJoinChannel(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/linkmic_kick_out/")
    Single<Response<Void>> linkMicKickOut(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("sec_user_id") String r5);

    @FormUrlEncoded
    @POST("/webcast/linkmic_channel/silence/")
    Single<Response<c>> linkMicSilence(@Field("room_id") long r1, @Field("room_channel_id") long r3, @Field("sec_room_channel_owner_id") String r5, @Field("to_sec_user_id") String r6);

    @FormUrlEncoded
    @POST("/webcast/linkmic_channel/unsilence/")
    Single<Response<d>> linkMicUnSilence(@Field("room_id") long r1, @Field("room_channel_id") long r3, @Field("sec_room_channel_owner_id") String r5, @Field("to_sec_user_id") String r6);
}
