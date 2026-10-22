package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x4 implements Action {
    public final /* synthetic */ w4 a;
    public final /* synthetic */ GetMessageBoardDataResultModel b;
    public final /* synthetic */ long c;
    public final /* synthetic */ w20.p9 d;

    public x4(w4 r1, GetMessageBoardDataResultModel r2, long r3, w20.p9 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void run() {
        this.a.finishWithResult(this.b);
        w4.k(this.a, this.c, this.d.b(), this.a.a);
    }
}
