package com.bytedance.android.live.liveinteract.plantform.api;

import com.bytedance.android.live.liveinteract.plantform.model.y0;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.h1;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.z2;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkPaidLinkApi;", "", "", "roomId", "", "usePlayModeInfo", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k1;", "getPlayModeInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/h1;", "getPaidInfoBeforeApply", "Lcom/bytedance/android/live/liveinteract/plantform/model/y0;", "getPaidExplainCardInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/z2;", "getUserPaidBenefitInfo", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkPaidLinkApi {
    @GET("/webcast/linkmic_profit/get_paid_linkmic_explain_card_info/")
    Single<e<y0>> getPaidExplainCardInfo(@Query("room_id") long r1);

    @GET("/webcast/linkmic_profit/get_paid_info_before_apply/")
    Single<e<h1>> getPaidInfoBeforeApply(@Query("room_id") long r1);

    @GET("/webcast/linkmic_audience/get_play_mode_info/")
    Single<e<k1>> getPlayModeInfo(@Query("room_id") long r1, @Query("use_play_mode_info") boolean r3);

    @GET("/webcast/linkmic_profit/get_user_paid_linkmic_benefit_info/")
    Single<e<z2>> getUserPaidBenefitInfo(@Query("room_id") long r1);
}
