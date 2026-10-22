package com.bytedance.bdlocation.network.response;

import android.aimedia.a;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class LocationResp {

    @b("data")
    public String data;

    @b("err_no")
    public int resultCode;

    @b(LocationMonitorConst.ERR_MSG)
    public String resultMsg;

    @b("err_tip")
    public String resultTip;
    public String submitLogId;

    public LocationResp() {
    }

    public String toMonitorString() {
        StringBuilder r8 = new StringBuilder("LocationResp { resultCode = ");
        r8.append(this.resultCode);
        r8.append(", resultMsg = '");
        r8.append(this.resultMsg);
        r8.append("', resultTip = '");
        r8.append(this.resultTip);
        r8.append("', submitLogId = '");
        return a.i(r8, this.submitLogId, "' }");
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("LocationResp{resultCode=");
        r8.append(this.resultCode);
        r8.append(", resultMsg='");
        r8.append(this.resultMsg);
        r8.append("', resultTip='");
        r8.append(this.resultTip);
        r8.append("', data='");
        r8.append(this.data);
        r8.append("', submitLogId='");
        return a.i(r8, this.submitLogId, "'}");
    }
}
