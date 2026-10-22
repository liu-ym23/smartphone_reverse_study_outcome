package com.obric.assistant.feedback.upload;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H§@¢\u0006\u0002\u0010\u0011J4\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/feedback/upload/IReportUploadNetworkService;", "", "getLocation", "Lcom/google/gson/JsonObject;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadReport", "nsKey", "", "conType", "xttToken", "useQueryAid", "", "reportData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFile", "body", "Lokhttp3/MultipartBody;", "(Ljava/lang/String;Lokhttp3/MultipartBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendText", "contentData", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IReportUploadNetworkService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    @POST("api/v1/fb/appends")
    Object appendText(@Header("Authorization") String r1, @Header("Content-type") String r2, @Body JsonObject r3, Continuation<? super JsonObject> r4);

    @GET("api/0/util/location/my")
    Object getLocation(Continuation<? super JsonObject> r1);

    @POST("api/v1/fb/files")
    Object uploadFile(@Header("Authorization") String r1, @Body k r2, Continuation<? super JsonObject> r3);

    @POST("api/v1/fb/reports")
    Object uploadReport(@Header("Authorization") String r1, @Header("Content-type") String r2, @Header("X-Tt-token") String r3, @Query("use_query_aid") int r4, @Body JsonObject r5, Continuation<? super JsonObject> r6);
}
