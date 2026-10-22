package com.obric.cae.userAware.Garage;

import com.obric.cae.userAware.Garage.proto.GarageTelemetryChunk;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class GarageTelemetryDispatcher {
    private static volatile Listener sListener;

    public interface Listener {
        void onGarageTelemetry(GarageTelemetryChunk r1, byte[] r2);
    }

    private GarageTelemetryDispatcher() {
    }

    public static void report(GarageTelemetryChunk r1, byte[] r2) {
        Listener r0 = sListener;
        if (r0 == null) goto L6;
        r0.onGarageTelemetry(r1, r2);
        return;
    }

    public static void setListener(Listener r2) {
        sListener = (Listener) ZeusTransformUtils.wrapperContextForParams(r2, Listener.class, "com.obric.memorydata.plugin");
    }
}
