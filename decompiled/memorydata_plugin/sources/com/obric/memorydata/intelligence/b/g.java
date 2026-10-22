package com.obric.memorydata.intelligence.b;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.database.entity.eo;
import com.obric.memorydata.database.entity.n;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ah;
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJG\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0012JH\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u000f2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000fH\u0002J$\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002J(\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0002J(\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/PredictTracker;", "", "<init>", "()V", "TAG", "", "APP_LAUNCH_VALUE", "", "INVALID_RESULT", "", "trackPredict", "", "calculateRecallRate", "", "launchMap", "", "", "predictMap", "(Ljava/util/Map;Ljava/util/Map;)[Ljava/lang/Float;", "calculateAcc", "computeAccuracy", "launchList", "predictList", "formatPredictResult", "predictResult", "Lcom/obric/memorydata/database/entity/PredictAppEntity;", "formatLaunchResult", "launchResult", "Lcom/obric/memorydata/database/entity/AppUsageEntity;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9948a = null;

    static {
        f9948a = new g();
    }

    private g() {
    }

    private final float a(List<Integer> r8, List<Integer> r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == false) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTracker", "launchList isEmpty", null, 4, null);
        return 0.0f;
    L6:
        int r11 = ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).size();
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r1 >= r11) goto L14;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r10.get(r1), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r7.get(r1), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r4 != 1) goto L13;
        r2 = r2 + 1;
        if (r4 != r5) goto L13;
        r3 = r3 + 1;
    L13:
        r1 = r1 + 1;
        goto L7
    L14:
        if (r2 != 0) goto L18;
        return -1.0f;
    L18:
        return r3 / r2;
    }

    private final Map<String, List<Integer>> a(List<eo> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Map<String, List<Integer>> r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        eo r1 = (eo) ZeusTransformUtils.preCheckCast(r10.next(), eo.class, "com.obric.memorydata.plugin");
        List<Integer> r2 = (List) ZeusTransformUtils.preCheckCast(r9.get(r1.a()), List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        ArrayList r3 = new ArrayList(24);
        int r5 = 0;
    L8:
        if (r5 >= 24) goto L10;
        r3.add(0);
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        r9.put(r1.a(), r2);
    L11:
        r2.set(com.obric.memorydata.utils.g.a(r1.c()), Integer.valueOf(r1.b()));
        goto L4
    L12:
        return r9;
    }

    private final Float[] a(Map<String, ? extends List<Integer>> r12, Map<String, ? extends List<Integer>> r13) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        int[] r1 = new int[24];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= 24) goto L5;
        r1[r3] = 0;
        r3 = r3 + 1;
        goto L3
    L5:
        int[] r4 = new int[24];
        int r5 = 0;
    L6:
        if (r5 >= 24) goto L8;
        r4[r5] = 0;
        r5 = r5 + 1;
        goto L6
    L8:
        Iterator r15 = r11.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L28;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r9 = 0;
    L13:
        if (r8.hasNext() == false) goto L10;
        Object r10 = r8.next();
        int r16 = r9 + 1;
        if (r9 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() != 1) goto L27;
        r1[r9] = r1[r9] + 1;
        List r17 = (List) ZeusTransformUtils.preCheckCast(r14.get(r7), List.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L22;
    L24:
        boolean r18 = false;
    L25:
        if (r18 == false) goto L27;
        r4[r9] = r4[r9] + 1;
        goto L27
    L22:
        if (((Number) ZeusTransformUtils.preCheckCast(r17.get(r9), Number.class, "com.obric.memorydata.plugin")).intValue() != 1) goto L24;
        r18 = true;
    L27:
        r9 = r16;
        goto L13
    L28:
        Float[] r19 = new Float[24];
        int r110 = 0;
    L29:
        if (r110 >= 24) goto L35;
        if (r1[r110] == 0) goto L33;
        float r20 = r4[r110] / r1[r110];
    L34:
        r19[r110] = Float.valueOf(r20);
        r110 = r110 + 1;
        goto L29
    L33:
        r20 = -1.0f;
        goto L34
    L35:
        int r111 = 0;
    L36:
        if (r2 >= 24) goto L38;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTracker", "recall rate hour " + r111 + " rate " + ((Number) ZeusTransformUtils.preCheckCast(r19[r2], Number.class, "com.obric.memorydata.plugin")).floatValue(), false, 4, null);
        r2 = r2 + 1;
        r111 = r111 + 1;
        goto L36
    L38:
        return r19;
    }

    private final Map<String, List<Integer>> b(List<n> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Map<String, List<Integer>> r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        n r1 = (n) ZeusTransformUtils.preCheckCast(r10.next(), n.class, "com.obric.memorydata.plugin");
        List<Integer> r2 = (List) ZeusTransformUtils.preCheckCast(r9.get(r1.a()), List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        ArrayList r3 = new ArrayList(24);
        int r5 = 0;
    L8:
        if (r5 >= 24) goto L10;
        r3.add(0);
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        r9.put(r1.a(), r2);
    L11:
        r2.set(com.obric.memorydata.utils.g.a(r1.e()), 1);
        goto L4
    L12:
        return r9;
    }

    private final Map<String, Float> b(Map<String, ? extends List<Integer>> r6, Map<String, ? extends List<Integer>> r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map<String, Float> r9 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        List<Integer> r3 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.memorydata.plugin");
        List<Integer> r4 = (List) ZeusTransformUtils.preCheckCast(r5.get(r2), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        float r11 = 0.0f;
    L9:
        r9.put(r2, Float.valueOf(r11));
        goto L4
    L8:
        r11 = f9948a.a(r4, r3);
        goto L9
    L10:
        return r9;
    }

    public final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTracker", "trackPredict start", false, 4, null);
        long r1 = r.a(System.currentTimeMillis());
        long r4 = r1 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        Map<String, List<Integer>> r6 = b(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAppUsageDao().queryRecords(r4, r1));
        Map<String, List<Integer>> r2 = a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPredictAppResultDao().queryRecords(r4, r1));
        Float[] r3 = a(r6, r2);
        int r5 = r3.length;
        float r7 = 0.0f;
        int r8 = 0;
        int r9 = 0;
    L3:
        boolean r11 = true;
        if (r8 >= r5) goto L12;
        float r12 = ((Number) ZeusTransformUtils.preCheckCast(r3[r8], Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r12 == (-1.0f)) goto L9;
        r11 = false;
    L9:
        if (r11 == true) goto L11;
        r7 = r7 + r12;
        r9 = r9 + 1;
    L11:
        r8 = r8 + 1;
        goto L3
    L12:
        if (r9 == 0) goto L14;
        JSONObject r10 = new JSONObject();
        r10.put("recall_rate", Float.valueOf(r7 / r9));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTracker", "trackPredict recallRate " + r10, false, 4, null);
        ah.a(DevTrackerEventId.PREDICT_APP_LAUNCH_RECALL, r10);
    L14:
        Iterator<Map.Entry<String, Float>> r0 = b(r6, r2).entrySet().iterator();
    L16:
        if (r0.hasNext() == false) goto L23;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        float r15 = ((Number) ZeusTransformUtils.preCheckCast(r13.getValue(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r15 != (-1.0f)) goto L20;
        boolean r16 = true;
    L21:
        if (r16 == true) goto L16;
        JSONObject r17 = new JSONObject();
        r17.put("package_name", r14);
        r17.put("acc_value", Float.valueOf(r15));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTracker", "trackPredict acc " + r17, false, 4, null);
        ah.a(DevTrackerEventId.PREDICT_APP_LAUNCH_ACCURACY, r17);
        goto L16
    L20:
        r16 = false;
        goto L21
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PredictTracker", "trackPredict end", false, 4, null);
    }
}
