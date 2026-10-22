package com.bytedance.android.livesdk.interactivity.api.emoji;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u00052\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/emoji/FusionEmojiApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "fieldMap", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/interactivity/api/emoji/b;", "Lcom/bytedance/android/live/network/response/v2/Response;", "getFusionEmojiInfo", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FusionEmojiApi {
    @FormUrlEncoded
    @POST("/webcast/interaction/fusion_emoji/")
    Observable<com.bytedance.android.live.network.response.e<b>> getFusionEmojiInfo(@FieldMap Map<String, String> r1);
}
