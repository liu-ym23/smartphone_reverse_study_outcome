package com.bytedance.crash.upload;

/* JADX INFO: loaded from: classes.dex */
public class UploadLimitConfig {
    private int crashLimitAll;
    private int crashLimitIssue;
    private int exceptionAllLimit;
    private int exceptionMsgLimit;
    private int exceptionStackLimit;
    private boolean isNoLimit;

    public UploadLimitConfig(int r10, int r11, int r12, int r13, int r14) {
        this.crashLimitIssue = 50;
        this.crashLimitAll = 100;
        this.exceptionAllLimit = 100;
        this.exceptionMsgLimit = 5;
        this.exceptionStackLimit = 2;
        if (r10 <= 0) goto L5;
        this.crashLimitIssue = r10;
    L5:
        if (r11 <= 0) goto L7;
        this.crashLimitAll = r11;
    L7:
        if (r12 <= 0) goto L9;
        this.exceptionAllLimit = r12;
    L9:
        if (r13 <= 0) goto L11;
        this.exceptionMsgLimit = r13;
    L11:
        if (r14 <= 0) goto L14;
        this.exceptionStackLimit = r14;
        return;
    }

    public UploadLimitConfig(boolean r10) {
        this.crashLimitIssue = 50;
        this.crashLimitAll = 100;
        this.exceptionAllLimit = 100;
        this.exceptionMsgLimit = 5;
        this.exceptionStackLimit = 2;
        this.isNoLimit = r10;
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
