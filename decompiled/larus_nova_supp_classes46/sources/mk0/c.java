package mk0;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ mb6.b.a a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public c(GuestLinkPipeLineManager.b r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r7) {
        Throwable r3 = (Throwable) r7;
        jy0.b.b("GuestLinkApiManager", "enterChannel failed", r3);
        com.bytedance.live.kmp.util.a.b(r3);
        mb6.b.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.o(dc6.a.a(this.b), r3, this.c);
        return;
    }
}
