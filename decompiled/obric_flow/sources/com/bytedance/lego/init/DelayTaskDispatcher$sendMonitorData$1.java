package com.bytedance.lego.init;

import android.util.Log;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
final class DelayTaskDispatcher$sendMonitorData$1 extends Lambda implements Function0<Unit> {
    public static final DelayTaskDispatcher$sendMonitorData$1 INSTANCE = null;

    static {
        INSTANCE = new DelayTaskDispatcher$sendMonitorData$1();
    }

    public DelayTaskDispatcher$sendMonitorData$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CopyOnWriteArrayList r10 = com.bytedance.lego.init.monitor.a.f6757a;
        IApmAgent r5 = (IApmAgent) og.a.a(IApmAgent.class);
        if (r5 == null) goto L13;
        JSONObject r11 = new JSONObject();
        Iterator r12 = r10.iterator();     // Catch: Exception -> L10
    L7:
        if (r12.hasNext() == false) goto L12;
        Pair r13 = (Pair) r12.next();     // Catch: Exception -> L10
        r11.put((String) r13.getFirst(), ((Number) r13.getSecond()).longValue());     // Catch: Exception -> L10
    L12:
        com.bytedance.lego.init.util.b.a("DelayTaskMonitor", "sendDelayTaskMonitor " + r11);
        r5.monitorEvent("delay_task_monitor", new JSONObject(), r11, new JSONObject());
        r10.clear();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L13:
        Log.e("#inittask#", "DelayTaskMonitor ServiceManager.getService(IApmAgent::class.java) is null.");
    }
}
