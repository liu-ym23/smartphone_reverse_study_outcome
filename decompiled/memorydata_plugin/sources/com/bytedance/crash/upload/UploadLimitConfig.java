package com.bytedance.crash.upload;

/* JADX INFO: loaded from: classes2.dex */
public class UploadLimitConfig {
    private int crashLimitAll;
    private int crashLimitIssue;
    private int exceptionAllLimit;
    private int exceptionMsgLimit;
    private int exceptionStackLimit;
    private boolean isNoLimit;

    public UploadLimitConfig(int r2, int r3, int r4, int r5, int r6) {
        this.crashLimitIssue = 50;
        this.crashLimitAll = 100;
        this.exceptionAllLimit = 100;
        this.exceptionMsgLimit = 5;
        this.exceptionStackLimit = 2;
        if (r2 <= 0) goto L5;
        this.crashLimitIssue = r2;
    L5:
        if (r3 <= 0) goto L7;
        this.crashLimitAll = r3;
    L7:
        if (r4 <= 0) goto L9;
        this.exceptionAllLimit = r4;
    L9:
        if (r5 <= 0) goto L11;
        this.exceptionMsgLimit = r5;
    L11:
        if (r6 <= 0) goto L14;
        this.exceptionStackLimit = r6;
        return;
    }

    public UploadLimitConfig(boolean r2) {
        this.crashLimitIssue = 50;
        this.crashLimitAll = 100;
        this.exceptionAllLimit = 100;
        this.exceptionMsgLimit = 5;
        this.exceptionStackLimit = 2;
        this.isNoLimit = r2;
    }

    public int getCrashLimitAll() {
        return this.crashLimitAll;
    }

    public int getCrashLimitIssue() {
        return this.crashLimitIssue;
    }

    public int getExceptionAllLimit() {
        return this.exceptionAllLimit;
    }

    public int getExceptionMsgLimit() {
        return this.exceptionMsgLimit;
    }

    public int getExceptionStackLimit() {
        return this.exceptionStackLimit;
    }

    public boolean isNoLimit() {
        return this.isNoLimit;
    }

    public String toString() {
        return "UploadLimitConfig{crashLimitIssue=" + this.crashLimitIssue + ", crashLimitAll=" + this.crashLimitAll + ", exceptionAllLimit=" + this.exceptionAllLimit + ", exceptionMsgLimit=" + this.exceptionMsgLimit + ", exceptionStackLimit=" + this.exceptionStackLimit + ", isNoLimit=" + this.isNoLimit + '}';
    }
}
