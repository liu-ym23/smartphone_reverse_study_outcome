package w5;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import c6.d;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f12977m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final WeakHandler f12978n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12980b;

    /* JADX INFO: renamed from: w5.a$a, reason: collision with other inner class name */
    public static class C0185a implements WeakHandler.IHandler {
        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r8) {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f12981a;

        public b(a r8) {
            this.f12981a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (Logger.debug() == false) goto L6;
            Logger.d("WsChannelSdk", "sRunnable AppAlive = " + a.f12977m);
        L6:
            if (a.f12977m == false) goto L11;
            a.f12977m = false;
            if (this.f12981a.f12979a == null) goto L12;
            d.c(w5.c.f12986b, 2);
            return;
        L12:
            return;
        }
    }

    public interface c {
    }

    static {
        f12978n = new WeakHandler(Looper.getMainLooper(), new C0185a());
    }

    public a() {
        this.f12980b = new b(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r8) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r8) {
        if (f12977m == false) goto L6;
        f12978n.postDelayed(this.f12980b, 3000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r8) {
        if (f12977m == true) goto L8;
        f12977m = true;
        if (this.f12979a == null) goto L8;
        d.c(w5.c.f12986b, 1);
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + f12977m);
    L10:
        f12978n.removeCallbacks(this.f12980b);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r8) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r8) {
    }
}
