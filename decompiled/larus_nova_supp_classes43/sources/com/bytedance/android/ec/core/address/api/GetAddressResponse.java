package com.bytedance.android.ec.core.address.api;

import com.bytedance.android.ec.core.address.z;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/address/api/GetAddressResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "addressList", "", "Lcom/bytedance/android/ec/core/address/api/AddressItemVO;", "getAddressList", "()Ljava/util/List;", "setAddressList", "(Ljava/util/List;)V", "logId", "", "getLogId", "()Ljava/lang/String;", "serverTime", "", "getServerTime", "()J", "setServerTime", "(J)V", "isValid", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAddressResponse extends CommerceBaseResponse {

    @SerializedName("address_list")
    private List<AddressItemVO> addressList;

    @SerializedName(a.KEY_LOG_ID)
    private final String logId;

    @SerializedName("server_time")
    private long serverTime;

    public GetAddressResponse() {
        this.serverTime = z.j();
    }

    public final boolean isValid() {
        if (getStatusCode() != 0) goto L9;
        List<AddressItemVO> r0 = this.addressList;
        if (r0 == null) goto L9;
        if ((!r0.isEmpty()) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final List<AddressItemVO> getAddressList() {
        return this.addressList;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final void setAddressList(List<AddressItemVO> r1) {
        this.addressList = r1;
    }

    public final void setServerTime(long r1) {
        this.serverTime = r1;
    }
}
