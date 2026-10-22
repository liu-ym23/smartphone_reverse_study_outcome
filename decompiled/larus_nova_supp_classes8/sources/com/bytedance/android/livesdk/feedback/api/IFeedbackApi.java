package com.bytedance.android.livesdk.feedback.api;

import com.bytedance.android.live.base.model.feedback.a;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jn\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\u0005H'J(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u0005H'Jd\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u00132\b\b\u0003\u0010\u0016\u001a\u00020\u00052\b\b\u0003\u0010\u0017\u001a\u00020\u00132\b\b\u0003\u0010\u0019\u001a\u00020\u00182\b\b\u0003\u0010\u001a\u001a\u00020\u0013H'J(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/api/IFeedbackApi;", "", "", "feedbackId", "roomId", "", "optionKeys", "requestId", "enterFromMerge", "enterMethod", "roomIds", "traceId", "recentRoomIds", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "feedbackRequest", "unreadExtra", "feedbackIds", "feedbackUnreadRequest", "", "flowType", "feedbackType", "roomType", "feedbackPosition", "", "bindRoomInvalid", "scene", "feedbackCardShow", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/base/model/feedback/a$a;", "getLiveRoomFeedbackCard", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFeedbackApi {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.api.IFeedbackApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable feedbackCardShow$default(IFeedbackApi r14, long r15, long r17, int r19, int r20, String r21, int r22, boolean r23, int r24, int r25, Object r26) {
            if (r26 != null) goto L27;
            if ((r25 & 8) == 0) goto L7;
            int r9 = -1;
        L9:
            if ((r25 & 16) == 0) goto L11;
            String r10 = "";
        L13:
            if ((r25 & 32) == 0) goto L15;
            int r11 = -1;
        L17:
            if ((r25 & 64) == 0) goto L19;
            boolean r12 = false;
        L21:
            if ((r25 & 128) == 0) goto L23;
            int r13 = -1;
        L25:
            return r14.feedbackCardShow(r15, r17, r19, r9, r10, r11, r12, r13);
        L23:
            r13 = r24;
            goto L25
        L19:
            r12 = r23;
            goto L21
        L15:
            r11 = r22;
            goto L17
        L11:
            r10 = r21;
            goto L13
        L7:
            r9 = r20;
            goto L9
        L27:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedbackCardShow");
        }

        public static /* synthetic */ Observable feedbackRequest$default(IFeedbackApi r15, long r16, long r18, String r20, String r21, String r22, String r23, String r24, String r25, String r26, int r27, Object r28) {
            if (r28 != null) goto L19;
            if ((r27 & 64) == 0) goto L7;
            String r12 = "";
        L9:
            if ((r27 & 128) == 0) goto L11;
            String r13 = "";
        L13:
            if ((r27 & 256) == 0) goto L15;
            String r14 = "";
        L17:
            return r15.feedbackRequest(r16, r18, r20, r21, r22, r23, r12, r13, r14);
        L15:
            r14 = r26;
            goto L17
        L11:
            r13 = r25;
            goto L13
        L7:
            r12 = r24;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedbackRequest");
        }
    }

    @POST("/webcast/distribution/feedback_show/")
    Observable<Response<Object>> feedbackCardShow(@Query("feedback_id") long r1, @Query("room_id") long r3, @Query("flow_type") int r5, @Query("feedback_type") int r6, @Query("room_type") String r7, @Query("feedback_position") int r8, @Query("bind_room_invalid") boolean r9, @Query("scene") int r10);

    @POST("/webcast/distribution/feedback/")
    Observable<Response<Object>> feedbackRequest(@Query("feedback_id") long r1, @Query("room_id") long r3, @Query("option_keys") String r5, @Query("request_id") String r6, @Query("enter_from_merge") String r7, @Query("enter_method") String r8, @Query("room_ids") String r9, @Query("trace_log_id") String r10, @Query("recent_room_ids") String r11);

    @POST("/webcast/distribution/feedback_unread/")
    Observable<Response<Object>> feedbackUnreadRequest(@Query("unread_extra") String r1, @Query("feed_ids") String r2);

    @GET("/webcast/distribution/get_feedback_card/")
    Observable<e<a.a>> getLiveRoomFeedbackCard(@Query("feedback_id") long r1, @Query("room_id") long r3);
}
