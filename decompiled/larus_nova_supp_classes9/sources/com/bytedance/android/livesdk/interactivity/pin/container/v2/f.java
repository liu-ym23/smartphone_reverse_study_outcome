package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import g42.l;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PinContainerHighlightProcessor a;
    public final /* synthetic */ l b;
    public final /* synthetic */ long c;

    public f(PinContainerHighlightProcessor r1, l r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r1 = (Throwable) r7;
        o32.a.b("remove all failed", r1);
        ExceptionUtils.handleException(this.a.getContext(), r1);
        int r8 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.c(this.b, r1, this.c, null, this.a.w());
    }
}
