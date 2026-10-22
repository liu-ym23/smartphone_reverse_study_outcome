package com.bytedance.android.live.broadcastgame.opengame.im;

import am3.f;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u001a\b\u0001\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/im/BroadcastGameMessageApi;", "", "", "roomId", "", "fetchRule", "", "", "options", "Lcom/bytedance/retrofit2/Call;", "Lam3/f;", "fetchMessageShortConnection", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface BroadcastGameMessageApi {
    @FormUrlEncoded
    @POST("/webcast/im/fetch/")
    Call<f> fetchMessageShortConnection(@Field("room_id") long r1, @Field("fetch_rule") int r3, @FieldMap Map<String, String> r4);
}
