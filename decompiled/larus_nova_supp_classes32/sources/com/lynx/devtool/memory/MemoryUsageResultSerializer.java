package com.lynx.devtool.memory;

import a8a.a;
import android.util.Log;
import com.lynx.tasm.LynxMemoryCollectionStatus;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.p0;
import com.lynx.tasm.r0;
import com.lynx.tasm.u0;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MemoryUsageResultSerializer {
    private static final String EMPTY_RESULT_JSON = "{}";
    private static final String TAG = "MemoryUsageResultSerializer";

    public interface ResultCallback {
        void onResult(String r1, String r2);
    }

    private MemoryUsageResultSerializer() {
    }

    private static String safeString(String r0) {
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0;
    }

    private static JSONObject instanceToJson(r0 r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("instanceId", r4.a);
        r0.put("pageId", safeString(r4.b));
        r0.put(LynxEventReporter.PROP_NAME_URL, safeString(r4.c));
        r0.put("totalBytes", r4.d);
        r0.put("elementBytes", r4.e);
        r0.put("elementNodeCount", r4.f);
        r0.put("viewBytes", r4.g);
        r0.put("viewDetail", viewDetailToJson(r4.h));
        r0.put("mainThreadRuntimeBytes", r4.i);
        r0.put("backgroundThreadRuntimeBytes", r4.j);
        r0.put("btsRuntimeGroupId", safeString(r4.k));
        return r0;
    }

    private static boolean isValidJsonKey(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isEmpty() == true) goto L6;
        return true;
    }

    private static JSONObject memoryRecordToJson(a r6) throws JSONException {
        JSONObject r0 = new JSONObject();
        if (r6 != null) goto L6;
        r0.put("category", NameKeys.UnloadStrategy_No_Strategy);
        r0.put("sizeBytes", 0);
        r0.put("instanceCount", 0);
        r0.put("detail", new JSONObject());
        return r0;
    L6:
        r0.put("category", safeString(r6.a));
        r0.put("sizeBytes", r6.b);
        r0.put("instanceCount", r6.c);
        r0.put("detail", stringMapToJson(r6.d));
        return r0;
    }

    private static String statusToString(LynxMemoryCollectionStatus r1) {
        if (r1 != LynxMemoryCollectionStatus.TIMEOUT) goto L6;
        return "timeout";
    L6:
        return "completed";
    }

    private static JSONObject stringMapToJson(Map<String, String> r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        if (r4 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r5.next();
        String r2 = r1.getKey();
        if (isValidJsonKey(r2) == false) goto L9;
        r0.put(r2, safeString(r1.getValue()));
        goto L9
    }

    public static JSONObject toJson(p0 r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("collectionStartMs", r4.a);
        r0.put("collectionStatus", statusToString(r4.b));
        r0.put("collectionDurationMs", r4.c);
        r0.put("collectionTimeoutMs", r4.d);
        r0.put("expectedInstanceCount", r4.e);
        r0.put("completedInstanceCount", r4.f);
        r0.put("totalBytes", r4.g);
        r0.put("appBytes", r4.h);
        r0.put("ratioToApp", r4.i);
        r0.put("elementBytes", r4.j);
        r0.put("elementNodeCount", r4.k);
        r0.put("viewBytes", r4.l);
        r0.put("mainThreadRuntimeBytes", r4.m);
        r0.put("backgroundThreadRuntimeBytes", r4.n);
        JSONArray r1 = new JSONArray();
        List<r0> r5 = r4.o;
        if (r5 == null) goto L10;
        Iterator<r0> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        r0 r2 = r6.next();
        if (r2 == null) goto L6;
        r1.put(instanceToJson(r2));
    L10:
        r0.put("instances", r1);
        return r0;
    }

    private static JSONObject viewDetailToJson(Map<String, a> r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        if (r4 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, a>> r5 = r4.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, a> r1 = r5.next();
        String r2 = r1.getKey();
        if (isValidJsonKey(r2) == false) goto L9;
        r0.put(r2, memoryRecordToJson(r1.getValue()));
        goto L9
    }

    public static /* synthetic */ String access$000(String r0, Throwable r1) {
        return failureMessage(r0, r1);
    }

    private static String failureMessage(String r2, Throwable r3) {
        String r0 = r3.getMessage();
        if (r0 != null) goto L5;
    L6:
        r0 = r3.getClass().getSimpleName();
    L8:
        return r2 + ": " + r0;
    L5:
        if (r0.isEmpty() == false) goto L8;
        goto L6
    }

    public static void queryAllMemoryUsage(long r2, final ResultCallback r4) {
        final AtomicBoolean r0 = new AtomicBoolean(false);
        int r1 = u0.a;     // Catch: Throwable -> L5
        u0.a(new AnonymousClass1(r4, r0), r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        complete(r4, r0, EMPTY_RESULT_JSON, failureMessage("Failed to query Lynx memory usage", th));
    }

    public static /* synthetic */ void access$100(ResultCallback r0, AtomicBoolean r1, String r2, String r3) {
        complete(r0, r1, r2, r3);
    }

    private static void complete(ResultCallback r2, AtomicBoolean r3, String r4, String r5) {
        if (r3.compareAndSet(false, true) == false) goto L11;
        r2.onResult(r4, r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        LLog.e(TAG, "Failed to deliver Lynx memory usage result: " + Log.getStackTraceString(th));
        return;
    }
}
