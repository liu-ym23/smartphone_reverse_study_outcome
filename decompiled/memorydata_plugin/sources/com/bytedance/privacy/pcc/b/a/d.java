package com.bytedance.privacy.pcc.b.a;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("payload")
    private final String f3069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("signature")
    private final String f3070b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("client_version")
        private final String f3071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("app_info")
        private final C0154a f3072b;

        @SerializedName(WsConstants.KEY_CHANNEL_ID)
        private final String c;

        @SerializedName("channel_ret")
        private final String d;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.b.a.d$a$a, reason: collision with other inner class name */
        private static class C0154a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @SerializedName("app_id")
            private final String f3073a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @SerializedName("app_svc_id")
            private final String f3074b;

            C0154a(String r1, String r2) {
                this.f3073a = r1;
                this.f3074b = r2;
            }
        }

        public a(String r2, AppInfo r3, String r4, String r5) {
            this.f3071a = r2;
            this.f3072b = new C0154a(r3.appId, r3.appSvcId);
            this.c = r4;
            this.d = r5;
        }

        public String a() {
            return new Gson().toJson(this);
        }

        public String toString() {
            return a();
        }
    }

    public d(String r1, String r2) {
        this.f3069a = r1;
        this.f3070b = r2;
    }

    public String a() {
        return new Gson().toJson(this);
    }

    public String toString() {
        return a();
    }
}
