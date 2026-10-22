package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ CharSequence a;

    public b(CharSequence r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Response r4 = (Response) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d r0 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d) ((BaseResponse) r4).data;
        if (r0 == null) goto L5;
        r0.a = this.a.toString();
    L5:
        return r4;
    }
}
