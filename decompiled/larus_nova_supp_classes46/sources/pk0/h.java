package pk0;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ wb6.a.c a;
    public final /* synthetic */ long b;

    public h(LinkPipelineManager.j r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        LinkMonitor.a("LinkApiM", "join channel failed " + r9, null, null, null, false, 124);
        wb6.a.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.o1(dc6.a.a(this.b), r9);
        return;
    }
}
