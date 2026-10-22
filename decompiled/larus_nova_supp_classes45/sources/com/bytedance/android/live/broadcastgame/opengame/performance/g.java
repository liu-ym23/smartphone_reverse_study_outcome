package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public g(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.invoke();
        if ((r4 instanceof CustomApiServerException) == false) goto L5;
        f2.c(((CustomApiServerException) r4).getPrompt(), 0);
    L6:
        ALogger.d("OpenPlatformPerfReporter", "/task/run/ error " + r4.getMessage());
        return;
    L5:
        f2.c("启动性能上报失败，请重新开启性能测试！", 0);
        goto L6
    }
}
