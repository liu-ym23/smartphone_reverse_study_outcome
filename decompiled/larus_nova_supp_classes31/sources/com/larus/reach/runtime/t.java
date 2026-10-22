package com.larus.reach.runtime;

import android.app.Activity;
import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t {
    public static final AtomicBoolean a = null;
    public static volatile WeakReference<Activity> b;

    static {
        a = new AtomicBoolean(false);
    }

    public static Application a() {
        Application r0 = FlowRuntime.a().getApplication();
        if (a.compareAndSet(false, true) == false) goto L6;
        r0.registerActivityLifecycleCallbacks(new s());
    L6:
        return r0;
    }

    public static Activity b() {
        Application r0 = FlowRuntime.a().getApplication();
        if (a.compareAndSet(false, true) == false) goto L6;
        r0.registerActivityLifecycleCallbacks(new s());
    L6:
        WeakReference<Activity> r1 = b;
        if (r1 == null) goto L11;
        Activity r2 = r1.get();
        if (r2 == null) goto L11;
        return r2;
    L11:
        return AppHost.a.a().getCurrentActivity();
    }
}
