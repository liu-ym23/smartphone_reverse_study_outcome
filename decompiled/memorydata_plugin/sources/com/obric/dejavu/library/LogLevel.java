package com.obric.dejavu.library;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/dejavu/library/LogLevel;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "Verbose", "Debug", "Info", "Warn", "Error", "Fatal", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    private static final /* synthetic */ LogLevel[] $VALUES = null;
    public static final LogLevel Debug = null;
    public static final LogLevel Default = null;
    public static final LogLevel Error = null;
    public static final LogLevel Fatal = null;
    public static final LogLevel Info = null;
    public static final LogLevel Verbose = null;
    public static final LogLevel Warn = null;
    private final int value;

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{Default, Verbose, Debug, Info, Warn, Error, Fatal};
    }

    static {
        Default = new LogLevel("Default", 0, 1);
        Verbose = new LogLevel("Verbose", 1, 2);
        Debug = new LogLevel("Debug", 2, 3);
        Info = new LogLevel("Info", 3, 4);
        Warn = new LogLevel("Warn", 4, 5);
        Error = new LogLevel("Error", 5, 6);
        Fatal = new LogLevel("Fatal", 6, 7);
        $VALUES = $values();
    }

    private LogLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static LogLevel valueOf(String r2) {
        return (LogLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(LogLevel.class, r2), LogLevel.class, "com.obric.memorydata.plugin");
    }

    public static LogLevel[] values() {
        return (LogLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LogLevel[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
