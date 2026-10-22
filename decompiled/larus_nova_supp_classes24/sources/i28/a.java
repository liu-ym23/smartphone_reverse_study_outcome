package i28;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements ThreadFactory {
    public final /* synthetic */ AtomicInteger a;

    public a(AtomicInteger r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        return new PthreadThreadV2(r4, "LaunchThread#" + this.a.getAndIncrement());
    }
}
