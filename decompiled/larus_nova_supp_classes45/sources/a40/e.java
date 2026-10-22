package a40;

import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ long b;

    public e(com.bytedance.android.live.cloudgrouplive.core.c r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
        int r7 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "JoinCloudGroupLiveSuccess", 0, null, 28);
        m r8 = this.a;
        if (r8 == null) goto L6;
        r8.b3(dc6.a.a(this.b));
        return;
    }
}
