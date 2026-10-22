package d4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.scene.listener.AppPageStackMonitor$FragmentStackCallback;
import kotlin.jvm.internal.Intrinsics;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f16589b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16590a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        String r10 = r5.getClass().getSimpleName();
        if ((r5 instanceof FragmentActivity) == false) goto L5;
        ((FragmentActivity) r5).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new AppPageStackMonitor$FragmentStackCallback(), true);
    L5:
        h.a().b(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }
}
