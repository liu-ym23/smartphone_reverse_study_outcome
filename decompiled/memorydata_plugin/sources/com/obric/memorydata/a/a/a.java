package com.obric.memorydata.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ0\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002J0\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002J0\u0010\u0010\u001a\u00020\u00112\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/business/predict/PredictBatteryTimeRemaining;", "", "<init>", "()V", "receiver", "com/obric/memorydata/business/predict/PredictBatteryTimeRemaining$receiver$1", "Lcom/obric/memorydata/business/predict/PredictBatteryTimeRemaining$receiver$1;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "predict", "switchMap", "", "", "sysStateMap", "runTask", "", "createPredictArgs", "Lorg/json/JSONObject;", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0414a f8293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f8294b;

    /* JADX INFO: renamed from: com.obric.memorydata.a.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/business/predict/PredictBatteryTimeRemaining$Companion;", "", "<init>", "()V", "TAG", "", "BATTERY_REMAIN_TIME", "TASK_NAME", "ACTION_POWER_STATE", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0414a {
        private C0414a() {
        }

        public /* synthetic */ C0414a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/business/predict/PredictBatteryTimeRemaining$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8295a;

        b(a r1) {
            this.f8295a = r1;
        }

        public void onReceive(Context r11, Intent r12) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "intent: " + r12, false, 4, null);
            Map r14 = null;
            if (r12 == null) goto L7;
            Bundle r0 = r12.getExtras();
            if (r0 == null) goto L7;
            Serializable r1 = r0.getSerializable("switchMap");
        L9:
            if (ZeusTransformUtils.instanceOf(r1, Map.class) == false) goto L11;
            Map r2 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
        L12:
            if (r12 == null) goto L16;
            Bundle r15 = r12.getExtras();
            if (r15 == null) goto L16;
            Serializable r16 = r15.getSerializable("sysStateMap");
        L18:
            if (ZeusTransformUtils.instanceOf(r16, Map.class) == false) goto L20;
            r14 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin");
        L20:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "switchMap: " + r2 + " sysStateMap: " + r14, false, 4, null);
            if (r2 == null) goto L24;
            if (r14 == null) goto L24;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "switchMap: " + r2, false, 4, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "sysStateMap: " + r14, false, 4, null);
            a.a(this.f8295a, r2, r14);
            return;
        L24:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "predict error switchMap: " + r2 + " sysStateMap: " + r14, null, 4, null);
            return;
        L16:
            r16 = null;
            goto L18
        L11:
            r2 = null;
        L7:
            r1 = null;
            goto L9
        }
    }

    static {
        f8293a = new C0414a(null);
    }

    public a() {
        this.f8294b = new b(this);
    }

    public static final /* synthetic */ void a(a r2, Map r3, Map r4) {
        r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Map<Integer, Integer> r3, Map<Integer, Integer> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        ThreadPoolContainer.Companion.execute(new $$Lambda$a$1l0hIEYC5OU9_FaHPbxeibC3ao(this, r5, r6));
    }

    private final String b(Map<Integer, Integer> r4, Map<Integer, Integer> r5) {
        Map<Integer, Integer> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<Integer, Integer> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        String r3 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("phone_battery_predict").setInputParam(c(r6, r7)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getOutput().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }

    private static final void b(a r8, Map r9, Map r10) {
        String r11 = r8.b((Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(r11, "") == true) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "===>run predict remaining: " + r11 + ' ', false, 4, null);
        Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "battery_remaining_time", r11);
        return;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "===>predict error timeMinus: " + r11, null, 4, null);
    }

    private final JSONObject c(Map<Integer, Integer> r10, Map<Integer, Integer> r11) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        JSONObject r13 = new JSONObject();
        Iterator r1 = r9.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r13.put(String.valueOf(r3), ((Number) ZeusTransformUtils.preCheckCast(r2.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L4
    L6:
        JSONObject r4 = new JSONObject();
        Iterator r5 = r12.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r6.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r4.put(String.valueOf(r7), ((Number) ZeusTransformUtils.preCheckCast(r6.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L8
    L10:
        JSONObject r8 = new JSONObject();
        r8.put("switchMap", r13);
        r8.put("sysStateMap", r4);
        r8.put("device_id", AppContext.INSTANCE.getServerDeviceId());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "createPredictArgs: switchMap=" + r9 + " sysStateMap=" + r12, false, 4, null);
        return r8;
    }

    /* JADX INFO: renamed from: lambda$1l0hIEYC5OU9_FaHPbxeibC-3ao, reason: not valid java name */
    public static /* synthetic */ void m429lambda$1l0hIEYC5OU9_FaHPbxeibC3ao(a r0, Map r1, Map r2) {
        b(r0, r1, r2);
    }

    public final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictBatteryTimeRemaining", "init register broadcast", false, 4, null);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("com.obric.action.POWER_MEMORY");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f8294b, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
    }
}
