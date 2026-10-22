package com.ss.android.lark.officesdk.launcher.load;

import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final LinkedHashMap<Class<? extends ILaunchTask<?>>, ILaunchTask<?>> a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = new LinkedHashMap();
    }

    public final void a(AbstractLaunchTask r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Log.i("OfficeLoadTaskCollector", "[office load] add task: " + r3.f());
        this.a.put((Class<? extends ILaunchTask<?>>) r3.getClass(), (ILaunchTask<?>) r3);
    }
}
