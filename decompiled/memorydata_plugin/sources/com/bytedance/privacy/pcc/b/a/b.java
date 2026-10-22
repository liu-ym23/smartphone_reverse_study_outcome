package com.bytedance.privacy.pcc.b.a;

import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("att_cert_chain")
    private final String f3053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("payload")
    private final String f3054b;

    @SerializedName("signature")
    private final String c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("client_version")
        private final String f3055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("client_nonce")
        private final String f3056b;

        @SerializedName("app_info")
        private final C0152a c;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.b.a.b$a$a, reason: collision with other inner class name */
        private static class C0152a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @SerializedName("app_id")
            private final String f3057a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @SerializedName("app_svc_id")
            private final String f3058b;

            C0152a(String r1, String r2) {
                this.f3057a = r1;
                this.f3058b = r2;
            }
        }

        public a(String r1, String r2, AppInfo r3) {
            this.f3055a = r1;
            this.f3056b = r2;
            this.c = new C0152a(r3.appId, r3.appSvcId);
        }

        public String a() {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
        }

        public String toString() {
            return a();
        }
    }

    public b(String r1, String r2, String r3) {
        this.f3053a = r1;
        this.f3054b = r2;
        this.c = r3;
    }

    public String a() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }

    public String toString() {
        return a();
    }
}
