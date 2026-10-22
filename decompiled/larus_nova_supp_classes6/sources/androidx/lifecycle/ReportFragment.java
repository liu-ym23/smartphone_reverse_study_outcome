package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "processListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "dispatchCreate", "", "listener", "dispatchStart", "dispatchResume", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "dispatch", EventVerify.TYPE_EVENT_V1, "Landroidx/lifecycle/Lifecycle$Event;", "setProcessListener", "ActivityInitializationListener", "LifecycleCallbacks", "Companion", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public class ReportFragment extends Fragment {
    public static final Companion Companion = null;
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\t8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/ReportFragment$Companion;", "", "<init>", "()V", "REPORT_FRAGMENT_TAG", "", "injectIfNeededIn", "", "activity", "Landroid/app/Activity;", "dispatch", EventVerify.TYPE_EVENT_V1, "Landroidx/lifecycle/Lifecycle$Event;", "dispatch$lifecycle_runtime", "reportFragment", "Landroidx/lifecycle/ReportFragment;", "get$annotations", "(Landroid/app/Activity;)V", "get", "(Landroid/app/Activity;)Landroidx/lifecycle/ReportFragment;", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void get$annotations(Activity r0) {
        }

        public final ReportFragment get(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Fragment r3 = r2.getFragmentManager().findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) r3;
        }

        @JvmStatic
        public final void injectIfNeededIn(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            LifecycleCallbacks.Companion.registerIn(r4);
        L5:
            FragmentManager r5 = r4.getFragmentManager();
            if (r5.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) != null) goto L9;
            r5.beginTransaction().add(new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
            r5.executePendingTransactions();
            return;
        }

        @JvmStatic
        public final void dispatch$lifecycle_runtime(Activity r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, EventVerify.TYPE_EVENT_V1);
            if ((r2 instanceof LifecycleRegistryOwner) == false) goto L7;
            ((LifecycleRegistryOwner) r2).getLifecycle().handleLifecycleEvent(r3);
            return;
        L7:
            if ((r2 instanceof LifecycleOwner) == false) goto L12;
            LifecycleRegistry r4 = ((LifecycleOwner) r2).getLifecycle();
            if ((r4 instanceof LifecycleRegistry) == false) goto L13;
            r4.handleLifecycleEvent(r3);
            return;
        L13:
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void dispatch$lifecycle_runtime(Activity r1, Lifecycle.Event r2) {
        Companion.dispatch$lifecycle_runtime(r1, r2);
    }

    public static final ReportFragment get(Activity r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final void injectIfNeededIn(Activity r1) {
        Companion.injectIfNeededIn(r1);
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

    public ReportFragment() {
    }

    private final void dispatch(Lifecycle.Event r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        Companion.dispatch$lifecycle_runtime(getActivity(), r3);
        return;
    }

    private final void dispatchCreate(ActivityInitializationListener r1) {
        if (r1 == null) goto L5;
        r1.onCreate();
        return;
    }

    private final void dispatchResume(ActivityInitializationListener r1) {
        if (r1 == null) goto L5;
        r1.onResume();
        return;
    }

    private final void dispatchStart(ActivityInitializationListener r1) {
        if (r1 == null) goto L5;
        r1.onStart();
        return;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    public final void setProcessListener(ActivityInitializationListener r1) {
        this.processListener = r1;
    }
}
