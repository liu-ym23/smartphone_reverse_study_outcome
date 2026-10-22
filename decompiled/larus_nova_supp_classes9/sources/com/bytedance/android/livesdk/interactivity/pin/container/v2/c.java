package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ PinContainerHighlightProcessor a;
    public final /* synthetic */ PinType b;
    public final /* synthetic */ g42.h c;
    public final /* synthetic */ long d;

    public c(PinContainerHighlightProcessor r1, PinType r2, g42.h r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r10) {
        Throwable r2 = (Throwable) r10;
        o32.a.b("pin event failed. pinType=" + this.b, r2);
        ExceptionUtils.handleException(this.a.getContext(), r2);
        int r11 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        g42.h r13 = this.c;
        long r3 = this.d;
        Room r6 = this.a.w();
        Intrinsics.checkNotNullParameter(r13, "pinEvent");
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a("request_pin", r13.a, r2, r3, null, r6, String.valueOf(r13.c));
    }
}
