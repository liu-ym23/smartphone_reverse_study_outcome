package com.bytedance.android.live.broadcast.api;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Deprecated(message = "这个判断退后台的方法问题太多，使用HostAppMonitorService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/LiveLifecycle;", "Landroid/content/BroadcastReceiver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifecycle extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks {
    public int a;
    public int b;
    public boolean c;

    public static final class a {
    }

    static {
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
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "bundle");
    }

    public LiveLifecycle() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        int r3 = this.b;
        if (r3 <= 0) goto L5;
        this.b = r3 - 1;
    L5:
        Intrinsics.checkNotNull(null);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.b++;
        if (this.c == false) goto L6;
        this.c = false;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        int r3 = this.a;
        if (r3 <= 0) goto L6;
        this.a = r3 - 1;
    L6:
        if (this.b <= 0) goto L9;
        return;
    L9:
        if (this.a == 0) goto L11;
        return;
    L11:
        if (this.c == true) goto L16;
        IHostApp r4 = k.f(IHostApp.class);
        if (r4 == null) goto L16;
        r4.getCurrentActivity();
    L16:
        this.c = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        if (puc.a.isOppoDevice() == false) goto L5;
        return;
    L5:
        if (puc.a.isVivoDevice() == true) goto L19;
        String r4 = r3.getAction();
        if (r4 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r4, "android.intent.action.CLOSE_SYSTEM_DIALOGS") == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual("homekey", r3.getStringExtra("reason")) == false) goto L18;
        boolean r5 = this.c;
        this.c = true;
        return;
    L18:
        return;
    }
}
