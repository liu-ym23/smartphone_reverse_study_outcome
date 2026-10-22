package ms.bd.c;

import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k0 {
    public static volatile k0 c;
    public final h0 a;
    public r0 b;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "a6a261", new byte[]{84, 45, 63, 85, 14, 23, 119, 18, 37, 103});
        c = null;
    }

    public static k0 a() {
        if (c != null) goto L15;
        monitor-enter(k0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new k0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k0.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public k0() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2((String) p2.a(16777217, 0, 0, "6a8263", new byte[]{3, 122, 102, 85, 14, 21, 32, 69, 124, 103}));
        ThreadMethodProxy.start(r0);
        this.a = new h0(this, r0.getLooper());
    }

    public final boolean b(i0 r3, String r4) {
        h0 r0 = this.a;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r3 != i0.d) goto L8;
        r0.removeMessages(r3.a);
        return true;
    L8:
        Message r1 = new Message();
        r1.what = r3.ordinal();
        r1.obj = r4;
        return this.a.sendMessage(r1);
    }
}
