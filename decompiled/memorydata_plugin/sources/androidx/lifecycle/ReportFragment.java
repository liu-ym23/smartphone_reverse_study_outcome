package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import com.volcengine.zeus.fragment.ReportBaseFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0003\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "()V", "processListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "dispatch", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatchCreate", "listener", "dispatchResume", "dispatchStart", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "setProcessListener", "ActivityInitializationListener", "Companion", "LifecycleCallbacks", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ReportFragment extends ReportBaseFragment {
    public static final Companion Companion = null;
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_zeus_com_obric_memorydata_plugin";
    private ActivityInitializationListener processListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "", "onCreate", "", "onResume", "onStart", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/ReportFragment$Companion;", "", "()V", "REPORT_FRAGMENT_TAG", "", "reportFragment", "Landroidx/lifecycle/ReportFragment;", "Landroid/app/Activity;", "get$annotations", "(Landroid/app/Activity;)V", "get", "(Landroid/app/Activity;)Landroidx/lifecycle/ReportFragment;", "dispatch", "", "activity", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatch$lifecycle_runtime_release", "injectIfNeededIn", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void get$annotations(Activity r2) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final void dispatch$lifecycle_runtime_release(Activity r2, Lifecycle.Event r3) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "activity");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (ZeusTransformUtils.instanceOf(r1, LifecycleRegistryOwner.class) == false) goto L7;
            ((LifecycleRegistryOwner) ZeusTransformUtils.preCheckCast(r1, LifecycleRegistryOwner.class, "com.obric.memorydata.plugin")).getLifecycle().handleLifecycleEvent(r3);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r1, LifecycleOwner.class) == false) goto L12;
            Lifecycle r4 = ((LifecycleOwner) ZeusTransformUtils.preCheckCast(r1, LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle();
            if (ZeusTransformUtils.instanceOf(r4, LifecycleRegistry.class) == false) goto L13;
            ((LifecycleRegistry) ZeusTransformUtils.preCheckCast(r4, LifecycleRegistry.class, "com.obric.memorydata.plugin")).handleLifecycleEvent(r3);
            return;
        L13:
            return;
        }

        public final ReportFragment get(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Fragment r3 = r1.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) ZeusTransformUtils.preCheckCast(r3, ReportFragment.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final void injectIfNeededIn(Activity r5) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "activity");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            LifecycleCallbacks.Companion.registerIn(r4);
        L5:
            FragmentManager r6 = r4.getFragmentManager();
            if (r6.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") != null) goto L9;
            r6.beginTransaction().add((Fragment) ZeusTransformUtils.preCheckCast(new ReportFragment(), Fragment.class, "com.obric.memorydata.plugin"), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            r6.executePendingTransactions();
            return;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPostCreated", "savedInstanceState", "onActivityPostResumed", "onActivityPostStarted", "onActivityPreDestroyed", "onActivityPrePaused", "onActivityPreStopped", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "Companion", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks$Companion;", "", "()V", "registerIn", "", "activity", "Landroid/app/Activity;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            @JvmStatic
            public final void registerIn(Activity r3) {
                Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "activity");
                r2.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(new LifecycleCallbacks(), Application.ActivityLifecycleCallbacks.class, "com.obric.memorydata.plugin"));
            }
        }

        static {
            Companion = new Companion(null);
        }

        public LifecycleCallbacks() {
        }

        @JvmStatic
        public static final void registerIn(Activity r2) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Companion.registerIn(r3);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r0, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r0, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r1, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r1, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r1, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r1, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(r1, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            Intrinsics.checkNotNullParameter(r3, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ReportFragment() {
    }

    private final void dispatch(Lifecycle.Event r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        Companion r0 = Companion;
        Activity r2 = ZeusTransformUtils.getActivity(this, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "activity");
        r0.dispatch$lifecycle_runtime_release(r2, r3);
        return;
    }

    @JvmStatic
    public static final void dispatch$lifecycle_runtime_release(Activity r2, Lifecycle.Event r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Companion.dispatch$lifecycle_runtime_release(r4, r3);
    }

    private final void dispatchCreate(ActivityInitializationListener r2) {
        ActivityInitializationListener r1 = (ActivityInitializationListener) ZeusTransformUtils.wrapperContextForParams(r2, ActivityInitializationListener.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onCreate();
        return;
    }

    private final void dispatchResume(ActivityInitializationListener r2) {
        ActivityInitializationListener r1 = (ActivityInitializationListener) ZeusTransformUtils.wrapperContextForParams(r2, ActivityInitializationListener.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onResume();
        return;
    }

    private final void dispatchStart(ActivityInitializationListener r2) {
        ActivityInitializationListener r1 = (ActivityInitializationListener) ZeusTransformUtils.wrapperContextForParams(r2, ActivityInitializationListener.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onStart();
        return;
    }

    public static final ReportFragment get(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        return Companion.get(r3);
    }

    @JvmStatic
    public static final void injectIfNeededIn(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Companion.injectIfNeededIn(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityCreated(Bundle r1) {
        super/*android.app.Fragment*/.onActivityCreated(r1);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Fragment*/.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*android.app.Fragment*/.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*android.app.Fragment*/.onResume();
        dispatchResume(this.processListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart() {
        super/*android.app.Fragment*/.onStart();
        dispatchStart(this.processListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStop() {
        super/*android.app.Fragment*/.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    public final void setProcessListener(ActivityInitializationListener r3) {
        this.processListener = (ActivityInitializationListener) ZeusTransformUtils.wrapperContextForParams(r3, ActivityInitializationListener.class, "com.obric.memorydata.plugin");
    }
}
