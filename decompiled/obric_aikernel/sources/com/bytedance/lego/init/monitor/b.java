package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.model.FeedShowTaskInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f2113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<Pair<String, Long>> f2114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f2115c = null;

    static {
        f2115c = new b();
        f2114b = new CopyOnWriteArrayList();
    }

    private b() {
    }

    private final void a(String r10, long r11) {
        f2114b.add(new Pair(r10, Long.valueOf(r11)));
    }

    private final String b(FeedShowTaskInfo r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = InitMonitor.MAIN;
    L5:
        r12.append(r13);
        r12.append(r10.taskId);
        r12.append("_TASKSTART");
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = InitMonitor.ASYNC;
        goto L5
    }

    public final void c(FeedShowTaskInfo r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        if (f2113a > 0) goto L5;
        return;
    L5:
        a(b(r10, r11), System.currentTimeMillis() - f2113a);
    }

    public final void d() {
        f2113a = System.currentTimeMillis();
    }
}
