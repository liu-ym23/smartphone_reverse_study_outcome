package pk0;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ wb6.a.d a;
    public final /* synthetic */ long b;

    public i(com.bytedance.live.bizlink.impl.platform.manager.a.i r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        LinkMonitor.a("LinkApiM", "kickOutSuccess", null, null, null, false, 124);
        wb6.a.d r0 = this.a;
        if (r0 == null) goto L6;
        dc6.a.a(this.b);
        r0.a(r9);
        return;
    }
}
