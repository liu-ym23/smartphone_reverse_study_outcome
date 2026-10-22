package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ TempAreaDynamicLoader a;

    public j(TempAreaDynamicLoader r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "e");
        TempAreaDynamicLoader r0 = this.a;
        r0.h = false;
        ALogger.d(r0.p, r4.toString());
    }
}
