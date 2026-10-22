package com.bytedance.android.livesdk.interactivity.virtualinteract.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.virtualinteract.model.a;
import com.bytedance.android.livesdk.interactivity.virtualinteract.model.c;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062(\b\u0001\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H'J>\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062(\b\u0001\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/virtualinteract/api/VirtualInteractRetrofitApi;", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "map", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/a;", "createActor", "Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/c;", "sendInteractionCommand", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface VirtualInteractRetrofitApi {
    @FormUrlEncoded
    @POST("/webcast/anchor/virtualgame/user/create_actor/")
    Observable<Response<a>> createActor(@FieldMap HashMap<String, String> r1);

    @FormUrlEncoded
    @POST("/webcast/anchor/virtualgame/user/command/")
    Observable<Response<c>> sendInteractionCommand(@FieldMap HashMap<String, String> r1);
}
