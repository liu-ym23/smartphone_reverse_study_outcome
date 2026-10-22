package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$OpenPlatformServerResultType", "", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$OpenPlatformServerResultType;", "", "errNo", "I", "getErrNo", "()I", "", "errMsg", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "Success", "SystemError", "SidNotExist", "BadBaseToken", "BadCloudCode", "BadAnonymousCloudCode", "NotFaasFunction", "BadParams", "BadAppId", "BadCloudToken", "BadSid", "BadBaseAppId", "UnknownError", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloudResultType$OpenPlatformServerResultType extends Enum<CloudResultType$OpenPlatformServerResultType> {
    public static final CloudResultType$OpenPlatformServerResultType BadAnonymousCloudCode = null;
    public static final CloudResultType$OpenPlatformServerResultType BadAppId = null;
    public static final CloudResultType$OpenPlatformServerResultType BadBaseAppId = null;
    public static final CloudResultType$OpenPlatformServerResultType BadBaseToken = null;
    public static final CloudResultType$OpenPlatformServerResultType BadCloudCode = null;
    public static final CloudResultType$OpenPlatformServerResultType BadCloudToken = null;
    public static final CloudResultType$OpenPlatformServerResultType BadParams = null;
    public static final CloudResultType$OpenPlatformServerResultType BadSid = null;
    public static final CloudResultType$OpenPlatformServerResultType NotFaasFunction = null;
    public static final CloudResultType$OpenPlatformServerResultType SidNotExist = null;
    public static final CloudResultType$OpenPlatformServerResultType Success = null;
    public static final CloudResultType$OpenPlatformServerResultType SystemError = null;
    public static final CloudResultType$OpenPlatformServerResultType UnknownError = null;
    public static final /* synthetic */ CloudResultType$OpenPlatformServerResultType[] a = null;
    private final String errMsg;
    private final int errNo;

    public static CloudResultType$OpenPlatformServerResultType valueOf(String r1) {
        return (CloudResultType$OpenPlatformServerResultType) r27.a.a(CloudResultType$OpenPlatformServerResultType.class, r1);
    }

    public static CloudResultType$OpenPlatformServerResultType[] values() {
        return (CloudResultType$OpenPlatformServerResultType[]) a.clone();
    }

    static {
        CloudResultType$OpenPlatformServerResultType r1 = new CloudResultType$OpenPlatformServerResultType("Success", 0, 0, "success");
        Success = r1;
        CloudResultType$OpenPlatformServerResultType r2 = new CloudResultType$OpenPlatformServerResultType("SystemError", 1, 11000, "system error");
        SystemError = r2;
        CloudResultType$OpenPlatformServerResultType r3 = new CloudResultType$OpenPlatformServerResultType("SidNotExist", 2, 13001, "sid not exist");
        SidNotExist = r3;
        CloudResultType$OpenPlatformServerResultType r4 = new CloudResultType$OpenPlatformServerResultType("BadBaseToken", 3, 13002, "bad base token");
        BadBaseToken = r4;
        CloudResultType$OpenPlatformServerResultType r5 = new CloudResultType$OpenPlatformServerResultType("BadCloudCode", 4, 13003, "bad cloud code");
        BadCloudCode = r5;
        CloudResultType$OpenPlatformServerResultType r6 = new CloudResultType$OpenPlatformServerResultType("BadAnonymousCloudCode", 5, 13004, "bad anonymous cloud code");
        BadAnonymousCloudCode = r6;
        CloudResultType$OpenPlatformServerResultType r7 = new CloudResultType$OpenPlatformServerResultType("NotFaasFunction", 6, 13005, "not available faas function");
        NotFaasFunction = r7;
        CloudResultType$OpenPlatformServerResultType r8 = new CloudResultType$OpenPlatformServerResultType("BadParams", 7, 40014, "bad params");
        BadParams = r8;
        CloudResultType$OpenPlatformServerResultType r9 = new CloudResultType$OpenPlatformServerResultType("BadAppId", 8, 40015, "bad appId");
        BadAppId = r9;
        CloudResultType$OpenPlatformServerResultType r11 = new CloudResultType$OpenPlatformServerResultType("BadCloudToken", 9, 40022, "bad cloud token");
        BadCloudToken = r11;
        CloudResultType$OpenPlatformServerResultType r12 = new CloudResultType$OpenPlatformServerResultType("BadSid", 10, 40023, "bad sid");
        BadSid = r12;
        CloudResultType$OpenPlatformServerResultType r13 = new CloudResultType$OpenPlatformServerResultType("BadBaseAppId", 11, 40026, "bad base appId");
        BadBaseAppId = r13;
        CloudResultType$OpenPlatformServerResultType r14 = new CloudResultType$OpenPlatformServerResultType("UnknownError", 12, -1, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        UnknownError = r14;
        a = new CloudResultType$OpenPlatformServerResultType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14};
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final int getErrNo() {
        return this.errNo;
    }

    public CloudResultType$OpenPlatformServerResultType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.errNo = r3;
        this.errMsg = r4;
    }
}
