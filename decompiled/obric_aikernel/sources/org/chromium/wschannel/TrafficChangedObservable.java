package org.chromium.wschannel;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes3.dex */
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

    private void notifyTrafficChangedObservers(Map<String, Object> r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void onTrafficChanged(String r10, long r11, long r12, boolean r13) {
        HashMap r14 = new HashMap();
        r14.put("url", r10);
        r14.put(TRAFFICCHANGED_SENTBYTES, Long.valueOf(r11));
        r14.put(TRAFFICCHANGED_RECEIVEDBYTES, Long.valueOf(r12));
        r14.put(TRAFFICCHANGED_IS_HEARTBEAT_FRAME, Boolean.valueOf(r13));
        notifyTrafficChangedObservers(r14);
    }
}
