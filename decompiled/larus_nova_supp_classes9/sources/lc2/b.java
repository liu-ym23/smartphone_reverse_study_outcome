package lc2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.o;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final List<f<? extends t>> a;
    public boolean b;
    public final a c;
    public WeakHandler d;
    public HandlerThread e;
    public final e52.a f;
    public final Handler g;
    public final o h;
    public final Function1<List<? extends f<? extends t>>, Unit> i;

    public final void b() {
        if (this.a.isEmpty() == false) goto L8;
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.b) u.a.getValue()).dropUselessRenderPost == false) goto L8;
        return;
    L8:
        if (this.b == false) goto L14;
        Iterator<T> r0 = this.a.iterator();
    L11:
        if (r0.hasNext() == false) goto L14;
        f r1 = (f) r0.next();
        r1.q = Long.valueOf(System.currentTimeMillis());
    L14:
        if (this.d == null) goto L19;
        HandlerThread r2 = this.e;
        if (r2 == null) goto L19;
        if (ThreadMethodProxy.isAlive(r2) != true) goto L19;
    L20:
        WeakHandler r3 = this.d;
        Intrinsics.checkNotNull(r3);
        Message.obtain(r3, 10086, new LinkedList(this.a)).sendToTarget();
        ((LinkedList) this.a).clear();
        return;
    L19:
        HandlerThread r4 = zb2.a.a();
        this.e = r4;
        this.d = new WeakHandler(r4.getLooper(), this.c);
        goto L20
    }

    public final void a(f<? extends t> r2) {
        Intrinsics.checkNotNullParameter(r2, "absTextMessage");
        ((LinkedList) this.a).add(r2);
    }

    public b(e52.a r3, Handler r4, Function1 r5) {
        c r0 = c.b;
        Intrinsics.checkNotNullParameter(r3, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r4, "uiHandler");
        Intrinsics.checkNotNullParameter(r0, "processor");
        Intrinsics.checkNotNullParameter(r5, "rendFunc");
        this.f = r3;
        this.g = r4;
        this.h = r0;
        this.i = r5;
        this.a = new LinkedList();
        this.c = new a(this);
    }
}
