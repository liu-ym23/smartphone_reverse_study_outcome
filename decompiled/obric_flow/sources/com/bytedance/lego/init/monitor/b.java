package com.bytedance.lego.init.monitor;

import ai.j0;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f6759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f6760b = null;

    static {
        f6760b = new CopyOnWriteArrayList();
    }

    public static void a(FeedShowTaskInfo r5, boolean r10) {
        if (f6759a > 0) goto L6;
        return;
    L6:
        if (r10 == false) goto L8;
        String r11 = j0.q(new StringBuilder(InitMonitor.MAIN), r5.taskId, "_TASKSTART");
    L9:
        long r12 = System.currentTimeMillis() - f6759a;
        f6760b.add(new Pair(r11, Long.valueOf(r12)));
        return;
    L8:
        r11 = j0.q(new StringBuilder(InitMonitor.ASYNC), r5.taskId, "_TASKSTART");
        goto L9
    }
}
