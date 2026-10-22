package com.bytedance.android.livesdk.interactivity.comment.highlight;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'JF\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/highlight/MarkHighlightApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "timestamp", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/a;", "getHighlightData", "anchorId", "highlightId", "status", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "startScreenRecordRequest", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MarkHighlightApi {
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
    @POST("/webcast/replay/pin_highlight_in_room/")
    Observable<Response<com.bytedance.android.livesdk.interactivity.comment.highlight.a>> getHighlightData(@Field("room_id") long r1, @Field("time_stamp") long r3);

    @FormUrlEncoded
    @POST("/webcast/replay/screen_record_in_room/")
    Observable<Response<d>> startScreenRecordRequest(@Field("room_id") long r1, @Field("time_stamp") long r3, @Field("anchor_id") long r5, @Field("highlight_id") long r7, @Field("status") long r9);
}
