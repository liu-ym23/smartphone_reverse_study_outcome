package mk0;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ mb6.b.b a;
    public final /* synthetic */ long b;

    public e(GuestLinkPipeLineManager.f r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        jy0.b.b("GuestLinkApiManager", "finishChannel failed", r5);
        com.bytedance.live.kmp.util.a.b(r5);
        mb6.b.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.r(dc6.a.a(this.b), r5);
        return;
    }
}
