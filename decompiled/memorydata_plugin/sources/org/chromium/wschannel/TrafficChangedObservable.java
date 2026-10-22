package org.chromium.wschannel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes7.dex */
public class TrafficChangedObservable extends Observable {
    public static final String TRAFFICCHANGED_IS_HEARTBEAT_FRAME = "is_heartbeat_frame";
    public static final String TRAFFICCHANGED_RECEIVEDBYTES = "received_bytes";
    public static final String TRAFFICCHANGED_SENTBYTES = "sent_bytes";
    public static final String TRAFFICCHANGED_URL = "url";
    private static volatile TrafficChangedObservable sInstance;

    public TrafficChangedObservable() {
    }

    public static TrafficChangedObservable inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TrafficChangedObservable.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TrafficChangedObservable();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TrafficChangedObservable.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void notifyTrafficChangedObservers(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        setChanged();
        notifyObservers(r4);
    }

    public void onTrafficChanged(String r3, long r4, long r6, boolean r8) {
        HashMap r0 = new HashMap();
        r0.put("url", r3);
        r0.put(TRAFFICCHANGED_SENTBYTES, Long.valueOf(r4));
        r0.put(TRAFFICCHANGED_RECEIVEDBYTES, Long.valueOf(r6));
        r0.put(TRAFFICCHANGED_IS_HEARTBEAT_FRAME, Boolean.valueOf(r8));
        notifyTrafficChangedObservers(r0);
    }
}
