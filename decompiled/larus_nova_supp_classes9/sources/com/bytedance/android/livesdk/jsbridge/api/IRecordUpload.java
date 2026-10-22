package com.bytedance.android.livesdk.jsbridge.api;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.Url;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import okhttp3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/api/IRecordUpload;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "url", "name", BuildConfig.FLAVOR, "Lokhttp3/k$b;", "parts", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/jsbridge/api/IRecordUpload$a;", "uploadRecord", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRecordUpload {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/api/IRecordUpload$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "code", "I", "getCode", "()I", "Lcom/bytedance/android/live/base/model/UrlModel;", "data", "Lcom/bytedance/android/live/base/model/UrlModel;", "getData", "()Lcom/bytedance/android/live/base/model/UrlModel;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("status_code")
        private final int code;

        @SerializedName("data")
        private final UrlModel data;

        public a() {
        }
    }

    @Multipart
    @POST
    Observable<a> uploadRecord(@Url String r1, @Header("fileName") String r2, @Part List<k.b> r3);
}
