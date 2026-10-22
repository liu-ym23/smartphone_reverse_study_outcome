package pk0;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ wb6.a.f b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public m(a r1, com.bytedance.android.live.livelink.multilink.pipeline.e r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        LinkMonitor.a("LinkApiM", "notifyJoinRtc success", null, null, null, false, 124);
        wb6.a.f r0 = this.b;
        if (r0 == null) goto L5;
        r0.b(dc6.a.a(this.c), r9);
    L5:
        com.bytedance.android.live.liveinteract.plantform.utils.l r10 = this.a.b;
        String r1 = this.d;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r10.i4(r1);
    }
}
