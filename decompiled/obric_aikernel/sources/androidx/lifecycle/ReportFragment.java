package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {
    public static final Companion Companion = null;
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void get$annotations(Activity r10) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final void dispatch$lifecycle_runtime_release(Activity r10, Lifecycle.Event r11) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
            if ((r10 instanceof LifecycleRegistryOwner) == false) goto L7;
            ((LifecycleRegistryOwner) r10).getLifecycle().handleLifecycleEvent(r11);
            return;
        L7:
            if ((r10 instanceof LifecycleOwner) == false) goto L12;
            Lifecycle r12 = ((LifecycleOwner) r10).getLifecycle();
            if ((r12 instanceof LifecycleRegistry) == false) goto L13;
            ((LifecycleRegistry) r12).handleLifecycleEvent(r11);
            return;
        L13:
            return;
        }

        @JvmName(name = "get")
        public final ReportFragment get(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Fragment r11 = r10.getFragmentManager().findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) r11;
        }

        @JvmStatic
        public final void injectIfNeededIn(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            LifecycleCallbacks.Companion.registerIn(r10);
        L5:
            FragmentManager r11 = r10.getFragmentManager();
            if (r11.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) != null) goto L9;
            r11.beginTransaction().add(new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
            r11.executePendingTransactions();
            return;
        }
    }

    @RequiresApi(29)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = null;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            @JvmStatic
            public final void registerIn(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
                r10.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            }
        }

        static {
            Companion = new Companion(null);
        }

        public LifecycleCallbacks() {
        }

        @JvmStatic
        public static final void registerIn(Activity r10) {
            Companion.registerIn(r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r10, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r10, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r10, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r10, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r10, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r10, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            Intrinsics.checkNotNullParameter(r11, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ReportFragment() {
    }

    private final void dispatch(Lifecycle.Event r10) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        Companion r11 = Companion;
        Activity r12 = getActivity();
        Intrinsics.checkNotNullExpressionValue(r12, "activity");
        r11.dispatch$lifecycle_runtime_release(r12, r10);
        return;
    }

    @JvmStatic
    public static final void dispatch$lifecycle_runtime_release(Activity r10, Lifecycle.Event r11) {
        Companion.dispatch$lifecycle_runtime_release(r10, r11);
    }

    private final void dispatchCreate(ActivityInitializationListener r10) {
        if (r10 == null) goto L5;
        r10.onCreate();
        return;
    }

    private final void dispatchResume(ActivityInitializationListener r10) {
        if (r10 == null) goto L5;
        r10.onResume();
        return;
    }

    private final void dispatchStart(ActivityInitializationListener r10) {
        if (r10 == null) goto L5;
        r10.onStart();
        return;
    }

    @JvmName(name = "get")
    public static final ReportFragment get(Activity r10) {
        return Companion.get(r10);
    }

    @JvmStatic
    public static final void injectIfNeededIn(Activity r10) {
        Companion.injectIfNeededIn(r10);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        dispatchResume(this.processListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        dispatchStart(this.processListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    public final void setProcessListener(ActivityInitializationListener r10) {
        this.processListener = r10;
    }
}
