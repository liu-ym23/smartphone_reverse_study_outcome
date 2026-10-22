package com.obric.cae.cldReport.logLevelDataBase;

import android.aimedia.a;

/* JADX INFO: loaded from: classes.dex */
public class LogLevEntry {
    private String invalidDate;
    private int logmask;
    private String module;
    private String startedDate;

    public LogLevEntry(String r8, int r10, String r11, String r12) {
        this.module = r8;
        this.logmask = r10;
        this.startedDate = r11;
        this.invalidDate = r12;
    }

    public String getInvalidDate() {
        return this.invalidDate;
    }

    public int getLogmask() {
        return this.logmask;
    }

    public String getModule() {
        return this.module;
    }

    public String getStartedDate() {
        return this.startedDate;
    }

    public void setInvalidDate(String r8) {
        this.invalidDate = r8;
    }

    public void setLogmask(int r8) {
        this.logmask = r8;
    }

    public void setModule(String r8) {
        this.module = r8;
    }

    public void setStartedDate(String r8) {
        this.startedDate = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("LogLevEntry{module='");
        r8.append(this.module);
        r8.append("', logmask=");
        r8.append(this.logmask);
        r8.append(", startedDate='");
        r8.append(this.startedDate);
        r8.append("', invalidDate='");
        return a.i(r8, this.invalidDate, "'}");
    }
}
