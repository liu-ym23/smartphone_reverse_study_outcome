package com.bytedance.android.live.liveinteract.hamlet.api;

import com.bytedance.android.live.liveinteract.hamlet.model.j;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/api/HamletAvatarApi;", "", "", "roomId", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/hamlet/model/j;", "getXplayInitInfo", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface HamletAvatarApi {
    @GET("/webcast/linkmic_audience/get_xplay_init_info/")
    Single<e<j>> getXplayInitInfo(@Query("room_id") long r1);
}
