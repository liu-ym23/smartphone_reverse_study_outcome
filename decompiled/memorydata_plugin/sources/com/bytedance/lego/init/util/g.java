package com.bytedance.lego.init.util;

import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.InitScheduler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/lego/init/util/InitTraceUtil;", "", "()V", "beginSection", "", "message", "", "beginTask", "taskInfo", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "endSection", "endTask", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2802a = null;

    static {
        f2802a = new g();
    }

    private g() {
    }

    public final void a() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.endSection();
    }

    public final void a(com.bytedance.lego.init.model.b r2) {
        Intrinsics.checkParameterIsNotNull(r2, "taskInfo");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r2.f2783a);
    }

    public final void a(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.beginSection("Task:" + r2);
    }

    public final void b() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        TraceCompat.endSection();
    }
}
