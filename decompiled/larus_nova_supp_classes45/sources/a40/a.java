package a40;

import com.bytedance.android.live.cloudgrouplive.core.CloudGroupLiveManager;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ l a;
    public final /* synthetic */ long b;

    public a(CloudGroupLiveManager.d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e<com.bytedance.android.live.cloudgrouplive.model.a> r7 = (com.bytedance.android.live.network.response.e) r6;
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "AcceptCloudGroupLiveSuccess", 0, null, 28);
        l r1 = this.a;
        if (r1 == null) goto L6;
        r1.b(dc6.a.a(this.b), r7);
        return;
    }
}
