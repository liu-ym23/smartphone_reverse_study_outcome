package com.larus.dora.api.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraWifiLinkStrategy;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface FlowDoraWifiLinkStrategy {
    public static final a Companion = null;
    public static final String P2P_NEXT_SOFT_AP = "P2P_NEXT_SOFT_AP";
    public static final String P2P_ONLY = "P2P_ONLY";
    public static final String SOFT_AP_ONLY = "SOFT_AP_ONLY";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
