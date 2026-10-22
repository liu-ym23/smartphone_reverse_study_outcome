package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J$\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J.\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0007H&J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0005H&J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u001a"}, d2 = {"Lcom/obric/sva/sdk/logger/ILogger;", "", "isDebug", "", "v", "", "tag", "", "msg", "d", "i", "tr", "", "w", "e", "s", "category", "Lcom/obric/sva/sdk/logger/SpecialCategory;", "getDirPath", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "flush", "special", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface ILogger {
    public static final Companion Companion = null;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class DefaultImpls {
        public static void special(ILogger r0, String r1, SpecialCategory r2) {
            Intrinsics.checkNotNullParameter(r2, "category");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void uploadAllLog$default(ILogger r0, String r1, Function1 r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.uploadAllLog(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadAllLog");
        }

        public static /* synthetic */ void s$default(ILogger r0, String r1, String r2, SpecialCategory r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = SpecialCategory.WAKEUP_DURATION;
        L6:
            r0.s(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: s");
        }

        public static /* synthetic */ void s$default(ILogger r0, String r1, String r2, Throwable r3, SpecialCategory r4, int r5, Object r6) {
            if (r6 != null) goto L9;
            if ((r5 & 8) == 0) goto L6;
            r4 = SpecialCategory.WAKEUP_DURATION;
        L6:
            r0.s(r1, r2, r3, r4);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: s");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void d(String r1, String r2);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    void flush();

    String getDirPath();

    void i(String r1, String r2);

    void i(String r1, String r2, Throwable r3);

    boolean isDebug();

    void s(String r1, String r2, SpecialCategory r3);

    void s(String r1, String r2, Throwable r3, SpecialCategory r4);

    void special(String r1, SpecialCategory r2);

    void uploadAllLog(String r1, Function1<? super Boolean, Unit> r2);

    void v(String r1, String r2);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void w(String r1, Throwable r2);
}
