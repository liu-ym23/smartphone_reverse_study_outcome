package com.bytedance.byted_bach_sdk.log;

/* JADX INFO: loaded from: classes.dex */
public abstract class BachAppLogger {
    public static final int BEF_LOG_LEVEL_DEBUG = 3;
    public static final int BEF_LOG_LEVEL_DEFAULT = 1;
    public static final int BEF_LOG_LEVEL_ERROR = 6;
    public static final int BEF_LOG_LEVEL_FATAL = 7;
    public static final int BEF_LOG_LEVEL_INFO = 4;
    public static final int BEF_LOG_LEVEL_SILENT = 8;
    public static final int BEF_LOG_LEVEL_VERBOSE = 2;
    public static final int BEF_LOG_LEVEL_WARN = 5;

    public BachAppLogger() {
    }

    public long getNativeHandle() {
        return 0;
    }

    public abstract void printf(int r1, String r2);
}
