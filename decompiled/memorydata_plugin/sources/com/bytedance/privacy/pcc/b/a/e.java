package com.bytedance.privacy.pcc.b.a;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3075a;

    private e(String r1) {
        this.f3075a = r1;
    }

    public static e a(String r3) {
        JsonObject r4 = JsonParser.parseString(r3).getAsJsonObject();
        int r0 = r4.get("code").getAsInt();
        if (r0 != 0) goto L11;
        if (r4.has("log_id") == false) goto L7;
        String r5 = r4.get("log_id").getAsString();
    L9:
        return new e(r5);
    L7:
        r5 = "";
        goto L9
    L11:
        throw new Exception("unexpected server code=" + r0);
    }

    public String a() {
        return this.f3075a;
    }
}
