package com.obric.assistant.ipc;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import rna.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements com.larus.platform.api.y {
    public d() {
    }

    public final boolean a() {
        return true;
    }

    public final void onGetId(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "did");
        Intrinsics.checkNotNullParameter(r4, "iid");
        Intrinsics.checkNotNullParameter(r5, "ssid");
        boolean r6 = b.a(r3);
        FLogger.a.i("HostStateSyncManager", "appLogIdCallback save doubaoDid saved=" + r6 + " didLength=" + r3.length());
    }
}
