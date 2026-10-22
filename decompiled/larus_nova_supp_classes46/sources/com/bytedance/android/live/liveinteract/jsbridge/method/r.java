package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GiftMessageBoardLinkmicResultModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ q a;

    public r(q r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((jd0.b) r3).a == false) goto L5;
        q r4 = this.a;
        GiftMessageBoardLinkmicResultModel r0 = new GiftMessageBoardLinkmicResultModel();
        r0.a(GiftMessageBoardLinkmicResultModel.Code.Success);
        Unit r1 = Unit.INSTANCE;
        r4.finishWithResult(r0);
        return;
    L5:
        q r5 = this.a;
        GiftMessageBoardLinkmicResultModel r2 = new GiftMessageBoardLinkmicResultModel();
        r2.a(GiftMessageBoardLinkmicResultModel.Code.Failed);
        Unit r6 = Unit.INSTANCE;
        r5.finishWithResult(r2);
    }
}
