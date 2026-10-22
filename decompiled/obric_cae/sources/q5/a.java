package q5;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Observable implements Application.ActivityLifecycleCallbacks, WeakHandler.IHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static a f10161o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f10162p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f10163q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RunnableC0141a f10165b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHandler f10166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f10167n;

    /* JADX INFO: renamed from: q5.a$a, reason: collision with other inner class name */
    public class RunnableC0141a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f10168a;

        public RunnableC0141a(a r8) {
            this.f10168a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f10168a;
            if (r8.f10164a == false) goto L6;
            r8.f10164a = false;
            Logger.d("ActivityLifecycleObserver", "sAppAlive = false");
            r8.getClass();
            return;
        }
    }

    public a() {
        this.f10165b = new RunnableC0141a(this);
        this.f10166m = new WeakHandler(this);
        this.f10167n = new ArrayList();
    }

    public final Object[] a() {
        ArrayList r8 = this.f10167n;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f10167n.size() <= 0) goto L7;
        Object[] r10 = this.f10167n.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = null;
        goto L8
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        if (r8.what == 1) goto L6;
        return;
    L6:
        if (f10163q == false) goto L9;
        setChanged();
        notifyObservers(Boolean.valueOf(f10163q));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r10) {
        Object[] r11 = a();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivityCreated(r8, r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r8) {
        Object[] r10 = a();
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((Application.ActivityLifecycleCallbacks) r10[r12]).onActivityDestroyed(r8);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r8) {
        if (this.f10164a == false) goto L5;
        this.f10166m.postDelayed(this.f10165b, 30000);
    L5:
        Object[] r10 = a();
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L12;
        ((Application.ActivityLifecycleCallbacks) r10[r12]).onActivityPaused(r8);
        r12 = r12 + 1;
        goto L8
    L12:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r8) {
        new WeakReference(r8);
        if (this.f10164a == true) goto L5;
        this.f10164a = true;
        Logger.d("ActivityLifecycleObserver", "onResume sAppAlive = true");
    L5:
        RunnableC0141a r10 = this.f10165b;
        this.f10166m.removeCallbacks(r10);
        Object[] r11 = a();
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L12;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivityResumed(r8);
        r13 = r13 + 1;
        goto L8
    L12:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r8, Bundle r10) {
        Object[] r11 = a();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivitySaveInstanceState(r8, r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r8) {
        Object[] r10 = a();
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        ((Application.ActivityLifecycleCallbacks) r10[r12]).onActivityStarted(r8);
        r12 = r12 + 1;
    L7:
        this.f10166m.removeMessages(1);
        int r13 = f10162p;
        if (r13 != 0) goto L10;
        f10163q = false;
    L10:
        f10162p = r13 + 1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r8) {
        Object[] r10 = a();
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        ((Application.ActivityLifecycleCallbacks) r10[r12]).onActivityStopped(r8);
        r12 = r12 + 1;
    L7:
        int r13 = f10162p - 1;
        f10162p = r13;
        if (r13 != 0) goto L12;
        f10163q = true;
        this.f10166m.sendEmptyMessageDelayed(1, 30000);
        return;
    }
}
