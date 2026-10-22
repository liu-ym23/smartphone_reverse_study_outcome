package com.bytedance.android.livesdk.interactivity.api.comment.wordassociate;

import c32.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0003H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/wordassociate/WordAssociationApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "fieldMap", "requestTag", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lc32/c;", "Lcom/bytedance/android/live/network/response/v2/Response;", "association", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface WordAssociationApi {
    @FormUrlEncoded
    @POST("/webcast/interaction/word_association/")
    Observable<e<c>> association(@FieldMap Map<String, String> r1, @Header("x-tt-request-tag") String r2);
}
