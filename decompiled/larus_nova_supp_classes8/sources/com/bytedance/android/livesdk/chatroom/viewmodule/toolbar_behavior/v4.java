package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v4<T> implements Consumer {
    public final /* synthetic */ Function2 a;

    public v4(Function2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        ALogger.e("ToolbarShakeMatchBehavior", "updateAudienceSettings fail-> errorInfo: " + r5);
        Function2 r0 = this.a;
        Boolean r1 = Boolean.FALSE;
        if ((r5 instanceof CustomApiServerException) == true) goto L5;
        r5 = null;
    L5:
        r0.invoke(r1, (CustomApiServerException) r5);
    }
}
