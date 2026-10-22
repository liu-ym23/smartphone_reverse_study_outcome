package com.optimize.statistics;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IMonitorHookV2 {
    Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest r1, Object r2, String r3, JSONObject r4, boolean r5, boolean r6);
}
