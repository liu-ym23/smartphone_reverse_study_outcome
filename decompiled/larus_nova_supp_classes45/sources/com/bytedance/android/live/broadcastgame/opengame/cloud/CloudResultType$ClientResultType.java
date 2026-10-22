package com.bytedance.android.live.broadcastgame.opengame.cloud;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$ClientResultType", "", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$ClientResultType;", "", "errMsg", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "", "errNo", "I", "getErrNo", "()I", "Success", "NetworkUnavailable", "NetworkError", "NotLogin", "NetworkTimeOut", "ServerError", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloudResultType$ClientResultType extends Enum<CloudResultType$ClientResultType> {
    public static final CloudResultType$ClientResultType NetworkError = null;
    public static final CloudResultType$ClientResultType NetworkTimeOut = null;
    public static final CloudResultType$ClientResultType NetworkUnavailable = null;
    public static final CloudResultType$ClientResultType NotLogin = null;
    public static final CloudResultType$ClientResultType ServerError = null;
    public static final CloudResultType$ClientResultType Success = null;
    public static final /* synthetic */ CloudResultType$ClientResultType[] a = null;
    private final String errMsg;
    private final int errNo;

    static {
        CloudResultType$ClientResultType r1 = new CloudResultType$ClientResultType("Success", 0, "success", 0);
        Success = r1;
        CloudResultType$ClientResultType r2 = new CloudResultType$ClientResultType("NetworkUnavailable", 1, "Network Error Occur:%s, status code = %s", 40000);
        NetworkUnavailable = r2;
        CloudResultType$ClientResultType r3 = new CloudResultType$ClientResultType("NetworkError", 2, "Network Error Occur:%s, errNo = %s", 40000);
        NetworkError = r3;
        CloudResultType$ClientResultType r4 = new CloudResultType$ClientResultType("NotLogin", 3, "User Doesn't Login", 40006);
        NotLogin = r4;
        CloudResultType$ClientResultType r5 = new CloudResultType$ClientResultType("NetworkTimeOut", 4, "Network Request Timeout", 40015);
        NetworkTimeOut = r5;
        CloudResultType$ClientResultType r6 = new CloudResultType$ClientResultType("ServerError", 5, "Internal Error Occur, server error:%s, errNo = %s", 50001);
        ServerError = r6;
        a = new CloudResultType$ClientResultType[]{r1, r2, r3, r4, r5, r6};
    }

    public static CloudResultType$ClientResultType valueOf(String r1) {
        return (CloudResultType$ClientResultType) r27.a.a(CloudResultType$ClientResultType.class, r1);
    }

    public static CloudResultType$ClientResultType[] values() {
        return (CloudResultType$ClientResultType[]) a.clone();
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final int getErrNo() {
        return this.errNo;
    }

    public CloudResultType$ClientResultType(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.errMsg = r3;
        this.errNo = r4;
    }
}
