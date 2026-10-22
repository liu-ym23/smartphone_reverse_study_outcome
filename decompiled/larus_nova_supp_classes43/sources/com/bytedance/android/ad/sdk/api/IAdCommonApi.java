package com.bytedance.android.ad.sdk.api;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JV\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\fH'Jb\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0001H'Jr\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0001\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\fH'J~\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0001\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0001H'Jb\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\fH'Jn\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0001H'JV\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\fH'Jb\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0003\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ad/sdk/api/IAdCommonApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "queryMap", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "addCommonParam", "", "extraInfo", "doPostForm", "fieldMap", "doPostJson", "jsonObject", "Lcom/google/gson/JsonObject;", "downloadFile", "Lcom/bytedance/retrofit2/mime/TypedInput;", "runtime-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public interface IAdCommonApi {

    public static final class a {
        public static /* synthetic */ Call a(IAdCommonApi r10, String r11, Map r12) {
            return r10.doGet(r11, r12, null, true);
        }
    }

    @GET
    Call<String> doGet(@Url String r1, @QueryMap(encode = true) Map<String, String> r10, @HeaderList List<Header> r11, @AddCommonParam boolean r12);

    @GET
    Call<String> doGet(@Url String r1, @QueryMap(encode = true) Map<String, String> r10, @HeaderList List<Header> r11, @AddCommonParam boolean r12, @ExtraInfo Object r13);

    @FormUrlEncoded
    @POST
    Call<String> doPostForm(@Url String r1, @FieldMap(encode = true) Map<String, String> r10, @QueryMap(encode = true) Map<String, String> r11, @HeaderList List<Header> r12, @AddCommonParam boolean r13);

    @FormUrlEncoded
    @POST
    Call<String> doPostForm(@Url String r1, @FieldMap(encode = true) Map<String, String> r10, @QueryMap(encode = true) Map<String, String> r11, @HeaderList List<Header> r12, @AddCommonParam boolean r13, @ExtraInfo Object r14);

    @POST
    Call<String> doPostJson(@Url String r1, @Body JsonObject r10, @QueryMap(encode = true) Map<String, String> r11, @HeaderList List<Header> r12, @AddCommonParam boolean r13);

    @POST
    Call<String> doPostJson(@Url String r1, @Body JsonObject r10, @QueryMap(encode = true) Map<String, String> r11, @HeaderList List<Header> r12, @AddCommonParam boolean r13, @ExtraInfo Object r14);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@Url String r1, @QueryMap(encode = true) Map<String, String> r10, @HeaderList List<Header> r11, @AddCommonParam boolean r12);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@Url String r1, @QueryMap(encode = true) Map<String, String> r10, @HeaderList List<Header> r11, @AddCommonParam boolean r12, @ExtraInfo Object r13);
}
