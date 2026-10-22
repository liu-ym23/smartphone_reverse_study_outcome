package com.bytedance.android.ec.core.monitor;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MonitorService$monitorParams$runnable$1 implements Runnable {
    public final /* synthetic */ Context a;

    public MonitorService$monitorParams$runnable$1(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity r0 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.a);     // Catch: Throwable -> L10
        if ((r0 instanceof LifecycleOwner) == true) goto L5;
        r0 = null;
    L5:
        LifecycleOwner r1 = (LifecycleOwner) r0;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = ECQuickUtilKt.b;     // Catch: Throwable -> L10
    L8:
        final Lifecycle r10 = r1.getLifecycle();     // Catch: Throwable -> L10
        r10.addObserver(new MonitorService$monitorParams$runnable$1$$special$$inlined$apply$lambda$1(r10, this));     // Catch: Throwable -> L10
        MonitorService.a.put(this.a, Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
