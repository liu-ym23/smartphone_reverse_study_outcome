package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {
    com.bytedance.android.live.revlink.impl.monitor.b a();

    HashMap<String, LiveData<?>> b();

    LiveFullLinkPKMonitor d();

    MultiEnterRoomTracer e();

    String f(String r1);

    void g(zy0.b r1);

    LiveData<Boolean> getChangeScreenEvent();

    LiveData<f31.i> getWindowStatus();

    Map<String, LiveData<Pair<String, JSONObject>>> h();
}
