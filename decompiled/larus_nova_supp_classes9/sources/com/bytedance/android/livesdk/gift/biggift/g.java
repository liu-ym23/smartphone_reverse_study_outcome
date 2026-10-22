package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftFailedException;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public g(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        if ((r3 instanceof SendGiftFailedException) == false) goto L7;
        SendGiftFailedException r4 = (SendGiftFailedException) r3;
        if ((r4.getType() instanceof y.c.a.C0067a) == false) goto L9;
        this.a.invoke(Integer.valueOf(r4.getType().c));
        return;
    L9:
        return;
    L7:
        this.a.invoke(Integer.valueOf(r0.a(r3)));
    }
}
