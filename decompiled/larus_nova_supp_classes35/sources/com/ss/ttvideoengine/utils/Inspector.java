package com.ss.ttvideoengine.utils;

import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Inspector {
    private static final String TAG = "Inspector";
    private String mHost;
    private final TTHTTPNetwork mNetworkSession;

    public static class Holder {
        private static final Inspector instance = null;

        private Holder() {
        }

        static {
            instance = new Inspector();
        }

        public static /* synthetic */ Inspector access$000() {
            return instance;
        }
    }

    public void inspectEvent(String r1, JSONObject r2) {
    }

    public Inspector() {
        this.mNetworkSession = new TTHTTPNetwork();
    }

    public static Inspector share() {
        return Holder.access$000();
    }

    public String getHost() {
        return this.mHost;
    }

    public void setHost(String r3) {
        this.mHost = r3;
        if (StrategyHelper.helper().isRunning() == false) goto L6;
        StrategyHelper.helper().getCenter().h(31207, this.mHost);
        return;
    }

    private static /* synthetic */ void lambda$inspectEvent$0(JSONObject r1, Error r2) {
        TTVideoEngineLog.d(TAG, "inspect event error:" + r2.toString());
    }
}
