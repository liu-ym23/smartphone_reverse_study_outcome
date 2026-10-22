package a40;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ long b;

    public f(com.bytedance.android.live.cloudgrouplive.core.c r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        int r0 = f40.a.a;
        CloudGroupLiveTraceEvent r1 = CloudGroupLiveTraceEvent.API_MANAGER;
        StringBuilder r2 = new StringBuilder("errorCode=");
        Integer r3 = null;
        if ((r7 instanceof ApiException) == true) goto L5;
        Throwable r4 = null;
    L6:
        ApiException r5 = (ApiException) r4;
        if (r5 == null) goto L9;
        r3 = Integer.valueOf(r5.getErrorCode());
    L9:
        r2.append(r3);
        r2.append(", errorMsg=");
        r2.append(r7.getMessage());
        f40.a.d(r1, "JoinCloudGroupLiveFailed", 0, r2.toString(), 20);
        m r8 = this.a;
        if (r8 == null) goto L13;
        r8.a3(dc6.a.a(this.b), r7);
        return;
    L13:
        return;
    L5:
        r4 = r7;
        goto L6
    }
}
