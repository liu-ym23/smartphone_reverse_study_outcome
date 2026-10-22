package l18;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements j18.a {
    public static b b;
    public final a a;

    public static class a extends Handler {
        public a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            super.handleMessage(r3);
            if (r3.what != 100) goto L8;
            Object r4 = r3.obj;
            if (r4 == null) goto L9;
            ((Runnable) r4).run();
            Log.i("LKDefaultAsyncHandleEve", "success run");
            return;
        L9:
            return;
        }
    }

    public b() {
        if (this.a == null) goto L5;
        return;
    L5:
        monitor-enter(LKEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.a != null) goto L9;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("innerDefaultAsyncHandler");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r1);     // Catch: Throwable -> L11
        this.a = new a(r1.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(LKEvent.class);     // Catch: Throwable -> L11
    }

    @Override // j18.a
    public final void a(String r2, i18.a r3) {
        this.a.obtainMessage(100, r3).sendToTarget();
    }
}
