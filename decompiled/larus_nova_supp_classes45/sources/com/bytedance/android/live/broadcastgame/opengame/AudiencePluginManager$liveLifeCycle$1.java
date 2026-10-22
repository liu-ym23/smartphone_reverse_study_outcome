package com.bytedance.android.live.broadcastgame.opengame;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AudiencePluginManager$liveLifeCycle$1 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ AudiencePluginManager a;

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

    public AudiencePluginManager$liveLifeCycle$1(AudiencePluginManager r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        AudiencePluginManager r0 = this.a;
        if (r0.v == false) goto L13;
        Iterator<T> r1 = r0.u.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (((Class) r2).isInstance(r7) == false) goto L6;
    L11:
        if (r2 == null) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L20;
        UtilityKotlinExtentionsKt.s(500, false, false, new AudiencePluginManager$liveLifeCycle$1$onActivityResumed$1(this), 6);
        return;
    L20:
        return;
    L10:
        r2 = null;
    L13:
        r8 = false;
        goto L14
    }
}
