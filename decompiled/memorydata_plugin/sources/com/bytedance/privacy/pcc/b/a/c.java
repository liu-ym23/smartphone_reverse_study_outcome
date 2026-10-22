package com.bytedance.privacy.pcc.b.a;

import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3059a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f3060b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("evidence_version")
        private String f3061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("evidence_token")
        private String f3062b;

        @SerializedName("evidence_detail")
        private String c;

        @SerializedName("evidence_extra")
        private String d;

        public a() {
        }

        public static a a(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r2, a.class), a.class, "com.obric.memorydata.plugin");
        }

        public String a() {
            return this.f3062b;
        }

        public String b() {
            return new Gson().toJson(this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("service_info")
        private C0153c f3063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("evidence_info")
        private a f3064b;

        @SerializedName("access_token")
        private String c;

        @SerializedName(WsConstants.KEY_CHANNEL_ID)
        private String d;

        @SerializedName("channel_expiry_time")
        private String e;

        b(C0153c r1, a r2, String r3, String r4, String r5) {
            this.f3063a = r1;
            this.f3064b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        static /* synthetic */ C0153c a(b r0) {
            return r0.f3063a;
        }

        static /* synthetic */ a b(b r0) {
            return r0.f3064b;
        }

        static /* synthetic */ String c(b r0) {
            return r0.c;
        }

        static /* synthetic */ String d(b r0) {
            return r0.d;
        }

        static /* synthetic */ String e(b r0) {
            return r0.e;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.b.a.c$c, reason: collision with other inner class name */
    public static class C0153c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("app_id")
        private String f3065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("app_svc_id")
        private String f3066b;

        @SerializedName("app_svc_key_info")
        private d c;

        public C0153c() {
        }

        public static C0153c a(String r2) {
            return (C0153c) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r2, C0153c.class), C0153c.class, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ d a(C0153c r0) {
            return r0.c;
        }

        public d a() {
            return this.c;
        }

        public String b() {
            return new Gson().toJson(this);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("svc_key_type")
        private String f3067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("svc_key_id")
        private String f3068b;

        @SerializedName("svc_key_version")
        private String c;

        @SerializedName("svc_pub_key")
        private String d;

        public String a() {
            return this.f3067a;
        }

        public String b() {
            return this.f3068b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }
    }

    static {
    }

    private c(b r1, String r2, String r3, String r4, int r5) {
        this.f3060b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }

    public static c a(String r7, String r8) {
        JsonObject r9 = JsonParser.parseString(r7).getAsJsonObject();
        int r0 = r9.get("code").getAsInt();
        if (r0 != 0) goto L12;
        JsonObject r10 = r9.getAsJsonObject("data");
        String r3 = r10.get("payload").getAsString();
        b r2 = (b) ZeusTransformUtils.preCheckCast(new Gson().fromJson(new String(Base64.decode(r3, 0), StandardCharsets.UTF_8), b.class), b.class, "com.obric.memorydata.plugin");
        if (b.a(r2) != null) goto L7;
    L8:
        com.bytedance.privacy.e.c.c(f3059a, "CreateChannelResponse: serviceInfo or appSvcKeyInfo is null");
    L10:
        return new c(r2, r3, r8, r10.get("signature").getAsString(), 2);
    L7:
        if (C0153c.a(b.a(r2)) != null) goto L10;
    L12:
        throw new Exception("unexpected server code=" + r0);
    }

    public static c a(String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19) {
        a r0 = null;
        if (r11 != null) goto L5;
    L7:
        C0153c r3 = null;
    L8:
        if (r12 == null) goto L13;
        if (r12.isEmpty() == true) goto L13;
        r0 = a.a(r12);
    L13:
        return new c(new b(r3, r0, r13, r14, r15), r16, r17, r18, r19);
    L5:
        if (r11.isEmpty() == true) goto L7;
        r3 = C0153c.a(r11);
        goto L8
    }

    public C0153c a() {
        b r0 = this.f3060b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return b.a(r0);
    }

    public a b() {
        b r0 = this.f3060b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return b.b(r0);
    }

    public String c() {
        b r0 = this.f3060b;
        if (r0 != null) goto L7;
        return "";
    L7:
        return b.c(r0);
    }

    public String d() {
        b r0 = this.f3060b;
        if (r0 != null) goto L7;
        return "";
    L7:
        return b.d(r0);
    }

    public String e() {
        b r0 = this.f3060b;
        if (r0 != null) goto L7;
        return "";
    L7:
        return b.e(r0);
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public String h() {
        return this.e;
    }

    public int i() {
        return this.f;
    }
}
