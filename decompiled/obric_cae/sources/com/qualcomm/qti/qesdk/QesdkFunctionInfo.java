package com.qualcomm.qti.qesdk;

import com.qualcomm.qti.qesdkIntf.IQesdkFunctionType;

/* JADX INFO: loaded from: classes2.dex */
public final class QesdkFunctionInfo implements IQesdkFunctionType {
    private String functionName;
    private int functionVersion;
    private int numOfArgs;
    private String opcode;
    private int ssId;
    private String ssName;

    public QesdkFunctionInfo() {
        this("", -1, -1, "", "");
    }

    private String[] getArgNamesInternal() {
        int r8 = getNumberOfArgs();
        String[] r10 = new String[r8];
        int r11 = 0;
        if (r8 == 0) goto L5;
    L6:
        if (r11 >= r8) goto L8;
        r10[r11] = Integer.toString(r11);
        r11 = r11 + 1;
        goto L6
    L8:
        return r10;
    L5:
        return new String[0];
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String[] getArgNames() {
        return getArgNamesInternal();
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getFunctionId() {
        return 0;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String getFunctionName() {
        return this.functionName;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getFunctionVersion() {
        return this.functionVersion;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getNumberOfArgs() {
        return this.numOfArgs;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String getOpCode() {
        return this.opcode;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getSSId() {
        return this.ssId;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String getSSName() {
        return this.ssName;
    }

    public QesdkFunctionInfo setFunctionName(String r8) {
        this.functionName = r8;
        return this;
    }

    public QesdkFunctionInfo setFunctionVersion(int r8) {
        this.functionVersion = r8;
        return this;
    }

    public QesdkFunctionInfo setNumberOfArgs(int r8) {
        this.numOfArgs = r8;
        return this;
    }

    public QesdkFunctionInfo setOpCode(String r8) {
        this.opcode = r8;
        return this;
    }

    public QesdkFunctionInfo setSSId(int r8) {
        this.ssId = r8;
        return this;
    }

    public QesdkFunctionInfo setSSName(String r8) {
        this.ssName = r8;
        return this;
    }

    public QesdkFunctionInfo(String r8, int r10, int r11, String r12, String r13) {
        this(r8, r10, r11, r12, r13, 1);
    }

    public QesdkFunctionInfo(String r8, int r10, int r11, String r12, String r13, int r14) {
        this.opcode = r13;
        this.functionName = r8;
        this.ssName = r12;
        this.ssId = r11;
        this.numOfArgs = r10;
        this.functionVersion = r14;
    }
}
