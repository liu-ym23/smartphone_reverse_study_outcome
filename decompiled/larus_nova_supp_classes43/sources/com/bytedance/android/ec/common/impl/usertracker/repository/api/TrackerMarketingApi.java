package com.bytedance.android.ec.common.impl.usertracker.repository.api;

import com.bytedance.android.ec.common.impl.usertracker.ecmarketing.model.RecordActionResponse;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\rJB\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'JL\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/usertracker/repository/api/TrackerMarketingApi;", "", "", "ruleIds", "scene", "sceneId", "action", "extraInfo", "Lio/reactivex/Observable;", "Lcom/bytedance/android/ec/common/impl/usertracker/ecmarketing/model/RecordActionResponse;", "recordAction", "requestTag", "recordActionWithPeakInfo", "a", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface TrackerMarketingApi {
    public static final a a = null;

    public static final class a {
        public static final TrackerMarketingApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (TrackerMarketingApi) n.a.create("https://growth.ecombdapi.com", TrackerMarketingApi.class);
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("/growth/marketing_express/report_user_action_rule")
    Observable<RecordActionResponse> recordAction(@Field("rule_ids") String r1, @Field("scene") String r10, @Field(com.bytedance.android.ec.core.event.a.KEY_SCENE_ID) String r11, @Field("action") String r12, @Field("extra_info") String r13);

    @FormUrlEncoded
    @POST("/growth/marketing_express/report_user_action_rule")
    Observable<RecordActionResponse> recordActionWithPeakInfo(@Header("x-tt-request-tag") String r1, @Field("rule_ids") String r10, @Field("scene") String r11, @Field(com.bytedance.android.ec.core.event.a.KEY_SCENE_ID) String r12, @Field("action") String r13, @Field("extra_info") String r14);
}
