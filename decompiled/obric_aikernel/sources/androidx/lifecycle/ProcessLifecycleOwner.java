package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleOwner implements LifecycleOwner {
    public static final Companion Companion = null;
    public static final long TIMEOUT_MS = 700;
    private static final ProcessLifecycleOwner newInstance = null;
    private final Runnable delayedPauseRunnable;
    private Handler handler;
    private final ReportFragment.ActivityInitializationListener initializationListener;
    private boolean pauseSent;
    private final LifecycleRegistry registry;
    private int resumedCounter;
    private int startedCounter;
    private boolean stopSent;

    @RequiresApi(29)
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = null;

        static {
            INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
        }

        @JvmStatic
        @DoNotInline
        public static final void registerActivityLifecycleCallbacks(Activity r10, Application.ActivityLifecycleCallbacks r11) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            Intrinsics.checkNotNullParameter(r11, "callback");
            r10.registerActivityLifecycleCallbacks(r11);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getTIMEOUT_MS$lifecycle_process_release$annotations() {
        }

        @JvmStatic
        public final LifecycleOwner get() {
            return ProcessLifecycleOwner.access$getNewInstance$cp();
        }

        @JvmStatic
        public final void init$lifecycle_process_release(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            ProcessLifecycleOwner.access$getNewInstance$cp().attach$lifecycle_process_release(r10);
        }
    }

    static {
        Companion = new Companion(null);
        newInstance = new ProcessLifecycleOwner();
    }

    private ProcessLifecycleOwner() {
        this.pauseSent = true;
        this.stopSent = true;
        this.registry = new LifecycleRegistry(this);
        this.delayedPauseRunnable = new e(this);
        this.initializationListener = new ProcessLifecycleOwner$initializationListener$1(this);
    }

    public static /* synthetic */ void a(ProcessLifecycleOwner r10) {
        delayedPauseRunnable$lambda$0(r10);
    }

    public static final /* synthetic */ ReportFragment.ActivityInitializationListener access$getInitializationListener$p(ProcessLifecycleOwner r10) {
        return r10.initializationListener;
    }

    public static final /* synthetic */ ProcessLifecycleOwner access$getNewInstance$cp() {
        return newInstance;
    }

    private static final void delayedPauseRunnable$lambda$0(ProcessLifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.dispatchPauseIfNeeded$lifecycle_process_release();
        r10.dispatchStopIfNeeded$lifecycle_process_release();
    }

    @JvmStatic
    public static final LifecycleOwner get() {
        return Companion.get();
    }

    @JvmStatic
    public static final void init$lifecycle_process_release(Context r10) {
        Companion.init$lifecycle_process_release(r10);
    }

    public final void activityPaused$lifecycle_process_release() {
        int r10 = this.resumedCounter - 1;
        this.resumedCounter = r10;
        if (r10 != 0) goto L6;
        Handler r11 = this.handler;
        Intrinsics.checkNotNull(r11);
        r11.postDelayed(this.delayedPauseRunnable, 700);
        return;
    }

    public final void activityResumed$lifecycle_process_release() {
        int r10 = this.resumedCounter + 1;
        this.resumedCounter = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.pauseSent == false) goto L7;
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.pauseSent = false;
        return;
    L7:
        Handler r11 = this.handler;
        Intrinsics.checkNotNull(r11);
        r11.removeCallbacks(this.delayedPauseRunnable);
    }

    public final void activityStarted$lifecycle_process_release() {
        int r10 = this.startedCounter + 1;
        this.startedCounter = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.stopSent == false) goto L9;
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.stopSent = false;
        return;
    }

    public final void activityStopped$lifecycle_process_release() {
        this.startedCounter--;
        dispatchStopIfNeeded$lifecycle_process_release();
    }

    public final void attach$lifecycle_process_release(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.handler = new Handler();
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context r11 = r10.getApplicationContext();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.Application");
        ((Application) r11).registerActivityLifecycleCallbacks(new ProcessLifecycleOwner$attach$1(this));
    }

    public final void dispatchPauseIfNeeded$lifecycle_process_release() {
        if (this.resumedCounter != 0) goto L6;
        this.pauseSent = true;
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        return;
    }

    public final void dispatchStopIfNeeded$lifecycle_process_release() {
        if (this.startedCounter == 0) goto L5;
        return;
    L5:
        if (this.pauseSent == false) goto L9;
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.stopSent = true;
        return;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.registry;
    }
}
