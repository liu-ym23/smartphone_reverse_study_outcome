package com.bytedance.lego.init.monitor;

import ai.j0;
import com.bytedance.lego.init.model.DelayTaskInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f6757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f6758b;

    static {
        f6757a = new CopyOnWriteArrayList();
        f6758b = -1;
    }

    public static void a(String r5, long r10, boolean r11) {
        if (r11 == false) goto L4;
        String r12 = InitMonitor.MAIN.concat(r5);
    L5:
        f6757a.add(new Pair(r12, Long.valueOf(r10)));
        return;
    L4:
        r12 = InitMonitor.ASYNC.concat(r5);
        goto L5
    }

    public static void b(DelayTaskInfo r5, boolean r10) {
        if (f6758b >= 0) goto L6;
        return;
    L6:
        if (r10 == false) goto L8;
        String r11 = j0.q(new StringBuilder(InitMonitor.MAIN), r5.taskId, "_TASKSTART");
    L9:
        long r12 = System.currentTimeMillis() - f6758b;
        f6757a.add(new Pair(r11, Long.valueOf(r12)));
        return;
    L8:
        r11 = j0.q(new StringBuilder(InitMonitor.ASYNC), r5.taskId, "_TASKSTART");
        goto L9
    }
}
