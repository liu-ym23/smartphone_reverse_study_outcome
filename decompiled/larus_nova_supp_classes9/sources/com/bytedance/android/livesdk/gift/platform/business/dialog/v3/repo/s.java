package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ Ref.LongRef a;

    public s(Ref.LongRef r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        Ref.LongRef r5 = this.a;
        r5.element = System.currentTimeMillis();
    }
}
