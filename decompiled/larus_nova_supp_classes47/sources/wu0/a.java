package wu0;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateFansclubInfoResultModel;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.lb;
import w20.r3;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends r3<lb, LiveUpdateFansclubInfoResultModel> {
    public a() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((lb) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        o r4 = c.c();
        if (r4 == null) goto L5;
        r4.Gd(11);
        finishWithSuccess();
        return;
    L5:
        finishWithFailure();
    }
}
