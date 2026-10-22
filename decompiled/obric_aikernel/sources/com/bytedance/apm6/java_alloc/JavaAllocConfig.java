package com.bytedance.apm6.java_alloc;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JavaAllocConfig {
    public static final String KEY_CONF_COLLECT = "enable_alloc_collect";
    public static final String KEY_CONF_COLLECT_PER_THOUSAND_ALLOC = "alloc_collect_per_thousand_alloc";
    public static final String KEY_CONF_DUMP_PER_THOUSAND_COLLECT = "alloc_dump_per_thousand_collect";
    public static final String KEY_CONF_THRESHOLD_ALLOC_FREQ = "alloc_threshold_alloc_frequency";
    public static final String KEY_CONF_THRESHOLD_ALLOC_SIZE = "alloc_threshold_alloc_size";
    public static final String KEY_CONF_UPLOAD = "enable_alloc_upload";
    public int collect_per_thousand_alloc;
    public int dump_per_thousand_collect;
    public boolean enable_collect;
    public boolean enable_upload;
    public int threshold_alloc_frequency;
    public long threshold_alloc_size;

    public JavaAllocConfig(boolean r10, boolean r11, int r12, int r13, int r14, long r15) {
        this.enable_collect = r10;
        this.enable_upload = r11;
        this.collect_per_thousand_alloc = r12;
        this.dump_per_thousand_collect = r13;
        this.threshold_alloc_frequency = r14;
        this.threshold_alloc_size = r15;
    }

    public JSONObject packJson() {
        JSONObject r10 = new JSONObject();
        r10.put(KEY_CONF_COLLECT, this.enable_collect);     // Catch: JSONException -> L5
        r10.put(KEY_CONF_UPLOAD, this.enable_upload);     // Catch: JSONException -> L5
        r10.put(KEY_CONF_COLLECT_PER_THOUSAND_ALLOC, this.collect_per_thousand_alloc);     // Catch: JSONException -> L5
        r10.put(KEY_CONF_DUMP_PER_THOUSAND_COLLECT, this.dump_per_thousand_collect);     // Catch: JSONException -> L5
        r10.put(KEY_CONF_THRESHOLD_ALLOC_FREQ, this.threshold_alloc_frequency);     // Catch: JSONException -> L5
        r10.put(KEY_CONF_THRESHOLD_ALLOC_SIZE, this.threshold_alloc_size);     // Catch: JSONException -> L5
    L4:
        return r10;
    }
}
