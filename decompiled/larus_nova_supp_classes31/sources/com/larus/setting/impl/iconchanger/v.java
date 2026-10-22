package com.larus.setting.impl.iconchanger;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.h4;
import com.larus.home.api.main.HomeServiceV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v implements Application.ActivityLifecycleCallbacks {
    public v() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        if ((r5 instanceof ChangeAppIconActivity) == false) goto L6;
        ChangeAppIconManager.d = false;
    L6:
        if ((r5 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r6 = (FragmentActivity) r5;
    L10:
        if (r6 != null) goto L12;
    L17:
        ChangeAppIconManager.b = true;
        return;
    L12:
        if (Intrinsics.areEqual(r6.getClass().getName(), HomeServiceV2.a.a()) == false) goto L15;
        ChangeAppIconManager.e(true);
        goto L17
    L15:
        if ((r6 instanceof h4) == false) goto L17;
        ChangeAppIconManager.e(false);
        goto L17
    L8:
        r6 = null;
        goto L10
    }
}
