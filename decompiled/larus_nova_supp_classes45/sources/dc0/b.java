package dc0;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import mb0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public b(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r6) {
        e r7 = (e) r6;
        d.b(LinkMonitorData.ApiGetTuningInfo, System.currentTimeMillis() - this.a, ((ExtraResponse) r7).logId);
        this.b.invoke(r7);
    }
}
