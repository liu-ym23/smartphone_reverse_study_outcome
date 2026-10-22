package mk0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ mb6.b.c a;
    public final /* synthetic */ long b;

    public g(com.bytedance.android.live.livelink.guestlink.pipeline.a r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        jy0.b.b("GuestLinkApiManager", "joinChannel failed", r5);
        com.bytedance.live.kmp.util.a.b(r5);
        mb6.b.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.o1(dc6.a.a(this.b), r5);
        return;
    }
}
