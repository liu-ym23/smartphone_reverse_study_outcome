package com.obric.search.common.log;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.obric.search.common.log.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006JP\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000626\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00180\u001dH\u0002J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/obric/search/common/log/RuntimeLogger;", "", "()V", "MAX_LENGTH", "", "TAG_PREFIX", "", "<set-?>", "Lcom/obric/search/common/log/RuntimeLogger$LogLevel;", "logLevel", "getLogLevel", "()Lcom/obric/search/common/log/RuntimeLogger$LogLevel;", "setLogLevel", "(Lcom/obric/search/common/log/RuntimeLogger$LogLevel;)V", "logger", "Lcom/obric/search/common/log/intf/ILogger;", "getLogger", "()Lcom/obric/search/common/log/intf/ILogger;", "setLogger", "(Lcom/obric/search/common/log/intf/ILogger;)V", "canLog", "", "level", "debug", "", LocationMonitorConst.TAG, "message", "doLogWith", "logMethod", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "error", "info", "warn", "LogLevel", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RuntimeLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RuntimeLogger f14958a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f14959b;
    private static LogLevel c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/search/common/log/RuntimeLogger$LogLevel;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", CipherConst.LEVEL_DEBUG, CipherConst.LEVEL_INFO, CipherConst.LEVEL_WARN, CipherConst.LEVEL_ERROR, "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum LogLevel extends Enum<LogLevel> {
        private static final /* synthetic */ LogLevel[] $VALUES = null;
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel WARN = null;
        private final int value;

        private static final /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{DEBUG, INFO, WARN, ERROR};
        }

        static {
            DEBUG = new LogLevel(CipherConst.LEVEL_DEBUG, 0, 0);
            INFO = new LogLevel(CipherConst.LEVEL_INFO, 1, 1);
            WARN = new LogLevel(CipherConst.LEVEL_WARN, 2, 2);
            ERROR = new LogLevel(CipherConst.LEVEL_ERROR, 3, 3);
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

    static {
        f14958a = new RuntimeLogger();
        f14959b = (a) ZeusTransformUtils.preCheckCast(new com.obric.search.common.log.a.a(), a.class, "com.obric.memorydata.plugin");
        c = LogLevel.DEBUG;
    }

    private RuntimeLogger() {
    }

    private final void a(String r3, String r4, Function2<? super String, ? super String, Unit> r5) {
        Function2 r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        String r6 = "SeSDK_" + r3;
        if (r4.length() > 2048) goto L6;
        r2.invoke(r6, r4);
        return;
    L6:
        int r7 = 0;
    L8:
        if (r7 >= r4.length()) goto L10;
        int r0 = r7 + 2048;
        String r8 = r4.substring(r7, Math.min(r0, r4.length()));
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        r2.invoke(r6, r8);
        r7 = r0;
        goto L8
    }

    private final boolean b(LogLevel r1) {
        if (r1.getValue() < c.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final a a() {
        return f14959b;
    }

    public final synchronized void a(LogLevel r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");     // Catch: Throwable -> L6
        c = r2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        f14959b = r1;
    }

    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "message");
        if (b(LogLevel.DEBUG) == true) goto L5;
        return;
    L5:
        a(r4, r5, (Function2) ZeusTransformUtils.preCheckCast(RuntimeLogger$debug$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    }

    public final void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "message");
        if (b(LogLevel.INFO) == true) goto L5;
        return;
    L5:
        a(r4, r5, (Function2) ZeusTransformUtils.preCheckCast(RuntimeLogger$info$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    }

    public final void c(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "message");
        if (b(LogLevel.WARN) == true) goto L5;
        return;
    L5:
        a(r4, r5, (Function2) ZeusTransformUtils.preCheckCast(RuntimeLogger$warn$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    }

    public final void d(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "message");
        if (b(LogLevel.ERROR) == true) goto L5;
        return;
    L5:
        a(r4, r5, (Function2) ZeusTransformUtils.preCheckCast(RuntimeLogger$error$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    }
}
