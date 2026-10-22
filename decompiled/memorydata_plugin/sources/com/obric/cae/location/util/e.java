package com.obric.cae.location.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonArray f7313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7314b;

    public e() {
        this.f7313a = new JsonArray();
        this.f7314b = "and";
    }

    public JsonObject a() {
        JsonObject r0 = new JsonObject();
        r0.add("conds", this.f7313a);
        r0.addProperty("op", this.f7314b);
        JsonObject r3 = new JsonObject();
        r3.add("filter", r0);
        return r3;
    }

    public e a(String r2) {
        if (r2 != null) goto L4;
    L6:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L6;
        this.f7314b = r2;
        goto L6
    }

    public e a(String r3, String r4) {
        if (r3 == null) goto L6;
        if (r4 == null) goto L6;
        JsonArray r0 = new JsonArray();
        r0.add(r4);
        JsonObject r5 = new JsonObject();
        r5.add("conds", r0);
        r5.addProperty("field", r3);
        r5.addProperty("op", "terms");
        this.f7313a.add(r5);
    L6:
        return this;
    }

    public String b() {
        return new Gson().toJson(a());
    }
}
