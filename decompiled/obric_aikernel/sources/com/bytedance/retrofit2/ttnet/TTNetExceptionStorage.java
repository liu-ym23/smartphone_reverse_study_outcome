package com.bytedance.retrofit2.ttnet;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class TTNetExceptionStorage extends IOException {
    private static final long serialVersionUID = -1606114814728652693L;
    public Object infoObj;
    public boolean needReport;
    public boolean reportMonitorError;
    public boolean reportMonitorOk;
    public String traceCode;
    public String url;

    public TTNetExceptionStorage() {
        this.needReport = false;
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r10) {
        super(r10);
        this.needReport = false;
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r10, Throwable r11) {
        super(r10, r11);
        this.needReport = false;
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public String getTraceCode() {
        return this.traceCode;
    }

    public void setInfo(boolean r10, boolean r11, boolean r12, String r13, String r14, Object r15) {
        this.needReport = r10;
        this.reportMonitorOk = r11;
        this.reportMonitorError = r12;
        this.url = r13;
        this.traceCode = r14;
        this.infoObj = r15;
    }
}
