package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ SquareTabWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Ref.BooleanRef c;

    public k(SquareTabWidget r1, int r2, Ref.BooleanRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        List<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.f> r6 = ((com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.a) ((BaseResponse) ((Response) r5)).data).a();
        if (r6 == null) goto L15;
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L15;
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.f r0 = (com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.f) r7.next();
        if (this.b != 1) goto L12;
        Ref.BooleanRef r1 = this.c;
        if (r1.element == true) goto L12;
        r0.a = false;
        r1.element = true;
    L12:
        SquareTabWidget r2 = this.a;
        int r3 = SquareTabWidget.i;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r4 = r2.xq();
        if (r4 == null) goto L6;
        r4.insertMessageSourceData(r0);
    L15:
        SquareTabWidget r8 = this.a;
        int r9 = SquareTabWidget.i;
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r10 = r8.wq();
        if (r10 == null) goto L24;
        r10.e();
        return;
    }
}
