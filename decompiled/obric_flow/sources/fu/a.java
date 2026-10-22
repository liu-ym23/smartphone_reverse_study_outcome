package fu;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import ju.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Stack f17013b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Stack f17014c = null;
    public static boolean d;
    public static Activity e;
    public static final CopyOnWriteArrayList f = null;

    static {
        f17012a = new a();
        f17013b = new Stack();
        f17014c = new Stack();
        d = true;
        f = new CopyOnWriteArrayList();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        e = r5;
        f17013b.add(r5);
        if (r10 != null) goto L5;
        boolean r11 = true;
    L6:
        String r12 = "create " + r5 + " " + r11;
        Intrinsics.checkNotNullParameter("ActivityManager", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L11;
        ((b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("ActivityManager", r12);
        return;
    L11:
        throw new IllegalStateException("KoinApplication has not been started");
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (Intrinsics.areEqual(e, r5) == false) goto L5;
        e = null;
    L5:
        Stack r10 = f17013b;
        r10.remove(r5);
        if (r10.isEmpty() == false) goto L12;
        Iterator r11 = f.iterator();
        if (r11.hasNext() == false) goto L12;
        throw androidx.constraintlayout.motion.widget.a.g(r11);
    L12:
        String r12 = "destroy " + r5;
        Intrinsics.checkNotNullParameter("ActivityManager", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L17;
        ((b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("ActivityManager", r12);
        return;
    L17:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        String r10 = "pause " + r5;
        Intrinsics.checkNotNullParameter("ActivityManager", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L7;
        ((b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("ActivityManager", r10);
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L12
        e = r5;     // Catch: Throwable -> L12
        if (d == false) goto L16;
        System.currentTimeMillis();     // Catch: Throwable -> L12
        d = false;     // Catch: Throwable -> L12
        Iterator r10 = f.iterator();     // Catch: Throwable -> L12
        if (r10.hasNext() == false) goto L16;
        if (r10.next() != null) goto L15;
        throw null;     // Catch: Throwable -> L12
    L15:
        throw new ClassCastException();     // Catch: Throwable -> L12
    L16:
        String r11 = "resume " + r5;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("ActivityManager", "tag");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Throwable -> L12
        org.koin.core.a r12 = su.a.f22013b;     // Catch: Throwable -> L12
        if (r12 == null) goto L22;
        ((b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("ActivityManager", r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L22:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        f17014c.add(r5);
        String r10 = "start " + r5;
        Intrinsics.checkNotNullParameter("ActivityManager", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L7;
        ((b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("ActivityManager", r10);
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L14
        Stack r10 = f17014c;     // Catch: Throwable -> L14
        r10.remove(r5);     // Catch: Throwable -> L14
        if (d == false) goto L7;
    L18:
        String r11 = "stop " + r5;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("ActivityManager", "tag");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Throwable -> L14
        org.koin.core.a r12 = su.a.f22013b;     // Catch: Throwable -> L14
        if (r12 == null) goto L24;
        ((b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).d("ActivityManager", r11);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L24:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L14
    L7:
        if (r10.isEmpty() == false) goto L18;
        d = true;     // Catch: Throwable -> L14
        Iterator r13 = f.iterator();     // Catch: Throwable -> L14
        if (r13.hasNext() == false) goto L18;
        if (r13.next() != null) goto L17;
        throw null;     // Catch: Throwable -> L14
    L17:
        throw new ClassCastException();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
