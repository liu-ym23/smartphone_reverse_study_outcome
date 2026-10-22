package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.android.live.broadcastgame.opengame.panel.FullScreenOpenPanel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SonicGamePlugin$liveLifeCycle$1 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ SonicGamePlugin a;

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

    public SonicGamePlugin$liveLifeCycle$1(SonicGamePlugin r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity r8) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        if ((r8 instanceof FullScreenOpenPanel) == false) goto L5;
    L19:
        boolean r0 = false;
    L20:
        if (r0 == false) goto L26;
        UtilityKotlinExtentionsKt.s(500, false, false, new SonicGamePlugin$liveLifeCycle$1$onActivityResumed$1(this, r8), 6);
        return;
    L26:
        return;
    L5:
        if (Intrinsics.areEqual(r8.getClass().getName(), this.a.v) == false) goto L7;
    L18:
        r0 = true;
        goto L20
    L7:
        if (Intrinsics.areEqual(r8.getClass().getName(), this.a.w) == true) goto L18;
        if (Intrinsics.areEqual(r8.getClass().getName(), this.a.x) == true) goto L18;
        Iterator<T> r1 = this.a.y.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        if (((Class) r2).isInstance(r8) == false) goto L12;
    L17:
        if (r2 == null) goto L19;
    L16:
        r2 = null;
        goto L17
    }
}
