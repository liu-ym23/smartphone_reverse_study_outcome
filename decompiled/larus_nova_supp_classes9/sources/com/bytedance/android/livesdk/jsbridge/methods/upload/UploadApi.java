package com.bytedance.android.livesdk.jsbridge.methods.upload;

import com.bytedance.android.live.base.annotation.SkipLivePBCheck;
import com.bytedance.android.live.base.model.i;
import com.bytedance.android.live.network.response.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "path", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/base/model/i;", "uploadImage", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface UploadApi {
    @POST("{path}")
    @SkipLivePBCheck
    Observable<e<i>> uploadImage(@Path(encode = BuildConfig.DEBUG, value = "path") String r1, @Body TypedOutput r2);
}
