package mk0;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ mb6.b.a b;
    public final /* synthetic */ long c;

    public b(long r1, GuestLinkPipeLineManager.b r3, long r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final void accept(Object r7) {
        ExtraResponse r3 = (ExtraResponse) r7;
        jy0.b.d("GuestLinkApiManager", "enterChannel success duration: " + dc6.a.a(this.a) + ", logId: " + r3.logId);
        mb6.b.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.h(dc6.a.a(this.a), r3, this.c);
        return;
    }
}
