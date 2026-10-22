package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.ies.bullet.service.base.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rb.b f5335a;

    public b(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProviderFactory");
        this.f5335a = r5;
    }

    public abstract void a(JSONObject r5, sc.a r10);

    public boolean b() {
        return this instanceof com.bytedance.ies.bullet.kit.web.jsbridge.a;
    }

    public IBridgeMethod$Access f() {
        return IBridgeMethod$Access.f5959a;
    }

    public abstract String g();

    @Override // com.bytedance.ies.bullet.service.base.m
    public void release() {
    }
}
