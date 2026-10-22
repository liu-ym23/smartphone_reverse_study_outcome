package com.bytedance.ies.bullet.prefetchv2;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f5845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5847c;
    public String d;

    public f(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "json");
        this.f5845a = r10;
        this.f5846b = "unknown";
        this.f5847c = new ArrayList();
        JSONArray r11 = r10.optJSONArray("apis");
        if (r11 == null) goto L7;
        this.f5847c = new ArrayList();
        int r5 = r11.length();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L7;
        JSONObject r13 = r11.getJSONObject(r12);
        this.f5847c.add(new i(r13));
        r12 = r12 + 1;
    L7:
        this.d = "default_bid";
    }
}
