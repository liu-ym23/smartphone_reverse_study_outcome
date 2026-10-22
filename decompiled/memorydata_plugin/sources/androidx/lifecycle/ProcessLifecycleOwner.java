package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020\u0016H\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020\u0016H\u0000¢\u0006\u0002\b%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "delayedPauseRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "initializationListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "pauseSent", "", "registry", "Landroidx/lifecycle/LifecycleRegistry;", "resumedCounter", "", "startedCounter", "stopSent", "activityPaused", "", "activityPaused$lifecycle_process_release", "activityResumed", "activityResumed$lifecycle_process_release", "activityStarted", "activityStarted$lifecycle_process_release", "activityStopped", "activityStopped$lifecycle_process_release", "attach", "context", "Landroid/content/Context;", "attach$lifecycle_process_release", "dispatchPauseIfNeeded", "dispatchPauseIfNeeded$lifecycle_process_release", "dispatchStopIfNeeded", "dispatchStopIfNeeded$lifecycle_process_release", "Api29Impl", "Companion", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Api29Impl;", "", "()V", "registerActivityLifecycleCallbacks", "", "activity", "Landroid/app/Activity;", "callback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = null;

        static {
            INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
        }

        @JvmStatic
        public static final void registerActivityLifecycleCallbacks(Activity r2, Application.ActivityLifecycleCallbacks r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Application.ActivityLifecycleCallbacks r5 = (Application.ActivityLifecycleCallbacks) ZeusTransformUtils.wrapperContextForParams(r3, Application.ActivityLifecycleCallbacks.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "activity");
            Intrinsics.checkNotNullParameter(r5, "callback");
            r4.registerActivityLifecycleCallbacks(r5);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Companion;", "", "()V", "TIMEOUT_MS", "", "getTIMEOUT_MS$lifecycle_process_release$annotations", "newInstance", "Landroidx/lifecycle/ProcessLifecycleOwner;", "get", "Landroidx/lifecycle/LifecycleOwner;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "init$lifecycle_process_release", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getTIMEOUT_MS$lifecycle_process_release$annotations() {
        }

        @JvmStatic
        public final LifecycleOwner get() {
            return (LifecycleOwner) ZeusTransformUtils.preCheckCast(ProcessLifecycleOwner.access$getNewInstance$cp(), LifecycleOwner.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final void init$lifecycle_process_release(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            ProcessLifecycleOwner.access$getNewInstance$cp().attach$lifecycle_process_release(r1);
        }
    }

    static {
        Companion = new Companion(null);
        newInstance = new ProcessLifecycleOwner();
    }

    private ProcessLifecycleOwner() {
        this.pauseSent = true;
        this.stopSent = true;
        this.registry = new LifecycleRegistry((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"));
        this.delayedPauseRunnable = new $$Lambda$ProcessLifecycleOwner$8RHFmaqBQY2MpEYiTr99NwPTGEU(this);
        this.initializationListener = (ReportFragment.ActivityInitializationListener) ZeusTransformUtils.preCheckCast(new ProcessLifecycleOwner$initializationListener$1(this), ReportFragment.ActivityInitializationListener.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ReportFragment.ActivityInitializationListener access$getInitializationListener$p(ProcessLifecycleOwner r0) {
        return r0.initializationListener;
    }

    public static final /* synthetic */ ProcessLifecycleOwner access$getNewInstance$cp() {
        return newInstance;
    }

    private static final void delayedPauseRunnable$lambda$0(ProcessLifecycleOwner r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dispatchPauseIfNeeded$lifecycle_process_release();
        r1.dispatchStopIfNeeded$lifecycle_process_release();
    }

    @JvmStatic
    public static final LifecycleOwner get() {
        return Companion.get();
    }

    @JvmStatic
    public static final void init$lifecycle_process_release(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Companion.init$lifecycle_process_release(r3);
    }

    public static /* synthetic */ void lambda$8RHFmaqBQY2MpEYiTr99NwPTGEU(ProcessLifecycleOwner r0) {
        delayedPauseRunnable$lambda$0(r0);
    }

    public final void activityPaused$lifecycle_process_release() {
        int r0 = this.resumedCounter - 1;
        this.resumedCounter = r0;
        if (r0 != 0) goto L6;
        Handler r1 = this.handler;
        Intrinsics.checkNotNull(r1);
        r1.postDelayed(this.delayedPauseRunnable, 700);
        return;
    }

    public final void activityResumed$lifecycle_process_release() {
        int r0 = this.resumedCounter + 1;
        this.resumedCounter = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.pauseSent == false) goto L7;
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.pauseSent = false;
        return;
    L7:
        Handler r1 = this.handler;
        Intrinsics.checkNotNull(r1);
        r1.removeCallbacks(this.delayedPauseRunnable);
    }

    public final void activityStarted$lifecycle_process_release() {
        int r0 = this.startedCounter + 1;
        this.startedCounter = r0;
        if (r0 == 1) goto L5;
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

    public final void attach$lifecycle_process_release(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.handler = new Handler();
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.Application");
        ((Application) ZeusTransformUtils.preCheckCast(r6, Application.class, "com.obric.memorydata.plugin")).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(new ProcessLifecycleOwner$attach$1(this), Application.ActivityLifecycleCallbacks.class, "com.obric.memorydata.plugin"));
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
        return (Lifecycle) ZeusTransformUtils.preCheckCast(this.registry, Lifecycle.class, "com.obric.memorydata.plugin");
    }
}
