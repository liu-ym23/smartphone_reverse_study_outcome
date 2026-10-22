package cvc;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements ThreadFactory {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r3) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r3, this.a);
        r0.setDaemon(this.b);
        return r0;
    }

    public d(String r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
