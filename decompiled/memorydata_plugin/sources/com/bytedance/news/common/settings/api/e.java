package com.bytedance.news.common.settings.api;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f2923b;
    private String c;
    private boolean d;

    public e(JSONObject r3, JSONObject r4) {
        this(r3, r4, UUID.randomUUID().toString(), true);
    }

    public e(JSONObject r2, JSONObject r3, String r4, boolean r5) {
        this.d = true;
        this.f2922a = r2;
        this.f2923b = r3;
        this.c = r4;
        this.d = r5;
    }

    public JSONObject a() {
        return this.f2922a;
    }

    public JSONObject b() {
        return this.f2923b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
