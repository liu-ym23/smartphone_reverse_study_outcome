package com.bytedance.android.live.room.api.record.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/api/record/api/RecordPublishApi;", "", "", "eventName", Constants.Keys.DATA, "extra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/room/api/record/api/a;", "pinHighlightReview", "a", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RecordPublishApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @FormUrlEncoded
    @POST("/webcast/replay/pin_highlight_review/")
    Observable<Response<com.bytedance.android.live.room.api.record.api.a>> pinHighlightReview(@Field("event_name") String r1, @Field(Constants.Keys.DATA) String r2, @Field("extra") String r3);
}
