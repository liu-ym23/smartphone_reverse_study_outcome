package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveHighlightTranscodingResultModel;
import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j6 implements Action {
    public final /* synthetic */ LiveHighlightTranscodingResultModel a;
    public final /* synthetic */ List b;
    public final /* synthetic */ n6 c;
    public final /* synthetic */ w20.ua d;

    public j6(LiveHighlightTranscodingResultModel r1, List r2, n6 r3, w20.ua r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void run() {
        n6 r0 = this.c;
        w20.ua r1 = this.d;
        String r2 = r0.a;
        if (r2 == null) goto L5;
        TTExecutors.getNormalExecutor().submit(new h6(r2, r1));
    L5:
        this.a.a(LiveHighlightTranscodingResultModel.Code.Success);
        LiveHighlightTranscodingResultModel r3 = this.a;
        LiveHighlightTranscodingResultModel.a r4 = new LiveHighlightTranscodingResultModel.a();
        r4.a(this.b);
        Unit r5 = Unit.INSTANCE;
        r3.b(r4);
        this.c.finishWithResult(this.a);
    }
}
