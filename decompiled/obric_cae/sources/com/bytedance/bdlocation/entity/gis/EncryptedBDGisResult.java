package com.bytedance.bdlocation.entity.gis;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class EncryptedBDGisResult {

    @b("data")
    public String data;

    @b("err_no")
    public int errorCode;

    @b(LocationMonitorConst.ERR_MSG)
    public String errorMessage;

    @b("err_tip")
    public String errorTips;

    public EncryptedBDGisResult() {
    }
}
