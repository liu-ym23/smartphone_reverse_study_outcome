package com.obric.aikernel.middleware.impl.settings;

import com.google.gson.k;
import kotlin.jvm.internal.Intrinsics;
import s7.h;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("enable")
    private final boolean f4604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("whitelist")
    private final k f4605b;

    public e() {
        this.f4604a = true;
        Object r10 = new com.google.gson.d().k("{\n        \"ofa.obriccloud.com\": null,\n        \"fa.obriccloud.com\": null,\n        \"os.oceancloudapi.com\": null\n    }", k.class);
        Intrinsics.checkNotNullExpressionValue(r10, "Gson().fromJson<JsonObje…, JsonObject::class.java)");
        this.f4605b = (k) r10;
    }

    @Override // s7.h
    public k a() {
        return this.f4605b;
    }

    @Override // s7.h
    public boolean b() {
        return this.f4604a;
    }

    public e c() {
        return new e();
    }
}
