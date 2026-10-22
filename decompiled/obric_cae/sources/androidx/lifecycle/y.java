package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class y extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2204b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2205a;

    public interface a {
        void a();

        void b();

        void onResume();
    }

    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static void a(Activity r8, h.a r10) {
            he.i.f(r8, "activity");
            he.i.f(r10, "event");
            if ((r8 instanceof o) == false) goto L7;
            ((o) r8).getLifecycle().f(r10);
            return;
        L7:
            if ((r8 instanceof m) == false) goto L12;
            h r11 = ((m) r8).getLifecycle();
            if ((r11 instanceof n) == false) goto L13;
            ((n) r11).f(r10);
            return;
        L13:
            return;
        }

        public static void b(Activity r8) {
            he.i.f(r8, "activity");
            c.Companion.getClass();
            r8.registerActivityLifecycleCallbacks(new c());
            FragmentManager r10 = r8.getFragmentManager();
            if (r10.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") != null) goto L6;
            r10.beginTransaction().add(new y(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            r10.executePendingTransactions();
            return;
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = null;

        public static final class a {
        }

        static {
            Companion = new a();
        }

        public c() {
        }

        public static final void registerIn(Activity r8) {
            Companion.getClass();
            he.i.f(r8, "activity");
            r8.registerActivityLifecycleCallbacks(new c());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r8, Bundle r10) {
            he.i.f(r8, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r8) {
            he.i.f(r8, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r8) {
            he.i.f(r8, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r8, Bundle r10) {
            he.i.f(r8, "activity");
            int r11 = y.f2204b;
            b.a(r8, h.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r8) {
            he.i.f(r8, "activity");
            int r10 = y.f2204b;
            b.a(r8, h.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r8) {
            he.i.f(r8, "activity");
            int r10 = y.f2204b;
            b.a(r8, h.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r8) {
            he.i.f(r8, "activity");
            int r10 = y.f2204b;
            b.a(r8, h.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r8) {
            he.i.f(r8, "activity");
            int r10 = y.f2204b;
            b.a(r8, h.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r8) {
            he.i.f(r8, "activity");
            int r10 = y.f2204b;
            b.a(r8, h.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r8) {
            he.i.f(r8, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r8, Bundle r10) {
            he.i.f(r8, "activity");
            he.i.f(r10, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r8) {
            he.i.f(r8, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r8) {
            he.i.f(r8, "activity");
        }
    }

    public y() {
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle r8) {
        super.onActivityCreated(r8);
        a r10 = this.f2205a;
        if (r10 == null) goto L5;
        r10.a();
    L5:
        h.a.C0016a r11 = h.a.Companion;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        h.a.C0016a r8 = h.a.Companion;
        this.f2205a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        h.a.C0016a r8 = h.a.Companion;
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        a r8 = this.f2205a;
        if (r8 == null) goto L5;
        r8.onResume();
    L5:
        h.a.C0016a r10 = h.a.Companion;
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        a r8 = this.f2205a;
        if (r8 == null) goto L5;
        r8.b();
    L5:
        h.a.C0016a r10 = h.a.Companion;
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        h.a.C0016a r8 = h.a.Companion;
    }
}
