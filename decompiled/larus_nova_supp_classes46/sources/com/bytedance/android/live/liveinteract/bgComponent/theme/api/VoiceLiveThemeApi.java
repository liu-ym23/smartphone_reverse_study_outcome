package com.bytedance.android.live.liveinteract.bgComponent.theme.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.DeleteVoiceLiveThemeResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.GetLatestBGResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.SelectVoiceLiveThemeResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadBackgroundResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadFileResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveThemeListResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface VoiceLiveThemeApi {
    @POST("/webcast/room/bg_add/")
    Observable<Response<UploadBackgroundResponse>> addUgcBgTheme(@Query("room_id") long r1, @Query("img_uri") String r3, @Query("file_format") String r4, @Query("show_area") String r5, @Query("bg_type") int r6, @Query("is_pre_load") boolean r7);

    @GET("/webcast/room/audio/bg_delete/")
    Observable<Response<DeleteVoiceLiveThemeResponse>> deleteTheme(@Query("room_id") long r1, @Query("image_uri") String r3, @Query("bg_type") int r4);

    @GET("/webcast/room/audio/bg/")
    Observable<Response<VoiceLiveThemeListResponse>> fetchOneKeyVoiceLiveThemeList(@Query("bg_type") int r1, @Query("room_id") long r2, @Query("image_type") int r4);

    @GET("/webcast/room/audio/bg/")
    Observable<Response<VoiceLiveThemeListResponse>> fetchVoiceLiveThemeList(@Query("bg_type") int r1);

    @GET("/webcast/room/audio/bg/")
    Observable<Response<VoiceLiveThemeListResponse>> fetchVoiceLiveThemeList(@Query("bg_type") int r1, @Query("room_id") long r2);

    @GET("/webcast/room/audio/bg/")
    Observable<Response<VoiceLiveThemeListResponse>> fetchVoiceLiveThemeList(@Query("bg_type") int r1, @Query("room_id") long r2, @Query("image_type") String r4, @Query("play_mode") long r5);

    @GET("/webcast/room/latest_bg/")
    Observable<Response<GetLatestBGResponse>> getLatestOfficeBg(@Query("bg_type") int r1);

    @GET("/webcast/room/audio/bg_set/")
    Observable<Response<SelectVoiceLiveThemeResponse>> selectTheme(@Query("room_id") long r1, @Query("image_uri") String r3, @Query("image_type") int r4, @Query("bg_type") int r5);

    @POST("/webcast/room/audio/bg_upload/")
    Observable<Response<UploadBackgroundResponse>> uploadBackgroundImg(@Query("room_id") long r1, @Body TypedOutput r3);

    @POST("/webcast/image/upload/")
    Observable<Response<UploadFileResponse>> uploadFile(@Query("scene") String r1, @Body TypedOutput r2);
}
