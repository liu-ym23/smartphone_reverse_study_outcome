package a40;

import com.bytedance.android.live.cloudgrouplive.core.CloudGroupLiveManager;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ long b;

    public g(CloudGroupLiveManager.b r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
        int r7 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "LeaveCloudGroupLiveSuccess", 0, null, 28);
        n r8 = this.a;
        if (r8 == null) goto L6;
        dc6.a.a(this.b);
        r8.I3();
        return;
    }
}
