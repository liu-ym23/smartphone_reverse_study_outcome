package com.bytedance.android.live.effect.utils;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH'JG\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0019\b\u0001\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000f0\fH'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/effect/utils/EffectNetworkAPIForSaas;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonPara", "", "maxLength", "", "relativePath", "", "queryMap", "", "doPost", "body", "Lkotlin/jvm/JvmSuppressWildcards;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface EffectNetworkAPIForSaas {
    @GET
    @Streaming
    Call<TypedInput> doGet(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4);

    @POST
    @Streaming
    Call<TypedInput> doPost(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @Body Map<String, Object> r4);
}
