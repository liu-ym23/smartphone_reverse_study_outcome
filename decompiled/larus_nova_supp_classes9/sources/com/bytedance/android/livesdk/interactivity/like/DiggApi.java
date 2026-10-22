package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JV\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007H'J\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/DiggApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "count", "cameraGroupId", BuildConfig.FLAVOR, "scene", "linkmicGuestLikeUserId", "likeToItemId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/like/api/c;", "digg", "Lcom/bytedance/android/livesdk/interactivity/like/api/b;", "getIcons", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DiggApi {

    public static final class a {
        public static /* synthetic */ Observable a(DiggApi r11, long r13, int r14, long r15, String r17, String r18, int r19) {
            if ((r19 & 4) == 0) goto L5;
            long r6 = 0;
        L7:
            if ((r19 & 8) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r19 & 16) == 0) goto L13;
            String r9 = null;
        L15:
            return r11.digg(r13, r14, r6, r8, r9, null);
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
    @POST("/webcast/room/like/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.like.api.c>> digg(@Field("room_id") long r1, @Field("count") int r3, @Field("camera_group_id") long r4, @Field("scene") String r6, @Field("linkmic_guest_like_user_id") String r7, @Field("like_to_item_id") String r8);

    @PbRequest("comment")
    @GET("/webcast/room/like/icon/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.like.api.b>> getIcons(@Query("room_id") long r1);
}
