package com.bytedance.lego.init;

import androidx.lifecycle.Lifecycle;
import com.bytedance.lego.init.model.ExecutionPeriod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PeriodTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<ExecutionPeriod, List<m3.h>> f2073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f2074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f2075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PeriodTaskManager f2076d = null;

    static {
        f2076d = new PeriodTaskManager();
        f2073a = new LinkedHashMap();
    }

    private PeriodTaskManager() {
    }

    public static final /* synthetic */ void a(PeriodTaskManager r10, ExecutionPeriod r11, boolean r12) {
        r10.f(r11, r12);
    }

    public static final /* synthetic */ boolean b(PeriodTaskManager r10) {
        return f2074b;
    }

    public static final /* synthetic */ boolean c(PeriodTaskManager r10) {
        return f2075c;
    }

    public static final /* synthetic */ void d(PeriodTaskManager r10, boolean r11) {
        f2074b = r11;
    }

    public static final /* synthetic */ void e(PeriodTaskManager r10, boolean r11) {
        f2075c = r11;
    }

    private final void f(ExecutionPeriod r10, boolean r11) {
        List<m3.h> r12 = f2073a.get(r10);
        if (r12 == null) goto L9;
        Iterator<T> r13 = r12.iterator();
        if (r13.hasNext() == false) goto L10;
        ((m3.h) r13.next()).b();
        throw null;
    L10:
        return;
    }

    static /* synthetic */ void g(PeriodTaskManager r10, ExecutionPeriod r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        r10.f(r11, r12);
    }

    private final void i() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        StringBuilder r10 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator<Map.Entry<ExecutionPeriod, List<m3.h>>> r11 = f2073a.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<ExecutionPeriod, List<m3.h>> r12 = r11.next();
        if ((!r12.getValue().isEmpty()) == false) goto L7;
        r10.append(r12.getKey().name() + ": ");
        Iterator<T> r13 = r12.getValue().iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        r10.append(((m3.h) r13.next()).c() + ' ');
        goto L12
    L14:
        r10.append("\n");
        goto L7
    L15:
        com.bytedance.lego.init.util.c r14 = com.bytedance.lego.init.util.c.f2121a;
        String r15 = r10.toString();
        Intrinsics.checkExpressionValueIsNotNull(r15, "totalInfo.toString()");
        r14.a("PeriodTaskManager", r15);
    }

    public final void h() {
        List<m3.h> r10 = k.c();
        Intrinsics.checkExpressionValueIsNotNull(r10, "TaskCollectorManager.getAllPeriodTaskInfo()");
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        m3.h r12 = (m3.h) r11.next();
        Map<ExecutionPeriod, List<m3.h>> r13 = f2073a;
        Intrinsics.checkExpressionValueIsNotNull(r12, "taskInfo");
        List<m3.h> r14 = r13.get(r12.a());
        if (r14 != null) goto L9;
        r14 = new ArrayList();
        ExecutionPeriod r15 = r12.a();
        Intrinsics.checkExpressionValueIsNotNull(r15, "taskInfo.executionPeriod");
        r13.put(r15, r14);
        Unit r16 = Unit.INSTANCE;
    L9:
        r14.add(r12);
        goto L4
    L10:
        i();
    }

    public final void j(Lifecycle r10) {
        Intrinsics.checkParameterIsNotNull(r10, "lifecycle");
        r10.addObserver(new PeriodTaskManager$registerMain$1());
    }

    public final void k(Lifecycle r10) {
        Intrinsics.checkParameterIsNotNull(r10, "lifecycle");
        r10.addObserver(new PeriodTaskManager$registerSplash$1());
    }
}
