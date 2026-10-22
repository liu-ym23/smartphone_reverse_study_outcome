package x02;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ String a;

    public p(String r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        if ((r5 instanceof RuntimeException) == true) goto L6;
        jy0.b.c("GiftSendTimeoutReportPlugin", "report gift fail, traceId = " + this.a + ", errmsg = " + r5.getMessage(), null, 4);
        c0 r6 = c0.a;
        c0.m(1);
        ToastUtil.a(2131922449, 0);
        return;
    }
}
