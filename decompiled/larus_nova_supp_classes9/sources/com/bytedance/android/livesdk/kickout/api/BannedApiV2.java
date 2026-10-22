package com.bytedance.android.livesdk.kickout.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import dd2.a;
import dd2.c;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'J8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'J8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'J4\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'J4\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/kickout/api/BannedApiV2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "count", "offset", BuildConfig.FLAVOR, "secUid", "Lio/reactivex/Observable;", "Ldd2/c;", "getKickedOutList", "getBannedTalkList", "Ldd2/a;", "getBannedTalkList2", "uid", "Lcom/bytedance/android/live/network/response/Response;", "Ljava/lang/Void;", "kickOut", "unKickOut", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface BannedApiV2 {
    @GET("/webcast/room/silence/list/")
    Observable<c> getBannedTalkList(@Query("room_id") long r1, @Query("count") int r3, @Query("offset") int r4, @Query("sec_user_id") String r5);

    @GET("/webcast/room/silence/list/")
    Observable<a> getBannedTalkList2(@Query("room_id") long r1, @Query("count") int r3, @Query("offset") int r4, @Query("sec_user_id") String r5);

    @GET("/webcast/room/kick/list/")
    Observable<c> getKickedOutList(@Query("room_id") long r1, @Query("count") int r3, @Query("offset") int r4, @Query("sec_user_id") String r5);

    @GET("/webcast/room/kick/user/")
    Observable<Response<Void>> kickOut(@Query("room_id") long r1, @Query("kick_uid") String r3, @Query("sec_kick_uid") String r4);

    @GET("/webcast/room/unkick/user/")
    Observable<Response<Void>> unKickOut(@Query("room_id") long r1, @Query("kick_uid") String r3, @Query("sec_kick_uid") String r4);
}
