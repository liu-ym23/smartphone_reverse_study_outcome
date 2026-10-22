package pk0;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ wb6.a.e c;

    public k(String r1, long r2, com.bytedance.android.live.livelink.multilink.pipeline.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        LinkMonitor.a("LinkApiM", "leaveChannel success", null, null, null, false, 124);
        InteractLinkFullLinkMonitor.x(this.a, dc6.a.a(this.b), r9.logId);
        wb6.a.e r0 = this.c;
        if (r0 == null) goto L6;
        r0.Xf(dc6.a.a(this.b), r9);
        return;
    }
}
