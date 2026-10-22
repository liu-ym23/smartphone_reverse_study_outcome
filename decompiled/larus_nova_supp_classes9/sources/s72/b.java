package s72;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r72.j;
import r72.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final a a;
    public WeakHandler b;
    public HandlerThread c;
    public final Handler d;
    public final Function1<va, k32.a> e;
    public final Function1<k32.a, Unit> f;

    public final void a(va r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (this.b == null) goto L8;
        HandlerThread r0 = this.c;
        if (r0 == null) goto L8;
        if (ThreadMethodProxy.isAlive(r0) != true) goto L8;
    L9:
        WeakHandler r1 = this.b;
        Intrinsics.checkNotNull(r1);
        Message.obtain(r1, 12345, r4).sendToTarget();
        return;
    L8:
        HandlerThread r2 = zb2.a.a();
        this.c = r2;
        this.b = new WeakHandler(r2.getLooper(), this.a);
        goto L9
    }

    public b(Handler r2, j r3, k r4) {
        Intrinsics.checkNotNullParameter(r2, "uiHandler");
        Intrinsics.checkNotNullParameter(r3, "processFunc");
        Intrinsics.checkNotNullParameter(r4, "rendFunc");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new a(this);
    }
}
