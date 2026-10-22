package com.obric.assistant.ipc;

import com.larus.utils.logger.FLogger;
import com.obric.memorydata.sdk.ResultCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b0 implements ResultCallback<Boolean> {
    public b0() {
    }

    public final void onResult(int r4, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        FLogger.a.i("WakeupTruthUploadManager", "ContextAwareness init code=" + r4 + " result=" + ((Boolean) r6) + " msg=" + r5);
    }
}
