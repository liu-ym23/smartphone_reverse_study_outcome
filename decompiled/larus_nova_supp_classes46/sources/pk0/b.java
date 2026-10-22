package pk0;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ wb6.a.a a;
    public final /* synthetic */ long b;

    public b(LinkPipelineManager.f r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        LinkMonitor.a("LinkApiM", "apply success ", null, null, null, false, 124);
        wb6.a.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.U8(dc6.a.a(this.b), r9);
        return;
    }
}
