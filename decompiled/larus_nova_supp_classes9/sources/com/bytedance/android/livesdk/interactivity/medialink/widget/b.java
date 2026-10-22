package com.bytedance.android.livesdk.interactivity.medialink.widget;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ MediaLinkControlPresenter a;

    public b(MediaLinkControlPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        com.bytedance.android.livesdk.message.linker.a r5 = (com.bytedance.android.livesdk.message.linker.a) ((BaseResponse) r4).data;
        if (r5 == null) goto L16;
        List r6 = r5.b();
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.size() < 2) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L18;
        ((q46.b) this.a).a.OF();
        return;
    L18:
        return;
    L9:
        r0 = false;
        goto L10
    }
}
