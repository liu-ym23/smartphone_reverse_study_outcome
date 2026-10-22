package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public f(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        this.a.invoke(0);
    }
}
