package w2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import androidx.work.WorkRequest;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f13307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static WeakHandler f13308e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f13309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f13310c;

    class a implements WeakHandler.IHandler {
        a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f13311c;

        b(e r10) {
            this.f13311c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.a() == false) goto L8;
            e.b(false);
            if (e.c(this.f13311c) == null) goto L9;
            e.c(this.f13311c).onEnterToBackground();
            return;
        L9:
            return;
        }
    }

    public interface c {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    static {
        f13308e = new WeakHandler(Looper.getMainLooper(), new a());
    }

    public e() {
        this.f13310c = new b(this);
        if (d() == null) goto L6;
        f13307d = true;
        return;
    }

    static /* synthetic */ boolean a() {
        return f13307d;
    }

    static /* synthetic */ boolean b(boolean r10) {
        f13307d = r10;
        return r10;
    }

    static /* synthetic */ c c(e r10) {
        return r10.f13309b;
    }

    private static Activity d() {
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r11 = r10.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r12 = r10.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r12.setAccessible(true);     // Catch: Throwable -> L14
        Map r13 = (Map) r12.get(r11);     // Catch: Throwable -> L14
        if (r13 != null) goto L6;
        return null;
    L6:
        Iterator r14 = r13.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();     // Catch: Throwable -> L14
        Class<?> r16 = r15.getClass();     // Catch: Throwable -> L14
        Field r17 = r16.getDeclaredField("paused");     // Catch: Throwable -> L14
        r17.setAccessible(true);     // Catch: Throwable -> L14
        if (r17.getBoolean(r15) == true) goto L8;
        Field r18 = r16.getDeclaredField("activity");     // Catch: Throwable -> L14
        r18.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r18.get(r15);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void e(c r10) {
        this.f13309b = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (f13307d == false) goto L6;
        f13308e.postDelayed(this.f13310c, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (f13307d == true) goto L7;
        f13307d = true;
        c r11 = this.f13309b;
        if (r11 == null) goto L7;
        r11.onEnterToForeground();
    L7:
        f13308e.removeCallbacks(this.f13310c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
    }
}
