package com.obric.cae.userAware.datacollection;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class PoiAdspEventDispatcher {
    private static volatile Listener sListener;

    public interface Listener {
        void onPoiAdspEvent(int r1, long r2, String r4);
    }

    private PoiAdspEventDispatcher() {
    }

    public static void report(int r1, long r2, String r4) {
        Listener r0 = sListener;
        if (r0 == null) goto L6;
        r0.onPoiAdspEvent(r1, r2, r4);
        return;
    }

    public static void setListener(Listener r2) {
        sListener = (Listener) ZeusTransformUtils.wrapperContextForParams(r2, Listener.class, "com.obric.memorydata.plugin");
    }
}
