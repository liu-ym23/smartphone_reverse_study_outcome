package c5;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.android.monitorV2.listener.d;
import com.bytedance.android.monitorV2.listener.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1121b;

    public b() {
        this.f1121b = c.f1123b;
    }

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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        boolean r10 = true;
        int r11 = this.f1120a + 1;
        this.f1120a = r11;
        a r12 = this.f1121b;
        if (r11 <= 0) goto L20;
        r12.getClass();
        Iterator r13 = ((ArrayList) r12.f1119c).iterator();     // Catch: Throwable -> L12
        if (r13.hasNext() == false) goto L20;
        if (r13.next() != null) goto L17;
        if (r5 == null) goto L15;
        r5.getApplicationContext();     // Catch: Throwable -> L12
    L15:
        throw null;     // Catch: Throwable -> L12
    L17:
        throw new ClassCastException();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        h.g("default_handle", th);
    L20:
        if (this.f1120a <= 0) goto L23;
        r10 = false;
    L23:
        r12.f1118b = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        int r5 = this.f1120a - 1;
        this.f1120a = r5;
        a r11 = this.f1121b;
        if (r5 > 0) goto L19;
        r11.getClass();
        Iterator r12 = ((ArrayList) r11.d).iterator();     // Catch: Throwable -> L11
    L6:
        if (r12.hasNext() == false) goto L19;
        com.bytedance.android.monitorV2.listener.c r13 = (com.bytedance.android.monitorV2.listener.c) r12.next();     // Catch: Throwable -> L11
        if (r10 == null) goto L13;
        r10.getApplicationContext();     // Catch: Throwable -> L11
    L13:
        e r14 = r13.f3612a;     // Catch: Throwable -> L11
        Handler r15 = r14.f3618c;     // Catch: Throwable -> L11
        if (r15 == null) goto L6;
        r15.post(new d(r14, 1));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        h.g("default_handle", th);
    L19:
        if (this.f1120a > 0) goto L21;
        boolean r16 = true;
    L22:
        r11.f1118b = r16;
        return;
    L21:
        r16 = false;
        goto L22
    }
}
