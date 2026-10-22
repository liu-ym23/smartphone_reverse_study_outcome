package com.bytedance.apm6.perf.base;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PerfFilterManager implements IPerfFilterManager {
    private static volatile PerfFilterManager singleton;
    private boolean mHasJavaHeapLeak;
    private long mJavaHeapSizeMaxMega;
    private long mJavaHeapSizeUsedMega;
    private long mNativeHeapSizeMega;
    private ConcurrentHashMap<String, String> mPerfFilters;
    private CopyOnWriteArraySet<String> mSceneSet;

    private PerfFilterManager() {
        this.mSceneSet = new CopyOnWriteArraySet();
        this.mPerfFilters = new ConcurrentHashMap();
    }

    public static PerfFilterManager getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(PerfFilterManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new PerfFilterManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PerfFilterManager.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    private void updateMemInfo() {
        this.mNativeHeapSizeMega = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.mJavaHeapSizeMaxMega = r4 / 1048576;
        long r2 = r1 - r6;
        this.mJavaHeapSizeUsedMega = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.mHasJavaHeapLeak = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void addPerfTag(String r1, String r2) {
        this.mPerfFilters.put(r1, r2);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public ConcurrentHashMap<String, String> getPerfFilters() {
        return this.mPerfFilters;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getPerfFiltersJson() {
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, String>> r5 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L9
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue());     // Catch: JSONException -> L9
    L8:
        return r1;
    }

    public JSONObject getPerfFiltersJson(boolean r6) {
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, String>> r5 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L11
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r1.put("RealRefreshRate", String.valueOf(g.e()));     // Catch: JSONException -> L11
        r1.put("RealMaxRefreshRate", String.valueOf(g.e()));     // Catch: JSONException -> L11
        if (r6 == false) goto L10;
        d.a().e(r1);     // Catch: JSONException -> L11
        d.a().f(r1);     // Catch: JSONException -> L11
    L10:
        return r1;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getRealTimeMemInfo() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        updateMemInfo();     // Catch: Exception -> L4
        r0.put(Constants.PERF_KEY_HAS_NATIVE_HEAP_SIZE, this.mNativeHeapSizeMega);     // Catch: Exception -> L4
        r0.put(Constants.PERF_KEY_HAS_JAVA_HEAP_LEAK, this.mHasJavaHeapLeak);     // Catch: Exception -> L4
        r0.put(Constants.PERF_KEY_JAVA_HEAP_USED, this.mJavaHeapSizeUsedMega);     // Catch: Exception -> L4
        r0.put(Constants.PERF_KEY_JAVA_HEAP_MAX, this.mJavaHeapSizeMaxMega);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public CopyOnWriteArraySet<String> getSceneSet() {
        return this.mSceneSet;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public String getSceneString() {
        String r2 = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        ActivityLifecycleService r3 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        return "";
    L8:
        return r3.getTopActivityClassName();
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void removePerfTag(String r1, String r2) {
        this.mPerfFilters.remove(r1, r2);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void startScene(String r1) {
        this.mSceneSet.add(r1);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void stopScene(String r1) {
        this.mSceneSet.remove(r1);
    }
}
