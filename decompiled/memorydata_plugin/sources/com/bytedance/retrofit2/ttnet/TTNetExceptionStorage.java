package com.bytedance.retrofit2.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetExceptionStorage extends IOException {
    private static final long serialVersionUID = -1606114814728652693L;
    public Object infoObj;
    public boolean reportMonitorError;
    public boolean reportMonitorOk;
    public String traceCode;
    public String url;

    public TTNetExceptionStorage() {
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r1) {
        super(r1);
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r1, Throwable r2) {
        super(r1, r2);
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public static TTNetExceptionStorage wrapIfNeeded(Exception r7, String r8, String r9, Object r10) {
        if (ZeusTransformUtils.instanceOf(r7, TTNetExceptionStorage.class) == true) goto L5;
        TTNetExceptionStorage r6 = new TTNetExceptionStorage(r7.getMessage(), r7);
        r6.setInfo(false, true, r8, r9, r10);
        return r6;
    L5:
        return (TTNetExceptionStorage) ZeusTransformUtils.preCheckCast(r7, TTNetExceptionStorage.class, "com.obric.memorydata.plugin");
    }

    public String getTraceCode() {
        return this.traceCode;
    }

    public void setInfo(boolean r1, boolean r2, String r3, String r4, Object r5) {
        this.reportMonitorOk = r1;
        this.reportMonitorError = r2;
        this.url = r3;
        this.traceCode = r4;
        this.infoObj = r5;
    }
}
