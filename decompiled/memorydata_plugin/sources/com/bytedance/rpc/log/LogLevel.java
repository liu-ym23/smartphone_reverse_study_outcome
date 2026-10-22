package com.bytedance.rpc.log;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum LogLevel extends Enum<LogLevel> {
    private static final /* synthetic */ LogLevel[] $VALUES = null;
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel NONE = null;
    public static final LogLevel VERBOSE = null;
    public static final LogLevel WARN = null;
    private int mLevel;

    static {
        LogLevel r0 = new LogLevel("NONE", 0, 0);
        NONE = r0;
        LogLevel r1 = new LogLevel("VERBOSE", 1, 2);
        VERBOSE = r1;
        LogLevel r3 = new LogLevel(CipherConst.LEVEL_DEBUG, 2, 3);
        DEBUG = r3;
        LogLevel r6 = new LogLevel(CipherConst.LEVEL_INFO, 3, 4);
        INFO = r6;
        LogLevel r8 = new LogLevel(CipherConst.LEVEL_WARN, 4, 5);
        WARN = r8;
        LogLevel r10 = new LogLevel(CipherConst.LEVEL_ERROR, 5, 6);
        ERROR = r10;
        $VALUES = new LogLevel[]{r0, r1, r3, r6, r8, r10};
    }

    private LogLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.mLevel = r3;
    }

    public static LogLevel valueOf(String r2) {
        return (LogLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(LogLevel.class, r2), LogLevel.class, "com.obric.memorydata.plugin");
    }

    public static LogLevel[] values() {
        return (LogLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LogLevel[].class, "com.obric.memorydata.plugin");
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean log() {
        if (this == NONE) goto L5;
        return true;
    L5:
        return false;
    }
}
