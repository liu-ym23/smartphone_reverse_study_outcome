package com.ss.android.lark.framework.assembly.floating;

import android.app.Application;
import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import xfb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitFloatTask extends AbstractLaunchTask {
    public final Map<xfb.a.a, y> c;

    public class a implements tfb.a.c {
        public final /* synthetic */ InitFloatTask a;

        public a(InitFloatTask r1) {
            this.a = r1;
        }
    }

    public InitFloatTask() {
        this.c = new ConcurrentHashMap();
    }

    public final void a(Context r6) {
        if (z.e(r6) == true) goto L5;
        return;
    L5:
        Application r7 = (Application) r6;
        a r0 = new a(this);
        tfb.a.b r1 = tfb.a.a;
        Intrinsics.checkNotNullParameter(r7, "application");
        Intrinsics.checkNotNullParameter(r0, "dependency");
        if (tfb.a.b.compareAndSet(false, true) == false) goto L11;
        tfb.a.c = r0;
        tfb.a.c r2 = xfb.a.a;
        Intrinsics.checkNotNullParameter(r7, "application");
        r7.registerActivityLifecycleCallbacks(new b());
        tfb.a.c r8 = xfb.a.a;
        if (r8 == null) goto L12;
        xfb.a.b r3 = xfb.a.c;
        com.ss.android.lark.framework.assembly.floating.a r4 = new com.ss.android.lark.framework.assembly.floating.a();
        AppLifecycle.a.a.c(r4);
        ((ConcurrentHashMap) ((a) r8).a.c).put(r3, r4);
        return;
    L12:
        return;
    }
}
