package z4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final LinkedList<Activity> b = null;
    public static final LinkedList<Activity> c = null;
    public static final List<c> d = null;
    public static boolean e;
    public static List<String> f;

    /* JADX INFO: renamed from: z4.a$a, reason: collision with other inner class name */
    public static class C0216a extends b {
        public C0216a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            List<String> r0 = a.f;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r0 = null;
        L6:
            if (r0.contains(r10.getClass().getName()) == false) goto L8;
            return;
        L8:
            a.b.remove(r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            List<String> r1 = a.f;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r1 = null;
        L6:
            if (r1.contains(r10.getClass().getName()) == false) goto L8;
            return;
        L8:
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            a.c.add(r10);
            if (a.e == false) goto L16;
            a r0 = a.a;
            a.e = false;
            ArrayList r11 = (ArrayList) a.d;
            if ((!r11.isEmpty()) == false) goto L18;
            Iterator r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L19;
            ((c) r12.next()).onAppForeground();
            goto L14
        L19:
            return;
        L18:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            List<String> r1 = a.f;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r1 = null;
        L6:
            if (r1.contains(r10.getClass().getName()) == false) goto L8;
            return;
        L8:
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            LinkedList<Activity> r0 = a.c;
            r0.remove(r10);
            if (a.e == false) goto L11;
            return;
        L11:
            if (r0.isEmpty() == false) goto L20;
            a.e = true;
            List<c> r11 = a.d;
            if ((true ^ r11.isEmpty()) == false) goto L21;
            Iterator r12 = ((ArrayList) r11).iterator();
        L16:
            if (r12.hasNext() == false) goto L22;
            ((c) r12.next()).onAppBackground();
            goto L16
        L22:
            return;
        L21:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            List<String> r12 = a.f;
            if (r12 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r12 = null;
        L6:
            if (r12.contains(r10.getClass().getName()) == false) goto L8;
            return;
        L8:
            LinkedList<Activity> r13 = a.b;
            r13.remove(r10);
            r13.add(r10);
        }
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "outState");
        }
    }

    public interface c {
        void onAppBackground();

        void onAppForeground();
    }

    public a() {
    }

    public final synchronized Activity a() {
        monitor-enter(this);
        LinkedList<Activity> r0 = b;     // Catch: Throwable -> L12
        if (r0.isEmpty() == false) goto L6;
        Activity r1 = null;
    L7:
        if (r1 != null) goto L9;
    L14:
        monitor-exit(this);
        return r1;
    L9:
        if (r1.isFinishing() == false) goto L14;
        r0.removeLast();     // Catch: Throwable -> L12
        r1 = a();     // Catch: Throwable -> L12
        goto L14
    L6:
        r1 = r0.getLast();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    static {
        a = new a();
        b = new LinkedList();
        c = new LinkedList();
        d = new ArrayList();
        e = true;
    }
}
