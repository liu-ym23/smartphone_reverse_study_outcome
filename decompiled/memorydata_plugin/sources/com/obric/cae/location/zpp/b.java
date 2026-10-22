package com.obric.cae.location.zpp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f7315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, b> f7316b = null;

    static {
        f7315a = Collections.unmodifiableList(Arrays.asList(new String[]{"time_since_last_fix", "steps_since_last_fix", "har_state_STILL", "har_state_WALKING", "har_state_ACCELERATING", "har_state_VEHICLE", "wifi_visible_count", "wifi_rssi_mean", "wifi_connected_any", "wifi_jaccard_index", "cell_id_changed", "cell_rssi_delta", "geofence_is_home", "geofence_is_company", "geofence_dynamic_present", "engine_status_unavailable", "engine_status_available", "user_aware_at_home", "user_aware_at_company", "user_aware_on_the_way", "visible_svs_mean_cn0", "visible_svs", "last_fix_accuracy", "last_fix_is_gps"}));
        f7316b = new ConcurrentHashMap();
    }
}
