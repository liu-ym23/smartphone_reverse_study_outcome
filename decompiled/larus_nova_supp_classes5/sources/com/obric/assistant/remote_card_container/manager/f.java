package com.obric.assistant.remote_card_container.manager;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements e {
    public f() {
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.i(r2, r3);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.w(r2, r3);
    }

    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        FLogger.a.w(r2, r3, r4);
    }
}
