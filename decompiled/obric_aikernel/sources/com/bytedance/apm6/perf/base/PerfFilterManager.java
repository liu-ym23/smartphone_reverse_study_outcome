package com.bytedance.apm6.perf.base;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
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
        Runtime r10 = Runtime.getRuntime();
        long r11 = r10.maxMemory();
        long r12 = r10.freeMemory();
        long r13 = r10.totalMemory();
        this.mJavaHeapSizeMaxMega = r11 / 1048576;
        long r14 = r13 - r12;
        this.mJavaHeapSizeUsedMega = r14 / 1048576;
        if (r14 <= (r11 * 0.95f)) goto L5;
        boolean r15 = true;
    L6:
        this.mHasJavaHeapLeak = r15;
        return;
    L5:
        r15 = false;
        goto L6
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void addPerfTag(String r10, String r11) {
        this.mPerfFilters.put(r10, r11);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public ConcurrentHashMap<String, String> getPerfFilters() {
        return this.mPerfFilters;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getPerfFiltersJson() {
        JSONObject r10 = new JSONObject();
        Iterator<Map.Entry<String, String>> r11 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, String> r12 = r11.next();     // Catch: JSONException -> L9
        r10.put(r12.getKey(), r12.getValue());     // Catch: JSONException -> L9
    L8:
        return r10;
    }

    public JSONObject getPerfFiltersJson(boolean r10) {
        JSONObject r11 = new JSONObject();
        Iterator<Map.Entry<String, String>> r12 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r12.hasNext() == false) goto L7;
        Map.Entry<String, String> r13 = r12.next();     // Catch: JSONException -> L11
        r11.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r11.put("RealRefreshRate", String.valueOf(g.d()));     // Catch: JSONException -> L11
        r11.put("RealMaxRefreshRate", String.valueOf(g.d()));     // Catch: JSONException -> L11
        if (r10 == false) goto L10;
        d.k().e(r11);     // Catch: JSONException -> L11
        d.k().a(r11);     // Catch: JSONException -> L11
    L10:
        return r11;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getRealTimeMemInfo() {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
        updateMemInfo();     // Catch: Exception -> L4
        r10.put(Constants.PERF_KEY_HAS_NATIVE_HEAP_SIZE, this.mNativeHeapSizeMega);     // Catch: Exception -> L4
        r10.put(Constants.PERF_KEY_HAS_JAVA_HEAP_LEAK, this.mHasJavaHeapLeak);     // Catch: Exception -> L4
        r10.put(Constants.PERF_KEY_JAVA_HEAP_USED, this.mJavaHeapSizeUsedMega);     // Catch: Exception -> L4
        r10.put(Constants.PERF_KEY_JAVA_HEAP_MAX, this.mJavaHeapSizeMaxMega);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public CopyOnWriteArraySet<String> getSceneSet() {
        return this.mSceneSet;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public String getSceneString() {
        String r10 = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        ActivityLifecycleService r11 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (r11 != null) goto L8;
        return "";
    L8:
        return r11.getTopActivityClassName();
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void removePerfTag(String r10, String r11) {
        this.mPerfFilters.remove(r10, r11);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void startScene(String r10) {
        this.mSceneSet.add(r10);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void stopScene(String r10) {
        this.mSceneSet.remove(r10);
    }
}
