package com.bytedance.lego.init.monitor;

import android.util.Log;
import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f6761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f6762b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f6763c = null;
    public static final c d = null;

    static {
        f6761a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;"))};
        d = new c();
        f6762b = new CopyOnWriteArrayList();
        f6763c = LazyKt.lazy(IdleTaskMonitor$iApmAgent$2.INSTANCE);
    }

    public static void a() {
        CopyOnWriteArrayList r5 = f6762b;
        KProperty[] r10 = f6761a;
        KProperty r11 = r10[0];
        Lazy r12 = f6763c;
        if (((IApmAgent) r12.getValue()) == null) goto L15;
        JSONObject r13 = new JSONObject();
        Iterator r14 = r5.iterator();     // Catch: Throwable -> L17
    L7:
        if (r14.hasNext() == false) goto L10;
        Pair r15 = (Pair) r14.next();     // Catch: Throwable -> L17
        r13.put((String) r15.first, ((Number) r15.second).longValue());     // Catch: Throwable -> L17
    L10:
        com.bytedance.lego.init.util.b.a("IdleTaskMonitor", "sendIdleTaskMonitor " + r13);
        JSONObject r16 = new JSONObject();
        r16.put("category", InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        KProperty r17 = r10[0];
        IApmAgent r18 = (IApmAgent) r12.getValue();
        if (r18 == null) goto L13;
        r18.monitorEvent("idle_task_monitor", r16, r13, new JSONObject());
    L13:
        r5.clear();
        return;
    L15:
        Log.e("#inittask#", "IdleTaskMonitor ServiceManager.getService(IApmAgent::class.java) is null.");
    }
}
