package x02;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ String a;

    public q(String r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        jy0.b.d("GiftSendTimeoutReportPlugin", "report prop success, traceId = " + this.a);
        c0 r4 = c0.a;
        c0.h(0);
    }
}
