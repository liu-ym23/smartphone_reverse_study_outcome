package com.bytedance.android.livesdk.interactivity.api.asr.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.asr.model.a;
import com.bytedance.android.livesdk.interactivity.api.asr.model.c;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0002H'JD\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\rH'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/asr/api/AnchorAsrRetrofitApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "asrResult", "triggerWord", "historyTextList", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/asr/model/a;", "match", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "audioData", "Lcom/bytedance/android/livesdk/interactivity/api/asr/model/c;", "sendAudioChat", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnchorAsrRetrofitApi {
    @FormUrlEncoded
    @POST("/webcast/interaction/anchor_audio/")
    Observable<Response<a>> match(@Field("origin_text") String r1, @Field("trigger_word") String r2, @Field("history_text_list") String r3);

    @POST("/webcast/room/send_anchor_audio_chat/")
    Observable<Response<c>> sendAudioChat(@QueryMap HashMap<String, String> r1, @Body TypedOutput r2);
}
