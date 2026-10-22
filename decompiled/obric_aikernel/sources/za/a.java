package za;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f13813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f13814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<Activity> f13816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f13817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f13818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f13819g;

    /* JADX INFO: renamed from: za.a$a, reason: collision with other inner class name */
    class C0324a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f13820b;

        C0324a(a r10) {
            this.f13820b = r10;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
            a.d(this.f13820b, true);
            if (a.b(this.f13820b) != 0) goto L7;
            if (r10 == null) goto L8;
            a.c(this.f13820b, r10.hashCode());
            return;
        L8:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
            int r11 = a.b(this.f13820b);
            a.d(this.f13820b, false);
            a r12 = this.f13820b;
            if (r10 == null) goto L5;
            int r13 = r10.hashCode();
        L6:
            a.c(r12, r13);
            if (r11 != 0) goto L10;
            a.e(this.f13820b);
            return;
        L10:
            return;
        L5:
            r13 = r11;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
            a.a(this.f13820b, new WeakReference(r10));
            int r11 = a.b(this.f13820b);
            a r12 = this.f13820b;
            if (r10 == null) goto L5;
            int r13 = r10.hashCode();
        L6:
            a.c(r12, r13);
            a.d(this.f13820b, false);
            if (r11 != 0) goto L10;
            a.e(this.f13820b);
            return;
        L10:
            return;
        L5:
            r13 = r11;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
            if (r10 != null) goto L5;
        L7:
            a.d(this.f13820b, false);
            return;
        L5:
            if (r10.hashCode() != a.b(this.f13820b)) goto L7;
            a.c(this.f13820b, 0);
            a.f(this.f13820b);
            goto L7
        }
    }

    public interface b {
        @MainThread
        void a();

        @MainThread
        void b();
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f13821a = null;

        static {
            f13821a = new a(null);
        }

        static /* synthetic */ a a() {
            return f13821a;
        }
    }

    private a() {
        this.f13814b = new ArrayList();
        this.f13817e = -1;
        this.f13819g = new C0324a(this);
    }

    /* synthetic */ a(C0324a r10) {
        this();
    }

    static /* synthetic */ WeakReference a(a r10, WeakReference r11) {
        r10.f13816d = r11;
        return r11;
    }

    static /* synthetic */ int b(a r10) {
        return r10.f13815c;
    }

    static /* synthetic */ int c(a r10, int r11) {
        r10.f13815c = r11;
        return r11;
    }

    static /* synthetic */ boolean d(a r10, boolean r11) {
        r10.f13818f = r11;
        return r11;
    }

    static /* synthetic */ void e(a r10) {
        r10.j();
    }

    static /* synthetic */ void f(a r10) {
        r10.i();
    }

    private boolean g() {
        Application r10 = this.f13813a;     // Catch: Throwable -> L21
        if (r10 != null) goto L6;
        return false;
    L6:
        ActivityManager r11 = (ActivityManager) r10.getSystemService("activity");     // Catch: Throwable -> L21
        String r12 = r10.getPackageName();     // Catch: Throwable -> L21
        List<ActivityManager.RunningAppProcessInfo> r13 = r11.getRunningAppProcesses();     // Catch: Throwable -> L21
        if (r13 != null) goto L9;
    L20:
        return false;
    L9:
        if (r13.isEmpty() == true) goto L20;
        Iterator<ActivityManager.RunningAppProcessInfo> r14 = r13.iterator();     // Catch: Throwable -> L21
    L13:
        if (r14.hasNext() == false) goto L20;
        ActivityManager.RunningAppProcessInfo r15 = r14.next();     // Catch: Throwable -> L21
        if (r15.importance != 100) goto L13;
        if (TextUtils.equals(r15.processName, r12) == false) goto L13;
        return true;
    L21:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private Object[] h() {
        List<b> r10 = this.f13814b;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f13814b.size() <= 0) goto L7;
        Object[] r11 = this.f13814b.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = null;
        goto L8
    }

    private void i() {
        int r10 = 0;
        this.f13817e = 0;
        Object[] r11 = h();
        if (r11 == null) goto L7;
        int r12 = r11.length;
    L5:
        if (r10 >= r12) goto L9;
        ((b) r11[r10]).b();
        r10 = r10 + 1;
        goto L5
    L9:
        return;
    }

    private void j() {
        this.f13817e = 1;
        Object[] r10 = h();
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((b) r10[r12]).a();
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public static a k() {
        return c.a();
    }

    private int l() {
        int r10 = this.f13817e;
        if (r10 != (-1)) goto L6;
        boolean r11 = g();
        this.f13817e = r11 ? 1 : 0;
        return r11 ? 1 : 0;
    L6:
        return r10;
    }

    public void m(Context r10) {
        if (this.f13813a == null) goto L5;
        return;
    L5:
        if ((r10 instanceof Application) == false) goto L18;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f13813a != null) goto L10;
        Application r11 = (Application) r10;     // Catch: Throwable -> L12
        this.f13813a = r11;     // Catch: Throwable -> L12
        r11.registerActivityLifecycleCallbacks(this.f13819g);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    }

    public boolean n() {
        if (l() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        if (l() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void p(b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List<b> r11 = this.f13814b;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f13814b.contains(r10) == true) goto L9;
        this.f13814b.add(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    }
}
