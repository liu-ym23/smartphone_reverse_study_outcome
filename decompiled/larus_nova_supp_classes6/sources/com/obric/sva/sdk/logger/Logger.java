package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\tJ&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/sva/sdk/logger/Logger;", "", "<init>", "()V", "isDebug", "", "getDirPath", "", "v", "", "tag", "msg", "d", "i", "w", "tr", "", "e", "flush", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "LogInfo", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class Logger {
    public static final Logger INSTANCE = null;

    static {
        INSTANCE = new Logger();
    }

    private Logger() {
    }

    public final void flush() {
    }

    public final void uploadAllLog(String r1, Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "scene");
    }

    public final String getDirPath() {
        return ILogDepend.a.getDirPath();
    }

    public final boolean isDebug() {
        return ILogDepend.a.isDebug();
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.i(r2, r3);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.e(r2, r3);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.i(r2, r3);
    }

    public final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.i(r2, r3);
    }

    public final void w(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        ILogDepend.a.w(r3, "", r4);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.w(r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.e(r2, r3, r4);
    }

    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogDepend.a.w(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void uploadAllLog$default(Logger r0, String r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.uploadAllLog(r1, r2);
    }
}
