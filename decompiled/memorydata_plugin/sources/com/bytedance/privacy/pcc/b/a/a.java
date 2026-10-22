package com.bytedance.privacy.pcc.b.a;

import android.util.Base64;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3051a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3052b;
    private final int c;

    static {
    }

    private a(String r1, int r2) {
        this.f3052b = r1;
        this.c = r2;
    }

    public static a a(String r4) {
        JsonObject r5 = JsonParser.parseString(r4).getAsJsonObject();
        int r0 = r5.get("code").getAsInt();
        if (r0 != 0) goto L10;
        JsonObject r6 = JsonParser.parseString(new String(Base64.decode(r5.getAsJsonObject("data").get("payload").getAsString(), 8), StandardCharsets.UTF_8)).getAsJsonObject();
        String r1 = r6.get("nonce").getAsString();
        int r2 = 1;
        if (r6.has("type") == false) goto L7;
        r2 = r6.get("type").getAsInt();
    L7:
        com.bytedance.privacy.e.c.b(f3051a, "ChallengeResponse parsed");
        return new a(r1, r2);
    L10:
        throw new Exception("unexpected server code=" + r0);
    }

    public String a() {
        return this.f3052b;
    }

    public int getType() {
        return this.c;
    }
}
