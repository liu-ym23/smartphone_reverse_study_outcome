package pk0;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ wb6.a.d a;
    public final /* synthetic */ long b;

    public j(com.bytedance.live.bizlink.impl.platform.manager.a.i r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        LinkMonitor.a("LinkApiM", "kickOutFailed", String.valueOf(r9), null, null, false, 120);
        wb6.a.d r0 = this.a;
        if (r0 == null) goto L6;
        dc6.a.a(this.b);
        r0.b(r9);
        return;
    }
}
