package w64;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor;
import com.bytedance.badger.collect.impl.utils.KLog;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements z64.g {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    @Override // z64.g
    public final void a(i r4) {
        if ((r4 instanceof i.b) == false) goto L8;
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "sim change, success " + ((i.b) r4).c);
        if (NetworkStatusMonitor.isStarted() == false) goto L11;
        NetworkStatusMonitor.getInstance(this.a.a.a).stop();
        return;
    L11:
        return;
    L8:
        if ((r4 instanceof i.a) == false) goto L13;
        KLog.e(Constants.TAGS.NETWORK_MONITOR, "sim change, error " + ((i.a) r4).a);
        return;
    }
}
