package com.bytedance.bdinstall.dtrait.model;

/* JADX INFO: loaded from: classes.dex */
public class DTraitLogEntry {
    private final String businessTag;
    private final String error;
    private DTraitLogLevel level;
    private final String methodName;
    private final String msg;

    public DTraitLogEntry(DTraitLogLevel r1, String r2, String r3, String r4, String r5) {
        this.level = r1;
        this.methodName = r3;
        this.msg = r4;
        this.businessTag = r2;
        this.error = r5;
    }

    public String getBusinessTag() {
        return this.businessTag;
    }

    public String getError() {
        return this.error;
    }

    public DTraitLogLevel getLevel() {
        return this.level;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getMsg() {
        return this.msg;
    }
}
