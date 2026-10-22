package com.larus.community.impl.applet;

import android.app.Activity;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AICreationAppletNavigator$e implements f09.a.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Ref.ObjectRef<f09.a.a> d;

    public final void onPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onPreDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        AICreationAppletNavigator r0 = AICreationAppletNavigator.a;
        int r1 = this.a;
        r0.getClass();
        if (AICreationAppletNavigator.i(r5, r1) == false) goto L6;
        FLogger.a.i("AICreationAppletNavigator", "run AI creation applet task action after native activity ready=".concat(r5.getClass().getSimpleName()));
        AICreationAppletNavigator.t(this.b, this.c, this.d, r5);
        return;
    }

    public final void onStart(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onCreate(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }

    public AICreationAppletNavigator$e(int r1, Runnable r2, long r3, Ref.ObjectRef<f09.a.a> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
