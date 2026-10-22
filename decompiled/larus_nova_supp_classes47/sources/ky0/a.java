package ky0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.alog.middleware.ALogService;
import jy0.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c, jy0.a, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // jy0.a
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        ALogService.iSafely(r2, r3);
    }

    @Override // jy0.a
    public final void k(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        ALogService.dSafely(r2, r3);
    }

    @Override // jy0.a
    public final void M3(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        if (r4 == null) goto L5;
        ALogService.eSafely(r2, r3, r4);
        return;
    L5:
        ALogService.eSafely(r2, r3);
    }

    @Override // jy0.a
    public final void d5(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        if (r4 == null) goto L5;
        ALogService.wSafely(r2, r3, r4);
        return;
    L5:
        ALogService.wSafely(r2, r3);
    }

    @Override // jy0.c
    public final void stacktrace(int r2, String r3, StackTraceElement[] r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        ALogger.stacktrace(r2, r3, r4);
    }
}
