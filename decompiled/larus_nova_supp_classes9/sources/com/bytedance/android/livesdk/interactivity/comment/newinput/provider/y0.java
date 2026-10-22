package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y0<T> implements Consumer {
    public final /* synthetic */ MarkHighlightController a;

    public y0(MarkHighlightController r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.highlight.a r6 = (com.bytedance.android.livesdk.interactivity.comment.highlight.a) ((BaseResponse) r5).data;
        if (r6 == null) goto L14;
        List<com.bytedance.android.livesdk.interactivity.comment.highlight.b> r7 = r6.a();
        if (r7 == null) goto L14;
        if ((!r7.isEmpty()) == true) goto L12;
        r7 = null;
    L12:
        if (r7 == null) goto L14;
        MarkHighlightController r0 = this.a;
        r0.getClass();
        r0.k(0);
        MarkHighlightController r1 = this.a;
        r1.r = r7;
        MarkHighlightController.HighlightViewAdapter r2 = r1.m;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        ((ArrayList) r2.b).clear();
        ((ArrayList) r2.b).addAll(r7);
        r1.m.notifyDataSetChanged();
        return;
    L14:
        MarkHighlightController r8 = this.a;
        r8.k(r8.d);
    }
}
