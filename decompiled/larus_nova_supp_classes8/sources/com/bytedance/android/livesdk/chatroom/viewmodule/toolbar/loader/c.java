package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.x70;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveMatrixLoader a;

    public c(LiveMatrixLoader r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        LiveMatrixLoader r0 = this.a;
        if (x70.a.getValue().booleanValue() == false) goto L5;
        boolean r5 = ((com.bytedance.android.livesdk.livematrix.a) ((BaseResponse) r4).data).a();
    L6:
        r0.i = r5;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
