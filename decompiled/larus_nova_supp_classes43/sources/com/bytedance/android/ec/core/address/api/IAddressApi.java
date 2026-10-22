package com.bytedance.android.ec.core.address.api;

import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jo\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\f\u001a\u00020\bH'¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\r2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/address/api/IAddressApi;", "", "", "requestTag", "", "gpsOn", "changeType", "addressId", "", "addressType", "addressPayload", "extraPayload", "hitOptRequest", "Lio/reactivex/Observable;", "Lcom/bytedance/android/ec/core/address/api/GetAddressResponse;", "getAddress", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/Observable;", "source", "channelType", "Lcom/bytedance/android/ec/core/address/api/ReportAddressResponse;", "reportAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAddressApi {

    public static final class a {
        public static /* synthetic */ Observable a(boolean r10, String r11, String r12, Integer r13, String r14, String r15, int r16, int r17) {
            AddressApi r0 = AddressApi.b;
            if ((r17 & 8) == 0) goto L5;
            String r18 = null;
        L7:
            if ((r17 & 16) == 0) goto L9;
            Integer r19 = null;
        L11:
            if ((r17 & 32) == 0) goto L13;
            String r20 = null;
        L15:
            if ((r17 & 64) == 0) goto L17;
            String r21 = null;
        L19:
            return r0.getAddress("t=1", r10, r11, r18, r19, r20, r21, r16);
        L17:
            r21 = r15;
            goto L19
        L13:
            r20 = r14;
            goto L15
        L9:
            r19 = r13;
            goto L11
        L5:
            r18 = r12;
            goto L7
        }
    }

    @FormUrlEncoded
    @POST("/address/sdk/getAddress/")
    Observable<GetAddressResponse> getAddress(@Header("x-tt-request-tag") String r1, @Field("gps_on") boolean r10, @Field("change_type") String r11, @Field("address_id") String r12, @Field("address_type") Integer r13, @Field("addr_payload") String r14, @Field("extra_payload") String r15, @Field("hit_opt_request") int r16);

    @FormUrlEncoded
    @POST("/address/sdk/report/")
    Observable<ReportAddressResponse> reportAddress(@Field("source") String r1, @Field("addr_payload") String r10, @Field("channel_type") Integer r11);
}
