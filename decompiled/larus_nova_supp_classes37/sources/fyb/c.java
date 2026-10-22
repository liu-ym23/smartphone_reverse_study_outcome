package fyb;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements ThreadFactory {
    public c() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r3) {
        return new PthreadThreadV2(r3, "HeartBeatThread");
    }
}
