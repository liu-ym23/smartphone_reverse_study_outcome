package com.bytedance.android.live.profit.taskcenter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TaskCenterService implements c, o {
    public final CompositeDisposable a;
    public final ev0.c b;
    public final j c;
    public final com.bytedance.android.live.revenue.core.a d;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        this.d.b(c.class, this.c);
        ev0.c r0 = this.b;
        r0.getClass();
        ev0.c.a("init");
        r0.b.clear();
        List<ev0.b> r1 = r0.c;
        ArrayList r2 = (ArrayList) r1;
        r2.add(gv0.b.b);
        Iterator r3 = ((ArrayList) r0.c).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ev0.b) r3.next()).a(r0);
        goto L4
    L6:
        List<ev0.a> r4 = r0.d;
        ReadOnlyProperty r5 = k.b;
        KProperty[] r6 = k.a;
        if (((Boolean) r5.getValue(null, r6[0])).booleanValue() == false) goto L10;
        ArrayList r7 = (ArrayList) r4;
        r7.add(gv0.a.a);
    L10:
        if (((Boolean) k.c.getValue(null, r6[1])).booleanValue() == false) goto L12;
        ArrayList r8 = (ArrayList) r4;
        r8.add(gv0.c.a);
    L12:
        ALogger.i("TaskCenterService", "onStart");
    }

    public final void onStop() {
        this.a.dispose();
        ev0.c r0 = this.b;
        r0.getClass();
        ev0.c.a("reset start priorityQueue.size=" + r0.b.size());
        if (r0.b.size() <= 0) goto L5;
        int r1 = hv0.a.a;
        int r2 = r0.b.size();
        HashMap r3 = hv0.a.a();
        r3.put("queue_size", String.valueOf(r2));
        n r4 = new n();
        Map<String, String> r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r5.putAll(r3);
        m r6 = new m();
        r6.b(LogCommon.ROOM);
        r6.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r4.b).addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_task_panel_reset", r4.a, r4.b);
    L5:
        ev0.c.d(LiveTaskPanelTraceMonitor.Step.TASK_PANEL_MANAGER_RESET.getStep(), MapsKt.mapOf(TuplesKt.to("priorityQueue_size", Integer.valueOf(r0.b.size()))));
        r0.a.clear();
        HybridDialog r9 = r0.e;
        if (r9 == null) goto L8;
        r9.close();
    L8:
        r0.e = null;
        Iterator<PanelInfo> r10 = r0.b.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r10.next().a(PanelInfo.State.DISMISSED, null);
        goto L10
    L12:
        r0.b.clear();
        Iterator r12 = ((ArrayList) r0.c).iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        ((ev0.b) r12.next()).b(r0);
        goto L14
    L16:
        ((ArrayList) r0.c).clear();
        ev0.c.a("reset done priorityQueue.size=" + r0.b.size());
        ALogger.i("TaskCenterService", "onStop");
    }

    public TaskCenterService(j r2, com.bytedance.android.live.revenue.core.a r3) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        Intrinsics.checkNotNullParameter(r3, "inst");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
        this.b = new ev0.c();
    }

    @Override // com.bytedance.android.live.profit.taskcenter.c
    public final void r5(String r3, Map r4) {
        Intrinsics.checkNotNullParameter("ttlive_task_panel_manage", "eventName");
        Intrinsics.checkNotNullParameter(r3, "step");
        Intrinsics.checkNotNullParameter(r4, "extra");
        LiveTaskPanelTraceMonitor.a("ttlive_task_panel_manage", r3, r4);
    }

    @Override // com.bytedance.android.live.profit.taskcenter.c
    public final void yk(final Context r8, final Uri r9, final Bundle r10, final b r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "uri");
        Intrinsics.checkNotNullParameter(r10, "bundle");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L5;
        Function0<Unit> r0 = new TaskCenterService$addPanel$1(this, r8, r9, r10, r12);
        Intrinsics.checkNotNullParameter(r0, "action");
        com.bytedance.live.kmp.util.f.a(r0);
    L6:
        ALogger.i("TaskCenterService", "addPanel");
        return;
    L5:
        this.b.b(r8, r9, r10, r12);
        goto L6
    }
}
