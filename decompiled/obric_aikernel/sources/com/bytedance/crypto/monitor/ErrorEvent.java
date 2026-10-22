package com.bytedance.crypto.monitor;

import com.bytedance.crypto.monitor.proto.CloudSyncData;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.monitor.proto.ErrorTrace;
import com.bytedance.crypto.monitor.proto.NormalTrace;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class ErrorEvent {
    private static final String TAG = "ErrorEvent";

    public ErrorEvent() {
    }

    public static void eventTrace(int r10, int r11, String r12, String r13, int r14, long r15, Object r16) {
        LogUtils.i(TAG, "eventTrace, module: " + r10 + ", event: " + r11 + ", pkgName: " + r12 + ", appid: " + r13 + ", errCode: " + r14);
        ErrorTrace r17 = ErrorTrace.newBuilder().setModuleId(r10).setEventId(r11).setPackageName(r12).setErrCode(r14).build();
        if (r16 != null) goto L5;
    L7:
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addErrorTrace(r17).addNormalTrace(NormalTrace.newBuilder().setModuleId(r10).setEventId(r11).setPackageName(r12).setAppId(r13).setUserid(0).setErrCode(r14).setTotalCalls(1).setTimeConsumption(r15).setTotalDataSize(0)).build().toBuilder());
        return;
    L5:
        if ((r16 instanceof CloudSyncData) == false) goto L7;
        r17 = r17.toBuilder().setCloudSyncData((CloudSyncData) r16).build();
        goto L7
    }
}
