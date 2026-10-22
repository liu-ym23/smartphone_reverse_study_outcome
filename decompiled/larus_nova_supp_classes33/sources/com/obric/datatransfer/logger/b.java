package com.obric.datatransfer.logger;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.obric.datatransfer.logger.a
    public final void log(TransferLogger.Level r2, String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r2, "level");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        if (r5 == null) goto L6;
        Log.getStackTraceString(r5);
    L6:
        r2.getLevelValue();
    }
}
