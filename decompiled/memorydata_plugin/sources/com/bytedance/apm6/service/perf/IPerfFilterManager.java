package com.bytedance.apm6.service.perf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IPerfFilterManager {
    void addPerfTag(String r1, String r2);

    ConcurrentHashMap<String, String> getPerfFilters();

    JSONObject getPerfFiltersJson();

    JSONObject getRealTimeMemInfo();

    CopyOnWriteArraySet<String> getSceneSet();

    String getSceneString();

    void removePerfTag(String r1, String r2);

    void startScene(String r1);

    void stopScene(String r1);
}
