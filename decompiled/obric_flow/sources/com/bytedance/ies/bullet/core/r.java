package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5351a;

    public /* synthetic */ r(int r5) {
        this.f5351a = r5;
    }

    private final void b(Activity r5, Bundle r10) {
    }

    private final void c(Activity r5) {
    }

    private final void d(Activity r5) {
    }

    private final void e(Activity r5, Bundle r10) {
    }

    private final void f(Activity r5) {
    }

    private final void g(Activity r5) {
    }

    public void a(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        List r11 = q2.a.f;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
        r11 = null;
    L6:
        if (r11.contains(r5.getClass().getName()) == false) goto L8;
        return;
    L8:
        LinkedList r12 = q2.a.f21471b;
        r12.remove(r5);
        r12.add(r5);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        switch(this.f5351a) {
            case 0: goto L14;
            case 1: goto L24;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        a(r5, r10);
        t0.b r11 = com.bytedance.ai.model.p.f2294c;
        if (r11 != null) goto L7;
        return;
    L7:
        if ((r5 instanceof AppCompatActivity) == true) goto L9;
        return;
    L9:
        if ((((AppCompatActivity) r5).getResources().getConfiguration().uiMode & 48) != 32) goto L11;
        boolean r12 = true;
    L12:
        r11.changeNightMode(r12);
        return;
    L11:
        r12 = false;
        goto L12
    L14:
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r13 = s.f5354c;     // Catch: Throwable -> L21
        if (r13.contains(r5) == false) goto L18;
        r13.remove(r5);     // Catch: Throwable -> L21
    L18:
        r13.add(r5);     // Catch: Throwable -> L21
    L19:
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivityCreated"), null);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        List r10 = null;
        switch(this.f5351a) {
            case 0: goto L13;
            case 1: goto L22;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        List r11 = q2.a.f;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
    L9:
        if (r10.contains(r5.getClass().getName()) == true) goto L23;
        q2.a.f21471b.remove(r5);
        return;
    L23:
        return;
    L7:
        r10 = r11;
        goto L9
    L13:
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r12 = s.f5354c;     // Catch: Throwable -> L19
        if (r12.contains(r5) == false) goto L17;
        r12.remove(r5);     // Catch: Throwable -> L19
    L17:
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L19
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivityDestroyed"), null);     // Catch: Throwable -> L19
        return;
    L24:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        switch(this.f5351a) {
            case 0: goto L6;
            case 1: goto L15;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r10 = s.f5354c;     // Catch: Throwable -> L12
        if (r10.contains(r5) == true) goto L10;
        r10.add(r5);     // Catch: Throwable -> L12
    L10:
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivityPaused"), null);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        switch(this.f5351a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        TTNetInit.onActivityResume(r5);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r10 = s.f5354c;     // Catch: Throwable -> L14
        if (r10.contains(r5) == true) goto L12;
        r10.add(r5);     // Catch: Throwable -> L14
    L12:
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L14
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivityResumed"), null);     // Catch: Throwable -> L14
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        switch(this.f5351a) {
            case 0: goto L6;
            case 1: goto L12;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
        s r11 = s.f5352a;     // Catch: Throwable -> L9
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L9
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivitySaveInstanceState"), null);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        List r10 = null;
        switch(this.f5351a) {
            case 0: goto L21;
            case 1: goto L20;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        List r11 = q2.a.f;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
    L9:
        if (r10.contains(r5.getClass().getName()) == true) goto L32;
        Intrinsics.checkNotNullParameter(r5, "activity");
        q2.a.f21472c.add(r5);
        if (q2.a.e == false) goto L30;
        q2.a.e = false;
        ArrayList r12 = q2.a.d;
        if (r12.isEmpty() == true) goto L31;
        Iterator r13 = r12.iterator();
        if (r13.hasNext() == true) goto L19;
        return;
    L19:
        throw mn.h.c(r13);
    L31:
        return;
    L30:
        return;
    L32:
        return;
    L7:
        r10 = r11;
        goto L9
    L20:
        return;
    L21:
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r14 = s.f5354c;     // Catch: Throwable -> L27
        if (r14.contains(r5) == true) goto L25;
        r14.add(r5);     // Catch: Throwable -> L27
    L25:
        boolean r15 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L27
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivityStarted"), null);     // Catch: Throwable -> L27
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
        List r10 = null;
        switch(this.f5351a) {
            case 0: goto L23;
            case 1: goto L22;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        List r11 = q2.a.f;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
    L9:
        if (r10.contains(r5.getClass().getName()) == true) goto L35;
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r12 = q2.a.f21472c;
        r12.remove(r5);
        if (q2.a.e == false) goto L14;
        return;
    L14:
        if (r12.isEmpty() == false) goto L33;
        q2.a.e = true;
        ArrayList r13 = q2.a.d;
        if (r13.isEmpty() == true) goto L34;
        Iterator r14 = r13.iterator();
        if (r14.hasNext() == true) goto L21;
        return;
    L21:
        throw mn.h.c(r14);
    L34:
        return;
    L33:
        return;
    L35:
        return;
    L7:
        r10 = r11;
        goto L9
    L22:
        return;
    L23:
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedList r15 = s.f5354c;     // Catch: Throwable -> L29
        if (r15.contains(r5) == true) goto L27;
        r15.add(r5);     // Catch: Throwable -> L29
    L27:
        boolean r16 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L29
        com.bytedance.ies.bullet.service.base.b.a(6, r5.getClass().getSimpleName().concat(" onActivityStopped"), null);     // Catch: Throwable -> L29
        return;
    }
}
