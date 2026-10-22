package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.roomplayer.PaidLivePingResponse;
import com.bytedance.android.livesdkapi.roomplayer.PaidLivePingV2Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import fq1.l;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002JZ\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\r2\b\b\u0003\u0010\u0011\u001a\u00020\u000fH'JF\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u00062\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayPaidApi;", "", "getPaidLivePingUrl", "", "getReportWatchTimestampUrl", "paidLivePing", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdkapi/roomplayer/PaidLivePingV2Response;", "url", "id", "idType", "pingType", "", "timeStamp", "", "paidLiveType", "entityId", "reportWatchTimestamp", "Lcom/bytedance/android/livesdkapi/roomplayer/PaidLivePingResponse;", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReplayPaidApi {

    public static final class a {
        public static Observable a(ReplayPaidApi r10, String r11, int r12, long r13, int r15, long r16, int r18) {
            if ((r18 & 1) != 0) goto L5;
            String r0 = null;
        L9:
            String r1 = r0;
            if ((r18 & 32) == 0) goto L12;
            int r7 = 0;
        L14:
            if ((r18 & 64) == 0) goto L16;
            long r8 = 0;
        L18:
            return r10.paidLivePing(r1, r11, "1", r12, r13, r7, r8);
        L16:
            r8 = r16;
            goto L18
        L12:
            r7 = r15;
            goto L14
        L5:
            if (r.d().isSaas() == false) goto L7;
            l.a("getReportWatchTimestampUrl");
            r0 = "";
            goto L9
        L7:
            r0 = "/webcast/paid_live/ping/";
            goto L9
        }
    }

    @GET
    Observable<Response<PaidLivePingV2Response>> paidLivePing(@Url String r1, @Query("id") String r2, @Query("id_type") String r3, @Query("ping_type") int r4, @Query("timestamp") long r5, @Query("paid_live_type") int r7, @Query("entity_id") long r8);

    @Deprecated(message = "path迁移至/webcast/paid_live/ping/")
    @GET
    Observable<Response<PaidLivePingResponse>> reportWatchTimestamp(@Url String r1, @Query("id") String r2, @Query("id_type") String r3, @Query("ping_type") int r4, @Query("timestamp") long r5);
}
