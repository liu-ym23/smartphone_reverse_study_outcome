package com.qualcomm.qti.qesdkIntf;

/* JADX INFO: loaded from: classes2.dex */
public interface IQesdkFunctionType {
    public static final int LEGACY_FUNC_DEFAULT_VERSION = 1;

    String[] getArgNames();

    int getFunctionId();

    String getFunctionName();

    default int getFunctionVersion() {
        return 1;
    }

    int getNumberOfArgs();

    String getOpCode();

    int getSSId();

    String getSSName();
}
