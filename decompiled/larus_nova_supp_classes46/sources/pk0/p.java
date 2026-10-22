package pk0;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ wb6.a.g a;
    public final /* synthetic */ long b;

    public p(com.bytedance.live.bizlink.impl.platform.manager.a.m r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        LinkMonitor.a("LinkApiM", "permit failed", String.valueOf(r9), null, null, false, 120);
        wb6.a.g r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(dc6.a.a(this.b), r9);
        return;
    }
}
