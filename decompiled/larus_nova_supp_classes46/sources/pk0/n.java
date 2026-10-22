package pk0;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ wb6.a.f b;
    public final /* synthetic */ long c;

    public n(a r1, com.bytedance.android.live.livelink.multilink.pipeline.e r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        LinkMonitor.a("LinkApiM", "notifyJoinRtc failed " + r9, null, null, null, false, 124);
        wb6.a.f r0 = this.b;
        if (r0 == null) goto L5;
        dc6.a.a(this.c);
        r0.a(r9);
    L5:
        this.a.b.h6(r9);
    }
}
