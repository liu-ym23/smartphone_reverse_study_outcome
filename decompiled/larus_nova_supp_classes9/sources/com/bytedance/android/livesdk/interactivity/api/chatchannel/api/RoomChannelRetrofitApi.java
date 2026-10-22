package com.bytedance.android.livesdk.interactivity.api.chatchannel.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.d;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J_\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0012\u0010\u0013J<\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010\u0016\u001a\u00020\u0004H'J(\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'J<\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00142\b\b\u0001\u0010\u001b\u001a\u00020\u0014H'J(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'J<\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u001f2\b\b\u0001\u0010!\u001a\u00020\u001fH'J(\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'Jd\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00142\b\b\u0001\u0010'\u001a\u00020\u001f2\b\b\u0001\u0010(\u001a\u00020\u00022\b\b\u0001\u0010)\u001a\u00020\u00142\b\b\u0001\u0010*\u001a\u00020\u00142\b\b\u0001\u0010+\u001a\u00020\u0014H'J<\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010.\u001a\u00020\u00042\b\b\u0001\u0010/\u001a\u00020\u0004H'J<\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u0007042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u001f2\b\b\u0001\u00102\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0014H'J2\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0014H'¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/api/RoomChannelRetrofitApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "closeLinkMic", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/f;", "createChannel", "inviteId", "channelId", "channelCreateType", "fansChannelType", "groupId", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/a;", "accessChannel", "(JJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lio/reactivex/Observable;", "applyChannel", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lio/reactivex/Observable;", BuildConfig.FLAVOR, "secUid", "isPermit", "replyAccessChannel", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/g;", "disbandChannel", "userId", "secId", "kickOutChannel", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/k;", "quitChannel", BuildConfig.FLAVOR, "offset", "limit", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/h;", "getChannelUserList", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/j;", "inviteChannel", "content", "type", "emojiId", "imEmojiDisplayName", "rtfContent", "pasteEditMethod", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/b;", "channelChat", "linkMicSwitch", "memberInviteSwitch", "updateSetting", "linkType", "roomChannelId", "roomChannelOwnerId", "Lio/reactivex/Single;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/d;", "getRtcInfo", "inviteItemString", "inviteMessage", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RoomChannelRetrofitApi {

    public static final class a {
        public static /* synthetic */ Observable a(RoomChannelRetrofitApi r13, long r14, long r15, Long r17, Long r18, Long r19, Long r20, int r21) {
            if ((r21 & 2) == 0) goto L5;
            long r6 = 0;
        L7:
            if ((r21 & 4) == 0) goto L9;
            Long r8 = 0L;
        L11:
            if ((r21 & 8) == 0) goto L13;
            Long r9 = 0L;
        L15:
            if ((r21 & 16) == 0) goto L17;
            Long r10 = 0L;
        L19:
            if ((r21 & 32) == 0) goto L21;
            Long r11 = 0L;
        L23:
            return r13.accessChannel(r14, r6, r8, r9, r10, r11);
        L21:
            r11 = r20;
            goto L23
        L17:
            r10 = r19;
            goto L19
        L13:
            r9 = r18;
            goto L15
        L9:
            r8 = r17;
            goto L11
        L5:
            r6 = r15;
            goto L7
        }
    }

    @FormUrlEncoded
    @POST("/webcast/room_channel/access/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.a>> accessChannel(@Field("room_id") long r1, @Field("invite_id") long r3, @Field("channel_id") Long r5, @Field("channel_create_type") Long r6, @Field("fans_channel_type") Long r7, @Field("group_id") Long r8);

    @FormUrlEncoded
    @POST("/webcast/room_channel/apply/")
    Observable<Response<Object>> applyChannel(@Field("room_id") Long r1, @Field("channel_id") Long r2, @Field("fans_channel_type") Long r3, @Field("group_id") Long r4);

    @FormUrlEncoded
    @POST("/webcast/room_channel/chat/")
    Observable<Response<b>> channelChat(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("content") String r5, @Field("type") int r6, @Field("emoji_id") long r7, @Field("interactive_emoji_display_name") String r9, @Field("rtf_content") String r10, @Field("paste_edit_method") String r11);

    @FormUrlEncoded
    @POST("/webcast/room_channel/create/")
    Observable<Response<f>> createChannel(@Field("room_id") long r1, @Field("close_link_mic") boolean r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/disband/")
    Observable<Response<g>> disbandChannel(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/user_list/")
    Observable<Response<h>> getChannelUserList(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("offset") int r5, @Field("limit") int r6);

    @GET("/webcast/linkmic_channel/get_rtc_info/")
    Single<Response<d>> getRtcInfo(@Query("room_id") long r1, @Query("link_type") int r3, @Query("room_channel_id") long r4, @Query("room_channel_owner_id") String r6);

    @FormUrlEncoded
    @POST("/webcast/room_channel/invite/")
    Observable<Response<j>> inviteChannel(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/invite_message/")
    Single<Response<Object>> inviteMessage(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("invite_items") String r5);

    @FormUrlEncoded
    @POST("/webcast/room_channel/kick_out/")
    Observable<Response<Object>> kickOutChannel(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("user_id") String r5, @Field("sec_uid") String r6);

    @FormUrlEncoded
    @POST("/webcast/room_channel/quit/")
    Observable<Response<k>> quitChannel(@Field("room_id") long r1, @Field("channel_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room_channel/access_reply/")
    Observable<Response<Object>> replyAccessChannel(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("sec_user_id") String r5, @Field("is_permit") boolean r6);

    @FormUrlEncoded
    @POST("/webcast/room_channel/settings_set/")
    Observable<Response<Object>> updateSetting(@Field("room_id") long r1, @Field("channel_id") long r3, @Field("link_mic_switch") boolean r5, @Field("member_invite_switch") boolean r6);
}
