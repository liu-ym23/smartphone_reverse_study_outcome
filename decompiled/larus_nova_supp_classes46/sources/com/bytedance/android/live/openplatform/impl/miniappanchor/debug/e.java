package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MiniAppAnchorDebugContextService a;

    public e(MiniAppAnchorDebugContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        UtilityKotlinExtentionsKt.s(0, false, false, new MiniAppAnchorDebugContextService$checkFastStartLiveInfo$3$1(this), 7);
    }
}
