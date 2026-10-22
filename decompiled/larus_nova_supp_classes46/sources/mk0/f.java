package mk0;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ mb6.b.c b;

    public f(long r1, com.bytedance.android.live.livelink.guestlink.pipeline.a r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        jy0.b.d("GuestLinkApiManager", "joinChannel success duration: " + dc6.a.a(this.a) + ", logId: " + r5.logId);
        mb6.b.c r0 = this.b;
        if (r0 == null) goto L6;
        r0.C2(dc6.a.a(this.a), r5);
        return;
    }
}
