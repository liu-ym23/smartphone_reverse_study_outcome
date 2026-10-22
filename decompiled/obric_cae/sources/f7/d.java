package f7;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import e7.e;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f7342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final WeakHandler f7343n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f7344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7345b;

    public static class a implements WeakHandler.IHandler {
        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r8) {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7346a;

        public b(d r8) {
            this.f7346a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.f7342m == false) goto L8;
            d.f7342m = false;
            c r8 = this.f7346a.f7344a;
            if (r8 == null) goto L9;
            r8.getClass();
            return;
        L9:
            return;
        }
    }

    public interface c {
    }

    static {
        f7343n = new WeakHandler(Looper.getMainLooper(), new a());
    }

    public d() {
        this.f7345b = new b(this);
        Activity r8 = null;
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L13
        Object r11 = r10.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
        Field r12 = r10.getDeclaredField("mActivities");     // Catch: Throwable -> L13
        r12.setAccessible(true);     // Catch: Throwable -> L13
        Map r13 = (Map) r12.get(r11);     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        Iterator r14 = r13.values().iterator();     // Catch: Throwable -> L13
    L8:
        if (r14.hasNext() == false) goto L15;
        Object r15 = r14.next();     // Catch: Throwable -> L13
        Class<?> r16 = r15.getClass();     // Catch: Throwable -> L13
        Field r17 = r16.getDeclaredField("paused");     // Catch: Throwable -> L13
        r17.setAccessible(true);     // Catch: Throwable -> L13
        if (r17.getBoolean(r15) == true) goto L8;
        Field r18 = r16.getDeclaredField("activity");     // Catch: Throwable -> L13
        r18.setAccessible(true);     // Catch: Throwable -> L13
        r8 = (Activity) r18.get(r15);     // Catch: Throwable -> L13
    L15:
        if (r8 == null) goto L23;
        f7342m = true;
        return;
    L23:
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r8) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r8) {
        if (f7342m == false) goto L6;
        f7343n.postDelayed(this.f7345b, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r8) {
        if (f7342m == true) goto L7;
        f7342m = true;
        if (this.f7344a == null) goto L7;
        e r10 = e.g();
        r10.getClass();
        Message r11 = Message.obtain();
        r11.obj = r10;
        r11.what = 7;
        e.F.sendMessage(r11);
    L7:
        f7343n.removeCallbacks(this.f7345b);
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
