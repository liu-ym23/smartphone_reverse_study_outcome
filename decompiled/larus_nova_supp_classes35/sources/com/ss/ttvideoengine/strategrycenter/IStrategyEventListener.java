package com.ss.ttvideoengine.strategrycenter;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IStrategyEventListener {
    public static final int EVENT_KEY_PLAY_RELATED_PRELOAD_FINISHED = 2012;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategrycenter.IStrategyEventListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCustomEvent(IStrategyEventListener r0, String r1, String r2, JSONObject r3) {
        }

        public static void $default$onEvent(IStrategyEventListener r0, String r1, int r2, int r3, String r4) {
        }
    }

    void onCustomEvent(String r1, String r2, JSONObject r3);

    void onEvent(String r1, int r2, int r3, String r4);
}
