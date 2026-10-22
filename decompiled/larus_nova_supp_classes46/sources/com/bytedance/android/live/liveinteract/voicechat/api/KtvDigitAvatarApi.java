package com.bytedance.android.live.liveinteract.voicechat.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdkapi.depend.model.live.audio.GetAvatarAuditResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadAvatar2AuditResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface KtvDigitAvatarApi {
    @GET("/webcast/linkmic_audience/ktv/get_avatar_audit/")
    Observable<e<GetAvatarAuditResponse>> getAvatarAuditResult();

    @POST("/webcast/linkmic_audience/ktv/upload_avatar_img/")
    Observable<e<UploadAvatar2AuditResponse>> uploadImage4Audit(@Query("room_id") long r1, @Body TypedOutput r3);
}
