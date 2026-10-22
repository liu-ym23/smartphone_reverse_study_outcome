package mk0;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ mb6.b.b b;
    public final /* synthetic */ String c;

    public d(long r1, GuestLinkPipeLineManager.f r3, String r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final void accept(Object r5) {
        ExtraResponse r6 = (ExtraResponse) r5;
        jy0.b.d("GuestLinkApiManager", "finishChannel success duration: " + dc6.a.a(this.a) + ", logId: " + r6.logId);
        mb6.b.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.j(dc6.a.a(this.a), this.c, r6);
        return;
    }
}
