package c6;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3360b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f3361m;

    public c(d r8, Application r10) {
        this.f3361m = r8;
        this.f3359a = r10;
        this.f3360b = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r8 = this.f3361m;
        Context r10 = this.f3359a;
        if (r10 != null) goto L5;
        return;
    L5:
        WeakReference<Context> r11 = d.f3363d;
        if (r11 != null) goto L8;
    L9:
        d.f3363d = new WeakReference(r10.getApplicationContext());
    L19:
        ComponentName r12 = new ComponentName(r10, WsChannelService.class);     // Catch: Throwable -> L16
        d.b r13 = new d.b();     // Catch: Throwable -> L16
        if (this.f3360b == false) goto L13;
        int r14 = 9;
    L14:
        r13.f3367a = r14;     // Catch: Throwable -> L16
        r8.f3365b.offer(r13);     // Catch: Throwable -> L16
        d.a(r8, r12);     // Catch: Throwable -> L16
        return;
    L13:
        r14 = 11;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r11.get() != null) goto L19;
        goto L9
    }
}
