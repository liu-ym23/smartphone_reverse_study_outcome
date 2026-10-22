package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public e(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.d("OpenPlatformPerfReporter", "/task/finish/ error: " + ((Throwable) r3).getMessage());
        this.a.invoke(1);
    }
}
