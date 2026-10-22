package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v1<T, R> implements Function {
    public final /* synthetic */ long a;

    public v1(long r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        c32.c r0 = (c32.c) ((ExtraResponse) r5).data;
        if (r0 == null) goto L5;
        r0.a = this.a;
    L5:
        return r5;
    }
}
