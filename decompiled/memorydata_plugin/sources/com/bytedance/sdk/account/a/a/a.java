package com.bytedance.sdk.account.a.a;

import com.bytedance.sdk.account.a.a.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T extends b> extends com.bytedance.sdk.account.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3094b;

    public a() {
    }

    public JSONObject a(String r1) {
        return null;
    }

    public abstract void a(T r1);

    public boolean a() {
        return this.f3094b;
    }

    public final void f(T r2) {
        if (a() == true) goto L6;
        a(r2);
        return;
    }
}
