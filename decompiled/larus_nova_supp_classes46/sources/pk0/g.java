package pk0;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ wb6.a.c a;
    public final /* synthetic */ long b;

    public g(LinkPipelineManager.j r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        LinkMonitor.a("LinkApiM", "join channel success", null, null, null, false, 124);
        vh7.e r0 = ((vh7.c) r9.data).castTo(IJoinChannelResult.class);
        vh7.e r1 = r0;
        com.bytedance.android.live.network.response.d.b r10 = k97.a.a(r1, r9.extra, r9.logId);
        wb6.a.c r2 = this.a;
        if (r2 == null) goto L6;
        r2.C2(dc6.a.a(this.b), r10);
        return;
    }
}
