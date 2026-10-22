package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.message.model.dk;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JU\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PoiStoreInfoApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "sceneCode", BuildConfig.FLAVOR, "storeId", BuildConfig.FLAVOR, "address", "anchorId", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/message/model/dk;", "getPoiStoreInfo", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Observable;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PoiStoreInfoApi {
    @FormUrlEncoded
    @POST("/instant/api/live/comment_message/")
    Observable<com.bytedance.android.live.network.response.e<dk>> getPoiStoreInfo(@Field("SceneCode") int r1, @Field("StoreID") Long r2, @Field("AddressDetail") String r3, @Field("AuthorID") String r4, @Field("RoomID") Long r5);
}
