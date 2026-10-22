package com.bytedance.ies.bullet.prefetchv2;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5850c;
    public final String d;
    public final boolean e;

    public g(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        this.f5848a = "";
        this.f5849b = "";
        this.d = "";
        this.f5848a = r5.optString("type");
        this.f5849b = r5.opt("value");
        this.f5850c = r5.optBoolean("enableAppIdIsolation", false);
        this.e = false;
    }

    public g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "rawValue");
        this.f5848a = "";
        this.f5849b = "";
        this.d = r5;
        this.e = true;
    }
}
