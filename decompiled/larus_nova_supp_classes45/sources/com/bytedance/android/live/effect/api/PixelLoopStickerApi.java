package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'J(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/api/PixelLoopStickerApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lo90/c;", "getPictures", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "", "roomId", "Lo90/f;", "uploadPicture", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PixelLoopStickerApi {
    @GET("/webcast/room/props/bg/")
    Observable<Response<o90.c>> getPictures();

    @POST("/webcast/room/props/bg_upload/")
    Observable<Response<o90.f>> uploadPicture(@Body TypedOutput r1, @Query("room_id") long r2);
}
