package com.obric.sva.sdk.service;

import android.os.Build;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\bJ\"\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u0003\u0018\u00010\u001cJ#\u0010\u001d\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u0001H\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\bH\u0002R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupTraceCollector;", "", "<init>", "()V", "stage1WakeupDuration", "", "Landroid/util/Pair;", "", "", "getStage1WakeupDuration", "()Ljava/util/List;", "stage2WakeupDuration", "getStage2WakeupDuration", "stage2WakeupDetail", "getStage2WakeupDetail", "miscMap", "", "getMiscMap", "()Ljava/util/Map;", "resetWakeupStageData", "", "insertTimeTrace", "name", "insertTimeByUser", "duration", "insertStage1TimeByUser", "insertTimeDetail", "data", "", "insertTimeValue", "T", "(Ljava/lang/String;Ljava/lang/Object;)V", "getLastTraceTime", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupTraceCollector {
    private final Map<String, Object> miscMap;
    private final List<Pair<String, Long>> stage1WakeupDuration;
    private final List<Pair<String, String>> stage2WakeupDetail;
    private final List<Pair<String, Long>> stage2WakeupDuration;

    private final long getLastTraceTime() {
        if (this.stage2WakeupDuration.size() == 0) goto L7;
        Object r0 = ((Pair) ListProtector.get(this.stage2WakeupDuration, 0)).second;
        Intrinsics.checkNotNull(r0);
        return ((Number) r0).longValue();
    L7:
        return System.currentTimeMillis();
    }

    public final void resetWakeupStageData() {
        this.stage1WakeupDuration.clear();
        this.stage2WakeupDuration.clear();
        this.stage2WakeupDetail.clear();
        this.miscMap.clear();
    }

    public WakeupTraceCollector() {
        this.stage1WakeupDuration = new CopyOnWriteArrayList();
        this.stage2WakeupDuration = new CopyOnWriteArrayList();
        this.stage2WakeupDetail = new CopyOnWriteArrayList();
        this.miscMap = new ConcurrentHashMap();
    }

    public final Map<String, Object> getMiscMap() {
        return this.miscMap;
    }

    public final List<Pair<String, Long>> getStage1WakeupDuration() {
        return this.stage1WakeupDuration;
    }

    public final List<Pair<String, String>> getStage2WakeupDetail() {
        return this.stage2WakeupDetail;
    }

    public final List<Pair<String, Long>> getStage2WakeupDuration() {
        return this.stage2WakeupDuration;
    }

    public final void insertTimeTrace(String r7) {
        Intrinsics.checkNotNullParameter(r7, "name");
        if (this.stage2WakeupDuration.isEmpty() == false) goto L5;
        this.stage2WakeupDuration.add(new Pair(r7, Long.valueOf(System.currentTimeMillis())));
        return;
    L5:
        this.stage2WakeupDuration.add(new Pair(r7, Long.valueOf(System.currentTimeMillis() - getLastTraceTime())));
    }

    public final void insertStage1TimeByUser(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        this.stage1WakeupDuration.add(new Pair(r3, Long.valueOf(r4)));
    }

    public final void insertTimeByUser(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        this.stage2WakeupDuration.add(new Pair(r3, Long.valueOf(r4)));
    }

    public final void insertTimeDetail(String r4, Map<String, ?> r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        if (r5 != null) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        if (Build.VERSION.SDK_INT < 24) goto L15;
        Iterator<Map.Entry<String, ?>> r6 = r5.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<String, ?> r1 = r6.next();
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        this.stage2WakeupDetail.add(new Pair(r4, r0.toString()));
    }

    public final <T> void insertTimeValue(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        if (r4 != null) goto L5;
        return;
    L5:
        this.stage2WakeupDetail.add(new Pair(r3, r4.toString()));
    }
}
