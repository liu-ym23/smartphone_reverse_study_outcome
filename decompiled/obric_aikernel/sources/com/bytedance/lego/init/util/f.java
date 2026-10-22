package com.bytedance.lego.init.util;

import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.InitScheduler;
import kotlin.jvm.internal.Intrinsics;
import m3.g;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2123a = null;

    static {
        f2123a = new f();
    }

    private f() {
    }

    public final void a(String r10) {
        Intrinsics.checkParameterIsNotNull(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r10);
    }

    public final void b(g r10) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r10.f11028c);
    }

    public final void c() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.endSection();
    }

    public final void d() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.endSection();
    }
}
