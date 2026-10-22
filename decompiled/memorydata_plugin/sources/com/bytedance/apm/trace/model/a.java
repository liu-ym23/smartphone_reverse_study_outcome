package com.bytedance.apm.trace.model;

import com.bytedance.apm.trace.api.c;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<String> f1474a;

    public c a(String r8, long r9) {
        return new b(r8, "tracer_window_span", this, r9);
    }

    public abstract void a(long r1, JSONObject r3, boolean r4);

    void a(String r2) {
        if (this.f1474a.contains(r2) == false) goto L5;
        return;
    L5:
        this.f1474a.add(r2);
    }
}
