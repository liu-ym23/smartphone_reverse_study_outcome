package zb2;

import android.os.HandlerThread;
import com.bytedance.android.live.liveinteract.f;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static PthreadHandlerThreadV2 a;
    public static final int b = 0;

    static {
        if (f.b == false) goto L5;
        int r0 = 0;
    L6:
        b = r0;
        return;
    L5:
        r0 = -2;
        goto L6
    }

    public static HandlerThread a() {
        PthreadHandlerThreadV2 r0 = a;
        if (r0 != null) goto L5;
    L8:
        PthreadHandlerThreadV2 r1 = a;
        if (r1 == null) goto L11;
        r1.quit();
    L11:
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("publicScreenRender", b);
        a = r2;
        ThreadMethodProxy.start(r2);
        PthreadHandlerThreadV2 r3 = a;
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        if (ThreadMethodProxy.isAlive(r0) != true) goto L8;
        PthreadHandlerThreadV2 r4 = a;
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
