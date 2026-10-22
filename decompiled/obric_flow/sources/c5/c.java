package c5;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1123b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f1124c = null;

    static {
        f1122a = new c();
        f1123b = new a(0);
        ArrayList r5 = new ArrayList();
        f1124c = r5;
        b r10 = new b();
        Intrinsics.checkNotNullParameter(r10, "delegate");
        r5.add(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Iterator r11 = f1124c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((b) r11.next()).getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Iterator r10 = f1124c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Iterator r10 = f1124c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Iterator r10 = f1124c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
        Iterator r11 = f1124c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((b) r11.next()).getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Iterator r10 = f1124c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).onActivityStarted(r5);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Iterator r10 = f1124c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).onActivityStopped(r5);
        goto L4
    }
}
