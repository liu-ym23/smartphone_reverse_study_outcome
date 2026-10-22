package q8;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import r9.c;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.a f21492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakHandler f21493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f21494c;
    public final a d;
    public final a e;

    public b(c r5) {
        this.f21494c = new AtomicBoolean(false);
        this.d = new a(this, 0);
        this.e = new a(this, 1);
    }

    public final void a() {
        Logger.d("WsChannelSdk_ok", "ping sent，waiting for pong");
        this.f21494c.set(true);
        WeakHandler r5 = this.f21493b;
        a r10 = this.d;
        r5.removeCallbacks(r10);
        this.f21493b.postDelayed(r10, 5000);
    }
}
